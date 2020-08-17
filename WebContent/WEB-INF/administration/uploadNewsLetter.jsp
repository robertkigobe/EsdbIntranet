<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>MD's Office Administration</title>
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
				<h2>Quick Links:</h2>

				<Ol>

					<li><a
						href="${pageContext.request.contextPath}/SwaziBankProducts">SwaziBank	Products</a></li>

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
			<div class="rightNav">%;">
					<h2>Upload Brief (PDF Format only):</h2>

					<form action=UploadBriefs method="post"
						enctype="multipart/form-data">


						<table>
							
							<tr>
								<td>File UpLoad :</td>
								<td><input type="file" name="fileUpLoad" size="50" required="required" accept="application/pdf"></td>

							</tr>
							<tr>
								<td>Action :</td>
								<td colspan="1"><input type="submit"
									value="Upload Document" size="50"></td>

							</tr>
						</table>
					</form>
				</div>


				</div>
			</div>
		</div>

		<div class="clear"></div>
		<div class="footer" id="footer" name="footer">
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>