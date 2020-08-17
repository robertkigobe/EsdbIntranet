<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Set Targets</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


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

				<h4>Balance Score Card- Set Targets</h4>

				<ol>
					<li><a href="${pageContext.request.contextPath}/BscPositions" class="list-group-item list-group-item-dark">Positions</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscPerspectives" class="list-group-item list-group-item-dark">Perspectives</a></li>
					<li><a href="${pageContext.request.contextPath}/BscObjectives" class="list-group-item list-group-item-dark">Objectives</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscSetMeasuresRequest" class="list-group-item list-group-item-dark">Measures</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscTargetRequest" class="list-group-item list-group-item-action active">Set
							Targets</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscScoreRequest" class="list-group-item list-group-item-dark">Score
							Positions</a></li>
					<li><a href="${pageContext.request.contextPath}/BscLogin" class="list-group-item list-group-item-dark">Reports</a></li>

				</ol>
			</div>
			<div class="rightNav">
				<form action=BscPostTargets method="post">

					<div class="page-header">
						<h3>SwaziBank BSC Targets</h3>
					</div>

					<table class="table  table-striped table-hover table-bordered">

						<tr>
							<td>Position:</td>
							<td><input type="text" name="position" value="${position}"
								readonly style="border: none; width: 100%" /></td>
						</tr>

						<tr>
							<td>Department:</td>
							<td><input type="text" name="department"
								value="${department}" readonly style="border: none; width: 100%" /></td>
						</tr>

						<tr>
							<td>Score Period:</td>

							<td><input type="text" name="position"
								value="${objectivePeriod}" readonly
								style="border: none; width: 100%" /></td>
						</tr>


					</table>


					<table class="table  table-striped table-hover table-bordered">

						<thead class="thread-dark">
							<tr>
								<th>Perspective</th>
								<th>Objective</th>
								<th>Period</th>
								<th>RF</th>
								<th>Measure</th>
								<th>Base</th>
								<th>Stretch</th>

							</tr>
							
							</thead>
							<tbody>

							<c:forEach var="target" items="${targets}">
								<tr>
									<td><input type="text" name="perspective"
										value="${target.perspective}" readonly
										style="border: none; word-wrap: break-word; min-width: 200px; max-width: 200px;" /></td>
									<td><input type="text" name="objective"
										value="${target.objective}" readonly
										style="border: none; width: 250px;" required /></td>
									<td><select name="period" required style="border: none; word-wrap: break-word; min-width: 100px; max-width: 100px;" >
											<option>${target.period}</option>
											<option>Short Term</option>
											<option>Mid Term</option>
											<option>Long Term</option>
									</select></td>
									<td><select name="reportingFrequency" required style="border: none; word-wrap: break-word; min-width: 100px; max-width: 100px;">
											<option>${target.reportingFrequency}</option>
											<option>Monthly</option>
											<option>Quarterly</option>
											<option>Bi-Annual</option>
											<option>Yearly</option>
									</select></td>
									<td><input type="text" name="measure"
										value="${target.measure}" readonly
										style="border: none; word-wrap: break-word; min-width: 600px; max-width: 600px;" required /></td>
									<td><input type="text" name="base" value="${target.base}"
										style="border: none; word-wrap: break-word; min-width: 80px; max-width: 80px" required /></td>
									<td><input type="text" name="stretch"
										value="${target.stretch}" step="0.01" class="two-decimals"
											style="border: none; word-wrap: break-word; min-width: 80px; max-width: 80px"
										required /></td>
								</tr>
							</c:forEach>

							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td><input value="Post Targets" type="Submit" class="btn btn-primary"></td>
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