<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mayank
  Date: 9/24/2015
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="/resources/scripts/formRequestHandler.js"></script>
    <script>
        function processOutGoingData(form, checkBoxNames) {
            for (var i = 0; i < checkBoxNames.length; i++)
                formProcessor(form, checkBoxNames[i]);
        }
        function formProcessor(form, checkBoxName) {

            var csv = getCSV(checkBoxName);
            alert(csv);
            var checkBoxArray = document.getElementsByName(checkBoxName);
            for (var i = 0; i < checkBoxArray.length; i++) {
                var checkBox = checkBoxArray[i];
                document.getElementById(checkBox.id);
                checkBox.checked = false;
            }
            var addressNode = document.createElement("input");
            addressNode.setAttribute('type', 'hidden');
            addressNode.setAttribute('name', checkBoxName);
            addressNode.setAttribute('value', csv);
            form.appendChild(addressNode);
        }
        function getCSV(checkboxName) {
            var csv = "";
            var checkboxArray = document.getElementsByName(checkboxName);
            for (var i = 0; i < checkboxArray.length; i++) {
                if (checkboxArray[i].checked) {
                    //alert(checkboxArray[i].value);
                    csv = csv + checkboxArray[i].value + " , ";
                }
            }
            return csv;
        }
    </script>
    <script>

        function selectCheckBoxes(checkboxName, csvValue) {
            var checkboxes = document.getElementsByName(checkboxName);
            var refValues = csvValue.split(" , ");
            for (var i = 0; i < checkboxes.length; i++) {
                var checkbox = checkboxes[i];
                var value = checkbox.value;
                for (var j = 0; j < refValues.length; j++) {
                    if (refValues[j].localeCompare(value) == 0)
                        checkbox.checked = true;
                    break;
                }
            }
        }

        window.onload = function(){
            selectCheckBoxes(addressCollection,${client.addressCollection});
            selectCheckBoxes(authorizedGrantTypes,${client.authorizedGrantTypes});
        };
    </script>
</head>
<body>

<c:set var="client" value="${model.client}"/>
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
            <td><spring:checkbox path="addressCollection" value="IA 49 C--Ashok Vihar Phase-1--Delhi-110052"/>Address
                1
            </td>
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
        </tr>
        <tr>
            <td><spring:checkbox path="authorizedGrantTypes" value="password"/>Resource Owner Password Credentials</td>
        </tr>
        <tr>
            <td><spring:checkbox path="authorizedGrantTypes" value="client_credentials"/>Client Credentials</td>
        </tr>

    </table>
    <input id="submit-button" onclick="processOutGoingData(this,['authorizedGrantTypes','addressCollection'])"
           type="submit">
</spring:form>
</body>
</html>
