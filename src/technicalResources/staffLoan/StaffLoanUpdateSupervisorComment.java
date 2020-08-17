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

@WebServlet("/StaffLoanUpdateSupervisorComment")
public class StaffLoanUpdateSupervisorComment extends HttpServlet {
	public static Connection con;
	public static String filename;
	private static final long serialVersionUID = 1L;
	private static final DateFormat inSdf = new SimpleDateFormat("mm/dd/yyyy");
	private static final DateFormat outSdf = new SimpleDateFormat("yyyy-mm-dd");
	
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		String viewLoan = request.getParameter("viewLoan");
		String submitLoan = request.getParameter("submitLoan");
		Random rand = new Random();
		rand.nextInt(500);
		
		Statement selectStatement = null;
		ResultSet results = null;
		float funeralCover = 0;
		String host = null;
		
		float interestRate = 0;
		if (con != null) {
			
			System.out.println("the connection is: " +host);

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[staffLoanSetUp]";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					funeralCover = results.getFloat("funeralCover");
					
					host = "mail.swazibank.co.sz";
					
					
					interestRate = results.getFloat("interestRate");
					
	
					
				

				}
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}

		// /////////////date insert///////////////////
		Date dateOpenedN = new Date();
		String dateCreated = sdf.format(dateOpenedN);
		// /////////////date insert///////////////////

		float allowances = Float.valueOf(request.getParameter("allowances"));
		request.getParameter("applicantComment");
		request.getParameter("bankExecutioner");
		request
				.getParameter("bankExecutionerCapacity");
		float basicSalary = Float.valueOf(request.getParameter("basicSalary"));
		String branchAdress = request.getParameter("branchAdress");
		request.getParameter("city");
		request.getParameter("boxAddress");
		request.getParameter("employeeAddress");
		
		float carloanDeductions = Float.valueOf(request
				.getParameter("carloanDeductions"));
		float carloanBalance = Float.valueOf(request
				.getParameter("carloanBalance"));
		String cif = request.getParameter("cif");
		float cityCouncilRatesDeductions = Float.valueOf(request
				.getParameter("cityCouncilRatesDeductions"));
		float cityCouncilRatesBalance = Float.valueOf(request
				.getParameter("cityCouncilRatesBalance"));
		System.getProperty("user.name");
		String dateloanRequired = request.getParameter("dateloanRequired");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String dateEngaged = request.getParameter("dateEngaged");
		String dateOfFirstInstallment = request
				.getParameter("dateOfFirstInstallment");
		request
				.getParameter("dateOfLastInstallment");
		request.getParameter("department");
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
		String employeeLoanRef = request.getParameter("employeeLoanRef");
		request.getParameter("employeeSupervisor");
		String dateOfLastInstallment = request.getParameter("dateOfLastInstallment");
		float farm_smallHolderDeductions = Float.valueOf(request
				.getParameter("farm_smallHolderDeductions"));
		float farm_smallHolderBalance = Float.valueOf(request
				.getParameter("farm_smallHolderBalance"));
		double finalValue = 0;
		String firstname = request.getParameter("firstname");
		request.getParameter("gender");
		request
				.getParameter("headOfDepartmentComment");
		request
				.getParameter("headOfDepartmentCommentDate");
		String hod = request.getParameter("hod");
		String hodEmail = request.getParameter("hodEmail");
		float housingloanDeductions = Float.valueOf(request
				.getParameter("housingloanDeductions"));
		float housingloanBalance = Float.valueOf(request
				.getParameter("housingloanBalance"));
		String iDNumber = request.getParameter("iDNumber");
		float insurancesDeductions = Float.valueOf(request
				.getParameter("insurancesDeductions"));
		float insurancesBalance = Float.valueOf(request
				.getParameter("insurancesBalance"));
		
		String lastModifiedBy = System.getProperty("user.name");
		String lastModifiedDate = dateCreated;
		String levelTermInsurances = request.getParameter("levelTermInsurance");
		float loanAmount = Float.valueOf(request.getParameter("loanAmount"));
		double loanAmount1 = Double.valueOf(request.getParameter("loanAmount")) - Double.valueOf(levelTermInsurances);
		String loanAmountWords = request.getParameter("loanAmountWords");
		int loanPeriod = 0;
		String loanStatus =  request.getParameter("loanStatus");
		String loanType = request.getParameter("loanType");
		request.getParameter("location");
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
		double rate = Double.valueOf(6.5);
		
		
		request.getParameter("employeeAddress");
		float ruralHousingloanDeductions = Float.valueOf(request
				.getParameter("ruralHousingloanDeductions"));
		float ruralHousingloanBalance = Float.valueOf(request
				.getParameter("ruralHousingloanBalance"));
		request.getParameter("secondName");
		float statutoryDeductions = Float.valueOf(request
				.getParameter("statutoryDeductions"));
		
		
		String supervisorComment = request.getParameter("supervisorComment");
		String supervisorCommentDate = dateCreated;
		String supervisorEmail = request.getParameter("supervisorEmail");
		String supervisor = request.getParameter("supervisor");
		String surname = request.getParameter("surName");
		request.getParameter("title");
		float targetSavings = Float.valueOf(request
				.getParameter("targetSavings"));
		String telelephoneNo = request.getParameter("telelephoneNo");
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		
		Date startDate2 = null;
		String startDate1 = null;
		String endDate1 = null;
		String dob = null;
		
		try{ 
			Date doFirstInstallment = inSdf.parse(dateOfFirstInstallment);
			startDate1 = outSdf.format(doFirstInstallment);
			Date doLastInstallment = inSdf.parse(dateOfLastInstallment);
			endDate1 = outSdf.format(doLastInstallment);
			
		
		}catch(ParseException se){}
		
		
		try {
			startDate2 = dateFormat.parse(startDate1);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		loanPeriod = (int) ChronoUnit.MONTHS.between(LocalDate
				.parse(startDate1).withDayOfMonth(1), LocalDate.parse(endDate1)
				.withDayOfMonth(1)) + 1;
		

		// ////////////////armotization //////////////////////

		double r = (rate / 100) / 12;
		double beginingBalance = 0;
		double totalEarlyPayments = 0;
		double extraPayment = 0;
		double totalPayment = 0;
		double principal = 0;
		double interest = 0;
		double endingBalance = 0;
		double totalInterest = 0;
		double levelTermInsurance = 0;
		totalInterest = interest * loanPeriod;
		
		
		float totalDeductions = 0;
		float totalBalances = 0;
		float netSalary = 0;
		double cummulativePercentage = 0;
		double cummulativePercentageB =0;
		
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		int customerAge = (int) ChronoUnit.YEARS.between(
				LocalDate.parse(dateOfBirth).withDayOfMonth(1), LocalDate
						.parse(date.toString()).withDayOfMonth(1));
		double x = 0;
		double singlePremium = 0;

		double initiationfee = 0;
		double loanAndCharges = 0;
		//double remittedInsurance = 0;
		//double totalLoanAmount = 0;
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
		//totalLoanAmount = loanAndCharges + levelTermInsurance;
		//remittedInsurance = (x * loanAndCharges / 1000) + singlePremium;
		double totalRepayment = -(FinanceLib.pmt(r, loanPeriod, loanAndCharges,	finalValue, false));
		
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
				- ( Float.valueOf(otherDeductionsExcLeaveAllowance) 	+  Float.valueOf(totalDeductions) 	+ Float.valueOf(targetSavings) + Float.valueOf(statutoryDeductions));
		cummulativePercentage = (totalDeductions +  totalRepayment);
		cummulativePercentageB = (cummulativePercentage/basicSalary)*100;
		
		//Float.valueOf(instalment)* Integer.valueOf(loanPeriod);

		if (loanStatus.equals("Cancel")) {

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();
			if (con != null) {

				String insertIssueSql = "UPDATE [dbo].[staffLoan] SET "
						+ "supervisor = '"
						+ supervisor
						+ "',"
						
						+ "iDNumber = '"
						+ iDNumber
						+ "',"
						+ "cif = '"
						+ cif
						+ "',"
						+ "employeePosition = '"
						+ employeePosition
						+ "',"
						+ "employeeGrade = '"
						+ employeeGrade
						+ "',"
						+ "employeeDepartment = '"
						+ employeeDepartment
						+ "',"
						+ "hod = '"
						+ hod
						+ "',"
						+ "hodEmail = '"
						+ hodEmail
						+ "',"
						+ "branchAdress						 = '"
						+ branchAdress
						+ "',"
						+ "telelephoneNo = '"
						+ telelephoneNo
						+ "',"
						+ "emailAddress = '"
						+ emailAddress
						+ "',"
						+ "supervisorEmail = '"
						+ supervisorEmail
						+ "',"
						
						+ "basicSalary = '"
						+ basicSalary
						+ "',"
						+ "allowances							 = '"
						+ allowances
						+ "',"
						+ "interestRate = '"
						+ interestRate
						+ "',"
						
						+ "loanAmountWords = '"
						+ loanAmountWords
						+ "',"
						+ "loanStatus = '"
						+ loanStatus
						+ "',"
						+ "supervisorComment = '"
						+ supervisorComment
						+ "',"
						+ "supervisorCommentDate = '"
						+ supervisorCommentDate
						+ "',"
						+ "[lastModifiedDate]  = '"
						+ lastModifiedDate
						+ "',"
						+ "[lastModifiedBy]  = '"
						+ lastModifiedBy
						+ "'"
						+ "Where [employeeLoanRef] = '" + employeeLoanRef + "'";

				java.sql.Statement insertReportStatement = null;

				try {

					insertReportStatement = con.createStatement();
					insertReportStatement.executeUpdate(insertIssueSql);

					insertReportStatement.close();
					con.close();

					response.sendRedirect(request.getContextPath()
							+ "/StaffLoanStatus");

					// Recipient's email ID needs to be mentioned.
					String to = employeeEmail;

					// Sender's email ID needs to be mentioned
					String from = "staffLoanApplication@swazibank.co.sz";

					

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
						message.addRecipient(Message.RecipientType.TO,
								new InternetAddress(to));

						// Set Subject: header field
						message.setSubject("Staff Loan Cancelled by: "
								+ supervisor);

						// Now set the actual message
						message.setText("Dear "
								+ firstname
								+ " "
								+ surname
								+ "\n"
								+ "\n"
								+ "Your Loan Staff Application  with Reference: "
								+ employeeLoanRef
								+ " has been cancelled. "
								+ "\n"

								+ "This mail is Auto generated. Please Contact your supervisor on "
								+ supervisorEmail
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

			}

		} else if (loanStatus.equals("Return to Staff for editing")) {

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();
			if (con != null) {

				String insertIssueSql = "UPDATE [dbo].[staffLoan] SET supervisor = '"
						+ supervisor
						+ "',"
						+ "supervisorEmail = '"
						+ supervisorEmail
						+ "',"
						+ "iDNumber = '"
						+ iDNumber
						+ "',"
						+ "cif = '"
						+ cif
						+ "',"
						+ "employeePosition = '"
						+ employeePosition
						+ "',"
						+ "employeeGrade = '"
						+ employeeGrade
						+ "',"
						+ "employeeDepartment = '"
						+ employeeDepartment
						+ "',"
						+ "hod = '"
						+ hod
						+ "',"
						+ "hodEmail = '"
						+ hodEmail
						+ "',"
						+ "branchAdress						 = '"
						+ branchAdress
						+ "',"
						+ "telelephoneNo = '"
						+ telelephoneNo
						+ "',"
						+ "emailAddress = '"
						+ emailAddress
						+ "',"
						
						
						+ "basicSalary = '"
						+ basicSalary
						+ "',"
						+ "allowances							 = '"
						+ allowances
						+ "',"
						+ "interestRate = '"
						+ interestRate
						+ "',"
						
						+ "loanAmountWords = '"
						+ loanAmountWords
						+ "',"
						+ "loanStatus = '"
						+ loanStatus
						+ "',"
						+ "supervisorComment = '"
						+ supervisorComment
						+ "',"
						+ "supervisorCommentDate = '"
						+ supervisorCommentDate
						+ "',"
						+ "[lastModifiedDate]  = '"
						+ lastModifiedDate
						+ "',"
						+ "[lastModifiedBy]  = '"
						+ lastModifiedBy
						+ "'"
						+ "Where [employeeLoanRef] = '" + employeeLoanRef + "'";

				java.sql.Statement insertReportStatement = null;

				try {

					insertReportStatement = con.createStatement();
					insertReportStatement.executeUpdate(insertIssueSql);

					insertReportStatement.close();
					con.close();

					response.sendRedirect(request.getContextPath()
							+ "/StaffLoanStatus");

					// Recipient's email ID needs to be mentioned.
					String to = employeeEmail;

					// Sender's email ID needs to be mentioned
					String from = "staffLoanApplication@swazibank.co.sz";

					

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
						message.addRecipient(Message.RecipientType.TO,
								new InternetAddress(to));

						// Set Subject: header field
						message.setSubject("Staff Loan requires editing");

						// Now set the actual message
						message.setText("Dear "
								+ firstname
								+ " "
								+ surname
								+ "\n"
								+ "\n"
								+ "Your Loan Staff Application  with Reference: "
								+ employeeLoanRef
								+ " has been returned for your action. Please click on the link to edit your loan: http://172.16.1.59:8080/EsdbIntranet/StaffLoanEditLoan"
								+ "\n"

								+ "This mail is Auto generated. Please Contact your supervisor on "
								+ supervisorEmail
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

		} else {
			if (viewLoan != null) {
// TODO Auto-generated method stub
				
				Font blackFont1 = FontFactory.getFont(FontFactory.HELVETICA, 8,
						Font.NORMAL);
				Font blackFont = FontFactory.getFont(FontFactory.HELVETICA, 7,
						Font.NORMAL);
				Font blackFontListHeading = FontFactory.getFont(
						FontFactory.TIMES_BOLD, 18, Font.NORMAL);
				

				Document document = new Document();

				try {

					response.setContentType("application/pdf");
					PdfWriter.getInstance(document, response.getOutputStream());
					document.open();

					Image img = Image.getInstance("C:/IntranetWarehouse/StaffLoan/logo/headerlogo1.jpg");
					
					document.add(img);
					
					Paragraph loanCalculator = new Paragraph(
							"LOAN CALCULATOR\n\n",
							blackFontListHeading);
					document.add(loanCalculator);
					
					PdfPTable table50 = new PdfPTable(2);
					table50.setWidthPercentage(100);
					table50.setHorizontalAlignment(Element.ALIGN_LEFT);
					table50.setWidths(new int[] { 5, 8 });
					table50.getDefaultCell().setBorder(Rectangle.BOX);
					table50.addCell(new Paragraph("Date of birth", blackFont1));
					table50.addCell(new Paragraph((dateOfBirth),blackFont1));
					table50.addCell(new Paragraph("Employee Age", blackFont1));
					table50.addCell(new Paragraph((String.valueOf(customerAge)),blackFont1));
					table50.addCell(new Paragraph("Loan Start Date", blackFont1));
					table50.addCell(new Paragraph((dateOfFirstInstallment),blackFont1));
					table50.addCell(new Paragraph("Loan Period (Months)", blackFont1));
					table50.addCell(new Paragraph((String.valueOf(loanPeriod)),blackFont1));
					table50.addCell(new Paragraph("Loan Amount Requested before funeral cover", blackFont1));
					table50.addCell(new Paragraph((String.format("%.2f",(loanAmount))),blackFont1));
					table50.addCell(new Paragraph("Funeral Cover", blackFont1));
					table50.addCell(new Paragraph((String.format("%.2f",(funeralCover))),blackFont1));
					table50.addCell(new Paragraph("Initiation Fee", blackFont1));
					table50.addCell(new Paragraph(String.format("%.2f",(initiationfee)),blackFont1));
					table50.addCell(new Paragraph("Level Term Insurance", blackFont1));
					table50.addCell(new Paragraph(String.format("%.2f",(levelTermInsurance)),blackFont1));
					table50.addCell(new Paragraph("Total Loan Amount", blackFont1));
					table50.addCell(new Paragraph(String.format("%.2f",(loanAndCharges)),blackFont1));
					document.add(table50);
					
					
					Paragraph atmotizationHeading = new Paragraph(
							"STAFF LOAN ARMOTIZATION\n\n", blackFontListHeading);
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

						ftable2.addCell(new Paragraph(String.valueOf(x1 + 1),
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
					ftable1.addCell(new Paragraph(String.valueOf(x1), blackFont1));
					ftable1.addCell(new Paragraph("Loan Period (Y)", blackFont1));
					ftable1.addCell(new Paragraph(String.valueOf(x1 / 12),
							blackFont1));
					ftable1.addCell(new Paragraph("Actual # of Payments",
							blackFont1));
					ftable1.addCell(new Paragraph(String.valueOf(x1), blackFont1));
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
					
					
							
					///////////Staff Loan Particulars//////////
					
					document.newPage();
					document.add(img);
					

					Paragraph applicationLetterParagraph2 = new Paragraph(
							"1.	STAFF LOAN APPLICANT’S PARTICULARS\n",
							blackFontListHeading);
					document.add(applicationLetterParagraph2);
					document.add(new Paragraph("\n"));

					PdfPTable table = new PdfPTable(2);
					table.setWidthPercentage(100);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					table.setWidths(new int[] { 5, 8 });
					table.getDefaultCell().setBorder(Rectangle.BOX);

					table.addCell(new Paragraph("Name: ", blackFont1));
					table.addCell(new Paragraph((firstname + " " + surname),blackFont1));
					table.addCell(new Paragraph("Employment No: ", blackFont1));
					table.addCell(new Paragraph((employeeCode),blackFont1));
					table.addCell(new Paragraph("Date of Birth: ", blackFont1));
					table.addCell(new Paragraph((dateOfBirth), blackFont1));
					
					table.addCell(new Paragraph("Position Held: ", blackFont1));
					table.addCell(new Paragraph((employeePosition),blackFont1));
					table.addCell(new Paragraph("Basic Monthly Salary: ", blackFont1));
					table.addCell(new Paragraph(String.valueOf(basicSalary), blackFont1));
					table.addCell(new Paragraph("Marital Status: ", blackFont1));
					table.addCell(new Paragraph((maritalStatus),blackFont1));
					table.addCell(new Paragraph("Position Grade: ", blackFont1));
					table.addCell(new Paragraph((employeeGrade),blackFont1));
					
					table.addCell(new Paragraph("No. of Dependants: ", blackFont1));
					table.addCell(new Paragraph((String.valueOf(noOfDependants)), blackFont1));
					table.addCell(new Paragraph("Date Employed: ", blackFont1));
					table.addCell(new Paragraph((dateEngaged),blackFont1));
					table.addCell(new Paragraph("Tel / Cell: ", blackFont1));
					table.addCell(new Paragraph((telelephoneNo),blackFont1));

					document.add(table);

					Paragraph applicationLetterParagraph3 = new Paragraph(
							"2.	LOAN PURPOSE: "
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

					table61.addCell(new Paragraph(("3. Loan Type: " + loanType),blackFont1));
					table61.addCell(new Paragraph(("Loan Amount: " + loanAndCharges),blackFont1));
					table61.addCell(new Paragraph(("Date Loan is required: "
							+ dateloanRequired),blackFont1));
					document.add(table61);
					

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

					table1.addCell(new Paragraph(("Basic Salary:"),blackFont1));
					table1.addCell(new Paragraph((" E "
							+ String.valueOf(Float.valueOf(basicSalary))),blackFont1));

					table1.addCell(new Paragraph(("Allowances (exc. Overtime& leave all:"),blackFont1));
					table1.addCell(new Paragraph((" E "
							+ String.valueOf(Float.valueOf(allowances))),blackFont1));

					table1.addCell(new Paragraph(("Total Earnings:"),blackFont1));
					table1.addCell(new Paragraph((" E "
							+ String.valueOf(Float.valueOf(allowances)
									+ Float.valueOf(basicSalary))),blackFont1));

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

					table2.addCell(new Paragraph(("ITEM"),blackFont1));
					table2.addCell(new Paragraph(("DEDUCTION"),blackFont1));
					table2.addCell(new Paragraph(("BALANCE"),blackFont1));
					table2.addCell(new Paragraph(("(4) Housing Loan (Mortgage)"),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.valueOf(Float
									.valueOf(housingloanDeductions))),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(housingloanBalance))),blackFont1));

					table2.addCell(new Paragraph(("(5) Rural Housing Loan"),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(ruralHousingloanDeductions))),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(ruralHousingloanBalance))),blackFont1));

					table2.addCell(new Paragraph(("(6) Farm / Small Holder"),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(farm_smallHolderDeductions))),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(farm_smallHolderBalance))),blackFont1));

					table2.addCell(new Paragraph(("(7) Car Loan"),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(carloanDeductions))),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(carloanBalance))),blackFont1));

					table2.addCell(new Paragraph(("(8) Personal Loan (36 Months)"),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(personalloanDeductions))),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(personalloanBalance))),blackFont1));

					table2.addCell(new Paragraph(("(9) Educational Loan (12 Months)"),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(educationalloanDeductions))),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(educationalloanBalance))),blackFont1));

					table2.addCell(new Paragraph(("(11) City Council Rates"),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(cityCouncilRatesDeductions))),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(cityCouncilRatesBalance))),blackFont1));

					table2.addCell(new Paragraph(("(12) Insurances"),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(insurancesDeductions))),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(insurancesBalance))),blackFont1));

					table2.addCell(new Paragraph(("(13) Other Loans"),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(otherDeductions))),blackFont1));
					table2.addCell(new Paragraph((" E "
							+ String.format("%.2f",(otherBalance))),blackFont1));

					

					table2.addCell(new Paragraph(("(14) Total"),blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f",(totalDeductions))),blackFont1));
					table2.addCell(new Paragraph((" E " + String.format("%.2f",(totalBalances))),blackFont1));

					document.add(table2);
					

					PdfPTable table3 = new PdfPTable(2);
					table3.setWidthPercentage(100);
					table3.setHorizontalAlignment(Element.ALIGN_LEFT);
					table3.setWidths(new int[] { 8, 4 });
					table3.getDefaultCell().setBorder(Rectangle.BOX);

					table3.addCell(new Paragraph(("(15) Other deductions(excl. Leave allowance)"),blackFont1));
					table3.addCell(new Paragraph((" E "
							+ String.valueOf(otherDeductionsExcLeaveAllowance)),blackFont1));

					table3.addCell(new Paragraph(("(16) Target Savings:"),blackFont1));
					table3.addCell(new Paragraph((" E " + String.valueOf(targetSavings)),blackFont1));

					table3.addCell(new Paragraph(("(17) Statutory Deductions(Paye+ Snpf)"),blackFont1));
					table3.addCell(new Paragraph((" E " + String.valueOf(statutoryDeductions)),blackFont1));

					table3.addCell(new Paragraph(("(18) NET SALARY (3) -  (14,15,16, 17)"),blackFont1));
					table3.addCell(new Paragraph((" E " + String.format("%.2f",(netSalary))),blackFont1));

					document.add(table3);
					document.newPage();

					Paragraph applicationLetterParagraph9 = new Paragraph(
							"5.	AMOUNT REQUIRED AND REPAYMENT ARRANGEMENTS: ",
							blackFontListHeading);
					document.add(applicationLetterParagraph9);
					document.add(new Paragraph("\n"));

					PdfPTable table7 = new PdfPTable(4);
					table7.setWidthPercentage(100);
					table7.setHorizontalAlignment(Element.ALIGN_LEFT);
					table7.setWidths(new int[] { 5, 3, 6, 3 });
					table7.getDefaultCell().setBorder(Rectangle.BOX);

					table7.addCell(new Paragraph(("NEW LOAN: " + loanType),blackFont1));
					table7.addCell(new Paragraph(("INTEREST RATE:" + interestRate + "%"),blackFont1));
					table7.addCell(new Paragraph(("REPAYMENT PERIOD IN MONTHS: "
							+ loanPeriod),blackFont1));
					table7.addCell(new Paragraph(("INSTALMENT:" + " E " + String.format("%.2f",(totalRepayment))),blackFont1));

					table7.addCell(". ");
					table7.addCell(". ");
					table7.addCell(new Paragraph(("CUM. PERCENTAGE (14 +19) / 3:"),blackFont1));
					table7.addCell(new Paragraph(String.format("%.2f",(cummulativePercentageB))+"%",blackFont1));

					table7.addCell(". ");
					table7.addCell(". ");
					table7.addCell(new Paragraph(("19. NET PAY (18) – (19) :"),blackFont1));
					table7.addCell(new Paragraph((" E "
							+ String.format("%.2f",(netSalary - totalRepayment))),blackFont1));

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

							+ "\nSIGNATURE: ………………………………………………… "),blackFont1));

					table4.addCell(new Paragraph(("6.	Manager’s / Senior Manager’s / Supervisors comments and recommendations."
							+ "\n\nI confirm that his request is within the terms of the Staff Loans Policy currently in force."
							+ "\n" + "\n" + "\n"

							+ "\nSIGNATURE: ………………………………………………… "),blackFont1));

					table4.addCell(new Paragraph(("7.	EXECUTIVE HEAD OF DEPARTMENT" + "\n"
							+ "\n" + "\n"

							+ "\nSIGNATURE: ………………………………………………… "),blackFont1));

					table4.addCell(new Paragraph(("8. APPROVED  / DECLINED" + "\n" + "\n"
							+ "\n"

							+ "\nSIGNATURE: ………………………………………………… "),blackFont1));

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
					
					java.sql.Statement insertReportStatement = null;

					try {

					String insertIssueSql = "UPDATE [dbo].[staffLoan] SET "
							+ "supervisor = '" + supervisor + "',"
							+ "supervisorEmail = '" + supervisorEmail + "',"
							+ "iDNumber = '" + iDNumber + "'," + "cif = '"
							+ cif + "'," + "employeePosition = '"
							+ employeePosition + "'," + "employeeGrade = '"
							+ employeeGrade + "'," + "employeeDepartment = '"
							+ employeeDepartment + "'," + "hod = '" + hod
							+ "'," + "hodEmail = '" + hodEmail + "',"
							+ "branchAdress	= '" + branchAdress + "',"
							+ "telelephoneNo = '" + telelephoneNo + "',"
							+ "emailAddress = '" + emailAddress + "',"
							+ "loanAmountWords = '" + loanAmountWords + "',"
							+ "loanStatus = 'Pending Hod Comments',"
							+ "supervisorComment = '" + supervisorComment
							+ "'," + "supervisorCommentDate = '"
							+ supervisorCommentDate + "',"
							+ "[lastModifiedDate]  = '" + lastModifiedDate
							+ "'," + "[lastModifiedBy]  = '" + lastModifiedBy
							+ "'" + "Where [employeeLoanRef] = '"
							+ employeeLoanRef + "'";
					
					

					

						insertReportStatement = con.createStatement();
						insertReportStatement.executeUpdate(insertIssueSql);

						insertReportStatement.close();
						con.close();

						response.sendRedirect(request.getContextPath()
								+ "/StaffLoanStatus");

						// Recipient's email ID needs to be mentioned.
						String to = hodEmail;

						// Sender's email ID needs to be mentioned
						String from = "staffLoanApplication@swazibank.co.sz";

						

						// Get system properties
						Properties properties = System.getProperties();

						// Setup mail server
						properties.setProperty("mail.smtp.host", "mail.swazibank.co.sz");

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
							message.setSubject("New Staff Loan Approval Submitted by: "
									+ supervisor + " Requires your Attention");

							// Now set the actual message
							message.setText("Dear "
									+ hod
									+ "\n"
									+ "\n"
									+ "A  Staff Loan belonging to "
									+ firstname
									+ " "
									+ surname
									+ " with Reference: '"
									+ employeeLoanRef
									+ "' requires your immediate attention. "
									+ "\n"
									+ "Please Click on the link http://live-intranet:8090/EsdbIntranet/StaffLoanHodRequest for your comment."
									+ "\n\nYou can view the employee payslip here file://172.16.1.59//IntranetWarehouse//StaffLoanPayslips/ "
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
