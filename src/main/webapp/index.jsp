<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="icon" href="assets/logo.png" sizes="32x32" type="image/png">
    <link rel="icon" href="assets/logo.png" sizes="16x16" type="image/png">
    <meta name="theme-color" content="#7952b3">
    <link href="assets/css/home/home.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="header.jsp" />
    <h1>Items in system:</h1>
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6">
        <c:forEach var="item" items="${items}">
            <div class="col-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${item.getName()}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">PC</h6>
                        <p class="card-text">${item.getDescription()}</p>
                        <a href="#" class="btn btn-outline-primary" role="button">Buy</a>
                        <a href="item?id=${item.getId()}" class="btn btn btn-outline-warning" role="button">Open item</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <h5>Total items count: ${size}</h5>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
            crossorigin="anonymous"></script>
</div>
</body>
</html>