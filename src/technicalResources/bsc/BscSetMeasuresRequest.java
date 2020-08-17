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

@WebServlet("/BscSetMeasuresRequest")
public class BscSetMeasuresRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		String position = null;
		String measure = null;
		String measureDesciption  = null;
		String perspective  = null;

		ArrayList<BscMeasureBean> measureList = new ArrayList<BscMeasureBean>();

		measureList.clear();
		measureList.add(new BscMeasureBean("Choose Positions", null, null, null));
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT Distinct [Position]  FROM [dbo].[bscMetrics] order by [position]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);
				while (results.next()) {
					 position = results.getString("position");
					measureList.add(new BscMeasureBean( position,measure, measureDesciption, perspective));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		request.setAttribute("position", position);
		request.setAttribute("measureList", measureList);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscMeasureRequest.jsp");
		view.forward(request, response);
		
	
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
