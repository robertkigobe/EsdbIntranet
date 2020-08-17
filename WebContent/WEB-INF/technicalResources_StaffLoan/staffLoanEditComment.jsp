<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Staff Loan Application</title>

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
					<h3>Supervisor Comment</h3>
					<div>
						<form action="StaffLoanUpdateLoanEdit" method="POST">
						
						<div class="form-row">
						
						<div class="form-group col-md-4">
									<label for="employeeLoanRef">Loan Ref:</label> <input
										type="text" class="form-control" name="employeeLoanRef"
										value="${employeeLoanRef}" required readonly>
								</div>

								<div class="form-group col-md-8">
									<label for="supervisorEmail">Employee Comment:</label> <input
										type="text" class="form-control" name="applicantComment"
										value="${applicantComment}" required >
								</div>

							</div>
						
						
							<div class="form-row">
								<div class="form-group col-md-2">
									<label for="loanStatus">Loan Status:</label>
									
									<input
										type="text" class="form-control" name="loanStatus"
										value="Pending-Supervisor Comments" readonly >
 
								</div>

								<div class="form-group col-md-6">
									<label for="supervisorComment">Supervisor Comment:</label> <input
										type="text" class="form-control" name="supervisorComment"
										value="${supervisorComment}" required >
								</div>
								<div class="form-group col-md-2">
									<label for="supervisorEmail">Supervisor Email:</label> <input
										type="email" class="form-control" name="supervisorEmail"
										value="${supervisorEmail}" required>
								</div>
								
								<div class="form-group col-md-2">
									<label for="hodEmail">Hod Email:</label> <input
										type="email" class="form-control" name="hodEmail"
										value="${hodEmail}" required>
								</div>
							</div>


							<div class="form-row">


								<div class="form-group col-md-2">
									<label for="employeeCode">Employee No</label> <input
										type="text" class="form-control" name="employeeCode"
										id="employeeEmploymentNo" value="${employeeCode}" required
										>
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
									<label for="secondName">Second Name</label> <input type="text"
										class="form-control" name="secondName" id="secondName"
										value="${secondName}"  >
								</div>
								
								<div class="form-group col-md-2">
									<label for="supervisor">Emp supervisor:</label> <input
										type="text" class="form-control" name="supervisor"
										value="${supervisor}" required >
								</div>
								
								<div class="form-group col-md-2">
									<label for="employeeEmail">Emp Email:</label> <input
										type="email" class="form-control" name="employeeEmail"
										value="${employeeEmail}" >
								</div>

							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="iDNumber">National Id:</label> <input type="text"
										class="form-control" name="iDNumber" value="${iDNumber}"
										required >
								</div>

								<div class="form-group col-md-2">
									<label for="cif">CIF:</label> <input type="text"
										class="form-control" name="cif" value="${cif}" required
										>
								</div>



								<div class="form-group col-md-2">
									<label for="dateOfBirth">Date of Birth:</label> <input
										type="text" class="form-control" name="dateOfBirth"
										value="${dateOfBirth}" required >
								</div>
								
							
								

								<div class="form-group col-md-2">
									<label for="maritalStatus">Marital Status</label> <input
										type="text" class="form-control" name="maritalStatus"
										id="maritalStatus" value="${maritalStatus}" required >
								</div>

								<div class="form-group col-md-4">
									<label for="dateEngaged">Date Engaged:</label> <input
										type="text" class="form-control" name="dateEngaged"
										value="${dateEngaged}" required >
								</div>

								

							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="employeePosition">Employee Position:</label> <input
										type="text" class="form-control" name="employeePosition" id="employeePosition"
										value="${employeePosition}" required >
								</div>
								<div class="form-group col-md-2">
									<label for="employeeGrade">Employee Grade:</label> <input
										type="text" class="form-control" name="employeeGrade"
										id="employeeGrade" value="${employeeGrade}" required >
								</div>

								<div class="form-group col-md-2">
									<label for="employeeDepartment">Department:</label> <input
										type="text" class="form-control" name="employeeDepartment"
										id="employeeDepartment" value="${employeeDepartment}" required
										>
								</div>
								
								



								<div class="form-group col-md-2">
									<label for="branchAdress">Branch Adress:</label> <input
										type="text" class="form-control" name="branchAdress"
										value="${branchAdress}" required >
								</div>

								<div class="form-group col-md-4">
									<label for="resAddress">Employee Address:</label> <input
										type="text" class="form-control" name="resAddress"
										value="${resAddress}" required >
								</div>

							</div>

							<div class="form-row">

								

								<div class="form-group col-md-4">
									<label for="telelephoneNo">Mobile:</label> <input type="text"
										class="form-control" name="telelephoneNo"
										value="${telelephoneNo}" required >
								</div>
								
								<div class="form-group col-md-2">
									<label for="emailAddress">Employee Email:</label> <input
										type="email" class="form-control" name="emailAddress"
										value="${emailAddress}" required >
								</div>
								<div class="form-group col-md-2">
									<label for="noOfDependants">Dependants:</label> <input
										type="text" class="form-control" name="noOfDependants"
										value="${noOfDependants}" required >
								</div>

								<div class="form-group col-md-2">
									<label for="loanType">Loan Type:</label> 
									
									<input
										type="text" class="form-control" name="loanType"
										value="${loanType}" required > 
								</div>

								<div class="form-group col-md-2">
									<label for="purposeOfLoan">Purpose Of Loan:</label> <input
										type="text" class="form-control" name="purposeOfLoan"
										value="${purposeOfLoan}" required >
								</div>

							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="dateloanRequired">Date Required:</label> <input
										type="date" class="form-control" name="dateloanRequired"
										value="${dateloanRequired}" required >
								</div>

								<div class="form-group col-md-2">
									<label for="dateOfFirstInstallment">Date of First
										Installment:</label> <input type="date" class="form-control"
										name="dateOfFirstInstallment"
										value="${dateOfFirstInstallment}" required >
								</div>

								<div class="form-group col-md-2">
									<label for="dateOfLastInstallment">Date of Last
										Installment:</label> <input type="date" class="form-control"
										name="dateOfLastInstallment" value="${dateOfLastInstallment}"
										required >
								</div>

								<div class="form-group col-md-2">
									<label for="loanAmount">Loan Amount:</label> <input
										type="number" class="form-control" name="loanAmount"
										value="${loanAmount}" step="0.01" class="two-decimals" required >
								</div>

								<div class="form-group col-md-4">
									<label for="loanAmount">Amount in words:</label> <input
										type="text" class="form-control" name="loanAmountWords"
										value="${loanAmountWords}" required >
								</div>



							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="basicSalary">Basic Salary:</label> <input
										type="number" class="form-control" name="basicSalary"
										value="${basicSalary}" step="0.01" class="two-decimals" required >
								</div>

								<div class="form-group col-md-2">
									<label for="allowances">Allowances:</label> <input
										type="number" class="form-control" name="allowances"
										value="${allowances}" step="0.01" class="two-decimals" required >
								</div>
								<div class="form-group col-md-2">
									<label for="housingloanDeductions">Housing loan
										Deductions:</label> <input type="number" class="form-control" name="housingloanDeductions"
										value="${housingloanDeductions}" step="0.01" class="two-decimals" required >
								</div>
								<div class="form-group col-md-2">
									<label for="housingloanBalance">Housing loan Balance:</label> <input
										type="number" class="form-control" name="housingloanBalance"
										value="${housingloanBalance}" step="0.01" class="two-decimals" required >
								</div>

								<div class="form-group col-md-2">
									<label for="ruralHousingloanDeductions">Rural Housing
										Deductions:</label> <input type="number" class="form-control" name="ruralHousingloanDeductions"
										value="${ruralHousingloanDeductions}" step="0.01" class="two-decimals" required >
								</div>
								<div class="form-group col-md-2">
									<label for="ruralHousingloanBalance">Rural Housing
										Balance:</label> <input type="number" class="form-control" name="ruralHousingloanBalance"
										value="${ruralHousingloanBalance}" step="0.01" class="two-decimals" required >
								</div>





							</div>


							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="farm_smallHolderDeductions">Farm Small
										Holder Ded:</label> <input type="number" class="form-control" name="farm_smallHolderDeductions"
										value="${farm_smallHolderDeductions}" step="0.01" class="two-decimals" required >
								</div>
								<div class="form-group col-md-2">
									<label for="farm_smallHolderBalance">Farm Small Holder
										Balance:</label> <input type="number" class="form-control" name="farm_smallHolderBalance"
										value="${farm_smallHolderBalance}" step="0.01" class="two-decimals" required >
								</div>

								<div class="form-group col-md-2">
									<label for="carloanDeductions">Car loan Deductions:</label> <input
										type="number" class="form-control" name="carloanDeductions"
										value="${carloanDeductions}" step="0.01" class="two-decimals" required >
								</div>
								<div class="form-group col-md-2">
									<label for="carloanBalance">Car loan Balance:</label> <input
										type="number" class="form-control" name="carloanBalance"
										value="${carloanBalance}" step="0.01" class="two-decimals" required >
								</div>

								<div class="form-group col-md-2">
									<label for="personalloanDeductions">Personal loan
										Deductions:</label> <input type="number" class="form-control"
										name="personalloanDeductions" step="0.01" class="two-decimals" value="${personalloanDeductions}" required >
								</div>
								<div class="form-group col-md-2">
									<label for="personalloanBalance">Personal loan Balance:</label>
									<input type="number" class="form-control"
										name="personalloanBalance" step="0.01" class="two-decimals" value="${personalloanBalance}" required >
								</div>

							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="educationalloanDeductions">Educational loan
										Deductions:</label> <input type="number" class="form-control"
										name="educationalloanDeductions" step="0.01" class="two-decimals" value="${educationalloanDeductions}" required >
								</div>
								<div class="form-group col-md-2">
									<label for="educationalloanBalance">Educational loan
										Balance:</label> <input type="number" class="form-control"
										name="educationalloanBalance" step="0.01" class="two-decimals" value="${educationalloanBalance}" required >
								</div>

								<div class="form-group col-md-2">
									<label for="cityCouncilRatesDeductions">City Council
										Rates Ded:</label> <input type="number" class="form-control"
										name="cityCouncilRatesDeductions" step="0.01" class="two-decimals" value="${cityCouncilRatesDeductions}" required >
								</div>
								<div class="form-group col-md-2">
									<label for="cityCouncilRatesBalance">City Council Rates
										Balance:</label> <input type="number" class="form-control"
										name="cityCouncilRatesBalance" step="0.01" class="two-decimals" value="${cityCouncilRatesBalance}" required >
								</div>

								<div class="form-group col-md-2">
									<label for="insurancesDeductions">Insurances
										Deductions:</label> <input type="number" class="form-control"
										name="insurancesDeductions" step="0.01" class="two-decimals" value="${insurancesDeductions}" required >
								</div>
								<div class="form-group col-md-2">
									<label for="insurancesBalance">Insurances Balance:</label> <input
										type="number" class="form-control" name="insurancesBalance"
										value="${insurancesBalance}" step="0.01" class="two-decimals" required >
								</div>

							</div>

							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="otherDeductions">Other Deductions:</label> <input
										type="number" class="form-control" name="otherDeductions"
										value="${otherDeductions}" step="0.01" class="two-decimals" required >
								</div>
								<div class="form-group col-md-2">
									<label for="otherBalance">Other Balance:</label> <input
										type="number" class="form-control" name="otherBalance"
										value="${otherBalance}" step="0.01" class="two-decimals"  required >
								</div>

								<div class="form-group col-md-2">
									<label for="targetSavings">Target Savings:</label> <input
										type="number" class="form-control" name="targetSavings"
										value="${targetSavings}" step="0.01" class="two-decimals" required >
								</div>
								<div class="form-group col-md-2">
									<label for="statutoryDeductions">Statutory Deductions:</label>
									<input type="number" class="form-control"
										name="statutoryDeductions" step="0.01" class="two-decimals" value="${statutoryDeductions}" required >
								</div>

								<div class="form-group col-md-2">
									<label for="otherDeductionsExcLeaveAllowance">Deductions
										Exc Leave Allow:</label> <input type="number" class="form-control"
										name="otherDeductionsExcLeaveAllowance" step="0.01" class="two-decimals" value="${otherDeductionsExcLeaveAllowance}" required >
								</div>
								<div class="form-group col-md-2">
									<label for="interestRate">Interest Rate:</label> <input
										type="number" class="form-control" name="interestRate"
										value="${interestRate}" step="0.01" class="two-decimals" required >
								</div>

							</div>


							<div class="form-row">

								<div class="form-group col-md-2">
									<label for="repaymentPeriod">Months to Repay:</label> <input
										type="number" class="form-control" name="repaymentPeriod"
										value="${repaymentPeriod}" required >
								</div>

								<div class="form-group col-md-2">
									<label for="instalment">Instalment:</label> <input
										type="number" class="form-control" name="instalment"
										value="${instalment}" step="0.01" class="two-decimals" required >
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
