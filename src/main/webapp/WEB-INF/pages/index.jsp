<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>Admin page</title>
</head>
<body>
    <div class="container">
        <div class="col justify-content-md-center">
            <div>
                <h1>Admin page</h1>
            </div>
            <div class="row">
                <a href="/stations"  role="button" class="btn btn-primary btn-lg">Stations list</a>
            </div>
            <br>
            <div class="row">
                <a href="/passengers"  role="button" class="btn btn-primary btn-lg">All passengers list</a>
            </div>
            <br>
            <div class="row">
                <a href="/trains"  role="button" class="btn btn-primary btn-lg">Trains list</a>
            </div>
            <br>
            <div class="row">
                <a href="/schedules"  role="button" class="btn btn-primary btn-lg">Schedules</a>
            </div>
        </div>
    </div>
</body>
</html>
