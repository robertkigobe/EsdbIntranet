<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Branch Entries</title>
<style>
div.scroll {
	position: relative;
	width: 100%;
	height: 500px;
	overflow: scroll;
}
</style>


<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/HomePage.css" rel="stylesheet" type="text/css" />

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

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

				<ol class="list-group">

						<li class="list-group-item">
							<h4>Quick Links</h4>
						</li>
						<li><a href="${pageContext.request.contextPath}/Directory"  class="list-group-item list-group-item-action active">SwaziBank Directory</a></li>
						<li><a href="${pageContext.request.contextPath}/VisionPage"
							class="list-group-item list-group-item-dark">SwaziBank Vision, Mission And Core
								Values</a></li>
						<li><a href="${pageContext.request.contextPath}/History" class="list-group-item list-group-item-dark">SwaziBank
								History</a></li>
						<li><a href="${pageContext.request.contextPath}/NoticeBoard" class="list-group-item list-group-item-dark">SwaziBank
								Notice Board</a></li>
						<li><a
							href="${pageContext.request.contextPath}/BriefsAndNews" class="list-group-item list-group-item-dark">Briefs
								And News</a></li>
						<li><a
							href="${pageContext.request.contextPath}/NewsLetter" class="list-group-item list-group-item-dark">Publications</a></li>
						


					</ol>
			</div>
			<div class="rightNav">
			
			<div class="page-header">
									<h4>Dirty Entries </h4>

								</div>

				<div>

					<form method="post" action="DataCleanUpUpdate"
						class="form-horizontal" style="margin: 20px;">

							<div class="form-row">

								<div class="form-group">
									<input type="text" class="form-control" name="cif" placeholder="Enter cif to clean"> 
									<button type="submit" class="btn btn-primary btn-sm btn-block"> Search</button>
								</div>
								
								<input type="text" class="form-control" name="branch" value="${branch}">
								<input type="text" class="form-control" name="password" value="${password}">
					
								
						</div>
					</form>
					
					<div class="alert alert-danger" role="alert">${error}</div>
					



					<div class="scroll">
						<table class="table  table-striped table-hover table-bordered">


							<thead class="thead-dark">

								<tr>
								<th>CIF</th>
									<th>Name</th>
									<th>Surname</th>
									<th>Occupation</th>
									<th>National Id</th>
																
								</tr>
								
							</thead>
							<tbody>
								<c:forEach var="file" items="${dataCleanUpListA}">
									<tr>
									<td><c:out value="${file.cif}" /></td>
										<td><c:out value="${file.name1}" /></td>
										<td><c:out value="${file.name2}" /></td>
										<td><c:out value="${file.street}" /></td>
										<td><c:out value="${file.nationalId}" /></td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
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