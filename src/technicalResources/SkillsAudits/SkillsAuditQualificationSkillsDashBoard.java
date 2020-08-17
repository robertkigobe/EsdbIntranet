package technicalResources.SkillsAudits;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import util.ConnectionHelper;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BasicStroke;
import java.awt.Color;

/**
 * Servlet implementation class SkillsDashBoard
 */
@WebServlet("/SkillsAuditQualificationSkillsDashBoard")
public class SkillsAuditQualificationSkillsDashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	float UnderQualified = 0;
	float OverQualified  = 0;
	float AdequatelyQualified  = 0;
	float total = 0;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		


		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "Select category, sum(case when rating = 'Under Qualified' then 1 else 0 end) 'UnderQualified',   sum(case when rating = 'Over Qualified' then 1 else 0 end) 'OverQualified', sum(case when rating = 'Adequately Qualified' then 1 else 0 end) 'AdequatelyQualified' FROM [SwaziBankIntranet2016].[dbo].[SkillsAuditScores] where category = 'Qualifications' group by category;";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					
					 UnderQualified = Float.valueOf(results.getString("UnderQualified"));
					 OverQualified = Float.valueOf(results.getString("OverQualified"));					
					 AdequatelyQualified = Float.valueOf(results.getString("AdequatelyQualified"));
					 
				}
				
				 total = UnderQualified + UnderQualified + AdequatelyQualified;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		JFreeChart chart = getChart();
		int width = 800;
		int height = 850;
		ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);	

	}

	public JFreeChart getChart() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Over Qualified", OverQualified);
		dataset.setValue("Under Qualified", UnderQualified);
		dataset.setValue("Adequately Qualified", AdequatelyQualified);

		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart("SwaziBank Qualifications Overview",
				dataset, legend, tooltips, urls);

		chart.setBorderPaint(Color.BLACK);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);

		return chart;
	}

}
