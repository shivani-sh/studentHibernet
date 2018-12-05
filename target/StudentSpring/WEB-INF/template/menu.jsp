<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../template/taglib.jsp" %>

<style>
    .vertical-menu {
        width: 200px;
    }
    .vertical-menu a {
        background-color: #eee;
        color: black;
        display: block;
        padding: 12px;
        text-decoration: none;
    }
    .vertical-menu a:hover {
        background-color: #ccc;
    }
    .vertical-menu a.active {
        background-color: #4CAF50;
        color: white;
    }
</style>



<div class="vertical-menu">
<%--<a class="active" href="<c:url value="/display"/>">Home</a>--%>
<a href="<c:url value="/add"/>"class="btn btn-outline-info" >Add Student</a>
<a class="active" href="<c:url value="/display"/>"class="btn btn-outline-info">View Student</a>
</div>

