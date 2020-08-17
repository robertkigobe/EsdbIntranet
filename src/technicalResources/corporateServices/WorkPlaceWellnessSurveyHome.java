package technicalResources.corporateServices;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorkPlaceWellnessSurveyHome
 */
@WebServlet("/WorkPlaceWellnessSurveyHome")
public class WorkPlaceWellnessSurveyHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_corporateServices/workPlaceWellnessSurveyHome.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_corporateServices/workPlaceWellnessSurveySuccess.jsp");
		view.forward(request, response);
		
		
	}

}