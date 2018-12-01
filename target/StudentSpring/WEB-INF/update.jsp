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
    <input type=submit value="Update">
    </form:form>

</body>
</html>
