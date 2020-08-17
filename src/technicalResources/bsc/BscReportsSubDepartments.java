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
@WebServlet("/BscReportsSubDepartments")
public class BscReportsSubDepartments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	public static String filename;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String subDepartment = (String) request.getAttribute("subDepartment");

		
		Statement selectStatement = null;
		ResultSet results = null;
		Statement selectStatement2 = null;
		Statement selectStatement3 = null;
		Statement selectStatement4 = null;
		ResultSet results2 = null;
		ResultSet results3 = null;
		ResultSet results4 = null;
		String bscPeriod = null;
		String position = null;
		String employee = null;
		String perspective = null;
		String objective = null;
		String period = null;
		String reportingFrequencies = null;
		String measure = null;
		float base = 0;
		float stretch = 0;
		float actual = 0;
		float archievementRatio = 0;
		float totalScore = 0;
		float averageScore = 0;
		String status = null;
		ArrayList<BscReportsBean> departmentReport = new ArrayList<BscReportsBean>();

		ArrayList<String> positions = new ArrayList<String>();
		ArrayList<String> bscPeriods = new ArrayList<String>();
		ArrayList<String> employees = new ArrayList<String>();

		departmentReport.clear();
		
		bscPeriods.clear();
		bscPeriods.add("Choose Period");
		

		positions.clear();
		positions.add("Choose Position");

		employees.clear();
		employees.add("Choose Employee");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		
		con = connectionHelper.connect();
		
		
		if (con != null) {
			
			String sqlbscPeriod = "SELECT distinct([bscPeriod])  FROM [dbo].[bscSDSBScores] where subDepartment = '"+ subDepartment + "'";
			try {
				selectStatement4 = con.createStatement();
				results4 = selectStatement4.executeQuery(sqlbscPeriod);

				while (results4.next()) {

					bscPeriod = results4.getString("bscPeriod");
					bscPeriods.add(bscPeriod);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			String sqlPosition = "SELECT distinct([position])  FROM [dbo].[bscSDSBScores]where subDepartment = '"
					+ subDepartment + "' order by position";
			try {
				selectStatement2 = con.createStatement();
				results2 = selectStatement2.executeQuery(sqlPosition);

				while (results2.next()) {

					position = results2.getString("position");
					positions.add(position);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			String sqlEmployeeName = "SELECT distinct([bscEmployeeName])  FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores]where subDepartment = '"
					+ subDepartment + "' order by [bscEmployeeName]";

			try {
				selectStatement3 = con.createStatement();
				results3 = selectStatement3.executeQuery(sqlEmployeeName);

				while (results3.next()) {

					employee = results3.getString("bscEmployeeName");
					employees.add(employee);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' "
					+ ",avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] where  [reportingFrequencies] = 'Monthly' and [subDepartment] = '"
					+ subDepartment
					+ "' Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

			
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					
					perspective = results.getString("perspective");
					objective = results.getString("objective");
					period = results.getString("period");
					reportingFrequencies = results
							.getString("reportingFrequencies");
					measure = results.getString("measure");
					base = Float.valueOf(results.getString("base"));
					stretch = Float.valueOf(results.getString("stretch"));
					actual = Float.valueOf(results.getString("actual"));
					
					

					if ((stretch - base) != 0) {
						archievementRatio = ((actual - base) / (stretch - base)) * 100;
					} else {
						archievementRatio = 0;
					}

					if (archievementRatio >= 100) {
						status = "Diamond";

					} else if ((archievementRatio < 100)
							&& (archievementRatio >= 70)) {
						status = "Platinum";

					} else if ((archievementRatio < 70)
							&& (archievementRatio >= 50)) {
						status = "Gold";

					} else if ((archievementRatio < 50)
							&& (archievementRatio >= 20)) {
						status = "Bronze";

					} else if (archievementRatio < 20) {
						status = "Wooden Spoon";
						
						
					}
					
					

					totalScore += archievementRatio;
					

					departmentReport.add(new BscReportsBean(perspective,
							objective, period, reportingFrequencies, measure,
							base, stretch, actual, archievementRatio,
							totalScore, averageScore, status));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			

		}

		averageScore = totalScore / departmentReport.size();
		
		request.setAttribute("subDepartment", subDepartment);
		request.setAttribute("bscPeriods", bscPeriods);
		request.setAttribute("positions", positions);
		request.setAttribute("employees", employees);
		request.setAttribute("averageScore", averageScore);
		request.setAttribute("departmentReport", departmentReport);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscReportsSubDepartments.jsp");
		view.forward(request, response);
		

		

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
