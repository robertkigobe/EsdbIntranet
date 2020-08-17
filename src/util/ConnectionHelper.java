package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
	
	public Connection connect() {
		
		Connection con = null;
		// Create a variable for the connection string.  
	    //String connectionUrl = "jdbc:sqlserver://172.16.1.59:1433;databaseName=SwaziBankIntranet2016;user=intranetUser;password=12345678=I";  
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SwaziBankIntranet2016;user=intranetUser;password=12345678=I";
	  
	  
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
