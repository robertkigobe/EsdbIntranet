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

/**
 * Servlet implementation class MukuruCustomerOrders
 */
@WebServlet("/MukuruCustomerOrders")
public class MukuruCustomerOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String filename;
	ConnectionHelper connectionHelper = new ConnectionHelper();
	public static Connection con;

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement selectStatement = null;
		ResultSet results = null;
		
		
		float sheet_Ref;
		String branch;
		String teller;
		String recipient;
		String recipient_ID;
		float order;
		String order_Confirmed_Date;
		String order_Completed_Date;
		float ordered_SZL;
		float issued_SZL;

		ArrayList<MukuruCustomerBean> mukuruCustomerOrderlist = new ArrayList<MukuruCustomerBean>();

		mukuruCustomerOrderlist.clear();

		
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  [Sheet_Ref]  ,[Branch]  ,[Teller]  ,[Recipient]  ,[Recipient_ID]  ,[Order]  ,[Order_Confirmed_Date] ,[Order_Completed_Date] ,[Ordered_SZL]  ,[Issued_SZL] FROM [SwaziBankIntranet2016].[dbo].[mukuru]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					
					sheet_Ref = results.getFloat("Sheet_Ref");
					branch = results.getString("Branch");
					teller = results.getString("Teller");
					 recipient = results.getString("Recipient");
					 recipient_ID = results.getString("Recipient_ID");
					 order = results.getFloat("Order");
					 order_Confirmed_Date = results.getString("Order_Confirmed_Date");
					 order_Completed_Date = results.getString("Order_Completed_Date");
					 ordered_SZL = results.getFloat("Ordered_SZL");
					 issued_SZL = results.getFloat("Issued_SZL");
					
					 
					 mukuruCustomerOrderlist.add(new MukuruCustomerBean(  sheet_Ref,  branch,  teller,
								 recipient,  recipient_ID,  order,
								 order_Confirmed_Date,  order_Completed_Date,
								 ordered_SZL,  issued_SZL));
				}
				request.setAttribute("mukuruCustomerOrderlist", mukuruCustomerOrderlist);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/mukuruCustomerOrders.jsp");
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
		
		
		String Recipient_ID  = request.getParameter("Recipient_ID");
		String fromDate  = request.getParameter("fromDate");
		String toDate  = request.getParameter("toDate");
		float sheet_Ref;
		String branch;
		String teller;
		String recipient;
		String recipient_ID;
		float order;
		String order_Confirmed_Date;
		String order_Completed_Date;
		float ordered_SZL;
		float issued_SZL;

		ArrayList<MukuruCustomerBean> mukuruCustomerOrderlist = new ArrayList<MukuruCustomerBean>();

		mukuruCustomerOrderlist.clear();

		
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  [Sheet_Ref]  ,[Branch]  ,[Teller]  ,[Recipient]  ,[Recipient_ID]  ,[Order]  ,[Order_Confirmed_Date] ,[Order_Completed_Date] ,[Ordered_SZL]  ,[Issued_SZL] "
					+ "FROM [SwaziBankIntranet2016].[dbo].[mukuru] where [Recipient_ID] = '"+Recipient_ID+"' and Order_Confirmed_Date between '"+fromDate+"' and '"+toDate+"'";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);
				
				if (results.next()){
					
					System.out.println(Recipient_ID + " " +fromDate + " " + toDate);
					while (results.next()) {
						
						sheet_Ref = results.getFloat("Sheet_Ref");
						branch = results.getString("Branch");
						teller = results.getString("Teller");
						 recipient = results.getString("Recipient");
						 recipient_ID = results.getString("Recipient_ID");
						 order = results.getFloat("Order");
						 order_Confirmed_Date = results.getString("Order_Confirmed_Date");
						 order_Completed_Date = results.getString("Order_Completed_Date");
						 ordered_SZL = results.getFloat("Ordered_SZL");
						 issued_SZL = results.getFloat("Issued_SZL");
						
						 
						 mukuruCustomerOrderlist.add(new MukuruCustomerBean(  sheet_Ref,  branch,  teller,
									 recipient,  recipient_ID,  order,
									 order_Confirmed_Date,  order_Completed_Date,
									 ordered_SZL,  issued_SZL));
					}
					request.setAttribute("mukuruCustomerOrderlist", mukuruCustomerOrderlist);

					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/mukuruCustomerOrders.jsp");
					view.forward(request, response);
					
					
				} 
				else {
					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/mukuruCustomerOrders.jsp");
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
