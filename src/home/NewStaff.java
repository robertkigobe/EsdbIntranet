package home;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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
 * Servlet implementation class Home
 */
@WebServlet("/NewStaff")
public class NewStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String directoryName = "C:/IntranetWarehouse/Home/NewStaff";
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

		hitCount++;
		listFiles(directoryName);
		request.setAttribute("fileList", fileList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/home/newStaff.jsp");
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
		userName = System.getProperty("user.name");
		String servletName = "New Staff";

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}