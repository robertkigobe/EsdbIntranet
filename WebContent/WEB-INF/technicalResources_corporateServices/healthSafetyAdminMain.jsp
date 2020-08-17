<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
						class="list-group-item list-group-item-dark ">View HSE First	Aid submissions</a></li>
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyViewInspectionFireMarshall"
						class="list-group-item list-group-item-dark">View HSE Fire Martial submissions</a></li>
					<li><a style="font-size:12px;"
						href="${pageContext.request.contextPath}/HealthSafetyViewInspectionWellnessChampion"
						class="list-group-item list-group-item-dark ">View HSE Wellness Champion submissions</a></li>

					<li><a style="font-size:14px;"
						href="${pageContext.request.contextPath}/HealthSafetyViewInspectionEnvironmental"
						class="list-group-item list-group-item-dark ">View HSE Environmental Submissions</a></li>

					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyAdminNewInspection"
						class="list-group-item list-group-item-dark ">HSE Inspection Register </a></li>
						


				</Ol>


			</div>

			<div class="rightNav container-fluid">


				<h2>News</h2>
				<div>
					<p>The workplace should prepare an occupational safety and
						health policy programme as part of the preparation of the Safety
						Statement required by Section 20 of the Safety, Health and Welfare
						at Work Act 2005. Effective safety and health policies should set
						a clear direction for the organisation to follow. They will
						contribute to all aspects of business performance as part of a
						demonstrable commitment to continuous improvement.
						Responsibilities to people and the working environment will be met
						in a way that fulfils the spirit and letter of the law.
						Cost-effective approaches to preserving and developing human and
						physical resources will reduce financial losses and liabilities.
						In a wider context, stakeholders' expectations, whether they are
						shareholders, employees or their representatives, customers or
						society at large, can be met.</p>

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