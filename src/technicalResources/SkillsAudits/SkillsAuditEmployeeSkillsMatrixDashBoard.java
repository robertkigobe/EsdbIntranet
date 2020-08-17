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
@WebServlet("/SkillsAuditEmployeeSkillsMatrixDashBoard")
public class SkillsAuditEmployeeSkillsMatrixDashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	float Beginner = 0;
	float Advanced  = 0;
	float Intermediate  = 0;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "Select category, sum(case when rating = 'Beginner' then 1 else 0 end) 'Beginner',   sum(case when rating = 'Intermediate' then 1 else 0 end) 'Intermediate', sum(case when rating = 'Advanced' then 1 else 0 end) 'Advanced' FROM [SwaziBankIntranet2016].[dbo].[SkillsAuditScores] where category = 'Technical knowledge' group by category;";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					
					Beginner = Float.valueOf(results.getString("Beginner"));
					Advanced = Float.valueOf(results.getString("Advanced"));					
					Intermediate = Float.valueOf(results.getString("Intermediate"));
					 
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
		dataset.setValue("Beginner", Beginner);
		dataset.setValue("Advanced", Advanced);
		dataset.setValue("Intermediate", Intermediate);

		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart("SwaziBank Technical Skills Overview",
				dataset, legend, tooltips, urls);

		chart.setBorderPaint(Color.BLACK);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);

		return chart;
	}

}
