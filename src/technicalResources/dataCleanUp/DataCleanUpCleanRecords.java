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
@WebServlet("/DataCleanUpCleanRecords")
public class DataCleanUpCleanRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	Statement selectStatement = null;
	ResultSet results = null;



	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<DataCleanUpBean> dataCleanUpListA = new ArrayList<DataCleanUpBean>();
		

			dataCleanUpListA = getArrayListRecordsClean("SZ0010004");
			request.setAttribute("dataCleanUpListA", dataCleanUpListA);

			// //////////////////////////

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpBranchEntries.jsp");
			view.forward(request, response);

		

	}

	public ArrayList<DataCleanUpBean> getArrayListRecordsClean(String company) {

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		ArrayList<DataCleanUpBean> dataCleanUpListClean = new ArrayList<DataCleanUpBean>();
		if (con != null) {

			String sqlA = "EXEC [SwaziBankIntranet2016].[dbo].[GetAllRecords]'"
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
