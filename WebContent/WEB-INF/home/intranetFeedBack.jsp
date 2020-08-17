<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Feedback Form</title>

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
					<li><a
						href="${pageContext.request.contextPath}/IntranetFeedBack"
						class="list-group-item list-group-item-dark active">Feedback</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark ">Briefs
							and News</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage"
						class="list-group-item list-group-item-dark">SwaziBank Vision,
							Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/History"
						class="list-group-item list-group-item-dark">SwaziBank History</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard"
						class="list-group-item list-group-item-dark">SwaziBank Notice
							Board</a></li>
							<li><a href="${pageContext.request.contextPath}/NewsLetter" class="list-group-item list-group-item-dark">Publications</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs And News</a></li>
					<li><a
						href="${pageContext.request.contextPath}/InternalAdvert"
						class="list-group-item list-group-item-dark">Internal
							Vacancies</a></li>


				</ol>

			</div>

			<div class="rightNav">

				<div class="col-md-5">
					<div class="page-header">
						<h4>Intranet FeedBack</h4>

					</div>

				<div>
					<form action="IntranetFeedBack" method="post" class="form-group">
						<br>
						
						<div class="page-header">
						<h6>Category</h6>

					</div>
						<select name="aboutFeedBackSubject" class="form-control">
							<option>Choose Section</option>
							<option>Home</option>
							<option>Departments</option>
							<option>Staff Services</option>
							<option>Technical Resources</option>
							<option>Other Suggestions</option>


						</select>

						<div class="page-header">
						<h6>Message details</h6>

					</div>
						<textarea  class="form-control" rows="10" cols="50" name="aboutFeedBackDetail"
							placeholder="Leave us a note, any type of note and you are guaranteed that together we shall make our SwaziBank Intranet better...."></textarea><br>

						<input value="Submit" type="Submit" size="50" class="btn btn-primary btn-sm">

					</form>
				</div>



			</div>


		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>
	</div>
</body>
</html>