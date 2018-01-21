<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script>

function validateForm() {
    var x = document.forms["loginForm"]["username"].value;
    if (x == "") {
        alert("Enter username");
        return false;
    }
    
    var x = document.forms["loginForm"]["password"].value;
    if(x == "") {
    	alert("Enter password")
        return false;	
    }
    }
    	
</script>
<style type="text/css">

body
 {background-size:cover; padding-left: 150px; padding-top: 100px;}
a{text-decoration: none; color:black; padding-right: 100px;}

.button {
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

</style>
</head>
<body background="Images/5.jpg">
<h1>Sign in - TMS by Sri Harsha</h1>
<form action="login.toll" method="post" name="loginForm" onsubmit="return validateForm()">
<table cellpadding="10">
<tr>
<td><b>Username:</b></td><td><input type="text" name="username"/></td>
</tr>
<tr>
<td><b>Password:</b></td><td><input type="password" name="password"/></td>
</tr>
</table>
<br>
<pre>
       ${msg}


 <input type="submit" value="Sign in" class="button"/>  <input type="reset" value="Clear" class="button"/>     
 <a href="ForgotPassword.jsp"><h1>Forgot Password?</h1></a>
 </pre>           
</form>
</body>
</html>