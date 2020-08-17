<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wellness Survey</title>
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

					<li><a href="#"
						class="list-group-item list-group-item-action active"> Start Survey</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs and News</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage" class="list-group-item list-group-item-dark">SwaziBank
						Vision</a></li>
						<li><a href="${pageContext.request.contextPath}/BriefsAndNews" class="list-group-item list-group-item-dark">Briefs
						And News</a></li>

					<li><a
					href="${pageContext.request.contextPath}/SwaziBankProducts" class="list-group-item list-group-item-dark">SwaziBank
						Products </a></li>
						
						<li><a href="${pageContext.request.contextPath}/BscMain" class="list-group-item list-group-item-dark">Balance
								Score Card</a></li>


				</ol>

			</div>


			<div class="rightNav">
				<div class="page-header">
					<h3>Please tick in the appropriate box</h3><br>
					<div>
							<form action="WorkPlaceWellnessSurveySurvey" method="post" class="form">
						<div class="form-group" >
								<label>Sex:</label> <select name="sex" required>
									<option></option>
									<option>Female</option>
									<option>Male</option>
									<option>Other</option>
								</select>
								<label>Age group:</label> <select name="age" required>
									<option></option>
									<option>19-24</option>
									<option>25-29</option>
									<option>30-34</option>
									<option>35-39</option>
									<option>40-44</option>
									<option>45-49</option>
									<option>50-54</option>
									<option>55+</option>
								</select>
								<label>Relationship Status:</label> <select name="relationship" required>
									<option></option>
									<option>Cohabiting</option>
									<option>Divorced</option>
									<option>Married</option>
									<option>Single</option>
									<option>Widowed</option>
								</select>
								<label>Employment Status:</label> <select name="employmentStatus" required>
									<option></option>
									<option>Permanent</option>
									<option>Contract</option>
								</select>
								<label>Employment Duration:</label> <select name="employmentDuration" required>
									<option></option>
									<option>0-6 months</option>
									<option>7-11 months</option>
									<option>1-2 years </option>
									<option>2.1-4 years</option>
									<option>4-1 -10 years</option>
									<option>over10 years</option>
								</select>
								
								<label>Department:</label> <select name="employmentDepartment" required>
									<option></option>
									<option>Credit and Risk</option>
									<option>Finance</option>
									<option>Human Resources</option>
									<option>Internal Audit</option>
									<option>Legal and Company Secretary</option>
									<option>Managing Directorate</option>
									<option>Marketing Communication</option>
									<option>Retail</option>
									<option>Shared Services</option>
									<option>Treasury</option>
									<option>Wholesale</option>
								</select>


							</div>
						
						<div class="form-group ">

							<label for="q1" class="form-control">1.Breakfast is the
								most important meal of the day.</label>
							<div class="radio">
								<label><input type="radio" name="q1" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q1" value="2">Disagree</label>

								<label><input type="radio" name="q1" value="3">Neither
									Agree nor Disagree</label> <label><input type="radio" name="q1"
									value="4">Agree</label> <label><input type="radio"
									name="q1" value="5" required>Strongly Agree</label>

							</div>

						</div>

						<div class="form-group ">
							<label for="q2" class="form-control">2.Self-medication
								can result to liver damage. </label>
							<div class="radio">
								<label><input type="radio" name="q2" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q2" value="2">Disagree</label>
								<label><input type="radio" name="q2" value="3">Neither
									Agree nor Disagree</label> <label><input type="radio" name="q2"
									value="4">Agree</label> <label><input type="radio"
									name="q2" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q3" class="form-control">3.Poor adherence to
								treatment can result to drug resistance. </label>
							<div class="radio">
								<label><input type="radio" name="q3" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q3" value="2">Disagree</label>
								<label><input type="radio" name="q3" value="3">Neither
									Agree nor Disagree</label> <label><input type="radio" name="q3"
									value="4">Agree</label> <label><input type="radio"
									name="q3" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q4" class="form-control">4.The main
								non-communicable diseases like diabetes, cancer, cardiovascular
								and upper respiratory diseases are lifestyle related. </label>
							<div class="radio">
								<label><input type="radio" name="q4" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q4" value="2">Disagree</label>
								<label><input type="radio" name="q4" value="3">Neither
									Agree nor Disagree</label> <label><input type="radio" name="q4"
									value="4">Agree</label> <label><input type="radio"
									name="q4" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q5" class="form-control">5.A colleague taking
								drug resistant (MDR) TB treatment is infectious in the
								workplace. </label>
							<div class="radio">
								<label><input type="radio" name="q5" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q5" value="2">Disagree</label>
								<label><input type="radio" name="q5" value="3">Neither
									Agree nor Disagree</label> <label><input type="radio" name="q5"
									value="4">Agree</label> <label><input type="radio"
									name="q5" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q6" class="form-control">6.When a TB patient
								is not coughing, s/he is infectious. </label>
							<div class="radio">
								<label><input type="radio" name="q6" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q6" value="2">Disagree</label>
								<label><input type="radio" name="q6" value="3">Neither
									Agree nor Disagree</label> <label><input type="radio" name="q6"
									value="4">Agree</label> <label><input type="radio"
									name="q6" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q7" class="form-control">7.I know where to
								report gender based violence and sexual harassment in the
								workplace.</label>
							<div class="radio">
								<label><input type="radio" name="q7" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q7" value="2">Disagree</label>
								<label><input type="radio" name="q7" value="3">Neither
									Agree nor Disagree</label> <label><input type="radio" name="q7"
									value="4">Agree</label> <label><input type="radio"
									name="q7" value="5" required>Strongly Agree</label>
							</div>
						</div>


						<div class="form-group ">
							<label for="q8" class="form-control">8.I know what
								constitute sexual harassment in the workplace.</label>
							<div class="radio">
								<label><input type="radio" name="q8" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q8" value="2">Disagree</label>
								<label><input type="radio" name="q8" value="3">Neither
									Agree nor Disagree</label> <label><input type="radio" name="q8"
									value="4">Agree</label> <label><input type="radio"
									name="q8" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q9" class="form-control">9.Wellness programs
								are meant for sick employees.</label>
							<div class="radio">
								<label><input type="radio" name="q9" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q9" value="2">Disagree</label>
								<label><input type="radio" name="q9" value="3">Neither
									Agree nor Disagree</label> <label><input type="radio" name="q9"
									value="4">Agree</label> <label><input type="radio"
									name="q9" value="5" required>Strongly Agree</label>
							</div>
						</div>


						<div class="form-group ">
							<label for="q10" class="form-control">10.I will attend
								staff wellness dialogues, counseling sessions and social
								activities if they are made available.</label>
							<div class="radio">
								<label><input type="radio" name="q10" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q10"
									value="2">Disagree</label> <label><input type="radio"
									name="q10" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q10" value="4">Agree</label> <label><input
									type="radio" name="q10" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q11" class="form-control">11.I would use
								health and wellness information materials if they are available.</label>
							<div class="radio">
								<label><input type="radio" name="q11" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q11"
									value="2">Disagree</label> <label><input type="radio"
									name="q11" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q11" value="4">Agree</label> <label><input
									type="radio" name="q11" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q12" class="form-control">12.I am comfortable
								working with an HIV positive employee.</label>
							<div class="radio">
								<label><input type="radio" name="q12" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q12"
									value="2">Disagree</label> <label><input type="radio"
									name="q12" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q12" value="4">Agree</label> <label><input
									type="radio" name="q12" value="5" required>Strongly Agree</label>
							</div>
						</div>



						<div class="form-group ">
							<label for="q13" class="form-control">13.Victims of
								domestic violence have themselves to blame.</label>
							<div class="radio">
								<label><input type="radio" name="q13" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q13"
									value="2">Disagree</label> <label><input type="radio"
									name="q13" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q13" value="4">Agree</label> <label><input
									type="radio" name="q13" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q14" class="form-control">14.I like my job
								and I am always motivated to do more.</label>
							<div class="radio">
								<label><input type="radio" name="q14" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q14"
									value="2">Disagree</label> <label><input type="radio"
									name="q14" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q14" value="4">Agree</label> <label><input
									type="radio" name="q14" value="5" required>Strongly Agree</label>
							</div>
						</div>



						<div class="form-group ">
							<label for="q15" class="form-control">15.I take all my
								leave days.</label>
							<div class="radio">
								<label><input type="radio" name="q15" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q15"
									value="2">Disagree</label> <label><input type="radio"
									name="q15" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q15" value="4">Agree</label> <label><input
									type="radio" name="q15" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q16" class="form-control">16.I have a good
								relationship with my supervisor/co-worker.</label>
							<div class="radio">
								<label><input type="radio" name="q16" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q16"
									value="2">Disagree</label> <label><input type="radio"
									name="q16" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q16" value="4">Agree</label> <label><input
									type="radio" name="q16" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q17" class="form-control">17.I always eat a
								balanced diet.</label>
							<div class="radio">
								<label><input type="radio" name="q17" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q17"
									value="2">Disagree</label> <label><input type="radio"
									name="q17" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q17" value="4">Agree</label> <label><input
									type="radio" name="q17" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q18" class="form-control">18.I sometimes come
								to work drunk or hung-over.</label>
							<div class="radio">
								<label><input type="radio" name="q18" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q18"
									value="2">Disagree</label> <label><input type="radio"
									name="q18" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q18" value="4">Agree</label> <label><input
									type="radio" name="q18" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q19" class="form-control">19.I make time for
								exercising at least 3 times a week.</label>
							<div class="radio">
								<label><input type="radio" name="q19" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q19"
									value="2">Disagree</label> <label><input type="radio"
									name="q19" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q19" value="4">Agree</label> <label><input
									type="radio" name="q19" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q20" class="form-control">20.I use drugs and
								substances such as alcohol, and smoking to cope with my daily
								stress.</label>
							<div class="radio">
								<label><input type="radio" name="q20" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q20"
									value="2">Disagree</label> <label><input type="radio"
									name="q20" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q20" value="4">Agree</label> <label><input
									type="radio" name="q20" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q21" class="form-control">21.In the past six
								months I have had sex with more than 1 person.</label>
							<div class="radio">
								<label><input type="radio" name="q21" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q21"
									value="2">Disagree</label> <label><input type="radio"
									name="q21" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q21" value="4">Agree</label> <label><input
									type="radio" name="q21" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q22" class="form-control">22. I can manage my
								debts effectively. </label>
							<div class="radio">
								<label><input type="radio" name="q22" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q22"
									value="2">Disagree</label> <label><input type="radio"
									name="q22" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q22" value="4">Agree</label> <label><input
									type="radio" name="q22" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q23" class="form-control">23. I know the role
								of the wellness office. </label>
							<div class="radio">
								<label><input type="radio" name="q23" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q23"
									value="2">Disagree</label> <label><input type="radio"
									name="q23" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q23" value="4">Agree</label> <label><input
									type="radio" name="q23" value="5" required>Strongly Agree</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q24" class="form-control">24. I know who to
								contact in case I have wellness challenges. </label>
							<div class="radio">
								<label><input type="radio" name="q24" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q24"
									value="2">Disagree</label> <label><input type="radio"
									name="q24" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q24" value="4">Agree</label> <label><input
									type="radio" name="q24" value="5" required>Strongly Agree</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q25" class="form-control">25. I am fully
								aware of the wellness testing services provided through SWABCHA.
							</label>
							<div class="radio">
								<label><input type="radio" name="q25" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q25"
									value="2">Disagree</label> <label><input type="radio"
									name="q25" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q25" value="4">Agree</label> <label><input
									type="radio" name="q25" value="5" required>Strongly Agree</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q26" class="form-control">26. I know the
								Wellness Champion (Peer Educator) in my department. </label>
							<div class="radio">
								<label><input type="radio" name="q26" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q26"
									value="2">Disagree</label> <label><input type="radio"
									name="q26" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q26" value="4">Agree</label> <label><input
									type="radio" name="q26" value="5" required>Strongly Agree</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q27" class="form-control">27. I know the role
								of Wellness Champions. </label>
							<div class="radio">
								<label><input type="radio" name="q27" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q27"
									value="2">Disagree</label> <label><input type="radio"
									name="q27" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q27" value="4">Agree</label> <label><input
									type="radio" name="q27" value="5" required>Strongly Agree</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q28" class="form-control">28. The Wellness
								Champions are friendly and approachable. </label>
							<div class="radio">
								<label><input type="radio" name="q28" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q28"
									value="2">Disagree</label> <label><input type="radio"
									name="q28" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q28" value="4">Agree</label> <label><input
									type="radio" name="q28" value="5" required>Strongly Agree</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q29" class="form-control">29. Having wellness
								mobile clinic visits twice a year is sufficient for my needs. </label>
							<div class="radio">
								<label><input type="radio" name="q29" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q29"
									value="2">Disagree</label> <label><input type="radio"
									name="q29" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q29" value="4">Agree</label> <label><input
									type="radio" name="q29" value="5" required>Strongly Agree</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q30" class="form-control">30. Condoms are
								always available in condo-cans. </label>
							<div class="radio">
								<label><input type="radio" name="q30" value="1">Strongly
									Disagree</label> <label><input type="radio" name="q30"
									value="2">Disagree</label> <label><input type="radio"
									name="q30" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q30" value="4">Agree</label> <label><input
									type="radio" name="q30" value="5" required>Strongly Agree</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q31" class="form-control">31. I know about
								the wellness sessions and I participate in educational sessions.
							</label>
							<div class="radio">
								<label><input type="radio" name="q31" value="1" required>Strongly
									Disagree</label> <label><input type="radio" name="q31"
									value="2">Disagree</label> <label><input type="radio"
									name="q31" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q31" value="4">Agree</label> <label><input
									type="radio" name="q31" value="5" required required>Strongly Agree</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q32" class="form-control">32. The wellness
								sessions are very informative and useful. </label>
							<div class="radio">
								<label><input type="radio" name="q32" value="1" required>Strongly
									Disagree</label> <label><input type="radio" name="q32"
									value="2">Disagree</label> <label><input type="radio"
									name="q32" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q32" value="4">Agree</label> <label><input
									type="radio" name="q32" value="5" required>Strongly Agree</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q33" class="form-control">33. I have actually
								made changes to my lifestyle because of the wellness sessions. </label>
							<div class="radio">
								<label><input type="radio" name="q33" value="1" required>Strongly
									Disagree</label> <label><input type="radio" name="q33"
									value="2">Disagree</label> <label><input type="radio"
									name="q33" value="3">Neither Agree nor Disagree</label> <label><input
									type="radio" name="q33" value="4">Agree</label> <label><input
									type="radio" name="q33" value="5" required>Strongly Agree</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q34" class="form-control">34. I often feel
								helpless to deal with problems in life and find it difficult to
								cope. </label>
							<div class="radio">
								<label><input type="radio" name="q34" value="1" required>Yes</label>
								<label><input type="radio" name="q34" value="2">No</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q35" class="form-control">35. I have lost
								interest, motivation or pleasure in usual activities </label>
							<div class="radio">
								<label><input type="radio" name="q35" value="1" required>Yes</label>
								<label><input type="radio" name="q35" value="2">No</label>
							</div>
						</div>

						<div class="form-group ">
							<label for="q36" class="form-control">36. Do you abuse
								(use more than prescribed) medicine from the chemist or
								prescription medicine from the doctor? </label>
							<div class="radio">
								<label><input type="radio" name="q36" value="1" required>Yes</label>
								<label><input type="radio" name="q36" value="2">No</label>
							</div>
						</div>


						<div class="form-group ">
							<label for="q37" class="form-control">37. Do you abuse
								(use more than prescribed) medicine from the chemist or
								prescription medicine from the doctor? </label>
							<div class="radio">
								<label><input type="radio" name="q37" value="1" required>Yes</label>
								<label><input type="radio" name="q37" value="2">No</label>
							</div>
						</div>

						
						
						
						<div class="form-group ">
							<label for="q38" class="form-control">38. I usually borrow money mostly for: Food</label>
							<div class="radio">
								<label><input type="radio" name="q38" value="1" required>Yes</label>
								<label><input type="radio" name="q38" value="2">No</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q39" class="form-control">39. I usually borrow money mostly for: Transport to work</label>
							<div class="radio">
								<label><input type="radio" name="q39" value="1" required>Yes</label>
								<label><input type="radio" name="q39" value="2">No</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="q40" class="form-control">40. I usually borrow money mostly for: School fees</label>
							<div class="radio">
								<label><input type="radio" name="q40" value="1" required>Yes</label>
								<label><input type="radio" name="q40" value="2">No</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="41" class="form-control">41. I usually borrow money mostly for: Tuition fees</label>
							<div class="radio">
								<label><input type="radio" name="q41" value="1" required>Yes</label>
								<label><input type="radio" name="q41" value="2">No</label>
							</div>
						</div>
						
						<div class="form-group ">
							<label for="42" class="form-control">42. I usually borrow money mostly for: Medical fees</label>
							<div class="radio">
								<label><input type="radio" name="q42" value="1" required>Yes</label>
								<label><input type="radio" name="q42" value="2">No</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="43" class="form-control">43. I usually borrow money mostly for: Shopping</label>
							<div class="radio">
								<label><input type="radio" name="q43" value="1" required>Yes</label>
								<label><input type="radio" name="q43" value="2">No</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="44" class="form-control">44. I usually borrow money mostly for: Debt consolidation</label>
							<div class="radio">
								<label><input type="radio" name="q44" value="1" required>Yes</label>
								<label><input type="radio" name="q44" value="2">No</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="45" class="form-control">45. I usually borrow money mostly for: I rarely borrow</label>
							<div class="radio">
								<label><input type="radio" name="q45" value="1" required>Yes</label>
								<label><input type="radio" name="q45" value="2">No</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="46" class="form-control">46. I usually borrow money mostly for: I do not borrow</label>
							<div class="radio">
								<label><input type="radio" name="q46" value="1" required>Yes</label>
								<label><input type="radio" name="q46" value="2">No</label>
							</div>
						</div>
					
						
						<div class="form-group ">
							<label for="q38" class="form-control">38. Sometimes I do not use a condom during sexual activities because: </label>
							<div class="radio">
								<label><input type="checkbox" name="q38" value="1">I trust my partner</label>
								<label><input type="checkbox" name="q38" value="2">my partner does not like condoms</label>
								<label><input type="checkbox" name="q38" value="3">I use other family panning methods </label>
								<label><input type="checkbox" name="q38" value="4">I am intoxicated </label>
								<label><input type="checkbox" name="q38" value="5" >To conceive</label>
								<label><input type="checkbox" name="q38" value="6">I am married</label>
								<label><input type="checkbox" name="q38" value="7">I am already positive</label>
								<label><input type="checkbox" name="q38" value="8">Condom has a nasty smell</label>
								<label><input type="checkbox" name="q38" value="9">I always use a condom </label>
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