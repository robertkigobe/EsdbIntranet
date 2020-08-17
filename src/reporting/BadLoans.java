package reporting;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class Directory
 */
@WebServlet("/BadLoans")
public class BadLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String filename;

	public static Connection con;
	String userName = null;
	private int hitCount;

	public void init() {
		hitCount = 0;

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;
		 userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ArrayList<BadLoansBean> directoryList = new ArrayList<BadLoansBean>();

		directoryList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[BadLoans] order by [Customer] ";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					String year =results.getString("YEAR").substring(0,4);
					String accNo = results.getString("AccNo");
					String cif = results.getString("Cif");
					String natinoalId = results.getString("NationalID");
					String dept = results.getString("Dept");
					String type = results
							.getString("Type");
					String customer = results.getString("Customer");
					String currentBalance = results.getString("Current Balance");

					directoryList.add(new BadLoansBean( year,  accNo,  cif, natinoalId,  dept,
							 type,  customer,  currentBalance));
				}
				request.setAttribute("directory", directoryList);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/reports/badLoans.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			finally {
				if (con != null) {
					try {
						ConnectionHelper.disconnect(con);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			}

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement selectStatement = null;
		ResultSet results = null;

		hitCount++;

		ArrayList<BadLoansBean> directoryList = new ArrayList<BadLoansBean>();

		directoryList.clear();
		String seachName = request.getParameter("seachName");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [YEAR],[AccNo],[Cif],[NationalID],[Dept] ,[Type] ,[Customer],[Current Balance] FROM [SwaziBankIntranet2016].[dbo].[BadLoans] where  [Customer] like ? or [NationalID] like ? or [Cif] like ? or [AccNo] like ? order by [Customer]  ";

			try {
				selectStatement = con.prepareStatement(sql);
				selectStatement.setString(1, '%' + seachName + '%');
				selectStatement.setString(2, '%' + seachName + '%');
				selectStatement.setString(3, '%' + seachName + '%');
				selectStatement.setString(4, '%' + seachName + '%');
				

				results = selectStatement.executeQuery();

				while (results.next()) {
					String year =results.getString("YEAR").substring(0,4);
					String accNo = results.getString("AccNo");
					String cif = results.getString("Cif");
					String natinoalId = results.getString("NationalID");
					String dept = results.getString("Dept");
					String type = results
							.getString("Type");
					String customer = results.getString("Customer");
					String currentBalance = results.getString("Current Balance");

					directoryList.add(new BadLoansBean(  year,  accNo,  cif, natinoalId,  dept,
							 type,  customer,  currentBalance));
				}
					request.setAttribute("directory", directoryList);

					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/reports/badLoans.jsp");
					view.forward(request, response);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			finally {
				if (con != null) {
					try {
						ConnectionHelper.disconnect(con);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void destroy() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dateNow = dateFormat.format(date);
		userName = System.getProperty("user.name");
		String servletName = "Directory";
		System.out.println(hitCount);

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		String insertIssueSql = "INSERT INTO [dbo].[ServletCounter] ([userName] ,[servletName] ,[dateNow] ,[hitCount])VALUES(?,?,?,?);";

		java.sql.PreparedStatement insertReportStatement = null;

		try {
			insertReportStatement = con.prepareStatement(insertIssueSql,
					new String[] { "id" });
			insertReportStatement.setString(1, userName);
			insertReportStatement.setString(2, servletName);
			insertReportStatement.setString(3, dateNow);
			insertReportStatement.setInt(4, hitCount);
			insertReportStatement.executeUpdate();
			insertReportStatement.close();
			con.close();
		} catch (SQLException e) {

			System.out.println("Cannot connect to activity database here");

		} finally {
			if (con != null) {
				try {
					ConnectionHelper.disconnect(con);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

}
