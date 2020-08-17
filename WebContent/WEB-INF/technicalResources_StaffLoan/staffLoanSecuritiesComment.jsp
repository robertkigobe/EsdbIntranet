<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Hr Senior Manager Comment</title>

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


				<div style="margin-left: 40px;">
					<h3>Securities Supervisor Comment</h3>
					<div>
						<form action="StaffLoanUpdateSecuritiesSupervisorComment" method="POST">

							<div class="form-row">
								<div class="form-group col-md-4">
									<label for="employeeLoanRef">Loan Ref:</label> <input
										type="text" class="form-control" name="employeeLoanRef"
										value="${employeeLoanRef}" required readonly>
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
										value="${firstname}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="surname">Last Name</label> <input type="text"
										class="form-control" name="surname" value="${surname}"
										required readonly readonly>
								</div>

								

								<div class="form-group col-md-2">
									<label for="supervisor">Employee supervisor:</label> <input
										type="text" class="form-control" name="supervisor"
										value="${supervisor}" required readonly>
								</div>



							</div>
							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="emailAddress">Employee Email:</label> <input
										type="email" class="form-control" name="emailAddress"
										value="${emailAddress}" required readonly readonly>
								</div>
								<div class="form-group col-md-10">
									<label for="supervisorEmail">Employee Comment:</label> <input
										type="text" class="form-control" name="applicantComment"
										value="${applicantComment}" required readonly readonly>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-2">
									<label for="supervisorEmail">Supervisor Email:</label> <input
										type="email" class="form-control" name="supervisorEmail"
										value="${supervisorEmail}" required readonly>
								</div>

								<div class="form-group col-md-10">
									<label for="supervisorEmail">Supervisor Comment:</label> <input
										type="text" class="form-control" name="supervisorComment"
										value="${supervisorComment}" required readonly readonly>
								</div>
							</div>
							
							<div class="form-row">
								<div class="form-group col-md-2">
									<label for="supervisorEmail">Hod Email:</label> <input
										type="email" class="form-control" name="hodEmail"
										value="${hodEmail}" required readonly readonly>
								</div>

								<div class="form-group col-md-10">
									<label for="hodComment">Hod Comment:</label> <input
										type="text" class="form-control" name="hodComment"
										value="${hodComment}" required readonly readonly>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-2">
									<label for="hrPayrollMasterEmail">Payroll Master Email:</label> <input
										type="email" class="form-control" name="hrPayrollMasterEmail"
										value="${hrPayrollMasterEmail}" required readonly readonly>
								</div>

								<div class="form-group col-md-10">
									<label for="hodComment">Payroll Master Comment:</label> <input
										type="text" class="form-control" name="hrPayrollMasterComment"
										value="${hrPayrollMasterComment}" required readonly readonly> 
								</div>
								
							</div>
							
							<div class="form-row">
								<div class="form-group col-md-2">
									<label for="seniorHrManagerEmail">Senior Hr Manager Email:</label> <input
										type="email" class="form-control" name="seniorHrManagerEmail"
										value="${seniorHrManagerEmail}" required readonly>
								</div>

								<div class="form-group col-md-10">
									<label for="seniorHrManagerComment">Senior Hr Manager Comment:</label> <input
										type="text" class="form-control" name="seniorHrManagerComment"
										value="${seniorHrManagerComment}" required readonly readonly>
								</div>
								
							</div>
							
							<div class="form-row">
								<div class="form-group col-md-2">
									<label for="loanStatus">Loan Status:</label> <select
										name="loanStatus" class="form-control" required>
										<option></option>
										<option>Sign Securities</option>
										<option>Cancelled</option>
									</select>
								</div>
								
								<div class="form-group col-md-2">
									<label for="interestRate">Interest Rate:</label> <input
										type="number" class="form-control" name="interestRate"
										value="${interestRate}" step="0.01" class="two-decimals" required>
								</div>
								
								<div class="form-group col-md-2">
									<label for="legalAdvisorEmail">legal Advisor Email:</label> <input
										type="text" class="form-control" name="legalAdvisorEmail"
										value="${legalAdvisorEmail}"  required>
								</div>

								<div class="form-group col-md-6">
									<label for="securitiesComment">Securities Supervisor Comment:</label> <input
										type="text" class="form-control" name="securitiesComment"
										value="${securitiesComment}" required>
								</div>

							</div>




							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="iDNumber">National Id:</label> <input type="text"
										class="form-control" name="iDNumber" value="${iDNumber}"
										required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="cif">CIF:</label> <input type="text"
										class="form-control" name="cif" value="${cif}" required
										readonly>
								</div>



								<div class="form-group col-md-2">
									<label for="dateOfBirth">Date of Birth:</label> <input
										type="text" class="form-control" name="dateOfBirth"
										value="${dateOfBirth}" required readonly>
								</div>




								<div class="form-group col-md-2">
									<label for="maritalStatus">Marital Status</label> <input
										type="text" class="form-control" name="maritalStatus"
										id="maritalStatus" value="${maritalStatus}" required readonly>
								</div>

								<div class="form-group col-md-4">
									<label for="dateEngaged">Date Engaged:</label> <input
										type="text" class="form-control" name="dateEngaged"
										value="${dateEngaged}" required readonly>
								</div>



							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="employeePosition">Employee Position:</label> <input
										type="text" class="form-control" name="employeePosition"
										id="employeePosition" value="${employeePosition}" required
										readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="employeeGrade">Employee Grade:</label> <input
										type="text" class="form-control" name="employeeGrade"
										id="employeeGrade" value="${employeeGrade}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="employeeDepartment">Department:</label> <input
										type="text" class="form-control" name="employeeDepartment"
										id="employeeDepartment" value="${employeeDepartment}" required
										readonly>
								</div>





								<div class="form-group col-md-2">
									<label for="branchAdress">Branch Adress:</label> <input
										type="text" class="form-control" name="branchAdress"
										value="${branchAdress}" required readonly>
								</div>

								<div class="form-group col-md-4">
									<label for="resAddress">Employee Address:</label> <input
										type="text" class="form-control" name="resAddress"
										value="${resAddress}" required readonly>
								</div>

							</div>

							<div class="form-row">



								<div class="form-group col-md-4">
									<label for="telelephoneNo">Mobile:</label> <input type="text"
										class="form-control" name="telelephoneNo"
										value="${telelephoneNo}" required readonly>
								</div>


								<div class="form-group col-md-4">
									<label for="noOfDependants">Dependants:</label> <input
										type="text" class="form-control" name="noOfDependants"
										value="${noOfDependants}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="loanType">Loan Type:</label> <input type="text"
										class="form-control" name="loanType" value="${loanType}"
										required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="purposeOfLoan">Purpose Of Loan:</label> <input
										type="text" class="form-control" name="purposeOfLoan"
										value="${purposeOfLoan}" required readonly>
								</div>

							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="dateloanRequired">Date Required:</label> <input
										type="date" class="form-control" name="dateloanRequired"
										value="${dateloanRequired}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="dateOfFirstInstallment">Date of First
										Installment:</label> <input type="date" class="form-control"
										name="dateOfFirstInstallment"
										value="${dateOfFirstInstallment}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="dateOfLastInstallment">Date of Last
										Installment:</label> <input type="date" class="form-control"
										name="dateOfLastInstallment" value="${dateOfLastInstallment}"
										required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="loanAmount">Loan Amount:</label> <input
										type="number" class="form-control" name="loanAmount"
										value="${loanAmount}" required readonly>
								</div>

								<div class="form-group col-md-4">
									<label for="loanAmount">Amount in words:</label> <input
										type="text" class="form-control" name="loanAmountWords"
										value="${loanAmountWords}" required readonly>
								</div>



							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="basicSalary">Basic Salary:</label> <input
										type="number" class="form-control" name="basicSalary"
										value="${basicSalary}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="allowances">Allowances:</label> <input
										type="number" class="form-control" name="allowances"
										value="${allowances}" required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="housingloanDeductions">Housing loan
										Deductions:</label> <input type="number" class="form-control"
										name="housingloanDeductions" value="${housingloanDeductions}"
										required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="housingloanBalance">Housing loan Balance:</label> <input
										type="number" class="form-control" name="housingloanBalance"
										value="${housingloanBalance}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="ruralHousingloanDeductions">Rural Housing
										Deductions:</label> <input type="number" class="form-control"
										name="ruralHousingloanDeductions"
										value="${ruralHousingloanDeductions}" required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="ruralHousingloanBalance">Rural Housing
										Balance:</label> <input type="number" class="form-control"
										name="ruralHousingloanBalance"
										value="${ruralHousingloanBalance}" required readonly>
								</div>


							</div>


							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="farm_smallHolderDeductions">Farm Small
										Holder Ded:</label> <input type="number" class="form-control" name=""
										farm_smallHolderDeductions""
										value="${farm_smallHolderDeductions}"
										required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="farm_smallHolderBalance">Farm Small Holder
										Balance:</label> <input type="number" class="form-control"
										name="farm_smallHolderBalance"
										value="${farm_smallHolderBalance}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="carloanDeductions">Car loan Deductions:</label> <input
										type="number" class="form-control" name="carloanDeductions"
										value="${carloanDeductions}" required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="carloanBalance">Car loan Balance:</label> <input
										type="number" class="form-control" name="carloanBalance"
										value="${carloanBalance}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="personalloanDeductions">Personal loan
										Deductions:</label> <input type="number" class="form-control"
										name="personalloanDeductions"
										value="${personalloanDeductions}" required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="personalloanBalance">Personal loan Balance:</label>
									<input type="number" class="form-control"
										name="personalloanBalance" value="${personalloanBalance}"
										required readonly>
								</div>

							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="educationalloanDeductions">Educational loan
										Deductions:</label> <input type="number" class="form-control"
										name="educationalloanDeductions"
										value="${educationalloanDeductions}" required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="educationalloanBalance">Educational loan
										Balance:</label> <input type="number" class="form-control"
										name="educationalloanBalance"
										value="${educationalloanBalance}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="cityCouncilRatesDeductions">City Council
										Rates Ded:</label> <input type="number" class="form-control"
										name="cityCouncilRatesDeductions"
										value="${cityCouncilRatesDeductions}" required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="cityCouncilRatesBalance">City Council Rates
										Balance:</label> <input type="number" class="form-control"
										name="cityCouncilRatesBalance"
										value="${cityCouncilRatesBalance}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="insurancesDeductions">Insurances
										Deductions:</label> <input type="number" class="form-control"
										name="insurancesDeductions" value="${insurancesDeductions}"
										required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="insurancesBalance">Insurances Balance:</label> <input
										type="number" class="form-control" name="insurancesBalance"
										value="${insurancesBalance}" required readonly>
								</div>

							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="otherDeductions">Other Deductions:</label> <input
										type="number" class="form-control" name="otherDeductions"
										value="${otherDeductions}" required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="otherBalance">Other Balance:</label> <input
										type="number" class="form-control" name="otherBalance"
										value="${otherBalance}" required readonly>
								</div>

								<div class="form-group col-md-2">
									<label for="targetSavings">Target Savings:</label> <input
										type="number" class="form-control" name="targetSavings"
										value="${targetSavings}" required readonly>
								</div>
								
								<div class="form-group col-md-2">
									<label for="otherDeductionsExcLeaveAllowance">Deductions
										Exc Leave Allow:</label> <input type="number" class="form-control"
										name="otherDeductionsExcLeaveAllowance"
										value="${otherDeductionsExcLeaveAllowance}" required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="repaymentPeriod">Months to Repay:</label> <input
										type="number" class="form-control" name="repaymentPeriod"
										value="${repaymentPeriod}" required readonly>
								</div>
								<div class="form-group col-md-2">
									<label for="instalment">Instalment:</label> <input
										type="number" class="form-control" name="instalment"
										value="${instalment}" required readonly>
								</div>

							</div>


							<div class="form-row">



							</div>



							<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>



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
