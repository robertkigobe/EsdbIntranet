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
@WebServlet("/HealthSafetyNewInspectionEnvironmental")
public class HealthSafetyNewInspectionEnvironmental extends HttpServlet {
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
			
		String sql = "SELECT [id],[itemNo],[itemDesc] FROM [dbo].[HSE_safety_and_healthy_function_setup] ORDER BY [id]";
		
		try {
			selectStatement = con.createStatement();
			results = selectStatement.executeQuery(sql);
			

			
			while (results.next()) {
				
				String itemNo = results.getString("itemNo");
				String ItemDesc = results.getString("itemDesc");
				items.add(new Item(itemNo, ItemDesc));
			}
            
			
			request.setAttribute("items", items);
			
		     Date date = new Date( );
		     SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		     
		     request.setAttribute("dateOfInspection", ft.format(date));
		     request.setAttribute("dateOf_she_representativeComment", ft.format(date));
		     request.setAttribute("dateOfManagerComment", ft.format(date));
		     request.setAttribute("dateOfwellnessCoordinatorComment", ft.format(date));
		     
			RequestDispatcher view = request
			 .getRequestDispatcher("WEB-INF/technicalResources_corporateServices/healthSafetyNewInspectionEnvironmental.jsp");
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
		String she_representative = request.getParameter("she_representative");
		
		String she_representativeComment = request.getParameter("she_representativeComment");
		String dateOf_she_representativeComment = request.getParameter("dateOf_she_representativeComment");
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

			String sql = "INSERT INTO [dbo].[HSE_inspection_register_safety_and_health]"
					+ "([branchDivision] ,[dateOfInspection], [itemNo],[itemDesc],[she_representative],"
					+ "[record],[comments],[she_representativeComment] ,[dateOf_she_representativeComment],"
					+ "[managerComment],[dateOfManagerComment],"
					+ "[wellnessCoordinatorComment],[dateOfwellnessCoordinatorComment])"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				
				for(int i = 0; i<items.size();i++){
				
				    int x = 1;
				    stmt.setString(x++, branchDivision);
				    stmt.setString(x++, dateOfInspection);
				    stmt.setString(x++, items.get(i).ItemNo);
				    stmt.setString(x++, items.get(i).ItemDesc);
				    stmt.setString(x++, she_representative);
				    stmt.setString(x++, items.get(i).record);
				    stmt.setString(x++, items.get(i).comments);
				    stmt.setString(x++, she_representativeComment);
				    stmt.setString(x++, dateOf_she_representativeComment);
				    stmt.setString(x++, managerComment);
				    stmt.setString(x++, dateOfManagerComment);
				    stmt.setString(x++, wellnessCoordinatorComment);
				    stmt.setString(x++, dateOfwellnessCoordinatorComment);
				    stmt.executeUpdate();
				}

				//stmt.setTimestamp(10, );;
				stmt.close();
		         response.sendRedirect(request.getContextPath()+ "/HealthSafetyMain");
			} catch (SQLException e1) {
				System.out.println("could not execute querry");
				e1.printStackTrace();
			}
		} else {
			System.out.println("No database connectivity");
		}

	
	}
		
}
