package staffServices;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class BriefsAndNews
 */
@WebServlet("/RiskForms")
public class RiskForms extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String directoryName = "C:/IntranetWarehouse/Forms/RiskForms";
	ArrayList<String> briefList = new ArrayList<String>();
	

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

		request.setAttribute("fileList", briefList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/staffServices/riskForms.jsp");
		view.forward(request, response);
	}

	public void listFiles(String directoryName) {
		briefList.clear();
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();

		for (File file : fList) {
			if (file.isFile()) {
				briefList.add(file.getName());
			}
		}
	}
	
	public void destroy() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dateNow = dateFormat.format(date);
		userName = System.getProperty("user.name");
		String servletName = "HR Policies";
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}