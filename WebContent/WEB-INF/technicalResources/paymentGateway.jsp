<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Payment Gateway</title>
<style type="text/css">
body {
	background-color: #f6f6f5;
}

body {
	background-color: #d2e0f1;
}

html, body {
	width: 100%;
}

table {
	margin: 0 auto;
	border-collapse: collapse;
}

h1 {
	color: 101010;
	text-align: center;
}

table, th, td {
	border: 1px solid #101010;
	padding: 5px;
}

p {
	font-family: verdana;
	font-size: 20px;
}
</style>

<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/HomePage.css" rel="stylesheet" type="text/css" />

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-3.1.1.min.js"></script>
<script
	src="https://test.oppwa.com/v1/paymentWidgets.js?checkoutId={checkoutId}"></script>
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
						href="${pageContext.request.contextPath}/AboutMarketing"
						class="list-group-item list-group-item-dark active">Marketing
							Department</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark">SwaziBank
							Departments</a></li>
					<li><a href="#" class="list-group-item list-group-item-dark ">Business
							Banking</a></li>
					<li><a href="${pageContext.request.contextPath}/VisionPage"
						class="list-group-item list-group-item-dark">SwaziBank Vision,
							Mission And Core Values</a></li>
					<li><a href="${pageContext.request.contextPath}/NewsLetter"
						class="list-group-item list-group-item-dark">Publications</a></li>




				</ol>

			</div>

			<div class="rightNav">

				<div class="col-md-10">
					<div class="page-header">
						<h4>Payment Gateway</h4>



						<div>
						
						<!-- this is numbe one -->

							<table>


								<thead>
									<td><img src="pictures/eftlogo.png" alt="EFT Corp"></td>
									<td><h1>Merchant Form</h1></td>
								</thead>
								<form action="pay.php" method="post">
									<tbody>
										<tr>
											<td>Amount:</td>
											<td><input type="text" name="amount" /></td>
										</tr>
										<tr>
											<td colspan="2" style="text-align: center;"><input
												type="submit"></input></td>
										</tr>
									</tbody>
								</form>
							</table>

						</div>

						<div>
						
						<!-- this is numbe two -->
							<table>
								<tr>
									<td><img src="pictures/eftlogo.png" alt="EFT Corp"></td>
									<td><h1>Pay</h1></td>
								</tr>
								<tr>
									<td>Please pay R<?php echo $amount;?></td>
								</tr>
								<tr>
									<td colspan="2">
										<form action="http://eftcorp.co/smspay/payResult.php"
											class="paymentWidgets" data-brands="VISA MASTER AMEX"></form>
									</td>
								</tr>
							</table>
						</div>


					</div>

					<div>
					
					<!-- this is numbe three -->

						<table>
							<tr>
								<td><img src="pictures/eftlogo.png" alt="EFT Corp"></td>
								<th>
									<?php
          if (preg_match("/^(000\.000\.|000\.100\.1|000\.[36])/",$decodedData['result']['code']))
          {
              echo 'Payment Successful';
					}
					else {
						echo 'Payment Failed';
					}
					?>
								</th>
							</tr>
							<tr>
								<td>Result Code</td>
								<td>
									<?php echo $decodedData['result']['code']; ?>
								</td>
							</tr>
							<tr>
								<td>Result-Description</td>
								<td>
									<?php echo $decodedData['result']['description']; ?>
								</td>
							</tr>
							<tr>
								<td>id</td>
								<td>
									<?php echo $decodedData['id']; ?>
								</td>
							</tr>
							<tr>
								<td>paymentType</td>
								<td>
									<?php echo $decodedData['paymentType']; ?>
								</td>
							</tr>
							<tr>
								<td>paymentBrand</td>
								<td>
									<?php echo $decodedData['paymentBrand']; ?>
								</td>
							</tr>
							<tr>
								<td>amount</td>
								<td>
									<?php echo $decodedData['amount']; ?>
								</td>
							</tr>
							<tr>
								<td>currency</td>
								<td>
									<?php echo $decodedData['currency']; ?>
								</td>
							</tr>
							<tr>
								<td>descriptor</td>
								<td>
									<?php echo $decodedData['descriptor']; ?>
								</td>
							</tr>
						</table>

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