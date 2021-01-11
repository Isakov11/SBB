<%@ page import="org.hino.sbb.dto.TrainDTO" %>
<!doctype html>
<html lang="en">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <c:if test="${empty dto.id}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty dto.id}">
        <title>Edit</title>
    </c:if>
</head>
<body>

<div class="container">
    <c:if test="${empty dto.id}">
        <c:url value="/${viewName}/add" var="var"/>
    </c:if>
    <c:if test="${!empty dto.id}">
        <c:url value="/${viewName}/edit" var="var"/>
    </c:if>
    <form action="${var}" method="post">
        <div class="container">
            <div class="row justify-content-md-center">
                <c:if test="${!empty dto.id}">
                    <input type="hidden" name="id" value="${dto.id}">
                </c:if>
                <div class="col">
                    <div class="form-group">
                        <label for="trainId">Train</label>
                        <select class="form-control" name="trainId" id="trainId">
                            <c:forEach var="train" items="${trainsList}">
                                <option value="${train.id}">${train.number} ${train.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col">
                    <label for="order">Station order</label>
                    <input type="text" class="form-control" name="stationOrder" id="order" value="${stationOrder}0"/>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="station">Station</label>
                        <select class="form-control" name="stationId"  id="station">
                            <c:forEach var="station" items="${stationsList}">
                                <option value="${station.id}">${station.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col">
                    <label for="arrivalpicker">Arrival time</label>
                    <div class="form-group">
                        <div class="input-group date" id="arrivalpicker">
                            <input type="text" class="form-control" name="arrivalpicker"/>
                            <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                                <script type="text/javascript">
                                    $(function () {
                                        $('#arrivalpicker').datetimepicker({
                                            locale: 'ru'
                                        });
                                    });
                                </script>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <label for="departurepicker">Departure time</label>
                    <div class="form-group">
                        <div class='input-group date' id='departurepicker'>
                            <input type='text' class="form-control" name="departurepicker"/>
                            <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                    <script type="text/javascript">
                        $(function () {
                            $('#departurepicker').datetimepicker({
                                locale: 'ru'
                            });
                        });
                    </script>
                </div>
                </div>
            <br>
                <button type="submit" class="btn btn-primary" >Save</button>
            <br>
        </div>
    </form>
</div>

    <c:if test="${empty dto.id}">
        <a href="./"  role="button" class="btn btn-primary btn-lg">Back</a>
    </c:if>
    <c:if test="${!empty dto.id}">
        <a href="../"  role="button" class="btn btn-primary btn-lg">Back</a>
    </c:if>
</div>
</body>
</html>
