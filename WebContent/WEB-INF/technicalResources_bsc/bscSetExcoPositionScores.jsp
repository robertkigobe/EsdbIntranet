<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Exco Scores</title>

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


				<form action=BscPostExcoScores method="post" class="form">

					<div class=" container page-header">
						<h4>Balance Score Card- Submit Department Scores</h4>
					</div>

					

						<table class="table-striped table-hover table-bordered"
							style="margin-bottom: 20px;">
							<thead class="thead-dark">
								<tr>
									<td>Position</td>
									<td>Department</td>
									<td>Score Period</td>
								</tr>
							</thead>
							<tbody>
								<tr>

									<td><input type="text" name="position" value="${position}"
										readonly
										style="border: none; word-wrap: break-word; min-width: 400px; max-width: 400px;" /></td>

									<td><input type="text" name="department"
										value="${department}" readonly
										style="border: none; word-wrap: break-word; min-width: 400px; max-width: 400px;" /></td>


									<td><input type="text" name="bscPeriod"
										value="${bscPeriod}" readonly
										style="border: none; word-wrap: break-word; min-width: 200px; max-width: 200px;" /></td>
								</tr>

							</tbody>


						</table>


						<table class="table-striped table-hover table-bordered">

							<thead class="thead-dark">
								<tr>
									<th>Perspective</th>
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

										<td><input type="text" name="period"
											value="${target.period}" readonly
											style="border: none; word-wrap: break-word; min-width: 100px; max-width: 100px;" /></td>
										<td><input type="text" name="reportingFrequency"
											value="${target.reportingFrequency}" readonly
											style="border: none; word-wrap: break-word; min-width: 100px; max-width: 100px;" /></td>
										<td><input type="text" name="measure"
											value="${target.measure}" readonly
											style="border: none; word-wrap: break-word; min-width: 600px; max-width: 600px;" /></td>
										<td><input type="number" name="base"
											value="${target.base}" readonly
											style="border: none; word-wrap: break-word; min-width: 80px; max-width: 80px;" /></td>
										<td><input type="number" name="stretch"
											value="${target.stretch}" readonly
											style="border: none; word-wrap: break-word; min-width: 80px; max-width: 80px;" /></td>
										<td><input type="number" name="actual" required
											step="0.01" class="two-decimals"
											style="border: none; word-wrap: break-word; min-width: 80px; max-width: 80px;" /></td>
											<td><input type="text" name="objective"
											value="${target.objective}" readonly
											style="border: none; word-wrap: break-word; min-width: 0px; max-width: 0px;" /></td>
											
									</tr>
								</c:forEach>

								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td><input value="Submit Department Scores" type="Submit"
										class="btn btn-primary btn-sm"></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>

						</table>

					
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