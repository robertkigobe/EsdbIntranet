<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delegate Staff Loan</title>
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
					<li><a href="${pageContext.request.contextPath}/Home"
						class="list-group-item list-group-item-action active">SwaziBank
							Home</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage"
						class="list-group-item list-group-item-dark">SwaziBank Vision,
							Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/History"
						class="list-group-item list-group-item-dark">SwaziBank History</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard"
						class="list-group-item list-group-item-dark">SwaziBank Notice
							Board</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs And News</a></li>
					<li><a href="${pageContext.request.contextPath}/NewsLetter"
						class="list-group-item list-group-item-dark">Publications</a></li>

				</ol>

			</div>


			<div class="rightNav">


				<form method="post" action="StaffLoanDelegateLoanUpdate" class="form col-md-12">

					<div class="page-header">

						<h2>Delegate Staff Loan Application</h2>

					</div>



					<div class="form-row">

						<div class="form-group col-md-2">
							<label for="employeeLoanRef">Loan Reference</label> <input
								type="text" class="form-control" name="employeeLoanRef"
								id="employeeLoanRef" value="${employeeLoanRef}" readonly />
						</div>
						<div class="form-group col-md-2">
							<label for="employeeCode">Employee Code</label> <input
								type="text" class="form-control" name="employeeCode"
								id="employeeCode" value="${employeeCode}" readonly />
						</div>

						<div class="form-group col-md-2">
							<label for="establishmentFee">Employee Email</label> <input
								type="email" class="form-control" name="employeeEmail"
								id="employeeEmail" value="${employeeEmail}" readonly />
						</div>

						<div class="form-group col-md-2">
							<label for="loanStatus">Loan Status</label> <input type="text"
								class="form-control" name="loanStatus" id="loanStatus"
								value="${loanStatus}" readonly />
						</div>

					</div>
					<div class="form-row">

						<div class="form-group col-md-2">
							<label for="recipientRole">New recipient Role</label> <select
								name="recipientRole" class="form-control" required>

								<option></option>
								<option>Supervisor</option>
								<option>Head of Department</option>
								<option>Payroll Master</option>
								<option>Senior HR</option>
								<option>Employee- Make Securities</option>
								<option>Securities Supervisor</option>


							</select>
						</div>
						
						<div class="form-group col-md-4">
							<label for="delegateComment">Comment</label> <input
								type="text" class="form-control" name="delegateComment"
								id="delegateComment" value="${delegateComment}" required />
						</div>
						<div class="form-group col-md-2">
							<label for="recipientEmail">Recipient Email</label> <input
								type="email" class="form-control" name="recipientEmail"
								id="recipientEmail" value="${recipientEmail}" required />
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-2">

							<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
						</div>
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