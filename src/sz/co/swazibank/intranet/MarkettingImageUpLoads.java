package sz.co.swazibank.intranet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FinanceFileUpLoads
 */
@WebServlet("/MarkettingImageUpLoads")
@MultipartConfig(maxFileSize = 100000000)
public class MarkettingImageUpLoads extends HttpServlet {
	public static Connection con;
	String message = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MarkettingImageUpLoads() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/faces/MarkettingFileUpLoads.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date no = new java.sql.Date(utilDate.getTime());
		
		
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
			String inserSql = "INSERT INTO images (no, name, page, fileUpload) values (?, ?, ?,?)";
			java.sql.PreparedStatement insertStatement;
			try {
				insertStatement = con.prepareStatement(inserSql);
				insertStatement.setDate(1, no);
				insertStatement.setString(2, name);
				insertStatement.setString(3, department);

				if (inputStream != null) {
					// fetches input stream of the upload file for the blob
					// column
					insertStatement.setBinaryStream(4, inputStream);
				}

				insertStatement.executeUpdate();

				insertStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		response.sendRedirect(request.getContextPath() + "/BriefsAndNews");
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
}
