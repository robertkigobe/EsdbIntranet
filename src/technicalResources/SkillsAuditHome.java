package technicalResources;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/SkillsAuditHome")
public class SkillsAuditHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SkillsAuditHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources/skillsAuditHome.jsp");
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String position = request.getParameter("position");

		switch (position) {
		case "Admin-Messenger":
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/views/messenger.jsp");
			view.forward(request, response);
			break;
			
		case "Admin-Head Cleaner":
			RequestDispatcher view1 = request
					.getRequestDispatcher("WEB-INF/views/headCleaner.jsp");
			view1.forward(request, response);
			break;
		case "Admin-Senior Driver":
			RequestDispatcher view2 = request
					.getRequestDispatcher("WEB-INF/views/seniorDriver.jsp");
			view2.forward(request, response);
			break;
			
		case "Admin-Cleaner/Messenger":
			RequestDispatcher view3 = request
					.getRequestDispatcher("WEB-INF/views/cleanermessenger.jsp");
			view3.forward(request, response);
			break;
			
			
		case "Admin-Registry Clerk":
			RequestDispatcher view4 = request
					.getRequestDispatcher("WEB-INF/views/registryClerk.jsp");
			view4.forward(request, response);
			break;
			
		case "Admin-Warehouse Assistant":
			RequestDispatcher view5 = request
					.getRequestDispatcher("WEB-INF/views/warehouseAssistant.jsp");
			view5.forward(request, response);
			break;
			
		case "Admin-Assistant Manager Administration":
			RequestDispatcher view6 = request
					.getRequestDispatcher("WEB-INF/views/assistantManagerAdministration.jsp");
			view6.forward(request, response);
			break;
			
			
		case "Admin-Manager Administration":
			RequestDispatcher view7 = request
					.getRequestDispatcher("WEB-INF/views/managerAdministration.jsp");
			view7.forward(request, response);
			break;
			
		case "Agribusiness-Loans Review Officer":
			RequestDispatcher view8 = request
					.getRequestDispatcher("WEB-INF/views/agribusinessLoansReviewOfficer.jsp");
			view8.forward(request, response);
			break;
			
		case "Agribusiness-Appraisal Officer":
			RequestDispatcher view9 = request
					.getRequestDispatcher("WEB-INF/views/agribusinessAppraisalOfficer.jsp");
			view9.forward(request, response);
			break;
			
		case "Agribusiness-Manager":
			RequestDispatcher view10 = request
					.getRequestDispatcher("WEB-INF/views/agribusinessManager.jsp");
			view10.forward(request, response);
			break;
			
		case "Motor-Vehicle Assistant Manager  Finance":
			RequestDispatcher view11 = request
					.getRequestDispatcher("WEB-INF/views/assistantManagerMotorVehicleFinance.jsp");
			view11.forward(request, response);
			break;
		
		case "Motor-Vehicle Officer":
			RequestDispatcher view12 = request
					.getRequestDispatcher("WEB-INF/views/motorVehicleOfficer.jsp");
			view12.forward(request, response);
			break;
			
			
		case "Motor-Vehicle Loans Administration & Securities":
			RequestDispatcher view13 = request
					.getRequestDispatcher("WEB-INF/views/loansAdministrationSecurities.jsp");
			view13.forward(request, response);
			break;	
			
		case "Branch-Network Filing Clerk":
			RequestDispatcher view14 = request
					.getRequestDispatcher("WEB-INF/views/branchNetworkFilingClerk.jsp");
			view14.forward(request, response);
			break;
			
		case "Branch-Network Receptionist":
			RequestDispatcher view15 = request
					.getRequestDispatcher("WEB-INF/views/branchNetworkReceptionist.jsp");
			view15.forward(request, response);
			break;
			
		case "Electronic-Banking Reconciliations Officer":
			RequestDispatcher view16 = request
					.getRequestDispatcher("WEB-INF/views/electronicBankingReconciliationsOfficer.jsp");
			view16.forward(request, response);
			break;
			
		case "Electronic-Banking Fraud and Investigation Officer":
			RequestDispatcher view17 = request
					.getRequestDispatcher("WEB-INF/views/electronicBankingFraudandInvestigationOfficer.jsp");
			view17.forward(request, response);
			break;
			
		case "SMME Reviews Officer":
			RequestDispatcher view18 = request
					.getRequestDispatcher("WEB-INF/views/sMMEReviewsOfficer.jsp");
			view18.forward(request, response);
			break;
			
		case "SMME Appraisal Officer":
			RequestDispatcher view19 = request
					.getRequestDispatcher("WEB-INF/views/sMMEAppraisalOfficer.jsp");
			view19.forward(request, response);
			break;
			
		case "SMME Manager":
			RequestDispatcher view20 = request
					.getRequestDispatcher("WEB-INF/views/sMMEManager.jsp");
			view20.forward(request, response);
			break;
			
		case "Risk and Compliance Officer":
			RequestDispatcher view21 = request
					.getRequestDispatcher("WEB-INF/views/riskandComplianceOfficer.jsp");
			view21.forward(request, response);
			break;
			
			
		case "Reviews Manager Reviews":
			RequestDispatcher view22 = request
					.getRequestDispatcher("WEB-INF/views/managerReviews.jsp");
			view22.forward(request, response);
			break;	
			
			
		case "Reviews Personal Loans Review Officer":
			RequestDispatcher view23 = request
					.getRequestDispatcher("WEB-INF/views/personalLoansReviewOfficer.jsp");
			view23.forward(request, response);
			break;
			
		case "Coop-Business Corporate Officer":
			RequestDispatcher view24 = request
					.getRequestDispatcher("WEB-INF/views/corporateOfficer.jsp");
			view24.forward(request, response);
			break;
			
		case "Executive Secretary":
			RequestDispatcher view25 = request
					.getRequestDispatcher("WEB-INF/views/executiveSecretary.jsp");
			view25.forward(request, response);
			break;
			
			
		case "Coop-Business Manager Corporate Business":
			RequestDispatcher view26 = request
					.getRequestDispatcher("WEB-INF/views/managerCorporateBusiness.jsp");
			view26.forward(request, response);
			break;
			
		case "Operations Operations Officer":
			RequestDispatcher view27 = request
					.getRequestDispatcher("WEB-INF/views/operationsOfficer.jsp");
			view27.forward(request, response);
			break;
			
		case "Operations Branch Network Controller":
			RequestDispatcher view28 = request
					.getRequestDispatcher("WEB-INF/views/branchNetworkController.jsp");
			view28.forward(request, response);
			break;
			
		case "Finance Finance Clerk":
			RequestDispatcher view29 = request
					.getRequestDispatcher("WEB-INF/views/financeClerk.jsp");
			view29.forward(request, response);
			break;
			
		case "Finance Payments Officer":
			RequestDispatcher view30 = request
					.getRequestDispatcher("WEB-INF/views/paymentsOfficer.jsp");
			view30.forward(request, response);
			break;
			
		case "Finance Budgets Officer":
			RequestDispatcher view31 = request
					.getRequestDispatcher("WEB-INF/views/budgetsOfficer.jsp");
			view31.forward(request, response);
			break;
			
		case "Finance Treasury Dealer":
			RequestDispatcher view32 = request
					.getRequestDispatcher("WEB-INF/views/treasuryDealer.jsp");
			view32.forward(request, response);
			break;
			
		case "Finance Management Accountant":
			RequestDispatcher view33 = request
					.getRequestDispatcher("WEB-INF/views/managementAccountant.jsp");
			view33.forward(request, response);
			break;
			
		case "Finance Correspondent Reconciliations Officer":
			RequestDispatcher view34 = request
					.getRequestDispatcher("WEB-INF/views/correspondentReconciliationsOfficer.jsp");
			view34.forward(request, response);
			break;
			
		case "Finance Senior Manager Finance":
			RequestDispatcher view35 = request
					.getRequestDispatcher("WEB-INF/views/seniorManagerFinance.jsp");
			view35.forward(request, response);
			break;
			
		case "Finance Manager Investment and Treasury":
			RequestDispatcher view36 = request
					.getRequestDispatcher("WEB-INF/views/managerInvestmentandTreasury.jsp");
			view36.forward(request, response);
			break;
		
		case "Finance Budgets Manager":
			RequestDispatcher view37 = request
					.getRequestDispatcher("WEB-INF/views/budgetsManager.jsp");
			view37.forward(request, response);
			break;
			
		case "Housing Appraisal Officer":
			RequestDispatcher view38 = request
					.getRequestDispatcher("WEB-INF/views/appraisalOfficer.jsp");
			view38.forward(request, response);
			break;
			
		case "Housing Building Inspector":
			RequestDispatcher view39 = request
					.getRequestDispatcher("WEB-INF/views/buildingInspector.jsp");
			view39.forward(request, response);
			break;
			
			
		case "Housing Loans Review Officer":
			RequestDispatcher view40 = request
					.getRequestDispatcher("WEB-INF/views/loansReviewOfficer.jsp");
			view40.forward(request, response);
			break;
			
		case "Housing Assistant Manager":
			RequestDispatcher view41 = request
					.getRequestDispatcher("WEB-INF/views/housingAssistantManager.jsp");
			view41.forward(request, response);
			break;
			
		case "Housing Registry Clerk":
			RequestDispatcher view42 = request
					.getRequestDispatcher("WEB-INF/views/housingRegistryClerk.jsp");
			view42.forward(request, response);
			break;
			
		case "Internal Audit Assistant":
			RequestDispatcher view43 = request
					.getRequestDispatcher("WEB-INF/views/internalAuditAssistant.jsp");
			view43.forward(request, response);
			break;
			
			
		case "Internal Auditor":
			RequestDispatcher view44 = request
					.getRequestDispatcher("WEB-INF/views/internalAuditor.jsp");
			view44.forward(request, response);
			break;
			
		case "Internal Audit IT":
			RequestDispatcher view45 = request
					.getRequestDispatcher("WEB-INF/views/internalAuditmanager.jsp");
			view45.forward(request, response);
			break;
			
		case "MD's PA":
			RequestDispatcher view46 = request
					.getRequestDispatcher("WEB-INF/views/mdspa.jsp");
			view46.forward(request, response);
			break;
			
		case "Legal Conveyancing Officer":
			RequestDispatcher view47 = request
					.getRequestDispatcher("WEB-INF/views/legalConveyancingOfficer.jsp");
			view47.forward(request, response);
			break;
			
		case "Legal Senior Recoveries Officer":
			RequestDispatcher view48 = request
					.getRequestDispatcher("WEB-INF/views/legalSeniorRecoveriesOfficer.jsp");
			view48.forward(request, response);
			break;
			
		case "Legal Advisor Commercial":
			RequestDispatcher view49 = request
					.getRequestDispatcher("WEB-INF/views/legalAdvisorCommercial.jsp");
			view49.forward(request, response);
			break;
			
		case "Insurance Accounts and Collections Officer":
			RequestDispatcher view50 = request
					.getRequestDispatcher("WEB-INF/views/insuranceAccountsandCollectionsOfficer.jsp");
			view50.forward(request, response);
			break;
			
		case "Insurance Underwriting and Sales officer":
			RequestDispatcher view51 = request
					.getRequestDispatcher("WEB-INF/views/insuranceUnderwrittingandSalesofficer.jsp");
			view51.forward(request, response);
			break;
			
		case "Insurance Manager":
			RequestDispatcher view52 = request
					.getRequestDispatcher("WEB-INF/views/insuranceManager.jsp");
			view52.forward(request, response);
			break;
			
		case "Marketing Customer Service Officer":
			RequestDispatcher view53 = request
					.getRequestDispatcher("WEB-INF/views/markettingCustomerServiceOfficer.jsp");
			view53.forward(request, response);
			break;
			
		case "Marketing Public Relations Officer":
			RequestDispatcher view54 = request
					.getRequestDispatcher("WEB-INF/views/markettingPublicRelationsOfficer.jsp");
			view54.forward(request, response);
			break;
			
		case "Marketing Sales Officer":
			RequestDispatcher view55 = request
					.getRequestDispatcher("WEB-INF/views/markettingSalesOfficer.jsp");
			view55.forward(request, response);
			break;
			
		case "Marketing Premier Banking Officer":
			RequestDispatcher view56 = request
					.getRequestDispatcher("WEB-INF/views/markettingPremierBankingOfficer.jsp");
			view56.forward(request, response);
			break;

		case "Marketing Marketing Analyst":
			RequestDispatcher view57 = request
					.getRequestDispatcher("WEB-INF/views/markettingMarketingAnalyst.jsp");
			view57.forward(request, response);
			break;
		
		
			case "Marketing Call Center Agent":
				RequestDispatcher view58 = request
						.getRequestDispatcher("WEB-INF/views/marketingCallCenterAgent.jsp");
				view58.forward(request, response);
				break;
				
			case "Human Resources Training and Development Officer":
				RequestDispatcher view59 = request
						.getRequestDispatcher("WEB-INF/views/humanResourcesTrainingandDevelopmentOfficer.jsp");
				view59.forward(request, response);
				break;
				
			case "Human Resources Industrial Relations Manager":
				RequestDispatcher view60 = request
						.getRequestDispatcher("WEB-INF/views/humanResourcesIndustrialRelationsManager.jsp");
				view60.forward(request, response);
				break;
				
			case "Credit Credit Analyst":
				RequestDispatcher view61 = request
						.getRequestDispatcher("WEB-INF/views/creditAnalyst.jsp");
				view61.forward(request, response);
				break;
				
			case "Credit Collections Officer":
				RequestDispatcher view62 = request
						.getRequestDispatcher("WEB-INF/views/creditCollectionsOfficer.jsp");
				view62.forward(request, response);
				break;
				
			case "Credit Account Opening Officer":
				RequestDispatcher view63 = request
						.getRequestDispatcher("WEB-INF/views/creditAccountOpeningOfficer.jsp");
				view63.forward(request, response);
				break;
				
			case "Credit Account Management Supervisor":
				RequestDispatcher view64 = request
						.getRequestDispatcher("WEB-INF/views/creditAssistantManagerAccountsManagement.jsp");
				view64.forward(request, response);
				break;
				
			}
	}

}
