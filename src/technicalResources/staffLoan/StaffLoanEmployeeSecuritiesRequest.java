package technicalResources.staffLoan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class StaffLoanHodRequest
 */
@WebServlet("/StaffLoanEmployeeSecuritiesRequest")
public class StaffLoanEmployeeSecuritiesRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;
		String employeeCode = null;

		ArrayList<String> employeeCodes = new ArrayList<String>();

		employeeCodes.clear();

		employeeCodes.add("Select your Employee No.");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String sql1 = "SELECT distinct[employeeCode]  FROM [SwaziBankIntranet2016].[dbo].[dynamiqueEmployees] order by EmployeeCode";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql1);

				while (results.next()) {
					employeeCode = results.getString("employeeCode");

					employeeCodes.add(employeeCode);
				}
				request.setAttribute("employeeCodes", employeeCodes);
				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanEmployeeSecuritiesRequestLogin.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

		
		String employeeCode = request.getParameter("employeeCode");
		String password = request.getParameter("password");
		
		System.out.println("Employee code is: =========>>>"+employeeCode);
		
	

		Statement selectStatement = null;
		ResultSet results = null;
		ArrayList<String> pendingEmployeeSecurityStaffLoanRequests = new ArrayList<String>();

		pendingEmployeeSecurityStaffLoanRequests.clear();
		pendingEmployeeSecurityStaffLoanRequests.add("Please select Loan reference in the email");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String sql = "SELECT  [employeeCode],[password] FROM [SwaziBankIntranet2016].[dbo].[dynamiqueEmployees] "
					+ "where [employeeCode] = '"
					+ employeeCode + "'  ";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				if (!results.next()) {
					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/utilities/badPassword.jsp");
					view.forward(request, response);
				} else {

					String sql2 = "SELECT  *  FROM [dbo].[StaffLoan] where  [loanStatus] = 'Pending Securities Preparation' and [employeeCode] = '"+employeeCode+"'";
					try {
						selectStatement = con.createStatement();
						results = selectStatement.executeQuery(sql2);

						while (results.next()) {

							String loanRef = results
									.getString("employeeLoanRef");

							pendingEmployeeSecurityStaffLoanRequests
									.add(loanRef);
						}

						
						request.setAttribute(
								"pendingEmployeeSecurityStaffLoanRequests",
								pendingEmployeeSecurityStaffLoanRequests);

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanEmployeeSecuritiesRequest.jsp");
						view.forward(request, response);

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out
								.println("Cannot connect to activity database here");
					}
				}

			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}
}
