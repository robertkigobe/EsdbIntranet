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
@WebServlet("/BscMeasures")
public class BscMeasures extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	public static String filename;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		String position = request.getParameter("position");
		String measure = null;
		String measureDesciption = null;
		String perspective = null;

		ArrayList<BscMeasureBean> measureList = new ArrayList<BscMeasureBean>();

		measureList.clear();
		
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [id], [position],[measure],[description], [perspective]  FROM [dbo].[bscMetrics] where position = '"
					+ position + " ' Order By  [Position]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					position = results.getString("position");
					measure = results.getString("measure");
					measureDesciption = results.getString("description");
					perspective = results.getString("perspective");

					measureList.add(new BscMeasureBean(position, measure,
							measureDesciption, perspective));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}
		request.setAttribute("position", position);
		request.setAttribute("measureList", measureList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscMeasures.jsp");
		view.forward(request, response);

		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
