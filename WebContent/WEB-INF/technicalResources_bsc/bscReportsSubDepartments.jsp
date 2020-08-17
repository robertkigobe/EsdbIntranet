<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Balance Score Card - Reports</title>

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

			<br>

			<div class="page-header">
				<h3>
					Sub Departments <small class="text-muted">Bsc Reports</small>
				</h3>

			</div>

			<br>
			<br>

			<form action=BscSearchReportsSubDepartments method="post">
			
			<div class="form-group row ">
					<label class="col-sm-2 col-form-label"><h5>Sub Department:</h5></label>
					<div class="col-sm-10">
						<input type="text" name="subDepartment" class="col-sm-3 col-form-label" value="${subDepartment}" readonly>
						
					</div>
				</div>
				<div class="form-group row ">
					<label class="col-sm-2 col-form-label"><h5>Period:</h5></label>
					<div class="col-sm-10">
						<Select name="bscPeriod" class="col-sm-3 col-form-label">
							<c:forEach var="bscPeriods" items="${bscPeriods}">
								<option value="${bscPeriods}">${bscPeriods}</option>
							</c:forEach>
						</Select>
					</div>
				</div>


				<div class="form-group row">
					<label class="col-sm-2 col-form-label"><h5>Position:</h5></label>
					<div class="col-sm-10">
						<Select name="position" class="col-sm-3 col-form-label">
							<c:forEach var="position" items="${positions}">
								<option value="${position}">${position}</option>
							</c:forEach>
						</Select>
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label"><h5>Employee
							Name:</h5></label>
					<div class="col-sm-10">
						<Select name="bscEmployeeName" class="col-sm-3 col-form-label">
							<c:forEach var="employee" items="${employees}">
								<option value="${employee}">${employee}</option>
							</c:forEach>
						</Select>
					</div>
				</div>



				<div class="form-group row">
					<div class="offset-sm-2 col-sm-10">
						<button type="submit" class="btn btn-primary">Search</button>
					</div>
				</div>
			</form>



			<br> <br>
			<h3>Performance: ${averageScore}%</h3>
			<br>

			<table class="table  table-striped table-hover table-bordered table-sm">

				<thead class="thead-dark">
					<tr>

						<th>Perspective</th>
						<th>Objective</th>
						<th>Period</th>
						<th>RF</th>
						<th>Measure</th>
						<th>Base</th>
						<th>Stretch</th>
						<th>Actual</th>
						<th>AR</th>
						<th>Status</th>


					</tr>
				</thead>
				<c:forEach var="file" items="${departmentReport}">
					<tr>
						<td style="width: 200px;"><c:out value="${file.perspective}" /></td>
						<td style="width: 400px;"><c:out value="${file.objective}" /></td>
						<td style="width: 100px;"><c:out value="${file.period}" /></td>
						<td style="width: 100px;"><c:out
								value="${file.reportingFrequencies}" /></td>
						<td style="width: 450px;"><c:out value="${file.measure}" /></td>
						<td style="width: 100px;"><c:out value="${file.base}" /></td>
						<td style="width: 100px;"><c:out value="${file.stretch}" /></td>
						<td style="width: 100px;"><c:out value="${file.actual}" /></td>
						<td style="width: 100px;"><c:out
								value="${file.archievementRatio}" />%</td>
						<td style="border-style: dotted; width: 100px;"><c:out
								value="${file.status}" /></td>

					</tr>
				</c:forEach>
			</table>



		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>