package technicalResources.IT;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ITDashboards
 */
@WebServlet("/ITDashboards")
public class ITDashboards extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Gson gsonObj1 = new Gson();
		Map<String, Integer> map1 = new HashMap<String, Integer>();

		
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_IT/iTDashboards.jsp");
		view.forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
