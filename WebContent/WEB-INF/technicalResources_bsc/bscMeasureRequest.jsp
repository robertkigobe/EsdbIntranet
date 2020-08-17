<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Measure Request</title>
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
<body>
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

				<h4>Balance Score Card- Home</h4>

				<Ol>
					<li><a href="${pageContext.request.contextPath}/BscPositions">Positions</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscPerspectives">Perspectives</a></li>
					<li><a href="${pageContext.request.contextPath}/BscObjectives">Objectives</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscSetMeasuresRequest">Measures</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscTargetRequest">Set
							Targets</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscScoreRequest">Score
							Positions</a></li>
					<li><a href="${pageContext.request.contextPath}/BscLogin">Reports</a></li>

				</Ol>
			</div>
			<div class="rightNav">
				<form action=BscMeasures method="post" class="form ">

					<div class=" container page-header">
						<h3>Explanation of Position Measures</h3>

					</div>
					<div>
						<table class="table  table-striped table-hover table-bordered">
							<tbody>

								<tr>
									
									<td><select name="position">
											<c:forEach items="${measureList}" var="item">
												<option value="${item.position}">${item.position}</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>

									<td><input value="View Position Measures" type="Submit"
										class="btn btn-primary"></td>
								</tr>
							</tbody>
						</table>
					</div>
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