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
@WebServlet("/SkillsAuditPersonalSkillsDashBoard")
public class SkillsAuditPersonalSkillsDashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	float Excellent = 0;
	float Good  = 0;
	float Fair  = 0;
	float Poor  = 0;



	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		


		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "Select category,  sum(case when rating = 'Excellent' then 1 else 0 end) 'Excellent',    sum(case when rating = 'Good' then 1 else 0 end) 'Good',  sum(case when rating = 'Fair' then 1 else 0 end) 'Fair', sum(case when rating = 'Poor' then 1 else 0 end) 'Poor'  FROM [SwaziBankIntranet2016].[dbo].[SkillsAuditScores] where category = 'Personal Attributes' group by category;";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					
					Poor = Float.valueOf(results.getString("Poor"));
					Excellent = Float.valueOf(results.getString("Excellent"));					
					Good = Float.valueOf(results.getString("Good"));
					Fair = Float.valueOf(results.getString("Fair"));

					 
				}
				
				

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
		dataset.setValue("Excellent", Excellent);
		dataset.setValue("Good", Good);
		dataset.setValue("Fair", Fair);
		dataset.setValue("Poor", Poor);


		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart("SwaziBank Personal Skills Overview",
				dataset, legend, tooltips, urls);

		chart.setBorderPaint(Color.BLACK);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);

		return chart;
	}

}
