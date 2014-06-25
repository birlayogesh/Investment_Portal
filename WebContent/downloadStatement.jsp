<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page import="com.amc.utility.PDFUtility"%>

<%
String folioid=request.getSession().getAttribute("folioId").toString();
PDFUtility pdfu=new PDFUtility();
pdfu.generatePDF(folioid);
%>

<script type="text/javascript">
	function key() {
		window.close();
	}
</script>
	

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Your Account Statement Has Been Downloaded.
<br></br>
Contact Customer Care for more Information.
<br></br>
<a href="javascript:key();">Close Window</a>
</body>

</html>