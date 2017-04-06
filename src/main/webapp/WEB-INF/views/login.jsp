<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="container">
${loginError}
<div class="form-group form">
	<form action='login' method="post">
		<div>
			<label>Login:</label>
			<input type="text" id="userLogin" name="userLogin" class="form-control"/>
		</div>
		<div>
			<label>Haslo:</label>
			<input type="password" id="password" name="password" class="form-control"/>
		</div>
		<button id="loginBtn" class="form-control">Zaloguj</button>
	</form>
</div>
</div>
</body>
</html>