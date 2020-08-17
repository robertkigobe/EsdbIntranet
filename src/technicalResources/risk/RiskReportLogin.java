package technicalResources.risk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import sz.co.swazibank.beans.DirectoryBean;
import util.ConnectionHelper;

/**
 * Servlet implementation class ProvisionsReport
 */
@WebServlet("/RiskReportLogin")
public class RiskReportLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	ArrayList<AmlBean> amlList;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_risk/riskLoginRequest.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		String report = request.getParameter("report");
		String password = request.getParameter("password");

		if ((report == "RISK MANEGEMENT TEST 2018")
				&& (password == "12345678=RMT18")) {
			userName = System.getProperty("user.name");
			request.setAttribute("userName", userName);

			ArrayList<RiskManagementSurveyBean> riskManagementSurveyList = new ArrayList<RiskManagementSurveyBean>();

			riskManagementSurveyList.clear();

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();
			if (con != null) {

				String sql = "SELECT [employeeName] ,[subDepartment] ,[score] FROM [SwaziBankIntranet2016].[dbo].[riskAwarenessSurvey] oder by [subDepartment], [employeeName]";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {
						String employeeName = results.getString("employeeName");
						String subDepartment = results.getString("subDepartment");
						String score = results.getString("score");
						

						riskManagementSurveyList.add(new RiskManagementSurveyBean(employeeName, subDepartment,
								score));
					}
					request.setAttribute("riskManagementSurveyList", riskManagementSurveyList);

					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalResources_risk/riskManegementSurveyReport.jsp");
					view.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
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
		} else if ((report.equals("RISK MANEGEMENT SURVEY 2018"))
				&& (password.equals("12345678=RMS18"))) {

			userName = System.getProperty("user.name");
			request.setAttribute("userName", userName);

			ArrayList<RiskManagementSurveyBean> riskManagementSurveyList = new ArrayList<RiskManagementSurveyBean>();

			riskManagementSurveyList.clear();

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();
			if (con != null) {

				String sql = "SELECT [employeeName] ,[subDepartment] ,[score] FROM [SwaziBankIntranet2016].[dbo].[riskAwarenessSurvey] order by [subDepartment], [employeeName]";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {
						String employeeName = results.getString("employeeName");
						String subDepartment = results.getString("subDepartment");
						String score = results.getString("score");
						

						riskManagementSurveyList.add(new RiskManagementSurveyBean(employeeName, subDepartment,
								score));
					}
					request.setAttribute("riskManagementSurveyList", riskManagementSurveyList);

					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalResources_risk/riskManegementSurveyReport.jsp");
					view.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
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

			

		} else if ((report == "RISK AMANEGEMENT AML TEST 2017")
				&& (password == "12345678=AML17")) {

			response.sendRedirect(request.getContextPath() + "/AmlReport");

		} else {
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/utilities/badPassword.jsp");
			view.forward(request, response);
		}

	}

}
