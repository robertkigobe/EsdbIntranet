<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Skills Audit Report Login</title>

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
					<li><a href="${pageContext.request.contextPath}/SkillsHome"
						class="list-group-item list-group-item-dark">SwaziBank
							Skills Audit</a></li>
							<li><a href="${pageContext.request.contextPath}/SkillsAuditNewSkillsAudit"
						class="list-group-item list-group-item-dark ">New Skills Audit</a></li>
							<li><a href="${pageContext.request.contextPath}/SkillsAuditQualityControlRequest"
						class="list-group-item list-group-item-dark ">Quality Control</a></li>
						<li><a href="#"
						class="list-group-item list-group-item-action active ">Reports</a></li>
				</ol>
			</div>


			<div class="rightNav">

				<div class="page-header">
					<h4>Skills Audit Report Request</h4>
					<br>
				</div>

				<form method="post" action="SkillsAuditReportRequest" class="form ">

					<div class="form-group">
					
					<select name="department">
							<c:forEach items="${departments}" var="departments">
								<option value="${departments}">${departments}</option>
							</c:forEach>
						</select>
						
					</div>
					
					<div class="form-group">
						<label>Password</label> <input type="password" name="password"
							class="form-control">
					</div>
					
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>

	
	</div>


	</div>
	<div class="clear"></div>
	<div>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>

</body>
</html>