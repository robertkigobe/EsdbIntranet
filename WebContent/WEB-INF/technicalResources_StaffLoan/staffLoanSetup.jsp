<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Staff Loans' Admin Status</title>

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.js"></script>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body >
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
						href="${pageContext.request.contextPath}/StaffLoanEmployeePasswordRequest" class="list-group-item list-group-item-action active">Staff Loan Password Request</a></li>
					
					<li><a href="${pageContext.request.contextPath}/StaffLoanSetup" class="list-group-item list-group-item-dark">StaffLoan Setup</a></li>

					
					<li><a href="#" class="list-group-item list-group-item-dark">Reset a Staff Loan</a></li>
						
						
						
						<li><a
						href="#" class="list-group-item list-group-item-dark">Delegate a Staff Loan</a></li>
						

					<li><a href="${pageContext.request.contextPath}/StaffLoanHrAnalysisRequest" class="list-group-item list-group-item-dark">Analyze Staff Loan</a></li>

					 <li><a
						href="#" class="list-group-item list-group-item-dark">Cancel a Staff Loan</a></li>



				</Ol>
			</div>
			<div class="rightNav">
				<form method="post" action="StaffLoanSetup" class="form col-md-12">

					<div class="page-header">

						<h2>Staff Loan Applications Setup</h2>

					</div>



					<div class="form-row">


						<div class="form-group col-md-2">
							<label for="funeralCover">Funeral Cover</label> <input
								type="number" class="form-control" name="funeralCover"
								id="funeralCover" value="${funeralCover}" required step="0.01" class="two-decimals" >
						</div>

						<div class="form-group col-md-2">
							<label for="establishmentFee">Establishment Fee</label> <input
								type="number" class="form-control" name="establishmentFee"
								id="establishmentFee" value="${establishmentFee}" required step="0.01" class="two-decimals" >
						</div>

						<div class="form-group col-md-2">
							<label for="interestRate">Interest Rate</label> <input type="number"
								class="form-control" name="interestRate" id="interestRate"
								value="${interestRate}" required step="0.01" class="two-decimals" >
						</div>

					</div>
					<div class="form-row">

						<div class="form-group col-md-4">
							<label for="emailHost">email Host Ip Adress</label> <input type="text"
								class="form-control" name="emailHost" id="emailHost"
								value="${emailHost}" required>
						</div>
					</div>
					<div class="form-row">

						<div class="form-group col-md-4">
							<label for="hrPayrollMaster">Hr Payroll Master</label> <input
								type="text" class="form-control" name="hrPayrollMaster"
								id="${hrPayrollMaster}" value="${hrPayrollMaster}" required>
						</div>

						<div class="form-group col-md-4">
							<label for="hrPayrollMasterEmail">Hr Payroll Master Email</label> <input
								type="email" class="form-control" name="hrPayrollMasterEmail"
								id="${hrPayrollMasterEmail}" value="${hrPayrollMasterEmail}"	required>
						</div>


					</div>
					<div class="form-row">

						<div class="form-group col-md-4">
							<label for="seniorHrManager">Senior Hr Manager</label> <input
								type="text" class="form-control" name="seniorHrManager"
								id="seniorHrManager" value="${seniorHrManager}">
						</div>

						<div class="form-group col-md-4">
							<label for="seniorHrManagerEmail">Senior Hr Manager Email</label> <input
								type="email" class="form-control" name="seniorHrManagerEmail"
								id="seniorHrManagerEmail" value="${seniorHrManagerEmail}">
						</div>

					</div>

					<div class="form-row">

						<div class="form-group col-md-4">
							<label for="securitiesSupervisor">Securities Supervisor</label> <input
								type="text" class="form-control" name="securitiesSupervisor"
								id="securitiesSupervisor" value="${securitiesSupervisor}">
						</div>

						<div class="form-group col-md-4">
							<label for="securitiesSupervisorEmail">Securities Supervisor Email</label>
							<input type="email" class="form-control"
								name="securitiesSupervisorEmail" id="securitiesSupervisorEmail"
								value="${securitiesSupervisorEmail}">
						</div>

					</div>
					
					<div class="form-row">

						<div class="form-group col-md-4">
							<label for="loanDisbursementSupervisor">Loan Disbursement Supervisor</label> <input
								type="text" class="form-control" name="loanDisbursementSupervisor"
								id="loanDisbursementSupervisor" value="${loanDisbursementSupervisor}">
						</div>

						<div class="form-group col-md-4">
							<label for="loanDisbursementSupervisorEmail">Loan Disbursement Supervisor Email</label>
							<input type="email" class="form-control"
								name="loanDisbursementSupervisorEmail" id="loanDisbursementSupervisorEmail"
								value="${loanDisbursementSupervisorEmail}">
						</div>

					</div>

					<div class="form-group col-md-4">

						<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>

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