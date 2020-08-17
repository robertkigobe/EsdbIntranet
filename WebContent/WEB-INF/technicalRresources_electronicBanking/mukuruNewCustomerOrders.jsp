<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>New Mukuru Order</title>
<style>
div.scroll {
	position: relative;
	width: 100%;
	height: 500px;
	overflow: scroll;
}
</style>


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



				<form method="post" action="CardproductionNewCard"
					class="form col-md-12">
					<div class="form-group"  >
						<input type="text" class="form-control" name="branch" id="branch"
							value="${branch}" required readonly></div>
							
					<div class="form-group"  style ="display: none;">
						<input type="password" class="form-control" name="password"
							id="password" value="${password}" required readonly>

					</div>

					<button type="submit" class="btn btn-primary btn-lg btn-block">New
						Card</button>

				</form>
			</div>
			<div class="rightNav">
				<div class="cotainer">
					<div class="container page-header">
						<h3>Mukuru Order Tracking</h3>

					</div>

					

					<form method="post" action="MukuruNewOrder">
						<div class="form-row">
						
						<div class="form-group col-md-2">
								<label for="transactions_Order_Confirmed_Date">Order Date</label> <input type="date"
									class="form-control" name="transactions_Order_Confirmed_Date" id="transactions_Order_Confirmed_Date" value="${transactions_Order_Confirmed_Date}"
									required >
							</div>
							
						<div class="form-group col-md-2">
								<label for="sheet_ref">Sheet Ref</label> <input type="text"
									class="form-control" name="sheet_ref" value="${sheet_ref}" required>
							</div>
							
							<div class="form-group col-md-2">
								<label for="transaction_T24_Ref">T24 Ref</label> <input type="text"
									class="form-control" name="transaction_T24_Ref" value="${transaction_T24_Ref}" required>
							</div>
							
							<div class="form-group col-md-2">
								<label for="transaction_order_no">Order No</label> <input type="text"
									class="form-control" name="transaction_order_no" value="${transaction_order_no}" required>
							</div>
							

							<div class="form-group col-md-2">
								<label for="transaction_recipient_pin">National Id</label> <input type="text"
									class="form-control" name="transaction_recipient_pin" value="${transaction_recipient_pin}" required>
							</div>
							
							
							<div class="form-group col-md-4">
								<label for="transaction_recipient">Customer Name</label> <input type="text"
									class="form-control" name="transaction_recipient" id="transaction_recipient" value="${transaction_recipient}"
									required >
							</div>
							

						</div>
						<div class="form-row">

							<div class="form-group col-md-4">
								<label for="transactions_teller">Teller Name</label> <input type="text"
									class="form-control" name="transactions_teller" id="transactions_teller" value="${transactions_teller}"
									required >
							</div>
							
							<div class="form-group col-md-2">					
								<label for="inputCity">Branch</label> 
								<select name="branch"
									class="form-control" required>

									<option></option>
									<option>Mbabane</option>
									<option>Manzini</option>
									<option>Nhlanngano</option>
									<option>Siteki</option>
									</select>
									
									
										
	
	String transaction_order_no;
	String transactions_Order_Completed_Date;
	float transactions_Ordered_SZL;
	float transaction_Issued_SZL;
									
									
							</div>
							
							
							
							<div class="form-group col-md-2">
								<label for="transactions_teller">Teller Name</label> <input type="text"
									class="form-control" name="transactions_teller" id="transactions_teller" value="${transactions_teller}"
									required >
							</div>
							
							<div class="form-group col-md-5">
								<label for="inputCity">Account Number</label> <input
									type="number" class="form-control" name="accountNumber" pattern=".{11,11}"
									 required value="${accountNumber}">
							</div>
						</div>
						<div class="form-row">


							<div class="form-group col-md-2">
								<label for="inputCity">National ID</label> <input type="text"
									class="form-control" name="nationId" value="${nationId}"
									required>
							</div>

							<div class="form-group col-md-5">
								<label for="inputCity">Physical Address</label> <input
									type="text" class="form-control" name="physicalAddress"
									value="${physicalAddress}" required>
							</div>
							<div class="form-group col-md-5">
								<label for="inputCity">Postal Address</label> <input type="text"
									class="form-control" name="postalAdress"
									value="${postalAdress}" required>
							</div>

						</div>


						<div class="form-row">

							<div class="form-group col-md-2">
								<label for="inputCity">Mobile Number</label> <input
									type="number" class="form-control" name="mobileNumber"
									value="${mobileNumber}" required placeholder="7...">
							</div>
							<div class="form-group col-md-2">
								<label for="inputCity">Telephone Number</label> <input
									type="number" class="form-control" name="telephoneNumber"
									value="${telephoneNumber}" placeholder="2...">
							</div>

							<div class="form-group col-md-4">
								<label for="inputCity">Email Adress</label> <input type="text"
									class="form-control" name="email" value="${email}">
							</div>

							<div class="form-group col-md-2">
								<label for="inputCity">meta1</label> <input type="text"
									class="form-control" name="branch" value="${branch}" readonly>
							</div>
							<div class="form-group col-md-2">
								<label for="inputCity">Meta2</label> <input type="password"
									class=".d-none" name="password" value="${password}" readonly>
							</div>
						</div>

						<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
					</form>

				</div>
			</div>
		</div>


	</div>

	<div class="clear"></div>
	<div>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>
	
	<script>
		 function(){}
	</script>

</body>
</html>