<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing Details</title>
<script>

   function validateForm() {
    var x = document.forms["billingForm"]["vehicleType"].value;
    if (x == "") {
        alert("Enter vehicleType");
        return false;
    }

	var x = document.forms["billingForm"]["vehicleNumber"].value;
    if (x == "") {
        alert("Enter vehicleNumber");
        return false;
    }

	var x = document.forms["billingForm"]["way"].value;
    if (x == "") {
        alert("Enter way");
        return false;
    }
    
    var x = document.forms["billingForm"]["amount"].value;
    if (x == "") {
        alert("Enter amount");
        return false;
    }
   }

</script>
<style type="text/css">a{text-decoration: none; color:black;}</style>
</head>
<img alt="" src="Images/18.jpg">
<body align="center">
<h2 class="welcome">logged in: ${loginDTO.username}</h2>
<form action="billing.toll" method="post" name="billingForm" onsubmit="return validateForm()">

<table align="center" cellspacing="25">
<tr>
<td>vehicleType</td><td>:<Select name="vehicleType"><option>Select vehicleType</option><option>LM-4Wheeler</option><option>LM-2Wheeler</option><option>HM-4Wheeler</option></Select></td>
</tr>
<tr>
<td>vehicleNumber</td><td>:<input type="text" name="vehicleNumber"></td>
</tr>
<tr>
<td>way</td><td>:<select name="way"><option>Select</option><option>1-Way</option><option>2-Way</option></select></td>
</tr>
<tr>
<td>Time</td><td>:<input type="date" name="time" disabled="disabled"></td>
</tr>
<tr>
<td>amount</td><td>:<select name="amount" ><option>50</option><option>30</option></select></td>
</tr>
</table>
<pre>
<input type="submit" value="Generate Bill">  <input type="reset" value="Clear">
</pre>
</form>
<br>
<a href="AdminHome.jsp"><b>Home</b></a>
</body>
</html>