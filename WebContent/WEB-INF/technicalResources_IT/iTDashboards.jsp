<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>IT Statistics</title>
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
				text : "MFS Daily Transactions"
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
				name : " ATM Cash Withdrawal",
				markerType : "square",
				xValueFormatString : "DD MMM, YYYY",
				color : "#F08080",
				dataPoints : [ 
				               
				               {x : new Date(2019, 1, 24), y : 121720},
				               {x : new Date(2019, 1, 25), y : 53160},
				               {x : new Date(2019, 1, 26), y : 49250},
				               {x : new Date(2019, 1, 27), y : 123570},
				               {x : new Date(2019, 1, 28), y : 105180},
				              
				               {x : new Date(2019, 2, 01), y : 109450}, 
				               {x : new Date(2019, 2, 02), y : 303440},
				               {x : new Date(2019, 2, 03), y : 117790},
				               {x : new Date(2019, 2, 04), y : 283530},
				               {x : new Date(2019, 2, 05), y : 243120},
				               {x : new Date(2019, 2, 06), y : 320240},
				               {x : new Date(2019, 2, 07), y : 250260},
				               {x : new Date(2019, 2, 08), y : 356760},
				               {x : new Date(2019, 2, 09), y : 226150},
				               {x : new Date(2019, 2, 10), y : 95610},
				               {x : new Date(2019, 2, 11), y : 242210},
				               {x : new Date(2019, 2, 12), y : 218250},
				               {x : new Date(2019, 2, 13), y : 135140},
				               {x : new Date(2019, 2, 14), y : 192330},
				               {x : new Date(2019, 2, 15), y : 238170},
				               {x : new Date(2019, 2, 16), y : 146950},
				               {x : new Date(2019, 2, 17), y : 57580},
				               {x : new Date(2019, 2, 18), y : 142290},
				               {x : new Date(2019, 2, 19), y : 152650},
				               {x : new Date(2019, 2, 20), y : 154200},
				               {x : new Date(2019, 2, 21), y : 178500},
				           
				               {x : new Date(2019, 2, 22), y : 115790},
				               {x : new Date(2019, 2, 23), y : 54150},
				               {x : new Date(2019, 2, 24), y : 118740}
				               ]
			}  , {
				type : "line",
				showInLegend : true,
				name : "ESCROW_AGENT_TOPUP",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "DD MMM, YYYY",
				color : "#228af0",
				dataPoints : [ 


{x : new Date(2019, 1, 24), y : 532296},
{x : new Date(2019, 1, 25), y : 78690},
{x : new Date(2019, 1, 26), y : 1830},
{x : new Date(2019, 1, 27), y : 675650},
{x : new Date(2019, 1, 28), y : 266797},

{x : new Date(2019, 2, 01), y : 429876}, 
{x : new Date(2019, 2, 02), y : 216830},
{x : new Date(2019, 2, 03), y : 282045},
{x : new Date(2019, 2, 04), y : 998097},
{x : new Date(2019, 2, 05), y : 781380},
{x : new Date(2019, 2, 06), y : 946731},
{x : new Date(2019, 2, 07), y : 597179},
{x : new Date(2019, 2, 08), y : 1016226},
{x : new Date(2019, 2, 09), y : 638820},
{x : new Date(2019, 2, 10), y : 78230},
{x : new Date(2019, 2, 11), y : 764280},
{x : new Date(2019, 2, 12), y : 1070900},
{x : new Date(2019, 2, 13), y : 617610},
{x : new Date(2019, 2, 14), y : 629485},
{x : new Date(2019, 2, 15), y : 839034},
{x : new Date(2019, 2, 16), y : 407000},
{x : new Date(2019, 2, 17), y : 158110},
{x : new Date(2019, 2, 18), y : 870055},
{x : new Date(2019, 2, 19), y : 714113}, 
{x : new Date(2019, 2, 20), y : 618480},
{x : new Date(2019, 2, 21), y : 782434},
{x : new Date(2019, 2, 22), y : 421767},
{x : new Date(2019, 2, 23), y : 235980},
{x : new Date(2019, 2, 24), y : 1049789}
				              ]

			}, 	{
				type : "line",
				showInLegend : true,
				name : " Funds Transfer To Other Bank",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "DD MMM, YYYY",
				color : "#800000",
				dataPoints : [ 

{x : new Date(2019, 1, 24), y : 235685},
{x : new Date(2019, 1, 25), y : 97312},
{x : new Date(2019, 1, 26), y : 23250},
{x : new Date(2019, 1, 27), y : 411755.07},
{x : new Date(2019, 1, 28), y : 522735.52},

{x : new Date(2019, 2, 01), y : 574359.96}, 
{x : new Date(2019, 2, 02), y : 54653},
{x : new Date(2019, 2, 03), y : 136672},
{x : new Date(2019, 2, 04), y : 625644.2},
{x : new Date(2019, 2, 05), y : 446202.2},
{x : new Date(2019, 2, 06), y : 411661.5},
{x : new Date(2019, 2, 07), y : 331950.75},
{x : new Date(2019, 2, 08), y : 1190053.98},
{x : new Date(2019, 2, 09), y : 207410.25},
{x : new Date(2019, 2, 10), y : 86835.5},
{x : new Date(2019, 2, 11), y : 357296.96},
{x : new Date(2019, 2, 12), y : 565935.87},
{x : new Date(2019, 2, 13), y : 886210.57},
{x : new Date(2019, 2, 14), y : 646191.94},
{x : new Date(2019, 2, 15), y : 986061.97},
{x : new Date(2019, 2, 16), y : 305457.14},
{x : new Date(2019, 2, 17), y : 88759.07},
{x : new Date(2019, 2, 18), y : 610618.96},
{x : new Date(2019, 2, 19), y : 1422660.21},
{x : new Date(2019, 2, 20), y : 473821.03},

{x : new Date(2019, 2, 21), y : 541601.89},
{x : new Date(2019, 2, 22), y : 177561},
{x : new Date(2019, 2, 23), y : 51300},
{x : new Date(2019, 2, 24), y : 1902183.19}

 ]
			},
			{
				type : "line",
				showInLegend : true,
				name : "Funds Transfer To Swazi Bank",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "DD MMM, YYYY",
				color : "#336600",
				dataPoints : [ 


{x : new Date(2019, 1, 24), y : 167434},
{x : new Date(2019, 1, 25), y : 4210},
{x : new Date(2019, 1, 26), y : 4040},
{x : new Date(2019, 1, 27), y : 380399.12},
{x : new Date(2019, 1, 28), y : 75413},

{x : new Date(2019, 2, 01), y : 282198.7}, 
{x : new Date(2019, 2, 02), y : 20710},
{x : new Date(2019, 2, 03), y : 21509},
{x : new Date(2019, 2, 04), y : 109706},
{x : new Date(2019, 2, 05), y : 68620},
{x : new Date(2019, 2, 06), y : 440538.5},
{x : new Date(2019, 2, 07), y : 331496.23},
{x : new Date(2019, 2, 08), y : 541696.79},
{x : new Date(2019, 2, 09), y : 68920},
{x : new Date(2019, 2, 10), y : 145975.2},
{x : new Date(2019, 2, 11), y : 128880},
{x : new Date(2019, 2, 12), y : 889743.05},
{x : new Date(2019, 2, 13), y : 45617},
{x : new Date(2019, 2, 14), y : 258298},
{x : new Date(2019, 2, 15), y : 230748.95},
{x : new Date(2019, 2, 16), y : 31220},
{x : new Date(2019, 2, 17), y : 218532},
{x : new Date(2019, 2, 18), y : 95907.35},
{x : new Date(2019, 2, 19), y : 189204},
{x : new Date(2019, 2, 20), y : 409292.24},
{x : new Date(2019, 2, 21), y : 120824},
{x : new Date(2019, 2, 21), y : 187846.95},
{x : new Date(2019, 2, 22), y : 48175},
{x : new Date(2019, 2, 23), y : 14270},
{x : new Date(2019, 2, 24), y : 76640}
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
			<div class="rightNav">
			
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
