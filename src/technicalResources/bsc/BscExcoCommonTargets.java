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
 * Servlet implementation class bscExcoCommonTargets
 */
@WebServlet("/BscExcoCommonTargets")
public class BscExcoCommonTargets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			String objectivePeriod = null;
			String perspective = null;
			String period = null;
			String reportingFrequency = null;
			String measure = null;
			float base = 0;
			float stretch = 0;

			Statement selectStatement = null;
			ResultSet results = null;

			ArrayList<BscCommonExcoBean> targets = new ArrayList<BscCommonExcoBean>();

			targets.clear();
			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();
			if (con != null) {

				String sql = "SELECT [objectivePeriod],[perspective], [period], [reportingFrequency], [measure] ,[base] ,[stretch] FROM [SwaziBankIntranet2016].[dbo].[bscExcoMetrics] group by  [objectivePeriod],[perspective], measure, period, reportingFrequency ,[base] ,[stretch] having count(measure) > 1 order by  CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes'  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END, measure";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {
						objectivePeriod = results.getString("objectivePeriod");
						perspective = results.getString("perspective");
						period = results.getString("period");
						reportingFrequency = results
								.getString("reportingFrequency");
						measure = results.getString("measure");
						base = results.getFloat("base");
						stretch = results.getFloat("stretch");

						targets.add(new BscCommonExcoBean(perspective, period,
								reportingFrequency, measure, base, stretch));
					}
					request.setAttribute("objectivePeriod", objectivePeriod);

					request.setAttribute("targets", targets);

					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscSetExcoCommonTargets.jsp");
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

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String[] measures = request.getParameterValues("measure");
	
		String[] period = request.getParameterValues("period");
		String[] reportingFrequency = request.getParameterValues("reportingFrequency");
		String[] bases = request.getParameterValues("base");
		String[] stretches = request.getParameterValues("stretch");
		
		

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String insertIssueSql = "UPDATE [dbo].bscExcoMetrics SET  [period] = ?, [reportingFrequency] = ?, [base] = ?,[stretch] = ?  Where [measure]  = ? ";

			try {

				java.sql.PreparedStatement insertReportStatement = con.prepareStatement(insertIssueSql, new String[] { "id" });
				
				for (int i = 0; i < measures.length; i++) {
					insertReportStatement.setString(1, period[i]);
					insertReportStatement.setString(2, reportingFrequency[i]);
					insertReportStatement.setFloat(3, Float.valueOf(bases[i]));
					insertReportStatement.setFloat(4, Float.valueOf(stretches[i]));
					insertReportStatement.setString(5, measures[i]);

					
					insertReportStatement.executeUpdate();
				}

				insertReportStatement.close();
				

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscExcoHome.jsp");

				view.forward(request, response);

			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			finally {
				if (con != null) {
					try {
						ConnectionHelper.disconnect(con);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		}
		
	}
}
