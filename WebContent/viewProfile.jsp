<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="com.amc.forms.LogonForm"%>
<%@page import="com.amc.db.DBConnectivity"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>

<%
	DBConnectivity dbc = new DBConnectivity();
	String folioID = request.getSession().getAttribute("folioId").toString();
	System.out.println("FOLIOD ID IN JSP:"+folioID);
	String abc[] = (String[]) dbc.getUserInfo(folioID);
	String name = null;
	String address = null;
	String emailId = null;
	String panId = null;
	int i = 0;
	name = abc[i++] + " " + abc[i++];
	address=abc[i++];
	emailId=abc[i++];
	panId=abc[i++];
%>
<jsp:include page="/header.jsp"></jsp:include>
<html:html>
<html:body bgcolor="rgb(104, 29, 216);">
	</br>
	</br>
	<div id="profile"><label for="folio" style="font-size: 34px;">Your
	Profile:</label></div>
	</br>

	<div id="Name:"><label for="folio"><b>NAME:<%=name%></b></label></div>
	</br>
	<div id="address"><label for="pin"><b>ADDRESS:<%=address%></b></label></div>
	</br>
	<div id="emailId"><label for="pin"><b>EMAIL ID :<%=emailId%></b></label></div>
	</br>
	<div id="panNum"><label for="pin"><b>PAN ID:<%=panId%></b></label></div>
	</br>
</html:body>
</html:html>