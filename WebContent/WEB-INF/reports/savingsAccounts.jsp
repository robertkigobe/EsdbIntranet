<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Savings Accounts</title>

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

			<div class="rightNav" style="float: right; width: 99%;">
				<div
					style="background-color: #eee; height: 500px; border: 1px dotted black; overflow: auto;">


					<table >
						<caption>
							<h2>Savings Accounts Report</h2>
							<form method="post" action="SavingsAccountsReport">
								<input type="text" name="seachAccount"
									placeholder="Search Account Number..">
							</form>

							<form method="post" action="SavingsAccountsToExcel">
								<input type="submit" value="Export to Excel" size="50">
							</form>



						</caption>

						<thead>
							<tr>

								<th>ACCOUNT</th>
								<th>CUSTID</th>
								<th>CUSTNAME</th>
								<th>SEX</th>
								<th>DATE_0F_BIRTH</th>
								<th>SECTOR</th>
								<th>INDUSTRY</th>
								<th>AC_INACTIVE Y / N</th>
								<th>BRANCH</th>
								<th>CATEGORY</th>
								<th>DESCRIPTION</th>
								<th>OS PRINCIPAL</th>
								<th>OS INTEREST</th>
								<th>PD PRINCIPAL</th>
								<th>PD INTCHGS</th>
								<th>TOTAL</th>
								<th>CREATED</th>
								<th>MATURITY</th>
								<th>TERMS</th>
								<th>JUNE TOTAL</th>
								<th>MOVEMENT</th>


							</tr>
						</thead>
						<c:forEach var="file" items="${savingsAccountsList}">




							<tr>
								<td><c:out value="${file.account}" /></td>
								<td><c:out value="${file.custid}" /></td>
								<td><c:out value="${file.custname}" /></td>
								<td><c:out value="${file.sex}" /></td>
								<td><c:out value="${file.date_0f_birth}" /></td>
								<td><c:out value="${file.sector}" /></td>
								<td><c:out value="${file.industry}" /></td>
								<td><c:out value="${file.inactive}" /></td>
								<td><c:out value="${file.branch}" /></td>
								<td><c:out value="${file.category}" /></td>
								<td><c:out value="${file.description}" /></td>
								<td><c:out value="${file.os_principal}" /></td>
								<td><c:out value="${file.os_interest}" /></td>
								<td><c:out value="${file.pd_principal}" /></td>
								<td><c:out value="${file.pd_intchgs}" /></td>
								<td><c:out value="${file.total}" /></td>
								<td><c:out value="${file.created}" /></td>
								<td><c:out value="${file.maturity}" /></td>
								<td><c:out value="${file.terms}" /></td>
								<td><c:out value="${file.month_total}" /></td>
								<td><c:out value="${file.movement}" /></td>

							</tr>
						</c:forEach>
					</table>
				</div>
			</div>


		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>