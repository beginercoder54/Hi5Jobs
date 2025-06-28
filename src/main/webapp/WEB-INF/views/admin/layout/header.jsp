<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value='/css/headerLayoutPost.css'/>" />
<body>
    <div class="main-container">
        <div class="sidebar">
            <div class="section">
                <p class="section-title">Quản lý người dùng</p>
                <div class="item"><a href="${pageContext.request.contextPath}/admin/home"><img src="${pageContext.request.contextPath}/image/settings.png"> Quản lý ứng viên</a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/admin/homeRe"><img src="${pageContext.request.contextPath}/image/settings.png"> Quản lý nhà truyển dụng</a></div>
            </div>
            <div class="section">
                <p class="section-title">Quản lý thông tin</p>
                <div class="item"><a href="${pageContext.request.contextPath}/admin/job" ><img src="${pageContext.request.contextPath}/image/icon3.png"> Quản lý việc làm</a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/admin/application"><img src="${pageContext.request.contextPath}/image/icon4.png"> Quản lý ứng tuyển</a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/admin/manage-cv"><img src="${pageContext.request.contextPath}/image/icon6.png"> Quản lý CV</a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/admin/reports"><img src="${pageContext.request.contextPath}/image/icon7.png"> Báo Cáo</a></div>
            </div>
        </div>
    </div>
</body>
