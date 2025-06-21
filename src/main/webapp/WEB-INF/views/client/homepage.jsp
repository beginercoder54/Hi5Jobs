<%-- 
    Document   : homepage
    Created on : May 18, 2025, 10:54:39 PM
    Author     : hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/job-card.css">
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
        <div class="job-card">

            <div class="content">
                <h4>${job.title}</h4>
                <div class="meta">
                    <span class="salary">💰 ${job.salary}</span>
                    <span class="location">📍 ${job.location}</span>
                </div>
            </div>
            <div class="favorite">♡</div>
        </div>
    </c:forEach>
</div>
