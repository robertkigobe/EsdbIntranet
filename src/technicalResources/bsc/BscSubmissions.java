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
@WebServlet("/BscSubmissions")
public class BscSubmissions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String bscPeriodSubmission;
		String bscEmployeeNameSubmission;
		String bscEmployeeSupervisorSubmission;
		String positionSubmission;
		String subDepartment;

		Statement selectStatement = null;
		ResultSet results = null;

		ArrayList<BscSubmissionsBean> submissionReport = new ArrayList<BscSubmissionsBean>();

		submissionReport.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			String sql = "SELECT  distinct([bscPeriod]), [bscEmployeeName]   ,[bscEmployeeSupervisor],subDepartment   ,[position]   ,[department] FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by bscPeriod,department, position";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					bscPeriodSubmission = results.getString("bscPeriod");
					bscEmployeeNameSubmission = results
							.getString("bscEmployeeName");
					subDepartment = results.getString("subDepartment");
					bscEmployeeSupervisorSubmission = results
							.getString("bscEmployeeSupervisor");
					positionSubmission = results.getString("position");

					submissionReport
							.add(new BscSubmissionsBean(bscPeriodSubmission,
									subDepartment, bscEmployeeNameSubmission,
									bscEmployeeSupervisorSubmission,
									positionSubmission));
				}
				request.setAttribute("submissionReport", submissionReport);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscSubmissionReports.jsp");
				view.forward(request, response);

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

		} // //////////////////////////////////
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String bscEmployeeName = request.getParameter("bscEmployeeName");
		String bscPeriodSubmission;
		String bscEmployeeNameSubmission;
		String bscEmployeeSupervisorSubmission;
		String positionSubmission;
		String subDepartment;

		Statement selectStatement = null;
		ResultSet results = null;

		ArrayList<BscSubmissionsBean> submissionReport = new ArrayList<BscSubmissionsBean>();

		submissionReport.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			String sql = "SELECT  distinct([bscPeriod]), [bscEmployeeName]   ,[bscEmployeeSupervisor],subDepartment   ,[position]   ,[department] FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] where [bscEmployeeName] like '%"
					+ bscEmployeeName
					+ "%' order by bscPeriod,department, position";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					bscPeriodSubmission = results.getString("bscPeriod");
					bscEmployeeNameSubmission = results
							.getString("bscEmployeeName");
					subDepartment = results.getString("subDepartment");
					bscEmployeeSupervisorSubmission = results
							.getString("bscEmployeeSupervisor");
					positionSubmission = results.getString("position");

					submissionReport
							.add(new BscSubmissionsBean(bscPeriodSubmission,
									subDepartment, bscEmployeeNameSubmission,
									bscEmployeeSupervisorSubmission,
									positionSubmission));
				}
				request.setAttribute("submissionReport", submissionReport);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscSubmissionReports.jsp");
				view.forward(request, response);

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

		}

	}
}
