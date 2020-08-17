<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Branch Personal Loan</title>
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

				<h4>Quick Links</h4>

				<ol class="list-group">



					<li><a
						href="${pageContext.request.contextPath}/BranchLoanITCUpload"
						class="list-group-item list-group-item-action active">Start a
							new loan application</a></li>
					<li><a
						href="${pageContext.request.contextPath}/BranchLoanTrackingDisbursedStatus"
						class="list-group-item list-group-item-dark">Loans Disbursed</a></li>
					<li><a
						href="${pageContext.request.contextPath}/StaffLoanAdministrationLogin"
						class="list-group-item list-group-item-dark">Administration</a></li>



				</Ol>
			</div>
			<div class="rightNav">


				<div class="page-header">
					<h4>Upload ITC report + Confirmation Latter + National ID +  Pay Slip (PDF files only ):</h4>

				</div>

				<div>



					<form action=BranchLoanITCUpload method="post"
						enctype="multipart/form-data" class="form">


						<div class="form-group ">
							<label for="applicantName"><small>Please make the
									file name to be the National Id + First Name + Surname</small></label> 
						</div>

						<div class="form-group ">
							<label for="applicantName">File UpLoad :</label> <input
								type="file" name="fileUpLoad" size="50" required
								accept="application/pdf">
						</div>

						<div class="form-group ">
							<label for="applicantName">Action :</label> <input type="submit"
								value="Upload Document" size="50">
						</div>

					</form>

				</div>


			</div>


		</div>
	</div>


	<div class="clear"></div>
	<div class="footer" id="footer" name="footer">
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>
	</div>
</body>
</html>