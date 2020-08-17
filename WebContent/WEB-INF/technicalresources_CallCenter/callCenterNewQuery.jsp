<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>New Query</title>
<style>
div.scroll {
	position: relative;
	width: 100%;
	height: 500px;
	overflow: scroll;
}
</style>


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
					<li><a class="list-group-item list-group-item-action active"
						href="#">New Query </a></li>
					<li class="nav-item"><a
						class="list-group-item list-group-item-dark"
						href="${pageContext.request.contextPath}/CallCenterHome">Home
					</a></li>
					<li class="nav-item"><a
						class="list-group-item list-group-item-dark"
						href="${pageContext.request.contextPath}/CallCenterUpdateQuery">Update
							Query</a></li>
					<li class="nav-item"><a
						class="list-group-item list-group-item-dark"
						href="${pageContext.request.contextPath}/CallCenterClosed">Closed
							Issues</a></li>


				</ol>

			</div>
			<div class="rightNav">


				<form action="CallCenterNewQuery" method=POST>
					<div class="page-header">
						<h3>New Query</h3>
					</div>

					<div  class="row">

						<div class="col col-md-4">
							<label for="nameOfAgent">Name Of Agent: </label> <select
								class="form-control " name="nameOfAgent">
								<option></option>
								<option>HLELELWE DLAMINI</option>
								<option>MASEKO THANDWA</option>
								<option>MASHABA THANDEKA</option>
								<option>NOKULINDA HLOPHE</option>  
								<option>SIMELANE SAKHILE</option>
								<option>SIVUMELE DLAMINI</option>
								<option>WAY GINA</option>
							</select>
						</div>

						<div class="col col-md-4">
							<label for="nameOfCustomer">Name Of Customer: </label> <input
								type="text" class="form-control " placeholder="Name of Customer"
								name="nameOfCustomer">
						</div>

						<div class="col col-md-4">
							<label>Status:</label> <select name="status"
								class="form-control ">

								<option>In Progress</option>
								<option>Closed</option>

							</select>
						</div>
						
						</div>
							<div  class="row">
						<div class="col col-md-4">
							<label for="departmentRensponsible">Department
								Responsible: </label> <select class="form-control "
								name="departmentRensponsible">
								<option></option>
								<option>Account Management</option>
								<option>Administration</option>
								<option>Agribusiness</option>
								<option>Branch Network</option>
								<option>Business Intelligence</option>
								<option>Call Center</option>
								<option>Collections</option>
								<option>Corporate Business</option>
								<option>Credit</option>
								<option>Digital Banking</option>
								<option>Electronic Banking</option>
								<option>Ezulwini Gables</option>
								<option>Finance</option>
								<option>Housing</option>
								<option>Human Resources</option>
								<option>Infrastructure</option>
								<option>Internal Audit</option>
								<option>Insurance Business</option>
								<option>Legal</option>
								<option>Manzini</option>
								<option>Manzini Cash Centre</option>
								<option>Matata</option>
								<option>Matsapha</option>
								<option>Mbabane</option>
								<option>Motor Vehicle ( Auto-easy)</option>
								<option>Nhlangano</option>
								<option>OPC Manzini</option>
								<option>Operations</option>
								<option>Piggs Peak</option>
								<option>Projects and Governance</option>
								<option>Reviews</option>
								<option>Risk and Compliance</option>
								<option>Sales and Marketing</option>
								<option>Securities</option>
								<option>Siphofaneni</option>
								<option>Simunye</option>
								<option>Siteki</option>
								<option>SMME</option>
								<option>Strategy</option>
								<option>Systems</option>
								<option>Treasury</option>
							</select>
						</div>
						<div class="col col-md-4">
							<label for="emailSentTo">Email Sent to: </label> <select
								class="form-control " name="emailSentTo">
								<option></option>
								<option>callcenter@swazibank.co.sz</option>
								<Option>mzn@swazibank.co.sz</Option>
								<Option>mts@swazibank.co.sz</Option>
								<Option>stk@swazibank.co.sz</Option>
								<Option>ppk@swazibank.co.sz</Option>
								<Option>nhl@swazibank.co.sz</Option>
								<Option>mbc@swazibank.co.sz</Option>
								<Option>mtat@swazibank.co.sz</Option>
								<Option>smy@swazibank.co.sz</Option>
								<Option>mbn@swazibank.co.sz</Option>
								<Option>spfstaff@swazibank.co.sz</Option>
								<Option>gables@swazibank.co.sz</Option>
								<Option>Housing@swazibank.co.sz</Option>
								<Option>autoeasy@swazibank.co.sz</Option>
								<Option>Credit@swazibank.co.sz</Option>
								<Option>CreditOpening@swazibank.co.sz</Option>
								<Option>CreditReviews@swazibank.co.sz</Option>
								<Option>CreditSecurities@swazibank.co.sz</Option>
								<Option>Mzncashcentre@swazibank.co.sz</Option>
								<option>Mbnstaff2@swazibank.co.sz</option>
								<option>ElectronicBanking@swazibank.co.sz</option>
								<option>robertk@swazibank.co.sz</option>
								<option>lindiwes@swazibank.co.sz</option>
								<option>sakhiles@swazibank.co.sz</option>
								<Option>admin@swazibank.co.sz</Option>
								<Option>Administrator@swazibank.co.sz</Option>
								<Option>aanbuvenkkatesh@teminos.com</Option>
								<Option>AndileF@swazibank.co.sz</Option>
								<Option>Andiles@swazibank.co.sz</Option>
								<Option>andrew.young@2cana.co.za</Option>
								<Option>Auditors@swazibank.co.sz</Option>
								<Option>BabhekeD@swazibank.co.sz</Option>
								<Option>BafanaN@swazibank.co.sz</Option>
								<Option>BaneleMa@swazibank.co.sz</Option>
								<Option>bapheleled@swazibank.co.sz</Option>
								<Option>BonakeleD@swazibank.co.sz</Option>
								<Option>BonganiG@swazibank.co.sz</Option>
								<Option>BonganiS@swazibank.co.sz</Option>
								<Option>BonganiZ@swazibank.co.sz</Option>
								<Option>BongekileM@swazibank.co.sz</Option>
								<Option>BonginkosiS@swazibank.co.sz</Option>
								<Option>BonginkosiN@swazibank.co.sz</Option>
								<Option>bonginkosit@swazibank.co.sz</Option>
								<Option>BongiweM@swazibank.co.sz</Option>
								<Option>bongiwen@swazibank.co.sz</Option>
								<Option>BongiweS@swazibank.co.sz</Option>
								<Option>BonisiweF@swazibank.co.sz</Option>
								<Option>BonsileMa@swazibank.co.sz</Option>
								<Option>BonsileN@swazibank.co.sz</Option>
								<Option>BuhlebezweM@swazibank.co.sz</Option>
								<Option>BusiN@swazibank.co.sz</Option>
								<Option>CanaanM@swazibank.co.sz</Option>
								<Option>CebileL@swazibank.co.sz</Option>
								<Option>CebsileK@swazibank.co.sz</Option>
								<Option>CelimphiloB@swazibank.co.sz</Option>
								<Option>CelumusaM@swazibank.co.sz</Option>
								<Option>ChamkileS@swazibank.co.sz</Option>
								<Option>ChristopherN@swazibank.co.sz</Option>
								<Option>ColileN@swazibank.co.sz</Option>
								<Option>ColletM@swazibank.co.sz</Option>
								<Option>CordeliaD@swazibank.co.sz</Option>
								<Option>CynthiaD@swazibank.co.sz</Option>
								<Option>dhilip@cashlinkglobal.com</Option>
								<Option>DorisP@swazibank.co.sz</Option>
								<Option>DuduS@swazibank.co.sz</Option>
								<Option>DumaseN@swazibank.co.sz</Option>
								<Option>DumileM@swazibank.co.sz</Option>
								<Option>ElsieD@swazibank.co.sz</Option>
								<Option>EnockM@swazibank.co.sz</Option>
								<Option>njeru@netguardians.co.ke</Option>
								<Option>EuniceM@swazibank.co.sz</Option>
								<Option>EzraM@swazibank.co.sz</Option>
								<Option>FakaziM@swazibank.co.sz</Option>
								<Option>FikileMa@swazibank.co.sz</Option>
								<Option>FikileMk@swazibank.co.sz</Option>
								<Option>FisiweK@swazibank.co.sz</Option>
								<Option>FAdofo@eftcorp.co.zw</Option>
								<Option>FuthiM@swazibank.co.sz</Option>
								<Option>FuthiN@swazibank.co.sz</Option>
								<Option>GabsileD@swazibank.co.sz</Option>
								<Option>gabsiledl@swazibank.co.sz</Option>
								<Option>GabsileM@swazibank.co.sz</Option>
								<Option>GcebileSi@swazibank.co.sz</Option>
								<Option>gcebiles@swazibank.co.sz</Option>
								<Option>GcinileD@swazibank.co.sz</Option>
								<Option>GillyD@swazibank.co.sz</Option>
								<Option>Ginaw@swazibank.co.sz</Option>
								<Option>GuguD@swazibank.co.sz</Option>
								<Option>HappinessM@swazibank.co.sz</Option>
								<Option>HappyN@swazibank.co.sz</Option>
								<Option>HendrickV@swazibank.co.sz</Option>
								<Option>HlelelweD@swazibank.co.sz</Option>
								<Option>HlengiweMa@swazibank.co.sz</Option>
								<Option>hleziphi@swazibank.co.sz</Option>
								<Option>HlobisileB@swazibank.co.sz</Option>
								<Option>hlomani@swazibank.co.sz</Option>
								<Option>HloniphileM@swazibank.co.sz</Option>
								<Option>HloniphileN@swazibank.co.sz</Option>
								<Option>HloniphileNd@swazibank.co.sz</Option>
								<Option>HloniphileD@swazibank.co.sz</Option>
								<Option>ZinhleM@swazibank.co.sz</Option>
								<Option>JabulaniM@swazibank.co.sz</Option>
								<Option>JabulaniZ@swazibank.co.sz</Option>
								<Option>JabulileD@swazibank.co.sz</Option>
								<Option>JacquelineN@swazibank.co.sz</Option>
								<Option>JansenM@swazibank.co.sz</Option>
								<Option>JeremiahK@swazibank.co.sz</Option>
								<Option>KennethM@swazibank.co.sz</Option>
								<Option>KhanyileN@swazibank.co.sz</Option>
								<Option>khanyisilef@swazibank.co.sz</Option>
								<Option>KhayelihleG@swazibank.co.sz</Option>
								<Option>KhetsiweN@swazibank.co.sz</Option>
								<Option>KhumbuzileM@swazibank.co.sz</Option>
								<Option>khumbuzilen@swazibank.co.sz</Option>
								<Option>KnowledgeM@swazibank.co.sz</Option>
								<Option>kusenid@swazibank.co.sz</Option>
								<Option>Kwanelev@swazibank.co.sz</Option>
								<Option>alakshmi@temenos.com</Option>
								<Option>LeonardD@swazibank.co.sz</Option>
								<Option>LindaM@swazibank.co.sz</Option>
								<Option>LindelwaMa@swazibank.co.sz</Option>
								<Option>LindelwaM@swazibank.co.sz</Option>
								<Option>LindiweS@swazibank.co.sz</Option>
								<Option>LindokuhleGa@swazibank.co.sz</Option>
								<Option>lindokuhleg@swazibank.co.sz</Option>
								<Option>LomalungeloN@swazibank.co.sz</Option>
								<Option>londiwed@swazibank.co.sz</Option>
								<Option>LucasT@swazibank.co.sz</Option>
								<Option>LuckyL@swazibank.co.sz</Option>
								<Option>LuckyM@swazibank.co.sz</Option>
								<Option>luke.deCoes2cana.co.za</Option>
								<Option>LungaN@swazibank.co.sz</Option>
								<Option>LungaD@swazibank.co.sz</Option>
								<Option>LungileMb@swazibank.co.sz</Option>
								<Option>lungilemad@swazibank.co.sz</Option>
								<Option>LungileMag@swazibank.co.sz</Option>
								<Option>LungileMa@swazibank.co.sz</Option>
								<Option>LungileMal@swazibank.co.sz</Option>
								<Option>LungileM@swazibank.co.sz</Option>
								<Option>LungileMd@swazibank.co.sz</Option>
								<Option>LungileS@swazibank.co.sz</Option>
								<Option>LwaziH@swazibank.co.sz</Option>
								<Option>LwaziM@swazibank.co.sz</Option>
								<Option>LwaziMa@swazibank.co.sz</Option>
								<Option>LwaziS@swazibank.co.sz</Option>
								<Option>MachaweM@swazibank.co.sz</Option>
								<Option>maggied@swazibank.co.sz</Option>
								<Option>MahleN@swazibank.co.sz</Option>
								<Option>MakabongweM@swazibank.co.sz</Option>
								<Option>MakhosazanaN@swazibank.co.sz</Option>
								<Option>MakhosazanaMt@swazibank.co.sz</Option>
								<Option>makhosazanadl@swazibank.co.sz</Option>
								<Option>MakhosazanaS@swazibank.co.sz</Option>
								<Option>MakhosazaneM@swazibank.co.sz</Option>
								<Option>MakhosonkeM@swazibank.co.sz</Option>
								<Option>MankuluD@swazibank.co.sz</Option>
								<Option>MantombiM@swazibank.co.sz</Option>
								<Option>MaryZ@swazibank.co.sz</Option>
								<Option>MaswatiD@swazibank.co.sz</Option>
								<Option>MatsafeniD@swazibank.co.sz</Option>
								<Option>MazalinaR@swazibank.co.sz</Option>
								<Option>MazibuseK@swazibank.co.sz</Option>
								<Option>MbaliK@swazibank.co.sz</Option>
								<Option>MbongeniB@swazibank.co.sz</Option>
								<Option>MbongiseniM@swazibank.co.sz</Option>
								<Option>MbusoF@swazibank.co.sz</Option>
								<Option>MbusoM@swazibank.co.sz</Option>
								<Option>MduduziH@swazibank.co.sz</Option>
								<Option>mduduzim@swazibank.co.sz</Option>
								<Option>MelissaA@swazibank.co.sz</Option>
								<Option>MelodyM@swazibank.co.sz</Option>
								<Option>MelusiM@swazibank.co.sz</Option>
								<Option>MfundoD@swazibank.co.sz</Option>
								<Option>MfundoN@swazibank.co.sz</Option>
								<Option>MichaelK@swazibank.co.sz</Option>
								<Option>MirrietM@swazibank.co.sz</Option>
								<Option>mkhululim@swazibank.co.sz</Option>
								<Option>MlungisiD@swazibank.co.sz</Option>
								<Option>MlungisiM@swazibank.co.sz</Option>
								<Option>mollyf@swazibank.co.sz</Option>
								<Option>MongiK@swazibank.co.sz</Option>
								<Option>MpenduloN@swazibank.co.sz</Option>
								<Option>MphikeleliD@swazibank.co.sz</Option>
								<Option>MphoK@swazibank.co.sz</Option>
								<Option>MpumeleloM@swazibank.co.sz</Option>
								<Option>MqambiN@swazibank.co.sz</Option>
								<Option>MurmlyS@swazibank.co.sz</Option>
								<Option>MusaWD@swazibank.co.sz</Option>
								<Option>musan@swazibank.co.sz</Option>
								<Option>Mxolisis@swazibank.co.sz</Option>
								<Option>MyrahV@swazibank.co.sz</Option>
								<Option>NatalieG@swazibank.co.sz</Option>
								<Option>naveenkumar@temenos.com</Option>
								<Option>NcamileM@swazibank.co.sz</Option>
								<Option>NcamsileM@swazibank.co.sz</Option>
								<Option>NelisiweMts@swazibank.co.sz</Option>
								<Option>NeliswaM@swazibank.co.sz</Option>
								<Option>NelsileG@swazibank.co.sz</Option>
								<Option>ngscreener@swazibank.co.sz</Option>
								<Option>nhlanhlama@swazibank.co.sz</Option>
								<Option>NhlanhlaM@swazibank.co.sz</Option>
								<Option>NhlanhlakwabanayoM@swazibank.co.sz</Option>
								<Option>njabulod@swazibank.co.sz</Option>
								<Option>njabulos@swazibank.co.sz</Option>
								<Option>njabulom@swazibank.co.sz</Option>
								<Option>NkosinathiM@swazibank.co.sz</Option>
								<Option>NkosinathiS@swazibank.co.sz</Option>
								<Option>NkosingivileM@swazibank.co.sz</Option>
								<Option>NkululekoDl@swazibank.co.sz</Option>
								<Option>NkululekoT@swazibank.co.sz</Option>
								<Option>NobesuthuS@swazibank.co.sz</Option>
								<Option>NokulindaH@swazibank.co.sz</Option>
							
								<Option>NokulungaD@swazibank.co.sz</Option>
								<Option>NokuphilaD@swazibank.co.sz</Option>
								<Option>NokwandaV@swazibank.co.sz</Option>
								<Option>NomathembaD@swazibank.co.sz</Option>
								<Option>NomathembaMg@swazibank.co.sz</Option>
								<Option>NomathembaMa@swazibank.co.sz</Option>
								<Option>NomathembaM@swazibank.co.sz</Option>
								<Option>NombuleloL@swazibank.co.sz</Option>
								<Option>Nombusot@swazibank.co.sz</Option>
								<Option>NomceboB@swazibank.co.sz</Option>
								<Option>NomceboM@swazibank.co.sz</Option>
								<Option>NomceboN@swazibank.co.sz</Option>
								<Option>NomphiloN@swazibank.co.sz</Option>
								<Option>Nomvuselelod@swazibank.co.sz</Option>
								<Option>NomzamoMa@swazibank.co.sz</Option>
								<Option>NomzamoM@swazibank.co.sz</Option>
								<Option>NonhlanhlaM@swazibank.co.sz</Option>
								<Option>NonhlanhlaN@swazibank.co.sz</Option>
								<Option>NonhlanhlaNx@swazibank.co.sz</Option>
								<Option>NosimiloD@swazibank.co.sz</Option>
								<Option>NosimiloH@swazibank.co.sz</Option>
								<Option>NosiphoN@swazibank.co.sz</Option>
								<Option>NosisaS@swazibank.co.sz</Option>
								<Option>nothandoma@swazibank.co.sz</Option>
								<Option>NozizweM@swazibank.co.sz</Option>
								<Option>NqobileM@swazibank.co.sz</Option>
								<Option>NqobileS@swazibank.co.sz</Option>
								<Option>nqobilent@swazibank.co.sz</Option>
								<Option>NqobileN@swazibank.co.sz</Option>
								<Option>NsimbiS@swazibank.co.sz</Option>
								<Option>NtandoyenkhosiT@swazibank.co.sz</Option>
								<Option>NtokozoD@swazibank.co.sz</Option>
								<Option>NtombiM@swazibank.co.sz</Option>
								<Option>NtombikayiseD@swazibank.co.sz</Option>
								<Option>NtombikayiseS@swazibank.co.sz</Option>
								<Option>PaballoM@swazibank.co.sz</Option>
								<Option>pascalm@swazibank.co.sz</Option>
								<Option>ThuliM@swazibank.co.sz</Option>
								<Option>PaulW@swazibank.co.sz</Option>
								<Option>PeterV@swazibank.co.sz</Option>
								<Option>PhesheyaV@swazibank.co.sz</Option>
								<Option>PhetsileD@swazibank.co.sz</Option>
								<Option>PhindileM@swazibank.co.sz</Option>
								<Option>PholileM@swazibank.co.sz</Option>
								<Option>PhumlaniM@swazibank.co.sz</Option>
								<Option>phumliled@swazibank.co.sz</Option>
								<Option>PhumlileN@swazibank.co.sz</Option>
								<Option>phumziled@swazibank.co.sz</Option>
								<Option>PortiaM@swazibank.co.sz</Option>
								<Option>PreciousH@swazibank.co.sz</Option>
								<Option>PrincessV@swazibank.co.sz</Option>
								<Option>PriscillaD@swazibank.co.sz</Option>
								<Option>ProfessorN@swazibank.co.sz</Option>
								<Option>NomceboD@swazibank.co.sz</Option>
								<Option>RobertK@swazibank.co.sz</Option>
								<Option>RobinsonH@swazibank.co.sz</Option>
								<Option>RomanD@swazibank.co.sz</Option>
								<Option>SabeloK@swazibank.co.sz</Option>
								<Option>sabelod@swazibank.co.sz</Option>
								<Option>SabeloT@swazibank.co.sz</Option>
								<Option>SakhileS@swazibank.co.sz</Option>
								<Option>SambuloM@swazibank.co.sz</Option>
								<Option>SamkelisiweM@swazibank.co.sz</Option>
								<Option>SandileMa@swazibank.co.sz</Option>
								<Option>SaneleM@swazibank.co.sz</Option>
								<Option>SaneleD@swazibank.co.sz</Option>
								<Option>SaneleN@swazibank.co.sz</Option>
								<Option>SarahM@swazibank.co.sz</Option>
								<Option>SebendzileM@swazibank.co.sz</Option>
								<Option>SethM@swazibank.co.sz</Option>
								<Option>sharmie@temenos.com</Option>
								<Option>shruthi.j@modefineserve.com</Option>
								<Option>SibongileM@swazibank.co.sz</Option>
								<Option>sibongiled@swazibank.co.sz</Option>
								<Option>sibonisilek@swazibank.co.sz</Option>
								<Option>sibonisilem@swazibank.co.sz</Option>
								<Option>SiceloG@swazibank.co.sz</Option>
								<Option>SiceloN@swazibank.co.sz</Option>
								<Option>SifisoMD@swazibank.co.sz</Option>
								<Option>SifisoD@swazibank.co.sz</Option>
								<Option>SifisoM@swazibank.co.sz</Option>
								<Option>SimangeleMa@swazibank.co.sz</Option>
								<Option>SimangeleM@swazibank.co.sz</Option>
								<Option>SimonKh@swazibank.co.sz</Option>
								<Option>SimphiweM@swazibank.co.sz</Option>
								<Option>SindiS@swazibank.co.sz</Option>
								<Option>SindisiweD@swazibank.co.sz</Option>
								<Option>SiphindileD@swazibank.co.sz</Option>
								<Option>siphiwe.memela@2cana.co.za</Option>
								<Option>SithembileM@swazibank.co.sz</Option>
								<Option>SivumeleD@swazibank.co.sz</Option>
								<Option>SiyabongaS@swazibank.co.sz</Option>
								<Option>SkhumbuzoD@swazibank.co.sz</Option>
								<Option>SkhumbuzoN@swazibank.co.sz</Option>
								<Option>SobalaD@swazibank.co.sz</Option>
								<Option>SoneniL@swazibank.co.sz</Option>
								<Option>SonkheG@swazibank.co.sz</Option>
								<Option>SotjaM@swazibank.co.sz</Option>
								<Option>StalinT@swazibank.co.sz</Option>
								<Option>Sthembiles@swazibank.co.sz</Option>
								<Option>sukoluhle@swazibank.co.sz</Option>
								<Option>Surendarb@teminos.com</Option>
								<Option>aves@swazibank.co.sz</Option>
								<Option>takhonam@swazibank.co.sz</Option>
								<Option>TawongaS@swazibank.co.sz</Option>
								<Option>TemalangeniD@swazibank.co.sz</Option>
								<Option>TemantungwaK@swazibank.co.sz</Option>
								<Option>TenanileD@swazibank.co.sz</Option>
								<Option>TenanileG@swazibank.co.sz</Option>
								<Option>TeneleDl@swazibank.co.sz</Option>
								<Option>TeneleD@swazibank.co.sz</Option>
								<Option>ThabisileD@swazibank.co.sz</Option>
								<Option>ThaboN@swazibank.co.sz</Option>
								<Option>ThabsileH@swazibank.co.sz</Option>
								<Option>ThabsileM@swazibank.co.sz</Option>
								<Option>Thabanen@swazibank.co.sz</Option>
								<Option>ThandazileN@swazibank.co.sz</Option>
								<Option>thandekam@swazibank.co.sz</Option>
								<Option>ThandoH@swazibank.co.sz</Option>
								<Option>Thandwam@swazibank.co.sz</Option>
								<Option>ThembaD@swazibank.co.sz</Option>
								<Option>ThembekileM@swazibank.co.sz</Option>
								<Option>ThembeniN@swazibank.co.sz</Option>
								<Option>ThembiAD@swazibank.co.sz</Option>
								<Option>ThembiM@swazibank.co.sz</Option>
								<Option>ThembinkosiM@swazibank.co.sz</Option>
								<Option>Thembumenzik@swazibank.co.sz</Option>
								<Option>ThembumenziM@swazibank.co.sz</Option>
								<Option>ThobaM@swazibank.co.sz</Option>
								<Option>ThokoN@swazibank.co.sz</Option>
								<Option>tholakelem@swazibank.co.sz</Option>
								<Option>ThomasN@swazibank.co.sz</Option>
								<Option>ThulieD@swazibank.co.sz</Option>
								<Option>ThulisileM@swazibank.co.sz</Option>
								<Option>tintfombis@swazibank.co.sz</Option>
								<Option>TracyM@swazibank.co.sz</Option>
								<Option>VakeleD@swazibank.co.sz</Option>
								<Option>MenziN@swazibank.co.sz</Option>
								<Option>TjengisileD@swazibank.co.sz</Option>
								<Option>MoffatM@swazibank.co.sz</Option>
								<Option>VusiG@swazibank.co.sz</Option>
								<Option>VusikhayaD@swazibank.co.sz</Option>
								<Option>wandilen@swazibank.co.sz</Option>
								<Option>WelileD@swazibank.co.sz</Option>
								<Option>wendyd@swazibank.co.sz</Option>
								<Option>Winilem@swazibank.co.sz</Option>
								<Option>winiletm@swazibank.co.sz</Option>
								<Option>xolanim@swazibank.co.sz</Option>
								<Option>XolaniS@swazibank.co.sz</Option>
								<Option>XolisileC@swazibank.co.sz</Option>
								<Option>ZakheleL@swazibank.co.sz</Option>
								<Option>ZakheleM@swazibank.co.sz</Option>
								<Option>ZamahlubiM@swazibank.co.sz</Option>
								<Option>zandiledl@swazibank.co.sz</Option>
								<Option>ZandileM@swazibank.co.sz</Option>
								<Option>ZaneleD@swazibank.co.sz</Option>
								<Option>ZaneleDl@swazibank.co.sz</Option>
								<Option>ZaneleTD@swazibank.co.sz</Option>
								<Option>zinem@swazibank.co.sz</Option>
								<Option>ZodwaM@swazibank.co.sz</Option>
								<Option>zodwan@swazibank.co.sz</Option>
								


							</select>

						</div>

						<div class="col col-md-4">
							<label for="emailCopyTo">Email Copy to: </label> <select
								class="form-control " name="emailCopyTo">
								<option></option>
								<option>callcenter@swazibank.co.sz</option>
								<Option>mzn@swazibank.co.sz</Option>
								<Option>mts@swazibank.co.sz</Option>
								<Option>stk@swazibank.co.sz</Option>
								<Option>ppk@swazibank.co.sz</Option>
								<Option>nhl@swazibank.co.sz</Option>
								<Option>mbc@swazibank.co.sz</Option>
								<Option>mtat@swazibank.co.sz</Option>
								<Option>smy@swazibank.co.sz</Option>
								<Option>mbn@swazibank.co.sz</Option>
								<Option>spfstaff@swazibank.co.sz</Option>
								<Option>gables@swazibank.co.sz</Option>
								<Option>Housing@swazibank.co.sz</Option>
								<Option>autoeasy@swazibank.co.sz</Option>
								<Option>Credit@swazibank.co.sz</Option>
								<Option>CreditOpening@swazibank.co.sz</Option>
								<Option>CreditReviews@swazibank.co.sz</Option>
								<Option>CreditSecurities@swazibank.co.sz</Option>
								<Option>Mzncashcentre@swazibank.co.sz</Option>
								<option>Mbnstaff2@swazibank.co.sz</option>
								<option>ElectronicBanking@swazibank.co.sz</option>
								<option>robertk@swazibank.co.sz</option>
								<option>lindiwes@swazibank.co.sz</option>
								<option>sakhiles@swazibank.co.sz</option>
								<Option>admin@swazibank.co.sz</Option>
								<Option>Administrator@swazibank.co.sz</Option>
								<Option>aanbuvenkkatesh@teminos.com</Option>
								<Option>AndileF@swazibank.co.sz</Option>
								<Option>Andiles@swazibank.co.sz</Option>
								<Option>andrew.young@2cana.co.za</Option>
								<Option>Auditors@swazibank.co.sz</Option>
								<Option>BabhekeD@swazibank.co.sz</Option>
								<Option>BafanaN@swazibank.co.sz</Option>
								<Option>BaneleMa@swazibank.co.sz</Option>
								<Option>bapheleled@swazibank.co.sz</Option>
								<Option>BonakeleD@swazibank.co.sz</Option>
								<Option>BonganiG@swazibank.co.sz</Option>
								<Option>BonganiS@swazibank.co.sz</Option>
								<Option>BonganiZ@swazibank.co.sz</Option>
								<Option>BongekileM@swazibank.co.sz</Option>
								<Option>BonginkosiS@swazibank.co.sz</Option>
								<Option>BonginkosiN@swazibank.co.sz</Option>
								<Option>bonginkosit@swazibank.co.sz</Option>
								<Option>BongiweM@swazibank.co.sz</Option>
								<Option>bongiwen@swazibank.co.sz</Option>
								<Option>BongiweS@swazibank.co.sz</Option>
								<Option>BonisiweF@swazibank.co.sz</Option>
								<Option>BonsileMa@swazibank.co.sz</Option>
								<Option>BonsileN@swazibank.co.sz</Option>
								<Option>BuhlebezweM@swazibank.co.sz</Option>
								<Option>BusiN@swazibank.co.sz</Option>
								<Option>CanaanM@swazibank.co.sz</Option>
								<Option>CebileL@swazibank.co.sz</Option>
								<Option>CebsileK@swazibank.co.sz</Option>
								<Option>CelimphiloB@swazibank.co.sz</Option>
								<Option>CelumusaM@swazibank.co.sz</Option>
								<Option>ChamkileS@swazibank.co.sz</Option>
								<Option>ChristopherN@swazibank.co.sz</Option>
								<Option>ColileN@swazibank.co.sz</Option>
								<Option>ColletM@swazibank.co.sz</Option>
								<Option>CordeliaD@swazibank.co.sz</Option>
								<Option>CynthiaD@swazibank.co.sz</Option>
								<Option>dhilip@cashlinkglobal.com</Option>
								<Option>DorisP@swazibank.co.sz</Option>
								<Option>DuduS@swazibank.co.sz</Option>
								<Option>DumaseN@swazibank.co.sz</Option>
								<Option>DumileM@swazibank.co.sz</Option>
								<Option>ElsieD@swazibank.co.sz</Option>
								<Option>EnockM@swazibank.co.sz</Option>
								<Option>njeru@netguardians.co.ke</Option>
								<Option>EuniceM@swazibank.co.sz</Option>
								<Option>EzraM@swazibank.co.sz</Option>
								<Option>FakaziM@swazibank.co.sz</Option>
								<Option>FikileMa@swazibank.co.sz</Option>
								<Option>FikileMk@swazibank.co.sz</Option>
								<Option>FisiweK@swazibank.co.sz</Option>
								<Option>FAdofo@eftcorp.co.zw</Option>
								<Option>FuthiM@swazibank.co.sz</Option>
								<Option>FuthiN@swazibank.co.sz</Option>
								<Option>GabsileD@swazibank.co.sz</Option>
								<Option>gabsiledl@swazibank.co.sz</Option>
								<Option>GabsileM@swazibank.co.sz</Option>
								<Option>GcebileSi@swazibank.co.sz</Option>
								<Option>gcebiles@swazibank.co.sz</Option>
								<Option>GcinileD@swazibank.co.sz</Option>
								<Option>GillyD@swazibank.co.sz</Option>
								<Option>Ginaw@swazibank.co.sz</Option>
								<Option>GuguD@swazibank.co.sz</Option>
								<Option>HappinessM@swazibank.co.sz</Option>
								<Option>HappyN@swazibank.co.sz</Option>
								<Option>HendrickV@swazibank.co.sz</Option>
								<Option>HlelelweD@swazibank.co.sz</Option>
								<Option>HlengiweMa@swazibank.co.sz</Option>
								<Option>hleziphi@swazibank.co.sz</Option>
								<Option>HlobisileB@swazibank.co.sz</Option>
								<Option>hlomani@swazibank.co.sz</Option>
								<Option>HloniphileM@swazibank.co.sz</Option>
								<Option>HloniphileN@swazibank.co.sz</Option>
								<Option>HloniphileNd@swazibank.co.sz</Option>
								<Option>HloniphileD@swazibank.co.sz</Option>
								<Option>ZinhleM@swazibank.co.sz</Option>
								<Option>JabulaniM@swazibank.co.sz</Option>
								<Option>JabulaniZ@swazibank.co.sz</Option>
								<Option>JabulileD@swazibank.co.sz</Option>
								<Option>JacquelineN@swazibank.co.sz</Option>
								<Option>JansenM@swazibank.co.sz</Option>
								<Option>JeremiahK@swazibank.co.sz</Option>
								<Option>KennethM@swazibank.co.sz</Option>
								<Option>KhanyileN@swazibank.co.sz</Option>
								<Option>khanyisilef@swazibank.co.sz</Option>
								<Option>KhayelihleG@swazibank.co.sz</Option>
								<Option>KhetsiweN@swazibank.co.sz</Option>
								<Option>KhumbuzileM@swazibank.co.sz</Option>
								<Option>khumbuzilen@swazibank.co.sz</Option>
								<Option>KnowledgeM@swazibank.co.sz</Option>
								<Option>kusenid@swazibank.co.sz</Option>
								<Option>Kwanelev@swazibank.co.sz</Option>
								<Option>alakshmi@temenos.com</Option>
								<Option>LeonardD@swazibank.co.sz</Option>
								<Option>LindaM@swazibank.co.sz</Option>
								<Option>LindelwaMa@swazibank.co.sz</Option>
								<Option>LindelwaM@swazibank.co.sz</Option>
								<Option>LindiweS@swazibank.co.sz</Option>
								<Option>LindokuhleGa@swazibank.co.sz</Option>
								<Option>lindokuhleg@swazibank.co.sz</Option>
								<Option>LomalungeloN@swazibank.co.sz</Option>
								<Option>londiwed@swazibank.co.sz</Option>
								<Option>LucasT@swazibank.co.sz</Option>
								<Option>LuckyL@swazibank.co.sz</Option>
								<Option>LuckyM@swazibank.co.sz</Option>
								<Option>luke.deCoes2cana.co.za</Option>
								<Option>LungaN@swazibank.co.sz</Option>
								<Option>LungaD@swazibank.co.sz</Option>
								<Option>LungileMb@swazibank.co.sz</Option>
								<Option>lungilemad@swazibank.co.sz</Option>
								<Option>LungileMag@swazibank.co.sz</Option>
								<Option>LungileMa@swazibank.co.sz</Option>
								<Option>LungileMal@swazibank.co.sz</Option>
								<Option>LungileM@swazibank.co.sz</Option>
								<Option>LungileMd@swazibank.co.sz</Option>
								<Option>LungileS@swazibank.co.sz</Option>
								<Option>LwaziH@swazibank.co.sz</Option>
								<Option>LwaziM@swazibank.co.sz</Option>
								<Option>LwaziMa@swazibank.co.sz</Option>
								<Option>LwaziS@swazibank.co.sz</Option>
								<Option>MachaweM@swazibank.co.sz</Option>
								<Option>maggied@swazibank.co.sz</Option>
								<Option>MahleN@swazibank.co.sz</Option>
								<Option>MakabongweM@swazibank.co.sz</Option>
								<Option>MakhosazanaN@swazibank.co.sz</Option>
								<Option>MakhosazanaMt@swazibank.co.sz</Option>
								<Option>makhosazanadl@swazibank.co.sz</Option>
								<Option>MakhosazanaS@swazibank.co.sz</Option>
								<Option>MakhosazaneM@swazibank.co.sz</Option>
								<Option>MakhosonkeM@swazibank.co.sz</Option>
								<Option>MankuluD@swazibank.co.sz</Option>
								<Option>MantombiM@swazibank.co.sz</Option>
								<Option>MaryZ@swazibank.co.sz</Option>
								<Option>MaswatiD@swazibank.co.sz</Option>
								<Option>MatsafeniD@swazibank.co.sz</Option>
								<Option>MazalinaR@swazibank.co.sz</Option>
								<Option>MazibuseK@swazibank.co.sz</Option>
								<Option>MbaliK@swazibank.co.sz</Option>
								<Option>MbongeniB@swazibank.co.sz</Option>
								<Option>MbongiseniM@swazibank.co.sz</Option>
								<Option>MbusoF@swazibank.co.sz</Option>
								<Option>MbusoM@swazibank.co.sz</Option>
								<Option>MduduziH@swazibank.co.sz</Option>
								<Option>mduduzim@swazibank.co.sz</Option>
								<Option>MelissaA@swazibank.co.sz</Option>
								<Option>MelodyM@swazibank.co.sz</Option>
								<Option>MelusiM@swazibank.co.sz</Option>
								<Option>MfundoD@swazibank.co.sz</Option>
								<Option>MfundoN@swazibank.co.sz</Option>
								<Option>MichaelK@swazibank.co.sz</Option>
								<Option>MirrietM@swazibank.co.sz</Option>
								<Option>mkhululim@swazibank.co.sz</Option>
								<Option>MlungisiD@swazibank.co.sz</Option>
								<Option>MlungisiM@swazibank.co.sz</Option>
								<Option>mollyf@swazibank.co.sz</Option>
								<Option>MongiK@swazibank.co.sz</Option>
								<Option>MpenduloN@swazibank.co.sz</Option>
								<Option>MphikeleliD@swazibank.co.sz</Option>
								<Option>MphoK@swazibank.co.sz</Option>
								<Option>MpumeleloM@swazibank.co.sz</Option>
								<Option>MqambiN@swazibank.co.sz</Option>
								<Option>MurmlyS@swazibank.co.sz</Option>
								<Option>MusaWD@swazibank.co.sz</Option>
								<Option>musan@swazibank.co.sz</Option>
								<Option>Mxolisis@swazibank.co.sz</Option>
								<Option>MyrahV@swazibank.co.sz</Option>
								<Option>NatalieG@swazibank.co.sz</Option>
								<Option>naveenkumar@temenos.com</Option>
								<Option>NcamileM@swazibank.co.sz</Option>
								<Option>NcamsileM@swazibank.co.sz</Option>
								<Option>NelisiweMts@swazibank.co.sz</Option>
								<Option>NeliswaM@swazibank.co.sz</Option>
								<Option>NelsileG@swazibank.co.sz</Option>
								<Option>ngscreener@swazibank.co.sz</Option>
								<Option>nhlanhlama@swazibank.co.sz</Option>
								<Option>NhlanhlaM@swazibank.co.sz</Option>
								<Option>NhlanhlakwabanayoM@swazibank.co.sz</Option>
								<Option>njabulod@swazibank.co.sz</Option>
								<Option>njabulos@swazibank.co.sz</Option>
								<Option>njabulom@swazibank.co.sz</Option>
								<Option>NkosinathiM@swazibank.co.sz</Option>
								<Option>NkosinathiS@swazibank.co.sz</Option>
								<Option>NkosingivileM@swazibank.co.sz</Option>
								<Option>NkululekoDl@swazibank.co.sz</Option>
								<Option>NkululekoT@swazibank.co.sz</Option>
								<Option>NobesuthuS@swazibank.co.sz</Option>
								<Option>NokulindaH@swazibank.co.sz</Option>
								<Option>NokulungaD@swazibank.co.sz</Option>
								<Option>NokuphilaD@swazibank.co.sz</Option>
								<Option>NokwandaV@swazibank.co.sz</Option>
								<Option>NomathembaD@swazibank.co.sz</Option>
								<Option>NomathembaMg@swazibank.co.sz</Option>
								<Option>NomathembaMa@swazibank.co.sz</Option>
								<Option>NomathembaM@swazibank.co.sz</Option>
								<Option>NombuleloL@swazibank.co.sz</Option>
								<Option>Nombusot@swazibank.co.sz</Option>
								<Option>NomceboB@swazibank.co.sz</Option>
								<Option>NomceboM@swazibank.co.sz</Option>
								<Option>NomceboN@swazibank.co.sz</Option>
								<Option>NomphiloN@swazibank.co.sz</Option>
								<Option>Nomvuselelod@swazibank.co.sz</Option>
								<Option>NomzamoMa@swazibank.co.sz</Option>
								<Option>NomzamoM@swazibank.co.sz</Option>
								<Option>NonhlanhlaM@swazibank.co.sz</Option>
								<Option>NonhlanhlaN@swazibank.co.sz</Option>
								<Option>NonhlanhlaNx@swazibank.co.sz</Option>
								<Option>NosimiloD@swazibank.co.sz</Option>
								<Option>NosimiloH@swazibank.co.sz</Option>
								<Option>NosiphoN@swazibank.co.sz</Option>
								<Option>NosisaS@swazibank.co.sz</Option>
								<Option>nothandoma@swazibank.co.sz</Option>
								<Option>NozizweM@swazibank.co.sz</Option>
								<Option>NqobileM@swazibank.co.sz</Option>
								<Option>NqobileS@swazibank.co.sz</Option>
								<Option>nqobilent@swazibank.co.sz</Option>
								<Option>NqobileN@swazibank.co.sz</Option>
								<Option>NsimbiS@swazibank.co.sz</Option>
								<Option>NtandoyenkhosiT@swazibank.co.sz</Option>
								<Option>NtokozoD@swazibank.co.sz</Option>
								<Option>NtombiM@swazibank.co.sz</Option>
								<Option>NtombikayiseD@swazibank.co.sz</Option>
								<Option>NtombikayiseS@swazibank.co.sz</Option>
								<Option>PaballoM@swazibank.co.sz</Option>
								<Option>pascalm@swazibank.co.sz</Option>
								<Option>ThuliM@swazibank.co.sz</Option>
								<Option>PaulW@swazibank.co.sz</Option>
								<Option>PeterV@swazibank.co.sz</Option>
								<Option>PhesheyaV@swazibank.co.sz</Option>
								<Option>PhetsileD@swazibank.co.sz</Option>
								<Option>PhindileM@swazibank.co.sz</Option>
								<Option>PholileM@swazibank.co.sz</Option>
								<Option>PhumlaniM@swazibank.co.sz</Option>
								<Option>phumliled@swazibank.co.sz</Option>
								<Option>PhumlileN@swazibank.co.sz</Option>
								<Option>phumziled@swazibank.co.sz</Option>
								<Option>PortiaM@swazibank.co.sz</Option>
								<Option>PreciousH@swazibank.co.sz</Option>
								<Option>PrincessV@swazibank.co.sz</Option>
								<Option>PriscillaD@swazibank.co.sz</Option>
								<Option>ProfessorN@swazibank.co.sz</Option>
								<Option>NomceboD@swazibank.co.sz</Option>
								<Option>RobertK@swazibank.co.sz</Option>
								<Option>RobinsonH@swazibank.co.sz</Option>
								<Option>RomanD@swazibank.co.sz</Option>
								<Option>SabeloK@swazibank.co.sz</Option>
								<Option>sabelod@swazibank.co.sz</Option>
								<Option>SabeloT@swazibank.co.sz</Option>
								<Option>SakhileS@swazibank.co.sz</Option>
								<Option>SambuloM@swazibank.co.sz</Option>
								<Option>SamkelisiweM@swazibank.co.sz</Option>
								<Option>SandileMa@swazibank.co.sz</Option>
								<Option>SaneleM@swazibank.co.sz</Option>
								<Option>SaneleD@swazibank.co.sz</Option>
								<Option>SaneleN@swazibank.co.sz</Option>
								<Option>SarahM@swazibank.co.sz</Option>
								<Option>SebendzileM@swazibank.co.sz</Option>
								<Option>SethM@swazibank.co.sz</Option>
								<Option>sharmie@temenos.com</Option>
								<Option>shruthi.j@modefineserve.com</Option>
								<Option>SibongileM@swazibank.co.sz</Option>
								<Option>sibongiled@swazibank.co.sz</Option>
								<Option>sibonisilek@swazibank.co.sz</Option>
								<Option>sibonisilem@swazibank.co.sz</Option>
								<Option>SiceloG@swazibank.co.sz</Option>
								<Option>SiceloN@swazibank.co.sz</Option>
								<Option>SifisoMD@swazibank.co.sz</Option>
								<Option>SifisoD@swazibank.co.sz</Option>
								<Option>SifisoM@swazibank.co.sz</Option>
								<Option>SimangeleMa@swazibank.co.sz</Option>
								<Option>SimangeleM@swazibank.co.sz</Option>
								<Option>SimonKh@swazibank.co.sz</Option>
								<Option>SimphiweM@swazibank.co.sz</Option>
								<Option>SindiS@swazibank.co.sz</Option>
								<Option>SindisiweD@swazibank.co.sz</Option>
								<Option>SiphindileD@swazibank.co.sz</Option>
								<Option>siphiwe.memela@2cana.co.za</Option>
								<Option>SithembileM@swazibank.co.sz</Option>
								<Option>SivumeleD@swazibank.co.sz</Option>
								<Option>SiyabongaS@swazibank.co.sz</Option>
								<Option>SkhumbuzoD@swazibank.co.sz</Option>
								<Option>SkhumbuzoN@swazibank.co.sz</Option>
								<Option>SobalaD@swazibank.co.sz</Option>
								<Option>SoneniL@swazibank.co.sz</Option>
								<Option>SonkheG@swazibank.co.sz</Option>
								<Option>SotjaM@swazibank.co.sz</Option>
								<Option>StalinT@swazibank.co.sz</Option>
								<Option>Sthembiles@swazibank.co.sz</Option>
								<Option>sukoluhle@swazibank.co.sz</Option>
								<Option>Surendarb@teminos.com</Option>
								<Option>aves@swazibank.co.sz</Option>
								<Option>takhonam@swazibank.co.sz</Option>
								<Option>TawongaS@swazibank.co.sz</Option>
								<Option>TemalangeniD@swazibank.co.sz</Option>
								<Option>TemantungwaK@swazibank.co.sz</Option>
								<Option>TenanileD@swazibank.co.sz</Option>
								<Option>TenanileG@swazibank.co.sz</Option>
								<Option>TeneleDl@swazibank.co.sz</Option>
								<Option>TeneleD@swazibank.co.sz</Option>
								<Option>ThabisileD@swazibank.co.sz</Option>
								<Option>ThaboN@swazibank.co.sz</Option>
								<Option>ThabsileH@swazibank.co.sz</Option>
								<Option>ThabsileM@swazibank.co.sz</Option>
								<Option>Thabanen@swazibank.co.sz</Option>
								<Option>ThandazileN@swazibank.co.sz</Option>
								<Option>thandekam@swazibank.co.sz</Option>
								<Option>ThandoH@swazibank.co.sz</Option>
								<Option>Thandwam@swazibank.co.sz</Option>
								<Option>ThembaD@swazibank.co.sz</Option>
								<Option>ThembekileM@swazibank.co.sz</Option>
								<Option>ThembeniN@swazibank.co.sz</Option>
								<Option>ThembiAD@swazibank.co.sz</Option>
								<Option>ThembiM@swazibank.co.sz</Option>
								<Option>ThembinkosiM@swazibank.co.sz</Option>
								<Option>Thembumenzik@swazibank.co.sz</Option>
								<Option>ThembumenziM@swazibank.co.sz</Option>
								<Option>ThobaM@swazibank.co.sz</Option>
								<Option>ThokoN@swazibank.co.sz</Option>
								<Option>tholakelem@swazibank.co.sz</Option>
								<Option>ThomasN@swazibank.co.sz</Option>
								<Option>ThulieD@swazibank.co.sz</Option>
								<Option>ThulisileM@swazibank.co.sz</Option>
								<Option>tintfombis@swazibank.co.sz</Option>
								<Option>TracyM@swazibank.co.sz</Option>
								<Option>VakeleD@swazibank.co.sz</Option>
								<Option>MenziN@swazibank.co.sz</Option>
								<Option>TjengisileD@swazibank.co.sz</Option>
								<Option>MoffatM@swazibank.co.sz</Option>
								<Option>VusiG@swazibank.co.sz</Option>
								<Option>VusikhayaD@swazibank.co.sz</Option>
								<Option>wandilen@swazibank.co.sz</Option>
								<Option>WelileD@swazibank.co.sz</Option>
								<Option>wendyd@swazibank.co.sz</Option>
								<Option>Winilem@swazibank.co.sz</Option>
								<Option>winiletm@swazibank.co.sz</Option>
								<Option>xolanim@swazibank.co.sz</Option>
								<Option>XolaniS@swazibank.co.sz</Option>
								<Option>XolisileC@swazibank.co.sz</Option>
								<Option>ZakheleL@swazibank.co.sz</Option>
								<Option>ZakheleM@swazibank.co.sz</Option>
								<Option>ZamahlubiM@swazibank.co.sz</Option>
								<Option>zandiledl@swazibank.co.sz</Option>
								<Option>ZandileM@swazibank.co.sz</Option>
								<Option>ZaneleD@swazibank.co.sz</Option>
								<Option>ZaneleDl@swazibank.co.sz</Option>
								<Option>ZaneleTD@swazibank.co.sz</Option>
								<Option>zinem@swazibank.co.sz</Option>
								<Option>ZodwaM@swazibank.co.sz</Option>
								<Option>zodwan@swazibank.co.sz</Option>

							</select>


						</div>
					</div>




					<div id="row" class="row">
						<div class="col col-md-12">
							<label for="customerQuery">Customer Query: </label>

							<textarea class="form-control" placeholder="Customer Query"
								name="customerQuery" rows="3"></textarea>
						</div>
					</div>
					<div id="row" class="row">

						<div class="col col-md-12">
							<label for="resolution">Resolution taken: </label>
							<textarea class="form-control" placeholder="Query resolution"
								name="resolution" rows="3"></textarea>
						</div>
					</div>

					<button type="submit" class="btn btn-primary btn-lg btn-block"
						style="margin-top: 10px;">Submit</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>