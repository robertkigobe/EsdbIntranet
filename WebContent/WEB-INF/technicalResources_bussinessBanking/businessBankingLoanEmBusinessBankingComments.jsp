<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Business Loan Application</title>

<link rel="stylesheet" href="jquery/jquery-ui.css">
<script
	src="${pageContext.request.contextPath}/jquery/jquery-ui.theme.css"></script>
<script src="${pageContext.request.contextPath}/jquery/jquery.js"></script>
<script src="${pageContext.request.contextPath}/jquery/jquery-ui.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


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
					<h3>Business Banking Loan Application - EM Decision</h3>
					<div>
						<form action="BusinessBankingLoanEmBusinessBankingComments" method="POST">
							<div style="border-style: ridge">
								<div style="border-style: ridge">

									<div class="container">
										<p class="bg-danger">${error}</p>
									</div>

									<div class="form-row">


										<div class="form-group col-md-6">
											<label for="loanRef">Reference:</label> <input type="text"
												class="form-control" name="loanRef" id="loanRef"
												value="${loanRef}" readonly>
												
										</div>
										
										<div class="form-group col-md-6">
											<label for="location">Location:</label> <input type="text"
												class="form-control" name="location" id="location"
												value="${location}" readonly>
												
										</div>

									</div>

									<div class="form-row">

										<div class="form-group col-md-6">
											<label for="toRecepient">To:</label> <input type="text"
												class="form-control" name="toRecepient" id="toRecepient"
												value="${toRecepient}" readonly>
										</div>

										<div class="form-group col-md-6">
											<label for="fromRecepient">From:</label> <input type="text"
												class="form-control" name="fromRecepient" id="fromRecepient"
												value="${fromRecepient}" readonly>
										</div>

									</div>

									<div class="form-row">

										<div class="form-group col-md-12">
											<label for="subjectR">Subject:</label> <input type="text"
												class="form-control" name="subjectR" id="subjectR"
												value="${subjectR}" readonly>
										</div>


									</div>

									<div class="form-row">

										<div class="form-group col-md-12">
											<label for="industry">Industry:</label> <input type="text"
												class="form-control" name="industry" value="${industry}"
												readonly>
										</div>

									</div>

								</div>

								<h4>
									<u>1. EXECUTIVE SUMMARY</u>
								</h4>
								<div style="border-style: ridge">

									<div class="form-row">

										<div class="form-group col-md-6">
											<label for="applicant_name">Applicant Name:</label> <input
												type="text" class="form-control" name="applicant_name"
												value="${applicant_name}" readonly>
										</div>
										<div class="form-group col-md-6">
											<label for="facility_type">Facility Type:</label> <input
												type="text" class="form-control" name="facility_type"
												value="${facility_type}" readonly>
										</div>
									</div>

									<div class="form-row">

										<div class="form-group col-md-6">
											<label for="purpose">Purpose:</label> <input type="text"
												class="form-control" name="purpose" value="${purpose}"
												readonly>
										</div>
										<div class="form-group col-md-6">
											<label for="loan_amount">Amount being renewed:</label> <input
												type="text" class="form-control" name="loan_amount"
												value="${loan_amount}" readonly>
										</div>
									</div>

									<div class="form-row">

										<div class="form-group col-md-2">
											<label for="startDate">Start Date:</label> <input type="text"
												class="form-control" placeholder="mm/dd/yyyy"
												name="startDate" id="datepicker" value="${startDate}"
												readonly>
										</div>

										<div class="form-group col-md-2">
											<label for="endDate">End Date:</label> <input type="text"
												class="form-control" name="endDate" 
												placeholder="mm/dd/yyyy" value="${endDate}" readonly>
										</div>

										<div class="form-group col-md-2">
											<label for="charges">Loan Amount:</label> <input type="text"
												id="charges" class="form-control" name="charges" value="${charges}" readonly>
										</div>

										<div class="form-group col-md-2">
											<label for="intertestRate">Interest Rate:</label> <input
												type="text" class="form-control" id="intertestRate"
												name="intertestRate" value="${intertestRate}" readonly>
										</div>



									</div>

									<div style="border-style: ridge">
										<h6>
											<u>2. COLLATERAL SECURITY</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="collateral_security" rows="10"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>

									<div style="border-style: ridge">
										<h6>
											<u>3. EXPOSURE TO BANK</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="exposure_to_bank" rows="3"   readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>

									<div style="border-style: ridge">
										<h6>
											<u>4. CONCLUSION</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0" name="conclusion"
												rows="6"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>

									<div style="border-style: ridge">
										<h6>
											<u>5. RECOMMENDATION</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="recommendations" rows="10"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>
								</div>

								<div style="border-style: ridge">
									<h4>
										<u>CUSTOMER DETAILS</u>
									</h4>

									<div style="border-style: ridge">
										<h6>
											<u>1. PURPOSE</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0" name="purpose2"
												rows="10"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>
									<div style="border-style: ridge">
										<h6>
											<u>2. CURRENT POSITION</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="curent_position" rows="10"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>
									<div style="border-style: ridge">
										<h6>
											<u>3. BACKGROUND</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0" name="background"
												rows="10"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>

									<div style="border-style: ridge">
										<h6>
											<u>3.2 NATURE OF BUSINESS</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="nature_of_business" rows="10"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>

									<div style="border-style: ridge">
										<h6>
											<u>3.3 NON FINANCIAL RISK ANALYSIS</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="non_financial_risks_analysis" rows="20"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>

									<div style="border-style: ridge">
										<h6>
											<u>3. MOTIVATION</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0" name="motivation"
												rows="10"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>


									<div style="border-style: ridge">
										<h6>
											<u>4. BENEFITS TO THE BANK</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="benefits_to_bank" rows="5"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>

									<div style="border-style: ridge">
										<h6>
											<u>5. COST TO THE BANK</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0" name="cost_to_bank"
												rows="5"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>

									<div style="border-style: ridge">
										<h6>
											<u>6. LEGAL IMPLICATIONS</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="legal_implications" rows="5"  readonly><c:out value="${collateral_security}" /></textarea>
										</div>

									</div>


									<div style="border-style: ridge">
										<h6>
											<u>7. ACOUNT ACTIVITY ANALYSIS</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="account_activity_analysis" rows="10"  readonly><c:out value="${account_activity_analysis}" /></textarea>
										</div>

									</div>

									<div style="border-style: ridge">
										<h6>
											<u>8. FINANCIAL RISK ANALYSIS</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="finance_risk_analysis" rows="10"  readonly><c:out value="${finance_risk_analysis}" /></textarea>
										</div>

									</div>

									<div style="border-style: ridge">
										<h6>
											<u>8.2. RATIO ANALYSIS</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="ratio_analysis" rows="10"  readonly><c:out value="${ratio_analysis}" /></textarea>
										</div>

									</div>



									<div style="border-style: ridge">
										<h6>
											<u>9. MAXIMUM LENDING LIMIT</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="maximum_lending_limit" rows="10"  readonly><c:out value="${maximum_lending_limit}" /></textarea>
										</div>

									</div>


									<div style="border-style: ridge">
										<h6>
											<u>10. CONCLUSION AND RECOOMENDATION</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="conclusion_and_recommendation" rows="10"  readonly><c:out value="${conclusion_and_recommendation}" /></textarea>
										</div>

									</div>
									
									<div style="border-style: ridge">
										<h6>
											<u>11. CREDIT COMMENTS</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="credit_comments" rows="10"  required><c:out value="${credit_comments}" /></textarea>
										</div>

									</div>
									
									<div style="border-style: ridge">
										<h6>
											<u>12. FINANCE COMMENTS</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="finance_comments" rows="10"  required><c:out value="${finance_comments}" /></textarea>
										</div>

									</div>
									
									<div style="border-style: ridge">
										<h6>
											<u>13. RISK COMMENTS</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="risk_comments" rows="10"  required><c:out value="${risk_comments}" /></textarea>
										</div>

									</div>
									
									

									<div style="border-style: ridge">
										<h6>
											<u>14. LEGAL COMMENTS</u>
										</h6>

										<div class="form-group">

											<textarea class="form-control rounded-0"
												name="legal_services" rows="10"  required><c:out value="${legal_services}" /></textarea>
										</div>

									</div>




								</div>

								<div style="border-style: ridge">
									<h4>
										<u>CUSTOMER DETAILS</u>
									</h4>

									<div style="border-style: ridge">
										<h6>
											<u>1. PURPOSE</u>
										</h6>

										<div class="form-row">

											<div class="form-group col-md-6">
												<label for="compiled_by">COMPILING OFFICER:</label> <input
													type="text" class="form-control" name="compiled_by"
													id="compiled_by" value="${compiled_by}" required>
											</div>

											<div class="form-group col-md-6">
												<label for="fromRecepient">SUBMITTING MANAGER:</label> <input
													type="text" class="form-control" name="submitted_by"
													id="submitted_by" value="${submitted_by}" required>
											</div>

										</div>

										<div style="border-style: ridge">
											<h6>
												<u>DECISION</u>
											</h6>


											<div class="form-row">
												<div class="form-group col-md-6">
													<label for="decision">Decision:</label> <select
														name="decision" class="form-control" required>
														<option></option>
														<option>Approved</option>
														<option>Rejected</option>

													</select>
												</div>

												<div class="form-group col-md-6">
													<label for="fromRecepient">Decision by:</label> <input
														type="text" class="form-control" name="decision_by"
														value="${decision_by}">
												</div>
											</div>
										</div>


									</div>

									<div style="border-style: ridge">


										<div class="form-row">


											<div class="form-group col-md-12">
												<button type="submit"
													class="btn btn-primary btn-lg btn-block" name="submitLoan">Submit
													Business Loan Application</button>

											</div>

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
