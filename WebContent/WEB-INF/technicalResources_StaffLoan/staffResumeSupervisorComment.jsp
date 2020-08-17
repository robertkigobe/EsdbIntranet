<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Staff Loan Application</title>

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js"></script>

</head>
<body>
	<div class="container">
		<div>
			<jsp:include page="../utilities/_header.jsp"></jsp:include>
		</div>

		<div>
			<jsp:include page="../utilities/_menu.jsp"></jsp:include>
			<div class="clear"></div>
		</div>
		<div>
			<jsp:include page="../utilities/bar.jsp"></jsp:include>
			<div class="clear"></div>
		</div>
		<div>
			<div class="leftNav">

				<h4>Quick Links</h4>

				<Ol>


					<li><a href="${pageContext.request.contextPath}/History">SwaziBank
							History</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard">SwaziBank
							Notice Board</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews">Briefs
							And News</a></li>
					<li><a
						href="${pageContext.request.contextPath}/IntranetFeedBack">Feedback</a></li>
					<li><a
						href="${pageContext.request.contextPath}/InternalAdvert">Internal
							Vacancies</a></li>


				</Ol>
			</div>
			<div class="rightNav">


				<div style="margin-left: 40px;">
					<h3>Staff Loan Supervisor Comment</h3>
					<div>
						<form action="StaffLoanSupervisorCommentPosting" method="POST">
						
						<input type="text" value="Loan Ref:" readonly
								style="border-style: outset;" /> <input type="text"
								name="employeeLoanRef" 
								value="${employeeLoanRef}" style="border-style: outset;" readonly/> <br> 

							<input type="text" value="Loan Status:" readonly
								style="border-style: outset;" /> <select name="loanStatus"
								style="border-style: outset;">
								<option>Pending HOD Comment</option>
							</select> <br> 
							
							<input type="text" value="Employee Name" readonly
								style="border-style: outset;" /> <input type="text"
								name="employeeName" 
								value="${employeeName}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Employment No" readonly
								style="border-style: outset;" /> <input type="text"
								name="employeeEmploymentNo" 
								value="${employeeEmploymentNo}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Employee CIF" readonly
								style="border-style: outset;" /> <input type="text"
								name="cif" 
								value="${cif}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Employee National Id" readonly
								style="border-style: outset;" /> <input type="text"
								name="nationalId" 
								value="${nationalId}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Date Of Birth" readonly
								style="border-style: outset;" /> <input type="text"
								name="employeeDOB" 
								value="${employeeDOB}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Branch" readonly
								style="border-style: outset;" /> <input type="text"
								name="branch" 
								value="${branch}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Branch Adress" readonly
								style="border-style: outset;" /> <input type="text"
								name="branchAdress" 
								value="${branchAdress}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Department" readonly
								style="border-style: outset;" /> <input type="text"
								name="employeeDepartment" 
								value="${employeeDepartment}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Position" readonly
								style="border-style: outset;" /> <input type="text"
								name="employeePosition" 
								value="${employeePosition}" style="border-style: outset;" readonly/> <br> 
								
								
								<input type="text" value="Supervisor" readonly
								style="border-style: outset;" /> <input type="text"
								name="supervisor" 
								value="${supervisor}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Employee Address" readonly
								style="border-style: outset;" /> <input type="text"
								name="employeeAddress" 
								value="${employeeAddress}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="City" readonly
								style="border-style: outset;" /> <input type="text"
								name="city" 
								value="${city}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Employee TelelephoneNo" readonly
								style="border-style: outset;" /> <input type="text"
								name="employeeTelelephoneNo" 
								value="${employeeTelelephoneNo}" style="border-style: outset;" readonly/> <br> 
								
								
								
								<input type="text" value="Applicant Comment Date" readonly
								style="border-style: outset;" /> <input type="text"
								name="applicantCommentDate" 
								value="${applicantCommentDate}" style="border-style: outset;" readonly/> <br>
								
								<input type="text" value="Created By" readonly
								style="border-style: outset;" /> <input type="text"
								name="createdBy" 
								value="${createdBy}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Date Application Forwarded:" readonly
								style="border-style: outset;" /> <input type="text"
								name="dateCreated" 
								value="${dateCreated}" style="border-style: outset;" readonly/> <br> 
								
								<input type="text" value="Applicant Comment" readonly
								style="border-style: outset;" /> <input type="text"
								name="applicantComment" 
								value="${applicantComment}" style="border-style: outset; width: 800px;" readonly/> <br> 	
								
								<input type="text"
								value="Supervisor Comment" readonly style="border-style: outset;" />
							<input type="text" name="supervisorComment" style="border-style: outset; width: 800px;"><br>	
							
							<input
								type="text" value="Supervisor Email" readonly
								style="border-style: outset;" /> <input type="text"
								name="employeeEmail" style="border-style: outset; " /> <br>
							
							<input
								type="text" value="Head of Department" readonly
								style="border-style: outset;" /> <select name="hod" style="border-style: outset;"
								required>

								<option></option>

								<option>Dumase Nxumalo</option>
								<option>Enoch Mavimbela</option>
								<option>Lindiwe Shongwe</option>
								<option>Nozizwe Mulera</option>
								<option>Paul Waswa</option>
								<option>Sifiso Mdluli</option>
								<option>Tawonga</option>
								<option>Thembi Dlamini</option>
								<option>Zakhele Lukele</option>
								<option>Zanele E Dlamini</option>
								</select>
								
								<input
								type="text" value="Hod Email" readonly
								style="border-style: outset;" /> <input type="text"
								name="hodEmail" style="border-style: outset;" /> <br>
				

							<div>
								<input class="button" type="submit"
									value="Submit Supervisor Comment"></input>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>

		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
</body>
</html>
