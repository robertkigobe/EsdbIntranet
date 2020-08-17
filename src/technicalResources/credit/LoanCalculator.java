package technicalResources.credit;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoanCalculator
 */
@WebServlet("/LoanCalculator")
public class LoanCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_Credit/loanCalulator.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		////////////////////////////////loan calculator///////////////////////
		
		String birthday = request.getParameter("birthday");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		float loanAmount = Float.valueOf(request.getParameter("loanAmount"));
		float funeralCover = Float
				.valueOf(request.getParameter("funeralCover"));

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		int loanPeriod = (int) ChronoUnit.MONTHS.between(
				LocalDate.parse(startDate).withDayOfMonth(1),
				LocalDate.parse(endDate).withDayOfMonth(1));
		int customerAge = (int) ChronoUnit.YEARS.between(
				LocalDate.parse(birthday).withDayOfMonth(1),
				LocalDate.parse(date.toString()).withDayOfMonth(1));

		double x = 0;

		double singlePremium = 0;
		double levelTermInsurance = 0;
		double initiationfee = 0;
		double loanAndCharges = 0;
		double remittedInsurance = 0;

		if (customerAge <= 29) {
			if (loanPeriod < 13) {
				x = 6.35;
			} else if (loanPeriod < 25){x = 12.0;}
			else if (loanPeriod < 37){x = 17.4;}
			else if (loanPeriod < 49){x = 22.75;}
			else if (loanPeriod < 61){x = 27.8;}
			
		} else if (customerAge <= 39) {
			if (loanPeriod < 13) {x = 10.5;} 
			else if (loanPeriod < 25){x = 19.50;}
			else if (loanPeriod < 37){x = 27.65;}
			else if (loanPeriod < 49){x = 35.1;}
			else if (loanPeriod < 61){x = 42.1;}
			
		}
		
		else if (customerAge <= 49) {
			if (loanPeriod < 13) {x = 8.55;} 
			else if (loanPeriod < 25){x = 16.85;}
			else if (loanPeriod < 37){x = 25.4;}
			else if (loanPeriod < 49){x = 32.0;}
			else if (loanPeriod < 61){x = 37.75;}
			
		}
		
		else if (customerAge <= 59) {
			if (loanPeriod < 13) {x = 13.45;} 
			else if (loanPeriod < 25){x = 25.5;}
			else if (loanPeriod < 37){x = 37.2;}
			else if (loanPeriod < 49){x = 48.3;}
			else if (loanPeriod < 61){x = 62.0;}
			
		}
		

		
		else if (customerAge >= 60) {
			if (loanPeriod < 13) {x = 21.9;} 
			else if (loanPeriod < 25){x = 43.45;}
			else if (loanPeriod < 37){x = 66.3;}
			else if (loanPeriod < 49){x = 90.75;}
			else if (loanPeriod < 61){x = 115.45;}
			
		}


		singlePremium = 6.91 * loanPeriod;
		levelTermInsurance = (x * loanAmount / 1000) + singlePremium;
		
		loanAndCharges = levelTermInsurance + initiationfee + loanAmount;
		remittedInsurance = (x * loanAndCharges / 1000) + singlePremium;
		
////////////////////////////////loan calculator///////////////////////

		System.out.println(remittedInsurance + " " + loanAndCharges + " " + loanAmount + " "
				+ funeralCover + " " + loanPeriod + " " + customerAge + " "
				+ singlePremium + " " + levelTermInsurance);

	}
	
	

}
