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

    <c:if test="${empty dto.id}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty dto.id}">
        <title>Edit</title>
    </c:if>
</head>
<body>
    <c:if test="${empty dto.id}">
        <c:url value="${viewName}/add" var="var"/>
    </c:if>
    <c:if test="${!empty dto.id}">
        <c:url value="${viewName}/edit" var="var"/>
    </c:if>
    <div class="container">
        <div class="row justify-content-md-center">

            <form action="${var}" method="post">
                <c:if test="${!empty dto.id}">
                    <input type="hidden" name="id" value="${dto.id}">
                </c:if>
                <div class="form-col">
                    <div class="row">
                        <label for="username">username</label>
                        <input type="text" class="form-control" name="username" id="username" value="${dto.username}"/>
                    </div>
                    <div class="row">
                        <label for="password">password</label>
                        <input type="text" class="form-control" name="password" id="password" value="${dto.password}"/>
                    </div>
                    <div class="row">
                        <label for="role">role</label>
                        <input type="text" class="form-control" name="role" id="role" value="${dto.role}"/>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
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
