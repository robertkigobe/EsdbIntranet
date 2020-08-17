package technicalResources.bsc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import util.ConnectionHelper;

/**
 * Servlet implementation class HealthSafetyMain
 */
@WebServlet("/BscSearchReportsSubDepartments")
public class BscSearchReportsSubDepartments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	public static String filename;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;

		String subDepartment = request.getParameter("subDepartment");
		String bscPeriod = request.getParameter("bscPeriod");
		String positions = request.getParameter("position");
		String bscEmployeeName = request.getParameter("bscEmployeeName");
		DecimalFormat df = new DecimalFormat("###.##");
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
		
		

		ArrayList<BscReportsBean> departmentReport = new ArrayList<BscReportsBean>();

		departmentReport.clear();

		// /////////////date insert///////////////////
		Date printDate = new Date();
		String printDateValue = sdf.format(printDate);
		// /////////////date insert///////////////////

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			
			

			if ((!bscPeriod.equals("Choose Period"))
					&&(!bscPeriod.equals("2017-2018"))
					&&(!bscPeriod.equals("Quarter 3 2017-2018"))
					&&(!bscPeriod.equals("Quarter 4 2017-2018"))
					&& (positions.equals("Choose Position"))
					&& (bscEmployeeName.equals("Choose Employee"))) {
				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscPeriod] =  '"
						+ bscPeriod
						+ "' and [reportingFrequencies] = 'Monthly' and [subDepartment] = '"
						+ subDepartment
						+ "'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {

						perspective = results.getString("perspective");
						objective = results.getString("objective");
						period = results.getString("period");
						reportingFrequencies = results
								.getString("reportingFrequencies");
						measure = results.getString("measure");
						base = Float.valueOf(results.getString("base"));
						stretch = Float.valueOf(results.getString("stretch"));
						actual = Float.valueOf(results.getString("actual"));
						if ((stretch - base) != 0) {
							archievementRatio = ((actual - base) / (stretch - base)) * 100;
						} else {
							archievementRatio = 0;
						}

						if (archievementRatio >= 100) {
							status = "Diamond";
						} else if ((archievementRatio < 100)
								&& (archievementRatio >= 70)) {
							status = "Platinum";
						} else if ((archievementRatio < 70)
								&& (archievementRatio >= 50)) {
							status = "Gold";
						} else if ((archievementRatio < 50)
								&& (archievementRatio >= 20)) {
							status = "Bronze";
						} else if (archievementRatio < 20) {
							status = "Wooden Spoon";
						}

						totalScore += archievementRatio;

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			} else if ((bscPeriod.equals("Choose Period"))
					&&(!bscPeriod.equals("2017-2018"))
					&&(!bscPeriod.equals("Quarter 3 2017-2018"))
					&&(!bscPeriod.equals("Quarter 4 2017-2018"))
					&& (!positions.equals("Choose Position"))
					&& (bscEmployeeName.equals("Choose Employee"))) {
				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [position] =  '"
						+ positions
						+ "' and [reportingFrequencies] = 'Monthly' and [subDepartment] = '"
						+ subDepartment
						+ "'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {

						perspective = results.getString("perspective");
						objective = results.getString("objective");
						period = results.getString("period");
						reportingFrequencies = results
								.getString("reportingFrequencies");
						measure = results.getString("measure");
						base = Float.valueOf(results.getString("base"));
						stretch = Float.valueOf(results.getString("stretch"));
						actual = Float.valueOf(results.getString("actual"));
						if ((stretch - base) != 0) {
							archievementRatio = ((actual - base) / (stretch - base)) * 100;
						} else {
							archievementRatio = 0;
						}

						if (archievementRatio >= 100) {
							status = "Diamond";
						} else if ((archievementRatio < 100)
								&& (archievementRatio >= 70)) {
							status = "Platinum";
						} else if ((archievementRatio < 70)
								&& (archievementRatio >= 50)) {
							status = "Gold";
						} else if ((archievementRatio < 50)
								&& (archievementRatio >= 20)) {
							status = "Bronze";
						} else if (archievementRatio < 20) {
							status = "Wooden Spoon";
						}

						totalScore += archievementRatio;

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}

			else if ((bscPeriod.equals("Choose Period")) 
					&&(!bscPeriod.equals("2017-2018"))
					&&(!bscPeriod.equals("Quarter 3 2017-2018"))
					&&(!bscPeriod.equals("Quarter 4 2017-2018"))
					&& (positions.equals("Choose Position"))
					&& (!bscEmployeeName.equals("Choose Employee"))) {
				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscEmployeeName] =  '"
						+ bscEmployeeName
						+ "' and [reportingFrequencies] = 'Monthly' and [subDepartment] = '"
						+ subDepartment
						+ "'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {

						perspective = results.getString("perspective");
						objective = results.getString("objective");
						period = results.getString("period");
						reportingFrequencies = results
								.getString("reportingFrequencies");
						measure = results.getString("measure");
						base = Float.valueOf(results.getString("base"));
						stretch = Float.valueOf(results.getString("stretch"));
						actual = Float.valueOf(results.getString("actual"));
						if ((stretch - base) != 0) {
							archievementRatio = ((actual - base) / (stretch - base)) * 100;
						} else {
							archievementRatio = 0;
						}

						if (archievementRatio >= 100) {
							status = "Diamond";
						} else if ((archievementRatio < 100)
								&& (archievementRatio >= 70)) {
							status = "Platinum";
						} else if ((archievementRatio < 70)
								&& (archievementRatio >= 50)) {
							status = "Gold";
						} else if ((archievementRatio < 50) && (archievementRatio >= 20)) {
							status = "Bronze";
						} else if (archievementRatio < 20) {
							status = "Wooden Spoon";
						}

						totalScore += archievementRatio;

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			} else if ((!bscPeriod.equals("Choose Period")) 
					&&(!bscPeriod.equals("2017-2018"))
					&&(!bscPeriod.equals("Quarter 3 2017-2018"))
					&&(!bscPeriod.equals("Quarter 4 2017-2018"))
					&& (!positions.equals("Choose Position"))
					&& (bscEmployeeName.equals("Choose Employee"))

			) {
				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscPeriod] =  '"
						+ bscPeriod
						+ "' and [position] =  '"
						+ positions
						+ "' and [reportingFrequencies] = 'Monthly' and [subDepartment] = '"
						+ subDepartment
						+ "'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {

						perspective = results.getString("perspective");
						objective = results.getString("objective");
						period = results.getString("period");
						reportingFrequencies = results
								.getString("reportingFrequencies");
						measure = results.getString("measure");
						base = Float.valueOf(results.getString("base"));
						stretch = Float.valueOf(results.getString("stretch"));
						actual = Float.valueOf(results.getString("actual"));
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

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			} else if ((!bscPeriod.equals("Choose Period")) 
					&&(!bscPeriod.equals("2017-2018"))
					&&(!bscPeriod.equals("Quarter 3 2017-2018"))
					&&(!bscPeriod.equals("Quarter 4 2017-2018"))
					&& (!bscEmployeeName.equals("Choose Employee"))

			) {
				String sql = "SELECT  [perspective]  ,[objective]  ,[period] ,[reportingFrequencies]  ,[measure]  ,avg([base]) as 'base'  ,avg([stretch]) as 'stretch' ,avg([actual]) as 'actual' FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] "
						+ "where [bscPeriod] =  '"
						+ bscPeriod
						+ "' and  [bscEmployeeName] = '"
						+ bscEmployeeName
						+ "' and [reportingFrequencies] = 'Monthly' and [subDepartment] = '"
						+ subDepartment
						+ "'"
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure] ORDER BY CASE [perspective]WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {

						perspective = results.getString("perspective");
						objective = results.getString("objective");
						period = results.getString("period");
						reportingFrequencies = results
								.getString("reportingFrequencies");
						measure = results.getString("measure");
						base = Float.valueOf(results.getString("base"));
						stretch = Float.valueOf(results.getString("stretch"));
						actual = Float.valueOf(results.getString("actual"));
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

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			
			
			
			else if ((bscPeriod.equals("Quarter 3 2017-2018"))
					&& (!bscEmployeeName.equals("Choose Employee"))

			) {
				
				
				String sql = " select "
						+ "[perspective],	"
						+ "[objective],"
						+ "[period],"
						+ "[reportingFrequencies],"
						+ "[measure],"
						+ "[base],"
						+ "[stretch], "
						+ "[actual]  "
						+ "from ("
						+ "SELECT    "
						+ "[perspective],"
						+ "[objective],"
						+ "[period],"
						+ "[reportingFrequencies],"
						+ "[measure],"
						+ "avg([base]) as 'base',"
						+ "avg([stretch]) as 'stretch',"
						+ "avg([actual]) as 'actual'    "
						+ "FROM "
						+ "[SwaziBankIntranet2016].[dbo].[bscSDSBScores]   "
						+ "where    "
						+ "[bscEmployeeName] = '"+bscEmployeeName+"' "
						+ "and [reportingFrequencies] = 'Monthly' "
						+ "and [subDepartment] = '"+ subDepartment+"' "
						+ "and bscPeriod IN ('October 2017','December 2017','November 2017') "
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure]  "
						+ "union     "
						+ "select   [perspective]  ,[objective] ,[period]  ,[reportingFrequencies]  ,[measure]  ,[base]  ,[stretch]  ,[actual]  "
						+ "FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores]  "
						+ "where bscEmployeeName = '"+bscEmployeeName+"' and bscPeriod = 'Quarter 3 2017-2018'  and [subDepartment] = '"+ subDepartment+"')  "
						+ "results  "
						+ "ORDER BY "
						+ "CASE [perspective]  WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {

						perspective = results.getString("perspective");
						
						objective = results.getString("objective");
						period = results.getString("period");
						reportingFrequencies = results
								.getString("reportingFrequencies");
						measure = results.getString("measure");
						base = Float.valueOf(results.getString("base"));
						stretch = Float.valueOf(results.getString("stretch"));
						actual = Float.valueOf(results.getString("actual"));
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

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			else if ((bscPeriod.equals("Quarter 4 2017-2018"))
					&& (!bscEmployeeName.equals("Choose Employee"))

			) {
				
				
				String sql = " select "
						+ "[perspective],	"
						+ "[objective],"
						+ "[period],"
						+ "[reportingFrequencies],"
						+ "[measure],"
						+ "[base],"
						+ "[stretch], "
						+ "[actual]  "
						+ "from ("
						+ "SELECT    "
						+ "[perspective],"
						+ "[objective],"
						+ "[period],"
						+ "[reportingFrequencies],"
						+ "[measure],"
						+ "avg([base]) as 'base',"
						+ "avg([stretch]) as 'stretch',"
						+ "avg([actual]) as 'actual'    "
						+ "FROM "
						+ "[SwaziBankIntranet2016].[dbo].[bscSDSBScores]   "
						+ "where    "
						+ "[bscEmployeeName] = '"+bscEmployeeName+"' "
						+ "and [reportingFrequencies] = 'Monthly' "
						+ "and [subDepartment] = '"+ subDepartment+"' "
						+ "and bscPeriod IN ('January 2018','February 2018','March 2018') "
						+ "Group by  [perspective],[objective],[period],[reportingFrequencies],[measure]  "
						+ "union     "
						+ "select   [perspective]  ,[objective] ,[period]  ,[reportingFrequencies]  ,[measure]  ,[base]  ,[stretch]  ,[actual]  "
						+ "FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores]  "
						+ "where bscEmployeeName = '"+bscEmployeeName+"' and bscPeriod = 'Quarter 4 2017-2018'  and [subDepartment] = '"+ subDepartment+"')  "
						+ "results  "
						+ "ORDER BY "
						+ "CASE [perspective]  WHEN 'Financial'  THEN '0'WHEN 'Customer' THEN '1'WHEN 'Internal Business Processes '  THEN '2' WHEN 'Learning and Growth' THEN '3'ELSE [perspective] END";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {

						perspective = results.getString("perspective");
						
						objective = results.getString("objective");
						period = results.getString("period");
						reportingFrequencies = results
								.getString("reportingFrequencies");
						measure = results.getString("measure");
						base = Float.valueOf(results.getString("base"));
						stretch = Float.valueOf(results.getString("stretch"));
						actual = Float.valueOf(results.getString("actual"));
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

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			else if ((bscPeriod.equals("2017-2018"))
					&& (!bscEmployeeName.equals("Choose Employee"))

			) {
				
				
				String sql = "select "
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
						+ "where    "
						+ "[bscEmployeeName] = '"+bscEmployeeName+"' "
						+ "and [reportingFrequencies] = 'Monthly' "
						+ "and [subDepartment] = '"+ subDepartment+"' "
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
						+ "where bscEmployeeName = '"+bscEmployeeName+"' "
						+ "and bscPeriod in ( 'Quarter 3 2017-2018','Quarter 4 2017-2018')   "
						+ "and [subDepartment] = '"+ subDepartment+"' "
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
						+ "[bscEmployeeName] = '"+bscEmployeeName+"' "
						+ "and [reportingFrequencies] = 'Yearly' "
						+ "and [subDepartment] = '"+ subDepartment+"' "
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
					results = selectStatement.executeQuery(sql);

					while (results.next()) {

						perspective = results.getString("perspective");
						
						objective = results.getString("objective");
						period = results.getString("period");
						reportingFrequencies = results
								.getString("reportingFrequencies");
						measure = results.getString("measure");
						base = Float.valueOf(results.getString("base"));
						stretch = Float.valueOf(results.getString("stretch"));
						actual = Float.valueOf(results.getString("actual"));
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

						departmentReport.add(new BscReportsBean(perspective,
								objective, period, reportingFrequencies,
								measure, base, stretch, actual,
								archievementRatio, totalScore, averageScore,
								status));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}

		}

		if (bscPeriod.contains("Choose")) {
			bscPeriod = "No Period Specified";
		}
		if (positions.contains("Choose")) {
			positions = "No positions Specified";
		}

		if (bscEmployeeName.contains("Choose")) {
			bscEmployeeName = "No Employee Specified";
		}

		averageScore = totalScore / departmentReport.size();

		Document document = new Document(PageSize.A3.rotate());

		try {

			response.setContentType("application/pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();

			PdfPTable tableH = new PdfPTable(2);
			tableH.setWidths(new int[] { 12, 15 });
			tableH.setWidthPercentage(30);
			tableH.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableH.setSpacingBefore(10);
			tableH.getDefaultCell().setBorder(Rectangle.BOX);

			tableH.addCell("Department");
			tableH.addCell(subDepartment);
			tableH.addCell("Report Period");
			tableH.addCell(bscPeriod);
			tableH.addCell("Employee Position");
			tableH.addCell(positions);
			tableH.addCell("Employee Name");
			tableH.addCell(bscEmployeeName);
			tableH.addCell("Average Score");

			PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(df
					.format(averageScore)) + "%"));
			if (averageScore < 0) {
				cell.setBackgroundColor(BaseColor.RED);
			} else if (averageScore > 100) {
				cell.setBackgroundColor(BaseColor.GREEN);
			} else {
				cell.setBackgroundColor(BaseColor.YELLOW);
			}
			tableH.addCell(cell);

			PdfPTable table = new PdfPTable(10);
			table.setWidths(new int[] { 12, 15, 6, 9, 21, 5, 5, 5, 5, 8 });
			table.setWidthPercentage(100);
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.setSpacingBefore(10);
			table.getDefaultCell().setBorder(Rectangle.BOX);
			// //// add table array

			table.addCell("Perspective");
			table.addCell("Objective");
			table.addCell("Period");
			table.addCell("Reporting Frequency");
			table.addCell("Measure");
			table.addCell("Base");
			table.addCell("Stretch");
			table.addCell("Actual");
			table.addCell("Achievement");
			table.addCell("Status");

			for (BscReportsBean saRow : departmentReport) {

				table.addCell(saRow.getPerspective());
				table.addCell(saRow.getObjective());
				table.addCell(saRow.getPeriod());
				table.addCell(saRow.getReportingFrequencies());
				table.addCell(saRow.getMeasure());
				table.addCell(String.valueOf(saRow.getBase()));
				table.addCell(String.valueOf(saRow.getStretch()));
				table.addCell(String.valueOf(df.format(saRow.getActual())));
				table.addCell(String.valueOf(df.format(saRow
						.getArchievementRatio() + 0.0)) + "%");
				table.addCell(saRow.getStatus());

			}

			PdfPTable tableS = new PdfPTable(6);
			tableS.setWidths(new int[] { 20, 20, 15, 20, 15, 20 });
			tableS.setWidthPercentage(100);
			tableS.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableS.setSpacingBefore(20);
			tableS.getDefaultCell().setBorder(Rectangle.BOX);

			tableS.addCell("Created by Employee");
			tableS.addCell(bscEmployeeName);
			tableS.addCell("Signature");
			tableS.addCell("___________________");
			tableS.addCell("Print Date");
			tableS.addCell(printDateValue);
			tableS.addCell("Employee Supervisor");
			tableS.addCell("___________________");
			tableS.addCell("Signature");
			tableS.addCell("___________________");
			tableS.addCell("Print Date");
			tableS.addCell("___________________");
			tableS.addCell("Deprtment Head/ Branch manager");
			tableS.addCell("___________________");
			tableS.addCell("Signature");
			tableS.addCell("___________________");
			tableS.addCell("Print Date");
			tableS.addCell("___________________");
			tableS.addCell("Executive Manager");
			tableS.addCell("___________________");
			tableS.addCell("Signature");
			tableS.addCell("___________________");
			tableS.addCell("Print Date");
			tableS.addCell("___________________");

			document.add(tableH);

			document.add(table);

			document.add(tableS);

		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
