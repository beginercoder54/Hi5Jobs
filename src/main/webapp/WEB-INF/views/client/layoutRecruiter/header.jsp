<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/clientheaderRE.css'/>" />
<body>
    <div class="header-container">
        <div class="header-wrapper">

            <!-- Logo + Nộp CV -->
            <div class="logo-section">
                <img src="${pageContext.request.contextPath}/image/logo-hi5jobs.png" alt="Logo">
                <strong class="submit-cv-text">Hi5Jobs</strong>
            </div>

            <!-- Thanh tìm kiếm -->
             <div class="search-bar">
                <form class="search-form" action="${pageContext.request.contextPath}/search" method="get">
                    <img src="${pageContext.request.contextPath}/image/search-icon.png" alt="Search">
                    <input type="text" name="query" placeholder="Search"/>
                </form>
            </div>

            <!-- Dropdown Công việc -->
            <div class="dropdown">
                <span class="label">Job</span>
                <span class="value">Profession &#x25BC;</span>
            </div>

            <!-- Dropdown Địa điểm -->
            <div class="dropdown">
                <span class="label">Location</span>
                <span class="value">City &#x25BC;</span>
            </div>

            <!-- Dành cho nhà tuyển dụng -->
            <a href="${pageContext.request.contextPath}/homepage">
                <div class="recruiter-section">
                    For jobseeker
                </div>
            </a>

            <!-- Đăng nhập -->
            <div class="login-section">
                <img src="${pageContext.request.contextPath}/image/loginicon.png" alt="Login">
                <a href="<c:url value='/login'/>">Log In</a>
            </div>

            <!-- Đăng ký -->
            <a href="<c:url value='/register'/>" class="register-button">
                Register
            </a>

        </div> 
    </div>
    <div class="image-header">
        <img src="${pageContext.request.contextPath}/image/recruiterheader.png" alt="imageheader">
    </div>
</body>
