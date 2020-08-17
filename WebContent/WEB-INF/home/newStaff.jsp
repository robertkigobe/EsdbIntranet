<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>New Staff</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="js/bootstrap.js"></script>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>

<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/HomePage.css" rel="stylesheet" type="text/css" />

<style>
* {
	font-size: 15px;
	line-height: 1.428;
}
</style>
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
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-action active">Briefs
							and News</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage"
						class="list-group-item list-group-item-dark">SwaziBank Vision,
							Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/History"
						class="list-group-item list-group-item-dark">SwaziBank History</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard"
						class="list-group-item list-group-item-dark">SwaziBank Notice
							Board</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs And News</a></li>
					<li><a
						href="${pageContext.request.contextPath}/IntranetFeedBack"
						class="list-group-item list-group-item-dark">Feedback</a></li>
					<li><a
						href="${pageContext.request.contextPath}/InternalAdvert"
						class="list-group-item list-group-item-dark">Internal
							Vacancies</a></li>


				</ol>

			</div>

			<div class="rightNav">


				<div class="col-md-12">
					<div class="page-header">
						<h4>Notice Board</h4>

					</div>
					<div>
						<table class="table  table-striped table-hover table-bordered">


							<thead class="thead-dark">


								<tr>
									<th >Staff Briefs</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="file" items="${fileList}">
									<tr>

										<td><form method="post" action="ViewNewStaff"><span class="glyphicon glyphicon-download"></span>

												<input type="submit" name="documentUrl" readonly
													style="clear: both; background-color: transparent; border: 0px solid; height: 20px;"
													value="${file}" />

											</form></td>


									</tr>
								</c:forEach>
						</table>
					</div>
				</div>
				
				<div class="clear"></div>
				<div>
					<jsp:include page="../utilities/_footer.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
</html>