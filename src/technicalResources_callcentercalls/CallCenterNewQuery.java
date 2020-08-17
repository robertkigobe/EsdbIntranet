package technicalResources_callcentercalls;

import java.io.IOException;

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

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import util.ConnectionHelper;

/**
 * Servlet implementation class CallCenterNewQuery
 */
@WebServlet("/CallCenterNewQuery")
public class CallCenterNewQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/technicalresources_CallCenter/callCenterNewQuery.jsp");
		rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String lastModifiedBy = System.getProperty("user.name");
		// /////////////date insert///////////////////
		Date dateOpenedN = new Date();
		String dateOpened = sdf.format(dateOpenedN);
		String dateClosed = null;
		String dateModified = null;
		// /////////////date insert///////////////////

		String nameOfAgent = request.getParameter("nameOfAgent");
		String departmentRensponsible = request.getParameter("departmentRensponsible");
		String nameOfCustomer = request.getParameter("nameOfCustomer");
		String status = request.getParameter("status");
		String emailSentTo = request.getParameter("emailSentTo");
		String emailCopyTo = request.getParameter("emailCopyTo");
		String resolution = request.getParameter("resolution");
		String customerQuery = request.getParameter("customerQuery");
		System.out.println(status);
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		java.sql.PreparedStatement stmt = null;
		if (con != null) {
			

			String insertIssueSql = "INSERT INTO [dbo].[CallCenterCalls] "
					+ "([dateOpened]"
					+ ",[nameOfAgent]"
					+ ",[nameOfCustomer]"
					+ ",[customerQuery]"
					+ ",[departmentResponsible]"
					+ ",[emailSentTo]"
					+ ",[emailCopyTo]"
					+ ",[resolution]"
					+ ",[dateClosed]"
					+ ",[status]"
					+ ",[dateModified]"
					+ ",[lastModifiedBy]) VALUES (?, ?, ?, ?,?, ?, ?, ?, ?, ?,  ?, ?)";
			try {
				stmt = con.prepareStatement(insertIssueSql,
						new String[] { "id" });

				int x = 1;
				stmt.setString(x++, dateOpened);
				stmt.setString(x++, nameOfAgent);
				stmt.setString(x++, nameOfCustomer);
				stmt.setString(x++, customerQuery);
				stmt.setString(x++, departmentRensponsible);
				stmt.setString(x++, emailSentTo);
				stmt.setString(x++, emailCopyTo);
				stmt.setString(x++, resolution);
				stmt.setString(x++, dateClosed);
				stmt.setString(x++, status);
				stmt.setString(x++, dateModified);
				stmt.setString(x++, lastModifiedBy);
				stmt.executeUpdate();
				
				stmt.close();
				response.sendRedirect(request.getContextPath()+ "/CallCenterHome");
				
				// Recipient's email ID needs to be mentioned.
				String to = emailSentTo;
				String ccTo = emailCopyTo;

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
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					
					// Set CC: header field of the header.
					message.addRecipient(Message.RecipientType.CC, new InternetAddress(ccTo));

					// Set Subject: header field
					message.setSubject("Querry from Customer: "+nameOfCustomer+ " Requires your Attention");

					// Now set the actual message
					message.setText("Good day "+departmentRensponsible+", \n"
							+ "\n"
							+ "The Customer "+nameOfCustomer+" has a query as below:\n \n"+customerQuery+" \n \n"
									
							+ "Please Contact "+nameOfAgent+" for additional Information \n \nTo update Query, please click on  http://172.16.1.59:8080/SwaziBankIntranetLive/CallCenterUpdateQuery"
									+ "\n"
									+ "\n kindly assist \n"
									+ "\n Call center - Marketing");

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
