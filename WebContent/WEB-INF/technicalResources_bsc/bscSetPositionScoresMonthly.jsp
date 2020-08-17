<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Submit Scores</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


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
					<li><a href="${pageContext.request.contextPath}/BscPositions"
						class="list-group-item list-group-item-dark">Positions</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscPerspectives"
						class="list-group-item list-group-item-dark">Perspectives</a></li>
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
						class="list-group-item list-group-item-action active">Score
							Positions</a></li>
					<li><a href="${pageContext.request.contextPath}/BscLogin"
						class="list-group-item list-group-item-dark">Reports</a></li>

				</ol>
			</div>


			<div class="rightNav">
				<div class="container page-header" style="margin-bottom: 30px;">
					<h4>Balance Score Card- Submit Scores</h4>
				</div>

				<form action=BscPostScores method="post" class="form-inline">
					<div class="form-group">

						<table class="table-striped table-hover table-bordered"
							style="margin-bottom: 30px;">
							<tr>

								<td><span class="badge badge-warning form-control">Choose
										Employee</span></td>
								<td><select class="form-control" name="bscEmployeeName"
									required>
										<c:forEach var="employee" items="${employees}">
											<option value="${employee}">${employee}</option>
										</c:forEach>
								</Select></td>

							</tr>
							<tr>

								<td><span class="badge badge-warning form-control">Choose
										Supervisor</span></td>
								<td><Select class="form-control" name="bscEmployeeSupervisor" required>
										<c:forEach var="employee" items="${employees}">
											<option value="${employee}">${employee}</option>
										</c:forEach>
								</Select></td>

							</tr>
							<tr>
								<td><span class="badge badge-warning form-control">Employee
										Position</span></td>

								<td><input class="form-control" type="text" name="position" value="${position}"
									readonly style="border: none; width: 100%" /></td>
							</tr>

							<tr>
							<td><span class="badge badge-warning form-control">Employee
										Department</span></td>

								<td><input class="form-control" type="text" name="department"
									value="${department}" readonly
									style="border: none; width: 100%" /></td>
							</tr>

							<tr>
								<td><span class="badge badge-warning form-control form-control">Employee
										Department</span></td>

								<td><select class="form-control" name="subDepartment" required>
										<option></option>
										<option>Account Management</option>
										<option>Administration</option>
										<option>Agribusiness</option>
										<option>Branch Network</option>
										<option>Business Intelligence</option>
										<option>Call Center</option>
										<option>Collections</option>
										<option>Corporate Business</option>
										<option>Credit</option>
										<option>Digital Banking</option>
										<option>Electronic Banking</option>
										<option>Ezulwini Gables</option>
										<option>Finance</option>
										<option>Housing</option>
										<option>Human Resources</option>
										<option>Internal Audit</option>
										<option>Infrastructure</option>
										<option>Insurance Business</option>
										<option>Legal</option>
										<option>Manzini</option>
										<option>Manzini Cash Centre</option>
										<option>Matata</option>
										<option>Matsapha</option>
										<option>Mbabane</option>
										<option>Motor Vehicle ( Auto-easy)</option>
										<option>Nhlangano</option>
										<option>OPC Manzini</option>
										<option>Operations</option>
										<option>Piggs Peak</option>
										<option>Projects and Governance</option>
										<option>Reviews</option>
										<option>Risk and Compliance</option>
										<option>Sales and Marketing</option>
										<option>Securities</option>
										<option>Siphofaneni</option>
										<option>Simunye</option>
										<option>Siteki</option>
										<option>SMME</option>
										<option>Strategy</option>
										<option>Systems</option>
										<option>Treasury</option>
								</select></td>
							</tr>

							<tr>

								<td><span class="badge badge-warning form-control">Choose Bsc
										Period</span></td>
								<td><select name="bscPeriod" class="form-control" required>
										<option></option>
										<option>April 2018</option>
										<option>May 2018</option>
										<option>June 2018</option>
										<option>July 2018</option>
										<option>August 2018</option>
										<option>September 2018</option>
										<option>October 2018</option>
										<option>November 2018</option>
										<option>December 2018</option>
										<option>January 2019</option>
										<option>February 2019</option>
										<option>March 2019</option>
										<option>April 2019</option>
								</select></td>
							</tr>


						</table>


						<table class="table-striped table-hover table-bordered">

							<thead class="thead-dark">
								<tr>
									<th>Perspective</th>
									<th>Objective</th>
									<th>Period</th>
									<th>RF</th>
									<th>Measure</th>
									<th>base</th>
									<th>stretch</th>
									<th>Actuals</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="target" items="${targets}">
									<tr>
										<td><input type="text" name="perspective"
											value="${target.perspective}" readonly
											style="border: none; word-wrap: break-word; min-width: 200px; max-width: 200px;" /></td>
										<td><input type="text" name="objective"
											value="${target.objective}" readonly
											style="border: none; word-wrap: break-word; min-width: 300px; max-width: 300px;" /></td>
										<td><input type="text" name="period"
											value="${target.period}" readonly
											style="border: none; word-wrap: break-word; min-width: 90px; max-width: 90px;" /></td>
										<td><input type="text" name="reportingFrequency"
											value="${target.reportingFrequency}" readonly
											style="border: none; word-wrap: break-word; min-width: 100px; max-width: 100px;" /></td>
										<td><input type="text" name="measure"
											value="${target.measure}" readonly
											style="border: none; word-wrap: break-word; min-width: 500px; max-width: 500px;" /></td>
										<td><input type="number" name="base"
											value="${target.base}" readonly
											style="border: none; word-wrap: break-word; min-width: 80px; max-width: 75px;" /></td>
										<td><input type="number" name="stretch"
											value="${target.stretch}" readonly
											style="border: none; word-wrap: break-word; min-width: 80px; max-width: 75px;" /></td>
										<td><input type="number" name="actual" required
											step="0.01" class="two-decimals"
											style="border: none; word-wrap: break-word; min-width: 80px; max-width: 75px;" /></td>

									</tr>
								</c:forEach>

								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td><input value="Submit Scores" type="Submit"
										class="btn btn-primary btn-sm"></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>

						</table>

					</div>
				</form>
			</div>

		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>

	<script type="text/javascript">
		""
		$(".two-decimals").change(function() {
			this.value = parseFloat(this.value).toFixed(2);
		});
	</script>

</body>
</html>