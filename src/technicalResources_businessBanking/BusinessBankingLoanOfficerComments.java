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
@WebServlet("/BusinessBankingLoanOfficerComments")
public class BusinessBankingLoanOfficerComments extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static Connection con;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		// /////////////date insert///////////////////
		Date dateOpenedN = new Date();
		String dateCreated = sdf.format(dateOpenedN);
		// /////////////setup///////////////////

		String last_modified_date = dateCreated;
		String loanRef = request.getParameter("loanRef");

		String account_activity_analysis = request.getParameter("account_activity_analysis");
		String applicant_name = request.getParameter("applicant_name");
		String background = request.getParameter("background");
		String benefits_to_bank = request.getParameter("benefits_to_bank");
		String charges = request.getParameter("charges");
		String collateral_security = request.getParameter("collateral_security");
		String compiled_by = request.getParameter("compiled_by");
		String conclusion = request.getParameter("conclusion");
		String conclusion_and_recommendation = request.getParameter("conclusion_and_recommendation");
		String cost_to_bank = request.getParameter("cost_to_bank");
		String credit_comments = request.getParameter("credit_comments");
		String creditemail = request.getParameter("creditemail");
		String curent_position = request.getParameter("curent_position");
		String decision = request.getParameter("decision");
		String decision_by = request.getParameter("decision_by");
		String endDate = request.getParameter("endDate");
		String exposure_to_bank = request.getParameter("exposure_to_bank");
		String finance_comments = request.getParameter("finance_comments");
		String finance_risk_analysis = request.getParameter("finance_risk_analysis");
		String facility_type = request.getParameter("facility_type");
		String financeemail = request.getParameter("financeemail");
		String fromRecepient = request.getParameter("fromRecepient");
		String industry = request.getParameter("industry");
		String intertestRate = request.getParameter("intertestRate");
		String legal_implications = request.getParameter("legal_implications");
		String last_modified_by = request.getParameter("last_modified_by");
		String legal_services = request.getParameter("legal_services");
		String legalemail = request.getParameter("legalemail");
		String loan_amount = request.getParameter("loan_amount");
		String loanDate = dateCreated;
		int loanPeriod = 0;
		String location = request.getParameter("location");
		String maximum_lending_limit = request.getParameter("maximum_lending_limit");
		String motivation = request.getParameter("motivation");
		String nature_of_business = request.getParameter("nature_of_business");
		String non_financial_risks_analysis = request.getParameter("non_financial_risks_analysis");
		String purpose = request.getParameter("purpose");
		String purpose2 = request.getParameter("purpose2");
		String ratio_analysis = request.getParameter("ratio_analysis");
		String recommendations = request.getParameter("recommendations");
		String risk_comments = request.getParameter("risk_comments");
		String riskemail = request.getParameter("riskemail");
		String startDate = request.getParameter("startDate");
		String subjectR = request.getParameter("subjectR");
		String submitted_by = request.getParameter("submitted_by");
		String toRecepient = request.getParameter("toRecepient");

		con = connectionHelper.connect();
		if (con != null) {
			String insertIssueSql = "UPDATE [dbo].[corporate_loans]  SET [account_activity_analysis] = '"
					+ account_activity_analysis + "'," + "[applicant_name] = '" + applicant_name + "',[background] = '"
					+ background + "',[benefits_to_bank] = '" + benefits_to_bank + "'," + "[charges] = '" + charges
					+ "',[collateral_security] = '" + collateral_security + "' ,[compiled_by] = '" + compiled_by + "',"
					+ "[conclusion] = '" + conclusion + "',[conclusion_and_recommendation] = '"
					+ conclusion_and_recommendation + "',[cost_to_bank] ='" + cost_to_bank + "',"
					+ "[credit_comments] = '" + credit_comments + "',[creditemail] = '" + creditemail + "'"
					+ "      ,[curent_position] = '" + curent_position + "',[decision] = '" + decision
					+ "',[decision_by] = '" + decision_by + "'," + "[endDate] = '" + endDate
					+ "',[exposure_to_bank] = '" + exposure_to_bank + "' ,[finance_comments] = '" + finance_comments
					+ "'," + "[financeemail] = '" + financeemail + "',[fromRecepient] = '" + fromRecepient
					+ "',[industry] = '" + industry + "',[intertestRate] ='" + intertestRate + "',"
					+ "[legal_implications] = '" + legal_implications + "'," + "[last_modified_by] = '"
					+ last_modified_by + "',[last_modified_date] = '" + last_modified_date + "',"
					+ "[legal_services] = '" + legal_services + "' ,[legalemail] = '" + legalemail + "',"
					+ "[loan_amount] = '" + loan_amount + "' ,[loanDate] = '" + loanDate + "',[loanPeriod] = '"
					+ loanPeriod + "',[location] = '" + location + "' ,[maximum_lending_limit] = '"
					+ maximum_lending_limit + "'," + "[motivation] = '" + motivation + "' ,[nature_of_business] = '"
					+ nature_of_business + "',[non_financial_risks_analysis] = '" + non_financial_risks_analysis
					+ "',[purpose] = '" + purpose + "',[purpose2] = '" + purpose2 + "'," + "[ratio_analysis] = '"
					+ ratio_analysis + "',[recommendations] = '" + recommendations + "',[risk_comments] = '"
					+ risk_comments + "'," + "[riskemail] = '" + riskemail + "',[startDate] = '" + startDate
					+ "',[subjectR] = '" + subjectR + "',[submitted_by] = '" + submitted_by + "' ,"
					+ "[toRecepient] = '" + toRecepient + "', Where [loanRef] = '" + loanRef + "'";

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

		response.sendRedirect(request.getContextPath() + "/BusinessBankingLoanStatus");
	}

}
