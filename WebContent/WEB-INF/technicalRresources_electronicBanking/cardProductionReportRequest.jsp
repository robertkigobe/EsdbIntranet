<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Card Production Reports</title>

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

				<h4>Useful Links</h4>

				<Ol>

					<li><a href="#"
						class="list-group-item list-group-item-action active">Generate
							Reports</a></li>

				</Ol>
			</div>


			<div class="rightNav">
				<div class="container-fluid">

					<caption>
						<h4>Card production Report</h4>
					</caption>



					<form method="post" action="CardProductionReport"
						class="form col-md-6">

						<div class="form-group col-md-8">

							<select name="cardType" class="form-control">
								<option>Card Type</option>
								<option>SAVINGS</option>
								<option>CURRENT</option>
								<option>SIYAKHULA</option>
								<option>COMPANY</option>


							</select>
						</div>
						<div class="form-group col-md-8">

							<select name="sdate" class="form-control">
								<c:forEach items="${dates}" var="item">
								
									<option value="${item}">${item}</option>
								</c:forEach>
							</select>

						</div>

						<div class="form-group col-md-8">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>

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