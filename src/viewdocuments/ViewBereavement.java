package viewdocuments;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewDocument
 */
@WebServlet("/ViewBereavement")
public class ViewBereavement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	String filePath;
	private static final int BUFSIZE = 4096;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String docName = request.getParameter("documentUrl");
		filePath =   "C:/IntranetWarehouse/Home/Bereavement/"+ docName;

		File file = new File(filePath);
		int length = 0;
		ServletOutputStream outStream = response.getOutputStream();
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

	

	
}
