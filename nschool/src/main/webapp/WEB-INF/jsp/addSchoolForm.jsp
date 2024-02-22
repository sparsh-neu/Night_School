<%@page import="com.me.nschool.dao.TeacherDAO"%>
<%@page import="com.me.nschool.pojo.Teacher" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
	//get the teacher list
	TeacherDAO teacherdao = new TeacherDAO();
	java.util.List<Teacher> teacherList = teacherdao.list();
	pageContext.setAttribute("teachers", teacherList);
%>

<html>
    <head>
        <title>Join Class</title>
    </head>
    <body>

        <h2>Joining a class</h2>

        <form:form modelAttribute="school" method="post">

            <table>

                <tr>
                    <td>Teacher:</td>
                    <td>
                        <form:select path="teacher">
                            <c:forEach var="teach" items="${teachers}">
                                <form:option value="${teach.name}"/>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>
                
                <tr>
                    <td>E-mail ID:</td>
                    <td><form:input path="smail" size="30" /> <font color="red"><form:errors path="smail"/></font></td>
                </tr>

                <tr>
                    <td>Course:</td>
                    <td><form:input path="course" size="30" /> <font color="red"><form:errors path="course"/></font></td>
                </tr>

                <tr>
                    <td>Term:</td>
                    <td><form:input path="term" size="30" /> <font color="red"><form:errors path="term"/></font></td>
                </tr>

                <tr>
                    <td>Subject:</td>
                    <td><form:input path="subject" size="30" /> <font color="red"><form:errors path="subject"/></font></td>
                </tr>
        
                <tr>
                    <td colspan="2"><input type="submit" value="Join Class" /></td>
                </tr>
            </table>

        </form:form>

    </body>
</html>