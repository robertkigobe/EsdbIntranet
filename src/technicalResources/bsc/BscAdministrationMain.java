package technicalResources.bsc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class HealthSafetyMain
 */
@WebServlet("/BscAdministrationMain")
public class BscAdministrationMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscAdministrationLogin.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String password = request.getParameter("password");

		if (password.equals("12345678=ADBSC")) {
			response.sendRedirect(request.getContextPath() + "/BscSubmissions");
		} else {
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/utilities/badPassword.jsp");
			view.forward(request, response);
		}
	}

}
