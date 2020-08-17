package technicalResources.SkillsAudits;

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
@WebServlet("/SkillsAuditPostQualityControlSkills")
public class SkillsAuditPostQualityControlSkills extends HttpServlet {
	
	public static Connection con;
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = System.getProperty("user.name");
		
		
		
		request.setAttribute("userName", userName);

		String financialYear = "2017-2018";
		String position = request.getParameter("position");
		String subDepartment = request.getParameter("subDepartment");
		String department = request.getParameter("department");
		String bscEmployeeName = request.getParameter("bscEmployeeName");
		String bscEmployeeSupervisor = request.getParameter("bscEmployeeSupervisor");
		
		String[] category = request.getParameterValues("category");
		String[] skill = request.getParameterValues("skill");
		String[] rating = request.getParameterValues("rating");
		String[] priority = request.getParameterValues("priority");
		String[] remarks = request.getParameterValues("remarks");
		

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String insertIssueSql = "UPDATE [dbo].[SkillsAuditScores] "
					+ "SET "
					+ "[bscEmployeeSupervisor] = ?  ,"
					+ "[financialYear] = ? ,"
					+ "[department] = ?  ,"
					+ "[subDepartment] = ?  ,"
					+ "[position] = ?  ,"
					+ "[category] = ?  ,"
					+ "[rating] = ? ,"
					+ "[priority] = ?  ,"
					+ "[remarks] = ?  "
					+ "WHERE [skill] = ? and [bscEmployeeName] = ?";

			try {

				java.sql.PreparedStatement insertReportStatement = con.prepareStatement(insertIssueSql);
				
				for (int i = 0; i < category.length; i++) {
					
					insertReportStatement.setString(1, bscEmployeeSupervisor);
					insertReportStatement.setString(2, financialYear);
					insertReportStatement.setString(3, department);
					insertReportStatement.setString(4, subDepartment);
					insertReportStatement.setString(5, position);
					insertReportStatement.setString(6, category[i]);
					insertReportStatement.setString(7, rating[i]);
					insertReportStatement.setString(8, priority[i]);
					insertReportStatement.setString(9, remarks[i]);
					insertReportStatement.setString(10, bscEmployeeName);
					insertReportStatement.setString(11, skill[i]);
					
					insertReportStatement.executeUpdate();
				}

				insertReportStatement.close();
				con.close();

				response.sendRedirect(request.getContextPath()+ "/SkillsHome");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
