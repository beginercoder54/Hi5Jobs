<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/css/settings.css'/>" />
<!DOCTYPE html>
<html>
    <body>
        <!-- FORM CHÍNH -->

        <div class="form-section">
            <img src="${user.base64Image != null ? 'data:image/jpeg;base64,'.concat(user.base64Image) : pageContext.request.contextPath.concat('/image/user.png')}" alt="Avatar" class="avatar-setting">
            <h2>${user.name}</h2>
            <h4>User ID: ${user.userID}</h4>
            <style>
                .section2 {
                    background-color: #fef7ed;
                    border-radius: 12px;
                    padding: 10px 15px;
                    margin-bottom: 15px;
                    font-family: sans-serif;
                }

                .section-header {
                    cursor: pointer;
                    padding: 10px;
                    background-color: #fef7ed;
                    color: #000;
                    font-size: 16px;
                }

                .section-content {
                    background-color: #ffffff;
                    border-radius: 8px;
                    padding: 15px;
                    margin-top: 10px;
                    display: none;
                    border: 1px solid #e3e3e3;
                }

                .field {
                    margin-bottom: 10px;
                }

                .field label {
                    display: inline-block;
                    width: 150px;
                    font-weight: normal;
                }

                .field span {
                    font-weight: bold;
                }

                .icon {
                    float: right;
                    color: green;
                    cursor:pointer;
                }

            </style>

            <div class="section2">
                <div class="section-header" onclick="toggleSection('info-section')">
                    <h3>▾ Thông tin người đại diện</h3>
                </div>
                <div id="info-section" class="section-content">
                    <div class="section-title">
                        <h4>Thông tin người dùng</h4>
                        <span class="icon" onclick="openModal()">📝</span>
                    </div>
                    <div class="field"><label>Họ và tên:</label> <span>${user.name}</span></div>
                    <div class="field"><label>Email:</label> <span>${user.email}</span></div>
                    <div class="field"><label>Số điện thoại:</label> <span>${user.phoneNumber}</span></div>
                    <div class="field"><label>Địa chỉ:</label> <span>${user.address}</span></div>
                    <div class="field"><label>Tên công ty:</label><span>${employee.companyName}</span></div>
                    <div class="field"><label>Mã số thuế:</label><span>${employee.taxcode}</span></div>
                    <div class="field"><label>Mô tả về công ty:</label><span>${employee.companyDescription}</span></div>
                    <div class="field">
                        <label>Ảnh công ty:</label><br>
                        <c:choose>
                            <c:when test="${not empty employee.imgCompany}">
                                <img src="data:image/jpeg;base64,${employee.base64Image}" alt="Ảnh công ty" style="max-width: 200px;" name="imgCompany">
                            </c:when>
                            <c:otherwise>
                                <span>Không có ảnh nào</span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>

            <div class="section2">
                <div class="section-header" onclick="toggleSection('password-section')">
                    <h3>▾ Thông tin đăng nhập và bảo mật</h3>
                </div>
                <div id="password-section" class="section-content" data-currentpass="${acc.password}">
                    <div class="section-title">
                        <h4>Đổi mật khẩu</h4>
                        <span class="icon" id="toggle-edit">📝</span>
                    </div>
                    <form action="${pageContext.request.contextPath}/change-password" method="post">

                        <div class="fields" style="margin-bottom: 10px;"><label style="with:170px;">Username:</label> <span>${acc.username}</span> </div>
                        <div class="fields" style="margin-bottom: 10px;"><label style="with:170px;">Nhập mật khẩu cũ:</label> <input type="password" name="oldpass" style="margin-left: 10px;" disabled></div>
                        <div class="fields" style="margin-bottom: 10px;"><label style="with:170px;">Nhập mật khẩu mới:</label> <input type="password" name="newpass" style="margin-left: 10px;" disabled></div>
                        <button type="submit" class="changepass" disabled>Change</button>
                    </form>
                </div>

                <script>
                    document.getElementById("toggle-edit").addEventListener("click", function () {
                        const section = document.getElementById("password-section");

                        // Mở các input
                        const inputs = section.querySelectorAll("input");
                        inputs.forEach(input => input.disabled = false);

                        // Mở nút Change
                        const button = section.querySelector("button.changepass");
                        if (button)
                            button.disabled = false;
                    });
                </script>


                <script>
                    function toggleSection(id) {
                        const section = document.getElementById(id);
                        section.style.display = (section.style.display === "block") ? "none" : "block";
                    }
                </script>

            </div>
        </div>

        <!-- ✅ Modal TÁCH RIÊNG KHỎI FORM -->
        <div id="profileModal" class="modal">
            <div class="modal-content">
                <span class="close" onclick="closeModal()">&times;</span>
                <h2>Update profile</h2>

                <!-- FORM CẬP NHẬT HỒ SƠ -->
                <form action="${pageContext.request.contextPath}/update-profileRE" method="post" enctype="multipart/form-data">
                    <label>Ảnh đại diện mới:</label>
                    <input type="file" name="avatar" accept="image/*" onchange="previewImage(event)" /><br/>

                    <img id="avatarPreview"
                         src="data:image/jpeg;base64,${user.base64Image}"
                         alt="Ảnh xem trước"
                         class="avatar-preview" /><br/>

                    <label>Họ tên:</label>
                    <input type="text" name="name" value="${user.name}" /><br/>

                    <label>Email:</label>
                    <input type="email" name="email" value="${user.email}" /><br/>

                    <label>Số điện thoại:</label>
                    <input type="text" name="phoneNumber" value="${user.phoneNumber}" /><br/>

                    <label>Địa chỉ:</label>
                    <input type="text" name="address" value="${user.address}" /><br/>

                    <label>Tên công ty:</label>
                    <input type="text" name="companyname" value="${employee.companyName}"/><br/>

                    <label>Mã số thuế:</label>
                    <input type="text" name="taxcode" value="${employee.taxcode}"/><br/>

                    <label>Mô tả công ty:</label>
                    <input type="text" name="companydescription" value="${employee.companyDescription}"/><br/>

                    <input type="file" name="imageCompany" accept="image/*" onchange="previewImageCompany(event)" /><br/>

                    <img id="imagePreview"
                         src="data:image/jpeg;base64,${employee.base64Image}"
                         alt="Ảnh xem trước"
                         class="imageCompany-preview" /><br/>
                    <button type="submit">Update</button>
                </form>

                <c:if test="${not empty alertMessage}">
                    <script>
                        alert("${alertMessage}");
                    </script>
                </c:if>
            </div>
        </div>

        <!-- JS -->
        <script>
            function openModal() {
                document.getElementById("profileModal").style.display = "flex";
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

            function previewImage(event) {
                const reader = new FileReader();
                reader.onload = function () {
                    document.getElementById('avatarPreview').src = reader.result;
                };
                reader.readAsDataURL(event.target.files[0]);
            }
            function previewImageCompany(event) {
                const reader = new FileReader();
                reader.onload = function () {
                    document.getElementById('imagePreview').src = reader.result;
                };
                reader.readAsDataURL(event.target.files[0]);
            }
        </script>

    </body>
</html>
