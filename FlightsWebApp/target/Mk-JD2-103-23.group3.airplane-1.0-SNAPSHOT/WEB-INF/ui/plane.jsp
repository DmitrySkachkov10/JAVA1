<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Flight Information</title>
</head>
<body>
    <h1>Flight Information</h1>
    <table border="1">
        <tr>
            <th>Aircraft Code</th>
            <th>Model</th>
            <th>Range</th>
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
