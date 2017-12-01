<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>yahoo from JSp!! </title>
</head>

<body>



<form action="signup.do"  method="post">
<p>	<font color="red	">${errorMessage} </font></p>
Enter name        :<input type="text" name="name" size="20"/>
<br />
Enter password    :		<input type="password" name="password" size="20"/>
<br />
Reenter Password  :		<input type="password" name="password2" size="20"/>
<br />
<input type="submit"  name ="Signup" value="Signup">
</form>
</body>
</html>