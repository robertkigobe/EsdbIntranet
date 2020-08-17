package workingResources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class FT23
 */
@WebServlet("/DC23")
public class DC23 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String filename;

	public static Connection con;
	String userName = null;
	public void init() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;
		userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ArrayList<DC23Bean> ft23List = new ArrayList<DC23Bean>();

		ft23List.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [ID]      ,[ACCOUNTNUMBER]      ,[SIGN]      ,[AMOUNTLCY]     "
					+ " ,[NARRATIVE]     ,[VALUEDATE]      ,[INPUTTER]      ,[AUTHORISER]  FROM [dbo].[DC23]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					String id = results.getString("ID");
					String accountnumber = results.getString("ACCOUNTNUMBER");
					String sign = results.getString("SIGN");
					String amountlcy = results.getString("AMOUNTLCY");
					String narrative = results.getString("NARRATIVE");
					String valuedate = results.getString("VALUEDATE");
					String inputter = results.getString("INPUTTER");
					String authoriser = results.getString("AUTHORISER");

					ft23List.add(new DC23Bean(id, accountnumber, sign,
							amountlcy, narrative, valuedate, inputter,
							authoriser));
				}
				request.setAttribute("ft23List", ft23List);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/workingResources/dc23.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			finally {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PreparedStatement selectStatement = null;
		ResultSet results = null;

		String seachName = request.getParameter("seachName");

		ArrayList<DC23Bean> ft23List = new ArrayList<DC23Bean>();

		ft23List.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [ID]      ,[ACCOUNTNUMBER]      ,[SIGN]      ,[AMOUNTLCY]     "
					+ " ,[NARRATIVE]     ,[VALUEDATE]      ,[INPUTTER]      ,[AUTHORISER]  FROM [dbo].[DC23] where [ACCOUNTNUMBER] like '%"+seachName+"%' ";

			try {
				selectStatement = con.prepareStatement(sql);
				// selectStatement.setString(1, '%' + seachName + '%');
				// selectStatement.setString(2, '%' + seachName + '%');

				results = selectStatement.executeQuery();

				while (results.next()) {
					String id = results.getString("ID");
					String accountnumber = results.getString("ACCOUNTNUMBER");
					String sign = results.getString("SIGN");
					String amountlcy = results.getString("AMOUNTLCY");
					String narrative = results.getString("NARRATIVE");
					String valuedate = results.getString("VALUEDATE");
					String inputter = results.getString("INPUTTER");
					String authoriser = results.getString("AUTHORISER");

					ft23List.add(new DC23Bean(id, accountnumber, sign,
							amountlcy, narrative, valuedate, inputter,
							authoriser));
				}
				request.setAttribute("ft23List", ft23List);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/workingResources/dc23.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			finally {
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

}
