package technicalResources.staffLoan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StaffLoanUploadSecurities
 */
@WebServlet("/StaffLoanUploadSecurities")
public class StaffLoanUploadSecurities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String employeeLoanRef = request.getParameter("employeeLoanRef");
		
		request.setAttribute("employeeLoanRef", employeeLoanRef);
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanUploadSecurity.jsp");
		view.forward(request, response);
	}

}
