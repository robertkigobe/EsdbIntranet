<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>EswatiniBank Home</title>
<style>
div.scroll {
	position: relative;
	width: 100%;
	height: 500px;
	overflow: scroll;
}
</style>


<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/sweetalert.js"></script>
<script src="js/jquery13082019.js"></script>





</head>
<body >

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
				<div class="birthdays" style="border: 2px solid #666;">
					<table class="table  table-striped table-hover table-bordered">
						<thead class="thead-dark">
							<tr>
								<th>
									<H3>BIRTHDAYS</H3>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="file" items="${directoryList}">
								<tr>
									<td><marquee height="30" width="100%" behavior="alternate"
											style="border: 0.5px groove; marquee-speed: slow;">
											<c:out value="${file.firstname}   " />
											<c:out value="${file.surname}" />
										</marquee></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="currentNews">




					<div
						style="background-color: #eee; border: 1px dotted black; overflow: auto;">
						<table class="table  table-striped table-hover table-bordered">
							<thead class="thead-dark">
								<tr>
									<th>
										<H3>Latest Articles</H3>
									</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="file" items="${fileList}">
									<tr>

										<td><form method="post" action="ViewWhatsNew">
												<span class="glyphicon glyphicon-download"></span> <input
													type="submit" name="documentUrl" readonly
													style="clear: both; background-color: transparent; border: 0px solid; height: 20px;"
													value="${file}" />
											</form></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>



				</div>
				<div class="weather"></div>
			</div>
			
			

			<div class="rightNav">

				<header class="col-md-10" style="margin-top: 60px;">

					<div id="carouselExampleFade" class="carousel slide carousel-fade"
						data-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img class="d-block w-100" src="pictures/img31.jpg"
									alt="First slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img20.jpg"
									alt="Second slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img21.jpg"
									alt="Third slide">
							</div>

							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img22.jpg"
									alt="Third slide">
							</div>

							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img23.jpg"
									alt="Third slide">
							</div>

							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img24.jpg"
									alt="Third slide">
							</div>

							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img25.jpg"
									alt="Third slide">
							</div>

							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img36.jpg"
									alt="Third slide">
							</div>

							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img35.jpg"
									alt="Third slide">
							</div>

							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img34.jpg"
									alt="Third slide">
							</div>

							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img33.jpg"
									alt="Third slide">
							</div>

							<div class="carousel-item">
								<img class="d-block w-100" src="pictures/img32.jpg"
									alt="Third slide">
							</div>


						</div>
						<a class="carousel-control-prev" href="#carouselExampleFade"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleFade"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>

				</header>

			</div>

		</div>


	</div>
	<div class="clear"></div>
	<div>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>



	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" ></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>

</body>
</html>