<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<title>Security Awareness</title>

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
					<li><a href="#" class="list-group-item list-group-item-dark">SwaziBank
							Departments</a></li>
					<li><a href="#"
						class="list-group-item list-group-item-dark active">Business
							Banking</a></li>
					<li><a
						href="${pageContext.request.contextPath}/AboutMarketing"
						class="list-group-item list-group-item-dark">Marketing
							Department</a></li>
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
						<h4>Security Awareness</h4>

					</div>

					<h3>PCI Data Storage Do’s and Don’ts</h3>


					<p>One of the most important Requirements of the Payment Card
						Industry’s Data Security Standard (PCI DSS) is; to “protect stored
						cardholder data.” The public assumes merchants and nancial
						institutions will protect data on payment cards to thwart theft
						and prevent unauthorized use. But merchants should take note:
						Requirement 3 applies only if cardholder data is stored. Merchants
						who do not store any cardholder data automatically provide
						stronger protection by having eliminated a key target for data
						thieves.</p>

					<p>For merchants who have a legitimate business reason to store
						cardholder data, it is important to understand what data elements
						PCI DSS allows them to store and what measures they must take to
						protect those data. To prevent unauthorized storage, only Council
						certi ed PIN entry devices and payment applications may be used.
						PCI DSS compliance is enforced by the major payment card brands
						who established the PCI DSS and the PCI Security Standards
						Council: American Express, Discover Financial Services, JCB
						International, MasterCard Worldwide and Visa Inc.</p>

					<h4>Basic PCI Data Storage Guidelines for Merchants</h4>

					<p>Cardholder data refers to any information contained on a
						customer’s payment card. The data is printed on either side of the
						card and is contained in digital format on the magnetic stripe
						embedded in the backside of the card. Some payment cards store
						data in chips embedded on the front side. The front side usually
						has the primary account number (PAN), cardholder name and
						expiration date. The magnetic stripe or chip holds these plus
						other sensitive data for authentication and authorization.</p>

					<p>In general, no payment card data should ever be stored by a
						merchant unless it’s necessary to meet the needs of the business.
						Sensitive data on the magnetic stripe or chip must never be
						stored. Only the PAN, expiration date, service code, or cardholder
						name may be stored, and merchants must use technical precautions
						for safe storage (see back of this fact sheet for a summary). The
						matrix below shows basic “do’s” and “don’ts” for data storage
						security.</p>

					<table class="table table-sm">
						<thead>
							<tr>

								<th scope="col">Data Do’s</th>
								<th scope="col">Data Don’t’s</th>

							</tr>
						</thead>
						<tbody>
							<tr>

								<td><p>Do understand where payment card data ows for
										the entire transaction process</p></td>
								<td><p>Do not store cardholder data unless it’s
										absolutely necessary</p></td>

							</tr>
							<tr>

								<td><p>Do verify that your payment card terminals
										comply with the PCI personal identi cation number (PIN) entry
										device (PED) security requirements</p></td>
								<td><p>Do not store sensitive authentication data
										contained in the payment card’s storage chip or full magnetic
										stripe, including the printed 3-4 digit card validation code
										on the front or back of the payment card after authorization</p></td>

							</tr>
							<tr>

								<td><p>Do verify that your payment applications comply
										with the Payment Application Data Security Standard (PA-DSS)</p></td>
								<td><p>Do not have PED terminals print out personally
										identi able payment card data; printouts should be truncated
										or masked</p></td>

							</tr>
							<tr>

								<td><p>Do retain (if you have a legitimate business
										need) cardholder data only if authorized, and ensure it’s
										protected</p></td>
								<td><p>Do not store any payment card data in payment
										card terminals or other unprotected endpoint devices, such as
										PCs, laptops or smart phones</p></td>

							</tr>
						</tbody>
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