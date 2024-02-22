<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Teacher Registration Form</title>
</head>
<body>

<h2>Register as Teacher</h2>

<form:form modelAttribute="teacher" method="post">

<table>
<tr>
    <td>Teacher Name:</td>
    <td><form:input path="name" size="30" /> <font color="red"><form:errors path="name"/></font></td>
</tr>

<tr>
    <td>Degree/Education:</td>
    <td><form:input path="degree" size="30" /> <font color="red"><form:errors path="degree"/></font></td>
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Register as Teacher" /></td>
</tr>
</table>

</form:form>

</body>
</html>