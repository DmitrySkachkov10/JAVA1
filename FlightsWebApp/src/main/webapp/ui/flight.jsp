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
            <th>Flight ID</th>
            <th>Flight No</th>
            <th>Scheduled Departure</th>
            <th>Scheduled Departure Local</th>
            <th>Scheduled Arrival</th>
            <th>Scheduled Arrival Local</th>
            <th>Interval</th>
            <th>Departure Airport</th>
            <th>Departure Airport Name</th>
            <th>Departure City</th>
            <th>Arrival Airport</th>
            <th>Arrival Airport Name</th>
            <th>Arrival City</th>
            <th>Status</th>
            <th>Aircraft Code</th>
        </tr>
        <c:forEach var="flight" items="${flights}">
            <tr>
                <td>${flight.flightId}</td>
                <td>${flight.flightNo}</td>
                <td>${flight.scheduledDeparture}</td>
                <td>${flight.scheduledDepartureLocal}</td>
                <td>${flight.scheduledArrival}</td>
                <td>${flight.getScheduledArrivalLocal}</td>
                <td>${flight.interval}</td>
                <td>${flight.departureAirport}</td>
                <td>${flight.departureAirportName}</td>
                <td>${flight.departureCity}</td>
                <td>${flight.arrivalAirport}</td>
                <td>${flight.arrivalAirportName}</td>
                <td>${flight.arrivalCity}</td>
                <td>${flight.status}</td>
                <td>${flight.aircraftCode}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>