<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="css/issueStyle.css" rel="stylesheet" type="text/css" />
<title>New Issue</title>
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
				<h2>Quick Links:</h2>

				<ol class="list-group">
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFirstAid"
						class="list-group-item list-group-item-dark active">HSE First
							Aid</a></li>
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFireMarshall"
						class="list-group-item list-group-item-dark ">HSE Fire Martial</a></li>
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionWellnessChampion"
						class="list-group-item list-group-item-dark ">HSE Wellness
							Champion</a></li>

					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionEnvironmental"
						class="list-group-item list-group-item-dark ">HSE
							Environmental</a></li>

				</Ol>



			</div>
			<div class="rightNav">

				<h2>Environmental Health and Safety Inspection Register</h2>
				<h4>Inspection record for office environment</h4>

				<form action="HealthSafetyNewInspectionFirstAid" method="POST">
					<div id="row" class="row ">

						<div class="col col-md-4">
							<label for="branchDivision">Branch / Division: </label> <select
								class="form-control col-md-3" name="branchDivision"
								value="Branch" required>

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
						<div class="col col-md-4">
							<label for="dateOfInspection">Date: </label> <input
								class="form-control col-md-4" value="${dateOfInspection}"
								name="dateOfInspection" type="date" readonly />
						</div>
						<div class="col col-md-4">
							<label for="firstAider">First Aider: </label> <input type="text"
								name="firstAider" class="form-control" required>
						</div>
					</div>
					<div id="row" style="margin-top: 10px" class="row">
						<div class="col col-md-12">
							<table class="table table-hover table-bordered ">
								<thead>
									<tr>

										<th style="width: 10%">No.</th>
										<th style="width: 33%">Item</th>
										<th style="width: 12%">Record</th>
										<th style="width: 34%">Deviations/Comments</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="it" items="${items}" varStatus="status">
										<tr>

											<td><input type="text" value="${it.itemNo }"
												class="form-control" name="itemNo${status.index }"
												style="border: none;" readonly /></td>


											<td><textarea class="form-control" rows="2"
													stle="font-size: 15px;" name="" id="comment" readonly>${it.itemDesc }</textarea>
											</td>
											</td>
											<td><select name="record${status.index }"
												class="form-control" style="border: none; width: 100%"
												required>
													<option></option>
													<option>Yes</option>
													<option>No</option>
											</select></td>

											<td><textarea class="form-control" rows="2"
													name="comment${status.index}" id="comment"></textarea></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div id="row" style="margin-top: 10px" class="row">

						<div class="col col-md-8">
							<label for="firstAiderComment">First Aider Comments: </label>
							<textarea class="form-control" id="firstAiderComment"
								name="firstAiderComment"></textarea>
						</div>
						<div class="col col-md-4">
							<label for="dateOffirstAiderComment">Date: </label> <input
								type="date" value="${dateOffirstAiderComment}"
								class="form-control input-lg" id="dateOffirstAiderComment"
								name="dateOffirstAiderComment" />
						</div>
					</div>
					<div id="row" style="margin-top: 10px" class="row">

						<div class="col col-md-8">
							<label for="managerComment">Manager's Comments: </label>
							<textarea class="form-control" id="fireMarshallComment"
								name="managerComment"></textarea>
						</div>
						<div class="col col-md-4">
							<label for="dateOfManagerComment">Date: </label> <input
								type="date" value="${dateOfManagerComment}"
								class="form-control input-lg" id="fireMarshallCommentDate"
								name="dateOfManagerComment" />
						</div>
					</div>
					<div style="margin-top: 10px" id="row" class="row">

						<div class="col col-md-8">
							<label for="wellnessCoordinatorComment">Wellness
								Coordinator Comments: </label>
							<textarea class="form-control" id="wellnessCoordinatorComment"
								name="wellnessCoordinatorComment"></textarea>
						</div>
						<div class="col col-md-4">
							<label for="dateOfwellnessCoordinatorComment">Date: </label> <input
								type="date" value="${dateOfwellnessCoordinatorComment}"
								class="form-control input-lg"
								id="dateOfwellnessCoordinatorComment"
								name="dateOfwellnessCoordinatorComment" />
						</div>
					</div>
					<div>
						<button type="submit" class="btn btn-primary btn-lg btn-block"
							style="margin-top: 10px;">Submit</button>
					</div>
				</form>
			</div>

			<div>
				<jsp:include page="../utilities/_footer.jsp"></jsp:include>
			</div>
		</div>
</body>
</html>
