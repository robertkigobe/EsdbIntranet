<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<Title>Skills Audit Home</Title>
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
					<li><a href="#"
						class="list-group-item list-group-item-action active">SwaziBank
							Skills Audit</a></li>
					<li><a
						href="${pageContext.request.contextPath}/SkillsAuditNewSkillsAudit"
						class="list-group-item list-group-item-dark ">New Skills Audit</a></li>
					<li><a
						href="${pageContext.request.contextPath}/SkillsAuditQualityControlRequest"
						class="list-group-item list-group-item-dark ">Quality Control</a></li>
					<li><a
						href="${pageContext.request.contextPath}/SkillsAuditReportRequest"
						class="list-group-item list-group-item-dark ">Reports</a></li>

				</ol>

			</div>

			<div class="rightNav">

				<div class="container col-md-12">
					<div class="page-header">

						<h2>
							Skills Audit <small class="text-muted">2017-2018</small>
						</h2>
					</div>
					<div class="col-md-8">




						<h4>Background and Rationale</h4>


						<p>The basic intent of the skills audit is to identify
							existing set of skills, experience and competencies each employee
							has. The audit skills tool will enable the bank to identify and
							develop those employees with a gap in the required skills.</p>

						
						<p>An Automated Skills Audit System has been designed to
							enable ease of Testing our skills though our desk top. The
							Automated System will make it easy for staff members and
							supervisors or managers to measure the skills and further
							facilitate future assessments.</p>

						<h4>Outcome: Skills Gap Matrix</h4>
						<p>At the end of the skills audit processes a comprehensive
							report listing the skills health situation of the Bank will be
							presented in the form of a Skills Gap Matrix for the Bank;
							overall, by department and per job/ employee. The report will
							present graphically the skills gap matrix. The Skills Gap Matrix
							will provide information that will enable the Bank to accurately
							identify training/re-skilling needs for staff and thereafter
							develop training plans and other employee development
							interventions and feed into key business targets such as the
							development of a Succession Plan for key positions and also help
							place the right people at the right jobs.</p>

						<p>
							<b>An Action Plan to set goals to help develop these skills
								that will address the gaps has to be prepared for each employee
								and the date planned to achieve these goals must be specified.</b>
						</p>
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
