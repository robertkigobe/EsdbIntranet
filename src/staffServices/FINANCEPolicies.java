package staffServices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BriefsAndNews
 */
@WebServlet("/FINANCEPolicies")
public class FINANCEPolicies extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String directoryName = "C:/IntranetWarehouse/Policies/FINANCEPolicies";
	ArrayList<String> briefList = new ArrayList<String>();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		listFiles(directoryName);

		request.setAttribute("fileList", briefList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/staffServices/fINANCEPolicies.jsp");
		view.forward(request, response);
	}

	public void listFiles(String directoryName) {
		briefList.clear();
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();

		for (File file : fList) {
			if (file.isFile()) {
				briefList.add(file.getName());
			}
		}
	}
}