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
@WebServlet("/RiskAwarenessSurvey")
public class RiskAwarenessSurvey extends HttpServlet {
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

			String sql1 = "SELECT  [Surname] + ' ' + [Firstname]   as 'employee'   FROM [SwaziBankIntranet2016].[dbo].[employeesDynamique]  order by Surname";

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
				.getRequestDispatcher("WEB-INF/technicalResources_risk/riskAwarenessSurvey.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String employeeName = request.getParameter("employeeName");
		String subDepartment = request.getParameter("subDepartment");

		int q1 = Integer.valueOf(request.getParameter("q1"));
		int q2 = Integer.valueOf(request.getParameter("q2"));
		int q3 = Integer.valueOf(request.getParameter("q3"));
		int q4 = Integer.valueOf(request.getParameter("q4"));
		int q5 = Integer.valueOf(request.getParameter("q5"));
		int q6 = Integer.valueOf(request.getParameter("q6"));
		int q7 = Integer.valueOf(request.getParameter("q7"));
		int q8 = Integer.valueOf(request.getParameter("q8"));
		int q9 = Integer.valueOf(request.getParameter("q9"));
		int q10 = Integer.valueOf(request.getParameter("q10"));
		int q11 = Integer.valueOf(request.getParameter("q11"));
		int q12 = Integer.valueOf(request.getParameter("q12"));
		int q13 = Integer.valueOf(request.getParameter("q13"));
		int q14 = Integer.valueOf(request.getParameter("q14"));
		int q15 = Integer.valueOf(request.getParameter("q15"));
		int q16 = Integer.valueOf(request.getParameter("q16"));
		int q17 = Integer.valueOf(request.getParameter("q17"));
		int q18 = Integer.valueOf(request.getParameter("q18"));
		int q19 = Integer.valueOf(request.getParameter("q19"));
		int q20 = Integer.valueOf(request.getParameter("q20"));
		int q21 = Integer.valueOf(request.getParameter("q21"));
		int q22 = Integer.valueOf(request.getParameter("q22"));
		int q23 = Integer.valueOf(request.getParameter("q23"));
		int q24 = Integer.valueOf(request.getParameter("q24"));
		int q25 = Integer.valueOf(request.getParameter("q25"));
		int q26 = Integer.valueOf(request.getParameter("q26"));
		int q27 = Integer.valueOf(request.getParameter("q27"));
		int q28 = Integer.valueOf(request.getParameter("q28"));
		int q29 = Integer.valueOf(request.getParameter("q29"));
		int q30 = Integer.valueOf(request.getParameter("q30"));
		int q31 = Integer.valueOf(request.getParameter("q31"));
		int q32 = Integer.valueOf(request.getParameter("q32"));
		int q33 = Integer.valueOf(request.getParameter("q33"));
		int q34 = Integer.valueOf(request.getParameter("q34"));


		float score = q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8 + q9 + q10 + q11
				+ q12+ q13  + q14 + q15 + q16 + q17 + q18 + q19+ q20 + q21
				+ q22 + q23 + q24 + q25 + q26 + q27 + q28 + q29 + q30 + q31
				+ q32 + q33+ q34;

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String insertIssueSql = "INSERT INTO [dbo].[riskAwarenessSurvey]([employeeName],[subDepartment],[score])VALUES (?,?,?)";

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
						.getRequestDispatcher("WEB-INF/technicalResources_risk/riskAwarenessSurveySuccess.jsp");
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
