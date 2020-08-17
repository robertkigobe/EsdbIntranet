package technicalResources.staffLoan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.FinanceLib;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;

import util.ConnectionHelper;

/**
 * Servlet implementation class ItAdmin
 */
@WebServlet("/StaffLoanSecurities")
@MultipartConfig(maxFileSize = 100000000)
public class StaffLoanSecurities extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DateFormat inSdf = new SimpleDateFormat("mm/dd/yyyy");
	private static final DateFormat outSdf = new SimpleDateFormat("yyyy-mm-dd");
	public static Connection con;
	public static String filename;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		Calendar cal = Calendar.getInstance();
		
		Statement selectStatement = null;
		ResultSet results = null;

		DateTimeFormatter formatter1 = DateTimeFormatter
				.ofPattern("yyyy-MM-dd");
		
		

		String dayOne = null;
		int dayOneP = 0;
		String monthOneV = null;
		int monthOne = 0;
		int yearOne = 0;

		String employeeLoanRef = request.getParameter("employeeLoanRef");

		String administationFee = null;
		String allowances = null;
		String applicantComment = null;
		String applicantCommentDate = null;
		String bankExecutioner = null;
		String bankExecutionerCapacity = null;
		String basicSalary = null;
		String boxAddress = null;
		String branchAdress = null;
		String carloanDeductions = null;
		String carloanBalance = null;
		String cif = null;
		String city = null;
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
		String employeeName = null;
		String employeePosition = null;
		String employeeDepartment = null;
		String establishmentFee = null;
		String farm_smallHolderDeductions = null;
		String farm_smallHolderBalance = null;
		String firstname = null;
		String hodComment = null;
		String hodCommentDate = null;
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
		String levelTermInsurance = null;
		String loanAmount = null;
		String loanAmountWords = null;
		String loanStatus = null;
		String loanType = null;
		String location = null;
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
		String securitiesPrinted = null;
		String seniorHrManagerComment = null;
		String seniorHrManagerCommentDate = null;
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
		double loanAmount1 = 0.0;

		//ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT * "
					+ "FROM [SwaziBankIntranet2016].[dbo].[staffLoan] "
					+ "where [employeeLoanRef] = '" + employeeLoanRef + "' ";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					administationFee = results.getString("administationFee");
					allowances = results.getString("allowances");
					applicantComment = results.getString("applicantComment");
					applicantCommentDate = results
							.getString("applicantCommentDate");
					bankExecutioner = results.getString("bankExecutioner");
					bankExecutionerCapacity = results
							.getString("bankExecutionerCapacity");
					basicSalary = results.getString("basicSalary");
					boxAddress = results.getString("boxAddress");
					branchAdress = results.getString("branchAdress");
					carloanDeductions = results.getString("carloanDeductions");
					carloanBalance = results.getString("carloanBalance");
					cif = results.getString("cif");
					city = results.getString("city");
					cityCouncilRatesDeductions = results
							.getString("cityCouncilRatesDeductions");
					cityCouncilRatesBalance = results
							.getString("cityCouncilRatesBalance");
					createdBy = results.getString("createdBy");
					dateloanRequired = results.getString("dateloanRequired");
					dateOfBirth = results.getString("dateOfBirth");
					dateEngaged = results.getString("dateEngaged");
					dateOfFirstInstallment = results
							.getString("dateOfFirstInstallment");
					dateOfLastInstallment = results
							.getString("dateOfLastInstallment");
					educationalloanDeductions = results
							.getString("educationalloanDeductions");
					educationalloanBalance = results
							.getString("educationalloanBalance");
					emailAddress = results.getString("emailAddress");
					employeeCode = results.getString("employeeCode");
					employeeEmail = results.getString("employeeEmail");
					employeeGrade = results.getString("employeeGrade");
					employeePosition = results.getString("employeePosition");
					employeeDepartment = results
							.getString("employeeDepartment");
					employeeLoanRef = results.getString("employeeLoanRef");
					establishmentFee = results.getString("establishmentFee");
					farm_smallHolderDeductions = results
							.getString("farm_smallHolderDeductions");
					farm_smallHolderBalance = results
							.getString("farm_smallHolderBalance");
					firstname = results.getString("firstname");
					hodComment = results.getString("hodComment");
					hodCommentDate = results.getString("hodCommentDate");
					hod = results.getString("hod");
					hodEmail = results.getString("hodEmail");
					housingloanDeductions = results
							.getString("housingloanDeductions");
					housingloanBalance = results
							.getString("housingloanBalance");
					iDNumber = results.getString("iDNumber");
					instalment = results.getString("instalment");
					insurancesDeductions = results
							.getString("insurancesDeductions");
					insurancesBalance = results.getString("insurancesBalance");
					interestRate = results.getString("interestRate");
					lastModifiedBy = results.getString("lastModifiedBy");
					lastModifiedDate = results.getString("lastModifiedDate");
					levelTermInsurance = results.getString("levelTermInsurance");
					loanAmount = results.getString("loanAmount");
					
					System.out.println("loanAmount======>>" +String.valueOf(Double.valueOf(loanAmount)) );
					System.out.println("levelTermInsurance======>>" +String.valueOf(Double.valueOf(levelTermInsurance)) );
					
					loanAmount1 = Double.valueOf(loanAmount) - Double.valueOf(levelTermInsurance);
					location = results.getString("location");
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
					seniorHrManagerComment =   results.getString("seniorHrManagerComment");
					seniorHrManagerCommentDate =   results.getString("seniorHrManagerCommentDate");
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

					employeeName = firstname + " " + surname;

					NumberFormat formatter = NumberFormat.getCurrencyInstance();
					int loanPeriod = 0;
					Date startDate2 = null;
					//Calendar cal = null;

					double rate = Double.valueOf(interestRate);
					double finalValue = 0;
					String startDate1 = dateOfFirstInstallment;
					String endDate1 = dateOfLastInstallment;
					
					// /////////////date insert///////////////////
					Date dateOpenedN = new Date();
					String dateCreated = sdf.format(dateOpenedN);
					// /////////////date insert///////////////////

					try{ 
						Date doFirstInstallment = inSdf.parse(dateOfFirstInstallment);
						startDate1 = outSdf.format(doFirstInstallment);
						Date doLastInstallment = inSdf.parse(dateOfLastInstallment);
						endDate1 = outSdf.format(doLastInstallment);
						
					
					}catch(ParseException se){}
					
					// convert String to LocalDate
					LocalDate localDate = LocalDate.parse(startDate1, formatter1);
					
					//NumberFormat formatter = NumberFormat.getCurrencyInstance();
					try {
						startDate2 = dateFormat.parse(startDate1);
						dayOneP = localDate.getDayOfMonth();
						monthOne = localDate.getMonthValue();
						yearOne = localDate.getYear();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					loanPeriod = (int) ChronoUnit.MONTHS.between(LocalDate
							.parse(startDate1).withDayOfMonth(1), LocalDate.parse(endDate1)
							.withDayOfMonth(1)) + 1;
					
					
					
					
					if (dayOneP == 1) {
						dayOne = "1st";
					} else 					if (dayOneP == 2) {
						dayOne = "2nd";
					} else 					if (dayOneP == 3) {
						dayOne = "3rd";
					} else 					if (dayOneP == 4) {
						dayOne = "4th";
					} else 					if (dayOneP == 5) {
						dayOne = "5th";
					} else 					if (dayOneP == 6) {
						dayOne = "6th";
					} else 					if (dayOneP == 7) {
						dayOne = "7th";
					} else 					if (dayOneP == 8) {
						dayOne = "8th";
					} else 					if (dayOneP == 9) {
						dayOne = "9th";
					} else 					if (dayOneP == 10) {
						dayOne = "10th";
					} else if (dayOneP == 11) {
						dayOne = "11tt";
					} else 					if (dayOneP == 12) {
						dayOne = "12th";
					} else 					if (dayOneP == 13) {
						dayOne = "13th";
					} else 					if (dayOneP == 14) {
						dayOne = "14th";
					} else 					if (dayOneP == 15) {
						dayOne = "15th";
					} else 					if (dayOneP == 16) {
						dayOne = "16th";
					} else 					if (dayOneP == 17) {
						dayOne = "17th";
					} else 					if (dayOneP == 18) {
						dayOne = "18th";
					} else 					if (dayOneP == 19) {
						dayOne = "19th";
					} else 					if (dayOneP == 20) {
						dayOne = "20th";
					} else if (dayOneP == 21) {
						dayOne = "21st";
					} else 					if (dayOneP == 22) {
						dayOne = "22nd";
					} else 					if (dayOneP == 23) {
						dayOne = "23rd";
					} else 					if (dayOneP == 24) {
						dayOne = "24th";
					} else 					if (dayOneP == 25) {
						dayOne = "25th";
					} else 					if (dayOneP == 26) {
						dayOne = "26th";
					} else 					if (dayOneP == 27) {
						dayOne = "27th";
					} else 					if (dayOneP == 28) {
						dayOne = "28th";
					} else 					if (dayOneP == 29) {
						dayOne = "29th";
					} else 					if (dayOneP == 30) {
						dayOne = "30th";
					} else if (dayOneP == 31) {
						dayOne = "31st";
					}
					
					
					if (monthOne == 1) {
						monthOneV = "January";
					} else if (monthOne == 2) {
						monthOneV = "February";
					} else if (monthOne == 3) {
						monthOneV = "March";
					} else if (monthOne == 4) {
						monthOneV = "April";
					} else if (monthOne == 5) {
						monthOneV = "May";
					} else if (monthOne == 6) {
						monthOneV = "June";
					} else if (monthOne == 7) {
						monthOneV = "July";
					} else if (monthOne == 8) {
						monthOneV = "August";
					} else if (monthOne == 9) {
						monthOneV = "September";
					} else if (monthOne == 10) {
						monthOneV = "October";
					} else if (monthOne == 11) {
						monthOneV = "November";
					} else if (monthOne == 12) {
						monthOneV = "December";
					}
					loanPeriod = (int) ChronoUnit.MONTHS.between(LocalDate
							.parse(startDate1).withDayOfMonth(1), LocalDate
							.parse(endDate1).withDayOfMonth(1)) + 1;

					double mortgageProtectionPolicy = (double) (((loanAmount1 / 1000) * 10.94) / 12);
					double houseOwnersCoverage = (double) ((loanAmount1 * 0.00275) / 12);

					// /////////////////////new//////////////////

					Date paymentDate;
					double r = (rate / 100) / 12;
					double presentValue = loanAmount1;
					int paymentNo;
					double beginingBalance = 0;
					double scheduledPayment = 0;
					double totalEarlyPayments = 0;
					double extraPayment = 0;
					double totalPayment = 0;
					double principal = 0;
					double interest = 0;
					double endingBalance = 0;
					double totalInterest = 0;
					totalInterest = interest * loanPeriod;

					float totalDeductions = 0;
					float totalBalances = 0;
					float netSalary = 0;
					double cummulativePercentage = 0;
					double cummulativePercentageB = 0;
					float repaymentAmount = 0;

					float funeralCover = (float) 5000.00;
					long millis = System.currentTimeMillis();
					java.sql.Date date = new java.sql.Date(millis);
					int customerAge = (int) ChronoUnit.YEARS.between(LocalDate
							.parse(dateOfBirth).withDayOfMonth(1), LocalDate
							.parse(date.toString()).withDayOfMonth(1));
					double x = 0;
					double singlePremium = 0;

					double initiationfee = 0;
					double loanAndCharges = 0;
					// double remittedInsurance = 0;
					// double totalLoanAmount = 0;
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

					loanAndCharges = Double.valueOf(levelTermInsurance)
							+ initiationfee + loanAmount1;
					// totalLoanAmount = loanAndCharges + levelTermInsurance;
					// remittedInsurance = (x * loanAndCharges / 1000) +
					// singlePremium;
					double totalRepayment = -(FinanceLib.pmt(r, loanPeriod,
							loanAndCharges, finalValue, false));

					totalDeductions = Float.valueOf(otherDeductions)
							+ Float.valueOf(insurancesDeductions)
							+ Float.valueOf(cityCouncilRatesDeductions)
							+ Float.valueOf(educationalloanDeductions)
							+ Float.valueOf(personalloanDeductions)
							+ Float.valueOf(carloanDeductions)
							+ Float.valueOf(farm_smallHolderDeductions)
							+ Float.valueOf(ruralHousingloanDeductions)
							+ Float.valueOf(housingloanDeductions);
					totalBalances = Float.valueOf(otherBalance)
							+ Float.valueOf(insurancesBalance)
							+ Float.valueOf(cityCouncilRatesBalance)

							+ Float.valueOf(educationalloanBalance)
							+ Float.valueOf(personalloanBalance)
							+ Float.valueOf(carloanBalance)
							+ Float.valueOf(farm_smallHolderBalance)
							+ Float.valueOf(ruralHousingloanBalance)
							+ Float.valueOf(housingloanBalance);

					netSalary = (Float.valueOf(allowances) + Float.valueOf(basicSalary))
							- (Float.valueOf(totalDeductions) 
									+ Float.valueOf(otherDeductionsExcLeaveAllowance) 
									+ Float.valueOf(targetSavings) 
									+ Float.valueOf(statutoryDeductions));
					
					System.out.println(Float.valueOf(allowances));
					System.out.println(Float.valueOf(basicSalary));
					System.out.println(Float.valueOf(totalDeductions));
					System.out.println(Float.valueOf(otherDeductionsExcLeaveAllowance));
					System.out.println(Float.valueOf(targetSavings));
					System.out.println(Float.valueOf(statutoryDeductions));
					
					
					
					cummulativePercentage = (totalDeductions + totalRepayment);
					cummulativePercentageB = (cummulativePercentage / Double
							.valueOf(basicSalary)) * 100;

					loanPeriod = (int) ChronoUnit.MONTHS.between(LocalDate
							.parse(startDate1).withDayOfMonth(1), LocalDate
							.parse(endDate1).withDayOfMonth(1)) + 1;

					// //////////////////////////////////////////

					Font blackFont1 = FontFactory.getFont(
							FontFactory.HELVETICA, 9, Font.NORMAL);
					Font blackFont = FontFactory.getFont(FontFactory.HELVETICA,
							7, Font.NORMAL);
					
					Font blackFont2 = FontFactory.getFont(FontFactory.HELVETICA,
							7, Font.BOLD);
					Font blackFontListHeading = FontFactory.getFont(
							FontFactory.TIMES_BOLD, 12, Font.NORMAL);
					
					Font blackFontListHeading1 = FontFactory.getFont(
							FontFactory.TIMES_BOLD, 10, Font.NORMAL);

					Font blackFontParameter1 = FontFactory.getFont(
							FontFactory.HELVETICA, 7, Font.BOLD);

					Font blackFontParameter12 = FontFactory.getFont(
							FontFactory.HELVETICA, 7, Font.UNDERLINE);

					

					Document document = new Document();

					try {

						response.setContentType("application/pdf");
						PdfWriter.getInstance(document,	response.getOutputStream());
						document.open();
						document.add(new Chunk(""));
						
						Image img = Image.getInstance("C:/IntranetWarehouse/StaffLoan/logo/logo.png");
						
						
						// //////////////////Finance Facility //////////////////

						
						document.add(img);
						
						
						
						
						Paragraph nl = new Paragraph(
								"Pre Quotation\n\n", blackFontListHeading);
						document.add(nl);

						PdfPTable finfac = new PdfPTable(2);
						finfac.setWidthPercentage(100);
						finfac.setHorizontalAlignment(Element.ALIGN_LEFT);
						finfac.setWidths(new int[] { 5, 5 });
						finfac.getDefaultCell().setBorder(Rectangle.NO_BORDER);

						finfac.addCell("Between:");
						finfac.addCell("Eswatini Development and Savings Bank\n(Hereinafter referred to as “the bank”)");
						finfac.addCell(" \n");
						finfac.addCell(" \n");

						finfac.addCell("Physical Address:\n(The Bank)");
						finfac.addCell("Eswatini Bank Head Office, Engungwini Building, Gwamile Street,Mbabane”)");

						finfac.addCell("");
						finfac.addCell("______________________________________");

						finfac.addCell("And");
						finfac.addCell(employeeName);

						finfac.addCell("");
						finfac.addCell("______________________________________");

						finfac.addCell("Postal Address");
						finfac.addCell(boxAddress + " " + city);
						finfac.addCell(" \n");
						finfac.addCell(" \n");

						finfac.addCell(new Paragraph("The Loan",
								blackFontParameter1));
						finfac.addCell(" \n");
						document.add(finfac);

						PdfPTable finfac2 = new PdfPTable(2);
						finfac2.setWidthPercentage(100);
						finfac2.setHorizontalAlignment(Element.ALIGN_LEFT);
						finfac2.setWidths(new int[] { 5, 8 });
						finfac2.getDefaultCell().setBorder(Rectangle.BOX);

						finfac2.addCell("Loan Type: ");
						finfac2.addCell(loanType);
						finfac2.addCell("Amount: ");
						finfac2.addCell(loanAmount);
						finfac2.addCell("Application Fees (0)%: ");
						finfac2.addCell("");
						finfac2.addCell("Establishment Fees (0)%: ");
						finfac2.addCell("");
						finfac2.addCell("Administration Fees: ");
						finfac2.addCell("");
						finfac2.addCell("Total Collectable: ");
						finfac2.addCell(loanAmount);
						finfac2.addCell("Repayment Period: ");
						finfac2.addCell(repaymentPeriod);
						finfac2.addCell("Repayment Amount: ");
						finfac2.addCell(String.valueOf(instalment));
						finfac2.addCell("Commencement Date: ");
						finfac2.addCell(dateOfFirstInstallment);
						finfac2.addCell("End Date: ");
						finfac2.addCell(dateOfLastInstallment);
						document.add(finfac2);

						Phrase ffp1 = new Phrase();
						ffp1.add(new Chunk("Interest\n", blackFontParameter1));
						ffp1.add(new Chunk(
								"The loan shall bear an interest at a rate equal E ",
								blackFont1));
						ffp1.add(new Chunk(instalment, blackFontParameter1));
						ffp1.add(new Chunk(
								" compounded monthly commencing on the ",
								blackFont1));
						ffp1.add(new Chunk(" the   ", blackFont1));
						ffp1.add(new Chunk(dateOfFirstInstallment,
								blackFontParameter1));
						ffp1.add(new Chunk(
								" and thereafter on the last day of each and every successive month.",
								blackFont1));
						document.add(ffp1);

						Phrase ffp2 = new Phrase();
						ffp2.add(new Chunk("\nSecurity\n", blackFontParameter1));
						ffp2.add(new Chunk(
								"Notwithstanding anything to the contrary in this Agreement, the Borrower shall not be entitled to draw down under the loan unless until the Borrower has furnished the Bank with the Deposit or commitment fee and the following securities:",
								blackFont1));
						ffp2.add(new Chunk("\n",blackFont1));
						ffp2.add(new Chunk("\n1.	Letter of Offer",blackFont1));
						ffp2.add(new Chunk("\n2.	The Agreement",blackFont1));
						ffp2.add(new Chunk("\n3.	Acknowledgement of Debt",blackFont1));
						ffp2.add(new Chunk("\n4.	Letter of Set Off",blackFont1));
						ffp2.add(new Chunk("\n5.	Irrevocable Pledge",blackFont1));
						ffp2.add(new Chunk("\n6.	Stop Order",blackFont1));
						ffp2.add(new Chunk("\n7.	Level Term Insurance",blackFont1));
					
						document.add(ffp2);
					
						
						// ///////////STAFF LOAN APPLICATION/////////////////
						document.newPage();
						document.add(img);

						Paragraph applicationLetterParagraph2 = new Paragraph(
								"1. STAFF LOAN APPLICANT’S PARTICULARS\n",
								blackFontListHeading1);
						document.add(applicationLetterParagraph2);
						document.add(new Paragraph("\n"));

						PdfPTable table = new PdfPTable(2);
						table.setWidthPercentage(100);
						table.setHorizontalAlignment(Element.ALIGN_LEFT);
						table.setWidths(new int[] { 5, 8 });
						table.getDefaultCell().setBorder(Rectangle.BOX);

						table.addCell(new Paragraph("Name: ", blackFont1));
						table.addCell(new Paragraph(
								(firstname + " " + surname), blackFont1));
						table.addCell(new Paragraph("Employment No: ",
								blackFont1));
						table.addCell(new Paragraph((employeeCode), blackFont1));
						table.addCell(new Paragraph("Date of Birth: ",
								blackFont1));
						table.addCell(new Paragraph((dateOfBirth), blackFont1));
						table.addCell(new Paragraph("Branch: ", blackFont1));
						table.addCell(new Paragraph((location), blackFont1));
						table.addCell(new Paragraph("Position Held: ",
								blackFont1));
						table.addCell(new Paragraph((employeePosition),
								blackFont1));
						table.addCell(new Paragraph("Basic Monthly Salary: ",
								blackFont1));
						table.addCell(new Paragraph(
								String.valueOf(basicSalary), blackFont1));
						table.addCell(new Paragraph("Marital Status: ",
								blackFont1));
						table.addCell(new Paragraph((maritalStatus), blackFont1));
						table.addCell(new Paragraph("Position Grade: ",
								blackFont1));
						table.addCell(new Paragraph((employeeGrade), blackFont1));
						table.addCell(new Paragraph("Address: ", blackFont1));
						table.addCell(new Paragraph((resAddress), blackFont1));
						table.addCell(new Paragraph("No. of Dependants: ",
								blackFont1));
						table.addCell(new Paragraph((String
								.valueOf(noOfDependants)), blackFont1));
						table.addCell(new Paragraph("Date Employed: ",
								blackFont1));
						table.addCell(new Paragraph((dateEngaged), blackFont1));
						table.addCell(new Paragraph("Tel / Cell: ", blackFont1));
						table.addCell(new Paragraph((telelephoneNo), blackFont1));

						document.add(table);

						Paragraph applicationLetterParagraph3 = new Paragraph(
								"2. LOAN PURPOSE: "
										+ (new Paragraph(purposeOfLoan,
												blackFontListHeading1)),
								blackFontListHeading);
						document.add(applicationLetterParagraph3);
						document.add(new Paragraph("\n"));

						PdfPTable table61 = new PdfPTable(3);
						table61.setWidthPercentage(100);
						table61.setHorizontalAlignment(Element.ALIGN_CENTER);
						table61.setWidths(new int[] { 7, 3, 5 });
						table61.getDefaultCell().setBorder(Rectangle.BOX);

						table61.addCell(new Paragraph(
								("3. Loan Type: " + loanType), blackFontListHeading1));
						table61.addCell(new Paragraph(
								("Loan Amount: " + loanAndCharges), blackFont1));
						table61.addCell(new Paragraph(
								("Date Loan is required: " + dateloanRequired),
								blackFont1));
						document.add(table61);

						Paragraph applicationLetterParagraph30 = new Paragraph(
								"4. RECENT SALARY ADVICE DETAILS",
								blackFontListHeading1);
						document.add(applicationLetterParagraph30);
						document.add(new Paragraph("\n"));

						PdfPTable table1 = new PdfPTable(2);
						table1.setWidthPercentage(100);
						table1.setHorizontalAlignment(Element.ALIGN_LEFT);
						table1.setWidths(new int[] { 8, 4 });
						table1.getDefaultCell().setBorder(Rectangle.BOX);

						table1.addCell(new Paragraph(("Basic Salary:"),
								blackFont1));
						table1.addCell(new Paragraph((" E " + String
								.valueOf(Float.valueOf(basicSalary))),
								blackFont1));

						table1.addCell(new Paragraph(
								("Allowances (exc. Overtime& leave all:"),
								blackFont1));
						table1.addCell(new Paragraph((" E " + String
								.valueOf(Float.valueOf(allowances))),
								blackFont1));

						table1.addCell(new Paragraph(("Total Earnings:"),
								blackFont1));
						table1.addCell(new Paragraph((" E " + String
								.valueOf(Float.valueOf(allowances)
										+ Float.valueOf(basicSalary))),
								blackFont1));

						document.add(table1);

						Paragraph applicationLetterParagraph31 = new Paragraph(
								"5. Current Loans and Balances: ",
								blackFontListHeading);
						document.add(applicationLetterParagraph31);
						document.add(new Paragraph("\n"));

						PdfPTable table2 = new PdfPTable(3);
						table2.setWidthPercentage(100);
						table2.setHorizontalAlignment(Element.ALIGN_CENTER);
						table2.setWidths(new int[] { 5, 5, 5 });
						table2.getDefaultCell().setBorder(Rectangle.BOX);

						table2.addCell(new Paragraph(("ITEM"), blackFont1));
						table2.addCell(new Paragraph(("DEDUCTION"), blackFont1));
						table2.addCell(new Paragraph(("BALANCE"), blackFont1));
						table2.addCell(new Paragraph(
								("(4) Housing Loan (Mortgage)"), blackFont1));
						table2.addCell(new Paragraph(
								(" E " + String.valueOf(Float
										.valueOf(housingloanDeductions))),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f", (Float.valueOf(housingloanBalance)))),
								blackFont1));

						table2.addCell(new Paragraph(
								("(5) Rural Housing Loan"), blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f",
								(Float.valueOf(ruralHousingloanDeductions)))),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f",
								(Float.valueOf(ruralHousingloanBalance)))),
								blackFont1));

						table2.addCell(new Paragraph(
								("(6) Farm / Small Holder"), blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f",
								(Float.valueOf(farm_smallHolderDeductions)))),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f",
								(Float.valueOf(farm_smallHolderBalance)))),
								blackFont1));

						table2.addCell(new Paragraph(("(7) Car Loan"),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f", (Float.valueOf(carloanDeductions)))),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f", (Float.valueOf(carloanBalance)))),
								blackFont1));

						table2.addCell(new Paragraph(
								("(8) Personal Loan (36 Months)"), blackFont1));
						table2.addCell(new Paragraph(
								(" E " + String
										.format("%.2f",
												(Float.valueOf(personalloanDeductions)))),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f", (Float.valueOf(personalloanBalance)))),
								blackFont1));

						table2.addCell(new Paragraph(
								("(9) Educational Loan (12 Months)"),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f",
								(Float.valueOf(educationalloanDeductions)))),
								blackFont1));
						table2.addCell(new Paragraph(
								(" E " + String
										.format("%.2f",
												(Float.valueOf(educationalloanBalance)))),
								blackFont1));

						table2.addCell(new Paragraph(
								("(11) City Council Rates"), blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f",
								(Float.valueOf(cityCouncilRatesDeductions)))),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f",
								(Float.valueOf(cityCouncilRatesBalance)))),
								blackFont1));

						table2.addCell(new Paragraph(("(12) Insurances"),
								blackFont1));
						table2.addCell(new Paragraph(
								(" E " + String.format("%.2f",
										(Float.valueOf(insurancesDeductions)))),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f", (Float.valueOf(insurancesBalance)))),
								blackFont1));

						table2.addCell(new Paragraph(("(13) Other Loans"),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f", (Float.valueOf(otherDeductions)))),
								blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f", (Float.valueOf(otherBalance)))),
								blackFont1));

						table2.addCell(new Paragraph(("(14) Total"), blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f", (totalDeductions))), blackFont1));
						table2.addCell(new Paragraph((" E " + String.format(
								"%.2f", (totalBalances))), blackFont1));

						document.add(table2);

						PdfPTable table3 = new PdfPTable(2);
						table3.setWidthPercentage(100);
						table3.setHorizontalAlignment(Element.ALIGN_LEFT);
						table3.setWidths(new int[] { 8, 4 });
						table3.getDefaultCell().setBorder(Rectangle.BOX);

						table3.addCell(new Paragraph(
								("(15) Other deductions(excl. Leave allowance)"),
								blackFont1));
						table3.addCell(new Paragraph((" E " + String
								.valueOf(otherDeductionsExcLeaveAllowance)),
								blackFont1));

						table3.addCell(new Paragraph(("(16) Target Savings:"),
								blackFont1));
						table3.addCell(new Paragraph((" E " + String
								.valueOf(targetSavings)), blackFont1));

						table3.addCell(new Paragraph(
								("(17) Statutory Deductions(Paye+ Snpf)"),
								blackFont1));
						table3.addCell(new Paragraph((" E " + String
								.valueOf(statutoryDeductions)), blackFont1));

						table3.addCell(new Paragraph(
								("(18) NET SALARY (3) -  (14,15,16, 17)"),
								blackFont1));
						table3.addCell(new Paragraph((" E " + String.format(
								"%.2f", (netSalary))), blackFont1));

						document.add(table3);
						

						Paragraph applicationLetterParagraph9 = new Paragraph(
								"6. AMOUNT REQUIRED AND REPAYMENT ARRANGEMENTS: ",
								blackFontListHeading);
						document.add(applicationLetterParagraph9);
						document.add(new Paragraph("\n"));

						PdfPTable table7 = new PdfPTable(4);
						table7.setWidthPercentage(100);
						table7.setHorizontalAlignment(Element.ALIGN_LEFT);
						table7.setWidths(new int[] { 5, 3, 6, 3 });
						table7.getDefaultCell().setBorder(Rectangle.BOX);

						table7.addCell(new Paragraph(("NEW LOAN: " + loanType),
								blackFont1));
						table7.addCell(new Paragraph(("INTEREST RATE:"
								+ interestRate + "%"), blackFont1));
						table7.addCell(new Paragraph(
								("REPAYMENT PERIOD IN MONTHS: " + loanPeriod),
								blackFont1));
						table7.addCell(new Paragraph(
								("INSTALMENT:" + " E " + String.format("%.2f",
										(totalRepayment))), blackFont1));

						table7.addCell(". ");
						table7.addCell(". ");
						table7.addCell(new Paragraph(
								("CUM. PERCENTAGE (14 +19) / 3:"), blackFont1));
						table7.addCell(new Paragraph(String.format("%.2f",
								(cummulativePercentageB)) + "%", blackFont1));

						table7.addCell(". ");
						table7.addCell(". ");
						table7.addCell(new Paragraph(
								("19. NET PAY (18) – (19) :"), blackFont1));
						table7.addCell(new Paragraph((" E " + String.format(
								"%.2f", (netSalary - totalRepayment))),
								blackFont1));

						document.add(table7);
						
						document.newPage();

						Paragraph applicationLetterParagraph10 = new Paragraph(
								"\n\nVERIFIED BY H.R. DIVISION…………………………………………………………",
								blackFont1);
						document.add(applicationLetterParagraph10);
						document.add(new Paragraph("\n"));
						PdfPTable table4 = new PdfPTable(1);
						table4.setWidthPercentage(100);
						table4.setHorizontalAlignment(Element.ALIGN_LEFT);
						table4.setWidths(new int[] { 5 });
						table4.getDefaultCell().setBorder(Rectangle.BOX);

						table4.addCell(new Paragraph(
								("6.	APPLICANT’S DECLARATION AND AUTHORISATION"

										+ "\n\nThis application is made under the terms of SwaziBank staff loan Policy current at this time."
										+ "\n\nI declare that the information given here is correct.  To the best of my knowledge and belief I have not omitted any information pertinent this application."
										+ "\n\nI hereby authorize and request SwaziBank to deduct the repayments specified overleaf from my salary to the credit of the relative loans(s) until all outstanding balances and interest have been paid in full."
										+ "\n\nI hereby grant to SwaziBank a lien and right of set off over all accounts whatsoever standing to my credit at SwaziBank."
										+ "\n\nI hereby grant to SwaziBank a lien over any/all terminal benefit due to me with the right to apply such benefits as repayment of any outstanding loans and / or interest."
										+ "\n\nI understand that in the event of my leaving the employment of the bank for any reason the outstanding balances of any loans will immediately become due and payable."
										+ "\n" + "\n" + "\n"

										+ "\nSIGNATURE: ………………………………………………… "),
								blackFont1));

						table4.addCell(new Paragraph(
								("6.	Manager’s / Senior Manager’s / Supervisors comments and recommendations."
										+ "\n\nI confirm that his request is within the terms of the Staff Loans Policy currently in force."
										+ "\n" + "\n" + supervisorComment + " Dated "+supervisorCommentDate+"\n"

										+ "\nSIGNATURE: ………………………………………………… "),
								blackFont1));

						table4.addCell(new Paragraph(
								("7.	EXECUTIVE HEAD OF DEPARTMENT" + "\n"
										+ "\n" +hodComment+  " Dated "+hodCommentDate+ "\n"

										+ "\nSIGNATURE: ………………………………………………… "),
								blackFont1));

						table4.addCell(new Paragraph(("8. APPROVED  / DECLINED"
								+ "\n" + "\n" +seniorHrManagerComment+ " Dated:"+seniorHrManagerCommentDate+ "\n"

								+ "\nSIGNATURE: ………………………………………………… "),
								blackFont1));

						document.add(table4);
						document.add(new Paragraph("\n"));
						/////////////////loan calculator ////////////////
						document.newPage();
						document.add(img);

						Paragraph loanCalculator = new Paragraph(
								"LOAN CALCULATOR\n\n", blackFontListHeading);
						document.add(loanCalculator);

						PdfPTable table50 = new PdfPTable(2);
						table50.setWidthPercentage(100);
						table50.setHorizontalAlignment(Element.ALIGN_LEFT);
						table50.setWidths(new int[] { 5, 8 });
						table50.getDefaultCell().setBorder(Rectangle.BOX);
						table50.addCell(new Paragraph("Date of birth",
								blackFont1));
						table50.addCell(new Paragraph((dateOfBirth), blackFont1));
						table50.addCell(new Paragraph("Employee Age",
								blackFont1));
						table50.addCell(new Paragraph((String
								.valueOf(customerAge)), blackFont1));
						table50.addCell(new Paragraph("Loan Start Date",
								blackFont1));
						table50.addCell(new Paragraph((dateOfFirstInstallment),
								blackFont1));
						table50.addCell(new Paragraph("Loan Period (Months)",
								blackFont1));
						table50.addCell(new Paragraph((String
								.valueOf(loanPeriod)), blackFont1));
						table50.addCell(new Paragraph(
								"Loan Amount Requested after funeral cover",
								blackFont1));
						table50.addCell(new Paragraph((String.format("%.2f",
								(loanAmount1))), blackFont1));
						table50.addCell(new Paragraph("Funeral Cover",
								blackFont1));
						table50.addCell(new Paragraph((String.format("%.2f",
								(funeralCover))), blackFont1));
						table50.addCell(new Paragraph("Initiation Fee",
								blackFont1));
						table50.addCell(new Paragraph(String.format("%.2f",
								(initiationfee)), blackFont1));
						table50.addCell(new Paragraph("Level Term Insurance",
								blackFont1));
						table50.addCell(new Paragraph(String.format("%.2f",
								(Float.valueOf(levelTermInsurance))),
								blackFont1));
						table50.addCell(new Paragraph("Total Loan Amount",
								blackFont1));
						table50.addCell(new Paragraph(String.format("%.2f",
								(loanAndCharges)), blackFont1));
						document.add(table50);

						Paragraph atmotizationHeading = new Paragraph(
								"STAFF LOAN ARMOTIZATION\n\n",
								blackFontListHeading);
						document.add(atmotizationHeading);

						PdfPTable ftable2 = new PdfPTable(9);
						ftable2.setWidthPercentage(100);
						ftable2.setHorizontalAlignment(Element.ALIGN_LEFT);
						ftable2.setWidths(new int[] { 2, 3, 3, 3, 3, 3, 3, 3, 3 });
						ftable2.getDefaultCell().setBorder(Rectangle.BOX);

						ftable2.addCell(new Paragraph("Pmt No:", blackFont2));
						ftable2.addCell(new Paragraph("Pmt Date:", blackFont2));
						ftable2.addCell(new Paragraph("Begining Bal:",
								blackFont2));
						ftable2.addCell(new Paragraph("Scheduled Pmt:",
								blackFont2));
						ftable2.addCell(new Paragraph("Extra Pmt:", blackFont2));
						ftable2.addCell(new Paragraph("Total Pmt:", blackFont2));
						ftable2.addCell(new Paragraph("Principal:", blackFont2));
						ftable2.addCell(new Paragraph("Interest:", blackFont2));
						ftable2.addCell(new Paragraph("Ending Bal:", blackFont2));

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
							} else

							{
								beginingBalance = endingBalance;
								interest = beginingBalance * r;
								principal = totalPayment - interest;
								totalPayment = extraPayment + totalRepayment;
								endingBalance = beginingBalance - principal;

							}

							totalInterest += interest;
							totalEarlyPayments += extraPayment;

							ftable2.addCell(new Paragraph(String
									.valueOf(x1 + 1), blackFont));
							ftable2.addCell(new Paragraph(dateTime, blackFont));
							ftable2.addCell(new Paragraph(formatter
									.format(beginingBalance), blackFont));
							ftable2.addCell(new Paragraph(formatter
									.format(totalRepayment), blackFont));
							ftable2.addCell(new Paragraph(formatter
									.format(extraPayment), blackFont));
							ftable2.addCell(new Paragraph(formatter
									.format(totalPayment), blackFont));
							ftable2.addCell(new Paragraph(formatter
									.format(principal), blackFont));
							ftable2.addCell(new Paragraph(formatter
									.format(interest), blackFont));
							ftable2.addCell(new Paragraph(formatter
									.format(endingBalance), blackFont));
							x1++;

						} while (endingBalance > 0);

						PdfPTable ftable1 = new PdfPTable(4);
						ftable1.setWidthPercentage(100);
						ftable1.setHorizontalAlignment(Element.ALIGN_LEFT);
						ftable1.setWidths(new int[] { 8, 5, 8, 5 });
						ftable1.getDefaultCell().setBorder(Rectangle.BOX);

						ftable1.addCell("");
						ftable1.addCell(new Paragraph("Loan Details",
								blackFont2));
						ftable1.addCell(" ");
						ftable1.addCell(new Paragraph("Loan Summary",
								blackFont2));
						ftable1.addCell(new Paragraph("Loan Amount", blackFont1));
						ftable1.addCell(new Paragraph(formatter
								.format(loanAndCharges), blackFont1));
						ftable1.addCell(new Paragraph("Scheduled Payment",
								blackFont1));
						ftable1.addCell(new Paragraph(formatter
								.format(totalRepayment), blackFont1));
						ftable1.addCell(new Paragraph("Annual Interest Rate",
								blackFont1));
						ftable1.addCell(new Paragraph(String.valueOf(rate)
								+ "%", blackFont1));
						ftable1.addCell(new Paragraph(
								"Scheduled # of   Payments", blackFont1));
						ftable1.addCell(new Paragraph(String.valueOf(x1),
								blackFont1));
						ftable1.addCell(new Paragraph("Loan Period (Y)",
								blackFont1));
						ftable1.addCell(new Paragraph(String.valueOf(x1 / 12),
								blackFont1));
						ftable1.addCell(new Paragraph("Actual # of Payments",
								blackFont1));
						ftable1.addCell(new Paragraph(String.valueOf(x1),
								blackFont1));
						ftable1.addCell(new Paragraph("Payments per year",
								blackFont1));
						ftable1.addCell(new Paragraph("12", blackFont1));
						ftable1.addCell(new Paragraph("Total Early Payments",
								blackFont1));
						ftable1.addCell(new Paragraph(formatter
								.format(totalEarlyPayments), blackFont1));

						ftable1.addCell(new Paragraph("First Installment Date",
								blackFont1));
						ftable1.addCell(new Paragraph(startDate1, blackFont1));
						ftable1.addCell(new Paragraph("Total Interest",
								blackFont1));
						ftable1.addCell(new Paragraph(formatter
								.format(totalInterest), blackFont1));

						ftable1.addCell(new Paragraph("Last Installment Date",
								blackFont1));
						ftable1.addCell(new Paragraph(endDate1, blackFont1));
						ftable1.addCell(new Paragraph("", blackFont1));
						ftable1.addCell(new Paragraph("", blackFont1));

						ftable1.addCell("");
						ftable1.addCell("");
						ftable1.addCell(new Paragraph("", blackFont1));
						ftable1.addCell(new Paragraph("", blackFont1));

						document.add(ftable1);
						document.add(ftable2);
						
						// //LETTER OF OFFER AND ACCEPTANCE//////

						document.newPage();
						document.add(img);
						Phrase loaHeader = new Phrase();
						loaHeader.add(new Chunk(
								"LETTER OF OFFER AND ACCEPTANCE ",
								blackFontListHeading));
												
						document.add(loaHeader);

						PdfPTable loa = new PdfPTable(2);
						loa.setWidthPercentage(100);
						loa.setHorizontalAlignment(Element.ALIGN_LEFT);
						loa.setWidths(new int[] { 5, 5 });
						loa.getDefaultCell().setBorder(Rectangle.NO_BORDER);

						Phrase loa1 = new Phrase();
						loa1.add(new Chunk(dateloanRequired ,blackFontParameter1));
						loa1.add(new Chunk(
								"\n\nBetween: 	Eswatini Development and Savings Bank \n\n(herein after referred to as “Eswatini Bank” or “the Bank”)"
										+ "\n\nAND\n\n	", blackFont1));
						loa1.add(new Chunk(employeeName + "\n\n" + boxAddress
								+ city, blackFontParameter12));

						loa1.add(new Chunk(
								"\n\n(Hereinafter referred to as “the Borrower”)"
										+ "\n\nReference is made to your application dated",
								blackFont1));
						loa1.add(new Chunk("\n\nThis " + String.valueOf(dayOne)
								+ " day of " + monthOneV + " , " + yearOne,
								blackFontParameter1));
						loa1.add(new Chunk(
								" in response to which the Bank is pleased to offer you a finance facility of ",
								blackFont1));
						loa1.add(new Chunk("EMALANGENI " + loanAmountWords
								+ " Only (E" + loanAndCharges,
								blackFontParameter1));
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
						loa.addCell(loa1);

						Phrase loa2 = new Phrase();
						loa2.add(new Chunk(
								"1.2.5	Warrants that the initiative in connection with this transaction and the signing and acceptance of this offer emanated from the Borrower voluntarily and without any duress or undue influence.								"
										+ "\n\n1.2.6	Warrants further that the Borrower shall sign all relevant documents including, but not limited to the main agreement, security documents and schedules relating to this transaction prior to the disbursement of funds.",
								blackFont1));
						loa2.add(new Chunk(
								"\n\n2. PURPOSE OF THE FACILITY OFFERED BY THE BANK",
								blackFontParameter1));
						loa2.add(new Chunk(
								"\n\nThe Finance Facility is granted to the Borrower for the purpose of STAFF PERSONAL LOAN. (The facility type will not necessarily be determined by its purpose)",
								blackFont1));
						loa2.add(new Chunk("\n\n3. DURATION OF THE FACILITY",blackFontParameter1));
						loa2.add(new Chunk("\n\nThe Finance Facility shall be repaid by the Borrower over a period of ",blackFont1));
						loa2.add(new Chunk(String.valueOf(x1) + " MONTHS",blackFontParameter1));
						loa2.add(new Chunk("commencing from  "+ dateOfFirstInstallment,blackFont1));
						
						loa2.add(new Chunk("or from the date of signing the finance facility Agreement and to Expire on ",blackFont1));
						loa2.add(new Chunk(dateOfLastInstallment,	blackFontParameter1));
						
						
						loa2.add(new Chunk("\n\n4. INTEREST & RATE",
								blackFontParameter1));
						loa2.add(new Chunk(
								"\n\nThe Finance Facility shall bear Interest which shall be linked to prime as determined from time to time by the Bank subject to the initial interest rate of 6.5% per annum.",
								blackFont1));
						loa2.add(new Chunk("\n\n5. REPAYMENT",
								blackFontParameter1));
						loa2.add(new Chunk(
								"\n\nThe Finance Facility shall be repaid to the Bank in the following manner (E.g. Whether by a lump sum, by",
								blackFont1));
						loa2.add(new Chunk("  E " + String.valueOf(formatter.format(totalRepayment)),blackFontParameter1));
						loa2.add(new Chunk(" per Month Effective  ", blackFont1));
						loa2.add(new Chunk("\n\nThis " + String.valueOf(dayOne)
								+ " day of " + monthOneV + " , " + yearOne,
								blackFontParameter1));
						loa2.add(new Chunk(
								"Unitl Loan is Fully Paid."
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
						loa.addCell(loa2);

						Phrase loa3 = new Phrase();
						loa3.add(new Chunk("7. CONDITIONS PRECEDENT",
								blackFontParameter1));
						loa3.add(new Chunk(
								"\n\n7.1 Notwithstanding anything to the contrary in this agreement, the Borrower shall not be entitled to draw on the facility offered unless and until the required security has been furnished and perfected to the satisfaction of the Bank."
								,blackFont1));
						loa3.add(new Chunk("\n\n8. OTHER TERMS",
								blackFontParameter1));
						loa3.add(new Chunk(
								"\n\n8.1	Disbursement of funds is further subject to approval by the Bank’s Legal Department."
								+ "\n\n8.2	The Bank reserves the right to withdraw this offer without notice to the Borrower if in its view the security pledged by the Borrower is insufficient or on grounds of change in circumstances of the borrower."
								+ "\n\n8.3	The Bank reserves the right to consider the outstanding portion of the loan to be due and payable by the Borrower on demand at any time."
								+ "\n\n8.4	This Finance Facility is subject to further terms & conditions per the Finance Facility Agreement document and related security documents."
								+ "\n\n8.5	All insurance premiums, municipal rates and taxes and all other expenses and charges which the Bank considers necessary or desirable to be disbursed for the preservation, repair and maintenance of the security provided, shall be for the Borrower’s account and shall be repayable to the Bank on demand."
								+ "\n\n8.6	The Borrower recognizes the right of the Bank to seize any or all items offered as security and preserve them where it deems necessary, or  to employ interim service providers to take care of the security pending resolution of  any issues in court or any other forum. The costs for such preservation of the security shall be borne by the Borrower through debit to his/her/its account by the bank."
								+ "\n\n8.7	The Bank shall be entitled to withdraw this offer if it  is not accepted or if the Borrower does not place the Bank in a position to lodge and perfect the security offered within thirty days (30) days from the date of  issue hereof."
								,blackFont1));
						loa3.add(new Chunk("\n\n9. COSTS",
								blackFontParameter1));
						loa3.add(new Chunk(
								"\n\nThe Borrower agrees that in the event of foreclosure of the Finance  Facility, for whatever reason(s), the Borrower shall be liable for all costs including legal costs at attorney and own client scale, collection commission, valuation costs, recovery costs, tracing costs, and all other related costs, charges and expenses.",
								blackFont1));
						loa.addCell(loa3);

						Phrase loa4 = new Phrase();
						loa4.add(new Chunk(
								"10. REPRESENTATION AND WARRANTIES",
								blackFontParameter1));
						loa4.add(new Chunk(
								"\n\nThe Borrower represents and warrants that his/her /its/their acceptance of the terms and conditions of this offer has been duly authorized and does not contravene any law and that there is no material litigation or similar proceedings, to the knowledge of the borrower presently pending or threatened which would have adverse effect on the assets or business of the borrower.\n\nI/We the undersigned do hereby acknowledge that I/we have read and understood to our/my satisfaction the above conditions, which I /we accept wholly, freely and voluntarily. I further confirm that the information furnished to the Bank is true and correct in every respect.   I/We undertake to produce and/or sign all documentation as may be required to complete the security. I/we further authorize the opening of a Finance Facility account in my / our name for the purpose of servicing this facility."
								,blackFont1));
						loa4.add(new Chunk("\n\n---------------------------------------- -------------------------------------                   SIGNATURE                                       DATE                                                     \n\n(AUTHORISED BANK REPRESENTATIVE)\n\n---------------------------------------------------------------------	       SIGNATURE	(BORROWER)			\n\n………………………………………………………\n\nCOMPANY STAMP (WHERE NECESSARY)",
								blackFontParameter1));
						loa.addCell(loa4);

						document.add(loa);
						
						// //////////////////The Agreement //////////////////

						document.newPage();
						Phrase fcaggheader = new Phrase();
						fcaggheader.add(new Chunk("FINANCE FACILITY AGREEMENT",
								blackFontParameter1));
						document.add(fcaggheader);

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
						fcsecAg1.add(new Chunk("\n\n2. Fees and Charges",
								blackFontParameter1));
						fcsecAg1.add(new Chunk("\n\n2.1 Application Fee",
								blackFontParameter1));
						fcsecAg1.add(new Chunk(
								"\nThe Borrower shall be charged a once off non-refundable application fee, payable by the Borrower upon the submission of the application.",
								blackFont1));
						fcsecAg1.add(new Chunk("\n\n2.2 Administration Fee:",
								blackFontParameter1));
						fcsecAg1.add(new Chunk(
								"\nThe Borrower shall be charged with paying to the Bank a monthly administration fee.",
								blackFont1));
						fcsecAg1.add(new Chunk("\n\n2.3 Establishment Fee:",
								blackFontParameter1));
						fcsecAg1.add(new Chunk(
								"\n\nThe Bank shall be entitled to charge a non-refundable establishment fee, payable by the Borrower upon the signature of this Agreement.",
								blackFont1));
						fcsecAg1.add(new Chunk("\n\n2.4 Early Settlement Fee:",
								blackFontParameter1));
						fcsecAg1.add(new Chunk(
								"\n\nThe Borrower may, subject to 10 days’ notice to the Bank prepay all or a portion of the loan, provided that the Borrower shall be liable to pay to the Bank, a once-off prepayment fee equal to 90 days interest.",
								blackFont1));
						fcsecAg1.add(new Chunk("\n\n2.5 Late Drawdown Fee:",
								blackFontParameter1));
						fcsecAg1.add(new Chunk(
								"\n\nShould the Borrower fail to draw down the loan within 30 days of being entitled to do so, it should obtain a written permission from the Bank in the event of any further delay from the said 30 days, failing which the Bank will be entitled to levy a late drawdown fee.",
								blackFont1));
						fcsecAg1.add(new Chunk("\n\n2.6 Late Payment Fee:",
								blackFontParameter1));
						fcsecAg1.add(new Chunk(
								"\n\nShould the Borrower fail to pay on due date any amounts falling due or payable to the Bank under or arising from this Agreement, then, without prejudice to such other rights as may accrue to the Bank consequent upon such failure, such overdraft amounts shall bear additional finance charges at the rate of 2% per day of the overdue amount.",
								blackFont1));

						finsecfac2.addCell(fcsecAg1);

						Phrase fcsecAg2 = new Phrase();
						fcsecAg2.add(new Chunk("2.7 Other Fees and Charges",
								blackFontParameter1));
						fcsecAg2.add(new Chunk(
								"\n\nThe list of fees and charges contained in clauses 2.1 to 2.6 may be changed at any time at the discretion of the bank without prior notice. ",
								blackFont1));
						// finsecfac2.addCell(fcsecAg2);

						fcsecAg2.add(new Chunk("\n\n3. Breach",
								blackFontParameter1));
						fcsecAg2.add(new Chunk(
								"\n\n3.1 In the event of the Borrower failing to observe and / or to perform any of the terms, conditions and or obligations of this or any other agreement which it may have with the bank, or defaulting in the punctual payment of any amount falling due in terms of this or any other Agreement it may have with the Bank, the Bank shall be entitled, without notice to the Borrower, to cancel this Agreement and withdraw the services with immediate effect.  In that event the bank shall be entitled to call on the loan and to foreclose on the securities and recover the full amount of the loan, interest accrued and any charges levied but unpaid, in terms of this Agreement.\n\nThe following non exhaustive list shall constitute events of default entitling the Bank to call on the full loan amount plus   interest and to foreclose under this Agreement:\n\n(a)	Any judgement, attachment being made, and execution being levied against the Borrower;\n\n(b)	The Borrower being placed under judicial management or wound up, whether compulsorily or voluntarily, or compromising with any of its creditors, or committing an act of insolvency, as defined in the Eswatini Insolvency Act No. 81 of 1955; or\n\n(c)	Stopping payment of any liquid document made payable to the Bank; or\n\n(d)	Without the prior written consent of the Bank, ceasing or intimating to the Bank its intention to cease to carry on its business; or\n\n(e)	Failing for whatever reason, at any time during the duration of this agreement, to record a trading profit during any one or more year’s trading; or\n\n(f)	The Borrower proposing any rescheduling, reorganization or rearrangement of the whole, or part of the indebtedness to the Bank or any of the Borrower’s creditors;\n\n(g)	The Borrower’s business operations, or any significant part thereof being interrupted for a continuous period of at least three months or more;\n\n(h)	Any representation, warranty or statement made in, or in connection with this Agreement by or on behalf of the Borrower pursuant to this Agreement being found to be false or incorrect.\n\n(i)	Occurrence of any fact or circumstance which in the opinion of the Bank may adversely affect the ability or willingness of the Borrower to comply with all or any of its obligations under this Agreement;\n\n(j)	Death, in the case of a natural person or a major shareholder whose input is critical for the operation of the business.",
								blackFont1));
						finsecfac2.addCell(fcsecAg2);

						Phrase fcsecAg3 = new Phrase();
						fcsecAg3.add(new Chunk(
								"3.2 The exercise of the rights by the bank in terms of this clause 3 shall be without prejudice, and/or in addition to any other rights which might thereupon be available to the Bank in terms of this Agreement or in law.\n\n3.3	If the bank terminates the loan agreement in terms of the provisions of clause 3 the bank may in addition to any other rights it has; set off any credit balances held by the Borrower in any other accounts with Eswatini Bank against the debt on the loan facility.",
								blackFont1));
						fcsecAg3.add(new Chunk("\n\n4. Project Management",
								blackFontParameter1));
						fcsecAg3.add(new Chunk(
								"\n\n4.1	In the event of failure by the Borrower to honor obligations under a project financed by the Bank under this Agreement, for whatever reason, the Bank may at its sole discretion, and without prejudice to any rights it may have against the Borrower, in terms of this Agreement or in law, appoint a manager on contract with or without staff, to manage and carry out the operations of the project for the purpose of repayment and settlement of the loan, interest thereon and related costs. The Borrower shall upon written notice by the Bank of the decision herein, co-operate with the Bank."
										+ "\n\n4.2 The income generated shall in addition to being used for the loan repayment be, applied towards the reasonable running expenses of the project, which shall include but not be limited to, management, operational and legal costs.  No dividends shall be declared or paid\n\n4.3	Upon full settlement of the loan, and related costs, the Bank shall release the business project to the Borrower.",
								blackFont1));
						fcsecAg3.add(new Chunk("\n\n5. Change in Circumstances",
								blackFontParameter1));
						fcsecAg3.add(new Chunk(
								"\n\n5.1	If at any time during the currency of this Agreement –\n\n5.1.1	Any new law, ruling or regulation is promulgated given or adopted;		\n\n5.1.2	There are any changes to the present or future law, ruling or regulation;		\n\n5.1.3	There are any changes to the interpretation or administration of any law, ruling or regulation by any relevant monetary or fiscal authority;\n\n5.1.4	There is any compliance by the Bank with any directive or request, whether or not having the force of law, from any monetary or fiscal authority, which would or does –"
										+ "\n\n(a)	Subject the Bank to any taxes, duties, or other charges, in respect of this agreement or change the basis of taxation of the Bank in respect of payments of principal or interest/fees payable to the Bank (except for changes in the rate of taxation on the overall net income of the Bank); or		\n\n(b)	Impose, modify or deem applicable any reverse, special deposit or similar requirement against assets of, deposits with or for the account of, or credit extended by the Bank, or\n\n(c)	Impose on the Bank any other obligation or condition affecting the loan or its commitment in terms of this agreement; And –\n\nThe result of any of the occurrences in 5.1.1 – 5.1.4 (a) – (c) above is to increase the cost to the Bank of making any advance or maintaining this Agreement or to reduce any amount or amounts received or receivable or loanable by the Bank hereunder by a sum which the Bank deems material, then the Borrower shall pay the Bank on demand and while such circumstances continue, such commitment fees as the Bank may ",
								blackFont1));
						finsecfac2.addCell(fcsecAg3);

						Phrase fcsecAg4 = new Phrase();
						fcsecAg4.add(new Chunk(
								"impose or such additional amounts which will compensate the Bank for such additional costs incurred. \n\n5.2	The Bank may give the Borrower thirty day notice of all amounts payable in terms of this clause 5.  A certificate signed by any manager of the Bank (whose appointment it shall not necessary to prove) as to such additional amount(s) shall be prima facie proof for all purposes.\n\n5.3	If the Borrower is required to pay additional amount(s) to the Bank pursuant to Clause 5.1 above, it shall be entitled to prepay any amounts owed in terms hereof without penalty, or to forthwith cancel any unutilized portion of the loan by giving the Bank thirty (30) days written notice thereof.\n\n5.4	Notwithstanding the provisions of clause 5 the bank shall not be liable for any failure to notify the Borrower of any changes. ",
								blackFont1));
						fcsecAg4.add(new Chunk(
								"\n\n6. Representations and Warranties",
								blackFontParameter1));
						fcsecAg4.add(new Chunk(
								"\n\nThe Borrower represents and warrants that –\n\n6.1	 Its acceptance of the terms of this Agreement has been duly authorized and does not contravene any law or any contractual obligation binding upon it;"
										+ "\n\n6.2 There is no material litigation or similar proceedings, to the knowledge of the Borrower presently pending or threatened which would have a material adverse effect on the business or assets of the Borrower;\n\n6.3	The Borrower is not in default in respect of any of its obligations in respect of money advanced and that no event specified in Clause 3 above has occurred or is continuing.",
								blackFont1));
						fcsecAg4.add(new Chunk(
								"\n\n7. Certificate of Indebtedness",
								blackFontParameter1));
						fcsecAg4.add(new Chunk(
								"\n\nA certificate signed by any manager of the Bank (whose appointment it shall not be necessary to prove) as to any indebtedness of the Borrower herein, or as to any other fact, shall be prima facie evidence of the Borrower’s indebtedness to the Bank or of such other fact for the purpose of any application or action, judgement or order or for any other purpose whatsoever.",
								blackFont1));
						fcsecAg4.add(new Chunk("\n\n8. Renunciation",
								blackFontParameter1));
						fcsecAg4.add(new Chunk(
								"\n\nThe Borrower specifically renounces the legal exceptions non numeratae pecuniae, non causa debiti, revision of accounts and error of calculation (errore  calculi) de duobus Vel plu rubus reis debindi, beneficium ordinus seu execussionis, benefitium devisionis and all other exceptions which might or could be pleaded to the validity of the indebtedness, whether capital, finance charges or legal costs, or any part thereof, and declares that he is fully acquainted with the force, effect and meaning thereof, the same having been explained to the Borrower by the Bank.",
								blackFont1));
						fcsecAg4.add(new Chunk("\n\n9. Domicilium",
								blackFontParameter1));
						fcsecAg4.add(new Chunk(
								"\n\n9.1 The parties respectively choose their domicilia citandi et executandi for all notices and processes to be given or served in pursuance hereof at the addresses given by both parties. (physical address) \n\n9.2	Either of the parties shall be entitled to change its domicilium from time to time:  Provided that any new domicilium selected by either of them shall be a physical address and shall be situate in the Kingdom of Eswatini and any such change shall only be effective upon receipt by the other party of notice in writing of such change.  All other notices or communications intended for either party ",
								blackFont1));
						finsecfac2.addCell(fcsecAg4);

						Phrase fcsecAg5 = new Phrase();
						fcsecAg5.add(new Chunk(
								"shall be made or given in writing at such party’s domicilium for the time being and, if forwarded by prepaid registered post, shall be deemed to have been made or given three days after the date of posting.",
								blackFont1));
						fcsecAg5.add(new Chunk("\n\n10. Entire Agreement",
								blackFontParameter1));
						fcsecAg5.add(new Chunk(
								"\n\nThis agreement constitutes the entire agreement between the parties and any amendment, addition or alteration to the provisions hereof shall only be deemed to be of force and effect if such amendment, addition or alteration is reduced to writing and signed by the parties.",
								blackFont1));
						fcsecAg5.add(new Chunk("\n\n11. Costs and Expenses",
								blackFontParameter1));
						fcsecAg5.add(new Chunk(
								"\n\nAll stamp duties payable in respect of this agreement or in respect of any guarantees or securities given in respect hereof and costs and expenses incurred by the Bank in connection with the preparation of this agreement and any securities relating thereto shall be for the account of the Borrower and shall be payable on demand.\n\nFurthermore, all legal costs as between attorney and his own client, tracing fees, valuation costs, collection commission, disbursements and fees of a like nature incurred by the Bank in successfully enforcing or defending any of the provisions of this Agreement, or any claim there under, shall be for the account of the Borrower and be payable on demand.",
								blackFont1));
						fcsecAg5.add(new Chunk("\n\n12. Dispute	",blackFontParameter1));
								
						fcsecAg5.add(new Chunk("\n\n12.1 In the event of any dispute arising between the Bank and the Borrower relating to any matter under this Agreement, such dispute shall be resolved amicably by the parties, and if they fail to resolve it between themselves, the dispute may be referred to court by any aggrieved party.\n\n12.2	In appropriate cases, and due to the technical nature of the matters involved, the Bank and the Borrower may by agreement refer the dispute to an Arbitrator jointly selected by the parties for resolution by arbitration.",
								blackFont1));
						fcsecAg5.add(new Chunk("\n\n13. Jurisdiction",	blackFontParameter1));
						fcsecAg5.add(new Chunk(	"\n\n13.1 The Borrower hereby consents and submits to the jurisdiction of the magistrate’s court having jurisdiction over its person in respect of all proceedings connected with this agreement, notwithstanding that the amount claimed or the value of the matter in dispute exceeds such jurisdiction;  provided that the Bank shall not be obliged to institute action in the magistrate’s court.\n\n13.2	Notwithstanding the provisions of Clause 13.1, the Bank shall be entitled to institute all or any proceedings against the Borrower in connection with this Agreement in the High Court of Eswatini and the Borrower hereby consents and submits to the jurisdiction of that court and agrees that any costs awarded against the Borrower be awarded or paid in accordance with Clause 11 hereof on Attorney and Own Client Scale.",
								blackFont1));
						finsecfac2.addCell(fcsecAg5);

						Phrase fcsecAg6 = new Phrase();
						fcsecAg6.add(new Chunk("14. Indulgence",
								blackFontParameter1));
						fcsecAg6.add(new Chunk(
								"\n\nNo relaxation or indulgence granted by the Bank to the Borrower from time to time shall be deemed to be a waiver of the Bank’s rights in terms hereof, nor shall any such relaxation or indulgence be deemed to be a novation or waiver of the terms and conditions of this Agreement.",
								blackFont1));
						fcsecAg6.add(new Chunk("\n\n15. Applicable Law",
								blackFontParameter1));
						fcsecAg6.add(new Chunk(
								"\n\nThis Agreement shall in all respects be governed by and construed in accordance with the laws of the Kingdom of Eswatini and all disputes, actions and other matters in connection therewith shall be determined in accordance with such law.",
								blackFont1));
						fcsecAg6.add(new Chunk(
								"\n\n16. Debit Order Authorization",
								blackFontParameter1));
						fcsecAg6.add(new Chunk(
								"\n\n16.1 The bank shall be entitled to originate debits to the Borrower’s account at Eswatini Bank or any other bank or branch for all amounts due or which might at any future time become due by the Borrower under this Agreement.\n\n16.2	This authority shall in no way be construed as constituting a novation, substitution or variation of the Borrower’s obligation under this agreement.",
								blackFont1));
						fcsecAg6.add(new Chunk("\n\n17. Execution",
								blackFontParameter1));
						fcsecAg6.add(new Chunk(
								"\n\nThis agreement is signed at " + location
										+ "" + "\n\nOn this day ", blackFont1));
						fcsecAg6.add(new Chunk(String.valueOf(dayOne)
								+ " day of " + monthOneV + " , " + yearOne,
								blackFontParameter1));
						fcsecAg6.add(new Chunk(
								"\n\nFor and on behalf of the bank:\n\nIn his/her capacity as:\n\nBy the Borrower personally\n\nOr in the case of the Borrower being a juristic person, by:\n\nFull Name(s)_____________________________________"
										+ "\n\n(Borrower/For the Borrower)\n\nSigned in the presence of the Undersigned witnesses:\n\n____________________ ____________________\n\n(Witness)		                           (Witness)",
								blackFont1));
						finsecfac2.addCell(fcsecAg6);

						document.add(finsecfac2);
						
						// GENERAL PLEDGE////////
						document.newPage();
						document.add(img);

						Phrase gpHeader = new Phrase();
						gpHeader.add(new Chunk("GENERAL PLEDGE",
								blackFontParameter1));
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
						gp3.add(new Chunk(employeeName, blackFontParameter12));
						gp3.add(new Chunk(
								"\n\nHereby cede, assign and make over to the said Bank all my/our right, title and interest in and to, and I/we do hereby pledge and deliver to the said Bank.",
								blackFont1));
						gp3.add(new Chunk("\n\na)	Stop Order over Salary",
								blackFontParameter1));
						gp3.add(new Chunk("\n\nb)	Level Term Insurance Cover",
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
						gp6.add(new Chunk(resAddress, blackFontParameter1));
						gp6.add(new Chunk(
								"\n\nWhich I/we choose as my/our domicilium citandi et executandi for the purpose of this agreement. All communications sent by post and addressed to me/us and the service of any legal process issued against me/us at the said address shall be deemed to have been delivered to me/us in the ordinary and usual course postal delivery. "
										+ "\n\nAnd for the purposes of this agreement, I/we hereby nominate, constitute and appoint the Manager or any person or persons acting in this capacity from time to time of the said Bank at Eswatini bank Gwamile Street, Mbabane\n\nWith power of substitution, to be my/our true and lawful Attorney and Agent in remsuam or in his discretion in my/our name with all necessary power and authority irrevocably during the subsistence of any indebtedness or liability whatsoever by me/us to the said Bank to do all that may be necessary and required to give effect to this agreement hereby ratifying, allowing and confirming and promising and agreeing to ratify, allow and confirm all and whatsoever my/our said Attorney and Agent shall lawfully do or cause to be done by virtue of these presents. "
										+ "\n\nThus done and signed at ",
								blackFont1));
						gp6.add(new Chunk(location, blackFontParameter1));
						gp6.add(new Chunk("\n\nThis" + String.valueOf(dayOne)
								+ " day of " + monthOneV + " , " + yearOne,
								blackFontParameter1));
						gp6.add(new Chunk(
								"\n\nCustomer: __________________________________\n\nAs Witness: \n\n1.	________________________________________\n\n2.	________________________________________",
								blackFont1));
						gp.addCell(gp6);

						document.add(gp);

						// ////////acknowledgement////////////
						document.newPage();
						document.add(img);
						Phrase aodheader = new Phrase();
						aodheader.add(new Chunk(
								"ACKNOWLEDGEMENT OF DEBT AGREEMENT",
								blackFontParameter1));
						document.add(aodheader);

						PdfPTable aod = new PdfPTable(2);
						aod.setWidthPercentage(100);
						aod.setHorizontalAlignment(Element.ALIGN_LEFT);
						aod.setWidths(new int[] { 5, 5 });
						aod.getDefaultCell().setBorder(Rectangle.NO_BORDER);

						Phrase phraseAod = new Phrase();
						phraseAod.add(new Chunk(
								" 1. \u00a0	I/We, the undersigned. ",
								blackFont1));
						phraseAod.add(new Chunk(employeeName,
								blackFontParameter1));
						phraseAod
								.add(new Chunk(
										"( The “debtor/s”), do hereby acknowledge myself/ourselves to be truly and lawfully indebted to Eswatini Development & Savings Bank (hereinafter referred to as “the Bank”) in the sum of E ",
										blackFont1));
						phraseAod
								.add(new Chunk(loanAmount, blackFontParameter1));
						phraseAod.add(new Chunk(" for and in respect of ",
								blackFont1));
						phraseAod.add(new Chunk(loanType + " ",
								blackFontParameter1));
						phraseAod.add(new Chunk(purposeOfLoan,
								blackFontParameter1));
						phraseAod
								.add(new Chunk(
										"\n\n\n2. \u00a0	I/We hereby promise and undertake to liquidate and pay the sum of E ",
										blackFont1));
						phraseAod
								.add(new Chunk(loanAmount, blackFontParameter1));
						phraseAod
								.add(new Chunk(
										" together with interest thereon at the rate of ",
										blackFont1));
						phraseAod.add(new Chunk(interestRate,
								blackFontParameter1));

						phraseAod
								.add(new Chunk(
										"% per annum or a rate advised by the bank from time to time reckoned from the ",
										blackFont1));
						phraseAod.add(new Chunk(String.valueOf(dayOne)
								+ " day of " + monthOneV + " , " + yearOne,
								blackFontParameter1));

						phraseAod.add(new Chunk(
								" and calculated on the balance owing from time to time as follows:-"
										+ "\n\na. \u00a0	In instalments of E ",
								blackFont1));
						phraseAod.add(new Chunk(String.format("%.2f",
								(totalRepayment)), blackFontParameter1));
						phraseAod.add(new Chunk(
								" Per month commencing on the  "+ dateOfFirstInstallment, blackFont1));
						
						phraseAod
								.add(new Chunk(
										"  And thereafter monthly at the same rate on the same day of each and every succeeding month thereafter."
												+ "\n\n3. \u00a0	In the event of any one payment due hereafter not being paid on due date, the full balance then outstanding including interest thereon shall immediately become due and recoverable from me/us without further notice."
												+ "\n\n4. \u00a0	All payments to be made hereafter shall be made to the said Bank at its address, namely  ",
										blackFont1));
						phraseAod
								.add(new Chunk("The Bank", blackFontParameter1));

						phraseAod
								.add(new Chunk(
										"  or such other address of which the Bank may from time to time notify me/us in writing."
												+ "\5\n5. \u00a0	I/We hereby choose as my/our domicilium citandi et executandi for all purposes hereunder  ",
										blackFont1));
						phraseAod
								.add(new Chunk(resAddress, blackFontParameter1));
						phraseAod
								.add(new Chunk(
										"   (Show street address)."
												+ "\n\n6. \u00a0	I/We hereby consent to the Bank taking any legal proceedings for the enforcing of its rights hereunder or for the recovery of any moneys claimable hereunder or otherwise in the Magistrate’s Court for the district having jurisdiction in respect of any such proceedings against me/us. ",
										blackFont1));
						aod.addCell(phraseAod);

						Phrase phraseAod2 = new Phrase();
						phraseAod2
								.add(new Chunk(
										"7. \u00a0	In the event of it being necessary for the Bank to institute any legal proceedings against me/us, I/we shall be responsible for the payment of all fees and disbursements thereby incurred by the Bank including collection commission on the scale as between Attorney and Client. ",
										blackFont1));

						phraseAod2
								.add(new Chunk(
										"\n\n8. \u00a0	I/we renounce the benefits of the legal exception ”No Numeratae Pecuniae”, “Non Causa Debiti”, “Errore Calculi”, “Revision of Accounts”, and “No value received” the meaning and effect of such renunciations of which I/we acknowledge and understand.   ",
										blackFont1));

						phraseAod2
								.add(new Chunk(
										"\n\n9. \u00a0	I/We accept that a statement signed by any authorized officer or manager of     the Bank (whose appointment it shall not be necessary to prove) specifying the amounts owing by Myself/ Ourselves in terms of this Agreement or the amount by which the capital liability has been reduced shall be conclusive proof of its contents and sufficient for all purposes hereunder including the issue of Writs of Execution. ",
										blackFont1));
						phraseAod2.add(new Chunk("\n\nDated at  ", blackFont1));
						phraseAod2
								.add(new Chunk(location, blackFontParameter1));

						phraseAod2
								.add(new Chunk(" on this the   ", blackFont1));
						phraseAod2.add(new Chunk(String.valueOf(dayOne)
								+ " day of " + monthOneV + " , " + yearOne,
								blackFontParameter1));
						phraseAod2
								.add(new Chunk(
										" in the presence of undersigned witnesses."
												+ "\n\n\n______________________________________________"
												+ "\n                                (Debtor)"
												+ "\n\nWitnesses"
												+ "\n\n\n1. \u00a0	__________________________________________\n\n\n2. \u00a0	__________________________________________",
										blackFont1));

						aod.addCell(phraseAod2);
						document.add(aod);
						// LETTER OF SET IREVOCABLE PLEDGE///
						document.newPage();
						document.add(img);

						PdfPTable losir = new PdfPTable(2);
						losir.setWidthPercentage(100);
						losir.setHorizontalAlignment(Element.ALIGN_LEFT);
						losir.setWidths(new int[] { 5, 5 });
						losir.getDefaultCell().setBorder(Rectangle.NO_BORDER);

						Phrase losirHader1 = new Phrase();
						losirHader1.add(new Chunk("LETTER OF SET OFF",
								blackFontParameter1));

						Phrase losirHader2 = new Phrase();
						losirHader2.add(new Chunk("IRREVOCABLE PLEGDE",
								blackFontParameter1));

						losir.addCell(losirHader1);
						losir.addCell(losirHader2);

						Phrase los = new Phrase();
						los.add(new Chunk(
								" \n\nIn consideration of your agreeing at my request not to require immediate payment of such of the sums mentioned below as may be now due and in consideration  of any like sums which you may hereafter advance or permit to become due, I the under signed\n______________________________________________\n\n",
								blackFont1));
						los.add(new Chunk(employeeName, blackFontParameter1));
						los.add(new Chunk(
								" \n\nHereby charge all moneys from time to time due to me from your bank on any Savings Account which I may now or hereafter have with you with the payment of any sums of money which may be now or may hereafter have with you with the payment of any sums of money owing to your Bank anywhere from or by me either solely or jointly with any other person or persons in partnership or otherwise upon banking account or upon any discount or other account for any other matter or thing whatsoever including the usual banking charges.",
								blackFont1));
						los.add(new Chunk(
								" \n\nAnd I authorize you to retain all money to me on any such account and to apply the same or any portion thereof towards payment of any sum or sums as aforesaid.",
								blackFont1));
						los.add(new Chunk(
								" \n\nThis is to be a continuing security and in addition and without prejudice to any other securities you may now or hereafter hold. ",
								blackFont1));
						los.add(new Chunk("\n\n Thus done at  ", blackFont1));
						los.add(new Chunk(location, blackFontParameter1));
						los.add(new Chunk(" on this the   ", blackFont1));
						los.add(new Chunk(String.valueOf(dayOne) + " day of "
								+ monthOneV + " , " + yearOne,
								blackFontParameter1));
						los.add(new Chunk(
								" in the presence of undersigned witnesses."
										+ "\n\n\n______________________________________________"
										+ "\n                                (Debtor)"
										+ "\n\nWitnesses"
										+ "\n\n\n1. \u00a0	__________________________________________\n\n\n2. \u00a0	__________________________________________",
								blackFont1));
						losir.addCell(los);

						Phrase ip = new Phrase();
						ip.add(new Chunk(
								"\n\nIn consideration of credit facilities having been afforded to myself by Eswatini Development and Savings Bank , at my own special request and instance and on the terms and conditions set out in the loan documents, I the undersigned    ",
								blackFont1));
						ip.add(new Chunk(employeeName, blackFontParameter1));
						ip.add(new Chunk(
								"  do hereby irrevocably consent and authorize the said Eswatini Bank or any subsequent employer to deduct all monthly installments payable by myself in respect of the said credit facilities from my salary and pay such amounts  into my loan account/ accounts until all monies due from me in respect of the credit facility/ facilities have been fully paid to Eswatini Bank. I further authorize the Bank to appropriate and or commute, fully or in part, any other contractual benefits that may accrue to me upon retirement or termination prior to retirement as much as I hereby cede, assign and surrender to the Bank all my right, title and interest in moneys standing to the credit of all accounts held in my name by the Bank in order to redeem any outstanding balance owing by myself on the afforded credit facilities.",
								blackFont1));
						ip.add(new Chunk("\n\n on this the   ", blackFont1));
						ip.add(new Chunk(String.valueOf(dayOne) + " day of "
								+ monthOneV + " , " + yearOne,
								blackFontParameter1));
						ip.add(new Chunk(
								" in the presence of undersigned witnesses."
										+ "\n\n\n\n\n\n\n\n\n______________________________________________"
										+ "\n                                (Debtor)"
										+ "\n\nWitnesses"
										+ "\n\n\n1. \u00a0	__________________________________________\n\n\n2. \u00a0	__________________________________________",
								blackFont1));
						losir.addCell(ip);
						document.add(losir);

						
						
						
						

						

						// STOP ORDER OVER SALARY/////
						document.newPage();
						document.add(img);

						Paragraph stopOrderParagraph1 = new Paragraph(
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
										+ "\n\nSURNAME: "+surname+"\n\nCHRISTIAN NAMES: "+firstname+"\n\nEMPLOYMENT NO: "+employeeCode + "     CIF: "+cif ), blackFont1));
														
						soosOuter.addCell(soosInner1);
						soosOuter.addCell(soosInner2);
						soosOuter.addCell(soosInner3);
						document.add(soosOuter);
						
						Phrase soos = new Phrase();
						
						soos.add(new Chunk("\nTo: The Manager\nESWATINI DEVELOPMENT AND SAVINGS BANK                                            Date:"+dateOfFirstInstallment+"\n"+branchAdress,
								blackFont1));
						
						soos.add(new Chunk("\n\nI/We hereby request and authorize you, until you receive notice to the contrary in writing, to make the periodical payment mentioned below according to the Instructions contained therein, to the debit of my/our Savings/Loan Account with your bank.\n\nTo be dispatched on: PAYDAYS............................................... commencing: ",
								blackFont1));
						
						soos.add(new Chunk(dateOfFirstInstallment.toUpperCase(),blackFontParameter1));
						
						soos.add(new Chunk("...............................................\n",blackFont1));
						
						soos.add(new Chunk("\n To:- .............................................................................................. Eswatini Bank\n",blackFontParameter1));

						soos.add(new Chunk("\n 'A':- ..............................................................................................",blackFontParameter1));

						soos.add(new Chunk(location,blackFontParameter1));
						
						
						soos.add(new Chunk("\n\nFor Credit of: ",blackFont1));
						
						soos.add(new Chunk(loanType.toUpperCase(),blackFontParameter1));
						
						soos.add(new Chunk("\n\nTo be paid To:",blackFont1));
						soos.add(new Chunk("Eswatini Bank\n                             " + branchAdress,blackFontParameter1));
						soos.add(new Chunk("\nAmount in words: ",blackFont1));
						
						soos.add(new Chunk(" (E"+String.valueOf(formatter.format(totalRepayment))+")",blackFontParameter1));
						soos.add(new Chunk("\n\nSpecial Instructions:          UNTIL LOAN IS FULLY REPAID"
										+ "\n\n                                                       ",blackFont1));
						soos.add(new Chunk("Yours faithfully",blackFontParameter1));
						soos.add(new Chunk("\n\n\n                                                     ............................."
										+ "\n“A”           Payments to be made to through Bankers                           ) Delete whichever"
										+ "\n“B”           Payments to be made direct to individuals or concerns        ) is not applicable"
										+ "\n\nThe bank will not send you special advices relating in the above payments. "
										+ "\n\nN.B.        If insufficient funds are available to meet this Stop Order on due date, payment will not be made.	The Bank will not 		make special arrangements to meet Stop Orders after due date.",
								blackFont1));
								document.add(soos);


					} catch (Exception e) {
						e.printStackTrace();
					}
					document.close();

				}

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
