package technicalResources.electronicBanking;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

@WebServlet("/UploadMomentumStatement")
public class UploadMomentumStatement extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ConnectionHelper connectionHelper = new ConnectionHelper();
	String filePath = null;
	String destinationPath = null;
	public static Connection con;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String docName = request.getParameter("documentUrl");
		filePath = "C:/IntranetWarehouse/ElectronicBanking/MomentumStatements/" + docName;
		destinationPath = "C:/IntranetWarehouse/ElectronicBanking/MomentumStatements_processed/";
		File fileIn = new File(filePath);
		File fileOut = new File(destinationPath + docName);

		try {

			Files.copy(fileIn.toPath(), fileOut.toPath());


			con = connectionHelper.connect();

			if (con != null) {

				String sql = "BULK INSERT [SwaziBankIntranet2016].[dbo].[momentum_statements] FROM 'C:/IntranetWarehouse/ElectronicBanking/MomentumStatements/"
						+ docName + "' WITH (FIELDTERMINATOR = ',',  ROWTERMINATOR = '0x0a');";

				try {

					Statement ps = con.createStatement();

					ps.addBatch(sql);
					ps.executeBatch();
					ps.close();
					con.close();
					fileIn.delete();

					response.sendRedirect(request.getContextPath() + "/MomentumStatements");

				} catch (SQLException e) {
					
					e.printStackTrace();

				}

			}
		} catch (FileAlreadyExistsException exc) {

			request.setAttribute("docName", docName);
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalRresources_electronicBanking/momentumStatementsFileAlreadyExistsError.jsp");
			view.forward(request, response);

		}

	}

}
