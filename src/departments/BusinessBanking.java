package departments;

import java.io.IOException;
import java.sql.Connection;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sz.co.swazibank.beans.EmployeeBirthday;

/**
 * Servlet implementation class Home
 */
@WebServlet("/BusinessBanking")
public class BusinessBanking extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<EmployeeBirthday> employees = new ArrayList<EmployeeBirthday>();
	public static Connection con;
	

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
				
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/departments/businessBankingHome.jsp");
		view.forward(request, response);

		
	}


}
