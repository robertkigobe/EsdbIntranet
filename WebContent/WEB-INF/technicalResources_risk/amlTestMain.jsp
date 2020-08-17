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

		<div style="margin-left: 50px">



			<div >
				<form action=AmlTestMain method="post">
					<TABLE >
						<TBODY>
							<TR style="margin: 50px;">
								<TD >AML TEST<BR><BR></TD>
							</TR>
							<tr style="margin: 50px;">
								<td colspan="1"><input type="submit"
									value="CLICK HERE TO START THE TEST" size="50" /><BR><BR></td>
							</tr>

							<TR style="margin: 50px;">
								<TD class=page_header_green>OBJECTIVE: <BR></TD>
							</TR>
							<TR style="margin: 50px;">
								<TD>
									<p class="MsoNormal"
										style="text-align: justify; font-size: 12.0pt; font-family:"TimesNewRoman";">The
										Bank is operating in an environment where it is expected to
										comply with different legislations. One of these legislations
										is the Money Laundering / Terrorist Finance Act
										(Prevention),2011. It is important for the Bank’s staff
										members to be trained on this legislation and be made aware of
										what is expected of them. The manner in which we conduct our
										business has a massive impact on the Bank's reputation. Our
										reputation of trust and integrity can be damaged if we do not
										adhere to the actions that are required of us by regulator
										every day as we go about our daily work. During the course of
										the year all Staff Members are required to complete training
										on Anti-Money Laundering and Terrorist Financing according to
										regulator guidelines.</p> <br> <br> <BR><br> <br> <BR><br> <br> <BR>
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