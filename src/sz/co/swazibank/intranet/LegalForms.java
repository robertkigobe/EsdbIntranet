package sz.co.swazibank.intranet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Policies
 */
@WebServlet("/LegalForms")
public class LegalForms extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/faces/legalForms.jsp");
				view.forward(request, response);
			}
			
			
		}