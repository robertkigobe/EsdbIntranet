<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/issueStyle.css" rel="stylesheet" type="text/css" />
<title>Staff Extension Directory</title>
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


		<div class="right" style="width: 100%">
			<div
				style="background-color: #eee; width: 100%; height: 500px; border: 1px dotted black; overflow: auto;">
				<table border="1" cellpadding="5">
					<caption>
						<h2>SwaziBank Internal Audit Issues</h2>
					</caption>
					<thead>
						<tr>
							<th style="width: 8%">Audit Code</th>
							<th style="width: 8%">Audit Type</th>
							<th style="width: 10%">Financial Year</th>
							<th style="width: 8%">Quarter</th>
							<th style="width: 8%">Audit Date</th>
							<th style="width: 15%">Report Title</th>
							<th style="width: 15%">Issue Title</th>
							<th style="width: 8%">Status</th>
							<th style="width: 15%">Risk Rating</th>


						</tr>
					</thead>
					<c:forEach var="file" items="${directory}">
						<tr>
							<td><c:out value="${file.auditCode}" /></td>
							<td><c:out value="${file.auditType}" /></td>
							<td><c:out value="${file.financialYear}" /></td>
							<td><c:out value="${file.quarter_v}" /></td>
							<td><c:out value="${file.auditDate}" /></td>
							<td><c:out value="${file.reportTitle}" /></td>
							<td><c:out value="${file.exceptionTitle}" /></td>
							<td><c:out value="${file.currentImplementationStatus}" /></td>
							<td><c:out value="${file.reportByOpinion}" /></td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<div class="clear"></div>
		<div>
			<footer> <jsp:include page="../utilities/_footer.jsp"></jsp:include>
			</footer>
		</div>
	</div>
</body>
</html>