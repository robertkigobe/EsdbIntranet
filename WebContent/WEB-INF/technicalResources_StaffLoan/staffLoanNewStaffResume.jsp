<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Staff Loan Application</title>

  <link rel="stylesheet" href="jquery/jquery-ui.css">
   <script src="${pageContext.request.contextPath}/jquery/jquery-ui.theme.css"></script>
  <script src="${pageContext.request.contextPath}/jquery/jquery.js"></script>
  <script src="${pageContext.request.contextPath}/jquery/jquery-ui.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  
 <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


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
				<div>
					<h3>New Staff Loan Application</h3>
					<div>
						<form action="StaffLoanEmployeeResume" method="POST">

							<div style="border-style: ridge">
								<h6>
									Employee Information
								</h6>
								<div class="container">
									<p class="bg-danger">${error}</p>
								</div>

								<div class="form-row">


									<div class="form-group col-md-2">
										<label for="employeeCode">Employee No</label> <input
											type="text" class="form-control" name="employeeCode"
											id="employeeEmploymentNo" value="${employeeCode}" required
											readonly>
									</div>

									<div class="form-group col-md-2">
										<label for="title">Title</label> <input type="text"
											class="form-control" name="title" id="title" value="${title}"
											required>
									</div>

									<div class="form-group col-md-2">
										<label for="firstname">First Name</label> <input type="text"
											class="form-control" name="firstname" id="firstName"
											value="${firstName}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="surName">Last Name</label> <input type="text"
											class="form-control" name="surName" value="${surName}"
											required>
									</div>

									<div class="form-group col-md-2">
										<label for="secondName">Second Name</label> <input type="text"
											class="form-control" name="secondName" id="secondName"
											value="${secondName}" >
									</div>
									<div class="form-group col-md-2">
										<label for="gender">Gender</label> <input type="text"
											class="form-control" name="gender" id="gender"
											value="${gender}" required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="iDNumber">National Id:</label> <input type="text"
											class="form-control" name="iDNumber" value="${iDNumber}"
											required>
									</div>

									<div class="form-group col-md-2">
										<label for="cif">CIF:</label> <input type="text"
											class="form-control" name="cif" value="${cif}" required>
									</div>



									<div class="form-group col-md-3">
										<label for="dateOfBirth">Date of Birth:</label> <input
											type="text"  class="form-control" name="dateOfBirth" placeholder="yyyy-mm-dd"
											value="${dateOfBirth}" required>
									</div>




									<div class="form-group col-md-2">
										<label for="maritalStatus">Marital Status</label> <input
											type="text" class="form-control" name="maritalStatus"
											id="maritalStatus" value="${maritalStatus}" required>
									</div>

									<div class="form-group col-md-3">
										<label for="dateEngaged">Date Engaged:</label> <input
											type="text" class="form-control" name="dateEngaged"
											value="${dateEngaged}" required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-3">
										<label for="employeePosition">Position:</label> <input
											type="text" class="form-control" name="employeePosition"
											id="employeePosition" value="${employeePosition}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="employeeGrade">Grade:</label> <input type="text"
											class="form-control" name="employeeGrade" id="employeeGrade"
											value="${employeeGrade}" required>
									</div>

									<div class="form-group col-md-3">
										<label for="employeeDepartment">Department:</label> 
											
											<select
												name="employeeDepartment" class="form-control" required>

												<option></option>
												<option>AUDIT</option>
												<option>BUSINESS BANKING</option>
												<option>CORPORATE SERVICES</option>
												<option>CREDIT</option>
												<option>FINANCE</option>
												<option>INFORMATION TECHNOLOGY</option>
												<option>MARKETING</option>
												<option>MD OFFICE</option>
												<option>OPERATIONS</option>
												<option>RISK</option>
												
												
											</select>
									</div>

									<div class="form-group col-md-4">
										<label for="employeeSupervisor">Supervisor:</label> <input
											type="text" class="form-control" name="employeeSupervisor"
											value="${employeeSupervisor}" required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="location">Location:</label> <input type="text"
											class="form-control" name="location" value="${location}"
											required>
									</div>

									<div class="form-group col-md-2">
										<label for="branchAdress">Branch Adress:</label> <input
											type="text" class="form-control" name="branchAdress"
											value="${branchAdress}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="boxAddress">Emp Post Add:</label> <input
											type="text" class="form-control" name="boxAddress"
											value="${boxAddress}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="city">City:</label> <input type="text"
											class="form-control" name="city" value="${city}" required>
									</div>


									<div class="form-group col-md-2">
										<label for="employeeAddress">Physical Address:</label> <input
											type="text" class="form-control" name="employeeAddress"
											value="${employeeAddress}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="noOfDependants">Dependants:</label> <input
											type="number" class="form-control" name="noOfDependants"
											value="${dependants}" required>
									</div>

								</div>
								<div class="form-row">


									<div class="form-group col-md-3">
										<label for="telelephoneNo">Employee Mobile:</label> <input
											type="text" class="form-control" name="telelephoneNo"
											value="${telelephoneNo}" required>
									</div>

									<div class="form-group col-md-3">
										<label for="emailAddress">Employee Email:</label> <input
											type="email" class="form-control" name="emailAddress"
											value="${emailAddress}" required>
									</div>

									<div class="form-group col-md-3">
										<label for="supervisorEmail">Supervisor Email:</label> <input
											type="email" class="form-control" name="supervisorEmail"
											value="${supervisorEmail}" required>
									</div>
									<div class="form-group col-md-3">
										<label for="hodEmail">Executive Manager Email:</label> <input
											type="hodEmail" class="form-control" name="hodEmail"
											value="${hodEmail}">
									</div>

								</div>
							</div>
							<div style="border-style: ridge">
								<h6>
									<u>Employee Liabilities</u>
								</h6>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="basicSalary">Basic Salary:</label> <input
											type="number" class="form-control" name="basicSalary"
											step="0.01" class="two-decimals" value="0.00" required>
									</div>

									<div class="form-group col-md-2">
										<label for="allowances">Allowances:</label> <input
											type="number" class="form-control" name="allowances"
											step="0.01" class="two-decimals" value="0.00" required>
									</div>
									<div class="form-group col-md-2">
										<label for="housingloanDeductions">Housing loan Ded'n:</label>
										<input type="number" class="form-control" step="0.01"
											class="two-decimals" name="housingloanDeductions"
											value="0.00" required>
									</div>
									<div class="form-group col-md-2">
										<label for="housingloanBalance">Housing loan Bal:</label> <input
											type="number" class="form-control" name="housingloanBalance"
											step="0.01" class="two-decimals" value="0.00" required>
									</div>

									<div class="form-group col-md-2">
										<label for="ruralHousingloanDeductions">Rural Housing
											Ded</label> <input type="number" class="form-control" step="0.01"
											class="two-decimals" name="ruralHousingloanDeductions"
											value="0.00" required>
									</div>
									<div class="form-group col-md-2">
										<label for="ruralHousingloanBalance">Rural Housing
											Bal:</label> <input type="number" class="form-control" step="0.01"
											class="two-decimals" name="ruralHousingloanBalance"
											value="0.00" required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="farm_smallHolderDeductions">FarmSmallHolder
											Ded:</label> <input type="number" class="form-control" step="0.01"
											class="two-decimals" name="farm_smallHolderDeductions"
											value="0.00" required>
									</div>
									<div class="form-group col-md-2">
										<label for="farm_smallHolderBalance">Farm Small Holder
											Balance:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="farm_smallHolderBalance" value="0.00" required>
									</div>

									<div class="form-group col-md-2">
										<label for="carloanDeductions">Car loan Deductions : </label>
										<input type="number" class="form-control"
											name="carloanDeductions" step="0.01" class="two-decimals"
											value="0.00" required>
									</div>
									<div class="form-group col-md-2">
										<label for="carloanBalance">Car loan Balance : </label> <input
											type="number" class="form-control" name="carloanBalance"
											step="0.01" class="two-decimals" value="0.00" required>
									</div>

									<div class="form-group col-md-2">
										<label for="personalloanDeductions">Personal loan
											Deductions:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals" value="0.00" 
											name="personalloanDeductions" required>
									</div>
									<div class="form-group col-md-2">
										<label for="personalloanBalance">Personal loan
											Balance:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals" name="personalloanBalance"
											value="0.00" required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="educationalloanDeductions">Educational
											loan Ded's:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="educationalloanDeductions" value="0.00" required>
									</div>
									<div class="form-group col-md-2">
										<label for="educationalloanBalance">Educational loan
											Balance:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="educationalloanBalance" value="0.00" required>
									</div>

									<div class="form-group col-md-2">
										<label for="cityCouncilRatesDeductions">City Council
											Rates Ded:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="cityCouncilRatesDeductions" value="0.00" required>
									</div>
									<div class="form-group col-md-2">
										<label for="cityCouncilRatesBalance">City Council
											Rates Balance:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="cityCouncilRatesBalance" value="0.00" required>
									</div>

									<div class="form-group col-md-2">
										<label for="insurancesDeductions">Insurances
											Deductions:</label> <input type="number" class="form-control"
											name="insurancesDeductions" value="0.00" required>
									</div>
									<div class="form-group col-md-2">
										<label for="insurancesBalance">Insurances Balance:</label> <input
											type="number" class="form-control" name="insurancesBalance"
											step="0.01" class="two-decimals" value="0.00" required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="otherDeductions">Other Deductions:</label> <input
											type="number" class="form-control" name="otherDeductions"
											step="0.01" class="two-decimals" value="0.00" required>
									</div>
									<div class="form-group col-md-2">
										<label for="otherBalance">Other Balance:</label> <input
											type="number" class="form-control" name="otherBalance"
											step="0.01" class="two-decimals" value="0.00" required>
									</div>

									<div class="form-group col-md-2">
										<label for="targetSavings">Target Savings:</label> <input
											type="number" class="form-control" name="targetSavings"
											step="0.01" class="two-decimals" value="0.00" required>
									</div>
									<div class="form-group col-md-2">
										<label for="statutoryDeductions">Statutory Ded:</label> <input
											type="number" class="form-control" step="0.01"
											class="two-decimals" name="statutoryDeductions" value="0.00"
											required>
									</div>

									<div class="form-group col-md-3">
										<label for="otherDeductionsExcLeaveAllowance">Other Deductions EXC Leave Allw
											:</label> <input type="number" class="form-control" step="0.01"
											class="two-decimals" name="otherDeductionsExcLeaveAllowance"
											value="0.00" required>
									</div>


								</div>

								<div style="border-style: ridge">
									<h6>
										<u>Loan Details</u>
									</h6>

									<div class="form-row">

										<div class="form-group col-md-2">
											<label for="dateloanRequired">Date Required:</label> 									
												<input
											type="text" class="form-control" placeholder="mm/dd/yyyy"
											name="dateloanRequired" id="datepicker"
												value="${dateloanRequired}" required>
										</div>

										<div class="form-group col-md-2">
											<label for="dateOfFirstInstallment">First
												Installment:</label> <input
											type="text" class="form-control" placeholder="mm/dd/yyyy"
											name="dateOfFirstInstallment" id="datepickerStartDate"
												value="${dateOfFirstInstallment}" required>
										</div>

										<div class="form-group col-md-2">
											<label for="dateOfLastInstallment">Last Installment:</label>
											<input
											type="text" class="form-control" name="dateOfLastInstallment"
											id="datepickerEndDate" placeholder="mm/dd/yyyy"
												value="${dateOfLastInstallment}" required>
										</div>

										<div class="form-group col-md-2">
											<label for="loanType">Loan Type:</label> <select
												name="loanType" class="form-control" required>

												<option></option>
												<option>Staff Personal loans up to 48 months</option>
												<option>Staff Personal loans 12 months</option>


											</select>
										</div>

										

									</div>
									<div class="form-row">


										<div class="form-group col-md-2">
											<label for="loanAmount">Loan Amount:</label> <input
												type="number" class="form-control" name="loanAmount"
												step="0.01" class="two-decimals" placeholder="0.00" required>
										</div>

										<div class="form-group col-md-5">
											<label for="loanAmount">Amount in words:</label> <input
												type="text" class="form-control" name="loanAmountWords"
												value="${loanAmountWords}" required>
										</div>

										<div class="form-group col-md-5">
											<label for="purposeOfLoan">Purpose Of Loan:</label> <input
												type="text" class="form-control" name="purposeOfLoan"
												value="${purposeOfLoan}" required>
										</div>

									</div>

									<div class="form-row">
									
									<div class="form-group col-md-3">
											<label for="loanType">Next Approval:</label> <select
												name="nextApproval" class="form-control" required>

												<option></option>
												<option>Supervisor</option>
												<option>Head of Department</option>
												
											</select>
										</div>

										<div class="form-group col-md-9">
											<label for="supervisorEmail">Employee Comment:</label> <input
												type="text" class="form-control" name="applicantComment"
												value="${applicantComment}" required>
										</div>

									</div>
								</div>



								<div class="form-row">

									<div class="form-group col-md-6">
										<button type="submit" class="btn btn-warning btn-lg btn-block"
											name="viewLoan">Pre-view Staff Loan</button>

									</div>
									
									<div class="form-group col-md-6">
										<button type="submit" class="btn btn-primary btn-lg btn-block"
											name="submitLoan">Submit Staff Loan Application</button>

									</div>
								
							</div>
						</form>
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
