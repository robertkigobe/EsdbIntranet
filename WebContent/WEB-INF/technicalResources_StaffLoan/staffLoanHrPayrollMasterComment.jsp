<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Payroll Master Comment</title>

<link href="css/HomePage.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
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
			
			<div >


				<div style="margin-left: 40px;">
					<h3>Payroll Administrator Comment</h3>
					<div>
						<form action="StaffLoanUpdateHrPayrollMasterComment" method="POST">

							<div style="border-style: ridge">
								<h6>
									<u>Employee Information</u>
								</h6>
								<div class="container">
									<p class="bg-danger">${error}</p>
								</div>
								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="employeeLoanRef">Loan Ref:</label> <input
											type="text" class="form-control" name="employeeLoanRef"
											value="${employeeLoanRef}" readonly>
									</div>


									<div class="form-group col-md-2">
										<label for="employeeCode">Employee No</label> <input
											type="text" class="form-control" name="employeeCode"
											id="employeeEmploymentNo" value="${employeeCode}" required
											readonly>
									</div>


									<div class="form-group col-md-2">
										<label for="firstname">First Name</label> <input type="text"
											class="form-control" name="firstname" id="firstname"
											value="${firstname}" required >
									</div>

									<div class="form-group col-md-2">
										<label for="surname">Last Name</label> <input type="text"
											class="form-control" name="surname" value="${surname}"
											required >
									</div>



									<div class="form-group col-md-2">
										<label for="supervisor">Emp supervisor:</label> <input
											type="text" class="form-control" name="supervisor"
											value="${supervisor}" required >
									</div>

									<div class="form-group col-md-2">
										<label for="supervisorEmail">Supervisor Email:</label> <input
											type="email" class="form-control" name="supervisorEmail"
											value="${supervisorEmail}" >
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
											type="date" class="form-control" name="dateOfBirth"
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

									<div class="form-group col-md-4">
										<label for="employeePosition">Position:</label> <input
											type="text" class="form-control" name="employeePosition"
											id="employeePosition" value="${employeePosition}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="employeeGrade">Grade:</label> <input type="text"
											class="form-control" name="employeeGrade" id="employeeGrade"
											value="${employeeGrade}" required>
									</div>

									<div class="form-group col-md-4">
										<label for="employeeDepartment">Department:</label> <input
											type="text" class="form-control" name="employeeDepartment"
											id="employeeDepartment" value="${employeeDepartment}"
											required >
									</div>

									

									<div class="form-group col-md-2">
										<label for="hodEmail">Hod Email:</label> <input type="email"
											class="form-control" name="hodEmail" value="${hodEmail}"
											required>
									</div>

								</div>

								<div class="form-row">



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


									<div class="form-group col-md-4">
										<label for="resAddress">Phyisical Address:</label> <input
											type="text" class="form-control" name="resAddress"
											value="${resAddress}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="noOfDependants">Dependants:</label> <input
											type="text" class="form-control" name="noOfDependants"
											value="${noOfDependants}" required readonly>
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
										<label for="hodEmail">HOD Email:</label> <input
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
											step="0.01" class="two-decimals" value="${basicSalary}"
											required>
									</div>

									<div class="form-group col-md-2">
										<label for="allowances">Allowances:</label> <input
											type="number" class="form-control" name="allowances"
											step="0.01" class="two-decimals" value="${allowances}"
											required>
									</div>
									<div class="form-group col-md-2">
										<label for="housingloanDeductions">Housing loan Ded'n:</label>
										<input type="number" class="form-control" step="0.01"
											class="two-decimals" name="housingloanDeductions"
											value="${housingloanDeductions}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="housingloanBalance">Housing loan Bal:</label> <input
											type="number" class="form-control" name="housingloanBalance"
											step="0.01" class="two-decimals"
											value="${housingloanBalance}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="ruralHousingloanDeductions">Rural Housing
											Ded</label> <input type="number" class="form-control" step="0.01"
											class="two-decimals" name="ruralHousingloanDeductions"
											value="${ruralHousingloanDeductions}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="ruralHousingloanBalance">Rural Housing
											Bal:</label> <input type="number" class="form-control" step="0.01"
											class="two-decimals" name="ruralHousingloanBalance"
											value="${ruralHousingloanBalance}" required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="farm_smallHolderDeductions">FarmSmallHolder
											Ded:</label> <input type="number" class="form-control" step="0.01"
											class="two-decimals" name="farm_smallHolderDeductions"
											value="${farm_smallHolderDeductions}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="farm_smallHolderBalance">Farm Small Holder
											Balance:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="farm_smallHolderBalance"
											value="${farm_smallHolderBalance}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="carloanDeductions">Car loan Deductions : </label>
										<input type="number" class="form-control"
											name="carloanDeductions" step="0.01" class="two-decimals"
											value="${carloanDeductions}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="carloanBalance">Car loan Balance : </label> <input
											type="number" class="form-control" name="carloanBalance"
											step="0.01" class="two-decimals" value="${carloanBalance}"
											required>
									</div>

									<div class="form-group col-md-2">
										<label for="personalloanDeductions">Personal loan
											Deductions:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="personalloanDeductions"
											value="${personalloanDeductions}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="personalloanBalance">Personal loan
											Balance:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals" name="personalloanBalance"
											value="${personalloanBalance}" required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="educationalloanDeductions">Educational
											loan Ded's:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="educationalloanDeductions"
											value="${educationalloanDeductions}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="educationalloanBalance">Educational loan
											Balance:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="educationalloanBalance"
											value="${educationalloanBalance}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="cityCouncilRatesDeductions">City Council
											Rates Ded:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="cityCouncilRatesDeductions"
											value="${cityCouncilRatesDeductions}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="cityCouncilRatesBalance">City Council
											Rates Balance:</label> <input type="number" class="form-control"
											step="0.01" class="two-decimals"
											name="cityCouncilRatesBalance"
											value="${cityCouncilRatesBalance}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="insurancesDeductions">Insurances
											Deductions:</label> <input type="number" class="form-control"
											name="insurancesDeductions" value="${insurancesDeductions}"
											required>
									</div>
									<div class="form-group col-md-2">
										<label for="insurancesBalance">Insurances Balance:</label> <input
											type="number" class="form-control" name="insurancesBalance"
											step="0.01" class="two-decimals" value="${insurancesBalance}"
											required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="otherDeductions">Other Deductions:</label> <input
											type="number" class="form-control" name="otherDeductions"
											step="0.01" class="two-decimals" value="${otherDeductions}"
											required>
									</div>
									<div class="form-group col-md-2">
										<label for="otherBalance">Other Balance:</label> <input
											type="number" class="form-control" name="otherBalance"
											step="0.01" class="two-decimals" value="${otherBalance}"
											required>
									</div>

									<div class="form-group col-md-2">
										<label for="targetSavings">Target Savings:</label> <input
											type="number" class="form-control" name="targetSavings"
											step="0.01" class="two-decimals" value="${targetSavings}"
											required>
									</div>
									<div class="form-group col-md-2">
										<label for="statutoryDeductions">Statutory Ded:</label> <input
											type="number" class="form-control" step="0.01"
											class="two-decimals" name="statutoryDeductions"
											value="${statutoryDeductions}" required>
									</div>

									<div class="form-group col-md-3">
										<label for="otherDeductionsExcLeaveAllowance">Other
											Deductions EXC Leave Allw :</label> <input type="number"
											class="form-control" step="0.01" class="two-decimals"
											name="otherDeductionsExcLeaveAllowance"
											value="${otherDeductionsExcLeaveAllowance}" required>
									</div>


								</div>

								<div style="border-style: ridge">
									<h6>
										<u>Loan Details</u>
									</h6>

									<div class="form-row">

										<div class="form-group col-md-2">
											<label for="dateloanRequired">Date Required:</label> <input
												type="text" class="form-control" name="dateloanRequired"
												value="${dateloanRequired}" readonly>
										</div>

										<div class="form-group col-md-2">
											<label for="dateOfFirstInstallment">First
												Installment:</label> <input type="text" class="form-control"
												name="dateOfFirstInstallment"
												value="${dateOfFirstInstallment}" readonly>
										</div>

										<div class="form-group col-md-2">
											<label for="dateOfLastInstallment">Last Installment:</label>
											<input type="text" class="form-control"
												name="dateOfLastInstallment"
												value="${dateOfLastInstallment}" readonly>
										</div>

										<div class="form-group col-md-2">
											<label for="loanType">Loan Type:</label> <input
												name="loanType" 
												value="${loanType}" type="text" class="form-control" readonly/>

										</div>

										<div class="form-group col-md-2">
											<label for="interestRate">Interest Rate:</label> <input
												type="number" class="form-control" name="interestRate"
												step="0.01" class="two-decimals" value="${interestRate}"
												readonly/>
										</div>

										<div class="form-group col-md-2">
											<label for="funeralCover">Funeral Cover:</label> <input
												type="number" class="form-control" name="funeralCover"
												step="0.01" class="two-decimals" value="5000.00"
												readonly/>
										</div>

									</div>
									<div class="form-row">


										<div class="form-group col-md-2">
											<label for="loanAmount">Loan Amount:</label> <input
												type="number" class="form-control" name="loanAmount"
												step="0.01" class="two-decimals" value="${loanAmount}"
												readonly/>
										</div>

										<div class="form-group col-md-4">
											<label for="loanAmount">Amount in words:</label> <input
												type="text" class="form-control" name="loanAmountWords"
												 value="${loanAmountWords}" readonly/>
										</div>
										
										<div class="form-group col-md-2">
											<label for="purposeOfLoan">Level term:</label> <input
												type="text" class="form-control" name="levelTermInsurance"
												value="${levelTermInsurance}" readonly/>
										</div>
										
											

										<div class="form-group col-md-4">
											<label for="purposeOfLoan">Purpose Of Loan:</label> <input
												type="text" class="form-control" name="purposeOfLoan"
												value="${purposeOfLoan}" readonly/>
										</div>

									</div>
								</div>

								<div style="border-style: ridge">
									<h6>
										<u>Loan Comments</u>
									</h6>

									<div class="form-row">
									
									<div class="form-group col-md-3">
											<label for="applicantCommentDate">Employee Comment
												Date:</label> <input type="email" class="form-control"
												name="applicantCommentDate" value="${applicantCommentDate}"
												readonly>
										</div>

										<div class="form-group col-md-9">
											<label for="supervisorEmail">Employee Comment:</label> <input
												type="text" class="form-control" name="applicantComment"
												value="${applicantComment}" required readonly>
										</div>
										


									</div>
									
									<div class="form-row">
									
									<div class="form-group col-md-3">
											<label for="supervisorCommentDate">Supervisor Comment
												Date:</label> <input type="email" class="form-control"
												name="supervisorCommentDate" value="${supervisorCommentDate}"
												readonly>
										</div>

										<div class="form-group col-md-9">
											<label for="supervisorComment">Supervisor Comment:</label> <input
												type="text" class="form-control" name="supervisorComment"
												value="${supervisorComment}" required readonly>
										</div>
										


									</div>
									
									<div class="form-row">
									
									<div class="form-group col-md-3">
											<label for="hodCommentDate">HOD Comment
												Date:</label> <input type="email" class="form-control"
												name="hodCommentDate" value="${hodCommentDate}"
												readonly>
										</div>

										<div class="form-group col-md-9">
											<label for="supervisorComment">HOD Comment:</label> <input
												type="text" class="form-control" name="supervisorComment"
												value="${hodComment}" required readonly>
										</div>
										


									</div>
									<div class="form-row">


										<div class="form-group col-md-3">
											<label for="loanStatus">Loan Status:</label> <select
												name="loanStatus" class="form-control" required readonly>

												<option>Approve</option>
												<option>Return to Staff for editing</option>
												<option>Cancel</option>

											</select>
										</div>
										<div class="form-group col-md-3">
										<label for="seniorHrManagerEmail">Senior HR Manager Email:</label> <input
											type="email" class="form-control" name="seniorHrManagerEmail"
											value="${seniorHrManagerEmail}">
									</div>

										<div class="form-group col-md-6">
											<label for="hrPayrollMasterComment">Payroll Administrator Comment:</label> <input
												type="text" class="form-control" name="hrPayrollMasterComment"
												value="${hrPayrollMasterComment}" required >
										</div>

									</div>
									
									
								</div>

								<div class="form-row">

									<div class="form-group col-md-6">
										<button type="submit" class="btn btn-warning btn-lg btn-block"
											name="viewLoan">View Staff Loan Documents</button>

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
