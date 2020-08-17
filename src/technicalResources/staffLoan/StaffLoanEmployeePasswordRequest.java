package technicalResources.staffLoan;

import java.io.IOException;
import java.sql.Connection;
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
 * Servlet implementation class StaffLoanEmployeePasswordRequest
 */
@WebServlet("/StaffLoanEmployeePasswordRequest")
public class StaffLoanEmployeePasswordRequest extends HttpServlet {
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
						.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanEmployeePasswordRequest.jsp");

				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;
		
		String employeeCode = request.getParameter("employeeCode");

		ArrayList<StaffLoanEmployeePasswordBean> StaffLoanEmployeePasswordList = new ArrayList<StaffLoanEmployeePasswordBean>();

		StaffLoanEmployeePasswordList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT "
					+ "distinct [employeeCode],"
					+ "[title],"
					+ "[surName],"
					+ "[firstName],"
					+ "[password],"
					+ "[department] "
					+ "FROM [SwaziBankIntranet2016].[dbo].[dynamiqueEmployees] where [employeeCode] = '"+employeeCode+"'";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					 employeeCode = results.getString("employeeCode");
					String title = results.getString("title");
					String surName = results.getString("surName");
					String firstName = results.getString("firstName");
					String password = results.getString("password");
					String department = results.getString("department");

					StaffLoanEmployeePasswordList
							.add(new StaffLoanEmployeePasswordBean(
									employeeCode, title, surName, firstName,
									password, department));
				}
				request.setAttribute("StaffLoanEmployeePasswordList",
						StaffLoanEmployeePasswordList);
				
				

				RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanEmployeePasswordResponse.jsp");

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
