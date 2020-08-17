<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Branch Cards</title>
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


				<div>






					<form method="post" action="CardproductionBranchCardsSearch"
						class="form-horizontal">



						<div class="col-md-10">


							<div class="form-row">

								<div class="form-group" style ="display: none;">


									<input type="text" class="form-control" name="branch"
										value="${branch}" readonly> <input type="password"
										class="form-control" name="password" value="${password}"
										readonly>
								</div>
								<div class="form-group">
									<div class="form-group col-md-7">
										<input type="text" name="cif" class="form-control"
											placeholder="enter cif">
									</div>

									<div class="form-group col-md-7">
										<button type="submit" class="btn btn-primary btn-sm btn-block">
											Search</button>
									</div>
								</div>




							</div>

						</div>
					</form>
					<form method="post" action="CardproductionLogin"
						class="form-horizontal">



						<div class="col-md-10">


							<div class="form-row">

								<div class="form-group">

									<div class="form-group col-md-7">
										<button type="submit" class="btn btn-primary btn-sm btn-block">Clear
											Search</button>
									</div>
									<div class="form-group col-md-0" style ="display: none;">
										<input type="text" class="form-control" name="branch"
											value="${branch}" readonly> <input type="password"
											class="form-control" name="password" value="${password}"
											readonly>
									</div>


								</div>
							</div>

						</div>
					</form>



					<div class="scroll">
						<table class="table  table-striped table-hover table-bordered">


							<thead class="thead-dark">

								<tr>
									<th>Application Date</th>
									<th>Name on card</th>
									<th>Cif</th>
									<th>Card Type</th>
								
									<th>Card Printed</th>
									<th>Date printed</th>
								</tr>


							</thead>
							<tbody>
								<c:forEach var="file" items="${cardList}">
									<tr>
										<td><c:out value="${file.applicationDate}" /></td>
										<td><c:out value="${file.nameOnCard}" /></td>
										<td><c:out value="${file.cif}" /></td>
										<td><c:out value="${file.accountType}" /></td>
									
										<td><c:out value="${file.printed}" /></td>
										<td><c:out value="${file.printDate}" /></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
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