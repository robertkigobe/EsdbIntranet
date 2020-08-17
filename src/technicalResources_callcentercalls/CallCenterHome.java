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

@WebServlet("/CallCenterHome")
public class CallCenterHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;
		Connection con;

	
	ConnectionHelper connectionHelper = new ConnectionHelper();
	con = connectionHelper.connect();
	if (con != null) {	
		
	String sql = "SELECT [responseId]  ,[dateOpened]  ,[nameOfAgent] ,[nameOfCustomer]  ,[nameOfStaff] ,[customerQuery]  ,[departmentResponsible]  ,[emailSentTo] ,[emailCopyTo]  ,[emailReplyTo]  ,[emailReplyCopyTo]  ,[resolution]  ,[dateClosed]  ,[status]  ,[dateModified]  ,[lastModifiedBy]  FROM [dbo].[CallCenterCalls] where  [status] in ('In Progress') order by [dateOpened] asc";
	
	try {
		selectStatement = con.createStatement();
		results = selectStatement.executeQuery(sql);
		
		ArrayList<CallcenterBean> queryList = new ArrayList<CallcenterBean>();
		queryList.clear();
		
		while (results.next()) {
			
			String nameOfAgent = results.getString("nameOfAgent");
			String nameOfCustomer = results.getString("nameOfCustomer");
			String customerQuery = results.getString("customerQuery");
			String departmentResponsible = results.getString("departmentResponsible");
			String emailSentTo = results.getString("emailSentTo");
			String status = results.getString("status");
			String emailCopyTo = results.getString("emailCopyTo");
			String emailReplyCopyTo = results.getString("emailReplyCopyTo");
			String emailReplyTo = results.getString("emailReplyTo");
			String nameOfStaff = results.getString("nameOfStaff");
			
			
			String resolution  = results.getString("resolution");
			String dateOpened  = results.getString("dateOpened");
			String dateClosed  = results.getString("dateClosed");
			String dateModified =  results.getString("dateModified");
			String lastModifiedBy =  results.getString("lastModifiedBy");
			
			
			queryList.add(new CallcenterBean(  customerQuery,
				     dateClosed,
				     dateModified,
				     dateOpened,
				     departmentResponsible,
				     emailCopyTo,
				     emailReplyTo,
				     emailReplyCopyTo,
				     emailSentTo,
				     lastModifiedBy,
				     nameOfAgent,
				     nameOfCustomer,
				     nameOfStaff,
				     resolution,
				     status));
		}
		request.setAttribute("queryList", queryList);

		
		RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/technicalresources_CallCenter/callCenterHome.jsp");
		rs.forward(request, response);
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Cannot connect to activity database here");
	} 
}
}

}
