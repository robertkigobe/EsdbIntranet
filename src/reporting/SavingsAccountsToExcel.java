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
@WebServlet("/SavingsAccountsToExcel")
public class SavingsAccountsToExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
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
		XSSFSheet spreadsheet = workbook.createSheet("Savings Accounts Report" + ' '
				+ dateAsString);
		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell;
		


		cell = row.createCell(1);
		cell.setCellValue("ACCOUNT");
		cell = row.createCell(2);
		cell.setCellValue("CUSTID");
		cell = row.createCell(3);
		cell.setCellValue("CUSTNAME");
		cell = row.createCell(4);
		cell.setCellValue("SEX");
		cell = row.createCell(5);
		cell.setCellValue("DATE_0F_BIRTH");
		cell = row.createCell(6);
		cell.setCellValue("SECTOR");
		cell = row.createCell(7);
		cell.setCellValue("INDUSTRY");
		cell = row.createCell(8);
		cell.setCellValue("AC_INACTIVE   Y  /  N");
		cell = row.createCell(9);
		cell.setCellValue("BRANCH");
		cell = row.createCell(10);
		cell.setCellValue("CATEGORY");
		cell = row.createCell(11);
		cell.setCellValue("DESCRIPTION");
		cell = row.createCell(12);
		cell.setCellValue("OS PRINCIPAL");
		cell = row.createCell(13);
		cell.setCellValue("OS INTEREST");
		cell = row.createCell(14);
		cell.setCellValue("PD PRINCIPAL");
		cell = row.createCell(15);
		cell.setCellValue("PD INTCHGS");
		cell = row.createCell(16);
		cell.setCellValue("TOTAL");
		cell = row.createCell(17);
		cell.setCellValue("CREATED");
		cell = row.createCell(18);
		cell.setCellValue("MATURITY");
		cell = row.createCell(19);
		cell.setCellValue("TERMS");
		cell = row.createCell(20);
		cell.setCellValue("MONTH TOTAL");
		cell = row.createCell(21);
		cell.setCellValue("MOVEMENT");

		con = connect();
		if (con != null) {

			String sql = "SELECT  [account]      ,[custid]      ,[custname]      ,[sex]      ,[date_0f_birth]      ,[sector]      ,[industry]     ,[inactive]      ,[branch]      ,[category]      ,[description]      ,[os_principal]      ,[os_interest]      ,[pd_principal]      ,[pd_intchgs]      ,[total]      ,[created]      ,[maturity]      ,[terms]      ,[month_total]      ,[movement]  FROM [SwaziBankIntranet2016].[dbo].[SavingsAccs]";


			try {
				selectStatement = con.createStatement();
				resultSet = selectStatement.executeQuery(sql);
				int i = 2;
				
				while (resultSet.next()) {
					
					

					row = spreadsheet.createRow(i);
					cell = row.createCell(1);
					cell.setCellValue(resultSet.getString("account"));
					cell = row.createCell(2);
					cell.setCellValue(resultSet.getString("custid"));
					cell = row.createCell(3);
					cell.setCellValue(resultSet.getString("custname"));
					cell = row.createCell(4);
					cell.setCellValue(resultSet.getString("sex"));
					cell = row.createCell(5);
					cell.setCellValue(resultSet.getString("date_0f_birth"));
					cell = row.createCell(6);
					cell.setCellValue(resultSet.getString("sector"));
					cell = row.createCell(7);
					cell.setCellValue(resultSet.getString("industry"));
					cell = row.createCell(8);
					cell.setCellValue(resultSet.getString("inactive"));
					cell = row.createCell(9);
					cell.setCellValue(resultSet.getString("branch"));
					cell = row.createCell(10);
					cell.setCellValue(resultSet.getString("category"));
									
					cell = row.createCell(11);
					cell.setCellValue(resultSet.getString("description"));
					cell = row.createCell(12);
					cell.setCellValue(resultSet.getString("os_principal"));
					cell = row.createCell(13);
					cell.setCellValue(resultSet.getString("os_interest"));
					cell = row.createCell(14);
					cell.setCellValue(resultSet.getString("pd_principal"));
					cell = row.createCell(15);
					cell.setCellValue(resultSet.getString("pd_intchgs"));
					cell = row.createCell(16);
					cell.setCellValue(resultSet.getString("total"));
					cell = row.createCell(17);
					cell.setCellValue(resultSet.getString("created"));
					cell = row.createCell(18);
					cell.setCellValue(resultSet.getString("maturity"));
					cell = row.createCell(19);
					cell.setCellValue(resultSet.getString("terms"));
					cell = row.createCell(20);
					cell.setCellValue(resultSet.getString("month_total"));
					cell = row.createCell(21);
					cell.setCellValue(resultSet.getString("movement"));

					i++;

				}
				// Write the workbook in file system
				FileOutputStream out = new FileOutputStream(new File("C:/IntranetWarehouse/Reports/MonthlyReports/ExcelExports/" + userName+" SavingsAccounts.xlsx"));
				workbook.write(out);
				out.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
