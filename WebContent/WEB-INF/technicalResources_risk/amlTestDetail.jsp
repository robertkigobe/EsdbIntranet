<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>AML TEST</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="js/bootstrap.js"></script>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>

<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/HomePage.css" rel="stylesheet" type="text/css" />

<style>
* {
	font-size: 15px;
	line-height: 1.428;
}
</style>
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


		<div style="margin-left: 40px;">
			<h2>SWAZIBANK AML TEST</h2>


			<form action="AmlTestDetail" method="POST" class="form">

				<div class="form-group" style="border: 1px solid black">

					<input type="text" value="Employee Name:"
						style="border-style: outset;" required placeholder="Employee Name"/> <Select name="employeeName" required>
						<c:forEach var="employees" items="${employees}" >
							<option value="${employees}">${employees}</option>
						</c:forEach>
					</Select>
				</div>
				<div class="form-group" style="border: 1px solid black">
					<input type="text" value="Department" style="border-style: outset;" />
					<select name="department" 
						style="border-style: outset;" required>

						<option></option>
						<option>BUSINESS BANKING</option>
						<option>CASH CENTRE BRANCH</option>
						<option>CORPORATE SERVICES DEPARTMENT</option>
						<option>CREDIT DEPARTMENT</option>
						<option>EZULWINI BRANCH</option>
						<option>INFORMATION TECHNOLOGY DEPARTMENT</option>
						<option>FINANCE DEPARTMENT</option>
						<option>HEAD OFFICE</option>
						<option>INTERNAL AUDIT DEPARTMENT</option>
						<option>MANZINI BRANCH</option>
						<option>MARKETTING DEPARTMENT</option>
						<option>MATSAPHA BRANCH</option>
						<option>MBABANE BRANCH</option>
						<option>MBABANE COMMERCIAL BRANCH</option>
						<option>MD'S OFFICE</option>
						<option>MATATA BRANCH</option>
						<option>OPERATIONS DEPARTMENT</option>
						<option>SIPHOFANENI</option>
						<option>SIMUNYE BRANCH</option>
						<option>NHLANGANO BRANCH</option>
						<option>SITEKI BRANCH</option>
						<option>PIGGS PEAK BRANCH</option>

					</select>
				</div>
			


				<div class="form-group">

					<label for="radio1" class="form-control">1. What is money
						laundering?</label> <br>

					<div class="radio">
						<input type="radio" name="radio1" id="radio1" class="radio"
							value="a" /> <label for="radio1">a) The process of
							transferring money from one form into another so as to avoid
							excessive bank charges, e.g. from cash into an investment.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio1" id="radio2" class="radio"
							value="b"  required/> <label for="radio2">b) The process of
							giving “dirty money” the appearance of having a legitimate
							source.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio1" id="radio3" class="radio"
							value="c" /> <label for="radio3">c) The act of
							transferring property from one owner to another without the
							knowledge of the crime prevention authorities.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio1" id="radio4" class="radio"
							value="d" /> <label for="radio4">d) The act of stealing
							someone else’s property.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio1" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio2" class="form-control">2. One of the aims
						of money laundering is to……….</label> <br>

					<div class="radio">
						<input type="radio" name="radio2" id="radio5" class="radio"
							value="a" /> <label for="radio5">a) Make a profit
							through illegal activities.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio2" id="radio6" class="radio"
							value="b" /> <label for="radio6">b) Perform multiple
							complex international banking transactions.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio2" id="radio7" class="radio"
							value="c" /> <label for="radio7">c) Make someone else’s
							deposits, withdrawals and transfers appear illegal.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio2" id="radio8" class="radio"
							value="d" /> <label for="radio8">d) Place illegally
							obtained money beyond the reach of the law.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio2" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>

				<div class="form-group">

					<label for="radio3" class="form-control">3. A money
						laundering offence is committed if…….</label> <br>

					<div class="radio">
						<input type="radio" name="radio3" id="radio9" class="radio"
							value="a" /> <label for="radio9">a) A person buying the
							goods knew or should have known that the goods were stolen.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio3" id="radio10" class="radio"
							value="b" /> <label for="radio10">b) The proceeds of a
							crime are used by the criminal to pay off a home loan.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio3" id="radio11" class="radio"
							value="c" /> <label for="radio11">c) The person who
							stole the money deposits it in his / her account.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio3" id="radio12" class="radio"
							value="d" /> <label for="radio12">d) All of the above</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio3" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio4" class="form-control">4. How do
						criminals conceal themselves from their acts of money laundering?
						There could be more than one correct answer.</label> <br>

					<div class="radio">
						<input type="radio" name="radio4" id="radio13" class="radio"
							value="a" /> <label for="radio13">a) By not operating
							accounts with foreign banks.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio4" id="radio14" class="radio"
							value="b" /> <label for="radio14">b) By creating
							fictitious identities and then opening front companies and bank
							accounts.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio4" id="radio15" class="radio"
							value="c" /> <label for="radio15">c) By not reporting
							their profits to the authorities and so avoid paying tax.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio4" id="radio16" class="radio"
							value="d" /> <label for="radio16">d) Both b and c.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio4" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio5" class="form-control">5. Which are the
						three stages of money laundering?</label> <br>

					<div class="radio">
						<input type="radio" name="radio5" id="radio17" class="radio"
							value="a" /> <label for="radio17">a) Placing,
							transferring and disguising.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio5" id="radio18" class="radio"
							value="b" /> <label for="radio18">b) Converting,
							layering and disguising.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio5" id="radio19" class="radio"
							value="c" /> <label for="radio19">c) Placing, layering
							and integrating.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio5" id="radio20" class="radio"
							value="d" /> <label for="radio20">d) None of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio5" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio6" class="form-control">6. The second
						stage of money laundering is characterized by……..</label> <br>

					<div class="radio">
						<input type="radio" name="radio6" id="radio21" class="radio"
							value="a" /> <label for="radio21">a) Placement of funds
							into the financial industry so as to hide the ownership of funds.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio6" id="radio22" class="radio"
							value="b" /> <label for="radio22">b) Concealing and
							disguising behaviour so as to hide the ownership of funds.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio6" id="radio23" class="radio"
							value="c" /> <label for="radio23">c) Re-use of funds,
							especially with the aim of spending it in the retail industry of
							the economy.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio6" id="radio24" class="radio"
							value="d" /> <label for="radio24">d) Conversion of cash
							into assets for the purpose of further legal or illegal trade.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio6" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio7" class="form-control">7. The last stage
						of money laundering is characterized by……..</label> <br>

					<div class="radio">
						<input type="radio" name="radio7" id="radio25" class="radio"
							value="a" /> <label for="radio25">a) Legislation
							enforcement action to convict the criminal.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio7" id="radio26" class="radio"
							value="b" /> <label for="radio26">b) The use of
							intricate financial products and services to hide the money.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio7" id="radio27" class="radio"
							value="c" /> <label for="radio27">c) The use of
							syndicates and insiders to split the money and change its form.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio7" id="radio28" class="radio"
							value="d" /> <label for="radio28">d) Actions that make
							the money available in the economy in seemingly legitimate form.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio7" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio8" class="form-control">8. Which of the
						following scenarios is not an example of layering?</label> <br>

					<div class="radio">
						<input type="radio" name="radio8" id="radio29" class="radio"
							value="a" /> <label for="radio29">a) A criminal
							transfers “dirty” money from his savings account to a cheque
							account, and then from the cheque account to his credit card
							account.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio8" id="radio30" class="radio"
							value="b" /> <label for="radio30">b) A criminal
							withdraws “dirty” money from his bank account and deposit it into
							a safe deposit box at the bank.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio8" id="radio31" class="radio"
							value="c" /> <label for="radio31">c) A criminal buy an
							office building with “dirty” money and sells it within a year for
							a loss.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio8" id="radio32" class="radio"
							value="d" /> <label for="radio32">d) A criminal gets
							members of his family to deposit stolen cash into his bank
							account.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio8" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio9" class="form-control">9. Mr. Jackson
						makes a large profit in his car dealership shop. However, his
						financial statements show a loss. He is engaging in ………..</label> <br>

					<div class="radio">
						<input type="radio" name="radio9" id="radio33" class="radio"
							value="a" /> <label for="radio33">a) Tax evasion </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio9" id="radio34" class="radio"
							value="b" /> <label for="radio34">b) Splitting </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio9" id="radio35" class="radio"
							value="c" /> <label for="radio35">c) Layering </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio9" id="radio36" class="radio"
							value="d" /> <label for="radio36">d) Integration</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio9" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio10" class="form-control">10. Joy regularly
						deposit cash by means of a number of deposit slips, with each
						deposit being relatively small. However, the total of all these
						deposits is significant. This is an example of a:</label> <br>

					<div class="radio">
						<input type="radio" name="radio10" id="radio37" class="radio"
							value="a" /> <label for="radio37">a) Customer that does
							not appear to be honest.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio10" id="radio38" class="radio"
							value="b" /> <label for="radio38">b) Transactions that
							appear to have a money laundering purpose such as integrating.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio10" id="radio39" class="radio"
							value="c" /> <label for="radio39">c) Customer whose
							affairs are not known to the bank as the bank does not have
							satisfactory picture of her business and estate</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio10" id="radio40" class="radio"
							value="d" /> <label for="radio40">d) None of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio10" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio11" class="form-control">11. Which of the
						following makes it hard to recognize money laundering
						transactions? </label> <br>

					<div class="radio">
						<input type="radio" name="radio11" id="radio41" class="radio"
							value="a" /> <label for="radio41">a) Transactions that
							are performed electronically.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio11" id="radio42" class="radio"
							value="b" /> <label for="radio42">b) Small cash
							deposits.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio11" id="radio43" class="radio"
							value="c" /> <label for="radio43">c) High volumes of
							transactions.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio11" id="radio44" class="radio"
							value="d" /> <label for="radio44">d) All of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio11" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio12" class="form-control">12. Which of the
						following is a big contributor to the growth of money laundering
						internationally? </label> <br>

					<div class="radio">
						<input type="radio" name="radio12" id="radio45" class="radio"
							value="a" /> <label for="radio45"> a) Improved
							technology and reduced barriers to the free movement of money</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio12" id="radio46" class="radio"
							value="b" /> <label for="radio46">b) Declining
							competence among law enforcement agencies, such as the police.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio12" id="radio47" class="radio"
							value="c" /> <label for="radio47"> c) Famine,
							displacement of people and homelessness.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio12" id="radio48" class="radio"
							value="d" /> <label for="radio48">d) The lack of support
							for international anti-money laundering initiatives.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio12" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio13" class="form-control">13. Which of the
						following are important anti-money laundering principles? </label> <br>

					<div class="radio">
						<input type="radio" name="radio13" id="radio49" class="radio"
							value="a" /> <label for="radio49">a) Try to only do
							business with those customers whose sources of wealth and funds
							are legitimate. </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio13" id="radio50" class="radio"
							value="b" /> <label for="radio50">b) Monitor cash
							transactions because they are typical money laundering vehicles.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio13" id="radio51" class="radio"
							value="c" /> <label for="radio51">c) Co-operate with
							Financial Intelligent Units to identify possible money laundering
							acts.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio13" id="radio52" class="radio"
							value="d" /> <label for="radio52"> d) All of the above</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio13" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">

					<label for="radio14" class="form-control">14. Jackson owns
						a car dealer but does not record all the transactions which occur
						daily in the financial records of the business. For years cash
						which is paid to the business go directly into his “holiday fund
						account” and he believes that only stupid people pay tax.
						Jackson’s girlfriend, Joy and the Accountant know about this money
						that does not get recorded because they both enjoy the holidays
						that are paid for with these funds. In terms of the ML
						(Prevention) Act, Joy and the Accountant are committing an offence
						because they…. </label> <br>

					<div class="radio">
						<input type="radio" name="radio14" id="radio53" class="radio"
							value="a" /> <label for="radio53">a) Knowingly used the
							proceeds of Jackson’s crime.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio14" id="radio54" class="radio"
							value="b" /> <label for="radio54">b) Did not contribute
							to the source of the “holiday fund”. </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio14" id="radio55" class="radio"
							value="c" /> <label for="radio55">c) Were willfully
							blind to the source of the “holiday fund”.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio14" id="radio56" class="radio"
							value="d" /> <label for="radio56">d) None of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio14" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio15" class="form-control">15. Jackson has
						used his investment account on three occasions this year to wire
						funds from his “holiday fund account” to overseas locations where
						he purchased different properties with the funds. If caught,
						Jackson could, amongst others be charged with…. </label> <br>

					<div class="radio">
						<input type="radio" name="radio15" id="radio57" class="radio"
							value="a" /> <label for="radio57">a) Racketeering
							related money laundering.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio15" id="radio58" class="radio"
							value="b" /> <label for="radio58">b) Being willfully
							negligent.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio15" id="radio59" class="radio"
							value="c" /> <label for="radio59">c) Being willfully
							blind </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio15" id="radio60" class="radio"
							value="d" /> <label for="radio60"> d) Theft.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio15" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio16" class="form-control">16. Joy knows
						that Jackson obtained his money through illegal means. Jackson
						asks her to help him to set up a trust fund that will allow him to
						hide and spend the money undetected. If Joy assists Jackson she
						would…. </label> <br>

					<div class="radio">
						<input type="radio" name="radio16" id="radio61" class="radio"
							value="a" /> <label for="radio61">a) Committing the
							offence of helping Jackson acquire the proceeds of crime.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio16" id="radio62" class="radio"
							value="b" /> <label for="radio62">b) Committing the
							offence of being negligently ignorant.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio16" id="radio63" class="radio"
							value="c" /> <label for="radio63">c) Committing the
							money laundering offence of helping Jackson to benefit from the
							proceeds of crime </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio16" id="radio64" class="radio"
							value="d" /> <label for="radio64">d) None of the above.
						</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio16" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio17" class="form-control">17. A new client
						comes with E50, 000 to the bank and request to open a savings
						account. The money is in both local and foreign currency. The
						client is clearly an Asian. When you request for his identity, he
						hands over a local travel document, which shows that he is a local
						citizen. On closer inspection, you see that his name is a typical
						Swazi name and you immediately become suspicious. You excuse
						yourself and walk over to your manager to discuss the matter with
						him. From your discussion you decide to report the incident as
						suspicious, but at the same time your manager instructs you to
						open the account. As soon as you take your seat the prospective
						client requests for his documents and excuses himself and
						disappears in a rather nervous hurry. This could be an instance of
						…… </label> <br>

					<div class="radio">
						<input type="radio" name="radio17" id="radio65" class="radio"
							value="a" /> <label for="radio65">a) Placement. The
							client was probably trying to open an account to place “dirty”
							money with the bank.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio17" id="radio66" class="radio"
							value="b" /> <label for="radio66">b) Risk exposure.
							Money launderers are particularly at risk when they have to deal
							directly with bank employees – especially those that are vigilant
							to money laundering. </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio17" id="radio67" class="radio"
							value="c" /> <label for="radio67">c) Tipping off.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio17" id="radio68" class="radio"
							value="d" /> <label for="radio68">d) Both b and a</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio17" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio18" class="form-control">18. Money
						Laundering and Terrorist financing have significant economic and
						social consequences to a country in that: </label> <br>

					<div class="radio">
						<input type="radio" name="radio18" id="radio69" class="radio"
							value="a" /> <label for="radio69">a) It increases crime
							and corruption.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio18" id="radio70" class="radio"
							value="b" /> <label for="radio70"> b) It weakens
							financial institutions.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio18" id="radio71" class="radio"
							value="c" /> <label for="radio71">c) It damage
							privatization efforts.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio18" id="radio72" class="radio"
							value="d" /> <label for="radio72">d) All of the above. </label>
					</div>
					<div class="radio">
						<input type="radio" name="radio18" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">







					<label for="radio19" class="form-control">19. Havens for
						money laundering and terrorist financing have... </label> <br>

					<div class="radio">
						<input type="radio" name="radio19" id="radio77" class="radio"
							value="a" /> <label for="radio73">a) A weak AML/CFT
							regime.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio19" id="radio74" class="radio"
							value="b" /> <label for="radio74"> b) Ineffective
							penalties, including difficult confiscation provision</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio19" id="radio75" class="radio"
							value="c" /> <label for="radio75">c) Some or many types
							of financial institutions that are not covered by an AML/CFT
							framework.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio19" id="radio76" class="radio"
							value="d" /> <label for="radio76">d) All of the above. </label>
					</div>
					<div class="radio">
						<input type="radio" name="radio19" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio20" class="form-control">20. What are the
						benefits of having an effective AML/CFT framework? </label> <br>

					<div class="radio">
						<input type="radio" name="radio20" id="radio77" class="radio"
							value="a" /> <label for="radio77">a) It fights crime and
							corruption. </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio20" id="radio78" class="radio"
							value="b" /> <label for="radio78"> b) It enhances
							stability of financial institutions.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio20" id="radio79" class="radio"
							value="c" /> <label for="radio79">c) It encourages
							economic development.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio20" id="radio80" class="radio"
							value="d" /> <label for="radio80">d) All of the above. </label>
					</div>
					<div class="radio">
						<input type="radio" name="radio20" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio21" class="form-control">21. Which of the
						following are benefits that a bank may obtain by complying with
						its money laundering control obligations? </label> <br>

					<div class="radio">
						<input type="radio" name="radio21" id="radio81" class="radio"
							value="a" /> <label for="radio81">a) The bank will know
							its customers better and be able to provide a better service to
							them.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio21" id="radio82" class="radio"
							value="b" /> <label for="radio22">b) The bank will
							protect its systems against abuse by money launderers.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio21" id="radio83" class="radio"
							value="c" /> <label for="radio83">c) The bank will
							protect itself from fraud.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio21" id="radio84" class="radio"
							value="d" /> <label for="radio84">d) All of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio21" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio22" class="form-control">22. Which
						organization(s) is responsible for the published 40
						Recommendations? </label> <br>

					<div class="radio">
						<input type="radio" name="radio22" id="radio85" class="radio"
							value="a" /> <label for="radio85">a) Basel Committee.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio22" id="radio86" class="radio"
							value="b" /> <label for="radio86"> b) The United
							Nations.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio22" id="radio87" class="radio"
							value="c" /> <label for="radio87">c) FATF.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio22" id="radio88" class="radio"
							value="d" /> <label for="radio88"> d) ADB. </label>
					</div>
					<div class="radio">
						<input type="radio" name="radio22" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">




					<label for="radio23" class="form-control">23. Notable among
						the Forty Recommendations are those calling for countries to: </label> <br>

					<div class="radio">
						<input type="radio" name="radio23" id="radio89" class="radio"
							value="a" /> <label for="radio89">a) Criminalize money
							laundering.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio23" id="radio90" class="radio"
							value="b" /> <label for="radio90"> b) Exercise stronger
							prudential supervision.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio23" id="radio91" class="radio"
							value="c" /> <label for="radio91">c) Punish both
							individuals and corporate entities.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio23" id="radio92" class="radio"
							value="d" /> <label for="radio92">d) All of the above. </label>
					</div>
					<div class="radio">
						<input type="radio" name="radio23" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio24" class="form-control">24. The Financial
						Action Task Force focuses on…. </label> <br>

					<div class="radio">
						<input type="radio" name="radio24" id="radio93" class="radio"
							value="a" /> <label for="radio93">a) Spreading the AML
							message to all constraints and regions around the world.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio24" id="radio94" class="radio"
							value="b" /> <label for="radio94"> b) Monitoring the
							implementation of the Forty Recommendations</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio24" id="radio95" class="radio"
							value="c" /> <label for="radio95">c) Reviewing and
							publishing money laundering trends and counter measures.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio24" id="radio96" class="radio"
							value="d" /> <label for="radio96">d) All of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio24" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">




					<label for="radio25" class="form-control">25. All of the
						following are in the FAFT Forty Recommendations to banks, except </label>
					<br>

					<div class="radio">
						<input type="radio" name="radio25" id="radio97" class="radio"
							value="a" /> <label for="radio97">a) Strictly enforce
							customer identification KYC rules</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio25" id="radio98" class="radio"
							value="b" /> <label for="radio98">b) Submit suspicious
							transaction report and maintain records.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio25" id="radio99" class="radio"
							value="c" /> <label for="radio99">c) Maintain
							transaction records as long as there business relationship
							exists.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio25" id="radio100" class="radio"
							value="d" /> <label for="radio100">d) Pay special
							attention to large, complex or unusual transactions.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio25" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio26" class="form-control">26. The Basel
						Committee issued a number of basic principles to Banks, which were
						in line with the FAFT Forty Recommendations. Which one is not in
						line with the Forty Recommendations? </label> <br>

					<div class="radio">
						<input type="radio" name="radio26" id="radio101" class="radio"
							value="a" /> <label for="radio101"> a) Compliance with
							laws.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio26" id="radio102" class="radio"
							value="b" /> <label for="radio102"> b) Charge on sight a
							customer with a suspicious transaction.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio26" id="radio103" class="radio"
							value="c" /> <label for="radio103">c) Cooperate with law
							enforcement agencies.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio26" id="radio104" class="radio"
							value="d" /> <label for="radio104">d) Know Your
							Customer.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio26" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio27" class="form-control">27. As part of
						the requirement that a bank must be able to identify its
						customers, the bank must….. </label> <br>

					<div class="radio">
						<input type="radio" name="radio27" id="radio105" class="radio"
							value="a" /> <label for="radio105"> a) Have enough
							information to be able to locate a customer.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio27" id="radio106" class="radio"
							value="b" /> <label for="radio106">b) Have a colour
							photograph of every client.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio27" id="radio107" class="radio"
							value="c" /> <label for="radio107">c) Insist on
							retaining original documents of clients on file</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio27" id="radio108" class="radio"
							value="d" /> <label for="radio108">d) All of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio27" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio28" class="form-control">28. The Eastern
						and Southern Anti-Money Laundering Group (ESAAMLG) objectives are:
					</label> <br>

					<div class="radio">
						<input type="radio" name="radio28" id="radio109" class="radio"
							value="a" /> <label for="radio109">a) Adopt and
							implement the Forty Recommendations.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio28" id="radio110" class="radio"
							value="b" /> <label for="radio110">) Apply AML measures
							to all serious crimes.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio28" id="radio111" class="radio"
							value="c" /> <label for="radio111">c) Implement all
							other measures contained in the multilateral agreement</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio28" id="radio112" class="radio"
							value="d" /> <label for="radio112">d) All of the above</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio28" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio29" class="form-control">29. The Swaziland
						ML (Prevention) Act, 2011, allows financial institutions to: </label> <br>

					<div class="radio">
						<input type="radio" name="radio29" id="radio113" class="radio"
							value="a" /> <label for="radio113">a) Keep business
							transactions record for a period of 1 year after termination of
							business transaction.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio29" id="radio114" class="radio"
							value="b" /> <label for="radio114">b) Comply with any
							instruction issued to it by another institution.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio29" id="radio115" class="radio"
							value="c" /> <label for="radio115">c) Permit any
							authorized law enforcement agency to enter into premises, search
							and remove any document for the purpose of investigation.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio29" id="radio116" class="radio"
							value="d" /> <label for="radio116">d) All of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio29" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">




					<label for="radio30" class="form-control">30. The bank is
						required by law to do the following except…. </label> <br>

					<div class="radio">
						<input type="radio" name="radio30" id="radio117" class="radio"
							value="a" /> <label for="radio117">a) Keep accurate
							video surveillance of all its customers as they conduct
							transactions </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio30" id="radio118" class="radio"
							value="b" /> <label for="radio118">b) Write and
							implement internal rules relating to money laundering. </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio30" id="radio119" class="radio"
							value="c" /> <label for="radio119">c) Train employees to
							enable them to comply with their money laundering control
							obligations.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio30" id="radio120" class="radio"
							value="d" /> <label for="radio120">d) Appoint an officer
							who is responsible for ensuring compliance by the institution’s
							employee.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio30" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio31" class="form-control">31. The banker’s
						duty to keep customer’s financial affairs confidential is often
						referred to as: </label> <br>

					<div class="radio">
						<input type="radio" name="radio31" id="radio121" class="radio"
							value="a" /> <label for="radio121"> a) Invasion of
							privacy. </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio31" id="radio122" class="radio"
							value="b" /> <label for="radio122">b) Bank secrecy </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio31" id="radio123" class="radio"
							value="c" /> <label for="radio123">c) Tempering with
							information.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio31" id="radio124" class="radio"
							value="d" /> <label for="radio124"> d) Privilege
							information.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio31" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">




					<label for="radio32" class="form-control">32. The bank may
						give out information about a client to certain law enforcement
						agencies provided …. </label> <br>

					<div class="radio">
						<input type="radio" name="radio32" id="radio125" class="radio"
							value="a" /> <label for="radio125"> a) It is forced to
							at gun point.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio32" id="radio126" class="radio"
							value="b" /> <label for="radio126">b) It is bribed to
							provide such information.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio32" id="radio127" class="radio"
							value="c" /> <label for="radio127">c) The law obliges
							the bank to provide such information to them.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio32" id="radio128" class="radio"
							value="d" /> <label for="radio128"> d) Both B and C</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio32" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">



					<label for="radio33" class="form-control">33. Obtaining
						specified information to ensure that a customer is who (s) he says
						(s) he is... </label> <br>

					<div class="radio">
						<input type="radio" name="radio33" id="radio129" class="radio"
							value="a" /> <label for="radio129"> a) Compliance.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio33" id="radio130" class="radio"
							value="b" /> <label for="radio130"> b) Customer
							identification.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio33" id="radio131" class="radio"
							value="c" /> <label for="radio131">c) Customer
							verification.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio33" id="radio132" class="radio"
							value="d" /> <label for="radio132">d) Both B and C</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio33" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio34" class="form-control">34. The bank may
						on suspicion of a money laundering transaction: </label> <br>

					<div class="radio">
						<input type="radio" name="radio34" id="radio133" class="radio"
							value="a" /> <label for="radio133">a) Freeze the account
							and confiscate the proceeds of crime.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio34" id="radio134" class="radio"
							value="b" /> <label for="radio134"> b) Investigate the
							customer right on the spot and inform him / her of their
							suspicion.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio34" id="radio135" class="radio"
							value="c" /> <label for="radio135">c) Continue with the
							transaction in the normal way and take no action.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio34" id="radio136" class="radio"
							value="d" /> <label for="radio136">d) Report the
							transaction through the normal channels even though you are not
							certain about it.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio34" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">




					<label for="radio35" class="form-control">35. The Money
						laundering Act, 2011 protect persons reporting on suspicious
						transaction provided: </label> <br>

					<div class="radio">
						<input type="radio" name="radio35" id="radio137" class="radio"
							value="a" /> <label for="radio137">a) The reporting was
							done in good faith.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio35" id="radio138" class="radio"
							value="b" /> <label for="radio138"> b) The reporting was
							done after a failed transaction with the criminal.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio35" id="radio139" class="radio"
							value="c" /> <label for="radio139">c) You are about to
							be exposed in the whole money laundering syndicate.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio35" id="radio140" class="radio"
							value="d" /> <label for="radio140">d) You have repented
							from your sins.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio35" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">






					<label for="radio36" class="form-control">36. Which of the
						following is not true? </label> <br>

					<div class="radio">
						<input type="radio" name="radio36" id="radio141" class="radio"
							value="a" /> <label for="radio141">a) Knowledge,
							training, skill and expertise are factors which affect an
							employee’s ability to identify suspicious transactions.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio36" id="radio142" class="radio" />
						<label for="radio142">b) If an employee knows that a
							co-worker was bribed not to submit a particular transaction, the
							employee must submit such report.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio36" id="radio143" class="radio"
							value="c" /> <label for="radio143">c) Employees are
							required to report all bank transactions they think are
							suspicious.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio36" id="radio144" class="radio"
							value="d" /> <label for="radio144">d) An employee is
							required to correctly identify the crimes that generated the
							particular illicit proceeds.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio36" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">




					<label for="radio37" class="form-control">37. In terms of
						the Money Laundering Act 2011, if you submit a suspicious and
						unusual transaction report you will…… </label> <br>

					<div class="radio">
						<input type="radio" name="radio37" id="radio145" class="radio"
							value="a" /> <label for="radio145"> a) Have to testify
							at a trial</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio37" id="radio146" class="radio"
							value="b" /> <label for="radio146">b) Be criminally
							liable </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio37" id="radio147" class="radio" />
						<label for="radio147">c) Have to inform the customer about
							the report</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio37" id="radio148" class="radio"
							value="d" /> <label for="radio148">d) None of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio37" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio38" class="form-control">38. Which of the
						following statement(s) are incorrect? </label> <br>

					<div class="radio">
						<input type="radio" name="radio38" id="radio149" class="radio"
							value="a" /> <label for="radio149">a) A bank teller must
							not continue to carry out a transaction if it is going to be
							reported.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio38" id="radio150" class="radio"
							value="b" /> <label for="radio150">b) The bank teller
							who is going to make a report must not discuss the intention to
							do so with anyone unless the disclosure is required or allowed by
							law.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio38" id="radio151" class="radio"
							value="c" /> <label for="radio151">c) The customer must
							not know that a suspicious transaction report is going to be
							filed.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio38" id="radio152" class="radio"
							value="d" /> <label for="radio152">d) The customer may
							continue to conclude transactions at the bank after a report has
							been sent to CBS.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio38" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio39" class="form-control">39. While
						performing your daily banking duties you notice that an account
						shows an unnecessarily large international transfer of money.
						Within hours the sum of money is again transferred to another
						country. What do you do? </label> <br>

					<div class="radio">
						<input type="radio" name="radio39" id="radio153" class="radio"
							value="a" /> <label for="radio153">a) Report the
							transaction in terms of AML (Prevention) Act, 2011.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio39" id="radio154" class="radio"
							value="b" /> <label for="radio154">b) Complete the
							appropriate internal fraud prevention forms.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio39" id="radio155" class="radio"
							value="c" /> <label for="radio155">c) Inform the police
							fraud squad (OSSU). </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio39" id="radio156" class="radio"
							value="d" /> <label for="radio156">d) Consult with
							colleagues outside office hours.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio39" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">




					<label for="radio40" class="form-control">40. A transaction
						would be said to have “no business sense” if ... </label> <br>

					<div class="radio">
						<input type="radio" name="radio40" id="radio157" class="radio"
							value="a" /> <label for="radio157">a) The customer
							deposits amounts of money and withdraws it immediately or
							transfers it to other accounts that he controls for no apparent
							reason.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio40" id="radio158" class="radio"
							value="b" /> <label for="radio158"> b) The amounts are
							transferred to and from accounts controlled by the customer for
							no apparent reason. </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio40" id="radio159" class="radio"
							value="c" /> <label for="radio159">c) The customer does
							not wish to use normal banking facilities, for instance s(he)
							avoids high interest facilities for large balances even though
							the customer is aware of these facilities and they suit his/ her
							needs better.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio40" id="radio160" class="radio"
							value="d" /> <label for="radio160">d) All of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio40" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio41" class="form-control">41. Ongoing
						monitoring of accounts and transactions is vital to the success of
						an anti-money laundering strategy. Which of the following types of
						transactions should be monitored? </label> <br>

					<div class="radio">
						<input type="radio" name="radio41" id="radio161" class="radio"
							value="a" /> <label for="radio161">a) Transactions that
							have no sound business basis.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio41" id="radio162" class="radio"
							value="b" /> <label for="radio162"> b) Transactions of
							high-risk clients.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio41" id="radio163" class="radio"
							value="c" /> <label for="radio163"> c) Transactions that
							are abnormal compared to the usual pattern of activity on an
							account. </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio41" id="radio164" class="radio"
							value="d" /> <label for="radio164">d) All of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio41" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">




					<label for="radio42" class="form-control">42. Before you
						supply information about a customer to any police official or
						other external investigator, you must ….. </label> <br>

					<div class="radio">
						<input type="radio" name="radio42" id="radio165" class="radio"
							value="a" /> <label for="radio165">a) Contact the MLCO
							to check if you are allowed to give those details.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio42" id="radio166" class="radio"
							value="b" /> <label for="radio166">b) Contact the
							particular customer and inform him/ her about the request for
							information.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio42" id="radio167" class="radio"
							value="c" /> <label for="radio167">c) Obtain permission
							from the Central Bank of Swaziland.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio42" id="radio168" class="radio"
							value="d" /> <label for="radio168">d) Confirm with the
							Commissioner of Police.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio42" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">




					<label for="radio43" class="form-control">43. A customer is
						suing the bank because he claims the bank broke its secrecy code
						by handing over information to law enforcement agencies. The bank
						was acting under the AML (Prevention) Act, 2001 and a High Court
						order. What are his chances of winning the case? </label> <br>

					<div class="radio">
						<input type="radio" name="radio43" id="radio169" class="radio"
							value="a" /> <label for="radio169">a) Extremely high.
							The legislation favours those under the presumption of being
							innocent until proven guilty.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio43" id="radio170" class="radio"
							value="b" /> <label for="radio170"> b) Good. The bank
							should have respected the confidentiality of his account
							information.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio43" id="radio171" class="radio"
							value="c" /> <label for="radio171">c) Bad. The AML Act,
							2001, supersedes any other secrecy legislation.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio43" id="radio172" class="radio"
							value="d" /> <label for="radio172">d) Poor. The AML Act,
							2001 only supersedes legislation pertaining to serious criminal
							offences.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio43" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio44" class="form-control">44. Proper
						records should be kept by financial institutions……. </label> <br>

					<div class="radio">
						<input type="radio" name="radio44" id="radio173" class="radio"
							value="a" /> <label for="radio173">a) Because the law
							requires them to do so.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio44" id="radio174" class="radio"
							value="b" /> <label for="radio174">b) As future proof of
							market share. </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio44" id="radio175" class="radio"
							value="c" /> <label for="radio175">c) To provide audit
							trail for all funds and evidence for the law enforcement agencies
							in their investigations.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio44" id="radio176" class="radio"
							value="d" /> <label for="radio176">d) None of the above.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio44" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">



					<label for="radio45" class="form-control">45. According to
						KYC Circular 1/2013, which accounts comply with a National ID
						only.</label> <br>

					<div class="radio">
						<input type="radio" name="radio45" id="radio177" class="radio"
							value="a" /> <label for="radio177">a) Accounts with
							turnover above E5,000.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio45" id="radio178" class="radio"
							value="b" /> <label for="radio178"> b) Accounts with a
							turnover less than E25,000. </label>
					</div>

					<div class="radio">
						<input type="radio" name="radio45" id="radio179" class="radio"
							value="c" /> <label for="radio179">c) Accounts with
							turnover less than E5,000</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio45" id="radio180" class="radio"
							value="d" /> <label for="radio180">d) None of the above</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio45" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">



					<label for="radio46" class="form-control"> 46. What does
						PEP stands for? </label> <br>

					<div class="radio">
						<input type="radio" name="radio46" id="radio181" class="radio"
							value="a" /> <label for="radio181">a) Politically
							Exposed Persons</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio46" id="radio182" class="radio"
							value="b" /> <label for="radio182">b) Professionally
							Exposed Persons</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio46" id="radio183" class="radio"
							value="c" /> <label for="radio183">c) Points Externally
							Prepared</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio46" id="radio184" class="radio"
							value="d" /> <label for="radio184">d) None of the above</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio46" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">






					<label for="radio47" class="form-control">47. Why is it
						necessary to do customer due diligence (CDD)? </label> <br>

					<div class="radio">
						<input type="radio" name="radio47" id="radio185" class="radio"
							value="a" /> <label for="radio185"> a) Identifying the
							customer and verifying that customer’s identity using reliable,
							independent source documents, data or information.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio47" id="radio186" class="radio"
							value="b" /> <label for="radio186">(b) Identifying the
							beneficial owner, and taking reasonable measures to verify the
							identity of the beneficial owner, such that the financial
							institution is satisfied that it knows who the beneficial owner
							is. For legal persons and arrangements this should include
							financial institutions understanding the ownership and control
							structure of the customer.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio47" id="radio187" class="radio"
							value="c" /> <label for="radio187">(c) Understanding
							and, as appropriate, obtaining information on the purpose and
							intended nature of the business relationship.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio47" id="radio188" class="radio"
							value="d" /> <label for="radio188">d) All of the above</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio47" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio48" class="form-control">48. What is the
						difference between a sanctioned individual and a PEP?</label> <br>

					<div class="radio">
						<input type="radio" name="radio48" id="radio189" class="radio"
							value="a" /> <label for="radio189">a) Both clients can
							be banked by any financial institution</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio48" id="radio190" class="radio"
							value="b" /> <label for="radio190">b) PEP’s are
							politically exposed persons and they cannot be banked whilst
							sanctioned individuals can be banked.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio48" id="radio191" class="radio"
							value="c" /> <label for="radio191">c) PEP’s are
							politically exposed persons they have high influence coming to
							money laundering we can bank them but they are high risk they
							need monitoring and sanctioned individuals have influence to
							finance terrorism and cannot be banked.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio48" id="radio192" class="radio"
							value="d" /> <label for="radio192">d) Both PEP’s and
							sanctioned individuals cannot be banked because they facilitate
							money laundering and terrorist financing</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio48" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">




					<label for="radio49" class="form-control">49. What do you
						do if you identify an unusual or suspicious transaction? </label> <br>

					<div class="radio">
						<input type="radio" name="radio49" id="radio193" class="radio"
							value="a" /> <label for="radio193">a) Proceed with the
							transaction and report a suspicious transaction to risk and
							compliance by filling a form from intranet and give reason for
							suspicion.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio49" id="radio194" class="radio"
							value="b" /> <label for="radio194"> b) Tell manager
							about your suspicion and get a form from intranet to report
							suspicious transaction then send to Risk and compliance.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio49" id="radio195" class="radio"
							value="c" /> <label for="radio195"> c) Tell colleagues
							to assist you with reporting of the suspicious transaction.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio49" id="radio196" class="radio"
							value="d" /> <label for="radio196">d) Tell customer
							about your suspicion and then report a suspicious transaction to
							risk and compliance.</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio49" value="e" checked
							style="visibility: hidden;" />
					</div>
				</div>
				<div class="form-group">





					<label for="radio50" class="form-control">50. What do you
						do if a customer alert is generated as sanctioned individual from
						world check?</label> <br>

					<div class="radio">
						<input type="radio" name="radio50" id="radio197" class="radio"
							value="a" /> <label for="radio197">a) Procced with the
							transaction</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio50" id="radio198" class="radio"
							value="b" /> <label for="radio198">b) Report to the
							branch manager</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio50" id="radio199" class="radio"
							value="c" /> <label for="radio199"> c) Report to the
							branch manager who will then escalate to risk and compliance for
							further screening, if the match is positive then they exit
							customer.</label>
					</div>

					<div class="radio">
						<input type="radio" name="radio50" id="radio200" class="radio"
							value="d" /> <label for="radio200">d) Exit customer with
							immediate effect</label>
					</div>
					<div class="radio">
						<input type="radio" name="radio50" value="e" checked
							style="visibility: hidden;" />
					</div>



					<div class="button">
						<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
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
