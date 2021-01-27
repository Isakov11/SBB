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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>Tickets</title>
</head>
<body>
    <jsp:include page ="../navigation.jsp"/>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <h1>List of registered passengers</h1><br>
        </div>
        <div class="row justify-content-start">
            <div class="col-2 justify-content-center">
            </div>
            <div class="col-8 justify-content-center">
                <div class="row justify-content-center">
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
                </div>
                <div class="row justify-content-md-center">
                    <table class="table table-striped table-bordered">
                        <thead><tr>
                            <th scope="col">Train number</th>
                            <th scope="col">Passenger</th>
                            <th scope="col">Purchase time</th>
                            <th scope="col">Action</th>
                        </tr></thead>
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
            </div>
        </div>
    </div>
</body>
</html>