package technicalResources.risk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AmlTestDetail
 */
@WebServlet("/AmlTestDetail")
public class AmlTestDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AmlTestDetail() {
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
		int v26 = 0;
		int v27 = 0;
		int v28 = 0;
		int v29 = 0;
		int v30 = 0;
		int v31 = 0;
		int v32 = 0;
		int v33 = 0;
		int v34 = 0;
		int v35 = 0;
		int v36 = 0;
		int v37 = 0;
		int v38 = 0;
		int v39 = 0;
		int v40 = 0;
		int v41 = 0;
		int v42 = 0;
		int v43 = 0;
		int v44 = 0;
		int v45 = 0;
		int v46 = 0;
		int v47 = 0;
		int v48 = 0;
		int v49 = 0;
		int v50 = 0;
		// TODO Auto-generated method stub

		String name = request.getParameter("employeeName");
		
		
		String department = request.getParameter("department");
		String branch = department;
		
		// /////////////date insert///////////////////
		
		Date dateModifiedN = new Date();
		int year = 1900 + dateModifiedN.getYear();
		
		
		

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
		char val26 = request.getParameter("radio26").charAt(0);
		char val27 = request.getParameter("radio27").charAt(0);
		char val28 = request.getParameter("radio28").charAt(0);
		char val29 = request.getParameter("radio29").charAt(0);
		char val30 = request.getParameter("radio30").charAt(0);
		char val31 = request.getParameter("radio31").charAt(0);
		char val32 = request.getParameter("radio32").charAt(0);
		char val33 = request.getParameter("radio33").charAt(0);
		char val34 = request.getParameter("radio34").charAt(0);
		char val35 = request.getParameter("radio35").charAt(0);
		char val36 = request.getParameter("radio36").charAt(0);
		char val37 = request.getParameter("radio37").charAt(0);
		char val38 = request.getParameter("radio38").charAt(0);
		char val39 = request.getParameter("radio39").charAt(0);
		char val40 = request.getParameter("radio40").charAt(0);
		char val41 = request.getParameter("radio41").charAt(0);
		char val42 = request.getParameter("radio42").charAt(0);
		char val43 = request.getParameter("radio43").charAt(0);
		char val44 = request.getParameter("radio44").charAt(0);
		char val45 = request.getParameter("radio45").charAt(0);
		char val46 = request.getParameter("radio46").charAt(0);
		char val47 = request.getParameter("radio47").charAt(0);
		char val48 = request.getParameter("radio48").charAt(0);
		char val49 = request.getParameter("radio49").charAt(0);
		char val50 = request.getParameter("radio50").charAt(0);

		if (val1 == 'b') {
			v1 = 2;
		} else {
			v1 = 0;
		}
		if (val2 == 'd') {
			v2 = 2;
		} else {
			v2 = 0;
		}
		if (val3 == 'd') {
			v3 = 2;
		} else {
			v3 = 0;
		}
		if (val4 == 'd') {
			v4 = 2;
		} else {
			v4 = 0;
		}
		if (val5 == 'c') {
			v5 = 2;
		} else {
			v5 = 0;
		}
		if (val6 == 'b') {
			v6 = 2;
		} else {
			v6 = 0;
		}
		if (val7 == 'd') {
			v7 = 2;
		} else {
			v7 = 0;
		}
		if (val8 == 'd') {
			v8 = 2;
		} else {
			v8 = 0;
		}
		if (val9 == 'a') {
			v9 = 2;
		} else {
			v9 = 0;
		}
		if (val10 == 'a') {
			v10 = 2;
		} else {
			v10 = 0;
		}
		if (val11 == 'd') {
			v11 = 2;
		} else {
			v11 = 0;
		}
		if (val12 == 'a') {
			v12 = 2;
		} else {
			v12 = 0;
		}
		if (val13 == 'd') {
			v13 = 2;
		} else {
			v13 = 0;
		}
		if (val14 == 'a') {
			v14 = 2;
		} else {
			v14 = 0;
		}
		if (val15 == 'a') {
			v15 = 2;
		} else {
			v15 = 0;
		}
		if (val16 == 'c') {
			v16 = 2;
		} else {
			v16 = 0;
		}
		if (val17 == 'd') {
			v17 = 2;
		} else {
			v17 = 0;
		}
		if (val18 == 'd') {
			v18 = 2;
		} else {
			v18 = 0;
		}
		if (val19 == 'd') {
			v19 = 2;
		} else {
			v19 = 0;
		}
		if (val20 == 'd') {
			v20 = 2;
		} else {
			v20 = 0;
		}
		if (val21 == 'd') {
			v21 = 2;
		} else {
			v21 = 0;
		}
		if (val22 == 'c') {
			v22 = 2;
		} else {
			v22 = 0;
		}
		if (val23 == 'd') {
			v23 = 2;
		} else {
			v23 = 0;
		}
		if (val24 == 'd') {
			v24 = 2;
		} else {
			v24 = 0;
		}
		if (val25 == 'c') {
			v25 = 2;
		} else {
			v25 = 0;
		}
		if (val26 == 'b') {
			v26 = 2;
		} else {
			v26 = 0;
		}
		if (val27 == 'a') {
			v27 = 2;
		} else {
			v27 = 0;
		}
		if (val28 == 'd') {
			v28 = 2;
		} else {
			v28 = 0;
		}
		if (val29 == 'c') {
			v29 = 2;
		} else {
			v29 = 0;
		}
		if (val30 == 'a') {
			v30 = 2;
		} else {
			v30 = 0;
		}
		if (val31 == 'b') {
			v31 = 2;
		} else {
			v31 = 0;
		}
		if (val32 == 'c') {
			v32 = 2;
		} else {
			v32 = 0;
		}
		if (val33 == 'd') {
			v33 = 2;
		} else {
			v33 = 0;
		}
		if (val34 == 'd') {
			v34 = 2;
		} else {
			v34 = 0;
		}
		if (val35 == 'a') {
			v35 = 2;
		} else {
			v35 = 0;
		}
		if (val36 == 'd') {
			v36 = 2;
		} else {
			v36 = 0;
		}
		if (val37 == 'd') {
			v37 = 2;
		} else {
			v37 = 0;
		}
		if (val38 == 'a') {
			v38 = 2;
		} else {
			v38 = 0;
		}
		if (val39 == 'a') {
			v39 = 2;
		} else {
			v39 = 0;
		}
		if (val40 == 'd') {
			v40 = 2;
		} else {
			v40 = 0;
		}
		if (val41 == 'd') {
			v41 = 2;
		} else {
			v41 = 0;
		}
		if (val42 == 'a') {
			v42 = 2;
		} else {
			v42 = 0;
		}
		if (val43 == 'c') {
			v43 = 2;
		} else {
			v43 = 0;
		}
		if (val44 == 'c') {
			v44 = 2;
		} else {
			v44 = 0;
		}
		if (val45 == 'c') {
			v45 = 2;
		} else {
			v45 = 0;
		}
		if (val46 == 'a') {
			v46 = 2;
		} else {
			v46 = 0;
		}
		if (val47 == 'd') {
			v47 = 2;
		} else {
			v47 = 0;
		}
		if (val48 == 'c') {
			v48 = 2;
		} else {
			v48 = 0;
		}
		if (val49 == 'a') {
			v49 = 2;
		} else {
			v49 = 0;
		}
		if (val50 == 'c') {
			v50 = 2;
		} else {
			v50 = 0;
		}
		

		int totalScore = (v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 + v10
				+ v11 + v12 + v13 + v14 + v15 + v16 + v17 + v18 + v19 + v20
				+ v21 + v22 + v23 + v24 + v25 + v26 + v27 + v28 + v29 + v30
				+ v31 + v32 + v33 + v34 + v35 + v36 + v37 + v38 + v39 + v40
				+ v41 + v42 + v43 + v44 + v45 + v46 + v47 + v48 + v49 + v50);
		
		con = connect();
		System.out.println("connected at: " + con);
		if (con != null) {

			String insertIssueSql = "INSERT INTO [dbo].[amlTest]([year],[name],[branch],[department],[totalScore]) VALUES (?,?,?,?,?);";

			java.sql.PreparedStatement insertReportStatement = null;
			
			
			
			try {
				insertReportStatement = con.prepareStatement(insertIssueSql,
						new String[] { "id" });
				insertReportStatement.setInt(1, year);
				insertReportStatement.setString(2, name);
				insertReportStatement.setString(3, department);
				insertReportStatement.setString(4, department);
				insertReportStatement.setInt(5, totalScore);
				insertReportStatement.executeUpdate();
				insertReportStatement.close();
				con.close();
		
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						
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
				.getRequestDispatcher("WEB-INF/technicalResources_risk/amlTestResults.jsp");
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
