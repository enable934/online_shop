<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Item admin page (edit)</title>
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
        <jsp:include page="../header.jsp"/>
        <form action="editItem" method="post">
            <h1 class="h3 mb-3 fw-normal text-center">Update item:</h1>
            <label for="editItemItemName" class="form-label">Item name (old one: ${item.getName()}})</label>
            <input type="text" id="editItemItemName" name="editItemItemName"
                   class="form-control ${itemName != null ? "is-invalid" : ""}" placeholder="${item.getName()}"
                   value="${item.getName()}"
                   required="" autofocus=""
                   aria-describedby="validationServerItemNameFeedback"
            >
            <div id="validationServerItemNameFeedback" class="invalid-feedback">
                Please enter item name.
            </div>
            <label for="editItemItemDescription" class="form-label text-start">Item description (old one: ${item.getDescription()})</label>
            <input type="text" id="editItemItemDescription" name="editItemItemDescription"
                   class="form-control ${itemDescription != null ? "is-invalid" : ""}" placeholder="${item.getDescription()}"
                   value="${item.getDescription()}"
                   required="" autofocus=""
                   aria-describedby="validationServerItemDescriptionFeedback"
            >
            <div id="validationServerItemDescriptionFeedback" class="invalid-feedback">
                Please enter item description.
            </div>
            <label for="editItemItemPrice" class="form-label">Item price (old one: ${item.getPrice()})</label>
            <input pattern="^\d*(\.\d{0,2})?$" id="editItemItemPrice" name="editItemItemPrice"
                   class="form-control ${itemPrice != null ? "is-invalid" : ""}" placeholder="${item.getPrice()}"
                   value="${item.getPrice()}"
                   required="" autofocus=""
                   aria-describedby="validationServerItemPriceFeedback"
            >
            <div id="validationServerItemPriceFeedback" class="invalid-feedback">
                Please enter item price greater than 0.
            </div>
            <button class="btn btn-outline-success" type="submit" style="margin-top: 10px;">Save</button>
            <c:if test="${editItemItemPrice != null}">
                <p><span class="text-warning">Error! Incorrect price! Value should be grater than 0!</span></p>
            </c:if>
            <c:if test="${editItemSameObjects != null}">
                <p><span class="text-warning">Error! Update any item field to perform update!</span></p>
            </c:if>
            <c:if test="${InternalError != null}">
                <p><span class="text-warning">Error! Can`t edit current item!</span></p>
            </c:if>
            <c:if test="${editItemIsSaved}">
                <p><span class="text-warning">Item edit saved!</span></p>
            </c:if>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
                crossorigin="anonymous"></script>
    </div>
</body>
</html>
