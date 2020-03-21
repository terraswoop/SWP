<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log into your Account</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div style="margin-left:10%;margin-right:50%;margin-top:10%;">
<p style="font-size:30px;">Login:</p>
<%
String msg=(String)request.getAttribute("meldung");
if(msg!=null){
	out.append("<p style='color:red;'>"+msg+"</p>");
}
%>
<form method="post" action="db/LoginCheck">
	Name: 		<input type="text" class="form-control" name="user"><br>
	Passwort: 	<input type="password" class="form-control" name="pwd"><br>
	<button class="btn btn-primary" type="submit">Senden</button>
</form>
<br>
<p style="font-size:30px;">Register:</p>
<form method="post" action="db/Register">
	Name: 		<input type="text" class="form-control" name="user"><br>
	Passwort: 	<input type="password" class="form-control" name="pwd"><br>
	<button class="btn btn-primary" type="submit">Senden</button>
</form>
</div>
</body>
</html>