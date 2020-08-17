package technicalResources.bsc;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class HealthSafetyMain
 */
@WebServlet("/BscReportsMain")
public class BscReportsMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	public static String filename;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String subDepartments = request.getParameter("subDepartment");
		String accessCode = request.getParameter("accessCode");

		if (subDepartments.equals("All")
				&& accessCode.equals("12345678=CS")) {

			response.sendRedirect(request.getContextPath()
					+ "/BscReportsCorportateServices");

		}
		else if (subDepartments.equals("Account Management")
				&& accessCode.equals("12345678=AMSD")) {

			String subDepartment = "Account Management";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Administration")
				&& accessCode.equals("12345678=ADSD")) {

			String subDepartment = "Administration";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		else if (subDepartments.equals("Agribusiness")
				&& accessCode.equals("12345678=AGBSD")) {

			String subDepartment = "Agribusiness";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		else if (subDepartments.equals("Business Intelligence")
				&& accessCode.equals("12345678=BISD")) {

			String subDepartment = "Business Intelligence";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);
		
		}
		else if (subDepartments.equals("Branch Network")
				&& accessCode.equals("12345678=BNCSD")) {

			String subDepartment = "Branch Network";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		 else if (subDepartments.equals("Call Center")
				&& accessCode.equals("12345678=CCSD")) {

			String subDepartment = "Call Center";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		 else if (subDepartments.equals("Collections")
					&& accessCode.equals("12345678=COLSD")) {

				String subDepartment = "Collections";
				request.setAttribute("subDepartment", subDepartment);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/BscReportsSubDepartments");
				dispatcher.forward(request, response);

			}
		
		
		else if (subDepartments.equals("Corporate Business")
				&& accessCode.equals("12345678=CBSD")) {

			String subDepartment = "Corporate Business";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Credit")
				&& accessCode.equals("12345678=CRSD")) {

			String subDepartment = "Credit";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		else if (subDepartments.equals("Electronic Banking")
				&& accessCode.equals("12345678=EBSD")) {

			String subDepartment = "Electronic Banking";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Ezulwini Gables")
				&& accessCode.equals("12345678=EZLSD")) {

			String subDepartment = "Ezulwini Gables";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		else if (subDepartments.equals("Finance")
				&& accessCode.equals("12345678=FNSD")) {

			String subDepartment = "Finance";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Infrastructure")
				&& accessCode.equals("12345678=INFSD")) {

			String subDepartment = "Infrastructure";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Internal Audit")
				&& accessCode.equals("12345678=IASD")) {

			String subDepartment = "Internal Audit";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}

		else if (subDepartments.equals("Insurance Business")
				&& accessCode.equals("12345678=IBSD")) {

			String subDepartment = "Insurance Business";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Legal")
				&& accessCode.equals("12345678=LEGSD")) {

			String subDepartment = "Legal";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Nhlangano")
				&& accessCode.equals("12345678=NHLSD")) {

			String subDepartment = "Nhlangano";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("OPC Manzini")
				&& accessCode.equals("12345678=OPCSD")) {

			String subDepartment = "OPC Manzini";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		
		
		else if (subDepartments.equals("Manzini Cash Centre")
				&& accessCode.equals("12345678=MZCSD")) {

			String subDepartment = "Manzini Cash Centre";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		
		
		else if (subDepartments.equals("Human Resources")
				&& accessCode.equals("12345678=HRSD")) {

			String subDepartment = "Human Resources";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}

		else if (subDepartments.equals("Housing")
				&& accessCode.equals("12345678=HSSD")) {

			String subDepartment = "Housing";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		else if (subDepartments.equals("Motor Vehicle ( Auto-easy)")
				&& accessCode.equals("12345678=MVSD")) {

			String subDepartment = "Motor Vehicle ( Auto-easy)";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}else if (subDepartments.equals("Matsapha")
				&& accessCode.equals("12345678=MTSSD")) {

			String subDepartment = "Matsapha";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}else if (subDepartments.equals("Manzini")
				&& accessCode.equals("12345678=MZNSD")) {

			String subDepartment = "Manzini";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Manzini Cash Centre")
				&& accessCode.equals("12345678=MZCSSD")) {

			String subDepartment = "Manzini Cash Centre";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Matata")
				&& accessCode.equals("12345678=MTTSD")) {

			String subDepartment = "Matata";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Mbabane")
				&& accessCode.equals("12345678=MBNSD")) {

			String subDepartment = "Mbabane";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Operations")
				&& accessCode.equals("12345678=OPSSD")) {

			String subDepartment = "Operations";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Piggs Peak")
				&& accessCode.equals("12345678=PPKSD")) {

			String subDepartment = "Piggs Peak";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		
		else if (subDepartments.equals("Reviews")
				&& accessCode.equals("12345678=RVSD")) {

			String subDepartment = "Reviews";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Risk and Compliance")
				&& accessCode.equals("12345678=RNCSD")) {

			String subDepartment = "Risk and Compliance";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Sales and Marketing")
				&& accessCode.equals("12345678=SNMSD")) {

			String subDepartment = "Sales and Marketing";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Securities")
				&& accessCode.equals("12345678=SCSD")) {

			String subDepartment = "Securities";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Simunye")
				&& accessCode.equals("12345678=SMYSD")) {

			String subDepartment = "Simunye";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		
		
		else if (subDepartments.equals("Siphofaneni")
				&& accessCode.equals("12345678=SPNSD")) {

			String subDepartment = "Siphofaneni";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Systems")
				&& accessCode.equals("12345678=SYSSD")) {

			String subDepartment = "Systems";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}
		
		else if (subDepartments.equals("Siteki")
				&& accessCode.equals("12345678=STKSD")) {

			String subDepartment = "Siteki";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}else if (subDepartments.equals("Treasury")
				&& accessCode.equals("12345678=TRSD")) {

			String subDepartment = "Treasury";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		} 
		

		else if (subDepartments.equals("SMME")
				&& accessCode.equals("12345678=SMMESD")) {

			String subDepartment = "SMME";
			request.setAttribute("subDepartment", subDepartment);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/BscReportsSubDepartments");
			dispatcher.forward(request, response);

		}  else {
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/utilities/badPassword.jsp");
			view.forward(request, response);
		}

	}
}
