package technicalResources.Finance;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Top100CustomerDeposits
 */
@WebServlet("/Top100CustomerDeposits")
public class Top100CustomerDeposits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_Finance/top100CustomerDeposits.jsp");
		
		//.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanNewStaffResume.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
