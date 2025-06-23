<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value='/css/postForm.css'/>" />
<h3>ĐĂNG TIN TUYỂN DỤNG MỚI</h3>
<form action="${pageContext.request.contextPath}/post" method="post">
    <!-- Thông tin cơ bản -->
    <div class="form-section">
        <h2>Thông tin cơ bản</h2>
        <div class="form-group1">
            <div>
                <label>Tiêu đề công việc</label>
                <input type="text" name="jobTitle" placeholder="Ex: Nhân viên thu ngân" />
            </div>
            <div>
                <label>Địa điểm</label>
                <input type="text" name="location" placeholder="Ex: Coconut Company" />
            </div>
        </div>
    </div>

    <!-- Mô tả công việc -->
    <div class="form-section">
        <h2>Mô tả công việc</h2>
        <div class="form-group2">
            <textarea name="description" placeholder="Ex: Mô tả công việc cụ thể..."></textarea>
        </div>
    </div>

    <!-- Mức lương -->
    <div class="form-section">
        <h2>Mức Lương</h2>
        <div class="form-group flex-row">
            <select name="salaryType">
                <option value="negotiable">Thỏa thuận</option>
                <option value="fixed">Cố định</option>
            </select>

            <input type="text" name="salaryFrom" placeholder="5.000.000" />
            <span>VND</span>

            <span> &nbsp; Tới &nbsp; </span>

            <input type="text" name="salaryTo" placeholder="15.000.000" />
            <span>VND</span>
        </div>
    </div>

    <!-- Yêu cầu -->
    <div class="form-section">
        <h2>Yêu cầu</h2>
        <div class="form-group">
            <div>
                <label>Giới tính yêu cầu</label>
                <select name="gender">
                    <option value="any">Không yêu cầu</option>
                    <option value="male">Nam</option>
                    <option value="female">Nữ</option>
                </select>
            </div>

            <div>
                <label>Số lượng tuyển</label>
                <input type="text" name="quantity" placeholder="15 người" />
            </div>
            <div>
                <label>Độ tuổi</label>
                <select name="age">
                    <option value="any">Không giới hạn</option>
                    <option value="16-22">16–22</option>
                    <option value="22-30">22–30</option>
                    <option value="30plus">Trên 30</option>
                </select>
            </div>
        </div>

        <div class="form-group2">
            <textarea name="requirementNote" placeholder="Mô tả yêu cầu công việc..."></textarea>
        </div>
    </div>

    <!-- Nút gửi -->
    <div class="form-actions">
        <button type="submit">Đăng Tin</button>
    </div>
   
</form>
