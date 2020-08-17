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
			<div class="page-header">
				<h3>Business Banking BSC Reports</h3>
			</div>

			<form action=BscReportsBusinessBanking method="post"
				class="form-group">

				<table class="table  table-striped table-hover table-bordered">



					<tr>
						<td>Period:</td>
						<td><select name="bscPeriod"
							style="border: none; width: 100%">
								<option>${bscPeriod}</option>
								<option>April 2017</option>
								<option>May 2017</option>
								<option>June 2017</option>
								<option>Quarter One 2017</option>
								<option>July 2017</option>
								<option>August 2017</option>
								<option>September 2017</option>
								<option>Quarter Two 2017</option>
								<option>October 2017</option>
								<option>November 2017</option>
								<option>December 2017</option>
								<option>Quarter Three 2017</option>
								<option>January 2018</option>
								<option>February 2018</option>
								<option>March 2018</option>
								<option>Quarter Four 2017</option>
								<option>Annual 2017 - 2018</option>
								<option>Bsc Submissions</option>
						</select></td>
						<td>Sub Department:</td>
						<td><select name="subDepartment"
							style="border: none; width: 100%">
								<option>Choose Sub-Department</option>
								<option>Account Management</option>
								<option>Administration</option>
								<option>Agribusiness</option>
								<option>Branch Network</option>
								<option>Business Intelligence</option>
								<option>Collections</option>
								<option>Corporate Business</option>
								<option>Credit</option>
								<option>Digital Banking</option>
								<option>Electronic Banking</option>
								<option>Finance</option>
								<option>Housing</option>
								<option>Human Resources</option>
								<option>Infrastructure</option>
								<option>Insurance Business</option>
								<option>Manzini</option>
								<option>Matata</option>
								<option>Matsapha</option>
								<option>Mbabane</option>
								<option>Motor Vehicle ( Auto-easy)</option>
								<option>Nhlangano</option>
								<option>Piggs Peak</option>
								<option>Projects and Governance</option>
								<option>Reviews</option>
								<option>Risk and Compliance</option>
								<option>Sales</option>
								<option>Securities</option>
								<option>Siphofaneni</option>
								<option>Simunye</option>
								<option>SMME</option>
								<option>Strategy</option>
								<option>Systems</option>
								<option>Treasury</option>
						</select></td>

					</tr>
					<tr>
					<tr>
						<td>Position:</td>
						<td><Select name="position" style="border: none; width: 100%">
								<c:forEach var="position" items="${positions}">
									<option value="${position}">${position}</option>
								</c:forEach>
						</Select></td>


						<td>Employee Name:</td>
						<td><Select name="bscEmployeeName"
							style="border: none; width: 100%">
								<c:forEach var="employee" items="${employees}">
									<option value="${employee}">${employee}</option>
								</c:forEach>
						</Select></td>


					</tr>


					<tr>
						<td></td>
						<td><input value="Search" type="Submit" size="50"></td>
						<td></td>
						<td><a
							href="${pageContext.request.contextPath}/BscReportsBusinessBanking">Clear
								Search</a></td>

					</tr>


				</table>

			</form>

			<br> <br>
			<h3>Performance: ${averageScore}%</h3>
			<br>

			<table class="table  table-striped table-hover table-bordered">


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