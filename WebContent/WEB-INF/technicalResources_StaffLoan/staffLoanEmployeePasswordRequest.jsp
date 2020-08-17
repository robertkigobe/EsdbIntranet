<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Staff Loan Password Request</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>


<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="js/bootstrap.js"></script>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>

<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/HomePage.css" rel="stylesheet" type="text/css" />

<style>
* {
	font-size: 15px;
	line-height: 1.428;
}
</style>
<body>
	<div class="container-fluid">
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


				<ol class="list-group">

					<li><a
						href="${pageContext.request.contextPath}/StaffLoanEmployeePasswordRequest" class="list-group-item list-group-item-action active">Staff Loan Password Request</a></li>
					
					<li><a
						href="#" class="list-group-item list-group-item-action active">Reset a Staff Loan</a></li>
						
						<li><a
						href="#" class="list-group-item list-group-item-action active">Cancel a Staff Loan</a></li>
						
						<li><a
						href="#" class="list-group-item list-group-item-action active">Delegate a Staff Loan</a></li>
						

					<li><a
						href="${pageContext.request.contextPath}/StaffLoanHrAnalysisRequest" class="list-group-item list-group-item-action active">Analyze Staff Loan</a></li>

					<li><a
						href="${pageContext.request.contextPath}/StaffLoanAdministrationRolePlayers" class="list-group-item list-group-item-action active">Set Up Staff Loan Role Players</a></li>



				</Ol>

			</div>


			<div class="rightNav">

				<div class="page-header">
					<h4>Staff Loan Password Request</h4>
					<br>
				</div>

				<form method="post" action="StaffLoanEmployeePasswordRequest" class="form col-md-7">

					

					<div class="form-group">
												
						<label>Select Employee Code :</label> <select name="employeeCode" class="form-control">
							<c:forEach items="${employeeCodes}" var="employeeCodes">
								<option value="${employeeCodes}">${employeeCodes}</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-primary">Submit</button> 
					</div>
				</form>
			</div>

		</div>

	</div>

	<div class="clear"></div>
	<div>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>

</body>
</html>