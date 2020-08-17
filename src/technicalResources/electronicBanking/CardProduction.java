package technicalResources.electronicBanking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class History
 */
@WebServlet("/CardProduction")
public class CardProduction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String branch = request.getParameter("branch");
		request.setAttribute("branch", branch);
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {

		Date dateN = new Date();
		String cardTpe = null;
		String applicationDate = sdf.format(dateN);
		String branch = request.getParameter("branch");
		String branchCode = null;
		String password = request.getParameter("password");
		String title =   request.getParameter("title".toUpperCase());
		String fname = request.getParameter("fname").toUpperCase();
		String lname = request.getParameter("lname").toUpperCase();
		String accountType = request.getParameter("accountType").toUpperCase();
		String cif = request.getParameter("cif");
		String accountNumber = request.getParameter("accountNumber");
		String nationId = request.getParameter("nationId");
		String physicalAddress = request.getParameter("physicalAddress").toUpperCase();
		String postalAdress = request.getParameter("postalAdress").toUpperCase();
		String mobileNumber = request.getParameter("mobileNumber");
		String telephoneNumber = request.getParameter("telephoneNumber");
		String email = request.getParameter("email");

		
		//Changed by frank roman and robert 03/06/2020 to accomodate a change
		//String nameOnCard = fname + " " + lname;///////////old //////////////////
		String nameOnCard = fname + " /" + lname;

		if (accountType.equals("SAVINGS")) {
			cardTpe = "71";
		} else if (accountType.equals("CURRENT")) {
			cardTpe = "72";
		} else if (accountType.equals("SIYAKHULA")) {
			cardTpe = "70";
		} else if (accountType.equals("COMPANY")) {
			cardTpe = "73";
		} else {
			cardTpe = null;
		}
		
		if ((lname.contains("."))||(lname.contains(","))||(lname.contains("'"))||(lname.contains(")"))||(lname.contains("("))){
			String error = "You may not use special characters in the Last Name";
		request.setAttribute("branch", branch);
		request.setAttribute("error", error);
		request.setAttribute("fname", fname);
		request.setAttribute("lname", lname);
		request.setAttribute("cif", cif);
		request.setAttribute("accountNumber", accountNumber);
		request.setAttribute("nationId", nationId);
		request.setAttribute("postalAdress", postalAdress);
		request.setAttribute("physicalAddress", physicalAddress);
		request.setAttribute("mobileNumber", mobileNumber);
		request.setAttribute("telephoneNumber", telephoneNumber);
		request.setAttribute("email", email);
		request.setAttribute("title", title);
		request.setAttribute("accountType", accountType);
		request.setAttribute("password", password);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}} else
		
		
		if ((fname.contains("."))||(fname.contains(","))||(fname.contains("'"))||(fname.contains(")"))||(fname.contains("("))){
			String error = "You may not use special characters in the First Name";
		request.setAttribute("branch", branch);
		request.setAttribute("error", error);
		request.setAttribute("fname", fname);
		request.setAttribute("lname", lname);
		request.setAttribute("cif", cif);
		request.setAttribute("accountNumber", accountNumber);
		request.setAttribute("nationId", nationId);
		request.setAttribute("postalAdress", postalAdress);
		request.setAttribute("physicalAddress", physicalAddress);
		request.setAttribute("mobileNumber", mobileNumber);
		request.setAttribute("telephoneNumber", telephoneNumber);
		request.setAttribute("email", email);
		request.setAttribute("title", title);
		request.setAttribute("accountType", accountType);
		request.setAttribute("password", password);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}} else

		if (nameOnCard.length() > 25) {
			String error = "The First Name and Last Name combined can not be longer than 25 characters";
			request.setAttribute("branch", branch);
			request.setAttribute("error", error);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("cif", cif);
			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("nationId", nationId);
			request.setAttribute("postalAdress", postalAdress);
			request.setAttribute("physicalAddress", physicalAddress);
			request.setAttribute("mobileNumber", mobileNumber);
			request.setAttribute("telephoneNumber", telephoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("title", title);
			request.setAttribute("accountType", accountType);
			request.setAttribute("password", password);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (cif.length() != 6) {
			String error = "Please confirm CIF";

			request.setAttribute("error", error);
			request.setAttribute("branch", branch);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("cif", cif);
			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("nationId", nationId);
			request.setAttribute("postalAdress", postalAdress);

			request.setAttribute("physicalAddress", physicalAddress);
			request.setAttribute("mobileNumber", mobileNumber);
			request.setAttribute("telephoneNumber", telephoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("title", title);
			request.setAttribute("accountType", accountType);
			request.setAttribute("password", password);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (accountNumber.length() != 11) {
			String error = "Please confirm the Account Number";
			request.setAttribute("error", error);
			request.setAttribute("branch", branch);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("cif", cif);
			request.setAttribute("postalAdress", postalAdress);

			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("nationId", nationId);
			request.setAttribute("physicalAddress", physicalAddress);
			request.setAttribute("mobileNumber", mobileNumber);
			request.setAttribute("telephoneNumber", telephoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("title", title);
			request.setAttribute("accountType", accountType);
			request.setAttribute("password", password);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (nationId.length() != 13) {
			String error = "Please confirm the ID Number";
			request.setAttribute("error", error);
			request.setAttribute("branch", branch);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("cif", cif);
			request.setAttribute("postalAdress", postalAdress);

			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("nationId", nationId);
			request.setAttribute("physicalAddress", physicalAddress);
			request.setAttribute("mobileNumber", mobileNumber);
			request.setAttribute("telephoneNumber", telephoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("title", title);
			request.setAttribute("accountType", accountType);
			request.setAttribute("password", password);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (mobileNumber.length() != 8) {
			String error = "Please confirm the Mobile Number";
			request.setAttribute("error", error);
			request.setAttribute("branch", branch);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("cif", cif);
			request.setAttribute("postalAdress", postalAdress);

			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("nationId", nationId);
			request.setAttribute("physicalAddress", physicalAddress);
			request.setAttribute("mobileNumber", mobileNumber);
			request.setAttribute("telephoneNumber", telephoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("title", title);
			request.setAttribute("accountType", accountType);
			request.setAttribute("password", password);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (telephoneNumber.length() != 8) {
			String error = "Please confirm the Telephone Number";
			request.setAttribute("error", error);
			request.setAttribute("branch", branch);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("cif", cif);
			request.setAttribute("postalAdress", postalAdress);

			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("nationId", nationId);
			request.setAttribute("physicalAddress", physicalAddress);
			request.setAttribute("mobileNumber", mobileNumber);
			request.setAttribute("telephoneNumber", telephoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("title", title);
			request.setAttribute("accountType", accountType);
			request.setAttribute("password", password);

			

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			if (branch.equals("SWAZIBANK HEAD OFFICE")) {
				branchCode = "01";
			} else if (branch.equals("MBABANE")) {
				branchCode = "02";
			} else if (branch.equals("PIGGS PEAK")) {
				branchCode = "03";
			} else if (branch.equals("MANZINI")) {
				branchCode = "04";
			} else if (branch.equals("MATSAPHA")) {
				branchCode = "05";
			} else if (branch.equals("NHLANGANO")) {
				branchCode = "06";
			} else if (branch.equals("SITEKI")) {
				branchCode = "07";
			} else if (branch.equals("SIMUNYE")) {
				branchCode = "08";
			} else if (branch.equals("MATATA")) {
				branchCode = "09";
			} else if (branch.equals("MBABANE COMMERCIAL")) {
				branchCode = "10";
			} else if (branch.equals("OPC")) {
				branchCode = "11";
			} else if (branch.equals("SIPHOFANENI")) {
				branchCode = "12";
			} else if (branch.equals("EZULWINI")) {
				branchCode = "13";
			} else if (branch.equals("MANZINI HUB")) {
				branchCode = "14";
			} else if (branch.equals("MANZINI CASH CENTRE")) {
				branchCode = "15";
			} else {
				
				String error = "The Branch Code is empty please close the application and login again";
				request.setAttribute("error", error);
				request.setAttribute("branch", branch);
				request.setAttribute("fname", fname);
				request.setAttribute("lname", lname);
				request.setAttribute("cif", cif);
				request.setAttribute("postalAdress", postalAdress);

				request.setAttribute("accountNumber", accountNumber);
				request.setAttribute("nationId", nationId);
				request.setAttribute("physicalAddress", physicalAddress);
				request.setAttribute("mobileNumber", mobileNumber);
				request.setAttribute("telephoneNumber", telephoneNumber);
				request.setAttribute("email", email);
				request.setAttribute("title", title);
				request.setAttribute("accountType", accountType);
				request.setAttribute("password", password);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProduction.jsp");
				try {
					view.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			String printed = "false";
			String printDate = "none";
			String status = "not checked";

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();
			
			if (con != null) {

				String insertIssueSql = "INSERT INTO [dbo].[CardProduction]  ([applicationDate] ,[branch] ,[title] ,[fname] ,[lname] ,[accountType] ,[cif] ,[accountNumber] ,[nationId] ,[mobileNumber] ,[physicalAddress] ,[postalAdress] ,[telephoneNumber] ,[email] ,[cardTpe] ,[branchCode] ,[printed] ,[printDate] ,[status],[nameOnCard]) "
								+ "  VALUES   ('"
						+ applicationDate
						+ "','"
						+ branch
						+ "','"
						+ title
						+ "','"
						+ fname
						+ "','"
						+ lname
						+ "','"
						+ accountType
						+ "','"
						+ cif
						+ "','"
						+ accountNumber
						+ "','"
						+ nationId
						+ "','"
						+ mobileNumber
						+ "','"
						+ physicalAddress
						+ "','"
						+ postalAdress
						+ "','"
						+ telephoneNumber
						+ "','"
						+ email
						+ "','"
						+ cardTpe
						+ "','"
						+ branchCode
						+ "','"
						+ printed
						+ "','"
						+ printDate
						+ "','"
						+ status
						+ "','"
						+ nameOnCard
						+ "')";

				try {

					java.sql.PreparedStatement insertReportStatement = con.prepareStatement(insertIssueSql,new String[] { "id" });
					
					//insertReportStatement = con.prepareStatement(insertIssueSql,new String[] { "id" });

					insertReportStatement.executeUpdate();

					insertReportStatement.close();
					con.close();

					request.setAttribute("branch", branch);
					request.setAttribute("password", password);

					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionSuccess.jsp");

					try {
						view.forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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

}
