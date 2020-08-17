package sz.co.swazibank.intranet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sz.co.swazibank.beans.DirectoryBean;

/**
 * Servlet implementation class DirectorySearch
 */
@WebServlet("/DirectorySearch")
public class DirectorySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	public static String filename;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PreparedStatement selectStatement = null;
		String searchString = request.getParameter("searchString");
		ArrayList<DirectoryBean> directoryList = new ArrayList<DirectoryBean>();

		directoryList.clear();
		if (con == null) {
			con = connect();

			String sql = "SELECT [id] ,[name] ,[sirName] ,[department] ,[extension] ,[organisationalEmail] FROM [dbo].[directory] where ([name] like ? or [sirName] like ?)";

			try {

				selectStatement = con.prepareStatement(sql);
				selectStatement.setString(1, "%" + searchString + "%");
				selectStatement.setString(2, "%" + searchString + "%");

				java.sql.ResultSet results = selectStatement.executeQuery();

				while (results.next()) {
					String name = results.getString("name");
					String sirName = results.getString("sirName");
					String department = results.getString("department");
					String extension = results.getString("extension");
					String organisationalEmail = results
							.getString("organisationalEmail");

					directoryList.add(new DirectoryBean(name, sirName,
							department, extension, organisationalEmail));

				}
				request.setAttribute("directory", directoryList);
				results.close();
				selectStatement.close();
				
				disconnect(con);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/faces/directorySearch.jsp");
		view.forward(request, response);

		try {
			disconnect(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
