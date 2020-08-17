package technicalResources.risk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AmlTestDetail
 */
@WebServlet("/RiskTestDetail")
public class RiskTestDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RiskTestDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		
		
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		int v1 = 0;
		int v2 = 0;
		int v3 = 0;
		int v4 = 0;
		int v5 = 0;
		int v6 = 0;
		int v7 = 0;
		int v8 = 0;
		int v9 = 0;
		int v10 = 0;
		int v11 = 0;
		int v12 = 0;
		int v13 = 0;
		int v14 = 0;
		int v15 = 0;
		int v16 = 0;
		int v17 = 0;
		int v18 = 0;
		int v19 = 0;
		int v20 = 0;
		int v21 = 0;
		int v22 = 0;
		int v23 = 0;
		int v24 = 0;
		int v25 = 0;
		
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String branch = request.getParameter("branch");
		String department = request.getParameter("department");

		char val1 = request.getParameter("radio1").charAt(0);
		char val2 = request.getParameter("radio2").charAt(0);
		char val3 = request.getParameter("radio3").charAt(0);
		char val4 = request.getParameter("radio4").charAt(0);
		char val5 = request.getParameter("radio5").charAt(0);
		char val6 = request.getParameter("radio6").charAt(0);
		char val7 = request.getParameter("radio7").charAt(0);
		char val8 = request.getParameter("radio8").charAt(0);
		char val9 = request.getParameter("radio9").charAt(0);
		char val10 = request.getParameter("radio10").charAt(0);
		char val11 = request.getParameter("radio11").charAt(0);
		char val12 = request.getParameter("radio12").charAt(0);
		char val13 = request.getParameter("radio13").charAt(0);
		char val14 = request.getParameter("radio14").charAt(0);
		char val15 = request.getParameter("radio15").charAt(0);
		char val16 = request.getParameter("radio16").charAt(0);
		char val17 = request.getParameter("radio17").charAt(0);
		char val18 = request.getParameter("radio18").charAt(0);
		char val19 = request.getParameter("radio19").charAt(0);
		char val20 = request.getParameter("radio20").charAt(0);
		char val21 = request.getParameter("radio21").charAt(0);
		char val22 = request.getParameter("radio22").charAt(0);
		char val23 = request.getParameter("radio23").charAt(0);
		char val24 = request.getParameter("radio24").charAt(0);
		char val25 = request.getParameter("radio25").charAt(0);

		if (val1 == 'c') {
			v1 = 4;
		} else {
			v1 = 0;
		}
		if (val2 == 'b') {
			v2 = 4;
		} else {
			v2 = 0;
		}
		if (val3 == 'a') {
			v3 = 4;
		} else {
			v3 = 0;
		}
		if (val4 == 'a') {
			v4 = 4;
		} else {
			v4 = 0;
		}
		if (val5 == 'c') {
			v5 = 4;
		} else {
			v5 = 0;
		}
		if (val6 == 'd') {
			v6 = 4;
		} else {
			v6 = 0;
		}
		if (val7 == 'a') {
			v7 = 4;
		} else {
			v7 = 0;
		}
		if (val8 == 'd') {
			v8 = 4;
		} else {
			v8 = 0;
		}
		if (val9 == 'b') {
			v9 = 4;
		} else {
			v9 = 0;
		}
		if (val10 == 'c') {
			v10 = 4;
		} else {
			v10 = 0;
		}
		if (val11 == 'd') {
			v11 = 4;
		} else {
			v11 = 0;
		}
		if (val12 == 'd') {
			v12 = 4;
		} else {
			v12 = 0;
		}
		if (val13 == 'd') {
			v13 = 4;
		} else {
			v13 = 0;
		}
		if (val14 == 'a') {
			v14 = 4;
		} else {
			v14 = 0;
		}
		if (val15 == 'c') {
			v15 = 4;
		} else {
			v15 = 0;
		}
		if (val16 == 'a') {
			v16 = 4;
		} else {
			v16 = 0;
		}
		if (val17 == 'd') {
			v17 = 4;
		} else {
			v17 = 0;
		}
		if (val18 == 'b') {
			v18 = 4;
		} else {
			v18 = 0;
		}
		if (val19 == 'c') {
			v19 = 4;
		} else {
			v19 = 0;
		}
		if (val20 == 'c') {
			v20 = 4;
		} else {
			v20 = 0;
		}
		if (val21 == 'd') {
			v21 = 4;
		} else {
			v21 = 0;
		}
		if (val22 == 'd') {
			v22 = 4;
		} else {
			v22 = 0;
		}
		if (val23 == 'b') {
			v23 = 4;
		} else {
			v23 = 0;
		}
		if (val24 == 'a') {
			v24 = 4;
		} else {
			v24 = 0;
		}
		if (val25 == 'd') {
			v25 = 4;
		} else {
			v25 = 0;
		}
		int year = 2017;

		int totalScore = (v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 + v10
				+ v11 + v12 + v13 + v14 + v15 + v16 + v17 + v18 + v19 + v20
				+ v21 + v22 + v23 + v24 + v25 );
		
		con = connect();
		if (con != null) {

			String insertIssueSql = "INSERT INTO [dbo].[riskTest]([year],[name],[branch],[department],[totalScore]) VALUES (?,?,?,?,?);";

			java.sql.PreparedStatement insertReportStatement = null;
			
			
			
			try {
				insertReportStatement = con.prepareStatement(insertIssueSql,
						new String[] { "id" });
				insertReportStatement.setInt(1, year);
				insertReportStatement.setString(2, name);
				insertReportStatement.setString(3, branch);
				insertReportStatement.setString(4, department);
				insertReportStatement.setInt(5, totalScore);
				insertReportStatement.executeUpdate();
				insertReportStatement.close();
				con.close();
		
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("can not close connection");
					}
				}
			}

		} 

		request.setAttribute("totalScore", totalScore);
		request.setAttribute("name", name);
		request.setAttribute("branch", branch);
		request.setAttribute("department", department);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources/riskTestResults.jsp");
		view.forward(request, response);
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
