<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Thông báo</title>
        <style>
            .notification-card {
                display: flex;
                background-color: #f1f1f1;
                padding: 15px;
                border-radius: 15px;
                width: fit-content;
                align-items: center;
                gap: 15px;
                font-family: Arial, sans-serif;
                margin-bottom: 10px;
            }

            .icon1 {
                width: 50px;
                height: 50px;
                background-color: #5bd6d2;
                border-radius: 50%;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .icon1 img {
                width: 24px;
                height: 24px;
            }

            .notification-content .title {
                margin: 0;
                font-weight: bold;
                font-size: 16px;
                color: #000;
            }

            .notification-content .subtitle {
                margin: 2px 0;
                color: #333;
            }

            .notification-content .date {
                margin: 0;
                font-size: 13px;
                color: #888;
            }
        </style>
    </head>
    <body>
        <h3>Thông báo</h3>

    <c:forEach var="a" items="${a}">
        <div class="notification-card">
            <div class="icon1">
                <img src="${pageContext.request.contextPath}/image/bell.png" alt="notification icon" />
            </div>
            <div class="notification-content">
                <p class="title">${a.message}</p>
                <p class="subtitle">${a.nameUser}</p>
                <p class="date">
                <fmt:formatDate value="${a.date}" pattern="dd/MM/yyyy HH:mm" />
                </p>
            </div>
        </div>
    </c:forEach>

</body>
</html>
