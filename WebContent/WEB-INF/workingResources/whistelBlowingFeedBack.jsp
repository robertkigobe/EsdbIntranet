<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Whistle Blowing Feedback</title>

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />


</head>
<body>
	<div class="container">
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

				<h4>Quick Links</h4>


				<ol>
					
					<li><a href="#">Feed Back to Risk</a></li>

				</ol>

			</div>
			<div class="rightNav">

				<h2>Whistle Blowing Platform</h2>

				<div>
					<form action="WhistelBlowingFeedBack" method="post">
						<h4>What is this about?: *</h4>
						<select name="aboutFeedBackSubject">
							<option>Choose Section</option>
							<option>Choose Branch</option>
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
							<option>Other Suggestions</option>


						</select>

						<h4>Message *:</h4>
						<textarea rows="10" cols="50" name="aboutFeedBackDetail"
							placeholder="SwaziBank values your efforts to eliminate any transgressions that may be committed by its employees. Please note that in line with the Whistle-Blowing Policy, your report will be treated with the confidentiality it deserves. Feel free to give us as much information as possible…"></textarea><br>

						<input value="Submit" type="Submit" size="50">

					</form>
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