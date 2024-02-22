<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Student Login</title>
</head>
<body>

<h2>Student Login</h2>

<form:form modelAttribute="student" method="post">

<table>
<tr>
    <td>Student E-mail:</td>
    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
</tr>

<tr>
    <td>Student Name:</td>
    <td><form:input path="name" size="30" /> <font color="red"><form:errors path="name"/></font></td>
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Login" /></td>
</tr>
</table>

</form:form>

</body>
</html>