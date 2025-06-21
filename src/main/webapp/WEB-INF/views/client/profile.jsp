
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<c:url value='/css/Profile.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/clientLogHomepage.css'/>" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wrapper">
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
                    <div class="user-actions">
                        <!-- Nút menu (ba gạch) -->
                        <div class="menu-icon">
                            <img src="${pageContext.request.contextPath}/image/menu.png" alt="Menu">

                            <!-- Dropdown menu -->
                            <div class="menu-dropdown">
                                <a href="${pageContext.request.contextPath}/notifications">🔔 Thông báo</a>
                                <a href="${pageContext.request.contextPath}/logout">🚪 Đăng xuất</a>
                            </div>
                        </div>

                        <!-- Avatar -->
                        <!-- Avatar -->
                        <div class="user-avatar">
                            <a href="${pageContext.request.contextPath}/profile">
                                <img src="${pageContext.request.contextPath}/image/user.png" alt="Avatar">
                            </a>
                        </div>

                    </div>
                </div> 
            </div>  
            <div class="profile-header" style="background-image: url('<c:url value="/image/background.png"/>');">
                <div class="avatar-container">
                    <img class="avatar" src="<c:url value='/image/user.png'/>" alt="Avatar" />
                </div>
                <div class="profile-info">
                    <div class="user-name">${user.name}</div>
                    <div class="user-id">User ID: ${sessionScope.userID}</div>
                </div>
            </div>  
            <div class = "infomation-container">
                <div class = "option-container">
                    <ul class="profile-menu">
                        <a href="#">Thông tin cá nhân</a>
                        <a href="#">Hồ sơ xin việc</a>
                        <a href="#">Resume</a>
                    </ul>
                </div>
                <div class = "info-main">
                    <p><strong>User ID:</strong> ${user.userID}</p>
                    <p><strong>Account ID:</strong> ${user.accountID}</p>
                    <p><strong>Họ tên:</strong> ${user.name}</p>
                    <p><strong>Email:</strong> ${user.email}</p>
                    <p><strong>Số điện thoại:</strong> ${user.phoneNumber}</p>
                    <p><strong>Địa chỉ:</strong> ${user.address}</p>
                    <div class="form-actions">
                        <button onclick="openModal()">Update profile</button>
                    </div>

                </div>

            </div>
        </div>
        <!-- Modal Update Profile -->
        <div id="profileModal" class="modal">
            <div class="modal-content">
                <span class="close" onclick="closeModal()">&times;</span>
                <h2>Cập nhật thông tin cá nhân</h2>
                <form action="${pageContext.request.contextPath}/update-profile" method="post">
                    <label>Ảnh đại diện mới:</label>
                    <input type="file" name="avatar" accept="image/*" onchange="previewImage(event)" />
                    <br/>
                   <img id="avatarPreview" src="#" alt="Ảnh xem trước" class="avatar-preview" />

                    <label>Họ tên:</label>
                    <input type="text" name="name" value="${user.name}" /><br/>

                    <label>Email:</label>
                    <input type="email" name="email" value="${user.email}" /><br/>

                    <label>Số điện thoại:</label>
                    <input type="text" name="phoneNumber" value="${user.phoneNumber}" /><br/>

                    <label>Địa chỉ:</label>
                    <input type="text" name="address" value="${user.address}" /><br/>

                    <button type="submit">Lưu thay đổi</button>
                </form>
            </div>
        </div>
        <script>
            function openModal() {
                document.getElementById("profileModal").style.display = "block";
            }

            function closeModal() {
                document.getElementById("profileModal").style.display = "none";
            }

            window.onclick = function (event) {
                var modal = document.getElementById("profileModal");
                if (event.target === modal) {
                    modal.style.display = "none";
                }
            };
        </script>
        <script>
            function previewImage(event) {
                const input = event.target;
                const preview = document.getElementById("avatarPreview");

                if (input.files && input.files[0]) {
                    const reader = new FileReader();

                    reader.onload = function (e) {
                        preview.src = e.target.result;
                        preview.style.display = "block";
                    };

                    reader.readAsDataURL(input.files[0]); // Đọc ảnh dạng base64
                }
            }
        </script>

    </body>
    <link rel="stylesheet" href="<c:url value='/css/clientfooter.css'/>" />
    <footer>
        <div>
            <a href="${pageContext.request.contextPath}/gioi-thieu">Giới thiệu</a> |
            <a href="${pageContext.request.contextPath}/tam-nhin-su-menh">Tầm nhìn & sứ mệnh</a> |
            <a href="${pageContext.request.contextPath}/doi-ngu-phat-trien">Đội ngũ phát triển</a> |
            <a href="${pageContext.request.contextPath}/blog">Blog</a> |
            <a href="${pageContext.request.contextPath}/lien-he-chung-toi">Liên hệ chúng tôi</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/tim-viec-lam">Tìm việc làm</a> |
            <a href="${pageContext.request.contextPath}/tao-cap-nhat-ho-so">Tạo / Cập nhật hồ sơ</a> |
            <a href="${pageContext.request.contextPath}/meo-phong-van">Mẹo phỏng vấn</a> |
            <a href="${pageContext.request.contextPath}/danh-gia-cong-ty">Đánh giá công ty</a> |
            <a href="${pageContext.request.contextPath}/cau-hoi-thuong-gap">Câu hỏi thường gặp (FAQ)</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/dang-tin-tuyen-dung">Đăng tin tuyển dụng</a> |
            <a href="${pageContext.request.contextPath}/tim-ung-vien">Tìm ứng viên</a> |
            <a href="${pageContext.request.contextPath}/goi-dich-vu">Gói dịch vụ</a> |
            <a href="${pageContext.request.contextPath}/quan-ly-tuyen-dung">Quản lý tuyển dụng</a> |
            <a href="${pageContext.request.contextPath}/cau-hoi-thuong-gap">Câu hỏi thường gặp (FAQ)</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/trung-tam-tro-giup">Trung tâm trợ giúp</a> |
            <a href="${pageContext.request.contextPath}/chinh-sach-bao-mat">Chính sách bảo mật</a> |
            <a href="${pageContext.request.contextPath}/dieu-khoan-su-dung">Điều khoản sử dụng</a> |
            <a href="${pageContext.request.contextPath}/huong-dan-thanh-toan">Hướng dẫn thanh toán</a> |
            <a href="${pageContext.request.contextPath}/bao-cao-vi-pham">Báo cáo vi phạm</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/mang-xa-hoi">Mạng xã hội:</a>
            <a href="https://facebook.com">Facebook</a> /
            <a href="https://linkedin.com">LinkedIn</a> /
            <a href="https://youtube.com">YouTube</a>
            <br>
            <a href="${pageContext.request.contextPath}/dang-ky-nhan-ban-tin">Đăng ký nhận bản tin</a>
        </div>
    </footer>
</html>
