package technicalResources.staffLoan;

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
 * Servlet implementation class StaffLoanHodRequest
 */
@WebServlet("/StaffLoanSecuritiesRequest")
public class StaffLoanSecuritiesRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ArrayList<String> pendingSecuritiesRequests = new ArrayList<String>();

		pendingSecuritiesRequests.clear();
		pendingSecuritiesRequests.add("Please select Loan reference in the email");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  *  FROM [dbo].[StaffLoan] where  [loanStatus] = 'Pending Securities Preparation'";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String loanRef = results.getString("employeeLoanRef");

					pendingSecuritiesRequests.add(loanRef);
				}
				
				request.setAttribute("pendingSecuritiesRequests", pendingSecuritiesRequests);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanSecuritiesCommentRequest.jsp");
				view.forward(request, response);			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}


	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;

		String administationFee = null;
		String allowances = null;
		String applicantComment = null;
		String applicantCommentDate = null;
		String bankExecutioner = null;
		String bankExecutionerCapacity = null;
		String basicSalary = null;
		String branchAdress = null;
		String carloanDeductions = null;
		String carloanBalance = null;
		String cif = null;
		String cityCouncilRatesDeductions = null;
		String cityCouncilRatesBalance = null;
		String createdBy = null;
		String dateloanRequired = null;
		String dateOfBirth = null;
		String dateEngaged = null;
		String dateOfFirstInstallment = null;
		String dateOfLastInstallment = null;
		String educationalloanDeductions = null;
		String educationalloanBalance = null;
		String emailAddress = null;
		String employeeCode = null;
		String employeeEmail = null;
		String employeeGrade = null;
		String employeePosition = null;
		String employeeDepartment = null;
		String employeeLoanRef = request.getParameter("employeeLoanRef");
		String establishmentFee = null;
		String farm_smallHolderDeductions = null;
		String farm_smallHolderBalance = null;
		String firstname = null;
		String hodComment = null;
		String hrPayrollMasterComment = null;
		String hrPayrollMasterEmail = null;
		String hod = null;
		String hodEmail = null;
		String housingloanDeductions = null;
		String housingloanBalance = null;
		String iDNumber = null;
		String instalment = null;
		String insurancesDeductions = null;
		String insurancesBalance = null;
		String interestRate = null;
		String lastModifiedBy = null;
		String lastModifiedDate = null;
		String loanAmount = null;
		String loanAmountWords = null;
		String loanStatus = null;
		String loanType = null;
		String maritalStatus = null;
		String noOfDependants = null;
		String otherBalance = null;
		String otherDeductions = null;
		String otherDeductionsExcLeaveAllowance = null;
		String personalloanDeductions = null;
		String personalloanBalance = null;
		String purposeOfLoan = null;
		String repaymentPeriod = null;
		String resAddress = null;
		String ruralHousingloanDeductions = null;
		String ruralHousingloanBalance = null;
		String secondName = null;
		
		String seniorHrManagerEmail = null;
		String seniorHrManagerComment = null;
		String securitiesPrinted = null;
		String statutoryDeductions = null;
		String studyloanDeductions = null;
		String studyloanBalance = null;
		String supervisorComment = null;
		String supervisorCommentDate = null;
		String supervisorEmail = null;
		String supervisor = null;
		String surname = null;
		String targetSavings = null;
		String telelephoneNo = null;

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [administationFee]      ,"
					+ "[allowances]      ," + "[applicantComment]      ,"
					+ "[applicantCommentDate]      ,"
					+ "[bankExecutioner]      ,"
					+ "[bankExecutionerCapacity]      ,"
					+ "[basicSalary]      ," + "[branchAdress]      ,"
					+ "[carloanDeductions]      ," + "[carloanBalance]      ,"
					+ "[cif]      ," + "[cityCouncilRatesDeductions]      ,"
					+ "[cityCouncilRatesBalance]      ," + "[createdBy]      ,"
					+ "[dateloanRequired]      ," + "[dateOfBirth]      ,"
					+ "[dateEngaged]      ,"
					+ "[dateOfFirstInstallment]      ,"
					+ "[dateOfLastInstallment]      ,"
					+ "[educationalloanDeductions]      ,"
					+ "[educationalloanBalance]      ,"
					+ "[emailAddress]      ," + "[employeeCode]      ,"
					+ "[employeeEmail]      ," + "[employeeGrade]      ,"
					+ "[employeePosition]      ,"
					+ "[employeeDepartment]      ,"
					+ "[hrPayrollMasterEmail]      ,"
					+ "[employeeLoanRef]      ," + "[establishmentFee]      ,"
					+ "[farm_smallHolderDeductions]      ,"
					+ "[farm_smallHolderBalance]      ," + "[firstname]      ,"
					+ "[hodComment]      ,"
					+ "[hrPayrollMasterComment]      ," + "[hod]      ,"
					+ "[hodEmail]      ," + "[housingloanDeductions]      ,"
					+ "[housingloanBalance]      ," + "[iDNumber]      ,"
					+ "[instalment]      ," + "[insurancesDeductions]      ,"
					+ "[insurancesBalance]      ," + "[interestRate]      ,"
					+ "[lastModifiedBy]      ," + "[lastModifiedDate]      ,"
					+ "[loanAmount]      ," + "[loanAmountWords]      ,"
					+ "[loanStatus]      ," + "[loanType]      ,"
					+ "[maritalStatus]      ," + "[noOfDependants]      ,"
					+ "[otherBalance]      ," + "[otherDeductions]      ,"
					+ "[otherDeductionsExcLeaveAllowance]      ,"
					+ "[personalloanDeductions]      ,"
					+ "[personalloanBalance]      ," + "[purposeOfLoan]      ,"
					+ "[repaymentPeriod]      ," + "[resAddress]      ,"
					+ "[ruralHousingloanDeductions]      ,"
					+ "[ruralHousingloanBalance]      ,"
					+ "[secondName]      ," + "[securitiesPrinted]      ,"
					+ "[statutoryDeductions]      ,"
					+ "[studyloanDeductions]      ,"
					+ "[studyloanBalance]      ,"
					+ "[supervisorComment]      ,"
					+ "[supervisorCommentDate]      ,"
					+ "[seniorHrManagerEmail]      ,"
					+ "[seniorHrManagerComment]      ,"
					
					+ "[supervisorEmail]      ," + "[supervisor]      ,"
					+ "[surname]      ," + "[targetSavings]      ,"
					+ "[telelephoneNo]  "
					+ "FROM [SwaziBankIntranet2016].[dbo].[StaffLoan] "
					+ "where [employeeLoanRef] = '" + employeeLoanRef + "' ";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					administationFee = results.getString("administationFee");
					allowances = results.getString("allowances");
					applicantComment = results.getString("applicantComment");
					applicantCommentDate = results.getString("applicantCommentDate");
					bankExecutioner = results.getString("bankExecutioner");
					bankExecutionerCapacity = results.getString("bankExecutionerCapacity");
					basicSalary = results.getString("basicSalary");
					branchAdress = results.getString("branchAdress");
					carloanDeductions = results.getString("carloanDeductions");
					carloanBalance = results.getString("carloanBalance");
					cif = results.getString("cif");
					cityCouncilRatesDeductions = results.getString("cityCouncilRatesDeductions");
					cityCouncilRatesBalance = results.getString("cityCouncilRatesBalance");
					createdBy = results.getString("createdBy");
					dateloanRequired = results.getString("dateloanRequired");
					dateOfBirth = results.getString("dateOfBirth");
					dateEngaged = results.getString("dateEngaged");
					dateOfFirstInstallment = results.getString("dateOfFirstInstallment");
					dateOfLastInstallment = results	.getString("dateOfLastInstallment");
					educationalloanDeductions = results.getString("educationalloanDeductions");
					educationalloanBalance = results.getString("educationalloanBalance");
					emailAddress = results.getString("emailAddress");
					employeeCode = results.getString("employeeCode");
					employeeEmail = results.getString("employeeEmail");
					employeeGrade = results.getString("employeeGrade");
					employeePosition = results.getString("employeePosition");
					employeeDepartment = results.getString("employeeDepartment");
					employeeLoanRef = results.getString("employeeLoanRef");
					establishmentFee = results.getString("establishmentFee");
					farm_smallHolderDeductions = results.getString("farm_smallHolderDeductions");
					farm_smallHolderBalance = results.getString("farm_smallHolderBalance");
					firstname = results.getString("firstname");
					hodComment = results.getString("hodComment");
					hrPayrollMasterComment = results.getString("hrPayrollMasterComment");
					hod = results.getString("hod");
					hodEmail = results.getString("hodEmail");
					housingloanDeductions = results.getString("housingloanDeductions");
					housingloanBalance = results.getString("housingloanBalance");
					hrPayrollMasterEmail  = results.getString("hrPayrollMasterEmail");
					iDNumber = results.getString("iDNumber");
					instalment = results.getString("instalment");
					insurancesDeductions = results.getString("insurancesDeductions");
					insurancesBalance = results.getString("insurancesBalance");
					interestRate = results.getString("interestRate");
					lastModifiedBy = results.getString("lastModifiedBy");
					lastModifiedDate = results.getString("lastModifiedDate");
					loanAmount = results.getString("loanAmount");
					loanAmountWords = results.getString("loanAmountWords");
					loanStatus = results.getString("loanStatus");
					loanType = results.getString("loanType");
					maritalStatus = results.getString("maritalStatus");
					noOfDependants = results.getString("noOfDependants");
					otherBalance = results.getString("otherBalance");
					otherDeductions = results.getString("otherDeductions");
					otherDeductionsExcLeaveAllowance = results
							.getString("otherDeductionsExcLeaveAllowance");
					personalloanDeductions = results
							.getString("personalloanDeductions");
					personalloanBalance = results
							.getString("personalloanBalance");
					purposeOfLoan = results.getString("purposeOfLoan");
					repaymentPeriod = results.getString("repaymentPeriod");
					resAddress = results.getString("resAddress");
					ruralHousingloanDeductions = results
							.getString("ruralHousingloanDeductions");
					ruralHousingloanBalance = results
							.getString("ruralHousingloanBalance");
					secondName = results.getString("secondName");
					securitiesPrinted = results.getString("securitiesPrinted");
					
					seniorHrManagerEmail = results.getString("seniorHrManagerEmail");
					seniorHrManagerComment = results.getString("seniorHrManagerComment");
					
					statutoryDeductions = results
							.getString("statutoryDeductions");
					studyloanDeductions = results
							.getString("studyloanDeductions");
					studyloanBalance = results.getString("studyloanBalance");
					supervisorComment = results.getString("supervisorComment");
					supervisorCommentDate = results
							.getString("supervisorCommentDate");
					supervisorEmail = results.getString("supervisorEmail");
					supervisor = results.getString("supervisor");
					surname = results.getString("surname");
					targetSavings = results.getString("targetSavings");
					telelephoneNo = results.getString("telelephoneNo");

					request.setAttribute("administationFee", administationFee);

					request.setAttribute("allowances", allowances);
					request.setAttribute("applicantComment", applicantComment);
					request.setAttribute("applicantCommentDate",
							applicantCommentDate);
					request.setAttribute("bankExecutioner", bankExecutioner);
					request.setAttribute("bankExecutionerCapacity",
							bankExecutionerCapacity);
					request.setAttribute("basicSalary", basicSalary);
					request.setAttribute("branchAdress", branchAdress);
					request.setAttribute("carloanDeductions", carloanDeductions);
					request.setAttribute("carloanBalance", carloanBalance);
					request.setAttribute("cif", cif);
					request.setAttribute("cityCouncilRatesDeductions",
							cityCouncilRatesDeductions);
					request.setAttribute("cityCouncilRatesBalance",
							cityCouncilRatesBalance);
					request.setAttribute("createdBy", createdBy);
					request.setAttribute("dateloanRequired", dateloanRequired);
					request.setAttribute("dateOfBirth", dateOfBirth);
					request.setAttribute("dateEngaged", dateEngaged);
					request.setAttribute("dateOfFirstInstallment",
							dateOfFirstInstallment);
					request.setAttribute("dateOfLastInstallment",
							dateOfLastInstallment);
					request.setAttribute("educationalloanDeductions",
							educationalloanDeductions);
					request.setAttribute("educationalloanBalance",
							educationalloanBalance);
					request.setAttribute("emailAddress", emailAddress);
					request.setAttribute("employeeCode", employeeCode);
					request.setAttribute("employeeEmail", employeeEmail);
					request.setAttribute("employeeGrade", employeeGrade);
					request.setAttribute("employeePosition", employeePosition);
					request.setAttribute("employeeDepartment",
							employeeDepartment);
					request.setAttribute("employeeLoanRef", employeeLoanRef);
					request.setAttribute("establishmentFee", establishmentFee);
					request.setAttribute("farm_smallHolderDeductions",
							farm_smallHolderDeductions);
					request.setAttribute("farm_smallHolderBalance",
							farm_smallHolderBalance);
					request.setAttribute("firstname", firstname);
					request.setAttribute("hodComment",
							hodComment);
					request.setAttribute("hrPayrollMasterComment",
							hrPayrollMasterComment);
					request.setAttribute("hod", hod);
					request.setAttribute("hodEmail", hodEmail);
					request.setAttribute("housingloanDeductions",
							housingloanDeductions);
					request.setAttribute("housingloanBalance",
							housingloanBalance);
					request.setAttribute("hrPayrollMasterEmail",
							hrPayrollMasterEmail);
					
					request.setAttribute("iDNumber", iDNumber);
					request.setAttribute("instalment", instalment);
					request.setAttribute("insurancesDeductions",
							insurancesDeductions);
					request.setAttribute("insurancesBalance", insurancesBalance);
					request.setAttribute("interestRate", interestRate);
					request.setAttribute("lastModifiedBy", lastModifiedBy);
					request.setAttribute("lastModifiedDate", lastModifiedDate);
					request.setAttribute("loanAmount", loanAmount);
					request.setAttribute("loanAmountWords", loanAmountWords);
					request.setAttribute("loanStatus", loanStatus);
					request.setAttribute("loanType", loanType);
					request.setAttribute("maritalStatus", maritalStatus);
					request.setAttribute("noOfDependants", noOfDependants);
					request.setAttribute("otherBalance", otherBalance);
					request.setAttribute("otherDeductions", otherDeductions);
					request.setAttribute("otherDeductionsExcLeaveAllowance",
							otherDeductionsExcLeaveAllowance);
					request.setAttribute("personalloanDeductions",
							personalloanDeductions);
					request.setAttribute("personalloanBalance",
							personalloanBalance);
					request.setAttribute("purposeOfLoan", purposeOfLoan);
					request.setAttribute("repaymentPeriod", repaymentPeriod);
					request.setAttribute("resAddress", resAddress);
					request.setAttribute("ruralHousingloanDeductions",
							ruralHousingloanDeductions);
					request.setAttribute("ruralHousingloanBalance",
							ruralHousingloanBalance);
					request.setAttribute("secondName", secondName);
					request.setAttribute("securitiesPrinted", securitiesPrinted);
					request.setAttribute("statutoryDeductions",
							statutoryDeductions);
					request.setAttribute("studyloanDeductions",
							studyloanDeductions);
					request.setAttribute("studyloanBalance", studyloanBalance);
					request.setAttribute("supervisorComment", supervisorComment);
					request.setAttribute("supervisorCommentDate",
							supervisorCommentDate);
					
					request.setAttribute("seniorHrManagerEmail",seniorHrManagerEmail);
					request.setAttribute("seniorHrManagerComment",seniorHrManagerComment);
					 
					
					request.setAttribute("supervisorEmail", supervisorEmail);
					request.setAttribute("supervisor", supervisor);
					request.setAttribute("surname", surname);
					request.setAttribute("targetSavings", targetSavings);
					request.setAttribute("telelephoneNo", telelephoneNo);

				}

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanSecuritiesComment.jsp");
				view.forward(request, response);
			} catch (SQLException e) {

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
