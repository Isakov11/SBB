<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <c:if test="${empty dto.id}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty dto.id}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<c:if test="${empty dto.id}">
    <c:url value="${viewName}/add" var="var"/>
</c:if>
<c:if test="${!empty dto.id}">
    <c:url value="${viewName}/edit" var="var"/>
</c:if>
<div class="container-fluid">
    <div class="row justify-content-center">

        <form:form modelAttribute="dto" action="${var}" method="post">
            <c:if test="${!empty dto.id}">
                <input type="hidden" name="id" value="${dto.id}">
            </c:if>
            <div class="form-col justify-content-center">
                <div class="row my-sm-2">
                    <label for="name">Station name</label>
                    <input type="text" class="form-control" name="name" id="name" value="${dto.name}"
                           required     autofocus/>
                    <form:errors path="name"/>
                </div>
                <div class="row my-sm-3 justify-content-center">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </div>
        </form:form>
    </div>

</div>

</body>
</html>
