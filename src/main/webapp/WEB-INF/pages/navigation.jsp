<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">SBB</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <a class="nav-link active" href="/index">Home</a>
            <a class="nav-link active" href="/wizard/step1">Buy ticket</a>
            <a class="nav-link active" href="/admin/stations">Stations list</a>
            <a class="nav-link active" href="/admin/trains">Trains list</a>
            <sec:authorize access="isAuthenticated()">
                <a class="nav-link active" href="/admin/schedules">Schedules</a>
                <a class="nav-link active" href="/admin/tickets">Registered passengers</a>
                <a class="nav-link active" href="/admin/passengers">All passengers list</a>
                <a class="nav-link active" href="/admin/users">Users</a>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <a class="nav-link active" href="/login">Log in</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a class="nav-link active" href="/logout">Log out</a>
            </sec:authorize>

        </div>
    </div>
</nav>

