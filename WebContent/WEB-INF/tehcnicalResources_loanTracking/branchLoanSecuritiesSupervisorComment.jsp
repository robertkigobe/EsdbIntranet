<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Securities Supervisor Comments</title>

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

			<div>

				<div style="margin-left: 40px;">
					<h3>Securities Supervisor Comments</h3>
					<div>

						<a href="file:///${securitiesDocumentLocation}" class="Button">Copy
							this Link and View Securities in new tab</a>

						<form action="BranchLoanSecuritiesSupervisorComment" method="POST">

							<div style="border-style: ridge">
								<h6>Customer Information</h6>

								<div class="form-row">
									<div class="form-group col-md-2">
										<label for="applicantName">Full Name:</label> <input
											type="text" class="form-control" name="applicantName"
											id="applicantName" value="${applicantName}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="nationality">Nationality</label> <input
											type="text" class="form-control" name="nationality"
											id="nationality" value="${nationality}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="iDNumber">National ID</label> <input type="text"
											class="form-control" name="iDNumber" id="iDNumber"
											value="${iDNumber}" required>
									</div>


									<div class="form-group col-md-2">
										<label for="taxIdentity">Tax Identity</label> <input
											type="text" class="form-control" name="taxIdentity"
											id="taxIdentity" id="taxIdentity" value="${taxIdentity}"
											required>
									</div>


									<div class="form-group col-md-2">
										<label for="dateOfBirth">Date of Birth</label> <input
											type="text" class="form-control" name="dateOfBirth"
											id="dateOfBirth" value="${dateOfBirth}" required>
									</div>


									<div class="form-group col-md-2">
										<label for="maritalStatus">Marital Status</label> <select
											name="maritalStatus" class="form-control" required>
											<option>${maritalStatus}</option>
											<option>Single</option>
											<option>Married</option>
											<option>Widowed</option>
											<option>Divorced</option>
										</select>

									</div>
								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="noOfDependants">Dependants</label> <input
											type="number" class="form-control" name="noOfDependants"
											id="noOfDependants" value="${noOfDependants}" required>
									</div>

									<div class="form-group col-md-10">
										<label for="loanReference">Loan Reference</label> <input
											type="text" class="form-control" name="loanReference"
											id="loanReference" value="${loanReference}" readonly>
									</div>




								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="physicalAddressType">Physical Add Type:</label> <select
											name="physicalAddressType" class="form-control" required>
											<option>${physicalAddressType}</option>
											<option>Own House</option>
											<option>Rented Flat</option>
											<option>Company House</option>
											<option>Parental Home</option>
										</select>
									</div>


									<div class="form-group col-md-4">
										<label for="physicalAddress">Physical Address </label> <input
											type="text" class="form-control" name="physicalAddress"
											id="physicalAddress" value="${physicalAddress}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="postalAddress">Postal Address </label> <input
											type="text" class="form-control" name="postalAddress"
											id="postalAddress" value="${postalAddress}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="telelephoneNo">Telephone Number</label> <input
											type="text" class="form-control" name="telelephoneNo"
											value="${telelephoneNo}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="mobileNo">Mobile Number</label> <input type="text"
											class="form-control" name="mobileNo" value="${mobileNo}"
											required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="applicantDistrict">District:</label> <input
											type="text" class="form-control" name="applicantDistrict"
											id="applicantDistrict" value="${applicantDistrict}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="applicantHomeArea">Home Area</label> <input
											type="text" class="form-control" name="applicantHomeArea"
											id="applicantHomeArea" value="${applicantHomeArea}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="applicantNearestShop_school">Nearest Shop:</label>
										<input type="text" class="form-control"
											name="applicantNearestShop_school"
											id="applicantNearestShop_school"
											value="${applicantNearestShop_school}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="applicantChief">Chief</label> <input type="text"
											class="form-control" name="applicantChief"
											value="${applicantChief}" required>
									</div>



									<div class="form-group col-md-2">
										<label for="applicantIndvuna">Indvuna</label> <input
											type="text" class="form-control" name="applicantIndvuna"
											value="${applicantIndvuna}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="applicantRunner">Runner:</label> <input
											type="text" class="form-control" name="applicantRunner"
											value="${applicantRunner}" required>
									</div>

								</div>

								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="employerName">Employer Name:</label> <input
											type="text" class="form-control" name="employerName"
											value="${employerName}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="employerAddress">Employer Address</label> <input
											type="text" class="form-control" name="employerAddress"
											value="${employerAddress}" id="employerAddress" required>
									</div>
									<div class="form-group col-md-3">
										<label for="employerPhysicalAddress">Employer Physical
											Address </label> <input type="text" class="form-control"
											name="employerPhysicalAddress" id="employerPhysicalAddress"
											value="${employerPhysicalAddress}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="employerTelephoneNo">Employer Tel No:</label> <input
											type="text" class="form-control" name="employerTelephoneNo"
											id="employerTelephoneNo" value="${employerTelephoneNo}"
											required>
									</div>

									<div class="form-group col-md-2">
										<label for="employementTerms">Emp Terms</label> <select
											name="employementTerms" class="form-control"
											id="employementTerms" required>

											<option>${employementTerms}</option>
											<option>Permanent and Pensionable</option>
											<option>Contract/Temprorary</option>
											<option>Probabtion</option>

										</select>

									</div>

									<div class="form-group col-md-1">
										<label for="employementPeriod">Period</label> <input
											type="text" class="form-control" name="employementPeriod"
											id="employementPeriod" value="${employementPeriod}" required>
									</div>

								</div>


								<div class="form-row">


									<div class="form-group col-md-3">
										<label for="applicantName">Next of Kin (NOK)Name:</label> <input
											type="text" class="form-control" name="nextOfKinName"
											id="nextOfKinName" id="nextOfKinName"
											value="${nextOfKinName}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="nextOfKinOccupation">NOK Occupation:</label> <input
											type="text" class="form-control" name="nextOfKinOccupation"
											id="nextOfKinOccupation" id="nextOfKinOccupation"
											value="${nextOfKinOccupation}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="nextOfKinEmployer">NOK Employer:</label> <input
											type="text" class="form-control" name="nextOfKinEmployer"
											id="nextOfKinEmployer" id="nextOfKinEmployer"
											value="${nextOfKinEmployer}" required>
									</div>


									<div class="form-group col-md-2">
										<label for="nextOfKinTelephoneNo">NOK Telephone:</label> <input
											type="text" class="form-control" name="nextOfKinTelephoneNo"
											id="nextOfKinTelephoneNo" id="nextOfKinTelephoneNo"
											value="${nextOfKinTelephoneNo}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="nextOfKinCellNo">NOK Cellphone:</label> <input
											type="text" class="form-control" name="nextOfKinCellNo"
											id="nextOfKinCellNo" id="nextOfKinCellNo"
											value="${nextOfKinCellNo}" required>
									</div>


								</div>


								<div class="form-row">


									<div class="form-group col-md-2">
										<label for="applicantBankName">Banker's Name</label> <input
											type="text" class="form-control" name="applicantBankName"
											id="applicantBankName" id="applicantBankName"
											value="${applicantBankName}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="applicantBankBranch">Branch</label> <input
											type="text" class="form-control" name="applicantBankBranch"
											id="applicantBankBranch" id="applicantBankBranch"
											value="${applicantBankBranch}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="applicantBankAccountNumber">Account
											Number(s)</label> <input type="text" class="form-control"
											name="applicantBankAccountNumber"
											id="applicantBankAccountNumber"
											id="applicantBankAccountNumber"
											value="${applicantBankAccountNumber}">
									</div>


									<div class="form-group col-md-2">
										<label for="previouslyAppliedforLoanwithSdsb">Previous
											Loans</label> <select name="previouslyAppliedforLoanwithSdsb"
											class="form-control" id="previouslyAppliedforLoanwithSdsb"
											required>
											<option>${previouslyAppliedforLoanwithSdsb}</option>
											<option>Yes</option>
											<option>No</option>
										</select>
									</div>
									<div class="form-group col-md-2">
										<label for="previousLoanType">Previous Type:</label> <select
											name="previousLoanType" class="form-control"
											id="previousLoanType">
											<option>${previousLoanType}</option>
											<option>Personal</option>
											<option>Auto Easy</option>
										</select>
									</div>


									<div class="form-group col-md-2">
										<label for="previousLoanBalances">Previous Balances</label> <input
											type="number" class="form-control"
											name="previousLoanBalances" id="previousLoanBalances"
											id="previousLoanBalances" value="${previousLoanBalances}">
									</div>

								</div>

							</div>


							<div style="border-style: ridge">
								<h4>Monthly Budget</h4>
								<div class="form-row">


									<div class="form-group col-md-2">
										<label for="basicSalary">Basic Salary (E)</label> <input
											type="number" class="form-control" name="basicSalary"
											id="basicSalary" id="basicSalary" value="${basicSalary}">
									</div>

									<div class="form-group col-md-2">
										<label for="otherIncome">Other Income (E)</label> <input
											type="number" class="form-control" name="otherIncome"
											id="otherIncome" id="otherIncome" value="${otherIncome}">
									</div>

									<div class="form-group col-md-2">
										<label for="deficiency">Deficiency (E)</label> <input
											type="number" class="form-control" name="deficiency"
											id="deficiency" id="deficiency" value="${deficiency}">
									</div>

									<div class="form-group col-md-2">
										<label for="surplus">Surplus (E)</label> <input type="number"
											class="form-control" name="surplus" id="surplus" id="surplus"
											value="${surplus}">
									</div>



								</div>
								<div class="form-row">

									<div class="form-group col-md-2">
										<label for="providentFund">Provident Fund (E)</label> <input
											type="number" class="form-control" name="providentFund"
											id="providentFund" id="providentFund"
											value="${providentFund}">
									</div>


									<div class="form-group col-md-2">
										<label for="medicalAid">MedicalAid (E)</label> <input
											type="number" class="form-control" name="medicalAid"
											id="medicalAid" id="medicalAid" value="${medicalAid}">
									</div>
									<div class="form-group col-md-2">
										<label for="pension">Pension (E)</label> <input type="number"
											class="form-control" name="pension" id="pension" id="pension"
											value="${pension}">
									</div>


									<div class="form-group col-md-2">
										<label for="tax">Tax (E)</label> <input type="number"
											class="form-control" name="tax" id="tax" id="tax"
											value="${tax}">
									</div>
									<div class="form-group col-md-2">
										<label for="rent">Rent (E)</label> <input type="number"
											class="form-control" name="rent" id="rent" id="rent"
											value="${rent}">
									</div>
									<div class="form-group col-md-2">
										<label for="electricity">Electricity (E)</label> <input
											type="number" class="form-control" name="electricity"
											id="electricity" id="electricity" value="${electricity}">
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-2">
										<label for="water">Water (E)</label> <input type="number"
											class="form-control" name="water" id="water" id="water"
											value="${water}">
									</div>
									<div class="form-group col-md-2">
										<label for="food">Food (E)</label> <input type="number"
											class="form-control" name="food" id="food" id="food"
											value="${food}">
									</div>
									<div class="form-group col-md-2">
										<label for="loans">Loans (E)</label> <input type="number"
											class="form-control" name="loans" id="loans" id="loans"
											value="${loans}">
									</div>
									<div class="form-group col-md-2">
										<label for="otherAccounts">Other Accounts (E)</label> <input
											type="number" class="form-control" name="otherAccounts"
											id="otherAccounts" id="otherAccounts"
											value="${otherAccounts}">
									</div>
									<div class="form-group col-md-2">
										<label for="insurances">Insurances (E)</label> <input
											type="number" class="form-control" name="insurances"
											id="insurances" id="insurances" value="${insurances}">
									</div>
									<div class="form-group col-md-2">
										<label for="otherDeduction">Other Deduction</label> <input
											type="number" class="form-control" name="otherDeduction"
											id="otherDeduction" id="otherDeduction"
											value="${otherDeduction}">
									</div>
								</div>

							</div>


							<div style="border-style: ridge">
								<h4>Statement of Affairs and Monthly Budget</h4>
								<div class="form-row">

									<div class="form-group col-md-3">
										<label for="longTermLoans">Long Term Loans(E)</label> <input
											type="number" class="form-control" name="longTermLoans"
											id="longTermLoans" id="longTermLoans"
											value="${longTermLoans}">
									</div>

									<div class="form-group col-md-3">
										<label for="overdrafts">Overdrafts (E)</label> <input
											type="number" class="form-control" name="overdrafts"
											id="overdrafts" id="overdrafts" value="${overdrafts}">
									</div>

									<div class="form-group col-md-3">
										<label for="otherDebts">Other Debts (E)</label> <input
											type="number" class="form-control" name="otherDebts"
											id="otherDebts" id="otherDebts" value="${otherDebts}">
									</div>

									<div class="form-group col-md-3">
										<label for="surplusLiabilities">Surplus Liabilities
											(E)</label> <input type="number" class="form-control"
											name="surplusLiabilities" id="surplusLiabilities"
											id="surplusLiabilities" value="${surplusLiabilities}">
									</div>


								</div>

								<div class="form-row">

									<div class="form-group col-md-4">
										<label for="property">Property (E)</label> <input
											type="number" class="form-control" name="property"
											id="property" id="property" value="${property}">
									</div>



									<div class="form-group col-md-4">
										<label for="furnitureCars">Furniture/Cars (E)</label> <input
											type="number" class="form-control" name="furnitureCars"
											id="furnitureCars" id="furnitureCars"
											value="${furnitureCars}">
									</div>


									<div class="form-group col-md-4">
										<label for="otherAssets">Other Assets (E)</label> <input
											type="number" class="form-control" name="otherAssets"
											id="otherAssets" id="otherAssets" value="${otherAssets}">
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="cashAtBank">Cash AtBank (E)</label> <input
											type="number" class="form-control" name="cashAtBank"
											id="cashAtBank" id="cashAtBank" value="${cashAtBank}">
									</div>



									<div class="form-group col-md-4">
										<label for="savings">Savings (E)</label> <input type="number"
											class="form-control" name="savings" id="savings" id="savings"
											value="${savings}">
									</div>
									<div class="form-group col-md-4">
										<label for="fixedDeposit">Fixed Deposit (E)</label> <input
											type="number" class="form-control" name="fixedDeposit"
											id="fixedDeposit" id="fixedDeposit" value="${fixedDeposit}">
									</div>

								</div>

								<div class="form-row">
									<div class="form-group col-md-2">
										<label for="water">Water (E)</label> <input type="number"
											class="form-control" name="water" id="water" id="water"
											value="${water}">
									</div>
									<div class="form-group col-md-2">
										<label for="food">Food (E)</label> <input type="number"
											class="form-control" name="food" id="food" id="food"
											value="${food}">
									</div>
									<div class="form-group col-md-2">
										<label for="loans">Loans (E)</label> <input type="number"
											class="form-control" name="loans" id="loans" id="loans"
											value="${loans}">
									</div>
									<div class="form-group col-md-2">
										<label for="otherAccounts">Other Accounts (E)</label> <input
											type="number" class="form-control" name="otherAccounts"
											id="otherAccounts" id="otherAccounts"
											value="${otherAccounts}">
									</div>
									<div class="form-group col-md-2">
										<label for="insurances">Insurances (E)</label> <input
											type="number" class="form-control" name="insurances"
											id="insurances" id="insurances" value="${insurances}">
									</div>
									<div class="form-group col-md-2">
										<label for="otherDeductions">Other Deduction</label> <input
											type="number" class="form-control" name="otherDeductions"
											id="otherDeductions" id="otherDeductions"
											value="${otherDeduction}">
									</div>


								</div>

							</div>
							<div style="border-style: ridge">
								<h4>Debts to be Cleared</h4>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="debtorsName1">First Debtor's Name</label> <input
											type="text" class="form-control" name="debtorsName1"
											id="debtorsName1" id="debtorsName1" value="${debtorsName1}"
											required>
									</div>
									<div class="form-group col-md-4">
										<label for="debtorsName1Amount">First Debtor's Amount</label>
										<input type="number" class="form-control"
											name="debtorsName1Amount" id="debtorsName1Amount"
											id="debtorsName1Amount" value="${debtorsName1Amount}"
											required>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="debtorsName2">Second Debtor's Name</label> <input
											type="text" class="form-control" name="debtorsName2"
											id="debtorsName2" id="debtorsName2" value="${debtorsName2}"
											required>
									</div>
									<div class="form-group col-md-4">
										<label for="debtorsName2Amount">Second Debtor's Amount</label>
										<input type="number" class="form-control"
											name="debtorsName2Amount" id="debtorsName2Amount"
											id="debtorsName2Amount" value="${debtorsName2Amount}"
											required>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="debtorsName3">Third Debtor's Name</label> <input
											type="text" class="form-control" name="debtorsName3"
											id="debtorsName3" id="debtorsName3" value="${debtorsName3}"
											required>
									</div>
									<div class="form-group col-md-4">
										<label for="debtorsName3Amount">Third Debtor's Amount</label>
										<input type="number" class="form-control"
											name="debtorsName3Amount" id="debtorsName3Amount"
											id="debtorsName3Amount" value="${debtorsName3Amount}"
											required>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="debtorsName4">Fourth Debtor's Name</label> <input
											type="text" class="form-control" name="debtorsName4"
											id="debtorsName4" id="debtorsName4" value="${debtorsName4}"
											required>
									</div>
									<div class="form-group col-md-4">
										<label for="number">Fourth Debtor's Amount</label> <input
											type="number" class="form-control" name="debtorsName4Amount"
											id="debtorsName4Amount" id="debtorsName4Amount"
											value="${debtorsName4Amount}" required>
									</div>
								</div>
							</div>


							<div style="border-style: ridge">
								<h4>References - can include Close relatives</h4>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="referenceName1">First Reference Name</label> <input
											type="text" class="form-control" name="referenceName1"
											id="referenceName1" id="referenceName1"
											value="${referenceName1}" required>
									</div>
									<div class="form-group col-md-6">
										<label for="referenceName1PhysicalAddress">First
											Reference Physical Address</label> <input type="text"
											class="form-control" name="referenceName1PhysicalAddress"
											id="referenceName1PhysicalAddress"
											id="referenceName1PhysicalAddress"
											value="${referenceName1PhysicalAddress}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="referenceName1TelephoneNo">Telephone
											Number</label> <input type="text" class="form-control"
											name="referenceName1TelephoneNo"
											id="referenceName1TelephoneNo" id="referenceName1TelephoneNo"
											value="${referenceName1TelephoneNo}" required>
									</div>

								</div>
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="referenceName2">Second Reference Name</label> <input
											type="text" class="form-control" name="referenceName2"
											id="referenceName2" id="referenceName2"
											value="${referenceName2}" required>
									</div>
									<div class="form-group col-md-6">
										<label for="referenceName2PhysicalAddress">Second
											Reference Physical Address</label> <input type="text"
											class="form-control" name="referenceName2PhysicalAddress"
											id="referenceName2PhysicalAddress"
											id="referenceName2PhysicalAddress"
											value="${referenceName2PhysicalAddress}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="referenceName2TelephoneNo">Telephone
											Number</label> <input type="text" class="form-control"
											name="referenceName2TelephoneNo"
											id="referenceName2TelephoneNo" id="referenceName2TelephoneNo"
											value="${referenceName2TelephoneNo}" required>
									</div>

								</div>
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="referenceName3">Third Reference Name</label> <input
											type="text" class="form-control" name="referenceName3"
											id="referenceName3" id="referenceName3"
											value="${referenceName3}" required>
									</div>
									<div class="form-group col-md-6">
										<label for="referenceName3PhysicalAddress">Third
											Reference Physical Address</label> <input type="text"
											class="form-control" name="referenceName3PhysicalAddress"
											id="referenceName3PhysicalAddress"
											id="referenceName3PhysicalAddress"
											value="${referenceName3PhysicalAddress}" required>
									</div>
									<div class="form-group col-md-2">
										<label for="referenceName3TelephoneNo">Telephone
											Number</label> <input type="text" class="form-control"
											name="referenceName3TelephoneNo"
											id="referenceName3TelephoneNo" id="referenceName3TelephoneNo"
											value="${referenceName3TelephoneNo}" required>
									</div>

								</div>
							</div>
							<div style="border-style: ridge">
								<h4>Loan Figures</h4>
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="levelTermInsurancePremiumAmount">Level
											term Insurance Premium Amount</label> <input type="number"
											class="form-control" name="levelTermInsurancePremiumAmount"
											id="levelTermInsurancePremiumAmount"
											value="${levelTermInsurancePremiumAmount}" required>
									</div>

									<div class="form-group col-md-4">
										<label for="administationFee">Administation Fee</label> <input
											type="" number"" class="form-control" name="administationFee"
											id="administationFee" id="administationFee"
											value="${administationFee}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="establishmentFee">Establishment Fee</label> <input
											type="" number"" class="form-control" name="establishmentFee"
											id="establishmentFee" value="${establishmentFee}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="interestRate">Interest Rate</label> <input type=""
											number"" class="form-control" name="interestRate"
											id="interestRate" value="${interestRate}" required>
									</div>


								</div>

								<div class="form-row">
									<div class="form-group col-md-2">
										<label for="loanAmount">Loan Amount</label> <input type=""
											number""
											class="form-control" name="loanAmount"
											id="loanAmount" value="${loanAmount}" required>
									</div>

									<div class="form-group col-md-6">
										<label for="loanAmountWords">Loan Amount in words</label> <input
											type="text" class="form-control" name="loanAmountWords"
											id="loanAmountWords" value="${loanAmountWords}" required>
									</div>

									<div class="form-group col-md-2">
										<label for="repaymentPeriod">Repayment period</label> <input
											type="" number"" class="form-control" name="repaymentPeriod"
											id="repaymentPeriod" value="${repaymentPeriod}" required>
									</div>

								</div>
							</div>

							<div style="border-style: ridge">
								<h4>Branch Info</h4>
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="businessConsultantName">Business
											Consultant Name</label> <input type="text" class="form-control"
											name="businessConsultantName" id="businessConsultantName"
											id="businessConsultantName" value="${businessConsultantName}"
											required>
									</div>

									<div class="form-group col-md-4">
										<label for="businessConsultantEmail">Business
											Consultant Email</label> <input type="text" class="form-control"
											name="businessConsultantEmail" id="businessConsultantEmail"
											id="businessConsultantEmail"
											value="${businessConsultantEmail}" required>
									</div>

									<div class="form-group col-md-4">
										<label for="branch">Branch:</label> <select name="branch"
											class="form-control" required>
											<option>${branch}</option>
											<option>CASH CENTRE BRANCH</option>
											<option>EZULWINI BRANCH</option>
											<option>MANZINI BRANCH</option>
											<option>MATSAPHA BRANCH</option>
											<option>MBABANE BRANCH</option>
											<option>MBABANE COMMERCIAL BRANCH</option>
											<option>MATATA BRANCH</option>
											<option>SIPHOFANENI</option>
											<option>SIMUNYE BRANCH</option>
											<option>NHLANGANO BRANCH</option>
											<option>SITEKI BRANCH</option>
											<option>PIGGS PEAK BRANCH</option>
										</select>
									</div>

								</div>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="branchManagerName">Branch Manager Name</label> <input
											type="text" class="form-control" name="branchManagerName"
											id="branchManagerName" id="branchManagerName"
											value="${branchManagerName}" required>
									</div>

									<div class="form-group col-md-4">
										<label for="branchManagerEmail">Branch Manager Email</label> <input
											type="text" class="form-control" name="branchManagerEmail"
											id="branchManagerEmail" id="branchManagerEmail"
											value="${branchManagerEmail}" required>
									</div>


									<div class="form-group col-md-4">
										<label for="businessConsultantCommentDate">Date of
											Request</label> <input type="text" class="form-control"
											name="businessConsultantCommentDate"
											id="businessConsultantCommentDate"
											value="${ businessConsultantCommentDate}" required>
									</div>

								</div>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="creditAnalystName">Credit Analyst Name</label> <input
											type="text" class="form-control" name="creditAnalystName"
											id="creditAnalystName" id="creditAnalystName"
											value="${creditAnalystName}" required>
									</div>

									<div class="form-group col-md-4">
										<label for="creditAnalystEmail">Credit Analyst Email</label> <input
											type="text" class="form-control" name="creditAnalystEmail"
											id="creditAnalystEmail" id="creditAnalystEmail"
											value="${creditAnalystEmail}" required>
									</div>


									<div class="form-group col-md-4">
										<label for="branchManagerCommentDate">Date of request</label>
										<input type="text" class="form-control"
											name="branchManagerCommentDate" id="branchManagerCommentDate"
											value="${branchManagerCommentDate}" required>
									</div>

								</div>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="creditAnalystName">Credit Manager Name</label> <input
											type="text" class="form-control" name="creditAnalystName"
											id="creditAnalystName" id="creditAnalystName"
											value="${creditAnalystName}" required>
									</div>

									<div class="form-group col-md-4">
										<label for="creditAnalystEmail">Credit Manager Email</label> <input
											type="text" class="form-control" name="creditAnalystEmail"
											id="creditAnalystEmail" id="creditAnalystEmail"
											value="${creditAnalystEmail}" required>
									</div>


									<div class="form-group col-md-4">
										<label for="creditAnalystCommentDate">Date of request</label>
										<input type="text" class="form-control"
											name="creditAnalystCommentDate" id="creditAnalystCommentDate"
											value="${creditAnalystCommentDate}" required>
									</div>

								</div>
							</div>
							<div style="border-style: ridge">
								<h4>Loan Comments</h4>
								<div class="form-row">


									<div class="form-group col-md-6">
										<label for="businessConsultantComment"> Business
											Consultant Comment</label> <input type="text" class="form-control"
											name="businessConsultantComment"
											id="businessConsultantComment"
											value="${ businessConsultantComment}" readonly>

									</div>
									<div class="form-group col-md-3">
										<label for="businessConsultantName">Business Cons Name
											Date</label> <input type="text" class="form-control"
											name="businessConsultantName" id="businessConsultantName"
											value="${ businessConsultantName}" readonly>
									</div>

									<div class="form-group col-md-3">
										<label for="businessConsultantCommentDate">Date</label> <input
											type="text" class="form-control"
											name="businessConsultantCommentDate"
											id="businessConsultantCommentDate"
											value="${ businessConsultantCommentDate}" readonly>
									</div>

								</div>

								<div class="form-row">


									<div class="form-group col-md-6">
										<label for="branchManagerComment"> Branch Manager
											Comment</label> <input type="text" class="form-control"
											name="branchManagerComment" id="branchManagerComment"
											value="${branchManagerComment}" required>
									</div>

									<div class="form-group col-md-3">
										<label for="branchManagerName">Branch Manager Name</label> <input
											type="text" class="form-control" name="branchManagerName"
											id="branchManagerName" value="${branchManagerName}" required>
									</div>


									<div class="form-group col-md-3">
										<label for="branchManagerCommentDate">Date</label> <input
											type="text" class="form-control"
											name="branchManagerCommentDate" id="branchManagerCommentDate"
											value="${branchManagerCommentDate}" required>
									</div>
								</div>


								<div class="form-row">


									<div class="form-group col-md-6">
										<label for="creditAnalystComment"> Credit Analyst
											Comment</label> <input type="text" class="form-control"
											name="creditAnalystComment" id="creditAnalystComment"
											value="${creditAnalystComment}" required>
									</div>

									<div class="form-group col-md-3">
										<label for="creditAnalystName"> Credit Analyst Name</label> <input
											type="text" class="form-control" name="creditAnalystName"
											id="creditAnalystName" value="${creditAnalystName}" required>
									</div>


									<div class="form-group col-md-3">
										<label for="creditAnalystCommentDate">Date</label> <input
											type="text" class="form-control"
											name="creditAnalystCommentDate" id="creditAnalystCommentDate"
											value="${creditAnalystCommentDate}" required>
									</div>
								</div>

								<div class="form-row">


									<div class="form-group col-md-6">
										<label for="creditManagerComment"> Credit Manager
											Comment</label> <input type="text" class="form-control"
											name="creditManagerComment" id="creditManagerComment"
											value="${creditManagerComment}" required>
									</div>

									<div class="form-group col-md-3">
										<label for="branchManagerName"> Branch Manager Name</label> <input
											type="text" class="form-control" name="branchManagerName"
											id="branchManagerName" value="${branchManagerName}" readonly>
									</div>


									<div class="form-group col-md-3">
										<label for="branchManagerEmail">Branch Manager Email</label> <input
											type="email" class="form-control" name="branchManagerEmail"
											id="branchManagerEmail" value="${branchManagerEmail}"
											readonly>
									</div>
								</div>

								<div class="form-row">


									<div class="form-group col-md-6">
										<label for="securitiesSupervisorComment"> Securities
											Supervisor Comment</label> <input type="text" class="form-control"
											name="securitiesSupervisorComment"
											id="securitiesSupervisorComment" required>
									</div>

									<div class="form-group col-md-3">
										<label for="loanOpeningSupervisorName"> LoanOpening
											Supervisor</label> <input type="text" class="form-control"
											name="loanOpeningSupervisorName"
											id="loanOpeningSupervisorName">
									</div>


									<div class="form-group col-md-3">
										<label for="loanOpeningSupervisorEmail">LoanOpening
											Email</label> <input type="email" class="form-control"
											name="loanOpeningSupervisorEmail"
											id="loanOpeningSupervisorEmail">
									</div>
								</div>

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
