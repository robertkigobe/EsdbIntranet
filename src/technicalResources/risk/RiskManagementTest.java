package technicalResources.risk;

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
 * Servlet implementation class RiskAwarenessSurvey
 */
@WebServlet("/RiskManagementTest")
public class RiskManagementTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		ArrayList<String> employees = new ArrayList<String>();
		employees.clear();
		employees.add("Choose Employee");
		String employee = null;

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String sql1 = "SELECT distinct [firstName], [surName], [firstName] + ' ' + [surName] as 'employee' FROM [SwaziBankIntranet2016].[dbo].[dynamiqueEmployees] order by [firstName], [surName]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql1);

				while (results.next()) {
					employee = results.getString("employee");

					employees.add(employee);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}
		request.setAttribute("employees", employees);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_risk/riskManagementTest.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String employeeName = request.getParameter("employeeName");
		String subDepartment = request.getParameter("subDepartment");

		float q1 = Float.valueOf(request.getParameter("q1"));
		float q2 = Float.valueOf(request.getParameter("q2"));
		float q3 = Float.valueOf(request.getParameter("q3"));
		float q4 = Float.valueOf(request.getParameter("q4"));
		float q5 = Float.valueOf(request.getParameter("q5"));
		float q6 = Float.valueOf(request.getParameter("q6"));
		float q7 = Float.valueOf(request.getParameter("q7"));
		float q8 = Float.valueOf(request.getParameter("q8"));
		float q9 = Float.valueOf(request.getParameter("q9"));
		float q10 = Float.valueOf(request.getParameter("q10"));
		float q11 = Float.valueOf(request.getParameter("q11"));
		float q12 = Float.valueOf(request.getParameter("q12"));
		float q13 = Float.valueOf(request.getParameter("q13"));
		float q14 = Float.valueOf(request.getParameter("q14"));
		float q15 = Float.valueOf(request.getParameter("q15"));
		float q16 = Float.valueOf(request.getParameter("q16"));
		float q17 = Float.valueOf(request.getParameter("q17"));
		float q18 = Float.valueOf(request.getParameter("q18"));
		float q19 = Float.valueOf(request.getParameter("q19"));
		float q20 = Float.valueOf(request.getParameter("q20"));
		float q21 = Float.valueOf(request.getParameter("q21"));
		float q22 = Float.valueOf(request.getParameter("q22"));
		float q23 = Float.valueOf(request.getParameter("q23"));
		float q24 = Float.valueOf(request.getParameter("q24"));
		float q25 = Float.valueOf(request.getParameter("q25"));
		float q26 = Float.valueOf(request.getParameter("q26"));
		float q27 = Float.valueOf(request.getParameter("q27"));
		float q28 = Float.valueOf(request.getParameter("q28"));
		float q29 = Float.valueOf(request.getParameter("q29"));
		float q30 = Float.valueOf(request.getParameter("q30"));
		float q31 = Float.valueOf(request.getParameter("q31"));
		float q32 = Float.valueOf(request.getParameter("q32"));
		float q33 = Float.valueOf(request.getParameter("q33"));
		float q34 = Float.valueOf(request.getParameter("q34"));
		float q35 = Float.valueOf(request.getParameter("q35"));
		float q36 = Float.valueOf(request.getParameter("q36"));
		float q37 = Float.valueOf(request.getParameter("q37"));
		float q38 = Float.valueOf(request.getParameter("q38"));
		float q39 = Float.valueOf(request.getParameter("q39"));
		float q40 = Float.valueOf(request.getParameter("q40"));


		float score = q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8 + q9 + q10 + q11
				+ q12+ q13  + q14 + q15 + q16 + q17 + q18 + q19+ q20 + q21
				+ q22 + q23 + q24 + q25 + q26 + q27 + q28 + q29 + q30 + q31
				+ q32 + q33+ q34 +q35 + q36 + q37 + q38 + q39 + q40;

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String insertIssueSql = "INSERT INTO [SwaziBankIntranet2016].[dbo].[riskManagementTest]([employeeName],[subDepartment],[score])VALUES (?,?,?)";

			java.sql.PreparedStatement insertReportStatement = null;

			try {
				insertReportStatement = con.prepareStatement(insertIssueSql,new String[] { "id" });
				insertReportStatement.setString(1, employeeName);
				insertReportStatement.setString(2, subDepartment);
				insertReportStatement.setFloat(3, score);

				insertReportStatement.executeUpdate();
				insertReportStatement.close();
				con.close();

				request.setAttribute("employeeName", employeeName);
				request.setAttribute("subDepartment", subDepartment);
				request.setAttribute("score", score);
				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_risk/riskManagementTestSuccess.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}

			finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {

						System.out.println("can not close connection");
					}
				}
			}

		}
	}
}
