package technicalResources_businessBanking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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
 * Servlet implementation class BusinessBankingNewLoan
 */
@WebServlet("/BusinessBankingNewLoan")
public class BusinessBankingNewLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DateFormat inSdf = new SimpleDateFormat("mm/dd/yyyy");
	private static final DateFormat outSdf = new SimpleDateFormat("yyyy-mm-dd");
	public static Connection con;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		
		Random rand = new Random();
		int randV = rand.nextInt(500);
		
		// /////////////date insert///////////////////
		Date dateOpenedN = new Date();
		String dateCreated = sdf.format(dateOpenedN);
		// /////////////setup///////////////////

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
		String last_modified_date = dateCreated;
		String legal_services = request.getParameter("legal_services");
		String legalemail = request.getParameter("legalemail");
		String loan_amount = request.getParameter("loan_amount");
		String loanDate = dateCreated;
		String loanRef = "Test ref: "+randV ;
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
		String status_of_loan = "In Progress";
		String subjectR = request.getParameter("subjectR");
		String submitted_by = request.getParameter("submitted_by");
		String toRecepient = request.getParameter("toRecepient");
		
		Date startDate2 = null;
		String startDate1 = null;
		String endDate1 = null;
	
		
		try {
			Date doFirstInstallment = inSdf.parse(startDate);
			startDate1 = outSdf.format(doFirstInstallment);
			Date doLastInstallment = inSdf.parse(endDate);
			endDate1 = outSdf.format(doLastInstallment);

			

			startDate2 = dateFormat.parse(startDate1);
			//loanPeriod = (int) ChronoUnit.MONTHS.between(LocalDate.parse(startDate1).withDayOfMonth(1),	LocalDate.parse(endDate1).withDayOfMonth(1)) + 1;
			loanPeriod = 0;
		} catch (Exception e1) {}
		
	

		con = connectionHelper.connect();
		if (con != null) {

			String insertIssueSql = "INSERT INTO [dbo].[corporate_loans] ([account_activity_analysis]"
					+ ",[applicant_name]" + ",[background]" + ",[benefits_to_bank]" + ",[charges] "
					+ ",[collateral_security]" + ",[compiled_by]" + ",[conclusion]" + ",[conclusion_and_recommendation]"
					+ ",[cost_to_bank]" + ",[credit_comments]" + ",[creditemail]" + ",[curent_position]" + ",[decision]"
					+ ",[decision_by]" + ",[endDate]" + ",[exposure_to_bank]" + ",[finance_comments]"
					+ ",[finance_risk_analysis]" + ",[facility_type]" + ",[financeemail]" + ",[fromRecepient] "
					+ ",[industry]" + " ,[intertestRate]" + ",[legal_implications] " + ",[last_modified_by]"
					+ ",[last_modified_date]" + ",[legal_services]" + ",[legalemail]" + ",[loan_amount]" + ",[loanDate]"
					+ ",[loanRef], [loanPeriod] " + ",[location] " + ",[maximum_lending_limit]" + ",[motivation]"
					+ " ,[nature_of_business]" + ",[non_financial_risks_analysis]" + " ,[purpose]" + ",[purpose2]"
					+ " ,[ratio_analysis]" + ",[recommendations] " + ",[risk_comments]" + ",[riskemail]"
					+ " ,[startDate]" + ",[status_of_loan]" + " ,[subjectR]" + ",[submitted_by]" + ",[toRecepient])"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			java.sql.PreparedStatement insertReportStatement = null;

			try {

				insertReportStatement = con.prepareStatement(insertIssueSql, new String[] { "id" });
				int x1 = 1;

				insertReportStatement.setString(x1++, account_activity_analysis);
				insertReportStatement.setString(x1++, applicant_name);
				insertReportStatement.setString(x1++, background);
				insertReportStatement.setString(x1++, benefits_to_bank);
				insertReportStatement.setString(x1++, charges);
				insertReportStatement.setString(x1++, collateral_security);
				insertReportStatement.setString(x1++, compiled_by);
				insertReportStatement.setString(x1++, conclusion);
				insertReportStatement.setString(x1++, conclusion_and_recommendation);
				insertReportStatement.setString(x1++, cost_to_bank);
				insertReportStatement.setString(x1++, credit_comments); 
				insertReportStatement.setString(x1++, creditemail);
				insertReportStatement.setString(x1++, curent_position); 
				insertReportStatement.setString(x1++, decision); 
				insertReportStatement.setString(x1++, decision_by);
				insertReportStatement.setString(x1++, endDate);
				insertReportStatement.setString(x1++, exposure_to_bank); 
				insertReportStatement.setString(x1++, finance_comments); 
				insertReportStatement.setString(x1++, finance_risk_analysis); 
				insertReportStatement.setString(x1++, facility_type); 
				insertReportStatement.setString(x1++, financeemail);
				insertReportStatement.setString(x1++, fromRecepient);
				insertReportStatement.setString(x1++, industry); 
				insertReportStatement.setString(x1++, intertestRate); 
				insertReportStatement.setString(x1++, legal_implications); 
				insertReportStatement.setString(x1++, last_modified_by); 
				insertReportStatement.setString(x1++, last_modified_date); 
				insertReportStatement.setString(x1++, legal_services); 
				insertReportStatement.setString(x1++, legalemail); 
				insertReportStatement.setString(x1++, loan_amount);
				insertReportStatement.setString(x1++, loanDate); 
				insertReportStatement.setString(x1++, loanRef); 
				insertReportStatement.setInt(x1++, 0); 
				insertReportStatement.setString(x1++, location); 

				insertReportStatement.setString(x1++, maximum_lending_limit); 
				insertReportStatement.setString(x1++, motivation); 
				insertReportStatement.setString(x1++, nature_of_business); 
				insertReportStatement.setString(x1++, non_financial_risks_analysis); 
																						
				insertReportStatement.setString(x1++, purpose); 
				insertReportStatement.setString(x1++, purpose2);
				insertReportStatement.setString(x1++, ratio_analysis); 
				insertReportStatement.setString(x1++, recommendations); 
																		
				insertReportStatement.setString(x1++, risk_comments); 
				insertReportStatement.setString(x1++, riskemail); 
				insertReportStatement.setString(x1++, startDate); 
				insertReportStatement.setString(x1++, status_of_loan); 
				insertReportStatement.setString(x1++, subjectR); 
				insertReportStatement.setString(x1++, submitted_by); 
				insertReportStatement.setString(x1++, toRecepient); 
			
				insertReportStatement.executeUpdate();
				insertReportStatement.close();

				con.close();
				response.sendRedirect(request.getContextPath() + "/BusinessBankingLoanStatus");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
