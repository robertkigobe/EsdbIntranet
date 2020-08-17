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
@WebServlet("/SavingsAccountsReport")
public class SavingsAccountsReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	ArrayList<SavingsAccountsBean> savingsAccountsList;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SavingsAccountsReport() {
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

		savingsAccountsList = new ArrayList<SavingsAccountsBean>();

		savingsAccountsList.clear();

		con = connect();
		if (con != null) {

			String sql = "SELECT  [account]      ,[custid]      ,[custname]      ,[sex]      ,[date_0f_birth]      ,[sector]      ,[industry]     ,[inactive]      ,[branch]      ,[category]      ,[description]      ,[os_principal]      ,[os_interest]      ,[pd_principal]      ,[pd_intchgs]      ,[total]      ,[created]      ,[maturity]      ,[terms]      ,[month_total]      ,[movement]  FROM [SwaziBankIntranet2016].[dbo].[SavingsAccs]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					String account = results.getString("account");
					String custid = results.getString("custid");
					String custname = results.getString("custname");
					String sex = results.getString("sex");
					String date_0f_birth = results.getString("date_0f_birth");
					String sector = results.getString("sector");
					String industry = results.getString("industry");
					String inactive = results.getString("inactive");
					String branch = results.getString("branch");
					String category = results.getString("category");
					String description = results.getString("description");
					String os_principal = results.getString("os_principal");
					String os_interest = results.getString("os_interest");
					String pd_principal = results.getString("pd_principal");
					String pd_intchgs = results.getString("pd_intchgs");
					String total = results.getString("total");
					String created = results.getString("created");
					String maturity = results.getString("maturity");
					String terms = results.getString("terms");
					String month_total = results.getString("month_total");
					String movement = results.getString("movement");

					savingsAccountsList.add(new SavingsAccountsBean(account,
							custid, custname, sex, date_0f_birth, sector,
							industry, inactive, branch, category, description,
							os_principal, os_interest, pd_principal,
							pd_intchgs, total, created, maturity, terms,
							month_total, movement));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		request.setAttribute("savingsAccountsList", savingsAccountsList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/reports/savingsAccounts.jsp");
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

		savingsAccountsList.clear();

		savingsAccountsList.clear();
		String seachAccount = request.getParameter("seachAccount");

		con = connect();
		if (con != null) {

			String sql = "SELECT  [account]      ,[custid]      ,[custname]      ,[sex]      ,[date_0f_birth]      ,[sector]      ,[industry]     ,[inactive]      ,[branch]      ,[category]      ,[description]      ,[os_principal]      ,[os_interest]      ,[pd_principal]      ,[pd_intchgs]      ,[total]      ,[created]      ,[maturity]      ,[terms]      ,[month_total]      ,[movement]  FROM [SwaziBankIntranet2016].[dbo].[SavingsAccs] where [account] like ?";

			try {
				selectStatement = con.prepareStatement(sql);
				selectStatement.setString(1, '%' + seachAccount + '%');
				results = selectStatement.executeQuery();

				while (results.next()) {
					String account = results.getString("account");
					String custid = results.getString("custid");
					String custname = results.getString("custname");
					String sex = results.getString("sex");
					String date_0f_birth = results.getString("date_0f_birth");
					String sector = results.getString("sector");
					String industry = results.getString("industry");
					String inactive = results.getString("inactive");
					String branch = results.getString("branch");
					String category = results.getString("category");
					String description = results.getString("description");
					String os_principal = results.getString("os_principal");
					String os_interest = results.getString("os_interest");
					String pd_principal = results.getString("pd_principal");
					String pd_intchgs = results.getString("pd_intchgs");
					String total = results.getString("total");
					String created = results.getString("created");
					String maturity = results.getString("maturity");
					String terms = results.getString("terms");
					String month_total = results.getString("month_total");
					String movement = results.getString("movement");

					savingsAccountsList.add(new SavingsAccountsBean(account,
							custid, custname, sex, date_0f_birth, sector,
							industry, inactive, branch, category, description,
							os_principal, os_interest, pd_principal,
							pd_intchgs, total, created, maturity, terms,
							month_total, movement));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		request.setAttribute("provisionList", savingsAccountsList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/reports/savingsAccounts.jsp");
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
