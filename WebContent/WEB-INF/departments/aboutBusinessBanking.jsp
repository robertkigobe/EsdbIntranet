<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<title>About Business Banking</title>

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
					<li><a href="#" class="list-group-item list-group-item-dark">SwaziBank Departments</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark active">Business Banking</a></li>
					<li><a href="${pageContext.request.contextPath}/AboutMarketing" class="list-group-item list-group-item-dark">Marketing Department</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage" class="list-group-item list-group-item-dark">SwaziBank Vision, Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/NewsLetter" class="list-group-item list-group-item-dark">Publications</a></li>
					
					


				</ol>

			</div>

			<div class="rightNav">

				<div class="col-md-10">
					<div class="page-header">
						<h4>BUSINESS BANKING</h4>

					</div>




					<p>The Business Banking Department is tasked with Financing big
						Projects in the Swaziland to stimulate Economic Growth. The
						Department is comprised of Corporate Business, Housing and
						Property Finance, Motor Vehicle Finance (Auto Easy) and Insurance
						Business.</p>

					<p>
						<B>Corporate Business: </B> Is in charge of financing big
						projects. For this matter we invest a lot of our energy in
						Relationship management. The various officers in Corporate
						Business, manage specific big clients. The clients are visited
						regularly, ensuring all the client needs are understood, timely
						addressed and ensuring the accounts are not over drawn. Currently
						the unit comprises of Manager Corporate Business, Corporate
						Officers that handle Business loans and Group Schemes. The group
						schemes marginally cross into housing, personal and motor vehicle
						loans for groups of thirty(30) or more employees.
					</p>

					<p>
						<B>Housing and Property Finance:</B>Is in charge of financing
						housing loans to both individuals and businesses. The properties
						include; housing plots on targeted land (farms and town plots),
						housing construction (residential and commercial) and development
						of plots. Financing is also provided for construction purposes on
						Swazi National Land (SNL). The construction on SNL is both
						residential and commercial.
					</p>

					<p>
						<B>Motor Vehicle Finance:</B>Is in charge of financing motor
						vehicle loans to both individuals and businesses. The vehicles
						include new and pre-owned up to 10 years old from today. The
						vehicles can be purchased from Swaziland and South Africa, in the
						case of South Africa, the vehicles must be form registered and
						recognized dealers. Cars manufactured from outside the South
						African market as well as rebuilt (accident damaged or cars
						written off) are not financed. The unit comprises of Motor Vehicle
						Finance Manager, Motor Vehicle Finance Assistant Manager, Business
						officers and reviews officers
					</p>

					<p>The Business Banking Department is responsible for, not
						limited to, the following;</p>

					<ol>
						<li>Securing good business loans</li>
						<li>Securing good motor vehicle loans</li>
						<li>Securing good housing loans</li>
						<li>Drive Transactional and Investment Accounts.</li>
						<Li>Increase Product awareness</Li>
						<li>Aggressive Monitoring of Loans and Collections.</li>
						<li>Collaboration with other Lending Units.</li>

					</ol>



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