package technicalResources.corporateServices;

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
 * Servlet implementation class WorkPlaceWellnessSurveyHome
 */
@WebServlet("/WorkPlaceWellnessSurveySurvey")
public class WorkPlaceWellnessSurveySurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_corporateServices/workPlaceWellnessSurveySurvey.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String relationship = request.getParameter("relationship");
		String employmentStatus = request.getParameter("employmentStatus");
		String employmentDuration = request.getParameter("employmentDuration");
		String employmentDepartment = request
				.getParameter("employmentDepartment");
		String q1 = request.getParameter("q1");
		String q2 = request.getParameter("q2");
		String q3 = request.getParameter("q3");
		String q4 = request.getParameter("q4");
		String q5 = request.getParameter("q5");
		String q6 = request.getParameter("q6");
		String q7 = request.getParameter("q7");
		String q8 = request.getParameter("q8");
		String q9 = request.getParameter("q9");
		String q10 = request.getParameter("q10");
		String q11 = request.getParameter("q11");
		String q12 = request.getParameter("q12");
		String q13 = request.getParameter("q13");
		String q14 = request.getParameter("q14");
		String q15 = request.getParameter("q15");
		String q16 = request.getParameter("q16");
		String q17 = request.getParameter("q17");
		String q18 = request.getParameter("q18");
		String q19 = request.getParameter("q19");
		String q20 = request.getParameter("q20");
		String q21 = request.getParameter("q21");
		String q22 = request.getParameter("q22");
		String q23 = request.getParameter("q23");
		String q24 = request.getParameter("q24");
		String q25 = request.getParameter("q25");
		String q26 = request.getParameter("q26");
		String q27 = request.getParameter("q27");
		String q28 = request.getParameter("q28");
		String q29 = request.getParameter("q29");
		String q30 = request.getParameter("q30");
		String q31 = request.getParameter("q31");
		String q32 = request.getParameter("q32");
		String q33 = request.getParameter("q33");
		String q34 = request.getParameter("q34");
		String q35 = request.getParameter("q35");
		String q36 = request.getParameter("q36");
		String q37 = request.getParameter("q37");
		String q38 = request.getParameter("q38");
		String q39 = request.getParameter("q39");
		String q40 = request.getParameter("q40");
		String q41 = request.getParameter("q41");
		String q42 = request.getParameter("q42");
		String q43 = request.getParameter("q43");
		String q44 = request.getParameter("q44");
		String q45 = request.getParameter("q45");
		String q46 = request.getParameter("q46");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {
			// do query

			String insertIssueSql = "INSERT INTO [dbo].[wellnessSurvey2018]" + "([sex],"
					+ "[age]" + ",[relationship]" + ",[employmentStatus]"
					+ ",[employmentDuration]" + ",[employmentDepartment]"
					+ ",[q1]" + ",[q2]" + ",[q3]" + " ,[q4]" + ",[q5]"
					+ ",[q6]" + ",[q7]" + ",[q8]" + ",[q9]" + ",[q10]"
					+ ",[q11]" + ",[q12]" + ",[q13]" + ",[q14]" + ",[q15]"
					+ ",[q16]" + ",[q17]" + ",[q18]" + ",[q19]" + ",[q20]"
					+ ",[q21]" + ",[q22]" + ",[q23]" + ",[q24]" + ",[q25]"
					+ ",[q26]" + ",[q27]" + ",[q28]" + ",[q29]" + ",[q30]"
					+ ",[q31]" + ",[q32]" + ",[q33]" + ",[q34]" + ",[q35]"
					+ ",[q36]" + ",[q37]" + ",[q38]" + ",[q39]" + ",[q40]"
					+ ",[q41]" + ",[q42]" + ",[q43]" + ",[q44]" + ",[q45]"
					+ ",[q46])" + " VALUES" + " ('"
					+ sex
					+ "','"
					+ age
					+ "','"
					+ relationship
					+ "','"
					+ employmentStatus
					+ "','"
					+ employmentDuration
					+ "','"
					+ employmentDepartment
					+ "',"
					+ "'"
					+ q1
					+ "',"
					+ "'"
					+ q2
					+ "',"
					+ "'"
					+ q3
					+ "',"
					+ "'"
					+ q4
					+ "',"
					+ "'"
					+ q5
					+ "',"
					+ "'"
					+ q6
					+ "',"
					+ "'"
					+ q7
					+ "',"
					+ "'"
					+ q8
					+ "',"
					+ "'"
					+ q9
					+ "',"
					+ "'"
					+ q10
					+ "',"
					+ "'"
					+ q11
					+ "',"
					+ "'"
					+ q12
					+ "',"
					+ "'"
					+ q13
					+ "',"
					+ "'"
					+ q14
					+ "',"
					+ "'"
					+ q15
					+ "',"
					+ "'"
					+ q16
					+ "',"
					+ "'"
					+ q17
					+ "',"
					+ "'"
					+ q18
					+ "',"
					+ "'"
					+ q19
					+ "',"
					+ "'"
					+ q20
					+ "',"
					+ "'"
					+ q21
					+ "',"
					+ "'"
					+ q22
					+ "',"
					+ "'"
					+ q23
					+ "',"
					+ "'"
					+ q24
					+ "',"
					+ "'"
					+ q25
					+ "',"
					+ "'"
					+ q26
					+ "',"
					+ "'"
					+ q27
					+ "',"
					+ "'"
					+ q28
					+ "',"
					+ "'"
					+ q29
					+ "',"
					+ "'"
					+ q30
					+ "',"
					+ "'"
					+ q31
					+ "',"
					+ "'"
					+ q32
					+ "',"
					+ "'"
					+ q33
					+ "',"
					+ "'"
					+ q34
					+ "',"
					+ "'"
					+ q35
					+ "',"
					+ "'"
					+ q36
					+ "',"
					+ "'"
					+ q37
					+ "',"
					+ "'"
					+ q38
					+ "',"
					+ "'"
					+ q39
					+ "',"
					+ "'"
					+ q40
					+ "',"
					+ "'"
					+ q41
					+ "',"
					+ "'"
					+ q42
					+ "',"
					+ "'"
					+ q43
					+ "',"
					+ "'"
					+ q44
					+ "'," + "'" + q45 + "'," + "'" + q46 + "')";
			
			java.sql.PreparedStatement insertReportStatement = null;

			try {
				
				insertReportStatement = con.prepareStatement(insertIssueSql,new String[] { "id" });
				
				insertReportStatement.executeUpdate();
				insertReportStatement.close();
				con.close();
				
				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_corporateServices/workPlaceWellnessSurveySuccess.jsp");
				view.forward(request, response);
				
				
			} catch (SQLException e1) {
				System.out.println("could not execute querry");
				e1.printStackTrace();
			}
		} else {
			System.out.println("No database connectivity");
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_corporateServices/workPlaceWellnessSurveyFailure.jsp");
			view.forward(request, response);
		}

	}
}
