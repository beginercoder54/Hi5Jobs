<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/css/settings.css'/>" />
<!DOCTYPE html>
<html>
    <body>
        <!-- FORM CHÍNH -->
        <form action="${pageContext.request.contextPath}/settings" method="post">
            <div class="form-section">
                <h2><strong>Profile</strong></h2>

                <p><strong>User ID:</strong> ${user.userID}</p>
                <p><strong>Account ID:</strong> ${user.accountID}</p>
                <p><strong>Họ tên:</strong> ${user.name}</p>
                <p><strong>Email:</strong> ${user.email}</p>
                <p><strong>Số điện thoại:</strong> ${user.phoneNumber}</p>
                <p><strong>Địa chỉ:</strong> ${user.address}</p>
                <p><strong>Tên công ty:</strong>${employee.companyName}</p>
                <p><strong>Mã số thuế:</strong>${employee.taxcode}</p>
                <p><strong>Mô tả về công ty:</strong>${employee.companyDescription}</p>

                <div class="form-actions">
                    <!-- Đổi type sang button để không submit form -->
                    <button type="button" onclick="openModal()">Update profile</button>
                </div>
            </div>
        </form>

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
        </script>

    </body>
</html>
