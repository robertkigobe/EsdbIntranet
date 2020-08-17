package technicalResources.IT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.ConnectionHelper;

public class ATMDailyGetChartData {
	private static Connection con;
	ConnectionHelper connectionHelper = new ConnectionHelper();
	Statement selectStatement = null;
	ResultSet results = null;
	
	String dateFrom, dateTo;
	

	public String GenerateJSonChartDataYearWisePassPercentage(String jsonp, String dateFrom, String dateTo)
			throws JSONException {

		String chartType = jsonp;
		
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		
		JSONObject finalJSonObj = new JSONObject();

		ATMDailyChartData cd;

		ArrayList<ATMDailyChartData> chartDataArray = new ArrayList<ATMDailyChartData>();

		cd = new ATMDailyChartData();
		cd.setYear("Branches");
		cd.setManzini((float) branchData("MZN01"));
		cd.setMbabane((float) branchData("MBN0"));
		cd.setEzulwini((float) branchData("EZL0"));
		cd.setManzinicsc((float) branchData("MCC0"));
		cd.setMastapha((float) branchData("MTS0"));
		cd.setMatata((float) branchData("MTT0"));
		cd.setMfs((float) branchData("MobileAp"));
		cd.setNhalnagano((float) branchData("NHL0"));
		cd.setPos((float) branchData("POS1"));
		cd.setPpk((float) branchData("PPK0"));
		cd.setSimunye((float) branchData("SMY0"));
		cd.setSiteki((float) branchData("STK0"));
		cd.setSptc((float) branchData("APOS"));

		chartDataArray.add(cd);

		

		JSONArray chartData = new JSONArray();
		JSONArray xaxisArr = new JSONArray();

		JSONObject xaxisObj = new JSONObject();

		JSONObject dataObj = new JSONObject();

		JSONArray manzini = new JSONArray();
		JSONArray mbabane = new JSONArray();
		
		JSONArray ezulwini = new JSONArray();
		JSONArray manzinicsc = new JSONArray();
		JSONArray matata = new JSONArray();
		JSONArray mastapha = new JSONArray();
		JSONArray mfs = new JSONArray();
		JSONArray nhalnagano = new JSONArray();
		JSONArray ppk = new JSONArray();
		JSONArray pos = new JSONArray();
		JSONArray simunye = new JSONArray();
		JSONArray siteki = new JSONArray();
		JSONArray sptc = new JSONArray();

		for (int i = 0; i < chartDataArray.size(); i++) {

			System.out.println("Json data " + i);

			xaxisArr.put(chartDataArray.get(i).getYear());

			manzini.put(chartDataArray.get(i).getManzini());
			mbabane.put(chartDataArray.get(i).getMbabane());
			
			ezulwini.put(chartDataArray.get(i).getEzulwini());
			manzinicsc.put(chartDataArray.get(i).getManzinicsc());
			matata.put(chartDataArray.get(i).getMatata());
			mastapha.put(chartDataArray.get(i).getMastapha());
			mfs.put(chartDataArray.get(i).getMfs());
			nhalnagano.put(chartDataArray.get(i).getNhalnagano());
			ppk.put(chartDataArray.get(i).getPpk());
			pos.put(chartDataArray.get(i).getPos());
			simunye.put(chartDataArray.get(i).getSimunye());
			siteki.put(chartDataArray.get(i).getSiteki());
			sptc.put(chartDataArray.get(i).getSptc());

		}

		xaxisObj.put("category", xaxisArr);
		

		chartData.put(xaxisObj);

		dataObj = new JSONObject();
		dataObj.put("name", "Manzini");
			
		dataObj.put("color", "#FF0000");
		dataObj.put("data", manzini);
		chartData.put(dataObj);
		
		dataObj = new JSONObject();
		dataObj.put("name", "Ezulwini");
		dataObj.put("color", "#641E16");
		dataObj.put("data", ezulwini);
		chartData.put(dataObj);
		
		dataObj = new JSONObject();
		dataObj.put("name", "Mbabane");
		dataObj.put("color", "#008000");
		dataObj.put("data", mbabane);
		chartData.put(dataObj);

		dataObj = new JSONObject();
		dataObj.put("name", "CASH CENTER");
		dataObj.put("color", "#85929E");
		dataObj.put("data", manzinicsc);
		chartData.put(dataObj);
		
		
		dataObj = new JSONObject();
		dataObj.put("name", "Matata");
		dataObj.put("color", "#A04000");
		dataObj.put("data", matata);
		chartData.put(dataObj);
		
		dataObj = new JSONObject();
		dataObj.put("name", "Mastapha");
		dataObj.put("color", "#229954");
		dataObj.put("data", mastapha);
		chartData.put(dataObj);
		
		dataObj = new JSONObject();
		dataObj.put("name", "Mfs");
		dataObj.put("color", "#D35400");
		dataObj.put("data", mfs);
		chartData.put(dataObj);
		
		dataObj = new JSONObject();
		dataObj.put("name", "Nhalnagano");
		dataObj.put("color", "#1ABC9C");
		dataObj.put("data", nhalnagano);
		chartData.put(dataObj);
		
		dataObj = new JSONObject();
		dataObj.put("name", "Ppk");
		dataObj.put("color", "#F7DC6F");
		dataObj.put("data", ppk);
		chartData.put(dataObj);
		
		dataObj = new JSONObject();
		dataObj.put("name", "Pos");
		dataObj.put("color", "#884EA0");
		dataObj.put("data", pos);
		chartData.put(dataObj);
		
		dataObj = new JSONObject();
		dataObj.put("name", "Simunye");
		dataObj.put("color", "#F4DO3F");
		dataObj.put("data", simunye);
		chartData.put(dataObj);
		
		dataObj = new JSONObject();
		dataObj.put("name", "Siteki");
		dataObj.put("color", "#A3E4D7");
		dataObj.put("data", siteki);
		chartData.put(dataObj);
		
		dataObj = new JSONObject();
		dataObj.put("name", "Sptc");
		dataObj.put("color", "#FADBD8");
		dataObj.put("data", sptc);
		chartData.put(dataObj);
		
		finalJSonObj.put(chartType, chartData);

		String tempStr = jsonp + "(" + finalJSonObj.toString() + ")";

		return tempStr;
	}
	
	
	public float branchData(String branch){
		float manziniAmount =0;
		con = connectionHelper.connect();
		String sql = null;
		
		if (con != null) {
			

			if(this.dateFrom == null || this.dateFrom == "" || this.dateTo == null || this.dateTo == "")
			{
				System.out.println("dateFrom is empty: " + this.dateFrom);
				 sql = "SELECT  [Transaction Date] as 'Transaction_Date'   "
						+ ",sum([Final Amount]) as 'Amount' FROM [POSTILILLION2019].[dbo].[post_trans] "
						+ "where  [Terminal ID] like '%"+branch+"%' group by [Transaction Date] "
								+ ",case 	when [Terminal ID] like '%"+branch+"%' then 'MANZINI ATM' 	  "
										+ "ELSE 'REMOTE ON US' 	  END";

			}
			else
			{
				
				System.out.println("branchData - dateFrom is : " + this.dateFrom);
				 sql = "SELECT  [Transaction Date] as 'Transaction_Date'   "
						+ ",sum([Final Amount]) as 'Amount' FROM [POSTILILLION2019].[dbo].[post_trans] "
						+ "where  [Terminal ID] like '%"+branch+"%' and [Transaction Date] > '"+this.dateFrom+"' and [Transaction Date] < '"+this.dateTo+"' group by [Transaction Date] "
								+ ",case 	when [Terminal ID] like '%"+branch+"%' then 'MANZINI ATM' 	  "
										+ "ELSE 'REMOTE ON US' 	  END";

			}

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					manziniAmount = results.getFloat("amount");
				}
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}
		
		System.out.println(manziniAmount);
		return manziniAmount;
	}

}
