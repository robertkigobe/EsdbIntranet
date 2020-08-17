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
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFirstAid"
						class="list-group-item list-group-item-dark ">HSE First Aid</a></li>
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFireMarshall"
						class="list-group-item list-group-item-dark ">HSE Fire Martial</a></li>
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionWellnessChampion"
						class="list-group-item list-group-item-dark active">HSE
							Wellness Champion</a></li>

					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionEnvironmental"
						class="list-group-item list-group-item-dark ">HSE
							Environmental</a></li>



				</Ol>


			</div>

			<div class="rightNav container-fluid">


				<h2>Peer Educator / Session Diary Company</h2>
				<div>
					<div>
						<form action="HealthSafetyNewInspectionWellnessChampion"
							method="POST">
							<div id="row" style="margin-bottom: 25px;" class="row ">

								<div class="col col-md-12">
									<label for="branchDivision">Branch / Division: </label> <select
										class="form-control col-md-12" name="branchDivision"
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
							</div>
							<div id="row" style="margin-bottom: 25px" class="row ">
								<div class="col col-md-6">
									<label for="peerEducator">Name Of Peer Educator: </label> <select
										name="peerEducator" class="form-control col-md-6" required>

										<option></option>
										<option>Robert Kigobe</option>
										<option>Banele Mabizela</option>

									</select>
								</div>
								<div class="col col-md-6">
									<label for="dateOfInspection">Date: </label> <input
										class="form-control col-md-6" name="dateOfInspection"
										value="${dateOfInspection}" type="date" readonly />
								</div>
							</div>
							<div id="row" style="margin-bottom: 25px;" class="row ">
								<div class="col col-md-6">
									<label for="facilitatedBy">Facilitated By: </label> <input
										class="form-control col-md-6" name="facilitatedBy" type="text"
										required />
								</div>
								<div class="col col-md-6">
									<label for="monitoredBy">Monitored By: </label> <input
										class="form-control col-md-6" name="monitoredBy" type="text"
										required />
								</div>
							</div>
							<div id="row" style="margin-bottom: 25px;" class="row ">
								<div class="col col-md-6">
									<label for="startTime">Start Time: </label> <input
										class="form-control col-md-6" name="startTime" type="time"
										required />
								</div>
								<div class="col col-md-6">
									<label for="endTime">End Time: </label> <input value="12:00AM"
										class="form-control col-md-6" name="endTime" type="time"
										required />
								</div>
							</div>
							<div id="row" style="margin-bottom: 25px;" class="row ">
								<div class="col col-md-12">
									<label for="topic">Topic: </label> <input
										class="form-control col-md-12" name="topic" type="text"
										required />
								</div>
							</div>
							<div id="row" style="margin-bottom: 25px;" class="row ">
								<div class="col col-md-3">
									<label for="numberOfParticipants">Total participants: </label>
									<input class="form-control col-md-4"
										name="numberOfParticipants" type="number" required />
								</div>
								<div class="col col-md-3">
									<label for="maleParticipants">Male participants: </label> <input
										class="form-control col-md-3" name="maleParticipants"
										type="number" required />
								</div>
								<div class="col col-md-3">
									<label for="femaleParticipants">Female participants: </label> <input
										class="form-control col-md-3" name="femaleParticipants"
										type="text" required />
								</div>
								<div class="col col-md-3">
									<label for="firstTimeParticipants">First-time
										participants: </label> <input class="form-control col-md-3"
										name="firstTimeParticipants" type="text" required />
								</div>
							</div>
							<div id="row" style="margin-bottom: 25px;" class="row ">
								<div class="col col-md-12">
									<label for="radioGroup">Method used:</label>
									<div class="radio" name="radioGroup">
										<label class="radio-inline"> <input type="radio"
											value="Pictures" name="methodUsed">Pictures
										</label> <label class="radio-inline"> <input value="Role Play"
											type="radio" name="methodUsed">Role Play
										</label> <label class="radio-inline"> <input type="radio"
											value="Video" name="methodUsed">Video
										</label> <label class="radio-inline"> <input
											value="Discussion" type="radio" name="methodUsed">Discussion
										</label> <label class="radio-inline"> <input type="radio"
											value="Guest Speaker" name="methodUsed">Guest Speaker
										</label> <label class="radio-inline"> <input type="radio"
											value="Condom Demonstration" name="methodUsed">Condom
											Demonstration
										</label>
									</div>
								</div>
							</div>
							<div id="row" style="margin-bottom: 25px;" class="row ">
								<div class="col col-md-12">
									<label for="questionAndConcerns">Key Questions and
										Concerns: </label>
									<textarea class="form-control" id="questionAndConcerns"
										name="questionAndConcerns"></textarea>
								</div>
							</div>
							<div id="row" style="margin-bottom: 25px;" class="row ">
								<div class="col col-md-6">
									<label for="condomsDistMales">Number of Condoms
										distributed to males: </label> <input class="form-control col-md-4"
										name="condomsDistMales" type="number" required />
								</div>
								<div class="col col-md-6">
									<label for="condomsDistFemales">Number of Condoms
										distributed to females: </label> <input class="form-control col-md-3"
										name="condomsDistFemales" type="number" required />
								</div>
							</div>
							<div id="row" style="margin-bottom: 25px;" class="row ">
								<div class="col col-md-6">
									<label for="vct_htc_referrals_males">Number of VCT/HTC
										referrals to males </label> <input class="form-control col-md-3"
										name="vct_htc_referrals_males" type="number" required />
								</div>
								<div class="col col-md-6">
									<label for="vct_htc_referrals_females">Number of
										VCT/HTC referrals to females </label> <input
										class="form-control col-md-3" name="vct_htc_referrals_females"
										type="number" required />
								</div>
							</div>
							<div>
								<button type="submit" class="btn btn-primary btn-lg btn-block"
									style="margin-top: 10px;">Submit</button>
							</div>
						</form>
					</div>



				</div>
			</div>
			<div class="clear"></div>

			<div>
				<jsp:include page="../utilities/_footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>