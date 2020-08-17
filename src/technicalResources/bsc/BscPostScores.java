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
@WebServlet("/BscPostScores")
public class BscPostScores extends HttpServlet {
	
	public static Connection con;
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		
		String bscEmployeeName = request.getParameter("bscEmployeeName");
		String bscEmployeeSupervisor = request.getParameter("bscEmployeeSupervisor");
		String position = request.getParameter("position");
		String department = request.getParameter("department");
		String subDepartment = request.getParameter("subDepartment");
		String bscPeriod = request.getParameter("bscPeriod");
		
		
		
		
		String[] perspectives = request.getParameterValues("perspective");
		String[] objectives = request.getParameterValues("objective");
		String[] periods = request.getParameterValues("period");
		String[] reportingFrequencies = request.getParameterValues("reportingFrequency");
		String[] measures = request.getParameterValues("measure");
		String[] bases = request.getParameterValues("base");
		String[] stretches = request.getParameterValues("stretch");
		String[] actuals = request.getParameterValues("actual");
		

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			
			

			String insertIssueSql = "INSERT INTO [dbo].[bscSDSBScores]  "
					+ "([bscEmployeeName]  "
					+ ",[bscEmployeeSupervisor]"
					+ ",[position]"
					+ ",[department]  "
					+ ",[subDepartment]  "
					+ ",[bscPeriod]  "
					+ ",[perspective]  "
					+ ",[objective]   "
					+ ",[period]   "
					+ ",[reportingFrequencies]   "
					+ ",[measure]  "
					+ ",[base]    "
					+ ",[stretch]  "
					+ ",[actual])  "
					+ "VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			try {

				java.sql.PreparedStatement insertReportStatement = con.prepareStatement(insertIssueSql, new String[] { "id" });
				
				
				
				for (int i = 0; i < measures.length; i++) {
					
					insertReportStatement.setString(1, bscEmployeeName);
					insertReportStatement.setString(2, bscEmployeeSupervisor);
					insertReportStatement.setString(3, position);
					insertReportStatement.setString(4, department);
					insertReportStatement.setString(5, subDepartment);
					insertReportStatement.setString(6, bscPeriod);
					insertReportStatement.setString(7, perspectives[i]);
					insertReportStatement.setString(8, objectives[i]);
					insertReportStatement.setString(9, periods[i]);
					insertReportStatement.setString(10, reportingFrequencies[i]);
					insertReportStatement.setString(11, measures[i]);
					insertReportStatement.setFloat(12, Float.valueOf(bases[i]));
					insertReportStatement.setFloat(13, Float.valueOf(stretches[i]));
					insertReportStatement.setFloat(14, Float.parseFloat(actuals[i]));
					
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
						
						e.printStackTrace();
					}
				}

			}

		}

	}
}
