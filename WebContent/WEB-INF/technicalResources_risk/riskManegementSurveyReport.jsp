<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Risk management Survey Report</title>
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
					<li><a
						href="${pageContext.request.contextPath}/RiskAwarenessSurvey"
						class="list-group-item list-group-item-action active">Start
							Survey</a></li>
					<li><a href="${pageContext.request.contextPath}/AmlTestMain"
						class="list-group-item list-group-item-dark">Anti Money
							Laundering Test</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Risk
							Management Test</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Publications</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">Whistle
							Blowing Platform</a></li>
					<li><a
						href="${pageContext.request.contextPath}/RiskReportLogin"
						class="list-group-item list-group-item-dark">Risk Management
							Survey Report</a></li>

					<li><a href="${pageContext.request.contextPath}/Home"
						class="list-group-item list-group-item-dark">SwaziBank Home</a></li>
				</ol>

			</div>
			<div class="rightNav">


				<div>



					<div class="page-header">
						<h4>Risk Management Survey Report</h4>

					</div>




					<div class="scroll">
						<table class="table  table-striped table-hover table-bordered">


							<thead class="thead-dark">
								<tr>
									<th> EMPLOYEE NAME</th>
									<th>DEPARTMENT</th>
									<th>SCORE</th>
			

								</tr>
							</thead>
							<tbody>
							
					
								
								
								
								<c:forEach var="file" items="${riskManagementSurveyList}">
									<tr>
									
										<td><c:out value="${file.employeeName}" /></td>
										<td><c:out value="${file.subDepartment}" /></td>
										<td><c:out value="${file.score}" /></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
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