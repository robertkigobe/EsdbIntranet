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

/**
 * Servlet implementation class BscExcoScores
 */
@WebServlet("/BscExcoScores")
public class BscExcoScores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

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

		measureList
				.add(new BscMeasureBean("Choose Position", null, null, null));
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT Distinct [Position]  FROM [dbo].[bscExcoMetrics] order by [Position]";

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
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscScoreExcoRequest.jsp");
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

		ArrayList<BscTargetsBeans> targets = new ArrayList<BscTargetsBeans>();

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

		String bscPeriod = request.getParameter("bscPeriod");
		String position = request.getParameter("position");

		Statement selectStatement = null;
		ResultSet results = null;
		targets.clear();
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			if (!bscPeriod.equals("Quarter 4 2017-2018")
					&& !bscPeriod.equals("Quarter 3 2017-2018")
					&& !bscPeriod.equals("2017-2018")) {

				String sql = "SELECT *  FROM [dbo].[bscExcoMetrics] where position = '"
						+ position + " ' Order By [id]";

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
					System.out
							.println("Cannot connect to activity database here");
				}

			} else if (bscPeriod.equals("Quarter 3 2017-2018")||bscPeriod.equals("Quarter 4 2017-2018") ) {

				String sql = "SELECT *  FROM [dbo].[bscExcoMetrics] where position = '"
					+ position + " ' and period = 'Mid Term' and reportingFrequency = 'Quarterly' Order By [id]";

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
					System.out
							.println("Cannot connect to activity database here");
				}
			} else if (bscPeriod.equals("2017-2018")) {

				String sql = "SELECT *  FROM [dbo].[bscExcoMetrics] where position = '"
					+ position + " ' and period = 'Long Term' and reportingFrequency = 'Yearly' Order By [id]";

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
					System.out
							.println("Cannot connect to activity database here");
				}
			}

		}

		request.setAttribute("bscPeriod", bscPeriod);
		request.setAttribute("objectivePeriod", objectivePeriod);
		request.setAttribute("department", department);
		request.setAttribute("position", position);
		request.setAttribute("targets", targets);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscSetExcoPositionScores.jsp");
		view.forward(request, response);

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
