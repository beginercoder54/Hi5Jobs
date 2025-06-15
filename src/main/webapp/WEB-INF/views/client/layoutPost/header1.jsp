<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/css/headerLayoutPost.css'/>" />


    <div class="header-container">
        <div class="logo">Hi5Jobs</div>
        <div class="header-actions">
            <button>Đăng Tin</button>
            <button>Tìm CV</button>
            <button>Trợ giúp</button>
            <img src="${pageContext.request.contextPath}/image/bell.png" alt="Thông báo" class="icon">
            <img src="${pageContext.request.contextPath}/image/user.png" alt="Avatar" class="avatar">
        </div>
    </div>