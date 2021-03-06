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

@WebServlet("/BscScoreRequestQuarterly")
public class BscScoreRequestQuarterly extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		String position = null;
		String measure = null;
		String measureDesciption = null;
		String perspective = null;

		ArrayList<BscMeasureBean> measureList = new ArrayList<BscMeasureBean>();

		measureList.clear();
		measureList.add(new BscMeasureBean("Choose Position", null, null, null));
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT Distinct [Position]  FROM [dbo].[bscMetrics] order by Position";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);
				while (results.next()) {
					position = results.getString("position");
					measureList.add(new BscMeasureBean(position, measure,
							measureDesciption, perspective));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		request.setAttribute("position", position);
		request.setAttribute("measureList", measureList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscScoreRequestQuarterly.jsp");
		view.forward(request, response);

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		


			ArrayList<BscTargetsBeans> targets = new ArrayList<BscTargetsBeans>();
			ArrayList<String> employees = new ArrayList<String>();

			String objectivePeriod = null;
			String department = null;
			String rolePlayed = null;
			String perspective = null;
			String objective = null;
			String period = null;
			String reportingFrequency = null;
			String measure = null;
			float base = 0;
			float stretch = 0;

			String position = request.getParameter("position");

			Statement selectStatement = null;
			Statement selectStatement1 = null;
			ResultSet results = null;
			ResultSet results1 = null;
			String employee = null;
			employees.clear();
			employees.add("Choose Employee");

			targets.clear();
			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();

			if (con != null) {

				String sql1 = "SELECT distinct [firstName], [surName], [firstName] + ' ' + [surName] as 'employee' FROM [SwaziBankIntranet2016].[dbo].[dynamiqueEmployees] order by [firstName], [surName]";

				try {
					selectStatement1 = con.createStatement();
					results1 = selectStatement1.executeQuery(sql1);

					while (results1.next()) {
						employee = results1.getString("employee");

						employees.add(employee);
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Cannot connect to activity database here");
				}

			}
			

			if (con != null) {

				String sql = "SELECT *  FROM [dbo].[bscMetrics] where position = '"+ position + " ' and period = 'Mid Term' and reportingFrequency = 'Quarterly' and [objectivePeriod] = 'April 2018 - March 2019' Order By [id]";


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
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Cannot connect to activity database here");
				}

			}

			request.setAttribute("employees", employees);
			request.setAttribute("objectivePeriod", objectivePeriod);
			request.setAttribute("department", department);
			request.setAttribute("position", position);
			request.setAttribute("targets", targets);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscSetPositionScoresQuarterly.jsp");
			view.forward(request, response);

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
