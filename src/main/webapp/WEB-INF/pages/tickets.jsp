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
                <th scope="col">Passenger</th>
                <th scope="col">Purchase time</th>
                <th scope="col">Train number</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="dto" items="${DTOList}">
                <tr>
                    <td>Name: ${dto.passengerName}
                        <br>
                        Second name: ${dto.passengerSecondName}
                        <br>
                        Birth date: ${dto.birthDate}
                    </td>
                    <td>${dto.purchaseTime}</td>
                    <td>${dto.trainNumber}</td>
                    <td>
                        <form action="../${viewName}/edit/${dto.id}" method="get">
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </form>
                        <br>
                        <form action="../${viewName}/delete/${dto.id}" method="get">
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="../${viewName}/add"  role="button" class="btn btn-primary btn-lg">Add ticket</a>
    </div>
    <a href="/"  role="button" class="btn btn-primary btn-lg">Back to admin page</a>
</div>
</body>
</html>