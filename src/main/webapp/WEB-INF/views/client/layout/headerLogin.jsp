 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/clientLogHomepage.css'/>" />
<body>
    <div class="header-container">
        <div class="header-wrapper">

            <!-- Logo + Nộp CV -->
            <div class="logo-section">
                <img src="${pageContext.request.contextPath}/image/logo-hi5jobs.png" alt="Logo">
                <strong class="submit-cv-text" onclick="window.location.href='/Hi5Jobs/homepage'" style="cursor: pointer;">Hi5Jobs</strong>
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
            <a href="${pageContext.request.contextPath}/recruiterhomepage">
                <div class="recruiter-section">
                    For recruiters
                </div>
            </a>
            <div class="user-actions">
                <!-- Nút menu (ba gạch) -->
                <div class="menu-icon">
                    <img src="${pageContext.request.contextPath}/image/menu.png" alt="Menu">

                    <!-- Dropdown menu -->
                    <div class="menu-dropdown">
                        <a href="${pageContext.request.contextPath}/profile?section=notification">🔔 Thông báo</a>
                        <a href="${pageContext.request.contextPath}/logout">🚪 Đăng xuất</a>
                    </div>
                </div>

                <!-- Avatar -->
                <c:set var="link" value="${sessionScope.userType == 2 ? '/profile' : '/settings'}" />

                <div class="user-avatar">
                    <a href="${pageContext.request.contextPath}${link}">
                        <img class="avatar"
                             src="${user.base64Image != null 
                                    ? 'data:image/jpeg;base64,'.concat(user.base64Image) 
                                    : pageContext.request.contextPath.concat('/image/user.png')}"
                             alt="Avatar"/>
                    </a>
                </div>

            </div>



        </div> 
    </div>
</body>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const menuIcon = document.querySelector(".menu-icon");
        const dropdown = document.querySelector(".menu-dropdown");

        menuIcon.addEventListener("click", function (e) {
            e.stopPropagation(); // tránh click lan ra ngoài
            dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
        });

        // Ẩn dropdown khi click ra ngoài
        document.addEventListener("click", function () {
            dropdown.style.display = "none";
        });
    });
</script>

