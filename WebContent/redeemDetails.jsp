<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page import="com.amc.db.DBConnectivity"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<script src="jquery-1.7.2.min.js"></script>


<script type="text/javascript">

</script>

<html:html>
<html:body bgcolor="green">
<html:form action="/final/redeem">
<table>
<tbody>

<div id="image" style="background-color: #0052FF;"><img
	src="AMC2.JPG" />
<h1 style="padding-left: 400px; color: #FF003D; margin-top: -38px;">Welcome
to AMC Payment Gateway <input type="button" value="LOGOUT" align="right"
	style="margin-left: 227px;" onClick=
	JavaScript:
	;
;
window.location='logon.jsp';;></h1>
</div>

		<tr>
			<td width="170" align="left" valign="top" class="label">
			<div class="floatl">Folio ID <span class="red">:</span>&nbsp;&nbsp;</div>
	    	</td>
	    	<td width="170" align="left" valign="top" class="label">
			<div class="floatl">AXABBE22<span class="red"></span>&nbsp;&nbsp;</div>
	    	</td>
	</tr>
	<tr>
			<td width="170" align="left" valign="top" class="label">
			<div class="floatl">Company <span class="red">:</span>&nbsp;&nbsp;</div>
	    	</td>
	    	<td width="170" align="left" valign="top" class="label">
			<div class="floatl">AXABBE22<span class="red"></span>&nbsp;&nbsp;</div>
	    	</td>
	</tr>
		
	<tr>
			<td width="170" align="left" valign="top" class="label">
			<div class="floatl">Number of Shares <span class="red">:</span>&nbsp;&nbsp;</div>
	    	</td>
	    	<td width="170" align="left" valign="top" class="label">
			<div class="floatl">AXABBE22<span class="red"></span>&nbsp;&nbsp;</div>
	    	</td>
	</tr>
<tr>
			<td width="170" align="left" valign="top" class="label">
			<div class="floatl">Redeem Amount <span class="red">:</span>&nbsp;&nbsp;</div>
	    	</td>
	    	<td width="170" align="left" valign="top" class="label">
			<div class="floatl">AXABBE22<span class="red"></span>&nbsp;&nbsp;</div>
	    	</td>
	</tr>
<tr>
	<td colspan="2" valign="middle"><input name="paynow" type="submit" style="width:145px" src="pay_button_new.gif"></td>     
</tr>	
</tbody>
</table>
</html:form>
</html:body>
</html:html>