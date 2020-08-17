package technicalResources;

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

import javax.servlet.RequestDispatcher;
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
@WebServlet("/EBPowerCadView")
public class EBPowerCadView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
	String directoryName = "C:/IntranetWarehouse/Operations/EB/processed";
	ArrayList<String> fileList = new ArrayList<String>();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"YYYYMMddhhmmss");
		String dateAsString = simpleDateFormat.format(new Date());

		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		new ArrayList<String>();

		Statement selectStatement = null;
		ResultSet resultSet = null;
		ArrayList<PowerCardBean> powerCardList = new ArrayList<PowerCardBean>();
		powerCardList.clear();

		// ///////////////////result set into poi///////////////////////////////
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("PowerCard Entries" + ' '
				+ dateAsString);
		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell;

		cell = row.createCell(1);
		cell.setCellValue("Record Type");
		cell = row.createCell(2);
		cell.setCellValue("Record Sequence");
		cell = row.createCell(3);
		cell.setCellValue("Bank Code");
		cell = row.createCell(4);
		cell.setCellValue("Operations Code");
		cell = row.createCell(5);
		cell.setCellValue("Operations Sequence");
		cell = row.createCell(6);
		cell.setCellValue("Settlement Account");
		cell = row.createCell(7);
		cell.setCellValue("Entry Sequence");
		cell = row.createCell(8);
		cell.setCellValue("Gl Reference");
		cell = row.createCell(9);
		cell.setCellValue("Doc Reference");
		cell = row.createCell(10);
		cell.setCellValue("Entry Label");
		cell = row.createCell(11);
		cell.setCellValue("Posting Date");
		cell = row.createCell(12);
		cell.setCellValue("Entry Date");
		cell = row.createCell(13);
		cell.setCellValue("Entry Account Number");
		cell = row.createCell(14);
		cell.setCellValue("Entry Key Account");
		cell = row.createCell(15);
		cell.setCellValue("Entry Amount");
		cell = row.createCell(16);
		cell.setCellValue("Entry Sign");
		cell = row.createCell(17);
		cell.setCellValue("Entry Currency");
		cell = row.createCell(18);
		cell.setCellValue("Posting Flag");
		cell = row.createCell(19);
		cell.setCellValue("Business Date");
		cell = row.createCell(20);
		cell.setCellValue("Data File Source");
		cell = row.createCell(21);
		cell.setCellValue("Issuer Bank Code");
		cell = row.createCell(22);
		cell.setCellValue("Acquirer Bank Code");
		cell = row.createCell(23);
		cell.setCellValue("Network Code");
		cell = row.createCell(24);
		cell.setCellValue("Acquirer Reference Number");
		cell = row.createCell(25);
		cell.setCellValue("Acquirer Reference Sequence");
		cell = row.createCell(26);
		cell.setCellValue("Destination Account Label");
		cell = row.createCell(27);
		cell.setCellValue("Operation Date Label");
		cell = row.createCell(28);
		cell.setCellValue("Basic Source Label");
		cell = row.createCell(29);
		cell.setCellValue("Conversion Rate");
		cell = row.createCell(30);
		cell.setCellValue("Operation Grouping Criteria");
		cell = row.createCell(31);
		cell.setCellValue("Source Amount");
		cell = row.createCell(32);
		cell.setCellValue("Source Currency");

		// ///////////////////result set into poi///////////////////////////////

		// ////////////////////normal select statement//////////////////////////
		con = connect();
		if (con != null) {

			String sql = "SELECT left( [Record],2) as RecordType,right(left( [Record],21), 19) as RecordSequence,right(left( [Record],27), 6) as BankCode,right(left( [Record],33), 6) as OperationsCode,right(left( [Record],36), 3) as OperationsSequence,right(left( [Record],44), 8) as SettlementAccount,right(left( [Record],52), 8) as EntrySequence,right(left( [Record],84), 32) as GlReference,right(left( [Record],596), 3) as DocReference,right(left( [Record],676), 80) as EntryLabel,right(left( [Record],683), 7) as PostingDate,right(left( [Record],690), 7) as EntryDate,right(left( [Record],690), 7) as EntryAccountNumber,right(left( [Record],714), 24) as EntryKeyAccount,right(left( [Record],716), 2) as EntryAmount,right(left( [Record],734), 18) as EntrySign,right(left( [Record],735), 1) as EntryCurrency,right(left( [Record],738), 3) as PostingFlag,right(left( [Record],739), 1) as BusinessDate,right(left( [Record],746), 7) as DataFileSource,right(left( [Record],751), 5) as IssuerBankCode,right(left( [Record],757), 6) as AcquirerBankCode,right(left( [Record],763), 6) as NetworkCode,right(left( [Record],765), 2) as AcquirerReferenceNumber,right(left( [Record],788), 23) as AcquirerReferenceSequence,right(left( [Record],792), 4) as DestinationAccountLabel,right(left( [Record],824), 32) as OperationDateLabel,right(left( [Record],856), 32) as BasicSourceLabel,right(left( [Record],888), 32) as OperationGroupingCode,right(left( [Record],890), 2) as ConversionRate FROM [SwaziBankIntranet2016].[dbo].[PowerCard]";

			try {
				selectStatement = con.createStatement();
				resultSet = selectStatement.executeQuery(sql);
				int i = 2;
				while (resultSet.next()) {

					row = spreadsheet.createRow(i);
					cell = row.createCell(1);
					cell.setCellValue(resultSet.getString("RecordType"));
					cell = row.createCell(2);
					cell.setCellValue(resultSet.getString("RecordSequence"));
					cell = row.createCell(3);
					cell.setCellValue(resultSet.getString("BankCode"));
					cell = row.createCell(4);
					cell.setCellValue(resultSet.getString("OperationsCode"));
					cell = row.createCell(5);
					cell.setCellValue(resultSet.getString("OperationsSequence"));
					cell = row.createCell(6);
					cell.setCellValue(resultSet.getString("SettlementAccount"));
					cell = row.createCell(7);
					cell.setCellValue(resultSet.getString("EntrySequence"));
					cell = row.createCell(8);
					cell.setCellValue(resultSet.getString("GlReference"));
					cell = row.createCell(9);
					cell.setCellValue(resultSet.getString("DocReference"));
					cell = row.createCell(10);
					cell.setCellValue(resultSet.getString("EntryLabel"));
					cell = row.createCell(11);
					cell.setCellValue(resultSet.getString("PostingDate"));
					cell = row.createCell(12);
					cell.setCellValue(resultSet.getString("EntryDate"));
					cell = row.createCell(13);
					cell.setCellValue(resultSet.getString("EntryAccountNumber"));
					cell = row.createCell(14);
					cell.setCellValue(resultSet.getString("EntryKeyAccount"));
					cell = row.createCell(15);
					cell.setCellValue(resultSet.getString("EntryAmount"));
					cell = row.createCell(16);
					cell.setCellValue(resultSet.getString("EntrySign"));
					cell = row.createCell(17);
					cell.setCellValue(resultSet.getString("EntryCurrency"));
					cell = row.createCell(18);
					cell.setCellValue(resultSet.getString("PostingFlag"));
					cell = row.createCell(19);
					cell.setCellValue(resultSet.getString("BusinessDate"));
					cell = row.createCell(20);
					cell.setCellValue(resultSet.getString("DataFileSource"));
					cell = row.createCell(21);
					cell.setCellValue(resultSet.getString("IssuerBankCode"));
					cell = row.createCell(22);
					cell.setCellValue(resultSet.getString("AcquirerBankCode"));
					cell = row.createCell(23);
					cell.setCellValue(resultSet.getString("NetworkCode"));
					cell = row.createCell(24);
					cell.setCellValue(resultSet
							.getString("AcquirerReferenceNumber"));
					cell = row.createCell(25);
					cell.setCellValue(resultSet
							.getString("AcquirerReferenceSequence"));
					cell = row.createCell(26);
					cell.setCellValue(resultSet
							.getString("DestinationAccountLabel"));
					cell = row.createCell(27);
					cell.setCellValue("OperationDateLabel");
					cell = row.createCell(28);
					cell.setCellValue("BasicSourceLabel");
					cell = row.createCell(29);
					cell.setCellValue("ConversionRate");
					cell = row.createCell(30);
					cell.setCellValue("OperationGroupingCriteria");
					cell = row.createCell(31);
					cell.setCellValue("SourceAmount");
					cell = row.createCell(32);
					cell.setCellValue("SourceCurrency");

					i++;

				}
				// Write the workbook in file system
				FileOutputStream out = new FileOutputStream(new File(
						"C://IntranetWarehouse//Operations//EB//processed//PowerCard "
								+ dateAsString + ".xlsx"));
				workbook.write(out);
				out.close();
				System.out.println("exceldatabase.xlsx written successfully");

				request.setAttribute("userName", userName);

				listFiles(directoryName);
				request.setAttribute("fileList", fileList);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/operations/eBPowerCadView.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			// ////////////////////normal select
			// statement//////////////////////////

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
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
