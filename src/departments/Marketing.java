package departments;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;

import sz.co.swazibank.beans.EmployeeBirthday;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Marketing")
public class Marketing extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<EmployeeBirthday> employees = new ArrayList<EmployeeBirthday>();
	public static Connection con;
	String directoryName = "C:/IntranetWarehouse/WhatsNew";
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
				.getRequestDispatcher("WEB-INF/departments/marketingHome.jsp");
		view.forward(request, response);

		
	}

	// ///////connect & disconnect /////////////
	

	
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
