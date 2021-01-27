<%@ page import="org.hino.sbb.dto.TrainDTO" %>
<!doctype html>
<html lang="en">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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

    <title>Select departure</title>
</head>
<body>
    <jsp:include page ="../navigation.jsp"/>
    <c:url value="/wizard/step1" var="var"/>

    <div class="container-fluid">
        <div class="row justify-content-center">
            <h1>Select departure and destination stations, and travel date</h1>
        </div>
        <div class="row justify-content-start">
            <div class="col-2 justify-content-center">

            </div>
                <div class="col-8 align-self-center justify-content-center">
                    <form action="/wizard/trainfinder" method="get">
                            <div class="row justify-content-center">
                                <div class="form-group">
                                    <label for="departStationId">Departure Station</label>
                                    <select class="form-control" name="departStationId" id="departStationId">
                                        <c:forEach var="depStation" items="${stationList}">
                                            <option value="${depStation.id}">${depStation.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="form-group">
                                    <label for="arrivalStationId">Arrival Station</label>
                                    <select class="form-control" name="arrivalStationId" id="arrivalStationId">
                                        <c:forEach var="arrStation" items="${stationList}">
                                            <option value="${arrStation.id}">${arrStation.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="form-group">
                                <label for="DepartDate" >Depart date</label>
                                <input class="form-control" type="date" value="" name="DepartDate"  id="DepartDate">
                                </div>
                            </div>
                        <div class="row justify-content-center">
                            <button type="submit" class="btn btn-primary">Find tickets</button>
                        </div>
                    </form>
                </div>
        </div>
    </div>
</body>
</html>
