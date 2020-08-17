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
 * Servlet implementation class HealthSafetyMain
 */
@WebServlet("/BscAnnualScores")
public class BscAnnualScores extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String subDepartment = null;
		String bscEmployeeName = null;

		String perspective = null;
		String objective = null;
		String period = null;
		String reportingFrequencies = null;
		String measure = null;
		float base = 0;
		float stretch = 0;
		float actual = 0;
		float archievementRatio = 0;
		float totalScore = 0;
		float averageScore = 0;
		String status = null;

		Statement selectStatement = null;
		ResultSet results1 = null;
		ResultSet results = null;

		ArrayList<BscReportsBean> departmentReport = new ArrayList<BscReportsBean>();
		ArrayList<BscReportsAnnualsubmissionBean> annualSubmissions = new ArrayList<BscReportsAnnualsubmissionBean>();
		ArrayList<BscSubmissionsAnnualBean> annualSubmissionsReport = new ArrayList<BscSubmissionsAnnualBean>();

		annualSubmissions.clear();
		annualSubmissionsReport.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String sql = "SELECT  distinct [bscEmployeeName] ,subDepartment    FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] where bscPeriod = '2017-2018' order by subDepartment, bscEmployeeName";

			try {
				selectStatement = con.createStatement();
				results1 = selectStatement.executeQuery(sql);

				if (!results1.next()) {
					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/utilities/badPassword.jsp");
					view.forward(request, response);
				} else {

					while (results1.next()) {

						bscEmployeeName = results1.getString("bscEmployeeName");
						subDepartment = results1.getString("subDepartment");

						annualSubmissions
								.add(new BscReportsAnnualsubmissionBean(
										 bscEmployeeName, subDepartment ));

					}

					

					
					for (int x = 0; x < annualSubmissions.size(); x++) {
						departmentReport.clear();
						 base = 0;
						 stretch = 0;
						 actual = 0;
						 archievementRatio = 0;
						 totalScore = 0;
						 averageScore = 0;
						String sql1 = "select "
								+ "[perspective],	"
								+ "[objective],"
								+ "[period],"
								+ "[reportingFrequencies],"
								+ "[measure],"
								+ "[base],"
								+ "[stretch], "
								+ "[actual]  "
								+ "from "
								+ "( SELECT    "
								+ "[perspective],"
								+ "[objective],"
								+ "[period],"
								+ "[reportingFrequencies],"
								+ "[measure],"
								+ "avg([base]) as 'base',"
								+ "avg([stretch]) as 'stretch',"
								+ "avg([actual]) as 'actual'  "
								+ "FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores]     "
								+ "where    " + "[bscEmployeeName] = '"
								+ annualSubmissions.get(x).getBscEmployeeName()
								+ "' "
								+ "and [reportingFrequencies] = 'Monthly' "
								+ "and [subDepartment] = '"
								+ annualSubmissions.get(x).getSubDepartment()
								+ "' "
								+ "and bscPeriod IN ('October 2017','December 2017','November 2017','January 2018','February 2018','March 2018')  "
								+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure]  "
								+ "union "
								+ "select   "
								+ "[perspective]  ,"
								+ "[objective] ,"
								+ "[period]  ,"
								+ "[reportingFrequencies]  ,"
								+ "[measure]  ,"
								+ "avg([base]) as 'base',"
								+ "avg([stretch]) as 'stretch',"
								+ "avg([actual]) as 'actual'  "
								+ "FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores]  "
								+ "where bscEmployeeName = '"
								+  annualSubmissions.get(x).getBscEmployeeName()
								+ "' "
								+ "and bscPeriod in ( 'Quarter 3 2017-2018','Quarter 4 2017-2018')   "
								+ "and [subDepartment] = '"
								+ annualSubmissions.get(x).getSubDepartment()
								+ "' "
								+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] "
								+ "union "
								+ "SELECT    "
								+ "[perspective],"
								+ "[objective],"
								+ "[period],"
								+ "[reportingFrequencies],"
								+ "[measure],"
								+ "avg([base]) as 'base',"
								+ "avg([stretch]) as 'stretch',"
								+ "avg([actual]) as 'actual'   "
								+ "FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores]     "
								+ "where    "
								+ "[bscEmployeeName] = '"
								+  annualSubmissions.get(x).getBscEmployeeName()
								+ "' "
								+ "and [reportingFrequencies] = 'Yearly' "
								+ "and [subDepartment] = '"
								+  annualSubmissions.get(x).getSubDepartment()
								+ "' "
								+ "and bscPeriod = '2017-2018' "
								+ "Group by  "
								+ "[perspective],[objective],[period],[reportingFrequencies],[measure] )  "
								+ "results   "
								+ "ORDER BY CASE [perspective]   "
								+ "WHEN 'Financial'  THEN '0'"
								+ "WHEN 'Customer' THEN '1'"
								+ "WHEN 'Internal Business Processes '  THEN '2' "
								+ "WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

						

						try {
							selectStatement = con.createStatement();
							results = selectStatement.executeQuery(sql1);

							//System.out.println("Test " + annualSubmissions.get(x).getBscEmployeeName());
							
							while (results.next()) {

								perspective = results.getString("perspective");

								objective = results.getString("objective");
								period = results.getString("period");
								reportingFrequencies = results
										.getString("reportingFrequencies");
								measure = results.getString("measure");
								base = Float.valueOf(results.getString("base"));
								stretch = Float.valueOf(results
										.getString("stretch"));
								actual = Float.valueOf(results
										.getString("actual"));

								if ((stretch - base) != 0) {
									archievementRatio = ((actual - base) / (stretch - base)) * 100;
								} else {
									archievementRatio = 0;
								}

								if (archievementRatio >= 100) {
									status = "Diamond";

								} else if ((archievementRatio < 100)
										&& (archievementRatio > 70)) {
									status = "Platinum";
								} else if ((archievementRatio < 70)
										&& (archievementRatio > 50)) {
									status = "Gold";
								} else if ((archievementRatio < 50)
										&& (archievementRatio > 20)) {
									status = "Bronze";
								} else if (archievementRatio < 20) {
									status = "Wooden Spoon";
								}

								totalScore += archievementRatio;

								departmentReport.add(new BscReportsBean(
										
										perspective, objective, period,
										reportingFrequencies, measure, base,
										stretch, actual, archievementRatio,
										totalScore, averageScore, status));
							
							}

							averageScore = totalScore / departmentReport.size();
							
							if (averageScore >= 100) {
								status = "Diamond";

							} else if ((averageScore < 100)
									&& (averageScore > 70)) {
								status = "Platinum";
							} else if ((averageScore < 70)
									&& (averageScore > 50)) {
								status = "Gold";
							} else if ((averageScore < 50)
									&& (averageScore > 20)) {
								status = "Bronze";
							} else if (averageScore < 20) {
								status = "Wooden Spoon";
							}
							
							
							annualSubmissionsReport.add(new BscSubmissionsAnnualBean(annualSubmissions.get(x).getSubDepartment(), annualSubmissions.get(x).getBscEmployeeName(),  averageScore, status));



						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out
									.println("Cannot connect to activity database here");
						}
					}
					
					
					request.setAttribute("annualSubmissionsReport", annualSubmissionsReport);

					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscSubmissionAnnualReport.jsp");
					view.forward(request, response);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			} finally {

				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
