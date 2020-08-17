<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AML TEST SCORE</title>
</head>
<body>
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


		<div class="rightNav" style="width: 60%">
			<div
				style="background-color: #eee; width: 700px;; border: 1px dotted black; overflow: auto;">
				<table border="1" cellpadding="5">
					<caption>
						<h2>AML Test Results</h2>
					</caption>
					<thead>
						<tr>
						<td>Item</td>
						<td>Value</td>
							
						</tr>
					</thead>
					<tbody>
					<tr><td>User Name </td><td> ${name}</td></tr>
					<tr><td>Employee Branch </td><td> ${branch}</td></tr>
					<tr><td>Employee Department </td><td> ${department}</td></tr>
					<tr><td>Test Score </td><td> ${totalScore}%</td></tr>
								
					</tbody>


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