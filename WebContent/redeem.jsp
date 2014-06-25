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
<jsp:include page="/header.jsp"></jsp:include>


<script type="text/javascript">
	function key() {
		window.open("http://localhost:8081/AMC_PORTAL/key_information.jsp", "",
				"width=500,height=200");
	}
	function offer() {
		window.open("http://localhost:8081/AMC_PORTAL/offer.jsp", "",
				"width=500,height=200");
	}
	function disclaimer() {
		window.open("http://localhost:8081/AMC_PORTAL/disclaimer.jsp", "",
				"width=500,height=200");
	}
	function disclaimer5() {
		if (document.getElementById("disclaimerValue").checked) {
			document.forms[0].submit();
		}else{
			$('#disclaimerCheck').val("error");
		}
	}

	function displayCurrentRate() {
		var e = document.getElementById("companyName");
		var strUser = e.options[e.selectedIndex].text;			
		$.ajax( {
			url : 'stockValue.jsp?companyName=' + strUser,
			dataType : "html",
			cache : false,
			data : strUser,
			ajax : true,
			success : function(responseHtml) {
			
				$('.valueOfStock').html(responseHtml);
			},
			error : function() {
				alert("error");
			}
		});

	}
	$(document).ready(function(){
		var e = document.getElementById("companyName");
		alert(e);
		var strUser = e.options[0].text;
		alert(strUser);			
		$.ajax({
			url : 'stockValue.jsp?companyName=' + strUser,
			dataType : "html",
			cache : false,
			data : strUser,
			ajax : true,
			success : function(responseHtml) {
			
				$('.valueOfStock').html(responseHtml);
			},
			error : function() {
				alert("error");
			}
		});	
	});
</script>


<html:html>
<html:body bgcolor="#ECBE6C">
	<html:form action="/login/actionBuySell">
		<div id="header" style="border-bottom: 2px solid #E46924;">
		<h2 style="color: red;">MAKE A TRANSACTION - Additional Purchase</h2>
		</div>
<input id="disclaimerCheck" type="hidden" name="disclaimerCheck">

		<table border="2px" style="width: 50%;">
			<tr>
				<td colspan="2" style="background-color: rgb(255, 92, 0);">
				<h3 style="color: black;">Applicant Details</h3>
				</td>
			</tr>
			<tr>
				<td>Folio No</td>
				<td><%=request.getSession().getAttribute("folioId")%></td>
			</tr>
			<tr>
				<td>Name of the First Applicant</td>
				<td><%=request.getSession().getAttribute("name")%></td>
			</tr>
		</table>
		</br>
<%
System.out.println("VALLALSLA:"+session.getAttribute("errorMessage"));
if(session.getAttribute("errorMessage")!=null) {%>
	<div id=errorText" style="font-size: 21px;margin-left: 43px;color: rgb(51, 0, 255);">	
	Error: Please Check the Disclaimer to Proceed Purchasing Shares</div>
<%
session.removeAttribute("errorMessage");
}%>
		<table border="2px" style="width: 50%;">
			<tr>
				<td colspan="2" style="background-color: rgb(255, 92, 0);">
				<h3 style="color: black;">Investment Details</h3>
				</td>
			</tr>
			<tr>
				<td style="width: 15%">Action:</td>
				<td><select name="action">
					<option>Sell</option>
				</select></td>
			</tr>
			<tr>
				<td style="width: 15%">Stock:</td>
				<td><select id="companyName" name="companyName"
					onchange="javascript:displayCurrentRate();">
					<%
					
						DBConnectivity dbc = new DBConnectivity();
						String fid=request.getSession().getAttribute("folioId").toString();
						String abc[] = (String[])dbc.getTransactionCompanyInfo(fid);
							int i = 0;
									for (i = 0; i < abc.length && abc[i] != null; i++) {
					%>
					<option id="company"><%=abc[i]%></option>
					<%
						}
					%>

				</select> <%=new java.util.Date()%>
				<div class="valueOfStock" style="margin-top: 9px;">
				</div>
				</td>
			</tr>
			<tr>
				<td style="width: 15%">Quantity:</td>
				<td><input type="text" style="width: 50px" maxlength="3"
					name="quantity"></td>
			</tr>
		</table>
		<table border="2px" style="width: 50%;">
			<tr>
				<td colspan="2" style="background-color: rgb(255, 92, 0);"><input
					type="checkbox" name="disclaimer" id="disclaimerValue" /> Yes, I
				have read the <a href="javascript:key();">Key Information
				Memoradum</a>,<a href="javascript:offer();">Offer document</a> and <a
					href="javascript:disclaimer();">Disclaimer</a> for the scheme in
				which i am investing.</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SELL" onclick="disclaimer5();" > &nbsp;&nbsp;&nbsp;&nbsp; <a
					href="">RESET</a></td>
			</tr>
		</table>
	</html:form>
</html:body>
</html:html>
