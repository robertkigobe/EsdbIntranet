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

/**
 * Servlet implementation class Login
 */
@WebServlet("/CardproductionBranchCardsSearch")
public class CardproductionBranchCardsSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String branch = request.getParameter("branch");
		String password = request.getParameter("password");
		String cif = request.getParameter("cif");

		Statement selectStatement = null;
		ResultSet results = null;

		ArrayList<CardBean> cardList = new ArrayList<CardBean>();

		cardList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [applicationDate] ,[branch] ,[title]  ,"
					+ "[fname]  ,[lname]  ,[accountType] ,[cif] ,[accountNumber]  ,"
					+ "[nationId]  ,[mobileNumber]  ,[physicalAddress]  ,"
					+ "[postalAdress]  ,[telephoneNumber]  ,[email]  ,[cardTpe]  ,"
					+ "[branchCode]  ,[printed]  ,[printDate] ,[status]  ,[nameOnCard] "
					+ "FROM [SwaziBankIntranet2016].[dbo].[CardProduction]  "
					+ "where cif='" + cif + "'";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String applicationDate = results
							.getString("applicationDate");
					// String branch = results.getString("branch");
					String title = results.getString("title");
					String fname = results.getString("fname");
					String lname = results.getString("lname");
					String accountType = results.getString("accountType");
					
					String accountNumber = results.getString("accountNumber");
					String nationId = results.getString("nationId");
					String mobileNumber = results.getString("mobileNumber");
					String physicalAddress = results
							.getString("physicalAddress");
					String postalAdress = results.getString("postalAdress");
					String telephoneNumber = results
							.getString("telephoneNumber");
					String email = results.getString("email");
					String cardTpe = results.getString("cardTpe");
					String branchCode = results.getString("branchCode");
					String printed = results.getString("printed");
					String printDate = results.getString("printDate");
					String status = results.getString("status");
					String nameOnCard = results.getString("nameOnCard");

					cardList.add(new CardBean(applicationDate, null, title,
							fname, lname, accountType, null, cif,
							accountNumber, nationId, mobileNumber,
							physicalAddress, postalAdress, telephoneNumber,
							email, cardTpe, branchCode, printed, printDate,
							status, nameOnCard));
				}

				request.setAttribute("branch", branch);
				request.setAttribute("password", password);
				request.setAttribute("cardList", cardList);
				// //////////////////////////

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
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
