<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>Signin Template · Bootstrap v5.0</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <!-- Favicons -->
    <link rel="icon" href="assets/logo.png" sizes="32x32" type="image/png">
    <link rel="icon" href="assets/logo.png" sizes="16x16" type="image/png">
    <meta name="theme-color" content="#7952b3">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }

            login-handler
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="assets/css/sign-in/signin.css" rel="stylesheet">
    <style type="text/css">.backpack.dropzone {
        font-family: 'SF UI Display', 'Segoe UI';
        font-size: 15px;
        text-align: center;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: 250px;
        height: 150px;
        font-weight: lighter;
        color: white;
        will-change: right;
        z-index: 2147483647;
        bottom: 20%;
        background: #333;
        position: fixed;
        user-select: none;
        transition: left .5s, right .5s;
        right: 0px;
    }

    .backpack.dropzone .animation {
        height: 80px;
        width: 250px;
        background: url("chrome-extension://lifbcibllhkdhoafpjfnlhfpfgnpldfl/assets/backpack/dropzone/hoverstate.png") left center;
    }

    .backpack.dropzone .title::before {
        content: 'Save to';
    }

    .backpack.dropzone.closed {
        right: -250px;
    }

    .backpack.dropzone.hover .animation {
        animation: sxt-play-anim-hover 0.91s steps(21);
        animation-fill-mode: forwards;
        background: url("chrome-extension://lifbcibllhkdhoafpjfnlhfpfgnpldfl/assets/backpack/dropzone/hoverstate.png") left center;
    }

    @keyframes sxt-play-anim-hover {
        from {
            background-position: 0px;
        }
        to {
            background-position: -5250px;
        }
    }

    .backpack.dropzone.saving .title::before {
        content: 'Saving to';
    }

    .backpack.dropzone.saving .animation {
        background: url("chrome-extension://lifbcibllhkdhoafpjfnlhfpfgnpldfl/assets/backpack/dropzone/saving_loop.png") left center;
        animation: sxt-play-anim-saving steps(59) 2.46s infinite;
    }

    @keyframes sxt-play-anim-saving {
        100% {
            background-position: -14750px;
        }
    }

    .backpack.dropzone.saved .title::before {
        content: 'Saved to';
    }

    .backpack.dropzone.saved .animation {
        background: url("chrome-extension://lifbcibllhkdhoafpjfnlhfpfgnpldfl/assets/backpack/dropzone/saved.png") left center;
        animation: sxt-play-anim-saved steps(20) 0.83s forwards;
    }

    @keyframes sxt-play-anim-saved {
        100% {
            background-position: -5000px;
        }
    }
    </style>
    <meta id="Reverso_extension___elForCheckedInstallExtension" name="Reverso extension" content="2.2.202">
    <script src="chrome-extension://mooikfkahbdckldjjndioackbalphokd/assets/prompt.js"></script>
</head>
<body class="text-center">

<main class="form-signin">
    <form action="login" method="post">
        <a href="./">
            <img class="mb-4" src="assets/logo.png" alt="" width="72" height="57">
        </a>
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        <label for="inputEmail" class="visually-hidden">Email address</label>
        <input type="text" id="inputEmail" name="email"
               class="form-control ${error != null ? "is-invalid" : ""}" placeholder="Email address"
               required="" autofocus=""
               aria-describedby="validationServerUsernameFeedback"
        >
        <div id="validationServerUsernameFeedback" class="invalid-feedback">
            Please enter a valid username.
        </div>
        <label for="inputPassword" class="visually-hidden">Password</label>
        <input type="password" id="inputPassword" name="password"
               class="form-control ${error != null ? "is-invalid" : ""}" placeholder="Repeat Password"
               required=""
               aria-describedby="validationServerPasswordFeedback"
        >
        <div id="validationServerPasswordFeedback" class="invalid-feedback">
            Please enter a valid password.
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <a type="button" class="btn btn-link" href="register">or register</a>
        <p class="mt-5 mb-3 text-muted">© 2021</p>
    </form>

</main>


</body>
</html>