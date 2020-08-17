package technicalResources.corporateServices;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * Servlet implementation class HealthSafetyNewInspection
 */
@WebServlet("/HealthSafetyAdminNewInspection")
public class HealthSafetyAdminNewInspection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     Date date = new Date( );
	     SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	     
	     request.setAttribute("dateOfInspection", ft.format(date));
	     
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/technicalResources_corporateServices/healthSafetyAdminNewInspection.jsp");
		view.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;
		
		 String dateOfInspection   = request.getParameter("dateOfInspection");
         String dueDateOfInspection   = request.getParameter("dueDateOfInspection");
         String branchDivision   = request.getParameter("branchDivision");
         String building   = request.getParameter("building");
         String floorArea   = request.getParameter("floorArea");
         String office   = request.getParameter("office");
         String deviations   = request.getParameter("deviations");
         String justifications   = request.getParameter("justifications");
         String personResponsible   = request.getParameter("personResponsible");

 		ConnectionHelper connectionHelper = new ConnectionHelper();
 		con = connectionHelper.connect();
 		if (con != null) {
 			// do query

 			String sql = "INSERT INTO [dbo].[HSE_admin__new_inspection]("
 					+ "[dateOfInspection]"
 					+ ",[dueDateOfInspection]"
 					+ ",[branchDivision]"
 					+ ",[building]"
 					+ ",[floorArea]"
 					+ ",[office]"
 					+ ",[deviations]"
 					+ ",[justifications]"
 					+ ",[personResponsible])"
 					+ "VALUES(?,?,?,?,?,?,?,?,?)";
 			try {
 				PreparedStatement stmt = con.prepareStatement(sql);
 				
 				    int x = 1;
 				    stmt.setString(x++, dateOfInspection);
 				    stmt.setString(x++, dueDateOfInspection);
 				    stmt.setString(x++, branchDivision);
 				    stmt.setString(x++, building);
 				    stmt.setString(x++, floorArea);
 				    stmt.setString(x++, office);
 				    stmt.setString(x++, deviations);
 				    stmt.setString(x++, justifications);
 				    stmt.setString(x++, personResponsible);
 				    stmt.executeUpdate();
 				    //stmt.setTimestamp(10, );;
 				    stmt.close();
 				    response.sendRedirect(request.getContextPath()+ "/HealthAndSafetyAdminMain");

 			} catch (SQLException e1) {
 				System.out.println("could not execute querry");
 				e1.printStackTrace();
 			}
 		} else {
 			System.out.println("No database connectivity");
 		}

	
	}
		
}
