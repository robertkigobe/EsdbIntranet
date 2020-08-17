package technicalResources_businessBanking;

import java.io.IOException;
import java.sql.Connection;
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

/**
 * Servlet implementation class StaffLoanDelegateLoanUpdate
 */
@WebServlet("/BusinessBankingLoanDelegateLoanUpdate")
public class BusinessBankingLoanDelegateLoanUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String loanRef = request.getParameter("loanRef");
		String recipientRole = request.getParameter("recipientRole");
		request.getParameter("delegateComment");
		String recipientEmail = request.getParameter("recipientEmail");
		String mailLink = null;

		
		if (recipientRole != null && recipientRole.equals("Credit")) {

			mailLink = "http://live-intranet:8090/EsdbIntranet/BusinessBankingLoanCreditRequest";

		} else if (recipientRole != null && recipientRole.equals("Finance")) {

			mailLink = "http://live-intranet:8090/EsdbIntranet/BusinessBankingLoanFinanceRequest";

		} else if (recipientRole != null && recipientRole.equals("Risk")) {

			mailLink = "http://live-intranet:8090/EsdbIntranet/BusinessBankingLoanRiskRequest";
		} else if (recipientRole != null && recipientRole.equals("Legal")) {

			mailLink = "http://live-intranet:8090/EsdbIntranet/BusinessBankingLoanLegalRequest";
		} else if (recipientRole != null && recipientRole.equals("E_M_Business_Banking")) {

			mailLink = "http://live-intranet:8090/EsdbIntranet/BusinessBankingLoanEmBusinessBankingRequest";
		}
		
		

		// Recipient's email ID needs to be mentioned.
		String to = recipientEmail;

		// Sender's email ID needs to be mentioned
		String from = "BusinessBankingLoanApplication@swazibank.co.sz";

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
			message.setSubject("Delegated Business Loan for loan:  " + loanRef + " Requires your Attention");
			// Now set the actual message
			message.setText("Dear " + recipientRole

					+ "\n" + "\n" + "A  Business Loan with Reference: " + loanRef
					+ "' requires your immediate attention. " + "\n\nPlease Click on the link " + mailLink
					+ " to process the loan"

					+ "\n\nYou can view the Loan Documents here file://172.16.1.59//IntranetWarehouse//BusinessBankingLoansDocuments/ "

					+ "\n\n" + "This mail is Auto generated. Please Contact the Applicant on "
					// + emailAddress
					+ " for additional Information." + "\n" + "\n warm regards" + "\n IT Department");
			// Send message
			Transport.send(message);
			response.sendRedirect(request.getContextPath() + "/BusinessBankingLoanStatus");
		} catch (Exception e) {
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_bussinessBanking/businessBankingLoanErrorPage.jsp");
			view.forward(request, response);
		}

	}
}
