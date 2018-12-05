<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update data</title>
</head>
<body>

<form:form action="/update" modelAttribute="student" method="post">
    <tr>
        <td>Name</td>
        <td><input type="text" name="name"/></td>
    </tr>
    <tr>
        <td>Age</td>
        <td><input type="number" name="age"/></td>
        <input type=hidden name="id" value="${id}">
    </tr>
    <button type="submit" class="btn btn-default">Submit</button>

</form:form>

</body>
</html>
<%--
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring Tiles Contact Form</title>
</head>
<body>
<h2>Contact Manager</h2>
<form:form action="/update" modelAttribute="student" method="post">

    <table>

        <tr>
            <td><form:label path="name"> Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="age">Email</form:label></td>
            <td><form:input path="age" /></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Add Contact"/>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>--%>
