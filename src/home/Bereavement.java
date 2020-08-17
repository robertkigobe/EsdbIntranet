package home;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;

import util.ConnectionHelper;

/**
 * Servlet implementation class BriefsAndNews
 */
@WebServlet("/Bereavement")
public class Bereavement extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String directoryName = "C:/IntranetWarehouse/Home/Bereavement";
	public static Connection con;
	ArrayList<String> fileList = new ArrayList<String>();
	String userName = System.getProperty("user.name");
	private int hitCount;

	public void init() {
		hitCount = 0;

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		hitCount++;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		listFiles(directoryName);
		request.setAttribute("fileList", fileList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/home/bereavement.jsp");
		view.forward(request, response);

		// //////////////////////////////////////
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		hitCount++;
		// ///////////////////////////////
		String filePath = (String) request.getAttribute("path");
		File file = new File(filePath);
		response.setHeader("Content-Type",
				getServletContext().getMimeType(file.getName()));
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition",
				"inline; filename=\"myfile.pdf\"");
		Files.copy(file.toPath(), response.getOutputStream());
		
		
		
	}
	


	public void listFiles(String directoryName) {
		fileList.clear();
		File directory = new File(directoryName);
		File[] fList = directory.listFiles((FileFilter) FileFileFilter.FILE);
		Arrays.sort(fList, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		for (File file : fList) {
			if (file.isFile()) {
				fileList.add(file.getName());
				
			}
		}
	}
	
	public void destroy() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dateNow = dateFormat.format(date);
		
		String servletName = "Bereavement";
		

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		String insertIssueSql = "INSERT INTO [dbo].[ServletCounter] ([userName] ,[servletName] ,[dateNow] ,[hitCount])VALUES(?,?,?,?);";

		java.sql.PreparedStatement insertReportStatement = null;

		try {
			insertReportStatement = con.prepareStatement(insertIssueSql,
					new String[] { "id" });
			insertReportStatement.setString(1, userName);
			insertReportStatement.setString(2, servletName);
			insertReportStatement.setString(3, dateNow);
			insertReportStatement.setInt(4, hitCount);
			insertReportStatement.executeUpdate();
			insertReportStatement.close();
			con.close();
		} catch (SQLException e) {

			System.out.println("Cannot connect to activity database here");

		} finally {
			if (con != null) {
				try {
					ConnectionHelper.disconnect(con);
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		}
	}
}