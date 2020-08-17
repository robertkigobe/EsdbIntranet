package technicalResources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Messenger
 */
@WebServlet("/SkillsAudit")
public class SkillsAudit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/home.jsp");
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		con = connect();
		if (con != null) {

			String insertReportSurveySql = "INSERT INTO skillsAudit (position, name, userName, category, item, rating, priority)	VALUES(?,?,?,?,?,?,?);";
			java.sql.PreparedStatement insertReportStatement = null;
			try {
				insertReportStatement = con
						.prepareStatement(insertReportSurveySql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("error in connection");
			}
			
			

		
		String position = (String) request.getParameter("position"); 
		String name = (String) request.getParameter("name");
		String userName = System.getProperty("user.name");
		String []category =  request.getParameterValues("category");
		String []item = request.getParameterValues("item");
		String []rating =  request.getParameterValues("rating");
		String []priority =  request.getParameterValues("priority");
		
		try {
			int x = category.length;
			for (int i=0; i < x; i++){
			insertReportStatement.setString(1, position);
			insertReportStatement.setString(2, name);
			insertReportStatement.setString(3, userName);
			insertReportStatement.setString(4, category[i]);
			insertReportStatement.setString(5, item[i]);
			insertReportStatement.setString(6, rating[i]);
			insertReportStatement.setString(7, priority[i]);
			insertReportStatement.executeUpdate();
			
			}
			insertReportStatement.close();
			con.close();
			
									
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/views/home.jsp");
			view.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("can not close connection");
				}
			}
		}

	}
}
// ///////connect & disconnect /////////////
			public static Connection connect() {
						
				 // Create a variable for the connection string.  
			      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
			         "databaseName=SwaziBankSkillsAudit2017;user=intranetUser;password=12345678=I";  
			  
			      // Declare the JDBC objects.  
			      
			  
			      try {  
			         // Establish the connection. 
			    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			         con =  DriverManager.getConnection(connectionUrl);
			         }
			      // Handle any errors that may have occurred.  
			      catch (Exception e) {  
			         e.printStackTrace();  
			      }  
			     
				return con;
				}

		public static void disconnect(Connection con) throws SQLException {
			if (con != null) {
				con.close();
			}
		}


	}


