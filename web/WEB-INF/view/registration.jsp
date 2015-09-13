<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:set var="message" value="${model.message}"/>
<c:if test="${not empty message}">
    <c:out value="${message}"/>
</c:if>
<spring:form modelAttribute="client" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><spring:input path="${client.name}"/></td>
        </tr>
        <tr>
            <spring:errors path="${client.name}"/>
        </tr>
        <tr>
            <td>Address</td>
            <td><spring:input path="${client.addressCollection.}"</td>
        </tr>
    </table>
    <input type="submit">
</spring:form>
</body>
</html>
