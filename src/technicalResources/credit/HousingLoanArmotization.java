package technicalResources.credit;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/HousingLoanArmotization")
public class HousingLoanArmotization extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_Credit/healthLoanArmotization.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String error = null;
		int loanPeriod = 0;
		Date startDate2 = null;
		Calendar cal = null;

		double loanAmount = Float.valueOf(request.getParameter("loanAmount"));
		double rate = Double.valueOf(request.getParameter("rate"));
		double finalValue = Float.valueOf(request.getParameter("finalValue"));
		String startDate1 = request.getParameter("startDate");
		String endDate1 = request.getParameter("endDate");

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
				.withDayOfMonth(1)) ;

		if (startDate1.equals(endDate1)) {

			error = "Start date and End date should be diffeent";

			request.setAttribute("error", error);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_Credit/healthLoanArmotization.jsp");
			view.forward(request, response);

		} else if (loanAmount < 1) {

			error = "Please check your loan amount";

			request.setAttribute("error", error);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_Credit/healthLoanArmotization.jsp");
			view.forward(request, response);

		} else if (rate == 0) {
			error = "Interest rate can not be 0% ";

			request.setAttribute("error", error);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_Credit/healthLoanArmotization.jsp");
			view.forward(request, response);
		}else if (loanPeriod <= 0) {
			error = "End date can not be before Start date";

			request.setAttribute("error", error);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_Credit/healthLoanArmotization.jsp");
			view.forward(request, response);
		} else {

			double mortgageProtectionPolicy = (double) (((loanAmount / 1000) * 10.94) / 12);
			double houseOwnersCoverage = (double) ((loanAmount * 0.00275) / 12);
			double r = (rate / 100) / 12;
			double presentValue = loanAmount;
			int paymentNo;
			Date paymentDate;
			double beginingBalance = 0;
			double scheduledPayment = 0;
			double totalEarlyPayments = 0;
			double extraPayment = Double.valueOf(request
					.getParameter("optExtPmt"));
			double totalPayment = 0;
			double principal = 0;
			double interest = 0;
			double endingBalance = 0;

			double totalInterest = 0;

			totalInterest = interest * loanPeriod; // /// TO BE CALCULATED IN
													// THE
													// FORLOOP AS AN ADDIDION

			double totalRepayment = -(FinanceLib.pmt(r, loanPeriod, loanAmount,
					finalValue, false));
			System.out.println("totalRepayment is: " + totalRepayment);

			Font blackFont = FontFactory.getFont(FontFactory.HELVETICA, 7,
					Font.NORMAL);
			Font blackFont1 = FontFactory.getFont(FontFactory.HELVETICA, 8,
					Font.NORMAL);
				

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
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
					ftable2.addCell(new Paragraph(formatter.format(principal),
							blackFont));
					ftable2.addCell(new Paragraph(formatter.format(interest),
							blackFont));
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
				ftable1.addCell(new Paragraph("Scheduled Payment", blackFont1));
				ftable1.addCell(new Paragraph(formatter.format(totalRepayment),
						blackFont1));
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
				ftable1.addCell(new Paragraph("Payments per year", blackFont1));
				ftable1.addCell(new Paragraph("12", blackFont1));
				ftable1.addCell(new Paragraph("Total Early Payments",
						blackFont1));
				ftable1.addCell(new Paragraph(formatter
						.format(totalEarlyPayments), blackFont1));

				ftable1.addCell(new Paragraph("Start Date of Loan", blackFont1));
				ftable1.addCell(new Paragraph(startDate1, blackFont1));
				ftable1.addCell(new Paragraph("Total Interest", blackFont1));
				ftable1.addCell(new Paragraph(formatter.format(totalInterest),
						blackFont1));

				ftable1.addCell(new Paragraph("Optional Extra Payments",
						blackFont1));
				ftable1.addCell(new Paragraph(formatter.format(extraPayment),
						blackFont1));
				ftable1.addCell(new Paragraph("Mortgage Protection Policy",
						blackFont1));
				ftable1.addCell(new Paragraph(formatter
						.format(mortgageProtectionPolicy), blackFont1));

				ftable1.addCell("");

				ftable1.addCell("");
				ftable1.addCell(new Paragraph("House Owners", blackFont1));
				ftable1.addCell(new Paragraph(formatter
						.format(houseOwnersCoverage), blackFont1));

				ftable1.addCell(new Paragraph("Lender Name:", blackFont1));
				ftable1.addCell("");
				ftable1.addCell(new Paragraph("Total Repayment", blackFont1));
				ftable1.addCell(new Paragraph(
						formatter.format((houseOwnersCoverage
								+ mortgageProtectionPolicy + totalRepayment)),
						blackFont1));

				document.add(ftable1);

				document.add(new Paragraph("\n"));

				document.add(ftable2);

			} catch (Exception e) {
				e.printStackTrace();
			}
			document.close();
		}
	}
}
