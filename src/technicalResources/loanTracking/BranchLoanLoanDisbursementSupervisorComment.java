package technicalResources.loanTracking;

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
 * Servlet implementation class LoanTrackingLogin
 */
@WebServlet("/BranchLoanLoanDisbursementSupervisorComment")
public class BranchLoanLoanDisbursementSupervisorComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// /////////////date insert///////////////////
		Date dateModifiedN = new Date();
		String dateModified = sdf.format(dateModifiedN);
		// /////////////date insert///////////////////

		String administationFee = String.valueOf(request
				.getParameter("administationFee"));

		String applicantBankName = request.getParameter("applicantBankName");
		String applicantBankBranch = request
				.getParameter("applicantBankBranch");
		String applicantBankAccountNumber = request
				.getParameter("applicantBankAccountNumber");
		String applicantName = request.getParameter("applicantName");
		String applicantDistrict = request.getParameter("applicantDistrict");
		String applicantHomeArea = request.getParameter("applicantHomeArea");
		String applicantNearestShop_school = request
				.getParameter("applicantNearestShop_school");
		String applicantChief = request.getParameter("applicantChief");
		String applicantIndvuna = request.getParameter("applicantIndvuna");
		String applicantRunner = request.getParameter("applicantRunner");
		String bankExecutioner = request.getParameter("bankExecutioner");
		String bankExecutionerCapacity = request
				.getParameter("bankExecutionerCapacity");
		String basicSalary = String
				.valueOf(request.getParameter("basicSalary"));
		String branchAdress = request.getParameter("branchAdress");
		String branch = request.getParameter("branch");
		String branchManagerComment = request
				.getParameter("branchManagerComment");

		String branchManagerName = request.getParameter("branchManagerName");
		String branchManagerEmail = request.getParameter("branchManagerEmail");
		String businessConsultantName = request
				.getParameter("businessConsultantName");

		String businessConsultantComment = request
				.getParameter("businessConsultantComment");
		String businessConsultantCommentDate = request
				.getParameter("businessConsultantCommentDate");

		String businessConsultantEmail = request
				.getParameter("businessConsultantEmail");
		String cashAtBank = String.valueOf(request.getParameter("cashAtBank"));
		String cif = request.getParameter("cif");
		String creditAnalystComment = request
				.getParameter("creditAnalystComment");
		String creditAnalystCommentDate = request
				.getParameter("creditAnalystCommentDate");
		String creditAnalystName = request.getParameter("creditAnalystName");
		String creditAnalystEmail = request.getParameter("creditAnalystEmail");
		String creditManagerCommentDate = dateModified;
		String creditManagerName = request.getParameter("creditManagerName");
		String creditManagerEmail = request.getParameter("creditManagerEmail");
		String creditManagerComment = request
				.getParameter("creditManagerComment");

		String dateOfBirth = request.getParameter("dateOfBirth");
		String dateOfFirstInstallment = request
				.getParameter("dateOfFirstInstallment");
		String dateOfLastInstallment = request
				.getParameter("dateOfLastInstallment");
		String deficiency = String.valueOf(request.getParameter("deficiency"));
		String debtorsName1 = request.getParameter("debtorsName1");
		String debtorsName2 = request.getParameter("debtorsName2");
		String debtorsName3 = request.getParameter("debtorsName3");
		String debtorsName4 = request.getParameter("debtorsName4");
		String debtorsName1Amount = String.valueOf(request
				.getParameter("debtorsName1Amount"));
		String debtorsName2Amount = String.valueOf(request
				.getParameter("debtorsName2Amount"));
		String debtorsName3Amount = String.valueOf(request
				.getParameter("debtorsName3Amount"));
		String debtorsName4Amount = String.valueOf(request
				.getParameter("debtorsName4Amount"));
		String disbursedAmount = request.getParameter("disbursedAmount");
		String disbursementDate = request.getParameter("disbursementDate");
		String emailAddress = request.getParameter("emailAddress");
		String employerName = request.getParameter("employerName");
		String employerAddress = request.getParameter("employerAddress");
		String employerPhysicalAddress = request
				.getParameter("employerPhysicalAddress");
		String employerTelephoneNo = request
				.getParameter("employerTelephoneNo");
		String employementTerms = request.getParameter("employementTerms");
		String employementPeriod = request.getParameter("employementPeriod");
		String electricity = String
				.valueOf(request.getParameter("electricity"));
		String establishmentFee = String.valueOf(request
				.getParameter("establishmentFee"));
		String fixedDeposit = String.valueOf(request
				.getParameter("fixedDeposit"));
		String food = String.valueOf(request.getParameter("food"));
		String furnitureCars = String.valueOf(request
				.getParameter("furnitureCars"));
		String iDNumber = request.getParameter("iDNumber");
		// String instalment =
		// String.valueOf(request.getParameter("instalment"));
		String insurances = String.valueOf(request.getParameter("insurances"));
		String insurancesBalance = String.valueOf(request
				.getParameter("insurancesBalance"));
		String interestRate = String.valueOf(request
				.getParameter("interestRate"));

		String levelTermInsurancePremiumAmount = String.valueOf(request
				.getParameter("levelTermInsurancePremiumAmount"));
		String loans = String.valueOf(request.getParameter("loans"));

		String loanAmount = String.valueOf(request.getParameter("loanAmount"));

		String loanAmountWords = request.getParameter("loanAmountWords");
		String loanOpeningSupervisorName = request
				.getParameter("loanOpeningSupervisorName");
		
		
		String longTermLoans = String.valueOf(request
				.getParameter("longTermLoans"));
		String maritalStatus = request.getParameter("maritalStatus");
		String medicalAid = String.valueOf(request.getParameter("medicalAid"));
		String mobileNo = request.getParameter("mobileNo");
		String nationality = request.getParameter("nationality");
		String nextOfKinName = request.getParameter("nextOfKinName");
		String nextOfKinOccupation = request
				.getParameter("nextOfKinOccupation");
		String nextOfKinEmployer = request.getParameter("nextOfKinEmployer");
		String nextOfKinTelephoneNo = request
				.getParameter("nextOfKinTelephoneNo");
		String nextOfKinCellNo = request.getParameter("bankExecutioner");
		String noOfDependants = request.getParameter("noOfDependants");
		String occupation = request.getParameter("occupation");
		String overdrafts = String.valueOf(request.getParameter("overdrafts"));
		String otherAccounts = String.valueOf(request
				.getParameter("otherAccounts"));
		String otherAssets = String
				.valueOf(request.getParameter("otherAssets"));
		String otherDebts = String.valueOf(request.getParameter("otherDebts"));
		String otherIncome = String
				.valueOf(request.getParameter("otherIncome"));
		String otherDeduction = String.valueOf(request
				.getParameter("otherDeduction"));
		String otherDeductions = String.valueOf(request
				.getParameter("otherDeductions"));
		// String outstandingLoanType =
		// request.getParameter("outstandingLoanType");
		// String outstandingLoanBalance =
		// String.valueOf(request.getParameter("outstandingLoanBalance"));
		String pension = String.valueOf(request.getParameter("pension"));
		String physicalAddress = request.getParameter("physicalAddress");
		String physicalAddressType = request
				.getParameter("physicalAddressType");
		String postalAddress = request.getParameter("postalAddress");
		String previouslyAppliedforLoanwithSdsb = request
				.getParameter("previouslyAppliedforLoanwithSdsb");
		String previousLoanBalances = String.valueOf(request
				.getParameter("previousLoanBalances"));
		String previousBranch = request.getParameter("previousBranch");
		String previousLoanType = request.getParameter("previousLoanType");
		String property = String.valueOf(request.getParameter("property"));
		String providentFund = String.valueOf(request
				.getParameter("providentFund"));
		String referenceName1 = request.getParameter("referenceName1");
		String referenceName2 = request.getParameter("referenceName2");
		String referenceName3 = request.getParameter("referenceName3");
		String referenceName1PhysicalAddress = request
				.getParameter("referenceName1PhysicalAddress");
		String referenceName2PhysicalAddress = request
				.getParameter("referenceName2PhysicalAddress");
		String referenceName3PhysicalAddress = request
				.getParameter("referenceName3PhysicalAddress");
		String referenceName1TelephoneNo = request
				.getParameter("referenceName1TelephoneNo");
		String referenceName2TelephoneNo = request
				.getParameter("referenceName2TelephoneNo");
		String referenceName3TelephoneNo = request
				.getParameter("referenceName3TelephoneNo");
		String registryOfficerComment = request
				.getParameter("registryOfficerComment");
		String registryrOfficerCommentDate = request
				.getParameter("registryrOfficerCommentDate");
		String registryrOfficerName = request
				.getParameter("registryrOfficerName");
		String registryOfficerEmail = request
				.getParameter("registryOfficerEmail");
		String rent = String.valueOf(request.getParameter("rent"));
		String repaymentPeriod = request.getParameter("repaymentPeriod");
		String savings = String.valueOf(request.getParameter("savings"));

		String securities1 = null;
		String securities2 = null;
		String securities3 = null;
		String securities4 = null;

		if (request.getParameter("securities1") == null) {
			securities1 = "yes";
		} else {
			securities1 = "no";
		}

		if (request.getParameter("securities2") == null) {
			securities2 = "yes";
		} else {
			securities2 = "no";
		}

		if (request.getParameter("securities3") == null) {
			securities3 = "yes";
		} else {
			securities3 = "no";
		}

		if (request.getParameter("securities4") == null) {
			securities4 = "yes";
		} else {
			securities4 = "no";
		}

		String securitiesSupervisorComment = request
				.getParameter("securitiesSupervisorComment");
		
		String securitiesSupervisorEmail = request
				.getParameter("securitiesSupervisorEmail");
		String securitiesSupervisorName = request
				.getParameter("securitiesSupervisorName");
		String securitiesDocumentLocation = request
				.getParameter("securitiesDocumentLocation");
		String securitiesDocumentUploadDate = request
				.getParameter("securitiesDocumentUploadDate");
		String tax = String.valueOf(request.getParameter("tax"));
		String taxIdentity = request.getParameter("taxIdentity");
		String telelephoneNo = request.getParameter("telelephoneNo");
		String surplus = String.valueOf(request.getParameter("surplus"));
		String surplusLiabilities = String.valueOf(request
				.getParameter("surplusLiabilities"));
		String water = String.valueOf(request.getParameter("water"));
		
		String disbursementAmount = String.valueOf(request.getParameter("disbursementAmount"));

		// /////latest updates///////
		String lastModifiedBy = branchManagerName;
		String lastModifiedDate = dateModified;
		String branchManagerCommentDate = dateModified;
		String loanStatus = "Loan Disbursed";
		String loanReference = request.getParameter("loanReference");
		String securitiesSupervisorCoomentDate = request
				.getParameter("securitiesSupervisorCoomentDate");
		String loanOpeningSupervisorEmail = request
				.getParameter("loanOpeningSupervisorEmail");
		
		String loanOpeningSupervisorCommentDate = dateModified;
		String loanOpeningSupervisorComment = request
				.getParameter("loanOpeningSupervisorComment");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {
			String sql = "UPDATE [dbo].[branchPersonalLoan] "
					+ "SET [administationFee] = '"
					+ administationFee
					+ "'"
					+ ",[applicantBankName] = '"
					+ applicantBankName
					+ "'"
					+ ",[applicantBankBranch] = '"
					+ applicantBankBranch
					+ "'"
					+ ",[applicantBankAccountNumber] = '"
					+ applicantBankAccountNumber
					+ "'"
					+ ",[applicantName] = '"
					+ applicantName
					+ "'"
					+ ",[applicantDistrict] = '"
					+ applicantDistrict
					+ "'"
					+ ",[applicantHomeArea] = '"
					+ applicantHomeArea
					+ "'"
					+ ",[applicantNearestShop_school] = '"
					+ applicantNearestShop_school
					+ "'"
					+ ",[applicantChief] = '"
					+ applicantChief
					+ "'"
					+ ",[applicantIndvuna] = '"
					+ applicantIndvuna
					+ "'"
					+ ",[applicantRunner] = '"
					+ applicantRunner
					+ "'"
					+ ",[bankExecutioner] = '"
					+ bankExecutioner
					+ "'"
					+ ",[bankExecutionerCapacity] = '"
					+ bankExecutionerCapacity
					+ "'"
					+ ",[basicSalary] = '"
					+ basicSalary
					+ "'"
					+ ",[branchAdress] = '"
					+ branchAdress
					+ "'"
					+ ",[branch] = '"
					+ branch
					+ "'"
					+ ",[branchManagerComment] = '"
					+ branchManagerComment
					+ "'"
					+ ",[branchManagerCommentDate] = '"
					+ branchManagerCommentDate
					+ "'"
					+ ",[branchManagerName] = '"
					+ branchManagerName
					+ "'"
					+ ",[branchManagerEmail] = '"
					+ branchManagerEmail
					+ "'"
					+ ",[businessConsultantName] = '"
					+ businessConsultantName
					+ "'"
					+ ",[businessConsultantComment] = '"
					+ businessConsultantComment
					+ "'"
					+ ",[businessConsultantCommentDate] = '"
					+ businessConsultantCommentDate
					+ "'"
					+ ",[businessConsultantEmail] = '"
					+ businessConsultantEmail
					+ "'"
					+ ",[cashAtBank] = '"
					+ cashAtBank
					+ "'"
					+ ",[cif] = '"
					+ cif
					+ "'"
					+ ",[creditAnalystComment] = '"
					+ creditAnalystComment
					+ "'"
					+ ",[creditAnalystCommentDate] = '"
					+ creditAnalystCommentDate
					+ "'"
					+ ",[creditAnalystName] = '"
					+ creditAnalystName
					+ "'"
					+ ",[creditAnalystEmail] = '"
					+ creditAnalystEmail
					+ "'"
					+ ",[creditManagerCommentDate] = '"
					+ creditManagerCommentDate
					+ "'"
					+ ",[creditManagerName] = '"
					+ creditManagerName
					+ "'"
					+ ",[creditManagerEmail] = '"
					+ creditManagerEmail
					+ "'"
					+ ",[creditManagerComment] = '"
					+ creditManagerComment
					+ "'"

					+ ",[dateOfBirth] = '"
					+ dateOfBirth
					+ "'"
					+ ",[dateOfFirstInstallment] = '"
					+ dateOfFirstInstallment
					+ "'"
					+ ",[dateOfLastInstallment] = '"
					+ dateOfLastInstallment
					+ "'"
					+ ",[deficiency] = '"
					+ deficiency
					+ "'"
					+ ",[debtorsName1] = '"
					+ debtorsName1
					+ "'"
					+ ",[debtorsName2] = '"
					+ debtorsName2
					+ "'"
					+ ",[debtorsName3] = '"
					+ debtorsName3
					+ "'"
					+ ",[debtorsName4] = '"
					+ debtorsName4
					+ "'"
					+ ",[debtorsName1Amount] = '"
					+ debtorsName1Amount
					+ "'"
					+ ",[debtorsName2Amount] = '"
					+ debtorsName2Amount
					+ "'"
					+ ",[debtorsName3Amount] = '"
					+ debtorsName3Amount
					+ "'"
					+ ",[debtorsName4Amount] = '"
					+ debtorsName4Amount
					+ "'"
					+ ",[disbursedAmount] = '"
					+ disbursedAmount
					+ "'"
					+ ",[disbursementDate] = '"
					+ disbursementDate
					+ "'"
					+ ",[emailAddress] = '"
					+ emailAddress
					+ "'"
					+ ",[employerName] = '"
					+ employerName
					+ "'"
					+ ",[employerAddress] = '"
					+ employerAddress
					+ "'"
					+ ",[employerPhysicalAddress] = '"
					+ employerPhysicalAddress
					+ "'"
					+ ",[employerTelephoneNo] = '"
					+ employerTelephoneNo
					+ "'"
					+ ",[employementTerms] = '"
					+ employementTerms
					+ "'"
					+ ",[employementPeriod] = '"
					+ employementPeriod
					+ "'"
					+ ",[electricity] = '"
					+ electricity
					+ "'"
					+ ",[establishmentFee] = '"
					+ establishmentFee
					+ "'"
					+ ",[fixedDeposit] = '"
					+ fixedDeposit
					+ "'"
					+ ",[food] = '"
					+ food
					+ "'"
					+ ",[furnitureCars] = '"
					+ furnitureCars
					+ "'"
					+ ",[iDNumber] = '"
					+ iDNumber
					+ "'"
					+ ",[insurances] = '"
					+ insurances
					+ "'"
					+ ",[insurancesBalance] = '"
					+ insurancesBalance
					+ "'"
					+ ",[interestRate] = '"
					+ interestRate
					+ "'"
					+ ",[lastModifiedBy] = '"
					+ lastModifiedBy
					+ "'"
					+ ",[lastModifiedDate] = '"
					+ lastModifiedDate
					+ "'"
					+ ",[levelTermInsurancePremiumAmount] = '"
					+ levelTermInsurancePremiumAmount
					+ "'"
					+ ",[loans] = '"
					+ loans
					+ "'"
					+ ",[loanStatus] = '"
					+ loanStatus
					+ "'"
					+ ",[loanAmount] = '"
					+ loanAmount
					+ "'"
					+ ",[loanAmountWords] = '"
					+ loanAmountWords
					+ "'"
					+ ",[loanOpeningSupervisorName] = '"
					+ loanOpeningSupervisorName
					+ "'"
					+ ",[loanOpeningSupervisorCommentDate] = '"
					+ loanOpeningSupervisorCommentDate
					+ "'"
					+ ",[loanOpeningSupervisorComment] = '"
					+ loanOpeningSupervisorComment
					+ "'"
					+ ",[loanOpeningSupervisorEmail] = '"
					+ loanOpeningSupervisorEmail
					+ "'"

					+ ",[longTermLoans] = '"
					+ longTermLoans
					+ "'"
					+ ",[maritalStatus] = '"
					+ maritalStatus
					+ "'"
					+ ",[medicalAid] = '"
					+ medicalAid
					+ "'"
					+ ",[mobileNo] = '"
					+ mobileNo
					+ "'"
					+ ",[nationality] = '"
					+ nationality
					+ "'"
					+ ",[nextOfKinName] = '"
					+ nextOfKinName
					+ "'"
					+ ",[nextOfKinOccupation] = '"
					+ nextOfKinOccupation
					+ "'"
					+ ",[nextOfKinEmployer] = '"
					+ nextOfKinEmployer
					+ "'"
					+ ",[nextOfKinTelephoneNo] = '"
					+ nextOfKinTelephoneNo
					+ "'"
					+ ",[nextOfKinCellNo] = '"
					+ nextOfKinCellNo
					+ "'"
					+ ",[noOfDependants] = '"
					+ noOfDependants
					+ "'"
					+ ",[occupation] = '"
					+ occupation
					+ "'"
					+ ",[overdrafts] = '"
					+ overdrafts
					+ "'"
					+ ",[otherAccounts] = '"
					+ otherAccounts
					+ "'"
					+ ",[otherAssets] = '"
					+ otherAssets
					+ "'"
					+ ",[otherDebts] = '"
					+ otherDebts
					+ "'"
					+ ",[otherIncome] = '"
					+ otherIncome
					+ "'"
					+ ",[otherDeduction] = '"
					+ otherDeduction
					+ "'"
					+ ",[otherDeductions] = '"
					+ otherDeductions
					+ "'"
					+ ",[pension] = '"
					+ pension
					+ "'"
					+ ",[physicalAddress] = '"
					+ physicalAddress
					+ "'"
					+ ",[physicalAddressType] = '"
					+ physicalAddressType
					+ "'"
					+ ",[postalAddress] = '"
					+ postalAddress
					+ "'"
					+ ",[previouslyAppliedforLoanwithSdsb] = '"
					+ previouslyAppliedforLoanwithSdsb
					+ "'"
					+ ",[previousBranch] = '"
					+ previousBranch
					+ "'"
					+ ",[previousLoanType] = '"
					+ previousLoanType
					+ "'"
					+ ",[previousLoanBalances] = '"
					+ previousLoanBalances
					+ "'"
					+ ",[property] = '"
					+ property
					+ "'"
					+ ",[providentFund] = '"
					+ providentFund
					+ "'"
					+ ",[referenceName1] = '"
					+ referenceName1
					+ "'"
					+ ",[referenceName2] = '"
					+ referenceName2
					+ "'"
					+ ",[referenceName3] = '"
					+ referenceName3
					+ "'"
					+ ",[referenceName1PhysicalAddress] = '"
					+ referenceName1PhysicalAddress
					+ "'"
					+ ",[referenceName2PhysicalAddress] = '"
					+ referenceName2PhysicalAddress
					+ "'"
					+ ",[referenceName3PhysicalAddress] = '"
					+ referenceName3PhysicalAddress
					+ "'"
					+ ",[referenceName1TelephoneNo] = '"
					+ referenceName1TelephoneNo
					+ "'"
					+ ",[referenceName2TelephoneNo] = '"
					+ referenceName2TelephoneNo
					+ "'"
					+ ",[referenceName3TelephoneNo] = '"
					+ referenceName3TelephoneNo
					+ "'"
					+ ",[registryOfficerComment] = '"
					+ registryOfficerComment
					+ "'"
					+ ",[registryrOfficerCommentDate] = '"
					+ registryrOfficerCommentDate
					+ "'"
					+ ",[registryrOfficerName] = '"
					+ registryrOfficerName
					+ "'"
					+ ",[registryOfficerEmail] = '"
					+ registryOfficerEmail
					+ "'"
					+ ",[rent] = '"
					+ rent
					+ "'"
					+ ",[repaymentPeriod] = '"
					+ repaymentPeriod
					+ "'"
					+ ",[savings] = '"
					+ savings
					+ "'"
					+ ",[securities1] = '"
					+ securities1
					+ "'"
					+ ",[securities2] = '"
					+ securities2
					+ "'"
					+ ",[securities3] = '"
					+ securities3
					+ "'"
					+ ",[securities4] = '"
					+ securities4
					+ "'"
					+ ",[securitiesSupervisorComment] = '"
					+ securitiesSupervisorComment
					+ "'"
					+ ",[securitiesSupervisorCoomentDate] = '"
					+ securitiesSupervisorCoomentDate
					+ "'"
					+ ",[securitiesSupervisorEmail] = '"
					+ securitiesSupervisorEmail
					+ "'"
					+ ",[securitiesSupervisorName] = '"
					+ securitiesSupervisorName
					+ "'"
					+ ",[securitiesDocumentLocation] = '"
					+ securitiesDocumentLocation
					+ "'"
					+ ",[securitiesDocumentUploadDate] = '"
					+ securitiesDocumentUploadDate
					+ "'"
					+ ",[tax] = '"
					+ tax
					+ "'"
					+ ",[taxIdentity] = '"
					+ taxIdentity
					+ "'"
					+ ",[telelephoneNo] = '"
					+ telelephoneNo
					+ "'"
					+ ",[surplus] = '"
					+ surplus
					+ "',[surplusLiabilities] = '"
					+ surplusLiabilities
					+ "'"
					+ ",[water] = '"
					+ water
					+ "' WHERE [loanReference] = '" + loanReference + "'";

			java.sql.PreparedStatement insertReportStatement = null;
			try {

				insertReportStatement = con.prepareStatement(sql,
						new String[] { "id" });

				insertReportStatement.executeUpdate();
				insertReportStatement.close();

				con.close();

				response.sendRedirect(request.getContextPath()
						+ "/BranchLoanTrackingStatus");
				String to = branchManagerName;
				String from = "staffLoanApplication@swazibank.co.sz";
				String host = "172.16.1.17";
				Properties properties = System.getProperties();
				properties.setProperty("mail.smtp.host", host);
				Session session = Session.getDefaultInstance(properties);
				response.setContentType("text/html");

				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));
					message.addRecipient(Message.RecipientType.TO,
							new InternetAddress(to));
					message.setSubject("Branch Loan Submitted by: "
							+ businessConsultantName
							+ " Requires your Attention");
					message.setText("Dear "
							+ branchManagerName

							+ "\n\n"
							+ "The Personal Loan Submitted by: "

							+ "  "
							+ businessConsultantName.toUpperCase()
							+ " with reference: "
							+ loanReference
							+ " has been disbursed with amount "+ disbursementAmount+"."
							+ "\nPlease Click on the link http://localhost:8080/SwaziBankIntranetLive/BranchLoanLoanDisbursementSupervisorRequest to comment."
							+ "\n\n"
							+ "This mail is Auto generated. Please Contact the Applicant on "
							+ creditManagerEmail
							+ " for additional Information." + "\n"
							+ "\n warm regards" + "\n IT Department");
					Transport.send(message);

				} catch (MessagingException mex) {
					mex.printStackTrace();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
				if (con != null) {
					try {
						ConnectionHelper.disconnect(con);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}
}
