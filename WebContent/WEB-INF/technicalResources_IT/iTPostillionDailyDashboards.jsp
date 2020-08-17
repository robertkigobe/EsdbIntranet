<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>IT Postillion Statistics</title>
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


<script>
	window.onload = function() {

		var chart = new CanvasJS.Chart("chartContainer", {
			animationEnabled : true,
			theme : "light2",
			title : {
				text : "Postillion Daily Transactions"
			},
			axisX : {
				valueFormatString : "DD MMM",
				crosshair : {
					enabled : true,
					snapToDataPoint : true
				}
			},
			axisY : {
				title : "Amount (E)",
				crosshair : {
					enabled : true
				}
			},
			toolTip : {
				shared : true
			},
			legend : {
				cursor : "pointer",
				verticalAlign : "bottom",
				horizontalAlign : "left",
				dockInsidePlotArea : true,
				itemclick : toogleDataSeries
			},
			data : [ {
				type : "line",
				showInLegend : true,
				name : "EZULWINI ATM",
				markerType : "square",
				xValueFormatString : "DD MMM, YYYY",
				color : "#F08080",
				dataPoints : [ 
				            
				               {x : new Date(2019, 1, 24), y : 131400},
				               {x : new Date(2019, 1, 25), y : 102960},
				               {x : new Date(2019, 1, 26), y : 92440},
				               {x : new Date(2019, 1, 27), y : 127770},
				               {x : new Date(2019, 1, 28), y : 110990},
				             
				               {x : new Date(2019, 2, 01), y : 162150}, 
				               {x : new Date(2019, 2, 02), y : 499260},
				               {x : new Date(2019, 2, 03), y : 307140},
				               {x : new Date(2019, 2, 04), y : 467920},
				               {x : new Date(2019, 2, 05), y : 537300},
				               {x : new Date(2019, 2, 06), y : 488390},
				               {x : new Date(2019, 2, 07), y : 381750},
				               {x : new Date(2019, 2, 08), y : 388820},
				               {x : new Date(2019, 2, 09), y : 221170},
				               {x : new Date(2019, 2, 10), y : 185320},
				               {x : new Date(2019, 2, 11), y : 299170},
				               {x : new Date(2019, 2, 12), y : 241560},
				               {x : new Date(2019, 2, 13), y : 194490},
				               {x : new Date(2019, 2, 14), y : 217560},
				               {x : new Date(2019, 2, 15), y : 191410},
				               {x : new Date(2019, 2, 16), y : 157900},
				               {x : new Date(2019, 2, 17), y : 89190},
				               {x : new Date(2019, 2, 18), y : 160920},
				               {x : new Date(2019, 2, 19), y : 141520},
				               {x : new Date(2019, 2, 20), y : 172390},
				               {x : new Date(2019, 2, 21), y : 163650},
				               {x : new Date(2019, 2, 22), y : 87000},
				               {x : new Date(2019, 2, 23), y : 74550},
				               {x : new Date(2019, 2, 24), y : 160920}
				               ]
			}, {
				type : "line",
				showInLegend : true,
				name : "MAZINI ATM",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "DD MMM, YYYY",
				color : "#228af0",
				dataPoints : [ 

{x : new Date(2019, 1, 24), y : 674260},
{x : new Date(2019, 1, 25), y : 474860},
{x : new Date(2019, 1, 26), y : 262260},
{x : new Date(2019, 1, 27), y : 687210},
{x : new Date(2019, 1, 28), y : 490970},

{x : new Date(2019, 2, 01), y : 674970}, 
{x : new Date(2019, 2, 02), y : 2124238},
{x : new Date(2019, 2, 03), y : 1037490},
{x : new Date(2019, 2, 04), y : 2663580},
{x : new Date(2019, 2, 05), y : 2420560},
{x : new Date(2019, 2, 06), y : 2137690},
{x : new Date(2019, 2, 07), y : 1717620},
{x : new Date(2019, 2, 08), y : 2209360},
{x : new Date(2019, 2, 09), y : 1652310},
{x : new Date(2019, 2, 10), y : 581140},
{x : new Date(2019, 2, 11), y : 1822010},
{x : new Date(2019, 2, 12), y : 1065296},
{x : new Date(2019, 2, 13), y : 939050},
{x : new Date(2019, 2, 14), y : 1171606},
{x : new Date(2019, 2, 15), y : 1193210},
{x : new Date(2019, 2, 16), y : 970290},
{x : new Date(2019, 2, 17), y : 356770},
{x : new Date(2019, 2, 18), y : 715910},
{x : new Date(2019, 2, 19), y : 689170},
{x : new Date(2019, 2, 20), y : 797240},
{x : new Date(2019, 2, 21), y : 799030},
{x : new Date(2019, 2,21), y : 887850},
{x : new Date(2019, 2, 22), y : 684300},
{x : new Date(2019, 2, 23), y : 261990},
{x : new Date(2019, 2, 24), y : 566300}
				              ]

			}, 	{
				type : "line",
				showInLegend : true,
				name : "CASH CENTER",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "DD MMM, YYYY",
				color : "#800000",
				dataPoints : [ 

{x : new Date(2019, 1, 24), y : 229890},
{x : new Date(2019, 1, 25), y : 178960},
{x : new Date(2019, 1, 26), y : 117790},
{x : new Date(2019, 1, 27), y : 225710},
{x : new Date(2019, 1, 28), y : 214030},

{x : new Date(2019, 2, 01), y : 244300}, 
{x : new Date(2019, 2, 02), y : 846330},
{x : new Date(2019, 2, 03), y : 647460},
{x : new Date(2019, 2, 04), y : 662480},
{x : new Date(2019, 2, 05), y : 600700},
{x : new Date(2019, 2, 06), y : 517880},
{x : new Date(2019, 2, 07), y : 414100},
{x : new Date(2019, 2, 08), y : 633420},
{x : new Date(2019, 2, 09), y : 430890},
{x : new Date(2019, 2, 10), y : 302650},
{x : new Date(2019, 2, 11), y : 511320},
{x : new Date(2019, 2, 12), y : 323390},
{x : new Date(2019, 2, 13), y : 311920},
{x : new Date(2019, 2, 14), y : 286290},
{x : new Date(2019, 2, 15), y : 355040},
{x : new Date(2019, 2, 14), y : 283580},
{x : new Date(2019, 2, 17), y : 197290},
{x : new Date(2019, 2, 18), y : 222800},
{x : new Date(2019, 2, 19), y : 258710},
{x : new Date(2019, 2, 20), y : 248480},
{x : new Date(2019, 2, 21), y : 219830},
{x : new Date(2019, 2,21), y : 274310},
{x : new Date(2019, 2, 22), y : 205650},
{x : new Date(2019, 2, 23), y : 127240},
{x : new Date(2019, 2, 24), y : 161720}

 ]
			},
			{
				type : "line",
				showInLegend : true,
				name : "MATATA ATM",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "DD MMM, YYYY",
				color : "#336600",
				dataPoints : [ 


{x : new Date(2019, 1, 24), y : 107700},
{x : new Date(2019, 1, 25), y : 78540},
{x : new Date(2019, 1, 26), y : 49120},
{x : new Date(2019, 1, 27), y : 134870},
{x : new Date(2019, 1, 28), y : 95330},

{x : new Date(2019, 2, 01), y : 180920}, 
{x : new Date(2019, 2, 02), y : 255440},
{x : new Date(2019, 2, 03), y : 234400},
{x : new Date(2019, 2, 04), y : 355870},
{x : new Date(2019, 2, 05), y : 310900},
{x : new Date(2019, 2, 06), y : 392990},
{x : new Date(2019, 2, 07), y : 413910},
{x : new Date(2019, 2, 08), y : 1068560},
{x : new Date(2019, 2, 09), y : 664740},
{x : new Date(2019, 2, 10), y : 175390},
{x : new Date(2019, 2, 11), y : 393860},
{x : new Date(2019, 2, 12), y : 218870},
{x : new Date(2019, 2, 13), y : 215630},
{x : new Date(2019, 2, 14), y : 272590},
{x : new Date(2019, 2, 15), y : 576230},
{x : new Date(2019, 2, 16), y : 289470},
{x : new Date(2019, 2, 17), y : 69820},
{x : new Date(2019, 2, 18), y : 171560},
{x : new Date(2019, 2, 19), y : 142230},
{x : new Date(2019, 2, 20), y : 306710},
{x : new Date(2019, 2, 21), y : 181580},
{x : new Date(2019, 2,21), y : 231680},
{x : new Date(2019, 2, 22), y : 144000},
{x : new Date(2019, 2, 23), y : 49940},
{x : new Date(2019, 2, 24), y : 88430}
 ]
			}]
		});
		chart.render();

		function toogleDataSeries(e) {
			if (typeof (e.dataSeries.visible) === "undefined"
					|| e.dataSeries.visible) {
				e.dataSeries.visible = false;
			} else {
				e.dataSeries.visible = true;
			}
			chart.render();
		}

	}
</script>
<script type="text/javascript"
	src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
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
					
				</ol>

			</div>
			
		<div><a href="${pageContext.request.contextPath}/ATMHighCharts" type="button" class="btn btn-outline-success">Branch ATMs</a>
			<a href="${pageContext.request.contextPath}/ITDashboards" type="button" class="btn btn-outline-secondary">Daily MFS</a>
			<a href="${pageContext.request.contextPath}/ITPostillionDailyDashboards" type="button" class="btn btn-outline-primary">Daily Postillion</a>
			<a href="${pageContext.request.contextPath}/ITPostillionWeeklyDashboards" type="button" class="btn btn-outline-primary">Weekly Postillion</a>
			<a href="#" type="button" class="btn btn-outline-success">Monthly MFS</a>
			<a href="#" type="button" class="btn btn-outline-secondary">Monthly Postillion</a>
			</div>

				<div id="chartContainer" style="height: 400px; width: 100%;"></div>


			</div>
		</div>
	</div>




	<div class="clear"></div>
	<div>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
