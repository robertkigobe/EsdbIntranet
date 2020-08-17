<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risk Management Test</title>
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
					<li><a
						href="${pageContext.request.contextPath}/RiskManagementTest"
						class="list-group-item list-group-item-action active">Start
							Test</a></li>
					
					<li><a
						href="${pageContext.request.contextPath}/RiskAwarenessSurveyHomePage" class="list-group-item list-group-item-dark">Risk
							Awareness Survey</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Anti Money Laundering Test</a></li>
					<li><a
						href="${pageContext.request.contextPath}/WhistelBlowingFeedBack" class="list-group-item list-group-item-dark">whistle
							Blowing Platform</a></li>
					<li><a href="${pageContext.request.contextPath}/Home"
						class="list-group-item list-group-item-dark">SwaziBank Home</a></li>
				</ol>

			</div>

			<div class="rightNav">
				<div class="page-header">
				<h4>Risk Management  Test Objective:</h4>
				</div>

				<div class="page-body">
					<br>
					<p>Risk Management in a banking environment is of essence
						considering the different services offered. It follows therefore
						that every staff member must have a certain level of Risk
						Management understanding. This is more so because every activity
						in a Bank has an element of risk that has to be managed.</p>

					<p>The Risk and Compliance Department has been entrusted with
						the responsibility of making sure that the culture of risk
						management in the Bank is instilled and every employee appreciates
						the risks around his/her environment. It is therefore important
						that this test is taken seriously by all employees. The pass mark
						for the test is 80%. Its aim is mainly to;</p>

					<ol>
						<li>Increase risk awareness in the Bank;</li>
						<li>Encourage employees to manage risks in their
							environments;</li>
						<li>Make employees aware of the different Risk Management
							Policies like Whistle Blowing, Business Continuity, etc.</li>
					</ol>
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