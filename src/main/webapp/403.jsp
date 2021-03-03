<html lang="en">
<head>
    <meta charset="UTF-8">

    <link rel="apple-touch-icon" type="image/png"
          href="https://cpwebassets.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png">
    <meta name="apple-mobile-web-app-title" content="CodePen">

    <link rel="shortcut icon" type="image/x-icon"
          href="https://cpwebassets.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico">

    <link rel="mask-icon" type=""
          href="https://cpwebassets.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg"
          color="#111">


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Access not granted!</title>

    <link rel="stylesheet" media="screen"
          href="https://cpwebassets.codepen.io/assets/fullpage/fullpage-4de243a40619a967c0bf13b95e1ac6f8de89d943b7fc8710de33f681fe287604.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400italic,700,700italic,900,900italic&amp;display=swap"
          rel="stylesheet">


    <link rel="apple-touch-icon" type="image/png"
          href="https://cpwebassets.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png">
    <meta name="apple-mobile-web-app-title" content="CodePen">

    <link rel="shortcut icon" type="image/x-icon"
          href="https://cpwebassets.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico">

    <link rel="mask-icon" type=""
          href="https://cpwebassets.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg"
          color="#111">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="icon" href="assets/logo.png" sizes="32x32" type="image/png">
    <link rel="icon" href="assets/logo.png" sizes="16x16" type="image/png">
    <meta name="theme-color" content="#7952b3">
    <link href="assets/css/home/home.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <title>Access not granted!</title>
    <script>
        if (document.location.search.match(/type=embed/gi)) {
            window.parent.postMessage("resize", "*");
        }
    </script>


    <style>
        html {
            font-size: 15px;
        }

        html, body {
            margin: 0;
            padding: 0;
            min-height: 100%;
        }

        body {
            height: 100%;
            display: flex;
            flex-direction: column;
        }

        .referer-warning {
            background: black;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.5);
            padding: 0.75em;
            color: white;
            text-align: center;
            font-family: 'Lato', 'Lucida Grande', 'Lucida Sans Unicode', Tahoma, Sans-Serif;
            line-height: 1.2;
            font-size: 1rem;
            position: relative;
            z-index: 2;
        }

        .referer-warning h1 {
            font-size: 1.2rem;
            margin: 0;
        }

        .referer-warning a {
            color: #56bcf9;
        }

        /* $linkColorOnBlack */
    </style>
</head>

<body class="">
<div class="container-fluid">
    <jsp:include page="header.jsp"/>
</div>
<div id="result-iframe-wrap" role="main">

    <iframe id="result" srcdoc="
<!DOCTYPE html>
<html lang=&quot;en&quot; >

<head>

  <meta charset=&quot;UTF-8&quot;>

<link rel=&quot;apple-touch-icon&quot; type=&quot;image/png&quot; href=&quot;https://cpwebassets.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png&quot; />
<meta name=&quot;apple-mobile-web-app-title&quot; content=&quot;CodePen&quot;>

<link rel=&quot;shortcut icon&quot; type=&quot;image/x-icon&quot; href=&quot;https://cpwebassets.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico&quot; />

<link rel=&quot;mask-icon&quot; type=&quot;&quot; href=&quot;https://cpwebassets.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg&quot; color=&quot;#111&quot; />

  <title>CodePen - #Codepenchallenge Persistence is 🔑</title>
  <meta charset=&quot;UTF-8&quot;/>
<meta name=&quot;viewport&quot; content=&quot;width=device-width, initial-scale=1.0&quot;/>
<meta http-equiv=&quot;X-UA-Compatible&quot; content=&quot;ie=edge&quot;/>



<style>
@import url('https://fonts.googleapis.com/css?family=Open+Sans|Nova+Mono');
:root {
  --font-header: 'Nova Mono', monospace;
  --font-text: 'Open Sans', sans-serif;
  --color-theme: #F1EEDB;
  --color-bg: #282B24;

  --animation-sentence: 'You know you\'re supposed to leave, right?';
  --animation-duration: 40s;
}
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
body {
  width: 100%;
  font-family: var(--font-text);
  color: var(--color-theme);
  background: var(--color-bg);
  overflow: hidden;
}
.container {
  text-align: center;
  margin: 1rem 0.5rem 0;
}
.container h1 {
  font-family: var(--font-header);
  font-size: calc(4rem + 2vw);
	text-transform: uppercase;
}
.container p {
  text-transform: uppercase;
  letter-spacing: 0.2rem;
  font-size: 2rem;
  margin: 1.5rem 0 3rem;
}
svg.keyhole {
  height: 82px;
  width: 82px;
  opacity: 0;
  visibility: hidden;
  /* define an animation for the keyhole, to introduce it
  paused by default, run with a timeout in JavaScript
  */
  animation: showKey 0.5s 0.5s paused ease-out forwards;
}
svg.key {
  height: 164px;
  width: 164px;
  position: absolute;
  opacity: 0;
  visibility: hidden;
  /* define an animation for the keyhole, to introduce it
  paused by default, run with a timeout in JavaScript
  */
  animation: showKey 0.5s 0.5s paused ease-out forwards;
}
.ghost {
  /* border: 1px solid tomato; */
  position: absolute;
  bottom: 5px;
  left: calc(50% - 100px);
  width: 200px;
  height: 200px;
  /* have the ghost move to the right and to the left of the screen, turning to its central position and repeating the animation twice */
  animation: hoverGhost calc(var(--animation-duration)/2) ease-in-out 2;

}
/* introduce text through a pseudo element, connected to the animated div */
.ghost:before {
  content: var(--animation-sentence);
  color: var(--color-theme);
  border-radius: 50%;
  position: absolute;
  bottom: 100%;
  text-align: center;
  line-height: 2;
  padding: 1rem;
  visibility: hidden;
  opacity: 0;
  /* have each string of text introduced as the ghost returns from the right edge of the screen, and for the length of time it takes to cover the central portion (a fourth, which becomes an eight as the animation length is half the total duration) */
  /* the delay for an hypothetical duration of 40s is 7.5s for the first, 27.5s for the second and finally 40s for the last
  in fractions and with a bit of math it boils down to 3/16, 27/40 and 1
  // ! remember to include a slight delay in the animation of the key and keyhole
  */
  animation:
    showText calc(var(--animation-duration)/8) calc(var(--animation-duration)*3/16) ease-out forwards,
    showNewText calc(var(--animation-duration)/8) calc(var(--animation-duration)*27/40) ease-out forwards,
    showFinalText calc(var(--animation-duration)/8) var(--animation-duration) ease-out forwards;

}

/* define the keyframe animations
- hoverghost to have the ghost move right, left and then back to its default position
- showKey to introduce into view the key (and keyhole) svg
- showText, showNewText, showFinalText to show the different strings (the implementation is quite quirky and primed for optimization)
 */
@keyframes hoverGhost {
  25% {
    transform: translateX(20vw);
  }
  75% {
    transform: translateX(-20vw);
  }
}

@keyframes showKey {
  to {
    opacity: 1;
    visibility: visible;
  }
}


/* alter the text changing the value of the custom property, weary of changing its value when the pseudo element is hidden and changing its value in the last keyframe (as the animation gives this value as per the &quot;forwards&quot; value of the fill-mode property)  */
@keyframes showText {
  2% {
    opacity: 1;
    visibility: visible;
  }
  98% {

    opacity: 1;
    visibility: visible;
  }
  99% {
    --animation-sentence: 'You know you\'re supposed to leave, right?';
    opacity: 0;
    visibility: hidden;
  }
  100% {
    --animation-sentence: 'So much to do, so little time...';
  }
}
@keyframes showNewText {
  2% {
    --animation-sentence: 'So much to do, so little time...';
    opacity: 1;
    visibility: visible;
  }
  98% {

    opacity: 1;
    visibility: visible;
  }
  99% {
    --animation-sentence: 'So much to do, so little time...';
    opacity: 0;
    visibility: hidden;
  }
  100% {
    --animation-sentence: 'Okay, you seem to care about this. Here\'s a key just for you';
  }
}
@keyframes showFinalText {
  2% {
    opacity: 1;
    visibility: visible;
  }
  98% {
    opacity: 1;
    visibility: visible;
  }
  100% {
    opacity: 0;
    visibility: hidden;
  }
}
</style>

  <script>
  window.console = window.console || function(t) {};
</script>



  <script>
  if (document.location.search.match(/type=embed/gi)) {
    window.parent.postMessage(&quot;resize&quot;, &quot;*&quot;);
  }
</script>


</head>

<body translate=&quot;no&quot; >
  <!-- include the svg assets later used in the project -->
<svg style=&quot;display: none;&quot;>
  <symbol id=&quot;keyhole&quot; xmlns=&quot;http://www.w3.org/2000/svg&quot; width=&quot;100&quot; height=&quot;100&quot; viewBox=&quot;0 0 26.458333 26.458334&quot;><g transform=&quot;translate(0 -270.542)&quot;><circle cx=&quot;13.229&quot; cy=&quot;279.141&quot; r=&quot;8.599&quot; fill=&quot;#f1eedb&quot; paint-order=&quot;stroke fill markers&quot;/><path d=&quot;M10.516 283.271h5.427c1.164 0 1.768.861 2.102 1.802l3.59 10.125c.334.94-.937 1.802-2.102 1.802H6.926c-1.165 0-2.437-.861-2.103-1.802l3.59-10.125c.334-.94.938-1.802 2.103-1.802z&quot; fill=&quot;#f1eedb&quot; paint-order=&quot;stroke fill markers&quot;/><circle r=&quot;6.06&quot; cy=&quot;279.141&quot; cx=&quot;13.229&quot; fill=&quot;#282b24&quot; paint-order=&quot;stroke fill markers&quot;/><path d=&quot;M11.502 283.76h3.455c.741 0 1.126.733 1.338 1.534l2.286 8.614c.213.8-.597 1.534-1.338 1.534H9.216c-.742 0-1.551-.733-1.339-1.534l2.286-8.614c.212-.8.597-1.534 1.339-1.534z&quot; fill=&quot;#282b24&quot; paint-order=&quot;stroke fill markers&quot;/></g></symbol>
  <symbol id=&quot;key&quot; xmlns=&quot;http://www.w3.org/2000/svg&quot; width=&quot;100&quot; height=&quot;100&quot; viewBox=&quot;0 0 26.458333 26.458334&quot;><circle cx=&quot;13.229&quot; cy=&quot;279.141&quot; r=&quot;8.599&quot; paint-order=&quot;stroke fill markers&quot; transform=&quot;matrix(0 -.76923 .7499 0 -202.882 23.405)&quot; fill=&quot;#f1eedb&quot;/><circle r=&quot;8.599&quot; cy=&quot;279.141&quot; cx=&quot;13.229&quot; paint-order=&quot;stroke fill markers&quot; transform=&quot;matrix(0 -.5887 .57392 0 -153.756 21.017)&quot; fill=&quot;#282b24&quot;/><path fill=&quot;#f1eedb&quot; paint-order=&quot;stroke fill markers&quot; d=&quot;M12.03 12.13h14.428v2.2H12.03z&quot;/><path fill=&quot;#f1eedb&quot; paint-order=&quot;stroke fill markers&quot; d=&quot;M18.147 12.13h2.895v6.772h-2.895zM22.113 12.13h2.716v5.065h-2.716z&quot;/></symbol>
  <symbol id=&quot;ghost&quot; xmlns=&quot;http://www.w3.org/2000/svg&quot; width=&quot;100&quot; height=&quot;100&quot; viewBox=&quot;0 0 26.458333 26.458334&quot;><g transform=&quot;translate(0 -270.542)&quot;><path d=&quot;M4.63 279.293c0-4.833 3.85-8.751 8.6-8.751 4.748 0 8.598 3.918 8.598 8.75H13.23zM4.725 279.293h16.914c.052 0 .19.043.19.096l-.095 14.329c0 .026-.011.05-.028.068a.093.093 0 0 1-.067.028c-.881 0-1.235-1.68-2.114-1.616-.995.072-1.12 2.082-2.114 2.154-.88.064-1.233-1.615-2.115-1.615-.881 0-1.233 1.615-2.114 1.615-.881 0-1.233-1.615-2.114-1.615-.882 0-1.236 1.679-2.115 1.615-.994-.072-1.12-2.082-2.114-2.154-.88-.063-1.41 1.077-2.114 1.616-.021.016-.05-.01-.067-.028a.097.097 0 0 1-.028-.068v-14.33c0-.052.042-.095.095-.095z&quot; fill=&quot;#f1eedb&quot; paint-order=&quot;stroke fill markers&quot;/><path d=&quot;M15.453 281.27a1.987 1.94 0 0 1-.994 1.68 1.987 1.94 0 0 1-1.987 0 1.987 1.94 0 0 1-.994-1.68h1.988z&quot; fill=&quot;#282b24&quot; paint-order=&quot;stroke fill markers&quot;/><g fill=&quot;#282b24&quot; transform=&quot;matrix(1 0 0 1.0177 .283 -5.653)&quot;><ellipse cx=&quot;10.205&quot; cy=&quot;278.668&quot; rx=&quot;1.231&quot; ry=&quot;1.181&quot; paint-order=&quot;stroke fill markers&quot;/><ellipse ry=&quot;1.181&quot; rx=&quot;1.231&quot; cy=&quot;278.668&quot; cx=&quot;16.159&quot; paint-order=&quot;stroke fill markers&quot;/><ellipse ry=&quot;.331&quot; rx=&quot;.853&quot; cy=&quot;280.936&quot; cx=&quot;10.205&quot; opacity=&quot;.5&quot; paint-order=&quot;stroke fill markers&quot;/><ellipse cx=&quot;16.159&quot; cy=&quot;280.936&quot; rx=&quot;.853&quot; ry=&quot;.331&quot; opacity=&quot;.5&quot; paint-order=&quot;stroke fill markers&quot;/></g><ellipse ry=&quot;.614&quot; rx=&quot;8.082&quot; cy=&quot;296.386&quot; cx=&quot;13.229&quot; opacity=&quot;.1&quot; fill=&quot;#f1eedb&quot; paint-order=&quot;stroke fill markers&quot;/></g></symbol>

</svg>

<!-- include in a container a heading, paragraph and svg for the keyhole -->
<div class=&quot;container&quot;>
  <h1>403</h1>
  <p>access not granted</p>
  <svg class=&quot;keyhole&quot;>
    <use href=&quot;#keyhole&quot;/>
  </svg>
</div>

<!-- outside of the container, to have them absolute positioned in relation to the body, include an svg for the key and one for the ghost -->
<svg class=&quot;key&quot;>
  <use href=&quot;#key&quot;/>
</svg>

<!--
  ! nest the svg in a vi, give the svg and vi the same class
  the div and svg behave differently when translating the element through the transform property, giving a nice distance between the text (included with a pseudo element on the div) and the svg
-->
<div class=&quot;ghost&quot;>
  <svg class=&quot;ghost&quot;>
    <use href=&quot;#ghost&quot;/>
  </svg>
</div>
    <script src=&quot;https://cpwebassets.codepen.io/assets/common/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js&quot;></script>


      <script id=&quot;rendered-js&quot; >
// target the elements in the DOM used in the project

/**
 * svg for the key and keyhole
 * div nesting the ghost
 * heading and paragraph
 */
const key = document.querySelector(&quot;.key&quot;);
const keyhole = document.querySelector(&quot;.keyhole&quot;);
const ghost = document.querySelector(&quot;.ghost&quot;);

const heading = document.querySelector(&quot;h1&quot;);
const paragraph = document.querySelector(&quot;p&quot;);


// for the length of the timout, consider the --animation-duration custom property and add a small delay
// retrieve properties on the root element
const root = document.querySelector(&quot;:root&quot;);
const rootStyles = getComputedStyle(root);
// retrieve the animation-duration custom property
// ! this is specified as &quot;40s&quot;, in seconds, so parse the number and includ it in milliseconds
const animationDuration = parseInt(rootStyles.getPropertyValue(&quot;--animation-duration&quot;)) * 1000;
let keyTimer = animationDuration * 9 / 8;


// retrieve the dimensions of the key (to have the key exactly where the cursor would lie)
const keyBox = key.getBoundingClientRect();
// console.log(keyBox);


// KEY &amp; KEYHOLE ANIMATION
// include a timeout with the specified time frame
const timeoutID = setTimeout(() => {
  // after the specified time, change the cursor as to seemingly grab the key
  key.parentElement.parentElement.style.cursor = &quot;grab&quot;;

  // introduce the key and keyhole svg elements by triggering the paused-by-default animation
  key.style.animationPlayState = &quot;running&quot;;
  keyhole.style.animationPlayState = &quot;running&quot;;

  // ! pointer-events set to none on the key to allow for a mouseover event on the keyhole
  // the key is indeed used in stead of the normal cursor and would overlap on top of everything
  key.style.pointerEvents = &quot;none&quot;;

  // when the cursor hovers anywhere in the window, call a function to update the position of the key and have it match the cursor
  window.addEventListener(&quot;mousemove&quot;, updateKeyPosition);

  // when the cursor hovers on the keyhole, call a function to grant access and remove present listeners
  keyhole.addEventListener(&quot;mouseover&quot;, grantAccess);

  clearTimeout(timeoutID);
}, keyTimer);


// define the function which updates the position of the absolute-positioned key according to the mouse coordinates (and the keys own dimensions)
const updateKeyPosition = e => {
  let x = e.clientX;
  let y = e.clientY;
  key.style.left = x - keyBox.width / 1.5;
  key.style.top = y - keyBox.height / 2;
};

// define the function which notifies the user of the grant access
const grantAccess = () => {
  // restore the cursor
  key.parentElement.parentElement.style.cursor = &quot;default&quot;;

  // change the text of the heading and paragraph elements
  heading.textContent = '🎉 yay 🎉';
  paragraph.textContent = 'access granted';

  // remove the svg elements for the key and keywhole from the flow of the document
  keyhole.style.display = &quot;none&quot;;
  key.style.display = &quot;none&quot;;

  // remove the event listeners, most notably the one on the window
  window.removeEventListener(&quot;mousemove&quot;, updateKeyPosition);
  keyhole.removeEventListener(&quot;mouseover&quot;, grantAccess);
};
//# sourceURL=pen.js
    </script>



</body>

</html>

"
            sandbox="allow-downloads allow-forms allow-modals allow-pointer-lock allow-popups allow-presentation  allow-scripts allow-top-navigation-by-user-activation"
            allow="accelerometer; camera; encrypted-media; geolocation; gyroscope; microphone; midi"
            allowtransparency="true" allowpaymentrequest="true" allowfullscreen="true" class="result-iframe">
    </iframe>

</div>


</body>
</html>