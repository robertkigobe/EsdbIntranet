package technicalResources_businessBanking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class BusinessBankingLoanCreditComments
 */
@WebServlet("/BusinessBankingLoanEmBusinessBankingComments")
public class BusinessBankingLoanEmBusinessBankingComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Connection con;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		new SimpleDateFormat("yyyy-MM-dd");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		// /////////////date insert///////////////////
		Date dateOpenedN = new Date();
		String dateCreated = sdf.format(dateOpenedN);
		// /////////////setup///////////////////

		String last_modified_date = dateCreated;
		String loanRef = request.getParameter("loanRef");
		String decision = request.getParameter("decision");
		String decision_by = request.getParameter("decision_by");
		

		con = connectionHelper.connect();
		if (con != null) {
			
			String insertIssueSql = "UPDATE [dbo].[corporate_loans] SET decision = '" + decision + "',decision_by = '" + decision_by + "', status_of_loan = '" + decision + "',"
					+ "[last_modified_date]  = '" + last_modified_date + "'" + " Where [loanRef] = '" + loanRef + "'";

			java.sql.Statement insertReportStatement = null;

			try {

				insertReportStatement = con.createStatement();
				insertReportStatement.executeUpdate(insertIssueSql);

				insertReportStatement.close();
				con.close();

				response.sendRedirect(request.getContextPath() + "/BusinessBankingLoanStatus");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
