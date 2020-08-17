<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>PRACTICES SURVEY QUESTIONNAIRE</title>

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


					<li><a href="${pageContext.request.contextPath}/WorkPlaceWellnessSurveySurvey"
						class="list-group-item list-group-item-action active"> Start Survey</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs and News</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage" class="list-group-item list-group-item-dark">SwaziBank
						Vision</a></li>
						<li><a href="${pageContext.request.contextPath}/BriefsAndNews" class="list-group-item list-group-item-dark">Briefs
						And News</a></li>

					<li><a
					href="${pageContext.request.contextPath}/SwaziBankProducts" class="list-group-item list-group-item-dark">SwaziBank
						Products </a></li>
						
						<li><a href="${pageContext.request.contextPath}/BscMain" class="list-group-item list-group-item-dark">Balance
								Score Card</a></li>



				</ol>

			</div>


			<div class="rightNav">
				<div class="page-header">
					<h4>
						KNOWLEDGE, ATTITUDES, BEHAVIOURS<small class="text-muted">PRACTICES
							SURVEY QUESTIONNAIRE</small>
					</h4>

				</div>
				<div class="page-body">
					
					<p>Dear Employees</p>
					<br>

					<p>
						We are in the process of documenting and improving our work place
						wellness program. The first step of this process is to gather
						input from as many employees as possible. Your participation and
						involvement in this process gives the wellness committee members
						the best opportunity to facilitate a successful wellness program </p><br><p>To
						help us in this regard, we have developed a few questions in this
						survey that we are asking everyone to complete.</p><br><p>Thank you
						for helping us to re-launch our work place wellness program.
					</p>
					<div  style="text-align: center;">
					<a href="${pageContext.request.contextPath}/WorkPlaceWellnessSurveySurvey"
						class="list-group-item list-group-item-action active"> Start Survey</a>
					</div>


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