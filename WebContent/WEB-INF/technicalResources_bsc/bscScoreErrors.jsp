<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successful Delete</title>
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

					<li><a href="${pageContext.request.contextPath}/BscDelete" class="list-group-item list-group-item-action active">Delete Score Cards</a></li>
					<li><a href="${pageContext.request.contextPath}/BscSubmissions" class="list-group-item list-group-item-dark">Submission Report</a></li>				
					<li><a href="#" class="list-group-item list-group-item-dark">Update Score Cards</a></li>
					<li><a 	href="${pageContext.request.contextPath}/BscTargetRequest" class="list-group-item list-group-item-dark">Set Targets</a></li>
					<li><a 	href="${pageContext.request.contextPath}/BscScoreRequest" class="list-group-item list-group-item-dark">Score Positions</a></li>
					<li><a 	href="${pageContext.request.contextPath}/BscScoreRequest" class="list-group-item list-group-item-dark">Bsc Report</a></li>

				</ol>

			</div>
			<div class="rightNav">
				<div class="container">
					<table border="1" cellpadding="5">
						<caption>
							<h2>Success!</h2>
						</caption>
						<thead>
							<tr>
								<th>You have successfully deleted the record of ${bscEmployeeName} with the position of ${position} under the supervision of ${bscEmployeeSupervisor} in the department of ${subDepartment} for the period of ${bscPeriod}  </th>

							</tr>
						</thead>


					</table>
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