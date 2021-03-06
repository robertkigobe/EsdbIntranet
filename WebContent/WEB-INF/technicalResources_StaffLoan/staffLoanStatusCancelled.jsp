<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Staff Loans' Status</title>

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


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
<body onload="startTime()">
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

				<h4>Quick Links</h4>

				<ol class="list-group">



					<li><a
						href="${pageContext.request.contextPath}/StaffLoanEmployeeRequest"
						class="list-group-item list-group-item-action active">Apply
							for a Loan Today</a></li>
					<li><a
						href="${pageContext.request.contextPath}/StaffLoanStatusDisbursed"
						class="list-group-item list-group-item-dark ">Disbursed Loans</a></li>
					<li><a
						href="${pageContext.request.contextPath}/StaffLoanStatus"
						class="list-group-item list-group-item-dark">Staff Loans</a></li>
					<li><a
						href="${pageContext.request.contextPath}/StaffLoanAdministrationLogin"
						class="list-group-item list-group-item-dark">Administration</a></li>



				</Ol>
			</div>
			<div class="rightNav">

				<h4>Staff Loan Applications Status</h4>

				<table class="table  table-striped table-hover table-bordered"
					id="myTable">
					<thead class="thead-dark">
						<tr>
							<th>Loan Reference:</th>

							<th>Status</th>
							<th>Cancelled Date</th>



						</tr>
					</thead>


					<c:forEach var="file" items="${loanList}">


						<tr>

							<td><c:out value="${file.loanRef}" /></td>
							<td><c:out value="${file.currentStatus}" /></td>
							<td><c:out value="${file.lastModifiedDate}" /></td>


						</tr>
					</c:forEach>
				</table>

			</div>
		</div>


	</div>

	<div class="clear"></div>
	<div>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>
</body>
</html>