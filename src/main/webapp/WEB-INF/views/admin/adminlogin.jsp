<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Quản lý phân quyền - Đăng nhập</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-login.css">
    </head>
    <body>
        <div class="container">
            <div class="sidebar">
                <h2>Admin Panel</h2>
            </div>

            <div class="login-area">
                <h1>Quản lý phân quyền</h1>
                <p>Đăng nhập hệ thống</p>
                <p style=" color: red;"><c:out value="${messages}" /></p>
                <div class="login-box">
                    <h3><img src="${pageContext.request.contextPath}/image/lock.png" alt="lock" style="vertical-align: middle; max-height: 20px" /> Nhập tên đăng nhập và mật khẩu</h3>

                    <form action="${pageContext.request.contextPath}/admin/home" method="post">
                        <label for="username">Tên đăng nhập:</label><br>
                        <input type="text" name="username" id="username" required><br><br>

                        <label for="password">Mật khẩu:</label><br>
                        <input type="password" name="password" id="password" required><br><br>

                        <input type="submit" value="ĐĂNG NHẬP">
                    </form>
                </div>
            </div>
        </div>

        <div class="footer">
            © Copyright 2014 Trường Đại học Kinh tế Tài chính - UEF | <a href="#">Trang chủ</a>
        </div>
    </body>
</html>
