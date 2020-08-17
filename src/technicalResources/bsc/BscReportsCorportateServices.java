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
@WebServlet("/BscReportsCorportateServices")
public class BscReportsCorportateServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	public static String filename;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getParameter("departmentAccess");
		request.getParameter("accessCode");
		Statement selectStatement = null;
		ResultSet results = null;
		Statement selectStatement1 = null;
		Statement selectStatement2 = null;
		Statement selectStatement3 = null;
		Statement selectStatement4 = null;
		Statement selectStatement5 = null;

		ResultSet results1 = null;
		ResultSet results2 = null;
		ResultSet results3 = null;
		ResultSet results4 = null;
		ResultSet results5 = null;

		String bscPeriod = "Choose Period";
		String department = null;
		String position = null;
		String employee = null;
		String perspective = null;
		String objective = null;
		String objective1 = null;
		String period = null;
		String reportingFrequencies = null;
		String measure = null;
		String measure1 = null;
		float base = 0;
		float stretch = 0;
		float actual = 0;
		float archievementRatio = 0;
		float totalScore = 0;
		float averageScore = 0;
		String status = null;
		ArrayList<BscReportsBean> departmentReport = new ArrayList<BscReportsBean>();

		ArrayList<String> departments = new ArrayList<String>();
		ArrayList<String> positions = new ArrayList<String>();
		ArrayList<String> objectives = new ArrayList<String>();
		ArrayList<String> measures = new ArrayList<String>();
		ArrayList<String> employees = new ArrayList<String>();

		departmentReport.clear();
		departments.clear();
		departments.add("Choose Department");
		positions.clear();
		positions.add("Choose Position");
		objectives.clear();
		objectives.add("Choose Objective");
		measures.clear();
		measures.add("Choose Measure");
		employees.clear();
		employees.add("Choose Employee");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

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

					if (archievementRatio > 100) {
						status = "Diamond";
					} else if ((archievementRatio < 100)
							&& (archievementRatio > 100)) {
						status = "Platinum";
					} else if ((archievementRatio < 70)
							&& (archievementRatio > 50)) {
						status = "Gold";
					} else if ((archievementRatio < 50)
							&& (archievementRatio > 20)) {
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

			String sqldepartment = "SELECT distinct(department) FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by department";

			try {
				selectStatement1 = con.createStatement();
				results1 = selectStatement1.executeQuery(sqldepartment);

				while (results1.next()) {

					department = results1.getString("department");
					departments.add(department);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			String sqlPosition = "SELECT distinct([position])  FROM [dbo].[bscSDSBScores] order by position";
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

			String sqlEmployeeName = "SELECT distinct([bscEmployeeName])  FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by [bscEmployeeName]";

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

			String sqlobjective = "SELECT distinct([objective])  FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by [objective]";

			try {
				selectStatement4 = con.createStatement();
				results4 = selectStatement4.executeQuery(sqlobjective);

				while (results4.next()) {

					objective1 = results4.getString("objective");
					objectives.add(objective1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			String sqlmeasure = "SELECT distinct([measure])  FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by [measure]";

			try {
				selectStatement5 = con.createStatement();
				results5 = selectStatement5.executeQuery(sqlmeasure);

				while (results5.next()) {

					measure1 = results5.getString("measure");
					measures.add(measure1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		averageScore = totalScore / departmentReport.size();

		request.setAttribute("bscPeriod", bscPeriod);
		request.setAttribute("positions", positions);
		request.setAttribute("measures", measures);
		request.setAttribute("objectives", objectives);
		request.setAttribute("departments", departments);
		request.setAttribute("objectives", objectives);
		request.setAttribute("employees", employees);
		request.setAttribute("averageScore", averageScore);
		request.setAttribute("departmentReport", departmentReport);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscReports.jsp");
		view.forward(request, response);

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Statement selectStatement = null;
		ResultSet results = null;

		String bscPeriod = request.getParameter("bscPeriod");
		String positions = request.getParameter("position");
		String department = request.getParameter("department");
		String perspective1 = request.getParameter("perspective1");
		String employee = request.getParameter("bscEmployeeName");
		String subDepartment = request.getParameter("subDepartment");
		String objective1 = request.getParameter("objective1");
		String bscEmployeeName = request.getParameter("bscEmployeeName");
		String measure1 = request.getParameter("measure1");
		
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

		departmentReport.clear();
		

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			if ((!bscPeriod.equals("Choose Period"))
					&& (positions.equals("Choose Position"))
					&& (department.equals("Choose Department"))
					&& (perspective1.equals("Choose Perspective"))
					&& (employee.equals("Choose Employee"))
					&& (subDepartment.equals("Choose Sub-Department"))
					&& (objective1.equals("Choose Objective"))
					&& (bscEmployeeName.equals("Choose Employee"))
					&& (measure1.equals("Choose Measure"))

			) {
				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscPeriod] =  '" + bscPeriod + "' and [reportingFrequencies] = 'Monthly'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

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

						if (archievementRatio > 100) {
							status = "Diamond";
						} else if ((archievementRatio < 100)
								&& (archievementRatio > 100)) {
							status = "Platinum";
						} else if ((archievementRatio < 70)
								&& (archievementRatio > 50)) {
							status = "Gold";
						} else if ((archievementRatio < 50)
								&& (archievementRatio > 20)) {
							status = "Bronze";
						} else if (archievementRatio < 20) {
							status = "Wooden Spoon";
						}

						totalScore += archievementRatio;

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			} // //////////////////////////////////

			// ///////////////////////////////////////////////////////////////////////
			else if ((!bscPeriod.equals("Choose Period"))
					&& (!positions.equals("Choose Position"))
					

			) {
				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscPeriod] =  '"
						+ bscPeriod
						+ "' and [position] =  '"
						+ positions
						+ "' and [reportingFrequencies] = 'Monthly'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

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

						if (archievementRatio > 100) {
							status = "Diamond";
						} else if ((archievementRatio < 100)
								&& (archievementRatio > 100)) {
							status = "Platinum";
						} else if ((archievementRatio < 70)
								&& (archievementRatio > 50)) {
							status = "Gold";
						} else if ((archievementRatio < 50)
								&& (archievementRatio > 20)) {
							status = "Bronze";
						} else if (archievementRatio < 20) {
							status = "Wooden Spoon";
						}

						totalScore += archievementRatio;

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			} // //////////////////////////////////

			// ///////////////////////////////////////////////////////////////////////
			else if ((!bscPeriod.equals("Choose Period"))
					&& (positions.equals("Choose Position"))
					&& (!department.equals("Choose Department"))
					&& (perspective1.equals("Choose Perspective"))
					&& (employee.equals("Choose Employee"))
					&& (subDepartment.equals("Choose Sub-Department"))
					&& (objective1.equals("Choose Objective"))
					&& (bscEmployeeName.equals("Choose Employee"))
					&& (measure1.equals("Choose Measure"))

			) {
				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscPeriod] =  '"
						+ bscPeriod
						+ "' and [department] =  '"
						+ department
						+ "' and [reportingFrequencies] = 'Monthly'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

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

						if (archievementRatio > 100) {
							status = "Diamond";
						} else if ((archievementRatio < 100)
								&& (archievementRatio > 100)) {
							status = "Platinum";
						} else if ((archievementRatio < 70)
								&& (archievementRatio > 50)) {
							status = "Gold";
						} else if ((archievementRatio < 50)
								&& (archievementRatio > 20)) {
							status = "Bronze";
						} else if (archievementRatio < 20) {
							status = "Wooden Spoon";
						}

						totalScore += archievementRatio;

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			} // //////////////////////////////////

			// ///////////////////////////////////////////////////////////////////////
			else if ((!bscPeriod.equals("Choose Period"))
					&& (positions.equals("Choose Position"))
					&& (department.equals("Choose Department"))
					&& (perspective1.equals("Choose Perspective"))
					&& (subDepartment.equals("Choose Sub-Department"))
					&& (objective1.equals("Choose Objective"))
					&& (!bscEmployeeName.equals("Choose Employee"))
					&& (measure1.equals("Choose Measure"))

			) {

				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscPeriod] =  '"
						+ bscPeriod
						+ "' and [bscEmployeeName] =  '"
						+ bscEmployeeName
						+ "' and [reportingFrequencies] = 'Monthly'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

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

						if (archievementRatio > 100) {
							status = "Diamond";
						} else if ((archievementRatio < 100)
								&& (archievementRatio > 100)) {
							status = "Platinum";
						} else if ((archievementRatio < 70)
								&& (archievementRatio > 50)) {
							status = "Gold";
						} else if ((archievementRatio < 50)
								&& (archievementRatio > 20)) {
							status = "Bronze";
						} else if (archievementRatio < 20) {
							status = "Wooden Spoon";
						}

						totalScore += archievementRatio;

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			} // //////////////////////////////////

			// ///////////////////////////////////////////////////////////////////////
			else if ((!bscPeriod.equals("Choose Period"))
					&& (positions.equals("Choose Position"))
					&& (department.equals("Choose Department"))
					&& (!perspective1.equals("Choose Perspective"))
					&& (employee.equals("Choose Employee"))
					&& (subDepartment.equals("Choose Sub-Department"))
					&& (objective1.equals("Choose Objective"))
					&& (bscEmployeeName.equals("Choose Employee"))
					&& (measure1.equals("Choose Measure"))

			) {

				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscPeriod] =  '"
						+ bscPeriod
						+ "' and [perspective] =  '"
						+ perspective1
						+ "' and [reportingFrequencies] = 'Monthly'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

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

						if (archievementRatio > 100) {
							status = "Diamond";
						} else if ((archievementRatio < 100)
								&& (archievementRatio > 100)) {
							status = "Platinum";
						} else if ((archievementRatio < 70)
								&& (archievementRatio > 50)) {
							status = "Gold";
						} else if ((archievementRatio < 50)
								&& (archievementRatio > 20)) {
							status = "Bronze";
						} else if (archievementRatio < 20) {
							status = "Wooden Spoon";
						}

						totalScore += archievementRatio;

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			} // //////////////////////////////////
			
			
			

			// ///////////////////////////////////////////////////////////////////////
			else if ((!bscPeriod.equals("Choose Period"))
					&& (positions.equals("Choose Position"))
					&& (department.equals("Choose Department"))
					&& (perspective1.equals("Choose Perspective"))
					&& (subDepartment.equals("Choose Sub-Department"))
					&& (!objective1.equals("Choose Objective"))
					&& (bscEmployeeName.equals("Choose Employee"))
					&& (measure1.equals("Choose Measure"))

			) {
				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscPeriod] =  '"
						+ bscPeriod
						+ "' and [objective] =  '"
						+ objective1
						+ "' and [reportingFrequencies] = 'Monthly'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

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

						if (archievementRatio > 100) {
							status = "Diamond";
						} else if ((archievementRatio < 100)
								&& (archievementRatio > 100)) {
							status = "Platinum";
						} else if ((archievementRatio < 70)
								&& (archievementRatio > 50)) {
							status = "Gold";
						} else if ((archievementRatio < 50)
								&& (archievementRatio > 20)) {
							status = "Bronze";
						} else if (archievementRatio < 20) {
							status = "Wooden Spoon";
						}

						totalScore += archievementRatio;

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			} // //////////////////////////////////

			// ///////////////////////////////////////////////////////////////////////
			else if ((!bscPeriod.equals("Choose Period"))
					&& (positions.equals("Choose Position"))
					&& (department.equals("Choose Department"))
					&& (perspective1.equals("Choose Perspective"))
					&& (employee.equals("Choose Employee"))
					&& (subDepartment.equals("Choose Sub-Department"))
					&& (objective1.equals("Choose Objective"))
					&& (bscEmployeeName.equals("Choose Employee"))
					&& (!measure1.equals("Choose Measure"))

			) {
				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscPeriod] =  '"
						+ bscPeriod
						+ "' and [measure] =  '"
						+ measure1
						+ "' and [reportingFrequencies] = 'Monthly'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

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

						if (archievementRatio > 100) {
							status = "Diamond";
						} else if ((archievementRatio < 100)
								&& (archievementRatio > 100)) {
							status = "Platinum";
						} else if ((archievementRatio < 70)
								&& (archievementRatio > 50)) {
							status = "Gold";
						} else if ((archievementRatio < 50)
								&& (archievementRatio > 20)) {
							status = "Bronze";
						} else if (archievementRatio < 20) {
							status = "Wooden Spoon";
						}

						totalScore += archievementRatio;

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			} // //////////////////////////////////
			
			// ///////////////////////////////////////////////////////////////////////
						else if ((!bscPeriod.equals("Choose Period"))
								&& (positions.equals("Choose Position"))
								&& (department.equals("Choose Department"))
								&& (perspective1.equals("Choose Perspective"))
								&& (employee.equals("Choose Employee"))
								&& (!subDepartment.equals("Choose Sub-Department"))
								&& (objective1.equals("Choose Objective"))
								&& (bscEmployeeName.equals("Choose Employee"))
								&& (measure1.equals("Choose Measure"))

						) {
							
							String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
									+ "where [bscPeriod] =  '"
									+ bscPeriod
									+ "' and [subDepartment] =  '"
									+ subDepartment
									+ "' and [reportingFrequencies] = 'Monthly'"
									+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

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

									if (archievementRatio > 100) {
										status = "Diamond";
									} else if ((archievementRatio < 100)
											&& (archievementRatio > 100)) {
										status = "Platinum";
									} else if ((archievementRatio < 70)
											&& (archievementRatio > 50)) {
										status = "Gold";
									} else if ((archievementRatio < 50)
											&& (archievementRatio > 20)) {
										status = "Bronze";
									} else if (archievementRatio < 20) {
										status = "Wooden Spoon";
									}

									totalScore += archievementRatio;

									departmentReport.add(new BscReportsBean(perspective,
											objective, period, reportingFrequencies,
											measure, base, stretch, actual,
											archievementRatio, totalScore, averageScore,
											status));
								}

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.out
										.println("Cannot connect to activity database here");
							}

						} // //////////////////////////////////
			
			// ///////////////////////////////////////////////////////////////////////
						else if ((!bscPeriod.equals("Choose Period"))
								&& (positions.equals("Choose Position"))
								&& (department.equals("Choose Department"))
								&& (!perspective1.equals("Choose Perspective"))
								&& (employee.equals("Choose Employee"))
								&& (subDepartment.equals("Choose Sub-Department"))
								&& (objective1.equals("Choose Objective"))
								&& (bscEmployeeName.equals("Choose Employee"))
								&& (measure1.equals("Choose Measure"))

						) {
							
							String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
									+ "where [bscPeriod] =  '"
									+ bscPeriod
									+ "' and [perspective] =  '"
									+ perspective1
									+ "' and [reportingFrequencies] = 'Monthly'"
									+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

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

									if (archievementRatio > 100) {
										status = "Diamond";
									} else if ((archievementRatio < 100)
											&& (archievementRatio > 100)) {
										status = "Platinum";
									} else if ((archievementRatio < 70)
											&& (archievementRatio > 50)) {
										status = "Gold";
									} else if ((archievementRatio < 50)
											&& (archievementRatio > 20)) {
										status = "Bronze";
									} else if (archievementRatio < 20) {
										status = "Wooden Spoon";
									}

									totalScore += archievementRatio;

									departmentReport.add(new BscReportsBean(perspective,
											objective, period, reportingFrequencies,
											measure, base, stretch, actual,
											archievementRatio, totalScore, averageScore,
											status));
								}

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.out
										.println("Cannot connect to activity database here");
							}

						} // //////////////////////////////////
			

		}
		
		if(bscPeriod.contains("Choose")){
			bscPeriod = "No Period Specified";
		}
		if(positions.contains("Choose")){
			positions = "No positions Specified";
		}
		if(department.contains("Choose")){
			department = "No department Specified";
		}
		if(bscEmployeeName.contains("Choose")){
			bscEmployeeName = "No Employee Specified";
		}
		if(subDepartment.contains("Choose")){
			subDepartment = "No Sub Department Specified";
		}

		averageScore = totalScore / departmentReport.size();

		request.setAttribute("bscPeriod", bscPeriod);
		request.setAttribute("positions", positions);
		request.setAttribute("department",department);
		request.setAttribute("bscEmployeeName",bscEmployeeName);
		request.setAttribute("subDepartment",subDepartment);
		request.setAttribute("averageScore", averageScore);
		request.setAttribute("departmentReport", departmentReport);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscSearchReports.jsp");
		view.forward(request, response);

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
