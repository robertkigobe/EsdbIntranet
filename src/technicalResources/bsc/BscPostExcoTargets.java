package technicalResources.bsc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class LoanTrackingNewLoan
 */
@WebServlet("/BscPostExcoTargets")
public class BscPostExcoTargets extends HttpServlet {
	
	public static Connection con;
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String[] measures = request.getParameterValues("measure");
		String[] departments =request.getParameterValues("department");
		String[] period = request.getParameterValues("period");
		String[] reportingFrequency = request.getParameterValues("reportingFrequency");
		String[] bases = request.getParameterValues("base");
		String[] stretches = request.getParameterValues("stretch");
		
		System.out.println(bases[1] + " " + measures[1] + " "+ departments[1]);

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String insertIssueSql = "UPDATE [dbo].bscExcoMetrics SET  [period] = ?, [reportingFrequency] = ?, [base] = ?,[stretch] = ?  Where [measure]  = ? and [position] = ?";

			try {

				java.sql.PreparedStatement insertReportStatement = con.prepareStatement(insertIssueSql, new String[] { "id" });
				
				for (int i = 0; i < measures.length; i++) {
					insertReportStatement.setString(1, period[i]);
					insertReportStatement.setString(2, reportingFrequency[i]);
					insertReportStatement.setFloat(3, Float.valueOf(bases[i]));
					insertReportStatement.setFloat(4, Float.valueOf(stretches[i]));
					insertReportStatement.setString(5, measures[i]);
					insertReportStatement.setString(6, departments[i]);
					
					insertReportStatement.executeUpdate();
				}

				insertReportStatement.close();
				con.close();

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
