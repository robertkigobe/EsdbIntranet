package technicalResources.staffLoan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class StaffLoanEditLoan
 */
@WebServlet("/StaffLoanSetup")
public class StaffLoanSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		float funeralCover = 0;
		String loanDisbursementSupervisor = null;
		String loanDisbursementSupervisorEmail = null;
		float establishmentFee = 0;
		String emailHost = null;
		String hrPayrollMaster = null;
		String hrPayrollMasterEmail = null;
		float interestRate = 0;
		String seniorHrManagerEmail = null;
		String seniorHrManager = null;
		String securitiesSupervisor = null;
		String securitiesSupervisorEmail = null;

		if (con != null) {

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[staffLoanSetUp]";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					funeralCover = results.getFloat("funeralCover");
					establishmentFee = results.getFloat("establishmentFee");
					emailHost = results.getString("emailHost");
					hrPayrollMaster = results.getString("hrPayrollMaster");
					hrPayrollMasterEmail = results
							.getString("hrPayrollMasterEmail");
					interestRate = results.getFloat("interestRate");
					seniorHrManagerEmail = results
							.getString("seniorHrManagerEmail");
					seniorHrManager = results.getString("seniorHrManager");
					securitiesSupervisor = results
							.getString("securitiesSupervisor");
					securitiesSupervisorEmail = results
							.getString("securitiesSupervisorEmail");
					loanDisbursementSupervisor = results
							.getString("loanDisbursementSupervisor");
					loanDisbursementSupervisorEmail = results
							.getString("loanDisbursementSupervisorEmail");

				}

				request.setAttribute("funeralCover", funeralCover);
				request.setAttribute("establishmentFee", establishmentFee);
				request.setAttribute("emailHost", emailHost);
				request.setAttribute("hrPayrollMaster", hrPayrollMaster);
				request.setAttribute("hrPayrollMasterEmail",
						hrPayrollMasterEmail);
				request.setAttribute("interestRate", interestRate);
				request.setAttribute("seniorHrManagerEmail",
						seniorHrManagerEmail);
				request.setAttribute("seniorHrManager", seniorHrManager);
				request.setAttribute("securitiesSupervisor",
						securitiesSupervisor);
				request.setAttribute("securitiesSupervisorEmail",
						securitiesSupervisorEmail);
				request.setAttribute("loanDisbursementSupervisor",
						loanDisbursementSupervisor);
				request.setAttribute("loanDisbursementSupervisorEmail",
						loanDisbursementSupervisorEmail);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanSetup.jsp");
				view.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		String funeralCover = request.getParameter("funeralCover");
		String loanDisbursementSupervisor = request
				.getParameter("loanDisbursementSupervisor");
		String loanDisbursementSupervisorEmail = request
				.getParameter("loanDisbursementSupervisorEmail");
		String establishmentFee = request.getParameter("establishmentFee");
		String emailHost = request.getParameter("emailHost");
		String hrPayrollMaster = request.getParameter("hrPayrollMaster");
		String hrPayrollMasterEmail = request
				.getParameter("hrPayrollMasterEmail");
		String interestRate = request.getParameter("interestRate");
		String seniorHrManagerEmail = request
				.getParameter("seniorHrManagerEmail");
		String seniorHrManager = request.getParameter("seniorHrManager");
		String securitiesSupervisor = request
				.getParameter("securitiesSupervisor");
		String securitiesSupervisorEmail = request
				.getParameter("securitiesSupervisorEmail");

		if (con != null) {

			String insertIssueSql = "UPDATE [dbo].[staffLoanSetUp]"

			+ "SET " + "[funeralCover] = '" + funeralCover + "'"
					+ ",[establishmentFee] =  '" + establishmentFee + "'"
					+ ",[emailHost] =  '" + emailHost + "'"
					+ ",[hrPayrollMaster] =  '" + hrPayrollMaster + "'"
					+ ",[hrPayrollMasterEmail] =  '" + hrPayrollMasterEmail
					+ "'" + ",[interestRate] =  '" + interestRate + "'"
					+ ",[seniorHrManagerEmail] =  '" + seniorHrManagerEmail
					+ "'" + ",[seniorHrManager] =  '" + seniorHrManager + "'"
					+ ",[securitiesSupervisor] =  '" + securitiesSupervisor
					+ "'" + ",[securitiesSupervisorEmail] =  '"
					+ securitiesSupervisorEmail + "'"
					+ ",[loanDisbursementSupervisor] =  '"
					+ loanDisbursementSupervisor + "'"
					+ ",[loanDisbursementSupervisorEmail] =  '"
					+ loanDisbursementSupervisorEmail + "'";

			java.sql.Statement insertReportStatement = null;

			try {

				insertReportStatement = con.createStatement();
				insertReportStatement.executeUpdate(insertIssueSql);

				insertReportStatement.close();
				con.close();
				
				response.sendRedirect(request.getContextPath()
						+ "/StaffLoanSetup"); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
