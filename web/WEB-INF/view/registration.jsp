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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src ="/resources/scripts/formRequestHandler.js" ></script>

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
            <td><spring:input path="name" name="name"/></td>
        </tr>
        <tr>
            <spring:errors path="name"/>
        </tr>
        <tr>
            <td><spring:checkbox path="addressCollection" value="IA 49 C--Ashok Vihar Phase-1--Delhi-110052"/>Address 1</td>
        </tr>

        <tr>
            <td><spring:checkbox path="addressCollection" value="517 W Apt 12--144 Street--New York"/>Address 2</td>
        </tr>

        <tr>
            <td><spring:checkbox path="addressCollection" value="NIT Delhi--Narela--Delhi"/>Address 3</td>
        </tr>
        GrantTypes <br>
        <tr>
            <td><spring:checkbox path="authorizedGrantTypes" value="authorization_code"/>Authorization Code</td>
        </tr>
        <tr>
            <td><spring:checkbox path="authorizedGrantTypes" value="implicit"/>Implicit</td>
        </tr>        <tr>
            <td><spring:checkbox path="authorizedGrantTypes" value="password"/>Resource Owner Password Credentials</td>
        </tr>
        <tr>
            <td><spring:checkbox path="authorizedGrantTypes" value="client_credentials"/>Client Credentials</td>
        </tr>

    </table>
    <input id="submit-button" onclick="processForm(this,['authorizedGrantTypes','addressCollection'])" type="submit">
</spring:form>
</body>
</html>
