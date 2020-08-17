package technicalResources.risk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class ForexAMLRiskDailyReport
 */
@WebServlet("/ForexAMLRiskDailyTransactions")
public class ForexAMLRiskDailyTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_risk/forexAMLRiskDailyTransaction.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date dateModifiedN = new Date();
		String transactionDate = sdf.format(dateModifiedN);
		
		String customerName = request.getParameter("customerName");
		String branch = request.getParameter("branch");
		String currency = request.getParameter("currency");
		String amount = request.getParameter("amount");
		String destination = request.getParameter("destination");
		String cif = request.getParameter("cif");
		
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String insertIssueSql = "INSERT INTO [dbo].[forexAMLRiskDailyTransactions] ([transactionDate], [customerName] ,[branch]  ,[currency] ,[amount] ,[destination], [cif])  VALUES (?,? ,? ,? ,? ,?,?)";

			java.sql.PreparedStatement insertReportStatement = null;

			try {
				insertReportStatement = con.prepareStatement(insertIssueSql,new String[] { "id" });
				insertReportStatement.setString(1, transactionDate);
				insertReportStatement.setString(2, customerName);
				insertReportStatement.setString(3, branch);
				insertReportStatement.setString(4, currency);
				insertReportStatement.setString(5, amount);
				insertReportStatement.setString(6, destination);
				insertReportStatement.setString(7, cif);

				insertReportStatement.executeUpdate();
				insertReportStatement.close();
				con.close();

				
				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_risk/forexAMLRiskDailyTransaction.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}

			finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {

						System.out.println("can not close connection");
					}
				}
			}

		}
		
		
	}

}
