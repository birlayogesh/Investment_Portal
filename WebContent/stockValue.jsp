<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@page import="java.io.FileReader"%>
<%@page import="au.com.bytecode.opencsv.CSVReader"%>
<%@page import="com.amc.db.DBConnectivity"%>
<%@page import="java.io.*"%>
<%@page import="com.amc.utility.ReadCSVUtility"%>
<script src="jquery-1.7.2.min.js"></script>

<%

String companyName=request.getParameter("companyName");
DBConnectivity dbct = new DBConnectivity();
String cmp_id = dbct.getCompanyId(companyName);
System.out.println("COMPANY IS::::"+cmp_id);
ReadCSVUtility rcvu=new ReadCSVUtility();
rcvu.fileUrl(cmp_id,request);
//FILE FINDER API	
%>




<div class="RealTimeValue" style="margin-top: 9px;color: rgb(5, 59, 173);">Current Stock Value&nbsp;:<%=request.getAttribute("realTimeValue")%>
</div>

<%if(request.getAttribute("add").equals("profit")){%>
<div style="margin-left: 281px;margin-top: -21px;color: green;
font-size: 20px;">
<img src="up_g.gif"/>
</div>
<div class="image" style="margin-top: -15px;
margin-left: 285px;
font-size: 20px;
color: green;">
&nbsp;&nbsp;<%=request.getAttribute("valueChange")%>
</div>
<%}else{ %>
<div style="margin-left: 281px;margin-top: -21px;color: green;
font-size: 20px;">
<img src="down_r.gif"/>
</div>
<div class="image" style="margin-top: -15px;
margin-left: 285px;
font-size: 20px;
color: red">
&nbsp;&nbsp;<%=request.getAttribute("valueChange")%>
</div>


<%} %>
<div class="Exchange" style="margin-top: 9px;color: rgb(5, 59, 173);">Stock Exchange&nbsp;:<%=request.getAttribute("stockExchange")%>
</div>
<div class="dLow" style="margin-top: 9px;color: rgb(5, 59, 173);">Day's Low &nbsp;:<%=request.getAttribute("daysLow")%>
</div>
<div class="dHigh" style="margin-top: -19px;
margin-left: 301px;color: rgb(5, 59, 173);">Day's High &nbsp;:<%=request.getAttribute("daysHigh")%>
</div>
<div class="oValue" style="margin-top: 9px;color: rgb(5, 59, 173);">Opening Value &nbsp;:<%=request.getAttribute("openingValue")%>
</div>
<div class="pClose" style="margin-top: -20px;
margin-left: 301px;color: rgb(5, 59, 173);">Previous Day Close &nbsp;:<%=request.getAttribute("previousClose")%>
</div>