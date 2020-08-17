<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Balance Score Card - Positions</title>

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

				<ol class="list-group">

					<li class="list-group-item">
						<h4>Balance Score Card- Home</h4>
					</li>
					<li><a href="${pageContext.request.contextPath}/Home"
						class="list-group-item list-group-item-dark ">SwaziBank Home</a></li>
					<li><a href="${pageContext.request.contextPath}/BscPositions"
						class="list-group-item list-group-item-dark active">Positions</a></li>
					<li><a href="${pageContext.request.contextPath}/BscObjectives"
						class="list-group-item list-group-item-dark">Objectives</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscSetMeasuresRequest"
						class="list-group-item list-group-item-dark">Measures</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscTargetRequest"
						class="list-group-item list-group-item-dark">Set Targets</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscScoreRequest"
						class="list-group-item list-group-item-dark">Score Positions</a></li>
					<li><a href="${pageContext.request.contextPath}/BscLogin"
						class="list-group-item list-group-item-dark">Reports</a></li>

				</ol>

			</div>


			<div class="rightNav">
				<div class="page-header">
					<h4>SwaziBank Positions</h4>

				</div>

				<div class="scroll">
					<table class="table  table-striped table-hover table-bordered">

						<thead class="thead-dark">
							<tr>
								<th>Position</th>
								<th>Department</th>
								<th>Role in SwaziBank</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="file" items="${positionList}">
								<tr>
									<td><c:out value="${file.position}" /></td>
									<td><c:out value="${file.department}" /></td>
									<td><c:out value="${file.rolePlayed}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>

			</div>
			<div class="clear"></div>
			<div>
				<jsp:include page="../utilities/_footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>