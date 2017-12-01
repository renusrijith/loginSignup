<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>yahoo from JSp!! </title>
</head>

<body>



<form action="login.do"  method="post">
<p>	<font color="red	">${errorMessage} </font></p>
 Enter name         :<input type="text" name="name" size="20"/>
<br />
password   :<input type="password" name="password" size="20"/>
<br />
<input type="submit" value="Login" >
</form>

<form action="signup.do"  method="get">
<input type="submit" value="Signup" >
</form>


</body>
</html>