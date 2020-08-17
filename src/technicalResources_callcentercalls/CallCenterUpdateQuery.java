package technicalResources_callcentercalls;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import util.ConnectionHelper;

@WebServlet("/CallCenterUpdateQuery")
public class CallCenterUpdateQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement selectStatement = null;
	ResultSet results = null;
	Connection con;
	
	/////////////////////// add bcc for the call center agent//////////////////////////////////
	/////////////////////// add a search box ///////////////

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [responseId] ,[dateOpened],[nameOfAgent],[nameOfCustomer]   ,[customerQuery]      ,[departmentResponsible]      ,[emailSentTo]      ,[resolution]      ,[dateClosed]      ,[status]      ,[dateModified]      ,[lastModifiedBy]  FROM [dbo].[CallCenterCalls] where [Status] = 'In Progress'";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				ArrayList<String> customerList = new ArrayList<String>();
				ArrayList<String> queryList = new ArrayList<String>();
				queryList.clear();

				while (results.next()) {

					String nameOfCustomer = results.getString("nameOfCustomer");
					String customerQuery = results.getString("customerQuery");

					queryList.add(customerQuery);
					customerList.add(nameOfCustomer);
				}
				request.setAttribute("queryList", queryList);
				request.setAttribute("customerList", customerList);

				RequestDispatcher rs = request
						.getRequestDispatcher("WEB-INF/technicalresources_CallCenter/callCenterUpdateRequest.jsp");
				rs.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	String nameOfCustomerP = request.getParameter("nameOfCustomer");
	String customerQueryP  = request.getParameter("customerQuery");
	
	String nameOfAgent = null;
	String nameOfCustomer = null;
	String customerQuery = null;
	String departmentResponsible = null;
	String emailSentTo = null;
	String status = null;
	String resolution  = null;
	
	ConnectionHelper connectionHelper = new ConnectionHelper();
	con = connectionHelper.connect();
	if (con != null) {

		String sql = "SELECT [responseId]      ,[dateOpened]      ,[nameOfAgent]      ,[nameOfCustomer]      ,[customerQuery]      ,[departmentResponsible]      ,[emailSentTo]      ,[resolution]      ,[dateClosed]      ,[status]      ,[dateModified]      ,[lastModifiedBy]  FROM [dbo].[CallCenterCalls] where [nameOfCustomer]   = '"+nameOfCustomerP+"' and [customerQuery]   = '"+customerQueryP+"'";

		try {
			selectStatement = con.createStatement();
			results = selectStatement.executeQuery(sql);

			while (results.next()) {

				nameOfAgent = results.getString("nameOfAgent");
			    nameOfCustomer = results.getString("nameOfCustomer");
				customerQuery = results.getString("customerQuery");
				departmentResponsible = results.getString("departmentResponsible");
				emailSentTo = results.getString("emailSentTo");
				status = results.getString("status");
				resolution  = results.getString("resolution");
		
			}
	
			
			request.setAttribute("nameOfAgent", nameOfAgent);
			request.setAttribute("nameOfCustomer", nameOfCustomer);
			request.setAttribute("customerQuery", customerQuery);
			request.setAttribute("departmentResponsible", departmentResponsible);
			request.setAttribute("emailSentTo", emailSentTo);
			request.setAttribute("status", status);
			request.setAttribute("resolution", resolution);
			
		
		
		

			RequestDispatcher rs = request
					.getRequestDispatcher("WEB-INF/technicalresources_CallCenter/callCenterUpdateQuery.jsp");
			rs.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot connect to activity database here");
		}
	} else {
		
		RequestDispatcher rs = request
				.getRequestDispatcher("WEB-INF/technicalresources_CallCenter/callCenterNoResultsQuery.jsp");
		rs.forward(request, response);
	}
	
	
	}
	
	

}
