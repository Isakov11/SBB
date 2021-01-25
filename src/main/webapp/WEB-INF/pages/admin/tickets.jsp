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

    <title>Tickets</title>
</head>
<body>

<div class="container">
    <div class="col">
        <div class="row justify-content-md-center">
            <h1>List of registered passengers</h1><br>
        </div>
        <div class="row my-sm-3">
            <form  class="form-inline" action="${viewName}/getlist" method="get">
                <label for="trainId">Select train: </label>
                <div class="form-group mx-sm-3">
                    <select class="form-control" name="trainId" id="trainId">
                        <c:forEach var="train" items="${trainList}">
                            <c:if test="${train.id eq trainSelect}">
                                <c:set var = "selectedTr" scope = "request" value = "selected "/></c:if>
                            <c:if test="${train.id ne trainSelect}">
                                <c:set var = "selectedTr" scope = "request" value = ""/></c:if>
                            <option ${selectedTr}value="${train.id}">№${train.number}
                                "${train.name}" ${train.trainRoute.peekFirst().stationName}
                                &mdash; ${train.trainRoute.peekLast().stationName}</option>
                        </c:forEach>
                    </select>
                </div>
                    <button type="submit" class="btn btn-primary">Find passengers</button>
            </form>
        </div>

    <div class="row justify-content-md-center">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th scope="col">Train number</th>
                <th scope="col">Passenger</th>
                <th scope="col">Purchase time</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="dto" items="${DTOList}">
                <tr>
                    <td>${dto.trainNumber}</td>
                    <td>Name: ${dto.passengerName}
                        <br>
                        Second name: ${dto.passengerSecondName}
                        <br>
                        Birth date: ${dto.birthDate.toString()}
                    </td>
                    <td>${dto.purchaseTime.toLocalDate()} ${dto.purchaseTime.toLocalTime()}</td>
                    <td>
                        <form action="${viewName}/delete/${dto.id}" method="get">
                            <button type="submit" class="btn btn-primary">Cancel ticket</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <a href="${adminPage}"  role="button" class="btn btn-primary btn-lg">Back to admin page</a>
</div>
</div>
</body>
</html>