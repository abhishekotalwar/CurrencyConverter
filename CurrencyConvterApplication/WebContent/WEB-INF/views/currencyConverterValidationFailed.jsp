<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "co" %>

<html>
<head>
<style>
.error {
    color: #ff0000;
    font-size: 18px;
}
</style>
<title>Currency Converter</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  function disableDate() {
      if (document.getElementById("current").checked) {
    	  document.getElementById("dateValue").disabled = true;
      } else {
    	  document.getElementById("dateValue").disabled = false;
      }
 }
</script>
</head>
	<body>
		<p align="left"><a href="logout"><b>Log out</b></a></p>
		<springForm:form commandName="currencyConvertData" action="currencyconverter" method="post">
			<pre>
				    Amount               : <input type="number" name="amount"/> <springForm:errors path="amount" cssClass="error" /><br>
				    Source Currency      : <select name="sourceCurrency" id="sourceCurrency">
   											 <co:forEach items="${pageData.currencyList}" var="value">
       											<option value="${value.code}">${value.description}</option>
    										</co:forEach>
    										</select> <springForm:errors path="sourceCurrency" cssClass="error" /><br>
				    Destination Currency : <select name="destinationCurrency" id="destinationCurrency">
   											 <co:forEach items="${pageData.currencyList}" var="value">
       											<option value="${value.code}">${value.description}</option>
    										</co:forEach>
    										</select> <springForm:errors path="destinationCurrency" cssClass="error" /><br>
				    Type                 : <input type="radio" name="type" id="current" value="current" onclick="disableDate();"> Current <input type="radio" name="type" id="history" value="history" onclick="disableDate();"> History <springForm:errors path="type" cssClass="error" /><br>
				    Date                 : <input type="text" id="dateValue" name="dateValue" disabled="disabled"/>
				    			   yyyy-MM-dd<br/>
					               <input type="submit" name="submit" value="submit"/>  
			</pre>
			
			<table border="1">
				<tr>
					<th align="center">Input Amount</th>
					<th align="center">Source Currency</th>
					<th align="center">Destination Currency</th>
					<th align="center">Converted Amount</th>
					<th align="center">Type</th>
					<th align="center">Date</th>																									
				</tr>
				<co:forEach begin="0" end="9" items="${pageData.historyList}" var="value">
					<tr>

       					<td align="center">${value.amount}</td>
      					<td align="center">${value.sourceCurrency}</td>
      					<td align="center">${value.destinationCurrency}</td>
      					<td align="center">${value.convertedAmount}</td>
      					<td align="center">${value.conversionType}</td>
      					<td align="center">${value.dateValue}</td>      					      					      					      					       					

					</tr>
				</co:forEach>
			</table>
			
		</springForm:form>
	</body>
</html>	