
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/job-card.css">
<div class="image-header">
    <img src="${pageContext.request.contextPath}/image/imageheader.png" alt="imageheader">
</div>
<h2 class="gradient-text">Where Talent Meets Opportunity</h2>
<div class="filter-bar">
    <div class="filter-dropdown">
        <button class="dropdown-toggle">Lọc theo ▼</button>
        <div class="dropdown-menu">
            <a href="#">Mức lương</a>
            <a href="#">Ngành nghề</a>
            <a href="#">Kinh nghiệm</a>
            <a href="#">Yêu thích</a>
        </div>
    </div>

    <div class="filter-buttons">
        <button class="filter-btn active">Tất cả</button>
        <button class="filter-btn">Từ 5-10 triệu</button>
        <button class="filter-btn">Từ 10-15 triệu</button>
        <button class="filter-btn">Từ 20-30 triệu</button>
        <button class="filter-btn">Trên 50 triệu</button>
    </div>
</div>
<div class="job-container">
    <c:forEach var="job" items="${jobs}">
        <div class="job-card" >
            <!-- Avatar bên trái -->
            <div class="job-logo">
                <img class="avatar"
                     src="${job.base64Image != null ? 'data:image/jpeg;base64,'.concat(job.base64Image) : pageContext.request.contextPath.concat('/image/logo-hi5jobs.png')}"
                     alt="Avatar"/>
            </div>

            <!-- Nội dung bên phải -->
            <div class="job-info">
                <div class="title-row">
                    <h4 onclick="window.location.href='<c:url value='/info?jobID=${job.jobID}&UserID=${job.userID}'/>'">${job.title}</h4><br>
                    <a href="${pageContext.request.contextPath}/addFavorite?jobID=${job.jobID}"><span class="favorite" >♡</span></a>
                </div>
                <div class="company">${job.companyName}</div>
                <div class="meta">
                    <span class="salary">💰 ${job.salary}</span>
                    <span class="location">📍 ${job.location}</span>
                </div>
            </div>

        </div>
    </c:forEach>
</div>
