package administration;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadBriefs
 */
@WebServlet("/UploadInternalAdvert")
public class UploadInternalAdvert extends HttpServlet {
	private final String UPLOAD_DIRECTORY = "C:/IntranetWarehouse/Home/InternalAdvert/";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadInternalAdvert() {
		super();
		// TODO Auto-generated constructor stub
	}



	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/administration/uploadInternalAdvert.jsp");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (ServletFileUpload.isMultipartContent(request)) {
			
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator
								+ name));
						
					}
				}
				response.sendRedirect(request.getContextPath() +"/InternalAdvert");
				
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}
		} else {
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
			request.getRequestDispatcher("/result.jsp").forward(request,
					response);

		}
	}

}
