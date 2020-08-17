package technicalResources.risk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class AmlTestMain
 */
@WebServlet("/AmlTestMain")
public class AmlTestMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_risk/amlTestMain.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		ArrayList<String> employees = new ArrayList<String>();
		employees.clear();
		employees.add("");
		String employee = null;

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String sql1 = "SELECT  distinct [Surname] + ' ' + [Firstname]   as 'employee'   FROM  [SwaziBankIntranet2016].[dbo].[dynamiqueEmployees]  order by  [Surname] + ' ' + [Firstname] ";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql1);

				while (results.next()) {
					employee = results.getString("employee");

					employees.add(employee);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}
		request.setAttribute("employees", employees);
		
		
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_risk/amlTestDetail.jsp");
		view.forward(request, response);
	}

}
