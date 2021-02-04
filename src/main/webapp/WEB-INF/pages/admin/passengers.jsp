<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <title>Passengers</title>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container-fluid">
    <div class="row justify-content-md-center">
        <h1>Passengers list</h1>
    </div>
    <div class="row justify-content-start">
        <div class="col-2 justify-content-center">
            <a href="${viewName}/add" role="button" class="btn btn-primary btn-lg">Add passenger</a>
        </div>
        <div class="col-8 justify-content-center">
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Second name</th>
                    <th scope="col">Birth date</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dto" items="${DTOList}">
                    <tr>
                        <td>${dto.name}</td>
                        <td>${dto.secondName}</td>
                        <td>${dto.birthDate.toString()}</td>
                        <td>
                            <form action="${viewName}/edit/${dto.id}" method="get">
                                <button type="submit" class="btn btn-primary">Edit</button>
                            </form>
                            <br>
                            <form action="${viewName}/delete/${dto.id}" method="get">
                                <button type="submit" class="btn btn-primary">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>