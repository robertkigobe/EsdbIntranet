package technicalResources.electronicBanking;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class CardProductionReport
 */
@WebServlet("/CardProductionReport")
public class CardProductionReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sdate;

		ArrayList<String> dates = new ArrayList<String>();
		dates.add("Choose Date");
		Statement selectStatement = null;
		ResultSet results = null;

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String sql = "SELECT distinct  top (7) (left([applicationDate], 10)) as sdate FROM [SwaziBankIntranet2016].[dbo].[CardProduction] where printed = 'false' order by left([applicationDate], 10) desc";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					sdate = results.getString("sdate");
					dates.add(sdate);

				}
				request.setAttribute("dates", dates);
				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionReportRequest.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			finally {
				if (con != null) {
					try {
						ConnectionHelper.disconnect(con);
					} catch (SQLException e) {

						e.printStackTrace();
					}
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		Date date = null;
		int day = 0;
		int month = 0;
		int year = 0;

		Statement selectStatement = null;
		ResultSet results = null;
		
		

		String cardTyped = request.getParameter("cardType");
		String cardBin = null;

		if (cardTyped.equals("SAVINGS")) {

			cardBin = "551272";

		} else if (cardTyped.equals("CURRENT")) {

			cardBin = "529743";

		} else if (cardTyped.equals("SIYAKHULA")) {

			cardBin = "551272";

		}

		else if (cardTyped.equals("COMPANY")) {

			cardBin = "536035";

		}

		String sdate = request.getParameter("sdate");

		String header = null;

		String applicationDate;
		String branch = null;
		String title;
		String fname;
		String lname;
		String accountType = null;
		String cif;
		String accountNumber;
		String nationId;
		String mobileNumber;
		String physicalAddress;
		String postalAdress;
		String telephoneNumber;
		String email;
		String cardTpe;
		String nameOnCard;
		String monthValue = null;
		String dayValue = null;
		String accountTyped = null;
		String branchCode = null;
		String printed = null;
		String printDate = null;
		String status = null;

		ArrayList<CardBean> cardList = new ArrayList<CardBean>();
		cardList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "select "
					+ "convert(datetime,applicationDate, 120) as 'applicationDate' , "
					+ "[SwaziBankIntranet2016].[dbo].[Card_production_Get_Host_File_Header_15052018]('"
					+ cardBin
					+ "',convert(datetime,applicationDate, 120)) as 'header',"
					+ "branch ,"
					+ "title  ,"
					+ "fname ,"
					+ "lname  ,"
					+ "accountType ,"
					+ "cif ,"
					+ "accountNumber ,"
					+ "nationId ,"
					+ "mobileNumber,"
					+ "physicalAddress ,"
					+ "postalAdress ,"
					+ "telephoneNumber,"
					+ "branchCode ,"
					+ "email ,"
					+ "cardTpe ,"
					+ "nameOnCard FROM [SwaziBankIntranet2016].[dbo].[CardProduction]"
					+ " where  accountType =  '"
					+ cardTyped
					+ "' and  left(applicationDate, 10) = '" + sdate + "'"
							+ "and printed = 'false'";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				if (!results.isBeforeFirst()) {
					
				System.out.println("in the failed results");

					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionNoData.jsp");
					view.forward(request, response);

				} else {

					while (results.next()) {

						applicationDate = results.getString("applicationDate");

						// //////////////////date ///////////////////
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

						date = sdf.parse(applicationDate);

						cal.setTime(date);
						
						day = cal.get(Calendar.DAY_OF_MONTH);

						if (day == 8) {
							dayValue = "08";
						} else if (day == 1) {
							dayValue = "01";
						} else if (day == 2) {
							dayValue = "02";
						} else if (day == 3) {
							dayValue = "03";
						} else if (day == 4) {
							dayValue = "04";
						} else if (day == 5) {
							dayValue = "05";
						} else if (day == 6) {
							dayValue = "06";
						} else if (day == 7) {
							dayValue = "07";
						} else if (day == 9) {
							dayValue = "09";
						} else {
							dayValue = String.valueOf(day);
						}

						if (month == 0) {
							monthValue = "01";
						} else if (month == 1) {
							monthValue = "02";
						} else if (month == 2) {
							monthValue = "03";
						} else if (month == 3) {
							monthValue = "04";
						} else if (month == 4) {
							monthValue = "05";
						} else if (month == 5) {
							monthValue = "06";
						} else if (month == 6) {
							monthValue = "07";
						} else if (month == 7) {
							monthValue = "08";
						} else if (month == 8) {
							monthValue = "09";
						} else if (month == 9) {
							monthValue = "10";
						} else if (month == 10) {
							monthValue = "11";
						} else if (month == 11) {
							monthValue = "12";
						}

						year = cal.get(Calendar.YEAR);
						cal.add(Calendar.YEAR, 3);

						cal2.add(Calendar.YEAR, 3);
						cal2.get(Calendar.YEAR);

						// //////////////////date ///////////////////

						String branch1 = results.getString("branch");

						if (branch1.equals("SWAZIBANK HEAD OFFICE")) {
							branch = "01";
						} else if (branch1.equals("MBABANE")) {
							branch = "02";
						} else if (branch1.equals("PIGGS PEAK")) {
							branch = "03";
						} else if (branch1.equals("MANZINI")) {
							branch = "04";
						} else if (branch1.equals("MATSAPHA")) {
							branch = "05";
						} else if (branch1.equals("NHLANGANO")) {
							branch = "06";
						} else if (branch1.equals("SITEKI")) {
							branch = "07";
						} else if (branch1.equals("SIMUNYE")) {
							branch = "08";
						} else if (branch1.equals("MATATA")) {
							branch = "09";
						} else if (branch1.equals("MBABANE COMMERCIAL")) {
							branch = "10";
						} else if (branch1.equals("OPC")) {
							branch = "11";
						} else if (branch1.equals("SIPHOFANENI")) {
							branch = "12";
						} else if (branch1.equals("EZULWINI")) {
							branch = "13";
						} else if (branch1.equals("MANZINI HUB")) {
							branch = "14";
						} else if (branch1.equals("MANZINI CASH CENTRE")) {
							branch = "15";
						}

						header = results.getString("header");
						title = results.getString("title");
						fname = results.getString("fname");
						lname = results.getString("lname");
						accountTyped = results.getString("accountType");

						if (accountTyped.equals("SAVINGS")) {
							accountType = "10";
							cardTpe = "71";
							cardBin = "551272";
							accountTyped = "CLASSIC";

						} else if (accountTyped.equals("CURRENT")) {
							accountType = "20";
							cardTpe = "72";

							accountTyped = "GOLD";
						} else if (accountTyped.equals("SIYAKHULA")) {
							accountType = "10";
							cardTpe = "70";
							cardBin = "551272";
							accountTyped = "SIYAKHULA";
						}

						else if (accountTyped.equals("COMPANY")) {
							accountType = "20";
							cardTpe = "73";
							cardBin = "536035";
							accountTyped = "BUSINESS";
						}

						cif = results.getString("cif");
						accountNumber = results.getString("accountNumber");
						nationId = results.getString("nationId");
						mobileNumber = results.getString("mobileNumber");
						physicalAddress = results.getString("physicalAddress");
						postalAdress = results.getString("postalAdress");
						telephoneNumber = results.getString("telephoneNumber");
						branchCode = results.getString("branchCode");
						email = results.getString("email");
						cardTpe = results.getString("cardTpe");
						nameOnCard = results.getString("nameOnCard");

						cardList.add(new CardBean(applicationDate, branch,
								title, fname, lname, accountType, accountTyped,
								cif, accountNumber, nationId, mobileNumber,
								physicalAddress, postalAdress, telephoneNumber,
								email, cardTpe, branchCode, printed, printDate,
								status, nameOnCard));
					}
					
					

					FileWriter file = new FileWriter(
							"C:/IntranetWarehouse/CardProduction/"
									+ accountTyped + " " + year + monthValue
									+ dayValue + ".txt");

					file.write(header + "\r\n");
					for (int i = 0; i < cardList.size(); i++) {

						file.write("D:" + cardList.get(i).getCardTpe() + "::"
								+ cardList.get(i).getCif() + ":"
								+ cardList.get(i).getNationId() + ":"
								+ cardList.get(i).getTitle() + ":"
								+ cardList.get(i).getFname() + ":"
								+ cardList.get(i).getLname() + ":"
								+ cardList.get(i).getNameOnCard() + ":::"
								+ cardList.get(i).getPhysicalAddress() + "::"
								+ cardList.get(i).getBranch() + ":"
								+ cardList.get(i).getAccountNumber() + ":"
								+ cardList.get(i).getAccountType() + ":"
								+ cardList.get(i).getAccountTyped()
								+ ":748:::::::");

						file.write("\r\n");
					}

					file.write("T" + String.format("%04d", cardList.size()));
					file.close();
					
					

					response.sendRedirect(request.getContextPath()
							+ "/CardProductionFiles");

				}
				
				
				
				

				try
				  {
				    
				    PreparedStatement ps = con.prepareStatement("UPDATE [dbo].[CardProduction] SET [printed] = 'true', [printDate] = GETDATE()  WHERE convert(datetime,applicationDate, 120)   = ? and accountNumber = ?");

				    
				    int x;
				    for (x = 0; x<cardList.size(); x++){
				    	
				    	ps.setString(1,cardList.get(x).getApplicationDate());
				    	ps.setString(2,cardList.get(x).getAccountNumber());
				    	ps.executeUpdate();
				    }
				    
				    ps.close();
				  }
				  catch (SQLException se)
				  {
				    // log the exception
				    throw se;
				  }
					
			}

			catch (SQLException e) {

				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
				if (con != null) {
					try {
						ConnectionHelper.disconnect(con);
					} catch (SQLException e) {

						e.printStackTrace();
					}
				}
			}
			
			
				
		}
	}
}
