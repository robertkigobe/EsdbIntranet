<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<style>
div.scroll {
	position: relative;
	width: 100%;
	height: 500px;
	overflow: scroll;
}
</style>


<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/HomePage.css" rel="stylesheet" type="text/css" />

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-3.1.1.min.js"></script>

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
					<li><a href="${pageContext.request.contextPath}/Directory"
						class="list-group-item list-group-item-action active">SwaziBank
							Directory</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage"
						class="list-group-item list-group-item-dark">SwaziBank Vision,
							Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/History"
						class="list-group-item list-group-item-dark">SwaziBank History</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard"
						class="list-group-item list-group-item-dark">SwaziBank Notice
							Board</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs And News</a></li>
					<li><a href="${pageContext.request.contextPath}/NewsLetter"
						class="list-group-item list-group-item-dark">Publications</a></li>



				</ol>

			</div>
			<div class="rightNav container-fluid">
				<div>

					<div class="page-header">
						<h3>Corporate Services HSE Credentials</h3>
					</div>

					<form action=HealthSafetyLogin method="post">
						<div id="row" class="row">

							<div class="col col-md-10">
								<label for="uName">User Name: </label> <select
									class="form-control col col-md-10" name="uName" value="Branch"
									required>

									<option></option>
									<option>HS-Test</option>
									<option>Admin</option>
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
						<div id="row" class="row" style="margin-top: 10px;">

							<div class="col col-md-10">
								<label for="password">Password: </label> <input type="password"
									class="form-control " placeholder="Password" name="password"
									required>
							</div>
						</div>
						<button type="submit" style="margin-top: 10px;"
							class="btn btn-primary btn-primary col-md-10">Submit</button>
					</form>
				</div>
			</div>

			<div class="clear"></div>

			<div>
				<jsp:include page="../utilities/_footer.jsp"></jsp:include>
			</div>

		</div>
</body>
</html>