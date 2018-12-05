<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>


    <title>AddData</title>
</head>
<body>

<center>

<form:form action="/addsave" modelAttribute="student" method="post">
<table>

    <h2>Please add data</h2>
    <table style="width: 600px" class="reference">

        <tr>
            <td>Name</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="number" name="age"/></td>
        </tr>

    </table>
    <input type="submit" value="save"/>
</table>
</form:form>
</center>

</body>

</html>



