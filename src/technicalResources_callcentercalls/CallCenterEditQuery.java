package technicalResources_callcentercalls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class CallCenterEditQuery
 */
@WebServlet("/CallCenterEditQuery")
public class CallCenterEditQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement selectStatement = null;
	ResultSet results = null;
	Connection con;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nameOfStaff = request.getParameter("nameOfStaff");
		String emailReplyTo = request.getParameter("emailReplyTo");
		String resolution = request.getParameter("resolution");
		String status = request.getParameter("status");
		String departmentResponsible = request
				.getParameter("departmentResponsible");
		String customerQuery = request.getParameter("customerQuery");
		String nameOfCustomer = request.getParameter("nameOfCustomer");
		String emailReplyCopyTo = request.getParameter("emailReplyCopyTo");
		String lastModifiedBy = System.getProperty("user.name");
		// /////////////date insert///////////////////
		Date dateModifiedN = new Date();
		String dateModified = sdf.format(dateModifiedN);
		String dateClosed = null;
		if (status.matches("Closed")) {
			dateClosed = sdf.format(dateModifiedN);
		}

		// /////////////date insert///////////////////

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String insertIssueSql = "UPDATE [dbo].[CallCenterCalls] SET "
					+ "[nameOfStaff]='"	+ nameOfStaff + "', "
					+ "[emailReplyTo] = '"+ emailReplyTo+ "',"
					+ "[emailReplyCopyTo]='"+ emailReplyCopyTo+ "',"
					+ "[resolution] = '"+ resolution+ "' ,"
					+ "[status] = '"+ status+ "',"
					+ "[dateClosed]='"+ dateClosed+ "',"
					+ "[dateModified] = '"+ dateModified+ "' ,"
					+ "[lastModifiedBy] = '"+ lastModifiedBy+ "' "
					+ "WHERE [customerQuery] = '"+ customerQuery+ "' and [departmentResponsible] = '"+ departmentResponsible+ "' and [nameOfCustomer] = '"+ nameOfCustomer + "'";

			java.sql.Statement insertReportStatement = null;

			try {

				insertReportStatement = con.createStatement();
				insertReportStatement.executeUpdate(insertIssueSql);
				System.out.println(dateClosed);

				insertReportStatement.close();
				con.close();

				response.sendRedirect(request.getContextPath()
						+ "/CallCenterHome");
				
				
				// Recipient's email ID needs to be mentioned.
				String to = emailReplyTo;
				String copyTo = emailReplyTo;

				// Sender's email ID needs to be mentioned
				String from = "callcenter@swazibank.co.sz";

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
					message.addRecipient(Message.RecipientType.CC, new InternetAddress(
							copyTo));

					// Set Subject: header field
					message.setSubject("A response from : "+nameOfStaff+ " has been submitted for your review");

					// Now set the actual message
					message.setText("Good day call center, \n"
							+ "\n"
							+ "The Customer "+nameOfCustomer+" has a query as below:\n \n"+customerQuery+" \n \n"
									
							+ "Please receive the response from "+nameOfStaff+" for a querry submitted earlier \n \n"
									+ "\n"
									+ "\n kind regards \n"
									+ "\n  "+departmentResponsible+"");

					// Send message
					Transport.send(message);

				} catch (MessagingException mex) {
					mex.printStackTrace();
				}

			} catch (SQLException mex) {
				mex.printStackTrace();
			}
		}

	}

}
