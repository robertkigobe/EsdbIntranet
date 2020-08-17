package technicalResources.corporateServices;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * Servlet implementation class HealthSafetyNewInspection
 */
@WebServlet("/HealthSafetyNewInspectionFireMarshall")
public class HealthSafetyNewInspectionFireMarshall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	private int itemCount;
	private ArrayList<Item> items;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Statement selectStatement = null;
		ResultSet results = null;
		
		items = new ArrayList<Item>();
		items.clear();		
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {	
			
		String sql = " SELECT [id],[itemNo],[itemDesc]"
				+ " FROM [dbo].[HSE_fire_marshall_function_setup] "
				+ "ORDER BY [id]";
		
		try {
			selectStatement = con.createStatement();
			results = selectStatement.executeQuery(sql);
			

			
			while (results.next()) {
				
				String itemNo = results.getString("itemNo");
				String ItemDesc = results.getString("itemDesc");
				items.add(new Item(itemNo, ItemDesc));
			}
            
			itemCount = items.size();
			
		     Date date = new Date( );
		     SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		     
		     request.setAttribute("dateOfInspection", ft.format(date));
		     request.setAttribute("dateOffireMarshallComment", ft.format(date));
		     request.setAttribute("dateOfManagerComment", ft.format(date));
		     request.setAttribute("dateOfwellnessCoordinatorComment", ft.format(date));
			request.setAttribute("items", items);
			
			RequestDispatcher view = request
			 .getRequestDispatcher("WEB-INF/technicalResources_corporateServices/healthSafetyInspectionFireMarshall.jsp");
			view.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot connect to activity database here");
		} 
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String branchDivision = request.getParameter("branchDivision");
		String dateOfInspection = request.getParameter("dateOfInspection");
		String fireMarshall = request.getParameter("fireMarshall");
		
		String fireMarshallComment = request.getParameter("fireMarshallComment");
		String dateOfireMarshallComment = request.getParameter("dateOffireMarshallComment");
		String managerComment = request.getParameter("managerComment");
		String dateOfManagerComment = request.getParameter("dateOfManagerComment");
		String wellnessCoordinatorComment = request.getParameter("wellnessCoordinatorComment");
		String dateOfwellnessCoordinatorComment = request.getParameter("dateOfwellnessCoordinatorComment");
		
		for(int i = 0; i<items.size();i++){
			
            items.get(i).setRecord(request.getParameter("record" + Integer.toString(i)));
            items.get(i).setComments(request.getParameter("comment" + Integer.toString(i)));
		}

		
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			// do query

			String sql = "INSERT INTO [dbo].[HSE_inspection_register_fire_marshall] "
					+ "([branchDivision] ,[dateOfInspection], [itemNo],[itemDesc],[fireMarshall],"
					+ "[record],[comments],[fireMarshallComment] ,[dateOfireMarshallComment],"
					+ "[managerComment],[dateOfManagerComment],"
					+ "[wellnessCoordinatorComment],[dateOfwellnessCoordinatorComment])"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				
				for(int i = 0; i<itemCount;i++){
				
				    int x = 1;
				    stmt.setString(x++, branchDivision);
				    stmt.setString(x++, dateOfInspection);
				    stmt.setString(x++, items.get(i).ItemNo);
				    stmt.setString(x++, items.get(i).ItemDesc);
				    stmt.setString(x++, fireMarshall);
				    stmt.setString(x++, items.get(i).record);
				    stmt.setString(x++, items.get(i).comments);
				    stmt.setString(x++, fireMarshallComment);
				    stmt.setString(x++, dateOfireMarshallComment);
				    stmt.setString(x++, managerComment);
				    stmt.setString(x++, dateOfManagerComment);
				    stmt.setString(x++, wellnessCoordinatorComment);
				    stmt.setString(x++, dateOfwellnessCoordinatorComment);
				    stmt.executeUpdate();
				}

				
				stmt.close();
		        // response.sendRedirect(request.getContextPath()+ "/HealthSafetyMain");
			} catch (SQLException e1) {
				System.out.println("could not execute querry");
				e1.printStackTrace();
			}
		} else {
			System.out.println("No database connectivity");
		}

	
	}
		
}
