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
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="header.jsp"/>
        <form action="newItem" method="post">
            <h1 class="h3 mb-3 fw-normal text-center">Add new item:</h1>
            <label for="itemName" class="form-label">Item name</label>
            <input type="text" id="itemName" name="itemName"
                   class="form-control ${itemName != null ? "is-invalid" : ""}" placeholder="Beer 'Hoegarden' 0.5l glass"
                   required="" autofocus=""
                   aria-describedby="validationServerItemNameFeedback"
            >
            <div id="validationServerItemNameFeedback" class="invalid-feedback">
                Please enter item name.
            </div>
            <label for="itemDescription" class="form-label text-start">Item description</label>
            <input type="text" id="itemDescription" name="itemDescription"
                   class="form-control ${itemDescription != null ? "is-invalid" : ""}" placeholder="Best beer for all humans"
                   required="" autofocus=""
                   aria-describedby="validationServerItemDescriptionFeedback"
            >
            <div id="validationServerItemDescriptionFeedback" class="invalid-feedback">
                Please enter item description.
            </div>
            <label for="itemPrice" class="form-label">Item price</label>
            <input pattern="^\d*(\.\d{0,2})?$" id="itemPrice" name="itemPrice"
                   class="form-control ${itemPrice != null ? "is-invalid" : ""}" placeholder="Item price, decimal (ex: 10.58)"
                   required="" autofocus=""
                   aria-describedby="validationServerItemPriceFeedback"
            >
            <div id="validationServerItemPriceFeedback" class="invalid-feedback">
                Please enter item price greater than 0.
            </div>
            <button class="btn btn-outline-success" type="submit" style="margin-top: 10px;">Save</button>
            <c:if test="${InternalError != null}">
                <p><span class="text-warning">Error! Can`t create a new item!</span></p>
            </c:if>
            <c:if test="${isSaved}">
                <p><span class="text-warning">Item saved!</span></p>
            </c:if>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
                crossorigin="anonymous"></script>
    </div>
</body>
</html>
