package technicalResources.staffLoan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class StaffLoanDelegateLoan
 */
@WebServlet("/StaffLoanEmployeeInvalidateRequest")
public class StaffLoanEmployeeInvalidateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ArrayList<String> pendingHodStaffLoanRequests = new ArrayList<String>();

		pendingHodStaffLoanRequests.clear();
		pendingHodStaffLoanRequests.add("Please select Loan reference in the email");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  *  FROM [dbo].[StaffLoan] where  [loanStatus] != 'Approved'";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String loanRef = results.getString("employeeLoanRef");

					pendingHodStaffLoanRequests.add(loanRef);
				}
				
				request.setAttribute("pendingHodStaffLoanRequests", pendingHodStaffLoanRequests);
		
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanInvalidateLoanRequest.jsp");
		view.forward(request, response);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		
		
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		String employeeLoanRef = request.getParameter("employeeLoanRef");
		
		// /////////////date insert///////////////////
		Date cancelDateN = new Date();
		String cancelDate = sdf.format(cancelDateN);
		
		// /////////////date insert///////////////////
		
		
	
		
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			
			
			
			String sql = "Update [dbo].[StaffLoan] set [loanStatus] = 'Cancelled',  [lastModifiedDate]  = '" + cancelDate + "' Where [employeeLoanRef] = '" + employeeLoanRef + "'";
					

			java.sql.Statement insertReportStatement = null;

			try {

				insertReportStatement = con.createStatement();
				insertReportStatement.executeUpdate(sql);
				insertReportStatement.close();
				con.close();

				response.sendRedirect(request.getContextPath()+ "/StaffLoanStatus");

				
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}
		
	}

}
