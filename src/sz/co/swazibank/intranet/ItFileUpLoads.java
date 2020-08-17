package sz.co.swazibank.intranet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItFileUpLoads
 */
@MultipartConfig(maxFileSize = 100000000)
@WebServlet("/ItFileUpLoads")
public class ItFileUpLoads extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7671576181771996860L;
	public static Connection con;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/faces/ItAdmin.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		con  = connect();
		insertFile(con, "C:/IntranetWarehouse/Briefs/aaa.doc");
		
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

		public void insertFile(Connection con,String path) {
	        int len;
	        String query;
	        PreparedStatement pstmt;
	         
	        try {

	    		//java.sql.Date sqlDate = java.sql.Date.valueOf(dated);
	    		String name = "testName";
	    		String department = "testDepartment";
	    		String category = "testCategory";

	        	File file = new File(path);
	            FileInputStream fis = new FileInputStream(file);
	            len = (int)file.length();
	            
	            query = ( "INSERT INTO fileUploads (dated, name, department,category, fileUpload) values (?, ?, ?,?,?)");
	            pstmt = con.prepareStatement(query,new String[] { "id" } );	            
	            pstmt.setDate(1,  new java.sql.Date(new java.util.Date().getTime()));
	            pstmt.setString(2,name);
	            pstmt.setString(3,department);
	            pstmt.setString(4,category);
	            //pstmt.setInt(5, len);
	             
	            //method to insert a stream of bytes
	            pstmt.setBinaryStream(5, fis, len); 
	            pstmt.executeUpdate();
	             
	        } catch (Exception e) {
	            e.printStackTrace();
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
		         con =  (Connection) DriverManager.getConnection(connectionUrl);
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




