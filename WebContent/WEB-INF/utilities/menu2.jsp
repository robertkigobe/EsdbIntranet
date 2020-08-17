<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
<link href="css/eswatini.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Tangerine">
<!-- Icons -->
<link href="css/leafyfont-awesome.min.css" rel="stylesheet">
<link href="css/leafysimple-line-icons.css" rel="stylesheet">

<!-- Main styles for this application -->
<link href="css/leafystyle.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Tangerine">

</head>
<body>
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
								class="dropdown-item" href="#">Risk and Compliance</a>
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
								class="dropdown-item" href="#">Risk and Compliance</a>
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
	<div>
		<jsp:include page="../utilities/bar.jsp"></jsp:include>
		<div class="clear"></div>
	</div>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript"
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

	<!-- Bootstrap and necessary plugins -->
	<script src="js/leafyjquery.min.js"></script>
	<script src="js/leafyindex.js"></script>
	<script src="js/leafybootstrap.min.js"></script>
	<script src="js/leafypace.min.js"></script>
	<!-- Plugins and scripts required by all views -->
	<script src="js/leafyChart.min.js"></script>
	<!-- GenesisUI main scripts -->
	<script src="js/leafyapp.js"></script>
	<!-- Plugins and scripts required by this views -->
	<script src="js/leafytoastr.min.js"></script>
	<script src="js/leafygauge.min.js"></script>
	<script src="js/leafymoment.min.js"></script>
	<script src="js/leafydaterangepicker.js"></script>
	<!-- Custom scripts required by this view -->
	<script src="js/leafymain.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript"
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>