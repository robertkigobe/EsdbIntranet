package technicalResources.staffLoan;

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
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import util.ConnectionHelper;

/**
 * Servlet implementation class StaffLoanPayrollMasterRequest
 */
@WebServlet("/StaffLoanHrAnalysisRequest")
public class StaffLoanHrAnalysisRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				
		Statement selectStatement = null;
		ResultSet results = null;
		String userName = System.getProperty("user.name");
		request.setAttribute("userName", userName);

		ArrayList<String> pendingLoanDisbursementsRequests = new ArrayList<String>();

		pendingLoanDisbursementsRequests.clear();
		pendingLoanDisbursementsRequests.add("Please select Loan reference in the email");
		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  *  FROM [dbo].[StaffLoan] where  [loanStatus] in ('Loan Disbursed', 'Cancelled')";
			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					String loanRef = results.getString("employeeLoanRef");

					pendingLoanDisbursementsRequests.add(loanRef);
				}
				
				request.setAttribute("pendingLoanDisbursementsRequests", pendingLoanDisbursementsRequests);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanHrAnalysisRequest.jsp");
				view.forward(request, response);			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;

		
		String employeeLoanRef = request.getParameter("employeeLoanRef");
		String allowances;
	     String applicantComment;
	     String applicantCommentDate;
	     String basicSalary;
	     String dateloanRequired;
	     String dateOfBirth;
	     String dateEngaged;
	     String employeeCode;
	     String employeeGrade;
	     String employeePosition;
	     String firstname;
	     String hodComment;
	     String hodCommentDate;
	     String hrPayrollMasterComment;
	     String hrPayrollMasterCommentDate;
	     String instalment;
	     String loanOpeningSupervisorComment;
	     String loanOpeningSupervisorCommentDate;
	     String location;
	     String maritalStatus;
	     String noOfDependants;
	     String repaymentPeriod;
	     String resAddress;
	     String seniorHrManagerComment;
	     String seniorHrManagerCommentDate;
	     String statutoryDeductions;
	     String supervisorComment;
	     String supervisorCommentDate;
	     String surname;
	     String targetSavings;
	     String telelephoneNo;
	     float totalDeductions = 0;
			ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT  * FROM [SwaziBankIntranet2016].[dbo].[StaffLoan] "
					+ "where [employeeLoanRef] = '" + employeeLoanRef + "' ";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {

					results.getString("administationFee");
				      allowances = results.getString("allowances");
				      applicantComment = results.getString("applicantComment");
				      applicantCommentDate = results.getString("applicantCommentDate");
				      results.getString("bankExecutioner");
				      results.getString("bankExecutionerCapacity");
				      basicSalary = results.getString("basicSalary");
				      results.getString("branchAdress");
				      results.getString("boxAddress");
				      results.getString("carloanDeductions");
				      results.getString("carloanBalance");
				      results.getString("cif");
				      results.getString("city");
				      results.getString("cityCouncilRatesDeductions");
				      results.getString("cityCouncilRatesBalance");
				      results.getString("createdBy");
				      dateloanRequired = results.getString("dateloanRequired");
				      dateOfBirth = results.getString("dateOfBirth");
				      dateEngaged = results.getString("dateEngaged");
				      results.getString("dateOfFirstInstallment");
				      results.getString("dateOfLastInstallment");
				      results.getString("educationalloanDeductions");
				      results.getString("educationalloanBalance");
				      results.getString("emailAddress");
				      results.getString("employeeAddress");
				      employeeCode = results.getString("employeeCode");
				      results.getString("employeeEmail");
				      employeeGrade = results.getString("employeeGrade");
				      employeePosition = results.getString("employeePosition");
				      results.getString("employeeDepartment");
				      employeeLoanRef = results.getString("employeeLoanRef");
				      results.getString("establishmentFee");
				      results.getString("farm_smallHolderDeductions");
				      results.getString("farm_smallHolderBalance");
				      firstname = results.getString("firstname");
				      results.getString("headOfDepartmentComment");
				      results.getString("headOfDepartmentCommentDate");
				      results.getString("hod");
				      hodComment = results.getString("hodComment");
				      hodCommentDate = results.getString("hodCommentDate");
				      results.getString("hodEmail");
				      results.getString("housingloanDeductions");
				      results.getString("housingloanBalance");
				      hrPayrollMasterComment = results.getString("hrPayrollMasterComment");
				      hrPayrollMasterCommentDate = results.getString("hrPayrollMasterCommentDate");
				      results.getString("hrPayrollMasterEmail");
				      results.getString("iDNumber");
				      instalment = results.getString("instalment");
				      results.getString("insurancesDeductions");
				      results.getString("insurancesBalance");
				      results.getString("interestRate");
				      results.getString("lastModifiedBy");
				      results.getString("lastModifiedDate");
				      results.getString("legalAdvisorEmail");
				      results.getString("legalAdvisorComment");
				      results.getString("legalAdvisorCommentDate");
				      results.getString("loanAmount");
				      results.getString("loanAmountWords");
				      String loanAndCharges = results.getString("loanAndCharges");
				      loanOpeningSupervisorComment = results.getString("loanOpeningSupervisorComment");
				      loanOpeningSupervisorCommentDate = results.getString("loanOpeningSupervisorCommentDate");
				      results.getString("loanOpeningSupervisorEmail");
				      location = results.getString("location");
				      results.getString("limitRef");
				      results.getString("loanStatus");
				      results.getString("loanType");
				      maritalStatus = results.getString("maritalStatus");
				      noOfDependants = results.getString("noOfDependants");
				      results.getString("otherBalance");
				      results.getString("otherDeductions");
				      results.getString("otherDeductionsExcLeaveAllowance");
				      results.getString("personalloanDeductions");
				      results.getString("personalloanBalance");
				      results.getString("purposeOfLoan");
				      results.getString("postCode");
				      repaymentPeriod = results.getString("repaymentPeriod");
				      
				      System.out.println(repaymentPeriod);
				      
				      
				      resAddress = results.getString("resAddress");
				      results.getString("ruralHousingloanDeductions");
				      results.getString("ruralHousingloanBalance");
				      results.getString("secondName");
				      results.getString("securitiesPrinted");
				      results.getString("securitiesComment");
				      results.getString("securitiesCommentDate");
				      results.getString("seniorHrManagerEmail");
				      seniorHrManagerComment = results.getString("seniorHrManagerComment");
				      seniorHrManagerCommentDate = results.getString("seniorHrManagerCommentDate");
				      statutoryDeductions = results.getString("statutoryDeductions");
				      results.getString("studyloanDeductions");
				      results.getString("studyloanBalance");
				      supervisorComment = results.getString("supervisorComment");
				      supervisorCommentDate = results.getString("supervisorCommentDate");
				      results.getString("supervisorEmail");
				      results.getString("supervisor");
				      surname = results.getString("surname");
				      results.getString("securitiesSupervisorEmail");
				      results.getString("securitiesDocumentLocation");
				      results.getString("securitiesDocumentUploadDate");
				      targetSavings = results.getString("targetSavings");
				      telelephoneNo = results.getString("telelephoneNo");
				      
				   
				      

				      FontFactory.getFont(FontFactory.HELVETICA,
								7, Font.NORMAL);
						Font blackFontListHeading = FontFactory.getFont(
								FontFactory.HELVETICA, 10, Font.NORMAL,
								new CMYKColor(75, 68, 67, 90));
						FontFactory.getFont(
								FontFactory.HELVETICA, 8, Font.UNDERLINE,
								new CMYKColor(75, 68, 67, 90));
						Font blackFontParameterRed = FontFactory.getFont(
								FontFactory.HELVETICA, 9, Font.UNDERLINE,
								new CMYKColor(255, 0, 0, 0));

						FontFactory.getFont(
								FontFactory.HELVETICA, 10, Font.NORMAL);

						Document document = new Document();

						try {

							response.setContentType("application/pdf");
							PdfWriter.getInstance(document,
									response.getOutputStream());
							document.open();
							
							Image img = Image.getInstance("C:/IntranetWarehouse/StaffLoan/logo/headerlogo1.jpg");				       
					        document.add(img);

							new Paragraph(
									"Dated:   " + dateloanRequired,
									blackFontParameterRed);

							new Paragraph(
									"Location:  " + location, blackFontParameterRed);
							
							

							
							document.add(new Paragraph("SWAZIBANK"));
							document.add(new Paragraph("\n"));

							Paragraph applicationLetterParagraph1 = new Paragraph(
									"STAFF LOAN APPLICATION\n\n",
									blackFontListHeading);
							document.add(applicationLetterParagraph1);


							PdfPTable table = new PdfPTable(2);
							table.setWidthPercentage(100);
							table.setHorizontalAlignment(Element.ALIGN_LEFT);
							table.setWidths(new int[] { 5, 8 });
							table.getDefaultCell().setBorder(Rectangle.BOX);

							table.addCell("Name: ");
							table.addCell(firstname + " "+surname);
							table.addCell("Employment No: ");
							table.addCell(employeeCode);
							table.addCell("Date of Birth: ");
							table.addCell(dateOfBirth);
							table.addCell("Branch: ");
							table.addCell(location);
							table.addCell("Position Held: ");
							table.addCell(employeePosition);
							table.addCell("Amount requested: ");
							table.addCell(basicSalary);
							table.addCell("Basic Monthly Salary: ");
							table.addCell(basicSalary);
							table.addCell("Amount Disbursed: ");
							table.addCell(basicSalary);
							table.addCell("Marital Status: ");
							table.addCell(maritalStatus);
							table.addCell("Position Grade: ");
							table.addCell(employeeGrade);
							table.addCell("Address: ");
							table.addCell(resAddress);
							table.addCell("No. of Dependants: ");
							table.addCell(noOfDependants);
							table.addCell("Date Employed: ");
							table.addCell(dateEngaged);
							table.addCell("Tel / Cell: ");
							table.addCell(telelephoneNo);

							document.add(table);

							
						

							Paragraph applicationLetterParagraph31 = new Paragraph(
									"Comments: ",
									blackFontListHeading);
							document.add(applicationLetterParagraph31);
							document.add(new Paragraph("\n"));

							PdfPTable table2 = new PdfPTable(3);
							table2.setWidthPercentage(100);
							table2.setHorizontalAlignment(Element.ALIGN_CENTER);
							table2.setWidths(new int[] { 5, 5, 5 });
							table2.getDefaultCell().setBorder(Rectangle.BOX);

							table2.addCell("Stakeholder");
							table2.addCell("Comment");
							table2.addCell("Time");
							
							table2.addCell("Employee");
							table2.addCell(applicantComment);
							table2.addCell(applicantCommentDate);

							table2.addCell("Supervisor");
							table2.addCell(supervisorComment);
							table2.addCell(supervisorCommentDate);
							
							table2.addCell("HOD");
							table2.addCell(hodComment);
							table2.addCell(hodCommentDate);
							
							table2.addCell("Payroll Master");
							table2.addCell(hrPayrollMasterComment);
							table2.addCell(hrPayrollMasterCommentDate);
							
							table2.addCell("Senior Manager HR");
							table2.addCell(seniorHrManagerComment);
							table2.addCell(seniorHrManagerCommentDate);
							
							table2.addCell("Securities Supevisor");
							table2.addCell(supervisorComment);
							table2.addCell(supervisorCommentDate);
							
							table2.addCell("Loans Opening Supervisor");
							table2.addCell(loanOpeningSupervisorComment);
							table2.addCell(loanOpeningSupervisorCommentDate);
							
							document.add(table2);
							
							

						} catch (Exception e) {
							e.printStackTrace();
						}
						document.close();

					}

				} catch (SQLException e) {

					e.printStackTrace();
					System.out.println("Cannot connect to activity database here");
				}

			}
			try {
				ConnectionHelper.disconnect(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
