<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>New First Aid Inspection</title>
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
			<div class="form-row">
				<div class="form-group col-md-2">
					<h2>Quick Links:</h2>

					<ol class="list-group">


						<li><a
							href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFirstAid"
							class="list-group-item list-group-item-dark">HSE First Aid</a></li>
						<li><a
							href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFireMarshall"
							class="list-group-item list-group-item-dark ">HSE Fire
								Martial</a></li>
						<li><a
							href="${pageContext.request.contextPath}/HealthSafetyNewInspectionWellnessChampion"
							class="list-group-item list-group-item-dark">HSE Wellness
								Champion</a></li>

						<li><a
							href="${pageContext.request.contextPath}/HealthSafetyNewInspectionEnvironmental"
							class="list-group-item list-group-item-dark ">HSE
								Environmental</a></li>


					</ol>


				</div>

				<div class="form-group col-md-10">


					<h2>Submitted Fire Marshall Reports</h2>
					<div>
						<table class="table table-hover table-bordered ">
							<thead>
								<tr>

									<th style="width: 40%">Branch:</th>
									<th style="width: 10%">Date:</th>
									<th style="width: 40%">First Aider</th>
									<th style="width: 10%">Action</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="in" items="${inspections}">
									<tr>
										<form action="HealthSafetyViewInspectionFirstAid"
											method="POST">
											<td><input type="text" value="${in.branchDivision}"
												name="branchDivision" class="form-control" readonly /></td>
											<td><input type="date" value="${in.dateOfInspection}"
												name="dateOfInspection" class="form-control" readonly /></td>
											<td><input type="text" value="${in.representative}"
												name="firstAider" class="form-control" readonly /></td>
											<td><button type="submit" class="btn btn-primary">View</button></td>
										</form>
									</tr>
								</c:forEach>
							</tbody>
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
