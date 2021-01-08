<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/png" href="/resources/favicon.png" />
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="/resources/css/bootstrap.4.5.3.min.css">
    <title>Admin page</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row text-center">
            <div class="col">
                <h1>Admin page</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <div >
                    <a href="stations"  role="button" class="btn btn-primary btn-lg">Stations list</a>
                </div>
                <br>
                <div>
                    <a href="passengers"  role="button" class="btn btn-primary btn-lg">All passengers list</a>
                </div>
                <br>
                <div>
                    <a href="trains"  role="button" class="btn btn-primary btn-lg">Trains list</a>
                </div>
                <br>
                <div>
                    <a href="schedules"  role="button" class="btn btn-primary btn-lg">Schedules</a>
                </div>
            </div>
            <div class="col-2"></div>

        </div>
    </div>
</body>
</html>
