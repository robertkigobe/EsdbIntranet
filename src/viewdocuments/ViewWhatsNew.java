package viewdocuments;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewDocument
 */
@WebServlet("/ViewWhatsNew")
public class ViewWhatsNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	String filePath;
	private static final int BUFSIZE = 4096;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String docName = request.getParameter("documentUrl");
		filePath =   "C:/IntranetWarehouse/WhatsNew/"+ docName;

		File file = new File(filePath);
		int length = 0;
		ServletOutputStream outStream = response.getOutputStream();
		response.setContentType("text/html");
		 response.setHeader("Content-Type", "application/pdf");
		response.setContentLengthLong((int)file.length());
		String fileName = (new File(filePath)).getName();
		response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
		byte [] byteBuffer = new byte[BUFSIZE];
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		while ((in != null)&&(length = in.read(byteBuffer))!= -1){
			outStream.write(byteBuffer, 0, length);
			
		}
		in.close();
		outStream.close();
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
