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
@WebServlet("/SkillsAuditPostSkills")
public class SkillsAuditPostSkills extends HttpServlet {
	
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

			String insertIssueSql = "INSERT INTO [dbo].[SkillsAuditScores]   "
					+ "([bscEmployeeName]  "
					+ ",[bscEmployeeSupervisor]  "
					+ ",[financialYear]  "
					+ ",[department]  "
					+ ",[subDepartment]  "
					+ ",[position]   "
					+ ",[category]    "
					+ ",[skill]   "
					+ ",[rating]   "
					+ ",[priority]  "
					+ ",[remarks])  VALUES  (?,?,?,?,?,?,?,?,?,?,?)";

			try {

				java.sql.PreparedStatement insertReportStatement = con.prepareStatement(insertIssueSql);
				
				for (int i = 0; i < category.length; i++) {
					insertReportStatement.setString(1, bscEmployeeName);
					insertReportStatement.setString(2, bscEmployeeSupervisor);
					insertReportStatement.setString(3, financialYear);
					insertReportStatement.setString(4, department);
					insertReportStatement.setString(5, subDepartment);
					insertReportStatement.setString(6, position);
					insertReportStatement.setString(7, category[i]);
					insertReportStatement.setString(8, skill[i]);
					insertReportStatement.setString(9, rating[i]);
					insertReportStatement.setString(10, priority[i]);
					insertReportStatement.setString(11, remarks[i]);
					
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
