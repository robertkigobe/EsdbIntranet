package sz.co.swazibank.intranet;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/HrTrainingMaterial")
public class HrTrainingMaterial extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String directoryName = "C:/IntranetWarehouse/HRTrainings";
	ArrayList<String> fileList = new ArrayList<String>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = System.getProperty("user.name");
		System.out.println(userName);
		listFiles(directoryName);
		
		request.setAttribute("fileList", fileList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/faces/Home.jsp");
		view.forward(request, response);
	}
	
	public void listFiles (String directoryName){
		fileList.clear();
		File directory = new File(directoryName);
		File [] fList = directory.listFiles();
		
		for (File file : fList){
			if(file.isFile()){
				fileList.add(file.getName());
			}
		}
	}
}