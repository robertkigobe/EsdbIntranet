<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<title>New Bad Loan</title>
</head>
<body>
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

				<Ol>


					<li><a href="${pageContext.request.contextPath}/History">SwaziBank
							History</a></li>
					<li><a href="${pageContext.request.contextPath}/NoticeBoard">SwaziBank
							Notice Board</a></li>
					<li><a href="${pageContext.request.contextPath}/BriefsAndNews">Briefs
							And News</a></li>
					<li><a
						href="${pageContext.request.contextPath}/IntranetFeedBack">Feedback</a></li>
					<li><a
						href="${pageContext.request.contextPath}/InternalAdvert">Internal
							Vacancies</a></li>


				</Ol>
			</div>


			<div class="rightNav">
				<div
					style="background-color: #eee; border: 1px dotted black; overflow: auto;">
					<table border="1">
						<caption>
							<h2>Insert New Bad Loan</h2>
						</caption>
						<thead>
							<tr>
								<th>Item</th>
								<th>Value</th>


							</tr>
						</thead>

						<form action=BadLoanNew method="post">
							<tr>
								<td><input type="text" value="Year of Entry" readonly
									style="border-style: outset;" /></td>
								<td><input type="date" name="year"
									style="border-style: outset;" /></td>
							</tr>
							
							<tr>
								<td><input type="text" value="Account No" readonly
									style="border-style: outset;" /></td>
								<td><input type="text" name="accno"
									style="border-style: outset;" /></td>
							</tr> 
							<tr>
								<td><input type="text" value="CIF" readonly
									style="border-style: outset;" /></td>
								<td><input type="text" name="cif"
									style="border-style: outset;" /></td>
							</tr>
							<tr>
								<td><input type="text" value="National Identification No."
									readonly style="border-style: outset;" /></td>
								<td><input type="text" name="nationalid"
									style="border-style: outset;" /></td>
							</tr>
							<tr>
								<td><input type="text" value="Department" readonly
									style="border-style: outset;" /></td>
								<td><select name="dept" style="border-style: outset;">

										<option></option>
										<option>AGRIC</option>
										<option>AUTOEASY</option>
										<option>COMMERCIAL</option>
										<option>CORPORATE</option>
										<option>EMPOWERMENT</option>
										<option>HOUSING</option>
										<option>OVERDUE</option>
										<option>OVERDRAFTS</option>
										<option>OPERATIONS</option>
										<option>RECOVERIES</option>
										<option>STAFF</option>
										<option>VIP</option>
								</select></td>

							</tr>
							<tr>
								<td><input type="text" value="Type" readonly
									style="border-style: outset;" /></td>
								<td><select name="type" style="border-style: outset;">
										<option></option>
										<option>AUTO EASY - INSURANCE PREMIUM</option>
										<option>AUTO EASY - PRIVATE VEHICLE FIN</option>
										<option>AUTO EASY - BUSINESS VEHICLE FIN</option>
										<option>AGRICULTURAL LOAN</option>
										<option>BAD DEBTS-COMPANY CHEQUE ACC</option>
										
										<option>BANK FUNDS</option>
										<option>BRIDGING FINANCE LOAN</option>
										<option>BUSINESS LOANS</option>
										
										<option>CORPORATE BUSINESS LOAN</option>
										<option>CORPORATE CLASSIC CHEQUE AC</option>
										<option>CORPORATE MOTOR VEHICLE PRIVATE LOA</option>
										<option>CORPORATE SCHEMES REVOLVING CREDIT</option>
										<option>CIVIL SERVICE</option>
										<option>CIVIL SERVANTS CAR SCHEME</option>
										<option>COMPANY CHEQUE ACCOUNT</option>
										<option>CORPORATE BUSINESS LOANS</option>
										<option>CORPORATE GROUP SCHEME PERSONAL LOA</option>
										<option>CORPORATE BUSINESS MOTOR VIHICLE FI</option>
										<option>EMPOWERMENT LOANS</option>
										<option>ESTATE LOANS</option>
										<option>IFAD FUNDS</option>
										<option>INDIVIDUAL CHEQUE ACCOUNT</option>
										<option>KHULULEKA PERSONAL LOAN</option>									
										<option>LUDVONDVOLO LOAN</option>
										<option>MOTOR VEHICLE FINANCE BUSINESS</option>
										<option>OVERDUE LOANS 0 BRANCH</option>
										<option>MOTOR VEHICLE FINANCE</option>
										<option>MOTOR VEHICLE PRIVATE LOAN</option>
										<option>MOTOR VEHICLE BUSINESS LOAN</option>
										<option>OVERDUE LOANS - BRANCH</option>
										<option>PERSONAL LOAN</option>
										<option>PREMIER SILVER REVOLVING CREDIT</option>
										<option>RECOVERIES</option>											
										<option>RURAL HOUSING LOAN - RESIDENTIAL</option>
										<option>RURAL STAFF HOUSING - RESIDENTIAL</option>
										<option>RURAL STAFF HOUSING 0 RESIDENTIAL</option>
										<option>RURAL HOUSING LOAN 0 RESIDENTIAL</option>
										<option>RURAL HOUSING LOAN - COMMERCIAL</option>
										<option>SMME BRIDGING FINANCE FACILITY</option>
										<option>STAFF LOANS</option>
										<option>STAFF CAR LOAN</option>
										<option>SPTC LOAN</option>
										<option>SSE LOAN (SMALL SCALE ENT GTEE)</option>
										<option>SILULU (CONSOLIDATED) LOANS</option>
										<option>SMME SSELG SCHEME</option>										
										<option>URBAN HOUSING LOAN0COMMERCIAL</option>
										<option>URBAN STAFF HOUSING-RESIDENTIAL</option>
										<option>UMLIBA EDUCATIONAL LOAN</option>
										<option>URBAN HOUSING LOAN-COMMERCIAL</option>
										<option>URBAN HOUSING LOAN-RESIDENTIAL</option>
										<option>VIP CHEQUE ACCOUNT 0 PLATINUM</option>
										<option>VIP CHEQUE ACCOUNT - PLATINUM</option>
										<option>VIP CHEQUE ACCOUNT - GOLD</option>
										<option>VIP REVOLVING CREDIT</option>
										<option>VIP SILVER REVOLVING CREDIT</option>
										<option>VIP CHEQUE ACCOUNT - SILVER</option>
										<option>VIP CHEQUE ACCOUNT - GOLD</option>
										<option>VIP CHEQUE ACCOUNT 0 SILVER</option>

								</select></td>

							</tr>
							<tr>
								<td><input type="text" value="Customer Name" readonly
									style="border-style: outset;" /></td>
								<td><input type="text" name="customer"
									style="border-style: outset;" /></td>
							</tr>
							<tr>
								<td><input type="text" value="Current Balance" readonly
									style="border-style: outset;" /></td>
								<td><input type="number" name="currentBalance" step="0.01"
									style="border-style: outset;" /></td>
							</tr>

							<tr>

								<td><input type="submit" value="Submit bad Loan" size="50"></td>
							</tr>

						</form>

					</table>
				</div>
			</div>
		</div>

		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>







</body>
</html>