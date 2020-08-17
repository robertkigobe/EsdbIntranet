package technicalResources.risk;

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

import sz.co.swazibank.beans.DirectoryBean;
import util.ConnectionHelper;


@WebServlet("/ForexAMLRiskDailyReport")
public class ForexAMLRiskDailyReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;
		
		ArrayList<ForexAMLRiskDailyBean> forexAMLRiskDailyList = new ArrayList<ForexAMLRiskDailyBean>();

		forexAMLRiskDailyList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [id],[transactionDate],[customerName] ,[branch] ,[currency] ,[amount] ,[destination]  ,[cif]  FROM [dbo].[forexAMLRiskDailyTransactions]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					
					String transactionDate = results.getString("transactionDate");
					String customerName = results.getString("customerName");
					String branch = results.getString("branch");
					String currency = results.getString("currency");
					String amount = results.getString("amount");
					String destination = results.getString("destination");
					String cif = results.getString("cif");
				
					forexAMLRiskDailyList.add(new ForexAMLRiskDailyBean(transactionDate,customerName,  branch , currency, amount , destination , cif));
				}
				
				request.setAttribute("forexAMLRiskDailyList", forexAMLRiskDailyList);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_risk/forexAMLRiskDailyReport.jsp");
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
