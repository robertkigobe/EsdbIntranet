<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Edit Skills Audit</title>

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
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

			<div class="container-fluid">
				<form action=SkillsAuditPostQualityControlSkills method="post">
					<h3>Skills Audit Edit</h3>
					<br>
					<br>
					<table class="table   table-sm table-bordered table-inverse">
						<tr>
							<th>Position:</th>
							<th><input type="text" name="position" value="${position}"
								readonly style="border: none; width: 100%" /></th>
							<th>Sub-Department:</th>
							<th><input type="text" name="subDepartment"
								value="${subDepartment}" readonly
								style="border: none; width: 50%" /><input type="text"
								name="department" value="${department}" readonly
								style="border: none; width: 50%" /></th>
						</tr>
						<tr>
							<th>Employee Name:</th>
							<th><input type="text" name="bscEmployeeName"
								value="${bscEmployeeName}" readonly style="border: none;" /></th>

							<th>Supervisor Name:</th>
							<th><input type="text" name="bscEmployeeSupervisor"
								value="${bscEmployeeSupervisor}" readonly style="border: none;" /></th>
						</tr>
					</table>
					
					
					<table class="table  table-striped table-hover table-bordered">
						<thead class="thead-dark">
							<tr>
								<th>Category</th>
								<th>Skill</th>
								<th>Rating</th>
								<th>Priority</th>
								<th>Remarks</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="target" items="${educationSkills}">
								<tr>
									<td><input type="text" name="category"
										value="${target.category}" readonly style="width: 200px;" /></td>
									<td><input type="text" name="skill"
										value="${target.skill}" readonly
										style="border: none; width: 500px;" required /></td>
									<td><select name="rating" required
										style="border: none; width: 100%;" required>
											<option>${target.rating}</option>
											<option>Yes</option>
											<option>No</option>

									</select></td>
									<td><select name="priority" required
										style="border: none; width: 150px;" required>
											<option>${target.priority}</option>
											<option>Very Important</option>
											<option>Important</option>
											<option>Of little Importance</option>
											<option>not Important at All</option>
									</select></td>
									<td><input type="text" name="remarks"
										style="border: none; width: 300px;" required value="${target.remarks}"/></td>

								</tr>
							</c:forEach>
							<c:forEach var="target" items="${qualificationSkills}">
								<tr>
									<td><input type="text" name="category"
										value="${target.category}" readonly style="width: 200px;" /></td>
									<td><input type="text" name="skill"
										value="${target.skill}" readonly
										style="border: none; width: 500px;" required /></td>
									<td><select name="rating" required
										style="border: none; width: 100%;" required>
											<option>${target.rating}</option>
											<option>Adequately Qualified</option>
											<option>Under Qualified</option>
											<option>Over Qualified</option>

									</select></td>
									<td><select name="priority" required
										style="border: none; width: 150px;" required>
											<option>${target.priority}</option>
											<option>Very Important</option>
											<option>Important</option>
											<option>Of little Importance</option>
											<option>not Important at All</option>
									</select></td>
									<td><input type="text" name="remarks"
										style="border: none; width: 300px;" required value="${target.remarks}"/></td>

								</tr>
							</c:forEach>

							<c:forEach var="target" items="${experienceSkills}">
								<tr>
									<td><input type="text" name="category"
										value="${target.category}" readonly style="width: 200px;" /></td>
									<td><input type="text" name="skill"
										value="${target.skill}" readonly
										style="border: none; width: 500px;" required /></td>
									<td><select name="rating" required
										style="border: none; width: 100%;" required>
											<option>${target.rating}</option>
											<option>Yes</option>
											<option>No</option>

									</select></td>
									<td><select name="priority" required
										style="border: none; width: 150px;" required>
											<option>${target.priority}</option>
											<option>Very Important</option>
											<option>Important</option>
											<option>Of little Importance</option>
											<option>not Important at All</option>
									</select></td>
									<td><input type="text" name="remarks"
										style="border: none; width: 300px;" required value="${target.remarks}"/></td>

								</tr>
							</c:forEach>


							<c:forEach var="target" items="${technicalSkills}">
								<tr>
									<td><input type="text" name="category"
										value="${target.category}" readonly style="width: 200px;" /></td>
									<td><input type="text" name="skill"
										value="${target.skill}" readonly
										style="border: none; width: 500px;" required /></td>
									<td><select name="rating" required
										style="border: none; width: 100%;" required>
											<option>${target.rating}</option>
											<option>Advanced</option>
											<option>Intermediate</option>
											<option>Beginner</option>

									</select></td>
									<td><select name="priority" required
										style="border: none; width: 150px;" required>
											<option>${target.priority}</option>
											<option>Very Important</option>
											<option>Important</option>
											<option>Of little Importance</option>
											<option>not Important at All</option>
									</select></td>
									<td><input type="text" name="remarks"
										style="border: none; width: 300px;" required value="${target.remarks}"/></td>

								</tr>
							</c:forEach>

							<c:forEach var="target" items="${professionalSkills}">
								<tr>
									<td><input type="text" name="category"
										value="${target.category}" readonly style="width: 200px;" /></td>
									<td><input type="text" name="skill"
										value="${target.skill}" readonly
										style="border: none; width: 500px;" required /></td>
									<td><select name="rating" required
										style="border: none; width: 100%;" required>
											<option>${target.rating}</option>
											<option>Excellent</option>
											<option>Good</option>
											<option>Fair</option>
											<option>Needs Improvement</option>

									</select></td>
									<td><select name="priority" required
										style="border: none; width: 150px;" required>
											<option>${target.priority}</option>
											<option>Very Important</option>
											<option>Important</option>
											<option>Of little Importance</option>
											<option>not Important at All</option>
									</select></td>
									<td><input type="text" name="remarks"
										style="border: none; width: 300px;" required value="${target.remarks}"/></td>

								</tr>
							</c:forEach>
							<c:forEach var="target" items="${extraCurricular}">
								<tr>
									<td><input type="text" name="category"
										value="${target.category}" readonly style="width: 200px;" /></td>
									<td><input type="text" name="skill"
										value="${target.skill}" readonly
										style="border: none; width: 500px;" required /></td>
									<td><select name="rating" required
										style="border: none; width: 100%;" required>
											<option>${target.rating}</option>
											<option>Yes</option>
											<option>No</option>

									</select></td>
									<td><select name="priority" required
										style="border: none; width: 150px;" required>
											<option>${target.priority}</option>
											<option>Very Important</option>
											<option>Important</option>
											<option>Of little Importance</option>
											<option>not Important at All</option>
									</select></td>
									<td><input type="text" name="remarks"
										style="border: none; width: 300px;" required value="${target.remarks}"/></td>

								</tr>
							</c:forEach>
							
							<c:forEach var="target" items="${pastExperience}">
								<tr>
									<td><input type="text" name="category"
										value="${target.category}" readonly style="width: 200px;" /></td>
									<td><input type="text" name="skill"
										value="${target.skill}" readonly
										style="border: none; width: 500px;" required /></td>
									<td><select name="rating" required
										style="border: none; width: 100%;" required>
											<option>${target.rating}</option>
											<option>Yes</option>
											<option>No</option>

									</select></td>
									<td><select name="priority" required
										style="border: none; width: 150px;" required>
											<option>${target.priority}</option>
											<option>Very Important</option>
											<option>Important</option>
											<option>Of little Importance</option>
											<option>not Important at All</option>
									</select></td>
									<td><input type="text" name="remarks"
										style="border: none; width: 300px;" required value="${target.remarks}"/></td>

								</tr>
							</c:forEach>
							
							<c:forEach var="target" items="${pastAwards}">
								<tr>
									<td><input type="text" name="category"
										value="${target.category}" readonly style="width: 200px;" /></td>
									<td><input type="text" name="skill"
										value="${target.skill}" readonly
										style="border: none; width: 500px;" required /></td>
									<td><select name="rating" required
										style="border: none; width: 100%;" required>
											<option>${target.rating}</option>
											<option>Yes</option>
											<option>No</option>

									</select></td>
									<td><select name="priority" required
										style="border: none; width: 150px;" required>
											<option>${target.priority}</option>
											<option>Very Important</option>
											<option>Important</option>
											<option>Of little Importance</option>
											<option>not Important at All</option>
									</select></td>
									<td><input type="text" name="remarks"
										style="border: none; width: 300px;" required value="${target.remarks}"/></td>

								</tr>
							</c:forEach>
							<tr>
								<td></td>
								<td></td>
								<td><input value="Submit Skills Audit" type="Submit"
									size="50"
									onclick="confirm('Press Ok to Submit or Cancel to edit your Work')"
									class="btn btn-primary btn-lg"></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>