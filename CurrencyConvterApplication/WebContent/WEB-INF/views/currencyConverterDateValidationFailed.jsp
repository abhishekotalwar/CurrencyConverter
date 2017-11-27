<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "co" %>
<html>
<head>
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
		<form action="currencyconverter" method="post">
			<pre>
				    Amount               : <input type="number" name="amount"/> <br>
				    Source Currency      : <select name="sourceCurrency" id="sourceCurrency">			    
   											 <co:forEach items="${pageData.currencyList}" var="value">
       											<option value="${value.code}">${value.description}</option>
    										</co:forEach>
    										</select><br>
				    Destination Currency : <select name="destinationCurrency" id="destinationCurrency">			    
   											 <co:forEach items="${pageData.currencyList}" var="value">
       											<option value="${value.code}">${value.description}</option>
    										</co:forEach>
    										</select><br>
				    Type                 : <input type="radio" name="type" id="current" value="current" onclick="disableDate();"> Current <input type="radio" name="type" id="history" value="history" onclick="disableDate();"> History<br>
				    Date                 : <input type="text" id="dateValue" name="dateValue" disabled="disabled"/> <font color="red">${pageData.message.dateMessage}</font>
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
			
		</form>
	</body>
</html>	