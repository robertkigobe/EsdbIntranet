<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="css/issueStyle.css" rel="stylesheet" type="text/css" />
<title>New Issue</title>
</head>
<body>
<div class="container">
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
			<h2>SwaziBank Internal Audit Issue tracking System</h2>
			
			<div >
				<form action="NewIssue" method="POST">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th style="width: 30%">Item</th>
								<th style="width: 70%">Value</th>
							</tr>
						</thead>
						<tbody>
						
						<tr>
								<td><input type="text" value="Audit Code"
									style="border: none;" /></td>
								<td><input type="text" name="auditCode"
									style="border: none; width: 100%" /></td>
							</tr>

							<tr>
								<td><input type="text" style="border: none;"
									value="Audit Type" /></td>
								<td><select name="auditType"
									style="border: none; width: 100%">

										<option></option>
										<option>Full Audit</option>
										<option>Follow-up Audit</option>
								</select></td>
							</tr>
							<tr>
								<td><input type="text" style="border: none;"
									value="Financial Year" /></td>
								<td><select name="financialYear"
									style="border: none; width: 100%">

										<option></option>
										<option>2016-2017</option>
										<option>2017-2018</option>
										<option>2018-2019</option>
										<option>2019-2020</option>
										<option>2020-2021</option>
								</select></td>
							</tr>
							<tr>
								<td><input type="text" style="border: none;"
									value="Quarter" /></td>
								<td><select name="quarter_v"
									style="border: none; width: 100%">

										<option></option>
										<option>Quarter 1</option>
										<option>Quarter 2</option>
										<option>Quarter 3</option>
										<option>Quarter 4</option>
								</select></td>
							</tr>
							<tr>

								<td><input type="text" value="Audit Date"
									style="border: none;" /></td>
								<td><input type="date" name="auditDate" value="dd/mm/yyyy"
									style="border: none; width: 100%" /></td>
							</tr>

							<tr>
								<td><input type="text" style="border: none;"
									value="Business Unit" /></td>
								<td><select name="businessUnit"
									style="border: none; width: 100%">

										<option></option>
										<option>Internal Audit</option>
										<option>Finance</option>
										<option>Operations</option>
										<option>Marketing</option>
										<option>Business Banking</option>
										<option>Corporate Services</option>
										<option>Credit</option>
										<option>Information Technology</option>
										<option>MD’s Office</option>

								</select></td>
							</tr>

							<tr>
								<td><input type="text" style="border: none;"
									value="Department" /></td>
								<td><select name="department"
									style="border: none; width: 100%">

										<option></option>
										<option>Treasury</option>
										<option>Finance</option>
										<option>SMME</option>
										<option>Agribusiness</option>
										<option>Electronic Banking</option>
										<option>Branch Network</option>
										<option>Sales</option>
										<option>Housing</option>
										<option>Corporate Business</option>
										<option>Insurance Business</option>
										<option>Motor Vehicle ( Auto-easy)</option>
										<option>Human Resources</option>
										<option>Administration</option>
										<option>Credit</option>
										<option>Account Management</option>
										<option>Reviews</option>
										<option>Securities</option>
										<option>Collections</option>
										<option>Systems</option>
										<option>Digital Banking</option>
										<option>Infrastructure</option>
										<option>Projects and Governance</option>
										<option>Business Intelligence</option>
										<option>Strategy</option>
										<option>Risk and Compliance</option>

								</select></td>
							</tr>
							<tr>
								<td><input type="text" value="Report Title"
									style="border: none;" /></td>
								<td><input type="text" name="reportTitle"
									style="border: none; width: 100%" /></td>
							</tr>

							<tr>

								<td><input type="text" value="Date Published"
									style="border: none;" /></td>
								<td><input type="date" name="datePublished" value="dd/mm/yyyy"
									style="border: none; width: 100%" /></td>
							</tr>

							<tr>

								<td><input type="text" value="Exception Title"
									style="border: none;" /></td>
								<td><input type="text" name="exceptionTitle"
									style="border: none; width: 100%" /></td>
							</tr>

							<tr>

								<td><input type="text" value="Audit Observation "
									style="border: none;" /></td>
								<td><textarea rows="5" cols="70" name="auditObservation"
										style="border: none; width: 100%" /></textarea>
							</tr>

							<tr>

								<td><input type="text" value="Agreed Manangement Action "
									style="border: none;" /></td>
								<td><textarea rows="5" cols="70"
										name="agreedManangementAction"
										style="border: none; width: 100%" /></textarea>
							</tr>

							<tr>

								<td><input type="text" value="Action Owner "
									style="border: none;"></td>
								<td><select name="actionOwner"
									style="border: none; width: 100%">
										<option></option>
										<option>EM Marketing</option>
										<option>Sales Supervisor</option>
										<option>EM Operations</option>
										<option>Manager SMME</option>
										<option>Manager Agribusiness</option>
										<option>Senior Operations Officer ( EB)</option>
										<option>EM Business banking</option>
										<option>Manager Corporate Business</option>
										<option>Manager Housing</option>
										<option>Manager Insurance</option>
										<option>Manager Motor vehicle</option>
										<option>EM Corporate Services</option>
										<option>Senior Manager Human resources</option>
										<option>Assistant Manager Administration</option>
										<option>EM Credit</option>
										<option>Manager Credit</option>
										<option>Assistant Manager Securities</option>
										<option>Assistant Manager Collections</option>
										<option>Supervisor Account Management</option>
										<option>Supervisor Reviews</option>
										<option>EM Finance</option>
										<option>Senior Manager Finance</option>
										<option>Manager Treasury</option>
										<option>Manager Budgets</option>
										<option>EM Legal</option>
										<option>Managing Director</option>
										<option>Senior Manager Strategy</option>
										<option>Head of Risk and Compliance</option>
										<option>EM IT</option>
										<option>Manager Systems</option>
										<option>Manager Digital Banking</option>
										<option>Manager Projects and Governance</option>
										<option>Manager Business Intelligence</option>
										<option>Assistant Manager Infrastructure</option>
										<option>Branch Network Controller</option>
										<option>Manager Manzini Branch</option>
										<option>Manager Matsapha Branch</option>
										<option>Manager Mbabane Branch</option>
										<option>Manager Nhlangano Branch</option>
										<option>Manager Pigg’s Peak Branch</option>
										<option>Manager Siteki Branch</option>
										<option>Manager Simunye Branch</option>
										<option>Manager Matata Branch</option>
										<option>Assistant Manager Manzini</option>
										<option>Assistant Manager Gables</option>
										<option>Assistant Manager Siphofaneni</option>
										<option>Assistant Manager Mbabane Commercial</option>
										<option>Manager OPC</option>
										<option>Manager Cash Centre</option>
										<option>Board Chairperson</option>
										<option>Audit Committee Chairperson</option>
										<option>Board Secretaries</option>
										<option>Board of Directors</option>
								</select></td>
							</tr>

							<tr>

								<td><input type="text" value="Due Date "
									style="border: none;" /></td>
								<td><input type="date" name="dueDate"
									style="border: none; width: 100%" /></td>
							</tr>

							<tr>

								<td><input type="text"
									value="Current Implementation status " style="border: none; width: 100%" /></td>

								<td><select name="currentImplementationStatus"
									style="border: none; width: 100%">
										<option></option>
										<option>Open</option>
										<option>Closed</option>
										<option>Not yet due</option>
								</select></td>
							</tr>

							<tr>

								<td><input type="text" value="FollowUp Management Comment "
									style="border: none; width: 100%" /></td>
								<td><input type="text" name="followUpManagementcomment"
									style="border: none; width: 100%" /></td>
							</tr>

							<tr>

								<td><input type="text" value="Revised Implementation Date"
									style="border: none;width: 100%" /></td>
								<td><input type="date" name="revisedImplementationDate" value="dd/mm/yyyy"
									style="border: none; width: 100%" /></td>
							</tr>

							<tr>

								<td><input type="text" value="FU Audit date"
									style="border: none;" /></td>
								<td><input type="date" name="fUAuditDate" value="dd/mm/yyyy"
									style="border: none; width: 100%" /></td>
							</tr>

							

							<tr>

								<td><input type="text" value="Actual Implementation Date"
									style="border: none;" /></td>
								<td><input type="date" name="actualImplementationDate"
									style="border: none; width: 100%" /></td>
							</tr>

							<tr>

								<td><input type="text" value="Root Cause "
									style="border: none;" /></td>
								<td><select name="riskOpini0n"
									style="border: none; width: 100%">
										<option></option>
										<option>Compliance risk</option>
										<option>Operational risk</option>
										<option>Fraud risk</option>
										<option>System risk</option>
										<option>Business risk</option>
										<option>Human Resource risk</option>


								</select></td>
							</tr>

							<tr>

								<td><input type="text" value="Risk Rating "
									style="border: none;" /></td>
								<td><select name="reportByOpinion"
									style="border: none; width: 100%">
										<option></option>
										<option>Critical</option>
										<option>Significant</option>
										<option>Need Improvement</option>
										<option>Housekeeping</option>

								</select></td>
							</tr>


						</tbody>
					</table>

					<div>
						<input class="button" type="submit" value="Submit"></input>
					</div>
				</form>
			</div>

		</div>
	</div>
	<footer>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</footer>
</body>
</html>
