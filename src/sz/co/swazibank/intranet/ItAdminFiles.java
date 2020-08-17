package sz.co.swazibank.intranet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ItAdmin
 */
@WebServlet("/ItAdminFiles")
@MultipartConfig(maxFileSize = 100000000)

public class ItAdminFiles extends HttpServlet {
	public static Connection con;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ItAdmin.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String no = timeStamp();
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		InputStream inputStream = null;

		Part filePart = request.getPart("fileUpLoad");
		if (filePart != null) {
			inputStream = filePart.getInputStream();
		}

		con = connect();
		System.out.println(con);
		System.out.println(no);

		if (con != null) {

			// constructs SQL statement
			String inserSql = "INSERT INTO iTupload (no, name, department, fileUpload) values (?,?,?,?)";
			java.sql.PreparedStatement insertStatement;
			try {
				insertStatement = con.prepareStatement(inserSql);
				insertStatement.setString(1, no);
				insertStatement.setString(2, name);
				insertStatement.setString(3, department);

				if (inputStream != null) {
					// fetches input stream of the upload file for the blob
					// column
					insertStatement.setBlob(4, inputStream);
				}

				insertStatement.executeUpdate();

				insertStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		response.sendRedirect(request.getContextPath() + "/HomeServlet");
	
	}

	// ///////connect & disconnect /////////////
	public static Connection connect() {

		String url = "jdbc:mysql://localhost:3306/SwaziBankIntranet";
		String user = "root";
		String password = "";
		System.out.println(url);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			if (con == null) {
				System.out.println("connection can not be established");
			}
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public static void disconnect(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	private String timeStamp() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(
				now.getTime());
		return currentTimestamp.toString();
	}

}
