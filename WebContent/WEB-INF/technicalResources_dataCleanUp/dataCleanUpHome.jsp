<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>SwaziBank Intranet Home</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/css/eswatini.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Tangerine">
<!-- Icons -->
<link
	href="${pageContext.request.contextPath}/css/leafyfont-awesome.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/leafysimple-line-icons.css"
	rel="stylesheet">

<!-- Main styles for this application -->
<link href="${pageContext.request.contextPath}/css/leafystyle.css"
	rel="stylesheet">


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
					<h4>Data Cleanup Login request</h4>
					<br>
				</div>


			<!-- Main content -->
			<main class="main"> <!-- Breadcrumb -->

			<div class="container-fluid">
				<div class="animated fadeIn row">


					

					<div class="col-lg-10">
						<div class="row">
							<div class="row">
								<div class="col-sm-6 col-lg-3">
									<div class="social-box twitter">
									<I class="fa fa-facebook" >${dataCleanUpList1A}</I>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-1" height="90"></canvas>
										</div>
										<div class="dropdown-menu dropdown-menu-right"></div>
										<ul>
											<li><strong>${dataCleanUpList1}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList1E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>HEAD OFFICE</h5>
									</div>
									<!--/.social-box-->
								</div>
								<!--/.col-->
								<div class="col-sm-6 col-lg-3">
									<div class="social-box facebook">
									<I class="fa fa-facebook" >${dataCleanUpList2A}</i>
										<div class="chart-wrapper">
											<canvas id="social-box-chart-1" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList2}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList2E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>MBABANE</h5>
										
									</div>
									<!--/.social-box-->
								</div>

								<div class="col-sm-6 col-lg-3">
									<div class="social-box facebook">
										<i class="fa fa-facebook">${dataCleanUpList3A}</i> 
										<div class="chart-wrapper">
											<canvas id="social-box-chart-2" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList3}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList3E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>PIGGS PEAK</h5>
									</div>
									<!--/.social-box-->
								</div>
								<!--/.col-->

								<div class="col-sm-6 col-lg-3">

									<div class="social-box linkedin">
										<i class="fa fa-facebook">${dataCleanUpList4A}</i>
										<div class="chart-wrapper">
											<canvas id="social-box-chart-3" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList4}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList4E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>MANZINI</h5>
									</div>
									<!--/.social-box-->
								</div>
							</div>
						</div>
						<div class="row">
							<div class="row">
								<div class="col-sm-6 col-lg-3">
									<div class="social-box facebook">
										<i class="fa fa-facebook">${dataCleanUpList5A}</i> 
										<div class="chart-wrapper">
											<canvas id="social-box-chart-1" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList5}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList5E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>MATSAPHA</h5>
									</div>
									<!--/.social-box-->
								</div>
								<!--/.col-->
								<div class="col-sm-6 col-lg-3">
									<div class="social-box twitter">
									<i class="fa fa-facebook">${dataCleanUpList6A}</i>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-1" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList6}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList6E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>NHLANGANO</h5>
									</div>
									<!--/.social-box-->
								</div>

								<div class="col-sm-6 col-lg-3">
									<div class="social-box facebook">
									<i class="fa fa-facebook">${dataCleanUpList7A}</i>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-2" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList7}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList7E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>SITEKI</h5>
									</div>
									<!--/.social-box-->
								</div>
								<!--/.col-->

								<div class="col-sm-6 col-lg-3">

									<div class="social-box linkedin">
									<i class="fa fa-facebook">${dataCleanUpList8A}</i>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-3" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList8}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList8E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>SIMUNYE</h5>
									</div>
									<!--/.social-box-->
								</div>
							</div>
						</div>
						<div class="row">
							<div class="row">
								<div class="col-sm-6 col-lg-3">
									<div class="social-box facebook">
									<i class="fa fa-facebook">${dataCleanUpList9A}</i>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-1" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList9}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList9E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>MATATA</h5>
									</div>
									<!--/.social-box-->
								</div>
								<!--/.col-->
								<div class="col-sm-6 col-lg-3">
									<div class="social-box facebook">
									<i class="fa fa-facebook">${dataCleanUpList10A}</i>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-1" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList10}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList10E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>MBC</h5>
									</div>
									<!--/.social-box-->
								</div>

								<div class="col-sm-6 col-lg-3">
									<div class="social-box twitter">
									<i class="fa fa-facebook">${dataCleanUpList11A}</i>
									
										<div class="chart-wrapper">
											<canvas id="social-box-chart-2" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList11}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList11E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>OPC</h5>
									</div>
									<!--/.social-box-->
								</div>
								<!--/.col-->

								<div class="col-sm-6 col-lg-3">

									<div class="social-box linkedin">
									<i class="fa fa-facebook">${dataCleanUpList12A}</i>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-3" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList12}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList12E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>SIPHOFANENEI</h12>
									</div>
									<!--/.social-box-->
								</div>
							</div>
						</div>
						<div class="row">
							<div class="row">
								<div class="col-sm-6 col-lg-3">
									<div class="social-box facebook">
									<i class="fa fa-facebook">${dataCleanUpList13A}</i>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-1" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList13}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList13E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>EZULWINI</h5>
									</div>
									<!--/.social-box-->
								</div>
								<!--/.col-->
								<div class="col-sm-6 col-lg-3">
									<div class="social-box facebook">
									<i class="fa fa-facebook">${dataCleanUpList14A}</i>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-1" height="90"></canvas>
										</div>
										<ul>
											<li><strong>${dataCleanUpList14}</strong> <span>Clean</span></li>
											<li><strong>${dataCleanUpList14E}</strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h5>MZN HUB</h4>
									</div>
									<!--/.social-box-->
								</div>

								<div class="col-sm-6 col-lg-3">
									<div class="social-box facebook">
									<i class="fa fa-facebook">${dataCleanUpList15A}</i>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-2" height="90"></canvas>
										</div>
										<ul>
											<li><strong></strong> <span>Clean</span></li>
											<li><strong></strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h4>CASH CENTER</h4>
									</div>
									<!--/.social-box-->
								</div>
								<!--/.col-->

								<div class="col-sm-6 col-lg-3">

									<div class="social-box twitter">
									<i class="fa fa-facebook">${dataCleanUpListNoCompany}</i>
										
										<div class="chart-wrapper">
											<canvas id="social-box-chart-3" height="90"></canvas>
										</div>
										<ul>
											<li><strong></strong> <span>Clean</span></li>
											<li><strong></strong> <a href="${pageContext.request.contextPath}/DataCleanUpLogin" class="card-link">Dirty Records</a>
										</ul>
										<h4>NO COMPANY</h4>
									</div>
									<!--/.social-box-->
								</div>
							</div>
						</div>

					</div>
					<div class="col-md-2">
						<div class="card text-white bg-primary">
							<div class="card-block pb-0">
								<div class="btn-group float-right">
									<button type="button"
										class="btn btn-transparent active dropdown-toggle p-0"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<i class="icon-settings"></i>
									</button>
									<div class="dropdown-menu dropdown-menu-right">
										
									</div>
								</div>
								<h4 class="mb-0">${cleanRecords}</h4>
								<p>Clean Records</p>
							</div>
							<div class="chart-wrapper px-3" style="height: 70px;">
								<canvas id="card-chart1" class="chart" height="70"></canvas>
							</div>
						</div>
						<div class="card text-white bg-warning">
							<div class="card-block pb-0">
								<div class="btn-group float-right">
									<button type="button"
										class="btn btn-transparent active dropdown-toggle p-0"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<i class="icon-settings"></i>
									</button>
									<div class="dropdown-menu dropdown-menu-right">
										<a class="dropdown-item" href="#">Export Clean Records to
											Excel</a> 
									</div>
								</div>
								<h4 class="mb-0">${dirtyRecords}</h4>
								<p>Dirty records</p>
							</div>
							<div class="chart-wrapper" style="height: 70px;">
								<canvas id="card-chart3" class="chart" height="70"></canvas>
							</div>
						</div>
						<div class="card text-white bg-danger">
							<div class="card-block pb-0">
								<div class="btn-group float-right">
									<button type="button"
										class="btn btn-transparent active dropdown-toggle p-0"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<i class="icon-settings"></i>
									</button>
									<div class="dropdown-menu dropdown-menu-right">
									<a class="dropdown-item" href="#">Clean Records</a>
											
										<a class="dropdown-item" href="#">Export Clean Records to Excel</a> 
										
									</div>
								</div>
								<h4 class="mb-0">${allRecords}</h4>
								<p>number of records</p>
							</div>
							<div class="chart-wrapper px-3" style="height: 70px;">
								<canvas id="card-chart4" class="chart" height="70"></canvas>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
	</div>
	<!-- /.conainer-fluid -->
	</main>




	</div>







	</div>
	<div class="clear"></div>
	<div>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>
	<!-- Bootstrap and necessary plugins -->

	<script src="${pageContext.request.contextPath}/js/leafyindex.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/leafybootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/leafypace.min.js"></script>
	<!-- Plugins and scripts required by all views -->
	<script src="${pageContext.request.contextPath}/js/leafychart.min.js"></script>
	<!-- GenesisUI main scripts -->
	<script src="${pageContext.request.contextPath}/js/leafyapp.js"></script>
	<!-- Plugins and scripts required by this views -->
	<script src="${pageContext.request.contextPath}/js/leafytoastr.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/leafygauge.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/leafymoment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/leafydaterangepicker.js"></script>
	<!-- Custom scripts required by this view -->
	<script src="${pageContext.request.contextPath}/js/leafymain.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript"
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>