package technicalResources_businessBanking;

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

/**
 * Servlet implementation class StaffLoanStatus
 */
@WebServlet("/BusinessBankingLoanStatus")
public class BusinessBankingLoanStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Statement selectStatement = null;
		ResultSet results = null;
		
		String currentStatus;
		String lastModifiedBy;
		String lastModifiedDate;
		String inactivity = null;
		Integer days = null;
		Integer hours = null;
		Integer minutes = null;
		Integer second = null;
		Integer seconds = null;
		
		ArrayList<BusinessBankingLoanStatusBean> loanList = new ArrayList<BusinessBankingLoanStatusBean>();
		loanList.clear();
		
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			
			String sql = "SELECT "
					+ "status_of_loan,"
					+ "loanDate,"
					+ "last_modified_by,"
					+ "last_modified_date,"
					+ "loanRef,"
					+ "datediff(year,convert(datetime,[last_modified_date], 120),GETDATE() ) as 'years',"
					+ "datediff(month,convert(datetime,[last_modified_date], 120),GETDATE() ) as 'months',"
					+ "datediff(week,convert(datetime,[last_modified_date], 120),GETDATE() ) as 'weeks',"
					+ "datediff(day,convert(datetime,[last_modified_date], 120),GETDATE() ) as 'days',"
					+ "datediff(hour,convert(datetime,[last_modified_date], 120),GETDATE() ) as 'hours',"
					+ "datediff(minute,convert(datetime,[last_modified_date], 120) ,GETDATE()) as 'minutes',"
					+ "datediff(second,convert(datetime,[last_modified_date], 120),GETDATE() ) as 'seconds' "
					+ "FROM [SwaziBankIntranet2016].[dbo].[corporate_loans] where status_of_loan NOT IN ('Loan Disbursed', 'Approved','Rejected','Cancelled') order by last_modified_date desc";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					 currentStatus = results.getString("status_of_loan");
					 lastModifiedBy = results.getString("last_modified_by");
					 lastModifiedDate = results.getString("last_modified_date");

					String loanRef = results.getString("loanRef");
					results.getString("status_of_loan");
					second  = Integer.valueOf(results.getString("seconds"));
					 
					 days = second / (60 * 60 * 24);
					 hours = (second / (60 * 60)) - (days * 24);
					 minutes = (second / 60) - ((hours * 60) + (days * 24 * 60));					 
					 seconds = second - ((hours * 60 * 60) + (days * 24 * 60 * 60) + (minutes * 60));

					 inactivity  =  days+"d: "+hours+"h: "+minutes+"m: "+seconds +"s"; 

					loanList.add(new BusinessBankingLoanStatusBean( loanRef,  inactivity, currentStatus,  lastModifiedDate,  lastModifiedBy));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		request.setAttribute("loanList", loanList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bussinessBanking/businessBankingLoanStatus.jsp");
		
		view.forward(request, response);

		try {
			ConnectionHelper.disconnect(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
