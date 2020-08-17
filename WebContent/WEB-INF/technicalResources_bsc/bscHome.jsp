<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Balance Score Card - Home</title>

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
						<h4>Balance Score Card- Home</h4>
					</li>
					<li><a href="${pageContext.request.contextPath}/Home"
						class="list-group-item list-group-item-action active">SwaziBank
							Home</a></li>
					<li><a href="${pageContext.request.contextPath}/BscPositions"
						class="list-group-item list-group-item-dark">Positions</a></li>
					<li><a href="${pageContext.request.contextPath}/BscObjectives"
						class="list-group-item list-group-item-dark">Objectives</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscSetMeasuresRequest"
						class="list-group-item list-group-item-dark">Measures</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscTargetRequest"
						class="list-group-item list-group-item-dark">Set Targets</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscScoreRequest"
						class="list-group-item list-group-item-dark">Score Positions</a></li>
					<li><a href="${pageContext.request.contextPath}/BscLogin"
						class="list-group-item list-group-item-dark">Reports</a></li>
						<li><a href="${pageContext.request.contextPath}/BscExcoLogin"
						class="list-group-item list-group-item-dark">Corporate Score card</a></li>
						<li><a href="${pageContext.request.contextPath}/BscAdministrationMain"
						class="list-group-item list-group-item-dark">Administration</a></li>

				</ol>

			</div>


			<div class="rightNav">
				<div class="page-header">
					<h3>
						Balanced Score Card <small class="text-muted">Performance
							Management</small>
					</h3>

				</div>
				<div class="page-body">
				<br>
					<p>The Balanced Score Card is a strategy performance
						management tool, a Semi-standard structured report, supported by
						design methods and automation tools, that can be used by managers
						to keep track of the execution of activities by the staff within
						their control and to monitor the consequences arising from these
						actions</p>
						<br>

					<p>The BSC that uses this tool team is focused on managing the
						implementation of a strategy or operational activities the tool is
						used for strategy implementation management and operational
						management. Balanced Score Card is also used by individuals to
						track personal performance,team performance, department
						performance to inform personal goal setting and incentive
						calculations</p>
						<br>

					<p>Under Strategic control Swazibanki's able to control the
						formation and execution of strategic plans; The Balance Score card
						can be set as as future goals management engine. The tool hence
						waits for a strategy to be executed before getting any feedback on
						how well it is working.</p>
						<br>

					<p>The Balance Score Card can also be used in short periodical
						like planning, organizing, staffing and directing. Periodically as
						set, measures and objectives for the period can be checked for
						errors and corrective action immediately implemented so that
						deviation from standards are minimized and stated goals of the
						organization are achieved in a desired manner.</p>
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