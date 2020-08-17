package technicalResources.loanTracking;

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

@WebServlet("/BranchLoanTrackingStatus")
public class BranchLoanTrackingStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Statement selectStatement = null;
		ResultSet results = null;

		String applicantName = null;
		String inactivity = null;
		String lastModifiedDate = null;
		float loanAmount = 0;
		String loanStatus = null;
		String iDNumber = null;
		String loanReference = null;

		ArrayList<BranchLoanStatusBean> branchPersonalLoanList = new ArrayList<BranchLoanStatusBean>();
		Integer days = null;
		Integer hours = null;
		Integer minutes = null;
		Integer second = null;
		Integer seconds = null;

		branchPersonalLoanList.clear();
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT   [applicantName],[lastModifiedDate]," + " [loanAmount]," + " [loanStatus],"
					+ " [iDNumber]," + " [loanReference],"

					+ "datediff(year,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'years',"
					+ "datediff(month,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'months',"
					+ "datediff(week,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'weeks',"
					+ "datediff(day,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'days',"
					+ "datediff(hour,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'hours',"
					+ "datediff(minute,convert(datetime,[lastModifiedDate], 120) ,GETDATE()) as 'minutes',"
					+ "datediff(second,convert(datetime,[lastModifiedDate], 120),GETDATE() ) as 'seconds' "
					+ "FROM [SwaziBankIntranet2016].[dbo].[branchLoan] where [loanStatus] != 'Loan Disbursed' order by [lastModifiedDate] desc";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					applicantName = results.getString("applicantName");
					loanAmount = results.getFloat("loanAmount");
					lastModifiedDate = results.getString("lastModifiedDate");
					loanReference = results.getString("lastModifiedDate");
					loanStatus = results.getString("loanStatus");

					second = Integer.valueOf(results.getString("seconds"));

					days = second / (60 * 60 * 24);
					hours = (second / (60 * 60)) - (days * 24);
					minutes = (second / 60) - ((hours * 60) + (days * 24 * 60));
					seconds = second - ((hours * 60 * 60) + (days * 24 * 60 * 60) + (minutes * 60));

					inactivity = days + "d: " + hours + "h: " + minutes + "m: " + seconds + "s";

					branchPersonalLoanList.add(new BranchLoanStatusBean(loanAmount, applicantName, inactivity,
							loanStatus, lastModifiedDate, iDNumber, loanReference));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		request.setAttribute("branchPersonalLoanList", branchPersonalLoanList);

		RequestDispatcher view = request.getRequestDispatcher(
				"WEB-INF/tehcnicalResources_loanTracking/branchPersonalLoanTrackingLoanStatus.jsp");
		view.forward(request, response);

		try {
			ConnectionHelper.disconnect(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources/loanTrackingNewCustomerResume.jsp");
		view.forward(request, response);

	}

}
