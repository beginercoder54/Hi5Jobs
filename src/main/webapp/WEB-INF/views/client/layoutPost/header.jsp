<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value='/css/headerLayoutPost.css'/>" />
<body>
    <div class="main-container">
        <div class="sidebar">
            <div class="section">
                <p class="section-title">Tài khoản</p>
                <div class="item"><a href="${pageContext.request.contextPath}/settings"><img src="icon1.png"> Cài đặt tài khoản</a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/profile-manage"><img src="icon2.png"> Quản lý hồ sơ</a></div>
            </div>
            <div class="section">
                <p class="section-title">Tuyển Dụng</p>
                <div class="item"><a href="${pageContext.request.contextPath}/overview"><img src="icon3.png"> Tổng quan</a></div>
                <div class="item"><a href="#" onclick="alert('Coming soon'); return false;"><img src="icon4.png"> Chiến dịch tuyển dụng</a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/job-search"><img src="icon5.png"> Tìm Tuyển Dụng</a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/manage-cv"><img src="icon6.png"> Quản lý CV</a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/reports"><img src="icon7.png"> Báo Cáo</a></div>
            </div>
        </div>
        <div class="content-area">
            <!-- Nội dung chính ở đây -->
        </div>
    </div>
</body>
