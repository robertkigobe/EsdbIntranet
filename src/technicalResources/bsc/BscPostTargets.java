package technicalResources.bsc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class LoanTrackingNewLoan
 */
@WebServlet("/BscPostTargets")
public class BscPostTargets extends HttpServlet {
	
	public static Connection con;
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
		String[] period = request.getParameterValues("period");
		String[] reportingFrequency = request.getParameterValues("reportingFrequency");
		String[] measures = request.getParameterValues("measure");
		
		String[] bases = request.getParameterValues("base");
		String[] stretches = request.getParameterValues("stretch");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String insertIssueSql = "UPDATE [dbo].bscMetrics SET  [period] = ?, [reportingFrequency] = ?, [base] = ?,[stretch] = ?  Where [measure]  = ? and [objectivePeriod] = 'April 2018 - March 2019'";

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
				con.close();

				response.sendRedirect(request.getContextPath()+ "/BscMain");

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
