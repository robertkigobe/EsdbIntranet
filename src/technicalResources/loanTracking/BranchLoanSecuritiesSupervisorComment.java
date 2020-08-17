package technicalResources.loanTracking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class LoanTrackingLogin
 */
@WebServlet("/BranchLoanSecuritiesSupervisorComment")
public class BranchLoanSecuritiesSupervisorComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// /////////////date insert///////////////////
		Date dateModifiedN = new Date();
		String dateModified = sdf.format(dateModifiedN);
		// /////////////date insert///////////////////


		
		String loanOpeningSupervisorName = request
				.getParameter("loanOpeningSupervisorName");
		String loanOpeningSupervisorCommentDate = dateModified;
		String loanOpeningSupervisorComment = request.getParameter("loanOpeningSupervisorComment");
		String loanOpeningSupervisorEmail = request.getParameter("loanOpeningSupervisorEmail");
		String businessConsultantName = request.getParameter("businessConsultantName");
		String businessConsultantEmail = request.getParameter("businessConsultantEmail");

		// /////latest updates///////

		String lastModifiedDate = dateModified;
		String loanReference = request.getParameter("loanReference");
		request
				.getParameter("loanOpeningSupervisorEmail");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {
			String sql = "UPDATE [dbo].[branchLoan] "
					+ "SET   [lastModifiedDate] = '"+ lastModifiedDate+ "'"
					+ ",[loanStatus] = 'Pending Loan Disbursement'"
					+ ",[loanOpeningSupervisorCommentDate] = '"+ loanOpeningSupervisorCommentDate+ "'"
					+ ",[loanOpeningSupervisorComment] = '"+ loanOpeningSupervisorComment+ "'  "
					+ ",[loanOpeningSupervisorName] = '"+ loanOpeningSupervisorName+ "'"
					+ ",[loanOpeningSupervisorEmail] = '"+ loanOpeningSupervisorEmail+ "'"
					+ "WHERE [loanReference] = '" + loanReference + "'";

			java.sql.PreparedStatement insertReportStatement = null;
			try {

				insertReportStatement = con.prepareStatement(sql,
						new String[] { "id" });

				insertReportStatement.executeUpdate();
				insertReportStatement.close();

				con.close();

				response.sendRedirect(request.getContextPath()
						+ "/BranchLoanTrackingStatus");
				String to = loanOpeningSupervisorEmail;
				String from = "staffLoanApplication@swazibank.co.sz";
				String host = "mail.swazibank.co.sz";
				Properties properties = System.getProperties();
				properties.setProperty("mail.smtp.host", host);
				Session session = Session.getDefaultInstance(properties);
				response.setContentType("text/html");

				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));
					message.addRecipient(Message.RecipientType.TO,
							new InternetAddress(to));
					message.setSubject("Branch Loan Submitted by: "
							+ businessConsultantName
							+ " Requires your Attention");
					message.setText("Dear "
							+ loanOpeningSupervisorName

							+ "\n\n"
							+ "A new Personal Loan has been Submitted by: "

							+ "  "
							+ businessConsultantName.toUpperCase()
							+ " with reference: "
							+ loanReference
							+ "."
							+ "\nPlease Click on the link http://localhost:8080/SwaziBankIntranetLive/BranchLoanLoanDisbursementSupervisorRequest to comment."
							+ "\n\n"
							+ "This mail is Auto generated. Please Contact the Applicant on "
							+ businessConsultantEmail
							+ " for additional Information." + "\n"
							+ "\n warm regards" + "\n IT Department");
					Transport.send(message);

				} catch (MessagingException mex) {
					mex.printStackTrace();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
				if (con != null) {
					try {
						ConnectionHelper.disconnect(con);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}
}
