<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Mukuru Orders</title>
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
					<li><a href="#"
						class="list-group-item list-group-item-action active">Import
							Worksheet</a></li>
					<li><a href="${pageContext.request.contextPath}/MukuruMonthlyCustomerOrders" class="list-group-item list-group-item-dark">Recipients
							with Multiple Transactions</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Dashboard</a></li>

				</ol>

			</div>
			<div class="rightNav">


				<div>




					<form method="post" action="MukuruCustomerOrders"
						class="form-horizontal">
						<h4>Mukuru Customer Orders</h4>

						<div class="form-row">
							<div class="form-group col-md-2">
								<label for="Recipient_ID">National Id</label> <input type="text"
									class="form-control" name="Recipient_ID" required>
							</div>
							<div class="form-group col-md-2">
								<label for="fromDate">From:</label> <input type="date"
									class="form-control" name="fromDate" required>
							</div>
							<div class="form-group col-md-2">
								<label for="toDate">To:</label> <input type="date"
									class="form-control" name="toDate" required>
							</div>


						</div>

						<div class="form-row">
							<div class="form-group col-md-2">
								<button class="btn btn-success">Search</button>
								
							</div>
						</div>
				</div>
				</form>
				<div class="form-group col-md-2">
					<a style="color: red; " href="${pageContext.request.contextPath}/MukuruCustomerOrders">All Orders</a>
				</div>
				
				<form method="post" action="MukuruOrdersToExcel"
						class="form-horizontal">
				
				<div class="form-row">
							<div class="form-group col-md-2">
								<button class="btn btn-warning">Export to Excel</button>
								
							</div>
						</div>
				
				</form>
				


				<div class="scroll">
					<table class="table  table-striped table-hover table-bordered">


						<thead class="thead-dark">
							<tr>

								<th>Branch</th>

								<th>National Id</th>
								<th>Customer Name</th>
								<th>Tran Date</th>
								<th>Amount Ordered</th>
								<th>Amount Issued</th>

							</tr>
						</thead>




						<tbody>

							<c:forEach var="file" items="${mukuruCustomerOrderlist}">
								<tr>
									<td><c:out value="${file.branch}" /></td>

									<td><c:out value="${file.recipient_ID}" /></td>
									<td><c:out value="${file.recipient}" /></td>
									<td><c:out value="${file.order_Confirmed_Date}" /></td>

									<td><c:out value="${file.ordered_SZL}" /></td>
									<td><c:out value="${file.issued_SZL}" /></td>

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