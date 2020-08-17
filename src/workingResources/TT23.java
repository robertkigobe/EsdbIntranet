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
@WebServlet("/TT23")
public class TT23 extends HttpServlet {
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

		ArrayList<TT23Bean> ft23List = new ArrayList<TT23Bean>();

		ft23List.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT   [ID]      ,[TRANSACTION_CODE]      ,[TELLER_ID_1]      ,[DR_CR_MARKER]      ,[CURRENCY_1]      ,[ACCOUNT_1]      ,[CIF1]      ,[AMOUNT_LOCAL_1]      ,[AMOUNT_LOC2]      ,[AUTH_DATE1]      ,[AUTH_DATE]      ,[NARRATION1]      ,[CURRENCY_2]      ,[UNIT]      ,[CHARGE_ACCOUNT]      ,[CHARGE_CUSTOMER]      ,[AMOUNT_LOCAL_2]      ,[AMOUNT_FCY_2]      ,[NET_AMOUNT]      ,[VALUE_DATE]      ,[VALUE_DATE2]      ,[NARRATIVE_2_CHEQUE_NUMBER]      ,[CHRG_AMT_LOCAL]      ,[STATUS]      ,[CHEQUE_NUMBER]      ,[OVERRIDE]      ,[INPUTER]      ,[DATE_TIME]      ,[AUTHORIZER]      ,[BRANCH_CODE]      ,[VALUE_DATE3]      ,[AMOUNT4]  FROM [SwaziBankIntranet2016].[dbo].[TT23RDnOV2017]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String id = results.getString("ID");
				    String transaction_code = results.getString("TRANSACTION_CODE");
				    String teller_id_1 = results.getString("TELLER_ID_1");  
				    String dr_cr_marker = results.getString("DR_CR_MARKER");
				    String currency_1 = results.getString("CURRENCY_1");
				    String account_1 = results.getString("ACCOUNT_1");
				    String cif1 = results.getString("CIF1");
				    String amount_local_1 = results.getString("AMOUNT_LOCAL_1");
				    String amount_loc2 = results.getString("AMOUNT_LOC2");
				    String auth_date1 = results.getString("AUTH_DATE1");
				    String auth_date = results.getString("AUTH_DATE");
				    String narration1 = results.getString("NARRATION1");
				    String currency_2 = results.getString("CURRENCY_2");
				    String unit = results.getString("UNIT");
				    String charge_account = results.getString("CHARGE_ACCOUNT");
				    String charge_customer = results.getString("CHARGE_CUSTOMER");
				    String amount_local_2 = results.getString("AMOUNT_LOCAL_2");
				    String amount_fcy_2 = results.getString("AMOUNT_FCY_2");
				    String net_amount = results.getString("NET_AMOUNT");
				    String value_date = results.getString("VALUE_DATE");
				    String value_date2 = results.getString("VALUE_DATE2");
				    String narrative_2_cheque_number = results.getString("NARRATIVE_2_CHEQUE_NUMBER");
				    String chrg_amt_local = results.getString("CHRG_AMT_LOCAL");
				    String status = results.getString("STATUS");
				    String cheque_number = results.getString("CHEQUE_NUMBER");
				    String override = results.getString("OVERRIDE");
				    String inputer = results.getString("INPUTER");
				    String date_time = results.getString("DATE_TIME");
				    String authorizer = results.getString("AUTHORIZER");
				    String branch_code = results.getString("BRANCH_CODE");
				    String value_date3 = results.getString("VALUE_DATE3");
				    String amount4 = results.getString("AMOUNT4");

					ft23List.add(new TT23Bean( id,  transaction_code,  teller_id_1,
							 dr_cr_marker,  currency_1,  account_1,
							 cif1,  amount_local_1,  amount_loc2,
							 auth_date1,  auth_date,  narration1,
							 currency_2,  unit,  charge_account,
							 charge_customer,  amount_local_2,  amount_fcy_2,
							 net_amount,  value_date,  value_date2,
							 narrative_2_cheque_number,  chrg_amt_local,
							 status,  cheque_number,  override,
							 inputer,  date_time,  authorizer,
							 branch_code,  value_date3,  amount4));
				}
				request.setAttribute("ft23List", ft23List);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/workingResources/tt23.jsp");
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

		ArrayList<TT23Bean> ft23List = new ArrayList<TT23Bean>();

		ft23List.clear();
		String seachName = request.getParameter("seachName");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT   [ID]      ,[TRANSACTION_CODE]      ,[TELLER_ID_1]      ,[DR_CR_MARKER]      ,[CURRENCY_1]      ,[ACCOUNT_1]      ,[CIF1]      ,[AMOUNT_LOCAL_1]      ,[AMOUNT_LOC2]      ,[AUTH_DATE1]      ,[AUTH_DATE]      ,[NARRATION1]      ,[CURRENCY_2]      ,[UNIT]      ,[CHARGE_ACCOUNT]      ,[CHARGE_CUSTOMER]      ,[AMOUNT_LOCAL_2]      ,[AMOUNT_FCY_2]      ,[NET_AMOUNT]      ,[VALUE_DATE]      ,[VALUE_DATE2]      ,[NARRATIVE_2_CHEQUE_NUMBER]      ,[CHRG_AMT_LOCAL]      ,[STATUS]      ,[CHEQUE_NUMBER]      ,[OVERRIDE]      ,[INPUTER]      ,[DATE_TIME]      ,[AUTHORIZER]      ,[BRANCH_CODE]      ,[VALUE_DATE3]      ,[AMOUNT4]  FROM [SwaziBankIntranet2016].[dbo].[TT23RDnOV2017]  where [ACCOUNT_1] like '%"+seachName+"%' or [CHARGE_ACCOUNT] like '%"+seachName+"%'";

			try {
				selectStatement = con.prepareStatement(sql);
				//selectStatement.setString(1, '%' + seachName + '%');
				//selectStatement.setString(2, '%' + seachName + '%');

				results = selectStatement.executeQuery();

				while (results.next()) {

					String id = results.getString("ID");
				    String transaction_code = results.getString("TRANSACTION_CODE");
				    String teller_id_1 = results.getString("TELLER_ID_1");  
				    String dr_cr_marker = results.getString("DR_CR_MARKER");
				    String currency_1 = results.getString("CURRENCY_1");
				    String account_1 = results.getString("ACCOUNT_1");
				    String cif1 = results.getString("CIF1");
				    String amount_local_1 = results.getString("AMOUNT_LOCAL_1");
				    String amount_loc2 = results.getString("AMOUNT_LOC2");
				    String auth_date1 = results.getString("AUTH_DATE1");
				    String auth_date = results.getString("AUTH_DATE");
				    String narration1 = results.getString("NARRATION1");
				    String currency_2 = results.getString("CURRENCY_2");
				    String unit = results.getString("UNIT");
				    String charge_account = results.getString("CHARGE_ACCOUNT");
				    String charge_customer = results.getString("CHARGE_CUSTOMER");
				    String amount_local_2 = results.getString("AMOUNT_LOCAL_2");
				    String amount_fcy_2 = results.getString("AMOUNT_FCY_2");
				    String net_amount = results.getString("NET_AMOUNT");
				    String value_date = results.getString("VALUE_DATE");
				    String value_date2 = results.getString("VALUE_DATE2");
				    String narrative_2_cheque_number = results.getString("NARRATIVE_2_CHEQUE_NUMBER");
				    String chrg_amt_local = results.getString("CHRG_AMT_LOCAL");
				    String status = results.getString("STATUS");
				    String cheque_number = results.getString("CHEQUE_NUMBER");
				    String override = results.getString("OVERRIDE");
				    String inputer = results.getString("INPUTER");
				    String date_time = results.getString("DATE_TIME");
				    String authorizer = results.getString("AUTHORIZER");
				    String branch_code = results.getString("BRANCH_CODE");
				    String value_date3 = results.getString("VALUE_DATE3");
				    String amount4 = results.getString("AMOUNT4");

					ft23List.add(new TT23Bean( id,  transaction_code,  teller_id_1,
							 dr_cr_marker,  currency_1,  account_1,
							 cif1,  amount_local_1,  amount_loc2,
							 auth_date1,  auth_date,  narration1,
							 currency_2,  unit,  charge_account,
							 charge_customer,  amount_local_2,  amount_fcy_2,
							 net_amount,  value_date,  value_date2,
							 narrative_2_cheque_number,  chrg_amt_local,
							 status,  cheque_number,  override,
							 inputer,  date_time,  authorizer,
							 branch_code,  value_date3,  amount4));
				}
				
				request.setAttribute("ft23List", ft23List);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/workingResources/tt23.jsp");
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
