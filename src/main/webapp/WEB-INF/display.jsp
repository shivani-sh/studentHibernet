<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <head>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        </head>

    </head>
    <title>DisplayData</title>
</head>
<body>
<center>
    <div style="margin: 10px;">
        <table style="width: 600px" class="reference">

            <div align="center" style="margin-right:100px">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Delete</th>
                    <th>Update</th>

                </tr>

            </div>
            <c:forEach items="${studentList}" var="student">
                <tr class="tr">
                    <td class="student id"><c:out value="${student.id}"/></td>
                    <td class="student Name"><c:out value="${student.name}"/></td>
                    <td class="student age"><c:out value="${student.age}"/></td>


                    <td><a href="<c:url value="/delete/${student.id}"/> " class="btn btn-outline-danger" role="button">Delete</a>
                    </td>


                    <td><a href="<c:url value="/update/${student.id}"/>" class="btn btn-outline-success" role="button">Update</a>
                    </td>
                </tr>
            </c:forEach>
            <div class="alert alert-success">
                <strong>Success!</strong>welcome
            </div>

        </table>
        <c:out value="${ message}"></c:out>

    </div>
</center>
</body>
</html>
