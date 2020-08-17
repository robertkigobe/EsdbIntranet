<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Balance Score Card - Perspectives</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


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
	<div class="container">
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

				<h4>Balance Score Card- Home</h4>

				<Ol>
					<li><a href="${pageContext.request.contextPath}/BscPositions">Positions</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscPerspectives">Perspectives</a></li>
					<li><a href="${pageContext.request.contextPath}/BscObjectives">Objectives</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscSetMeasuresRequest">Measures</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscTargetRequest">Set
							Targets</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscScoreRequest">Score
							Positions</a></li>
					<li><a href="${pageContext.request.contextPath}/BscLogin">Reports</a></li>
				</Ol>
			</div>
			<div class="rightNav">
				<h1>Balance Score card - Perspectives</h1>

				<ol>
					<li><p>
							<b>The Financial Perspective: </b>Focuses on financial
							performance of SwaziBank. It covers the revenue and profit
							targets of SwaziBank. The financial health of an SwaziBank is a
							critical perspective for managers to track. Financial performance
							is usually interpreted as a result of good performance in the
							other three scorecard perspectives.
						</p></li>
					<li><p>
							<b>The Customer perspective: </b>Focuses on performance targets
							as they relate to customers and the market. It usually covers
							customer growth and service targets as well as market share and
							branding objectives. Typical measures and KPIs in this
							perspective include customer satisfaction, service levels, net
							promoter scores, market share and brand awareness.
						</p></li>
					<li><p>
							<b>The Internal Business Processes: </b>Focuses on internal
							operational goals and covers objectives as they relate to the key
							processes necessary to deliver the customer objectives. Here,
							companies outline the internal business processes goals and the
							things the organisation has to do really well internally in order
							to push performance. Typical example measures and KPIs include
							process improvements, quality optimisation and capacity
							utilisation.
						</p></li>
					<li><p>
							<b>Learning and Growth: </b>Focuses on the intangible drivers of
							future and is often broken down into the following components:
						<ol>
							<li>Human Capital (skills, talent, and knowledge)</li>
							<li>Information Capital (databases, information systems,
								networks, and technology infrastructure)</li>
							<li>Organization Capital (culture, leadership, employee
								alignment, teamwork and knowledge management)..</li>

						</ol> Typical example measures and KPIs include staff engagement,
						skills assessment, performance management scores and corporate
						culture audits.</li>
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