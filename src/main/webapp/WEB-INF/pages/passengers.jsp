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

    <title>Passenger</title>
</head>
<body>

<div class="container">
   <div class="row justify-content-md-center">
   <table class="table table-striped table-bordered">
       <thead>
       <tr>
           <th scope="col">Name</th>
           <th scope="col">Second name</th>
           <th scope="col">Birth date</th>
       </tr>
       </thead>
       <tbody>
            <c:forEach var="dto" items="${DTOList}">
                <tr>
                    <td>${dto.name}</td>
                    <td>${dto.secondName}</td>
                    <td>${dto.birthDate}</td>
                </tr>
            </c:forEach>
       </tbody>
   </table>
   </div>
</div>
</body>
</html>