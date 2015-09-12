<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mayank
  Date: 9/13/2015
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client Registration</title>
</head>
<body>
<spring:form method="post" action="/client/register">
    <table draggable="true">
        <tr>
            <td>Name</td>
            <td><spring:input path="@{client.name}" /></td>
        </tr>

    </table>
</spring:form>
</body>
</html>
