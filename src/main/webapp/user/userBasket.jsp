<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User basket</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="icon" href="../assets/logo.png" sizes="32x32" type="image/png">
    <link rel="icon" href="../assets/logo.png" sizes="16x16" type="image/png">
    <meta name="theme-color" content="#7952b3">
    <link href="../assets/css/home/home.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <style>
        .ellipsis {
            max-width: 300px;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="../header.jsp"/>
    <h1>Items in basket:</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th style="width: 106px"></th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody id="basket-table-body">
        </tbody>
    </table>
    <h5>Total price: <span id="basket-total-price">0</span></h5>
    <button class="confirm-order" onclick="confirmOrder()">Confirm</button>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
            crossorigin="anonymous"></script>
</div>
</body>
<script src="../js/userBasket.js"></script>
<script src="../js/header.js"></script>
</html>
