package technicalResources.electronicBanking;

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


@WebServlet("/MukuruMonthlyCustomerOrders")
public class MukuruMonthlyCustomerOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String filename;
	ConnectionHelper connectionHelper = new ConnectionHelper();
	public static Connection con;

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement selectStatement = null;
		ResultSet results = null;

		
		String branch;
		String snap_shot;
		String recipient;
		String recipient_ID;
		int total_count;
		float total_ordered;
		float total_received;
		

		ArrayList<MukuruMonthlyCustomerBean> mukuruMonthlyCustomerOrderlist = new ArrayList<MukuruMonthlyCustomerBean>();

		mukuruMonthlyCustomerOrderlist.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT Concat(YEAR([Order_Confirmed_Date]) , '_' , MONTH([Order_Confirmed_Date])) as 'snap_shot' ,[Branch] as 'branch'  ,[Recipient] as 'recipient'  ,[Recipient_ID] as 'recipient_ID' ,count([Recipient_ID]) as 'total_count' ,sum ([Ordered_SZL]) as 'total_ordered' ,sum ([Issued_SZL]) as 'total_received'  FROM [SwaziBankIntranet2016].[dbo].[mukuru] group by [Recipient_ID],[Branch],[Recipient], YEAR([Order_Confirmed_Date]), MONTH([Order_Confirmed_Date]) having count([Recipient_ID]) > 1";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					
					 branch = results.getString("branch");
					 snap_shot = results.getString("snap_shot");
					 recipient = results.getString("recipient");
					 recipient_ID = results.getString("recipient_ID");
					 total_count = results.getInt("total_count");
					 total_ordered = results.getFloat("total_ordered");
					 total_received = results.getFloat("total_received");
					

					 mukuruMonthlyCustomerOrderlist.add(new MukuruMonthlyCustomerBean(  branch,  snap_shot,
								 recipient,  recipient_ID,  total_count,
								 total_ordered,  total_received));
				}
				request.setAttribute("mukuruMonthlyCustomerOrderlist", mukuruMonthlyCustomerOrderlist);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/mukuruMonthlyCustomerOrders.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
		
		Statement selectStatement = null;
		ResultSet results = null;
		int count = 0;
		
		
		String yearP  = request.getParameter("yearP");
		String monthP  = request.getParameter("monthP");
		 count  = Integer.valueOf(request.getParameter("count"));
		
		String branch;
		String snap_shot;
		String recipient;
		String recipient_ID;
		int total_count;
		float total_ordered;
		float total_received;

		ArrayList<MukuruMonthlyCustomerBean> mukuruMonthlyCustomerOrderlist = new ArrayList<MukuruMonthlyCustomerBean>();

		mukuruMonthlyCustomerOrderlist.clear();

		
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  	"
					+ "Concat(YEAR([Order_Confirmed_Date]) , '_' , "
					+ "MONTH([Order_Confirmed_Date])) as 'snap_shot',"
					+ "[Branch] as 'branch'    ,[Recipient] as 'recipient',"
					+ "[Recipient_ID] as 'recipient_ID'	,count([Recipient_ID]) as 'total_count',"
					+ "sum ([Ordered_SZL]) as 'total_ordered',"
					+ "sum ([Issued_SZL]) as 'total_received'  "
					+ "FROM [SwaziBankIntranet2016].[dbo].[mukuru]  "
					+ "where YEAR([Order_Confirmed_Date]) = '"+Integer.valueOf(yearP)+"' "
							+ "and MONTH([Order_Confirmed_Date]) = '"+Integer.valueOf(monthP)+"'"
									+ "group by [Recipient_ID],"
									+ "[Branch],"
									+ "[Recipient], "
									+ "YEAR([Order_Confirmed_Date]), "
									+ "MONTH([Order_Confirmed_Date])  "
									+ "having count([Recipient_ID]) > '"+count+"'";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);
				
				if (results.next()){
					
					do {
						
						branch = results.getString("branch");
						snap_shot = results.getString("snap_shot");
						recipient = results.getString("recipient");
						recipient_ID = results.getString("recipient_ID");
						total_count = results.getInt("total_count");
						total_ordered = results.getFloat("total_ordered");
						total_received = results.getFloat("total_received");
						
						
						mukuruMonthlyCustomerOrderlist.add(new MukuruMonthlyCustomerBean(  branch,  snap_shot,
								recipient,  recipient_ID,  total_count,
								total_ordered,  total_received));
					}
					
					while (results.next());
					
					request.setAttribute("mukuruMonthlyCustomerOrderlist", mukuruMonthlyCustomerOrderlist);

					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/mukuruMonthlyCustomerOrders.jsp");
					view.forward(request, response);
					
					
				} 
				else {
					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/mukuruCustomerOrdersEmptySet.jsp");
					view.forward(request, response);
				}

				
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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

}
