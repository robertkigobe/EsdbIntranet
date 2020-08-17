<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Balance Score Card - Reports</title>

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
	<div class="container">
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
			<caption>
				<h1>SwaziBank BSC Reports</h1>
			</caption>

			
			
			<table border="1" style="border-style: dotted solid double dashed;">
			<tr><h2>Search criteria</h2></tr>
			<tr><td>Period</td><td>${bscPeriod}</td></tr>
			<tr><td>Department</td><td>${department}</td></tr>
			<tr><td>Sub department</td><td>${bscEmployeeName}</td></tr>
			<tr><td>Position</td><td>${positions}</td></tr>
			<tr><td>Employee</td><td>${bscEmployeeName}</td></tr>
			
			</table>
			<h3>Performance:<input type="text" value="${averageScore}%" readonly style="border-bottom: 3px double;  text-align: center;" /></h3><h3>
			<a href="${pageContext.request.contextPath}/BscReports">Clear
								Search</a></h3>
			<br>

			<table border="1" style="border-style: dotted solid double dashed;">

				<thead>
					<tr>

						<th>Perspective</th>
						<th>Objective</th>
						<th>Period</th>
						<th>RF</th>
						<th>Measure</th>
						<th>Base</th>
						<th>Stretch</th>
						<th>Actual</th>
						<th>AR</th>
						<th>Status</th>


					</tr>
				</thead>
				<c:forEach var="file" items="${departmentReport}">
					<tr>
						<td style="width: 200px;"><c:out value="${file.perspective}" /></td>
						<td style="width: 400px;"><c:out value="${file.objective}" /></td>
						<td style="width: 100px;"><c:out value="${file.period}" /></td>
						<td style="width: 100px;"><c:out
								value="${file.reportingFrequencies}" /></td>
						<td style="width: 450px;"><c:out value="${file.measure}" /></td>
						<td style="width: 100px;"><c:out value="${file.base}" /></td>
						<td style="width: 100px;"><c:out value="${file.stretch}" /></td>
						<td style="width: 100px;"><c:out value="${file.actual}" /></td>
						<td style="width: 100px;"><c:out
								value="${file.archievementRatio}" />%</td>
						<td style="border-style: dotted; width: 100px;"><c:out
								value="${file.status}" /></td>

					</tr>
				</c:forEach>
			</table>



		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>