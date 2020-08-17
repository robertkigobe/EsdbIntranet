package technicalResources.staffLoan;

import java.io.File;
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
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/StaffLoanEmployeeResume")
public class StaffLoanEmployeeResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DateFormat inSdf = new SimpleDateFormat("mm/dd/yyyy");
	private static final DateFormat outSdf = new SimpleDateFormat("yyyy-mm-dd");
	public static Connection con;
	public static String filename;
	Statement selectStatement = null;
	ResultSet results = null;
	private String other11;
	private float disbursedAmount;
	private String disbursementDate;
	private String hodComment;
	private String hodCommentDate;
	private String hrPayrollMasterComment;
	private String hrPayrollMasterCommentDate;
	private String legalAdvisorEmail;
	private String legalAdvisorComment;
	private String legalAdvisorCommentDate;
	private String loanOpeningSupervisor;
	private String loanOpeningSupervisorComment;
	private String loanOpeningSupervisorCommentDate;
	private String loanOpeningSupervisorEmail;
	private float limitRef;
	private String postCode;
	private String repaymentPeriod;
	private String securitiesComment;
	private String securitiesCommentDate;
	private String seniorHrManagerComment;
	private String seniorHrManagerCommentDate;
	private float studyloanDeductions;
	private float studyloanBalance;
	private String securitiesDocumentLocation;
	private String securitiesDocumentUploadDate;
	private String other4;
	private String other5;
	private String other6;
	private String other7;
	private String other8;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		Calendar cal = Calendar.getInstance();

		String viewLoan = request.getParameter("viewLoan");
		String submitLoan = request.getParameter("submitLoan");
		Random rand = new Random();
		int randV = rand.nextInt(500);

		// /////////////date insert///////////////////
		Date dateOpenedN = new Date();
		String dateCreated = sdf.format(dateOpenedN);
		// /////////////setup///////////////////

		float funeralCover = 0;
		String loanDisbursementSupervisor = null;
		String loanDisbursementSupervisorEmail = null;
		float establishmentFee = 0;
		String host = null;
		String hrPayrollMaster = null;
		String hrPayrollMasterEmail = null;
		float interestRate = 0;
		String seniorHrManagerEmail = null;
		String seniorHrManager = null;
		String securitiesSupervisor = null;
		String securitiesSupervisorEmail = null;

		if (con != null) {

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[staffLoanSetUp]";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					funeralCover = results.getFloat("funeralCover");
					establishmentFee = results.getFloat("establishmentFee");
					host = "mail.swazibank.co.sz";
					hrPayrollMaster = results.getString("hrPayrollMaster");
					hrPayrollMasterEmail = results.getString("hrPayrollMasterEmail");
					interestRate = results.getFloat("interestRate");

					seniorHrManagerEmail = results.getString("seniorHrManagerEmail");
					seniorHrManager = results.getString("seniorHrManager");
					securitiesSupervisor = results.getString("securitiesSupervisor");
					securitiesSupervisorEmail = results.getString("securitiesSupervisorEmail");
					loanDisbursementSupervisor = results.getString("loanDisbursementSupervisor");
					loanDisbursementSupervisorEmail = results.getString("loanDisbursementSupervisorEmail");

				}
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}

		float administationFee = 0;
		float allowances = Float.valueOf(request.getParameter("allowances"));
		String applicantComment = request.getParameter("applicantComment");
		String applicantCommentDate = dateCreated;
		String bankExecutioner = request.getParameter("bankExecutioner");
		String bankExecutionerCapacity = request.getParameter("bankExecutionerCapacity");
		float basicSalary = Float.valueOf(request.getParameter("basicSalary"));
		String branchAdress = request.getParameter("branchAdress");
		String city = request.getParameter("city");
		String boxAddress = request.getParameter("boxAddress");
		String employeeAddress = request.getParameter("employeeAddress");

		float carloanDeductions = Float.valueOf(request.getParameter("carloanDeductions"));
		float carloanBalance = Float.valueOf(request.getParameter("carloanBalance"));
		String cif = request.getParameter("cif");
		float cityCouncilRatesDeductions = Float.valueOf(request.getParameter("cityCouncilRatesDeductions"));
		float cityCouncilRatesBalance = Float.valueOf(request.getParameter("cityCouncilRatesBalance"));
		String createdBy = System.getProperty("user.name");
		String dateloanRequired = request.getParameter("dateloanRequired");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String dateEngaged = request.getParameter("dateEngaged");
		String dateOfFirstInstallment = request.getParameter("dateOfFirstInstallment");
		String dateOfLastInstallment = request.getParameter("dateOfLastInstallment");
		String department = request.getParameter("department");
		float educationalloanDeductions = Float.valueOf(request.getParameter("educationalloanDeductions"));
		float educationalloanBalance = Float.valueOf(request.getParameter("educationalloanBalance"));
		String emailAddress = request.getParameter("emailAddress");
		String employeeCode = request.getParameter("employeeCode");
		String employeeEmail = request.getParameter("employeeEmail");
		String employeeGrade = request.getParameter("employeeGrade");
		String employeePosition = request.getParameter("employeePosition");
		String employeeDepartment = request.getParameter("employeeDepartment");
		String employeeLoanRef = employeeDepartment + ": " + randV;
		String employeeSupervisor = request.getParameter("employeeSupervisor");
		String error = null;
		//String noOfDependants = request.getParameter("noOfDependants");
		float farm_smallHolderDeductions = Float.valueOf(request.getParameter("farm_smallHolderDeductions"));
		float farm_smallHolderBalance = Float.valueOf(request.getParameter("farm_smallHolderBalance"));
		double finalValue = 0;
		String firstname = request.getParameter("firstname");
		String gender = request.getParameter("gender");
		String headOfDepartmentComment = request.getParameter("headOfDepartmentComment");
		String headOfDepartmentCommentDate = request.getParameter("headOfDepartmentCommentDate");
		String hod = request.getParameter("hod");
		String hodEmail = request.getParameter("hodEmail");
		float housingloanDeductions = Float.valueOf(request.getParameter("housingloanDeductions"));
		float housingloanBalance = Float.valueOf(request.getParameter("housingloanBalance"));
		String iDNumber = request.getParameter("iDNumber");
		float instalment = 0;
		float insurancesDeductions = Float.valueOf(request.getParameter("insurancesDeductions"));
		float insurancesBalance = Float.valueOf(request.getParameter("insurancesBalance"));

		String lastModifiedBy = System.getProperty("user.name");
		String lastModifiedDate = dateCreated;
		float loanAmount = Float.valueOf(request.getParameter("loanAmount"));
		double loanAmount1 = Double.valueOf(request.getParameter("loanAmount"));
		String loanAmountWords = request.getParameter("loanAmountWords");
		int loanPeriod = 0;
		String loanStatus = null;

		String nextApproval = request.getParameter("nextApproval");
		if (nextApproval.equals("Supervisor")) {
			loanStatus = "Pending-Supervisor Comments";
		} else {
			loanStatus = "Pending Hod Comments";
		}
		String loanType = request.getParameter("loanType");
		String location = request.getParameter("location");
		String maritalStatus = request.getParameter("maritalStatus");

		int noOfDependants = Integer.valueOf(request.getParameter("noOfDependants"));
		float otherBalance = Float.valueOf(request.getParameter("otherBalance"));
		float otherDeductions = Float.valueOf(request.getParameter("otherDeductions"));
		float otherDeductionsExcLeaveAllowance = Float
				.valueOf(request.getParameter("otherDeductionsExcLeaveAllowance"));
		float personalloanDeductions = Float.valueOf(request.getParameter("personalloanDeductions"));
		float personalloanBalance = Float.valueOf(request.getParameter("personalloanBalance"));
		String purposeOfLoan = request.getParameter("purposeOfLoan");
		double rate = Double.valueOf(interestRate);

		String resAddress = request.getParameter("employeeAddress");
		float ruralHousingloanDeductions = Float.valueOf(request.getParameter("ruralHousingloanDeductions"));
		float ruralHousingloanBalance = Float.valueOf(request.getParameter("ruralHousingloanBalance"));
		String secondName = request.getParameter("secondName");
		boolean securitiesPrinted = false;
		float statutoryDeductions = Float.valueOf(request.getParameter("statutoryDeductions"));

		String supervisorComment = request.getParameter("supervisorComment");
		String supervisorCommentDate = request.getParameter("supervisorCommentDate");
		String supervisorEmail = request.getParameter("supervisorEmail");
		String supervisor = request.getParameter("employeeSupervisor");
		String surname = request.getParameter("surName");
		String title = request.getParameter("title");
		float targetSavings = Float.valueOf(request.getParameter("targetSavings"));
		String telelephoneNo = request.getParameter("telelephoneNo");

		Date startDate2 = null;
		String startDate1 = null;
		String endDate1 = null;
		String dob = null;
		NumberFormat formatter = null;

		try {
			Date doFirstInstallment = inSdf.parse(dateOfFirstInstallment);
			startDate1 = outSdf.format(doFirstInstallment);
			Date doLastInstallment = inSdf.parse(dateOfLastInstallment);
			endDate1 = outSdf.format(doLastInstallment);

			formatter = NumberFormat.getCurrencyInstance();

			startDate2 = dateFormat.parse(startDate1);
			loanPeriod = (int) ChronoUnit.MONTHS.between(LocalDate.parse(startDate1).withDayOfMonth(1),
					LocalDate.parse(endDate1).withDayOfMonth(1)) + 1;

		} catch (Exception e1) {
			// System.err.println(e1.getErrorOffset());
			error = "Please use date format mm/dd/yy and ensure start date is less than end date";
			request.setAttribute("employeeCode", employeeCode);
			request.setAttribute("boxAddress", boxAddress);
			request.setAttribute("title", title);
			request.setAttribute("firstname", firstname);
			request.setAttribute("surName", surname);
			request.setAttribute("secondName", secondName);
			request.setAttribute("gender", gender);
			request.setAttribute("iDNumber", iDNumber);
			request.setAttribute("cif", cif);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("maritalStatus", maritalStatus);
			request.setAttribute("dateEngaged", dateEngaged);
			request.setAttribute("employeePosition", employeePosition);
			request.setAttribute("employeeGrade", employeeGrade);
			request.setAttribute("employeeDepartment", employeeDepartment);
			request.setAttribute("employeeSupervisor", employeeSupervisor);
			request.setAttribute("location", location);
			request.setAttribute("branchAdress", branchAdress);
			request.setAttribute("boxAddress", boxAddress);
			request.setAttribute("city", city);
			request.setAttribute("employeeAddress", employeeAddress);

			request.setAttribute("noOfDependants", noOfDependants);
			request.setAttribute("telelephoneNo", telelephoneNo);
			request.setAttribute("emailAddress", emailAddress);
			request.setAttribute("supervisorEmail", supervisorEmail);
			request.setAttribute("hodEmail", hodEmail);
			request.setAttribute("basicSalary", basicSalary);
			request.setAttribute("allowances", allowances);
			request.setAttribute("housingloanDeductions", housingloanDeductions);
			request.setAttribute("housingloanBalance", housingloanBalance);
			request.setAttribute("ruralHousingloanDeductions", ruralHousingloanDeductions);
			request.setAttribute("ruralHousingloanBalance", ruralHousingloanBalance);
			request.setAttribute("farm_smallHolderDeductions", farm_smallHolderDeductions);
			request.setAttribute("farm_smallHolderBalance", farm_smallHolderBalance);
			request.setAttribute("carloanDeductions", carloanDeductions);
			request.setAttribute("carloanBalance", carloanBalance);
			request.setAttribute("personalloanDeductions", personalloanDeductions);
			request.setAttribute("personalloanBalance", personalloanBalance);
			request.setAttribute("educationalloanDeductions", educationalloanDeductions);
			request.setAttribute("educationalloanBalance", educationalloanBalance);

			request.setAttribute("cityCouncilRatesDeductions", cityCouncilRatesDeductions);
			request.setAttribute("cityCouncilRatesBalance", cityCouncilRatesBalance);
			request.setAttribute("insurancesDeductions", insurancesDeductions);
			request.setAttribute("insurancesBalance", insurancesBalance);
			request.setAttribute("otherDeductions", otherDeductions);
			request.setAttribute("otherBalance", otherBalance);
			request.setAttribute("targetSavings", targetSavings);
			
			
			request.setAttribute("noOfDependants", noOfDependants);
			
			
			request.setAttribute("statutoryDeductions", statutoryDeductions);
			request.setAttribute("otherDeductionsExcLeaveAllowance", otherDeductionsExcLeaveAllowance);
			request.setAttribute("dateloanRequired", dateloanRequired);
			request.setAttribute("dateOfFirstInstallment", startDate1);
			request.setAttribute("dateOfLastInstallment", endDate1);
			request.setAttribute("loanType", loanType);
			request.setAttribute("interestRate", interestRate);
			request.setAttribute("funeralCover", funeralCover);
			request.setAttribute("loanAmount", loanAmount);
			request.setAttribute("loanAmountWords", loanAmountWords);
			request.setAttribute("purposeOfLoan", purposeOfLoan);
			request.setAttribute("supervisorEmail", supervisorEmail);
			request.setAttribute("applicantComment", applicantComment);
			request.setAttribute("error", error);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanNewStaffResume.jsp");
			view.forward(request, response);
		}

		// ////////////////armotization //////////////////////

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

		// //////////////////////////////loan

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		int customerAge = (int) ChronoUnit.YEARS.between(LocalDate.parse(dateOfBirth).withDayOfMonth(1),
				LocalDate.parse(date.toString()).withDayOfMonth(1));
		double x = 0;
		double singlePremium = 0;
		double levelTermInsurance = 0;
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
		levelTermInsurance = (x * loanAmount1 / 1000) + singlePremium;

		loanAndCharges = levelTermInsurance + initiationfee + loanAmount1;
		// totalLoanAmount = loanAndCharges + levelTermInsurance;
		// remittedInsurance = (x * loanAndCharges / 1000) + singlePremium;
		double totalRepayment = -(FinanceLib.pmt(r, loanPeriod, loanAndCharges, finalValue, false));

		totalDeductions = Float.valueOf(otherDeductions) + Float.valueOf(insurancesDeductions)
				+ Float.valueOf(cityCouncilRatesDeductions) + Float.valueOf(educationalloanDeductions)
				+ Float.valueOf(personalloanDeductions) + Float.valueOf(carloanDeductions)
				+ Float.valueOf(farm_smallHolderDeductions) + Float.valueOf(ruralHousingloanDeductions)
				+ Float.valueOf(housingloanDeductions);
		totalBalances = Float.valueOf(otherBalance) + Float.valueOf(insurancesBalance)
				+ Float.valueOf(cityCouncilRatesBalance)

				+ Float.valueOf(educationalloanBalance) + Float.valueOf(personalloanBalance)
				+ Float.valueOf(carloanBalance) + Float.valueOf(farm_smallHolderBalance)
				+ Float.valueOf(ruralHousingloanBalance) + Float.valueOf(housingloanBalance);

		netSalary = (Float.valueOf(allowances) + Float.valueOf(basicSalary))
				- (Float.valueOf(totalDeductions) + Float.valueOf(otherDeductionsExcLeaveAllowance)
						+ +Float.valueOf(targetSavings) + Float.valueOf(statutoryDeductions));
		cummulativePercentage = (totalDeductions + totalRepayment);
		cummulativePercentageB = (cummulativePercentage / Double.valueOf(basicSalary)) * 100;

		repaymentAmount = Float.valueOf(instalment) * Integer.valueOf(loanPeriod);

		// ////////////////loan calculator///////////////////////

		if (dateOfFirstInstallment.equals(dateOfLastInstallment)) {
			error = "Start date and End date should be different";
			request.setAttribute("employeeCode", employeeCode);
			request.setAttribute("boxAddress", boxAddress);
			request.setAttribute("title", title);
			request.setAttribute("firstname", firstname);
			request.setAttribute("surName", surname);
			request.setAttribute("secondName", secondName);
			request.setAttribute("gender", gender);
			request.setAttribute("iDNumber", iDNumber);
			request.setAttribute("cif", cif);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("maritalStatus", maritalStatus);
			request.setAttribute("dateEngaged", dateEngaged);
			request.setAttribute("employeePosition", employeePosition);
			request.setAttribute("employeeGrade", employeeGrade);
			request.setAttribute("employeeDepartment", employeeDepartment);
			request.setAttribute("employeeSupervisor", employeeSupervisor);
			request.setAttribute("location", location);
			request.setAttribute("branchAdress", branchAdress);
			request.setAttribute("boxAddress", boxAddress);
			request.setAttribute("city", city);
			request.setAttribute("employeeAddress", employeeAddress);

			request.setAttribute("noOfDependants", noOfDependants);
			request.setAttribute("telelephoneNo", telelephoneNo);
			request.setAttribute("emailAddress", emailAddress);
			request.setAttribute("supervisorEmail", supervisorEmail);
			request.setAttribute("hodEmail", hodEmail);
			request.setAttribute("basicSalary", basicSalary);
			request.setAttribute("allowances", allowances);
			request.setAttribute("housingloanDeductions", housingloanDeductions);
			request.setAttribute("housingloanBalance", housingloanBalance);
			request.setAttribute("ruralHousingloanDeductions", ruralHousingloanDeductions);
			request.setAttribute("ruralHousingloanBalance", ruralHousingloanBalance);
			request.setAttribute("farm_smallHolderDeductions", farm_smallHolderDeductions);
			request.setAttribute("farm_smallHolderBalance", farm_smallHolderBalance);
			request.setAttribute("carloanDeductions", carloanDeductions);
			request.setAttribute("carloanBalance", carloanBalance);
			request.setAttribute("personalloanDeductions", personalloanDeductions);
			request.setAttribute("personalloanBalance", personalloanBalance);
			request.setAttribute("educationalloanDeductions", educationalloanDeductions);
			request.setAttribute("educationalloanBalance", educationalloanBalance);

			request.setAttribute("cityCouncilRatesDeductions", cityCouncilRatesDeductions);
			request.setAttribute("cityCouncilRatesBalance", cityCouncilRatesBalance);
			request.setAttribute("insurancesDeductions", insurancesDeductions);
			request.setAttribute("insurancesBalance", insurancesBalance);
			request.setAttribute("otherDeductions", otherDeductions);
			request.setAttribute("otherBalance", otherBalance);
			request.setAttribute("targetSavings", targetSavings);
			request.setAttribute("statutoryDeductions", statutoryDeductions);
			request.setAttribute("otherDeductionsExcLeaveAllowance", otherDeductionsExcLeaveAllowance);
			request.setAttribute("dateloanRequired", dateloanRequired);
			request.setAttribute("dateOfFirstInstallment", startDate1);
			request.setAttribute("dateOfLastInstallment", endDate1);
			request.setAttribute("loanType", loanType);
			request.setAttribute("interestRate", interestRate);
			request.setAttribute("funeralCover", funeralCover);
			request.setAttribute("loanAmount", loanAmount);
			request.setAttribute("loanAmountWords", loanAmountWords);
			request.setAttribute("purposeOfLoan", purposeOfLoan);
			request.setAttribute("supervisorEmail", supervisorEmail);
			request.setAttribute("applicantComment", applicantComment);
			request.setAttribute("error", error);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanNewStaffResume.jsp");
			view.forward(request, response);
		
		
		} else {

			if (viewLoan != null) {
				// TODO Auto-generated method stub

				Font blackFont1 = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL);
				Font blackFont = FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL);
				Font blackFontListHeading = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.NORMAL);

				Document document = new Document();

				try {

					response.setContentType("application/pdf");
					PdfWriter.getInstance(document, response.getOutputStream());
					document.open();

					Image img = Image.getInstance("C:/IntranetWarehouse/StaffLoan/logo/headerlogo1.jpg");
					document.add(img);

					Paragraph loanCalculator = new Paragraph("LOAN CALCULATOR\n\n", blackFontListHeading);
					document.add(loanCalculator);

					PdfPTable table50 = new PdfPTable(2);
					table50.setWidthPercentage(100);
					table50.setHorizontalAlignment(Element.ALIGN_LEFT);
					table50.setWidths(new int[] { 5, 8 });
					table50.getDefaultCell().setBorder(Rectangle.BOX);
					table50.addCell(new Paragraph("Date of birth", blackFont1));
					table50.addCell(new Paragraph(dateOfBirth, blackFont1));
					table50.addCell(new Paragraph("Employee Age", blackFont1));
					table50.addCell(new Paragraph((String.valueOf(customerAge)), blackFont1));
					table50.addCell(new Paragraph("Loan Start Date", blackFont1));
					table50.addCell(new Paragraph((startDate1), blackFont1));
					table50.addCell(new Paragraph("Loan Period (Months)", blackFont1));
					table50.addCell(new Paragraph((String.valueOf(loanPeriod)), blackFont1));
					table50.addCell(new Paragraph("Loan Amount Requested before funeral cover", blackFont1));
					table50.addCell(new Paragraph((String.format("%.2f", (loanAmount))), blackFont1));
					table50.addCell(new Paragraph("Funeral Cover", blackFont1));
					table50.addCell(new Paragraph((String.format("%.2f", (funeralCover))), blackFont1));
					table50.addCell(new Paragraph("Initiation Fee", blackFont1));
					table50.addCell(new Paragraph(String.format("%.2f", (initiationfee)), blackFont1));
					table50.addCell(new Paragraph("Level Term Insurance", blackFont1));
					table50.addCell(new Paragraph(String.format("%.2f", (levelTermInsurance)), blackFont1));
					table50.addCell(new Paragraph("Total Loan Amount", blackFont1));
					table50.addCell(new Paragraph(String.format("%.2f", (loanAndCharges)), blackFont1));
					document.add(table50);

					Paragraph atmotizationHeading = new Paragraph("STAFF LOAN ARMOTIZATION\n\n", blackFontListHeading);
					document.add(atmotizationHeading);

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

						ftable2.addCell(new Paragraph(String.valueOf(x1 + 1), blackFont));
						ftable2.addCell(new Paragraph(dateTime, blackFont));
						ftable2.addCell(new Paragraph(formatter.format(beginingBalance), blackFont));
						ftable2.addCell(new Paragraph(formatter.format(totalRepayment), blackFont));
						ftable2.addCell(new Paragraph(formatter.format(extraPayment), blackFont));
						ftable2.addCell(new Paragraph(formatter.format(totalPayment), blackFont));
						ftable2.addCell(new Paragraph(formatter.format(principal), blackFont));
						ftable2.addCell(new Paragraph(formatter.format(interest), blackFont));
						ftable2.addCell(new Paragraph(formatter.format(endingBalance), blackFont));
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
					ftable1.addCell(new Paragraph(formatter.format(loanAndCharges), blackFont1));
					ftable1.addCell(new Paragraph("Scheduled Payment", blackFont1));
					ftable1.addCell(new Paragraph(formatter.format(totalRepayment), blackFont1));
					ftable1.addCell(new Paragraph("Annual Interest Rate", blackFont1));
					ftable1.addCell(new Paragraph(String.valueOf(rate) + "%", blackFont1));
					ftable1.addCell(new Paragraph("Scheduled # of   Payments", blackFont1));
					ftable1.addCell(new Paragraph(String.valueOf(x1), blackFont1));
					ftable1.addCell(new Paragraph("Loan Period (Y)", blackFont1));
					ftable1.addCell(new Paragraph(String.valueOf(x1 / 12), blackFont1));
					ftable1.addCell(new Paragraph("Actual # of Payments", blackFont1));
					ftable1.addCell(new Paragraph(String.valueOf(x1), blackFont1));
					ftable1.addCell(new Paragraph("Payments per year", blackFont1));
					ftable1.addCell(new Paragraph("12", blackFont1));
					ftable1.addCell(new Paragraph("Total Early Payments", blackFont1));
					ftable1.addCell(new Paragraph(formatter.format(totalEarlyPayments), blackFont1));

					ftable1.addCell(new Paragraph("First Installment Date", blackFont1));
					ftable1.addCell(new Paragraph(startDate1, blackFont1));
					ftable1.addCell(new Paragraph("Total Interest", blackFont1));
					ftable1.addCell(new Paragraph(formatter.format(totalInterest), blackFont1));

					ftable1.addCell(new Paragraph("Last Installment Date", blackFont1));
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

					Paragraph applicationLetterParagraph2 = new Paragraph("1.	STAFF LOAN APPLICANT’S PARTICULARS\n",
							blackFontListHeading);
					document.add(applicationLetterParagraph2);
					document.add(new Paragraph("\n"));

					PdfPTable table = new PdfPTable(2);
					table.setWidthPercentage(100);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					table.setWidths(new int[] { 5, 8 });
					table.getDefaultCell().setBorder(Rectangle.BOX);

					table.addCell(new Paragraph("Name: ", blackFont1));
					table.addCell(new Paragraph((firstname + " " + surname), blackFont1));
					table.addCell(new Paragraph("Employment No: ", blackFont1));
					table.addCell(new Paragraph((employeeCode), blackFont1));
					table.addCell(new Paragraph("Date of Birth: ", blackFont1));
					table.addCell(new Paragraph((dateOfBirth), blackFont1));
					table.addCell(new Paragraph("Branch: ", blackFont1));
					table.addCell(new Paragraph((location), blackFont1));
					table.addCell(new Paragraph("Position Held: ", blackFont1));
					table.addCell(new Paragraph((employeePosition), blackFont1));
					table.addCell(new Paragraph("Basic Monthly Salary: ", blackFont1));
					table.addCell(new Paragraph(String.valueOf(basicSalary), blackFont1));
					table.addCell(new Paragraph("Marital Status: ", blackFont1));
					table.addCell(new Paragraph((maritalStatus), blackFont1));
					table.addCell(new Paragraph("Position Grade: ", blackFont1));
					table.addCell(new Paragraph((employeeGrade), blackFont1));
					table.addCell(new Paragraph("Address: ", blackFont1));
					table.addCell(new Paragraph((resAddress), blackFont1));
					table.addCell(new Paragraph("No. of Dependants: ", blackFont1));
					table.addCell(new Paragraph((String.valueOf(noOfDependants)), blackFont1));
					table.addCell(new Paragraph("Date Employed: ", blackFont1));
					table.addCell(new Paragraph((dateEngaged), blackFont1));
					table.addCell(new Paragraph("Tel / Cell: ", blackFont1));
					table.addCell(new Paragraph((telelephoneNo), blackFont1));

					document.add(table);

					Paragraph applicationLetterParagraph3 = new Paragraph(
							"2.	LOAN PURPOSE: " + (new Paragraph(purposeOfLoan, blackFontListHeading)),
							blackFontListHeading);
					document.add(applicationLetterParagraph3);
					document.add(new Paragraph("\n"));

					PdfPTable table61 = new PdfPTable(3);
					table61.setWidthPercentage(100);
					table61.setHorizontalAlignment(Element.ALIGN_CENTER);
					table61.setWidths(new int[] { 5, 3, 7 });
					table61.getDefaultCell().setBorder(Rectangle.BOX);

					table61.addCell(new Paragraph(("3. Loan Type: " + loanType), blackFont1));
					table61.addCell(new Paragraph(("Loan Amount: " + loanAndCharges), blackFont1));
					table61.addCell(new Paragraph(("Date Loan is required: " + dateloanRequired), blackFont1));
					document.add(table61);

					Paragraph applicationLetterParagraph30 = new Paragraph("4.	RECENT SALARY ADVICE DETAILS",
							blackFontListHeading);
					document.add(applicationLetterParagraph30);
					document.add(new Paragraph("\n"));

					PdfPTable table1 = new PdfPTable(2);
					table1.setWidthPercentage(100);
					table1.setHorizontalAlignment(Element.ALIGN_LEFT);
					table1.setWidths(new int[] { 8, 4 });
					table1.getDefaultCell().setBorder(Rectangle.BOX);

					table1.addCell(new Paragraph(("Basic Salary:"), blackFont1));
					table1.addCell(new Paragraph((" E " + String.valueOf(Float.valueOf(basicSalary))), blackFont1));

					table1.addCell(new Paragraph(("Allowances (exc. Overtime& leave all:"), blackFont1));
					table1.addCell(new Paragraph((" E " + String.valueOf(Float.valueOf(allowances))), blackFont1));

					table1.addCell(new Paragraph(("Total Earnings:"), blackFont1));
					table1.addCell(new Paragraph(
							(" E " + String.valueOf(Float.valueOf(allowances) + Float.valueOf(basicSalary))),
							blackFont1));

					document.add(table1);

					Paragraph applicationLetterParagraph31 = new Paragraph("Current Loans and Balances: ",
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
					table2.addCell(new Paragraph(("(4) Housing Loan (Mortgage)"), blackFont1));
					table2.addCell(
							new Paragraph((" E " + String.valueOf(Float.valueOf(housingloanDeductions))), blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f", (housingloanBalance))), blackFont1));

					table2.addCell(new Paragraph(("(5) Rural Housing Loan"), blackFont1));
					table2.addCell(
							new Paragraph((" E " + String.format("%.2f", (ruralHousingloanDeductions))), blackFont1));
					table2.addCell(
							new Paragraph((" E " + String.format("%.2f", (ruralHousingloanBalance))), blackFont1));

					table2.addCell(new Paragraph(("(6) Farm / Small Holder"), blackFont1));
					table2.addCell(
							new Paragraph((" E " + String.format("%.2f", (farm_smallHolderDeductions))), blackFont1));
					table2.addCell(
							new Paragraph((" E " + String.format("%.2f", (farm_smallHolderBalance))), blackFont1));

					table2.addCell(new Paragraph(("(7) Car Loan"), blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f", (carloanDeductions))), blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f", (carloanBalance))), blackFont1));

					table2.addCell(new Paragraph(("(8) Personal Loan (36 Months)"), blackFont1));
					table2.addCell(
							new Paragraph((" E " + String.format("%.2f", (personalloanDeductions))), blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f", (personalloanBalance))), blackFont1));

					table2.addCell(new Paragraph(("(9) Educational Loan (12 Months)"), blackFont1));
					table2.addCell(
							new Paragraph((" E " + String.format("%.2f", (educationalloanDeductions))), blackFont1));
					table2.addCell(
							new Paragraph((" E " + String.format("%.2f", (educationalloanBalance))), blackFont1));

					table2.addCell(new Paragraph(("(11) City Council Rates"), blackFont1));
					table2.addCell(
							new Paragraph((" E " + String.format("%.2f", (cityCouncilRatesDeductions))), blackFont1));
					table2.addCell(
							new Paragraph((" E " + String.format("%.2f", (cityCouncilRatesBalance))), blackFont1));

					table2.addCell(new Paragraph(("(12) Insurances"), blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f", (insurancesDeductions))), blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f", (insurancesBalance))), blackFont1));

					table2.addCell(new Paragraph(("(13) Other Loans"), blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f", (otherDeductions))), blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f", (otherBalance))), blackFont1));

					table2.addCell(new Paragraph(("(14) Total"), blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f", (totalDeductions))), blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f", (totalBalances))), blackFont1));

					document.add(table2);

					PdfPTable table3 = new PdfPTable(2);
					table3.setWidthPercentage(100);
					table3.setHorizontalAlignment(Element.ALIGN_LEFT);
					table3.setWidths(new int[] { 8, 4 });
					table3.getDefaultCell().setBorder(Rectangle.BOX);

					table3.addCell(new Paragraph(("(15) Other deductions(excl. Leave allowance)"), blackFont1));
					table3.addCell(
							new Paragraph((" E " + String.valueOf(otherDeductionsExcLeaveAllowance)), blackFont1));

					table3.addCell(new Paragraph(("(16) Target Savings:"), blackFont1));
					table3.addCell(new Paragraph((" E " + String.valueOf(targetSavings)), blackFont1));

					table3.addCell(new Paragraph(("(17) Statutory Deductions(Paye+ Snpf)"), blackFont1));
					table3.addCell(new Paragraph((" E " + String.valueOf(statutoryDeductions)), blackFont1));

					table3.addCell(new Paragraph(("(18) NET SALARY (3) -  (14,15,16, 17)"), blackFont1));
					table3.addCell(new Paragraph((" E " + String.format("%.2f", (netSalary))), blackFont1));

					document.add(table3);
					document.newPage();

					Paragraph applicationLetterParagraph9 = new Paragraph(
							"5.	AMOUNT REQUIRED AND REPAYMENT ARRANGEMENTS: ", blackFontListHeading);
					document.add(applicationLetterParagraph9);
					document.add(new Paragraph("\n"));

					PdfPTable table7 = new PdfPTable(4);
					table7.setWidthPercentage(100);
					table7.setHorizontalAlignment(Element.ALIGN_LEFT);
					table7.setWidths(new int[] { 5, 3, 6, 3 });
					table7.getDefaultCell().setBorder(Rectangle.BOX);

					table7.addCell(new Paragraph(("NEW LOAN: " + loanType), blackFont1));
					table7.addCell(new Paragraph(("INTEREST RATE:" + interestRate + "%"), blackFont1));
					table7.addCell(new Paragraph(("REPAYMENT PERIOD IN MONTHS: " + loanPeriod), blackFont1));
					table7.addCell(new Paragraph(("INSTALMENT:" + " E " + String.format("%.2f", (totalRepayment))),
							blackFont1));

					table7.addCell(". ");
					table7.addCell(". ");
					table7.addCell(new Paragraph(("CUM. PERCENTAGE (14 +19) / 3:"), blackFont1));
					table7.addCell(new Paragraph(String.format("%.2f", (cummulativePercentageB)) + "%", blackFont1));

					table7.addCell(". ");
					table7.addCell(". ");
					table7.addCell(new Paragraph(("19. NET PAY (18) – (19) :"), blackFont1));
					table7.addCell(
							new Paragraph((" E " + String.format("%.2f", (netSalary - totalRepayment))), blackFont1));

					document.add(table7);

					Paragraph applicationLetterParagraph10 = new Paragraph(
							"\n\nVERIFIED BY H.R. DIVISION…………………………………………………………\n\nSIGNATURE………………………………………………………………………………",
							blackFont1);
					document.add(applicationLetterParagraph10);
					document.add(new Paragraph("\n"));
					PdfPTable table4 = new PdfPTable(1);
					table4.setWidthPercentage(100);
					table4.setHorizontalAlignment(Element.ALIGN_LEFT);
					table4.setWidths(new int[] { 5 });
					table4.getDefaultCell().setBorder(Rectangle.BOX);

					table4.addCell(new Paragraph(("6.	APPLICANT’S DECLARATION AND AUTHORISATION"

							+ "\n\nThis application is made under the terms of SwaziBank staff loan Policy current at this time."
							+ "\n\nI declare that the information given here is correct.  To the best of my knowledge and belief I have not omitted any information pertinent this application."
							+ "\n\nI hereby authorize and request SwaziBank to deduct the repayments specified overleaf from my salary to the credit of the relative loans(s) until all outstanding balances and interest have been paid in full."
							+ "\n\nI hereby grant to SwaziBank a lien and right of set off over all accounts whatsoever standing to my credit at SwaziBank."
							+ "\n\nI hereby grant to SwaziBank a lien over any/all terminal benefit due to me with the right to apply such benefits as repayment of any outstanding loans and / or interest."
							+ "\n\nI understand that in the event of my leaving the employment of the bank for any reason the outstanding balances of any loans will immediately become due and payable."
							+ "\n" + "\n" + "\n"

							+ "\nSIGNATURE: ………………………………………………… "), blackFont1));

					table4.addCell(new Paragraph(
							("6.	Manager’s / Senior Manager’s / Supervisors comments and recommendations."
									+ "\n\nI confirm that his request is within the terms of the Staff Loans Policy currently in force."
									+ "\n" + "\n" + "\n"

									+ "\nSIGNATURE: ………………………………………………… "),
							blackFont1));

					table4.addCell(new Paragraph(("7.	EXECUTIVE HEAD OF DEPARTMENT" + "\n" + "\n" + "\n"

							+ "\nSIGNATURE: ………………………………………………… "), blackFont1));

					table4.addCell(new Paragraph(("8. APPROVED  / DECLINED" + "\n" + "\n" + "\n"

							+ "\nSIGNATURE: ………………………………………………… "), blackFont1));

					document.add(table4);
					document.add(new Paragraph("\n"));

				} catch (Exception e) {
					e.printStackTrace();
				}
				document.close();

			} else if (submitLoan != null) {
				// TODO Auto-generated method stub

				con = connectionHelper.connect();
				if (con != null) {

					String insertIssueSql = "INSERT INTO [dbo].[staffLoan]  " + "([administationFee] "
							+ ",[allowances]   " + ",[applicantComment]   " + ",[applicantCommentDate]  "
							+ ",[bankExecutioner]  " + ",[bankExecutionerCapacity] " + ",[basicSalary]  "
							+ ",[branchAdress]   " + ",[boxAddress]  " + ",[carloanDeductions]  "
							+ ",[carloanBalance]  " + ",[cif]  " + ",[city]  " + ",[cityCouncilRatesDeductions]   "
							+ ",[cityCouncilRatesBalance]   " + ",[createdBy]  " + ",[customerAge]  "
							+ ",[dateloanRequired] " + ",[dateOfBirth]  " + ",[dateEngaged] "
							+ ",[dateOfFirstInstallment]  " + ",[dateOfLastInstallment]  " + ",[department]  "
							+ ",[disbursedAmount]  " + ",[disbursementDate]  " + ",[educationalloanDeductions]  "
							+ ",[educationalloanBalance]   " + ",[emailAddress]   " + ",[employeeAddress]  "
							+ ",[employeeCode]   " + ",[employeeEmail]   " + ",[employeeGrade]   "
							+ ",[employeePosition]   " + ",[employeeDepartment]  " + ",[employeeLoanRef]   "
							+ ",[establishmentFee]   " + ",[farm_smallHolderDeductions]  "
							+ ",[farm_smallHolderBalance] " + ",[firstname]   " + ",[funeralCover]   "
							+ ",[headOfDepartmentComment]   " + ",[headOfDepartmentCommentDate]  " + ",[hod]  "
							+ ",[hodComment]  " + ",[hodCommentDate]  " + ",[hodEmail]    "
							+ ",[housingloanDeductions]  " + ",[housingloanBalance]   " + ",[hrPayrollMasterComment]  "
							+ ",[hrPayrollMaster]   " + ",[hrPayrollMasterCommentDate]  " + ",[hrPayrollMasterEmail]   "
							+ ",[iDNumber]  " + ",[instalment]  " + ",[insurancesDeductions]  "
							+ ",[insurancesBalance]  " + ",[interestRate]  " + ",[lastModifiedBy]  "
							+ ",[lastModifiedDate]   " + ",[legalAdvisorEmail]  " + ",[legalAdvisorComment]  "
							+ ",[legalAdvisorCommentDate]   " + ",[levelTermInsurance]  " + ",[loanAndCharges]  "
							+ ",[loanAmount]  " + ",[loanAmountWords]   " + ",[loanPeriod]   "
							+ ",[loanOpeningSupervisor]  " + ",[loanOpeningSupervisorComment]  "
							+ ",[loanOpeningSupervisorCommentDate]  " + ",[loanOpeningSupervisorEmail]   "
							+ ",[location]  " + ",[limitRef]  " + ",[loanStatus]  " + ",[loanType]  "
							+ " ,[maritalStatus]  " + ",[noOfDependants]  " + ",[otherBalance]  "
							+ ",[otherDeductions]  " + ",[otherDeductionsExcLeaveAllowance]  "
							+ ",[personalloanDeductions]   " + ",[personalloanBalance]  " + ",[purposeOfLoan] "
							+ ",[postCode]  " + ",[repaymentPeriod]  " + ",[resAddress]  "
							+ ",[ruralHousingloanDeductions]  " + ",[ruralHousingloanBalance]  " + ",[secondName] "
							+ ",[securitiesPrinted]  " + ",[securitiesComment]  " + ",[securitiesCommentDate]  "
							+ ",[seniorHrManager]  " + ",[seniorHrManagerEmail]  " + ",[seniorHrManagerComment]  "
							+ ",[seniorHrManagerCommentDate]  " + ",[statutoryDeductions]  "
							+ ",[studyloanDeductions]  " + ",[studyloanBalance]  " + ",[supervisorComment]  "
							+ ",[supervisorCommentDate]  " + ",[supervisorEmail]  " + ",[supervisor]  " + ",[surname]  "
							+ ",[securitiesSupervisor]  " + ",[securitiesSupervisorEmail]  "
							+ ",[securitiesDocumentLocation]  " + ",[securitiesDocumentUploadDate] "
							+ ",[targetSavings] " + ",[telelephoneNo] " + ",[totalRepayment] " + ",[totalInterest]  "
							+ ",[other4]  " + ",[other5] " + ",[other6] " + ",[other7] " + ",[other8] " + ",[other11]) "
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

					java.sql.PreparedStatement insertReportStatement = null;

					try {

						insertReportStatement = con.prepareStatement(insertIssueSql, new String[] { "id" });
						int x1 = 1;

						insertReportStatement.setFloat(x1++, administationFee);
						insertReportStatement.setFloat(x1++, allowances);
						insertReportStatement.setString(x1++, applicantComment);
						insertReportStatement.setString(x1++, applicantCommentDate);
						insertReportStatement.setString(x1++, bankExecutioner);
						insertReportStatement.setString(x1++, bankExecutionerCapacity);
						insertReportStatement.setFloat(x1++, basicSalary);
						insertReportStatement.setString(x1++, branchAdress);
						insertReportStatement.setString(x1++, boxAddress);
						insertReportStatement.setFloat(x1++, carloanDeductions);
						insertReportStatement.setFloat(x1++, carloanBalance);
						insertReportStatement.setString(x1++, cif);
						insertReportStatement.setString(x1++, city);
						insertReportStatement.setFloat(x1++, cityCouncilRatesDeductions);
						insertReportStatement.setFloat(x1++, cityCouncilRatesBalance);
						insertReportStatement.setString(x1++, createdBy);
						insertReportStatement.setFloat(x1++, customerAge);
						insertReportStatement.setString(x1++, dateloanRequired);
						insertReportStatement.setString(x1++, dateOfBirth);
						insertReportStatement.setString(x1++, dateEngaged);
						insertReportStatement.setString(x1++, dateOfFirstInstallment);
						insertReportStatement.setString(x1++, dateOfLastInstallment);
						insertReportStatement.setString(x1++, department);
						insertReportStatement.setFloat(x1++, disbursedAmount);
						insertReportStatement.setString(x1++, disbursementDate);
						insertReportStatement.setFloat(x1++, educationalloanDeductions);
						insertReportStatement.setFloat(x1++, educationalloanBalance);
						insertReportStatement.setString(x1++, emailAddress);
						insertReportStatement.setString(x1++, employeeAddress);
						insertReportStatement.setString(x1++, employeeCode);
						insertReportStatement.setString(x1++, employeeEmail);
						insertReportStatement.setString(x1++, employeeGrade);
						insertReportStatement.setString(x1++, employeePosition);
						insertReportStatement.setString(x1++, employeeDepartment);
						insertReportStatement.setString(x1++, employeeLoanRef);
						insertReportStatement.setFloat(x1++, establishmentFee);
						insertReportStatement.setFloat(x1++, farm_smallHolderDeductions);
						insertReportStatement.setFloat(x1++, farm_smallHolderBalance);
						insertReportStatement.setString(x1++, firstname);
						insertReportStatement.setFloat(x1++, funeralCover);
						insertReportStatement.setString(x1++, headOfDepartmentComment);
						insertReportStatement.setString(x1++, headOfDepartmentCommentDate);
						insertReportStatement.setString(x1++, hod);
						insertReportStatement.setString(x1++, hodComment);
						insertReportStatement.setString(x1++, hodCommentDate);
						insertReportStatement.setString(x1++, hodEmail);
						insertReportStatement.setFloat(x1++, housingloanDeductions);
						insertReportStatement.setFloat(x1++, housingloanBalance);
						insertReportStatement.setString(x1++, hrPayrollMasterComment);
						insertReportStatement.setString(x1++, hrPayrollMaster);
						insertReportStatement.setString(x1++, hrPayrollMasterCommentDate);
						insertReportStatement.setString(x1++, hrPayrollMasterEmail);
						insertReportStatement.setString(x1++, iDNumber);
						insertReportStatement.setFloat(x1++, instalment);
						insertReportStatement.setFloat(x1++, insurancesDeductions);
						insertReportStatement.setFloat(x1++, insurancesBalance);
						insertReportStatement.setFloat(x1++, interestRate);
						insertReportStatement.setString(x1++, lastModifiedBy);
						insertReportStatement.setString(x1++, lastModifiedDate);
						insertReportStatement.setString(x1++, legalAdvisorEmail);
						insertReportStatement.setString(x1++, legalAdvisorComment);
						insertReportStatement.setString(x1++, legalAdvisorCommentDate);
						insertReportStatement.setFloat(x1++, (float) levelTermInsurance);
						insertReportStatement.setFloat(x1++, (float) loanAndCharges);
						insertReportStatement.setFloat(x1++, loanAmount);
						insertReportStatement.setString(x1++, loanAmountWords);
						insertReportStatement.setFloat(x1++, loanPeriod);
						insertReportStatement.setString(x1++, loanOpeningSupervisor);
						insertReportStatement.setString(x1++, loanOpeningSupervisorComment);
						insertReportStatement.setString(x1++, loanOpeningSupervisorCommentDate);
						insertReportStatement.setString(x1++, loanOpeningSupervisorEmail);
						insertReportStatement.setString(x1++, location);
						insertReportStatement.setFloat(x1++, limitRef);
						insertReportStatement.setString(x1++, loanStatus);
						insertReportStatement.setString(x1++, loanType);
						insertReportStatement.setString(x1++, maritalStatus);
						insertReportStatement.setFloat(x1++, noOfDependants);
						insertReportStatement.setFloat(x1++, otherBalance);
						insertReportStatement.setFloat(x1++, otherDeductions);
						insertReportStatement.setFloat(x1++, otherDeductionsExcLeaveAllowance);
						insertReportStatement.setFloat(x1++, personalloanDeductions);
						insertReportStatement.setFloat(x1++, personalloanBalance);
						insertReportStatement.setString(x1++, purposeOfLoan);
						insertReportStatement.setString(x1++, postCode);
						insertReportStatement.setString(x1++, String.valueOf(loanPeriod));
						insertReportStatement.setString(x1++, resAddress);
						insertReportStatement.setFloat(x1++, ruralHousingloanDeductions);
						insertReportStatement.setFloat(x1++, ruralHousingloanBalance);
						insertReportStatement.setString(x1++, secondName);
						insertReportStatement.setBoolean(x1++, securitiesPrinted);
						insertReportStatement.setString(x1++, securitiesComment);
						insertReportStatement.setString(x1++, securitiesCommentDate);
						insertReportStatement.setString(x1++, seniorHrManager);
						insertReportStatement.setString(x1++, seniorHrManagerEmail);
						insertReportStatement.setString(x1++, seniorHrManagerComment);
						insertReportStatement.setString(x1++, seniorHrManagerCommentDate);
						insertReportStatement.setFloat(x1++, statutoryDeductions);
						insertReportStatement.setFloat(x1++, studyloanDeductions);
						insertReportStatement.setFloat(x1++, studyloanBalance);
						insertReportStatement.setString(x1++, supervisorComment);
						insertReportStatement.setString(x1++, supervisorCommentDate);
						insertReportStatement.setString(x1++, supervisorEmail);
						insertReportStatement.setString(x1++, supervisor);
						insertReportStatement.setString(x1++, surname);
						insertReportStatement.setString(x1++, securitiesSupervisor);
						insertReportStatement.setString(x1++, securitiesSupervisorEmail);
						insertReportStatement.setString(x1++, securitiesDocumentLocation);
						insertReportStatement.setString(x1++, securitiesDocumentUploadDate);
						insertReportStatement.setFloat(x1++, targetSavings);
						insertReportStatement.setString(x1++, telelephoneNo);
						insertReportStatement.setFloat(x1++, (float) totalRepayment);
						insertReportStatement.setFloat(x1++, (float) totalInterest);
						insertReportStatement.setString(x1++, other4);
						insertReportStatement.setString(x1++, other5);
						insertReportStatement.setString(x1++, other6);
						insertReportStatement.setString(x1++, other7);
						insertReportStatement.setString(x1++, other8);
						insertReportStatement.setString(x1++, other11);

						insertReportStatement.executeUpdate();
						insertReportStatement.close();

						con.close();

						response.sendRedirect(request.getContextPath() + "/StaffLoanStatus");
						File paySlips = new File("\\\\\\172.16.1.59\\IntranetWarehouse\\StaffLoanPayslips");
						if (nextApproval.equals("Supervisor")) {

							// Recipient's email ID needs to be mentioned.
							String to = supervisorEmail;

							// Sender's email ID needs to be mentioned
							String from = "staffLoanApplication@swazibank.co.sz";

							// Assuming you are sending email from localhost

							// Get system properties
							Properties properties = System.getProperties();

							// Setup mail server
							properties.setProperty("mail.smtp.host", host);

							// Get the default Session object.
							Session session = Session.getDefaultInstance(properties);

							// Set response content type
							response.setContentType("text/html");

							try {
								// Create a default MimeMessage object.
								MimeMessage message = new MimeMessage(session);

								// Set From: header field of the header.
								message.setFrom(new InternetAddress(from));

								// Set To: header field of the header.
								message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
								message.addRecipient(Message.RecipientType.CC, new InternetAddress(emailAddress));
								message.addRecipient(Message.RecipientType.BCC,
										new InternetAddress("hloniphileN@swazibank.co.sz"));

								// Set Subject: header field
								message.setSubject("New Staff Loan Submitted by: " + firstname + " " + surname
										+ " Requires your Attention");

								// Now set the actual message
								message.setText("Dear " + supervisor + "\n\n"
										+ "A new Staff Loan has been Submitted by " + firstname + " " + surname
										+ "with reference: " + employeeLoanRef + "\n"
										+ "Please Click on the link http://live-intranet:8090/EsdbIntranet/StaffLoanSupervisorRequest for your comment."
										+ "\n\nYou can view the employee payslip here file://172.16.1.59//IntranetWarehouse//StaffLoanPayslips/ "
										+ "\n\n" + "This mail is Auto generated. Please Contact the Applicant on "
										+ emailAddress + " for additional Information." + "\n" + "\n warm regards"
										+ "\n IT Department");
								// Send message
								Transport.send(message);

							} catch (MessagingException mex) {
								mex.printStackTrace();
							}
						} else if (nextApproval.equals("Head of Department")) {

							// Recipient's email ID needs to be mentioned.
							String to = supervisorEmail;

							// Sender's email ID needs to be mentioned
							String from = "staffLoanApplication@swazibank.co.sz";

							// Assuming you are sending email from localhost

							// Get system properties
							Properties properties = System.getProperties();

							// Setup mail server
							properties.setProperty("mail.smtp.host", host);

							// Get the default Session object.
							Session session = Session.getDefaultInstance(properties);

							// Set response content type
							response.setContentType("text/html");

							try {
								// Create a default MimeMessage object.
								MimeMessage message = new MimeMessage(session);

								// Set From: header field of the header.
								message.setFrom(new InternetAddress(from));

								// Set To: header field of the header.
								message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
								message.addRecipient(Message.RecipientType.CC, new InternetAddress(employeeEmail));
								message.addRecipient(Message.RecipientType.BCC,
										new InternetAddress("hloniphileN@swazibank.co.sz"));

								// Set Subject: header field
								message.setSubject("New Staff Loan Submitted by: " + firstname + " " + surname
										+ " Requires your Attention");

								// Now set the actual message

								message.setText("Dear " + supervisor + "\n\n"
										+ "A new Staff Loan has been Submitted by " + firstname + " " + surname
										+ "with reference: " + employeeLoanRef + "\n"
										+ "Please Click on the link http://live-intranet:8090/EsdbIntranet/StaffLoanHodRequest for your comment."

										+ "\n\nYou can view the employee payslip here file://172.16.1.59//IntranetWarehouse//StaffLoanPayslips/ "

										+ "\n\n" + "This mail is Auto generated. Please Contact the Applicant on "
										+ emailAddress + " for additional Information." + "\n" + "\n warm regards"
										+ "\n IT Department");
								// Send message
								Transport.send(message);

							} catch (MessagingException mex) {
								mex.printStackTrace();
							}
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
