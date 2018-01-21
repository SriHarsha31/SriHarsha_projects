<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SuperAdmin</title>
<style type="text/css">body{background-size: cover;} a{text-decoration: none; color:black;} ol{padding-left: 100px;} h1{padding-left: 80px; } p{padding-left: 100px;}
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
<%-- 
 <script type="text/javascript">
 function logout(){
	 var x = document.forms["logForm"]["log"].value;
 <%
 response.setHeader("Cache-control","no-store");
 response.setHeader("Pragma","no-cache");
 response.setDateHeader("Expires", -1); %>
 }  
</script> --%>  
</head>
<body background="Images/15.jpg">
<marquee><h1>Welcome Super Admin</h1></marquee>
<h1>Hello  ${loginDTO.username}</h1><form action="logout.toll" method="post" name="logForm"> <p class="a1" ><input type="submit" value="Logout" name="log" class="logout"/></p></form>

<ol>
<label><h2>Contents</h2></label>
<li><h3><a href="addAdmin.jsp">Add Admin</a></h3></li>
<li><h3><a href="Search.jsp">Search Admin</a></h3></li>
<li><h3><a href="ChangePassword.jsp">Change Password</a></h3></li>
<li><h3><a href="Update.jsp">Update Details</a></h3></li>
</ol>
<pre>
             <p> ${msg}  </p>

</pre>
</body>
</html>