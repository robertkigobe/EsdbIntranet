package technicalResources.staffLoan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.FinanceLib;

import util.ConnectionHelper;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class StaffLoanUpdateLoanEdit
 */
@WebServlet("/StaffLoanUpdateLoanEdit")
public class StaffLoanUpdateLoanEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String viewLoan = request.getParameter("viewLoan");
		String submitLoan = request.getParameter("submitLoan");
		Random rand = new Random();
		rand.nextInt(500);

		// /////////////date insert///////////////////
		Date dateOpenedN = new Date();
		String dateCreated = sdf.format(dateOpenedN);
		// /////////////date insert///////////////////

		float administationFee = 0;
		float allowances = Float.valueOf(request.getParameter("allowances"));
		String applicantComment = request.getParameter("applicantComment");
		String applicantCommentDate = dateCreated;
		String bankExecutioner = request.getParameter("bankExecutioner");
		String bankExecutionerCapacity = request
				.getParameter("bankExecutionerCapacity");
		float basicSalary = Float.valueOf(request.getParameter("basicSalary"));
		String branchAdress = request.getParameter("branchAdress");

		String city = request.getParameter("city");
		String boxAddress = request.getParameter("boxAddress");

		float carloanDeductions = Float.valueOf(request
				.getParameter("carloanDeductions"));
		float carloanBalance = Float.valueOf(request
				.getParameter("carloanBalance"));
		String cif = request.getParameter("cif");
		float cityCouncilRatesDeductions = Float.valueOf(request
				.getParameter("cityCouncilRatesDeductions"));
		float cityCouncilRatesBalance = Float.valueOf(request
				.getParameter("cityCouncilRatesBalance"));
		String createdBy = System.getProperty("user.name");
		String dateloanRequired = request.getParameter("dateloanRequired");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String dateEngaged = request.getParameter("dateEngaged");
		String dateOfFirstInstallment = request
				.getParameter("dateOfFirstInstallment");
		String dateOfLastInstallment = request
				.getParameter("dateOfLastInstallment");
		float educationalloanDeductions = Float.valueOf(request
				.getParameter("educationalloanDeductions"));
		float educationalloanBalance = Float.valueOf(request
				.getParameter("educationalloanBalance"));
		String emailAddress = request.getParameter("emailAddress");
		String employeeCode = request.getParameter("employeeCode");
		String employeeEmail = request.getParameter("employeeEmail");
		String employeeGrade = request.getParameter("employeeGrade");
		String employeePosition = request.getParameter("employeePosition");
		String employeeDepartment = request.getParameter("employeeDepartment");
		String employeeLoanRef  = request.getParameter("employeeLoanRef");
		float establishmentFee = 0;
		float farm_smallHolderDeductions = Float.valueOf(request
				.getParameter("farm_smallHolderDeductions"));
		float farm_smallHolderBalance = Float.valueOf(request
				.getParameter("farm_smallHolderBalance"));
		String firstname = request.getParameter("firstname");
		String headOfDepartmentComment = request
				.getParameter("headOfDepartmentComment");
		String headOfDepartmentCommentDate = request
				.getParameter("headOfDepartmentCommentDate");
		String hod = request.getParameter("hod");
		String hodEmail = request.getParameter("hodEmail");
		float housingloanDeductions = Float.valueOf(request
				.getParameter("housingloanDeductions"));
		float housingloanBalance = Float.valueOf(request
				.getParameter("housingloanBalance"));
		String iDNumber = request.getParameter("iDNumber");
		float instalment = Float.valueOf(request.getParameter("instalment"));
		float insurancesDeductions = Float.valueOf(request
				.getParameter("insurancesDeductions"));
		float insurancesBalance = Float.valueOf(request
				.getParameter("insurancesBalance"));
		float interestRate = Float
				.valueOf(request.getParameter("interestRate"));
		String lastModifiedBy = System.getProperty("user.name");
		String lastModifiedDate = dateCreated;
		float loanAmount = Float.valueOf(request.getParameter("loanAmount"));
		String loanAmountWords = request.getParameter("loanAmountWords");
		String loanStatus = "Pending-Supervisor Comments";
		String loanType = request.getParameter("loanType");
		String location = request.getParameter("location");
		String maritalStatus = request.getParameter("maritalStatus");
		int noOfDependants = Integer.valueOf(request
				.getParameter("noOfDependants"));
		float otherBalance = Float
				.valueOf(request.getParameter("otherBalance"));
		float otherDeductions = Float.valueOf(request
				.getParameter("otherDeductions"));
		float otherDeductionsExcLeaveAllowance = Float.valueOf(request
				.getParameter("otherDeductionsExcLeaveAllowance"));
		float personalloanDeductions = Float.valueOf(request
				.getParameter("personalloanDeductions"));
		float personalloanBalance = Float.valueOf(request
				.getParameter("personalloanBalance"));
		String purposeOfLoan = request.getParameter("purposeOfLoan");

		String repaymentPeriod = request.getParameter("repaymentPeriod");
		String resAddress = request.getParameter("resAddress");
		float ruralHousingloanDeductions = Float.valueOf(request
				.getParameter("ruralHousingloanDeductions"));
		float ruralHousingloanBalance = Float.valueOf(request
				.getParameter("ruralHousingloanBalance"));
		String secondName = request.getParameter("secondName");
		int securitiesPrinted = 0;
		float statutoryDeductions = Float.valueOf(request
				.getParameter("statutoryDeductions"));
		String supervisorComment = request.getParameter("supervisorComment");
		String supervisorCommentDate = request
				.getParameter("supervisorCommentDate");
		String supervisorEmail = request.getParameter("supervisorEmail");
		String supervisor = request.getParameter("supervisor");
		String surname = request.getParameter("surname");

		float targetSavings = Float.valueOf(request
				.getParameter("targetSavings"));
		String telelephoneNo = request.getParameter("telelephoneNo");

		// ////////////////armotization //////////////////////

		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String error = null;
		int loanPeriod = 0;
		Date startDate2 = null;
		Calendar cal = null;

		double loanAmount1 = Double.valueOf(request.getParameter("loanAmount"));
		double rate = Double.valueOf(request.getParameter("interestRate"));
		double finalValue = 0;
		String startDate1 = request.getParameter("dateOfFirstInstallment");
		String endDate1 = request.getParameter("dateOfLastInstallment");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-");
		cal = Calendar.getInstance();
		try {
			startDate2 = sdf.parse(startDate1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		loanPeriod = (int) ChronoUnit.MONTHS.between(LocalDate
				.parse(startDate1).withDayOfMonth(1), LocalDate.parse(endDate1)
				.withDayOfMonth(1)) + 1;

		if (startDate1.equals(endDate1)) {

			error = "Start date and End date should be diffeent";

			request.setAttribute("error", error);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_Credit/staffLoanArmotization.jsp");
			view.forward(request, response);

		} else if (loanAmount < 1) {

			error = "Please check your loan amount";

			request.setAttribute("error", error);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_Credit/staffLoanArmotization.jsp");
			view.forward(request, response);

		} else if (rate == 0) {
			error = "Interest rate can not be 0% ";

			request.setAttribute("error", error);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_Credit/staffLoanArmotization.jsp");
			view.forward(request, response);
		} else if (loanPeriod <= 0) {
			error = "End date can not be before Start date";

			request.setAttribute("error", error);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_Credit/staffLoanArmotization.jsp");
			view.forward(request, response);
		} else {

			double r = (rate / 100) / 12;
			double beginingBalance = 0;
			double totalEarlyPayments = 0;
			double extraPayment = 0;
			double totalPayment = 0;
			double principal = 0;
			double interest = 0;
			double endingBalance = 0;

			double totalInterest = 0;

			totalInterest = interest * loanPeriod;
			double totalRepayment = -(FinanceLib.pmt(r, loanPeriod, loanAmount,
					finalValue, false));

			// ////////////////armotization //////////////////////

			float totalDeductions = 0;
			float totalBalances = 0;
			float netSalary = 0;
			float cummulativePercentage = 0;
			if (viewLoan != null) {
				// TODO Auto-generated method stub

				netSalary = (Float.valueOf(allowances) + Float
						.valueOf(basicSalary))
						- (Float.valueOf(statutoryDeductions)
								+ Float.valueOf(totalDeductions)
								+ Float.valueOf(targetSavings) + Float
									.valueOf(statutoryDeductions));
				cummulativePercentage = (totalDeductions + Float
						.valueOf(instalment)) / 3;
				//Float.valueOf(instalment)* Integer.valueOf(repaymentPeriod);

				Font blackFont1 = FontFactory.getFont(FontFactory.HELVETICA, 8,
						Font.NORMAL);

				Font blackFont = FontFactory.getFont(FontFactory.HELVETICA, 7,
						Font.NORMAL);
				Font blackFontListHeading = FontFactory.getFont(
						FontFactory.TIMES_BOLD, 18, Font.NORMAL);
				FontFactory.getFont(
						FontFactory.HELVETICA, 8, Font.UNDERLINE,
						new CMYKColor(75, 68, 67, 90));
				FontFactory.getFont(
						FontFactory.TIMES_BOLD, 13, Font.NORMAL);

				FontFactory.getFont(
						FontFactory.HELVETICA, 10, Font.NORMAL);

				FontFactory.getFont(
						FontFactory.HELVETICA, 9, Font.NORMAL);

				FontFactory.getFont(FontFactory.HELVETICA, 7,
						Font.NORMAL);
				FontFactory.getFont(FontFactory.HELVETICA,
						8, Font.NORMAL);

				Document document = new Document();

				try {

					response.setContentType("application/pdf");
					PdfWriter.getInstance(document, response.getOutputStream());
					document.open();

					Image img = Image
							.getInstance("C:/IntranetWarehouse/StaffLoan/logo/headerlogo1.jpg");
					document.add(img);
					
					

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

					int x = 0;
					do {

						cal.setTime(startDate2);
						cal.add(Calendar.MONTH, x);
						DateFormat dateFormat = new SimpleDateFormat(
								"yyyy-MM-dd");
						String dateTime = dateFormat.format(cal.getTime());

						if (x == 0) {

							beginingBalance = loanAmount;
							interest = loanAmount * r;
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

						ftable2.addCell(new Paragraph(String.valueOf(x + 1),
								blackFont));
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
						x++;

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
					ftable1.addCell(new Paragraph(formatter.format(loanAmount),
							blackFont1));
					ftable1.addCell(new Paragraph("Scheduled Payment",
							blackFont1));
					ftable1.addCell(new Paragraph(formatter
							.format(totalRepayment), blackFont1));
					ftable1.addCell(new Paragraph("Annual Interest Rate",
							blackFont1));
					ftable1.addCell(new Paragraph(String.valueOf(rate) + "%",
							blackFont1));
					ftable1.addCell(new Paragraph("Scheduled # of   Payments",
							blackFont1));
					ftable1.addCell(new Paragraph(String.valueOf(x), blackFont1));
					ftable1.addCell(new Paragraph("Loan Period (Y)", blackFont1));
					ftable1.addCell(new Paragraph(String.valueOf(x / 12),
							blackFont1));
					ftable1.addCell(new Paragraph("Actual # of Payments",
							blackFont1));
					ftable1.addCell(new Paragraph(String.valueOf(x), blackFont1));
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
					ftable1.addCell(new Paragraph("Total Interest", blackFont1));
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
					document.add(new Paragraph("\n"));
					document.add(ftable2);
					
					document.newPage();

					document.add(img);

					Paragraph applicationLetterParagraph1 = new Paragraph(
							"STAFF LOAN APPLICATION\n", blackFontListHeading);
					document.add(applicationLetterParagraph1);

					Paragraph applicationLetterParagraph2 = new Paragraph(
							"1.	APPLICANT’S PARTICULARS\n",
							blackFontListHeading);
					document.add(applicationLetterParagraph2);
					document.add(new Paragraph("\n"));

					PdfPTable table = new PdfPTable(2);
					table.setWidthPercentage(100);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					table.setWidths(new int[] { 5, 8 });
					table.getDefaultCell().setBorder(Rectangle.BOX);

					table.addCell("Name: ");
					table.addCell(firstname + " " + surname);
					table.addCell("Employment No: ");
					table.addCell(employeeCode);
					table.addCell("Date of Birth: ");
					table.addCell(dateOfBirth);
					table.addCell("Branch: ");
					table.addCell(location);
					table.addCell("Position Held: ");
					table.addCell(employeePosition);
					table.addCell("Basic Monthly Salary: ");
					table.addCell(String.valueOf(basicSalary));
					table.addCell("Marital Status: ");
					table.addCell(maritalStatus);
					table.addCell("Position Grade: ");
					table.addCell(employeeGrade);
					table.addCell("Address: ");
					table.addCell(resAddress);
					table.addCell("No. of Dependants: ");
					table.addCell(String.valueOf(noOfDependants));
					table.addCell("Date Employed: ");
					table.addCell(dateEngaged);
					table.addCell("Tel / Cell: ");
					table.addCell(telelephoneNo);

					document.add(table);

					Paragraph applicationLetterParagraph3 = new Paragraph(
							"\n2.	LOAN PURPOSE: "
									+ (new Paragraph(purposeOfLoan,
											blackFontListHeading)),
							blackFontListHeading);
					document.add(applicationLetterParagraph3);
					document.add(new Paragraph("\n"));

					PdfPTable table61 = new PdfPTable(3);
					table61.setWidthPercentage(100);
					table61.setHorizontalAlignment(Element.ALIGN_CENTER);
					table61.setWidths(new int[] { 5, 3, 7 });
					table61.getDefaultCell().setBorder(Rectangle.BOX);

					table61.addCell("3. Loan Type: " + loanType);
					table61.addCell("Loan Amount: " + loanAmount);
					table61.addCell("Date Loan is required: "
							+ dateloanRequired);
					document.add(table61);
					document.add(new Paragraph("\n"));

					Paragraph applicationLetterParagraph30 = new Paragraph(
							"4.	RECENT SALARY ADVICE DETAILS",
							blackFontListHeading);
					document.add(applicationLetterParagraph30);
					document.add(new Paragraph("\n"));

					PdfPTable table1 = new PdfPTable(2);
					table1.setWidthPercentage(100);
					table1.setHorizontalAlignment(Element.ALIGN_LEFT);
					table1.setWidths(new int[] { 8, 4 });
					table1.getDefaultCell().setBorder(Rectangle.BOX);

					table1.addCell("Basic Salary:");
					table1.addCell(" E "
							+ String.valueOf(Float.valueOf(basicSalary)));

					table1.addCell("Allowances (exc. Overtime& leave all:");
					table1.addCell(" E "
							+ String.valueOf(Float.valueOf(allowances)));

					table1.addCell("Total Earnings:");
					table1.addCell(" E "
							+ String.valueOf(Float.valueOf(allowances)
									+ Float.valueOf(basicSalary)));

					document.add(table1);

					Paragraph applicationLetterParagraph31 = new Paragraph(
							"Current Loans and Balances: ",
							blackFontListHeading);
					document.add(applicationLetterParagraph31);
					document.add(new Paragraph("\n"));

					PdfPTable table2 = new PdfPTable(3);
					table2.setWidthPercentage(100);
					table2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2.setWidths(new int[] { 5, 5, 5 });
					table2.getDefaultCell().setBorder(Rectangle.BOX);

					table2.addCell("ITEM");
					table2.addCell("DEDUCTION");
					table2.addCell("BALANCE");
					table2.addCell("(4) Housing Loan (Mortgage)");
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(housingloanDeductions)));
					table2.addCell(" E "
							+ String.valueOf(Float.valueOf(housingloanBalance)));

					table2.addCell("(5) Rural Housing Loan");
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(ruralHousingloanDeductions)));
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(ruralHousingloanBalance)));

					table2.addCell("(6) Farm / Small Holder");
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(farm_smallHolderDeductions)));
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(farm_smallHolderBalance)));

					table2.addCell("(7) Car Loan");
					table2.addCell(" E "
							+ String.valueOf(Float.valueOf(carloanDeductions)));
					table2.addCell(" E "
							+ String.valueOf(Float.valueOf(carloanBalance)));

					table2.addCell("(8) Personal Loan (36 Months)");
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(personalloanDeductions)));
					table2.addCell(" E "
							+ String.valueOf(Float.valueOf(personalloanBalance)));

					table2.addCell("(9) Educational Loan (12 Months)");
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(educationalloanDeductions)));
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(educationalloanBalance)));

					table2.addCell("(11) City Council Rates");
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(cityCouncilRatesDeductions)));
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(cityCouncilRatesBalance)));

					table2.addCell("(12) Insurances");
					table2.addCell(" E "
							+ String.valueOf(Float
									.valueOf(insurancesDeductions)));
					table2.addCell(" E "
							+ String.valueOf(Float.valueOf(insurancesBalance)));

					table2.addCell("(13) Other Loans");
					table2.addCell(" E "
							+ String.valueOf(Float.valueOf(otherDeductions)));
					table2.addCell(" E "
							+ String.valueOf(Float.valueOf(otherBalance)));

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

					table2.addCell("(14) Total");
					table2.addCell(" E " + String.valueOf(totalDeductions));
					table2.addCell(" E " + String.valueOf(totalBalances));

					document.add(table2);
					document.add(new Paragraph("\n"));

					PdfPTable table3 = new PdfPTable(2);
					table3.setWidthPercentage(100);
					table3.setHorizontalAlignment(Element.ALIGN_LEFT);
					table3.setWidths(new int[] { 8, 4 });
					table3.getDefaultCell().setBorder(Rectangle.BOX);

					table3.addCell("(15) Other deductions(excl. Leave allowance)");
					table3.addCell(" E "
							+ String.valueOf(otherDeductionsExcLeaveAllowance));

					table3.addCell("(16) Target Savings:");
					table3.addCell(" E " + String.valueOf(targetSavings));

					table3.addCell("(17) Statutory Deductions(Paye+ Snpf)");
					table3.addCell(" E " + String.valueOf(statutoryDeductions));

					table3.addCell("(18) NET SALARY (3) -  (14,15,16, 17)");
					table3.addCell(" E " + String.valueOf(netSalary));

					document.add(table3);

					Paragraph applicationLetterParagraph9 = new Paragraph(
							"5.	AMOUNT REQUIRED AND REPAYMENT ARRANGEMENTS: ",
							blackFontListHeading);
					document.add(applicationLetterParagraph9);
					document.add(new Paragraph("\n"));

					PdfPTable table7 = new PdfPTable(4);
					table7.setWidthPercentage(100);
					table7.setHorizontalAlignment(Element.ALIGN_LEFT);
					table7.setWidths(new int[] { 3, 3, 8, 3 });
					table7.getDefaultCell().setBorder(Rectangle.BOX);

					table7.addCell("NEW LOAN: " + loanType);
					table7.addCell("INTEREST RATE: " + interestRate + "%");
					table7.addCell("REPAYMENT PERIOD IN MONTHS: "
							+ repaymentPeriod);
					table7.addCell("INSTALMENT:" + " E "
							+ String.format("%.2f",(totalRepayment)));

					table7.addCell(". ");
					table7.addCell(". ");
					table7.addCell("CUM. PERCENTAGE (14 +19) / 3:");
					table7.addCell(String.valueOf(String.format("%.2f",(cummulativePercentage/100)) + "%"));

					table7.addCell(". ");
					table7.addCell(". ");
					table7.addCell("NET PAY (18) – (19) :");
					table7.addCell(" E "
							+ String.format("%.2f",(netSalary - cummulativePercentage)));

					document.add(table7);

					Paragraph applicationLetterParagraph10 = new Paragraph(
							"VERIFIED BY H.R. DIVISION………………………………………………………………………………\n\nSIGNATURE………………………………………………………………………………",
							blackFontListHeading);
					document.add(applicationLetterParagraph10);
					document.add(new Paragraph("\n"));

					document.newPage();
					PdfPTable table4 = new PdfPTable(1);
					table4.setWidthPercentage(100);
					table4.setHorizontalAlignment(Element.ALIGN_LEFT);
					table4.setWidths(new int[] { 5 });
					table4.getDefaultCell().setBorder(Rectangle.BOX);

					table4.addCell("6.	APPLICANT’S DECLARATION AND AUTHORISATION"

							+ "\n\nThis application is made under the terms of SwaziBank staff loan Policy current at this time."
							+ "\n\nI declare that the information given here is correct.  To the best of my knowledge and belief I have not omitted any information pertinent this application."
							+ "\n\nI hereby authorize and request SwaziBank to deduct the repayments specified overleaf from my salary to the credit of the relative loans(s) until all outstanding balances and interest have been paid in full."
							+ "\n\nI hereby grant to SwaziBank a lien and right of set off over all accounts whatsoever standing to my credit at SwaziBank."
							+ "\n\nI hereby grant to SwaziBank a lien over any/all terminal benefit due to me with the right to apply such benefits as repayment of any outstanding loans and / or interest."
							+ "\n\nI understand that in the event of my leaving the employment of the bank for any reason the outstanding balances of any loans will immediately become due and payable."
							+ "\n" + "\n" + "\n"

							+ "\nSIGNATURE: ………………………………………………… ");

					table4.addCell("6.	Manager’s / Senior Manager’s / Supervisors comments and recommendations."
							+ "\n\nI confirm that his request is within the terms of the Staff Loans Policy currently in force."
							+ "\n" + "\n" + "\n"

							+ "\nSIGNATURE: ………………………………………………… ");

					table4.addCell("7.	EXECUTIVE HEAD OF DEPARTMENT" + "\n"
							+ "\n" + "\n"

							+ "\nSIGNATURE: ………………………………………………… ");

					table4.addCell("8. APPROVED  / DECLINED" + "\n" + "\n"
							+ "\n"

							+ "\nSIGNATURE: ………………………………………………… ");

					document.add(table4);
					document.add(new Paragraph("\n"));
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				document.close();

			} else if (submitLoan != null) {
				// TODO Auto-generated method stub

				ConnectionHelper connectionHelper = new ConnectionHelper();
				con = connectionHelper.connect();
				if (con != null) {

					String insertIssueSql = "UPDATE [dbo].[staffLoan]  SET  "
							+ "[administationFee] = '"+ administationFee +"'"
							+ " ,[allowances] = '"+ allowances +"'"
							+ ",[applicantComment] = '"+ applicantComment +"'"
							+ ",[applicantCommentDate] = '"+ applicantCommentDate +"'"
							+ ",[bankExecutioner] = '"+ bankExecutioner +"'"
							+ ",[bankExecutionerCapacity] = '"+ bankExecutionerCapacity +"'"
							+ ",[basicSalary] = '"+ basicSalary +"'"
							+ ",[branchAdress] = '"+ branchAdress +"'"
							+ " ,[carloanDeductions] = '"+ carloanDeductions +"'"
							+ " ,[carloanBalance] = '"+ carloanBalance +"'"
							+ ",[cif] = '"+ cif +"'"
							+ ",[boxAddress] = '"+ boxAddress +"'"
							+ ",[city] = '"+ city +"'"
							+ ",[cityCouncilRatesDeductions] = '"+ cityCouncilRatesDeductions +"'"
							+ ",[cityCouncilRatesBalance] = '"+ cityCouncilRatesBalance +"'"
							+ ",[createdBy] = '"+ createdBy +"'"
							+ ",[dateloanRequired] = '"+ dateloanRequired +"'"
							+ ",[dateOfBirth] = '"+ dateOfBirth +"'"
							+ ",[dateEngaged] = '"+ dateEngaged +"'"
							+ " ,[dateOfFirstInstallment] = '"+ dateOfFirstInstallment +"'"
							+ ",[dateOfLastInstallment] = '"+ dateOfLastInstallment +"'"
							+ ",[educationalloanDeductions] = '"+ educationalloanDeductions +"'"
							+ ",[educationalloanBalance] = '"+ educationalloanBalance +"'"
							+ ",[emailAddress] = '"+ emailAddress +"'"
							+ ",[employeeCode] = '"+ employeeCode +"'"
							+ ",[employeeEmail] = '"+ employeeEmail +"'"
							+ ",[employeeGrade] = '"+ employeeGrade +"'"
							+ ",[employeePosition] = '"+ employeePosition +"'"
							+ ",[employeeDepartment] = '"+ employeeDepartment +"'"
							
							+ ",[establishmentFee] = '"+ establishmentFee +"'"
							+ ",[farm_smallHolderDeductions] = '"+ farm_smallHolderDeductions +"'"
							+ ",[farm_smallHolderBalance] = '"+ farm_smallHolderBalance +"'"
							+ ",[firstname] = '"+ firstname +"'"
							+ ",[headOfDepartmentComment] = '"+ headOfDepartmentComment +"'"
							+ ",[headOfDepartmentCommentDate] = '"+ headOfDepartmentCommentDate +"'"
							+ ",[hod] = '"+ hod +"'"
							+ ",[hodEmail] = '"+ hodEmail +"'"
							+ ",[housingloanDeductions] = '"+ housingloanDeductions +"'"
							+ ",[housingloanBalance] = '"+ housingloanBalance +"'"
							+ ",[iDNumber] = '"+ iDNumber +"'"
							+ ",[instalment] = '"+ totalRepayment +"'"
							+ ",[insurancesDeductions] = '"+ insurancesDeductions +"'"
							+ ",[insurancesBalance] = '"+ insurancesBalance +"'"
							+ ",[interestRate] = '"+ interestRate +"'"
							+ ",[lastModifiedBy] = '"+ lastModifiedBy +"'"
							+ ",[lastModifiedDate] = '"+ lastModifiedDate +"'"
							+ ",[loanAmount] = '"+ loanAmount +"'"
							+ ",[loanAmountWords] = '"+ loanAmountWords +"'"
							+ ",[loanStatus] = '"+ loanStatus +"'"
							+ ",[loanType] = '"+ loanType +"'"
							+ ",[location] = '"+ location +"'"
							+ ",[maritalStatus] = '"+ maritalStatus +"'"
							+ ",[noOfDependants] = '"+ noOfDependants +"'"
							+ ",[otherBalance] = '"+ otherBalance +"'"
							+ ",[otherDeductions] = '"+ otherDeductions +"'"
							+ ",[otherDeductionsExcLeaveAllowance] = '"+ otherDeductionsExcLeaveAllowance +"'"
							+ ",[personalloanDeductions] = '"+ personalloanDeductions +"'"
							+ ",[personalloanBalance] = '"+ personalloanBalance +"'"
							+ ",[purposeOfLoan] = '"+ purposeOfLoan +"'"
							+ ",[repaymentPeriod] = '"+ repaymentPeriod +"'"
							+ ",[resAddress] = '"+ resAddress +"'"
							+ ",[ruralHousingloanDeductions] = '"+ ruralHousingloanDeductions +"'"
							+ ",[ruralHousingloanBalance] = '"+ ruralHousingloanBalance +"'"
							+ ",[secondName] = '"+ secondName +"'"
							+ ",[securitiesPrinted] = '"+ securitiesPrinted +"'"
							+ ",[statutoryDeductions] = '"+ statutoryDeductions +"'"
							+ ",[supervisorComment] = '"+ supervisorComment +"'"
							+ ",[supervisorCommentDate] = '"+ supervisorCommentDate +"'"
							+ ",[supervisorEmail] = '"+ supervisorEmail +"'"
							+ ",[supervisor] = '"+ supervisor +"'"
							+ ",[surname] = '"+ surname +"'"
							+ ",[targetSavings] = '"+ targetSavings +"'"
							+ ",[telelephoneNo]  = '"+ telelephoneNo +"' WHERE [employeeLoanRef] = '"+ employeeLoanRef +"'";

					java.sql.Statement insertReportStatement = null;

					try {
						
						
						insertReportStatement = con.createStatement();
						insertReportStatement.executeUpdate(insertIssueSql);
						
						insertReportStatement.close();
						con.close();

						response.sendRedirect(request.getContextPath()
								+ "/StaffLoanStatus");

						// Recipient's email ID needs to be mentioned.
						String to = supervisorEmail;

						// Sender's email ID needs to be mentioned
						String from = "staffLoanApplication@swazibank.co.sz";

						// Assuming you are sending email from localhost
						String host = "172.16.1.17";

						// Get system properties
						Properties properties = System.getProperties();

						// Setup mail server
						properties.setProperty("mail.smtp.host", host);

						// Get the default Session object.
						Session session = Session
								.getDefaultInstance(properties);

						// Set response content type
						response.setContentType("text/html");

						try {
							// Create a default MimeMessage object.
							MimeMessage message = new MimeMessage(session);

							// Set From: header field of the header.
							message.setFrom(new InternetAddress(from));

							// Set To: header field of the header.
							message.addRecipient(Message.RecipientType.TO,
									new InternetAddress(to));
							message.addRecipient(Message.RecipientType.CC,	new InternetAddress(emailAddress));
							message.addRecipient(Message.RecipientType.BCC,	new InternetAddress("hloniphileN@swazibank.co.sz"));

							// Set Subject: header field
							message.setSubject("New Staff Loan Submitted by: "
									+ firstname + " " + surname
									+ " Requires your Attention");

							// Now set the actual message
							message.setText("Dear "
									+ supervisor
									+ "\n\n"
									+ "A new Staff Loan has been Submitted by "
									+ firstname
									+ " "
									+ surname
									+ "with reference: "
									+ employeeLoanRef
									+ "\n"
									+ "Please Click on the link http://172.16.1.59:8090/EsdbIntranet/StaffLoanSupervisorRequest to comment."
									+ "\n\n"
									+ "This mail is Auto generated. Please Contact the Applicant on "
									+ emailAddress
									+ " for additional Information." + "\n"
									+ "\n warm regards" + "\n IT Department");
							// Send message
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
		
	}

}
