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
            <th>Id</th>
            <th>AirportName</th>
            <th>City</th>
            <th>Coordinates</th>
            <th>TimeZone</th>

        </tr>
        <c:forEach var="airport" items="${airports}">
            <tr>
                <td>${airport.id}</td>
                <td>${airport.airportName}</td>
                <td>${airport.city}</td>
                <td>${airport.coordinates}</td>
                <td>${airport.timeZone}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
