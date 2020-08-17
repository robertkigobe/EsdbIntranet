package viewdocuments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.DataInputStream;
import java.io.File; 
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@WebServlet("/ViewPowerCard")
public class ViewPowerCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	String filePath;
	private static final int BUFSIZE = 4096;
	

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String docName = request.getParameter("documentUrl");
		filePath = "C:/IntranetWarehouse/Operations/EB/processed/" + docName;

	     
		File file = new File(filePath);
		int length = 0;
		ServletOutputStream outStream = response.getOutputStream();
		response.setContentType("application/vnd.ms-excel");
		 response.addHeader("Pragma", "No-cache");
		response.setContentLengthLong((int)file.length());
		String fileName = (new File(filePath)).getName();
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		byte [] byteBuffer = new byte[BUFSIZE];
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		while ((in != null)&&(length = in.read(byteBuffer))!= -1){
			outStream.write(byteBuffer, 0, length);
	
		}
		in.close();
		outStream.close();
		
		
		//////////////////////////////////////

		///////////////////////////////// excel/////////////////////////////////////////

	}

	// ///////connect & disconnect /////////////
	public static Connection connect() {

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=SwaziBankIntranet2016;user=intranetUser;password=12345678=I";

		// Declare the JDBC objects.

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = (Connection) DriverManager.getConnection(connectionUrl);
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
