package technicalResources.loanTracking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import util.ConnectionHelper;


@WebServlet("/BranchLoanSanctionsRequest")
public class BranchLoanSanctionsRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;

		ArrayList<String> pendingCreditManagerBranchLoanRequests = new ArrayList<String>();

		pendingCreditManagerBranchLoanRequests.clear();
		pendingCreditManagerBranchLoanRequests.add("Please select Loan reference in the email");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  *  FROM [SwaziBankIntranet2016].[dbo].[branchLoan] where  [loanStatus] = 'Pending Sanction and securities signing'";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String loanReference = results.getString("loanReference");

					pendingCreditManagerBranchLoanRequests.add(loanReference);
				}

				request.setAttribute("pendingCreditManagerBranchLoanRequests",
						pendingCreditManagerBranchLoanRequests);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/tehcnicalResources_loanTracking/branchPersonalLoanSecuritiesRequest.jsp");
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
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		DateTimeFormatter formatter1 = DateTimeFormatter
				.ofPattern("yyyy/MM/dd HH:mm:ss");
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		int loanPeriod = 0;
		Date startDate2 = null;
		Calendar cal = null;
		
		
		String day = null;
		String month = null;
		String year = null;
		Date date1 = null;
		
		int dayOne = 0;
		int monthOne = 0;
		int yearOne = 0;
		String monthOneV = null;
		

		Statement selectStatement = null;
		ResultSet results = null;

		String loanReference = request.getParameter("loanReference");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[branchLoan] where [loanReference] = '"+ loanReference + "'";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					
					float administationFee = results.getFloat("administationFee");
					float basicSalary = results.getFloat("basicSalary");
					float cashAtBank = results.getFloat("cashAtBank");
					float debtorsName1Amount = results.getFloat("debtorsName1Amount");
					float debtorsName2Amount = results.getFloat("debtorsName2Amount");
					float debtorsName3Amount = results.getFloat("debtorsName3Amount");
					float debtorsName4Amount = results.getFloat("debtorsName4Amount");
					float deficiency = results.getFloat("deficiency");
					float electricity = results.getFloat("electricity");
					float initiationFee = results.getFloat("initiationFee");
					float fixedDeposit = results.getFloat("fixedDeposit");
					float food = results.getFloat("food");
					float foodBudget = results.getFloat("foodBudget");
					float furnitureCars = results.getFloat("furnitureCars");
					float instalment = results.getFloat("instalment");
					float insurances = results.getFloat("insurances");
					float insurancesBalance = 0;
					float insurancesBudget = results.getFloat("insurancesBudget");
					float interestRate = results.getFloat("interestRate");
					float levelTermInsurancePremiumAmount = results.getFloat("levelTermInsurancePremiumAmount");
					float loanAmount = results.getFloat("loanAmount");
					Double loanAmount1 = Double.valueOf(loanAmount);
					float loanAmountDisbursed = 0;
					float loans = results.getFloat("loans");
					float loansBudget = results.getFloat("loansBudget");
					float longTermLoans = results.getFloat("longTermLoans");
					float medicalAid = results.getFloat("medicalAid");
					float otherAccounts = results.getFloat("otherAccounts");
					float otherAssets = results.getFloat("otherAssets");
					float otherDebts = results.getFloat("otherDebts");
					float otherDeductionBudget = results.getFloat("otherDeductionBudget");
					float otherDeductions = results.getFloat("otherDeductions");
					float otherIncome = results.getFloat("otherIncome");
					float outstandingLoanBalance = 0;
					float overdrafts = results.getFloat("overdrafts");
					float pension = results.getFloat("pension");
					float previousLoanBalances = results.getFloat("previousLoanBalances");
					float property = results.getFloat("property");
					float providentFund = results.getFloat("providentFund");
					float rent = results.getFloat("rent");
					float savings = results.getFloat("savings");
					float surplus = results.getFloat("surplus");
					float surplusLiabilities = results.getFloat("surplusLiabilities");
					float tax = results.getFloat("tax");
					float water = results.getFloat("water");
					float waterBudget = results.getFloat("waterBudget");
					int noOfDependants = results.getInt("noOfDependants");
					int repaymentPeriod = results.getInt("repaymentPeriod");
					String applicantBankAccountNumber = results.getString("applicantBankAccountNumber");
					String applicantBankBranch = results.getString("applicantBankBranch");
					String applicantBankName = results.getString("applicantBankName");
					String applicantChief = results.getString("applicantChief");
					String applicantDistrict = results.getString("applicantDistrict");
					String applicationDay= results.getString("applicationDay");
					String applicationMonth =results.getString("applicationMonth");
					String applicationYear = results.getString("applicationYear");
					String applicantHomeArea = results.getString("applicantHomeArea");
					String applicantIndvuna = results.getString("applicantIndvuna");
					String applicantName = results.getString("applicantName");
					String applicantNearestShop_school = results.getString("applicantNearestShop_school");
					String applicantRunner = results.getString("applicantRunner");
					String applicationLoanRef = results.getString("applicationLoanRef");
					String bankExecutioner = results.getString("bankExecutioner");
					String bankExecutionerCapacity = results.getString("bankExecutionerCapacity");
					String branch = results.getString("branch");
					String branchAdress = results.getString("branchAdress");
					String branchManagerComment = results.getString("branchManagerComment");
					String branchManagerCommentDate = results.getString("branchManagerCommentDate");
					String branchManagerEmail = results.getString("branchManagerEmail");
					String branchManagerName = results.getString("branchManagerName");
					String branchManagerSecuritiesComment = results.getString("branchManagerSecuritiesComment");
					String branchManagerSecuritiesCommen = null;
					String businessConsultantComment = results.getString("businessConsultantComment");
					String businessConsultantCommentDate = results.getString("businessConsultantCommentDate");
					String businessConsultantEmail = results.getString("businessConsultantEmail");
					String businessConsultantName = results.getString("businessConsultantName");
					String cif = results.getString("cif");
					String copyOfConcifirmationLetter = results.getString("copyOfConcifirmationLetter");
					String copyOfId = results.getString("copyOfId");
					String copyOfItcReport = results.getString("copyOfItcReport");
					String copyOfPaySlip = results.getString("copyOfPaySlip");
					String creditAnalystComment = results.getString("creditAnalystComment");
					String creditAnalystCommentDate = results.getString("creditAnalystCommentDate");
					String creditAnalystEmail = results.getString("creditAnalystEmail");
					String creditAnalystName = results.getString("creditAnalystName");
					String creditManagerComment = results.getString("creditManagerComment");
					String creditManagerCommentDate = results.getString("creditManagerCommentDate");
					String creditManagerEmail = results.getString("creditManagerEmail");
					String creditManagerName = results.getString("creditManagerName");
					String currentLoanBalances = results.getString("currentLoanBalances");
					String currentLoans = results.getString("currentLoans");
					String dateCreated = results.getString("dateCreated");
					String dateOfBirth = results.getString("dateOfBirth");
					String dateOfFirstInstallment = results.getString("dateOfFirstInstallment");
					String dateOfLastInstallment = results.getString("dateOfLastInstallment");
					String debtorsName1 = results.getString("debtorsName1");
					String debtorsName2 = results.getString("debtorsName2");
					String debtorsName3 = results.getString("debtorsName3");
					String debtorsName4 = results.getString("debtorsName4");
					String disbursementDate = results.getString("disbursementDate");
					String employementPeriod = results.getString("employementPeriod");
					String employementTerms = results.getString("employementTerms");
					String employerAddress = results.getString("employerAddress");
					String employerName = results.getString("employerName");
					String employerPhysicalAddress = results.getString("employerPhysicalAddress");
					String employerTelephoneNo = results.getString("employerTelephoneNo");
					String iDNumber = results.getString("iDNumber");
					String inactivity = results.getString("inactivity");
					String lastDateModified = results.getString("lastDateModified");
					String lastModifiedBy = results.getString("lastModifiedBy");
					String lastModifiedDate = results.getString("lastModifiedDate");
					String loanAmountApplied = results.getString("loanAmountApplied");
					String loanAmountWords = results.getString("loanAmountWords");
					String loanOpeningSupervisorComment = results.getString("loanOpeningSupervisorComment");
					String loanOpeningSupervisorCommentDate = results.getString("loanOpeningSupervisorCommentDate");
					String loanOpeningSupervisorEmail = results.getString("loanOpeningSupervisorEmail");
					String loanOpeningSupervisorName = results.getString("loanOpeningSupervisorName");
					String loanStatus = results.getString("loanStatus");
					String loanType = results.getString("loanType");
					String maritalStatus = results.getString("maritalStatus");
					String mobileNo = results.getString("mobileNo");
					String nationality = results.getString("nationality");
					String nextOfKinCellNo = results.getString("nextOfKinCellNo");
					String nextOfKinEmployer = results.getString("nextOfKinEmployer");
					String nextOfKinName = results.getString("nextOfKinName");
					String nextOfKinOccupation = results.getString("nextOfKinOccupation");
					String nextOfKinTelephoneNo = results.getString("nextOfKinTelephoneNo");
					String occupation = results.getString("occupation");
					String Other1 = results.getString("Other1");
					String Other2 = results.getString("Other2");
					String Other3 = results.getString("Other3");
					String Other4 = results.getString("Other4");
					String Other5 = results.getString("Other5");
					
					String otherAccountsBudget = results.getString("otherAccountsBudget");
					String physicalAddress = results.getString("physicalAddress");
					String physicalAddressType = results.getString("physicalAddressType");
					String postalAddress = results.getString("postalAddress");
					String previousBranch = results.getString("previousBranch");
					String previousLoanType = results.getString("previousLoanType");
					String previouslyAppliedforLoanwithSdsb = results.getString("previouslyAppliedforLoanwithSdsb");
					String referenceName1 = results.getString("referenceName1");
					String referenceName1PhysicalAddress = results.getString("referenceName1PhysicalAddress");
					String referenceName1TelephoneNo = results.getString("referenceName1TelephoneNo");
					String referenceName2 = results.getString("referenceName2");
					String referenceName2PhysicalAddress = results.getString("referenceName2PhysicalAddress");
					String referenceName2TelephoneNo = results.getString("referenceName2TelephoneNo");
					String referenceName3 = results.getString("referenceName3");
					String referenceName3PhysicalAddress = results.getString("referenceName3PhysicalAddress");
					String referenceName3TelephoneNo = results.getString("referenceName3TelephoneNo");
					String registryOfficerComment = results.getString("registryOfficerComment");
					String registryOfficerEmail = results.getString("registryOfficerEmail");
					String registryrOfficerCommentDate = results.getString("registryrOfficerCommentDate");
					String registryrOfficerName = results.getString("registryrOfficerName");
					String resAddress = results.getString("resAddress");
					String securitiesDocumentLocation = results.getString("securitiesDocumentLocation");
					String securitiesDocumentUploadDate = results.getString("securitiesDocumentUploadDate");
					String securitiesSupervisorComment = results.getString("securitiesSupervisorComment");
					String securitiesSupervisorCommentDate = results.getString("securitiesSupervisorCommentDate");
					String securitiesSupervisorEmail = results.getString("securitiesSupervisorEmail");
					String securitiesSupervisorName = results.getString("securitiesSupervisorName");
					String SecurityLink = results.getString("SecurityLink");
					String SecurityUploadDate = results.getString("SecurityUploadDate");
					String taxIdentity = results.getString("taxIdentity");
					String telelephoneNo = results.getString("telelephoneNo");
					
					
					
					
					
					

					
					// //////////////////////////////////////////

					Font blackFont1 = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL);
					Font blackFont = FontFactory.getFont(FontFactory.HELVETICA,	7, Font.NORMAL);
					Font blackFont2 = FontFactory.getFont(FontFactory.HELVETICA,7, Font.BOLD);
					Font blackFontListHeading = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Font.NORMAL);
					
					Font blackFontListHeading1 = FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.NORMAL);

					Font blackFontParameter1 = FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD);

					Font blackFontParameter12 = FontFactory.getFont(
							FontFactory.HELVETICA, 7, Font.UNDERLINE);

					Font blackFontParameterRed = FontFactory.getFont(
							FontFactory.TIMES_BOLD, 13, Font.NORMAL);
					
					
					Font blackFontParameter = FontFactory.getFont(
							FontFactory.TIMES_BOLD, 12, Font.NORMAL);
					

					Font blackFontSetOff = FontFactory.getFont(
							FontFactory.HELVETICA, 10, Font.NORMAL);

					

					Document document = new Document();

					try {

						response.setContentType("application/pdf");
						PdfWriter.getInstance(document,	response.getOutputStream());
						
						document.open();

						Image img = Image.getInstance("C:/IntranetWarehouse/StaffLoan/logo/logo.png");
						
						
						Paragraph docHeadingOne = new Paragraph(
								"Date of Loan Creation:   " + dateCreated
										, blackFontParameter);
						Paragraph docHeadingTwo = new Paragraph(
								"Branch Manager:   " + branchManagerName,
								blackFontParameter);

						Paragraph docHeadingThree = new Paragraph("CSSO:   "
								+ businessConsultantName, blackFontParameter);
						Paragraph docHeadingFour = new Paragraph("Branch:   "
								+ branch, blackFontParameter);

						Paragraph docHeadingFive = new Paragraph(applicantName,
								blackFontParameter);

						Paragraph docHeadingSix = new Paragraph(
								"Thus Done at  " + branch + " and dated this "
										+ applicationDay + " day of " + applicationMonth + " " + applicationYear,
								blackFontParameter);

						Paragraph docHeadingSeven = new Paragraph(
								"\n\n\n"
										+ " __________________________                    ________________________________\n"
										+ "     For the Bank                                          As Witness\n\n\n",
								blackFontParameter);

						Paragraph offerLetterParagraph3 = new Paragraph(
								"Location:  " + branch, blackFontParameterRed);

						Paragraph offerLetterParagraph2 = new Paragraph(
								"Dated Created:   " + dateCreated,
								blackFontParameter);

						Paragraph offerLetterParagraph31 = new Paragraph(
								"Location:  " + branch, blackFontParameterRed);

						Paragraph overallSignature = new Paragraph(
								"\nThis agreement is executed at:\nundersigned witness:\n\n\n"
										+ " __________________________                    ________________________________\n"
										+ "     For the Bank                                          As Witness\n\n\n"
										+ " __________________________                    ________________________________\n"
										+ "    The Borrower/For the Borrower                          As Witness\n"
										+ "COMPANY STAMP\n"
										+ "(Where relevant)                                         (All pages to be initialled) ",
								blackFontSetOff);
						
						
						
						// //SANCTION//////
						
						document.newPage();
						document.add(img);
						
						Phrase sanction = new Phrase();
						sanction.add(new Chunk("\nMEMORANDUM ",blackFontListHeading));	
						
						sanction.add(new Chunk("\n\nTO:"+ " "+ " "+ " ",blackFontSetOff));	
						
						sanction.add(new Chunk("MANAGER :"+ " "+ " "+ " ",blackFontSetOff));	
						sanction.add(new Chunk(branch,blackFontSetOff));	

						sanction.add(new Chunk("\n\nFROM:"+ " "+ " "+"MANAGER CREDIT",blackFontSetOff));

						sanction.add(new Chunk("\n\nDATE:    ",blackFontSetOff));	
						
						sanction.add(new Chunk(applicationDay+ " "+applicationMonth+" "+applicationYear,blackFontSetOff));

						sanction.add(new Chunk("\n\nBORROWER:"+ " "+ " "+ " ",blackFontSetOff));	
						
						sanction.add(new Chunk(applicantBankName+ " "+ " ",blackFontSetOff));	
						
						sanction.add(new Chunk("CIF :" + cif,blackFontSetOff));

						sanction.add(new Chunk("\n\nFACILITY/TYPE:	  "+loanType,blackFontSetOff));	
						
						

						sanction.add(new Chunk("\n\nAmount create new field for total amount  ",blackFontSetOff));	
						
						sanction.add(new Chunk("Rate"+" "+ interestRate+ " ",blackFontSetOff));	
						
						sanction.add(new Chunk("Repayment create new field for total repayment ",blackFontSetOff));	
						
						sanction.add(new Chunk("Expiry Date"+" "+dateOfLastInstallment,blackFontSetOff));

						sanction.add(new Chunk("\n\nDECISION:	create new field for decision",blackFontListHeading));

						sanction.add(new Chunk("\n\nPERIOD:	     ",blackFontSetOff));	
						
						sanction.add(new Chunk("	12 Months",blackFontSetOff));

						sanction.add(new Chunk("\n\nNEXT REVIEWABLE DATE:	 ",blackFontListHeading));	
						
						sanction.add(new Chunk("	create new date for reviwable date",blackFontSetOff));

						sanction.add(new Chunk("\n\nPURPOSE OF LOAN:	  ",blackFontListHeading));	
						
						sanction.add(new Chunk("	create new field for purpose.",blackFontSetOff));

						sanction.add(new Chunk("\nSECURITY:",blackFontSetOff));	
						sanction.add(new Chunk("\n1)	Stop order from salary account",blackFontSetOff));
						sanction.add(new Chunk("\n2)	General pledge ",blackFontSetOff));
						sanction.add(new Chunk("\n3)	Level Term Insurance Policy",blackFontSetOff));
						sanction.add(new Chunk("\n4)	Cession over Target Savings to be increased by E135.00 monthly",blackFontSetOff));

						sanction.add(new Chunk("\n\nAny security held now, or at any future time, shall be security for all liabilities of the borrower to the Bank. Security currently held and or that is required for the above loan is as listed above.",blackFontListHeading));

						sanction.add(new Chunk("\nCONDITIONS:",blackFontSetOff));
						sanction.add(new Chunk("\n1)	Disbursement must be effected upon perfection of securities.",blackFontSetOff));
						sanction.add(new Chunk("\n2)	Collect applicable charges.",blackFontSetOff));
						sanction.add(new Chunk("\n3)	Account should be closely monitored.",blackFontSetOff));



						sanction.add(new Chunk("\n\nE.T. DLAMINI",blackFontSetOff));
						sanction.add(new Chunk("\nMANAGER CREDIT  ",blackFontSetOff));

						document.add(sanction);
						
						

						document.newPage();
						document.add(img);
						
						Phrase loaHeader = new Phrase();
						loaHeader.add(new Chunk("\nLETTER OF OFFER AND ACCEPTANCE ",blackFontListHeading));	
						document.add(loaHeader);

						PdfPTable loa = new PdfPTable(2);
						loa.setWidthPercentage(100);
						loa.setHorizontalAlignment(Element.ALIGN_LEFT);
						loa.setWidths(new int[] { 5, 5 });
						loa.getDefaultCell().setBorder(Rectangle.NO_BORDER);

						Phrase loa1 = new Phrase();
						loa1.add(new Chunk(dateCreated + " "+ branch ,blackFontParameter12));
						loa1.add(new Chunk(	"\n\nBetween:", blackFont1));

						loa1.add(new Chunk("Eswatini Development and Savings Bank", blackFontParameter12));

						loa1.add(new Chunk("\n\n(herein after referred to as “Eswatini Bank” or “the Bank”)", blackFont1));

								loa1.add(new Chunk("\nAND\n", blackFont1));

						loa1.add(new Chunk(applicantName+" " + postalAddress, blackFontParameter12));

						loa1.add(new Chunk("\n(Hereinafter referred to as “the Borrower”)"
										+ "\n\nReference is made to your application dated ",
								blackFont1));
						loa1.add(new Chunk(dateCreated,	blackFontParameter12));
						loa1.add(new Chunk(
								" in response to which the Bank is pleased to offer you a finance facility of ",
								blackFont1));
						loa1.add(new Chunk("EMALANGENI " + loanAmountWords
								+ " Only (E" + loanAmount,
								blackFontParameter12));
						loa1.add(new Chunk(
								") upon the terms and conditions stipulated hereunder and further subject to the terms and conditions contained in the Finance Facility Agreement and the Finance Facility security documents annexed hereto.  		"
										+ "\n\nIf you decide to accept this offer, kindly append your signature in the space provided hereunder and return it promptly to Eswatini Bank.		",
								blackFont1));
						loa1.add(new Chunk(
								"\n\n1. DECLARATION AND ACKNOWLEDGEMENT BY THE BORROWER ",
								blackFontParameter1));
						loa1.add(new Chunk(
								"\n\n1.1.	The Borrower is aware that all the Bank’s rights in this offer, including rights of ownership in any movable or immovable assets that may be pledged as security for the borrower’s indebtedness to the Bank will remain with the Bank until the last installment of the Finance Facility Agreement has been paid in full."
										+ "\n\n1.2.	In contemplation thereof the Borrower :	"
										+ "\n\n1.2.1	Agrees to recognize EswatiniBank as the owner of the immovable assets, movable goods/ equipment as declared in paragraph 1.1 above.\n\n1.2.2	Warrants that prior to the Borrower signing the main agreement hereto, all particulars and facts already furnished by the Borrower to the Bank are true and correct."
										+ "\n\n1.2.3	Confirms that the finance facility the Borrower signs for herein constitutes and fits the purpose for which the borrower requires it.\n\n1.2.4	Declares that prior to signing this offer, no benefits not recorded herein were offered, given or promised by the Bank, or any official of the Bank, either directly or indirectly as an inducement to accept this offer.",
								blackFont1));
						
						loa1.add(new Chunk(
								"1.2.5	Warrants that the initiative in connection with this transaction and the signing and acceptance of this offer emanated from the Borrower voluntarily and without any duress or undue influence.								"
										+ "\n\n1.2.6	Warrants further that the Borrower shall sign all relevant documents including, but not limited to the main agreement, security documents and schedules relating to this transaction prior to the disbursement of funds.",
								blackFont1));
						loa1.add(new Chunk(
								"\n\n2. PURPOSE OF THE FACILITY OFFERED BY THE BANK",
								blackFontParameter1));
						loa1.add(new Chunk(
								"\n\nThe Finance Facility is granted to the Borrower for the purpose of  "+ loanType +". (The facility type will not necessarily be determined by its purpose)",
								blackFont1));
						
						loa1.add(new Chunk("\n\n3. DURATION OF THE FACILITY",blackFontParameter1));
						loa1.add(new Chunk("\n\nThe Finance Facility shall be repaid by the Borrower over a period of ",blackFont1));
						loa1.add(new Chunk(repaymentPeriod +" MONTHS",blackFontParameter1));
						loa1.add(new Chunk(" commencing from  ",blackFont1));
						loa1.add(new Chunk(dateOfFirstInstallment,blackFontParameter1));
						loa1.add(new Chunk(" or from the date of signing the finance facility Agreement and to Expire on ",blackFont1));
						loa1.add(new Chunk(dateOfLastInstallment,	blackFontParameter1));
						
						loa.addCell(loa1);

						Phrase loa2 = new Phrase();
						
						loa2.add(new Chunk("\n\n4. INTEREST & RATE",
								blackFontParameter1));
						loa2.add(new Chunk(
								"\n\nThe Finance Facility shall bear Interest which shall be linked to prime as determined from time to time by the Bank subject to the initial interest rate of "+interestRate  +"  per annum.",
								blackFont1));
						loa2.add(new Chunk("\n\n5. REPAYMENT",
								blackFontParameter1));
						loa2.add(new Chunk(
								"\n\nThe Finance Facility shall be repaid to the Bank in the following manner (E.g. Whether by a lump sum, by",
								blackFont1));
						loa2.add(new Chunk("  E " + instalment,blackFontParameter1));
						loa2.add(new Chunk(" per Month Effective  ", blackFont1));
						loa2.add(new Chunk("\n\n on " + dateOfFirstInstallment,
								blackFontParameter1));
						loa2.add(new Chunk(
								"  Unitl Loan is Fully Paid."
										+ "\n\nThe Borrower agrees that this offer may require the Borrower to facilitate repayments by means of authorizing a standing debit order against the Borrower’s account, whether it be held with the Bank or another institution. The Borrower further undertakes not to alter or nullify such debit instruction without the written approval of the Bank.",
								blackFont1));
						loa2.add(new Chunk("\n\n6. REQUIRED SECURITY",
								blackFontParameter1));
						loa2.add(new Chunk(
								"\n\nAs part of the requirements of the Finance Facility Agreement, the Borrower hereby offers the following items as the Bank’s security for the requested facility",
								blackFont1));
						loa2.add(new Chunk(
								"\n\ni.	LEVEL TERM INSURANCE POLICY",
								blackFontParameter1));
						loa2.add(new Chunk(
								"\nii.	STOP ORDER OVER SALARY FROM SOURCE ",
								blackFontParameter1));
						loa2.add(new Chunk("\niii.	GENERAL PLEDGE ",
								blackFontParameter1));
						loa2.add(new Chunk("\niv.	CESSION OVER TARGET SAVINGS TO BE INCREASED BY E" +loanAmount*(5/100)+" MONTHLY",
								blackFontParameter1));
						loa2.add(new Chunk("7. CONDITIONS PRECEDENT",
								blackFontParameter1));
						loa2.add(new Chunk(
								"\n\n7.1 Notwithstanding anything to the contrary in this agreement, the Borrower shall not be entitled to draw on the facility offered unless and until the required security has been furnished and perfected to the satisfaction of the Bank."
								,blackFont1));
						loa2.add(new Chunk("\n\n8. OTHER TERMS",
								blackFontParameter1));
						loa2.add(new Chunk(
								"\n\n8.1	Disbursement of funds is further subject to approval by the Bank’s Legal Department."
								+ "\n\n8.2	The Bank reserves the right to withdraw this offer without notice to the Borrower if in its view the security pledged by the Borrower is insufficient or on grounds of change in circumstances of the borrower."
								+ "\n\n8.3	The Bank reserves the right to consider the outstanding portion of the loan to be due and payable by the Borrower on demand at any time."
								+ "\n\n8.4	This Finance Facility is subject to further terms & conditions per the Finance Facility Agreement document and related security documents."
								+ "\n\n8.5	All insurance premiums, municipal rates and taxes and all other expenses and charges which the Bank considers necessary or desirable to be disbursed for the preservation, repair and maintenance of the security provided, shall be for the Borrower’s account and shall be repayable to the Bank on demand."
								+ "\n\n8.6	The Borrower recognizes the right of the Bank to seize any or all items offered as security and preserve them where it deems necessary, or  to employ interim service providers to take care of the security pending resolution of  any issues in court or any other forum. The costs for such preservation of the security shall be borne by the Borrower through debit to his/her/its account by the bank.",blackFont1));
								
						loa.addCell(loa2);
						Phrase loa3 = new Phrase();
								
								loa3.add(new Chunk("8.7	The Bank shall be entitled to withdraw this offer if it  is not accepted or if the Borrower does not place the Bank in a position to lodge and perfect the security offered within thirty days (30) days from the date of  issue hereof."
								,blackFont1));
								loa3.add(new Chunk("\n\n9. COSTS",
								blackFontParameter1));
								loa3.add(new Chunk(
								"\n\nThe Borrower agrees that in the event of foreclosure of the Finance  Facility, for whatever reason(s), the Borrower shall be liable for all costs including legal costs at attorney and own client scale, collection commission, valuation costs, recovery costs, tracing costs, and all other related costs, charges and expenses.",
								blackFont1));
					
								loa3.add(new Chunk(
								"10. REPRESENTATION AND WARRANTIES",
								blackFontParameter1));
								loa3.add(new Chunk(
								"\n\nThe Borrower represents and warrants that his/her /its/their acceptance of the terms and conditions of this offer has been duly authorized and does not contravene any law and that there is no material litigation or similar proceedings, to the knowledge of the borrower presently pending or threatened which would have adverse effect on the assets or business of the borrower.\n\nI/We the undersigned do hereby acknowledge that I/we have read and understood to our/my satisfaction the above conditions, which I /we accept wholly, freely and voluntarily. I further confirm that the information furnished to the Bank is true and correct in every respect.   I/We undertake to produce and/or sign all documentation as may be required to complete the security. I/we further authorize the opening of a Finance Facility account in my / our name for the purpose of servicing this facility."
								,blackFont1));
								loa3.add(new Chunk("\n\n---------------------------------------- -------------------------------------                   SIGNATURE                                       DATE                                                     \n\n(AUTHORISED BANK REPRESENTATIVE)\n\n---------------------------------------------------------------------	       SIGNATURE	(BORROWER)			\n\n………………………………………………………\n\nCOMPANY STAMP (WHERE NECESSARY)",
								blackFontParameter1));
								
								/////////////////irrevocable pledge/////////////////

								loa3.add(new Chunk("\n\nIRREVOCABLE PLEDGE\n\n", blackFontListHeading));
								loa3.add(new Chunk("In consideration of credit facilities having been afforded to myself by Eswatini Development and Eswatini Bank , at my own special request and instance and on the terms and conditions set out in the loan documents, I  the undersigned ",blackFont1));
								loa3.add(new Chunk("\n"+applicantName+"\n\n", blackFontParameter12));
								loa3.add(new Chunk("\n\ndo hereby irrevocably consent and authorize the said Eswatini  Bank or any subsequent employer to deduct all monthly installments payable by myself in respect of the said credit facilities from my salary and pay such amounts  into my loan account/ accounts until all monies due from me in respect of the credit facility/ facilities have been fully paid to Eswatini Bank. I further authorize the Bank to appropriate and or commute, fully or in part, any other contractual benefits that may accrue to me upon retirement or termination prior to retirement as much as I hereby cede, assign and surrender to the Bank all my right, title and interest in moneys standing to the credit of all accounts held in my name by the Bank in order to redeem any outstanding balance owing by myself on the afforded credit facilities.",blackFont1));
								
										loa3.add(new Chunk("\n\n---------------------------------------- -------------------------------------                   SIGNATURE                                       DATE                                                     \n\n(AUTHORISED BANK REPRESENTATIVE)\n\n---------------------------------------------------------------------	       SIGNATURE	(BORROWER)			\n\n………………………………………………………\n\nCOMPANY STAMP (WHERE NECESSARY)",
										blackFontParameter1));
								
						loa.addCell(loa3);
						Phrase loa4 = new Phrase();
						
						loa4.add(new Chunk("LETTER OF SET OFF\n\n", blackFontListHeading));
						loa4.add(new Chunk("In consideration of your agreeing at my request not to require immediate payment of such of the sums mentioned below as may be now due and in consideration  of any like sums which you may hereafter advance or permit to become due, I the under signed \n\n",blackFont1));
						loa4.add(new Chunk(applicantName, blackFontParameter12));
						
						loa4.add(new Chunk("\n\nHereby charge all moneys from time to time due to me from your bank on any Savings Account which I may now or hereafter have with you with the payment of any sums of money which may be now or may hereafter have with you with the payment of any sums of money owing to your Bank anywhere from or by me either solely or jointly with any other person or persons in partnership or otherwise upon banking account or upon any discount or other account for any other matter or thing whatsoever including the usual banking charges.", blackFont1));
						
						loa4.add(new Chunk("\n\nAnd I authorize you to retain all money to me on any such account and to apply the same or any portion thereof towards payment of any sum or sums as aforesaid.",blackFont1));

						loa4.add(new Chunk("\n\nThus Done at:",blackFont1));
						loa4.add(new Chunk(" "+branch,blackFontParameter12));
						loa4.add(new Chunk("\nand dated this",blackFont1));
						loa4.add(new Chunk(" "+applicationDay+" ",blackFontParameter12));
						loa4.add(new Chunk("day of",blackFont1));
						loa4.add(new Chunk(" "+applicationMonth + " "+ applicationYear,blackFontParameter12));
						loa4.add(new Chunk("\n\n\nCUSTOMER SIGNATURE----------------------------------------                                                     "
								+ " \n\nAS WITNESS\n\n1----------------------------------------\n\n2----------------------------------------",
								blackFontParameter1));
						
						loa.addCell(loa4);

						document.add(loa);
						
						////////////Finance Facility Agreement/////////////
						document.newPage();
						document.add(img);
						
					
						Paragraph financeFacilityAgreementparagraph1 = new Paragraph(
								"Finance Facility Agreement", blackFontListHeading);
						document.add(financeFacilityAgreementparagraph1);
						document.add(new Paragraph("\n"));
						

						Paragraph financeFacilityAgreementparagraph2 = new Paragraph(
								"Made and entered into by and between:\n",
								blackFontSetOff);
						document.add(financeFacilityAgreementparagraph2);

						Paragraph financeFacilityAgreementparagraph3 = new Paragraph(
								"Eswatini Development and Savings Bank\nPhysical Address: SwaziBank Head Office, \nEngungwini Building, Gwamile Street, Mbabane \n",
								blackFontParameter);
						document.add(financeFacilityAgreementparagraph3);
						
						Paragraph financeFacilityAgreementParagraph31 = new Paragraph(
								"(herein after referred to as “SwaziBank” or “the Bank”)\n And \n",
								blackFontSetOff);
						document.add(financeFacilityAgreementParagraph31);

						Paragraph financeFacilityAgreementParagraph4 = new Paragraph(
								applicantName + " \nAddress:" + physicalAddress
										+ "\n", blackFontParameter);
						document.add(financeFacilityAgreementParagraph4);
						// document.add(offerLetterParagraph6);

						Paragraph financeFacilityAgreementParagraph6 = new Paragraph(
								"(Hereinafter referred to as “the Borrower”)\n\nThe Loan\n\n",
								blackFontSetOff);
						document.add(financeFacilityAgreementParagraph6);

						PdfPTable ftable1 = new PdfPTable(2);
						ftable1.setWidthPercentage(100);
						ftable1.setHorizontalAlignment(Element.ALIGN_LEFT);
						ftable1.setWidths(new int[] { 5, 8 });
						ftable1.getDefaultCell().setBorder(Rectangle.BOX);

						ftable1.addCell("Loan Type: ");
						ftable1.addCell("PERSONAL LOAN");
						ftable1.addCell("Amount: ");
						ftable1.addCell(String.valueOf(loanAmount));
						ftable1.addCell("Initiation Fees (0)%: ");
						ftable1.addCell(String.valueOf(initiationFee));
						ftable1.addCell("Administration Fees: ");
						ftable1.addCell(String.valueOf(administationFee));
						ftable1.addCell("Repayment Period: ");
						ftable1.addCell(String.valueOf(repaymentPeriod));
						ftable1.addCell("Repayment Amount: ");
						ftable1.addCell(String.valueOf(instalment));
						ftable1.addCell("Commencement Date: ");
						ftable1.addCell(dateCreated);
						ftable1.addCell("End Date: ");
						ftable1.addCell(dateOfLastInstallment);
						document.add(ftable1);
						
						document.newPage();
						
						PdfPTable finsecfac2 = new PdfPTable(2);
						finsecfac2.setWidthPercentage(100);
						finsecfac2.setHorizontalAlignment(Element.ALIGN_LEFT);
						finsecfac2.setWidths(new int[] { 5, 5 });
						finsecfac2.getDefaultCell().setBorder(
								Rectangle.NO_BORDER);
						
						Phrase fcsecAg1 = new Phrase();
						fcsecAg1.add(new Chunk("1. Interpretation ",
								blackFontParameter1));
						fcsecAg1.add(new Chunk(
								"\n\n1.1	In this agreement, unless the context otherwise indicates-The singular shall include the plural and vice versa:"
										+ "\n\na)	The words indicating gender shall import and include the other genders;"
										+ "\nb)	The headings to this agreement are used for the sake of convenience and shall not govern the interpretation hereof;"
										+ "\nc)	Any reference to a natural person shall include an artificial or corporate person and vice versa;"
										+ "\nd)	“Borrower” means the Borrower in terms of this Agreement, either a private individual or juristic person, as the case may be;"
										+ "\ne)	“Finance Facility” “Facility”  or  “Loan”  includes  Loan or Overdraft and any other advance and finance facility in terms of this Agreement;"
										+ "\nf)	“Prime lending rate” or “prime” means the discount  rate as published (per cent, per annum, compounded monthly) from time to time by the Central Bank as certified by any manager of the Bank whose appointment and designation need not be proved."
										+ "\ng)	“This Agreement” means this Finance Facility agreement, together with annexures hereto, including the Letter of Offer & Acceptance and the loan securities thereof;"
										+ "\n\n1.2	This Agreement shall be binding to the Borrower and its successors in title and successors in law.",
								blackFont1));
						
						
						fcsecAg1.add(new Chunk("\n\n2. The Loan ",
								blackFontParameter1));

						fcsecAg1.add(new Chunk("\n\n Upon and subject to the terms and conditions hereinafter set out,"
								+ " the Bank will provide or procure for the Borrower who hereby borrows the sum of "+loanAmount+"("+loanAmountWords+")"+"Subject to the requirements of "
								+ "Clauses 5, 6.1-6.3 below, and the provisions of the Letter of Offer & Acceptance, the Borrower shall be entitled to draw down under the loan",
								blackFont1));
						
						fcsecAg1.add(new Chunk("\n\n3. Loan Interest",
								blackFontParameter1));
						
						fcsecAg1.add(new Chunk("\n\n3.1 The loan shall bear interest at a rate equal to PRIME PLUS "+interestRate+" per annum. "+"\n\n 3.2 Interest shall be calculated on the daily balance of the amount of the loan, plus any interest thereon outstanding from time to time."
								+ " "+"\n\n 3.3 Interest on the loan shall be paid to the Bank monthly in arrears on the last day of the month, the first of such payments to be made on the "+dateOfFirstInstallment+" , and thereafter on the last day of each and every successive month.",
								blackFont1));
						
						fcsecAg1.add(new Chunk("\n\n4. Repayment",
								blackFontParameter1));
						
						fcsecAg1.add(new Chunk("\n\n4.1 The loan capital together with interest"
								+ " thereon shall be repaid to the Bank in the following manner (specify whether in a lump sum or in instalments, and when to be paid)."
                               + "  E " + (loanAmount*interestRate)/repaymentPeriod+ " PER MONTH EFFECTIVE "+dateOfFirstInstallment+" AND TO EXPIRE ON "+dateOfLastInstallment+
                              "\n\n 4.2 The Borrower agrees that all payments to be made pursuant to this Agreement may be made by means of the debit order authorization in terms of Clause 20.",
								blackFont1));
						fcsecAg1.add(new Chunk("\n\n5. Condition Precedent",
								blackFontParameter1));
						fcsecAg1.add(new Chunk("\n\n Notwithstanding anything to the contrary in this Agreement, the Borrower shall not be entitled to draw down under the loan unless and until the Borrower has furnished the Bank with the Deposit or commitment fee and the following security (ies):"+
                           "\n\ni)	STOP ORDER FROM SOURCE\n\nii)	GENERAL PLEDGE \n\niii)	LEVEL TERM INSURANCE POLICY\n\niv)	CESSION OVER TARGET SAVINGS TO BE INCREASED BY E"+ 0.5*loanAmount+" MONTHLY",
								blackFont1));
						
						fcsecAg1.add(new Chunk("\n\n6. Fees and Charges",
								blackFontParameter1));
						fcsecAg1.add(new Chunk("\n\n6.1 Initiation Fee",
								blackFontParameter1));
						fcsecAg1.add(new Chunk(
								"\nThe Borrower shall be charged a once off non-refundable application fee, payable by the Borrower upon the submission of the application. E"+ initiationFee,
								blackFont1));
						finsecfac2.addCell(fcsecAg1);
						Phrase fcsecAg2 = new Phrase();
						
						fcsecAg2.add(new Chunk("\n\n6.2 Administration Fee:",
								blackFontParameter1));
						
						fcsecAg2.add(new Chunk(
								"\nThe Borrower shall be charged with paying to the Bank a monthly administration fee. E"+ administationFee,
								blackFont1));
						fcsecAg2.add(new Chunk("\n\n6.3 Establishment Fee:",
								blackFontParameter1));
						fcsecAg2.add(new Chunk(
								"\n\nThe Bank shall be entitled to charge a non-refundable establishment fee, payable by the Borrower upon the signature of this Agreement.",
								blackFont1));
						fcsecAg2.add(new Chunk("\n\n6.4 Early Settlement Fee:",
								blackFontParameter1));
						fcsecAg2.add(new Chunk(
								"\n\nThe Borrower may, subject to 10 days’ notice to the Bank prepay all or a portion of the loan, provided that the Borrower shall be liable to pay to the Bank, a once-off prepayment fee equal to 90 days interest.",
								blackFont1));
						
						
						
				
						fcsecAg2.add(new Chunk("\n\n6.5 Late Drawdown Fee:",
								blackFontParameter1));
						fcsecAg2.add(new Chunk(
								"\n\nShould the Borrower fail to draw down the loan within 30 days of being entitled to do so, it should obtain a written permission from the Bank in the event of any further delay from the said 30 days, failing which the Bank will be entitled to levy a late drawdown fee.",
								blackFont1));
						fcsecAg2.add(new Chunk("\n\n6.6 Late Payment Fee:",
								blackFontParameter1));
						fcsecAg2.add(new Chunk(
								"\n\nShould the Borrower fail to pay on due date any amounts falling due or payable to the Bank under or arising from this Agreement, then, without prejudice to such other rights as may accrue to the Bank consequent upon such failure, such overdraft amounts shall bear additional finance charges at the rate of 2% per day of the overdue amount.",
								blackFont1));

						

						
						fcsecAg2.add(new Chunk("\n\n6.7 Other Fees and Charges",
								blackFontParameter1));
						fcsecAg2.add(new Chunk(
								"\n\nThe list of fees and charges contained in clauses 6.1 to 6.6 may be changed at any time at the discretion of the bank without prior notice. ",
								blackFont1));
						// finsecfac2.addCell(fcsecAg2);
						

						fcsecAg2.add(new Chunk("\n\n7. Breach",
								blackFontParameter1));
						fcsecAg2.add(new Chunk(
								"\n\n7.1 In the event of the Borrower failing to observe and / or to perform any of the terms, conditions and or obligations of this or any other agreement which it may have with the bank, or defaulting in the punctual payment of any amount falling due in terms of this or any other Agreement it may have with the Bank, the Bank shall be entitled, without notice to the Borrower, to cancel this Agreement and withdraw the services with immediate effect.  In that event the bank shall be entitled to call on the loan and to foreclose on the securities and recover the full amount of the loan, interest accrued and any charges levied but unpaid, in terms of this Agreement.\n\nThe following non exhaustive list shall constitute events of default entitling the Bank to call on the full loan amount plus   interest and to foreclose under this Agreement:\n\n(a)	Any judgement, attachment being made, and execution being levied against the Borrower;\n\n(b)	The Borrower being placed under judicial management or wound up, whether compulsorily or voluntarily, or compromising with any of its creditors, or committing an act of insolvency, as defined in the Eswatini Insolvency Act No. 81 of 1955; or\n\n(c)	Stopping payment of any liquid document made payable to the Bank; or\n\n(d)	Without the prior written consent of the Bank, ceasing or intimating to the Bank its intention to cease to carry on its business; or\n\n(e)	Failing for whatever reason, at any time during the duration of this agreement, to record a trading profit during any one or more year’s trading; or\n\n(f)	The Borrower proposing any rescheduling, reorganization or rearrangement of the whole, or part of the indebtedness to the Bank or any of the Borrower’s creditors;"
								,blackFont1));

						finsecfac2.addCell(fcsecAg2);
						Phrase fcsecAg3 = new Phrase();
						
						fcsecAg3.add(new Chunk(		"\n\n(g)	The Borrower’s business operations, or any significant part thereof being interrupted for a continuous period of at least three months or more;\n\n(h)	Any representation, warranty or statement made in, or in connection with this Agreement by or on behalf of the Borrower pursuant to this Agreement being found to be false or incorrect.\n\n(i)	Occurrence of any fact or circumstance which in the opinion of the Bank may adversely affect the ability or willingness of the Borrower to comply with all or any of its obligations under this Agreement;\n\n(j)	Death, in the case of a natural person or a major shareholder whose input is critical for the operation of the business.",
								blackFont1));
						
						
						fcsecAg3.add(new Chunk(
								"7.2 The exercise of the rights by the bank in terms of this clause 3 shall be without prejudice, and/or in addition to any other rights which might thereupon be available to the Bank in terms of this Agreement or in law.\n\n7.3	If the bank terminates the loan agreement in terms of the provisions of clause 3 the bank may in addition to any other rights it has; set off any credit balances held by the Borrower in any other accounts with Eswatini Bank against the debt on the loan facility.",
								blackFont1));
						fcsecAg3.add(new Chunk("\n\n8. Project Management",
								blackFontParameter1));
						fcsecAg3.add(new Chunk(
								"\n\n8.1	In the event of failure by the Borrower to honor obligations under a project financed by the Bank under this Agreement, for whatever reason, the Bank may at its sole discretion, and without prejudice to any rights it may have against the Borrower, in terms of this Agreement or in law, appoint a manager on contract with or without staff, to manage and carry out the operations of the project for the purpose of repayment and settlement of the loan, interest thereon and related costs.\n The Borrower shall upon written notice by the Bank of the decision herein, co-operate with the Bank."
										+ "\n\n8.2 The income generated shall in addition to being used for the loan repayment be, applied towards the reasonable running expenses of the project, which shall include but not be limited to, management, operational and legal costs.  No dividends shall be declared or paid\n\n8.3	Upon full settlement of the loan, and related costs, the Bank shall release the business project to the Borrower.",
								blackFont1));
						fcsecAg3.add(new Chunk("\n\n9. Change in Circumstances",
								blackFontParameter1));
						fcsecAg3.add(new Chunk(
								"\n\n9.1	If at any time during the currency of this Agreement –\n\n9.1.1	Any new law, ruling or regulation is promulgated given or adopted;		\n\n9.1.2	There are any changes to the present or future law, ruling or regulation;		\n\n9.1.3	There are any changes to the interpretation or administration of any law, ruling or regulation by any relevant monetary or fiscal authority;\n\n9.1.4	There is any compliance by the Bank with any directive or request, whether or not having the force of law, from any monetary or fiscal authority, which would or does –"
										+ "\n\n(a)	Subject the Bank to any taxes, duties, or other charges, in respect of this agreement or change the basis of taxation of the Bank in respect of payments of principal or interest/fees payable to the Bank (except for changes in the rate of taxation on the overall net income of the Bank); or		\n\n(b)	Impose, modify or deem applicable any reverse, special deposit or similar requirement against assets of, deposits with or for the account of, or credit extended by the Bank, or\n\n(c)	Impose on the Bank any other obligation or condition affecting the loan or its commitment in terms of this agreement; And –\n\nThe result of any of the occurrences in 9.1.1 – 9.1.4 (a) – (c) above is to increase the cost to the Bank of making any advance or maintaining this Agreement or to reduce any amount or amounts received or receivable or loanable by the Bank hereunder by a sum which the Bank deems material, then the"
						,blackFont1));
						finsecfac2.addCell(fcsecAg3);

						Phrase fcsecAg4 = new Phrase();
						fcsecAg4.add(new Chunk(" Borrower shall pay the Bank on demand and while such circumstances continue, such commitment fees as the Bank may ",
								blackFont1));
						
						fcsecAg4.add(new Chunk(
								"impose or such additional amounts which will compensate the Bank for such additional costs incurred. \n\n9.2	The Bank may give the Borrower thirty day notice of all amounts payable in terms of this clause 9.  A certificate signed by any manager of the Bank (whose appointment it shall not necessary to prove) as to such additional amount(s) shall be prima facie proof for all purposes.\n\n9.3	If the Borrower is required to pay additional amount(s) to the Bank pursuant to Clause 9.1 above, it shall be entitled to prepay any amounts owed in terms hereof without penalty, or to forthwith cancel any unutilized portion of the loan by giving the Bank thirty (30) days written notice thereof.\n\n9.4	Notwithstanding the provisions of clause 5 the bank shall not be liable for any failure to notify the Borrower of any changes. ",
								blackFont1));
						fcsecAg4.add(new Chunk(
								"\n\n10. Representations and Warranties",
								blackFontParameter1));
						fcsecAg4.add(new Chunk(
								"\n\nThe Borrower represents and warrants that –\n\n10.1	 Its acceptance of the terms of this Agreement has been duly authorized and does not contravene any law or any contractual obligation binding upon it;"
										+ "\n\n10.2 There is no material litigation or similar proceedings, to the knowledge of the Borrower presently pending or threatened which would have a material adverse effect on the business or assets of the Borrower;\n\n10.3	The Borrower is not in default in respect of any of its obligations in respect of money advanced and that no event specified in Clause 7 above has occurred or is continuing.",
								blackFont1));
						fcsecAg4.add(new Chunk(
								"\n\n11. Certificate of Indebtedness",
								blackFontParameter1));
						fcsecAg4.add(new Chunk(
								"\n\nA certificate signed by any manager of the Bank (whose appointment it shall not be necessary to prove) as to any indebtedness of the Borrower herein, or as to any other fact, shall be prima facie evidence of the Borrower’s indebtedness to the Bank or of such other fact for the purpose of any application or action, judgement or order or for any other purpose whatsoever.",
								blackFont1));
						fcsecAg4.add(new Chunk("\n\n12. Renunciation",
								blackFontParameter1));
						fcsecAg4.add(new Chunk(
								"\n\nThe Borrower specifically renounces the legal exceptions non numeratae pecuniae, non causa debiti, revision of accounts and error of calculation (errore  calculi) de duobus Vel plu rubus reis debindi, beneficium ordinus seu execussionis, benefitium devisionis and all other exceptions which might or could be pleaded to the validity of the indebtedness, whether capital, finance charges or legal costs, or any part thereof, and declares that he is fully acquainted with the force, effect and meaning thereof, the same having been explained to the Borrower by the Bank.",
								blackFont1));
						fcsecAg4.add(new Chunk("\n\n13. Domicilium",
								blackFontParameter1));
						fcsecAg4.add(new Chunk(
								"\n\n13.1 The parties respectively choose their domicilia citandi et executandi for all notices and processes to be given or served in pursuance hereof at the addresses given by both parties. ", 
								blackFont1));
						fcsecAg4.add(new Chunk( "\n\n The Bank: "+ branchAdress ,
								blackFontParameter1));
						fcsecAg4.add(new Chunk("\n\nThe Borrower: "+"\n\n"+applicantName+"  "+applicantHomeArea,blackFontParameter1));
						
						fcsecAg4.add(new Chunk(" \n\n13.2	Either of the parties shall be entitled to change its domicilium from time to time:  Provided that any new domicilium selected by either of them shall be a physical address and shall be situate in the Kingdom of Eswatini and any such change shall only be effective upon receipt by the other party of notice in writing of such change.  All other notices or communications intended for either party ",
								blackFont1));
						finsecfac2.addCell(fcsecAg4);

						Phrase fcsecAg5 = new Phrase();
						fcsecAg5.add(new Chunk(
								"shall be made or given in writing at such party’s domicilium for the time being and, if forwarded by prepaid registered post, shall be deemed to have been made or given three days after the date of posting.",
								blackFont1));
						fcsecAg5.add(new Chunk("\n\n14. Entire Agreement",
								blackFontParameter1));
						fcsecAg5.add(new Chunk(
								"\n\nThis agreement constitutes the entire agreement between the parties and any amendment, addition or alteration to the provisions hereof shall only be deemed to be of force and effect if such amendment, addition or alteration is reduced to writing and signed by the parties.",
								blackFont1));
						fcsecAg5.add(new Chunk("\n\n15. Costs and Expenses",
								blackFontParameter1));
						fcsecAg5.add(new Chunk(
								"\n\nAll stamp duties payable in respect of this agreement or in respect of any guarantees or securities given in respect hereof and costs and expenses incurred by the Bank in connection with the preparation of this agreement and any securities relating thereto shall be for the account of the Borrower and shall be payable on demand.\n\nFurthermore, all legal costs as between attorney and his own client, tracing fees, valuation costs, collection commission, disbursements and fees of a like nature incurred by the Bank in successfully enforcing or defending any of the provisions of this Agreement, or any claim there under, shall be for the account of the Borrower and be payable on demand.",
								blackFont1));
						fcsecAg5.add(new Chunk("\n\n16. Dispute	",blackFontParameter1));
								
						fcsecAg5.add(new Chunk("\n\n16.1 In the event of any dispute arising between the Bank and the Borrower relating to any matter under this Agreement, such dispute shall be resolved amicably by the parties, and if they fail to resolve it between themselves, the dispute may be referred to court by any aggrieved party.\n\n12.2	In appropriate cases, and due to the technical nature of the matters involved, the Bank and the Borrower may by agreement refer the dispute to an Arbitrator jointly selected by the parties for resolution by arbitration.",
								blackFont1));
						fcsecAg5.add(new Chunk("\n\n17. Jurisdiction",	blackFontParameter1));
						fcsecAg5.add(new Chunk(	"\n\n17.1 The Borrower hereby consents and submits to the jurisdiction of the magistrate’s court having jurisdiction over its person in respect of all proceedings connected with this agreement, notwithstanding that the amount claimed or the value of the matter in dispute exceeds such jurisdiction;  provided that the Bank shall not be obliged to institute action in the magistrate’s court.\n\n13.2	Notwithstanding the provisions of Clause 13.1, the Bank shall be entitled to institute all or any proceedings against the Borrower in connection with this Agreement in the High Court of Eswatini and the Borrower hereby consents and submits to the jurisdiction of that court and agrees that any costs awarded against the Borrower be awarded or paid in accordance with Clause 11 hereof on Attorney and Own Client Scale.",
								blackFont1));
						finsecfac2.addCell(fcsecAg5);

						Phrase fcsecAg6 = new Phrase();
						fcsecAg6.add(new Chunk("18. Indulgence",
								blackFontParameter1));
						fcsecAg6.add(new Chunk(
								"\n\nNo relaxation or indulgence granted by the Bank to the Borrower from time to time shall be deemed to be a waiver of the Bank’s rights in terms hereof, nor shall any such relaxation or indulgence be deemed to be a novation or waiver of the terms and conditions of this Agreement.",
								blackFont1));
						fcsecAg6.add(new Chunk("\n\n19. Applicable Law",
								blackFontParameter1));
						fcsecAg6.add(new Chunk(
								"\n\nThis Agreement shall in all respects be governed by and construed in accordance with the laws of the Kingdom of Eswatini and all disputes, actions and other matters in connection therewith shall be determined in accordance with such law.",
								blackFont1));
						fcsecAg6.add(new Chunk(
								"\n\n20. Debit Order Authorization",
								blackFontParameter1));
						fcsecAg6.add(new Chunk(
								"\n\n20.1 The bank shall be entitled to originate debits to the Borrower’s account at  ",
								blackFont1));
						fcsecAg6.add(new Chunk("\n\nBank: ESWATINI BANK \n\nBranch: "+branch+"\n\nAccount No: "+applicantBankAccountNumber,
								blackFontParameter));
						fcsecAg6.add(new Chunk(	"\n\n or any other bank or branch for all amounts due or which might at any future time become due by the Borrower under this Agreement.\n\n20.2	This authority shall in no way be construed as constituting a novation, substitution or variation of the Borrower’s obligation under this agreement.",
								blackFont1));
								
								
								
						fcsecAg6.add(new Chunk("\n\n21. Execution",
								blackFontParameter1));
						fcsecAg6.add(new Chunk(
								"\n\nThis agreement is signed at " +branch
										+ "" + "\n\nOn this day ", blackFont1));
						fcsecAg6.add(new Chunk(String.valueOf(dateCreated),
								blackFontParameter1));
						fcsecAg6.add(new Chunk(
								"\n\nFor and on behalf of the bank: "+bankExecutioner+"\n\nIn his/her capacity as: "+bankExecutionerCapacity +"\n\nBy the Borrower personally\n\nOr in the case of the Borrower being a juristic person, by:\n\nFull Name(s)_____________________________________"
										+ "\n\n(Borrower/For the Borrower)\n\nSigned in the presence of the Undersigned witnesses:\n\n____________________ ____________________\n\n(Witness)		                           (Witness)",
								blackFont1));
						finsecfac2.addCell(fcsecAg6);

						document.add(finsecfac2);
						
						document.newPage();
						
						// GENERAL PLEDGE////////
						document.newPage();
						document.add(img);

						Phrase gpHeader = new Phrase();
						gpHeader.add(new Chunk("GENERAL PLEDGE",
								blackFontListHeading));
						document.add(gpHeader);

						PdfPTable gp = new PdfPTable(2);
						gp.setWidthPercentage(100);
						gp.setHorizontalAlignment(Element.ALIGN_LEFT);
						gp.setWidths(new int[] { 5, 5 });
						gp.getDefaultCell().setBorder(Rectangle.NO_BORDER);

						Phrase gp1 = new Phrase();
						gp1.add(new Chunk("Eswatini Bank", blackFontParameter1));
						gp.addCell(gp1);

						Phrase gp2 = new Phrase();
						gp2.add(new Chunk("\n", blackFont1));
						gp.addCell(gp2);

						Phrase gp3 = new Phrase();
						gp3.add(new Chunk(
								"In consideration of certain banking facilities having been granted and which may from time to time hereafter be granted to Me\n\nBy the",
								blackFont1));
						gp3.add(new Chunk(
								" ESWATINI DEVELOPMENT AND SAVINGS BANK ",
								blackFontParameter1));
						gp3.add(new Chunk(
								"(hereinafter referred to as “the said Bank”) upon the terms and conditions hereinafter set out, I / we the undersigned ",
								blackFont1));
						gp3.add(new Chunk(applicantName, blackFontParameter12));
						gp3.add(new Chunk(
								"\n\nHereby cede, assign and make over to the said Bank all my/our right, title and interest in and to, and I/we do hereby pledge and deliver to the said Bank.",
								blackFont1));
						gp3.add(new Chunk("\n\na)	Stop Order over Salary",
								blackFontParameter1));
						gp3.add(new Chunk("\n\nb)	Level Term Insurance Cover",
								blackFontParameter1));
						gp3.add(new Chunk("\n\nc)	General Pledge",
								blackFontParameter1));
						gp3.add(new Chunk("\n\nd)	Target Increased Monthly by  E"+0.5*loanAmount,
								blackFontParameter1));
						
						gp3.add(new Chunk(
								"\n\nTogether with all other securities which have been or may hereafter be provided deposited with and delivered to the said Bank by me/us or on my/our behalf, including shares, stock, Bonds, Debentures and other instruments whether negotiable or not, sum or sums of money, merchandise, goods and other movable property, whether corporeal or incorporeal of every kind and description together with all interest, dividends, rights, income and benefits however named or described; without any exception, arising there from or by virtue thereof (all of which are hereinafter referred to as “the said securities”); and I/we declare that I am / we are the lawful owner(s) or legal holder(s) of the said securities and an / are entitled to all interest, dividends, rights, income and benefits, however named or described, without any exception which are now or may hereafter be due and payable or arising there from or by virtue thereof;\n\nI/we hereby authorise and empower the said Bank to take all such steps as and to do whatever it may in its discretion deem necessary to control, store, converse, transport, insure and otherwise protector or deal with the said securities or any of them, and to that end to notify or instruct any person concerned or otherwise interested therein, but notwithstanding the terms of this agreement the said Bank shall not be obliged to take any such steps or to do anything by virtue of this clause. \n\nThe said securities are ceded assigned, made over, pledged and delivered to the said Bank as a continuing security for each and every sum in which I/we may now be or hereafter indebted to the said Bank from whatever cause arising notwithstanding any fluctuation in the amount or even temporary extinction of such indebtedness, whether such indebtedness be a direct or indirect liability incurred by me/us individually or jointly with others or by any partnership, firm, business concern in which I/we have or hold or may held or may hereafter have or hold any interest and whether such indebtedness arise from money lent and advanced, overdrawn accounts, Drafts, Promissory Notes, or Bills of Exchange or other Negotiable instruments made, signed, accepted or endorsed by me/us or others with whom I/we am/are interested or concerned or any renewals thereof, or thereof, or thought any acts of suretyship or guarantee, or other undertaking signed and executed by my/us solely or jointly with others or ",
								blackFont1));
						gp.addCell(gp3);

						Phrase gp4 = new Phrase();
						gp4.add(new Chunk(
								"otherwise or given by the said Bank on my/our behalf including interest, if not otherwise specially arranged, at the said Bank’s rate current from time to time, discount, commission, legal costs, incurred or to be incurred, collection costs, stamps premiums of insurance and all other necessary, usual or incidental charges and expenses as hereinafter provided and otherwise. 							\n\nI/we agree that it shall always be in the entire discretion of the said Bank to determine the extent, nature and duration or advances made or to be made and of the facilities allowed or to be allowed to me/us and to demand that I/we shall provide, deposit with and deliver to the said Bank such other or further security as it may require, notwithstanding the apparent sufficiency of the securities actually held by it. \n\nI/we agree that in the event of any default by me/us in the observance or performance of any of the conditions of this Agreement or of my/our failure or discharge any obligation or liability to the said Bank on the due date thereof or within 24 hours of being called upon in writing so to do to pay such amount as may be demanded of me/us by the said Bank and/or to provide, deposit with and deliver to the said Bank such other or further security as it may require, then and in such case the said Bank shall at its sole option be entitled forthwith to consider the amount of my/our indebtedness or liability as aforesaid to be legally claimable and due without notice and the said Bank may forthwith proceed for recovery thereof and of such other moneys as may be due under any by virtue of this agreement and I/we authorise and empower the Bank then immediately or at any time thereafter irrevocably and in rem suam or in its discretion in my/our name to sell, call up, collect and in any way dispose of realise the said securities or any of them in such manner and on such terms and conditions as the said Bank in its sole and unfettered discretion may deem necessary and whether the said securities or any of them have reached maturity or be due and payable or otherwise and at any time in its discretion to collect, obtain, take up such interest, Dividends, Rights, Income and Benefits however named or described without any exception which may from time to time become due and payable or available to me/us on or by virtue of the said securities or any of them and to give in my/our names valid and effectual receipts for all or any sums received by the said Bank on my/our behalf and to cede, assign, transfer and delivered the said securities or any of them disposed of or realised in terms of this agreement, and to take or institute or cause to be taken or instituted such legal or other action as may be necessary and to proceed to the final end and determination thereof provided that the after payment of all cost and expenses in connection with such realisation and legal proceedings, and of all debts and liabilities secured by this agreements, the balance if any of such proceeds shall be paid to me/us or to my/our order; whereas in the event of the proceeds of the said securities being insufficient to pay my/our indebtedness or liabilities as aforesaid to the said Bank, I/we bind myself/ourselves and undertake to pay the deficiency on demand. But notwithstanding the provisions of this agreement, the said Bank shall be entitled at any ",
								blackFont1));
						gp.addCell(gp4);

						Phrase gp5 = new Phrase();
						gp5.add(new Chunk(
								"time whether before, during or after the realisation of the said securities to sue for and take pay debts and liabilities secured by this agreement, the balance if any of such proceeds shall be paid to me/us or to my/our order, whereas in the event of the proceeds of the said securities to sue for and take all necessary or advisable legal steps for the recovery of the moneys debts or liabilities as aforesaid, which may then be due and owing by me/us or any part thereof and to execute upon all or any of my/our assets or property according to law just as if the said securities had not been given. 							\n\nAll or any amounts collected by the said Bank in terms of this agreement may be appropriated by it towards payment of such of my/our liability or indebtedness as aforesaid or part thereof as it in its sole and unfettered discretion shall decide. \n\nI/we agree that an account rendered by the said Bank and certified by any manager or accountant or any person or persons acting in such capacity thereof setting out the amount of my/our liability or indebtedness as aforesaid from time to time and of any interest due to accrued and costs interest, dividends, rights, income and benefits, monies, securities other assets received and of the proceeds of the sale, disposal or realisation of the said securities or any of them shall be prima facie proof of the corrections of the matters contained in such account and I/we hereby authorise and empower the said Bank to apply for and obtain Provisional Sentence in any competent Court against me/us upon this document and the certified account of my/our liability or indebtedness as aforesaid. \n\nI/we bind myself / ourselves undertake to pay all or any amounts disbursed or costs and charges reasonable incurred by the said Bank in carrying out the provisions of this agreement or in taking action to enforce the terms hereof, and I/we agree that the said Bank shall be liable or responsible and I/we hereby absolve and hold the said Bank blameless for any loss or damage sustained in or by reason of the sale, disposal or other realisation of the said securities or any of them whether through brokers, agents or otherwise or by reason of deterioration in value of the said securities or any of them while in the custody of the said Bank or by reason of its failure or omission to take up or collect any interest, Dividends, Rights, Income and Benefits however named or described or to insure or to protect my/our interests in the said securities in any other way. \n\nI/we bind myself / ourselves and undertake not to cede, assign, make over and pledge to anyone else or to realise, alienate, receive, collect, in any other manner deal with the said securities, or any interest, dividends, rights, income and benefits however named or described without any exception arising there from or by virtue thereof without the written consent of the said Bank first being ha and obtained.  \n\nI/we renounce all benefits of the legal exceptions non numerate pecuniae, non causa debit, errore calculi, revision of accounts, no value received, ordinis seu excussioni et divisionis and all other exception which might or could be taken at law or in equity to the payment of my/our liability or indebtedness as aforesaid or any part thereof with the forece and effect of which exceptions I/we declare to be fully acquainted. ",
								blackFont1));
						gp.addCell(gp5);

						Phrase gp6 = new Phrase();
						gp6.add(new Chunk(
								"In as far as one or other of us in surety for the other or others or surety for any other debtor or debtors to the said Bank. I/we hereby renounce the benefits of the legal exceptions of division and execution and agree and undertake to accept the liability/ies jointly and severally with the other debtor or debtors and in so far as one or other of us is a woman or married woman I/we furthermore renounce the benefits of the legal exceptions “senatus consultum velleianum” and “authentica si qua mulier” with the force and effect whereof I/we are fully acquainted. ",
								blackFont1));
						gp6.add(new Chunk(
								"\n\nAny notice or demand required to be given in terms of this agreement shall be validly given if delivered or addressed and posted to me/us ",
								blackFont1));
						gp6.add(new Chunk(physicalAddress, blackFontParameter1));
						gp6.add(new Chunk(
								"\n\nWhich I/we choose as my/our domicilium citandi et executandi for the purpose of this agreement. All communications sent by post and addressed to me/us and the service of any legal process issued against me/us at the said address shall be deemed to have been delivered to me/us in the ordinary and usual course postal delivery. "
										+ "\n\nAnd for the purposes of this agreement, I/we hereby nominate, constitute and appoint the Manager or any person or persons acting in this capacity from time to time of the said Bank at",blackFont1));
						gp6.add(new Chunk(" Eswatini bank Gwamile Street, Mbabane",blackFontParameter1));
						gp6.add(new Chunk("\n\nWith power of substitution, to be my/our true and lawful Attorney and Agent in remsuam or in his discretion in my/our name with all necessary power and authority irrevocably during the subsistence of any indebtedness or liability whatsoever by me/us to the said Bank to do all that may be necessary and required to give effect to this agreement hereby ratifying, allowing and confirming and promising and agreeing to ratify, allow and confirm all and whatsoever my/our said Attorney and Agent shall lawfully do or cause to be done by virtue of these presents. "+ "\n\nThus done and signed at ",
								blackFont1));
						gp6.add(new Chunk(branchAdress, blackFontParameter1));
						gp6.add(new Chunk("\n\n" + String.valueOf(dateCreated)
								,
								blackFontParameter1));
						gp6.add(new Chunk(
								"\n\nCustomer: __________________________________\n\nAs Witness: \n\n1.	________________________________________\n\n2.	________________________________________",
								blackFont1));
						gp.addCell(gp6);

						document.add(gp);
						

						// ///////////////////////CUSTOMER TARGET SAVINGS STOP ORDER/////////////////

						document.newPage();
						document.add(img);

						Paragraph stopOrderParagraph1 = new Paragraph(
								"CUSTOMER SAVINGS STOP ORDER", blackFontListHeading);
						document.add(stopOrderParagraph1);
						document.add(new Paragraph("\n"));

						
						
						PdfPTable stopOrderTable = new PdfPTable(2);
						stopOrderTable.setWidthPercentage(100);
						stopOrderTable.setHorizontalAlignment(Element.ALIGN_LEFT);
						stopOrderTable.setWidths(new int[] { 6, 6 });
						stopOrderTable.getDefaultCell().setBorder(Rectangle.BOX);

						stopOrderTable.addCell("\nENTERED BY:................................\n\n"
								+ "DATE:...............................................\n\n"
								+ "Checking Officer to sign below as certifying signature and to sign the diary and Debit Card.\n\n ");
						stopOrderTable.addCell("\nCUSTOMER DETAILS\n\n"
								+ "CUSTOMER NAME: " + applicantName + "\n\n"
										+ "EMPLOYEE NO: "+iDNumber+"\n\n"
												+ "CIF: " + cif);
						
						document.add(stopOrderTable);

						Paragraph stopOrderParagraph2 = new Paragraph(new Paragraph("\n\nTo: The Manager\nESWATINI DEVELOPMENT AND SAVINGS BANK\n"
										+ (new Paragraph(branchAdress,
												blackFontParameter))));
						document.add(stopOrderParagraph2);
						document.add(new Paragraph("\n"));
						
						Paragraph stopOrderParagraph3 = new Paragraph(
								" I/We ",blackFontSetOff);
						document.add(stopOrderParagraph3);
						document.add(docHeadingFive);
						Paragraph stopOrderParagraph4 = new Paragraph(
								"hereby request and authorize Payroll Administration to deduct from my salary the under-listed amount from my salary subject to the maximum amount of deductions that may be deducted under the law per month and pay same to the Eswatini Bank account",blackFontSetOff);
						document.add(stopOrderParagraph4);
						
						Paragraph stopOrderParagraph5 = new Paragraph(
								"I authorize this amount to be transferred to my Target Savings Account number",blackFontSetOff);
						document.add(stopOrderParagraph5);
						
						Paragraph stopOrderParagraph6 = new Paragraph(
								"..................................... Commencing "+ dateCreated,blackFontSetOff);
						document.add(stopOrderParagraph6);
						
						Paragraph stopOrderParagraph7 = new Paragraph(
								"Amount in words Emalangeni "+ loanAmountWords,blackFontSetOff);
						document.add(stopOrderParagraph7);
						
						Paragraph stopOrderParagraph8 = new Paragraph(
								"Special Instructions - UNTIL FURTHER NOTICE FROM THE BANK ",blackFontSetOff);
						document.add(stopOrderParagraph8);
						
						document.add(new Paragraph(
								"Customer Signature__________________________________",
								blackFontParameter));
						document.add(new Paragraph("\n"));
						
						
						Paragraph stopOrderParagraph9 = new Paragraph(
								"NB: No withdrawals shall be made from the savings account until the loan is fully paid ",blackFontSetOff);
						document.add(stopOrderParagraph9);


						// STOP ORDER OVER SALARY/////
						document.newPage();
						document.add(img);

						Paragraph stopOrderParagraph12 = new Paragraph(
								"STOP ORDER OVER SALARY", blackFontListHeading);
						document.add(stopOrderParagraph1);

						document.add(new Paragraph("\n"));
						
						PdfPTable soosOuter = new PdfPTable(3);
						soosOuter.setWidthPercentage(100);
						soosOuter.setHorizontalAlignment(Element.ALIGN_CENTER);
						soosOuter.setWidths(new int[] { 6,2,6});
						soosOuter.getDefaultCell().setBorder(Rectangle.NO_BORDER);
						
						
						PdfPTable soosInner1 = new PdfPTable(1);
						soosInner1.setWidthPercentage(100);
						soosInner1.setHorizontalAlignment(Element.ALIGN_CENTER);
						soosInner1.setWidths(new int[] { 15});
						soosInner1.getDefaultCell().setBorder(Rectangle.BOX);
						soosInner1.addCell(new Paragraph(
								("\nENTERED BY ..................................................."
										+ "\n\nDATE ........................................................."
										+ "\n\nChecking Officer to sign below as certifying signature and to sign the diary and Debit Card. \n\n" ), blackFont1));
						
						PdfPTable soosInner2 = new PdfPTable(1);
						soosInner2.setWidthPercentage(100);
						soosInner2.setHorizontalAlignment(Element.ALIGN_CENTER);
						soosInner2.setWidths(new int[] { 15});
						soosInner2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
						soosInner2.addCell(new Paragraph(
								(" "), blackFont1));
						
						PdfPTable soosInner3 = new PdfPTable(1);
						soosInner3.setWidthPercentage(100);
						soosInner3.setHorizontalAlignment(Element.ALIGN_CENTER);
						soosInner3.setWidths(new int[] { 15});
						soosInner3.getDefaultCell().setBorder(Rectangle.BOX);
						soosInner3.addCell(new Paragraph(
								("\n\nCUSTOMER NAME"
										+ "\n\nSURNAME: "+applicantName+"\n\nCHRISTIAN NAMES: "+applicantName+"\n\nEMPLOYMENT NO: "+cif + "     CIF: "+cif ), blackFont1));
														
						soosOuter.addCell(soosInner1);
						soosOuter.addCell(soosInner2);
						soosOuter.addCell(soosInner3);
						document.add(soosOuter);
						
						Phrase soos = new Phrase();
						
						soos.add(new Chunk("\nTo: The Manager\nESWATINI DEVELOPMENT AND SAVINGS BANK                                            Date:"+dateCreated+"\n"+branchAdress,
								blackFont1));
						
						soos.add(new Chunk("\n\nI/We hereby request and authorize you, until you receive notice to the contrary in writing, to make the periodical payment mentioned below according to the Instructions contained therein, to the debit of my/our Savings/Loan Account with your bank.\n\nTo be dispatched on: PAYDAYS............................................... commencing: ",
								blackFont1));
						
						soos.add(new Chunk(applicantDistrict,blackFontParameter1));
						
						soos.add(new Chunk("...............................................",blackFont1));
						
						soos.add(new Chunk("\n To:- .............................................................................................. Eswatini Bank\n",blackFontParameter1));

						soos.add(new Chunk("\n 'A':- ..............................................................................................",blackFontParameter1));

						//soos.add(new Chunk(applicantDistrict,blackFontParameter1));
						
						soos.add(new Chunk(applicantDistrict,blackFontParameter1));
						
						soos.add(new Chunk("\n\nFor Credit of: ",blackFont1));
						
						soos.add(new Chunk(loanType.toUpperCase(),blackFontParameter1));
						
						soos.add(new Chunk("\n\nTo be paid To:",blackFont1));
						soos.add(new Chunk("Eswatini Bank\n                             " + branchAdress,blackFontParameter1));
						soos.add(new Chunk("\nAmount in words: ",blackFont1));
						soos.add(new Chunk(loanAmountWords.toUpperCase(),blackFontParameter1));
						soos.add(new Chunk(" (E"+instalment,blackFontParameter1));
						soos.add(new Chunk("\n\nSpecial Instructions:          UNTIL LOAN IS FULLY REPAID"
										+ "\n\n                                                       ",blackFont1));
						soos.add(new Chunk("Yours faithfully",blackFontParameter1));
						soos.add(new Chunk("\n\n                                                     ............................."
										+ "\n“A”           Payments to be made to through Bankers                           ) Delete whichever"
										+ "\n“B”           Payments to be made direct to individuals or concerns        ) is not applicable"
										+ "\n\nThe bank will not send you special advices relating in the above payments. "
										+ "\nN.B.        If insufficient funds are available to meet this Stop Order on due date, payment will not be made.	The Bank will not 		make special arrangements to meet Stop Orders after due date.",
								blackFont1));
								document.add(soos);

					} catch (Exception e) {
						e.printStackTrace();
					}
					document.close();

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
