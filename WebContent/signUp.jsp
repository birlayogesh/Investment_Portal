<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>


<%@ page import="com.amc.forms.LogonForm" %>

<script LANGUAGE="javascript">


</script>


<html:html>
<html:body bgcolor="rgb(104, 29, 216);">
<html:form action="/login/signup" >
<div id="logonForm" style="margin-top: 200px;background: #6B651F;width:35%">
<div id="firstName">
        <label for="folio">FIRST NAME:</label>
		<input type="text"  name="firstName"/>	     
</div>
</br>
<div id="lastName">
        <label for="pin">LAST NAME :</label>
		<input type="text" name="lastName"/>
</div>
</br>
<div id="address">
        <label for="pin">ADDRESS:</label>
		<input type="text" name="address"/>
</div>
</br>
<div id="emailId">
        <label for="pin">EMAIL ID  :</label>
		<input type="text" name="emailId"/>
</div>
</br>
<div id="panNum">
        <label for="pin">PAN ID:</label>
		<input type="text" name="panNum"/>
</div>
   </br>
   
<div id="submit" align="center" >   
<html:submit value="SUBMIT" style="font-size:20px;"></html:submit>
</div> 

</div>
</html:form>
</html:body>
</html:html>

