<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Data CleanUp</title>

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

					<li class="list-group-item">
						<h4>Quick Links</h4>
					</li>
					<li><a href="${pageContext.request.contextPath}/Home"
						class="list-group-item list-group-item-action active">SwaziBank
							Home</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage"
						class="list-group-item list-group-item-dark">SwaziBank Vision,
							Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/History"
						class="list-group-item list-group-item-dark">SwaziBank History</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard"
						class="list-group-item list-group-item-dark">SwaziBank Notice
							Board</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs And News</a></li>
					<li><a href="${pageContext.request.contextPath}/NewsLetter"
						class="list-group-item list-group-item-dark">Publications</a></li>

				</ol>

			</div>


			<div class="rightNav">

				<div class="page-header">
					<h4>Data Cleanup - Update Entry</h4>
					<br>
				</div>

				<div class="alert alert-danger" role="alert">${error}</div>


				<form action="DataCleanUpHome" method="POST">

					<div class="form-row">


						<div class="form-group col-md-3">
							<label for="cif">cif</label> <input type="text"
								class="form-control" name="cif" id="cif" value="${cif}" required
								readonly>
						</div>

						<div class="form-group col-md-3">
							<label for="shortName">Short Name</label> <input type="text"
								class="form-control" name="shortName" id="shortName"
								value="${shortName}" required readonly>
						</div>
						<div class="form-group col-md-3">
							<label for="name1">Name 1</label> <input type="text"
								class="form-control" name="name1" id="name1" value="${name1}"
								required>
						</div>

						<div class="form-group col-md-3">
							<label for="name2">Name 2</label> <input type="text"
								class="form-control" name="name2" id="name2" value="${name2}"
								required>
						</div>



					</div>

					<div class="form-row">


						<div class="form-group col-md-3">
							<label for="street">Street</label> <input type="text"
								class="form-control" name="street" id="street" value="${street}"
								required>
						</div>

						<div class="form-group col-md-3">
							<label for="townCountry">Town Country</label> <input type="text"
								class="form-control" name="townCountry" id="townCountry"
								value="${townCountry}" required>
						</div>
						<div class="form-group col-md-3">
							<label for="nationalId">National Id</label> <input type="text"
								class="form-control" name="nationalId" id="nationalId"
								value="${nationalId}" required>
						</div>

						<div class="form-group col-md-3">
							<label for="homeNo">Home No</label> <input type="text"
								class="form-control" name="homeNo" id="homeNo" value="${homeNo}"
								>
						</div>



					</div>


					<div class="form-row">


						<div class="form-group col-md-3">
							<label for="workNo">Work No</label> <input type="text"
								class="form-control" name="workNo" id="workNo" value="${workNo}"
								>
						</div>

						<div class="form-group col-md-3">
							<label for="mobileNo">Mobile No</label> <input type="text"
								class="form-control" name="mobileNo" id="mobileNo"
								value="${mobileNo}" >
						</div>
						<div class="form-group col-md-3">
							<label for="ocucpation">Ocucpation</label> <input type="text"
								class="form-control" name="ocucpation" id="ocucpation"
								value="${ocucpation}" required>
						</div>

						<div class="form-group col-md-3">
							<label for="faxno">Fax No</label> <input type="text"
								class="form-control" name="faxno" id="faxno" value="${faxno}"
								>
						</div>



					</div>

					<div class="form-row">


						<div class="form-group col-md-3">
							<label for="email">Email</label> <input type="text"
								class="form-control" name="email" id="email" value="${email}"
								required>
						</div>

						<div class="form-group col-md-3">
							<label for="passport">Passport</label> <input type="text"
								class="form-control" name="passport" id="passport"
								value="${passport}" >
						</div>
						<div class="form-group col-md-3">
							<label for="nextOfKin">Next Of Kin</label> <input type="text"
								class="form-control" name="nextOfKin" id="nextOfKin"
								value="${nextOfKin}" required>
						</div>

						<div class="form-group col-md-3">
							<label for="nextOfKin2">Next Of Kin Telephone</label> <input type="text"
								class="form-control" name="nextOfKin2" id="nextOfKin2"
								value="${nextOfKin2}" required>
						</div>



					</div>

					<div class="form-row">
					
					<div class="form-group col-md-3">
							<label for="nextOfKin2">Next Of Kin Mobile</label> <input type="text"
								class="form-control" name="nextOfKin2" id="nextOfKin2"
								value="${nextOfKin2}" required>
						</div>


						<div class="form-group col-md-3">
							<label for="postAdress">Post Adress</label> <input type="text"
								class="form-control" name="postAdress" id="postAdress"
								value="${postAdress}" required>
						</div>
						
						<div class="form-group col-md-3">
							<label for="postAdress">Branch</label> <input type="text"
								class="form-control" name="branch" id="branch"
								value="${branchA}" readonly>
						</div>



					</div>



					<button type="submit" class="btn btn-primary btn-lg btn-block">Update
						Entry</button>



				</form>
			</div>

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
