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
@WebServlet("/AaLoanAgeAnalysisReport")
public class AaLoanAgeAnalysisReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	ArrayList<AaLoanAgeAnalysisBean> aaLoansList;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AaLoanAgeAnalysisReport() {
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

		aaLoansList = new ArrayList<AaLoanAgeAnalysisBean>();

		aaLoansList.clear();

		con = connect();
		if (con != null) {

			String sql = "SELECT [Branch],[LoanId],[Category],[CategroyDescription],[CustomerID],[CustomerName],[Currency],[Product],"
					+ "[ValueDate],[MaturityDate],[PrincipalBalance],[OverdueInterest],[OverduePrincipal],[OverduePenalty],[OverdueMonthlyFee],"
					+ "[TotalOverdues],[0DAYS] ,[(1-10)Days],[(11-30)Days],[(31-60)Days],[(61-89)Days],[(90-180)Days],[(181-365)Days],[366DaysAbove],"
					+ "[DueSPOverdue],[GrcSPOverdue],[Pd1SPOverdue],[Pd2Overdue],[Pd3SPOverdue],[Na1SPOverdue],[Na2SPOverdue],[Na3SPOverdue],[TotalDuesClass],"
					+ "[TotalExposure],[PeriodicPrincipal],[PeriodicInterest],[TotalPeriodic],[DisbursementAccount],[SettlementAccount],[LoanStatus] FROM [SwaziBankIntranet2016].[dbo].[AALoanAgeAnalysis]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String Branch = results.getString("Branch");
					String LoanId = results.getString("LoanId");
					String Category = results.getString("Category");
					String CategroyDescription = results
							.getString("CategroyDescription");
					String CustomerID = results.getString("CustomerID");
					String CustomerName = results.getString("CustomerName");
					String Currency = results.getString("Currency");
					String Product = results.getString("Product");
					String ValueDate = results.getString("ValueDate");
					String MaturityDate = results.getString("MaturityDate");
					String PrincipalBalance = results
							.getString("PrincipalBalance");
					String OverdueInterest = results
							.getString("OverdueInterest");
					String OverduePrincipal = results
							.getString("OverduePrincipal");
					String OverduePenalty = results.getString("OverduePenalty");
					String OverdueMonthlyFee = results
							.getString("OverdueMonthlyFee");
					String TotalOverdues = results.getString("TotalOverdues");
					String days0 = results.getString("0DAYS");
					String days1to10 = results.getString("(1-10)Days");
					String days11to30 = results.getString("(11-30)Days");
					String days31to60 = results.getString("(31-60)Days");
					String days61to89 = results.getString("(61-89)Days");
					String days90to180 = results.getString("(90-180)Days");
					String days181to365 = results.getString("(181-365)Days");
					String days366Above = results.getString("366DaysAbove");
					String DueSPOverdue = results.getString("DueSPOverdue");
					String GrcSPOverdue = results.getString("GrcSPOverdue");
					String Pd1SPOverdue = results.getString("Pd1SPOverdue");
					String Pd2Overdue = results.getString("Pd2Overdue");
					String Pd3SPOverdue = results.getString("Pd3SPOverdue");
					String Na1SPOverdue = results.getString("Na1SPOverdue");
					String Na2SPOverdue = results.getString("Na2SPOverdue");
					String Na3SPOverdue = results.getString("Na3SPOverdue");
					String TotalDuesClass = results.getString("TotalDuesClass");
					String TotalExposure = results.getString("TotalExposure");
					String PeriodicPrincipal = results
							.getString("PeriodicPrincipal");
					String PeriodicInterest = results
							.getString("PeriodicInterest");
					String TotalPeriodic = results.getString("TotalPeriodic");
					String DisbursementAccount = results
							.getString("DisbursementAccount");
					String SettlementAccount = results
							.getString("SettlementAccount");
					String LoanStatus = results.getString("LoanStatus");

					aaLoansList
							.add(new AaLoanAgeAnalysisBean(Branch, LoanId,
									Category, CategroyDescription, CustomerID,
									CustomerName, Currency, Product, ValueDate,
									MaturityDate, PrincipalBalance,
									OverdueInterest, OverduePrincipal,
									OverduePenalty, OverdueMonthlyFee,
									TotalOverdues, days0, days1to10,
									days11to30, days31to60, days61to89,
									days90to180, days181to365, days366Above,
									DueSPOverdue, GrcSPOverdue, Pd1SPOverdue,
									Pd2Overdue, Pd3SPOverdue, Na1SPOverdue,
									Na2SPOverdue, Na3SPOverdue, TotalDuesClass,
									TotalExposure, PeriodicPrincipal,
									PeriodicInterest, TotalPeriodic,
									DisbursementAccount, SettlementAccount,
									LoanStatus));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		request.setAttribute("aaLoansList", aaLoansList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/reports/aaLoanAgeAnalysis.jsp");
		view.forward(request, response);

		try {
			disconnect(con);
		} catch (SQLException e) {
			
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

		aaLoansList.clear();

		aaLoansList.clear();
		String seachAccount = request.getParameter("seachAccount");

		con = connect();
		if (con != null) {
 
			String sql = "select [Branch],[LoanId],[Category],[CategroyDescription],[CustomerID] ,[CustomerName] ,[Currency] ,[Product]  ,[ValueDate]  ,[MaturityDate]      ,[PrincipalBalance]      ,[OverdueInterest]      ,[OverduePrincipal]      ,[OverduePenalty]      ,[OverdueMonthlyFee]      ,[TotalOverdues]     ,[0DAYS]      ,[(1-10)Days]      ,[(11-30)Days]      ,[(31-60)Days]      ,[(61-89)Days]      ,[(90-180)Days]      ,[(181-365)Days]      ,[366DaysAbove]      ,[DueSPOverdue]      ,[GrcSPOverdue]      ,[Pd1SPOverdue]      ,[Pd2Overdue]      ,[Pd3SPOverdue]      ,[Na1SPOverdue]      ,[Na2SPOverdue]      ,[Na3SPOverdue]      ,[TotalDuesClass]      ,[TotalExposure]      ,[PeriodicPrincipal]      ,[PeriodicInterest]      ,[TotalPeriodic]      ,[DisbursementAccount]      ,[SettlementAccount]      ,[LoanStatus] FROM [SwaziBankIntranet2016].[dbo].[AALoanAgeAnalysis]  where [LoanId] like ?";

			try {
				selectStatement = con.prepareStatement(sql);
				selectStatement.setString(1, '%' + seachAccount + '%');
				results = selectStatement.executeQuery();

				while (results.next()) {
					String Branch = results.getString("Branch");
					String LoanId = results.getString("LoanId");
					String Category = results.getString("Category");
					String CategroyDescription = results
							.getString("CategroyDescription");
					String CustomerID = results.getString("CustomerID");
					String CustomerName = results.getString("CustomerName");
					String Currency = results.getString("Currency");
					String Product = results.getString("Product");
					String ValueDate = results.getString("ValueDate");
					String MaturityDate = results.getString("MaturityDate");
					String PrincipalBalance = results
							.getString("PrincipalBalance");
					String OverdueInterest = results
							.getString("OverdueInterest");
					String OverduePrincipal = results
							.getString("OverduePrincipal");
					String OverduePenalty = results.getString("OverduePenalty");
					String OverdueMonthlyFee = results
							.getString("OverdueMonthlyFee");
					String TotalOverdues = results.getString("TotalOverdues");
					String days0 = results.getString("0DAYS");
					String days1to10 = results.getString("(1-10)Days");
					String days11to30 = results.getString("(11-30)Days");
					String days31to60 = results.getString("(31-60)Days");
					String days61to89 = results.getString("(61-89)Days");
					String days90to180 = results.getString("(90-180)Days");
					String days181to365 = results.getString("(181-365)Days");
					String days366Above = results.getString("366DaysAbove");
					String DueSPOverdue = results.getString("DueSPOverdue");
					String GrcSPOverdue = results.getString("GrcSPOverdue");
					String Pd1SPOverdue = results.getString("Pd1SPOverdue");
					String Pd2Overdue = results.getString("Pd2Overdue");
					String Pd3SPOverdue = results.getString("Pd3SPOverdue");
					String Na1SPOverdue = results.getString("Na1SPOverdue");
					String Na2SPOverdue = results.getString("Na2SPOverdue");
					String Na3SPOverdue = results.getString("Na3SPOverdue");
					String TotalDuesClass = results.getString("TotalDuesClass");
					String TotalExposure = results.getString("TotalExposure");
					String PeriodicPrincipal = results
							.getString("PeriodicPrincipal");
					String PeriodicInterest = results
							.getString("PeriodicInterest");
					String TotalPeriodic = results.getString("TotalPeriodic");
					String DisbursementAccount = results
							.getString("DisbursementAccount");
					String SettlementAccount = results
							.getString("SettlementAccount");
					String LoanStatus = results.getString("LoanStatus");

					aaLoansList
							.add(new AaLoanAgeAnalysisBean(Branch, LoanId,
									Category, CategroyDescription, CustomerID,
									CustomerName, Currency, Product, ValueDate,
									MaturityDate, PrincipalBalance,
									OverdueInterest, OverduePrincipal,
									OverduePenalty, OverdueMonthlyFee,
									TotalOverdues, days0, days1to10,
									days11to30, days31to60, days61to89,
									days90to180, days181to365, days366Above,
									DueSPOverdue, GrcSPOverdue, Pd1SPOverdue,
									Pd2Overdue, Pd3SPOverdue, Na1SPOverdue,
									Na2SPOverdue, Na3SPOverdue, TotalDuesClass,
									TotalExposure, PeriodicPrincipal,
									PeriodicInterest, TotalPeriodic,
									DisbursementAccount, SettlementAccount,
									LoanStatus));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		request.setAttribute("aaLoansList", aaLoansList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/reports/aaLoanAgeAnalysis.jsp");
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
