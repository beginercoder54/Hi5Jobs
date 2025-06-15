<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Hi5Jobs-Register</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    </head>
    <body>
        <div class="container">
            <div class="left-panel">
                <h2 class="slogan">Your Job. Your Team. Your Future</h2>
                <img src="${pageContext.request.contextPath}/image/logo-hi5jobs.png" alt="Hi5Jobs" class="main-image">
            </div>
            <div class="right-panel">
                 <h2>Register</h2>
                <form action="register" method="post" class="register-form">
                   <p style="color: red; margin: 0;"><c:out value="${messages}" /></p>
                    <input type="text" name="username" placeholder="User name" >
                    <input type="text" name="fullName" placeholder="Full name" >
                    <input type="text" name="phone" placeholder="Phone number" >
                    <input type="password" name="password" placeholder="Password" >
                    <input type="password" name="confirmPassword" placeholder="Confirm password" >
                    <button type="submit" class="enter-btn">Enter</button>
                    <div class="divider">Or continue</div>
                </form>
                <div class="social-buttons">
                    <button class="fb-btn">f</button>
                    <button class="google-btn">G</button>
                </div>
                <div class="login-link">
                    Already have an account? <a href="${pageContext.request.contextPath}/login">Log In</a>
                </div>
            </div>
        </div>
    </body>
</html>