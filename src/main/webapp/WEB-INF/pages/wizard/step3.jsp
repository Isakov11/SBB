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

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <title>Buy ticket</title>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<form action="/wizard/passengerselecter" method="post">
    <div class="container-fluid">
        <div class="row justify-content-md-center">
            <h1>Train №: ${trainDTO.number} "${trainDTO.name}"</h1>
        </div>
        <div class="row justify-content-md-center">
            <h2>Route: ${firstStation} &mdash; ${lastStation}</h2>
        </div>
        <div class="row justify-content-md-center">
            <div class="form-col">
                <div class="row">
                    <label for="name">First name</label>
                    <input type="text" class="form-control" name="name" id="name" value="${dto.name}"/>
                </div>
                <div class="row">
                    <label for="secondName">Second name</label>
                    <input type="text" class="form-control" name="secondName" id="secondName"
                           value="${dto.secondName}"/>
                </div>
                <div class="row justify-content-start">
                    <label for="birthDate">Birth date</label>
                </div>
                <div class="row justify-content-start">
                    <input class="form-control" type="date" value="${dto.birthDate}" name="birthDate" id="birthDate">
                </div>
            </div>
        </div>
        <input type="hidden" name="trainId" value="${trainDTO.id}">
        <input type="hidden" name="departStationId" value="${departStationId}">
    </div>
    <div class="row my-sm-2 justify-content-center">
        <button type="submit" class="btn btn-primary">Save</button>
    </div>
    </div>
</form>
<div class="row my-sm-5 justify-content-center">
    <h1>${resultMessage}</h1>
</div>
<div>
</div>
</body>
</html>
