<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
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
<title>IT Policies and Procedures</title>
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
						<h4>Policies and Laid Down Procedures</h4>
					</li>
					<li><a href="${pageContext.request.contextPath}/Home"
						class="list-group-item list-group-item-dark">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/FINANCEPolicies"
						class="list-group-item list-group-item-dark">Finance Policies</a></li>
					<li><a href="${pageContext.request.contextPath}/HRPolicies"
						class="list-group-item list-group-item-dark">HR Policies</a></li>
					<li><a href="${pageContext.request.contextPath}/ITPolicies"
						class="list-group-item list-group-item-action active">IT Policies</a></li>
					<li><a href="${pageContext.request.contextPath}/RiskPolicies"
						class="list-group-item list-group-item-dark">Risk Policies</a></li>

				</ol>

			</div>

			<div class="rightNav">
				<div>
					<div class="page-header">
						<h4>IT Department Policies</h4>

					</div>
					<div>
						<table class="table  table-striped table-hover table-bordered">


							<thead class="thead-dark">
								<tr>
									<th>Policy Name</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="file" items="${fileList}">
									<tr>

										<td><form method="post" action="ViewITPolicies"><span class="glyphicon glyphicon-download"></span>
												<input type="submit" name="documentUrl" readonly
													style="clear: both; background-color: transparent; border: 0px solid; height: 20px;"
													value="${file}" />
											</form></td>

									</tr>
								</c:forEach>
						</table>
					</div>
				</div>
				<div class="clear"></div>
				<div>
					<jsp:include page="../utilities/_footer.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
</html>