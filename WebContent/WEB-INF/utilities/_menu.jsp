<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>

<link href="css/menu.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<ul class="main-navigation">

		<li><a href="${pageContext.request.contextPath}/Home">Home</a>
			<ul>

				<li><a href="${pageContext.request.contextPath}/VisionPage">
						Vision, Mission And Core Values</a></li>
				<li><a href="${pageContext.request.contextPath}/History">
						History</a></li>
				<li><a href="${pageContext.request.contextPath}/NoticeBoard">
						Notice Board</a></li>
				<li><a href="${pageContext.request.contextPath}/BriefsAndNews">Briefs
						And News</a></li>
				<li><a href="${pageContext.request.contextPath}/NewStaff">Our
						New Staff</a></li>
				<li><a href="${pageContext.request.contextPath}/Bereavement">Bereavement</a></li>
				<li><a href="${pageContext.request.contextPath}/InternalAdvert">Internal
						Vacancies</a></li>
				<li><a
					href="${pageContext.request.contextPath}/IntranetFeedBack">Feedback</a></li>
			</ul></li>

		<li><a href="#">Departments</a>

			<ul>

				<li><a
					href="${pageContext.request.contextPath }/AboutBusinessBanking">Business
						Banking</a></li>
				<!--   -->
				<li><a href="${pageContext.request.contextPath}/AboutMarketing">Marketing</a></li>

			</ul></li>

		<li><a href="#">Staff Services</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/Directory">Staff
						Extension Directory</a></li>
				<li><a
					href="${pageContext.request.contextPath}/SwaziBankProducts">SwaziBank
						Products </a></li>
				<li><a
					href="${pageContext.request.contextPath}/StaffTrainingManuals">Staff
						Training Manuals </a></li>

				<li><a href="">Policies and Procedures</a>
					<ul>
						<!--   -->
						<li>
						<li><a
							href="${pageContext.request.contextPath}/FINANCEPolicies">Finance
								Policies</a></li>
						<li><a href="${pageContext.request.contextPath}/HRPolicies">Human
								Resources Policies</a></li>
						<li><a href="${pageContext.request.contextPath}/ITPolicies">Information
								Technology Policies</a></li>
						<li><a href="${pageContext.request.contextPath}/RiskPolicies">
								Risk and Compliance Policies</a></li>
						<!--  -->
					</ul></li>

				<li><a href="#">SwaziBank Forms</a>
					<ul>
						<!-- 			<li><a href="#">Business Banking Forms</a></li>
						 -->
						<li><a href="${pageContext.request.contextPath}/HRForms">Human Resources Forms</a></li>
						<li><a href="${pageContext.request.contextPath}/ITForms">Information
								Technology Forms</a></li>
						<li><a
							href="${pageContext.request.contextPath}/OperationForms">
								Operations Forms</a></li>
						<li><a href="${pageContext.request.contextPath}/RiskForms">
								Risk and Compliance Forms</a></li>
						<!--<li><a href="#">Coffee Break</a></li> -->
					</ul></li>
			</ul></li>

		<li><a href="#">Working Resources</a>
			<ul>
				<li><a href="#">Credit Tools</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/BadLoans">Bad
								Loans</a></li>
						<li><a href="${pageContext.request.contextPath}/BadLoanNew">Insert
								New Bad Loan</a></li>
					</ul></li>
			</ul></li>

		<li><a href="#">Department Tools</a>
			<ul>
				<li><a href="">Corporate Services Tools</a>
					<ul>
					
						<li><a href="${pageContext.request.contextPath}/ChangeManagement">Change Management Articles</a></li>		
						<li><a href="${pageContext.request.contextPath}/HealthSafetyLogin">Health and Safety</a></li> 
						<li><a href="http://172.16.1.11/myess/Account/Login">My ESS</a></li>
						<li><a href="${pageContext.request.contextPath}/WellnessResources">Wellness Articles</a></li>
						
					</ul></li>
				<li><a href="">Credit Tools</a>
					<ul><li><a
							href="${pageContext.request.contextPath}/HousingLoanArmotization">Housing Loan Amortization</a></li>
							<li><a
							href="http://172.16.1.59:8092/staffLoan/staffLoanStatus">Staff Loans</a></li>
								<li><a
							href="http://live-intranet:8080/EsdbLoanAutomation/BranchLoanTrackingStatus">Branch Personal
								Loans</a></li>
					</ul></li>
				<li><a href="">Finance Tools</a>
					<ul>
						<li><a href="http://www.centralbank.org.sz/">Central Bank
								of Swaziland</a></li>
						<li><a href="http://sbdatawarehse/provisions/">Provisions</a></li>
						<li><a
							href="http://sbdatawarehse/provisions/JBLoader/Finance/">JB
								loader Summary Reports</a></li>
						<li><a href="https://www.mycdas.com/">ITQNET - CDAS</a></li>
					</ul></li>
					<li><a href="">IT Tools</a>
					<ul>

						<li><a href="${pageContext.request.contextPath}/ITDashboards">IT Statistics</a></li>
						<li><a href="http://gieom.swazibank.co.sz">Gieom</a></li>
						
						
					</ul></li>
				<li><a href="">Marketing Tools</a>
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/CallCenterHome">Call
								Center Issue Tracking</a></li>
					</ul></li>


				<li><a href="#"> Risk and Compliance Tools</a>
					<ul>
					
					<li><a href="${pageContext.request.contextPath}/ForexAMLRiskDailyTransactions">AML Forex Daily Transactions</a></li>
						<li><a href="${pageContext.request.contextPath}/AmlTestMain">Anti
								Money Laundering Test 2017</a></li>
						<li><a
							href="${pageContext.request.contextPath}/WhistelBlowingFeedBack">whistle
								Blowing Platform</a></li>
						<li><a
							href="${pageContext.request.contextPath}/RiskAwarenessSurveyHomePage">Risk
								Awareness Survey</a></li>

						<li><a
							href="${pageContext.request.contextPath}/RiskManagementTestHomePage">Risk
								Management Training Test</a></li>


					</ul></li>
					
					<li><a href="#">MD's Office</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/DataCleanUpHome">Data Clean Up</a></li>
						</ul></li>
					
					
				<li><a href="#"> Electronic Banking Tools</a>
					<ul>
						<li><a href="http://172.16.1.41/starrecon/Default.aspx">Automatic Reconciliation</a></li>
						<li><a href="${pageContext.request.contextPath}/CardproductionLogin">Card Production</a></li>
						<li><a href="${pageContext.request.contextPath}/MukuruCustomerOrders">Mukuru Remittences</a></li>
						<li><a href="${pageContext.request.contextPath}/CardproductionLogin">MFS Daily Performance</a></li>
					</ul></li>
			</ul>
		<li><a href="http://172.16.1.63:9191/mfmbs/ib/">Internet Banking</a></li>
		<li><a href="http://helpdesk:8081/helpdesk/WebObjects/Helpdesk.woa">Help Desk</a></li>
		<li><a href="http://172.16.1.59:8095/eswatinibank/homeResources/home" class="btn btn-success">Visit Beta-Version</a></li>
	</ul>

	<!--  
	<li><a href="${pageContext.request.contextPath}/SkillsHome">Skills Audit</a></li>
				<li><a href="#">Operations Tools</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/TT23">TT
								23rd</a></li>
						<li><a href="${pageContext.request.contextPath}/DC23">DC
								23rd</a></li>
						<li><a href="${pageContext.request.contextPath}/FT23">FT
								23rd</a></li>
					</ul></li>
	<li><a href="${pageContext.request.contextPath}/WorkPlaceWellnessSurveyHome">Work place wellness survey</a></li>
	<li><a href="${pageContext.request.contextPath}/RiskTestMain">Risk Management Test 2017</a></li>
	<li><a href="#">Operations Tools</a>
		<ul>
			<li><a href="${pageContext.request.contextPath}/TT23">TT 23rd</a></li>
			<li><a href="${pageContext.request.contextPath}/DC23">DC 23rd</a></li>
			<li><a href="${pageContext.request.contextPath}/FT23">FT 23rd</a></li>
		</ul>
	</li>
	-->
</body>
</html>