package technicalResources.IT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

/**
 * Servlet implementation class ITDashboards
 */
@WebServlet("/ITPostillionMonthlyDashboards")
public class ITPostillionMonthlyDashboards extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<ITDashboardBean> manziniData = new ArrayList<ITDashboardBean>();
		manziniData.clear();
		//Calendar cal = Calendar.getInstance();
		
		JSONObject obj = new JSONObject();
		
		manziniData.add(new ITDashboardBean(2018, 6, 1, 3002240)); 
		manziniData.add(new ITDashboardBean(2018, 6, 8,  2816366)); 
		manziniData.add(new ITDashboardBean(2018, 6, 15,  10847295));  
		manziniData.add(new ITDashboardBean(2018, 6, 22,  8492631)); 
		manziniData.add(new ITDashboardBean(2018, 6, 29,  4864595)); 
		manziniData.add(new ITDashboardBean(2018, 7, 5,  4173799)); 
		manziniData.add(new ITDashboardBean(2018, 7, 12,  6812058)); 
		manziniData.add(new ITDashboardBean(2018, 7, 19,  11853618)); 
		manziniData.add(new ITDashboardBean(2018, 7, 26,  6364350)); 
		manziniData.add(new ITDashboardBean(2018, 8, 2,  3098576)); 
		manziniData.add(new ITDashboardBean(2018, 8, 9,  3260840)); 
		manziniData.add(new ITDashboardBean(2018, 8, 16,  10493355)); 
		manziniData.add(new ITDashboardBean(2018, 8, 23,  9739270)); 
		manziniData.add(new ITDashboardBean(2018, 8, 30,  4567939)); 
		manziniData.add(new ITDashboardBean(2018, 9, 7,  3012765)); 
		manziniData.add(new ITDashboardBean(2018, 9, 14,  9352610)); 
		manziniData.add(new ITDashboardBean(2018, 9, 21,  9429921)); 
		manziniData.add(new ITDashboardBean(2018, 9, 28,  4953820)); 
		
		obj.put("manzini", manziniData);
		
		
		//JSONObject.stringfy(obj);
		//response.setContentType();
		String jsonString = obj.toJSONString();
		System.out.println(manziniData.toString());
		request.setAttribute("jsonString", jsonString);
       

		
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_IT/iTPostillionMonthlyDashboards.jsp");
		view.forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
