<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>


<%@ page import="com.amc.forms.LogonForm" %>


<html:html>
<html:body bgcolor="rgb(104, 29, 216);">
<html:errors/>
<html:form action="/login/submit" >
<marquee>
<div id="image">
<img src="tuchman_mitchell_86.png"/>
</div>
<div id="text">
Hi, I'm Mr Moneywiz, your personal finance advisor at AMC.</br>
I strongly recommend you to use our Portfolio Manager to track all your.
</div> 
</marquee>

<div id="logonForm" style="margin-top: 200px;background: #6B651F;width:35%">

<div id="folio" align="center">
<div id="foliotext" style="padding-left: 89px;">
        <label for="folio">FOLIO NUMBER:</label>
    </div>
        <div id="folioval" style="padding-left: 121px;">
		<input type="text"  maxlength="6" name="folioNumber"/>
		</div>	     
</div>
</br>
<span>
<div id="pin" align="center">
        <label for="pin">PIN:</label>
        <div id="pinval" style="padding-left: 121px;">
		<input type="password" maxlength="4" name="pin"/></div>
</div>
</span>
</br></br>  

<div id="submit" align="center" style="padding-left: 94px;">
<html:submit value="LOGIN" style="font-size:20px"></html:submit>
</div>
</br>

<div id="register" align="center">
<b>New User? Become a Member now!</b>
<input type="button" value="REGISTER" onClick="JavaScript:window.location='signUp.jsp';">
</div>
</div>

</html:form>
</html:body>
</html:html>

