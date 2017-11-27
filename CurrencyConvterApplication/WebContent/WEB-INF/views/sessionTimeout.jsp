<html>
<head>
<title>Login</title>
</head>
	<body>
		<font color="red">${errorMessage}</font><br/>
		<form action="loginVerify" method="post" >
			<pre>
					User Name     : <input type="text" name="userName"/> <br>
					Password      : <input type="password" name="password"/><br>
					          <input type="submit" name="Login" value="Login"/>  <a href="register"><b>Sign up</b></a>
			</pre>
		</form>
	</body>
</html>