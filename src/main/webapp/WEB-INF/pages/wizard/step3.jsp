<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!doctype html>
<html lang="en">
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

    <title>Buy ticket</title>
</head>
<body>
    <form action="/wizard/passengerselecter" method="post">
        <div class="container">
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
                        <input type="text" class="form-control" name="secondName" id="secondName" value="${dto.secondName}"/>
                    </div>
                    <div class="row">
                        <label for="birthDate">Birth date</label>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="input-group date" id="birthDate">
                                <input type="text" class="form-control" name="birthDate" />
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                        <script type="text/javascript">
                                            $(function () {
                                                $('#birthDate').datetimepicker({
                                                    format: 'DD.MM.YYYY', locale: 'ru'
                                                });
                                            });
                                        </script>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="trainId" value="${trainDTO.id}">
                <input type="hidden" name="departStationId" value="${departStationId}">
            </div>
            <div class="row my-sm-5 justify-content-md-center">
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </div>
    </form>
    <div class="row my-sm-5 justify-content-center">
        <h1>${resultMessage}</h1>
    </div>
    <div>
        <a href="/index"  role="button" class="btn btn-primary btn-lg">Back</a>
    </div>
</body>
</html>
