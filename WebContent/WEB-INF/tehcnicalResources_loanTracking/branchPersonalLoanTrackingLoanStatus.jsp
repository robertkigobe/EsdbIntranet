<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Branch Personal Loans' Status</title>

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.js"></script>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>

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
						href="${pageContext.request.contextPath}/BranchLoanITCUpload"
						class="list-group-item list-group-item-action active">Start a
							new loan application</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BranchLoanTrackingDisbursedStatus"
						class="list-group-item list-group-item-dark">Loans Disbursed</a></li>
					<li><a
						href="${pageContext.request.contextPath}/StaffLoanAdministrationLogin"
						class="list-group-item list-group-item-dark">Administration</a></li>



				</Ol>
			</div>
			<div class="rightNav">

				<h4>Branch Loan Applications</h4>

				<table class="table  table-striped table-hover table-bordered"
					id="myTable">
					<thead class="thead-dark">
						<tr>
							<th>Loan Reference:</th>
							<th>Customer name:</th>
							<th>Amount:</th>
							<th>Inactive since:</th>
							<th>Status</th>
						</tr>
					</thead>


					<c:forEach var="file" items="${branchPersonalLoanList}">

						<tr>
							<td><c:out value="${file.loanReference}"></c:out></td>
							<td><c:out value="${file.applicantName}" /></td>
							<td><c:out value="${file.loanAmount}" /></td>
							<td><c:out value="${file.inactivity}" /></td>
							<td><c:out value="${file.loanStatus}" /></td>
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