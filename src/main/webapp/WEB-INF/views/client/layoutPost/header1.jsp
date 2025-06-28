<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/css/headerLayoutPost.css'/>" />


<div class="header-container">
    <div class="logo">Hi5Jobs</div>
    <div class="header-actions">
        <a href="${pageContext.request.contextPath}/post"><button>Đăng Tin</button></a>
        <a href="${pageContext.request.contextPath}/homepage"><button>Trang chủ</button></a>
        <button onclick ="alert('Coming soon')";>Trợ giúp</button>
        <a href="${pageContext.request.contextPath}/notification-re"><img src="${pageContext.request.contextPath}/image/bell.png" alt="Thông báo" class="icon"></a>
        <a href="${pageContext.request.contextPath}/settings"><img src="${user.base64Image != null ? 'data:image/jpeg;base64,'.concat(user.base64Image) : pageContext.request.contextPath.concat('/image/user.png')}" alt="Avatar" class="avatar"></a>
    </div>
</div>