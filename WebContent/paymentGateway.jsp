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
function paymodeDisplay()
{
		
										
			for (var i=0; i < document.Form1.paymode.length; i++)
		   {
			   if (document.Form1.paymode[i].checked)
				{
				  var rad_val = document.Form1.paymode[i].value;
				}
		   }

		document.getElementById("divSuccessMessage").style.visibility='hidden';
		document.getElementById("divSuccessMessage").innerHTML ="";

			if(rad_val=="CREDIT")
	{
		document.getElementById("divSuccessMessage").style.visibility='visible';
		document.getElementById("divSuccessMessage").innerHTML ='<div id="netbanking" class="columntext w100p"> <div class="w100p" style="margin-top:6px;margin-bottom:8px;"><strong>Please select your Credit Card and click on "Submit":</strong></div> <div class="floatl w33p"><input type="radio" name="txtBankID1" value="AEC" checked> HDFC VISA </div><div class="floatl w33p"><input type="radio" name="txtBankID1" value="AM2">ICICI CC</div><br clear="all"> </div>';		
	}
			
			if (rad_val=="DEBIT")
			{
		document.getElementById("divSuccessMessage").style.visibility='visible';
		document.getElementById("divSuccessMessage").innerHTML =
		'<div id="netbanking" class="columntext w100p"><div class="w100p" style="margin-top:6px;margin-bottom:2px;" ><strong>Pay using your Visa Debit Card</strong></div><div class="floatl w33p"><label><input  type="radio" value="SPD" name="txtBankID1" checked/>Andhra Bank</label></div><div class="floatl w33p"><label><input  type="radio" value="SPD" name="txtBankID1"/>Axis Bank</label></div></div>';
			}
}		
	</script>
	
<html>
<body bgcolor="green">
<div id="image" style="background-color:#0052FF;">
<img src="AMC2.JPG"/>
<h1 style="padding-left: 400px;color:#FF003D;margin-top: -38px;">Welcome to AMC Payment Gateway
<input type="button" value="LOGOUT" align="right" style="margin-left: 227px;" onClick="JavaScript:window.location='logon.jsp';">
</h1>
</div>	
<form name="Form1" action="/login/finalPurchase">
              <table width="100%" border="0" cellspacing="0" cellpadding="3" style="text-align:left;">
                <tbody><tr> 
                  <td height="10">Folio Number</td>
                  <td height="10">:</td>
                  <td width="79%" height="10" align="left"> 
      			<%=request.getSession().getAttribute("folioId")%>
                    <br></td>
                </tr>
                <tr> 
                  <td height="10">Amount (Rs. Ps.)</td>
                  <td height="10">:</td>
                  <td height="10" align="left"><strong> 
                    20
                    </strong></td>
                </tr>
                <tr> 
                  <td width="20%" height="10"><label>Payment opton</label></td>
                  <td width="1%" height="10">:</td>
                  <td width="79%" height="10" align="left"> <input name="paymode" type="radio" value="CREDIT" onclick="paymodeDisplay()" checked="checked">
                    Credit Cards 
                    <input type="radio" value="DEBIT" name="paymode" onclick="paymodeDisplay()" >
                    Debit Cards 
                </tr>
                <tr> 
                  <td height="10" colspan="3" align="center"></td>
                </tr>
                <tr> 
                  <td height="10" colspan="3" align="center"><div id="divSuccessMessage" style="visibility: visible; text-align: left;"><div id="netbanking" class="columntext w100p"> <div class="w100p" style="margin-top:6px;margin-bottom:8px;"><strong>Please select your Credit Card and click on "Submit":</strong></div> <div class="floatl w33p"><input type="radio" name="txtBankID1" value="AEC" checked="">HDFC Visa</div><div class="floatl w33p"><input type="radio" name="txtBankID1" value="AM2">ICICI CC</div><br clear="all"> </div></div></td>
                </tr>
                <tr> 
                  <td height="10" colspan="3" align="right" valign="top">&nbsp;
                  </td>
                </tr>
              </tbody></table>
             <div id="submitButton" style="margin-left: 247px;margin-top: -15px;">  <input type="button" value="SUBMIT" onClick="JavaScript:window.location='paymentDetails.jsp';"></div>
       </form>	

</body>
</html>