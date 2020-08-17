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

/**
 * Servlet implementation class ProvisionsReport
 */
@WebServlet("/RiskReport")
public class RiskReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	ArrayList<AmlBean> amlList;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RiskReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		amlList = new ArrayList<AmlBean>();

		amlList.clear();

		con = connect();
		if (con != null) {

			String sql = "SELECT [year] ,[name],[branch] ,[department]  ,[totalScore]  FROM [SwaziBankIntranet2016].[dbo].[riskTest]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					String year = results.getString("year");
					String name = results.getString("name");
					String branch = results.getString("branch");
					String department = results.getString("department");
					int totalScore = Integer.valueOf(results.getInt("totalScore"));
					

					amlList.add(new AmlBean(year, name,branch, department,totalScore));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		request.setAttribute("amlList", amlList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources/riskReport.jsp");
		view.forward(request, response);

		try {
			disconnect(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PreparedStatement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		amlList.clear();

		amlList.clear();
		String name1 = request.getParameter("name");

		con = connect();
		if (con != null) {

			String sql = "SELECT [year] ,[name],[branch] ,[department]  ,[totalScore]  FROM [SwaziBankIntranet2016].[dbo].[riskTest] where name like ?";

			try {
				selectStatement = con.prepareStatement(sql);
				selectStatement.setString(1, '%' + name1 + '%');
				results = selectStatement.executeQuery();

				while (results.next()) {
					String year = results.getString("year");
					String name = results.getString("name");
					String branch = results.getString("branch");
					String department = results.getString("department");
					int totalScore = Integer.valueOf(results.getInt("totalScore"));

					amlList.add(new AmlBean(year, name,branch, department,totalScore));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		request.setAttribute("provisionList", amlList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/risk/riskReport.jsp");
		view.forward(request, response);
	}

	// ///////connect & disconnect /////////////
	public static Connection connect() {

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=SwaziBankIntranet2016;user=intranetUser;password=12345678=I";

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
