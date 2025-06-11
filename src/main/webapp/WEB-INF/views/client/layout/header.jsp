<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/clientheader.css'/>" />
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
                <img src="${pageContext.request.contextPath}/image/search-icon.png" alt="Search">
                <input type="text" placeholder="Search">
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
            <a href="${pageContext.request.contextPath}/recruiterhomepage">
                <div class="recruiter-section">
                    For recruiters
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
        <img s<rc="${pageContext.request.contextPath}/image/imageheader.png" alt="imageheader">
    </div>
</body>
