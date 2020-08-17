package technicalResources.electronicBanking;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import util.ConnectionHelper;

/**
 * Servlet implementation class EBPowerCadView
 */
@WebServlet("/MukuruOrdersToExcel")
public class MukuruOrdersToExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionHelper connectionHelper = new ConnectionHelper();
	public static Connection con;
	String directoryName = "C:/IntranetWarehouse/Operations/EB/processed";
	ArrayList<String> fileList = new ArrayList<String>();
	String filePath;
	private static final int BUFSIZE = 4096;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"YYYYMMddhhmmss");
		String dateAsString = simpleDateFormat.format(new Date());

		Random rand = new Random();
		int randV = rand.nextInt(500);

		Statement selectStatement = null;
		ResultSet resultSet = null;
		ArrayList<MukuruCustomerBean> mukuruCustomerOrderlist = new ArrayList<MukuruCustomerBean>();

		mukuruCustomerOrderlist.clear();

		// ///////////////////result set into poi///////////////////////////////
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Mukuru Customer Orders" + ' '
				+ dateAsString);
		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell;

		cell = row.createCell(1);
		cell.setCellValue("Sheet Ref");
		cell = row.createCell(2);
		cell.setCellValue("Branch");
		cell = row.createCell(3);
		cell.setCellValue("Teller");
		cell = row.createCell(4);
		cell.setCellValue("Recipient");
		cell = row.createCell(5);
		cell.setCellValue("RecipientID_Passport");
		cell = row.createCell(6);
		cell.setCellValue("Order_No");
		cell = row.createCell(7);
		cell.setCellValue("Order Confirmed Date");
		cell = row.createCell(8);
		cell.setCellValue("Order Completed Date");
		cell = row.createCell(9);
		cell.setCellValue("Ordered SZL");
		cell = row.createCell(10);
		cell.setCellValue("Issued SZL");
		
		
		con = connectionHelper.connect();

		
		if (con != null) {

			String sql = "SELECT  [Sheet_Ref]  ,[Branch]  ,[Teller]  ,[Recipient]  ,[Recipient_ID]  ,[Order]  ,[Order_Confirmed_Date] ,"
					+ "[Order_Completed_Date] ,[Ordered_SZL]  ,[Issued_SZL] FROM [SwaziBankIntranet2016].[dbo].[mukuru]";

			try {
				selectStatement = con.createStatement();
				resultSet = selectStatement.executeQuery(sql);
				int i = 2;
				
				while (resultSet.next()) {

					row = spreadsheet.createRow(i);
					cell = row.createCell(1);
					cell.setCellValue(resultSet.getString("Sheet_Ref"));
					cell = row.createCell(2);
					cell.setCellValue(resultSet.getString("Branch"));
					cell = row.createCell(3);
					cell.setCellValue(resultSet.getString("Teller"));
					cell = row.createCell(4);
					cell.setCellValue(resultSet.getString("Recipient"));
					cell = row.createCell(5);
					cell.setCellValue(resultSet.getString("Recipient_ID"));
					cell = row.createCell(6);
					cell.setCellValue(resultSet.getString("Order"));
					cell = row.createCell(7);
					cell.setCellValue(resultSet.getString("Order_Confirmed_Date"));
					cell = row.createCell(8);
					cell.setCellValue(resultSet.getString("Order_Completed_Date"));
					cell = row.createCell(9);
					cell.setCellValue(resultSet.getString("Ordered_SZL"));
					cell = row.createCell(10);
					cell.setCellValue(resultSet.getString("Issued_SZL"));
					

					i++;

				}
				
				// Write the workbook in file system
				FileOutputStream out = new FileOutputStream(new File("C:/IntranetWarehouse/ElectronicBanking/ExcelExports/" + randV+" mukuruOrders.xlsx"));
				workbook.write(out);
				out.close();
				
				
				
				
				
				
				//String docName = request.getParameter("documentUrl");
				filePath =   "C:/IntranetWarehouse/ElectronicBanking/ExcelExports/" + randV+" mukuruOrders.xlsx";

				File file = new File(filePath);
				int length = 0;
				
				ServletOutputStream outStream = response.getOutputStream();
				response.setHeader("Content-Type", "application/vnd.ms-excel");
				response.setContentLengthLong((int)file.length());
				String fileName = (new File(filePath)).getName();
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
				byte [] byteBuffer = new byte[BUFSIZE];
				DataInputStream in = new DataInputStream(new FileInputStream(file));
				while ((in != null)&&(length = in.read(byteBuffer))!= -1){
					outStream.write(byteBuffer, 0, length);
					
				}
				in.close();
				outStream.close();
		
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}		}
		

		response.sendRedirect(request.getContextPath() +"/MukuruCustomerOrders");
		
	}

}
