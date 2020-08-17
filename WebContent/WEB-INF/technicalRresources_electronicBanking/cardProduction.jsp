<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Card Production New Entry</title>
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

					<li class="list-group-item">
						<h4>Quick Links</h4>
					</li>
					<li><a href="#"
						class="list-group-item list-group-item-action active">New Card</a></li>
					



				</ol>
			</div>



			<div class="rightNav">
				<div class="cotainer">
					<div class="container page-header">
						<h3>ATM Card Application</h3>

					</div>

					<div class="container">
						<p class="bg-danger">${error}</p>
					</div>

					<form method="post" action="CardProduction">
						<div class="form-row">


							<div class="form-group col-md-2">
								<label for="inputCity">Title</label> 
								<select name="title"
									class="form-control" required>

									<option>${title}</option>
									<option>SIR</option>
									<option>MRS</option>
									<option>DR</option>
									<option>DR MRS</option>
									<option>MISS</option>
									<option>MR</option>
									<option>PROF</option>
									<option>LADY</option>
									<option>MINOR</option>
									<option>HON</option>
									<option>BIZ</option>


								</select>
							</div>
							<div class="form-group col-md-5">
								<label for="inputCity">First Name</label> <input type="text"
									class="form-control" name="fname" id="fname" value="${fname}"
									required >
							</div>
							<div class="form-group col-md-5">
								<label for="inputCity">Last Name</label> <input type="text"
									class="form-control" name="lname" value="${lname}" required>
							</div>

						</div>
						<div class="form-row">

							<div class="form-group col-md-2">
								<label for="inputCity">Account Type</label> <select
									name="accountType" class="form-control" required>
									<option>${accountType}</option>
									<option>SAVINGS</option>
									<option>CURRENT</option>
									<option>SIYAKHULA</option>
									<option>COMPANY</option>
								</select>
							</div>
							<div class="form-group col-md-5">
								<label for="inputCity">CIF</label> <input type="number"
									class="form-control" name="cif" required value="${cif}">
							</div>
							<div class="form-group col-md-5">
								<label for="inputCity">Account Number</label> <input
									type="number" class="form-control" name="accountNumber" pattern=".{11,11}"
									 required value="${accountNumber}">
							</div>
						</div>
						<div class="form-row">


							<div class="form-group col-md-2">
								<label for="inputCity">National ID</label> <input type="text"
									class="form-control" name="nationId" value="${nationId}"
									required>
							</div>

							<div class="form-group col-md-5">
								<label for="inputCity">Physical Address</label> <input
									type="text" class="form-control" name="physicalAddress"
									value="${physicalAddress}" required>
							</div>
							<div class="form-group col-md-5">
								<label for="inputCity">Postal Address</label> <input type="text"
									class="form-control" name="postalAdress"
									value="${postalAdress}" required>
							</div>

						</div>


						<div class="form-row">

							<div class="form-group col-md-2">
								<label for="inputCity">Mobile Number</label> <input
									type="number" class="form-control" name="mobileNumber"
									value="${mobileNumber}" required placeholder="7...">
							</div>
							<div class="form-group col-md-2">
								<label for="inputCity">Telephone Number</label> <input
									type="number" class="form-control" name="telephoneNumber"
									value="${telephoneNumber}" placeholder="2...">
							</div>

							<div class="form-group col-md-4">
								<label for="inputCity">Email Adress</label> <input type="text"
									class="form-control" name="email" value="${email}">
							</div>

							<div class="form-group col-md-2">
								<label for="inputCity">meta1</label> <input type="text"
									class="form-control" name="branch" value="${branch}" readonly>
							</div>
							<div class="form-group col-md-2">
								<label for="inputCity">Meta2</label> <input type="password"
									class=".d-none" name="password" value="${password}" readonly>
							</div>
						</div>

						<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
					</form>

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