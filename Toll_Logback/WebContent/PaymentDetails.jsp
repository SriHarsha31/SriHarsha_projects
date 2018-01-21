<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PaymentDetails</title>
<style type="text/css">a{text-decoration: none; color:black;}</style>
</head>
<body align="center">
<table cellspacing="30" align="center">
<tr>
<td>vehicleType:</td><td><c:out value="${bill.vehicleType}"></c:out></td>
</tr>
<tr>
<td>vehicleNumber:</td><td><c:out value="${bill.vehicleNumber}"></c:out></td>
</tr>
<tr>
<td>way:</td><td><c:out value="${bill.way}"></c:out></td>
</tr>
<tr>
<td>time:</td><td><c:out value="${bill.time}"></c:out></td>
</tr>
<tr>
<td>Amount:</td><td><c:out value="${bill.amount}"></c:out></td>
</tr>
</table>
<br>
<h2><a href="AdminHome.jsp">Home</a></h2>
</body>
</html>