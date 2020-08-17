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
 * Servlet implementation class LoanActors
 */
@WebServlet("/BranchLoanActors")
public class BranchLoanActors extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String loanReference1 = request.getParameter("loanReference");
		System.out.println(loanReference1);
		Statement selectStatement = null;
		ResultSet results = null;

		float administationFee;

		String applicantBankName;
		String applicantBankBranch;
		String applicantBankAccountNumber;
		String applicantName;
		String applicantDistrict;
		String applicantHomeArea;
		String applicantNearestShop_school;
		String applicantChief;
		String applicantIndvuna;
		String applicantRunner;
		String bankExecutioner;
		String bankExecutionerCapacity;
		float basicSalary;
		String branchAdress;
		String branch;
		String branchManagerComment;
		String branchManagerCommentDate;
		String branchManagerName;
		String branchManagerEmail;
		String businessConsultantName;
		String businessConsultantComment;
		String businessConsultantCommentDate;
		String businessConsultantEmail;
		float cashAtBank;
		String cif;
		String creditAnalystComment;
		String creditAnalystCommentDate;
		String creditAnalystName;
		String creditAnalystEmail;
		String creditManagerCommentDate;
		String creditManagerName;
		String creditManagerEmail;
		String creditManagerComment;
		String dateCreated;
		String dateOfBirth;
		String dateOfFirstInstallment;
		String dateOfLastInstallment;
		float deficiency;
		String debtorsName1;
		String debtorsName2;
		String debtorsName3;
		String debtorsName4;
		float debtorsName1Amount;
		float debtorsName2Amount;
		float debtorsName3Amount;
		float debtorsName4Amount;
		String disbursedAmount;
		String disbursementDate;
		String emailAddress;
		String employerName;
		String employerAddress;
		String employerPhysicalAddress;
		String employerTelephoneNo;
		String employementTerms;
		String employementPeriod;
		float electricity;
		float establishmentFee;
		float fixedDeposit;
		float food;
		float furnitureCars;
		String iDNumber;

		float insurances;

		float interestRate;
		String lastModifiedBy;
		String lastModifiedDate;
		float levelTermInsurancePremiumAmount;
		float loans;
		float loanAmount;
		String loanAmountWords;
		String loanOpeningSupervisorName;
		String loanOpeningSupervisorCommentDate;
		String loanOpeningSupervisorComment;
		String loanOpeningSupervisorEmail;
		String loanReference;
		String loanStatus;
		float longTermLoans;
		String maritalStatus;
		float medicalAid;
		String mobileNo;
		String nationality;
		String nextOfKinName;
		String nextOfKinOccupation;
		String nextOfKinEmployer;
		String nextOfKinTelephoneNo;
		String nextOfKinCellNo;
		String noOfDependants;
		String occupation;
		float overdrafts;
		float otherAccounts;
		float otherAssets;
		float otherDebts;
		float otherIncome;
		float otherDeduction;
		float otherDeductions;
		String inactivity;

		float pension;
		String physicalAddress;
		String physicalAddressType;
		String postalAddress;
		String previouslyAppliedforLoanwithSdsb;
		float previousLoanBalances;
		String previousBranch;
		String previousLoanType;
		float property;
		float providentFund;
		String referenceName1;
		String referenceName2;
		String referenceName3;
		String referenceName1PhysicalAddress;
		String referenceName2PhysicalAddress;
		String referenceName3PhysicalAddress;
		String referenceName1TelephoneNo;
		String referenceName2TelephoneNo;
		String referenceName3TelephoneNo;
		String registryOfficerComment;
		String registryrOfficerCommentDate;
		String registryrOfficerName;
		String registryOfficerEmail;
		float rent;
		String repaymentPeriod;

		float savings;
		String securities1;
		String securities2;
		String securities3;
		String securities4;
		String securitiesSupervisorComment;
		String securitiesSupervisorCoomentDate;
		String securitiesSupervisorEmail;
		String securitiesSupervisorName;
		String securitiesDocumentLocation;
		String securitiesDocumentUploadDate;
		float tax;
		String taxIdentity;
		String telelephoneNo;
		float surplus;
		float surplusLiabilities;
		float water;

		ArrayList<BranchLoanApplicationBean> branchPersonalLoanList = new ArrayList<BranchLoanApplicationBean>();
		Integer days = null;
		Integer hours = null;
		Integer minutes = null;
		Integer second = null;
		Integer seconds = null;

		branchPersonalLoanList.clear();
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  [id]"
					+ "[administationFee]"
					+ ",[allowances]"

					+ ",[applicantBankName]"
					+ ",[applicantBankBranch]"
					+ ",[applicantBankAccountNumber]"
					+ ",[applicantName]"
					+ ",[applicantDistrict]"
					+ ",[applicantHomeArea]"
					+ ",[applicantNearestShop_school]"
					+ ",[applicantChief]"
					+ ",[applicantIndvuna]"
					+ ",[applicantRunner]"

					+ ",[bankExecutioner]"
					+ ",[bankExecutionerCapacity]"
					+ ",[basicSalary]"
					+ ",[branchAdress]"
					+ ",[branch]"
					+ ",[branchManagerComment]"
					+ ",[branchManagerCommentDate]"
					+ ",[branchManagerName]"
					+ ",[branchManagerEmail]"
					+ ",[businessConsultantName]"
					+ ",[businessConsultantComment]"
					+ ",[businessConsultantCommentDate]"
					+ ",[businessConsultantEmail]"
					+ ",[cashAtBank]"
					+ ",[cif]"
					+ ",[creditAnalystComment]"
					+ ",[creditAnalystCommentDate]"
					+ ",[creditAnalystName]"
					+ ",[creditAnalystEmail]"
					+ ",[creditManagerCommentDate]"
					+ ",[creditManagerName]"
					+ ",[creditManagerEmail]"
					+ ",[creditManagerComment]"
					+ ",[dateCreated]"
					+ ",[dateOfBirth]"
					+ ",[dateOfFirstInstallment]"
					+ ",[dateOfLastInstallment]"
					+ ",[deficiency]"
					+ ",[debtorsName1]"
					+ ",[debtorsName2]"
					+ ",[debtorsName3]"
					+ ",[debtorsName4]"
					+ ",[debtorsName1Amount]"
					+ ",[debtorsName2Amount]"
					+ ",[debtorsName3Amount]"
					+ ",[debtorsName4Amount]"
					+ ",[disbursedAmount]"
					+ ",[disbursementDate]"
					+ ",[emailAddress]"
					+ ",[employerName]"
					+ ",[employerAddress]"
					+ ",[employerPhysicalAddress]"
					+ ",[employerTelephoneNo]"
					+ ",[employementTerms]"
					+ ",[employementPeriod]"
					+ ",[electricity]"
					+ ",[establishmentFee]"
					+ ",[fixedDeposit]"
					+ ",[food]"
					+ ",[furnitureCars]"
					+ ",[iDNumber]"
					+ ",[insurances]"
					+ ",[insurancesBalance]"
					+ ",[interestRate]"
					+ ",[lastModifiedBy]"
					+ ",[lastModifiedDate]"
					+ ",[levelTermInsurancePremiumAmount]"
					+ ",[loans]"
					+ ",[loanStatus]"
					+ ",[loanAmount]"
					+ ",[loanAmountWords]"
					+ ",[loanOpeningSupervisorName]"
					+ ",[loanOpeningSupervisorCommentDate]"
					+ ",[loanOpeningSupervisorComment]"
					+ ",[loanOpeningSupervisorEmail]"
					+ ",[loanReference]"
					+ ",[longTermLoans]"
					+ ",[maritalStatus]"
					+ ",[medicalAid]"
					+ ",[mobileNo]"

					+ ",[nationality]"
					+ ",[nextOfKinName]"
					+ ",[nextOfKinOccupation]"
					+ ",[nextOfKinEmployer]"
					+ ",[nextOfKinTelephoneNo]"
					+ ",[nextOfKinCellNo]"
					+ ",[noOfDependants]"
					+ ",[occupation]"
					+ ",[overdrafts]"
					+ ",[otherAccounts]"
					+ ",[otherAssets]"
					+ ",[otherDebts]"
					+ ",[otherIncome]"
					+ ",[otherDeduction]"
					+ ",[otherDeductions]"
					+ ",[pension]"
					+ ",[physicalAddress]"
					+ ",[physicalAddressType]"
					+ ",[postalAddress]"
					+ ",[previouslyAppliedforLoanwithSdsb]"
					+ ",[previousBranch]"
					+ ",[previousLoanType]"
					+ ",[previousLoanBalances]"
					+ ",[property]"
					+ ",[providentFund]"
					+ ",[referenceName1]"
					+ ",[referenceName2]"
					+ ",[referenceName3]"
					+ ",[referenceName1PhysicalAddress]"
					+ ",[referenceName2PhysicalAddress]"
					+ ",[referenceName3PhysicalAddress]"
					+ ",[referenceName1TelephoneNo]"
					+ ",[referenceName2TelephoneNo]"
					+ ",[referenceName3TelephoneNo]"
					+ ",[registryOfficerComment]"
					+ ",[registryrOfficerCommentDate]"
					+ ",[registryrOfficerName]"
					+ ",[registryOfficerEmail]"
					+ ",[rent]"
					+ ",[repaymentPeriod]"

					+ ",[savings]"
					+ ",[securities1]"
					+ ",[securities2]"
					+ ",[securities3]"
					+ ",[securities4]"
					+ ",[securitiesSupervisorComment]"
					+ ",[securitiesSupervisorCoomentDate]"
					+ ",[securitiesSupervisorEmail]"
					+ ",[securitiesSupervisorName]"
					+ ",[securitiesDocumentLocation]"
					+ ",[securitiesDocumentUploadDate]"
					+ ",[tax]"
					+ ",[taxIdentity]"
					+ ",[telelephoneNo]"
					+ ",[surplus]"
					+ ",[surplusLiabilities]"
					+ ",[water], "
					+ "datediff(year,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'years',"
					+ "datediff(month,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'months',"
					+ "datediff(week,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'weeks',"
					+ "datediff(day,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'days',"
					+ "datediff(hour,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'hours',"
					+ "datediff(minute,convert(datetime,[lastModifiedDate], 120) ,GETDATE()) as 'minutes',"
					+ "datediff(second,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'seconds' "
					+ "FROM [SwaziBankIntranet2016].[dbo].[branchPersonalLoan] where [loanStatus] = 'Loan Disbursed' order by [lastModifiedDate] desc";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					administationFee = results.getFloat("administationFee");
					// allowances = results.getFloat("allowances");

					applicantBankName = results.getString("applicantBankName");
					applicantBankBranch = results
							.getString("applicantBankBranch");
					applicantBankAccountNumber = results
							.getString("applicantBankAccountNumber");
					applicantName = results.getString("applicantName");
					applicantDistrict = results.getString("applicantDistrict");
					applicantHomeArea = results.getString("applicantHomeArea");
					applicantNearestShop_school = results
							.getString("applicantNearestShop_school");
					applicantChief = results.getString("applicantChief");
					applicantIndvuna = results.getString("applicantIndvuna");
					applicantRunner = results.getString("applicantRunner");

					bankExecutioner = results.getString("bankExecutioner");
					bankExecutionerCapacity = results
							.getString("bankExecutionerCapacity");
					basicSalary = results.getFloat("basicSalary");
					branchAdress = results.getString("branchAdress");
					branch = results.getString("branch");
					branchManagerComment = results
							.getString("branchManagerComment");
					branchManagerCommentDate = results
							.getString("branchManagerCommentDate");
					branchManagerName = results.getString("branchManagerName");
					branchManagerEmail = results
							.getString("branchManagerEmail");
					businessConsultantName = results
							.getString("businessConsultantName");
					businessConsultantComment = results
							.getString("businessConsultantComment");
					businessConsultantCommentDate = results
							.getString("businessConsultantCommentDate");
					businessConsultantEmail = results
							.getString("businessConsultantEmail");
					cashAtBank = results.getFloat("cashAtBank");
					cif = results.getString("cif");
					creditAnalystComment = results
							.getString("creditAnalystComment");
					creditAnalystCommentDate = results
							.getString("creditAnalystCommentDate");
					creditAnalystName = results.getString("creditAnalystName");
					creditAnalystEmail = results
							.getString("creditAnalystEmail");
					creditManagerCommentDate = results
							.getString("creditManagerCommentDate");
					creditManagerName = results.getString("creditManagerName");
					creditManagerEmail = results
							.getString("creditManagerEmail");
					creditManagerComment = results
							.getString("creditManagerComment");
					dateOfBirth = results.getString("dateOfBirth");
					dateOfFirstInstallment = results
							.getString("dateOfFirstInstallment");
					dateOfLastInstallment = results
							.getString("dateOfLastInstallment");
					deficiency = results.getFloat("deficiency");
					dateCreated = results.getString("dateCreated");
					debtorsName1 = results.getString("debtorsName1");
					debtorsName2 = results.getString("debtorsName2");
					debtorsName3 = results.getString("debtorsName3");
					debtorsName4 = results.getString("debtorsName4");
					debtorsName1Amount = results.getFloat("debtorsName1Amount");
					debtorsName2Amount = results.getFloat("debtorsName2Amount");
					debtorsName3Amount = results.getFloat("debtorsName3Amount");
					debtorsName4Amount = results.getFloat("debtorsName4Amount");
					disbursedAmount = results.getString("disbursedAmount");
					disbursementDate = results.getString("disbursementDate");
					emailAddress = results.getString("emailAddress");
					employerName = results.getString("employerName");
					employerAddress = results.getString("employerAddress");
					employerPhysicalAddress = results
							.getString("employerPhysicalAddress");
					employerTelephoneNo = results
							.getString("employerTelephoneNo");
					employementTerms = results.getString("employementTerms");
					employementPeriod = results.getString("employementPeriod");
					electricity = results.getFloat("electricity");
					establishmentFee = results.getFloat("establishmentFee");
					fixedDeposit = results.getFloat("fixedDeposit");
					food = results.getFloat("food");
					furnitureCars = results.getFloat("furnitureCars");
					iDNumber = results.getString("iDNumber");

					insurances = results.getFloat("insurances");
					// insurancesBalance =
					// results.getFloat("insurancesBalance");
					interestRate = results.getFloat("interestRate");
					lastModifiedBy = results.getString("lastModifiedBy");
					lastModifiedDate = results.getString("lastModifiedDate");
					levelTermInsurancePremiumAmount = results
							.getFloat("levelTermInsurancePremiumAmount");
					loans = results.getFloat("loans");
					loanAmount = results.getFloat("loanAmount");
					loanAmountWords = results.getString("loanAmountWords");
					loanOpeningSupervisorName = results
							.getString("loanOpeningSupervisorName");
					loanOpeningSupervisorCommentDate = results
							.getString("loanOpeningSupervisorCommentDate");
					loanOpeningSupervisorComment = results
							.getString("loanOpeningSupervisorComment");
					loanOpeningSupervisorEmail = results
							.getString("loanOpeningSupervisorEmail");
					loanReference = results.getString("loanReference");
					loanStatus = results.getString("loanStatus");
					longTermLoans = results.getFloat("longTermLoans");
					maritalStatus = results.getString("maritalStatus");
					medicalAid = results.getFloat("medicalAid");
					mobileNo = results.getString("mobileNo");
					nationality = results.getString("nationality");
					nextOfKinName = results.getString("nextOfKinName");
					nextOfKinOccupation = results
							.getString("nextOfKinOccupation");
					nextOfKinEmployer = results.getString("nextOfKinEmployer");
					nextOfKinTelephoneNo = results
							.getString("nextOfKinTelephoneNo");
					nextOfKinCellNo = results.getString("nextOfKinCellNo");
					noOfDependants = results.getString("noOfDependants");
					occupation = results.getString("occupation");
					overdrafts = results.getFloat("overdrafts");
					otherAccounts = results.getFloat("otherAccounts");
					otherAssets = results.getFloat("otherAssets");
					otherDebts = results.getFloat("otherDebts");
					otherIncome = results.getFloat("otherIncome");
					otherDeduction = results.getFloat("otherDeduction");
					otherDeductions = results.getFloat("otherDeductions");
					// outstandingLoanType =
					// results.getString("outstandingLoanType");
					// outstandingLoanBalance =
					// results.getFloat("outstandingLoanBalance");
					pension = results.getFloat("pension");
					physicalAddress = results.getString("physicalAddress");
					physicalAddressType = results
							.getString("physicalAddressType");
					postalAddress = results.getString("postalAddress");
					previouslyAppliedforLoanwithSdsb = results
							.getString("previouslyAppliedforLoanwithSdsb");
					previousBranch = results.getString("previousBranch");
					previousLoanType = results.getString("previousLoanType");
					previousLoanBalances = results
							.getFloat("previousLoanBalances");
					property = results.getFloat("property");
					providentFund = results.getFloat("providentFund");
					referenceName1 = results.getString("referenceName1");
					referenceName2 = results.getString("referenceName2");
					referenceName3 = results.getString("referenceName3");
					referenceName1PhysicalAddress = results
							.getString("referenceName1PhysicalAddress");
					referenceName2PhysicalAddress = results
							.getString("referenceName2PhysicalAddress");
					referenceName3PhysicalAddress = results
							.getString("referenceName3PhysicalAddress");
					referenceName1TelephoneNo = results
							.getString("referenceName1TelephoneNo");
					referenceName2TelephoneNo = results
							.getString("referenceName2TelephoneNo");
					referenceName3TelephoneNo = results
							.getString("referenceName3TelephoneNo");
					registryOfficerComment = results
							.getString("registryOfficerComment");
					registryrOfficerCommentDate = results
							.getString("registryrOfficerCommentDate");
					registryrOfficerName = results
							.getString("registryrOfficerName");
					registryOfficerEmail = results
							.getString("registryOfficerEmail");
					rent = results.getFloat("rent");
					repaymentPeriod = results.getString("repaymentPeriod");

					savings = results.getFloat("savings");
					securities1 = results.getString("securities1");
					securities2 = results.getString("securities2");
					securities3 = results.getString("securities3");
					securities4 = results.getString("securities4");
					securitiesSupervisorComment = results
							.getString("securitiesSupervisorComment");
					securitiesSupervisorCoomentDate = results
							.getString("securitiesSupervisorCoomentDate");
					securitiesSupervisorEmail = results
							.getString("securitiesSupervisorEmail");
					securitiesSupervisorName = results
							.getString("securitiesSupervisorName");
					securitiesDocumentLocation = results
							.getString("securitiesDocumentLocation");
					securitiesDocumentUploadDate = results
							.getString("securitiesDocumentUploadDate");
					tax = results.getFloat("tax");
					taxIdentity = results.getString("taxIdentity");
					telelephoneNo = results.getString("telelephoneNo");
					surplus = results.getFloat("surplus");
					surplusLiabilities = results.getFloat("surplusLiabilities");
					water = results.getFloat("water");

					second = Integer.valueOf(results.getString("seconds"));

					days = second / (60 * 60 * 24);
					hours = (second / (60 * 60)) - (days * 24);
					minutes = (second / 60) - ((hours * 60) + (days * 24 * 60));
					seconds = second
							- ((hours * 60 * 60) + (days * 24 * 60 * 60) + (minutes * 60));

					inactivity = days + "d: " + hours + "h: " + minutes + "m: "
							+ seconds + "s";

					branchPersonalLoanList.add(new BranchLoanApplicationBean(
							administationFee, 0, loanReference,
							applicantBankName, applicantBankBranch,
							applicantBankAccountNumber, applicantName,
							applicantDistrict, applicantHomeArea,
							applicantNearestShop_school, applicantChief,
							applicantIndvuna, applicantRunner, loanReference,
							bankExecutioner, bankExecutionerCapacity,
							basicSalary, branchAdress, branch,
							branchManagerComment, branchManagerCommentDate,
							branchManagerName, branchManagerEmail,
							businessConsultantName, businessConsultantComment,
							businessConsultantCommentDate,
							businessConsultantEmail, cashAtBank, cif,
							creditAnalystComment, creditAnalystCommentDate,
							creditAnalystName, creditAnalystEmail,
							creditManagerCommentDate, creditManagerName,
							creditManagerEmail, creditManagerComment,
							dateCreated, dateOfBirth, dateOfFirstInstallment,
							dateOfLastInstallment, deficiency, debtorsName1,
							debtorsName2, debtorsName3, debtorsName4,
							debtorsName1Amount, debtorsName2Amount,
							debtorsName3Amount, debtorsName4Amount,
							disbursedAmount, disbursementDate, emailAddress,
							employerName, employerAddress,
							employerPhysicalAddress, employerTelephoneNo,
							employementTerms, employementPeriod, electricity,
							establishmentFee, fixedDeposit, food,
							furnitureCars, iDNumber, 0, insurances, 0,
							interestRate, lastModifiedBy, lastModifiedDate,
							levelTermInsurancePremiumAmount, loans, loanStatus,
							loanAmount, loanAmountWords,
							loanOpeningSupervisorName,
							loanOpeningSupervisorCommentDate,
							loanOpeningSupervisorComment,
							loanOpeningSupervisorEmail, longTermLoans,
							maritalStatus, medicalAid, mobileNo, nationality,
							nextOfKinName, nextOfKinOccupation,
							nextOfKinEmployer, nextOfKinTelephoneNo,
							nextOfKinCellNo, noOfDependants, occupation,
							overdrafts, otherAccounts, otherAssets, otherDebts,
							otherIncome, otherDeduction, otherDeductions,
							inactivity, 0, pension, physicalAddress,
							physicalAddressType, postalAddress,
							previouslyAppliedforLoanwithSdsb,
							previousLoanBalances, previousBranch,
							previousLoanType, property, providentFund,
							referenceName1, referenceName2, referenceName3,
							referenceName1PhysicalAddress,
							referenceName2PhysicalAddress,
							referenceName3PhysicalAddress,
							referenceName1TelephoneNo,
							referenceName2TelephoneNo,
							referenceName3TelephoneNo, registryOfficerComment,
							registryrOfficerCommentDate, registryrOfficerName,
							registryOfficerEmail, rent, repaymentPeriod, null,
							savings, securities1, securities2, securities3,
							securities4, securitiesSupervisorComment,
							securitiesSupervisorCoomentDate,
							securitiesSupervisorEmail,
							securitiesSupervisorName,
							securitiesDocumentLocation,
							securitiesDocumentUploadDate, tax, taxIdentity,
							telelephoneNo, surplus, surplusLiabilities, water));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		request.setAttribute("branchPersonalLoanList", branchPersonalLoanList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/tehcnicalResources_loanTracking/branchPersonalLoanTrackingLoanDisbursedStatus.jsp");
		view.forward(request, response);

		try {
			ConnectionHelper.disconnect(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
