<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Call Center Home</title>
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
					<li class="nav-item"><a
						class="list-group-item list-group-item-dark active"
						href="#">Closed Issues</a></li>
					<li><a class="list-group-item list-group-item-action "
						href="${pageContext.request.contextPath}/CallCenterHome">Home </a></li>
					<li class="nav-item"><a
						class="list-group-item list-group-item-dark"
						href="${pageContext.request.contextPath}/CallCenterNewQuery">New
							Query </a></li>
					<li class="nav-item"><a
						class="list-group-item list-group-item-dark"
						href="${pageContext.request.contextPath}/CallCenterUpdateQuery">Update
							Query</a></li>



				</ol>

			</div>
			<div class="rightNav">

				<div class="page-header">
					<h3>Call Center Management System</h3>
				</div>

				<div>
					<table id="queryTable"
						class="table  table-striped table-hover table-bordered"
						id="queryTable">
						<thead class="thead-dark">
							<tr>
								<th>Date Opened:</th>
								<th>Date Closed:</th>
								<th>Name Of Agent:</th>
								<th>Resolved by:</th>
								<th>Customer Query:</th>
								<th>Department:</th>
								<th>Resolution:</th>

							</tr>
						</thead>
						<c:forEach items="${queryList}" var="query">
							<tr>
								<td><c:out value="${query.dateOpened}" /></td>
								<td><c:out value="${query.dateClosed}" /></td>
								<td><c:out value="${query.nameOfAgent}" /></td>
								<td><c:out value="${query.nameOfStaff}" /></td>
								<td><c:out value="${query.customerQuery}" /></td>
								<td><c:out value="${query.departmentResponsible}" /></td>
								<td><c:out value="${query.resolution}" /></td>
								
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>