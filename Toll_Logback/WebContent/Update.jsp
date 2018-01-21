<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Details</title>
<script>
   function validateForm() {
    var x = document.forms["updateForm"]["username"].value;
    if (x == "") {
        alert("Enter Username");
        return false;
    }
    
    var x = document.forms["updateForm"]["password"].value;
    if (x == "") {
        alert("Enter Password");
        return false;
    }
    
    var x = document.forms["updateForm"]["contactNum"].value;
    if (x == "") {
        alert("Enter Contact Number");
        return false;
    }

	var x = document.forms["updateForm"]["tollbooth_name"].value;
    if (x == "") {
        alert("Enter TollBooth Name");
        return false;
    }
   }
   </script>
   <style type="text/css">body{background-size: cover; color:white;} form{padding-left: 600px;} h2{padding-left: 1200px;}
   
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
<body background="Images/16.jpg" align="center">
<h2 class="welcome">logged in: ${loginDTO.username}</h2>
<form action="update.toll" method="post" name="updateForm" onsubmit="return validateForm()">
<table  cellpadding="15">
<tr>
<td><b>Username</b></td>      <td>:<input type="text" name="username" readonly="readonly" value="${adminDTO.username}"></td> 
</tr>
<tr>
<td><b>Password</b></td>      <td>:<input type="text" name="password" value="${adminDTO.password}"/></td> 
</tr>
<tr>

<td><b>email</b></td>         <td>:<input type="email" name="email" readonly="readonly" value="${adminDTO.email}"></td> 
</tr>
<tr>
<td><b>Contact</b></td>       <td>:<input type="text" name="contactNum" value="${adminDTO.contactNum}"/></td> 
</tr>
<tr>
<td><b>TollBooth-Name</b></td><td>:<select name="tollbooth_name">
          <option disabled="disabled">Select Toll</option> <option>Nelamangala</option> <option>Kunigal</option>  <option>KB Cross</option><option>Hosakerehalli</option></select></td> 
 </tr>
 <tr>          
<td><b>Expiry-Date</b></td>   <td>:<input type="text" name="expiry_date" readonly="readonly" value="${adminDTO.expiry_date}"></td> 
</tr>
<tr>
<td><b>Status: Yes</b></td><td><input type="radio" name="status" value="1" checked="checked"/> <b>No</b><input type="radio" name="status"  value="0"></td>
</tr>
<tr>
<td><input type="hidden" name="role" value="${adminDTO.role}"/></td>

</tr>
<tr>

<td> <input type="submit" value="Update" class="button"/></td>
</tr>
</table>
     
           
          
           

          ${msg}
</form>
</body>
</html>