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
 * Servlet implementation class BscSubmissions
 */
@WebServlet("/BscDelete")
public class BscDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Statement selectStatement = null;
		ResultSet results = null;
		String subDepartment = null;
		String bscEmployeeName = null;
		String bscEmployeeSupervisor = null;
		String bscPeriod = null;
		String position = null;

		ArrayList<String> subDepartments = new ArrayList<String>();
		ArrayList<String> bscEmployeeNames = new ArrayList<String>();
		ArrayList<String> bscEmployeeSupervisors = new ArrayList<String>();
		ArrayList<String> bscPeriods = new ArrayList<String>();
		ArrayList<String> positions = new ArrayList<String>();

		subDepartments.clear();
		bscEmployeeNames.clear();
		subDepartments.clear();
		subDepartments.clear();
		subDepartments.add("Choose Subdepartment");
		bscEmployeeNames.add("Choose Staff Name");
		bscEmployeeSupervisors.add("Choose bscEmployeeSupervisor");
		bscPeriods.add("Choose bscPeriod");
		positions.add("Choose position");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String sql1 = "SELECT  distinct([subDepartment])   FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by subDepartment";
			String sql2 = "SELECT  distinct([bscEmployeeName])   FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by bscEmployeeName asc";
			String sql3 = "SELECT  distinct([bscEmployeeSupervisor])   FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by bscEmployeeSupervisor asc";
			String sql4 = "SELECT  distinct([bscPeriod])   FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by [bscPeriod] ";
			String sql5 = "SELECT  distinct([position])   FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by [position]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql1);

				while (results.next()) {
					subDepartment = results.getString("subDepartment");
					subDepartments.add(subDepartment);
				}
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql2);

				while (results.next()) {
					bscEmployeeName = results.getString("bscEmployeeName");
					bscEmployeeNames.add(bscEmployeeName);
				}
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql3);

				while (results.next()) {
					bscEmployeeSupervisor = results
							.getString("bscEmployeeSupervisor");
					bscEmployeeSupervisors.add(bscEmployeeSupervisor);
				}
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql4);

				while (results.next()) {
					bscPeriod = results.getString("bscPeriod");
					bscPeriods.add(bscPeriod);
				}

				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql5);

				while (results.next()) {
					position = results.getString("position");
					positions.add(position);
				}

				request.setAttribute("positions", positions);
				request.setAttribute("subDepartments", subDepartments);
				request.setAttribute("bscEmployeeNames", bscEmployeeNames);
				request.setAttribute("bscEmployeeSupervisors",
						bscEmployeeSupervisors);
				request.setAttribute("bscPeriods", bscPeriods);
				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscDeleteRequest.jsp");

				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		} else {

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/utilities/noDatabaseConnection.jsp");

			view.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String subDepartment = request.getParameter("subDepartment");
		String bscEmployeeName = request.getParameter("bscEmployeeName");
		String bscEmployeeSupervisor = request
				.getParameter("bscEmployeeSupervisor");
		String bscPeriod = request.getParameter("bscPeriod");
		String position = request.getParameter("position");
		
		
			
		

		Statement selectStatement = null;

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			String sql = "DELETE " + "FROM [dbo].[bscSDSBScores]  " + "WHERE "
					+ "[bscPeriod] = '" + bscPeriod + "' "
					+ "and [bscEmployeeName] = '" + bscEmployeeName + "' "
					+ "and [bscEmployeeSupervisor] = '" + bscEmployeeSupervisor
					+ "'" + "and subDepartment = '" + subDepartment + "' 	   "
					+ "and [position] = '" + position + "'";

			try {
				selectStatement = con.createStatement();
				selectStatement.executeUpdate(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			request.setAttribute("bscPeriod",bscPeriod);
			request.setAttribute("bscEmployeeName",bscEmployeeName);
			request.setAttribute("bscEmployeeSupervisor",bscEmployeeSupervisor);
			request.setAttribute("subDepartment",subDepartment);
			request.setAttribute("position",position);
			
			
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_bsc/successfulDelete.jsp");
			view.forward(request, response);

		}

		else {
			
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/utilities/noDatabaseConnection.jsp");

			view.forward(request, response);

		}
	}
	
}
