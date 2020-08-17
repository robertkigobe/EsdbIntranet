<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>ATM BEHAVIOR</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/highcharts.js"></script>
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<div>
			<img src="pictures/headerlogo1.jpg" style="width: 100%; height: 20%"></img>
		</div>

		<div>
			<jsp:include page="../utilities/_menu.jsp"></jsp:include>
			<div class="clear"></div>
		</div>



		<div class="leftNav">

			<ol class="list-group">

				<li class="list-group-item">
					<h4>Quick Links</h4>
				</li>
				<li><a href="${pageContext.request.contextPath}/History"
					class="list-group-item list-group-item-dark active">SwaziBank
						History</a></li>
				<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
					class="list-group-item list-group-item-dark">Briefs and News</a></li>
				<li><a href="${pageContext.request.contextPath}/VisionPage"
					class="list-group-item list-group-item-dark">SwaziBank Vision,
						Mission And Core Values</a></li>
				<li><a href="${pageContext.request.contextPath}/NoticeBoard"
					class="list-group-item list-group-item-dark">SwaziBank Notice
						Board</a></li>
				<li><a href="${pageContext.request.contextPath}/NewsLetter"
					class="list-group-item list-group-item-dark">Publications</a></li>
				<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
					class="list-group-item list-group-item-dark">Briefs And News</a></li>
				<li><a
					href="${pageContext.request.contextPath}/IntranetFeedBack"
					class="list-group-item list-group-item-dark">Feedback</a></li>
				<li><a href="${pageContext.request.contextPath}/InternalAdvert"
					class="list-group-item list-group-item-dark">Internal Vacancies</a></li>

				
			</ol>

		</div>

		<div class="rightNav">

			
				<div class="page-header">
				
				<div><a href="${pageContext.request.contextPath}/ATMHighCharts" type="button" class="btn btn-outline-success">Branch ATMs</a>
			<a href="${pageContext.request.contextPath}/ITDashboards" type="button" class="btn btn-outline-secondary">Daily MFS</a>
			<a href="${pageContext.request.contextPath}/ITPostillionDailyDashboards" type="button" class="btn btn-outline-primary">Daily Postillion</a>
			<a href="${pageContext.request.contextPath}/ITPostillionWeeklyDashboards" type="button" class="btn btn-outline-primary">Weekly Postillion</a>
			<a href="#" type="button" class="btn btn-outline-success">Monthly MFS</a>
			<a href="#" type="button" class="btn btn-outline-secondary">Monthly Postillion</a>
			</div>
			<br />
			
			

				 <form method="get" action="" class="form-horizontal" name="dateParameterForm">
						<div class="form-group">


							<div class="input-group mb-6">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">Date
										From: </span>
								</div>
								<input type="date" class="form-control" col-md-6 name="dateFrom" value="dateFrom" required>
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">Date
										To: </span>
								</div>
								<input type="date" class="form-control" col-md-6 name="dateTo" value="dateTo" required>
								<button class="btn btn-success" >Search</button>
							</div>
							<a href="${pageContext.request.contextPath}/ATMHighCharts"
								class="form-group-item">Clear Filters</a>
						</div>
				</div>
				</form> 
				
				
				

			


			<table class="table">
				<tr>
					<td align="center">
						<div id="outerDiv" style="width: 100%">
							<div id="placeholder"></div>
						</div>
					</td>
				</tr>
			</table>

		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			generateChart();

		});

		function passpercentage(json) {
			
			var dateFrom = document.dateParameterForm.dateFrom.value;
			var dateTo = document.dateParameterForm.dateTo.value;

			$(function() {

				var len = json.passpercentage.length
				i = 0;

				var options = {
					chart : {
						type : 'column'

					},
					credits : {
						enabled : false
					},
					title : {
						text : 'POSTILLION STATISTICS'
					},
					subtitle : {
						text : 'Source: Postillion',
						x : -20
					},
					yAxis : {
						min : 0,
						title : {
							text : 'Amounts'
						}
					},
					plotOptions : {
						column : {
							pointPadding : 0.2,
							borderWidth : 0
						}
					},
					xAxis : {
						categories : []
					},
					series : []
				}

				for (i; i < len; i++) {
					if (i === 0) {
						var dat = json.passpercentage[i].category, lenJ = dat.length, j = 0, tmp;

						for (j; j < lenJ; j++) {
							options.xAxis.categories.push(dat[j]);
						}
					} else {
						options.series.push(json.passpercentage[i]);
					}
				}

				$('#placeholder').highcharts(options);

			});

		}

		function generateChart() {

			chartType = "passpercentage";
			
			var dateFrom = document.dateParameterForm.dateFrom.value;
			var dateTo = document.dateParameterForm.dateTo.value;
			
			$("#placeholder").text("");

			$
					.ajax({
						type : "GET",
						url : "http://localhost:8080/SwaziBankIntranetLive/ATMGetChartDetails?jsonp="+chartType+"&dateFrom="+dateFrom+"&dateTo="+dateTo,
						dataType : 'jsonp',
						jsonpCallback : chartType, // the function to call
						error : function() {
							alert("Error is occured");
						}
					});

		}
		

	</script>
</body>
</html>