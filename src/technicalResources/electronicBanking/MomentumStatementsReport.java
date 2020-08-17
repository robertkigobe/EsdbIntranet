package technicalResources.electronicBanking;

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

@WebServlet("/MomentumStatementsReport")
public class MomentumStatementsReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;

		ArrayList<MomentumStatementBean> momentumStatementList = new ArrayList<MomentumStatementBean>();

		momentumStatementList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[momentum_statements]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String sHADOW_ACCOUNT_NBR = results.getString("SHADOW_ACCOUNT_NBR");
					String cARD_NUMBER = results.getString("CARD_NUMBER");
					String cLIENT_CODE = results.getString("CLIENT_CODE");
					String tRANSACTION_DATE = results.getString("TRANSACTION_DATE");
					String pROCESSING_DATE = results.getString("PROCESSING_DATE");
					String mICROFILM_REF_NUMBER = results.getString("MICROFILM_REF_NUMBER");
					String tRANSACTION_TYPE = results.getString("TRANSACTION_TYPE");
					String oUTLET = results.getString("OUTLET");
					String bILLING_AMT = results.getString("BILLING_AMT");
					String tRANSACTION_AMT = results.getString("TRANSACTION_AMT");
					String tRANSACTION_CCY = results.getString("TRANSACTION_CCY");

					momentumStatementList.add(new MomentumStatementBean(sHADOW_ACCOUNT_NBR, cARD_NUMBER, cLIENT_CODE,
							tRANSACTION_DATE, pROCESSING_DATE, mICROFILM_REF_NUMBER, tRANSACTION_TYPE, oUTLET,
							bILLING_AMT, tRANSACTION_AMT, tRANSACTION_CCY));
				}
				request.setAttribute("momentumStatementList", momentumStatementList);

				RequestDispatcher view = request.getRequestDispatcher(
						"WEB-INF/technicalRresources_electronicBanking/momentumStatementsReport.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		Statement selectStatement = null;
		ResultSet results = null;
		String clientcode = request.getParameter("clientcode");
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		
		ArrayList<MomentumStatementBean> momentumStatementList = new ArrayList<MomentumStatementBean>();

		momentumStatementList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT * FROM [SwaziBankIntranet2016].[dbo].[momentum_statements] where CLIENT_CODE = '"+clientcode+"' and   TRANSACTION_DATE between CAST('"+startDate+"'as date) and CAST('"+endDate+"'as date) order by cast(TRANSACTION_DATE as Date)";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String sHADOW_ACCOUNT_NBR = results.getString("SHADOW_ACCOUNT_NBR");
					String cARD_NUMBER = results.getString("CARD_NUMBER");
					String cLIENT_CODE = results.getString("CLIENT_CODE");
					String tRANSACTION_DATE = results.getString("TRANSACTION_DATE");
					String pROCESSING_DATE = results.getString("PROCESSING_DATE");
					String mICROFILM_REF_NUMBER = results.getString("MICROFILM_REF_NUMBER");
					String tRANSACTION_TYPE = results.getString("TRANSACTION_TYPE");
					String oUTLET = results.getString("OUTLET");
					String bILLING_AMT = results.getString("BILLING_AMT");
					String tRANSACTION_AMT = results.getString("TRANSACTION_AMT");
					String tRANSACTION_CCY = results.getString("TRANSACTION_CCY");

					momentumStatementList.add(new MomentumStatementBean(sHADOW_ACCOUNT_NBR, cARD_NUMBER, cLIENT_CODE,
							tRANSACTION_DATE, pROCESSING_DATE, mICROFILM_REF_NUMBER, tRANSACTION_TYPE, oUTLET,
							bILLING_AMT, tRANSACTION_AMT, tRANSACTION_CCY));
				}
				request.setAttribute("momentumStatementList", momentumStatementList);

				RequestDispatcher view = request.getRequestDispatcher(
						"WEB-INF/technicalRresources_electronicBanking/momentumStatementsReport.jsp");
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
