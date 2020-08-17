package technicalResources.loanTracking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
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

import org.apache.poi.ss.formula.functions.FinanceLib;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import util.ConnectionHelper;

/**
 * Servlet implementation class BranchLoanNewApplication
 */
@WebServlet("/BranchLoanBranchManagerComment")
public class BranchLoanBranchManagerComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String viewLoan = request.getParameter("viewLoan");
		String submitLoan = request.getParameter("submitLoan");

		request.getParameter("lastId");
		float administationFee;
		String applicantBankAccountNumber;
		String applicantBankBranch;
		String applicantBankName;
		String applicantChief;
		String applicantDistrict;
		String applicantHomeArea;
		String applicantIndvuna;
		String applicantName;
		String applicantNearestShop_school;
		String applicantRunner;
		int applicationDay1;
		int applicationMonth1;
		String bankExecutioner;
		String bankExecutionerCapacity;
		float basicSalary;
		String branch;
		String branchAdress;
		String branchManagerComment;
		String branchManagerCommentDate;
		String branchManagerEmail;
		String branchManagerName;
		String businessConsultantComment;
		String businessConsultantCommentDate;
		String businessConsultantEmail;
		String businessConsultantName;
		float cashAtBank;
		String cif;
		String creditAnalystComment;
		String creditAnalystCommentDate;
		String creditAnalystEmail;
		String creditAnalystName;
		String creditManagerComment;
		String creditManagerCommentDate;
		String creditManagerEmail;
		String creditManagerName;
		String dateCreated;
		String dateOfBirth;
		String dateOfFirstInstallment;
		String dateOfLastInstallment;
		String debtorsName1;
		float debtorsName1Amount = 0;
		String debtorsName2;
		float debtorsName2Amount = 0;
		String debtorsName3;
		float debtorsName3Amount = 0;
		String debtorsName4;
		float debtorsName4Amount = 0;
		float deficiency = 0;
		float disbursedAmount = 0;
		String disbursementDate;
		float electricity;
		String emailAddress;
		String employementPeriod;
		String employementTerms;
		String employerAddress;
		String employerName;
		String employerPhysicalAddress;
		String employerTelephoneNo;
		float fixedDeposit;
		float food;
		float funeralCover;
		float furnitureCars;
		String iDNumber;
		float insurances;
		float interestRate = 0;
		String lastModifiedBy;
		String lastModifiedDate;
		float levelTermInsurancePremiumAmount;
		double loanAmount;
		double loanAmount1;
		String loanAmountWords;
		String loanOpeningSupervisorComment;
		String loanOpeningSupervisorCommentDate;
		String loanOpeningSupervisorEmail;
		String loanOpeningSupervisorName;
		String loanReference;
		float loans;
		String loanType;
		float longTermLoans;
		String maritalStatus;
		float medicalAid;
		String mobileNo;
		String nationality;
		String nextOfKinCellNo;
		String nextOfKinEmployer;
		String nextOfKinName;
		String nextOfKinOccupation;
		String nextOfKinTelephoneNo;
		int noOfDependants;
		String occupation;
		float otherAccounts;
		float otherAssets;
		float otherDebts;
		float otherDeductions;
		float otherIncome;
		float overdrafts;
		float pension;
		String physicalAddress;
		String physicalAddressType;
		String postalAddress;
		String previousBranch;
		float previousLoanBalances;
		String previousLoanType;
		String previouslyAppliedforLoanwithSdsb;
		float property;
		float providentFund;
		String referenceName1;
		String referenceName1PhysicalAddress;
		String referenceName1TelephoneNo;
		String referenceName2;
		String referenceName2PhysicalAddress;
		String referenceName2TelephoneNo;
		String referenceName3;
		String referenceName3PhysicalAddress;
		String referenceName3TelephoneNo;
		String registryOfficerComment;
		String registryOfficerEmail;
		String registryrOfficerCommentDate;
		String registryrOfficerName;
		float rent;
		int repaymentPeriod;
		float savings;
		String securitiesDocumentLocation;
		String securitiesDocumentUploadDate;
		String securitiesSupervisorComment;
		String securitiesSupervisorEmail;
		String securitiesSupervisorName;
		float surplus;
		float surplusLiabilities;
		float tax;
		String taxIdentity;
		String telelephoneNo;
		float water;
		double finalValue = 0;

		// /////////////date insert///////////////////
		Date dateOpenedN = new Date();
		dateCreated = sdf.format(dateOpenedN);
		// /////////////date insert///////////////////
		debtorsName4Amount = 0;

		administationFee = 0;
		applicantBankName = request.getParameter("applicantBankName");
		applicantBankBranch = request.getParameter("applicantBankBranch");
		applicantBankAccountNumber = request
				.getParameter("applicantBankAccountNumber");
		applicantName = request.getParameter("applicantName");
		applicantDistrict = request.getParameter("applicantDistrict");
		applicantHomeArea = request.getParameter("applicantHomeArea");
		applicantNearestShop_school = request
				.getParameter("applicantNearestShop_school");
		applicantChief = request.getParameter("applicantChief");
		applicantIndvuna = request.getParameter("applicantIndvuna");
		applicantRunner = request.getParameter("applicantRunner");
		bankExecutioner = request.getParameter("bankExecutioner");
		bankExecutionerCapacity = request
				.getParameter("bankExecutionerCapacity");
		basicSalary = Float.valueOf(request.getParameter("basicSalary"));
		branchAdress = request.getParameter("branchAdress");
		branch = request.getParameter("branch");
		branchManagerComment = request.getParameter("branchManagerComment");
		branchManagerCommentDate = dateCreated;
		request
				.getParameter("branchManagerSecuritiesComment");
		request
				.getParameter("branchManagerSecuritiesCommentDate");
		branchManagerName = request.getParameter("branchManagerName");
		branchManagerEmail = request.getParameter("branchManagerEmail");
		businessConsultantName = request.getParameter("businessConsultantName");
		businessConsultantCommentDate = request.getParameter("businessConsultantCommentDate");
		businessConsultantComment = request
				.getParameter("businessConsultantComment");
		businessConsultantEmail = request
				.getParameter("businessConsultantEmail");
		cashAtBank = Float.valueOf(request.getParameter("cashAtBank"));
		cif = request.getParameter("cif");
		creditAnalystComment = request.getParameter("creditAnalystComment");
		creditAnalystCommentDate = request
				.getParameter("creditAnalystCommentDate");
		creditAnalystName = request.getParameter("creditAnalystName");
		creditAnalystEmail = request.getParameter("creditAnalystEmail");
		creditManagerCommentDate = request.getParameter("creditManagerCommentDate");
		creditManagerName = request.getParameter("creditManagerName");
		creditManagerEmail = request.getParameter("creditManagerEmail");
		creditManagerComment = request.getParameter("creditManagerComment");
		dateOfBirth = request.getParameter("dateOfBirth");
		dateOfFirstInstallment = request.getParameter("dateOfFirstInstallment");
		dateOfLastInstallment = request.getParameter("dateOfLastInstallment");
		deficiency = Float.valueOf(request.getParameter("deficiency"));
		debtorsName1 = request.getParameter("debtorsName1");
		debtorsName2 = request.getParameter("debtorsName2");
		debtorsName3 = request.getParameter("debtorsName3");
		debtorsName4 = request.getParameter("debtorsName4");
		debtorsName1Amount = Float.valueOf(request
				.getParameter("debtorsName1Amount"));
		debtorsName2Amount = Float.valueOf(request
				.getParameter("debtorsName2Amount"));
		debtorsName3Amount = Float.valueOf(request
				.getParameter("debtorsName3Amount"));
		debtorsName4Amount = Float.valueOf(request
				.getParameter("debtorsName4Amount"));
		disbursementDate = request.getParameter("disbursementDate");
		disbursedAmount = 0;
		emailAddress = request.getParameter("disbursementDate");
		employerName = request.getParameter("employerName");
		employerAddress = request.getParameter("employerAddress");
		employerPhysicalAddress = request
				.getParameter("employerPhysicalAddress");
		employerTelephoneNo = request.getParameter("employerTelephoneNo");
		employementTerms = request.getParameter("employementTerms");
		employementPeriod = request.getParameter("employementPeriod");
		electricity = Float.valueOf(request.getParameter("electricity"));
		fixedDeposit = Float.valueOf(request.getParameter("fixedDeposit"));
		food = Float.valueOf(request.getParameter("food"));
		Float.valueOf(request.getParameter("foodBudget"));
		furnitureCars = Float.valueOf(request.getParameter("furnitureCars"));
		funeralCover = 5000;
		iDNumber = request.getParameter("iDNumber");
		insurances = Float.valueOf(request.getParameter("insurances"));
		Float.valueOf(request
				.getParameter("insurancesBudget"));
		interestRate = 22;
		lastModifiedBy = businessConsultantName;
		lastModifiedDate = dateCreated;
		levelTermInsurancePremiumAmount = 0;
		loans = Float.valueOf(request.getParameter("loans"));
		loanAmount = Float.valueOf(request.getParameter("loanAmount"));
		loanAmount1 = Double.valueOf(request.getParameter("loanAmount"));
		request.getParameter("loanAmount");
		loanAmountWords = request.getParameter("loanAmountWords");
		loanOpeningSupervisorName = request
				.getParameter("loanOpeningSupervisorName");
		loanOpeningSupervisorCommentDate = request
				.getParameter("loanOpeningSupervisorCommentDate");
		loanOpeningSupervisorComment = request
				.getParameter("loanOpeningSupervisorComment");
		loanOpeningSupervisorEmail = request
				.getParameter("loanOpeningSupervisorEmail");
		loanReference = request.getParameter("loanReference");
		longTermLoans = Float.valueOf(request.getParameter("longTermLoans"));
		maritalStatus = request.getParameter("maritalStatus");
		medicalAid = Float.valueOf(request.getParameter("medicalAid"));
		mobileNo = request.getParameter("mobileNo");
		nationality = request.getParameter("nationality");
		nextOfKinName = request.getParameter("nextOfKinName");
		nextOfKinOccupation = request.getParameter("nextOfKinOccupation");
		nextOfKinEmployer = request.getParameter("nextOfKinEmployer");
		nextOfKinTelephoneNo = request.getParameter("nextOfKinTelephoneNo");
		nextOfKinCellNo = request.getParameter("nextOfKinCellNo");
		noOfDependants = Integer
				.valueOf(request.getParameter("noOfDependants"));
		occupation = request.getParameter("occupation");
		overdrafts = Float.valueOf(request.getParameter("overdrafts"));
		otherAccounts = Float.valueOf(request.getParameter("otherAccounts"));
		otherAssets = Float.valueOf(request.getParameter("otherAssets"));
		otherDebts = Float.valueOf(request.getParameter("otherDebts"));
		otherIncome = Float.valueOf(request.getParameter("otherIncome"));
		otherDeductions = Float
				.valueOf(request.getParameter("otherDeductions"));
		pension = Float.valueOf(request.getParameter("pension"));
		physicalAddress = request.getParameter("physicalAddress");
		physicalAddressType = request.getParameter("physicalAddressType");
		postalAddress = request.getParameter("postalAddress");
		previouslyAppliedforLoanwithSdsb = request
				.getParameter("previouslyAppliedforLoanwithSdsb");
		previousLoanBalances = Float.valueOf(request
				.getParameter("previousLoanBalances"));
		previousBranch = request.getParameter("previousBranch");
		previousLoanType = request.getParameter("previousLoanType");
		property = Float.valueOf(request.getParameter("property"));
		providentFund = Float.valueOf(request.getParameter("providentFund"));
		referenceName1 = request.getParameter("referenceName1");
		referenceName2 = request.getParameter("referenceName2");
		referenceName3 = request.getParameter("referenceName3");
		referenceName1PhysicalAddress = request
				.getParameter("referenceName1PhysicalAddress");
		referenceName2PhysicalAddress = request
				.getParameter("referenceName2PhysicalAddress");
		referenceName3PhysicalAddress = request
				.getParameter("referenceName3PhysicalAddress");
		referenceName1TelephoneNo = request
				.getParameter("referenceName1TelephoneNo");
		referenceName2TelephoneNo = request
				.getParameter("referenceName2TelephoneNo");
		referenceName3TelephoneNo = request
				.getParameter("referenceName3TelephoneNo");
		registryOfficerComment = request.getParameter("registryOfficerComment");
		registryrOfficerCommentDate = request
				.getParameter("registryrOfficerCommentDate");
		registryrOfficerName = request.getParameter("registryrOfficerName");
		registryOfficerEmail = request.getParameter("registryOfficerEmail");
		rent = Float.valueOf(request.getParameter("rent"));
		repaymentPeriod = 25;
		savings = Float.valueOf(request.getParameter("savings"));

		Float.valueOf(request.getParameter("loansBudget"));
		Float.valueOf(request
				.getParameter("otherDeductionBudget"));
		surplus = Float.valueOf(request.getParameter("surplus"));
		surplusLiabilities = Float.valueOf(request
				.getParameter("surplusLiabilities"));
		tax = Float.valueOf(request.getParameter("tax"));

		request
				.getParameter("copyOfConcifirmationLetter");
		request.getParameter("copyOfId");
		request.getParameter("copyOfItcReport");
		request.getParameter("copyOfPaySlip");
		request.getParameter("currentLoanBalances");
		request.getParameter("currentLoans");
		loanType = request.getParameter("loanType");
		request.getParameter("Other1");
		request.getParameter("Other2");
		request.getParameter("Other3");
		request.getParameter("Other4");
		request.getParameter("Other5");

		Float.valueOf(request
				.getParameter("otherAccountsBudget"));
		request.getParameter("resAddress");
		securitiesDocumentLocation = request
				.getParameter("securitiesDocumentLocation");
		securitiesDocumentUploadDate = request
				.getParameter("securitiesDocumentUploadDate");
		securitiesSupervisorComment = request
				.getParameter("securitiesSupervisorComment");
		request
				.getParameter("securitiesSupervisorCommentDate");
		securitiesSupervisorEmail = request
				.getParameter("securitiesSupervisorEmail");
		securitiesSupervisorName = request
				.getParameter("securitiesSupervisorName");
		request.getParameter("SecurityLink");
		request.getParameter("SecurityUploadDate");
		taxIdentity = request.getParameter("taxIdentity");
		telelephoneNo = request.getParameter("telelephoneNo");

		water = Float.valueOf(request.getParameter("water"));
		Float.valueOf(request.getParameter("waterBudget"));

		applicationDay1 = 0;

		applicationMonth1 = 0;
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		Date startDate2 = null;
		Calendar cal = null;

		String startDate1 = dateOfFirstInstallment;
		String endDate1 = dateOfLastInstallment;

		// convert String to LocalDate
		LocalDate localDate1 = LocalDate.parse(startDate1, formatter1);
		LocalDate localDate2 = LocalDate.parse(endDate1, formatter1);
		LocalDate localDate3 = LocalDate.parse(dateOfBirth, formatter1);
		LocalDate localDate4 = LocalDate.now();
		repaymentPeriod = (int) ChronoUnit.MONTHS.between(localDate1.withDayOfMonth(1),localDate2.withDayOfMonth(1)) + 1;
		int customerAge = (int) ChronoUnit.YEARS.between(localDate3.withDayOfMonth(1), localDate4.withDayOfMonth(1));
		

		cal = Calendar.getInstance();
		// cal.setTime(startDate2);
		try {
			startDate2 = dateFormat.parse(startDate1);
			applicationDay1 = localDate1.getDayOfMonth();
			applicationMonth1 = localDate1.getMonthValue();
			localDate1.getYear();

		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		if (applicationDay1 == 1) {
		} else if (applicationDay1 == 2) {
		} else if (applicationDay1 == 3) {
		} else if (applicationDay1 == 4) {
		} else if (applicationDay1 == 5) {
		} else if (applicationDay1 == 6) {
		} else if (applicationDay1 == 7) {
		} else if (applicationDay1 == 8) {
		} else if (applicationDay1 == 9) {
		} else if (applicationDay1 == 10) {
		} else if (applicationDay1 == 11) {
		} else if (applicationDay1 == 12) {
		} else if (applicationDay1 == 13) {
		} else if (applicationDay1 == 14) {
		} else if (applicationDay1 == 15) {
		} else if (applicationDay1 == 16) {
		} else if (applicationDay1 == 17) {
		} else if (applicationDay1 == 18) {
		} else if (applicationDay1 == 19) {
		} else if (applicationDay1 == 20) {
		} else if (applicationDay1 == 21) {
		} else if (applicationDay1 == 22) {
		} else if (applicationDay1 == 23) {
		} else if (applicationDay1 == 24) {
		} else if (applicationDay1 == 25) {
		} else if (applicationDay1 == 26) {
		} else if (applicationDay1 == 27) {
		} else if (applicationDay1 == 28) {
		} else if (applicationDay1 == 29) {
		} else if (applicationDay1 == 30) {
		} else if (applicationDay1 == 31) {
		}

		if (applicationMonth1 == 1) {
		} else if (applicationMonth1 == 2) {
		} else if (applicationMonth1 == 3) {
		} else if (applicationMonth1 == 4) {
		} else if (applicationMonth1 == 5) {
		} else if (applicationMonth1 == 6) {
		} else if (applicationMonth1 == 7) {
		} else if (applicationMonth1 == 8) {
		} else if (applicationMonth1 == 9) {
		} else if (applicationMonth1 == 10) {
		} else if (applicationMonth1 == 11) {
		} else if (applicationMonth1 == 12) {
		}
		
		int loanPeriod = repaymentPeriod;

		double x = 0;
		double singlePremium = 0;
		double levelTermInsurance = 0;
		double initiationfee = 0;
		double loanAndCharges = 0;
		double loanAndLevelTerm = 0;
		double rate = interestRate;

		double r = (rate / 100) / 12;
		double beginingBalance = 0;
		double totalEarlyPayments = 0;
		double extraPayment = 0;
		;
		double totalPayment = 0;
		double principal = 0;
		double interest = interestRate;
		double endingBalance = 0;

		double totalInterest = 0;

		totalInterest = interest * loanPeriod;

		
		

		if (customerAge <= 29) {
			if (loanPeriod < 13) {
				x = 6.35;
			} else if (loanPeriod < 25) {
				x = 12.0;
			} else if (loanPeriod < 37) {
				x = 17.4;
			} else if (loanPeriod < 49) {
				x = 22.75;
			} else if (loanPeriod < 61) {
				x = 27.8;
			}

		} else if (customerAge <= 39) {
			if (loanPeriod < 13) {
				x = 10.5;
			} else if (loanPeriod < 25) {
				x = 19.50;
			} else if (loanPeriod < 37) {
				x = 27.65;
			} else if (loanPeriod < 49) {
				x = 35.1;
			} else if (loanPeriod < 61) {
				x = 42.1;
			}

		}

		else if (customerAge <= 49) {
			if (loanPeriod < 13) {
				x = 8.55;
			} else if (loanPeriod < 25) {
				x = 16.85;
			} else if (loanPeriod < 37) {
				x = 25.4;
			} else if (loanPeriod < 49) {
				x = 32.0;
			} else if (loanPeriod < 61) {
				x = 37.75;
			}

		}

		else if (customerAge <= 59) {
			if (loanPeriod < 13) {
				x = 13.45;
			} else if (loanPeriod < 25) {
				x = 25.5;
			} else if (loanPeriod < 37) {
				x = 37.2;
			} else if (loanPeriod < 49) {
				x = 48.3;
			} else if (loanPeriod < 61) {
				x = 62.0;
			}

		}

		else if (customerAge >= 60) {
			if (loanPeriod < 13) {
				x = 21.9;
			} else if (loanPeriod < 25) {
				x = 43.45;
			} else if (loanPeriod < 37) {
				x = 66.3;
			} else if (loanPeriod < 49) {
				x = 90.75;
			} else if (loanPeriod < 61) {
				x = 115.45;
			}

		}

		singlePremium = 6.91 * loanPeriod;

		levelTermInsurance = (x * loanAmount1 / 1000) + singlePremium;

		loanAndLevelTerm = levelTermInsurance + loanAmount1;

		if ((loanAndLevelTerm / 0.927) * 0.08 < 500) {

			initiationfee = 500;

		} else {

			initiationfee = (loanAndLevelTerm / 0.927) * 0.08;

		}

		loanAndCharges = levelTermInsurance + initiationfee + loanAmount1;

		double managementFee = 119;

		double totalRepayment = -(FinanceLib.pmt(r, loanPeriod, loanAndCharges,
				finalValue, false)) + managementFee;

		if (viewLoan != null) {
			// TODO Auto-generated method stub

			Font blackFont1 = FontFactory.getFont(FontFactory.HELVETICA, 8,
					Font.NORMAL);
			Font blackFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9,
					Font.NORMAL);
			Font blackFontListHeading = FontFactory.getFont(
					FontFactory.TIMES_BOLD, 18, Font.NORMAL);

			Document document = new Document();

			try {

				response.setContentType("application/pdf");
				PdfWriter.getInstance(document, response.getOutputStream());
				document.open();

				Image img = Image
						.getInstance("C:/IntranetWarehouse/StaffLoan/logo/logo.png");
				document.add(img);

				Paragraph atmotizationHeading = new Paragraph(
						"PERSONAL LOAN ARMOTIZATION\n\n", blackFontListHeading);

				PdfPTable ftable2 = new PdfPTable(9);
				ftable2.setWidthPercentage(100);
				ftable2.setHorizontalAlignment(Element.ALIGN_LEFT);
				ftable2.setWidths(new int[] { 2, 3, 3, 3, 3, 3, 3, 3, 3 });
				ftable2.getDefaultCell().setBorder(Rectangle.BOX);

				ftable2.addCell(new Paragraph("Pmt No:", blackFont));
				ftable2.addCell(new Paragraph("Pmt Date:", blackFont));
				ftable2.addCell(new Paragraph("Begining Bal:", blackFont));
				ftable2.addCell(new Paragraph("Scheduled Pmt:", blackFont));
				ftable2.addCell(new Paragraph("Extra Pmt:", blackFont));
				ftable2.addCell(new Paragraph("Total Pmt:", blackFont));
				ftable2.addCell(new Paragraph("Principal:", blackFont));
				ftable2.addCell(new Paragraph("Interest:", blackFont));
				ftable2.addCell(new Paragraph("Ending Bal:", blackFont));

				int x1 = 0;
				do {

					cal.setTime(startDate2);
					cal.add(Calendar.MONTH, x1);

					String dateTime = dateFormat.format(cal.getTime());

					if (x1 == 0) {

						beginingBalance = loanAndCharges;
						interest = loanAndCharges * r;
						totalPayment = extraPayment + totalRepayment;
						principal = totalPayment - interest;
						endingBalance = beginingBalance - principal;
					}

					else

					{
						beginingBalance = endingBalance;
						interest = beginingBalance * r;
						principal = totalPayment - interest;
						totalPayment = extraPayment + totalRepayment;
						endingBalance = beginingBalance - principal;

					}

					totalInterest += interest;
					totalEarlyPayments += extraPayment;

					ftable2.addCell(new Paragraph(String.valueOf(x1),
							blackFont1));
					ftable2.addCell(new Paragraph(dateTime, blackFont1));
					ftable2.addCell(new Paragraph(formatter
							.format(beginingBalance), blackFont1));
					ftable2.addCell(new Paragraph(formatter
							.format(totalRepayment), blackFont1));
					ftable2.addCell(new Paragraph(formatter
							.format(extraPayment), blackFont1));
					ftable2.addCell(new Paragraph(formatter
							.format(totalPayment), blackFont1));
					ftable2.addCell(new Paragraph(formatter.format(principal),
							blackFont1));
					ftable2.addCell(new Paragraph(formatter.format(interest),
							blackFont1));
					ftable2.addCell(new Paragraph(formatter
							.format(endingBalance), blackFont1));
					x1++;

				} while (endingBalance > 0);

				PdfPTable ftable1 = new PdfPTable(4);
				ftable1.setWidthPercentage(100);
				ftable1.setHorizontalAlignment(Element.ALIGN_LEFT);
				ftable1.setWidths(new int[] { 8, 5, 8, 5 });
				ftable1.getDefaultCell().setBorder(Rectangle.BOX);

				ftable1.addCell("");
				ftable1.addCell(new Paragraph("Loan Details", blackFont1));
				ftable1.addCell(" ");
				ftable1.addCell(new Paragraph("Loan Summary", blackFont1));
				ftable1.addCell(new Paragraph("Loan Amount", blackFont1));
				ftable1.addCell(new Paragraph(formatter.format(loanAndCharges),
						blackFont1));
				ftable1.addCell(new Paragraph("Scheduled Payment", blackFont1));
				ftable1.addCell(new Paragraph(formatter.format(totalRepayment),
						blackFont1));
				ftable1.addCell(new Paragraph("Annual Interest Rate",
						blackFont1));
				ftable1.addCell(new Paragraph(String.valueOf(interestRate)
						+ "%", blackFont1));
				ftable1.addCell(new Paragraph("Scheduled # of   Payments",
						blackFont1));
				ftable1.addCell(new Paragraph(String.valueOf(loanPeriod),
						blackFont1));
				ftable1.addCell(new Paragraph("Loan Period (Y)", blackFont1));
				ftable1.addCell(new Paragraph(String.valueOf(x1 / 12),
						blackFont1));
				ftable1.addCell(new Paragraph("Actual # of Payments",
						blackFont1));
				ftable1.addCell(new Paragraph(String.valueOf(loanPeriod),
						blackFont1));
				ftable1.addCell(new Paragraph("Payments per year", blackFont1));
				ftable1.addCell(new Paragraph("12", blackFont1));
				ftable1.addCell(new Paragraph("Total Early Payments",
						blackFont1));
				ftable1.addCell(new Paragraph(formatter
						.format(totalEarlyPayments), blackFont1));
				ftable1.addCell(new Paragraph("First Installment Date",
						blackFont1));
				ftable1.addCell(new Paragraph(startDate1, blackFont1));
				ftable1.addCell(new Paragraph("Total Interest", blackFont1));
				ftable1.addCell(new Paragraph(formatter.format(totalInterest),
						blackFont1));
				ftable1.addCell(new Paragraph("Last Installment Date",
						blackFont1));
				ftable1.addCell(new Paragraph(endDate1, blackFont1));
				ftable1.addCell(new Paragraph("", blackFont1));
				ftable1.addCell(new Paragraph("", blackFont1));

				ftable1.addCell("");
				ftable1.addCell("");
				ftable1.addCell(new Paragraph("", blackFont1));
				ftable1.addCell(new Paragraph("", blackFont1));

				Paragraph loanCalculator = new Paragraph("LOAN CALCULATOR\n\n",
						blackFontListHeading);
				document.add(loanCalculator);

				PdfPTable table50 = new PdfPTable(2);
				table50.setWidthPercentage(100);
				table50.setHorizontalAlignment(Element.ALIGN_LEFT);
				table50.setWidths(new int[] { 5, 8 });
				table50.getDefaultCell().setBorder(Rectangle.BOX);
				table50.addCell(new Paragraph("Date of birth", blackFont1));
				table50.addCell(new Paragraph((dateOfBirth), blackFont1));
				table50.addCell(new Paragraph("Employee Age", blackFont1));
				table50.addCell(new Paragraph((String.valueOf(customerAge)),
						blackFont1));
				table50.addCell(new Paragraph("Loan Start Date", blackFont1));
				table50.addCell(new Paragraph((dateOfFirstInstallment),
						blackFont1));
				table50.addCell(new Paragraph("Loan Period (Months)",
						blackFont1));
				table50.addCell(new Paragraph((String.valueOf(loanPeriod)),
						blackFont1));
				table50.addCell(new Paragraph(
						"Loan Amount Requested before funeral cover",
						blackFont1));
				table50.addCell(new Paragraph((String.format("%.2f",
						(loanAmount))), blackFont1));
				table50.addCell(new Paragraph("Funeral Cover", blackFont1));
				table50.addCell(new Paragraph((String.format("%.2f",
						(funeralCover))), blackFont1));
				table50.addCell(new Paragraph("Initiation Fee", blackFont1));
				table50.addCell(new Paragraph((String.format("%.2f",
						(initiationfee))), blackFont1));
				table50.addCell(new Paragraph("Level Term Insurance",
						blackFont1));
				table50.addCell(new Paragraph(String.format("%.2f",
						(levelTermInsurance)), blackFont1));
				table50.addCell(new Paragraph("Total Loan Amount", blackFont1));
				table50.addCell(new Paragraph(String.format("%.2f",
						(loanAndCharges)), blackFont1));
				document.add(table50);
				document.add(new Paragraph("\n"));
				document.add(atmotizationHeading);
				document.add(ftable1);
				document.add(new Paragraph("\n"));
				document.add(ftable2);

				document.newPage();
				document.add(img);

				Paragraph resume = new Paragraph("RESUME\n\n",
						blackFontListHeading);
				document.add(resume);

				PdfPTable resumeTable1 = new PdfPTable(2);
				resumeTable1.setWidthPercentage(100);
				resumeTable1.setHorizontalAlignment(Element.ALIGN_LEFT);
				resumeTable1.setWidths(new int[] { 7, 6 });
				resumeTable1.getDefaultCell().setBorder(Rectangle.BOX);

				resumeTable1.addCell(new Paragraph("BRANCH", blackFont1));
				resumeTable1.addCell(new Paragraph(branch, blackFont1));
				resumeTable1.addCell(new Paragraph("DATE", blackFont1));
				resumeTable1.addCell(new Paragraph(startDate1, blackFont1));
				resumeTable1
						.addCell(new Paragraph("CUSTOMER NAME", blackFont1));
				resumeTable1.addCell(new Paragraph(applicantName, blackFont1));
				resumeTable1
						.addCell(new Paragraph("POSTAL ADDRESS", blackFont1));
				resumeTable1.addCell(new Paragraph(postalAddress, blackFont1));
				resumeTable1.addCell(new Paragraph("CELL NUMBER", blackFont1));
				resumeTable1.addCell(new Paragraph(mobileNo, blackFont1));
				resumeTable1.addCell(new Paragraph("PLACE OF EMPLOYMENT",
						blackFont1));
				resumeTable1.addCell(new Paragraph(employerName, blackFont1));

				document.add(resumeTable1);
				document.add(new Paragraph("\n"));

				PdfPTable resumeTable2 = new PdfPTable(2);
				resumeTable2.setWidthPercentage(100);
				resumeTable2.setHorizontalAlignment(Element.ALIGN_LEFT);
				resumeTable2.setWidths(new int[] { 7, 6 });
				resumeTable2.getDefaultCell().setBorder(Rectangle.BOX);

				resumeTable2.addCell(new Paragraph("ACTUAL LOAN AMOUNT",
						blackFont));
				resumeTable2.addCell(new Paragraph("", blackFont1));
				resumeTable2.addCell(new Paragraph("REQUESTED LOAN AMOUNT",
						blackFont1));
				resumeTable2.addCell(new Paragraph(String.format("%.2f",
						(loanAmount)), blackFont1));
				resumeTable2
						.addCell(new Paragraph("INITIATION FEE", blackFont1));
				resumeTable2.addCell(new Paragraph(String.format("%.2f",
						(initiationfee)), blackFont1));
				resumeTable2.addCell(new Paragraph(
						"TOTAL LOAN AMOUNT (Requested Loan + Charges)",
						blackFont1));
				resumeTable2.addCell(new Paragraph(String.format("%.2f",
						(loanAndCharges)), blackFont1));
				resumeTable2
						.addCell(new Paragraph("INITIATION FEE", blackFont1));
				resumeTable2.addCell(new Paragraph(String.format("%.2f",
						(initiationfee)), blackFont1));
				resumeTable2.addCell(new Paragraph("LEVEL TERM INSURANCE",
						blackFont1));
				resumeTable2.addCell(new Paragraph(String.format("%.2f",
						(levelTermInsurance)), blackFont1));
				resumeTable2.addCell(new Paragraph(
						"TOTAL PREMIUMS TO BE REMITTED TO INSURANCE",
						blackFont1));
				resumeTable2.addCell(new Paragraph(String.format("%.2f",
						(levelTermInsurance)), blackFont1));
				resumeTable2.addCell(new Paragraph("TOTAL LOAN AMOUNT",
						blackFont1));
				resumeTable2.addCell(new Paragraph(String.format("%.2f",
						(loanAndCharges)), blackFont1));

				document.add(resumeTable2);

				document.add(new Paragraph("\n"));

				PdfPTable resumeTable3 = new PdfPTable(2);
				resumeTable3.setWidthPercentage(100);
				resumeTable3.setHorizontalAlignment(Element.ALIGN_LEFT);
				resumeTable3.setWidths(new int[] { 7, 6 });
				resumeTable3.getDefaultCell().setBorder(Rectangle.BOX);

				resumeTable3.addCell(new Paragraph("OTHER INFORMAITON",
						blackFont));
				resumeTable3.addCell(new Paragraph("", blackFont1));
				resumeTable3.addCell(new Paragraph("INTEREST", blackFont1));
				resumeTable3.addCell(new Paragraph(String.format("%.2f",
						(interestRate)), blackFont1));
				resumeTable3.addCell(new Paragraph("PURPOSE", blackFont1));
				resumeTable3.addCell(new Paragraph(loanType, blackFont1));
				resumeTable3.addCell(new Paragraph("PERIOD", blackFont1));
				resumeTable3.addCell(new Paragraph(
						(String.valueOf(loanPeriod)), blackFont1));
				resumeTable3.addCell(new Paragraph("PRINCIPAL REPAYMENT",
						blackFont1));
				resumeTable3.addCell(new Paragraph(String.format("%.2f",
						(totalRepayment - managementFee)), blackFont1));
				resumeTable3
						.addCell(new Paragraph("MANAGEMENT FEE", blackFont1));
				resumeTable3.addCell(new Paragraph(String.format("%.2f",
						(managementFee)), blackFont1));
				resumeTable3.addCell(new Paragraph("TOTAL REPAYMENT",
						blackFont1));
				resumeTable3.addCell(new Paragraph(String.format("%.2f",
						(totalRepayment)), blackFont1));
				resumeTable3.addCell(new Paragraph("CUSTOMER CIF", blackFont1));
				resumeTable3.addCell(new Paragraph(cif, blackFont1));
				resumeTable3
						.addCell(new Paragraph("BANKERS REPORT", blackFont1));
				resumeTable3.addCell(new Paragraph(businessConsultantComment,
						blackFont1));

				document.add(resumeTable3);

				document.add(new Paragraph("\n"));

				PdfPTable resumeTable4 = new PdfPTable(2);
				resumeTable4.setWidthPercentage(100);
				resumeTable4.setHorizontalAlignment(Element.ALIGN_LEFT);
				resumeTable4.setWidths(new int[] { 7, 6 });
				resumeTable4.getDefaultCell().setBorder(Rectangle.BOX);

				resumeTable4.addCell(new Paragraph("ELIGIBILITY", blackFont));
				resumeTable4.addCell(new Paragraph("", blackFont1));
				resumeTable4.addCell(new Paragraph("GROSS PAY", blackFont1));
				resumeTable4.addCell(new Paragraph(String.format("%.2f",
						(basicSalary)), blackFont1));
				resumeTable4.addCell(new Paragraph(
						"PROPOSED MONTHLY REPAYMENT", blackFont1));
				resumeTable4.addCell(new Paragraph(String.format("%.2f",
						(totalRepayment)), blackFont1));
				resumeTable4.addCell(new Paragraph("OTHER LOANS DEDUCTION",
						blackFont1));
				resumeTable4.addCell(new Paragraph((String
						.valueOf(debtorsName1Amount)), blackFont1));
				resumeTable4.addCell(new Paragraph("OTHER LOANS DEDUCTION",
						blackFont1));
				resumeTable4.addCell(new Paragraph((String
						.valueOf(debtorsName2Amount)), blackFont1));
				resumeTable4.addCell(new Paragraph("OTHER LOANS DEDUCTION",
						blackFont1));
				resumeTable4.addCell(new Paragraph((String
						.valueOf(debtorsName3Amount)), blackFont1));
				resumeTable4.addCell(new Paragraph("TOTAL DEDUCTIONS",
						blackFont1));
				resumeTable4.addCell(new Paragraph(String.format("%.2f",
						(totalRepayment)), blackFont1));
				resumeTable4.addCell(new Paragraph("COMMITMENT", blackFont1));
				resumeTable4.addCell(new Paragraph("", blackFont1));
				resumeTable4.addCell(new Paragraph("", blackFont1));
				resumeTable4.addCell(new Paragraph("", blackFont1));
				resumeTable4.addCell(new Paragraph("PREVIOUS LOAN AMOUNT",
						blackFont1));
				resumeTable4.addCell(new Paragraph(String
						.valueOf(previousLoanBalances), blackFont1));

				document.add(resumeTable4);

			} catch (Exception e) {
				e.printStackTrace();
			}
			document.close();

		} else if (submitLoan != null) {

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();

			if (con != null) {
				String sql = "UPDATE [SwaziBankIntranet2016].[dbo].[branchLoan] "
						+ "SET [branchManagerComment] = '"
						+ branchManagerComment
						+ "'"
						+ ",[branchManagerCommentDate] = '"
						+ branchManagerCommentDate
						+ "'"
						+ ",[creditAnalystName] = '"
						+ creditAnalystName
						+ "'"
						+ ",[creditAnalystEmail] = '"
						+ creditAnalystEmail
						+ "'"
						+ ",[lastModifiedBy] = '"
						+ lastModifiedBy
						+ "'"
						+ ",[lastModifiedDate] = '"
						+ lastModifiedDate
						+ "'"
						+ ",[loanStatus] = 'Pending Credit Analysts Comments'"
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
					String to = creditAnalystEmail;
					String from = "staffLoanApplication@swazibank.co.sz";
					String host = "mail.swazibank.co.sz";
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
								+ creditAnalystName

								+ "\n\n"
								+ "A new Branch Personal Loan has been Submitted by: "
								+ "  "
								+ businessConsultantName.toUpperCase()
								+ " with reference: "
								+ loanReference
								+ "."
								+ "\nPlease Click on the link http://live-intranet:8080/EsdbLoanAutomation/BranchLoanCreditAnalystRequest to comment."
								+ "\n\n"
								+ "Click this link to see the loan attachments"
								+ "\n\n"
								+ "This mail is Auto generated. Please Contact the Applicant on "
								+ creditManagerEmail
								+ " for additional Information." + "\n"
								+ "\n warm regards" + "\n IT Department");
						Transport.send(message);

					} catch (MessagingException mex) {
						mex.printStackTrace();
					}
					System.out.println();
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
}