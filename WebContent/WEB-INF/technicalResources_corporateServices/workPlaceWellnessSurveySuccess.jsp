<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Success</title>
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

				<ol class="list-group">

					<li><a href="#"
						class="list-group-item list-group-item-action active"> Start Survey</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs and News</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage" class="list-group-item list-group-item-dark">SwaziBank
						Vision</a></li>
						<li><a href="${pageContext.request.contextPath}/BriefsAndNews" class="list-group-item list-group-item-dark">Briefs
						And News</a></li>

					<li><a
					href="${pageContext.request.contextPath}/SwaziBankProducts" class="list-group-item list-group-item-dark">SwaziBank
						Products </a></li>
						
						<li><a href="${pageContext.request.contextPath}/BscMain" class="list-group-item list-group-item-dark">Balance
								Score Card</a></li>


					
				</ol>



			</div>



			<div class="rightNav">
				<div class="cotainer">
					<div class="container page-header">
						<h3>Wellness Survey</h3>
						<p>You have successfully completed the survey. thank you very much. the survey results will be published in a after the 31st October s018</p>

					</div>


				</div>
			</div>

		</div>


		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>


</body>
</html>