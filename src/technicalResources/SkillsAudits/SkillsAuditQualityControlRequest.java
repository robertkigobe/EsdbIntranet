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

import util.ConnectionHelper;

@WebServlet("/SkillsAuditQualityControlRequest")
public class SkillsAuditQualityControlRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	String department;
	String bscEmployeeName;
	String password;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String department;
		String bscEmployeeName;

		Statement selectStatement = null;
		ResultSet results = null;

		ArrayList<String> departments = new ArrayList<String>();
		ArrayList<String> subDepartments = new ArrayList<String>();
		ArrayList<String> positions = new ArrayList<String>();
		ArrayList<String> bscEmployeeSupervisors = new ArrayList<String>();
		ArrayList<String> bscEmployeeNames = new ArrayList<String>();

		departments.clear();
		subDepartments.clear();
		positions.clear();
		bscEmployeeSupervisors.clear();
		bscEmployeeNames.clear();

		departments.add("Choose Department");
		bscEmployeeNames.add("Choose Employee");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sqlDepartment = "SELECT distinct( [department]) FROM [SwaziBankIntranet2016].[dbo].[SkillsAuditScores] where department is not null;";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sqlDepartment);

				while (results.next()) {

					department = results.getString("department");
					departments.add(department);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}

		if (con != null) {
			String sqlEmployee = "SELECT distinct( [bscEmployeeName]) FROM [SwaziBankIntranet2016].[dbo].[SkillsAuditScores] where bscEmployeeName is not null;";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sqlEmployee);

				while (results.next()) {

					bscEmployeeName = results.getString("bscEmployeeName");
					bscEmployeeNames.add(bscEmployeeName);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

		request.setAttribute("departments", departments);
		request.setAttribute("bscEmployeeNames", bscEmployeeNames);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_skillsAudit/skillsAuditQualityControlRequest.jsp");
		view.forward(request, response);

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		department = request.getParameter("department");
		bscEmployeeName = request.getParameter("bscEmployeeName");
		password = request.getParameter("password");
		String bscEmployeeSupervisor = null;
		String subDepartment = null;
		String position = null;
		String category = null;
		String skill = null;
		String rating = null;
		String priority = null;
		String remarks = null;

		if (departmentLogin(department, bscEmployeeName)) {

			Statement selectStatementPosition = null;
			Statement selectStatementEducation = null;
			ResultSet resultsPosition = null;
			ResultSet resultsEducation = null;

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();

			ArrayList<SkillsAuditMetricEditBean> educationSkills = new ArrayList<SkillsAuditMetricEditBean>();
			ArrayList<SkillsAuditMetricEditBean> technicalSkills = new ArrayList<SkillsAuditMetricEditBean>();
			ArrayList<SkillsAuditMetricEditBean> professionalSkills = new ArrayList<SkillsAuditMetricEditBean>();
			ArrayList<SkillsAuditMetricEditBean> qualificationSkills = new ArrayList<SkillsAuditMetricEditBean>();
			ArrayList<SkillsAuditMetricEditBean> experienceSkills = new ArrayList<SkillsAuditMetricEditBean>();
			ArrayList<SkillsAuditMetricEditBean> pastExperience = new ArrayList<SkillsAuditMetricEditBean>();
			ArrayList<SkillsAuditMetricEditBean> extraCurricular = new ArrayList<SkillsAuditMetricEditBean>();
			ArrayList<SkillsAuditMetricEditBean> pastAwards = new ArrayList<SkillsAuditMetricEditBean>();

			educationSkills.clear();
			technicalSkills.clear();
			professionalSkills.clear();
			qualificationSkills.clear();
			experienceSkills.clear();
			pastExperience.clear();
			extraCurricular.clear();
			pastAwards.clear();

			if (con != null) {

				String sql1 = "SELECT  position, subDepartment, bscEmployeeSupervisor   FROM [SwaziBankIntranet2016].[dbo].[SkillsAuditScores] where [bscEmployeeName] = '"
						+ bscEmployeeName + "'";

				try {
					selectStatementPosition = con.createStatement();
					resultsPosition = selectStatementPosition
							.executeQuery(sql1);

					while (resultsPosition.next()) {
						position = resultsPosition.getString("position");
						subDepartment = resultsPosition
								.getString("subDepartment");
						bscEmployeeSupervisor = resultsPosition
								.getString("bscEmployeeSupervisor");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}

			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditScores] where bscEmployeeName = '"
						+ bscEmployeeName + " '  and  category ='Education ' ";

				try {
					selectStatementEducation = con.createStatement();
					resultsEducation = selectStatementEducation
							.executeQuery(sql1);

					while (resultsEducation.next()) {

						category = resultsEducation.getString("category");
						skill = resultsEducation.getString("skill");
						rating = resultsEducation.getString("rating");
						priority = resultsEducation.getString("priority");
						remarks = resultsEducation.getString("remarks");

						educationSkills.add(new SkillsAuditMetricEditBean(
								category, skill, rating, priority, remarks));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			
			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditScores] where bscEmployeeName = '"
						+ bscEmployeeName + " '  and  category ='Technical knowledge' ";

				try {
					selectStatementEducation = con.createStatement();
					resultsEducation = selectStatementEducation
							.executeQuery(sql1);

					while (resultsEducation.next()) {

						category = resultsEducation.getString("category");
						skill = resultsEducation.getString("skill");
						rating = resultsEducation.getString("rating");
						priority = resultsEducation.getString("priority");
						remarks = resultsEducation.getString("remarks");

						technicalSkills.add(new SkillsAuditMetricEditBean(
								category, skill, rating, priority, remarks));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			
			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditScores] where bscEmployeeName = '"
						+ bscEmployeeName + " '  and  category ='Personal Attributes' ";

				try {
					selectStatementEducation = con.createStatement();
					resultsEducation = selectStatementEducation
							.executeQuery(sql1);

					while (resultsEducation.next()) {

						category = resultsEducation.getString("category");
						skill = resultsEducation.getString("skill");
						rating = resultsEducation.getString("rating");
						priority = resultsEducation.getString("priority");
						remarks = resultsEducation.getString("remarks");

						professionalSkills.add(new SkillsAuditMetricEditBean(
								category, skill, rating, priority, remarks));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			
			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditScores] where bscEmployeeName = '"
						+ bscEmployeeName + " '  and  category ='Qualifications' ";

				try {
					selectStatementEducation = con.createStatement();
					resultsEducation = selectStatementEducation
							.executeQuery(sql1);

					while (resultsEducation.next()) {

						category = resultsEducation.getString("category");
						skill = resultsEducation.getString("skill");
						rating = resultsEducation.getString("rating");
						priority = resultsEducation.getString("priority");
						remarks = resultsEducation.getString("remarks");

						qualificationSkills.add(new SkillsAuditMetricEditBean(
								category, skill, rating, priority, remarks));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			
			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditScores] where bscEmployeeName = '"
						+ bscEmployeeName + " '  and  category ='Experience' ";

				try {
					selectStatementEducation = con.createStatement();
					resultsEducation = selectStatementEducation
							.executeQuery(sql1);

					while (resultsEducation.next()) {

						category = resultsEducation.getString("category");
						skill = resultsEducation.getString("skill");
						rating = resultsEducation.getString("rating");
						priority = resultsEducation.getString("priority");
						remarks = resultsEducation.getString("remarks");

						experienceSkills.add(new SkillsAuditMetricEditBean(
								category, skill, rating, priority, remarks));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			
			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditScores] where bscEmployeeName = '"
						+ bscEmployeeName + " '  and  category ='Extra Awards' ";

				try {
					selectStatementEducation = con.createStatement();
					resultsEducation = selectStatementEducation
							.executeQuery(sql1);

					while (resultsEducation.next()) {

						category = resultsEducation.getString("category");
						skill = resultsEducation.getString("skill");
						rating = resultsEducation.getString("rating");
						priority = resultsEducation.getString("priority");
						remarks = resultsEducation.getString("remarks");

						pastAwards.add(new SkillsAuditMetricEditBean(
								category, skill, rating, priority, remarks));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			
			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditScores] where bscEmployeeName = '"
						+ bscEmployeeName + " '  and  category ='Extra Curricular' ";

				try {
					selectStatementEducation = con.createStatement();
					resultsEducation = selectStatementEducation
							.executeQuery(sql1);

					while (resultsEducation.next()) {

						category = resultsEducation.getString("category");
						skill = resultsEducation.getString("skill");
						rating = resultsEducation.getString("rating");
						priority = resultsEducation.getString("priority");
						remarks = resultsEducation.getString("remarks");

						extraCurricular.add(new SkillsAuditMetricEditBean(
								category, skill, rating, priority, remarks));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}
			
			if (con != null) {

				String sql1 = "SELECT *  FROM [dbo].[SkillsAuditScores] where bscEmployeeName = '"
						+ bscEmployeeName + " '  and  category ='Past Experience' ";

				try {
					selectStatementEducation = con.createStatement();
					resultsEducation = selectStatementEducation
							.executeQuery(sql1);

					while (resultsEducation.next()) {

						category = resultsEducation.getString("category");
						skill = resultsEducation.getString("skill");
						rating = resultsEducation.getString("rating");
						priority = resultsEducation.getString("priority");
						remarks = resultsEducation.getString("remarks");

						pastExperience.add(new SkillsAuditMetricEditBean(
								category, skill, rating, priority, remarks));
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
			request.setAttribute("bscEmployeeName", bscEmployeeName);
			request.setAttribute("bscEmployeeSupervisor", bscEmployeeSupervisor);
			request.setAttribute("department", department);
			request.setAttribute("educationSkills", educationSkills);
			request.setAttribute("qualificationSkills", qualificationSkills);
			request.setAttribute("technicalSkills", technicalSkills);
			request.setAttribute("professionalSkills", professionalSkills);
			request.setAttribute("experienceSkills", experienceSkills);
			request.setAttribute("pastExperience", pastExperience);
			request.setAttribute("extraCurricular", extraCurricular);
			request.setAttribute("pastAwards",pastAwards);

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/technicalResources_skillsAudit/skillsAuditEdit.jsp");
			view.forward(request, response);

		} else {
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/issueTrackingFaces/badPassword.jsp");
			view.forward(request, response);
		}

	}

	public boolean departmentLogin(String department, String bscEmployeeName) {
		
		
		if ((department.equals("Information Technology"))
				&& (password.equals("12345678=ITSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else
		
		if ((department.equals("Business Banking"))
				&& (password.equals("12345678=BBSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else
		
		if ((department.equals("Finance"))
				&& (password.equals("12345678=FNSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else
		
		if ((department.equals("Finance"))
				&& (password.equals("12345678=FNSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else
		if ((department.equals("Office of the MD"))
				&& (password.equals("12345678=MDSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else
		if ((department.equals("Internal Audit"))
				&& (password.equals("12345678=IASA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else
		
		if ((department.equals("Risk and Compliance"))
				&& (password.equals("12345678=RCSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else
		if ((department.equals("Credit"))
				&& (password.equals("12345678=CRSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else 
		if ((department.equals("Legal"))
				&& (password.equals("12345678=LGSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else if ((department.equals("Marketing"))
				&& (password.equals("12345678=MTGSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else if

		((department.equals("Operations"))
				&& (password.equals("12345678=OPSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else if ((department.equals("Corporate Services"))
				&& (password.equals("12345678=CSSA"))
				&& (bscEmployeeName != ("Choose Employee"))) {
			return true;
		} else {
			return false;
		}

	}
}
