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
    <link rel="stylesheet" href="/resources/css/bootstrap.4.5.3.min.css">

    <link rel="stylesheet" type="text/css" media="screen"
          href="/resources/css/bootstrap.3.3.1.min.css"/>
    <link rel="stylesheet" href="/resources/css/font-awesome.4.3.0.min.css">

    <link href="/resources/css/bootstrap-datetimepicker.4.17.47.css" rel="stylesheet">

    <script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.3.3.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/moment-with-locales.2.29.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap-datetimepicker.4.17.47.min.js"></script>

    <title>Select departure</title>
</head>
<body>
    <c:url value="/wizard/step1" var="var"/>

<div class="container">
    <form action="/wizard/trainfinder" method="get">
        <!---------------------------------------------------------------------------------------------->
        <div class="col">
            <h1>Select departure and destination stations, and travel date</h1><br>
            <div class="form-group">
                <label for="departStationId">Departure Station</label>
                <select class="form-control" name="departStationId" id="departStationId">
                    <c:forEach var="depStation" items="${stationList}">
                        <option value="${depStation.id}">${depStation.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col">
            <div class="form-group">
                <label for="arrivalStationId">Arrival Station</label>
                <select class="form-control" name="arrivalStationId" id="arrivalStationId">
                    <c:forEach var="arrStation" items="${stationList}">
                        <option value="${arrStation.id}">${arrStation.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col">
            <label for="DepartDate">Departure date</label>
            <div class="form-group">
                <div class="input-group date" id="DepartDate">
                    <input type="text" class="form-control" name="DepartDate" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                            <script type="text/javascript">
                                $(function () {

                                    $('#DepartDate').datetimepicker({
                                        format: 'DD.MM.YYYY', locale: 'ru'
                                    });
                                });
                            </script>
                    </span>
                </div>
            </div>
        </div>
        <!---------------------------------------------------------------------------------------------->
        <button type="submit" class="btn btn-primary">Find</button>
    </form>


    </div>
        <a href="${adminPage}"  role="button" class="btn btn-primary btn-lg">Back</a>
    </div>
</body>
</html>
