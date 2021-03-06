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
@WebServlet("/CardproductionLogin")
public class CardproductionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionLogin.jsp");

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String branch = request.getParameter("branch");
		String password = request.getParameter("password");

		if (branch.equals("EZULWINI") && password.equals("12345678=EZCP")) {

			// /////////////////////////
			ArrayList<CardBean> cardList = new ArrayList<CardBean>();
			cardList = getBranchCards(branch);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			request.setAttribute("cardList", cardList);
			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
			view.forward(request, response);
			

		} else if (branch.equals("SWAZIBANK HEAD OFFICE")
				&& password.equals("12345678=SHOCP")) {
			
			ArrayList<CardBean> cardList = new ArrayList<CardBean>();
			cardList = getAllBranchCards();
			request.setAttribute("cardList", cardList);
			
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionAllBranchEntries.jsp");
			view.forward(request, response);

			//response.sendRedirect(request.getContextPath()+"/CardProductionFiles");

		}

		else if (branch.equals("MBABANE") && password.equals("12345678=MBNCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);
		}

		else if (branch.equals("PIGGS PEAK")
				&& password.equals("12345678=PPKCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("MANZINI") && password.equals("12345678=MZNCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("MATSAPHA") && password.equals("12345678=MTSCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("NHLANGANO")
				&& password.equals("12345678=NHLCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("MANZINI CASH CENTRE")
				&& password.equals("12345678=MZCCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("MANZINI HUB")
				&& password.equals("12345678=MZHCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("SIPHOFANENI")
				&& password.equals("12345678=SPFCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("OPC") && password.equals("12345678=OPCCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("MBABANE COMMERCIAL")
				&& password.equals("12345678=MBCCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("MATATA") && password.equals("12345678=MTTCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("SIMUNYE") && password.equals("12345678=SMYCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		}

		else if (branch.equals("SITEKI") && password.equals("12345678=STKCP")) {

			// /////////////////////////
						ArrayList<CardBean> cardList = new ArrayList<CardBean>();
						cardList = getBranchCards(branch);
						request.setAttribute("branch", branch);
						request.setAttribute("password", password);
						request.setAttribute("cardList", cardList);
						// //////////////////////////

						RequestDispatcher view = request
								.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionBranchEntries.jsp");
						view.forward(request, response);

		} else {

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/utilities/badPassword.jsp");
			view.forward(request, response);
		}

	}
	
	public ArrayList<CardBean> getBranchCards (String branch){
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
					+ "where branch = '" + branch + "'";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String applicationDate = results.getString("applicationDate");
					//String branch = results.getString("branch");
					String title = results.getString("title");
					String fname = results.getString("fname");
					String lname = results.getString("lname");
					String accountType = results.getString("accountType");
					String cif = results.getString("cif");
					String accountNumber = results.getString("accountNumber");
					String nationId = results.getString("nationId");
					String mobileNumber = results.getString("mobileNumber");
					String physicalAddress = results.getString("physicalAddress");
					String postalAdress = results.getString("postalAdress");
					String telephoneNumber = results.getString("telephoneNumber");
					String email = results.getString("email");
					String cardTpe = results.getString("cardTpe");
					String branchCode = results.getString("branchCode");
					String printed = results.getString("printed");
					String printDate = results.getString("printDate");
					String status = results.getString("status");
					String nameOnCard = results.getString("nameOnCard");
					
					cardList.add(new CardBean(applicationDate, branch,
							title, fname, lname, accountType, null,
							cif, accountNumber, nationId, mobileNumber,
							physicalAddress, postalAdress, telephoneNumber,
							email, cardTpe, branchCode, printed, printDate,
							status, nameOnCard));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out
						.println("Cannot connect to activity database here");
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
		
		
		return cardList;
	}
	
	public ArrayList<CardBean> getAllBranchCards (){
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
					+ "FROM [SwaziBankIntranet2016].[dbo].[CardProduction]" ;

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String applicationDate = results.getString("applicationDate");
					String branch = results.getString("branch");
					String title = results.getString("title");
					String fname = results.getString("fname");
					String lname = results.getString("lname");
					String accountType = results.getString("accountType");
					String cif = results.getString("cif");
					String accountNumber = results.getString("accountNumber");
					String nationId = results.getString("nationId");
					String mobileNumber = results.getString("mobileNumber");
					String physicalAddress = results.getString("physicalAddress");
					String postalAdress = results.getString("postalAdress");
					String telephoneNumber = results.getString("telephoneNumber");
					String email = results.getString("email");
					String cardTpe = results.getString("cardTpe");
					String branchCode = results.getString("branchCode");
					String printed = results.getString("printed");
					String printDate = results.getString("printDate");
					String status = results.getString("status");
					String nameOnCard = results.getString("nameOnCard");
					
					cardList.add(new CardBean(applicationDate, branch,
							title, fname, lname, accountType, null,
							cif, accountNumber, nationId, mobileNumber,
							physicalAddress, postalAdress, telephoneNumber,
							email, cardTpe, branchCode, printed, printDate,
							status, nameOnCard));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out
						.println("Cannot connect to activity database here");
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
		
		
		return cardList;
	}

}
