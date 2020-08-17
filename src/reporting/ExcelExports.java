package reporting;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcelExports
 */
@WebServlet("/ExcelExports")
public class ExcelExports extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String directoryName = "C:/IntranetWarehouse/Reports/MonthlyReports/ExcelExports";
	ArrayList<String> excelList = new ArrayList<String>();
	String filePath;
	private static final int BUFSIZE = 4096;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelExports() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		listFiles(directoryName);

		request.setAttribute("fileList", excelList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/reports/excelExports.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String docName = request.getParameter("documentUrl");
		filePath =   "C:/IntranetWarehouse/Reports/MonthlyReports/ExcelExports/"+ docName;

		File file = new File(filePath);
		int length = 0;
		ServletOutputStream outStream = response.getOutputStream();
		response.setContentType("application/vnd.ms-excel"); 
		response.setHeader("Content-Disposition", "attachment; filename=filename.xls"); 
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
	}

	public void listFiles(String directoryName) {
		excelList.clear();
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();

		for (File file : fList) {
			if (file.isFile()) {
				excelList.add(file.getName());
			}
		}
	}
}
