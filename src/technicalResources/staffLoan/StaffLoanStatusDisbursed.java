package technicalResources.staffLoan;

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
@WebServlet("/StaffLoanStatusDisbursed")
public class StaffLoanStatusDisbursed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		String currentStatus;
		String lastModifiedBy;
		String lastModifiedDate;
		String inactivity = null;
		Integer days = null;
		Integer hours = null;
		Integer minutes = null;
		Integer second = null;
		Integer seconds = null;
		
		ArrayList<StaffLoanStatusBean> loanList = new ArrayList<StaffLoanStatusBean>();
		loanList.clear();
		
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			
			String sql = "SELECT "
					+ "loanStatus,"
					+ "applicantCommentDate,"
					+ "lastModifiedBy,"
					+ "lastModifiedDate,"
					+ "employeeLoanRef,"
					+ "loanStatus,"
					+ "datediff(year,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'years',"
					+ "datediff(month,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'months',"
					+ "datediff(week,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'weeks',"
					+ "datediff(day,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'days',"
					+ "datediff(hour,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'hours',"
					+ "datediff(minute,convert(datetime,[lastModifiedDate], 120) ,GETDATE()) as 'minutes',"
					+ "datediff(second,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'seconds' "
					+ "FROM [SwaziBankIntranet2016].[dbo].[StaffLoan] where loanStatus = 'Loan Disbursed' order by lastModifiedDate desc";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					 currentStatus = results.getString("loanStatus");
					 results.getString("applicantCommentDate");
					 lastModifiedBy = results.getString("lastModifiedBy");
					 lastModifiedDate = results.getString("lastModifiedDate");

					String loanRef = results.getString("employeeLoanRef");
					results.getString("loanStatus");
					second  = Integer.valueOf(results.getString("seconds"));
					 
					 days = second / (60 * 60 * 24);
					 hours = (second / (60 * 60)) - (days * 24);
					 minutes = (second / 60) - ((hours * 60) + (days * 24 * 60));					 
					 seconds = second - ((hours * 60 * 60) + (days * 24 * 60 * 60) + (minutes * 60));

					 inactivity  =  days+"d: "+hours+"h: "+minutes+"m: "+seconds +"s"; 

					loanList.add(new StaffLoanStatusBean( loanRef,  inactivity, currentStatus,  lastModifiedDate,  lastModifiedBy));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		request.setAttribute("loanList", loanList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanStatusDisbursed.jsp");
		
		view.forward(request, response);

		try {
			ConnectionHelper.disconnect(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
