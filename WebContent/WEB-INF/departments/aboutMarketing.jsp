<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Home</title>

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
					<li><a href="${pageContext.request.contextPath}/AboutMarketing" class="list-group-item list-group-item-dark active">Marketing Department</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">SwaziBank Departments</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark ">Business Banking</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage" class="list-group-item list-group-item-dark">SwaziBank Vision, Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/NewsLetter" class="list-group-item list-group-item-dark">Publications</a></li>
					
					


				</ol>

			</div>

			<div class="rightNav">

				<div class="col-md-10">
					<div class="page-header">
						<h4>Marketing</h4>

					</div>

				<p>The Marketing department seeks to enhance the Bank’s
					strategic direction in its pursuit to be the country’s leading
					bank.</p>

				<p>As the SwaziBank brand is now well known and established, it
					is imperative that the brand maintains its positioning as one of
					the country’s top brands in people’s minds.</p>

				<p>The department is made up of Marketing, Public Relations,
					Premier Banking, Call Centre and Sales.</p>

				<p>The Marketing Department is responsible for, not limited to,
					the following;</p>

				<ol>
					<li>Product development and selling.</li>
					<li>Marketing of products and services.</li>
					<li>Corporate communications.</li>
					<li>Customer relations.</li>
					<li>Stakeholder relations.</li>
					<li>Media Relations.</li>
					<li>Premier Banking.</li>
					<li>Advertising.</li>
					<li>Publications.</li>
					<li>Corporate Social Investment.</li>
					<li>Events Management.</li>
					<li>Protocol.</li>
					<li>Exhibitions.</li>
					<li>Public Relations.</li>
					<li>Branding.</li>
					<li>Corporate image promotion and protection.</li>
					<li>Promotional material.
				</ol>



			</div>


		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>