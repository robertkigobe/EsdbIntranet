<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>AA Loan Age Analysis</title>

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
							<h2>AA Loans Age Analysis Report</h2>
							<form method="post" action="AaLoanAgeAnalysisReport">
								<input type="text" name="seachAccount"
									placeholder="Search Loan ID..">
							</form>

							<form method="post" action="ProvisionToExcel">
								<input type="submit" value="Export to Excel" size="50">
							</form>



						</caption>

						<thead>
							<tr>
								<th>Branch</th>
								<th>LoanId</th>
								<th>Category</th>
								<th>CategroyDescription</th>
								<th>CustomerID</th>
								<th>CustomerName</th>
								<th>Currency</th>
								<th>Product</th>
								<th>ValueDate</th>
								<th>MaturityDate</th>
								<th>PrincipalBalance</th>
								<th>OverdueInterest</th>
								<th>OverduePrincipal</th>
								<th>OverduePenalty</th>
								<th>OverdueMonthlyFee</th>
								<th>TotalOverdues</th>
								<th>days0</th>
								<th>days1to10</th>
								<th>days11to30</th>
								<th>days31to60</th>
								<th>days61to89</th>
								<th>days90to180</th>
								<th>days181to365</th>
								<th>days366Above</th>
								<th>DueSPOverdue</th>
								<th>GrcSPOverdue</th>
								<th>Pd1SPOverdue</th>
								<th>Pd2Overdue</th>
								<th>Pd3SPOverdue</th>
								<th>Na1SPOverdue</th>
								<th>Na2SPOverdue</th>
								<th>Na3SPOverdue</th>
								<th>TotalDuesClass</th>
								<th>TotalExposure</th>
								<th>PeriodicPrincipal</th>
								<th>PeriodicInterest</th>
								<th>TotalPeriodic</th>
								<th>DisbursementAccount</th>
								<th>SettlementAccount</th>
								<th>LoanStatus</th>
							</tr>
						</thead>
						<c:forEach var="file" items="${aaLoansList}">

							<tr>

								<td><c:out value="${file.branch}" /></td>
								<td><c:out value="${file.loanId}" /></td>
								<td><c:out value="${file.category}" /></td>
								<td><c:out value="${file.categroyDescription}" /></td>
								<td><c:out value="${file.customerID}" /></td>
								<td><c:out value="${file.customerName}" /></td>
								<td><c:out value="${file.currency}" /></td>
								<td><c:out value="${file.product}" /></td>
								<td><c:out value="${file.valueDate}" /></td>
								<td><c:out value="${file.maturityDate}" /></td>
								<td><c:out value="${file.principalBalance}" /></td>
								<td><c:out value="${file.overdueInterest}" /></td>
								<td><c:out value="${file.overduePrincipal}" /></td>
								<td><c:out value="${file.overduePenalty}" /></td>
								<td><c:out value="${file.overdueMonthlyFee}" /></td>
								<td><c:out value="${file.totalOverdues}" /></td>
								<td><c:out value="${file.days0}" /></td>
								<td><c:out value="${file.days1to10}" /></td>
								<td><c:out value="${file.days11to30}" /></td>
								<td><c:out value="${file.days31to60}" /></td>
								<td><c:out value="${file.days61to89}" /></td>
								<td><c:out value="${file.days90to180}" /></td>
								<td><c:out value="${file.days181to365}" /></td>
								<td><c:out value="${file.days366Above}" /></td>
								<td><c:out value="${file.dueSPOverdue}" /></td>
								<td><c:out value="${file.grcSPOverdue}" /></td>
								<td><c:out value="${file.pd1SPOverdue}" /></td>
								<td><c:out value="${file.pd2Overdue}" /></td>
								<td><c:out value="${file.pd3SPOverdue}" /></td>
								<td><c:out value="${file.na1SPOverdue}" /></td>
								<td><c:out value="${file.na2SPOverdue}" /></td>
								<td><c:out value="${file.na3SPOverdue}" /></td>
								<td><c:out value="${file.totalDuesClass}" /></td>
								<td><c:out value="${file.totalExposure}" /></td>
								<td><c:out value="${file.periodicPrincipal}" /></td>
								<td><c:out value="${file.periodicInterest}" /></td>
								<td><c:out value="${file.totalPeriodic}" /></td>
								<td><c:out value="${file.disbursementAccount}" /></td>
								<td><c:out value="${file.settlementAccount}" /></td>
								<td><c:out value="${file.loanStatus}" /></td>
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