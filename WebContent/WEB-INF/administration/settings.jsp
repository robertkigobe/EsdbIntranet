<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />

<style>
ul.a {
	list-style-type: circle;
}
</style>
<title>Settings</title>
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
				<h2>Quick Links:</h2>

				<Ol>

					<li><a
						href="${pageContext.request.contextPath}/SwaziBankProducts">SwaziBank
							Products</a></li>

					<li><a href="${pageContext.request.contextPath}/VisionPage">SwaziBank
							Vision, Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/History">SwaziBank
							History</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard">SwaziBank
							Notice Board</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews">Briefs
							And News</a></li>
					<li><a
						href="${pageContext.request.contextPath}/InternalAdvert">Internal
							Vacancies</a></li>
							




				</Ol>


			</div>
			<div class="rightNav">
			
			<h2>Intranet Settings </h2>
				<div>

					<ol>
					
					<li><a href="${pageContext.request.contextPath}/UploadWhatsNew">Upload
								What's New</a></li>
								
						<li><a href="${pageContext.request.contextPath}/UploadBriefs">Upload
								Briefs</a></li>
								<li><a
							href="${pageContext.request.contextPath}/UploadBereavement">Upload
								Bereavement</a></li>
						
						<li><a
							href="${pageContext.request.contextPath}/UploadNewStaff">Upload
								New Staff</a></li>
								
								<li><a
							href="${pageContext.request.contextPath}/UploadInternalAdvert">Upload
								Internal Advert</a></li>
						<li><a href="#">Upload Newsletter</a></li>

					</ol>


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