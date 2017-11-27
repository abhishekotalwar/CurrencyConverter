<html>
<head>
<title>Login</title>
</head>
	<body>
		<form action="loginVerify" method="post" >
			<pre>
					User Name     : <input type="text" name="userName"/> <br>
					Password      : <input type="password" name="password"/><br>
					          <input type="submit" name="Login" value="Login"/>  <a href="register">Sign up</a><br>
					<font color="red">${errorMessage}</font>
			</pre>
		</form>
	</body>
</html>
