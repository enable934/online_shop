<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Item admin page</title>
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
        <a href="newItem" class="btn btn btn-outline-warning" role="button" style="margin-top: 10px;">Create new item</a>
        <h1>Items in system:</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th class="ellipsis">Description</th>
                    <th>Price</th>
                    <th style="width: 106px"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr><td>${item.getName()}</td>
                        <td class="ellipsis">${item.getDescription()}</td>
                        <td>${item.getPrice()}</td>
                        <td>
                            <a href="editItem?id=${item.getId()}" class="btn btn-primary" role="button"><i class="bi bi-pencil-square"></i></a>
                            <form method="post" action='<c:url value="/item/deleteItem"/>' style="display:inline;">
                                <input type="hidden" name="targetId" value="${item.getId()}">
                                <button type="submit" class="btn btn-danger" role="button"><i class="bi bi-trash"></i></button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h5>Total items count: ${size}</h5>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
                crossorigin="anonymous"></script>
    </div>
</body>
</html>
