<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="icon" type="image/png" href="/resources/favicon.png" />
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.4.5.3.min.css">
    <title>Direct trains list</title>
</head>
<body>
    <c:url value="/wizard/findtrain" var="var"/>
    <div class="container">
        <div class="row justify-content-md-center">

            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th class="align-middle" scope="col">Number</th>
                    <th class="align-middle" scope="col">Name</th>
                    <th class="align-middle" scope="col">Seats number</th>
                    <th class="align-middle" scope="col">
                        <table class="table table-borderless">
                            <thead class="align-middle">
                            <tr>
                                <th scope="col">Station</th>
                                <th scope="col">Arrival date</th>
                                <th scope="col">Departure date</th>
                            </tr>
                            </thead>
                        </table>
                    </th>
                    <th class="align-middle text-center" scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dto" items="${DTOList}">
                    <tr>
                        <td class="align-middle">${dto.number}</td>
                        <td class="align-middle">${dto.name}</td>
                        <td class="align-middle">${dto.seatsNumber}</td>
                        <td>
                            <table class="table table-striped table-bordered">
                                <tbody>
                                <c:forEach var="sched" items="${dto.trainRoute}">
                                    <tr>
                                        <td>${sched.stationName}</td>
                                        <td>${sched.arrivalTime.toLocalDate()} ${sched.arrivalTime.toLocalTime()}</td>
                                        <td>${sched.departureTime.toLocalDate()} ${sched.departureTime.toLocalTime()}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </td>
                        <td>
                            <form action="/wizard/selecttrain" method="get">
                                <input type="hidden" name="departStationId" value="${departStationId}">
                                <input type="hidden" name="trainId" value="${dto.id}">
                                <button type="submit" class="btn btn-primary">Select train</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
            <a href="../"  role="button" class="btn btn-primary btn-lg">Back</a>
    </div>
</body>
</html>
