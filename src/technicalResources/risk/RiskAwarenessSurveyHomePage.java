package technicalResources.risk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RiskAndComplianceSurveyHomePage
 */
@WebServlet("/RiskAwarenessSurveyHomePage")
public class RiskAwarenessSurveyHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/technicalResources_risk/riskAndComplianceSurveyHomePage.jsp");
		view.forward(request, response);
		
	}



}
