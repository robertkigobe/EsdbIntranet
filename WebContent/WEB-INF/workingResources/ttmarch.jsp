<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>TT Transactions</title>
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
				<h1>TT's for March 2018</h1>

				<div class="scroll">



					<form method="post" action="TTMARCH">
						<H4>
							Search: First Name or Surname:<input type="text" name="seachName"
								placeholder="Account Number.."> <a
								href="${pageContext.request.contextPath}/TTMARCH">Clear
								Filters</a>
						</H4>
					</form>

					<table border="1">


						<thead>
							<tr>
								<th>ID</th> 
								<th>TRANSACTION_CODE</th> 
								<th>TELLER_ID_1</th> 
								<th>DR_CR_MARKER</th> 
								<th>CURRENCY_1</th> 
								<th>ACCOUNT_1</th> 
								<th>ACCOUNT_2</th> 
								<th>AMOUNT_LOCAL_1</th> 
								<th>AMOUNT_LOC2</th> 
								<th>AUTH_DATE1</th> 
								<th>AUTH_DATE</th> 
								<th>NARRATION1</th> 
								<th>CURRENCY_2</th> 
								<th>UNIT</th> 
								<th>CHARGE_ACCOUNT</th> 
								<th>CHARGE_CUSTOMER</th> 
								<th>AMOUNT_LOCAL_2</th> 
								<th>AMOUNT_FCY_2</th> 
								<th>NET_AMOUNT</th> 
								<th>VALUE_DATE</th> 
								<th>VALUE_DATE2</th> 
								<th>NARRATIVE_2_CHEQUE_NUMBER</th> 
								<th>CHRG_AMT_LOCAL</th> 
								<th>STATUS</th> 
								<th>CHEQUE_NUMBER</th> 
								<th>OVERRIDE</th> 
								<th>INPUTER</th> 
								<th>DATE_TIME</th> 
								<th>AUTHORIZER</th> 
								<th>BRANCH_CODE</th> 
								<th>VALUE_DATE3</th> 
								<th>AMOUNT4</th>

							</tr>
						</thead>
						<c:forEach var="file" items="${ft23List}">

							   

							<tr>
								<td><c:out value="${file.id}" /></td>
								<td><c:out value="${file.transaction_code}" /></td>
								<td><c:out value="${file.teller_id_1}" /></td>
								<td><c:out value="${file.dr_cr_marker}" /></td>
								<td><c:out value="${file.currency_1}" /></td>
								<td><c:out value="${file.account_1}" /></td>
								<td><c:out value="${file.cif1}" /></td>
								<td><c:out value="${file.amount_local_1}" /></td>
								<td><c:out value="${file.amount_loc2}" /></td>
								<td><c:out value="${file.auth_date1}" /></td>
								<td><c:out value="${file.auth_date}" /></td>
								<td><c:out value="${file.narration1}" /></td>
								<td><c:out value="${file.currency_2}" /></td>
								<td><c:out value="${file.unit}" /></td>
								<td><c:out value="${file.charge_account}" /></td>
								<td><c:out value="${file.charge_customer}" /></td>
								<td><c:out value="${file.amount_local_2}" /></td>
								<td><c:out value="${file.amount_fcy_2}" /></td>
								<td><c:out value="${file.net_amount}" /></td>
								<td><c:out value="${file.value_date}" /></td>
								<td><c:out value="${file.value_date2}" /></td>
								<td><c:out value="${file.narrative_2_cheque_number}" /></td>
								<td><c:out value="${file.chrg_amt_local}" /></td>
								<td><c:out value="${file.status}" /></td>
								<td><c:out value="${file.cheque_number}" /></td>
								<td><c:out value="${file.override}" /></td>
								<td><c:out value="${file.inputer}" /></td>
								<td><c:out value="${file.date_time}" /></td>
								<td><c:out value="${file.authorizer}" /></td>
								<td><c:out value="${file.branch_code}" /></td>
								<td><c:out value="${file.value_date3}" /></td>
								<td><c:out value="${file.amount4}" /></td>

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