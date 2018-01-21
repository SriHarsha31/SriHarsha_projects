<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
body
 {background-size:cover;}

 a{text-decoration: none; color: black;}
.welcome{padding-left: 25px;}

.logout{
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
 }
 
 .a1{padding-left: 1300px;}

</style>
</head>
<body background="Images/4.jpg" >
<marquee><h1>Welcome To Toll Management System  </h1></marquee>

<h2 class="welcome">Hello ${loginDTO.username}</h2><form action="logout.toll" method="post"><p class="a1" ><input type="submit" value="Logout" class="logout"/></p></form>
<ol>
<label><h2>Contents</h2></label>
   
<li><h3><a href="Billing.jsp">Billing</a></h3></li>   
<li><h3><a href="ChangePassword.jsp">Change Password</a></h3></li>
<li><h3><a href="Update.jsp">Update Details</a></h3></li>
</ol>
 
 
<pre>        ${msg}  </pre> 
</body>
</html>