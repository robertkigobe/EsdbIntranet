<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bsc Delete</title>

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

					<li><a href="#" class="list-group-item list-group-item-action active">Delete Score Cards</a></li>
					<li><a href="${pageContext.request.contextPath}/BscLogin" class="list-group-item list-group-item-dark">Submission Report</a></li>				
					<li><a
						href="#" class="list-group-item list-group-item-dark">Update Score Cards</a></li>
					
					<li><a 	href="${pageContext.request.contextPath}/BscTargetRequest" class="list-group-item list-group-item-dark">Set Targets</a></li>
					<li><a 	href="${pageContext.request.contextPath}/BscScoreRequest" class="list-group-item list-group-item-dark">Score Positions</a></li>
					<li><a 	href="${pageContext.request.contextPath}/BscScoreRequest" class="list-group-item list-group-item-dark">Bsc Report</a></li>

				</ol>

			</div>


			<div class="rightNav">

				<div class="page-header">
					<h4>Balance ScoreCard Delete Request</h4>
					<br>
				</div>

				<form method="post" action="BscDelete" class="form col-md-5" 
					id="deleteEntry">
					
					<div class="form-group">
						<select name="bscEmployeeName" class="form-control">
							<c:forEach items="${bscEmployeeNames}" var="bscEmployeeNames">
								<option value="${bscEmployeeNames}">${bscEmployeeNames}
								</option>
							</c:forEach>
						</select>
					</div>
					
					
					<div class="form-group">
						<select name="bscEmployeeSupervisor" class="form-control">
							<c:forEach items="${bscEmployeeSupervisors}"
								var="bscEmployeeSupervisors">
								<option value="${bscEmployeeSupervisors}">${bscEmployeeSupervisors}
								</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<select name="subDepartment" class="form-control">
							<c:forEach items="${subDepartments}" var="subDepartments">
								<option value="${subDepartments}">${subDepartments}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<select name="position" class="form-control">
							<c:forEach items="${positions}" var="positions">
								<option value="${positions}">${positions}</option>
							</c:forEach>
						</select>
					</div>
					
					
					<div class="form-group">
						<select name="bscPeriod" class="form-control">
							<c:forEach items="${bscPeriods}" var="bscPeriods">
								<option value="${bscPeriods}">${bscPeriods}</option>
							</c:forEach>
						</select>
					</div>
					
					

					<div class="form-group">

						<button type="submit" class="btn btn-primary">Submit</button>
					</div>

				</form>
			</div>

		</div>

	</div>

	<div class="clear"></div>
	<div>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>

	<script>

	var form = document.getElementById('deleteEntry');
	form.onsubmit = function () {
    // this method is cancelled if window.confirm returns false
    	return window.confirm('Are you sure that you want to delete the entry? this action is irreversible.');
	}
		
	</script>

</body>
</html>