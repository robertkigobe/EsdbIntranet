package technicalResources.dataCleanUp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

@WebServlet("/DataCleanUpHome")
public class DataCleanUpHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	Statement selectStatement = null;
	ResultSet results = null;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<DataCleanUpBean> dataCleanUpListA = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpListC = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpListD = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpListNoCompany = new ArrayList<DataCleanUpBean>();

		ArrayList<DataCleanUpBean> dataCleanUpList1 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList2 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList3 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList4 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList5 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList6 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList7 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList8 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList9 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList10 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList11 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList12 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList13 = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList14 = new ArrayList<DataCleanUpBean>();

		ArrayList<DataCleanUpBean> dataCleanUpList1A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList2A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList3A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList4A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList5A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList6A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList7A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList8A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList9A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList10A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList11A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList12A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList13A = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList14A = new ArrayList<DataCleanUpBean>();

		ArrayList<DataCleanUpBean> dataCleanUpList1E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList2E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList3E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList4E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList5E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList6E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList7E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList8E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList9E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList10E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList11E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList12E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList13E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList14E = new ArrayList<DataCleanUpBean>();
		ArrayList<DataCleanUpBean> dataCleanUpList16A = new ArrayList<DataCleanUpBean>();

		dataCleanUpListA.clear();
		dataCleanUpListC.clear();
		dataCleanUpListD.clear();
		dataCleanUpList16A.clear();
		dataCleanUpListNoCompany.clear();

		dataCleanUpList1.clear();
		dataCleanUpList2.clear();
		dataCleanUpList3.clear();
		dataCleanUpList4.clear();
		dataCleanUpList5.clear();
		dataCleanUpList6.clear();
		dataCleanUpList7.clear();
		dataCleanUpList8.clear();
		dataCleanUpList9.clear();
		dataCleanUpList10.clear();
		dataCleanUpList11.clear();
		dataCleanUpList12.clear();
		dataCleanUpList13.clear();
		dataCleanUpList14.clear();
		dataCleanUpList1A.clear();
		dataCleanUpList2A.clear();
		dataCleanUpList3A.clear();
		dataCleanUpList4A.clear();
		dataCleanUpList5A.clear();
		dataCleanUpList6A.clear();
		dataCleanUpList7A.clear();
		dataCleanUpList8A.clear();
		dataCleanUpList9A.clear();
		dataCleanUpList10A.clear();
		dataCleanUpList11A.clear();
		dataCleanUpList12A.clear();
		dataCleanUpList13A.clear();
		dataCleanUpList14.clear();
		dataCleanUpList1E.clear();
		dataCleanUpList2E.clear();
		dataCleanUpList3E.clear();
		dataCleanUpList4E.clear();
		dataCleanUpList5E.clear();
		dataCleanUpList6E.clear();
		dataCleanUpList7E.clear();
		dataCleanUpList8E.clear();
		dataCleanUpList9E.clear();
		dataCleanUpList10E.clear();
		dataCleanUpList11E.clear();
		dataCleanUpList12E.clear();
		dataCleanUpList13E.clear();
		dataCleanUpList14E.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			// String sql = "EXEC [dbo].[GetAllRecords]";

			dataCleanUpList1A = getArrayListRecords("SZ0010001");
			dataCleanUpList2A = getArrayListRecords("SZ0010002");
			dataCleanUpList3A = getArrayListRecords("SZ0010003");
			dataCleanUpList4A = getArrayListRecords("SZ0010004");
			dataCleanUpList5A = getArrayListRecords("SZ0010005");
			dataCleanUpList6A = getArrayListRecords("SZ0010006");
			dataCleanUpList7A = getArrayListRecords("SZ0010007");
			dataCleanUpList8A = getArrayListRecords("SZ0010008");
			dataCleanUpList9A = getArrayListRecords("SZ0010009");
			dataCleanUpList10A = getArrayListRecords("SZ0010010");
			dataCleanUpList11A = getArrayListRecords("SZ0010011");
			dataCleanUpList12A = getArrayListRecords("SZ0010012");
			dataCleanUpList13A = getArrayListRecords("SZ0010013");
			dataCleanUpList14A = getArrayListRecords("SZ0010014");

			dataCleanUpList1 = getArrayListRecordsClean("SZ0010001");
			dataCleanUpList2 = getArrayListRecordsClean("SZ0010002");
			dataCleanUpList3 = getArrayListRecordsClean("SZ0010003");
			dataCleanUpList4 = getArrayListRecordsClean("SZ0010004");
			dataCleanUpList5 = getArrayListRecordsClean("SZ0010005");
			dataCleanUpList6 = getArrayListRecordsClean("SZ0010006");
			dataCleanUpList7 = getArrayListRecordsClean("SZ0010007");
			dataCleanUpList8 = getArrayListRecordsClean("SZ0010008");
			dataCleanUpList9 = getArrayListRecordsClean("SZ0010009");
			dataCleanUpList10 = getArrayListRecordsClean("SZ0010010");
			dataCleanUpList11 = getArrayListRecordsClean("SZ0010011");
			dataCleanUpList12 = getArrayListRecordsClean("SZ0010012");
			dataCleanUpList13 = getArrayListRecordsClean("SZ0010013");
			dataCleanUpList14 = getArrayListRecordsClean("SZ0010014");

			dataCleanUpListNoCompany = getArrayListRecordsNoCompany();

			int cleanRecords = dataCleanUpList1.size()
					+ dataCleanUpList2.size() + dataCleanUpList3.size()
					+ dataCleanUpList4.size() + dataCleanUpList5.size()
					+ dataCleanUpList6.size() + dataCleanUpList7.size()
					+ dataCleanUpList8.size() + dataCleanUpList9.size()
					+ dataCleanUpList10.size() + dataCleanUpList11.size()
					+ dataCleanUpList12.size() + dataCleanUpList13.size()
					+ dataCleanUpList14.size();

			int allRecords = dataCleanUpList1A.size()
					+ dataCleanUpList2A.size() + dataCleanUpList3A.size()
					+ dataCleanUpList4A.size() + dataCleanUpList5A.size()
					+ dataCleanUpList6A.size() + dataCleanUpList7A.size()
					+ dataCleanUpList8A.size() + dataCleanUpList9A.size()
					+ dataCleanUpList10A.size() + dataCleanUpList11A.size()
					+ dataCleanUpList12A.size() + dataCleanUpList13A.size()
					+ dataCleanUpList14A.size();

			int dirtyRecords = allRecords - cleanRecords;

			// dataCleanUpListA = getArrayListRecordsAll();

			// ////////////////////////END OF PROCEDURES////////////////////

			request.setAttribute("dataCleanUpListA", dataCleanUpListA.size());
			request.setAttribute("dataCleanUpList1", dataCleanUpList1.size());
			request.setAttribute("dataCleanUpList1A", dataCleanUpList1A.size());
			request.setAttribute("dataCleanUpList1E", dataCleanUpList1A.size()
					- dataCleanUpList1.size());

			request.setAttribute("dataCleanUpList2", dataCleanUpList2.size());
			request.setAttribute("dataCleanUpList2A", dataCleanUpList2A.size());
			request.setAttribute("dataCleanUpList2E", dataCleanUpList2A.size()
					- dataCleanUpList2.size());

			request.setAttribute("dataCleanUpList3", dataCleanUpList3.size());
			request.setAttribute("dataCleanUpList3A", dataCleanUpList3A.size());
			request.setAttribute("dataCleanUpList3E", dataCleanUpList3A.size()
					- dataCleanUpList3.size());

			request.setAttribute("dataCleanUpList4", dataCleanUpList4.size());
			request.setAttribute("dataCleanUpList4A", dataCleanUpList4A.size());
			request.setAttribute("dataCleanUpList4E", dataCleanUpList4A.size()
					- dataCleanUpList4.size());

			request.setAttribute("dataCleanUpList5", dataCleanUpList5.size());
			request.setAttribute("dataCleanUpList5A", dataCleanUpList5A.size());
			request.setAttribute("dataCleanUpList5E", dataCleanUpList5A.size()
					- dataCleanUpList5.size());

			request.setAttribute("dataCleanUpList6", dataCleanUpList6.size());
			request.setAttribute("dataCleanUpList6A", dataCleanUpList6A.size());
			request.setAttribute("dataCleanUpList6E", dataCleanUpList6A.size()
					- dataCleanUpList6.size());
			request.setAttribute("dataCleanUpList7", dataCleanUpList7.size());
			request.setAttribute("dataCleanUpList7A", dataCleanUpList7A.size());
			request.setAttribute("dataCleanUpList7E", dataCleanUpList7A.size()
					- dataCleanUpList7.size());
			request.setAttribute("dataCleanUpList8", dataCleanUpList8.size());
			request.setAttribute("dataCleanUpList8A", dataCleanUpList8A.size());
			request.setAttribute("dataCleanUpList8E", dataCleanUpList8A.size()
					- dataCleanUpList8.size());
			request.setAttribute("dataCleanUpList9", dataCleanUpList9.size());
			request.setAttribute("dataCleanUpList9A", dataCleanUpList9A.size());
			request.setAttribute("dataCleanUpList9E", dataCleanUpList9A.size()
					- dataCleanUpList9.size());
			request.setAttribute("dataCleanUpList10", dataCleanUpList10.size());
			request.setAttribute("dataCleanUpList10A",
					dataCleanUpList10A.size());
			request.setAttribute("dataCleanUpList10E",
					dataCleanUpList10A.size() - dataCleanUpList10.size());

			request.setAttribute("dataCleanUpList11", dataCleanUpList11.size());
			request.setAttribute("dataCleanUpList11A",
					dataCleanUpList11A.size());
			request.setAttribute("dataCleanUpList11E",
					dataCleanUpList11A.size() - dataCleanUpList11.size());

			request.setAttribute("dataCleanUpList12", dataCleanUpList12.size());
			request.setAttribute("dataCleanUpList12A",
					dataCleanUpList12A.size());
			request.setAttribute("dataCleanUpList12E",
					dataCleanUpList12A.size() - dataCleanUpList12.size());

			request.setAttribute("dataCleanUpList13", dataCleanUpList13.size());
			request.setAttribute("dataCleanUpList13A",
					dataCleanUpList13A.size());
			request.setAttribute("dataCleanUpList13E",
					dataCleanUpList13A.size() - dataCleanUpList13.size());

			request.setAttribute("dataCleanUpList14", dataCleanUpList14.size());
			request.setAttribute("dataCleanUpList14A",
					dataCleanUpList14A.size());
			request.setAttribute("dataCleanUpList14E",
					dataCleanUpList14A.size() - dataCleanUpList14.size());

			request.setAttribute("dataCleanUpList16A",
					dataCleanUpList16A.size());
			request.setAttribute("dataCleanUpListNoCompany",
					dataCleanUpListNoCompany.size());

			request.setAttribute("cleanRecords", cleanRecords);
			request.setAttribute("allRecords", allRecords);

			request.setAttribute("dirtyRecords", dirtyRecords);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpHome.jsp");
			view.forward(request, response);
		}

	}

	ArrayList<DataCleanUpBean> getArrayListRecords(String company) {

		String sqlA = "EXEC [SwaziBankIntranet2016].[dbo].[GetCompanyData] '"
				+ company + "'";

		ArrayList<DataCleanUpBean> dataCleanUpList = new ArrayList<DataCleanUpBean>();

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

				dataCleanUpList.add(new DataCleanUpBean(cif, mnemonic,
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
		return dataCleanUpList;

	}

	ArrayList<DataCleanUpBean> getArrayListRecordsClean(String company) {

		String sqlA = "EXEC [SwaziBankIntranet2016].[dbo].[GetCompanyDataClean] '"
				+ company + "'";

		ArrayList<DataCleanUpBean> dataCleanUpListClean = new ArrayList<DataCleanUpBean>();

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
		return dataCleanUpListClean;

	}

	ArrayList<DataCleanUpBean> getArrayListRecordsNoCompany() {

		String sqlA = "EXEC [SwaziBankIntranet2016].[dbo].[GetCompanyDataNoCompany] ";

		ArrayList<DataCleanUpBean> dataCleanUpListNoCompany = new ArrayList<DataCleanUpBean>();

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

				dataCleanUpListNoCompany.add(new DataCleanUpBean(cif, mnemonic,
						shortName, name1, name2, street, townCountry,
						nationalId, homeNo, workNo, mobileNo, faxno, email,
						passport, nextOfKin, nextOfKin2, postAdress,
						ocucpation, null, dateModified, modifiedby));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot connect to activity database here");

		}
		return dataCleanUpListNoCompany;

	}

	ArrayList<DataCleanUpBean> getArrayListRecordsAll() {

		String sqlA = "SELECT  *  FROM [SwaziBankIntranet2016].[dbo].[dataCleaningCustomer]";

		ArrayList<DataCleanUpBean> dataCleanUpListAll = new ArrayList<DataCleanUpBean>();

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
				String company = results.getString("company");
				String dateModified = results.getString("dateModified");
				String modifiedby = results.getString("modifiedby");

				dataCleanUpListAll.add(new DataCleanUpBean(cif, mnemonic,
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
		return dataCleanUpListAll;

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		int a = 0;
		int b1 = 0; 
		String b2 = null;
		int b3 = 0;
		int b4 = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		String cif = request.getParameter("cif");

		String branch = request.getParameter("branch");
		
	
		String password = request.getParameter("password");

		String shortName = request.getParameter("shortName");
		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		String street = request.getParameter("street");
		String townCountry = request.getParameter("townCountry");
		String nationalId = request.getParameter("nationalId");
		
		a = Integer.valueOf(nationalId.substring(0, 1)) + 
				Integer.valueOf(nationalId.substring(2, 3)) +
				Integer.valueOf(nationalId.substring(4, 5)) +
				Integer.valueOf(nationalId.substring(6, 7)) +
				Integer.valueOf(nationalId.substring(8, 9)) +
				Integer.valueOf(nationalId.substring(10, 11));
		 b1 = Integer.valueOf((nationalId.substring(0, 1))  
				+(nationalId.substring(2, 3)) 
				+(nationalId.substring(4, 5)) 
				+(nationalId.substring(6, 7)) 
				+(nationalId.substring(8, 9)) 
				+(nationalId.substring(10, 11)))*2; 
		 b2 = String.valueOf(b1);
		 b3 = b2.length();
		 
		 for(int x=0; x<b3; x++){
			 
			 b4 += Integer.valueOf(b2.substring(x));
		 }
		 
		c = b4 + a;
		
		if (String.valueOf(c).substring(String.valueOf(c).length()-1).equals(String.valueOf(0))){
			d = 0;
		}
		else {
		d = 10 - Integer.valueOf(String.valueOf(c).substring(String.valueOf(c).length()-1));
		}
		String homeNo = request.getParameter("homeNo");
		String workNo = request.getParameter("workNo");
		String mobileNo = request.getParameter("mobileNo");
		String faxno = request.getParameter("faxno");
		String email = request.getParameter("email");
		
		System.out.println(email);
		
		String passport = request.getParameter("passport");
		String nextOfKin = request.getParameter("nextOfKin");
		String nextOfKin2 = request.getParameter("nextOfKin2");
		String postAdress = request.getParameter("postAdress");
		String ocucpation = request.getParameter("ocucpation");
		String company = request.getParameter("company");
		String dateModified = request.getParameter("dateModified");
		String modifiedby = request.getParameter("modifiedby");

		if (!(shortName.equals(name1))) {
			String error = "Short Name and First Name should be the same";

			request.setAttribute("error", error);
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
			
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpUpdateRecord.jsp");
			view.forward(request, response);
		}

		else if (!(homeNo.length() == 8) ) {
			String error = "Home Telephone should 8 characters long";
			request.setAttribute("error", error);
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
			
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpUpdateRecord.jsp");
			view.forward(request, response);
		}

		else if (!(workNo.length() == 8) ) {
			String error = "Work Telephone should 8 characters long";
			request.setAttribute("error", error);
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
			
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpUpdateRecord.jsp");
			view.forward(request, response);
		}

		else if (!(mobileNo.length() == 8) ) {
			String error = "Mobile Telephone should 8 characters long";
			request.setAttribute("error", error);
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
			
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpUpdateRecord.jsp");
			view.forward(request, response);
		}
		else if (!(nextOfKin2.length() == 8) ) {
			String error = "Next of Kin Telephone should 8 characters long";
			request.setAttribute("error", error);
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
			
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpUpdateRecord.jsp");
			view.forward(request, response);
		}
		
		
		
		else if (!(nationalId.length() == 13) && !(nationalId.substring(13).equals(String.valueOf(d)))) {
			String error = "Please check the National ID";

			request.setAttribute("error", error);
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
			
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_dataCleanUp/dataCleanUpUpdateRecord.jsp");
			view.forward(request, response);
		}
		
		

		else

		
		{

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();
			if (con != null) {

				String insertReportStatementUpdate = "UPDATE [dbo].[dataCleaningCustomer]   SET [name1] = '"
						+ name1
						+ "'      "
						+ ",[name2] = '"
						+ name2
						+ "'      "
						+ ",[street] = '"
						+ street
						+ "'      "
						+ ",[townCountry] = '"
						+ townCountry
						+ "'      "
						+ ",[nationalId] = '"
						+ nationalId
						+ "'      "
						+ ",[homeNo] = '"
						+ homeNo
						+ "'      "
						+ ",[workNo] = '"
						+ workNo
						+ "'      ,[mobileNo] = '"
						+ mobileNo
						+ "'      ,[faxno] = '"
						+ faxno
						+ "'      ,[email] = '"
						+ email
						+ "'      ,[passport] = '"
						+ passport
						+ "'      ,[nextOfKin] = '"
						+ nextOfKin
						+ "'      ,[nextOfKin2] = '"
						+ nextOfKin2
						+ "'      ,[postAdress] = '"
						+ postAdress
						+ "'      ,[ocucpation] = '"
						+ ocucpation
						+ "'      ,[dateModified] = '"
						+ dateModified
						+ "'      ,[modifiedby] = '"
						+ modifiedby
						+ "' WHERE [shortName] = '" + shortName + "'";

				java.sql.PreparedStatement insertReportStatement = null;

				try {

					insertReportStatement = con
							.prepareStatement(insertReportStatementUpdate);

					insertReportStatement.executeUpdate();

					insertReportStatement.close();
					con.close();


					// //////////////////////////
					response.sendRedirect(request.getContextPath()
							+ "/DataCleanUpCleanRecords");

					
					


				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				/////////////////////////////////////
				
				

				finally {
					if (con != null) {
						try {
							ConnectionHelper.disconnect(con);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			}

		}

	}
	
	

}
