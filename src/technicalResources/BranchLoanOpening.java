package technicalResources;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
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
 * Servlet implementation class BranchLoanOpening
 */
@WebServlet("/BranchLoanOpening")
public class BranchLoanOpening extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "C:/IntranetWarehouse/LoanTracking";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchLoanOpening() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/operations/loanTracking/branchLoanOpening.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if (!ServletFileUpload.isMultipartContent(request)) {
			response.getWriter().println("Does not support!");
			// if not, we stop here
			return;
		}
		
		// configures some settings
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(THRESHOLD_SIZE);
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
				
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setFileSizeMax(MAX_FILE_SIZE);
				upload.setSizeMax(REQUEST_SIZE);
				
				// constructs the directory path to store upload file
				String uploadPath = getServletContext().getRealPath("")
					+ File.separator + UPLOAD_DIRECTORY;
				// creates the directory if it does not exist
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}
				
				try {
					// parses the request's content to extract file data
					List<?> formItems = upload.parseRequest(request);
					Iterator<?> iter = formItems.iterator();
					
					// iterates over form's fields
					while (iter.hasNext()) {/*
						FileItem item = (FileItem) iter.next();
						// processes only fields that are not form fields
						if (!item.isFormField()) {
							String fileName = new File(item.getName()).getName();
							String filePath = uploadPath + File.separator + fileName;
							File storeFile = new File(filePath);
							
							// saves the file on disk
							item.write(storeFile);
						}*/
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
							
							response.sendRedirect(request.getContextPath() +"/BriefsAndNews");
							
						} catch (Exception ex) {
							request.setAttribute("message", "File Upload Failed due to "
									+ ex);
						}
					} 
							
							
							
							
							
							
							
					request.setAttribute("message", "Upload has been done successfully!");
				} catch (Exception ex) {
					request.setAttribute("message", "There was an error: " + ex.getMessage());
					ex.printStackTrace();
				}
				getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
			}
	}


