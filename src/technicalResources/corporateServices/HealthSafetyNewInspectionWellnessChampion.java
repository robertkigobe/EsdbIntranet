package technicalResources.corporateServices;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.ConnectionHelper;
/**
 * Servlet implementation class HealthSafetyNewInspection
 */
@WebServlet("/HealthSafetyNewInspectionWellnessChampion")
public class HealthSafetyNewInspectionWellnessChampion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	     Date date = new Date( );
	     SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	     
	     request.setAttribute("dateOfInspection", ft.format(date));
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_corporateServices/healthSafetyNewWellnessChampion.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String branchDivision = request.getParameter("branchDivision");
		String peerEducator = request.getParameter("peerEducator");
		String dateOfInspection = request.getParameter("dateOfInspection");
		String facilitatedBy  = request.getParameter("facilitatedBy");
		String monitoredBy  = request.getParameter("monitoredBy");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String topic = request.getParameter("topic");
		String numberOfParticipants = request.getParameter("numberOfParticipants");
		String maleParticipants = request.getParameter("maleParticipants");
		String femaleParticipants = request.getParameter("femaleParticipants");
		String firstTimeParticipants = request.getParameter("firstTimeParticipants");
		String methodUsed = request.getParameter("methodUsed");
		String questionAndConcerns = request.getParameter("questionAndConcerns");
		String condomsDistMales = request.getParameter("condomsDistMales");
		String condomsDistFemales = request.getParameter("condomsDistFemales");
		String vct_htc_referrals_males = request.getParameter("vct_htc_referrals_males");
		String vct_htc_referrals_females= request.getParameter("vct_htc_referrals_females");


		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			// do query

			String sql = "INSERT INTO [dbo].[HSE_inspection_wellness_champion]"
					+ " ([branchDivision],[peerEducator],[dateOfInspection],[facilitatedBy],"
					+ "[monitoredBy],[startTime],[endTime],[numberOfParticipants],"
					+ "[maleParticipants],[femaleParticipants],[firstTimeParticipants],"
					+ "[methodUsed],[questionAndConcerns],[condomsDistMales],[condomsDistFemales]"
					+ ",[vct_htc_referrals_males],[vct_htc_referrals_females],[topic])"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
			
				int x = 1;
				stmt.setString(x++, branchDivision);
				stmt.setString(x++, peerEducator);
				stmt.setString(x++, dateOfInspection);
				stmt.setString(x++, facilitatedBy);
				stmt.setString(x++, monitoredBy);
				stmt.setString(x++, startTime);
				stmt.setString(x++, endTime);
				stmt.setString(x++, numberOfParticipants);
				stmt.setString(x++, maleParticipants);
				stmt.setString(x++, femaleParticipants);
				stmt.setString(x++, firstTimeParticipants);
				stmt.setString(x++, methodUsed);
				stmt.setString(x++, questionAndConcerns);
				stmt.setString(x++, condomsDistMales);
				stmt.setString(x++, condomsDistFemales);
				stmt.setString(x++, vct_htc_referrals_males);
				stmt.setString(x++, vct_htc_referrals_females);
				stmt.setString(x++, topic);
				
				stmt.executeUpdate();

				stmt.close();
		         response.sendRedirect(request.getContextPath()+ "/HealthSafetyMain");
			} catch (SQLException e1) {
				System.out.println("could not execute querry");
				e1.printStackTrace();
			}
		} else {
			System.out.println("No database connectivity");
		}

	}
}
