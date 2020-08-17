<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer Queries</title>
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
						href="#">Update
							Query</a></li>
					<li><a class="list-group-item list-group-item-action "
						href="${pageContext.request.contextPath}/CallCenterHome">Home </a></li>
					<li class="nav-item"><a
						class="list-group-item list-group-item-dark"
						href="${pageContext.request.contextPath}/CallCenterNewQuery">New
							Query </a></li>
							<li class="nav-item"><a
						class="list-group-item list-group-item-dark"
						href="${pageContext.request.contextPath}/CallCenterClosed">Closed Issues</a></li>



				</ol>

			</div>
			<div class="rightNav">
				<div>
				
				<div class="col-md-12">
								<div class="page-header">
						<h4>Choose Customer and Query to update</h4>

								</div>
					
					<form action=CallCenterUpdateQuery method="post">



						<div id="row" class="row">

							<div class="col col-md-2">
								<label for="nameOfAgent">Customer Name: </label> <select
									name="nameOfCustomer" class="form-control ">
									<c:forEach var="customerList" items="${customerList}">

										<option c:out value="${customerList}">${customerList}</option>

									</c:forEach>

								</select>
							</div>



							<div class="col col-md-10">
								<label for="customerQuery">Customer Query: </label> <select
									name="customerQuery" class="form-control ">
									<c:forEach var="queryList" items="${queryList}">

										<option c:out value="${queryList}">${queryList}</option>

									</c:forEach>

								</select>
							</div>
						</div>


						<button type="submit" class="btn btn-primary btn-lg btn-block"
							style="margin-top: 10px;">Submit</button>
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