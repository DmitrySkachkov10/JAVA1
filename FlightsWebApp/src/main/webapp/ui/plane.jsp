<%@ page language="java"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="c1" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Aircraft Information</title>
</head>
<body>
    <h1>Aircraft Information</h1>
    <table border="1">
        <tr>
            <th>aircraft_code</th>
            <th>model</th>
            <th>range</th>
        </tr>
        <c:forEach var="aircraft" items="${aircrafts}">
            <tr>
                <td>${aircraft.aircraft_code}</td>
                <td>${aircraft.model}</td>
                <td>${aircraft.range}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
