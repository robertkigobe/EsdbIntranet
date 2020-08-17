<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Marketing Home</title>
<style type="text/css">
ul.a {
	list-style-type: circle;
}
</style>

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
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


				<div class="currentNews">


					<div class="a">


						<h4>Quick Links</h4>


						<ul>
							<li><a href="${pageContext.request.contextPath}/AboutMarketing">About Marketing</a></li>
							<li><a href="${pageContext.request.contextPath}/SwaziBankProducts">Product Briefs</a></li>
													
						</ul>


					</div>



				</div>
				<div class="weather"></div>
			</div>
			<div class="rightNav">
				<div id="slider">
					<img class="mySlides" src="pictures/marketing1.jpg"
						style="width: 100%"> <img class="mySlides"
						src="pictures/marketing2.JPG" style="width: 100%"> <img
						class="mySlides" src="pictures/marketing3.JPG" style="width: 100%">
					<img class="mySlides" src="pictures/marketing4.JPG"
						style="width: 100%"> <img class="mySlides"
						src="pictures/marketing5.JPG" style="width: 100%">
				</div>
			</div>
			<script>
				var myIndex = 0;
				carousel();

				function carousel() {
					var i;
					var x = document.getElementsByClassName("mySlides");
					for (i = 0; i < x.length; i++) {
						x[i].style.display = "none";
					}
					myIndex++;
					if (myIndex > x.length) {
						myIndex = 1
					}
					x[myIndex - 1].style.display = "block";
					setTimeout(carousel, 4000); // Change image every 4 seconds
				}
			</script>

		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>