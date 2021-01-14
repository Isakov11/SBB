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
        <title>Add</title></c:if>
    <c:if test="${!empty dto.id}">
        <title>Edit</title></c:if>
</head>
<body>

<div class="container">
    <c:if test="${empty dto.id}">
        <c:url value="/${viewName}/add" var="var"/>
    </c:if>
    <c:if test="${!empty dto.id}">
        <c:url value="/${viewName}/edit" var="var"/>
    </c:if>
    <div class="wrapper">
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
                                <c:if test="${train.id eq dto.trainId}">
                                    <c:set var = "selected" scope = "request" value = "selected "/></c:if>
                                <c:if test="${train.id ne dto.trainId}">
                                    <c:set var = "selected" scope = "request" value = ""/></c:if>
                                <option ${selected}value="${train.id}">${train.number} ${train.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="passenger">Passenger</label>
                        <select class="form-control" name="passengerId"  id="passenger">
                            <c:forEach var="passenger" items="${passengersList}">
                                <c:if test="${passenger.id eq dto.passengerId}">
                                    <c:set var = "selectedP" scope = "request" value = "selected "/></c:if>
                                <c:if test="${passenger.id ne dto.passengerId}">
                                    <c:set var = "selectedP" scope = "request" value = ""/></c:if>
                                <option ${selectedP}value="${passenger.id}">${passenger.name} ${passenger.secondName} ${passenger.birthDate}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                </div>
            <br>
                <button type="submit" class="btn btn-primary">Save</button>
            <br>
        </div>

    </form>
    </div>
</div>
    <c:if test="${empty dto.id}">
        <a href="./"  role="button" class="btn btn-primary btn-lg">Back</a></c:if>
    <c:if test="${!empty dto.id}">
        <a href="../"  role="button" class="btn btn-primary btn-lg">Back</a></c:if>
</div>
</body>
</html>
