package technicalResources;

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


@WebServlet("/NewIssue")
public class IntenralAuditNewIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntenralAuditNewIssue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/issueTrackingFaces/newIssues.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String auditCode = request.getParameter("auditCode");
		String auditType = request.getParameter("auditType");
		String financialYear = request.getParameter("financialYear");
		String quarter_v = request.getParameter("quarter_v");
		String auditDate = request.getParameter("auditDate");
		String businessUnit = request.getParameter("businessUnit");
		String department = request.getParameter("department");
		String reportTitle = request.getParameter("reportTitle");
		String datePublished = request.getParameter("datePublished");
		String exceptionTitle = request.getParameter("exceptionTitle");
		String auditObservation = request
				.getParameter("auditObservation");
		String agreedManangementAction = request
				.getParameter("agreedManangementAction");
		String actionOwner = request.getParameter("actionOwner");
		String dueDate = request.getParameter("dueDate");
		String currentImplementationStatus = request
				.getParameter("currentImplementationStatus");
		String followUpManagementcomment = request
				.getParameter("followUpManagementcomment");
		String revisedImplementationDate = request
				.getParameter("revisedImplementationDate");
		String fUAuditDate = request.getParameter("fUAuditDate");
		String actualImplementationDate = request
				.getParameter("actualImplementationDate");
		String riskOpini0n = request.getParameter("riskOpini0n");
		String reportByOpinion = request
				.getParameter("reportByOpinion");
		
		con = connect();
		if (con != null) {

			String insertIssueSql = "INSERT INTO issueTracking(auditCode,"
					 +"auditType,"
					+ "financialYear," + "quarter_v," + "auditDate,"
					+ "businessUnit," + "department," + "reportTitle,"
					+ "datePublished," + "exceptionTitle,"
					+ "auditObservation," + "agreedManangementAction,"
					+ "actionOwner," + "dueDate," + "currentImplementationStatus,"
					+ "followUpManagementcomment,"
					+ "revisedImplementationDate," + "fUAuditDate, "
					+  "actualImplementationDate, "
					+ "riskOpini0n," + "reportByOpinion"
					+ ")	VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

			java.sql.PreparedStatement insertReportStatement = null;
			
			
			
			try {
				insertReportStatement = con.prepareStatement(insertIssueSql,
						new String[] { "id" });
				insertReportStatement.setString(1, auditCode);
				insertReportStatement.setString(2, auditType);
				insertReportStatement.setString(3, financialYear);
				insertReportStatement.setString(4, quarter_v);
				insertReportStatement.setString(5, auditDate);
				insertReportStatement.setString(6, businessUnit);
				insertReportStatement.setString(7, department);
				insertReportStatement.setString(8, reportTitle);
				insertReportStatement.setString(9, datePublished);
				insertReportStatement.setString(10, exceptionTitle);
				insertReportStatement.setString(11, auditObservation);
				insertReportStatement.setString(12, agreedManangementAction);
				insertReportStatement.setString(13, actionOwner);
				insertReportStatement.setString(14, dueDate);
				insertReportStatement.setString(15, currentImplementationStatus);
				insertReportStatement.setString(16, followUpManagementcomment);
				insertReportStatement.setString(17, revisedImplementationDate);
				insertReportStatement.setString(18, fUAuditDate);
				insertReportStatement.setString(19, actualImplementationDate);
				insertReportStatement.setString(20, riskOpini0n);
				insertReportStatement.setString(21, reportByOpinion);
				insertReportStatement.executeUpdate();
				insertReportStatement.close();
				con.close();


				
				response.sendRedirect(request.getContextPath() +"/Issue");
				
				
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

		} else {
			
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
			con = DriverManager.getConnection(connectionUrl);
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
