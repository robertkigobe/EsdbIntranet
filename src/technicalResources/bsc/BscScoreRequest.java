package technicalResources.bsc;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BscScoreRequest")
public class BscScoreRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscScoreRequest.jsp");
		view.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String scoreRequest = request.getParameter("scoreRequest");

		if (scoreRequest.equals("Choose Score Type")) {

			response.sendRedirect(request.getContextPath() + "/BscScoreRequest");
		} else if (scoreRequest.equals("Monthly 2018-2019")) {

			response.sendRedirect(request.getContextPath()
					+ "/BscScoreRequestMonthly");
			
		} else if (scoreRequest.equals("Quarterly 2018-2019")) {

			response.sendRedirect(request.getContextPath()
					+ "/BscScoreRequestQuarterly");
		} else if (scoreRequest.equals("Annual 2018-2019")) {
			response.sendRedirect(request.getContextPath()
					+ "/BscScoreRequestAnnual");
		}
		else
		{response.sendRedirect(request.getContextPath()
				+ "/BscTargetRequest");
		}

	}
}
