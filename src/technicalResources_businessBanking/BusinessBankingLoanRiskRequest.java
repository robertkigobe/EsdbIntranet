package technicalResources_businessBanking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

@WebServlet("/BusinessBankingLoanRiskRequest")
public class BusinessBankingLoanRiskRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;


		ArrayList<String> pendingSecuritiesRequests = new ArrayList<String>();

		pendingSecuritiesRequests.clear();
		pendingSecuritiesRequests.add("Please select Loan reference in the email");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[corporate_loans] where  [status_of_loan] = 'In Progress'";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String loanRef = results.getString("loanRef");

					pendingSecuritiesRequests.add(loanRef);
				}

				request.setAttribute("pendingSecuritiesRequests", pendingSecuritiesRequests);

				RequestDispatcher view = request.getRequestDispatcher(
						"WEB-INF/technicalResources_bussinessBanking/businessBankingLoanRiskRequest.jsp");
				view.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;
		String loanRef = request.getParameter("loanRef");

		String location = null;
		String loanDate = null;
		String toRecepient = null;
		String fromRecepient = null;
		String subjectR = null;
		String industry = null;
		String applicant_name = null;
		String facility_type = null;
		String purpose = null;
		String loan_amount = null;
		String startDate = null;
		String endDate = null;
		String charges = null;
		String intertestRate = null;
		String collateral_security = null;
		String exposure_to_bank = null;
		String conclusion = null;
		String recommendations = null;
		String purpose2 = null;
		String curent_position = null;
		String background = null;
		String nature_of_business = null;
		String non_financial_risks_analysis = null;
		String motivation = null;
		String benefits_to_bank = null;
		String cost_to_bank = null;
		String legal_implications = null;
		String account_activity_analysis = null;
		String finance_risk_analysis = null;
		String ratio_analysis = null;
		String maximum_lending_limit = null;
		String conclusion_and_recommendation = null;
		String credit_comments = null;
		String finance_comments = null;
		String risk_comments = null;
		String legal_services = null;
		String compiled_by = null;
		String submitted_by = null;
		String decision_by = null;
		String status_of_loan = null;
		String last_modified_by = null;
		String last_modified_date = null;
		String decision = null;
		

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[corporate_loans] where [loanRef] = '" + loanRef
					+ "' ";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					location = results.getString("location");
					loanDate = results.getString("loanDate");
					toRecepient = results.getString("toRecepient");
					fromRecepient = results.getString("fromRecepient");
					subjectR = results.getString("subjectR");
					industry = results.getString("industry");
					applicant_name = results.getString("applicant_name");
					facility_type = results.getString("facility_type");
					purpose = results.getString("purpose");
					loan_amount = results.getString("loan_amount");
					startDate = results.getString("startDate");
					endDate = results.getString("endDate");
					charges = results.getString("charges");
					intertestRate = results.getString("intertestRate");
					collateral_security = results.getString("collateral_security");
					exposure_to_bank = results.getString("exposure_to_bank");
					conclusion = results.getString("conclusion");
					recommendations = results.getString("recommendations");
					purpose2 = results.getString("purpose2");
					curent_position = results.getString("curent_position");
					background = results.getString("background");
					nature_of_business = results.getString("nature_of_business");
					non_financial_risks_analysis = results.getString("non_financial_risks_analysis");
					motivation = results.getString("motivation");
					benefits_to_bank = results.getString("benefits_to_bank");
					cost_to_bank = results.getString("cost_to_bank");
					legal_implications = results.getString("legal_implications");
					account_activity_analysis = results.getString("account_activity_analysis");
					finance_risk_analysis = results.getString("finance_risk_analysis");
					ratio_analysis = results.getString("ratio_analysis");
					maximum_lending_limit = results.getString("maximum_lending_limit");
					conclusion_and_recommendation = results.getString("conclusion_and_recommendation");
					credit_comments = results.getString("credit_comments");
					finance_comments = results.getString("finance_comments");
					risk_comments = results.getString("risk_comments");
					legal_services = results.getString("legal_services");
					compiled_by = results.getString("compiled_by");
					submitted_by = results.getString("submitted_by");
					decision_by = results.getString("decision_by");
					status_of_loan = results.getString("status_of_loan");
					last_modified_by = results.getString("last_modified_by");
					last_modified_date = results.getString("last_modified_date");
					decision = results.getString("decision");

				}

				request.setAttribute("location", location);
				request.setAttribute("loanDate", loanDate);
				request.setAttribute("toRecepient", toRecepient);
				request.setAttribute("fromRecepient", fromRecepient);
				request.setAttribute("subjectR", subjectR);
				request.setAttribute("industry", industry);
				request.setAttribute("applicant_name", applicant_name);
				request.setAttribute("facility_type", facility_type);
				request.setAttribute("purpose", purpose);
				request.setAttribute("loan_amount", loan_amount);
				request.setAttribute("startDate", startDate);
				request.setAttribute("endDate", endDate);
				request.setAttribute("charges", charges);
				request.setAttribute("intertestRate", intertestRate);
				request.setAttribute("collateral_security", collateral_security);
				request.setAttribute("exposure_to_bank", exposure_to_bank);
				request.setAttribute("conclusion", conclusion);
				request.setAttribute("recommendations", recommendations);
				request.setAttribute("purpose2", purpose2);
				request.setAttribute("curent_position", curent_position);
				request.setAttribute("background", background);
				request.setAttribute("nature_of_business", nature_of_business);
				request.setAttribute("non_financial_risks_analysis", non_financial_risks_analysis);
				request.setAttribute("motivation", motivation);
				request.setAttribute("benefits_to_bank", benefits_to_bank);
				request.setAttribute("cost_to_bank", cost_to_bank);
				request.setAttribute("legal_implications", legal_implications);
				request.setAttribute("loanRef", loanRef);
				request.setAttribute("account_activity_analysis", account_activity_analysis);
				request.setAttribute("finance_risk_analysis", finance_risk_analysis);
				request.setAttribute("ratio_analysis", ratio_analysis);
				request.setAttribute("maximum_lending_limit", maximum_lending_limit);
				request.setAttribute("conclusion_and_recommendation", conclusion_and_recommendation);
				request.setAttribute("credit_comments", credit_comments);
				request.setAttribute("finance_comments", finance_comments);
				request.setAttribute("risk_comments", risk_comments);
				request.setAttribute("legal_services", legal_services);
				request.setAttribute("compiled_by", compiled_by);
				request.setAttribute("submitted_by", submitted_by);
				request.setAttribute("decision_by", decision_by);
				request.setAttribute("status_of_loan", status_of_loan);
				request.setAttribute("last_modified_by", last_modified_by);
				request.setAttribute("last_modified_date", last_modified_date);
				request.setAttribute("decision", decision);
				
				
				RequestDispatcher view = request.getRequestDispatcher(
						"WEB-INF/technicalResources_bussinessBanking/businessBankingLoanRiskComments.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_bussinessBanking/businessBankingLoanErrorPage.jsp");
				view.forward(request, response);
			}

		}

	}
}
