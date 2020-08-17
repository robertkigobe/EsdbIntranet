package technicalResources.staffLoan;

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
 * Servlet implementation class StaffLoanDelegateLoanUpdate
 */
@WebServlet("/StaffLoanDelegateLoanUpdate")
public class StaffLoanDelegateLoanUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ConnectionHelper connectionHelper = new ConnectionHelper();
		Statement selectStatement = null;
		ResultSet results = null;
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String employeeLoanRef = request.getParameter("employeeLoanRef");
		String employeeEmail = request.getParameter("employeeEmail");
		String recipientRole = request.getParameter("recipientRole");
		String delegateComment = request.getParameter("delegateComment");
		String recipientEmail = request.getParameter("recipientEmail");
		String loanStatus = null;
		String lastModifiedBy = System.getProperty("user.name");
		String mailLink = null;

		// /////////////date insert///////////////////
		Date dateOpenedN = new Date();
		String dateCreated = sdf.format(dateOpenedN);
		// /////////////date insert///////////////////
		String lastModifiedDate = dateCreated;

		if (recipientRole != null && recipientRole.equals("Supervisor")) {

			loanStatus = "Pending-Supervisor Comments";
			mailLink = "http://live-intranet:8090/EsdbIntranet/StaffLoanSupervisorRequest";

		} else if (recipientRole != null && recipientRole.equals("Head of Department")) {

			loanStatus = "Pending Hod Comments";
			mailLink = "http://live-intranet:8090/EsdbIntranet/StaffLoanHodRequest";

		} else if (recipientRole != null && recipientRole.equals("Payroll Master")) {

			loanStatus = "Pending Hr Processing";
			mailLink = "http://live-intranet:8090/EsdbIntranet/StaffLoanPayrollMasterRequest";
		} else if (recipientRole != null && recipientRole.equals("Senior HR")) {

			loanStatus = "Pending Hr Approval";
			mailLink = "http://live-intranet:8090/EsdbIntranet/StaffLoanSeniorHrManagerRequest";
		} else if (recipientRole != null && recipientRole.equals("Employee- Make Securities")) {

			loanStatus = "Pending Securities Preparation";
			mailLink = "http://live-intranet:8090/EsdbIntranet/StaffLoanEmployeeSecuritiesRequest";
		} else if (recipientRole != null && recipientRole.equals("Securities Supervisor")) {

			loanStatus = "Pending Securities Verification";
			mailLink = "http://live-intranet:8090/EsdbIntranet/StaffLoanLegalAdvisorCommentRequest";
		} else {

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanAdminStatus.jsp");
			view.forward(request, response);

		}

		con = connectionHelper.connect();
		if (con != null) {
			
			String insertIssueSql = "UPDATE [dbo].[staffLoan] "
					+ "SET  "
					+ "[loanStatus] = '"+loanStatus+"',"
					+ "[lastModifiedBy]  = '"+lastModifiedBy+"',"
					+ "[lastModifiedDate]  = '"+lastModifiedDate+"',"
					+ "[other11]  = '"+lastModifiedDate+"'"
					+ "Where [employeeLoanRef] = '" + employeeLoanRef + "'";


			java.sql.Statement insertReportStatement = null;

			try {

				insertReportStatement = con.createStatement();
				insertReportStatement.executeUpdate(insertIssueSql);

				insertReportStatement.close();
				con.close();

				// Recipient's email ID needs to be mentioned.
				String to = recipientEmail;

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
					// Set Subject: header field
					message.setSubject("Delegated Staff Loan securities for loan:  " + employeeLoanRef
							+ " Requires your Attention");
					// Now set the actual message
					message.setText("Dear " + recipientRole

							+ "\n" + "\n" + "A  Staff Loan with Reference: " + employeeLoanRef
							+ "' requires your immediate attention. " + "\n\nPlease Click on the link " + mailLink
							+ " to process the loan"

							+ "\n\nYou can view the employee payslip here file://172.16.1.59//IntranetWarehouse//StaffLoanPayslips/ "

							+ "\n\n" + "This mail is Auto generated. Please Contact the Applicant on "
							// + emailAddress
							+ " for additional Information." + "\n" + "\n warm regards" + "\n IT Department");
					// Send message
					Transport.send(message);
				} catch (Exception e) {
					// TODO: handle exception
				}
				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanAdminStatus.jsp");
				view.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Updating database failed");
			}

		} else {

		}

	}
}
