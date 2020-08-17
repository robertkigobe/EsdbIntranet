<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forex Transactions</title>

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
						<li><a href="${pageContext.request.contextPath}/ForexAMLRiskDailyTransactions"  class="list-group-item list-group-item-action active">Forex Transactions</a></li>
						<li><a href="${pageContext.request.contextPath}/ForexAMLRiskDailyReport"  class="list-group-item list-group-item-dark">Forex Transactions Entries</a></li>
						<li><a href="${pageContext.request.contextPath}/ForexAMLHighRiskDailyReport"  class="list-group-item list-group-item-dark">High Risk Transactions</a></li>
						


					</ol>

			</div>


			<div class="rightNav">




				<div>
					<h3>Forex AML Risk Transaction Entry</h3>
					<div>
						<form action="ForexAMLRiskDailyTransactions" method="POST">

							

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="customerName">Customer Name</label> <input
										type="text" class="form-control" name="customerName"
										id="customerName" value="${customerName}" required >
								</div>
								<div class="form-group col-md-2">
									<label for="cif">Cif</label> <input
										type="number" class="form-control" name="cif"
										id="cif" value="${cif}" required >
								</div>
								<div class="form-group col-md-2">
									<label for="branch">Branch:</label> <select name="branch"
										class="form-control" required>
										<option></option>
										<option>CASH CENTRE BRANCH</option>
										<option>EZULWINI BRANCH</option>
										<option>MANZINI BRANCH</option>
										<option>MATSAPHA BRANCH</option>
										<option>MBABANE BRANCH</option>
										<option>MBABANE COMMERCIAL BRANCH</option>
										<option>MATATA BRANCH</option>
										<option>SIPHOFANENI</option>
										<option>SIMUNYE BRANCH</option>
										<option>NHLANGANO BRANCH</option>
										<option>SITEKI BRANCH</option>
										<option>PIGGS PEAK BRANCH</option>
									</select>
								</div>

								<div class="form-group col-md-2">
									<label for="currency">Currency</label> <select name="currency"
										class="form-control" required>
										<option></option>
										<OPTION>US DOLLAR EURO</OPTION>
										<OPTION>BRITISH POUND</OPTION>
										<OPTION>RAND</OPTION>
										<OPTION>EMALANGENI</OPTION>


									</select>
								</div>

								<div class="form-group col-md-2">
									<label for="amount">Amount</label> <input type="number"
										class="form-control" name="amount" id="amount"
										value="${amount}" required step="any">
								</div>






								<div class="form-group col-md-2">
									<label for="destination">Destination</label> <select
										name="destination" class="form-control" required>
										<option></option>
										<option>AFGHANISTAN</option>
										<option>BELARUS</option>
										<option>BOSNIA AND HERZEGOVINA</option>
										<option>BOTSWANA</option>
										<option>CENTRAL AFRICAN REPUBLIC</option>
										<option>COTE D'IVOIRE</option>
										<option>DEMOCRATIC REPUBLIC OF CONGO</option>
										<option>EGYPT</option>
										<option>ETHIOPIA</option>
										<option>IRAN
										<option>IVORY COAST</option>
										<option>IRAQ</option>
										<option>LEBANON</option>
										<option>LIBERIA</option>
										<option>NORTH KOREA</option>
										<option>REPUBLIC OF GUINEA</option>
										<option>REPUBLIC OF NORTH SUDAN</option>
										<option>RUSSIA</option>
										<option>SOMALIA</option>
										<option>SUDAN</option>
										<option>SYRIA</option>
										<option>THE DEMOCRATIC PEOPLE'S REPUBLIC OF KOREA</option>
										<option>THE REPUBLIC OF SOUTH SUDAN</option>
										<option>TUNISIA</option>
										<option>UGANDA</option>
										<option>UKRAINE</option>
										<option>VANUATU</option>
										<option>VENEZUELA</option>
										<option>WESTERN BALKANS</option>
										<option>YEMEN</option>
										<option>ZIMBABWE</option>
										<option>ALL OTHER</option>


									</select>
								</div>

							</div>

							<div class="form-row">

								<div class="form-group col-md-3">
									<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
								</div>
							</div>

						</form>
					</div>
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