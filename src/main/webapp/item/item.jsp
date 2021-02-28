<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${item.getName()}</title>
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
        <jsp:include page="../header.jsp" />
        <div class="row">

            <div class="col-lg">

                <div class="card mt-4">
                    <img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt="">
                    <div class="card-body">
                        <h3 class="card-title">${item.getName()}</h3>
                        <h4>$${item.getPrice()}</h4>
                        <p class="card-text">${item.getDescription()}</p>
                        <c:choose>
                            <c:when test="${reviewScore == 0}"><span class="text-warning">&#9734; &#9734; &#9734; &#9734; &#9734;</span> 0 stars</c:when>
                            <c:when test="${reviewScore == 1}"><span class="text-warning">&#9733; &#9734; &#9734; &#9734; &#9734;</span> 1 star</c:when>
                            <c:when test="${reviewScore == 2}"><span class="text-warning">&#9733; &#9733; &#9734; &#9734; &#9734;</span> 2 stars</c:when>
                            <c:when test="${reviewScore == 3}"><span class="text-warning">&#9733; &#9733; &#9733; &#9734; &#9734;</span> 3 stars</c:when>
                            <c:when test="${reviewScore == 4}"><span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span> 4 stars</c:when>
                            <c:when test="${reviewScore == 5}"><span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9733;</span> 5 stars</c:when>
                            <c:when test="${reviewScore == -1}"><span class="text-warning">No reviews yet</span></c:when>
                            <c:otherwise>undefined</c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <div class="card card-outline-secondary my-4">
                    <div class="card-header">
                        Item Reviews
                    </div>
                    <div class="card-body">
                        <c:if test="${reviews.size() > 0}">
                            <c:forEach var="review" items="${reviews}">
                                <div class="col">
                                    <p>${review.getText()}</p>
                                    <small class="text-muted">Posted by ${review.getCustomer_name()} on ${review.getDate()}</small>
                                    <hr>
                                </div>
                            </c:forEach>
                        </c:if>

                        <a href="#" class="btn btn-success">Leave a Review</a>
                    </div>
                </div>

            </div>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
                crossorigin="anonymous"></script>
    </div>
</body>
</html>
