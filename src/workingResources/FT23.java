package workingResources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class FT23
 */
@WebServlet("/FT23")
public class FT23 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String filename;

	public static Connection con;
	String userName = null;
	public void init() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;
		userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ArrayList<FT23Bean> ft23List = new ArrayList<FT23Bean>();

		ft23List.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  [ID] ,[TRANSACTION_TYPE]  ,[DEBIT_ACCT_NO] ,[DEBIT_AMOUNT] ,[CREDIT_CURRENCY] ,[PROCESSING_DATE]  ,[DEBIT_THEIR_REF] , [CREDIT_ACCT_NO]  ,[CREDIT_AMOUNT] ,[DEBIT_CURRENCY]  ,[VALUE_DATE] ,[CREDIT_THEIR_REF]   ,[PAYMENT_DETAILS]   ,[IMPUTER]  ,[AUTHORISER]  ,[CO_CODE]  ,[DATE_TIME]  ,[AMOUNT_DEBITED]   ,[AMOUNT_CREDITED]  ,[CHARGE_AMOUNT] ,[STMT_NOS]  ,[DTAE] ,[OVERRIDE] FROM [dbo].[FT23RDnOV2018]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					String id = results.getString("ID");
					String transaction_type = results
							.getString("TRANSACTION_TYPE");
					String debit_acct_no = results.getString("DEBIT_ACCT_NO");
					String debit_amount = results.getString("DEBIT_AMOUNT");
					String credit_currency = results
							.getString("CREDIT_CURRENCY");
					String processing_date = results
							.getString("PROCESSING_DATE");
					String debit_their_ref = results
							.getString("DEBIT_THEIR_REF");
					String credit_acct_no = results.getString("CREDIT_ACCT_NO");
					String credit_amount = results.getString("CREDIT_AMOUNT");
					String debit_currency = results.getString("DEBIT_CURRENCY");
					String value_date = results.getString("VALUE_DATE");
					String credit_their_ref = results
							.getString("CREDIT_THEIR_REF");
					String payment_details = results
							.getString("PAYMENT_DETAILS");
					String imputer = results.getString("IMPUTER");
					String authoriser = results.getString("AUTHORISER");
					String co_code = results.getString("CO_CODE");
					String date_time = results.getString("DATE_TIME");
					String amount_debited = results.getString("AMOUNT_DEBITED");
					String amount_credited = results
							.getString("AMOUNT_CREDITED");
					String charge_amount = results.getString("CHARGE_AMOUNT");
					String stmt_nos = results.getString("STMT_NOS");
					String dtae = results.getString("DTAE");
					String override = results.getString("OVERRIDE");

					ft23List.add(new FT23Bean(id, transaction_type,
							debit_acct_no, debit_amount, credit_currency,
							processing_date, debit_their_ref, credit_acct_no,
							credit_amount, debit_currency, value_date,
							credit_their_ref, payment_details, imputer,
							authoriser, co_code, date_time, amount_debited,
							amount_credited, charge_amount, stmt_nos, dtae,
							override));
				}
				request.setAttribute("ft23List", ft23List);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/workingResources/ft23.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PreparedStatement selectStatement = null;
		ResultSet results = null;

		ArrayList<FT23Bean> ft23List = new ArrayList<FT23Bean>();

		ft23List.clear();
		String seachName = request.getParameter("seachName");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  [ID] ,[TRANSACTION_TYPE]  ,[DEBIT_ACCT_NO] ,[DEBIT_AMOUNT] ,[CREDIT_CURRENCY] ,[PROCESSING_DATE]  ,[DEBIT_THEIR_REF] , [CREDIT_ACCT_NO]  ,[CREDIT_AMOUNT] ,[DEBIT_CURRENCY]  ,[VALUE_DATE] ,[CREDIT_THEIR_REF]   ,[PAYMENT_DETAILS]   ,[IMPUTER]  ,[AUTHORISER]  ,[CO_CODE]  ,[DATE_TIME]  ,[AMOUNT_DEBITED]   ,[AMOUNT_CREDITED]  ,[CHARGE_AMOUNT] ,[STMT_NOS]  ,[DTAE] ,[OVERRIDE] FROM [dbo].[FT23RDnOV2018]  where [DEBIT_ACCT_NO] like '%"+seachName+"%' or [CREDIT_ACCT_NO] like '%"+seachName+"%'";

			try {
				selectStatement = con.prepareStatement(sql);
				//selectStatement.setString(1, '%' + seachName + '%');
				//selectStatement.setString(2, '%' + seachName + '%');

				results = selectStatement.executeQuery();

				while (results.next()) {
					String id = results.getString("ID");
					String transaction_type = results
							.getString("TRANSACTION_TYPE");
					String debit_acct_no = results.getString("DEBIT_ACCT_NO");
					String debit_amount = results.getString("DEBIT_AMOUNT");
					String credit_currency = results
							.getString("CREDIT_CURRENCY");
					String processing_date = results
							.getString("PROCESSING_DATE");
					String debit_their_ref = results
							.getString("DEBIT_THEIR_REF");
					String credit_acct_no = results.getString("CREDIT_ACCT_NO");
					String credit_amount = results.getString("CREDIT_AMOUNT");
					String debit_currency = results.getString("DEBIT_CURRENCY");
					String value_date = results.getString("VALUE_DATE");
					String credit_their_ref = results
							.getString("CREDIT_THEIR_REF");
					String payment_details = results
							.getString("PAYMENT_DETAILS");
					String imputer = results.getString("IMPUTER");
					String authoriser = results.getString("AUTHORISER");
					String co_code = results.getString("CO_CODE");
					String date_time = results.getString("DATE_TIME");
					String amount_debited = results.getString("AMOUNT_DEBITED");
					String amount_credited = results
							.getString("AMOUNT_CREDITED");
					String charge_amount = results.getString("CHARGE_AMOUNT");
					String stmt_nos = results.getString("STMT_NOS");
					String dtae = results.getString("DTAE");
					String override = results.getString("OVERRIDE");

					ft23List.add(new FT23Bean(id, transaction_type,
							debit_acct_no, debit_amount, credit_currency,
							processing_date, debit_their_ref, credit_acct_no,
							credit_amount, debit_currency, value_date,
							credit_their_ref, payment_details, imputer,
							authoriser, co_code, date_time, amount_debited,
							amount_credited, charge_amount, stmt_nos, dtae,
							override));
				}
				request.setAttribute("ft23List", ft23List);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/workingResources/ft23.jsp");
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
