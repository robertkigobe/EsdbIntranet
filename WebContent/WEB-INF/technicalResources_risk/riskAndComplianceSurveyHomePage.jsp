<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risk and Awareness Survey</title>
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
						<h4>Quick Links</h4>
					</li>
					<li><a href="${pageContext.request.contextPath}/RiskAwarenessSurvey"
						class="list-group-item list-group-item-action active">Start
							Survey</a></li>
					<li><a href="${pageContext.request.contextPath}/AmlTestMain" class="list-group-item list-group-item-dark">Anti
							Money Laundering Test</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Risk
							Management Test</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Publications</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Whistle
							Blowing Platform</a></li>
												<li><a href="${pageContext.request.contextPath}/RiskReportLogin" class="list-group-item list-group-item-dark">Risk	Management Survey Report</a></li>
							
					<li><a href="${pageContext.request.contextPath}/Home"
						class="list-group-item list-group-item-dark">SwaziBank Home</a></li>
				</ol>

			</div>



			<div class="rightNav">
				<div class="page-header">
					<h3>Risk Awareness Survey</h3>

				</div>

				<h4>Objective of the Survey:</h4>
				<div class="page-body">
					<br>
					<p>The objective of the Risk Awareness Survey is to provide the
						Risk Department with insight on the level of staff awareness on
						risk matters bank-wide. This has been done through structured
						questions that will be consolidated to form a Risk Awareness Index
						of the Bank. The Index will be used to develop programs that will
						enhance increased risk awareness of all employees of the Bank.
						There are therefore no wrong or right responses to the provided
						questions. This exercise is not designed to test knowledge of risk
						among employees but rather an enhancement tool for the Risk
						department to improve programs meant to increase risk awareness in
						the Bank. In order for this to be a meaningful exercise, Staff is
						requested to answer questions with all honesty.</p>
					<br>


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