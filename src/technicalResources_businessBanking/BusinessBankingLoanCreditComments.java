package technicalResources_businessBanking;

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
 * Servlet implementation class BusinessBankingLoanCreditComments
 */
@WebServlet("/BusinessBankingLoanCreditComments")
public class BusinessBankingLoanCreditComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Connection con;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		new SimpleDateFormat("yyyy-MM-dd");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		String creditemail = request.getParameter("creditemail");
		// /////////////date insert///////////////////
		Date dateOpenedN = new Date();
		String dateCreated = sdf.format(dateOpenedN);
		// /////////////setup///////////////////

		String last_modified_date = dateCreated;
		String loanRef = request.getParameter("loanRef");
		String credit_comments = request.getParameter("credit_comments");

		con = connectionHelper.connect();
		if (con != null) {
			String insertIssueSql = "UPDATE [dbo].[corporate_loans] SET credit_comments = '" + credit_comments + "', "
					+ "[last_modified_date]  = '" + last_modified_date + "'" + " Where [loanRef] = '" + loanRef + "'";

			java.sql.Statement insertReportStatement = null;

			try {

				insertReportStatement = con.createStatement();
				insertReportStatement.executeUpdate(insertIssueSql);

				insertReportStatement.close();
				con.close();

				response.sendRedirect(request.getContextPath() + "/BusinessBankingLoanStatus");

				// Recipient's email ID needs to be mentioned.
				String to = creditemail;

				// Sender's email ID needs to be mentioned
				String from = "creditdepartmenttestEmail@swazibank.co.sz";

				String host = "172.16.1.17";

				// Get system properties
				Properties properties = System.getProperties();

				// Setup mail server
				properties.setProperty("mail.smtp.host", host);

				// Get the default Session object.
				Session session = Session.getDefaultInstance(properties);

				// Set response content type
				response.setContentType("text/html");

				try {
					// Create a default MimeMessage object.
					MimeMessage message = new MimeMessage(session);

					// Set From: header field of the header.
					message.setFrom(new InternetAddress(from));

					// Set To: header field of the header.
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

					// Set Subject: header field
					message.setSubject("Business Loan " + loanRef + " edited by Credit Department");

					// Now set the actual message
					message.setText("Greetings Business Banking "

							+ "Your Loan Staff Application  with Reference: " + loanRef + " has been Edited. "
							+ "Please Click on the link http://live-intranet:8090/EsdbIntranet/BusinessBankingLoanOfficerRequest for your comment."
							+ "\n\nYou can view the Loan Documents here file://172.16.1.59//IntranetWarehouse//BusinessBankingLoansDocuments/ "
							+ "\n\n" + "This mail is Auto generated. Please Contact the Applicant on " + creditemail
							+ " for additional Information." + "\n" + "\n warm regards" + "\n IT Department");
					// Send message
					Transport.send(message);

				} catch (MessagingException mex) {
					mex.printStackTrace();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
