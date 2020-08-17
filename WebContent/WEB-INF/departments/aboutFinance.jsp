<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Finance Department</title>

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

				<h4>Quick Links</h4>


				<ul>
					<li><a
						href="${pageContext.request.contextPath}/AboutMarketing">About
							Marketing</a></li>

				</ul>

			</div>
			<div class="rightNav">

				<h2>FINANCE DEPARTMENT</h2>


				<p>The Finance Department is tasked with managing the general expenditures and incomes of the Bank.</p>

				

				<p>
					<B>Treasury and Investments:</B>Is in charge of day management of
					cash resources. The main objectives include;
				<ol>

					<li>Invest Bank cash resources in the best yielding
						instruments</li>
					<li>Ensure Bank accounts have adequate cash resources to cater
						for daily operational needs</li>
					<li>Ensure compliance with daily reserve and liquidity reserve
						requirements</li>


				</ol>

				<p>The Finance Department is responsible for, not limited to,
					the following;</p>

				<ol>

					<li>Budgeting</li>
					<li>Financial Reporting</li>
					<li>Payments</li>
					<Li>Management of suspense Accounts</Li>
					<li>Procurement.</li>
					<li>Regulatory Reporting</li>
					<li>Fixed Asset Management.</li>

				</ol>



			</div>


		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>