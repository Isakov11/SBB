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
    <title>Buy ticket</title>
</head>
<body>
    <form action="/wizard/selectpassenger" method="post">
        <div class="container">
            <div class="row justify-content-md-left">
                <h1>Train №: ${trainDTO.number} ${trainDTO.name}</h1>
            </div>
            <div class="row justify-content-md-left">
                <h2>Route: ${firstStation}&mdash;${lastStation}</h2>
            </div>
            <div class="row justify-content-md-center">
                <div class="form-col">
                    <div class="row">
                        <label for="name">First name</label>
                        <input type="text" class="form-control" name="name" id="name" value="${dto.name}"/>
                    </div>
                    <div class="row">
                        <label for="secondName">Second name</label>
                        <input type="text" class="form-control" name="secondName" id="secondName" value="${dto.secondName}"/>
                    </div>
                    <div class="row">
                        <label for="birthDate">Birth date</label>
                        <input type="text" class="form-control" name="birthDate" id="birthDate" value="${dto.birthDate}"/>
                    </div>
                </div>
                <input type="hidden" name="trainId" value="${trainDTO.id}">
                <input type="hidden" name="departStationId" value="${departStationId}">
            </div>
                <button type="submit" class="btn btn-primary">Save</button>
            <br>
        </div>
    </form>
    </div>
        <a href="../"  role="button" class="btn btn-primary btn-lg">Back</a>
    </div>
</body>
</html>
