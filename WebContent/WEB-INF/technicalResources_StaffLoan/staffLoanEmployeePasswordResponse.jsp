<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Staff loan Password</title>
<style>
div.scroll {
	position: relative;
	width: 100%;
	height: 500px;
	overflow: scroll;
}
</style>


<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/HomePage.css" rel="stylesheet" type="text/css" />

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-3.1.1.min.js"></script>

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

					<li><a
						href="${pageContext.request.contextPath}/StaffLoanEmployeePasswordRequest"
						class="list-group-item list-group-item-action active">Staff
							Loan Password Request</a></li>

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

					<li><a
						href="${pageContext.request.contextPath}/StaffLoanAdministrationRolePlayers"
						class="list-group-item list-group-item-action active">Set Up
							Staff Loan Role Players</a></li>



				</Ol>

			</div>
			<div class="rightNav">


				<div>
					<div class="form-group">

						<div class="page-header">
							<h4>Staff Loan Password Details</h4>

						</div>




						<div class="scroll">
							<table class="table  table-striped table-hover table-bordered">


								<thead class="thead-dark">
									<tr>
										<th>Department</th>
										<th>Employee Code</th>
										<th>Name</th>
										<th>First Name</th>
										<th>Password</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="file" items="${StaffLoanEmployeePasswordList}">
										<tr>
											<td><c:out value="${file.department}" /></td>
											<td><c:out value="${file.employeeCode}" /></td>
											<td><c:out value="${file.surName}" /></td>
											<td><c:out value="${file.firstName}" /></td>
											<td><c:out value="${file.password}" /></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
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