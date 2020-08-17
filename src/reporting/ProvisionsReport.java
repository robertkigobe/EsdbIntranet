package reporting;

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
@WebServlet("/ProvisionsReport")
public class ProvisionsReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	ArrayList<ProvisionBean> provisionList;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProvisionsReport() {
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

		provisionList = new ArrayList<ProvisionBean>();

		provisionList.clear();

		con = connect();
		if (con != null) {

			String sql = "SELECT [YEAR],[QUARTER] ,[AccNo] ,[CONTRACT_IDs]  ,[DrawDown_link] ,[Branch] ,[Dept] ,[Customer] ,[Type] ,[YearEndBalance] ,[YearEndRate] ,[YearEndProv]  ,[CurrentBalance] ,[CurrentRate] ,[SECURITY] ,[CurrentProvisions] ,[PastDues],[Comments],[OLD_ACCT]  FROM [SwaziBankIntranet2016].[dbo].[Final_Provisions_Report2]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					String year = results.getString("YEAR");
					String quater = results.getString("QUARTER");
					String AccNo = results.getString("AccNo");
					String contractIds = results.getString("CONTRACT_IDs");
					String drawdownLink = results.getString("DrawDown_link");
					String branch = results.getString("Branch");
					String dept = results.getString("Dept");
					String customer = results.getString("Customer");
					String type = results.getString("Type");
					String yearEndBalance = results.getString("YearEndBalance");
					String yearEndRate = results.getString("YearEndRate");
					String yearEndProvision = results.getString("YearEndProv");
					String currentBalance = results.getString("CurrentBalance");
					String currentRate = results.getString("CurrentRate");
					String security = results.getString("SECURITY");
					String currentProvisions = results
							.getString("CurrentProvisions");
					String pastDues = results.getString("PastDues");
					String comments = results.getString("Comments");
					String oldAccount = results.getString("OLD_ACCT");

					provisionList.add(new ProvisionBean(year, quater, AccNo,
							contractIds, drawdownLink, branch, dept, customer,
							type, yearEndBalance, yearEndRate,
							yearEndProvision, currentBalance, currentRate,
							security, currentProvisions, pastDues, comments,
							oldAccount));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		request.setAttribute("provisionList", provisionList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/reports/provisions.jsp");
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

		provisionList.clear();

		provisionList.clear();
		String seachAccount = request.getParameter("seachAccount");

		con = connect();
		if (con != null) {

			String sql = "SELECT [YEAR],[QUARTER] ,[AccNo] ,[CONTRACT_IDs]  ,[DrawDown_link] ,[Branch] ,[Dept] ,[Customer] ,[Type] ,[YearEndBalance] ,[YearEndRate] ,[YearEndProv]  ,[CurrentBalance] ,[CurrentRate] ,[SECURITY] ,[CurrentProvisions] ,[PastDues],[Comments],[OLD_ACCT]  FROM [SwaziBankIntranet2016].[dbo].[Final_Provisions_Report2] where [AccNo] like ?";

			try {
				selectStatement = con.prepareStatement(sql);
				selectStatement.setString(1, '%' + seachAccount + '%');
				results = selectStatement.executeQuery();

				while (results.next()) {
					String year = results.getString("YEAR");
					String quater = results.getString("QUARTER");
					String AccNo = results.getString("AccNo");
					String contractIds = results.getString("CONTRACT_IDs");
					String drawdownLink = results.getString("DrawDown_link");
					String branch = results.getString("Branch");
					String dept = results.getString("Dept");
					String customer = results.getString("Customer");
					String type = results.getString("Type");
					String yearEndBalance = results.getString("YearEndBalance");
					String yearEndRate = results.getString("YearEndRate");
					String yearEndProvision = results.getString("YearEndProv");
					String currentBalance = results.getString("CurrentBalance");
					String currentRate = results.getString("CurrentRate");
					String security = results.getString("SECURITY");
					String currentProvisions = results
							.getString("CurrentProvisions");
					String pastDues = results.getString("PastDues");
					String comments = results.getString("Comments");
					String oldAccount = results.getString("OLD_ACCT");

					provisionList.add(new ProvisionBean(year, quater, AccNo,
							contractIds, drawdownLink, branch, dept, customer,
							type, yearEndBalance, yearEndRate,
							yearEndProvision, currentBalance, currentRate,
							security, currentProvisions, pastDues, comments,
							oldAccount));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		request.setAttribute("provisionList", provisionList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/reports/provisions.jsp");
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
