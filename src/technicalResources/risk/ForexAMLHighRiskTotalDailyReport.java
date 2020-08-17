package technicalResources.risk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import sz.co.swazibank.beans.DirectoryBean;
import util.ConnectionHelper;

@WebServlet("/ForexAMLHighRiskTotalDailyReport")
public class ForexAMLHighRiskTotalDailyReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;

		ArrayList<ForexAMLHighRiskCustomersBean> forexAMLRiskDailyList = new ArrayList<ForexAMLHighRiskCustomersBean>();

		forexAMLRiskDailyList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT "
					+ "cast([transactionDate] as Date) as 'Transaction Date'"
					+ ",[cif],[customerName]"
					+ ",[branch] "
					+ ",[currency]  "
					+ ",[destination]  "
					+ ",count([cif]) as 'transactions'  "
					+ ",sum(cast([amount] as Decimal (10,2))) as 'Total Amount' "
					+ "FROM [dbo].[forexAMLRiskDailyTransactions]  "
					+ "where [cif] in ('161445','239720','355584','111754','172141','108342','128169','241668','170259','192235','270307'"
					+ ",'270308','281321','457530','338689','188709','508754','508708','155201','109952','495018','109952','338779','528264'"
					+ ",'101861','104332','105740','106199','108192','108329','108944','113107','113934','116850','119024','119376','119965'"
					+ ",'122823','131912','135400','135671','140046','146934','159479','166173','166686','174653','178810','179838','185767'"
					+ ",'200914','202563','207478','208528','212547','218130','219454','223043','226358','228584','228626','228627','228902'"
					+ ",'229180','229996','232767','234572','234634','236330','250659','266145','268294','277455','292082','299626','301888'"
					+ ",'301905','302093','302100','302152','302236','302306','302365','302513','302584','302850','302946','303125','303569'"
					+ ",'304187','319180','513256','355412','525606','232952','576522','194640','469787','213577','492068','246789','234572'"
					+ ",'336127','119965','201546','175348','161445','239720','171415','119959','576365','217486','162539','166595','194326'"
					+ ",'584086','570326','460927','563364','377978','590273','590576','567560','570808','209657','604526','199008','208280'"
					+ ",'507993','607520','468949','569986','526105','54516','180314')  "
					+ "group by  [cif], [branch], [customerName],[currency],[destination],cast([transactionDate] as Date)";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String transactionDate = results
							.getString("Transaction Date");
					String cif = results.getString("cif");
					String customerName = results.getString("customerName");
					String branch = results.getString("branch");
					String currency = results.getString("currency");
					String destination = results.getString("destination");
					String transactions = results.getString("transactions");
					String totalAmount = results.getString("Total Amount");

					forexAMLRiskDailyList
							.add(new ForexAMLHighRiskCustomersBean(
									transactionDate, cif, customerName, branch,
									currency, destination, transactions,
									totalAmount));
				}

				request.setAttribute("forexAMLRiskDailyList",
						forexAMLRiskDailyList);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_risk/forexAMLHighRiskTotalDailyReport.jsp");
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String dateParameter = request.getParameter("dateParameter");

		Statement selectStatement = null;
		ResultSet results = null;
		String transactionDate = null;
		String cif = null;
		String customerName = null;
		String branch = null;
		String currency = null;
		String destination = null;
		String transactions = null;
		String totalAmount = null;
		Float totalTransactions = null;
		Float totalTransactionsAmount = null;
		

		ArrayList<ForexAMLHighRiskCustomersBean> forexAMLRiskDailyList = new ArrayList<ForexAMLHighRiskCustomersBean>();

		forexAMLRiskDailyList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT "
					+ "cast([transactionDate] as Date) as 'Transaction Date'"
					+ ",[cif],[customerName]"
					+ ",[branch] "
					+ ",[currency]  "
					+ ",[destination]  "
					+ ",count([cif]) as 'transactions'  "
					+ ",sum(cast([amount] as Decimal (10,2))) as 'Total Amount' "
					+ "FROM [dbo].[forexAMLRiskDailyTransactions]  "
					+ "where cast([transactionDate] as Date) = '"
					+ dateParameter
					+ "' and [cif] in ('161445','239720','355584','111754','172141','108342','128169','241668','170259','192235','270307'"
					+ ",'270308','281321','457530','338689','188709','508754','508708','155201','109952','495018','109952','338779','528264'"
					+ ",'101861','104332','105740','106199','108192','108329','108944','113107','113934','116850','119024','119376','119965'"
					+ ",'122823','131912','135400','135671','140046','146934','159479','166173','166686','174653','178810','179838','185767'"
					+ ",'200914','202563','207478','208528','212547','218130','219454','223043','226358','228584','228626','228627','228902'"
					+ ",'229180','229996','232767','234572','234634','236330','250659','266145','268294','277455','292082','299626','301888'"
					+ ",'301905','302093','302100','302152','302236','302306','302365','302513','302584','302850','302946','303125','303569'"
					+ ",'304187','319180','513256','355412','525606','232952','576522','194640','469787','213577','492068','246789','234572'"
					+ ",'336127','119965','201546','175348','161445','239720','171415','119959','576365','217486','162539','166595','194326'"
					+ ",'584086','570326','460927','563364','377978','590273','590576','567560','570808','209657','604526','199008','208280'"
					+ ",'507993','607520','468949','569986','526105','54516','180314')  "
					+ "group by  [cif], [branch], [customerName],[currency],[destination],cast([transactionDate] as Date)";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					transactionDate = results.getString("Transaction Date");
					cif = results.getString("cif");
					customerName = results.getString("customerName");
					branch = results.getString("branch");
					currency = results.getString("currency");
					destination = results.getString("destination");
					transactions = results.getString("transactions");
					totalAmount = results.getString("Total Amount");
					
					//totalTransactions += Float.valueOf(transactions);
					//totalTransactionsAmount += Float.valueOf(totalAmount);

					forexAMLRiskDailyList
							.add(new ForexAMLHighRiskCustomersBean(
									transactionDate, cif, customerName, branch,
									currency, destination, transactions,
									totalAmount));
				}

				Font blackFont = FontFactory.getFont(FontFactory.HELVETICA, 7,
						Font.NORMAL);
				Font blackFontListHeading = FontFactory.getFont(
						FontFactory.TIMES_BOLD, 18, Font.NORMAL);
				Font blackFontParameter = FontFactory.getFont(
						FontFactory.HELVETICA, 8, Font.UNDERLINE,
						new CMYKColor(75, 68, 67, 90));
				Font blackFontParameterRed = FontFactory.getFont(
						FontFactory.TIMES_BOLD, 13, Font.NORMAL);

				Font blackFontSetOff = FontFactory.getFont(
						FontFactory.HELVETICA, 10, Font.NORMAL);

				Font blackFontSetOffList = FontFactory.getFont(
						FontFactory.HELVETICA, 9, Font.NORMAL);

				Font blackFontA = FontFactory.getFont(FontFactory.HELVETICA, 7,
						Font.NORMAL);
				Font blackFont1A = FontFactory.getFont(FontFactory.HELVETICA,
						8, Font.NORMAL);

				Document document = new Document();

				try {

					response.setContentType("application/pdf");
					PdfWriter.getInstance(document, response.getOutputStream());
					document.open();

					Image img = Image
							.getInstance("C:/IntranetWarehouse/StaffLoan/logo/headerlogo1.jpg");
					document.add(img);
					
					document.add(new Paragraph("\n"));

					Paragraph financeFacilityAgreementParagraph1 = new Paragraph(
							"High Risk Daily Forex Transactions Report",
							blackFontListHeading);
					document.add(financeFacilityAgreementParagraph1);
					
					document.add(new Paragraph("\n"));

					PdfPTable ftable1 = new PdfPTable(8);
					ftable1.setWidthPercentage(100);
					ftable1.setHorizontalAlignment(Element.ALIGN_LEFT);
					ftable1.setWidths(new int[] { 2, 1, 3, 2, 2, 3, 1, 2 });
					ftable1.getDefaultCell().setBorder(Rectangle.BOX);

					ftable1.addCell(new Paragraph("Date", blackFont));
					ftable1.addCell(new Paragraph("Cif", blackFont));
					ftable1.addCell(new Paragraph("Customer Name", blackFont));
					ftable1.addCell(new Paragraph("Branch", blackFont));
					ftable1.addCell(new Paragraph("Currency", blackFont));
					ftable1.addCell(new Paragraph("Destination", blackFont));
					ftable1.addCell(new Paragraph("Count", blackFont));
					ftable1.addCell(new Paragraph("Total Amount", blackFont));
					
					for (int x = 0; x<forexAMLRiskDailyList.size(); x++) {

						ftable1.addCell(new Paragraph(forexAMLRiskDailyList.get(x).getTransactionDate(), blackFont));
						ftable1.addCell(new Paragraph(forexAMLRiskDailyList.get(x).getCif(), blackFont));
						ftable1.addCell(new Paragraph(forexAMLRiskDailyList.get(x).getCustomerName(), blackFont));
						ftable1.addCell(new Paragraph(forexAMLRiskDailyList.get(x).getBranch(), blackFont));
						ftable1.addCell(new Paragraph(forexAMLRiskDailyList.get(x).getCurrency(), blackFont));
						ftable1.addCell(new Paragraph(forexAMLRiskDailyList.get(x).getDestination(), blackFont));
						ftable1.addCell(new Paragraph(forexAMLRiskDailyList.get(x).getTransactions(), blackFont));
						ftable1.addCell(new Paragraph(forexAMLRiskDailyList.get(x).getTotalAmount(), blackFont));
						

					} 
					
					ftable1.addCell(new Paragraph("Total", blackFont));
					ftable1.addCell(new Paragraph("", blackFont));
					ftable1.addCell(new Paragraph("", blackFont));
					ftable1.addCell(new Paragraph("", blackFont));
					ftable1.addCell(new Paragraph("", blackFont));
					ftable1.addCell(new Paragraph("", blackFont));
					ftable1.addCell(new Paragraph(String.valueOf(1), blackFont));
					ftable1.addCell(new Paragraph(String.valueOf(totalTransactionsAmount), blackFont));
					
					document.add(ftable1);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				document.close();

			} catch (SQLException e) {
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
