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
@WebServlet("/ProvisionToExcel")
public class ProvisionToExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	String directoryName = "C:/IntranetWarehouse/Operations/EB/processed";
	ArrayList<String> fileList = new ArrayList<String>();
	String filePath;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"YYYYMMddhhmmss");
		String dateAsString = simpleDateFormat.format(new Date());

		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		new ArrayList<String>();

		Statement selectStatement = null;
		ResultSet resultSet = null;
		ArrayList<ProvisionBean> provisionList = new ArrayList<ProvisionBean>();
		provisionList.clear();

		// ///////////////////result set into poi///////////////////////////////
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Provisions Report" + ' '
				+ dateAsString);
		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell;

		cell = row.createCell(1);
		cell.setCellValue("YEAR");
		cell = row.createCell(2);
		cell.setCellValue("Quarter");
		cell = row.createCell(3);
		cell.setCellValue("Account Number");
		cell = row.createCell(4);
		cell.setCellValue("CONTRACT ID");
		cell = row.createCell(5);
		cell.setCellValue("DRAWDOWN LINK");
		cell = row.createCell(6);
		cell.setCellValue("BRANCH");
		cell = row.createCell(7);
		cell.setCellValue("DEPARTMENT");
		cell = row.createCell(8);
		cell.setCellValue("CUSTOMER");
		cell = row.createCell(9);
		cell.setCellValue("PRODUCT TYPE");
		cell = row.createCell(10);
		cell.setCellValue("YEAH END BALANCE");
		cell = row.createCell(11);
		cell.setCellValue("YEAR END RATE");
		cell = row.createCell(12);
		cell.setCellValue("YEAR END PROVISION");
		cell = row.createCell(13);
		cell.setCellValue("CURRENT BALANCE");
		cell = row.createCell(14);
		cell.setCellValue("CURRENT RATE");
		cell = row.createCell(15);
		cell.setCellValue("SECURITY");
		cell = row.createCell(16);
		cell.setCellValue("CURRENT PROVISIONS");
		cell = row.createCell(17);
		cell.setCellValue("PAST DUES");
		cell = row.createCell(18);
		cell.setCellValue("COMMENTS");

		con = connect();
		if (con != null) {

			String sql = "SELECT [YEAR],[QUARTER] ,[AccNo] ,[CONTRACT_IDs]  ,[DrawDown_link] ,[Branch] ,[Dept] ,[Customer] ,"
					+ "[Type] ,[YearEndBalance] ,[YearEndRate] ,[YearEndProv]  ,[CurrentBalance] ,[CurrentRate] ,[SECURITY] ,"
					+ "[CurrentProvisions] ,[PastDues],[Comments],[OLD_ACCT]  FROM [SwaziBankIntranet2016].[dbo].[Final_Provisions_Report2]";

			try {
				selectStatement = con.createStatement();
				resultSet = selectStatement.executeQuery(sql);
				int i = 2;
				
				while (resultSet.next()) {

					row = spreadsheet.createRow(i);
					cell = row.createCell(1);
					cell.setCellValue(resultSet.getString("YEAR"));
					cell = row.createCell(2);
					cell.setCellValue(resultSet.getString("QUARTER"));
					cell = row.createCell(3);
					cell.setCellValue(resultSet.getString("AccNo"));
					cell = row.createCell(4);
					cell.setCellValue(resultSet.getString("CONTRACT_IDs"));
					cell = row.createCell(5);
					cell.setCellValue(resultSet.getString("DrawDown_link"));
					cell = row.createCell(6);
					cell.setCellValue(resultSet.getString("Branch"));
					cell = row.createCell(7);
					cell.setCellValue(resultSet.getString("Dept"));
					cell = row.createCell(8);
					cell.setCellValue(resultSet.getString("Customer"));
					cell = row.createCell(9);
					cell.setCellValue(resultSet.getString("Type"));
					cell = row.createCell(10);
					cell.setCellValue(resultSet.getString("YearEndBalance"));
					cell = row.createCell(11);
					cell.setCellValue(resultSet.getString("YearEndRate"));
					cell = row.createCell(12);
					cell.setCellValue(resultSet.getString("YearEndProv"));
					cell = row.createCell(13);
					cell.setCellValue(resultSet.getString("CurrentBalance"));
					cell = row.createCell(14);
					cell.setCellValue(resultSet.getString("CurrentRate"));
					cell = row.createCell(15);
					cell.setCellValue(resultSet.getString("SECURITY"));
					cell = row.createCell(16);
					cell.setCellValue(resultSet.getString("CurrentProvisions"));
					cell = row.createCell(17);
					cell.setCellValue(resultSet.getString("PastDues"));
					cell = row.createCell(18);
					cell.setCellValue(resultSet.getString("Comments"));
					cell = row.createCell(19);
					cell.setCellValue(resultSet.getString("OLD_ACCT"));

					i++;

				}
				// Write the workbook in file system
				FileOutputStream out = new FileOutputStream(new File("C:/IntranetWarehouse/Reports/MonthlyReports/ExcelExports/" + userName+" Provisions.xlsx"));
				workbook.write(out);
				out.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}		}
		
		System.out.println("Rpbert");
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
