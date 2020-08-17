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

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import util.ConnectionHelper;

@WebServlet("/SkillsAuditReportRequest")
public class SkillsAuditReportRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	String department;
	String bscEmployeeName;
	String password;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String department;
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

		request.setAttribute("departments", departments);

		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/technicalResources_skillsAudit/skillsAuditReportRequest.jsp");
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

			Statement selectStatement = null;
			ResultSet results = null;

			ConnectionHelper connectionHelper = new ConnectionHelper();
			con = connectionHelper.connect();

			ArrayList<SkillsAuditReportBean> reportSkills = new ArrayList<SkillsAuditReportBean>();

			reportSkills.clear();

			if (con != null) {

				String sql = "SELECT subDepartment,position, bscEmployeeName,bscEmployeeSupervisor,category,skill,rating,priority, remarks   FROM [dbo].[SkillsAuditScores] where department = '"
						+ department
						+ " ' and category in ('Education','Qualifications','Experience','Technical knowledge', 'Personal Attributes' ) order by  department, subDepartment, category, skill";

				try {
					selectStatement = con.createStatement();
					results = selectStatement.executeQuery(sql);

					while (results.next()) {

						subDepartment = results.getString("subDepartment");
						position = results.getString("position");
						category = results.getString("category");
						skill = results.getString("skill");
						bscEmployeeName = results.getString("bscEmployeeName");
						bscEmployeeSupervisor = results
								.getString("bscEmployeeSupervisor");
						rating = results.getString("rating");
						priority = results.getString("priority");
						remarks = results.getString("remarks");

						reportSkills.add(new SkillsAuditReportBean(
								subDepartment, position, category, skill,
								bscEmployeeName, bscEmployeeSupervisor, rating,
								priority, remarks));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("Cannot connect to activity database here");
				}

			}

			Document document = new Document(PageSize.A3.rotate());

			try {

				response.setContentType("application/pdf");
				PdfWriter.getInstance(document, response.getOutputStream());
				document.open();

				PdfPTable table = new PdfPTable(8);
				table.setWidths(new int[] { 12, 15, 18, 15, 15, 8, 12, 18 });
				table.setWidthPercentage(100);
				table.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.setSpacingBefore(10);
				table.getDefaultCell().setBorder(Rectangle.BOX);
				// //// add table array

				table.addCell("Sub Department");
				table.addCell("Position");
				table.addCell("Employee Name");
				table.addCell("Category");
				table.addCell("Skill");
				table.addCell("Rating");
				table.addCell("Priority");
				table.addCell("Remarks");

				for (SkillsAuditReportBean saRow : reportSkills) {

					table.addCell(saRow.getSubDepartment());
					table.addCell(saRow.getPosition());
					table.addCell(saRow.getBscEmployeeName());
					table.addCell(saRow.getCategory());
					table.addCell(saRow.getSkill());
					table.addCell(saRow.getRating());
					table.addCell(saRow.getPriority());
					table.addCell(saRow.getRemarks());

				}

				document.add(table);
			} catch (Exception e) {
				e.printStackTrace();
			}
			document.close();

		} else {
			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/issueTrackingFaces/badPassword.jsp");
			view.forward(request, response);
		}

	}

	public boolean departmentLogin(String department, String bscEmployeeName) {

		if ((department.equals("Operations"))
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
