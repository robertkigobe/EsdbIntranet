package technicalResources.electronicBanking;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/CardproductionNewCard")
public class CardproductionNewCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		String branch = request.getParameter("branch");
		String password = request.getParameter("password");

		if (branch.equals("EZULWINI") && password.equals("12345678=EZCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		} else if (branch.equals("SWAZIBANK HEAD OFFICE")
				&& password.equals("12345678=SHOCP")) {

			response.sendRedirect(request.getContextPath()+ "/CardProductionFiles");

		}

		else if (branch.equals("MBABANE") && password.equals("12345678=MBNCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("PIGGS PEAK")
				&& password.equals("12345678=PPKCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MANZINI") && password.equals("12345678=MZNCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MATSAPHA") && password.equals("12345678=MTSCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("NHLANGANO")
				&& password.equals("12345678=NHLCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MANZINI CASH CENTRE")
				&& password.equals("12345678=MZCCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MANZINI HUB")
				&& password.equals("12345678=MZHCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("SIPHOFANENI")
				&& password.equals("12345678=SPFCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("OPC") && password.equals("12345678=OPCCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MBABANE COMMERCIAL")
				&& password.equals("12345678=MBCCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MATATA") && password.equals("12345678=MTTCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("SIMUNYE") && password.equals("12345678=SMYCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("SITEKI") && password.equals("12345678=STKCP")) {

			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			view.forward(request, response);

		} else {
			
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/utilities/badPassword.jsp");
			view.forward(request, response);
		}

	}

}
