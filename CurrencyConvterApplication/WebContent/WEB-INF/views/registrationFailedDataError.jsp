<html>
<head>
<title>Register</title>
</head>
	<body>
		<form action="registrationVerify" method="post" >
			<pre>
				User Name          : <input type="text" name="userName"/> <font color="red">${errorMessage.duplicateUser}</font><br/>
				Password           : <input type="password" name="password"/> <font color="red">${errorMessage.passowrdNotmatch}</font><br/>
				Re-Enter Password  : <input type="password" name="reEnterPassword"/> <font color="red">${errorMessage.passowrdNotmatch}</font><br/>
				First Name         : <input type="text" name="firstName"/> <br/>
				Last Name          : <input type="text" name="lastName"/> <br/>
				Email              : <input type="text" name="email"/> <font color="red">${errorMessage.emailExist}</font><br/>
					   <input type="submit" name="register" value="Register"/>
			</pre>
		</form>
	</body>
</html>