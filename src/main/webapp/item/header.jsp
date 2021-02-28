<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01"
                aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="../">
                <img style="background-color: orange;padding-right: 8px;" src="../assets/logo-alt.svg" alt="" width="98"
                     height="43">
            </a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="../">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Categories</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../item/itemManagement">Items admin page</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
            <%
                if (session.getAttribute("user") != null) {
            %>
            <span class="navbar-text px-2">
                    Welcome ${sessionScope.user.firstname}!
                </span>
            <form action="logout" class="d-flex">
                <button class="btn btn-dark" type="submit"><i class="bi bi-box-arrow-in-right"></i></button>
            </form>
            <% } else {
            %>
            <a class="btn btn-link" type="button" href="../login.jsp">Log in</a>
            <%
                }
            %>
        </div>
    </div>
</nav>
