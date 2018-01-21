<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchResults</title>
<style type="text/css">a{text-decoration: none;color:black;}</style>
</head>
<body align="center">

<h1>Search Results</h1>
<br>
<table border="2" align="center">
<tr>
<th>Sl no</th>
<th>Username</th>
<th>Email</th>
<th>Contact number</th>
<th>Toll Name</th>
</tr>
<c:forEach items="${list}" var="admins">
<tr>
<td>${admins.id}</td>
<td>${admins.username}</td>
<td>${admins.email}</td>
<td>${admins.contactNum}</td>
<td>${admins.tollbooth_name}</td>
</tr>
</c:forEach>
</table>
<br>
<h2><a href="superAdminHome.jsp">Home</a></h2>
</body>
</html>