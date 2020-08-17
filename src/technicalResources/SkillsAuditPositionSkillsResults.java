package technicalResources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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



/**
 * Servlet implementation class BscPositionScoreParameters
 */
@WebServlet("/SkillsAuditPositionSkillsResults")
public class SkillsAuditPositionSkillsResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	String remarks;
	String position;
	String name ;
	String usedName;
	String category;
	String item;
	String rating;
	String priority;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ArrayList<PositionBean> positionSkillsAudit = new ArrayList<PositionBean>();
		positionSkillsAudit.clear();

		con = connect();
		if (con != null) {

			String sql = "SELECT  distinct ([name]) FROM [SwaziBankSkillsAudit2017].[dbo].[skillsAudit] ";
			

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String position = "test";
					String name = results.getString("name");
					String category = "test";
					String item = "test";
					String rating = "test";
					String priority = "test";
					String remarks = "test";

					positionSkillsAudit.add(new PositionBean(position,
							name,userName, category, item, rating,
							priority, remarks));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		request.setAttribute("positionSkillsAudit", positionSkillsAudit);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/views/positionSkillsResults.jsp");
		view.forward(request, response);

		try {
			disconnect(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		java.sql.PreparedStatement selectStatement = null;
		ResultSet results = null;

		ArrayList<PositionBean> positionSkillsAudit = new ArrayList<PositionBean>();
		positionSkillsAudit.clear();
		String nameP = request.getParameter("name");
		con = connect();
		if (con != null) {

			String sql = "SELECT [id],[position],[name] ,[userName],[category] ,[item] ,[rating] ,[priority]  FROM [SwaziBankSkillsAudit2017].[dbo].[skillsAudit] where [name] like ? order by id";

			try {
				selectStatement = con.prepareStatement(sql);
				selectStatement.setString(1, "%" + nameP + "%");

				results = selectStatement.executeQuery();

				while (results.next()) {

					
					
					 position = results.getString("position");
					 name = results.getString("name");
					 usedName = results.getString("userName"); 
					 category = results.getString("category");
					 item = results.getString("item");
					 rating = results.getString("rating");
					 priority = results.getString("priority");
					 
					if(rating.equals("Poor") && priority.equals("Low")){
						remarks = "Decision to be taken by HR"; 
					} else if (rating.equals("master & trainer") && priority.equals("High")){
						
						remarks = "Decision  to be taken by Human Resources";
					} else 
					{
						remarks = "Decision  to be taken by Human Resources";
					}

					positionSkillsAudit.add(new PositionBean(position,
							name, usedName, category, item, rating,
							priority, remarks));
				}
				
				request.setAttribute("name", name);
				request.setAttribute("usedName", usedName);
				request.setAttribute("position", position);
				request.setAttribute("positionSkillsAudit",
						positionSkillsAudit);
				String userName = System.getProperty("user.name");
				request.setAttribute("userName", userName);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/views/bscPositionScoreCard.jsp");
				view.forward(request, response);

				try {
					disconnect(con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

	}

	// ///////connect & disconnect /////////////
	public static Connection connect() {

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=SwaziBankSkillsAudit2017;user=intranetUser;password=12345678=I";

		// Declare the JDBC objects.

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = (Connection) DriverManager.getConnection(connectionUrl);
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void disconnect(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

}
