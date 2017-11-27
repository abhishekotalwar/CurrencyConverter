<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Login</title>
<style>
.error {
    color: #ff0000;
    font-size: 18px;
}
</style>
</head>
	<body>
		<springForm:form commandName="loginFormData" action="loginVerify" method="post" >
			<pre>
					User Name     : <input type="text" name="userName"/> <springForm:errors path="userName" cssClass="error" /> <br>
					Password      : <input type="password" name="password"/> <springForm:errors path="password" cssClass="error" /> <br>
					          <input type="submit" name="Login" value="Login"/>  <a href="register">Sign up</a>
			</pre>
		</springForm:form>
	</body>
</html>