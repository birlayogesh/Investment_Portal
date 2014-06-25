<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="com.amc.forms.LogonForm"%>

<script type="text/javascript">
	function openWindow() {
		window.open("http://localhost:8081/AMC_PORTAL/downloadStatement.jsp",
				"", "width=500,height=200");
	}
</script>
<div id="image" style="background-color:#0052FF;">
<img src="AMC2.JPG"/>
<h1 style="padding-left: 400px;color:#FF003D;margin-top: -38px;">Welcome to Asset Management Portal</h1>
</div>

<html:html>
<link href="dropdown.css" rel="stylesheet" type="text/css">

<div id="header" style="border-bottom: 2px solid #E46924;">
<h1 style="color: blue;">MAKE A TRANSACTION</h1>
</div>

<html:body bgcolor="#ECBE6C">
	<div id="def1">
	<h3>This Section allows you to make transaction on your mutual
	fund investment account.</h3>
	</div>
	<div id="def2">
	<h3>You may choose to either switch between schemes,or, redeem
	your investment from any scheme.</h3>
	</div>
	<div id="def3">
	<h3>Please refer to offer documents read with addendum updated
	from time to time for various details such as applicable NAV/business Day/load structure/risk factors etc.
	</h3>
	</div>
	

	
	
	<ul id="nav" style="margin-left: 967px;margin-top: -170px;">
		<li><a href="invesment_home.jsp">Home</a></li>

		<li><a href="#">My Profile</a>
		<ul>
			<li><a href="viewProfile.jsp">View Profile</a></li>

			<li><a href="#">Change Pin</a></li>
		</ul>
		</li>
		<li><a href="#">Services</a>

		<ul>
			<li><a href="purchase.jsp">Purchase</a></li>
			<li><a href="redeem.jsp">Redeem</a></li>

			<li><a href="logon.jsp">Logout</a></li>
			<li><a href="javascript:openWindow();">Download Statement</a></li>
		</ul>

		</li>
	</ul>
	

</html:body>
</html:html>
