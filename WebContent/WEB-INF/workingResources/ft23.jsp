<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Financial Transactions</title>
<style>
div.scroll {
	position: relative;
	width: 100%;
	height: 500px;
	overflow: scroll;
}
</style>

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
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

				<h4>Quick Links</h4>

				<Ol>

					<li><a href="${pageContext.request.contextPath}/VisionPage">SwaziBank
							Vision, Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/History">SwaziBank
							History</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard">SwaziBank
							Notice Board</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews">Briefs
							And News</a></li>
					<li><a
						href="${pageContext.request.contextPath}/IntranetFeedBack">Feedback</a></li>
					<li><a
						href="${pageContext.request.contextPath}/InternalAdvert">Internal
							Vacancies</a></li>


				</Ol>
			</div>
			<div class="rightNav">
				<h1>FT's for 23rd November 2017</h1>

				<div class="scroll">



					<form method="post" action="FT23">
						<H4>
							Search: First Name or Surname:<input type="text" name="seachName"
								placeholder="Account Number.."> <a
								href="${pageContext.request.contextPath}/FT23">Clear
								Filters</a>
						</H4>
					</form>

					<table border="1">


						<thead>
							<tr>
							<th>ID</th>
								<TH>TRANSACTION_TYPE</tH>
								<TH>DEBIT_ACCT_NO</th>
								<TH>DEBIT_AMOUNT</th>
								<TH>CREDIT_CURRENCY</th>
								<TH>PROCESSING_DATE</th>
								<TH>DEBIT_THEIR_REF</th>
								<TH>CREDIT_ACCT_NO</th>
								<TH>CREDIT_AMOUNT</th>
								<TH>DEBIT_CURRENCY</th>
								<TH>VALUE_DATE</th>
								<TH>CREDIT_THEIR_REF</th>
								<TH>PAYMENT_DETAILS</th>
								<TH>IMPUTER</th>
								<TH>AUTHORISER</th>
								<TH>CO_CODE</th>
								<TH>DATE_TIME</th>
								<TH>AMOUNT_DEBITED</th>
								<TH>AMOUNT_CREDITED</th>
								<TH>CHARGE_AMOUNT</th>
								<TH>STMT_NOS</th>
								<TH>DTAE</th>
								<TH>OVERRIDE</th>


							</tr>
						</thead>
						<c:forEach var="file" items="${ft23List}">



							<tr>
								<td><c:out value="${file.id}" /></td>
								<td><c:out value="${file.transaction_type}" /></td>
								<td><c:out value="${file.debit_acct_no}" /></td>
								<td><c:out value="${file.debit_amount}" /></td>
								<td><c:out value="${file.credit_currency}" /></td>
								<td><c:out value="${file.processing_date}" /></td>
								<td><c:out value="${file.debit_their_ref}" /></td>
								<td><c:out value="${file.credit_acct_no}" /></td>
								<td><c:out value="${file.credit_amount}" /></td>
								<td><c:out value="${file.debit_currency}" /></td>
								<td><c:out value="${file.value_date}" /></td>
								<td><c:out value="${file.credit_their_ref}" /></td>
								<td><c:out value="${file.payment_details}" /></td>
								<td><c:out value="${file.imputer}" /></td>
								<td><c:out value="${file.authoriser}" /></td>
								<td><c:out value="${file.co_code}" /></td>
								<td><c:out value="${file.date_time}" /></td>
								<td><c:out value="${file.amount_debited}" /></td>
								<td><c:out value="${file.amount_credited}" /></td>
								<td><c:out value="${file.charge_amount}" /></td>
								<td><c:out value="${file.stmt_nos}" /></td>
								<td><c:out value="${file.dtae}" /></td>
								<td><c:out value="${file.override}" /></td>

							</tr>
						</c:forEach>
					</table>
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