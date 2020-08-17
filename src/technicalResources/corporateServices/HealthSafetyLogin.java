package technicalResources.corporateServices;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/HealthSafetyLogin")
public class HealthSafetyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_corporateServices/healthSafetyLogin.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = request.getParameter("uName");
		String password = request.getParameter("password");

		if ((userName.matches("HS-Test")) && (password.matches("12345678=HS"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Account Management"))
				&& (password.matches("AccMan1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Administration"))
				&& (password.matches("Admin1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Agribusiness"))
				&& (password.matches("Agri1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Branch Network"))
				&& (password.matches("Bnet1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Business Intelligence"))
				&& (password.matches("Busi1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Call Center"))
				&& (password.matches("Callc1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Collections"))
				&& (password.matches("Coll1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Corporate Business"))
				&& (password.matches("Corp1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Credit")) && (password.matches("Credi1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Digital Banking"))
				&& (password.matches("Digb1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Electronic Banking"))
				&& (password.matches("elect1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Ezulwini Gables"))
				&& (password.matches("Ezug1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Finance")) && (password.matches("Fin1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Housing")) && (password.matches("hous123"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Human Resources"))
				&& (password.matches("Humr1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Infrastructure"))
				&& (password.matches("Infra1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Internal Audit"))
				&& (password.matches("Inter1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Insurance Business"))
				&& (password.matches("Insb123"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Legal")) && (password.matches("Lega1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Manzini")) && (password.matches("Manz1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Manzini Cash Centre"))
				&& (password.matches("Macc1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Matata")) && (password.matches("Mata123"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Matsapha")) && (password.matches("Mats1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Mbabane")) && (password.matches("Mbab1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Motor Vehicle ( Auto-easy)"))
				&& (password.matches("Moto1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Nhlangano"))
				&& (password.matches("Nhla1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("OPC Manzini"))
				&& (password.matches("Opcm1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Operations"))
				&& (password.matches("Oper1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Piggs Peak"))
				&& (password.matches("Pigg1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Projects and Governance"))
				&& (password.matches("Proj1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Reviews")) && (password.matches("Revi1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Risk and Compliance"))
				&& (password.matches("Rico1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Sales and Marketing"))
				&& (password.matches("Sama1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Securities"))
				&& (password.matches("Secu1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Siphofaneni"))
				&& (password.matches("Sipho1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Simunye")) && (password.matches("Simu1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Siteki")) && (password.matches("Site1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("SMME")) && (password.matches("Smme1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Strategy")) && (password.matches("Stat1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Systems")) && (password.matches("Syst1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}
		else if ((userName.matches("Treasury")) && (password.matches("Trea1234"))) {
			response.sendRedirect(request.getContextPath()
					+ "/HealthSafetyMain");
		}

		else if ((userName.matches("Admin"))
				&& (password.matches("admin=1234"))) {

			response.sendRedirect(request.getContextPath()
					+ "/HealthAndSafetyAdminMain");

		} else {
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/issueTrackingFaces/badPassword.jsp");
			view.forward(request, response);
		}
	}

}
