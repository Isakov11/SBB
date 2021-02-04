<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

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


    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="/resources/js/trainHandler.js"></script>
    <title>Trains List</title>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container-fluid">
    <div class="row justify-content-center">
        <h1>Trains list</h1>
    </div>
    <div class="row justify-content-start">
        <div class="col-2 justify-content-center">
            <sec:authorize access="isAuthenticated()">
                <a href="${viewName}/add" role="button" class="btn btn-primary btn-lg">Add train</a>
            </sec:authorize>
        </div>
        <div class="col-8 justify-content-center">
            <c:if test="${empty DTOList}">
                <h2>No train found</h2>
            </c:if>
            <c:if test="${!empty DTOList}">
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
                        <sec:authorize access="isAuthenticated()">
                            <th class="align-middle text-center" scope="col">Action</th>
                        </sec:authorize>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dto" items="${DTOList}">
                        <tr class="dto_${dto.id}">
                            <td class="align-middle">${dto.number}</td>
                            <td class="align-middle">${dto.name}</td>
                            <td class="align-middle">${dto.seatsNumber}</td>
                            <td class="align-middle">
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
                            <sec:authorize access="isAuthenticated()">
                                <td>
                                    <div class="container">
                                        <div class="row align-middle">
                                            <div class="col">
                                                <form action="${viewName}/edit/${dto.id}" method="get">
                                                    <button type="submit" class="btn btn-primary">Edit</button>
                                                </form>
                                            </div>
                                            <br>
                                            <div class="col">
                                                <button type="submit" class="btn btn-primary"
                                                        onclick="deleteTrain(${dto.id})">Delete
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>