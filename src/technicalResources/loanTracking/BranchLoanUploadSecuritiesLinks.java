package technicalResources.loanTracking;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
@WebServlet("/BranchLoanUploadSecuritiesLinks")
public class BranchLoanUploadSecuritiesLinks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "//172.16.1.59/IntranetWarehouse/BranchLoans";
	private String name = null;
	public static Connection con;
	public static String filename;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String loanReference = null;

		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		String securitiesDocumentLocation = null;
		String securitiesSupervisorEmail = "robertk@swazibank.co.sz";

		// /////////////date insert///////////////////
		Date securitiesDocumentUploadDateN = new Date();
		String securitiesDocumentUploadDate = sdf
				.format(securitiesDocumentUploadDateN);
		String lastModifiedDate = securitiesDocumentUploadDate;

		if (ServletFileUpload.isMultipartContent(request)) {

			// ////////////////////////
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator
								+ name));

					}

					else if (item.isFormField()) { // Check regular field.
						loanReference = (String) item.getFieldName();
						System.out.println(loanReference  + "1");
						if (loanReference.equalsIgnoreCase("loanReference")) {
							loanReference = (String) item.getString();
							System.out.println(loanReference + "2");
						}
					}

				}

				securitiesDocumentLocation = UPLOAD_DIRECTORY + File.separator
						+ name;

			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}

			// /////////////////////

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();
			if (con != null) {

				String sql = "UPDATE [dbo].[branchLoan] "
						+ "SET [loanStatus] = 'Pending Securities Verification',"
						+ "[lastModifiedDate]  = '" + lastModifiedDate + "',"
						+ "[lastModifiedBy]  = '" + userName + "',"
						+ "[securitiesDocumentLocation]  = '"
						+ securitiesDocumentLocation + "',"
						+ "[securitiesDocumentUploadDate]  = '"
						+ lastModifiedDate + "'   Where [loanReference] = '"
						+ loanReference + "'";

				java.sql.Statement insertReportStatement = null;

				try {

					insertReportStatement = con.createStatement();
					insertReportStatement.executeUpdate(sql);

					insertReportStatement.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Updating database failed");
				}

				// Recipient's email ID needs to be mentioned.
				String to = securitiesSupervisorEmail;

				// Sender's email ID needs to be mentioned
				String from = "branchLoanApplication@swazibank.co.sz";

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
							new InternetAddress(to));
					// Set Subject: header field
					message.setSubject("New Branch Loan securities for loan:  "
							+ loanReference + " Require your Attention");
					// Now set the actual message
					message.setText("Dear Securities"

							+ "\n"
							+ "\n"
							+ "A  Branch Loan with Reference: '"
							+ loanReference
							+ "' requires your immediate attention. "
							+ "\n"
							+ "Please Click on the link http://localhost:8080/SwaziBankIntranetLive/BranchLoanSecuritiesSupervisorRequest"
							+ "\n\n"
							+ "This mail is Auto generated. Please Contact the Applicant on "
							// + emailAddress
							+ " for additional Information." + "\n"
							+ "\n warm regards" + "\n IT Department");
					// Send message
					Transport.send(message);
				} catch (Exception e) {
					// TODO: handle exception
				}
				response.sendRedirect(request.getContextPath()
						+ "/BranchLoanTrackingStatus");

			}

		} else {
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
			request.getRequestDispatcher("/result.jsp").forward(request,
					response);

		}
	}

}
