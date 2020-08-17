package technicalResources.bsc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnectionHelper;

/**
 * Servlet implementation class LoanTrackingNewLoan
 */
@WebServlet("/BscPostExcoScores")
public class BscPostExcoScores extends HttpServlet {
	
	public static Connection con;
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bscPeriod = request.getParameter("bscPeriod");
		String department = request.getParameter("department");
		String position = request.getParameter("position");
		String bscEmployeeName = null;
		
		if (position.equals("Executive Manager Business Banking")){
			bscEmployeeName = "NOZIZWE MULELA"; 
		} else if (position.equals("Executive Manager Corporate Services")){
			bscEmployeeName = "THEMBI DLAMINI"; 
		}else if (position.equals("Executive Manager Credit")){
			bscEmployeeName = "DUMASE NXUMALO"; 
		}else if (position.equals("Executive Manager Finance")){
			bscEmployeeName = "ZANELE DLAMINI"; 
		}else if (position.equals("Executive Manager Internal Audit")){
			bscEmployeeName = "TAWONGA SIFUNDZA"; 
		}else if (position.equals("Executive Manager IT")){
			bscEmployeeName = "PAUL WASWA"; 
		}else if (position.equals("Executive Manager Legal and Board Secretary")){
			bscEmployeeName = "SIFISO MDLULI"; 
		}else if (position.equals("Executive Manager Marketing")){
			bscEmployeeName = "LINDIWE SHONGWE"; 
		}else if (position.equals("Executive Manager Operations")){
			bscEmployeeName = "ENOC MAVIMBELA"; 
		}
		
		String bscEmployeeSupervisor = "ZAKELE LUKHELE";
		String subDepartment = "Exco";
		String[] perspectives = request.getParameterValues("perspective");
		String[] objectives = request.getParameterValues("objective");
		String[] periods = request.getParameterValues("period");
		String[] reportingFrequencies = request.getParameterValues("reportingFrequency");
		String[] measures = request.getParameterValues("measure");
		String[] bases = request.getParameterValues("base");
		String[] stretches = request.getParameterValues("stretch");
		String[] actuals = request.getParameterValues("actual");
		

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String insertIssueSql = "INSERT INTO [dbo].[bscSDSBExcoScores]  "
					+ "([bscEmployeeName]  "
					+ ",[bscEmployeeSupervisor]"
					+ ",[position]"
					+ ",[department]  "
					+ ",[subDepartment]  "
					+ ",[bscPeriod]  "
					+ ",[perspective]  "
					+ ",[objective]   "
					+ ",[period]   "
					+ ",[reportingFrequencies]   "
					+ ",[measure]  "
					+ ",[base]    "
					+ ",[stretch]  "
					+ ",[actual])  "
					+ "VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			try {

				java.sql.PreparedStatement insertReportStatement = con.prepareStatement(insertIssueSql);
				
				for (int i = 0; i < measures.length; i++) {
					
					insertReportStatement.setString(1, bscEmployeeName);
					insertReportStatement.setString(2, bscEmployeeSupervisor);
					insertReportStatement.setString(3, position);
					insertReportStatement.setString(4, department);
					insertReportStatement.setString(5, subDepartment);
					insertReportStatement.setString(6, bscPeriod);
					insertReportStatement.setString(7, perspectives[i]);
					insertReportStatement.setString(8, objectives[i]);
					insertReportStatement.setString(9, periods[i]);
					insertReportStatement.setString(10, reportingFrequencies[i]);
					insertReportStatement.setString(11, measures[i]);
					insertReportStatement.setFloat(12, Float.valueOf(bases[i]));
					insertReportStatement.setFloat(13, Float.valueOf(stretches[i]));
					
					
					insertReportStatement.setFloat(14, Float.parseFloat(actuals[i]));
					System.out.println(Float.parseFloat(actuals[i]));
					insertReportStatement.executeUpdate();
				}

				insertReportStatement.close();
				con.close();

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_bsc/bscExcoHome.jsp");

				view.forward(request, response);

			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			finally {
				if (con != null) {
					try {
						ConnectionHelper.disconnect(con);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}

			}

		}

	}
}
