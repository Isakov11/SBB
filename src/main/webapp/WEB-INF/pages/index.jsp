<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <link rel="icon" type="image/png" href="/resources/favicon.png" />
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.4.5.3.min.css">
    <title>Index page</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row text-center">
            <div class="col">
                <sec:authorize access= "hasRole('ADMIN')">
                    <h1>Admin page</h1>
                </sec:authorize>
            </div>
        </div>
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <sec:authorize access="isAuthenticated()">
                    <div>
                        <a href="/admin/stations"  role="button" class="btn btn-primary btn-lg">Stations list</a>
                    </div>
                    <br>
                    <div>
                        <a href="/admin/trains"  role="button" class="btn btn-primary btn-lg">Trains list</a>
                    </div>
                    <br>
                    <div>
                        <a href="/admin/schedules"  role="button" class="btn btn-primary btn-lg">Schedules</a>
                    </div>
                    <br>
                    <div>
                        <a href="/admin/tickets"  role="button" class="btn btn-primary btn-lg">Registered passengers</a>
                    </div>
                    <br>
                    <div>
                        <a href="/admin/passengers"  role="button" class="btn btn-primary btn-lg">All passengers list</a>
                    </div>
                    <br>
                    <div>
                        <a href="/admin/users"  role="button" class="btn btn-primary btn-lg">Users</a>
                    </div>
                    <br>
                </sec:authorize>
                <div>
                    <a href="/wizard/step1"  role="button" class="btn btn-primary btn-lg">Add ticket</a>
                </div>
                <br>
                <sec:authorize access="!isAuthenticated()">
                <div>
                    <a href="/login"  role="button" class="btn btn-primary btn-lg">Login</a>
                </div>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <div>
                        <a href="/logout"  role="button" class="btn btn-primary btn-lg">Logout</a>
                    </div>
                </sec:authorize>
            </div>
            </div>
    </div>
</body>
</html>
