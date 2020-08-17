package technicalResources.SkillsAudits;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import util.ConnectionHelper;

/**
 * Servlet implementation class SkillsAuditEducationExperienceSkillsDashBoard
 */
@WebServlet("/SkillsAuditEducationExperienceSkillsDashBoard")
public class SkillsAuditEducationExperienceSkillsDashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	int yesEducation = 0;
	int noEducation = 0;

	int yesExperience = 0;
	int noExperience = 0;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sqlEducation = " Select category, 	sum(case when rating = 'Yes' then 1 else 0 end) 'Yes',	sum(case when rating = 'No' then 1 else 0 end) 'No' FROM [SwaziBankIntranet2016].[dbo].[SkillsAuditScores] 	where category = 'Education' group by category;";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sqlEducation);

				while (results.next()) {

					yesEducation = Integer.valueOf(results.getString("Yes"));
					noEducation = Integer.valueOf(results.getString("No"));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		String sqlExperience = " Select category, 	sum(case when rating = 'Yes' then 1 else 0 end) 'Yes',	sum(case when rating = 'No' then 1 else 0 end) 'No' FROM [SwaziBankIntranet2016].[dbo].[SkillsAuditScores] 	where category = 'Experience' group by category;";

		try {
			selectStatement = con.createStatement();
			results = selectStatement.executeQuery(sqlExperience);

			while (results.next()) {

				yesExperience = Integer.valueOf(results.getString("Yes"));
				noExperience = Integer.valueOf(results.getString("No"));

			}

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

		OutputStream out = response.getOutputStream();
		try {
			/* Step - 1: Define the data for the bar chart */
			DefaultCategoryDataset bar_chart_servlet = new DefaultCategoryDataset();

			bar_chart_servlet.addValue(yesEducation, "Yes", "Education");
			bar_chart_servlet.addValue(noEducation, "No", "Education");

			bar_chart_servlet.addValue(yesExperience, "Yes", "Experience");
			bar_chart_servlet.addValue(noExperience, "No", "Experience");

			/* Step -2:Define the JFreeChart object to create bar chart */
			JFreeChart BarChartObject = ChartFactory.createBarChart(
					"SwaziBank Experience and Education Overview",
					"Experience and Education", "Counts", bar_chart_servlet,
					PlotOrientation.VERTICAL, true, true, false);

			/* Step -3: Set the response type to PNG */
			response.setContentType("image/png"); /* Set the HTTP Response Type */

			/* Step -4: Write the response to the output stream */
			ChartUtilities.writeChartAsPNG(out, BarChartObject, 700, 700);
		} catch (Exception e) {
			System.err.println(e.toString()); /* Throw exceptions to log files */
		} finally {
			out.close();/* Close the output stream */
		}
	}
}
