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
        <title>Login page</title>
    </head>
    <body>
    <div class="container-fluid">
        <div class="row my-5">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
            <form action="/login" method="post">
                <div class="form-group row">
                    <label for="username" class="col-sm-2 col-form-label">Username</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="username" name="username" placeholder="username" required="true" autofocus="true"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="Password" name="password" placeholder="password" required="true"/>
                    </div>
                </div>
                <div class="form-group row justify-content-center">
                    <button type="submit" class="btn btn-primary">Log in</button>
                </div>
            </form>
            </div>
        </div>
    </div>
    </body>
</html>