<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Score Position</title>
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
					<li><a href="#"
						class="list-group-item list-group-item-action active"> Bsc Exco Home</a></li>
						<li><a
						href="${pageContext.request.contextPath}/BscExcoCommonTargets"
						class="list-group-item list-group-item-dark">Common Targets</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BscExcoTargets"
						class="list-group-item list-group-item-dark">Corporate Targets</a></li>
					
										<li><a href="${pageContext.request.contextPath}/BscExcoScores" class="list-group-item list-group-item-dark">Corporate Scores</a></li>


					<li><a
						href="${pageContext.request.contextPath}/BscSetMeasuresRequest"
						class="list-group-item list-group-item-dark">Corporate Report</a></li>

				</ol>
			</div>

			<div class="rightNav">
				<form action=BscExcoScores method="post" class="form-inline">
					<div class=" container page-header">
						<h3>Choose Department to score</h3>

					</div>

					<div>
						<table class="table  table-striped table-hover table-bordered">
							<tbody>

								<tr>

									<td><select name="bscPeriod" class="form-control">
										<option>Choose Period</option>
										<option>October 2017</option>
										<option>November 2017</option>
										<option>December 2017</option>
										<option>Quarter 3 2017-2018</option>
										<option>January 2018</option>
										<option>February 2018</option>
										<option>March 2018</option>
										<option>Quarter 4 2017-2018</option>
										<option>2017-2018</option>
								</select></td>
								</tr>
								<tr>

									<td><select name="position" class="form-control">
											<c:forEach items="${measureList}" var="item">
												<option value="${item.position}">${item.position}</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>

									<td><input value="Submit Score Score Request" type="Submit"
										class="btn btn-primary form-control"></td>
								</tr>
							</tbody>
						</table>
					</div>
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