package technicalResources.loanTracking;

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
@WebServlet("/BranchLoanUploadSecurities")
public class BranchLoanUploadSecurities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loanReference = request.getParameter("loanReference");
		
		request.setAttribute("loanReference", loanReference);
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/tehcnicalResources_loanTracking/branchLoanUploadSecurity.jsp");
		view.forward(request, response);
	}

}
