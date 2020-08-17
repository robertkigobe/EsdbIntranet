package technicalResources.loanTracking;

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

/**
 * Servlet implementation class LoanTrackingLogin
 */
@WebServlet("/BranchLoanSecuritiesSupervisorRequest")
public class BranchLoanSecuritiesSupervisorRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;

		ArrayList<String> pendingBrachManangerBranchLoanRequests = new ArrayList<String>();

		pendingBrachManangerBranchLoanRequests.clear();
		pendingBrachManangerBranchLoanRequests.add("Please select Loan reference in the email");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  *  FROM [SwaziBankIntranet2016].[dbo].[branchLoan] where  [loanStatus] = 'Pending Securities Verification'";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String loanReference = results.getString("loanReference");

					pendingBrachManangerBranchLoanRequests.add(loanReference);
				}

				request.setAttribute("pendingBrachManangerBranchLoanRequests",
						pendingBrachManangerBranchLoanRequests);

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/tehcnicalResources_loanTracking/branchLoanSecuritiesSupervisorRequest.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;

		String loanReference = request.getParameter("loanReference");
		
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[branchLoan] where [loanReference] = '"+loanReference+"'";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					 request.setAttribute("administationFee", results.getFloat("administationFee"));
					//allowances request.setAttribute("applicantBankName", results.getFloat("allowances");
					
					request.setAttribute("applicantBankName", results.getString("applicantBankName"));
					 request.setAttribute("applicantBankBranch", results.getString("applicantBankBranch"));
					 request.setAttribute("applicantBankAccountNumber", results.getString("applicantBankAccountNumber"));
					 request.setAttribute("applicantName", results.getString("applicantName"));
					 request.setAttribute("applicantDistrict", results.getString("applicantDistrict"));
					 request.setAttribute("applicantHomeArea", results.getString("applicantHomeArea"));
					 request.setAttribute("applicantNearestShop_school", results.getString("applicantNearestShop_school"));
					 request.setAttribute("applicantChief", results.getString("applicantChief"));
					 request.setAttribute("applicantIndvuna", results.getString("applicantIndvuna"));
					 request.setAttribute("applicantRunner", results.getString("applicantRunner"));
					
					 request.setAttribute("bankExecutioner", results.getString("bankExecutioner"));
					 request.setAttribute("bankExecutionerCapacity", results.getString("bankExecutionerCapacity"));
					  request.setAttribute("basicSalary", results.getFloat("basicSalary"));
					 request.setAttribute("branchAdress", results.getString("branchAdress"));
					 request.setAttribute("branch", results.getString("branch"));
					 request.setAttribute("branchManagerComment", results.getString("branchManagerComment"));
					 request.setAttribute("branchManagerCommentDate", results.getString("branchManagerCommentDate"));
					 request.setAttribute("branchManagerName", results.getString("branchManagerName"));
					 request.setAttribute("branchManagerEmail", results.getString("branchManagerEmail"));
					 request.setAttribute("businessConsultantName", results.getString("businessConsultantName"));
					 request.setAttribute("businessConsultantComment", results.getString("businessConsultantComment"));
					 request.setAttribute("businessConsultantCommentDate", results.getString("businessConsultantCommentDate"));
					 request.setAttribute("businessConsultantEmail", results.getString("businessConsultantEmail"));
					  request.setAttribute("cashAtBank", results.getFloat("cashAtBank"));
					 request.setAttribute("cif", results.getString("cif"));	
					 request.setAttribute("creditAnalystComment", results.getString("creditAnalystComment"));
					 request.setAttribute("creditAnalystCommentDate", results.getString("creditAnalystCommentDate"));
					 request.setAttribute("creditAnalystName", results.getString("creditAnalystName"));
					 request.setAttribute("creditAnalystEmail", results.getString("creditAnalystEmail"));
					 request.setAttribute("creditManagerCommentDate", results.getString("creditManagerCommentDate"));
					 request.setAttribute("creditManagerName", results.getString("creditManagerName"));
					 request.setAttribute("creditManagerEmail", results.getString("creditManagerEmail"));
					 request.setAttribute("creditManagerComment", results.getString("creditManagerComment"));
					 request.setAttribute("dateOfBirth", results.getString("dateOfBirth"));
					 request.setAttribute("dateOfFirstInstallment", results.getString("dateOfFirstInstallment"));
					 request.setAttribute("dateOfLastInstallment", results.getString("dateOfLastInstallment"));
					  request.setAttribute("deficiency", results.getFloat("deficiency"));
					   request.setAttribute("dateCreated", results.getString("dateCreated"));
					 request.setAttribute("debtorsName1", results.getString("debtorsName1"));
					 request.setAttribute("debtorsName2", results.getString("debtorsName2"));
					 request.setAttribute("debtorsName3", results.getString("debtorsName3"));
					 request.setAttribute("debtorsName4", results.getString("debtorsName4"));
					 request.setAttribute("debtorsName1Amount", results.getFloat("debtorsName1Amount"));
					 request.setAttribute("debtorsName2Amount", results.getFloat("debtorsName2Amount"));
					 request.setAttribute("debtorsName3Amount", results.getFloat("debtorsName3Amount"));
					 request.setAttribute("debtorsName4Amount", results.getFloat("debtorsName4Amount"));
					 request.setAttribute("disbursedAmount", results.getString("disbursedAmount"));
					 request.setAttribute("disbursementDate", results.getString("disbursementDate"));
					 request.setAttribute("emailAddress", results.getString("emailAddress"));
					 request.setAttribute("employerName", results.getString("employerName"));
					 request.setAttribute("employerAddress", results.getString("employerAddress"));
					 request.setAttribute("employerPhysicalAddress", results.getString("employerPhysicalAddress"));
					 request.setAttribute("employerTelephoneNo", results.getString("employerTelephoneNo"));
					 request.setAttribute("employementTerms", results.getString("employementTerms"));
					 request.setAttribute("employementPeriod", results.getString("employementPeriod"));
					  request.setAttribute("electricity", results.getFloat("electricity"));
					 // request.setAttribute("establishmentFee", results.getFloat("establishmentFee"));
					  request.setAttribute("fixedDeposit", results.getFloat("fixedDeposit"));
					  request.setAttribute("food", results.getFloat("food"));
					  request.setAttribute("furnitureCars", results.getFloat("furnitureCars"));
					 request.setAttribute("iDNumber", results.getString("iDNumber"));
				
					  request.setAttribute("insurances", results.getFloat("insurances"));
					 //insurancesBalance request.setAttribute("applicantBankName", results.getFloat("insurancesBalance");
					  request.setAttribute("interestRate", results.getFloat("interestRate"));
					 request.setAttribute("lastModifiedBy", results.getString("lastModifiedBy"));
					 request.setAttribute("lastModifiedDate", results.getString("lastModifiedDate"));	
					  request.setAttribute("levelTermInsurancePremiumAmount", results.getFloat("levelTermInsurancePremiumAmount"));
					  request.setAttribute("loans", results.getFloat("loans"));
					  request.setAttribute("loanAmount", results.getFloat("loanAmount"));
					 request.setAttribute("loanAmountWords", results.getString("loanAmountWords"));
					 request.setAttribute("loanOpeningSupervisorName", results.getString("loanOpeningSupervisorName"));
					 request.setAttribute("loanOpeningSupervisorCommentDate", results.getString("loanOpeningSupervisorCommentDate"));
					 request.setAttribute("loanOpeningSupervisorComment", results.getString("loanOpeningSupervisorComment"));
					 request.setAttribute("loanOpeningSupervisorEmail", results.getString("loanOpeningSupervisorEmail"));
					 request.setAttribute("loanReference", results.getString("loanReference"));
					 request.setAttribute("loanStatus", results.getString("loanStatus"));
					 request.setAttribute("longTermLoans", results.getFloat("longTermLoans"));
					 request.setAttribute("maritalStatus", results.getString("maritalStatus"));
					  request.setAttribute("medicalAid", results.getFloat("medicalAid"));
					 request.setAttribute("mobileNo", results.getString("mobileNo"));
					 request.setAttribute("nationality", results.getString("nationality"));
					 request.setAttribute("nextOfKinName", results.getString("nextOfKinName"));
					 request.setAttribute("nextOfKinOccupation", results.getString("nextOfKinOccupation"));
					 request.setAttribute("nextOfKinEmployer", results.getString("nextOfKinEmployer"));
					 request.setAttribute("nextOfKinTelephoneNo", results.getString("nextOfKinTelephoneNo"));
					 request.setAttribute("nextOfKinCellNo", results.getString("nextOfKinCellNo"));
					 request.setAttribute("noOfDependants", results.getString("noOfDependants"));
					 request.setAttribute("occupation", results.getString("occupation")); 
					 request.setAttribute("overdrafts", results.getFloat("overdrafts"));
					  request.setAttribute("otherAccounts", results.getFloat("otherAccounts")); 
					  request.setAttribute("otherAssets", results.getFloat("otherAssets"));
					  request.setAttribute("otherDebts", results.getFloat("otherDebts"));
					  request.setAttribute("otherIncome", results.getFloat("otherIncome"));
					  //request.setAttribute("otherDeduction", results.getFloat("otherDeduction"));
					  request.setAttribute("otherDeductions", results.getFloat("otherDeductions"));
					//outstandingLoanType request.setAttribute("applicantBankName", results.getString("outstandingLoanType");
					 //outstandingLoanBalance request.setAttribute("applicantBankName", results.getFloat("outstandingLoanBalance");
					  request.setAttribute("pension", results.getFloat("pension"));
					 request.setAttribute("physicalAddress", results.getString("physicalAddress"));
					 request.setAttribute("physicalAddressType", results.getString("physicalAddressType"));
					 request.setAttribute("postalAddress", results.getString("postalAddress"));
					 request.setAttribute("previouslyAppliedforLoanwithSdsb", results.getString("previouslyAppliedforLoanwithSdsb"));
					 request.setAttribute("previousBranch", results.getString("previousBranch"));
					 request.setAttribute("previousLoanType", results.getString("previousLoanType"));
					 request.setAttribute("previousLoanBalances", results.getFloat("previousLoanBalances"));
					 request.setAttribute("property", results.getFloat("property"));
					  request.setAttribute("providentFund", results.getFloat("providentFund"));
					 request.setAttribute("referenceName1", results.getString("referenceName1"));
					 request.setAttribute("referenceName2", results.getString("referenceName2"));
					 request.setAttribute("referenceName3", results.getString("referenceName3"));
					 request.setAttribute("referenceName1PhysicalAddress", results.getString("referenceName1PhysicalAddress"));
					 request.setAttribute("referenceName2PhysicalAddress", results.getString("referenceName2PhysicalAddress"));
					 request.setAttribute("referenceName3PhysicalAddress", results.getString("referenceName3PhysicalAddress"));
					 request.setAttribute("referenceName1TelephoneNo", results.getString("referenceName1TelephoneNo"));
					 request.setAttribute("referenceName2TelephoneNo", results.getString("referenceName2TelephoneNo"));
					 request.setAttribute("referenceName3TelephoneNo", results.getString("referenceName3TelephoneNo"));
					 request.setAttribute("registryOfficerComment", results.getString("registryOfficerComment"));
					 request.setAttribute("registryrOfficerCommentDate", results.getString("registryrOfficerCommentDate"));
					 request.setAttribute("registryrOfficerName", results.getString("registryrOfficerName"));
					 request.setAttribute("registryOfficerEmail", results.getString("registryOfficerEmail"));
					  request.setAttribute("rent", results.getFloat("rent"));
					 request.setAttribute("repaymentPeriod", results.getString("repaymentPeriod"));

					 request.setAttribute("securitiesSupervisorComment", results.getString("securitiesSupervisorComment"));
					 request.setAttribute("securitiesSupervisorCommentDate", results.getString("securitiesSupervisorCommentDate"));
					 request.setAttribute("securitiesSupervisorEmail", results.getString("securitiesSupervisorEmail"));
					 request.setAttribute("securitiesSupervisorName", results.getString("securitiesSupervisorName"));
					 request.setAttribute("securitiesDocumentLocation", results.getString("securitiesDocumentLocation"));
					 request.setAttribute("securitiesDocumentUploadDate", results.getString("securitiesDocumentUploadDate"));
					  request.setAttribute("tax", results.getFloat("tax"));
					  request.setAttribute("taxIdentity", results.getString("taxIdentity"));
					 request.setAttribute("telelephoneNo", results.getString("telelephoneNo"));
					  request.setAttribute("surplus", results.getFloat("surplus"));
					  request.setAttribute("surplusLiabilities", results.getFloat("surplusLiabilities"));
					  request.setAttribute("water", results.getFloat("water"));
					  
					  RequestDispatcher view = request.getRequestDispatcher("WEB-INF/tehcnicalResources_loanTracking/branchLoanSecuritiesSupervisorComment.jsp");
						view.forward(request, response);
								 
								 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}
		try {
			ConnectionHelper.disconnect(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
