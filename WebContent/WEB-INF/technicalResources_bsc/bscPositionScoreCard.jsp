<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title>SwaziBank Position Score Card</title>
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
		
			<div style="background-color: #eee; width: 100%;  border: 1px dotted black; overflow: auto;">
				
				<table>
				<h2>Position Score Card</h2>
				<tr><td>Position:</td><td></td></tr>
				<tr><td>Sub Department:</td><td></td></tr>
				<tr><td>Department</td><td></td></tr>
				
				</table>
				
				<table border="1" cellpadding="5">
					
					
					
					<thead>
						<tr>
						<th style="width: 5%">Perspective</th>
						<th style="width: 15%">Objective</th>
						<th style="width: 5%">Period</th>
						<th style="width: 20%">Measure</th>
						<th style="width: 5%">Frequency</th>
						<th style="width: 40%">Description</th>
							
						</tr>
					</thead>
					<c:forEach var="file" items="${positionScoreCardList}">
						<tr>
							<td><c:out value="${file.perspective}" /></td>
							<td><c:out value="${file.objective}" /></td>
							<td><c:out value="${file.period}" /></td>
							<td><c:out value="${file.measure}" /></td>
							<td><c:out value="${file.frequency}" /></td>
							<td><c:out value="${file.description}" /></td>			
						</tr>
						
					</c:forEach>
				</table>
			</div>
		</div>

		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	
</body>
</html>