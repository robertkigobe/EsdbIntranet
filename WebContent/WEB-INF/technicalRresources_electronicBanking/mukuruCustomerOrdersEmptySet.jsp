<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Mukuru Multiple Recipients</title>
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
					<li><a href="${pageContext.request.contextPath}/MukuruCustomerOrders" class="list-group-item list-group-item-dark">Recipients
							with Multiple Transactions</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Dashboard</a></li>

				</ol>

			</div>
			<div class="rightNav">

				<div>
					<form method="post" action="MukuruMonthlyCustomerOrders"
						class="form-horizontal">
						<h4>Mukuru Multiple Recipient Customer Orders</h4>

						<div class="form-row">
							
							<div class="form-group col-md-2">
								<label for="yearP">Year:</label> <input type="number"
									class="form-control" name="yearP" required>
							</div>
							<div class="form-group col-md-2">
								<label for="monthP">Month:</label> <input type="number"
									class="form-control" name="monthP" required>
							</div>

						</div>

						<div class="form-row">
							<div class="form-group col-md-2">
								<button class="btn btn-success">Search</button>

							</div>
						</div>
				</div>

						

				
				
			

				<div class="scroll">
					<table class="table  table-striped table-hover table-bordered">

						<thead class="thead-dark">
							<tr>

								<th>Branch</th>
								<th>Period</th>
								<th>National Id</th>
								<th>Customer Name</th>
								<th>Count</th>
								<th>Total Ordered</th>
								<th>Total Received</th>

							</tr>
						</thead>

						<tbody>
								<tr>
									<td><h2>There is no records returned for your query</h2></td>
								</tr>
							
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