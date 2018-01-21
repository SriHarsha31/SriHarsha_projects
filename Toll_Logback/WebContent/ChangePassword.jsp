<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Reset</title>
<script>

function validateForm() {
    var x = document.forms["cpForm"]["newPassword"].value;
    if (x == "") {
        alert("Enter new password");
        return false;
    }

	var x = document.forms["cpForm"]["confirmPassword"].value;
    if (x == "") {
        alert("confirm password");
        return false;
    }
}
</script>

 <style>
  body{background-size:cover; }
  
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
<body background="Images/13.jpg" align="center">
<h2 class="welcome">logged in: ${loginDTO.username}</h2>
<form action="cp.toll" method="post" name="cpForm" onsubmit="return validateForm()">
<table align="center">
<tr>
<td><h2>New Password     :</h2></td><td><input type="password" name="newPassword"></td>
</tr>
<tr>
<td><h2>Confirm Password :</h2></td><td><input type="password" name="confirmPassword"></td>
</tr>
</table>
<br>
${msg}
<pre>
<input type="submit" value="confirm" class="button">  <input type="reset" value="Clear" class="button">
</pre>
</form>
</body>
</html>