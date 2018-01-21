<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Admin</title>

   <style>body{background-size: cover;}  
   .search{
    background-color: black;
    border: none;
    color: white;
    padding: 8px 22px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
 } a{text-decoration: none;color:black;}</style>
</head>
<body align="center" background="Images/17.jpg">
<h2 class="welcome">logged in: ${loginDTO.username}</h2>
<form action="search.toll" method="post" name="searchForm" onsubmit="return validateForm()">
<table cellspacing="20" align="center">
<tr>
<td><h1>Username</h1> </td><td>:<input type="text" name="username"/></td>
</tr>
<tr>
<td><h1>Email</h1></td><td>:<input type="text" name="email"/></td>
</tr>
<tr>
<td><h1>TollBooth Name</h1></td><td>:<select name="tollname">
<option disabled="disabled">Select Toll</option> <option>Nelamangala</option> <option>Kunigal</option>  <option>KB Cross</option><option>Hosakerehalli</option></select></td>
</tr>
</table>
<pre>
<input type="submit" value="Search" class="search"/>  <input type="reset" value="Clear" class="search"/>
</pre>
</form>
<br>
<h1><a href="superAdminHome.jsp">Home</a></h1>
</body>
</html>