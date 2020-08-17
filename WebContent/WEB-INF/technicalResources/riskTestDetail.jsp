<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="css/amlTest1.css" rel="stylesheet" type="text/css" />
<title>AML TEST 2017</title>
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


		<div style="margin-left: 40px;">
			<h2>SWAZIBANK RISK MANAGEMENT TEST 2017</h2>

			<div>
				<form action="RiskTestDetail" method="POST">

					<input type="text" value="Employee Name:" read-only
						style="border-style: outset;" /> <select name="name"
						style="border-style: outset;" required>

						<option></option>
						<Option>ALEX MAMBA</Option>
						<Option>ANDILE SILENGE</Option>
						<Option>ANDILE FAKUDZE</Option>
						<Option>ANDILE MHLANGA</Option>
						<Option>BABHEKE DLADLA</Option>
						<option>BAFANA NCOGWANE</option>
						<option>BANDILE NKAMBULE</option>
						<Option>BANELE BHEMBE</Option>
						<option>BAPHELELE DLAMINI</option>
						<Option>BEN DLAMINI</Option>
						<option>BENELE SIMELANE</option>
						<Option>BONAKELE DLAMINI</Option>
						<option>BONGANI SHONGWE</option>
						<option>BEAULA DLAMINI</option>
						<option>BETSABISENI SIMELANE</option>
						<Option>BONGANI GULE</Option>
						<option>BONGANI ZWANE</option>
						<Option>BONGEKILE MDLULI</Option>
						<Option>BONGINKOSI SHABANGU</Option>
						<Option>BONGINKOSI NGWENYA</Option>
						<Option>BONGINKOSI THWALA</Option>
						<Option>BONGIWE MABUZA</Option>
						<Option>BONGIWE SIGWANE</Option>
						<Option>BONGIWE NGWENYA</Option>
						<Option>BONISILE MAGAGULA</Option>
						<Option>BONISILE NDZIMANDZE</Option>
						<Option>BONISIWE FAKUDZE</Option>
						<Option>BOYCE DLAMINI</Option>
						<Option>BUHLEBEZWE MDZINISO</Option>
						<Option>CANAAN MAVUSO</Option>
						<option>CEBILE LUKHELE</option>
						<Option>CEBISILE KUNENE</Option>
						<Option>CEBSILE DLAMINI</Option>
						<option>CECILIA MSANE</option>
						<Option>CELUMUSA MATSEBULA</Option>
						<Option>CHAMKILE SIMELANE</Option>
						<option>CHEILA VOVOS</option>
						<Option>CHRISTOPHER NKAMBULE</Option>
						<Option>COLLET MBULI</Option>
						<Option>CORDELIA DLAMINI</Option>
						<Option>CYNTHIA MADUNA</Option>
						<Option>DORIS PHIRI</Option>
						<Option>DUDU SKOSANA</Option>
						<Option>DUMILE MNDZEBELE</Option>
						<Option>ELSIE DLAMINI</Option>
						<Option>EUNICE MALAZA</Option>
						<Option>EVIDENCE MABUZA</Option>
						<Option>EZRA MASUKU</Option>
						<Option>FAKAZI MAMBA</Option>
						<Option>FANI FANI DLAMINI</Option>
						<Option>FIKILE MKHWANAZI</Option>
						<Option>FIKILE MAVIMBELA</Option>
						<Option>FISIWE KHUMALO</Option>
						<Option>FUTHI NGUBENI</Option>
						<Option>GABSILE MATSE</Option>
						<Option>GABSILE DLAMINI</Option>
						<Option>GABSILE MHLANGA</Option>
						<Option>GCEBILE SIFUNDZA</Option>
						<Option>GCEBILE SOKO</Option>
						<Option>GCINA GULE</Option>
						<Option>GCINILE DLAMINI</Option>
						<Option>GENIUS SIHLONGONYANE</Option>
						<Option>GUGU DLAMINI</Option>
						<Option>HAPPINESS MASUKU</Option>
						<Option>HAPPY NXUMALO</Option>
						<Option>HENDRICK VAN VUUREN</Option>
						<Option>HLENGIWE MASHABA</Option>
						<Option>HLEZIPHI SHABANGU</Option>
						<Option>HLOBSILE BHEMBE</Option>
						<Option>HLONIPHILE NKAMBULE</Option>
						<Option>HLONIPHILE KUNENE</Option>
						<Option>HLONIPHILE NDZIMANDZE</Option>
						<Option>HLONIPHILE MAZIYA</Option>
						<Option>INNOCENTIA MAVUSO</Option>
						<Option>JABULANI ZULU</Option>
						<Option>JABULANI MNISI</Option>
						<Option>JABULILE HLOPHE</Option>
						<Option>JABULILE DLAMINI</Option>
						<Option>JACQUELINE NDLOVU</Option>
						<Option>JANSEN MKHWELI</Option>
						<Option>JEREMIAH KHABA</Option>
						<Option>JOSEPHINE FAKUDZE</Option>
						<Option>KENNETH MOTSA</Option>
						<Option>KHANYILE NDZINISA</Option>
						<Option>KHANYISILE FAKUDZE</Option>
						<Option>KHAYELIHLE GAMA</Option>
						<Option>KHETSIWE NDWANDWE</Option>
						<Option>KHUMBU NKAMBULE</Option>
						<Option>KHUMBULANI KHUMALO</Option>
						<Option>KHUMBUZILE MNISI</Option>
						<Option>KNOWLEDGE MANANA</Option>
						<Option>KUSENI DLAMINI</Option>
						<Option>KUSOBALA DLAMINI</Option>
						<Option>KWANELE DLAMINI</Option>
						<Option>KWANELE VILANE</Option>
						<option>LANDABENHLE SIBISI</option>
						<Option>LEONARD DLAMINI</Option>
						<Option>LINDA MNISI</Option>
						<Option>LINDELWA MAMBA</Option>
						<Option>LINDELWE MYENI</Option>
						<Option>LINDOKUHLE GININDZA</Option>
						<option>LOMALUNGELO NKUMANE</option>
						<option>LONCWALA MTSETFWA</option>
						<Option>LONDIWE DLAMINI</Option>
						<Option>LUCAS THWALA</Option>
						<Option>LUCKY LUKHELE</Option>
						<Option>LUCKY MAMBA</Option>
						<Option>LUNGA NHLEKO</Option>
						<Option>LUNGA DLUDLU</Option>
						<Option>LUNGILE MATSEBULA</Option>
						<Option>LUNGILE MBUYISA</Option>
						<Option>LUNGILE MALINGA</Option>
						<Option>LUNGILE MAGONGO</Option>
						<Option>LUNGILE MDLULI</Option>
						<Option>LUNGILE SIHLONGONYANE</Option>
						<Option>LUNGILE MAHLALELA</Option>
						<Option>LWAZI HLOPHE</Option>
						<Option>LWAZI SIMELANE</Option>
						<Option>LWAZI MAMBA</Option>
						<Option>LWAZI MALINDZISA</Option>
						<Option>MACHAWE MASEKO</Option>
						<Option>MAGGIE DLAMINI</Option>
						<Option>MAKABONGWE MATSEBULA</Option>
						<option>MAHLE NXUMALO</option>
						<Option>MAKHOSAZANA DLAMINI</Option>
						<Option>MAKHOSAZANA SHONGWE</Option>
						<Option>MAKHOSAZANA DLAMINI</Option>
						<Option>MAKHOSAZANA MTHETHWA</Option>
						<Option>MAKHOSONKE MKHWANAZI</Option>
						<Option>MAPHILA MAGONGO</Option>
						<Option>MARY ZWANE</Option>
						<option>MASANGO MTHOBISI</option>
						<Option>MASWATI KUNENE</Option>
						<Option>MASWATI DLAMINI</Option>
						<Option>MAZALINA MTHANDE</Option>
						<Option>MAZIBUSE KHUMALO</Option>
						<option>MBALI KHUMALO</option>
						<Option>MBONGENI BHEMBE</Option>
						<Option>MBONGENI GWEBU</Option>
						<option>MBONGISENI ATWINE MABUZA</option>
						<Option>MBUSO MAVUSO</Option>
						<Option>MBUSO FAKUDZE</Option>
						<Option>MCEBI SHONGWE</Option>
						<Option>MDUDUZI HLOPHE</Option>
						<Option>MDUDUZI MNGOMETULU</Option>
						<Option>MELISSA ADAMS</Option>
						<Option>MELODY MAGAGULA</Option>
						<Option>MELUSI MASUKU</Option>
						<Option>MFANAFUTHI MABUZA</Option>
						<option>MFUNDO MABUZA</option>
						<Option>MILDRED NXUMALO</Option>
						<Option>MIRRIET MATHONSI</Option>
						<Option>MKHULULI MNISI</Option>
						<Option>MLUNGISI MNISI</Option>
						<Option>MLUNGISI DLAMINI</Option>
						<Option>MLUNGISI MAVUSO</Option>
						<Option>MOLLY FRANCIS</Option>
						<option>MOFFAT MLOTSA</option>
						<Option>MPHIKELELI DLAMINI</Option>
						<Option>MPHO KHOZA</Option>
						<Option>MPUMELELO MAVUNDLA</Option>
						<Option>MQAMBI NGWENYA</Option>
						<Option>MURMLY MABUZA</Option>
						<Option>MDLULI TRACY</Option>
						<Option>MUSA DLAMINI</Option>
						<Option>MUSA NGCAMPHALALA</Option>
						<Option>MYRAH VILAKAZI</Option>
						<Option>NATALIE GAMEDZE</Option>
						<Option>NCAMILE MALINGA</Option>
						<Option>NCAMSILE MNISI</Option>
						<option>NCEDILE BHEMBE</option>
						<option>NDUMISO KHUMALO</option>
						<Option>NELISWA DLAMINI</Option>
						<Option>NELSILE GININDZA</Option>
						<Option>NELSIWE MTSHALI</Option>
						<Option>NHLANHLA MAGAGULA</Option>
						<Option>NHLANHLA MTSETFWA</Option>
						<Option>NHLANHLAKWABANA MKHONTA</Option>
						<Option>NJABULO SIMELANE</Option>
						<Option>NJABULO MASUKU</Option>
						<Option>NJABULO DLAMINI</Option>
						<Option>NKOSINATHI SILOMBO</Option>
						<Option>NKOSINATHI MASINA</Option>
						<Option>NKOSINGIVILE NONDUDUZO MASUKU</Option>
						<Option>NKULULEKO TSABEDZE</Option>
						<Option>NKULULEKO DLAMINI</Option>
						<option>NOBAHLE TITI SIBANYONI</option>
						<Option>NOBESUTHU SEOPELA</Option>
						<Option>NOBESUTHU NKAMBULE</Option>
						<Option>NOKULINDA HLOPHE</Option>
						<Option>NOKULUNGA DLAMIINI</Option>
						<Option>NOKUPHILA DUBE</Option>
						<Option>NOKUPHILA SHONGWE</Option>
						<option>NOKWANDA LONDIWE MTSETFWA</option>
						<option>NOKWANDA VILAKATI</option>
						<Option>NOMATHEMBA DLAMINI</Option>
						<Option>NOMATHEMBA MAGAGULA</Option>

						<Option>NOMATHEMBA MAMBA</Option>
						<Option>NOMATHEMBA MASILELA</Option>
						<Option>NOMBULELO LUKHELE</Option>
						<Option>NOMBUSO THWALA</Option>
						<Option>NOMCEBO BHEMBE</Option>
						<option>NONTOBEKO NGAMPHALALA</option>
						<Option>NOMCEBO MTHANDE</Option>
						<Option>NOMCEBO NXUMALO</Option>
						<Option>NOMPILO NXUMALO</Option>
						<Option>NOMZAMO MNTUNGWA</Option>
						<option>NONHLANHLA DLAMINI</option>

						<Option>NONHLANHLA NXUMALO</Option>
						<Option>NONHLANHLA NDLANGAMANDLA</Option>
						<Option>NONHLANHLA MABUZA</Option>
						<Option>NONTOKOZO DLAMINI</Option>
						<option>NTOKOZO MSIMANGO</option>
						<option>NONTOBEKO HLOPHE</option>
						<Option>NOSIMILO GWEBU</Option>
						<Option>NOSIMILO MTHETHWA</Option>
						<Option>NOSIPHO GAMEDZE</Option>
						<Option>NOSIPHO NTSHANGASE</Option>
						<Option>NOSISA SIBANDZE</Option>
						<Option>NOTHANDO MASUKU</Option>
						<Option>NQOBILE NTULI</Option>
						<Option>NQOBILE SACOLO</Option>
						<Option>NQOBILE DUBE</Option>
						<Option>NQOBILE NDZABANDZABA</Option>
						<Option>NQOBILE MAVIMBELA</Option>
						<Option>NTOKOZO DLAMINI</Option>
						<Option>NTOMBI MAHLANGU</Option>
						<Option>NTOMBIKAYISE SIMELANE</Option>
						<Option>NTOMBIKAYISE DLAMINI</Option>
						<Option>PABALLO MHLANGA</Option>
						<Option>PASCAL MDLULI</Option>
						<Option>PATIENCE MAMBA</Option>
						<Option>PETER VILAKATI</Option>
						<Option>PETROS MNDZEBELE</Option>
						<Option>PHESHEYA VILAKATI</Option>
						<Option>PHETSILE DLAMINI</Option>
						<option>PHILILE SINDILE SHIBA</option>
						<Option>PHINDILE MKHWANAZI</Option>
						<Option>PHOLILE MNDZEBELE</Option>
						<Option>PHUMLANI MKHONTA</Option>
						<option>PHUMLILE DLAMINI</option>
						<Option>PHUMLILE NDLOVU</Option>
						<Option>PHUMZILE DUBE</Option>
						<Option>PORTIA DLAMINI</Option>
						<Option>PRECIOUS HLATSHWAYO</Option>
						<Option>PRINCESS VILAKATI</Option>
						<Option>PRISCILLA DLAMINI</Option>
						<Option>PROFESSOR NXUMALO</Option>
						<Option>PRUDENCE DLAMINI</Option>
						<Option>ROBERT KIGOBE</Option>
						<Option>ROBINSON HLOPHE</Option>
						<Option>ROMAN DLAMINI</Option>
						<Option>ROSE NHLENGETHWA</Option>
						<Option>SABELO DLAMINI</Option>
						<Option>SABELO KUNENE</Option>
						<Option>SABELO TFWALA</Option>
												<option>SAMBULO MLOTSHWA</option>
						<Option>SAKHILE SIMELANE</Option>
						<Option>SAKHILE DLAMINI</Option>
						<Option>SAKHILE MAHLALELA</Option>
						<Option>SAMKELISIWE MVUBU</Option>
						<Option>SANDILE MAMBA</Option>
						<Option>SANELE MAZIYA</Option>
						<Option>SANELE DLAMINI</Option>
						<Option>SANELE NKAMBULE</Option>
						<option>SANELE MNGOMEZULU</option>
						<option>SEBENZILE MHLANGA</option>


						<Option>SETH MPILA</Option>
						<Option>SIBONGILE DLAMINI</Option>
						<Option>SIBONGILE MNDAWE</Option>
						<Option>SIBONGILE DLAMINI</Option>
						<Option>SIBONISILE MDLULI</Option>
						<Option>SIBONISILE KHUMALO</Option>
						<Option>SIBUSISO SHONGWE</Option>
						<Option>SICELO NHLABATSI</Option>
						<Option>SICELO GININDZA</Option>
						<Option>SIFISO DUBE</Option>
						<Option>SIFISO FAKUDZE</Option>
						<Option>SIFISO MAGAGULA</Option>
						<Option>SIFISO MASINGA</Option>
						<Option>SIKHUMBUZO DLAMINI</Option>
						<Option>SIKHUMBUZO NDLOVU</Option>
						<Option>SIMANGELE MASANGO</Option>
						<Option>SIMANGELE MAVUSO</Option>
						<Option>SIMON KHUMALO</Option>
						<Option>SIMPHIWE MOTSA</Option>
						<Option>SINDIE SIMELANE</Option>
						<Option>SINDISIWE DLAMINI</Option>
						<Option>SIPHO DLAMINI</Option>
						<option>SIPHELELE MSIBI</option>
						<option>SIPHOSAKE SENGWAYO</option>

						<Option>SITHEMBILE SHABANGU</Option>
						<Option>SITHEMBILE MATIMELA</Option>
						<Option>SIVUMELE DLAMINI</Option>
						<option>SIYABONGA SHIBA</option>

						<Option>SONENI LUKHELE</Option>
						<Option>SOTJA NZIMA</Option>
						<option>TANDZILE SIMELANE</option>
						<Option>TAKHONA MAGONGO</Option>
						<Option>TEMALANGENI DLAMINI</Option>
						<Option>TENANILE DLAMINI</Option>
						<Option>TENANILE GAMEDZE</Option>
						<Option>TENELE SHABANGU</Option>
						<Option>THABANE NDZINISA</Option>
						<option>THABILE MKHWANAZI</option>
						<Option>THABISILE HLOPHE</Option>
						<Option>THABSILE DLAMINI</Option>
						<Option>THABSILE MNGOMETULU</Option>
						<Option>THANDAZILE NDZINISA</Option>
						<Option>THANDEKA MASHABA</Option>
						<Option>THANDWA MASEKO</Option>
						<Option>THEMBA DUBE</Option>
						<Option>THEMBEKILE MAGONGO</Option>
						<Option>THEMBENI DLAMINI</Option>
						<Option>THEMBI HLETA</Option>
						<Option>THEMBI MDLULI</Option>
						<Option>THEMBUMENZI KUNENE</Option>
						<Option>THEMBUMENZI MAMBA</Option>
						<Option>THEOPHILUS DLAMINI</Option>
						<Option>THOBA MAGAGULA</Option>
						<Option>THOKO NKONYANE</Option>
						<Option>THOLAKELE MASEKO</Option>
						<option>THULI MAMBA</option>
						<Option>THOMAS NXUMALO</Option>
						<Option>THULANI TSELA</Option>
						<Option>THULI DLAMINI</Option>
						<Option>THULSILE MNISI</Option>
						<Option>TINTFOMBI SIMELANE</Option>
						<Option>VAKELE DLAMINI</Option>
						<Option>VICTOR NXUMALO</Option>
						<Option>VIRGINIA MADUNA</Option>
						<Option>VIRGINIA DLADLA</Option>
						<Option>VUSI GWEBU</Option>
						<Option>VUSI MLOTSA</Option>
						<Option>VUSIKHAYA DLAMINI</Option>
						<Option>VUSUMUZI TSHABALALA</Option>
						<option>WANDILE GWEBU</option>
						<option>WELILE DLAMINI</option>
						<Option>WENDY DLAMINI</Option>
						<Option>WINILE MNISI</Option>
						<Option>WINILE MASILELA</Option>
						<Option>XOLANI SITHOLE</Option>
						<Option>XOLANI MACU</Option>
						<Option>XOLILE NDZABUKELWAKO</Option>
						<Option>XOLISILE CHAUYA</Option>
						<option>YOYI SIMELANE</option>
						<Option>ZAKHELE MAHLINZA</Option>
						<option>ZAMAHLUBI MTHIMKHULU</option>
						<Option>ZANDILE DLADLA</Option>
						<Option>ZANDILE MNGOMETULU</Option>
						<Option>ZANELE SIHLONGONYANE</Option>
						<Option>ZANELE DUBE</Option>
						<Option>ZANELE DLAMINI</Option>
						<Option>ZANELE JABU DLAMINI</Option>
						<Option>ZINE MKHOMBE</Option>
						<option>ZODWA GAMEDZE</option>
						<Option>ZODWA NCONGWANE</Option>
						<Option>ZODWA MASIMULA</Option>




					</select> <br> <input type="text" value="Branch"
						style="border-style: outset;" /> <select name="branch"
						value="Branch" style="border-style: outset;" required>

						<option></option>

						<option>HEAD OFFICE</option>
						<option>MBABANE BRANCH</option>
						<option>MBABANE COMMERCIAL BRANCH</option>
						<option>EZULWINI BRANCH</option>
						<option>MATSAPHA BRANCH</option>
						<option>MANZINI BRANCH</option>
						<option>CASH CENTRE BRANCH</option>
						<option>MATATA BRANCH</option>
						<option>SIPHOFANENI</option>
						<option>SIMUNYE BRANCH</option>
						<option>NHLANGANO BRANCH</option>
						<option>SITEKI BRANCH</option>
						<option>PIGGS PEAK BRANCH</option>

					</select> <br> <input type="text" value="Department"
						style="border-style: outset;" /> <select name="department"
						value="Department" style="border-style: outset;" required>

						<option></option>
						<option>INTERNAL AUDIT DEPARTMENT</option>
						<option>FINANCE DEPARTMENT</option>
						<option>OPERATIONS DEPARTMENT</option>
						<option>MARKETTING DEPARTMENT</option>
						<option>BUSINESS BANKING</option>
						<option>CORPORATE SERVICES DEPARTMENT</option>
						<option>CREDIT DEPARTMENT</option>
						<option>INFORMATION TECHNOLOGY DEPARTMENT</option>
						<option>MD'S OFFICE</option>

					</select>




					<table>
						<thead>
							<tr>
								<th>Question</th>
							</tr>
						</thead>
						<tbody>

							<tr>


								<td required><label style="color: black;">1) Which
										one of the following is not a definition of a Risk? </label> <br>

									<div>
										<input type="radio" name="radio1" id="radio1" class="radio"
											value="a" /> <label for="radio1">a) A risk is
											anything that may affect the achievement of an organization’s
											objectives.</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio1" id="radio2" class="radio"
											value="b" /> <label for="radio2">b) It is the
											uncertainty that surrounds future events and outcomes.</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio1" id="radio3" class="radio"
											value="c" /> <label for="radio3">c) Risk is the
											identification, assessment, and prioritization of risks
											followed by coordinated and economical application of
											resources to minimize, monitor, and control the probability
											and/or impact of unfortunate events..</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio1" id="radio4" class="radio"
											value="d" /> <label for="radio4">d) None of the
											above.</label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio1" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>
							<tr>








								<td><label style="color: black;">2) Risk management
										is…</label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio2" id="radio5" class="radio"
											value="a" /> <label for="radio5">a) A department or
											unit within the organization charged with the risk exposures
											that are related to their duties and responsibilities.</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio2" id="radio6" class="radio"
											value="b" /> <label for="radio6">b) the
											identification, assessment, and prioritization of risks
											followed by coordinated and economical application of
											resources to minimize, monitor, and control the probability
											and/or impact of unfortunate events.</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio2" id="radio7" class="radio"
											value="c" /> <label for="radio7">c) the
											classification of risks according to specific categories.</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio2" id="radio8" class="radio"
											value="d" /> <label for="radio8">d) Th development
											of a common and consistent approach to risk across the
											organization.</label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio2" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>

							<tr>




								<td><label style="color: black;"> 3) The Risk
										Management Process consists of the following; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio3" id="radio9" class="radio"
											value="a" /> <label for="radio9">a) Identify,
											Assess, Respond and Monitor</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio3" id="radio10" class="radio"
											value="b" /> <label for="radio10">b) Identify,
											Respond, Assess and Monitor</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio3" id="radio11" class="radio"
											value="c" /> <label for="radio11">c) Identify,
											Assess, Report and Monitor</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio3" id="radio12" class="radio"
											value="d" /> <label for="radio12"> d) Identify,
											communicate, Respond and Monitor</label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio3" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>

							<tr>





								<td><label style="color: black;">4) The following
										are the responses to risk;</label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio4" id="radio13" class="radio"
											value="a" /> <label for="radio13">a) Tolerate,
											treat, transfer, and terminate </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio4" id="radio14" class="radio"
											value="b" /> <label for="radio14">b) Terminate,
											transfer, tolerate, report </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio4" id="radio15" class="radio"
											value="c" /> <label for="radio15">c) Tolerate,
											treat, transfer, categorize</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio4" id="radio16" class="radio"
											value="d" /> <label for="radio16">d) None of the
											above.</label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio4" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>

							<tr>







								<td><label style="color: black;">5) Who is
										responsible for risk management in the Bank?</label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio5" id="radio17" class="radio"
											value="a" /> <label for="radio17">a) The board</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio5" id="radio18" class="radio"
											value="b" /> <label for="radio18">b) Risk &
											Compliance department</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio5" id="radio19" class="radio"
											value="c" /> <label for="radio19">c) All employees</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio5" id="radio20" class="radio"
											value="d" /> <label for="radio20">d) Management</label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio5" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>

							<tr>







								<td><label style="color: black;">6) The following
										are benefits of effective risk management;</label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio6" id="radio21" class="radio"
											value="a" /> <label for="radio21">a) Better able to
											take advantage of new business opportunities</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio6" id="radio22" class="radio"
											value="b" /> <label for="radio22">b) Reduction in
											management time spent “fire-fighting”</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio6" id="radio23" class="radio"
											value="c" /> <label for="radio23">c) Gives the
											organisation a competitive advantage</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio6" id="radio24" class="radio"
											value="d" /> <label for="radio24">d) All of the
											above</label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio6" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>

							<tr>







								<td><label style="color: black;">7) Operational
										risk is defined as </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio7" id="radio25" class="radio"
											value="a" /> <label for="radio25">a) the risk of
											loss resulting from inadequate or failed internal processes,
											people and systems or from external events.</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio7" id="radio26" class="radio"
											value="b" /> <label for="radio26">b) the risk of
											loss resulting from the failure of the Bank’s borrowers and
											other counterparties to fulfil their contractual obligations
											and that collateral provided does not cover the Bank’s
											claims.</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio7" id="radio27" class="radio"
											value="c" /> <label for="radio27">c) the failure to
											recognize or address changes in market conditions that affect
											the ability to liquidate assets quickly and with minimal loss
											in value.</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio7" id="radio28" class="radio"
											value="d" /> <label for="radio28">d) None of the
											above.</label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio7" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>


							<tr>








								<td><label style="color: black;">8) The following
										are categories of operational risk except</label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio8" id="radio29" class="radio"
											value="a" /> <label for="radio29">a) Human capital
											risk</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio8" id="radio30" class="radio"
											value="b" /> <label for="radio30">b) Technology risk</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio8" id="radio31" class="radio"
											value="c" /> <label for="radio31">c) Fraud Risk</label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio8" id="radio32" class="radio"
											value="d" /> <label for="radio32">d) Liquidity risk</label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio8" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>

							<tr>








								<td><label style="color: black;">9) Credit risk is
										defined as</label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio9" id="radio33" class="radio"
											value="a" /> <label for="radio33">a) the risk of
											loss resulting from inadequate or failed internal processes,
											people and systems or from external events. </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio9" id="radio34" class="radio"
											value="b" /> <label for="radio34">b) the risk of
											loss resulting from the failure of the Bank’s borrowers and
											other counterparties to fulfil their contractual obligations
											and that collateral provided does not cover the Bank’s
											claims. </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio9" id="radio35" class="radio"
											value="c" /> <label for="radio35">c) the failure to
											recognize or address changes in market conditions that affect
											the ability to liquidate assets quickly and with minimal loss
											in value. </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio9" id="radio36" class="radio"
											value="d" /> <label for="radio36">d) None of the
											above.</label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio9" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>


								<td><label style="color: black;"> 10) Pressure to
										commit fraud may be caused by; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio10" id="radio37" class="radio"
											value="a" /> <label for="radio37">a) inability to
											pay bills </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio10" id="radio38" class="radio"
											value="b" /> <label for="radio38">b) desire for
											status symbols (bigger house, new car) </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio10" id="radio39" class="radio"
											value="c" /> <label for="radio39">c) both A and B </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio10" id="radio40" class="radio"
											value="d" /> <label for="radio40">d) None of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio10" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>

							<tr>



								<td><label style="color: black;"> 11) The following
										are the early warning signs of liquidity </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio11" id="radio41" class="radio"
											value="a" /> <label for="radio41">a) Rising funding
											costs </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio11" id="radio42" class="radio"
											value="b" /> <label for="radio42">b) Reductions in
											availability of long-term funding </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio11" id="radio43" class="radio"
											value="c" /> <label for="radio43">c) Decreases in
											credit lines by correspondent banks </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio11" id="radio44" class="radio"
											value="d" /> <label for="radio44">d) All of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio11" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>



								<td><label style="color: black;"> 12) The most
										common market risk factors are </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio12" id="radio45" class="radio"
											value="a" /> <label for="radio45">a) interest rates
										</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio12" id="radio46" class="radio"
											value="b" /> <label for="radio46">b) foreign
											exchange rates </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio12" id="radio47" class="radio"
											value="c" /> <label for="radio47">c) equity prices </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio12" id="radio48" class="radio"
											value="d" /> <label for="radio48">d) All of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio12" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>




							<tr>

								<td><label style="color: black;">13) Which of the
										following risks can trigger liquidity risk? </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio13" id="radio49" class="radio"
											value="a" /> <label for="radio49">a) Credit Risk </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio13" id="radio50" class="radio"
											value="b" /> <label for="radio50">b) Operational
											Risk </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio13" id="radio51" class="radio"
											value="c" /> <label for="radio51">c) Reputational
											Risk </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio13" id="radio52" class="radio"
											value="d" /> <label for="radio52"> d) All of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio13" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>


								<td><label style="color: black;"> 14) Foreign
										Exchange Risk is </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio14" id="radio53" class="radio"
											value="a" /> <label for="radio53">a) The potential
											that movements in exchange rates may adversely affect the
											value of an institution’s holding, and, thus its financial
											condition. </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio14" id="radio54" class="radio"
											value="b" /> <label for="radio54">b) risk that the
											counterparty to a transaction could default before the final
											settlement of the transaction's cash flows. </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio14" id="radio55" class="radio"
											value="c" /> <label for="radio55">c) The potential
											for adverse changes in the value of an institution’s
											commodity related holdings. </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio14" id="radio56" class="radio"
											value="d" /> <label for="radio56">d) The current and
											prospective potential for loss to an institution arising from
											its inability to meet its obligations or to fund increases in
											assets as they fall due without incurring unacceptable cost
											or losses. </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio14" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>




								<td><label style="color: black;">15. The following
										are types of market risk except. </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio15" id="radio57" class="radio"
											value="a" /> <label for="radio57">a) Commodity price
											risk </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio15" id="radio58" class="radio"
											value="b" /> <label for="radio58">b) Interest rate
											risk </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio15" id="radio59" class="radio"
											value="c" /> <label for="radio59">c) Credit risk </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio15" id="radio60" class="radio"
											value="d" /> <label for="radio60"> d) Foreign
											exchange risk </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio15" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>

								<td><label style="color: black;">16) The Bank is
										mostly exposed to Foreign Exchange Rate Risk when; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio16" id="radio61" class="radio"
											value="a" /> <label for="radio61">a) Borrowing funds
											denominated in US Dollars .</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio16" id="radio62" class="radio"
											value="b" /> <label for="radio62">b) Interest rates
											are rising </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio16" id="radio63" class="radio"
											value="c" /> <label for="radio63">c) Borrowing funds
											in Emalangeni </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio16" id="radio64" class="radio"
											value="d" /> <label for="radio64">d) None of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio16" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>



								<td><label style="color: black;"> 17) The following
										is an example of operational risk </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio17" id="radio65" class="radio"
											value="a" /> <label for="radio65">a) A bank employee
											colluding with a client to defraud the bank </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio17" id="radio66" class="radio"
											value="b" /> <label for="radio66">b) Inability to
											access system </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio17" id="radio67" class="radio"
											value="c" /> <label for="radio67">c) Unauthorised
											persons having accessing sensitive information </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio17" id="radio68" class="radio"
											value="d" /> <label for="radio68">d) All of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio17" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>

								<td><label style="color: black;">18) The following
										are Cressey’s fraud factors; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio18" id="radio69" class="radio"
											value="a" /> <label for="radio69">a) Pressure,
											rationalisation, and peer pressure </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio18" id="radio70" class="radio"
											value="b" /> <label for="radio70">b) Opportunity,
											rationalisation, and pressure </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio18" id="radio71" class="radio"
											value="c" /> <label for="radio71">c)
											Rationalisation, opportunity, and ability </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio18" id="radio72" class="radio"
											value="d" /> <label for="radio72">d) None of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio18" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>





							<tr>

								<td><label style="color: black;">19) The following
										are examples of opportunities to commit fraud except; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio19" id="radio77" class="radio"
											value="a" /> <label for="radio73">a) Absence of
											internal controls </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio19" id="radio74" class="radio"
											value="b" /> <label for="radio74"> b) Inefficient
											internal controls </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio19" id="radio75" class="radio"
											value="c" /> <label for="radio75">c) Inability to
											pay bills </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio19" id="radio76" class="radio"
											value="d" /> <label for="radio76">d) Perceived low
											risk of getting caught </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio19" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>

								<td><label style="color: black;">20) Pressure to
										commit fraud may be caused by; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio20" id="radio77" class="radio"
											value="a" /> <label for="radio77">a) inability to
											pay bills </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio20" id="radio78" class="radio"
											value="b" /> <label for="radio78">b) desire for
											status symbols (bigger house, new car) </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio20" id="radio79" class="radio"
											value="c" /> <label for="radio79">c) both A and B </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio20" id="radio80" class="radio"
											value="d" /> <label for="radio80">d) None of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio20" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>

								<td><label style="color: black;">21) Red flags
										indicating that someone may be involved in fraudulent
										activities include; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio21" id="radio81" class="radio"
											value="a" /> <label for="radio81">a) living beyond
											means </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio21" id="radio82" class="radio"
											value="b" /> <label for="radio22">b) unusually close
											association with a vendor or customer </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio21" id="radio83" class="radio"
											value="c" /> <label for="radio83">c) ﬁnancial
											difﬁculties </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio21" id="radio84" class="radio"
											value="d" /> <label for="radio84">d) All of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio21" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>

								<td><label style="color: black;">22) An
										organisation is exposed to internal fraud when; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio22" id="radio85" class="radio"
											value="a" /> <label for="radio85">a) There is lack
											of internal controls </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio22" id="radio86" class="radio"
											value="b" /> <label for="radio86">b) There are
											vigilant supervisors </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio22" id="radio87" class="radio"
											value="c" /> <label for="radio87">c) There is
											ability to override existing internal controls </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio22" id="radio88" class="radio"
											value="d" /> <label for="radio88"> d) Both A and C.
										</label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio22" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>


							<tr>

								<td><label style="color: black;">23) Due Diligence
										is; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio23" id="radio89" class="radio"
											value="a" /> <label for="radio89">a) Obtaining a
											customer’s identity document at account opening stage </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio23" id="radio90" class="radio"
											value="b" /> <label for="radio90">b) Investigation,
											examination, research of a business or person prior to
											signing a contract. </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio23" id="radio91" class="radio"
											value="c" /> <label for="radio91">c) Attaching all
											necessary documents in the customer file. </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio23" id="radio92" class="radio"
											value="d" /> <label for="radio92">d) None of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio23" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>



							<tr>

								<td><label style="color: black;">24. Financial Risk
										refers to; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio24" id="radio93" class="radio"
											value="a" /> <label for="radio93">a) Risks arising
											from financial failure </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio24" id="radio94" class="radio"
											value="b" /> <label for="radio94"> b) Risk that the
											lender will be prevented from accessing assets, cash flows
											and contracts on which it is depending because of factors
											arising from the group structure </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio24" id="radio95" class="radio"
											value="c" /> <label for="radio95">c) Risks arising
											from day-to-day operation of the business in its sector of
											industry and macro-economic environment </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio24" id="radio96" class="radio"
											value="d" /> <label for="radio96">d) None of the
											above </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio24" value="e" checked
											style="visibility: hidden;" />
									</div></td>
							</tr>


							<tr>

								<td><label style="color: black;">25) Fraud can be
										detected through; </label> <br>

									<div style="margin-top: 2px">
										<input type="radio" name="radio25" id="radio97" class="radio"
											value="a" /> <label for="radio97">a) Whistle-Blowing
										</label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio25" id="radio98" class="radio"
											value="b" /> <label for="radio98">b) Internal Audit
											Activities </label>
									</div>

									<div style="margin-top: 2px">
										<input type="radio" name="radio25" id="radio99" class="radio"
											value="c" /> <label for="radio99">c) Management
											Review </label>
									</div>

									<div style="margin-top: 1px">
										<input type="radio" name="radio25" id="radio100" class="radio"
											value="d" /> <label for="radio100">d) All of the
											above. </label>
									</div>
									<div style="margin-top: 2px">
										<input type="radio" name="radio25" value="e" checked
											style="visibility: hidden;" />
									</div></td>
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
