package technicalResources.staffLoan;

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


@WebServlet("/StaffLoanUpdateSupervisorLoanOpeningComment")
public class StaffLoanUpdateSupervisorLoanOpeningComment extends HttpServlet {
	public static Connection con;
	public static String filename;
	private static final long serialVersionUID = 1L;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		String employeeLoanRef = request.getParameter("employeeLoanRef");
		String loanStatus = request.getParameter("loanStatus");
		String loanOpeningSupervisorComment = request.getParameter("loanOpeningSupervisorComment");		
		String firstname = 	request.getParameter("firstname");	
		String surname = 	request.getParameter("surname");	
		
		String disbursedAmount = 	request.getParameter("disbursedAmount");
		
		System.out.println(loanStatus);
		
		// /////////////date insert///////////////////
		Date loanOpeningSupervisorCommentDateN = new Date();
		String loanOpeningSupervisorCommentDate = sdf.format(loanOpeningSupervisorCommentDateN);
		String lastModifiedDate = loanOpeningSupervisorCommentDate;
		// /////////////date insert///////////////////
		String lastModifiedBy = userName;
		
		String  emailAddress = request.getParameter("emailAddress");
		

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {


			String insertIssueSql = "UPDATE [dbo].[staffLoan] "
					+ "SET "
					+ "[loanStatus] = '"+loanStatus+"',"
					+ "[loanOpeningSupervisorComment] = '"+loanOpeningSupervisorComment+"', "
					+ "[loanOpeningSupervisorCommentDate]  = '"+loanOpeningSupervisorCommentDate+"',"
					+ "[lastModifiedDate]  = '"+lastModifiedDate+"',"
					+ "[disbursedAmount]  = '"+disbursedAmount+"',"
					+ "[disbursementDate]  = '"+lastModifiedDate+"',"
					+ "[lastModifiedBy]  = '"+lastModifiedBy+"'"
					+ "Where [employeeLoanRef] = '" + employeeLoanRef + "'";

		
			java.sql.Statement insertReportStatement = null;

			try {
				
				
				insertReportStatement = con.createStatement();
				insertReportStatement.executeUpdate(insertIssueSql);
				
				insertReportStatement.close();
				con.close();

				response.sendRedirect(request.getContextPath()
						+ "/StaffLoanStatus");
				
				// Recipient's email ID needs to be mentioned.
				String to = emailAddress;

				// Sender's email ID needs to be mentioned
				String from = "staffLoanApplication@swazibank.co.sz";

				// Assuming you are sending email from localhost
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
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(
							to));
					
					message.addRecipient(Message.RecipientType.BCC,	new InternetAddress("hloniphileN@swazibank.co.sz"));

					// Set Subject: header field
					message.setSubject("New Staff Loan Disbursment Requires your Attention");

					// Now set the actual message
					message.setText("Dear " + emailAddress + "\n"
							+ "\n"
							+ "A  Staff Loan belonging to "+firstname + " "+surname+ " with Reference: '"+employeeLoanRef+"' Has been disbursed with the amount "+disbursedAmount+" "
									+ "\n"
									+ "Please contact Hr for a statement of your process."
							+ "\n\n"
							+ "This mail is Auto generated. Thank you for using the system."
									+ "\n"
									+ "\n warm regards"
									+ "\n IT Department");

					// Send message
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
