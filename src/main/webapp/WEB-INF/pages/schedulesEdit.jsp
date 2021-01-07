<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>


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
                        <label for="train">Train</label>
                        <select class="form-control" id="train">
                            <c:forEach var="train" items="${trainsList}">
                                <option value="${train.id}">${train.number} ${train.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="station">Station</label>
                        <select class="form-control" id="station">
                            <c:forEach var="station" items="${stationsList}">
                                <option value="${station.id}">${station.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col">
                <input data-date-format="dd/mm/yyyy" id="datepicker">
            </div>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><script type="text/javascript">
            $('#datepicker').datepicker({
                weekStart: 1,
                daysOfWeekHighlighted: "6,0",
                autoclose: true,
                todayHighlight: true,
            });
            $('#datepicker').datepicker("setDate", new Date());
            </script>

            <br>
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form>
    <c:if test="${empty dto.id}">
        <a href="./"  role="button" class="btn btn-primary btn-lg">Back</a>
    </c:if>
    <c:if test="${!empty dto.id}">
        <a href="../"  role="button" class="btn btn-primary btn-lg">Back</a>
    </c:if>
    <!-- <a href="../"  role="button" class="btn btn-primary btn-lg">Back</a> -->
</div>
</body>
</html>
