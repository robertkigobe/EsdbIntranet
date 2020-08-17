package technicalResources;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;


/**
 * Servlet implementation class Administration
 */
@WebServlet("/EBPowerCadAdministration")
public class EBPowerCadAdministration extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String directoryName = "C:/IntranetWarehouse/Operations/EB/raw";
	ArrayList<String> fileList = new ArrayList<String>();
	ArrayList<String> records = new ArrayList<String>();
	public static Connection con;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		listFiles(directoryName);
		request.setAttribute("fileList", fileList);
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/operations/ebPowerCad.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		con = connect();
		if (con != null) {

			String docName = request.getParameter("documentUrl");

			String filePath = "C://IntranetWarehouse//Operations//EB//raw//"
					+ docName;

			File file = new File(filePath);

			records.clear();
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				records.add(in.nextLine());
			}
			Collections.sort(records);

			
			// //////////////////////////insert/////////////////

			String dropPowerCard = "DROP TABLE PowerCard;";
			String createPowerCard = "create table PowerCard ( Record [varchar](max)  NOT NULL);";
			String insertPowerCard = "INSERT INTO [dbo].[PowerCard] ([Record]) VALUES (?)";

			java.sql.PreparedStatement dropPowerCardStatement = null;
			java.sql.PreparedStatement createPowerCardStatement = null;
			java.sql.PreparedStatement insertPowerCardStatement = null;

			try {
				dropPowerCardStatement = con.prepareStatement(dropPowerCard);
				dropPowerCardStatement.executeUpdate();
				dropPowerCardStatement.close();
				createPowerCardStatement = con
						.prepareStatement(createPowerCard);
				createPowerCardStatement.executeUpdate();
				createPowerCardStatement.close();

				insertPowerCardStatement = con
						.prepareStatement(insertPowerCard);

				try {
					
					for (int x = 0; x < records.size(); x++) {
						insertPowerCardStatement.setString(1, records.get(x));
						insertPowerCardStatement.executeUpdate();
					}
					insertPowerCardStatement.close();
					response.sendRedirect(request.getContextPath() +"/EBPowerCadView");
					
					
				} catch (SQLException e) {
					System.out.println("error in insert");
				}

				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("error in connection");
			}

		}
		
		

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
