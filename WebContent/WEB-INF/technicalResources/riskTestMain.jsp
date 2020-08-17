<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="resources/css/HomeStyle.css" rel="stylesheet"
	type="text/css" />

<title>Risk Department-AML Test</title>
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

		<div style="margin-left: 50px">



			<div>
				<form action=RiskTestMain method="post">
					<TABLE>
						<TBODY>
							<TR style="margin: 50px;">
								<TD>RISK MANAGEMENT TEST 2017<BR> <BR></TD>
							</TR>
							<tr style="margin: 50px;">
								<td colspan="1"><input type="submit"
									value="CLICK HERE TO START THE TEST" size="50" /><BR> <BR></td>
							</tr>

							<TR style="margin: 50px;">
								<TD class=page_header_green>OBJECTIVE: <BR></TD>
							</TR>
							<TR style="margin: 50px;">
								<TD>
									<p class="MsoNormal"
										style="text-align: justify; font-size: 12.0pt; font-family:"TimesNewRoman";">Risk
										Management in a banking environment is of essence considering
										the different services offered. It follows therefore that
										every staff member must have a certain level of Risk
										Management understanding. This is more so because every
										activity in a Bank has an element of risk that has to be
										managed.</p>  <br>

									<p class="MsoNormal"
										style="text-align: justify; font-size: 12.0pt; font-family:"TimesNewRoman";">The
										Risk and Compliance Department has been entrusted with the
										responsibility of making sure that the culture of risk
										management in the Bank is instilled and every employee
										appreciates the risks around his/her environment. It is
										therefore important that this test is taken seriously by all
										employees. The pass mark for the test is 80%. Its aim is
										mainly to;</p> <BR> 
										<OL>
										<li>Increase risk awareness in the Bank.</li>
										<li>Encourage employees to manage risks in their environments.</li>
										<li>Make employees aware of the different Risk Management Policies like Whistle Blowing, Business Continuity, etc. </li>
										</OL>
										<br> <br> <BR> <br> <br>
									<BR>
								</TD>
							</TR>


						</TBODY>
					</TABLE>
				</form>
			</DIV>
		</div>
		<div class="clear"></div>
		<div>
			<jsp:include page="../utilities/_footer.jsp"></jsp:include>
		</div>
</body>
</html>