<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>AML TEST RESULTS</title>

<link href="css/HomeStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js"></script>

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

			
				<div
					style="background-color: #eee;  border: 1px dotted black; overflow: auto;">

							<h2>AML Test Scores</h2>

					<table class="table  table-striped table-hover table-bordered">
						
						
						<thead>
							<tr>
								<th >Name</th>
								<th >Branch</th>
								<th >Department</th>
								<th >Year</th>
								<th >Test Score</th>
							</tr>
						</thead>
						<c:forEach var="file" items="${amlList}">
							<tr>
								<td><c:out value="${file.name}" /></td>
								<td><c:out value="${file.branch}" /></td>
								<td><c:out value="${file.department}" /></td>
								<td><c:out value="${file.year}" /></td>
								<td><c:out value="${file.totalScore}%" /></td>
								
							</tr>
						</c:forEach>
					</table>
				</div>
			


		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>