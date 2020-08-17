package technicalResources;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/SkillsAuditLogin")
public class SkillsAuditLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkillsAuditLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/technicalResources/skillsAuditLogin.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("uName");
		String password = request.getParameter("password");
		
		if ((userName.matches("HS-Test" ))&&(password.matches("12345678=HS"))){
			
			response.sendRedirect(request.getContextPath() +"/HealthSafetyMain");
			
			
		} else {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/issueTrackingFaces/badPassword.jsp");
		view.forward(request, response);
		}
	}

}
