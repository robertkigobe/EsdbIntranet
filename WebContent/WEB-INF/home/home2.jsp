<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>ESwatini Bank Home</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">


</head>
<body>


	<div class="container-fluid">

<div class="jumbotron">

		<div>
			<nav class="navbar navbar-expand-sm navbar-inverse bg-light"> <img
				alt="" src="pictures/EswatiniBankblue.jpg" style="width: 10%;"
				class="border-top border-info">


			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">

					<!-- Drop down -->
					<li class="nav-item dropdown active"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Home </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Vision and Mission</a> <a
								class="dropdown-item" href="#">History</a> <a
								class="dropdown-item" href="#">Notice board</a> <a
								class="dropdown-item" href="#">New Staff</a> <a
								class="dropdown-item" href="#">Bereavement</a> <a
								class="dropdown-item" href="#">Vacancies</a> <a
								class="dropdown-item" href="#">Intranet Feedback</a>
						</div></li>
					<!-- Drop down -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Departments </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">

							<a class="dropdown-item" href="#">Business Banking</a> <a
								class="dropdown-item" href="#">Credit</a> <a
								class="dropdown-item" href="#">Corporate Business</a> <a
								class="dropdown-item" href="#">Corporate Services</a> <a
								class="dropdown-item" href="#">Finance</a> <a
								class="dropdown-item" href="#">Information Technology</a> <a
								class="dropdown-item" href="#">Internal Audit</a> <a
								class="dropdown-item" href="#">Legal</a> <a
								class="dropdown-item" href="#">Marketing</a> <a
								class="dropdown-item" href="#">MD's Office</a> <a
								class="dropdown-item" href="#">Risk and Compliance</a> <a
								class="dropdown-item" href="#">Operations</a> <a
								class="dropdown-item" href="#">Risk & Compliance</a>
						</div></li>
					<!-- Drop down -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Staff Srvices </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Staff Directory</a> <a
								class="dropdown-item" href="#">Product Offerings</a> <a
								class="dropdown-item" href="#">Training Manuals</a> <a
								class="dropdown-item" href="#">Policies and Procedures</a> <a
								class="dropdown-item" href="#">Forms and Templates</a>

						</div></li>
					<!-- Drop down -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Department Tools </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">

							<a class="dropdown-item" href="#">Business Banking</a> <a
								class="dropdown-item" href="#">Credit</a> <a
								class="dropdown-item" href="#">Corporate Business</a> <a
								class="dropdown-item" href="#">Corporate Services</a> <a
								class="dropdown-item" href="#">Finance</a> <a
								class="dropdown-item" href="#">Information Technology</a> <a
								class="dropdown-item" href="#">Internal Audit</a> <a
								class="dropdown-item" href="#">Legal</a> <a
								class="dropdown-item" href="#">Marketing</a> <a
								class="dropdown-item" href="#">MD's Office</a> <a
								class="dropdown-item" href="#">Risk and Compliance</a> <a
								class="dropdown-item" href="#">Operations</a> <a
								class="dropdown-item" href="#">Risk & Compliance</a>
						</div></li>
					<!-- Drop down -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Internet Banking </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a> <a
								class="dropdown-item" href="#">Something else here</a>
						</div></li>
				</ul>
			</div>
			</nav>
		</div>
		<h1 class="headings">The Bank with a Heart</h1>
	</div>

		<div class="form-row">
			<div class="form-group col-md-2">
				<div class="birthdays">
					<table class="table  table-striped table-hover table-bordered">
						<thead class="thead">
							<tr>
								<th>
									<H3>BIRTHDAYS</H3>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="file" items="${directoryList}">
								<tr>
									<td><marquee height="30" width="100%" behavior="alternate"
											style="border: 0.5px groove; marquee-speed: slow;">
											<c:out value="${file.firstname}   " />
											<c:out value="${file.surname}" />
										</marquee></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="birthdays">
					<table class="table  table-striped table-hover table-bordered">
						<thead class="thead">
							<tr>
								<th>
									<H3>Latest Articles</H3>
								</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="file" items="${fileList}">
								<tr>

									<td><form method="post" action="ViewWhatsNew">
											<input type="submit" name="documentUrl" readonly
												style="clear: both; background-color: transparent; border: 0px solid; height: 20px;"
												value="${file}" />
										</form></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div class="form-group col-md-10">
			
				<div class="rightNav">

					<div id="carouselExampleFade" class="carousel slide carousel-fade"
						data-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img class="d-block w-100" src="pictures/img21.jpg"
									" alt="First slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img22.jpg"
									alt="Second slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img23.jpg"
									alt="Third slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img24.jpg"
									alt="Third slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img25.jpg"
									alt="Third slide">
							</div>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleFade"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleFade"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<div>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>

</body>
</html>