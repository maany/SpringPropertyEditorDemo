<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mayank
  Date: 9/20/2015
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" modelAttribute="timeManager">
  Date : <form:input path="date" name="date"/><br>
  <input type="submit" value="submit"/>
</form:form>
</body>
</html>
