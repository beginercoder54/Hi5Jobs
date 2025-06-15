<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Hi5Jobs-Login</title>
        <link rel="stylesheet" href="<c:url value='/css/loginSucces.css?v=5'/>" />
    </head>
    <body>
        <div class="container">
            <div class="left-panel">
                <p class="slogan">Your Job. Your Team. Your Future</p>
                <img src="${pageContext.request.contextPath}/image/logo-hi5jobs.png" class="illustration" alt="Hi5Jobs">

            </div>
            <div class  ="right-panel">
                <h2 style="color: red">Registration Successful</h2>
                   <button type="submit" class="enter-btn" onclick="window.location.href='${pageContext.request.contextPath}/login'">Go to login</button>
            </div>

        </div>
    </body>
</html>
