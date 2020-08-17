<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="css/issueStyle.css" rel="stylesheet" type="text/css" />
<title>New Issue</title>
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

				<Ol>


					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFirstAid"
						class="list-group-item list-group-item-dark active">HSE First
							Aid</a></li>
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFirstAid"
						class="list-group-item list-group-item-dark active">HSE Fire
							Martial</a></li>
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFirstAid"
						class="list-group-item list-group-item-dark active">HSE
							Wellness Champion</a></li>

					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFirstAid"
						class="list-group-item list-group-item-dark active">HSE
							Environmental</a></li>

					<li><a href="#">Upload HSE Articles</a></li>


					<li><a href="#">Communicate with HR</a></li>

				</Ol>


			</div>

			<div class="rightNav">

				<div>
					<h2>Environmental Health and Safety Inspection Register</h2>

					<div>
						<form action="HealthSafetyNewInspectionFirstAid" method="POST">

							<input type="text" value="Branch/Division" style="border: none;" />
							<select name="financialYear" value="Branch"
								style="border: dotted;" required>

								<option></option>
								<option>Mbabane HQ</option>
								<option>Mbabane Commercial</option>

							</select> <input type="text" value="Name of First Aider"
								style="border: none;" /> <select name="financialYear"
								value="Branch" style="border: dotted;" required>

								<option></option>
								<option>Robert Kigobe</option>
								<option>Banele Mabizela</option>

							</select> <input type="text" value="Date of Inspection:"
								style="border: none;" /> <input type="date" value="yyyy/mm/dd"
								style="border: line;" required />

							<table class="table table-striped table-hover table-bordered">
								<thead>
									<tr>
										<th style="width: 5%">No.</th>
										<th style="width: 25%">Item</th>
										<th style="width: 10%">Record</th>
										<th style="width: 50%">Comments</th>
									</tr>
								</thead>
								<tbody>

									<tr>
										<td><input type="text" value="1.1" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="First-aid official trained?"
											style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>
									<tr>
										<td><input type="text" value="1.2" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="Treatment register provided and used?"
											style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>


									<tr>
										<td><input type="text" value="1.3" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="Is the contents checked regularly?"
											style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>
									<tr>
										<td><input type="text" value="1.4" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="Correct signs displayed?"
											style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>
									<tr>
										<td><input type="text" value="1.5" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="Is there any medication in the first aid box?"
											style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>
									<tr>
										<td><input type="text" value="1.6" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="Is there equipment in the first aid box to ensure that medical waste can be safely disposed of? (i.e. rubber gloves, plastic seal bag?"
											style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>
									<tr>
										<td><input type="text" value="1.7" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="Are all incidents (work related injuries) reported by staff?"
											style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>
									<tr>
										<td><input type="text" value="1.8" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="Is action taken; investigated & recorded?"
											style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>
									<tr>
										<td><input type="text" value="1.9" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="Are all incidents that could lead to pollution of air, ground or water, reported?"
											style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>
									<tr>
										<td><input type="text" value="1.10" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="All accidents discussed with staff?"
											style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>
									<tr>
										<td><input type="text" value="1.11" style="border: none;" /></td>
										<td><input type="text" name="auditCode"
											value="Records kept?" style="border: none; width: 100%" /></td>
										<td><select name="financialYear"
											style="border: none; width: 100%" required>

												<option></option>
												<option>Yes</option>
												<option>No</option>

										</select></td>
										<td><input type="text" value=""
											style="border: none; width: 100%" required /></td>
									</tr>





								</tbody>
							</table>

							<div>
						<button type="submit" class="btn btn-primary btn-lg btn-block" style="margin-top: 10px;">Submit</button>
							</div>
						</form>
					</div>

				</div>
			</div>
			</div>
			<footer>
				<jsp:include page="../utilities/_footer.jsp"></jsp:include>
			</footer>
	</div>

</body>
</html>
