<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="icon" type="image/png" href="/resources/favicon.png"/>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <title>Direct trains list</title>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<c:url value="/wizard/trainfinder" var="var"/>
<div class="container-fluid">
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
                        <form action="/wizard/trainselecter" method="get">
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
</div>
</body>
</html>
