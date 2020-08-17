<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/HomeStyle.css" rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Exported reports to Excel</title>
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
			<div class="leftNav" style="float: left; width: 20%;">
				<h2>Quick Links:</h2>

				<ul>


					<li><a href="#">SwaziBank Products</a></li>

					<li><a href="#">Links</a></li>

				</ul>


			</div>

			<div class="rightNav" style="float: right; width: 80%;">
				<div
					style="background-color: #eee; width: 700px; height: 500px; border: 1px dotted black; overflow: auto;">
					<table border="1" cellpadding="5">

						<h2>Briefs</h2>

						<thead>
							<tr>
								<th style="width: 15%">Document Name</th>
							</tr>
						</thead>
						<%
							String totalPath = "http://localhost:8080/SwaziBankIntranetLive/docs/";
						%>
						<c:forEach var="file" items="${fileList}">
							<tr>

								<td><form method="post" action="ExcelExports">
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
</body>
</html>