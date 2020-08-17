<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Provisions</title>

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


					<table>
						<caption>
							<h2>Provisions Report</h2>
							<form method="post" action="ProvisionsReport">
								<input type="text" name="seachAccount"
									placeholder="Search Account Number..">
							</form>
							
							<form method="post" action="ProvisionToExcel">
								<input type="submit" value="Export to Excel" size="50">
							</form>
							


						</caption>

						<thead>
							<tr>
								<th>Year</th>
								<th>Quarter</th>
								<th>Account Number</th>
								<th>Contract ID</th>
								<th>Drawdown Linked Account</th>
								<th>Branch</th>
								<th>Department</th>
								<th>Customer</th>
								<th>Type</th>
								<th>Year End Balance</th>
								<th>Year End Rate</th>
								<th>Year End Provision</th>
								<th>CurrentBalance</th>
								<th>CurrentRate</th>
								<th>Security</th>
								<th>Current Provisions</th>
								<th>Past Dues</th>
								<th>Comments</th>
								<th>Old Account</th>
							</tr>
						</thead>
						<c:forEach var="file" items="${provisionList}">

							<tr>
								<td><c:out value="${file.year}" /></td>
								<td><c:out value="${file.quater}" /></td>
								<td><c:out value="${file.accNo}" /></td>
								<td><c:out value="${file.contractIds}" /></td>
								<td><c:out value="${file.drawdownLink}" /></td>
								<td><c:out value="${file.branch}" /></td>
								<td><c:out value="${file.dept}" /></td>
								<td><c:out value="${file.customer}" /></td>
								<td><c:out value="${file.type}" /></td>
								<td><c:out value="${file.yearEndBalance}" /></td>
								<td><c:out value="${file.yearEndRate}" /></td>
								<td><c:out value="${file.yearEndProvision}" /></td>
								<td><c:out value="${file.currentBalance}" /></td>
								<td><c:out value="${file.currentRate}" /></td>
								<td><c:out value="${file.security}" /></td>
								<td><c:out value="${file.currentProvisions}" /></td>
								<td><c:out value="${file.pastDues}" /></td>
								<td><c:out value="${file.comments}" /></td>
								<td><c:out value="${file.oldAccount}" /></td>
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