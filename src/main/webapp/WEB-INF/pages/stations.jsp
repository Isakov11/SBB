<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.4.5.3.min.css">

    <title>Station List</title>
</head>
<body>

<div class="container">
    <div class="row justify-content-md-center">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Road Id</th>
                <th scope="col">Schedule</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="entity" items="${DTOList}">
                <tr>
                    <td>${entity.name}</td>
                    <td>${entity.roadId}</td>
                    <td><c:forEach var="sched" items="${entity.stationSchedule}">
                        ${sched.toString()}<br>
                    </c:forEach>
                    </td>
                    <td>
                        <form action="../${viewName}/edit/${entity.id}" method="get">
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </form>
                        <br>
                        <form action="../${viewName}/delete/${entity.id}" method="get">
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="../${viewName}/add"  role="button" class="btn btn-primary btn-lg">Add station</a>
    </div>
    <a href="/"  role="button" class="btn btn-primary btn-lg">Back to admin page</a>
</div>
</body>
</html>