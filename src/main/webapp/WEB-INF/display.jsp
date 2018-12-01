<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DisplayData</title>
</head>
<body>
<center>
<div style="margin: 10px;">
<table style="width: 600px" class="reference">
    <form:form action="/add" modelAttribute="student" method="post">
        <input type="submit" value="Add">
    </form:form>
    <form:form action="/display" modelAttribute="student" method="post">
        <input type="submit" value="show"/>
    </form:form>
    <div align="center" style="vertical-align: bottom"></div>
    <caption><h2>List of student</h2></caption>
    <div align="center" style="margin-right:100px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Delete</th>

    </tr>
    </div>
    <c:forEach items="${studentList}" var="student">
    <tr class="tr">
        <td class="student id"><c:out value="${student.id}"/></td>
        <td class="student Name"><c:out value="${student.name}"/></td>
        <td class="student age"><c:out value="${student.age}"/></td>
        <td><a href="<c:url value="/delete/${student.id}"/>"> Delete</a></td>
        <td><a href="<c:url value="/update/${student.id}"/> ">update</a></td>
    </tr>
        </c:forEach>


</table>
<c:out value="${ message}"></c:out>

</div>
</center>
</body>
</html>
