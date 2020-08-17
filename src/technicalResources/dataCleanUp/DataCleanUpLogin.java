package technicalResources.dataCleanUp;

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

import technicalResources.electronicBanking.CardBean;
import util.ConnectionHelper;

/**
 * Servlet implementation class StaffLoanEmployeeRequest
 */
@WebServlet("/DataCleanUpLogin")
public class DataCleanUpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	Statement selectStatement = null;
	ResultSet results = null;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpLoginRequest.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<DataCleanUpBean> dataCleanUpListA = new ArrayList<DataCleanUpBean>();
		String branch = request.getParameter("branch");
		String password = request.getParameter("password");
		
		

		if (branch.equals("EZULWINI") && password.equals("12345678=EZDC")) {

			// /////////////////////////
			String branchA = "SZ0010002";
			dataCleanUpListA = getArrayListRecordsClean(branchA);
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		} else if (branch.equals("SWAZIBANK HEAD OFFICE")
				&& password.equals("12345678=SHODC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010002");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MBABANE") && password.equals("12345678=MBNDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010002");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);
		}

		else if (branch.equals("PIGGS PEAK")
				&& password.equals("12345678=PPKDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010003");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MANZINI") && password.equals("12345678=MZNDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010004");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MATSAPHA") && password.equals("12345678=MTSDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010005");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("NHLANGANO")
				&& password.equals("12345678=NHLDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010006");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MANZINI CASH CENTRE")
				&& password.equals("12345678=MZCDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010015");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MANZINI HUB")
				&& password.equals("12345678=MZHDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010014");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("SIPHOFANENI")
				&& password.equals("12345678=SPFDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010012");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("OPC") && password.equals("12345678=OPCDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010011");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MBABANE COMMERCIAL")
				&& password.equals("12345678=MBCDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010010");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("MATATA") && password.equals("12345678=MTTDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010009");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("SIMUNYE") && password.equals("12345678=SMYDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010008");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		}

		else if (branch.equals("SITEKI") && password.equals("12345678=STKDC")) {

			dataCleanUpListA = getArrayListRecordsClean("SZ0010007");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);
			request.setAttribute("branch", branch);
			request.setAttribute("password", password);
			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		} else {

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/utilities/badPassword.jsp");
			view.forward(request, response);
		}

	}

	public ArrayList<DataCleanUpBean> getArrayListRecordsClean(String company) {

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		ArrayList<DataCleanUpBean> dataCleanUpListClean = new ArrayList<DataCleanUpBean>();
		if (con != null) {

			String sqlA = "EXEC [SwaziBankIntranet2016].[dbo].[GetCompanyData]'"
					+ company + "'";


			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sqlA);
				while (results.next()) {
					
					String cif = results.getString("id");

					String mnemonic = results.getString("mnemonic");
					String shortName = results.getString("shortName");
					String name1 = results.getString("name1");
					String name2 = results.getString("name2");
					String street = results.getString("street");
					String townCountry = results.getString("townCountry");
					String nationalId = results.getString("nationalId");
					String homeNo = results.getString("homeNo");
					String workNo = results.getString("workNo");
					String mobileNo = results.getString("mobileNo");
					String faxno = results.getString("faxno");
					String email = results.getString("email");
					String passport = results.getString("passport");
					String nextOfKin = results.getString("nextOfKin");
					String nextOfKin2 = results.getString("nextOfKin2");
					String postAdress = results.getString("postAdress");
					String ocucpation = results.getString("ocucpation");
					// String company = results.getString("company");
					String dateModified = results.getString("dateModified");
					String modifiedby = results.getString("modifiedby");

					dataCleanUpListClean.add(new DataCleanUpBean(cif, mnemonic,
							shortName, name1, name2, street, townCountry,
							nationalId, homeNo, workNo, mobileNo, faxno, email,
							passport, nextOfKin, nextOfKin2, postAdress,
							ocucpation, company, dateModified, modifiedby));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");

			}


		} 
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataCleanUpListClean;


	}

}
