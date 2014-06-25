<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
 

<html:html>
<html:body bgcolor="rgba(29, 41, 65, 0.84)">
<html:form action="/login/welcome">
<div id="title" align="center" style="color: red;
font-size: 49px;
align: center;">WELCOME TO ASSET MANAGEMENT SYSTEM</div>
</br>


<img src="" name="Rotating" id="Rotating1" >
  <img src="" name="Rotating" id="Rotating2" >
    <img src="" name="Rotating" id="Rotating3" >
      <img src="" name="Rotating" id="Rotating4" >
    
  <script language="JavaScript">
  var ImageArr1 = new Array("642.jpg","mutual_funds.jpg","stock_prices350_4ee0e56a28c64_4f5f03ba4cc15.jpg");
  var ImageHolder1 = document.getElementById('Rotating1');
  
  var ImageArr2 = new Array("stock_prices350_4ee0e56a28c64_4f5f03ba4cc15.jpg","MoneyControl-MyTV-sc.jpg","MoneyControl-MyTV-sc.jpg");
  var ImageHolder2 = document.getElementById('Rotating2');

  var ImageArr3 = new Array("mutual_funds.jpg","stock_prices350_4ee0e56a28c64_4f5f03ba4cc15.jpg","642.jpg");
  var ImageHolder3 = document.getElementById('Rotating3');

  var ImageArr4 = new Array("MoneyControl-MyTV-sc.jpg","642.jpg","mutual_funds.jpg");
  var ImageHolder4 = document.getElementById('Rotating4');
  
  function RotateImages(whichHolder,Start)
  {
  	var a = eval("ImageArr"+whichHolder);
  	var b = eval("ImageHolder"+whichHolder);
  	if(Start>=a.length)
  		Start=0;
  	b.src = a[Start];
  	window.setTimeout("RotateImages("+whichHolder+","+(Start+1)+")",1500);
  }
  
  RotateImages(1,0);
  RotateImages(2,0);
  RotateImages(3,0);
  RotateImages(4,0);
  </script>
</br></br></br>
<html:submit>ENTER THE SYSTEM</html:submit>
</html:form>
</html:body>
</html:html>
