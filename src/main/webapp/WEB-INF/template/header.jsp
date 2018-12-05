

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../template/taglib.jsp" %>

<style>
    * {box-sizing: border-box;}
    body {
        margin: 0;
        font-family: Arial, Helvetica, sans-serif;
    }
    .header {
        overflow: hidden;
        background-color: #f1f1f1;
        padding: 30px 10px;
    }
    .header a {
        float: left;
        color: black;
        text-align: center;
        padding: 8px;
        text-decoration: none;
        font-size: 18px;
        line-height: 20px;
        border-radius: 40px;
    }

    .header a:hover {
        background-color: transparent;
        color: black;
    }
    .header a.active {
        background-color: dodgerblue;
        color: white;
    }
    .header-right {
        float: left;
    }
    @media screen and (max-width: 500px) {
        .header a {
            float: none;
            display: block;
            text-align: left;
        }
        .header-right {
            float: none;
        }
    }
</style>



<div class="header">
    <%--<a class="active" href="<c:url value="/display"/>">Home</a>--%>
    <a href="<c:url value="/add"/>"class="btn btn-outline-info" >Add Student</a>
    <a class="active" href="<c:url value="/display"/>"class="btn btn-outline-info">View Student</a>

</div>
