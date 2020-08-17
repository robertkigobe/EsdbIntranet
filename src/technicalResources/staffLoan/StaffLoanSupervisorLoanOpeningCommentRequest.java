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
 * Servlet implementation class StaffLoanPayrollMasterRequest
 */
@WebServlet("/StaffLoanSupervisorLoanOpeningCommentRequest")
public class StaffLoanSupervisorLoanOpeningCommentRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ArrayList<String> pendingLoanDisbursementsRequests = new ArrayList<String>();

		pendingLoanDisbursementsRequests.clear();
		pendingLoanDisbursementsRequests.add("Please select Loan reference in the email");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  *  FROM [dbo].[StaffLoan] where  [loanStatus] = 'Pending Loan Disbursement'";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String loanRef = results.getString("employeeLoanRef");

					pendingLoanDisbursementsRequests.add(loanRef);
				}
				
				request.setAttribute("pendingLoanDisbursementsRequests", pendingLoanDisbursementsRequests);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanSupervisorLoanOpeningCommentRequest.jsp");
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

		
		String employeeLoanRef = request.getParameter("employeeLoanRef");
		String administationFee;
	     String allowances;
	     String applicantComment;
	     String applicantCommentDate;
	     String bankExecutioner;
	     String bankExecutionerCapacity;
	     String basicSalary;
	     String branchAdress;
	     String boxAddress;
	     String carloanDeductions;
	     String carloanBalance;
	     String cif;
	     String city;
	     String cityCouncilRatesDeductions;
	     String cityCouncilRatesBalance;
	     String createdBy;
	     String dateloanRequired;
	     String dateOfBirth;
	     String dateEngaged;
	     String dateOfFirstInstallment;
	     String dateOfLastInstallment;
	     String educationalloanDeductions;
	     String educationalloanBalance;
	     String emailAddress;
	     String employeeAddress;
	     String employeeCode;
	     String employeeEmail;
	     String employeeGrade;
	     String employeePosition;
	     String employeeDepartment;
	     
	     String establishmentFee;
	     String farm_smallHolderDeductions;
	     String farm_smallHolderBalance;
	     String firstname;
	     String headOfDepartmentComment;
	     String headOfDepartmentCommentDate;
	     String hod;
	     String hodComment;
	     String hodCommentDate;
	     String hodEmail;
	     String housingloanDeductions;
	     String housingloanBalance;
	     String hrPayrollMasterComment;
	     String hrPayrollMasterCommentDate;
	     String hrPayrollMasterEmail;
	     String iDNumber;
	     String instalment;
	     String insurancesDeductions;
	     String insurancesBalance;
	     String interestRate;
	     String lastModifiedBy;
	     String lastModifiedDate;
	     String legalAdvisorEmail;
	     String legalAdvisorComment;
	     String legalAdvisorCommentDate;
	     String loanAmount;
	     String loanAmountWords;
	     String loanOpeningSupervisorComment;
	     String loanOpeningSupervisorCommentDate;
	     String loanOpeningSupervisorEmail;
	     String location;
	     String limitRef;
	     String loanStatus;
	     String loanType;
	     String maritalStatus;
	     String noOfDependants;
	     String otherBalance;
	     String otherDeductions;
	     String otherDeductionsExcLeaveAllowance;
	     String personalloanDeductions;
	     String personalloanBalance;
	     String purposeOfLoan;
	     String postCode;
	     String repaymentPeriod;
	     String resAddress;
	     String ruralHousingloanDeductions;
	     String ruralHousingloanBalance;
	     String secondName;
	     String securitiesPrinted;
	     String securitiesComment;
	     String securitiesCommentDate;
	     String seniorHrManagerEmail;
	     String seniorHrManagerComment;
	     String seniorHrManagerCommentDate;
	     String statutoryDeductions;
	     String studyloanDeductions;
	     String studyloanBalance;
	     String supervisorComment;
	     String supervisorCommentDate;
	     String supervisorEmail;
	     String supervisor;
	     String surname;
	     String securitiesSupervisorEmail;
	     String securitiesDocumentLocation;
	     String securitiesDocumentUploadDate;
	     String targetSavings;
	     String telelephoneNo;


		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [administationFee] ,"
					+ "[allowances]"
					+ " ,[applicantComment]"
     + " ,[applicantCommentDate]"
     + " ,[bankExecutioner]"
     + " ,[bankExecutionerCapacity]"
     + " ,[basicSalary]"
    + "  ,[branchAdress]"
     + " ,[boxAddress]"
     + " ,[carloanDeductions]"
     + " ,[carloanBalance]"
      + ",[cif]"
      + ",[city]"
      + ",[cityCouncilRatesDeductions]"
      + ",[cityCouncilRatesBalance]"
      + ",[createdBy]"
      + ",[dateloanRequired]"
      + ",[dateOfBirth]"
      + ",[dateEngaged]"
      + ",[dateOfFirstInstallment]"
      + ",[dateOfLastInstallment]"
      + ",[educationalloanDeductions]"
      + ",[educationalloanBalance]"
      + ",[emailAddress]"
      + ",[employeeAddress]"
      + ",[employeeCode]"
      + ",[employeeEmail]"
      + ",[employeeGrade]"
      + ",[employeePosition]"
      + ",[employeeDepartment]"
      + ",[employeeLoanRef]"
      + ",[establishmentFee]"
      + ",[farm_smallHolderDeductions]"
      + ",[farm_smallHolderBalance]"
      + ",[firstname]"
      + ",[headOfDepartmentComment]"
      + ",[headOfDepartmentCommentDate]"
      + ",[hod]"
      + ",[hodComment]"
      + ",[hodCommentDate]"
      + ",[hodEmail]"
      + ",[housingloanDeductions]"
      + ",[housingloanBalance]"
      + ",[hrPayrollMasterComment]"
      + ",[hrPayrollMasterCommentDate]"
      + ",[hrPayrollMasterEmail]"
      + ",[iDNumber]"
      + ",[instalment]"
      + ",[insurancesDeductions]"
      + ",[insurancesBalance]"
      + ",[interestRate]"
      + ",[lastModifiedBy]"
    		  + ",[lastModifiedDate]"
      + ",[legalAdvisorEmail]"
      + ",[legalAdvisorComment]"
      + ",[legalAdvisorCommentDate]"
      + ",[loanAmount]"
     + " ,[loanAmountWords]"
      + ",[loanOpeningSupervisorComment]"
      + ",[loanOpeningSupervisorCommentDate]"
      + ",[loanOpeningSupervisorEmail]"
     + " ,[location]"
     + " ,[limitRef]"
     + " ,[loanStatus]"
      + ",[loanType]"
      + ",[maritalStatus]"
      + ",[noOfDependants]"
     + " ,[otherBalance]"
     + " ,[otherDeductions]"
     + " ,[otherDeductionsExcLeaveAllowance]"
    		  + " ,[personalloanDeductions]"
      + ",[personalloanBalance]"
      + ",[purposeOfLoan]"
     + " ,[postCode]"
     + " ,[repaymentPeriod]"
     + " ,[resAddress]"
     + " ,[ruralHousingloanDeductions]"
      + ",[ruralHousingloanBalance]"
     + " ,[secondName]"
     + " ,[securitiesPrinted]"
     + " ,[securitiesComment]"
     + " ,[securitiesCommentDate]"
     + " ,[seniorHrManagerEmail]"
     + " ,[seniorHrManagerComment]"
     + " ,[seniorHrManagerCommentDate]"
     + " ,[statutoryDeductions]"
     + " ,[studyloanDeductions]"
     + " ,[studyloanBalance]"
    + "  ,[supervisorComment]"
    + "  ,[supervisorCommentDate]"
     + " ,[supervisorEmail]"
     + " ,[supervisor]"
     + " ,[surname]"
     + " ,[securitiesSupervisorEmail]"
     + " ,[securitiesDocumentLocation]"
     + " ,[securitiesDocumentUploadDate]"
     + " ,[targetSavings]"
     + " ,[telelephoneNo]"
    
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
				      boxAddress = results.getString("boxAddress");
				      carloanDeductions = results.getString("carloanDeductions");
				      carloanBalance = results.getString("carloanBalance");
				      cif = results.getString("cif");
				      city = results.getString("city");
				      cityCouncilRatesDeductions = results.getString("cityCouncilRatesDeductions");
				      cityCouncilRatesBalance = results.getString("cityCouncilRatesBalance");
				      createdBy = results.getString("createdBy");
				      dateloanRequired = results.getString("dateloanRequired");
				      dateOfBirth = results.getString("dateOfBirth");
				      dateEngaged = results.getString("dateEngaged");
				      dateOfFirstInstallment = results.getString("dateOfFirstInstallment");
				      dateOfLastInstallment = results.getString("dateOfLastInstallment");
				      educationalloanDeductions = results.getString("educationalloanDeductions");
				      educationalloanBalance = results.getString("educationalloanBalance");
				      emailAddress = results.getString("emailAddress");
				      employeeAddress = results.getString("employeeAddress");
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
				      headOfDepartmentComment = results.getString("headOfDepartmentComment");
				      headOfDepartmentCommentDate = results.getString("headOfDepartmentCommentDate");
				      hod = results.getString("hod");
				      hodComment = results.getString("hodComment");
				      hodCommentDate = results.getString("hodCommentDate");
				      hodEmail = results.getString("hodEmail");
				      housingloanDeductions = results.getString("housingloanDeductions");
				      housingloanBalance = results.getString("housingloanBalance");
				      hrPayrollMasterComment = results.getString("hrPayrollMasterComment");
				      hrPayrollMasterCommentDate = results.getString("hrPayrollMasterCommentDate");
				      hrPayrollMasterEmail = results.getString("hrPayrollMasterEmail");
				      iDNumber = results.getString("iDNumber");
				      instalment = results.getString("instalment");
				      insurancesDeductions = results.getString("insurancesDeductions");
				      insurancesBalance = results.getString("insurancesBalance");
				      interestRate = results.getString("interestRate");
				      lastModifiedBy = results.getString("lastModifiedBy");
				      lastModifiedDate = results.getString("lastModifiedDate");
				      legalAdvisorEmail = results.getString("legalAdvisorEmail");
				      legalAdvisorComment = results.getString("legalAdvisorComment");
				      legalAdvisorCommentDate = results.getString("legalAdvisorCommentDate");
				      loanAmount = results.getString("loanAmount");
				      loanAmountWords = results.getString("loanAmountWords");
				      loanOpeningSupervisorComment = results.getString("loanOpeningSupervisorComment");
				      loanOpeningSupervisorCommentDate = results.getString("loanOpeningSupervisorCommentDate");
				      loanOpeningSupervisorEmail = results.getString("loanOpeningSupervisorEmail");
				      location = results.getString("location");
				      limitRef = results.getString("limitRef");
				      loanStatus = results.getString("loanStatus");
				      loanType = results.getString("loanType");
				      maritalStatus = results.getString("maritalStatus");
				      noOfDependants = results.getString("noOfDependants");
				      otherBalance = results.getString("otherBalance");
				      otherDeductions = results.getString("otherDeductions");
				      otherDeductionsExcLeaveAllowance = results.getString("otherDeductionsExcLeaveAllowance");
				      personalloanDeductions = results.getString("personalloanDeductions");
				      personalloanBalance = results.getString("personalloanBalance");
				      purposeOfLoan = results.getString("purposeOfLoan");
				      postCode = results.getString("postCode");
				      repaymentPeriod = results.getString("repaymentPeriod");
				      resAddress = results.getString("resAddress");
				      ruralHousingloanDeductions = results.getString("ruralHousingloanDeductions");
				      ruralHousingloanBalance = results.getString("ruralHousingloanBalance");
				      secondName = results.getString("secondName");
				      securitiesPrinted = results.getString("securitiesPrinted");
				      securitiesComment = results.getString("securitiesComment");
				      securitiesCommentDate = results.getString("securitiesCommentDate");
				      seniorHrManagerEmail = results.getString("seniorHrManagerEmail");
				      seniorHrManagerComment = results.getString("seniorHrManagerComment");
				      seniorHrManagerCommentDate = results.getString("seniorHrManagerCommentDate");
				      statutoryDeductions = results.getString("statutoryDeductions");
				      studyloanDeductions = results.getString("studyloanDeductions");
				      studyloanBalance = results.getString("studyloanBalance");
				      supervisorComment = results.getString("supervisorComment");
				      supervisorCommentDate = results.getString("supervisorCommentDate");
				      supervisorEmail = results.getString("supervisorEmail");
				      supervisor = results.getString("supervisor");
				      surname = results.getString("surname");
				      securitiesSupervisorEmail = results.getString("securitiesSupervisorEmail");
				      securitiesDocumentLocation = results.getString("securitiesDocumentLocation");
				      securitiesDocumentUploadDate = results.getString("securitiesDocumentUploadDate");
				      targetSavings = results.getString("targetSavings");
				      telelephoneNo = results.getString("telelephoneNo");
				      

				      request.setAttribute("administationFee",administationFee);
				      request.setAttribute("allowances",allowances);
				      request.setAttribute("applicantComment",applicantComment);
				      request.setAttribute("applicantCommentDate",applicantCommentDate);
				      request.setAttribute("bankExecutioner",bankExecutioner);
				      request.setAttribute("bankExecutionerCapacity",bankExecutionerCapacity);
				      request.setAttribute("basicSalary",basicSalary);
				      request.setAttribute("branchAdress",branchAdress);
				      request.setAttribute("boxAddress",boxAddress);
				      request.setAttribute("carloanDeductions",carloanDeductions);
				      request.setAttribute("carloanBalance",carloanBalance);
				      request.setAttribute("cif",cif);
				      request.setAttribute("city",city);
				      request.setAttribute("cityCouncilRatesDeductions",cityCouncilRatesDeductions);
				      request.setAttribute("cityCouncilRatesBalance",cityCouncilRatesBalance);
				      request.setAttribute("createdBy",createdBy);
				      request.setAttribute("dateloanRequired",dateloanRequired);
				      request.setAttribute("dateOfBirth",dateOfBirth);
				      request.setAttribute("dateEngaged",dateEngaged);
				      request.setAttribute("dateOfFirstInstallment",dateOfFirstInstallment);
				      request.setAttribute("dateOfLastInstallment",dateOfLastInstallment);
				      request.setAttribute("educationalloanDeductions",educationalloanDeductions);
				      request.setAttribute("educationalloanBalance",educationalloanBalance);
				      request.setAttribute("emailAddress",emailAddress);
				      request.setAttribute("employeeAddress",employeeAddress);
				      request.setAttribute("employeeCode",employeeCode);
				      request.setAttribute("employeeEmail",employeeEmail);
				      request.setAttribute("employeeGrade",employeeGrade);
				      request.setAttribute("employeePosition",employeePosition);
				      request.setAttribute("employeeDepartment",employeeDepartment);
				      request.setAttribute("employeeLoanRef",employeeLoanRef);
				      request.setAttribute("establishmentFee",establishmentFee);
				      request.setAttribute("farm_smallHolderDeductions",farm_smallHolderDeductions);
				      request.setAttribute("farm_smallHolderBalance",farm_smallHolderBalance);
				      request.setAttribute("firstname",firstname);
				      request.setAttribute("headOfDepartmentComment",headOfDepartmentComment);
				      request.setAttribute("headOfDepartmentCommentDate",headOfDepartmentCommentDate);
				      request.setAttribute("hod",hod);
				      request.setAttribute("hodComment",hodComment);
				      request.setAttribute("hodCommentDate",hodCommentDate);
				      request.setAttribute("hodEmail",hodEmail);
				      request.setAttribute("housingloanDeductions",housingloanDeductions);
				      request.setAttribute("housingloanBalance",housingloanBalance);
				      request.setAttribute("hrPayrollMasterComment",hrPayrollMasterComment);
				      request.setAttribute("hrPayrollMasterCommentDate",hrPayrollMasterCommentDate);
				      request.setAttribute("hrPayrollMasterEmail",hrPayrollMasterEmail);
				      request.setAttribute("iDNumber",iDNumber);
				      request.setAttribute("instalment",instalment);
				      request.setAttribute("insurancesDeductions",insurancesDeductions);
				      request.setAttribute("insurancesBalance",insurancesBalance);
				      request.setAttribute("interestRate",interestRate);
				      request.setAttribute("lastModifiedBy",lastModifiedBy);
				      request.setAttribute("lastModifiedDate",lastModifiedDate);
				      request.setAttribute("legalAdvisorEmail",legalAdvisorEmail);
				      request.setAttribute("legalAdvisorComment",legalAdvisorComment);
				      request.setAttribute("legalAdvisorCommentDate",legalAdvisorCommentDate);
				      request.setAttribute("loanAmount",loanAmount);
				      request.setAttribute("loanAmountWords",loanAmountWords);
				      request.setAttribute("loanOpeningSupervisorComment",loanOpeningSupervisorComment);
				      request.setAttribute("loanOpeningSupervisorCommentDate",loanOpeningSupervisorCommentDate);
				      request.setAttribute("loanOpeningSupervisorEmail",loanOpeningSupervisorEmail);
				      request.setAttribute("location",location);
				      request.setAttribute("limitRef",limitRef);
				      request.setAttribute("loanStatus",loanStatus);
				      request.setAttribute("loanType",loanType);
				      request.setAttribute("maritalStatus",maritalStatus);
				      request.setAttribute("noOfDependants",noOfDependants);
				      request.setAttribute("otherBalance",otherBalance);
				      request.setAttribute("otherDeductions",otherDeductions);
				      request.setAttribute("otherDeductionsExcLeaveAllowance",otherDeductionsExcLeaveAllowance);
				      request.setAttribute("personalloanDeductions",personalloanDeductions);
				      request.setAttribute("personalloanBalance",personalloanBalance);
				      request.setAttribute("purposeOfLoan",purposeOfLoan);
				      request.setAttribute("postCode",postCode);
				      request.setAttribute("repaymentPeriod",repaymentPeriod);
				      request.setAttribute("resAddress",resAddress);
				      request.setAttribute("ruralHousingloanDeductions",ruralHousingloanDeductions);
				      request.setAttribute("ruralHousingloanBalance",ruralHousingloanBalance);
				      request.setAttribute("secondName",secondName);
				      request.setAttribute("securitiesPrinted",securitiesPrinted);
				      request.setAttribute("securitiesComment",securitiesComment);
				      request.setAttribute("securitiesCommentDate",securitiesCommentDate);
				      request.setAttribute("seniorHrManagerEmail",seniorHrManagerEmail);
				      request.setAttribute("seniorHrManagerComment",seniorHrManagerComment);
				      request.setAttribute("seniorHrManagerCommentDate",seniorHrManagerCommentDate);
				      request.setAttribute("statutoryDeductions",statutoryDeductions);
				      request.setAttribute("studyloanDeductions",studyloanDeductions);
				      request.setAttribute("studyloanBalance",studyloanBalance);
				      request.setAttribute("supervisorComment",supervisorComment);
				      request.setAttribute("supervisorCommentDate",supervisorCommentDate);
				      request.setAttribute("supervisorEmail",supervisorEmail);
				      request.setAttribute("supervisor",supervisor);
				      request.setAttribute("surname",surname);
				      request.setAttribute("securitiesSupervisorEmail",securitiesSupervisorEmail);
				      request.setAttribute("securitiesDocumentLocation",securitiesDocumentLocation);
				      request.setAttribute("securitiesDocumentUploadDate",securitiesDocumentUploadDate);
				      request.setAttribute("targetSavings",targetSavings);
				      request.setAttribute("telelephoneNo",telelephoneNo);
				      
				       

				}

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanLegalAdvisorComment.jsp");
				

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
