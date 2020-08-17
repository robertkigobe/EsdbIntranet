package home;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;

import sz.co.swazibank.beans.EmployeeBirthday;
import util.ConnectionHelper;

/**
 * Servlet implementation class Home
 * 2017-12-12 robertk, changed the select query to ensure the birthdays are for only those without status DD
 * 2017-12-13 ROBERTK added sambulo mlotshwa in the risk and aml dtail jsp names section
 * 
 */
@WebServlet("/Home2")
public class Home2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<EmployeeBirthday> employees = new ArrayList<EmployeeBirthday>();
	String directoryName = "C:/IntranetWarehouse/WhatsNew";
	ArrayList<String> fileList = new ArrayList<String>();

	public static Connection con;
	String userName = null;
	private int hitCount;

	public void init() {
		hitCount = 0;

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/////////////////////////////
		Statement selectStatement = null;
		ResultSet results = null;
		 userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ArrayList<BirthdayBean> directoryList = new ArrayList<BirthdayBean>();

		directoryList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  [Surname],[Firstname] FROM [SwaziBankIntranet2016].[dbo].[employeesDynamique]   WHERE month(DateOfBirth) =  month(getDate()) and  day (DateOfBirth) = day (getDate())";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					String surname = results.getString("Surname");
					String firstname = results.getString("Firstname");
					

					directoryList.add(new BirthdayBean( firstname,  surname));
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			finally {
				if (con != null) {
					try {
						ConnectionHelper.disconnect(con);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			}

		}
		/////////////////////////////
		
		
		hitCount++;
		try {
			userName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e1) {
			
			e1.printStackTrace();
		}
		
		listFiles(directoryName);
		// ///////////////////////////////
		
		request.setAttribute("fileList", fileList);
		request.setAttribute("directoryList", directoryList);
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/home/home2.jsp");
		view.forward(request, response);

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
		
		//userName = System.getProperty("user.name");
		String servletName = "Home";
		System.out.println(hitCount);

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
