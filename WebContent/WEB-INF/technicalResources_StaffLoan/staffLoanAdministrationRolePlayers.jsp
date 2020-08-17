<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOD Staff Loan Comments</title>
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
</head>
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

					<li class="list-group-item">
						<h4>Quick Links</h4>
					</li>
					
					<li><a href="#"
						class="list-group-item list-group-item-action active">Request
							Staff Password</a></li>

					<li><a href="#"
						class="list-group-item list-group-item-action active">Reset a
							Staff Loan</a></li>

					<li><a href="#"
						class="list-group-item list-group-item-action active">Cancel a
							Staff Loan</a></li>

					<li><a href="#"
						class="list-group-item list-group-item-action active">Delegate
							a Staff Loan</a></li>


					<li><a
						href="${pageContext.request.contextPath}/StaffLoanHrAnalysisRequest"
						class="list-group-item list-group-item-action active">Analyze
							Staff Loan</a></li>

					<li><a href="#"
						class="list-group-item list-group-item-action active">Set Up
							Staff Loan Role Players</a></li>



				</Ol>

			</div>


			<div class="rightNav">
			
			<h4>Staff Loan Setup Administration</h4>


				<form action=StaffLoanHodRequest method="post" class="form col-md-7">

					<div class="form-group">

						<label>Choose Action:</label> <select name="hod"
							style="border-style: outset;" required>
							<option></option>
							<option>Create New Branch Manager</option>
							<option>Edit Branch Manager</option>
							<option>Delete Branch Manager</option>
							<option>Create Head of Department</option>
							<option>Edit Head of Department</option>
							<option>Delete Head of Department</option>
							<option>Set up Payroll Master</option>
							<option>Edit Payroll Master</option>
							<option>Delete Payroll Master</option>
							<option>Set up Senior Hr Manager</option>
							<option>Edit Senior Hr Manager</option>
							<option>Delete Senior Hr Manager</option>
							<option>Set up Securities Supervisor</option>
							<option>Edit Securities Supervisor</option>
							<option>Delete Securities Supervisor</option>
							<option>Set up Loan Opening Supervisor</option>
							<option>Edit Loan Opening Supervisor</option>
							<option>Delete Loan Opening Supervisor</option>
						</select>

					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>

				</form>

			</div>
		</div>

		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>







</body>
</html>