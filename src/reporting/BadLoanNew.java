package reporting;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
@WebServlet("/BadLoanNew")
public class BadLoanNew extends HttpServlet {
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
		userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		hitCount++;

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/reports/badLoanNew.jsp");
				view.forward(request, response);
			

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		hitCount++;

		ArrayList<BadLoansBean> directoryList = new ArrayList<BadLoansBean>();

		directoryList.clear();
		
		

		String year = request.getParameter("year");
		String accno = request.getParameter("accno");
		String cif = request.getParameter("cif");
		String nationalid = request.getParameter("nationalid");
		String dept = request.getParameter("dept");
		String type = request.getParameter("type");
		String customer = request.getParameter("customer");
		float currentBalance = Float
				.valueOf(request.getParameter("currentBalance"));

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "INSERT INTO [dbo].[BadLoans]  ([YEAR]  ,[AccNo]  ,[Cif]  ,[NationalID]  ,[Dept]  ,[Type]  ,[Customer] ,[Current Balance]) VALUES (?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement insertReportStatement = null;
			try {
				insertReportStatement = con.prepareStatement(sql,
						new String[] { "id" });

				insertReportStatement.setString(1, year);
				insertReportStatement.setString(2, accno);
				insertReportStatement.setString(3, cif);
				insertReportStatement.setString(4, nationalid);
				insertReportStatement.setString(5, dept);
				insertReportStatement.setString(6, type);
				insertReportStatement.setString(7, customer);
				insertReportStatement.setFloat(8, currentBalance);


				
				insertReportStatement.executeUpdate();
				insertReportStatement.close();

				con.close();

				response.sendRedirect(request.getContextPath()
						+ "/BadLoans");
				
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
