<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risk Management Test</title>
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
						href="${pageContext.request.contextPath}/RiskAwarenessSurveyHomePage"
						class="list-group-item list-group-item-dark">Risk Awareness
							Survey</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Anti
							Money Laundering Test</a></li>
					<li><a
						href="${pageContext.request.contextPath}/WhistelBlowingFeedBack"
						class="list-group-item list-group-item-dark">whistle Blowing
							Platform</a></li>
					<li><a href="${pageContext.request.contextPath}/Home"
						class="list-group-item list-group-item-dark">SwaziBank Home</a></li>
				</ol>

			</div>



			<div class="rightNav">
				<div class="page-header">
					<h3>Risk Management Test 2018</h3>
					<div>

						<form action="RiskManagementTest" method="post" class="form">



							<div class="form-group" style="border: 1px solid black">
								<label>Employee Name:</label> <Select name="employeeName">
									<c:forEach var="employees" items="${employees}">
										<option value="${employees}">${employees}</option>
									</c:forEach>
								</Select> <label>Sub Department:</label> <select name="subDepartment">
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

								<label for="q1" class="form-control">1. The following
									BEST describes enterprise risk management:</label>
								<div class="radio">
									<label><input type="radio" name="q1" value="0" required>The
										identification, assessment, and Prioritization of risks
										followed by coordinated and economical application of
										resources to minimize, monitor, and control the probability
										and/or impact of unfortunate events</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q1" value="0">Anything
										that may affect the achievement of an organization's
										objectives. </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q1" value="2.5"
										required>A process, effected by an entity's board of
										directors, management, and other personnel, applied in
										strategy setting and across the enterprise, designed to
										identify potential events that may affect the entity, and
										manage risk to be within its risk appetite, to provide
										reasonable assurance regarding the achievement of entity
										objectives</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q1" value="0">It
										is the uncertainty that surrounds future events and outcomes</label>
								</div>

							</div>


							<div class="form-group">

								<label for="q2" class="form-control">2. Which one of the
									following is not a definition of a Risk? </label>
								<div class="radio">
									<label><input type="radio" name="q2" value="0" required>A
										risk is anything that may affect the achievement of an
										organization’s objectives.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q2" value="0">It
										is the uncertainty that surrounds future events and outcomes.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q2" value="2.5">Risk
										is the identification, assessment, and Prioritization of risks
										followed by coordinated and economical application of
										resources to minimize, monitor, and control the probability
										and/or impact of unfortunate events.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q2" value="0">None
										of the above.</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q3" class="form-control">3. Which of the
									following is closely linked to risk acceptance? </label>
								<div class="radio">
									<label><input type="radio" name="q3" value="0" required>Risk
										detection</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q3" value="0">Risk
										prevention</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q3" value="2.5">Risk
										tolerance</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q3" value="0">Risk
										correction</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q4" class="form-control">4. Which of the
									following risk concepts can be assumed to have no mitigating
									controls? </label>
								<div class="radio">
									<label><input type="radio" name="q4" value="0" required>Business
										risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q4" value="0">Residual
										risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q4" value="2.5">Inherent
										risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q4" value="0">Current
										risk</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q5" class="form-control">5. The ISO 3100
									Risk Management Process consists of the following;</label>
								<div class="radio">
									<label><input type="radio" name="q5" value="0" required>Identify,
										Assess, Respond and Monitor</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q5" value="0">Identify,
										Respond, Assess and Monitor</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q5" value="0">Identify,
										Assess, Report and Monitor</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q5" value="2.5">Establish
										context, Identify, Analyse, Evaluate and Treat </label>
								</div>

							</div>



							<div class="form-group">

								<label for="q6" class="form-control">6. The following
									are the responses to risk;</label>
								<div class="radio">
									<label><input type="radio" name="q6" value="2.5" required>Tolerate,
										treat, transfer, and terminate</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q6" value="0">Terminate,
										transfer, tolerate, report</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q6" value="0">Tolerate,
										treat, transfer, categorize</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q6" value="0">None
										of the above.</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q7" class="form-control">7. Who is
									responsible for risk management in the Bank?</label>
								<div class="radio">
									<label><input type="radio" name="q7" value="0" required>The
										board</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q7" value="0">All
										employees</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q7" value="0">Management</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q7" value="2.5">All
										of the Above</label>
								</div>

							</div>
							<div class="form-group">

								<label for="q8" class="form-control">8. The following
									are benefits of effective risk management;</label>
								<div class="radio">
									<label><input type="radio" name="q8" value="0" required>Better
										able to take advantage of new business opportunities</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q8" value="0">Reduction
										in management time spent “fire-fighting”</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q8" value="0">Gives
										the organisation a competitive advantage</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q8" value="2.5">All
										of the above</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q6" class="form-control">9. Operational risk
									is defined as </label>
								<div class="radio">
									<label><input type="radio" name="q9" value="2.5" required>the
										risk of loss resulting from inadequate or failed internal
										processes, people and systems or from external events.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q9" value="0">the
										risk of loss resulting from the failure of the Bank's
										borrowers and other counterparties to fulfil their contractual
										obligations and that collateral provided does not cover the
										Bank's claims.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q9" value="0">the
										failure to recognize or address changes in market conditions
										that affect the ability to liquidate assets quickly and with
										minimal loss in value.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q9" value="0">None
										of the above.</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q10" class="form-control">10. The following
									are categories of operational risk except</label>
								<div class="radio">
									<label><input type="radio" name="q10" value="0" required>Human
										capital risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q10" value="0">Technology
										risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q10" value="0">Fraud
										Risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q10" value="2.5">Liquidity
										risk</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q11" class="form-control">11. Credit risk is
									defined as </label>
								<div class="radio">
									<label><input type="radio" name="q11" value="0" required>the
										risk of loss resulting from inadequate or failed internal
										processes, people and systems or from external events.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q11" value="2.5">the
										risk of loss resulting from the failure of the Bank's
										borrowers and other counterparties to fulfil their contractual
										obligations and that collateral provided does not cover the
										Bank's claims.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q11" value="0">the
										failure to recognize or address changes in market conditions
										that affect the ability to liquidate assets quickly and with
										minimal loss in value.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q11" value="0">None
										of the above.</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q12" class="form-control">12. Pressure to
									commit fraud may be caused by;</label>
								<div class="radio">
									<label><input type="radio" name="q12" value="0" required>inability
										to pay bills</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q12" value="0">desire
										for status symbols (bigger house, new car)</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q12" value="2.5">both
										A and B</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q12" value="0">None
										of the above</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q13" class="form-control">13. The following
									are the early warning signs of liquidity </label>
								<div class="radio">
									<label><input type="radio" name="q13" value="0" required>Rising
										funding costs</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q13" value="0">Reductions
										in availability of long-term funding</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q13" value="0">Decreases
										in credit lines by correspondent banks</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q13" value="2.5">All
										of the above</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q14" class="form-control">14. The most
									common market risk factors are</label>
								<div class="radio">
									<label><input type="radio" name="q14" value="0" required>interest
										rates</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q14" value="0">foreign
										exchange rates</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q14" value="0">equity
										prices</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q14" value="2.5">All
										of the above</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q15" class="form-control">15. Which of the
									following risks can trigger liquidity risk? </label>
								<div class="radio">
									<label><input type="radio" name="q15" value="0" required>Credit
										Risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q15" value="0">Operational
										Risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q15" value="0">Reputational
										Risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q15" value="2.5">All
										of the above</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q16" class="form-control">16. Foreign
									Exchange Risk is </label>
								<div class="radio">
									<label><input type="radio" name="q16" value="2.5" required>The
										potential that movements in exchange rates may adversely
										affect the value of an institution's holding, and, thus its
										financial condition. </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q16" value="0">risk
										that the counterparty to a transaction could default before
										the final settlement of the transaction's cash flows. </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q16" value="0">The
										potential for adverse changes in the value of an institution's
										commodity related holdings. </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q16" value="0">The
										current and prospective potential for loss to an institution
										arising from its inability to meet its obligations or to fund
										increases in assets as they fall due without incurring
										unacceptable cost or losses. </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q16" value="0">Foreign
										exchange risk</label>
								</div>

							</div>



							<div class="form-group">

								<label for="q17" class="form-control">17. The following
									are Cressey's fraud factors;</label>
								<div class="radio">
									<label><input type="radio" name="q17" value="0" required>Pressure,
										rationalisation, and peer pressure</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q17" value="2.5">Opportunity,
										rationalisation, and pressure</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q17" value="0">Rationalisation,
										opportunity, and ability</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q17" value="0">None
										of the above</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q18" class="form-control">18. The following
									are examples of opportunities to commit fraud except;</label>
								<div class="radio">
									<label><input type="radio" name="q18" value="0" required>Absence
										of internal controls</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q18" value="0">Inefficient
										internal controls</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q18" value="2.5">Inability
										to pay bills</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q18" value="0">Perceived
										low risk of getting caught</label>
								</div>


							</div>
							<div class="form-group">

								<label for="q19" class="form-control">19. Pressure to
									commit fraud may be caused by;</label>
								<div class="radio">
									<label><input type="radio" name="q19" value="0">inability
										to pay bills</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q19" value="0">desire
										for status symbols (bigger house, new car)</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q19" value="2.5" required>both
										A and B</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q19" value="0">None
										of the above</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q20" class="form-control">20. An
									organisation is exposed to internal fraud when;</label>
								<div class="radio">
									<label><input type="radio" name="q20" value="0">There
										is lack of internal controls</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q20" value="0">There
										are vigilant supervisors</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q20" value="0">There
										is ability to override existing internal controls</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q20" value="2.5" required>Both
										A and C.</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q21" class="form-control">21. Due Diligence
									is;</label>
								<div class="radio">
									<label><input type="radio" name="q21" value="0">Obtaining
										a customer's identity document at account opening stage</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q21" value="2.5" required>Investigation,
										examination, research of a business or person prior to signing
										a contract.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q21" value="0">Attaching
										all necessary documents in the customer file.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q21" value="0">None
										of the above</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q22" class="form-control">22. Fraud can be
									detected through;</label>
								<div class="radio">
									<label><input type="radio" name="q22" value="0">Whistle-Blowing</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q22" value="0" required>Internal
										Audit Activities</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q22" value="0">Management
										Review</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q22" value="2.5">All
										of the above.</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q23" class="form-control">23. In your line
									of work, you would make a recommendation that requires the risk
									management activity to focus on areas consisting of which of
									the following?</label>
								<div class="radio">
									<label><input type="radio" name="q23" value="2.5" required>High
										inherent risk and high residual risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q23" value="0">High
										audit risk and high current risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q23" value="0">Low
										inherent risk and low residual risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q23" value="0">Low
										inherent risk and high residual risk</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q24" class="form-control">24. Under
									operational risk, red flags are conditions that indicate a
									higher likelihood of fraud. Which of the following would not be
									considered a red flag? </label>
								<div class="radio">
									<label><input type="radio" name="q24" value="2.5" required>Management
										has delegated the authority to make payments under a certain
										limit to subordinates.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q24" value="0">An
										individual has held the same cash-handling job for an extended
										period without any rotation of duties.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q24" value="0">An
										individual handling loan application is responsible for making
										collection of application information, writing a loan
										appraisal, reviewing the loan appraisal, and authorize
										disbursements on the same loan application.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q24" value="0">The
										assignment of responsibility and accountability in the credit
										department is not clear.</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q2" class="form-control">25. Red flags
									indicating that someone may be involved in fraudulent
									activities include;</label>
								<div class="radio">
									<label><input type="radio" name="q25" value="0">living
										beyond means</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q25" value="0">unusually
										close association with a vendor or customer</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q25" value="0">financial difficulties</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q25" value="2.5" required>All
										of the above</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q26" class="form-control">26. The following
									describes the roles and responsibilities of a Risk Champion,
									EXCEPT:</label>
								<div class="radio">
									<label><input type="radio" name="q26" value="0" required>Accountable
										for ensuring accuracy within their department or business unit
										around the identification, assessment, management and
										monitoring of risk</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q26" value="0">They
										are the eyes and ears of risk information for the risk manager
										who is in charge of assessing risk across the enterprise</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q26" value="0">Sensitize
										staff on risk management issues within their business units</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q26" value="2.5">Responsible
										for performing the actual risk management activities</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q27" class="form-control">27. The following
									should be avoided when considering risks</label>
								<div class="radio">
									<label><input type="radio" name="q27" value="0">Wishful
										thinking</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q27" value="0">Too
										much reliance on previous experiences</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q27" value="0">Recent
										information given too much weight</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q27" value="2.5" required>All
										of the above</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q28" class="form-control">28. The following
									is the most accurate list of credit risk takers for the Bank</label>
								<div class="radio">
									<label><input type="radio" name="q28" value="0">Loan
										Appraisal Officers Only</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q28" value="0">Loan
										Approving Managers Only</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q28" value="0">Appraisal
										Officer, Credit Committee and Managing Director</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q28" value="0">Appraisal
										Officer, Loan Approving Managers, Credit Committee, Managing
										Director and Board</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q28" value="2.5" required>Credit
										Committee and Risk & Compliance Department</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q29" class="form-control">29. Consider the
									following statements regarding the management of the Bank's
									risk taker. Which of the following statements are true? </label>
								<ol style="list-style-type: upper-roman;">
									<li>Do not give too much independence to star risk taking
										employees</li>
									<li>Separate the front, middle and back office</li>
									<li>Do not blindly trust models</li>
									<li>Be conservative in recognizing inception profits</li>
									<li>Do not sell clients inappropriate products</li>
									<li>Do not trust risk takers</li>
								</ol>
								<div class="radio">
									<label><input type="radio" name="q29" value="0">I
										and II are correct</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q29" value="0">III,
										IV, and V are correct</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q29" value="2.5" required>I,
										II, III, IV, and V are correct</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q29" value="0">I,
										II, III, IV, V and VI. are correct</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q30" class="form-control">30. The following
									best describes risk appetite</label>

								<ol style="list-style-type: upper-roman;">
									<li>How much loss at what confidence level are we prepared
										to risk</li>
									<li>What reputation risk are we prepared to take</li>
									<li>Scenario analysis and stress testing is important</li>
									<li>How concentrated should we allow our risks to become</li>
								</ol>

								<div class="radio">
									<label><input type="radio" name="q30" value="0">All
										of the above</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q30" value="0">I
										and II are correct</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q30" value="0">I
										only is correct</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q30" value="2.5" required>I,
										II and IV are correct</label>
								</div>


							</div>

							<div class="form-group">

								<label for="q31" class="form-control">31. Risk
									management forms part of corporate strategy through the
									following channels</label>
								<div class="radio">
									<label><input type="radio" name="q31" value="0">Manage
										departmental strategy-manage corporate strategic risks - manage project risks-manage process risks</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q31" value="2.5" required>Manage
										corporate strategic risks-manage departmental strategy - manage process risks-manage project risks</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q31" value="0">manage
										project risks-manage process risks - manage departmental
										strategy-Manage corporate strategic risks</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q31" value="0">None
										of the above</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q32" class="form-control">32. Key Risk
									Indicators...</label>
								<div class="radio">
									<label><input type="radio" name="q32" value="2.5" required>Conveys
										the information of a risk that is about to happen.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q32" value="0">Check
										whether the control works the way it is supposed to work</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q32" value="0">Shows
										whether you are achieving what you want to achieve</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q32" value="0">All
										of the above</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q33" class="form-control">33. Which of the
									following statement(s) is not true regarding Departmental or
									Business Unit's self-assessments:</label>
								<div class="radio">
									<label><input type="radio" name="q33" value="0">Risk
										self-assessments best identify risks when they are based on
										current policies and procedures</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q33" value="0">Risk-self
										assessment for a business unit is the sole responsibility of
										the Risk Champion</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q33" value="2.5" required>B
										and C</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q33" value="0">Risk-self
										assessments should include all risks that whole bank is
										exposed to as opposed to sticking to what is currently on the
										ground</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q34" class="form-control">34. Which of the
									following statement(s) regarding Risk is true:</label>
								<div class="radio">
									<label><input type="radio" name="q34" value="0">Risk
										is contextual</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q34" value="0">A
										risk resides in the future</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q34" value="0">All
										risks can be avoided completely when planned for properly.</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q34" value="2.5" required>A
										and B</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q35" class="form-control">35. A monthly
									report that details an unplanned event that has potential to
									cause loss, but did not lead to loss of revenue is;</label>
								<div class="radio">
									<label><input type="radio" name="q35" value="0">Incident
										Log Report</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q35" value="0">Key
										Risk Indicator Report</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q35" value="2.5" required>Near
										Miss report</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q35" value="0">Risk
										Self-Assessment Report</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q36" class="form-control">36. A monthly
									report that details an unusual incident that occurred during
									the month resulting in unwanted consequences (such as revenue
									loss);</label>
								<div class="radio">
									<label><input type="radio" name="q36" value="2.5" required>Incident
										Log Report</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q36" value="0">Key
										Risk Indicator Report</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q36" value="0">Near
										Miss report</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q36" value="0">Risk
										Self-Assessment Report</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q37" class="form-control">37. Risks
									identified in line of work and departmental processes and
									recorded in what report?</label>
								<div class="radio">
									<label><input type="radio" name="q37" value="0">Incident
										Log Report</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q37" value="0">Key
										Risk Indicator Report</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q37" value="0">Near
										Miss report</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q37" value="2.5" required>Risk
										Self-Assessment Report</label>
								</div>
							</div>



							<div class="form-group">

								<label for="q38" class="form-control">38. In order to
									avoid audit exceptions, the best course of action by a business
									unit would be to….</label>
								<div class="radio">
									<label><input type="radio" name="q38" value="0">Regularly
										liaise with the Internal Audit Department to schedule the next
										audit</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q38" value="2.5" required>Always
										follow stipulated policies and procedures in line of duty</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q38" value="0">Rely
										on well experienced employees on guidance</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q38" value="0">Always
										close all pending audit findings</label>
								</div>

							</div>

							<div class="form-group">

								<label for="q39" class="form-control">39. You are away
									from work on leave and your colleague calls and urgently
									request a document stored in your desktop. Which of the
									following would be the correct course of action;</label>
								<div class="radio">
									<label><input type="radio" name="q39" value="0">Share
										password with your colleague to sort emergency</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q39" value="0">Share
										password with your Manager who will access your desktop and
										share file with colleague</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q39" value="0">Share
										password with close employee from another department and
										request them to come and unlock your desktop and send document
										to colleague</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q39" value="2.5" required>Do
										not share password to anyone and make means to come and unlock
										desktop as soon as possible and send file.</label>
								</div>
							</div>

							<div class="form-group">

								<label for="q40" class="form-control">40. The following
									is not a component of internal controls</label>
								<div class="radio">
									<label><input type="radio" name="q40" value="0">Control
										environment</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q40" value="0">Risk
										Assessment</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q40" value="0">Control
										environment </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="q40" value="2.5" required>Policies</label>
								</div>
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