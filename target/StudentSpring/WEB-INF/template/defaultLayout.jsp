<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>

</head>

<body>
<section id="header">
    <tiles:insertAttribute name="header" />
</section>

<section id="menu">
    <tiles:insertAttribute name="menu" />
</section>

<section id="body">
    <tiles:insertAttribute name="body" />
</section>

<footer id="footer">
    <tiles:insertAttribute name="footer" />
</footer>
</body>
</html>






<%--

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   &lt;%&ndash; <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>&ndash;%&gt;
</head>
<body>
<div><tiles:insertAttribute name="header" /></div>
<div style="float:left;padding:10px;width:15%;"><tiles:insertAttribute name="menu" /></div>
<div style="float:left;padding:10px;width:80%;border-left:1px solid pink;">
    <tiles:insertAttribute name="body" /></div>
<div style="clear:both"><tiles:insertAttribute name="footer" /></div>

</body>
</html>
--%>

<%--

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<table>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td>
            <tiles:insertAttribute name="menu" />
        </td>
        <td>
            <tiles:insertAttribute name="body" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
--%>
