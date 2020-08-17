package technicalResources.electronicBanking;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;

/**
 * Servlet implementation class BriefsAndNews
 */
@WebServlet("/CardProductionFiles")
public class CardProductionFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String directoryName = "C:/IntranetWarehouse/CardProduction";
	public static Connection con;
	ArrayList<String> fileList = new ArrayList<String>();
	

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		listFiles(directoryName);
		request.setAttribute("fileList", fileList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/cardProductionFiles.jsp");
		view.forward(request, response);

		// //////////////////////////////////////
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ///////////////////////////////
		String filePath = (String) request.getAttribute("documentUrl");
		
		File file = new File(filePath);
		response.setHeader("Content-Type",
				getServletContext().getMimeType(file.getName()));
		response.setContentType("text/html");
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filePath + ".txt\"");
		Files.copy(file.toPath(), response.getOutputStream());
		
	
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