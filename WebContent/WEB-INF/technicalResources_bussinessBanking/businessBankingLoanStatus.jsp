<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Business Banking Loans' Status</title>

<link rel="stylesheet" href="jquery/jquery-ui.css">
<script src="jquery/jquery-ui.theme.css"></script>
<script src="jquery/jquery.js"></script>
<script src="jquery/jquery-ui.js"></script>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

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

				<h4>Quick Links</h4>

				<ol class="list-group">



					<li><a
						href="${pageContext.request.contextPath}/BusinessBankingLoanPayslipUpload"
						class="list-group-item list-group-item-action active">Start a New Loan Process</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BusinessBankingLoanOfficerRequest"
						class="list-group-item list-group-item-dark ">Loans in Progress</a></li>
						<li><a
						href="${pageContext.request.contextPath}/BusinessLoanDelegateLoan"
						class="list-group-item list-group-item-dark ">Delegate Loans</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BusinessBankingLoanApprovedStatus"
						class="list-group-item list-group-item-dark ">Approved Loans</a>
						
						</li>
					<li><a href="${pageContext.request.contextPath}/BusinessBankingLoanRejectedStatus" class="list-group-item list-group-item-dark">Rejeted
							Loans</a>
							
							</li>
					

				</Ol>
			</div>
			<div class="rightNav">

				<h4>Business Banking Loan Applications Status</h4>

				<table class="table  table-striped table-hover table-bordered"
					id="myTable">
					<thead class="thead-dark">
						<tr>
							<th>Loan Reference:</th>
							<th>Inactive for:</th>
							<th>Status</th>
							<th>Last Modified Date</th>



						</tr>
					</thead>


					<c:forEach var="file" items="${loanList}">


						<tr>

							<td><c:out value="${file.loanRef}" /></td>
							<td><c:out value="${file.inactivity }"></c:out></td>
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