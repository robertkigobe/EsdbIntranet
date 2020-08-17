<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Common EXCO Targets</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>


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

				<h4>Balance Score Card- Corporate</h4>

				<ol>
					<li><a href="#"
						class="list-group-item list-group-item-action active"> Bsc Exco Home</a></li>
						<li><a
						href="${pageContext.request.contextPath}/BscExcoCommonTargets"
						class="list-group-item list-group-item-dark">Common Targets</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscExcoTargets"
						class="list-group-item list-group-item-dark">Corporate Targets</a></li>
					
										<li><a href="${pageContext.request.contextPath}/BscExcoScores" class="list-group-item list-group-item-dark">Corporate Scores</a></li>


					<li><a
						href="${pageContext.request.contextPath}/BscSetMeasuresRequest"
						class="list-group-item list-group-item-dark">Corporate Report</a></li>	</ol>
			</div>
			<div class="rightNav">
				<form action=BscExcoCommonTargets method="post">

					<div class="page-header">
						<h3>SwaziBank EXCO Bsc Targets</h3>
					</div>

					<table class="table  table-striped table-hover table-bordered">

						<tr>
							<td>Score Period:</td>
							<td><input type="text" name="position"
								value="${objectivePeriod}" readonly
								style="border: none; width: 100%" /></td>
						</tr>
					</table>


							<table class="table-striped table-hover table-bordered">

							<thead class="thead-dark">
								<tr>
								
								<th>Perspective</th>
								<th>Measure</th>
								<th>Period</th>
								<th>RF</th>
								<th>Base</th>
								<th>Stretch</th>
								</tr>
							</thead>
							
							<tbody>

								<c:forEach var="target" items="${targets}">
									<tr>
										
										<td><input type="text" name="perspective"
											value="${target.perspective}" readonly
											style="border: none; word-wrap: break-word; min-width: 250px; max-width: 250px;" /></td>
										<td><input type="text" name="measure"
											value="${target.measure}" readonly
											style="border: none; word-wrap: break-word; min-width: 600px; max-width: 600px;" /></td>
										<td><select name="period" required style="border: none; word-wrap: break-word; min-width: 150px; max-width: 150px;">
											<option>${target.period}</option>
											<option>Short Term</option>
											<option>Mid Term</option>
											<option>Long Term</option>
									</select></td>
										<td><select name="reportingFrequency" required style="border: none; word-wrap: break-word; min-width: 150px; max-width: 150px;">
											<option>${target.reportingFrequency}</option>
											<option>Monthly</option>
											<option>Quarterly</option>
											<option>Bi-Annual</option>
											<option>Yearly</option>
									</select></td>
										<td><input type="number" name="base"
											value="${target.base}" 
											style="border: none; word-wrap: break-word; min-width: 80px; max-width: 80px;" /></td>
										<td><input type="number" name="stretch"
											value="${target.stretch}" 
											style="border: none; word-wrap: break-word; min-width: 80px; max-width: 80px;" /></td>
										
									</tr>
								</c:forEach>

								<tr>
									<td></td>
									
									<td><input value="Submit Comon Targets" type="Submit"
										class="btn btn-primary btn-sm"></td>
								
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>

						</table>
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