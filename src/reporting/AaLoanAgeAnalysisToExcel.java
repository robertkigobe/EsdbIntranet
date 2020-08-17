package reporting;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Servlet implementation class EBPowerCadView
 */
@WebServlet("/AaLoanAgeAnalysisToExcel")
public class AaLoanAgeAnalysisToExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	//String directoryName = "C:/IntranetWarehouse/Operations/EB/processed";
	ArrayList<String> fileList = new ArrayList<String>();
	String filePath;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"YYYYMMddhhmmss");
		String dateAsString = simpleDateFormat.format(new Date());

		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		Statement selectStatement = null;
		ResultSet resultSet = null;
		ArrayList<ProvisionBean> provisionList = new ArrayList<ProvisionBean>();
		provisionList.clear();

		// ///////////////////result set into poi///////////////////////////////
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("AA Loans Age Analysis Report" + ' '
				+ dateAsString);
		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell;
		

		cell = row.createCell(1);
		cell.setCellValue("Branch");
		cell = row.createCell(2);
		cell.setCellValue("LoanId");
		cell = row.createCell(3);
		cell.setCellValue("Category");
		cell = row.createCell(4);
		cell.setCellValue("Categroy Description");
		cell = row.createCell(5);
		cell.setCellValue("CustomerID");
		cell = row.createCell(6);
		cell.setCellValue("CustomerName");
		cell = row.createCell(7);
		cell.setCellValue("Currency");
		cell = row.createCell(8);
		cell.setCellValue("Product");
		cell = row.createCell(9);
		cell.setCellValue("Value Date");
		cell = row.createCell(10);
		cell.setCellValue("Maturity Date");
		cell = row.createCell(11);
		cell.setCellValue("Principal Balance");
		cell = row.createCell(12);
		cell.setCellValue("Overdue Interest");
		cell = row.createCell(13);
		cell.setCellValue("Overdue Principal");
		cell = row.createCell(14);
		cell.setCellValue("Overdue Penalty");
		cell = row.createCell(15);
		cell.setCellValue("SECURITY");
		cell = row.createCell(16);
		cell.setCellValue("Overdue Monthly Fee");
		cell = row.createCell(17);
		cell.setCellValue("Total Overdues");
		cell = row.createCell(18);
		cell.setCellValue("Days0");
		cell = row.createCell(19);
		cell.setCellValue("Days 1-10");
		cell = row.createCell(20);
		cell.setCellValue("Days 11-30");
		cell = row.createCell(21);
		cell.setCellValue("Days 31-60");
		cell = row.createCell(22);
		cell.setCellValue("Days 61-89");
		cell = row.createCell(23);
		cell.setCellValue("Days 90-180");
		cell = row.createCell(24);
		cell.setCellValue("Days 181-365");
		cell = row.createCell(25);
		cell.setCellValue("Days 366 & Above");
		cell = row.createCell(26);
		cell.setCellValue("DueS POverdue");
		cell = row.createCell(27);
		cell.setCellValue("GrcS POverdue");
		cell = row.createCell(28);
		cell.setCellValue("Pd1S POverdue");
		cell = row.createCell(29);
		cell.setCellValue("Pd2S POverdue");
		cell = row.createCell(30);
		cell.setCellValue("Pd3S POverdue");
		cell.setCellValue("Na1SPOverdue");
		cell = row.createCell(31);
		cell.setCellValue("Na2SPOverdue");
		cell = row.createCell(32);
		cell.setCellValue("Na3SPOverdue");
		cell = row.createCell(33);
		cell.setCellValue("TotalDuesClass");
		cell = row.createCell(34);
		cell.setCellValue("TotalExposure");
		cell = row.createCell(35);
		cell.setCellValue("PeriodicPrincipal");
		cell = row.createCell(36);
		cell.setCellValue("PeriodicInterest");
		cell = row.createCell(37);
		cell.setCellValue("TotalPeriodic");
		cell = row.createCell(38);
		cell.setCellValue("DisbursementAccount");
		cell = row.createCell(39);
		cell.setCellValue("SettlementAccount");
		cell = row.createCell(40);
		cell.setCellValue("LoanStatus");

		con = connect();
		if (con != null) {

			String sql = "SELECT [Branch],[LoanId],[Category],[CategroyDescription],[CustomerID],[CustomerName],[Currency],[Product],"
					+ "[ValueDate],[MaturityDate],[PrincipalBalance],[OverdueInterest],[OverduePrincipal],[OverduePenalty],[OverdueMonthlyFee],"
					+ "[TotalOverdues],[0DAYS] ,[(1-10)Days],[(11-30)Days],[(31-60)Days],[(61-89)Days],[(90-180)Days],[(181-365)Days],[366DaysAbove],"
					+ "[DueSPOverdue],[GrcSPOverdue],[Pd1SPOverdue],[Pd2Overdue],[Pd3SPOverdue],[Na1SPOverdue],[Na2SPOverdue],[Na3SPOverdue],[TotalDuesClass],"
					+ "[TotalExposure],[PeriodicPrincipal],[PeriodicInterest],[TotalPeriodic],[DisbursementAccount],[SettlementAccount],[LoanStatus] FROM [SwaziBankIntranet2016].[dbo].[AALoanAgeAnalysis]";

			try {
				selectStatement = con.createStatement();
				resultSet = selectStatement.executeQuery(sql);
				int i = 2;
				
				while (resultSet.next()) {

					row = spreadsheet.createRow(i);
					cell = row.createCell(1);
					cell.setCellValue(resultSet.getString("Branch"));
					cell = row.createCell(2);
					cell.setCellValue(resultSet.getString("LoanId"));
					cell = row.createCell(3);
					cell.setCellValue(resultSet.getString("Category"));
					cell = row.createCell(4);
					cell.setCellValue(resultSet.getString("CategroyDescription"));
					cell = row.createCell(5);
					cell.setCellValue(resultSet.getString("CustomerID"));
					cell = row.createCell(6);
					cell.setCellValue(resultSet.getString("CustomerName"));
					cell = row.createCell(7);
					cell.setCellValue(resultSet.getString("Currency"));
					cell = row.createCell(8);
					cell.setCellValue(resultSet.getString("Product"));
					cell = row.createCell(9);
					cell.setCellValue(resultSet.getString("ValueDate"));
					cell = row.createCell(10);
					cell.setCellValue(resultSet.getString("MaturityDate"));
					cell = row.createCell(11);
					cell.setCellValue(resultSet.getString("PrincipalBalance"));
					cell = row.createCell(12);
					cell.setCellValue(resultSet.getString("OverdueInterest"));
					cell = row.createCell(13);
					cell.setCellValue(resultSet.getString("OverduePrincipal"));
					cell = row.createCell(14);
					cell.setCellValue(resultSet.getString("OverduePenalty"));
					cell = row.createCell(15);
					cell.setCellValue(resultSet.getString("OverdueMonthlyFee"));
					cell = row.createCell(16);
					cell.setCellValue(resultSet.getString("TotalOverdues"));
					cell = row.createCell(17);
					cell.setCellValue(resultSet.getString("0DAYS"));
					cell = row.createCell(18);
					cell.setCellValue(resultSet.getString("(1-10)Days"));
					cell = row.createCell(19);
					cell.setCellValue(resultSet.getString("(11-30)Days"));
					cell = row.createCell(20);
					cell.setCellValue(resultSet.getString("(31-60)Days"));
					cell = row.createCell(21);
					cell.setCellValue(resultSet.getString("(61-89)Days"));
					cell = row.createCell(22);
					cell.setCellValue(resultSet.getString("(90-180)Days"));
					cell = row.createCell(23);
					cell.setCellValue(resultSet.getString("(181-365)Days"));
					cell = row.createCell(24);
					cell.setCellValue(resultSet.getString("366DaysAbove"));
					cell = row.createCell(25);
					cell.setCellValue(resultSet.getString("DueSPOverdue"));
					cell = row.createCell(26);
					cell.setCellValue(resultSet.getString("GrcSPOverdue"));
					cell = row.createCell(27);
					cell.setCellValue(resultSet.getString("Pd1SPOverdue"));
					cell = row.createCell(28);
					cell.setCellValue(resultSet.getString("Pd2Overdue"));
					cell = row.createCell(29);
					cell.setCellValue(resultSet.getString("Pd3SPOverdue"));
					cell = row.createCell(30);
					cell.setCellValue(resultSet.getString("Na1SPOverdue"));
					cell = row.createCell(31);
					cell.setCellValue(resultSet.getString("Na2SPOverdue"));
					cell = row.createCell(32);
					cell.setCellValue(resultSet.getString("Na3SPOverdue"));
					cell = row.createCell(33);
					cell.setCellValue(resultSet.getString("TotalDuesClass"));
					cell = row.createCell(34);
					cell.setCellValue(resultSet.getString("TotalExposure"));
					cell = row.createCell(35);
					cell.setCellValue(resultSet.getString("PeriodicPrincipal"));
					cell = row.createCell(36);
					cell.setCellValue(resultSet.getString("PeriodicInterest"));
					cell = row.createCell(37);
					cell.setCellValue(resultSet.getString("TotalPeriodic"));
					cell = row.createCell(38);
					cell.setCellValue(resultSet.getString("DisbursementAccount"));
					cell = row.createCell(39);
					cell.setCellValue(resultSet.getString("SettlementAccount"));
					cell = row.createCell(40);
					cell.setCellValue(resultSet.getString("LoanStatus"));

					i++;

				}
				// Write the workbook in file system
				FileOutputStream out = new FileOutputStream(new File("C:/IntranetWarehouse/Reports/MonthlyReports/ExcelExports/" + userName+" AALoansAgeAnalysis.xlsx"));
				workbook.write(out);
				out.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}		}
		
		
		response.sendRedirect(request.getContextPath() +"/ExcelExports");
		
	}

	// ///////connect & disconnect /////////////
	public static Connection connect() {

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=SwaziBankIntranet2016;user=intranetUser;password=12345678=I";

		// Declare the JDBC objects.

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = (Connection) DriverManager.getConnection(connectionUrl);
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void disconnect(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	public void listFiles(String directoryName) {
		fileList.clear();
		File directory = new File(directoryName);
		File[] fList = directory.listFiles((FileFilter) FileFileFilter.FILE);
		Arrays.sort(fList, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		for (File file : fList) {
			if (file.isFile()) {
				fileList.add(file.getName());

			}
		}
	}
}
