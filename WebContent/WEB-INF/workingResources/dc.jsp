<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>DC</title>
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
				<h1>DC's for Feb 2018</h1>

				<div class="scroll">



					<form method="post" action="DC">
						<H4>
							Search: First Name or Surname:<input type="text" name="seachName"
								placeholder="Account Number.."> <a
								href="${pageContext.request.contextPath}/DC">Clear Filters</a>
						</H4>
					</form>

					<table border="1">


						<thead>
							<tr>
								<th>ID</th>
								<th>ACCOUNTNUMBER</th>
								<th>SIGN</th>
								<th>AMOUNTLCY</th>
								<th>NARRATIVE</th>
								<th>VALUEDATE</th>
								<th>INPUTTER</th>
								<th>AUTHORISER</th>



							</tr>
						</thead>
						<c:forEach var="file" items="${ft23List}">



							<tr>
								<td><c:out value="${file.id}" /></td>
								<td><c:out value="${file.accountnumber}" /></td>
								<td><c:out value="${file.sign}" /></td>
								<td><c:out value="${file.amountlcy}" /></td>
								<td><c:out value="${file.narrative}" /></td>
								<td><c:out value="${file.valuedate}" /></td>
								<td><c:out value="${file.inputter}" /></td>
								<td><c:out value="${file.authoriser}" /></td>

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