package technicalResources.bsc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;


@WebServlet("/BscExcoTargets")
public class BscExcoTargets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String objectivePeriod = null;
		String department = null;
		String position= null;
		String rolePlayed = null;
		String perspective = null;
		String objective = null;
		String period = null;
		String reportingFrequency = null;
		String measure = null;
		float base = 0;
		float stretch = 0;

		

		Statement selectStatement = null;
		ResultSet results = null;

		ArrayList<BscTargetsBeans> targets = new ArrayList<BscTargetsBeans>();

		targets.clear();
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [objectivePeriod]  ,[department]   ,[position]  ,[rolePlayed]   ,[perspective]  ,[objective]   ,[objectiveDescription]   ,[period]   ,[reportingFrequency]  ,[measure]   ,[description]  ,[base]   ,[stretch]  FROM [SwaziBankIntranet2016].[dbo].[bscExcoMetrics]  order by   CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes'  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END, measure,position";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					objectivePeriod = results.getString("objectivePeriod");
					department = results.getString("department");
					position = results.getString("position");
					rolePlayed = results.getString("rolePlayed");
					perspective = results.getString("perspective");
					objective = results.getString("objective");
					period = results.getString("period");
					reportingFrequency = results
							.getString("reportingFrequency");
					measure = results.getString("measure");
					base = results.getFloat("base");
					stretch = results.getFloat("stretch");

					targets.add(new BscTargetsBeans(objectivePeriod,
							department, position, rolePlayed, perspective,
							objective, period, reportingFrequency, measure,
							base, stretch));
				}
				request.setAttribute("objectivePeriod", objectivePeriod);
				
				request.setAttribute("targets", targets);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscSetExcoTargets.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out
						.println("Cannot connect to activity database here");
			}

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
