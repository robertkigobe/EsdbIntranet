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

import util.ConnectionHelper;

@WebServlet("/DataCleanUpUpdate")
public class DataCleanUpUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	Statement selectStatement = null;
	ResultSet results = null;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String cif = request.getParameter("cif");
		String branch = request.getParameter("branch");
		String password = request.getParameter("password");
		String error = null;

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sqlA = "SELECT  *  FROM [SwaziBankIntranet2016].[dbo].[dataCleaningCustomer] where id = '" + cif + "'";

			ArrayList<DataCleanUpBean> dataCleanUpListAll = new ArrayList<DataCleanUpBean>();
			

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sqlA);
				
						
					while (results.next()) {

						String mnemonic = results.getString("mnemonic");
						String shortName = results.getString("shortName")
								.toUpperCase();
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
						String company = results.getString("company");
						String dateModified = results.getString("dateModified");
						String modifiedby = results.getString("modifiedby");

						dataCleanUpListAll.add(new DataCleanUpBean(cif,
								mnemonic, shortName, name1, name2, street,
								townCountry, nationalId, homeNo, workNo,
								mobileNo, faxno, email, passport, nextOfKin,
								nextOfKin2, postAdress, ocucpation, company,
								dateModified, modifiedby));

						request.setAttribute("cif", cif);
						request.setAttribute("shortName", shortName);
						request.setAttribute("name1", name1);
						request.setAttribute("name2", name2);
						request.setAttribute("street", street);
						request.setAttribute("townCountry", townCountry);
						request.setAttribute("nationalId", nationalId);
						request.setAttribute("homeNo", homeNo);
						request.setAttribute("workNo", workNo);
						request.setAttribute("mobileNo", mobileNo);
						request.setAttribute("faxno", faxno);
						request.setAttribute("email", email);
						request.setAttribute("passport", passport);
						request.setAttribute("nextOfKin", nextOfKin);
						request.setAttribute("nextOfKin2", nextOfKin2);
						request.setAttribute("postAdress", postAdress);
						request.setAttribute("ocucpation", ocucpation);
						request.setAttribute("company", company);
					}

					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpUpdateRecord.jsp");
					view.forward(request, response);

				}
			

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
			
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
