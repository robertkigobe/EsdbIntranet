<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Balance Score Card Records</title>

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

				<h4>Balance Score Card- Administration</h4>

				<Ol class="list-group">
				
				<li><a href="#" class="list-group-item list-group-item-action active">Submission Report</a></li>
					<li><a href="${pageContext.request.contextPath}/BscDelete" class="list-group-item list-group-item-dark">Delete Score Cards</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Update Score Cards</a></li>
					<li><a 	href="${pageContext.request.contextPath}/BscTargetRequest" class="list-group-item list-group-item-dark">Set Targets</a></li>
					<li><a 	href="${pageContext.request.contextPath}/BscScoreRequest" class="list-group-item list-group-item-dark">Score Positions</a></li>
					<li><a 	href="${pageContext.request.contextPath}/BscScoreRequest" class="list-group-item list-group-item-dark">Bsc Report</a></li>
					

				</Ol>
			</div>


			<div class="rightNav">
				<div
					style="background-color: #eee; border: 1px dotted black; overflow: auto;">


					<form method="post" action="BscSubmissions" class="form-horizontal">
						<div class="form-group">


							<div class="col-md-5">
							
								<div class="page-header">
									<h4>SwaziBank 2017-2018 Annual Submissions Report</h4>
								</div>
							
								<input type="text" name="bscEmployeeName" class="form-control;" placeholder="Enter Name"> 
								<a href="${pageContext.request.contextPath}/BscUpdateDelete" class="form-group-item">Clear Filters</a>
							
							</div>

						</div>
					</form>

					<form method=POST action = BscDelete>
						<table class="table  table-striped table-hover table-bordered">

							<thead class="thead-dark">
								<tr>
						
									<th>Sub Department</th>
									<th>Employee Name</th>
									<th>Final Score</th>
									<th>Status</th>

								</tr>
							</thead>
							<c:forEach var="file" items="${annualSubmissionsReport}">

								<tr>
									
									<td style="width: 300px;"><c:out
											value="${file.subDepartment}" /></td>
									<td style="width: 250px;"><c:out
											value="${file.bscEmployeeName}" /></td>
									
									<td style="width: 300px;"><c:out
											value="${file.averageScore}" />%</td>
											<td style="width: 300px;"><c:out
											value="${file.status}" /></td>

								</tr>
							</c:forEach>
						</table>
					</form>
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