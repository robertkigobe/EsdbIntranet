package technicalResources.SkillsAudits;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import technicalResources.bsc.BscMeasureBean;
import util.ConnectionHelper;

/**
 * Servlet implementation class NewSkillsAudit
 */
@WebServlet("/SkillsAuditNewSkillsAudit")
public class SkillsAuditNewSkillsAudit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);
		String position = null;
		String measure = null;
		String measureDesciption = null;
		String perspective = null;

		ArrayList<BscMeasureBean> measureList = new ArrayList<BscMeasureBean>();

		measureList.clear();

		measureList
				.add(new BscMeasureBean("Choose Position", null, null, null));
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT Distinct [Position]  FROM [dbo].[SkillsAuditMetrics] order by [Position]";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);
				while (results.next()) {
					position = results.getString("position");
					measureList.add(new BscMeasureBean(position, measure,
							measureDesciption, perspective));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		request.setAttribute("position", position);
		request.setAttribute("measureList", measureList);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_skillsAudit/newSkillsAuditRequest.jsp");
		view.forward(request, response);

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String financialYear = null;
		String department = null;
		String subDepartment = null;
		String position = null;
		String category = null;
		String skill = null;
		String rating = null;
		String priority = null;
		String remarks = null;

		String positionName = request.getParameter("position");

		

			Statement selectStatement = null;
			ResultSet results = null;

			ArrayList<SkillsAuditMetricsBean> educationSkills = new ArrayList<SkillsAuditMetricsBean>();
			ArrayList<SkillsAuditMetricsBean> technicalSkills = new ArrayList<SkillsAuditMetricsBean>();
			ArrayList<SkillsAuditMetricsBean> professionalSkills = new ArrayList<SkillsAuditMetricsBean>();
			ArrayList<SkillsAuditMetricsBean> qualificationSkills = new ArrayList<SkillsAuditMetricsBean>();
			ArrayList<SkillsAuditMetricsBean> experienceSkills = new ArrayList<SkillsAuditMetricsBean>();
			ArrayList<String> employees = new ArrayList<String>();
			ArrayList<String> supervisors = new ArrayList<String>();


			educationSkills.clear();
			qualificationSkills.clear();
			technicalSkills.clear();
			professionalSkills.clear();
			experienceSkills.clear();

			Statement selectStatement1 = null;
			ResultSet results1 = null;
			String employee = null;
			employees.clear();
			supervisors.clear();
			
			employees.add("Choose Employee");
			supervisors.add("Choose Supervisor");

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();

			if (con != null) {

				String sql1 = "SELECT  [Surname] + ' ' + [Firstname]   as 'employee'   FROM [SwaziBankIntranet2016].[dbo].[employeesDynamique]  order by Surname";

				try {
					selectStatement1 = con.createStatement();
					results1 = selectStatement1.executeQuery(sql1);

					while (results1.next()) {
						employee = results1.getString("employee");
						supervisors.add(employee);
						employees.add(employee);
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}

			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditMetrics] where position = '"
						+ positionName + " '  and  category ='Education ' ";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql1);

					while (results.next()) {

						financialYear = results.getString("financialYear");
						department = results.getString("department");
						subDepartment = results.getString("subDepartment");
						position = results.getString("position");
						category = results.getString("category");
						skill = results.getString("skill");
						rating = results.getString("rating");
						priority = results.getString("priority");
						remarks = results.getString("remarks");

						educationSkills.add(new SkillsAuditMetricsBean(financialYear, department,subDepartment, position, category,  skill,  rating,  priority,  remarks));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}

			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditMetrics] where position = '"
						+ positionName + " '  and  category ='Experience' ";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql1);

					while (results.next()) {

						financialYear = results.getString("financialYear");
						department = results.getString("department");
						subDepartment = results.getString("subDepartment");
						position = results.getString("position");
						category = results.getString("category");
						skill = results.getString("skill");
						rating = results.getString("rating");
						priority = results.getString("priority");
						remarks = results.getString("remarks");

						experienceSkills.add(new SkillsAuditMetricsBean(financialYear, department,subDepartment, position, category,  skill,  rating,  priority,  remarks));

						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}

			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditMetrics] where position = '"
						+ positionName + " '  and  category ='Qualifications' ";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql1);

					while (results.next()) {

						financialYear = results.getString("financialYear");
						department = results.getString("department");
						subDepartment = results.getString("subDepartment");
						position = results.getString("position");
						category = results.getString("category");
						skill = results.getString("skill");
						rating = results.getString("rating");
						priority = results.getString("priority");
						remarks = results.getString("remarks");

						qualificationSkills.add(new SkillsAuditMetricsBean(financialYear, department,subDepartment, position, category,  skill,  rating,  priority,  remarks));

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}

			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditMetrics] where position = '"
						+ positionName
						+ " '  and  category ='Technical knowledge' ";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql1);

					while (results.next()) {

						financialYear = results.getString("financialYear");
						department = results.getString("department");
						subDepartment = results.getString("subDepartment");
						position = results.getString("position");
						category = results.getString("category");
						skill = results.getString("skill");
						rating = results.getString("rating");
						priority = results.getString("priority");
						remarks = results.getString("remarks");

						technicalSkills.add(new SkillsAuditMetricsBean(financialYear, department,subDepartment, position, category,  skill,  rating,  priority,  remarks));

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}

			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditMetrics] where position = '"
						+ positionName
						+ " '  and  category ='Personal Attributes' ";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql1);

					while (results.next()) {

						financialYear = results.getString("financialYear");
						department = results.getString("department");
						subDepartment = results.getString("subDepartment");
						position = results.getString("position");
						category = results.getString("category");
						skill = results.getString("skill");
						rating = results.getString("rating");
						priority = results.getString("priority");
						remarks = results.getString("remarks");

						professionalSkills.add(new SkillsAuditMetricsBean(financialYear, department,subDepartment, position, category,  skill,  rating,  priority,  remarks));

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			request.setAttribute("position", position);
			request.setAttribute("subDepartment", subDepartment);
			request.setAttribute("department", department);
			request.setAttribute("employees", employees);
			request.setAttribute("supervisors", supervisors);
			request.setAttribute("educationSkills", educationSkills);
			request.setAttribute("technicalSkills", technicalSkills);
			request.setAttribute("professionalSkills", professionalSkills);
			request.setAttribute("qualificationSkills", qualificationSkills);
			request.setAttribute("experienceSkills", experienceSkills);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_skillsAudit/skillsAuditNew.jsp");
			view.forward(request, response);

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}
}
