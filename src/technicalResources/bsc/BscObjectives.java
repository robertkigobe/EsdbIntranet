package technicalResources.bsc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import util.ConnectionHelper;



/**
 * Servlet implementation class HealthSafetyMain
 */
@WebServlet("/BscObjectives")
public class BscObjectives extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	public static String filename;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ArrayList<BscObjectivesBean> objectiveList = new ArrayList<BscObjectivesBean>();

		objectiveList.clear();
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT Distinct[Objective],[objectiveDescription] FROM [dbo].[bscMetrics]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					
					String objective = results.getString("Objective");
					
					String objectiveDesciption = results.getString("ObjectiveDescription");
						
					

					objectiveList.add(new BscObjectivesBean( objective,objectiveDesciption));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		
		}
		
		request.setAttribute("objectiveList", objectiveList);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscObjectives.jsp");
		view.forward(request, response);
		
	
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
