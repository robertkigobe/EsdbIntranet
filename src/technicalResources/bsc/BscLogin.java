package technicalResources.bsc;

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
 * Servlet implementation class Login
 */
@WebServlet("/BscLogin")
public class BscLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BscLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;
		String subDepartment = null;
		ArrayList<String> subDepartments = new ArrayList<String>();

		subDepartments.clear();
		subDepartments.add("Choose ");
		subDepartments.add("All");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		
		if (con != null) {

			String sql = "SELECT  distinct([subDepartment])   FROM [SwaziBankIntranet2016].[dbo].[bscSDSBScores] order by subDepartment";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					subDepartment = results.getString("subDepartment");
					subDepartments.add(subDepartment);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}
		
		request.setAttribute("subDepartments", subDepartments);
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscLogin.jsp");

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
