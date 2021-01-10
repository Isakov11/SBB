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

    <title>Schedules</title>
</head>
<body>

<div class="container">
    <div class="row justify-content-md-center">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th scope="col">Train</th>
                <th scope="col">Station</th>
                <th scope="col">Arrival time</th>
                <th scope="col">Departure time</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="entity" items="${DTOList}">
                <tr>
                    <td>Number: ${entity.train.number}
                        <br>
                        Name: ${entity.train.name}
                    </td>
                    <td>${entity.station.name}</td>
                    <td>${entity.arrivalTime.toLocalDate()}  ${entity.arrivalTime.toLocalTime()}</td>
                    <td>${entity.departureTime.toLocalDate()} ${entity.departureTime.toLocalTime()}</td>
                    <td>
                        <form action="../${viewName}/edit/${entity.id}" method="get">
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </form>
                        <br>
                        <form action="../${viewName}/delete/${entity.id}" method="get">
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="../${viewName}/add"  role="button" class="btn btn-primary btn-lg">Add schedule</a>
    </div>
    <a href="/"  role="button" class="btn btn-primary btn-lg">Back to admin page</a>
</div>
</body>
</html>