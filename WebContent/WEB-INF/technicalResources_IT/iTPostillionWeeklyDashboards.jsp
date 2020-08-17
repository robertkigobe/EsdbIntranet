<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>IT Weekly Postillion Statistics</title>
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
				text : "Postillion Weekly Transactions"
			},
			axisX : {
				valueFormatString : "MMM DD",
				crosshair : {
					enabled : true,
					snapToDataPoint : true
				}
			},
			axisY : {
				title: "Amount",
				lineColor: "#C24642",
				tickColor: "#C24642",
				labelFontColor: "#C24642",
				titleFontColor: "#C24642",
				suffix: "E"
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
				name : "MANZINI ATMS",
				markerType : "square",
				xValueFormatString : "YYYY MMM, DD",
				color : "#F08080",
				dataPoints : [ 
				               {x : new Date(2018, 06, 01), y : 3002240}, 
				               {x : new Date(2018, 06, 08), y : 2816366}, 
				               {x : new Date(2018, 06, 15), y : 10847295}, 
				               {x : new Date(2018, 06, 22), y : 8492631}, 
				               {x : new Date(2018, 06, 29), y : 4864595}, 
				               {x : new Date(2018, 07, 05), y : 4173799}, 
				               {x : new Date(2018, 07, 12), y : 6812058}, 
				               {x : new Date(2018, 07, 19), y : 11853618}, 
				               {x : new Date(2018, 07, 26), y : 6364350}, 
				               {x : new Date(2018, 08, 02), y : 3098576}, 
				               {x : new Date(2018, 08, 09), y : 3260840}, 
				               {x : new Date(2018, 08, 16), y : 10493355}, 
				               {x : new Date(2018, 08, 23), y : 9739270}, 
				               {x : new Date(2018, 08, 30), y : 4567939}, 
				               {x : new Date(2018, 09, 07), y : 3012765}, 
				               {x : new Date(2018, 09, 14), y : 9352610}, 
				               {x : new Date(2018, 09, 21), y : 9429921}, 
				               {x : new Date(2018, 09, 28), y : 4953820}, 
				               {x : new Date(2018, 10, 04), y : 3268865}, 
				               {x : new Date(2018, 10, 11), y : 3791620}, 
				               {x : new Date(2018, 10, 18), y : 12714630}, 
				               {x : new Date(2018, 10, 25), y : 7064760}, 
				               {x : new Date(2018, 11, 02), y : 4178000}, 
				               {x : new Date(2018, 11, 09), y : 9778700}, 
				               {x : new Date(2018, 11, 17), y : 11005450}, 
				               {x : new Date(2018, 11, 24), y : 4639090}, 
				               {x : new Date(2018, 11, 31), y : 1130100}, 
				               {x : new Date(2019, 00, 07), y : 2349550}, 
				               {x : new Date(2019, 00, 14), y : 5588908}, 
				               {x : new Date(2019, 00, 21), y : 13838610}, 
				               {x : new Date(2019, 00, 28), y : 7742602}
				                ]
			}, {
				type : "line",
				showInLegend : true,
				name : "POS DEVICES",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "YYYY MMM, DD",
				color : "#228af0",
				dataPoints : [ 

				               {x : new Date(2018, 06, 01), y : 5016784}, 
				               {x : new Date(2018, 06, 08), y : 5049741.11}, 
				               {x : new Date(2018, 06, 15), y : 7299720.10}, 
				               {x : new Date(2018, 06, 22), y : 6752963.79}, 
				               {x : new Date(2018, 06, 29), y : 6770878.23}, 
				               {x : new Date(2018, 07, 05), y : 6102001.60}, 
				               {x : new Date(2018, 07, 12), y : 6391254.85}, 
				               {x : new Date(2018, 07, 19), y : 8520323.93}, 
				               {x : new Date(2018, 07, 26), y : 7104175.40}, 
				               {x : new Date(2018, 08, 02), y : 3598742.56}, 
				               {x : new Date(2018, 08, 09), y : 5142221.03}, 
				               {x : new Date(2018, 08, 16), y : 6216142.84}, 
				               {x : new Date(2018, 08, 23), y : 6278060.86}, 
				               {x : new Date(2018, 08, 30), y : 5682480}, 
				               {x : new Date(2018, 09, 07), y : 4560792.82}, 
				               {x : new Date(2018, 09, 14), y : 7071351.18}, 
				               {x : new Date(2018, 09, 21), y : 6612203.08}, 
				               {x : new Date(2018, 09, 28), y : 5774668.34}, 
				               {x : new Date(2018, 10, 04), y : 4538765.41}, 
				               {x : new Date(2018, 10, 11), y : 4289422.79}, 
				               {x : new Date(2018, 10, 18), y : 7119290.16}, 
				               {x : new Date(2018, 10, 25), y : 6420155.80}, 
				               {x : new Date(2018, 11, 02), y : 5783474.21}, 
				               {x : new Date(2018, 11, 09), y : 7183543}, 
				               {x : new Date(2018, 11, 17), y : 11167271}, 
				               {x : new Date(2018, 11, 24), y : 3420200}, 
				               {x : new Date(2018, 11, 31), y : 824460}, 
				               {x : new Date(2019, 00, 07), y : 3058745}, 
				               {x : new Date(2019, 00, 14), y : 6077082.8}, 
				               {x : new Date(2019, 00, 21), y : 10851064.05}, 
				               {x : new Date(2019, 00, 28), y : 7587370} 
				              ]

			}, 	{
				type : "line",
				showInLegend : true,
				name : "MBABANE ATMs",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "YYYY MMM, DD",
				color : "#800000",
				dataPoints : [ 
								{x : new Date(2018, 06, 01), y : 2094510}, 
				               {x : new Date(2018, 06, 08), y : 2003260}, 
				               {x : new Date(2018, 06, 15), y : 6668550}, 
				               {x : new Date(2018, 06, 22), y : 6235690}, 
				               {x : new Date(2018, 06, 29), y : 3617290}, 
				               {x : new Date(2018, 07, 05), y : 2502777}, 
				               {x : new Date(2018, 07, 12), y : 4097180}, 
				               {x : new Date(2018, 07, 19), y : 11570226}, 
				               {x : new Date(2018, 07, 26), y : 4398730}, 
				               {x : new Date(2018, 08, 02), y : 2261110}, 
				               {x : new Date(2018, 08, 09), y : 2244920}, 
				               {x : new Date(2018, 08, 16), y : 11312426}, 
				               {x : new Date(2018, 08, 23), y : 6194250}, 
				               {x : new Date(2018, 08, 30), y : 3280670}, 
				               {x : new Date(2018, 09, 07), y : 2068020}, 
				               {x : new Date(2018, 09, 14), y : 6169600}, 
				               {x : new Date(2018, 09, 21), y : 6007410}, 
				               {x : new Date(2018, 09, 28), y : 3670590}, 
				               {x : new Date(2018, 10, 04), y : 2344650}, 
				               {x : new Date(2018, 10, 11), y : 2530630}, 
				               {x : new Date(2018, 10, 18), y : 8343458}, 
				               {x : new Date(2018, 10, 25), y : 4449010}, 
				               {x : new Date(2018, 11, 02), y : 2993780}, 
				               {x : new Date(2018, 11, 09), y : 5899920}, 
				               {x : new Date(2018, 11, 17), y : 7044720}, 
				               {x : new Date(2018, 11, 24), y : 7143966}, 
				               {x : new Date(2018, 11, 31), y : 856970}, 
				               {x : new Date(2019, 00, 07), y : 1709380}, 
				               {x : new Date(2019, 00, 14), y : 3950780}, 
				               {x : new Date(2019, 00, 21), y : 12718666}, 
				               {x : new Date(2019, 00, 28), y : 4537416}

 ]
			},
			{
				type : "line",
				showInLegend : true,
				name : "REMOTE ON US",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "YYYY MMM, DD",
				color : "#b30000",
				dataPoints : [ 
								{x : new Date(2018, 06, 01), y : 2099776.16}, 
				               {x : new Date(2018, 06, 08), y : 2318545.67}, 
				               {x : new Date(2018, 06, 15), y : 3816242.42}, 
				               {x : new Date(2018, 06, 22), y : 4400919.59}, 
				               {x : new Date(2018, 06, 29), y : 3037363.84}, 
				               {x : new Date(2018, 07, 05), y : 3197988.33}, 
				               {x : new Date(2018, 07, 12), y : 2804589.90}, 
				               {x : new Date(2018, 07, 19), y : 4756547.44}, 
				               {x : new Date(2018, 07, 26), y : 3487935.59}, 
				               {x : new Date(2018, 08, 02), y : 2258853.59}, 
				               {x : new Date(2018, 08, 09), y : 2705608.23}, 
				               {x : new Date(2018, 08, 16), y : 4388791.82}, 
				               {x : new Date(2018, 08, 23), y : 4342099.72}, 
				               {x : new Date(2018, 08, 30), y : 3220249.38}, 
				               {x : new Date(2018, 09, 07), y : 2642669.59}, 
				               {x : new Date(2018, 09, 14), y : 3977115.40}, 
				               {x : new Date(2018, 09, 21), y : 4962154.41}, 
				               {x : new Date(2018, 09, 28), y : 3198904.82}, 
				               {x : new Date(2018, 10, 04), y : 2840381.43}, 
				               {x : new Date(2018, 10, 11), y : 2687989.18}, 
				               {x : new Date(2018, 10, 18), y : 5309349.11}, 
				               {x : new Date(2018, 10, 25), y : 3874081.84}, 
				               {x : new Date(2018, 11, 02), y : 3341208.16}, 
				               {x : new Date(2018, 11, 09), y : 4930131.92}, 
				               {x : new Date(2018, 11, 17), y : 6063578.87}, 
				               {x : new Date(2018, 11, 24), y : 3473843.53}, 
				               {x : new Date(2018, 11, 31), y : 803086.42}, 
				               {x : new Date(2019, 00, 07), y : 1955642.28}, 
				               {x : new Date(2019, 00, 14), y : 3819249.77}, 
				               {x : new Date(2019, 00, 21), y : 5695689.40}, 
				               {x : new Date(2019, 00, 28), y : 4328943.74}

 ]
			},
			{
				type : "line",
				showInLegend : true,
				name : "MATSAPHA ATMs",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "YYYY MMM, DD",
				color : "#336600",
				dataPoints : [ 

							   {x : new Date(2018, 06, 01), y : 1758510}, 
				               {x : new Date(2018, 06, 08), y : 2251890}, 
				               {x : new Date(2018, 06, 15), y : 10826846}, 
				               {x : new Date(2018, 06, 22), y : 5216680}, 
				               {x : new Date(2018, 06, 29), y : 3035550}, 
				               {x : new Date(2018, 07, 05), y : 2959860}, 
				               {x : new Date(2018, 07, 12), y : 4417590}, 
				               {x : new Date(2018, 07, 19), y : 7310920}, 
				               {x : new Date(2018, 07, 26), y : 3800060}, 
				               {x : new Date(2018, 08, 02), y : 2272050}, 
				               {x : new Date(2018, 08, 09), y : 2400550}, 
				               {x : new Date(2018, 08, 16), y : 6675140}, 
				               {x : new Date(2018, 08, 23), y : 5169890}, 
				               {x : new Date(2018, 08, 30), y : 3214350}, 
				               {x : new Date(2018, 09, 07), y : 2235350}, 
				               {x : new Date(2018, 09, 14), y : 6743800}, 
				               {x : new Date(2018, 09, 21), y : 5615200}, 
				               {x : new Date(2018, 09, 28), y : 3461640}, 
				               {x : new Date(2018, 10, 04), y : 2569880}, 
				               {x : new Date(2018, 10, 11), y : 2686170}, 
				               {x : new Date(2018, 10, 18), y : 8328610}, 
				               {x : new Date(2018, 10, 25), y : 4365880}, 
				               {x : new Date(2018, 11, 02), y : 2919530}, 
				               {x : new Date(2018, 11, 09), y : 6556630}, 
				               {x : new Date(2018, 11, 17), y : 6862030}, 
				               {x : new Date(2018, 11, 24), y : 2971920}, 
				               {x : new Date(2018, 11, 31), y : 699120}, 
				               {x : new Date(2019, 00, 07), y : 1521100}, 
				               {x : new Date(2019, 00, 14), y : 3912250}, 
				               {x : new Date(2019, 00, 21), y : 7831940}, 
				               {x : new Date(2019, 00, 28), y : 4524690}
 ]
			}
			,
			{
				type : "line",
				showInLegend : true,
				name : "NHLANGANO ATMs",
				lineDashType : "dash",
				markerType : "square",
				xValueFormatString : "YYYY MMM, DD",
				color : "#336600",
				dataPoints : [ {x : new Date(2018, 06, 01), y : 1394809}, 
				               {x : new Date(2018, 06, 08), y : 1307780}, 
				               {x : new Date(2018, 06, 15), y : 5847760}, 
				               {x : new Date(2018, 06, 22), y : 4556890}, 
				               {x : new Date(2018, 06, 29), y : 2060640}, 
				               {x : new Date(2018, 07, 05), y : 1569910}, 
				               {x : new Date(2018, 07, 12), y : 3757830}, 
				               {x : new Date(2018, 07, 19), y : 5364130}, 
				               {x : new Date(2018, 07, 26), y : 4271860}, 
				               {x : new Date(2018, 08, 02), y : 1365960}, 
				               {x : new Date(2018, 08, 09), y : 1671090}, 
				               {x : new Date(2018, 08, 16), y : 6322110}, 
				               {x : new Date(2018, 08, 23), y : 5491000}, 
				               {x : new Date(2018, 08, 30), y : 2014070}, 
				               {x : new Date(2018, 09, 07), y : 1593985}, 
				               {x : new Date(2018, 09, 14), y : 5620930}, 
				               {x : new Date(2018, 09, 21), y : 5516650}, 
				               {x : new Date(2018, 09, 28), y : 2295240}, 
				               {x : new Date(2018, 10, 04), y : 1562100}, 
				               {x : new Date(2018, 10, 11), y : 2227610}, 
				               {x : new Date(2018, 10, 18), y : 6422450}, 
				               {x : new Date(2018, 10, 25), y : 5193780}, 
				               {x : new Date(2018, 11, 02), y : 1951050}, 
				               {x : new Date(2018, 11, 09), y : 5757620}, 
				               {x : new Date(2018, 11, 17), y : 6752130}, 
				               {x : new Date(2018, 11, 24), y : 2341000}, 
				               {x : new Date(2018, 11, 31), y : 597620}, 
				               {x : new Date(2019, 00, 07), y : 1207070}, 
				               {x : new Date(2019, 00, 14), y : 2842510}, 
				               {x : new Date(2019, 00, 21), y : 6863130}, 
				               {x : new Date(2019, 00, 28), y : 4175570}]
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
			<div class="rightNav" >
			

			<div><a href="${pageContext.request.contextPath}/ITDashboards" type="button" class="btn btn-outline-primary">Daily MFS</a>
			<a href="${pageContext.request.contextPath}/ITPostillionDailyDashboards" type="button" class="btn btn-outline-primary">Daily Postillion</a>
			<a href="#" type="button" class="btn btn-outline-secondary">Weekly MFS</a>
			<a href="${pageContext.request.contextPath}/ITPostillionWeeklyDashboards" type="button" class="btn btn-outline-primary">Weekly Postillion</a>
			<a href="#" type="button" class="btn btn-outline-success">Monthly MFS</a>
			<a href="#" type="button" class="btn btn-outline-success">Monthly Postillion</a>
			<a href="#" type="button" class="btn btn-outline-warning">Quarterly MFS</a>
			<a href="#" type="button" class="btn btn-outline-warning">Quarterly Postillion</a></div>

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
