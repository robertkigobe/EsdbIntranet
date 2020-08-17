<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Bad Loans</title>
<style type="text/css">
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
				<h1>Bad Loans Directory</h1>
				<div class="scroll">

						

							<form method="post" action="BadLoans">
								<H4>Search by Customer Name, Cif, National ID, Account No:<input type="text" name="seachName" placeholder="Search..">
								<a href="${pageContext.request.contextPath}/BadLoans">Clear Filters</a></H4>
							</form>
						

					<table border="1">

						<thead>
							<tr>


								<th>Year</th>
								<th>Account No</th>
								<th>CIF</th>
								<th>National ID</th>
								<th>Department</th>
								<th>Type</th>
								<th>Customer Name</th>
								<th>Current Bal</th>

							</tr>
						</thead>
						<c:forEach var="file" items="${directory}">
							<tr>
								<td><c:out value="${file.year}" /></td>
								<td><c:out value="${file.accNo}" /></td>
								<td><c:out value="${file.cif}" /></td>
								<td><c:out value="${file.nationalId}" /></td>
								<td><c:out value="${file.dept}" /></td>
								<td><c:out value="${file.type}" /></td>
								<td><c:out value="${file.customer}" /></td>
								<td><c:out value="${file.currentBalance}" /></td>

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