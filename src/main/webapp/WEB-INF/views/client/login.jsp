<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Hi5Jobs-Login</title>
        <link rel="stylesheet" href="<c:url value='/css/login.css?v=5' />" />
    </head>
    <body>
        <div class="container">
            <div class="left-panel">
                <p class="slogan">Your Job. Your Team. Your Future</p>
                <img src="${pageContext.request.contextPath}/image/logo-hi5jobs.png" class="illustration" alt="Hi5Jobs">

            </div>
            <div class  ="right-panel">
                <form action="login" method="post" class="login-form">
                    <h2>Log in</h2>
                    <input type="text" name="username" placeholder="Username" >
                    <input type="password" name="password" placeholder="Password" >
                    <p style="height: 20px; color: red;"><c:out value="${message}" /></p>
                    <button type="submit" class="enter-btn">Log in</button>
                    <div class="divider">Or continue</div>

                </form>
                <div class="social-buttons">
                    <button class="fb-btn" onclick="alert('Coming soon')">f</button>
                    <button class="google-btn" onclick="alert('Coming soon')">G</button>
                </div>
                <div class="register-link">
                    Don't have an account? <a href="${pageContext.request.contextPath}/register">Register</a>
                </div>
            </div>

        </div>
    </body>
</html>
