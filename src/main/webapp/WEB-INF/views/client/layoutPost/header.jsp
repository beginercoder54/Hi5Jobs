<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value='/css/headerLayoutPost.css'/>" />
<body>
    <div class="main-container">
        <div class="sidebar">
            <div class="section">
                <p class="section-title">Tài khoản</p>
                <div class="item"><a href="${pageContext.request.contextPath}/settings"><img src="${pageContext.request.contextPath}/image/settings.png"> Cài đặt tài khoản</a></div>
            </div>
            <div class="section">
                <p class="section-title">Tuyển Dụng</p>
                <div class="item"><a href="#" onclick="alert('Coming soon'); return false;"><img src="${pageContext.request.contextPath}/image/icon3.png"> Tổng quan</a></div>
                <div class="item"><a href="#" onclick="alert('Coming soon'); return false;"><img src="${pageContext.request.contextPath}/image/icon4.png"> Chiến dịch tuyển dụng</a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/manage-cv"><img src="${pageContext.request.contextPath}/image/icon6.png"> Quản lý tuyển dụng</a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/reports"><img src="${pageContext.request.contextPath}/image/icon7.png"> Báo Cáo</a></div>
            </div>
        </div>
    </div>
</body>
