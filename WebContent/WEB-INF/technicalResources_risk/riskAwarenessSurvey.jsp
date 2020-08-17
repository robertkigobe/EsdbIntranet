<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risk Awareness Survey</title>
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

				<ol class="list-group">

					<li class="list-group-item">
						<h4>Quick Links</h4>
					</li>
					<li><a
						href="${pageContext.request.contextPath}/RiskAwarenessSurvey"
						class="list-group-item list-group-item-action active">Start
							Survey</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Anti
							Money Laundering Test</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Risk
							Management Test</a></li>
							<li><a href="#" class="list-group-item list-group-item-dark">Risk	Management Test</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Publications</a></li>
					<li><a href="${pageContext.request.contextPath}/Home"
						class="list-group-item list-group-item-dark">SwaziBank Home</a></li>
				</ol>

			</div>



			<div class="rightNav">
				<div class="page-header">
					<h3>Risk Awareness Survey</h3>
					<div>

						<form action="RiskAwarenessSurvey" method="post" class="form">



							<div class="form-group" style="border:1px solid black">
								<label>Employee Name:</label> <Select name="employeeName">
									<c:forEach var="employees" items="${employees}">
										<option value="${employees}">${employees}</option>
									</c:forEach>
								</Select>   <label>Sub Department:</label> <select
									name="subDepartment">
									<option>Choose Branch</option>
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





							<div class="form-group">

								<label for="q1" class="form-control">1. Would you say
									Risk Management is a management concern or everyones concern?</label>
								<div class="radio">
									<label><input type="radio" name="q1" value="1">Management</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q1" value="2">Every
										one</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q1" value="1" required>Not
										Sure</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q2" class="form-control">2. To what extent
									do you think the Bank is exposed to risks?</label>
								<div class="radio">
									<label><input type="radio" name="q2" value="0" required>None</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q2" value="1">Low</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q2" value="2">Medium</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q2" value="3">High</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q2" value="3">Very
										High</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q3" class="form-control">3. Would you say RM
									is integrated into the Bank's operations or it is in isolation?</label>
								<div class="radio">
									<label><input type="radio" name="q3" value="1" required>Fully
										Integrated</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q3" value="2">Some
										Integration</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q3" value="0">Isolated</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q4" class="form-control">4. Would you be
									able to identify risks in your line of work?</label>
								<div class="radio">
									<label><input type="radio" name="q4" value="1" required>Yes</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q4" value="0">No</label>
								</div>
							</div>
							<div class="form-group">

								<label for="q5" class="form-control">5. Do you feel you
									have the right capacity to identify risks in your line of work?
								</label>
								<div class="radio">
									<label><input type="radio" name="q5" value="0" required>None</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q5" value="1">Low</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q5" value="2">Medium</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q5" value="3">High</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q5" value="4">Very
										High</label>
								</div>
							</div>
							<div class="form-group">

								<label for="q6" class="form-control">6. Do you currently
									know a way by which you can report risks when identified? </label>
								<div class="radio">
									<label><input type="radio" name="q6" value="1" required>Yes</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q6" value="0">No</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q7" class="form-control">7. Would you say
									that your job interrelates with other functions or is it in
									silos? </label>
								<div class="radio">
									<label><input type="radio" name="q7" value="1" required>Interrelates</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q7" value="0">Silos</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q8" class="form-control">8. Do you feel you
									can openly communicate risks you have identified in your line
									of work? </label>
								<div class="radio">
									<label><input type="radio" name="q8" value="3" required>Strongly
										agree</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q8" value="2">agree</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q8" value="1">Disagree</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q8" value="0">Strongly
										Disagree</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q9" class="form-control">9. Would you say
									that the Bank openly communicates risks and risk management
									issues ? </label>
								<div class="radio">
									<label><input type="radio" name="q9" value="3" required>Strongly
										agree</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q9" value="2">agree</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q9" value="1">Disagree</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q9" value="0">Strongly
										Disagree</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q10" class="form-control">10. Have you had
									any risk management training or presentation? </label>
								<div class="radio">
									<label><input type="radio" name="q10" value="2" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q10" value="0">Not
										Sure</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q10" value="1">No</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q11" class="form-control">11. Would you be
									interested in one? </label>
								<div class="radio">
									<label><input type="radio" name="q11" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q11" value="0">No</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q12" class="form-control">12. Are you aware
									of the functions of the Risk and Compliance Department? </label>
								<div class="radio">
									<label><input type="radio" name="q12" value="2" required>Fully
										Aware </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q12" value="1">Some
										Idea</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q12" value="0">No
										Idea</label>
								</div>

							</div>
							
							<div class="form-group">

								<label for="q13" class="form-control">13. Are you aware
									of any policies and procedures that you have to follow in your
									line of work? </label>
								<div class="radio">
									<label><input type="radio" name="q13" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q13" value="0">No
									</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q14" class="form-control">14. Have you ever
									signed on your unit's policies and procedures after you read
									them? </label>
								<div class="radio">
									<label><input type="radio" name="q14" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q14" value="0">No
									</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q15" class="form-control">15. Do You know
									anything about Internal Controls? </label>
								<div class="radio">
									<label><input type="radio" name="q15" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q15" value="0">No
									</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q16" class="form-control">16. Do you think
									the Bank has enough Controls to minimize Risk Exposures? </label>
								<div class="radio">
									<label><input type="radio" name="q16" value="2" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q16" value="0">Not
										Sure </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q16" value="1">No
									</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q17" class="form-control">17. Do you
									understand anything about Key Risk Indicators (KRIs) ? </label>
								<div class="radio">
									<label><input type="radio" name="q17" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q17" value="0">No
									</label>
								</div>

							</div>
							
							<div class="form-group">

								<label for="q18" class="form-control">18. Have you ever
									heard of a Business Continuity Plan (BCP) ? </label>
								<div class="radio">
									<label><input type="radio" name="q18" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q18" value="0">No
									</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q19" class="form-control">19. Do you know if
									your department or business unit has formulated a BCP? </label>
								<div class="radio">
									<label><input type="radio" name="q19" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q19" value="0">No
									</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q20" class="form-control">20. Have you ever
									heard of a Risk Assessment in your department? </label>
								<div class="radio">
									<label><input type="radio" name="q20" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q20" value="0">No
									</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q21" class="form-control">21. Do you
									understand the term "Near Miss Reporting"? </label>
								<div class="radio">
									<label><input type="radio" name="q21" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q21" value="0">No
									</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q22" class="form-control">22. Do you
									understand the Term Operational Risk Incident?</label>
								<div class="radio">
									<label><input type="radio" name="q22" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q22" value="0">No
									</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q23" class="form-control">23. In your
									opinion, does the Bank encourage the minimization of Risk
									Exposures? </label>
								<div class="radio">
									<label><input type="radio" name="q23" value="3" required>Strongly
										agree</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q23" value="2">agree</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q23" value="1">Disagree</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q23" value="0">Strongly
										Disagree</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q24" class="form-control">24. What would you
									say is the biggest cause for risks in the Bank? </label>
								<div class="radio">
									<label><input type="radio" name="q24" value="3" required>People</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q24" value="2">Culture</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q24" value="3">Systems</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q24" value="2">Processes</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q24" value="1">External
										environment</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q25" class="form-control">25. Have you ever
									reported any Risks spotted in your line of work?</label>
								<div class="radio">
									<label><input type="radio" name="q25" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q25" value="0">No
									</label>
								</div>

							</div>
							
							<div class="form-group">

								<label for="q26" class="form-control">26. Do you receive
									feedback on reported Risks?</label>
								<div class="radio">
									<label><input type="radio" name="q26" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q26" value="0">Not
										Sure </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q26" value="2">No
									</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q27" class="form-control">27. Do you
									understand credit risk?</label>
								<div class="radio">
									<label><input type="radio" name="q27" value="2" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q27" value="1">Some
										Idea </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q27" value="0">No
									</label>
								</div>

							</div>
							
							<div class="form-group">

								<label for="q28" class="form-control">28. Is your
									business unit exposed to credit risk? </label>
								<div class="radio">
									<label><input type="radio" name="q28" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q28" value="0">Not
										Sure </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q28" value="1">No
									</label>
								</div>

							</div>
							
							<div class="form-group">

								<label for="q29" class="form-control">29. Would you say
									credit risk is the major risk faced by the Bank? </label>
								<div class="radio">
									<label><input type="radio" name="q29" value="2" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q29" value="0">Not
										Sure </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q29" value="1">No
									</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q30" class="form-control">30. Would you say
									credit risk is well managed by the Bank? </label>
								<div class="radio">
									<label><input type="radio" name="q30" value="2" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q30" value="1">Not
										Sure </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q30" value="0">No
									</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q31" class="form-control">31. Do you
									understand liquidity risk? </label>
								<div class="radio">
									<label><input type="radio" name="q31" value="2" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q31" value="1">Some
										Idea </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q31" value="0">No
									</label>
								</div>

							</div>
							
							<div class="form-group">

								<label for="q32" class="form-control">32. Would you say
									liquidity risk is well managed by the Bank? </label>
								<div class="radio">
									<label><input type="radio" name="q32" value="1" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q32" value="0">Not
										Sure </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q32" value="1">No
									</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q33" class="form-control">33. Which of the
									following market risk factors do not apply to the Bank? </label>
								<div class="radio">
									<label><input type="radio" name="q33" value="0" required>Intrest
										rate risk </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q33" value="1">Foreign
										exchange risk </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q33" value="1">Equity
										prices </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q33" value="1">Foreign
										exchange risk and Equity prices </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q33" value="2">Equity
										prices </label>
								</div>

							</div>

							<div class="form-group">

								<label for="q34" class="form-control">34. Do you
									understand how interest rate volatility can be a threat to the
									Bank's profitability? </label>
								<div class="radio">
									<label><input type="radio" name="q34" value="2" required>Yes
									</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q34" value="1">Some
										Idea </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q34" value="0">No
									</label>
								</div>

							</div>
							<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
					</div>
				</div>

			</div>
		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
</body>
</html>