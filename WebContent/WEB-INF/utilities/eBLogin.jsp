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
</head>
<body>
<body>


	<div class="container">
		<div>
			<jsp:include page="_header.jsp"></jsp:include>
		</div>

		<div>
			<jsp:include page="../utilities/_menu.jsp"></jsp:include>
			<div class="clear"></div>
		</div>
		<div>
			<jsp:include page="bar.jsp"></jsp:include>
			<div class="clear"></div>
		</div>


		<div class="rightNav" style="width: 60%">
			<div
				style="background-color: #eee; width: 700px;; border: 1px dotted black; overflow: auto;">
				<table border="1" cellpadding="5">
					<caption>
						<h2>Electronic Banking Credentials</h2>
					</caption>
					<thead>
						<tr>
							<th style="width: 50%">Item</th>
							<th style="width: 50%">Value</th>


						</tr>
					</thead>


					<form action=EBLogin method="post">
						<tr>
							<td>User Name:</td>
							<td><input type="text" name="uName" size="50"></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password" size="50"></td>
						</tr>
					<tr>

						<td><input type="submit" value="Submit" size="50"></td>
					</tr>

					</form>

				</table>
			</div>
		</div>

		<div class="clear"></div>
		<div>
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>







</body>
</html>