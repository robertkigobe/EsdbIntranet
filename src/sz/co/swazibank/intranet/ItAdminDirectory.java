package sz.co.swazibank.intranet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItAdmin
 */
@WebServlet("/ItAdminDirectory")
@MultipartConfig(maxFileSize = 100000000)

public class ItAdminDirectory extends HttpServlet {
	public static Connection con;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/faces/ItAdminDirectory.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String sirName = request.getParameter("sirName");
		String department = request.getParameter("department");
		String extension = request.getParameter("extension");
		String organisationalEmail = request.getParameter("organisationalEmail");
		

		con = connect();
		
		if (con != null) {

			// constructs SQL statement
			String insertSql = "INSERT INTO directory (name, sirName, department, extension,organisationalEmail) values (?,?,?,?,?)";
			
			 
			java.sql.PreparedStatement insertStatement;
			try {
				insertStatement = con.prepareStatement(insertSql,new String[] { "id" } );
				insertStatement.setString(1, name);
				insertStatement.setString(2, sirName);
				insertStatement.setString(3, department);
				insertStatement.setString(4, extension);
				insertStatement.setString(5, organisationalEmail);
				insertStatement.executeUpdate();

				insertStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		response.sendRedirect(request.getContextPath() + "/Directory");
		if (con != null){
			try {
				disconnect(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


		// ///////connect & disconnect /////////////
		public static Connection connect() {
					
			 // Create a variable for the connection string.  
		      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
		         "databaseName=SwaziBankIntranet2016;user=intranetUser;password=12345678=I";  
		  
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
