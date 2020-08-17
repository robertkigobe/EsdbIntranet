package technicalResources.staffLoan;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import util.ConnectionHelper;

/**
 * Servlet implementation class StaffLoanUploadSecurities
 */
@WebServlet("/StaffLoanUploadSecuritiesLinks")
public class StaffLoanUploadSecuritiesLinks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "//172.16.1.59/IntranetWarehouse/StaffLoan";

	private String name = null;
	public static Connection con;
	public static String filename;
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String employeeLoanRef = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		Statement selectStatement = null;
		ResultSet results = null;

		String securitiesDocumentLocation = null;
		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String securitiesSupervisorEmail = null;
		String emailAddress = null;

		if (con != null) {

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[staffLoanSetUp]";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					securitiesSupervisorEmail = results.getString("securitiesSupervisorEmail");

				}
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		


		// /////////////date insert///////////////////
		Date securitiesDocumentUploadDateN = new Date();
		String securitiesDocumentUploadDate = sdf.format(securitiesDocumentUploadDateN);
		String lastModifiedDate = securitiesDocumentUploadDate;

		if (ServletFileUpload.isMultipartContent(request)) {

			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));

					} else if (item.isFormField()) { // Check regular field.
						employeeLoanRef = (String) item.getFieldName();
						if (employeeLoanRef.equalsIgnoreCase("employeeLoanRef")) {
							employeeLoanRef = (String) item.getString();
						}
					}
				}

				securitiesDocumentLocation = UPLOAD_DIRECTORY + File.separator + name;

				System.out.println(UPLOAD_DIRECTORY + File.separator + name);

				// ConnectionHelper connectionHelper = new ConnectionHelper();
				con = connectionHelper.connect();
				

				if (con != null) {

					String sql = "SELECT  emailAddress  FROM [dbo].[StaffLoan] where  [employeeLoanRef] = '"+employeeLoanRef+"'";
					try {
						selectStatement = con.createStatement();
						results = selectStatement.executeQuery(sql);

						while (results.next()) {

							emailAddress = results.getString("emailAddress");

							
						}
						
								
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("Cannot connect to activity database here");
					}
				}
				
				
				if (con != null) {

					String insertIssueSql = "UPDATE [dbo].[staffLoan] "
							+ "SET [loanStatus] = 'Pending Securities Verification'," + "[lastModifiedDate]  = '"
							+ lastModifiedDate + "'," + "[lastModifiedBy]  = '" + userName + "',"
							+ "[securitiesDocumentLocation]  = '" + securitiesDocumentLocation + "',"
							+ "[securitiesDocumentUploadDate]  = '" + lastModifiedDate + "',"
							+ "[securitiesPrinted]  = 'true'  Where [employeeLoanRef] = '" + employeeLoanRef + "'";

					java.sql.Statement insertReportStatement = null;

					try {

						insertReportStatement = con.createStatement();
						insertReportStatement.executeUpdate(insertIssueSql);

						insertReportStatement.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Updating database failed");
					}

					// Recipient's email ID needs to be mentioned.
					String to = securitiesSupervisorEmail;

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
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
						message.addRecipient(Message.RecipientType.CC,	new InternetAddress(emailAddress));
						message.addRecipient(Message.RecipientType.BCC,	new InternetAddress("hloniphileN@swazibank.co.sz"));
						// Set Subject: header field
						message.setSubject(
								"New Staff Loan securities for loan:  " + employeeLoanRef + " Require your Attention");
						// Now set the actual message
						message.setText("Dear Securities"

								+ "\n" + "\n" + "A  Staff Loan belonging to " + firstname + " " + surname
								+ " with Reference: '" + employeeLoanRef + "' requires your immediate attention. "
								+ "\n"
								+ "Please Click on the link http://live-intranet:8090/EsdbIntranet/StaffLoanLegalAdvisorCommentRequest"
								+ "\n\n" + "This mail is Auto generated. Please Contact the Applicant on "
								// + emailAddress
								+ " for additional Information." + "\n" + "\n warm regards" + "\n IT Department");
						// Send message
						Transport.send(message);
					} catch (Exception e) {
						// TODO: handle exception
					}
					response.sendRedirect(request.getContextPath() + "/StaffLoanStatus");

				}

				else {
					request.setAttribute("message", "Sorry this Servlet only handles file upload request");
					request.getRequestDispatcher("/result.jsp").forward(request, response);

				}

			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to " + ex);
			}

		}
	}

}
