<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Register</title>
<style>
.error {
    color: #ff0000;
    font-size: 18px;
}
</style>
</head>
	<body>
		<springForm:form commandName="registerFormData" action="registrationVerify" method="post" >
			<pre>
				User Name          : <input type="text" name="userName"/> <springForm:errors path="userName" cssClass="error" /><br/>
				Password           : <input type="password" name="password"/> <springForm:errors path="password" cssClass="error" /><br/>
				Re-Enter Password  : <input type="password" name="reEnterPassword"/> <springForm:errors path="reEnterPassword" cssClass="error" /><br/>
				First Name         : <input type="text" name="firstName"/> <springForm:errors path="firstName" cssClass="error" /><br/>
				Last Name          : <input type="text" name="lastName"/> <springForm:errors path="lastName" cssClass="error" /><br/>
				Email              : <input type="text" name="email"/> <springForm:errors path="email" cssClass="error" /><br/>
					   <input type="submit" name="register" value="Register"/>
			</pre>
		</springForm:form>
	</body>
</html>