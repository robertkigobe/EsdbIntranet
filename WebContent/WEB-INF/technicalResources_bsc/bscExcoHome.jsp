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


					<li><a href="#"
						class="list-group-item list-group-item-action active"> Bsc Exco Home</a></li>
						<li><a
						href="${pageContext.request.contextPath}/BscExcoCommonTargets"
						class="list-group-item list-group-item-dark">Common Targets</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscExcoTargets"
						class="list-group-item list-group-item-dark">Corporate Targets</a></li>
					
										<li><a href="${pageContext.request.contextPath}/BscExcoScores" class="list-group-item list-group-item-dark">Corporate Scores</a></li>


					<li><a
						href="${pageContext.request.contextPath}/BscExcoReportRequest"
						class="list-group-item list-group-item-dark">Corporate Report</a></li>

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
					<p>The Balanced Score Card is a strategy performance management
						tool, a Semi-standard structured report, supported by design
						methods and automation tools, that can be used by managers to keep
						track of the execution of activities by the staff within their
						control and to monitor the consequences arising from these actions</p>
					<br>

					<p>This page provides you with links to manage the following;</p>
					<ol>
						<li><b>Common Targets.</b> This is the link that enables you
							to set targets that are shared amongst all the departments. At
							the point of setting the departmental targets, the lines set in
							here shall be automatically filled with figures that have been
							input form this link. It is important that this common targets
							action is performed first to ensure the rest of the links have
							values.The action is perfomed only once a year. The targets can
							be whenever it is necessary to update by visiting the same links
							again through out the year</li>
						<li><b>Department Targets.</b>This is the link that enables
							you to set targets for the various departments. The targets in
							this link include all those that exist in the common targets set
							in the previous link. The targets in this link are grouped by
							department. On posting the targets from this link, all the values
							in the targets are updated according to the values specified on
							this page. The targets can be whenever it is necessary to update
							by visiting the same links again through out the year</li>
						
						<li><b>Department Scores.</b>This is the link that enables
							you to score the various departments. Like the common targets,
							this link populates the department scores on a monthly basis with
							the shared measures.On clicking this link, you are redirected to
							a page that requires you to choose the Department for which a
							score and a month should be created. This action is required to
							be performed monthly.</li>
						<li><b>Department Reports.</b>This is the link that enables
							you to generate reports for the different departments categorized
							by months scores. If no section is chosen, the score will reflect
							the Bank's performance since the tool's inception. The main
							report page avails filters to allow you report by department or
							period.</li>
					</ol>


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