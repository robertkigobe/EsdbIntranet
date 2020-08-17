package technicalResources.staffLoan;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

import util.ConnectionHelper;

/**
 * Servlet implementation class StaffLoanEmployeeRequest
 */
@WebServlet("/StaffLoanEmployeeRequest")
public class StaffLoanEmployeeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:/IntranetWarehouse/StaffLoan";
	public static Connection con;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement selectStatement = null;
		
		ResultSet results = null;
		String employeeCode = null;
		
		ArrayList<String> employeeCodes = new ArrayList<String>();
		

		employeeCodes.clear();
		

		employeeCodes.add("Select your Employee No.");

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String sql1 ="SELECT distinct[employeeCode]  FROM [SwaziBankIntranet2016].[dbo].[dynamiqueEmployees] order by EmployeeCode";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql1);

				while (results.next()) {
					employeeCode = results.getString("employeeCode");

					employeeCodes.add(employeeCode);
				}
				
				
				request.setAttribute("employeeCodes", employeeCodes);
				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanEmployeeCodeRequest.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String employeeCode = null;
		
		String password= null;
		
		employeeCode = request.getParameter("employeeCode");
		
		 password = request.getParameter("password");
		
				
	      String title  = null;
	      String surName  = null;
	      String firstName  = null;
	      String secondName  = null;
	      String dateOfBirth  = null;
	      String iDNumber  = null;
	      String gender  = null;
	      String maritalStatus  = null;
	      String employeeAddress  = null;
	      String postCode  = null;
	      String branchAdress  = null;
	      String homeTelNo  = null;
	      String emailAddress  = null;
	      String dateEngaged  = null;
	      String dependants  = null;
	      String employeePosition  = null;
	      String employeeGrade  = null;
	      String employeeSupervisor  = null;
	      String department  = null;
	      String location  = null;
	      String cif  = null;
	      
	     
		Statement selectStatement = null;
		ResultSet results = null;

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();

		if (con != null) {

			String sql = "SELECT  top 1 [employeeCode],[password] FROM [SwaziBankIntranet2016].[dbo].[dynamiqueEmployees] "
					+ "where [employeeCode] = '" + employeeCode + "'  order by [employeeCode] desc";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				/*
				if (!results.next()) {
					RequestDispatcher view = request
							.getRequestDispatcher("WEB-INF/utilities/badPassword.jsp");
					view.forward(request, response);
					
				} else { */

					
						String sql2 = "SELECT [employeeCode] ,"
								+ "[title]  ,"
								+ "[surName]   ,"
								+ "[firstName]  ,"
								+ "[secondName]  ,"
								+ "convert(date, [dateOfBirth], 23 ) as 'dateOfBirth'   ,"
								+ "[iDNumber]  ,"
								+ "[gender]  ,"
								+ "[maritalStatus]  ,"
								+ "[employeeAddress] ,"
								+ "[postCode]  ,"
								+ "[branchAdress] ,"
								+ "[homeTelNo]  ,"
								+ "[emailAddress]  ,"
								+ "[dateEngaged]  ,"
								+ "[dependants] ,"
								+ "[position]  ,"
								+ "[employeeGrade]  ,"
								+ "[employeeSupervisor]  ,"
								+ "[password]  ,"
								+ "[department] ,"
								+ "[location] ,"
								+ "[cif]  "
								+ "FROM [SwaziBankIntranet2016].[dbo].[dynamiqueEmployees] where [employeeCode] = '"+employeeCode+"'";

						try {
							selectStatement = con.createStatement();
							results = selectStatement.executeQuery(sql2);

							while (results.next()) {

						        title = results.getString("title");
						        surName = results.getString("surName");
						        firstName = results.getString("firstName");
						        secondName = results.getString("secondName");
						        dateOfBirth = results.getString("dateOfBirth");
						        iDNumber = results.getString("iDNumber");
						        gender = results.getString("gender");
						        maritalStatus = results.getString("maritalStatus");
						        employeeAddress = results.getString("employeeAddress");
						        postCode = results.getString("postCode");
						        branchAdress = results.getString("branchAdress");
						        homeTelNo = results.getString("homeTelNo");
						        emailAddress = results.getString("emailAddress");
						        dateEngaged = results.getString("dateEngaged");
						        dependants = results.getString("dependants");
						        employeePosition = results.getString("position");
						        employeeGrade = results.getString ("employeeGrade");
						        employeeSupervisor = results.getString("employeeSupervisor");
						        department = results.getString("department");
						        location = results.getString("location");
						        cif = results.getString("cif");

							
							}

							request.setAttribute("employeeCode",employeeCode)  ;
							request.setAttribute("title",title);
							request.setAttribute("surName",surName);
							request.setAttribute("firstName",firstName);
							
							request.setAttribute("secondName",secondName);
							request.setAttribute("iDNumber",iDNumber);
							request.setAttribute("cif",cif);
							request.setAttribute("dateOfBirth",dateOfBirth);
							request.setAttribute("gender", gender);
							request.setAttribute("maritalStatus", maritalStatus);
							request.setAttribute("dateEngaged",dateEngaged);
							request.setAttribute("employeePosition",employeePosition);
							request.setAttribute("employeeGrade",employeeGrade);
							request.setAttribute("department",department);
							request.setAttribute("branchAdress", branchAdress);
							request.setAttribute("employeeAddress",employeeAddress);
							request.setAttribute("employeeSupervisor",employeeSupervisor);
							request.setAttribute("homeTelNo",homeTelNo);
							request.setAttribute("dependants",dependants);
							request.setAttribute("postCode",postCode);
							request.setAttribute("emailAddress", emailAddress);
							request.setAttribute("password",password);
							request.setAttribute("location", location);
							

							if (ServletFileUpload.isMultipartContent(request)) {
								
								try {
									List<FileItem> multiparts = new ServletFileUpload(
											new DiskFileItemFactory()).parseRequest(request);
									for (FileItem item : multiparts) {
										if (!item.isFormField()) {
											String name = new File(item.getName()).getName();
											item.write(new File(UPLOAD_DIRECTORY + File.separator
													+ name));
											
											System.out.println("in here uploading");
											
										}
									}
									
									
								} catch (Exception ex) {
									request.setAttribute("message", "File Upload Failed due to "
											+ ex);
								}
							} 
							

							RequestDispatcher view = request
									.getRequestDispatcher("WEB-INF/technicalResources_StaffLoan/staffLoanNewStaffResume.jsp");
							view.forward(request, response);
							
							
							
						} catch (SQLException e) {

							e.printStackTrace();
							System.out.println("Cannot connect to activity database here");
						}
					
				

			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
