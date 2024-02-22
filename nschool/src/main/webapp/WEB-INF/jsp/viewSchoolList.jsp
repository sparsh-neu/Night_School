<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>School List</title>
    </head>
    <body>
    	<h1><b>Night School List</b></h1>
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
            	<td><b>STUDENT</b></td>
                <td><b>COURSE</b></td>
                <td><b>TERM</b></td>
                <td><b>SUBJECT</b></td>
            </tr>
            <c:forEach var="sch" items="${requestScope.schoollist}">
                <tr>
                	<td>${sch.smail}</td>
                	<td>${sch.course}</td>
                    <td>${sch.term}</td>
                    <td>${sch.subject}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>