<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Forex AML High Risk Transactions</title>
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

						<li class="list-group-item">
							<h4>Quick Links</h4>
						</li>
						<li><a href="${pageContext.request.contextPath}/ForexAMLRiskDailyReport"  class="list-group-item list-group-item-action active">Forex Transactions</a></li>
						<li><a href="#"
							class="list-group-item list-group-item-dark">High Risk Transactions</a></li>
						
						


					</ol>
				
			</div>
			<div class="rightNav">


				<div>
				
				


					<form method="post" action="ForexAMLHighRiskTotalDailyReport" class="form-horizontal">
						<div class="form-group">


							<div class="col-md-5">
								<div class="page-header">
									<h4>Forex AML High Risk Transactions</h4>

								</div>
								<input type="text" name="dateParameter" class="form-control"
									col-md-4 placeholder="search date"> <a
									href="${pageContext.request.contextPath}/ForexAMLHighRiskTotalDailyReport"
									class="form-group-item">Clear Filters</a>
							</div>

						</div>
					</form>


					<div class="scroll">
						<table class="table  table-striped table-hover table-bordered">


							<thead class="thead-dark">
							
								<tr>
								<th>Date</th>
									<th>cif</th>
									<th>Name</th>
									<th>Branch</th>
									<th>Currency</th>
									<th>Destination</th>
									<th>Transactions</th>
									<th>Amount</th>									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="file" items="${forexAMLRiskDailyList}">
									<tr>
									<td><c:out value="${file.transactionDate}" /></td>
										<td><c:out value="${file.cif}" /></td>
										<td><c:out value="${file.customerName}" /></td>
										<td><c:out value="${file.branch}" /></td>
										<td><c:out value="${file.currency}" /></td>
										<td><c:out value="${file.destination}" /></td>
										<td><c:out value="${file.transactions}" /></td>
										<td><c:out value="${file.totalAmount}" /></td>

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