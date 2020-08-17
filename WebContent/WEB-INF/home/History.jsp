<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>

<title>SwaziBank History</title>


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
					<li><a href="${pageContext.request.contextPath}/History" class="list-group-item list-group-item-dark active">SwaziBank
							History</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs and News</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage"
						class="list-group-item list-group-item-dark">SwaziBank Vision,
							Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard"
						class="list-group-item list-group-item-dark">SwaziBank Notice
							Board</a></li>
					<li><a href="${pageContext.request.contextPath}/NewsLetter"
						class="list-group-item list-group-item-dark">Publications</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews"
						class="list-group-item list-group-item-dark">Briefs And News</a></li>
					<li><a
						href="${pageContext.request.contextPath}/IntranetFeedBack"
						class="list-group-item list-group-item-dark">Feedback</a></li>
					<li><a
						href="${pageContext.request.contextPath}/InternalAdvert"
						class="list-group-item list-group-item-dark">Internal
							Vacancies</a></li>

					<li><a
						href="${pageContext.request.contextPath}/FileUploadDbServlet"
						class="list-group-item list-group-item-dark">Uploads</a></li>
				</ol>

			</div>

			<div class="rightNav">

				<div class="col-md-10">
					<div class="page-header">
						<h4>SwaziBank History</h4>

					</div>


					<blockquote class="blockquote">Swazibank was formed
						under the backdrop of a small economy and at that time the country
						was still under the colonial rule and control. when the great
						visionary King Sobhuza ii established the Swaziland Credit and
						Savings Bank, in august 1965, he was attempting to address the
						economic aspect of development of the people of the kingdom. As a
						wise and visionary king, his majesty wanted his nation to develop
						in all spheres of life, and one area that needed attention at that
						time was the economic empowernment of Swazis.</blockquote>

					<blockquote class="blockquote">The main objective of
						the Bank was the provision of Small Agricultural Loans to support
						the growing of maize, cotton and tobacco on a commercial scale.
						Small-scale enterprise that were supervisedby the Small Enterprise
						Development Corporation (Sedco) were also sponsored by the same
						Bank. The Bank also had a mandate to provide finance for low cost
						housing that would eventually create Swazi property owners in
						urban areas.</blockquote>

					<blockquote class="blockquote">It is encouraging to
						note that this noble idea and vision of King Sobhuza ii has been
						steadfastly implemented over the years, enabling many indigenous
						Swazi people to rise from the ashes of poverty to become giants in
						both agro-business and commercial enterprises.</blockquote>

					<blockquote class="blockquote">However, a combination
						of factors started to mar an otherwise excellent dream of King
						Sobhuza ii, to establish a Development Bank that will assist in
						empowering Swazi’s economically. As the Bank began to experience
						problems that moved it away from its establishment mandate to
						become a great liability to the government and the tax payer. For
						about three decades the authorities of the country had been
						battling unsuccessfully to resuscitate the institution to serve
						its purpose. Unfortunate possibilities and unfavourable options
						such as closing the bank would now and again appear as a lasting
						solution.</blockquote>

					<blockquote class="blockquote">Today it seems like the
						Bank has never come a long way having crossed many deep rivers and
						climbed the steepest of mountains. The growth of the Bank has been
						so fast in such a way that it has become its greatest risk. It is
						for that reason that the Bank is fully cognisant of the fact that
						in order to sustain itself and consolidate its leading position,
						it needs to form strategic alliances and effective networks with
						international and regional Banks or similar Institutions.</blockquote>



				</DIV>
			</div>
		</div>

		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>