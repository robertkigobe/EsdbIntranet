package technicalResources_businessBanking;

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
 * Servlet implementation class StaffLoanDelegateLoan
 */
@WebServlet("/BusinessLoanDelegateLoan")
public class BusinessLoanDelegateLoan extends HttpServlet {
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

			String sql = "SELECT  *  FROM [dbo].[corporate_loans] where  [status_of_loan] != 'Approved'";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String loanRef = results.getString("loanRef");

					pendingHodStaffLoanRequests.add(loanRef);
				}
				
				request.setAttribute("pendingHodStaffLoanRequests", pendingHodStaffLoanRequests);
		
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_bussinessBanking/bussinessBankingDelegateRequest.jsp");
		view.forward(request, response);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		
		
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;
		String loanRef = request.getParameter("loanRef");
		String status_of_loan = null;
		String industry = null;
		String applicant_name = null;
		
		
	
		
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			
			String sql = "SELECT  *  FROM [dbo].[corporate_loans] where [loanRef] = '"+loanRef+"'";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					
					applicant_name = results.getString("applicant_name");
					industry = results.getString("industry");
					status_of_loan = results.getString("status_of_loan"); 
					 
				
				}
				con.close();
				
				request.setAttribute("applicant_name", applicant_name);
				request.setAttribute("industry", industry);
				request.setAttribute("status_of_loan", status_of_loan);
				request.setAttribute("loanRef", loanRef);
				
				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_bussinessBanking/BusinessBankingLoanDelegateLoan.jsp");
				view.forward(request, response);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}
		
	}

}
