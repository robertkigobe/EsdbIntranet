package home;

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
 * Servlet implementation class IntranetFeedBack
 */
@WebServlet("/IntranetFeedBack")
public class IntranetFeedBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	Statement selectStatement = null;
	ResultSet results = null;
	
	String userName = System.getProperty("user.name");
	private int hitCount;

	public void init() {
		hitCount = 0;

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		hitCount++;
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/home/intranetFeedBack.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		hitCount++;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dateNow = dateFormat.format(date);
		String aboutFeedBackSubject = request.getParameter("aboutFeedBackSubject");
		String aboutFeedBackDetail = request.getParameter("aboutFeedBackDetail");

	
		
		
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		String insertIssueSql = "INSERT INTO [dbo].[IntranetFeedback] ([dateNow],[userName] ,[aboutFeedBackSubject] ,[aboutFeedBackDetail]) VALUES (?,?,?,?);";

		java.sql.PreparedStatement insertReportStatement = null;

		try {
			insertReportStatement = con.prepareStatement(insertIssueSql,
					new String[] { "id" });
			
			insertReportStatement.setString(1, dateNow);
			insertReportStatement.setString(2, userName);
			insertReportStatement.setString(3, aboutFeedBackSubject);
			insertReportStatement.setString(4, aboutFeedBackDetail);
			
			insertReportStatement.executeUpdate();
			insertReportStatement.close();
			con.close();
			
			// Sender's email ID needs to be mentioned
						String from = "robertk@swazibank.co.sz";

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
							
							message.addRecipient(Message.RecipientType.TO,
									new InternetAddress("robertk@swazibank.co.sz"));

							// Set Subject: header field
							message.setSubject("Intranet feedback: "
									+ aboutFeedBackSubject + " Requires your Attention");

							// Now set the actual message
							message.setText("Dear " + "Intranet" + "\n" + aboutFeedBackDetail+ "\n\nThis mail is Auto generated. " + "\n"
									+ "kind regards" + "\n Anonymous");

							// Send message
							Transport.send(message);

						} catch (MessagingException mex) {
							mex.printStackTrace();
						}
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/home/intranetFeedBackResponse.jsp");
			view.forward(request, response);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot connect to activity database here");

		} finally {
			if (con != null) {
				try {
					ConnectionHelper.disconnect(con);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void destroy() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dateNow = dateFormat.format(date);
		String userName = System.getProperty("user.name");
		String servletName = "IntranetFeedBack";
		

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		String insertIssueSql = "INSERT INTO [dbo].[ServletCounter] ([userName] ,[servletName] ,[dateNow] ,[hitCount])VALUES(?,?,?,?);";

		java.sql.PreparedStatement insertReportStatement = null;

		try {
			insertReportStatement = con.prepareStatement(insertIssueSql,
					new String[] { "id" });
			insertReportStatement.setString(1, userName);
			insertReportStatement.setString(2, servletName);
			insertReportStatement.setString(3, dateNow);
			insertReportStatement.setInt(4, hitCount);
			insertReportStatement.executeUpdate();
			insertReportStatement.close();
			con.close();
		} catch (SQLException e) {

			System.out.println("Cannot connect to activity database here");

		} finally {
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
