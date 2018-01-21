<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Admin</title>
<script>
   function validateForm() {
    var x = document.forms["adminForm"]["username"].value;
    if (x == "") {
        alert("Enter Username");
        return false;
    }

	var x = document.forms["adminForm"]["email"].value;
    if (x == "") {
        alert("Enter email");
        return false;
    }

	var x = document.forms["adminForm"]["tollbooth_name"].value;
    if (x == "") {
        alert("Enter tollboothName");
        return false;
    }
    
    var x = document.forms["adminForm"]["expiry_date"].value;
    if (x == "") {
        alert("Enter expiryDate");
        return false;
    }
    
    var x = document.forms["adminForm"]["contactNum"].value;
    if (x == "") {
        alert("Enter Number");
        return false;
        
    }
    
    var x = document.forms["adminForm"]["contactNum"].value;
    if(x.length != 10) {
        window.alert("Phone number must be 10 digits");
        //x.focus();
        return false;
    }
    
  /* 
    var radio = document.getElementsByName("status");
    var formValid = false;

    var i = 0;
    while (!formValid && i < radio.length) {
        if (radio[i].checked) formValid = true;
        i++;        
    }

    if (!formValid) alert("Must check some option!");
    return formValid; */
    
   }
   
  </script>
  <style>
  body{background-size:cover; }
  
  .welcome{padding-right: 1200px;}
  
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
<body background="Images/9.jpg" align="center">
<h1>Enter admin details</h1>
<h2 class="welcome">logged in: ${loginDTO.username}</h2>
<form action="admin.toll" method="post" name="adminForm" onsubmit="return validateForm()">
<table align="center" cellspacing="25">
<tr>
   <td><b>Username</b></td> <td>:<input type="text" name="username"/></td>
   </tr>
   <tr>
   <td><b>Email</b></td><td>:<input type="email" name="email"/></td>
   </tr>
<tr>
 <td><b>Expiry-Date</b></td><td>:<input type="date" name="expiry_date"/></td>
 </tr>
 <tr>
 <td><b>Contact</b></td> <td>:<input type="text" name="contactNum"/></td>
 </tr>
 <tr>
<td><b>TollBooth-Name</b></td><td>:<select name="tollbooth_name">
<option disabled="disabled">Select Toll</option> <option>Nelamangala</option> <option>Kunigal</option>  <option>KB Cross</option><option>Hosakerehalli</option></select></td> 
 </tr>
 <tr>
  <td><b>Status:Yes</b><input type="radio" name="status" value="1" /><b>No</b><input type="radio" name="status" checked="checked" value="0"></td>                                           
</tr>
</table>
<pre>        
        
     <input type="submit" value="Add" class="button"/>  <input type="reset" value="Clear" class="button"/>

                            ${msg}
                            
  </pre>                            
</form>
</body>
</html>