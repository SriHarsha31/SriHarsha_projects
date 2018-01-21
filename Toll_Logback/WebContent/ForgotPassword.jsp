<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<script>
function validateForm() {
	var x = document.forms["fpForm"]["email"].value;
	if(x == "") {
		alert("Enter email");
		return false;
	}
}
</script>
 <style>
  body {background-size:cover; }
  
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
<body align="center" background="Images/11.jpg">
<h1>ForgotPassword Page</h1>
<form action="fp.toll" method="post" name="fpForm" onsubmit="return validateForm()">
<pre>
    <h1>Enter Email</h1>
    
    ${msg}
    
 <input type="text" name="email"/>


 <input type="submit" value="Send" class="button"/>
</pre>
</form>
</body>
</html>