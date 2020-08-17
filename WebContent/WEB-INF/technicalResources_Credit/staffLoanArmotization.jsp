<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>ESDB Loan Amortization</title>

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
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

				<h4>Quick Links</h4>

				<ol class="list-group">

					<li><a href="${pageContext.request.contextPath}/History"
						class="list-group-item list-group-item-dark active">Eswatini
							Bank History</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs and News</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage"
						class="list-group-item list-group-item-dark">Vision, Mission
							And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard"
						class="list-group-item list-group-item-dark">Eswatini Notice
							Board</a></li>

				</ol>
			</div>
			<div class="rightNav">

				<div>
					<h3>Staff Loan Amortization</h3>
					<div>
						<form action="StaffLoanArmotization" method="POST">

							<div class="container">
								<p class="bg-danger">${error}</p>
							</div>

							<div class="form-row">

								<div class="form-group col-md-3">
									<label for="loanAmount">Loan Amount</label> <input
										type="number" class="form-control" name="loanAmount"
										id="loanAmount" value="${loanAmount}" required step="any">
								</div>
								<div class="form-group col-md-3">
									<label for="rate">Yearly Interest Rate</label> <input
										type="number" class="form-control" name="rate" id="rate"
										value="${rate}" required step="any">
								</div>
								<div class="form-group col-md-3">
									<label for="finalValue">Final Value</label> <input
										type="number" class="form-control" name="finalValue"
										id="finalValue" value="${finalValue}" required step="any">
								</div>

								<div class="form-group col-md-3">
									<label for="optExtPmt">Optional Extra Payments</label> <input
										type="number" class="form-control" name="optExtPmt"
										id="finalValue" value="${optExtPmt}" required step="any">
								</div>

							</div>


							<div class="form-row">

								<div class="form-group col-md-3">
									<label for="startDate">Start Date</label> <input type="date"
										class="form-control" name="startDate" id="startDate"
										value="${startDate}" required>
								</div>

								<div class="form-group col-md-3">
									<label for="endDate">End Date</label> <input type="date"
										class="form-control" name="endDate" id="endDate"
										value="${endDate}" required>
								</div>


							</div>

							<div class="form-row">

								<div class="form-group col-md-3">
									<button type="submit" class="btn btn-primary btn-lg btn-block">Armotize</button>
								</div>
							</div>

						</form>
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
