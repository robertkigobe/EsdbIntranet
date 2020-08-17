<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/HomeStyle.css" rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Health and Safety Home</title>
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
				<h2>Quick Links:</h2>

				<ol class="list-group">


					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyViewInspectionFirstAid"
						class="list-group-item list-group-item-dark ">View HSE First
							Aid submissions</a></li>
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyViewInspectionFireMarshall"
						class="list-group-item list-group-item-dark">View HSE Fire
							Martial submissions</a></li>
					<li><a style="font-size: 12px;"
						href="${pageContext.request.contextPath}/HealthSafetyViewInspectionWellnessChampion"
						class="list-group-item list-group-item-dark ">View HSE
							Wellness Champion submissions</a></li>

					<li><a style="font-size: 14px;"
						href="${pageContext.request.contextPath}/HealthSafetyViewInspectionEnvironmental"
						class="list-group-item list-group-item-dark ">View HSE
							Environmental Submissions</a></li>

					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyAdminNewInspection"
						class="list-group-item list-group-item-dark active">HSE
							Inspection Register </a></li>



				</Ol>


			</div>
			<div class="rightNav container-fluid">


				<h2>News</h2>
				<form action="HealthSafetyAdminNewInspection" method="POST">
					<div id="row" class="row ">

						<div class="col col-md-6">
							<label for="dateOfInspection">Date: </label> <input
								class="form-control col-md-12" value="${dateOfInspection}"
								name="dateOfInspection" type="date" readonly />
						</div>
						<div class="col col-md-6">
							<label for="dueDateOfInspection"> Due Date: </label> <input
								class="form-control col-md-12"
								"
								name="dueDateOfInspection" type="date" required />
						</div>
					</div>
					<div id="row" class="row ">
						<div class="col col-md-3">
							<label for="branchDivision">Branch: </label> <select
								class="form-control col-md-3" name="branchDivision" required>
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
								<option>Infrastructure</option>
								<option>Internal Audit</option>
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

							</select>
						</div>
						<div class="col col-md-3">
							<label for="building">Building: </label> <input
								class="form-control col-md-3" name="building" type="text" />
						</div>

						<div class="col col-md-3">
							<label for="floor">Floor: </label> <input
								class="form-control col-md-3" name="floorArea" type="text" />
						</div>
						<div class="col col-md-3">
							<label for="office">Office: </label> <input
								class="form-control col-md-3" name="office" type="text" />
						</div>

					</div>
					<div id="row" class="row ">
						<div class="col col-md-12">
							<label for="deviations">Deviations: </label>
							<textarea class="form-control" id="deviations" name="deviations"></textarea>
						</div>
					</div>
					<div id="row" class="row ">
						<div class="col col-md-12">
							<label for="justifications">Justifications: </label>
							<textarea class="form-control" id="justifications"
								name="justifications"></textarea>
						</div>
					</div>
					<div id="row" class="row ">
						<div class="col col-md-12">
							<label for="personResponsible">Person Responsible: </label> <input
								class="form-control col-md-12" name="personResponsible"
								type="text" />
						</div>
					</div>
					<div>
						<button type="submit" class="btn btn-primary btn-lg btn-block"
							id="submit"
							style="margin-top: 10px;">Submit</button>
					</div>

				</form>




			</div>
		</div>
		<div class="clear"></div>

		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
</body>
</html>