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
<html:form action="/final/purchase">

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
<table width="100%" border="0" align="left" cellpadding="0"
	cellspacing="0" bgcolor="#FFFFFF">

	<tbody>
		<tr>

			<td width="9" height="27" align="center" valign="middle"></td>

			<td align="left" valign="middle" class="tableHeader text11"><span
				class="text14">Payment Information</span> (Please enter your card
			details to authorise this transaction...)</td>

			<td></td>

		</tr>
		<tr>

			<td class="tableBorderLeft">&nbsp;</td>

			<td valign="top"></td>
		</tr>
	</tbody>

</table>

<table width="100%" border="0" cellpadding="3" cellspacing="0">

	<tbody>
		<tr>

			<td colspan="3" align="left" class="description"></td>
		</tr>
		<tr>

			<td width="170" align="left" valign="top" class="label">
			<div class="floatl">Card Number <span class="red">*</span>&nbsp;&nbsp;</div>

		

			<!--<div class="floatl"><img src="bank/images/visa.gif" alt="Visa Card" width="37" height="23"><img src="bank/images/mastercard.gif" alt="MasterCard" width="37" height="23"> </div>--></td>

			<td width="282" align="left" valign="top"><input id="cnumber"
				name="cnumber" type="text" class="textbox cardno_textbox"
				value="Please enter your card number without any spaces"
				maxlength="19" style="width: 280px;"
				onblur="if(this.value=='')this.value=this.defaultValue;"
				onfocus="if(this.value==this.defaultValue)this.value='';"
				autocomplete="OFF">
	</td>
	</tr>
	
		<tr>

			<td align="left" valign="top" class="label">Name on Card<span
				class="red">*</span></td>

			<td><input name="cname2" type="text"
				class="textbox cardno_textbox"
				value="Please enter your name specified on the card" id="cname2"
				maxlength="50" style="width: 280px;"
				onblur="if(this.value=='')this.value=this.defaultValue;"
				onfocus="if(this.value==this.defaultValue)this.value='';"
				autocomplete="OFF"></td>

			<td>&nbsp;</td>
		</tr>
		<tr id="VMExpDate">

       <td align="left" valign="top" class="label">Expiry Date<span class="red">*</span></td>

       <td><select name="expmon" class="selectbox" id="expmon">

         <option value="0">MM</option>

<option value="01" selected="">01</option>

<option value="02">02</option>

<option value="03">03</option>

<option value="04">04</option>

<option value="05">05</option>

<option value="06">06</option>

<option value="07">07</option>

<option value="08">08</option>

<option value="09">09</option>

<option value="10">10</option>

<option value="11">11</option>

<option value="12">12</option>

       </select>

       

         <select name="expyr" class="selectbox" id="expyr">

           <option value="0">YYYY</option>



            <option value="2012" selected="">2012</option>

            <option value="2013">2013</option>

            <option value="2014">2014</option>

            <option value="2015">2015</option>

            <option value="2016">2016</option>

            <option value="2017">2017</option>

            <option value="2018">2018</option>

            <option value="2019">2019</option>

            <option value="2020">2020</option>

            <option value="2021">2021</option>

            <option value="2022">2022</option>

            <option value="2023">2023</option>

            <option value="2024">2024</option>

            <option value="2025">2025</option>

            <option value="2026">2026</option>

            <option value="2027">2027</option>

            <option value="2028">2028</option>

            <option value="2029">2029</option>

            <option value="2030">2030</option>
                 </select></td>

       <td>&nbsp;</td>
     </tr>
     <tr id="VMCVV">

       <td align="left" valign="top" class="label">CVV2/CVC2 Number <span class="red">*</span></td>

       <td align="left" valign="top">

       <div class="floatl"><input name="cvv2" type="password" id="cvv2" maxlength="3" clas="textbox" style="width:45px; border:1px solid #cccccc;" autocomplete="OFF"></div>
     </td>
     </tr>
	<tr>

       <td><input name="image" type="image" style="width:95px;"  src="cancel_button_new.gif" alt="Cancel"></td>

       <td colspan="2" valign="middle"><input name="paynow" type="submit" style="width:145px" src="pay_button_new.gif"></td>
       </tr>     
</tbody>
</table>
</html:form>
</html:body>
</html:html>