<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>momentum Statements</title>
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

			<div>


				<h4>Momentum Statements</h4>


				<form method="post" action="MomentumStatementsReport"
					class="form-horizontal">
					<div class="form-row">



						<div class="form-group col-md-2">
							<label for="dateOfBirth">Client Code:</label> <input type="text"
								name="clientcode" class="form-control"
								placeholder="search client code">
						</div>

						<div class="form-group col-md-2">
							<label for="startDate">Start Date:</label> <select
								name="startDate" class="form-control" required>

								<option>Choose Start Date</option>
								<option>01-JAN-19</option>
								<option>01-FEB-19</option>
								<option>01-MAR-19</option>
								<option>01-APR-19</option>
								<option>01-MAY-19</option>
								<option>01-JUN-19</option>
								<option>01-JUL-19</option>
								<option>01-AUG-19</option>
								<option>01-SEP-19</option>
								<option>01-OCT-19</option>
								<option>01-NOV-19</option>
								<option>01-DEC-19</option>
								<option>01-JAN-20</option>
								<option>01-FEB-20</option>
								<option>01-MAR-20</option>
								<option>01-APR-20</option>
								<option>01-MAY-20</option>
								<option>01-JUN-20</option>
								<option>01-JUL-20</option>
								<option>01-AUG-20</option>
								<option>01-SEP-20</option>
								<option>01-OCT-20</option>
								<option>01-NOV-20</option>
								<option>01-DEC-20</option>



							</select>
						</div>

						<div class="form-group col-md-2">
							<label for="endDate">End Date:</label> <select name="endDate"
								class="form-control" required>

								<option>Choose End Date</option>
								<option>31-JAN-19</option>
								<option>29-FEB-19</option>
								<option>31-MAR-19</option>
								<option>30-APR-19</option>
								<option>31-MAY-19</option>
								<option>30-JUN-19</option>
								<option>31-JUL-19</option>
								<option>31-AUG-19</option>
								<option>30-SEP-19</option>
								<option>31-OCT-19</option>
								<option>30-NOV-19</option>
								<option>31-DEC-19</option>
								<option>31-JAN-20</option>
								<option>29-FEB-20</option>
								<option>31-MAR-20</option>
								<option>30-APR-20</option>
								<option>31-MAY-20</option>
								<option>30-JUN-20</option>
								<option>31-JUL-20</option>
								<option>31-AUG-20</option>
								<option>30-SEP-20</option>
								<option>31-OCT-20</option>
								<option>30-NOV-20</option>
								<option>31-DEC-20</option>



							</select>
						</div>



					</div>
					<div class="form-group col-md-1">
						<button type="submit"
							class="btn btn-primary btn-lg btn-block form-control">Search</button>

					</div>
				</form>
				<a href="${pageContext.request.contextPath}/MomentumStatements"
					class="form-group-item">Clear Filters</a>



				<div class="scroll">
					<table class="table  table-striped table-hover table-bordered">


						<thead class="thead-dark">
							<tr>


								<th>SHADOW_ACCOUNT #</th>
								<th>CARD_NUMBER</th>
								<th>CLIENT_CODE</th>
								<th>TRAN_DATE</th>
								<th>PROC_DATE</th>
								<th>MICROFILM_REF_NUMBER</th>
								<th>TRAN_TYPE</th>
								<th>OUTLET</th>
								<th>BILLING_AMT</th>
								<th>TRAN_AMT</th>
								<th>TRAN_CCY</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="file" items="${momentumStatementList}">
								<tr>
									<td><c:out value="${file.sHADOW_ACCOUNT_NBR}" /></td>
									<td><c:out value="${file.cARD_NUMBER}" /></td>
									<td><c:out value="${file.cLIENT_CODE}" /></td>
									<td><c:out value="${file.tRANSACTION_DATE}" /></td>
									<td><c:out value="${file.pROCESSING_DATE}" /></td>
									<td><c:out value="${file.mICROFILM_REF_NUMBER}" /></td>
									<td><c:out value="${file.tRANSACTION_TYPE}" /></td>
									<td><c:out value="${file.oUTLET}" /></td>
									<td><c:out value="${file.bILLING_AMT}" /></td>
									<td><c:out value="${file.tRANSACTION_AMT}" /></td>
									<td><c:out value="${file.tRANSACTION_CCY}" /></td>

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

</body>
</html>