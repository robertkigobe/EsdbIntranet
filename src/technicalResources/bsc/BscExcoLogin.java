package technicalResources.bsc;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BscExcoLogin")
public class BscExcoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscExcoLogin.jsp");

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String accessCode = request.getParameter("accessCode");

		if (accessCode.equals("12345678=EXCO2018")) {

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscExcoHome.jsp");

			view.forward(request, response);

		} else {
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/utilities/badPassword.jsp");
			view.forward(request, response);
		}

	}

}
