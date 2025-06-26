<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  buffer="32kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Chi tiết công việc</title>
        <link rel="stylesheet" href="<c:url value='/css/job-detail.css'/>" />
    </head>
    <body>
        <div class="main-container">
            <!-- Bên trái: Chi tiết công việc -->
            <div class="left-panel">
                <!-- Header -->
                <div class="job-header">
                    <c:choose>
                        <c:when test="${not empty j.base64Image}">
                            <img class="card-logo" src="data:image/jpeg;base64,${j.base64Image}" alt="Logo công ty">
                        </c:when>
                        <c:otherwise>
                            <img class="card-logo" src="${pageContext.request.contextPath}/image/logo-hi5jobs.png" alt="Logo công ty">
                        </c:otherwise>
                    </c:choose>

                    <div class="job-info">
                        <p class="company">${job.companyName}</p>
                        <h2 class="title">${job.title}</h2>
                        <p class="salary-location">
                            <span class="salary">💰 <span class="highlight">${job.salary}</span></span>
                            <span class="location">📍 ${job.location}</span>
                        </p>
                        <form action="apply-job" method="post">
                            <input type="hidden" name="jobID" value="${job.jobID}" />

                        </form>
                        <button class="apply-btn" onclick="openPopup()">📝 Nộp hồ sơ</button>
                    </div>
                </div>

                <!-- Tabs -->
                <div class="tabs">
                    <div class="tab active">Thông tin chung</div>
                </div>

                <!-- Các mục thông tin -->
                <div class="section">
                    <p><strong>Ngày đăng:</strong> ${job.uploadDate}</p>
                    <p><strong>Giới tính:</strong> ${job.gentle}</p>
                    <p><strong>Số lượng tuyển:</strong> ${job.numberofRecruiment}</p>
                </div>

                <div class="section">
                    <h3>Mô Tả Công Việc</h3>
                    <p>${job.descriptionJob}</p>
                </div>

                <div class="section">
                    <h3>Yêu Cầu Công Việc</h3>
                    <p>${job.requirement}</p>
                </div>

                <div class="section">
                    <h3>Thông Tin Công Ty</h3>
                    <p><strong>Tên công ty:</strong> ${job.companyName}</p>
                    <p><strong>Địa chỉ:</strong> ${job.location}</p>
                    <p><strong>Mã số thuế:</strong> ${job.taxcode}</p>
                </div>

                <button class="apply-btn full"  onclick="openPopup()">📝 Nộp hồ sơ</button>
            </div>

            <!-- Bên phải: Việc làm tương tự -->
            <div class="right-panel">
                <h4>Việc làm liên quan</h4>
                <c:forEach var="j" items="${relatedJobs}" >
                    <div class="job-card" onclick="window.location.href = '<c:url value='/info?jobID=${j.jobID}&UserID=${j.userID}'/>'">
                        <c:choose>
                            <c:when test="${not empty j.base64Image}">
                                <img class="card-logo" src="data:image/jpeg;base64,${j.base64Image}" alt="Logo công ty">
                            </c:when>
                            <c:otherwise>
                                <img class="card-logo" src="${pageContext.request.contextPath}/image/logo-hi5jobs.png" alt="Logo công ty">
                            </c:otherwise>
                        </c:choose>
                        <div class="card-info">
                            <p class="card-title">${j.title}</p>
                            <p class="card-company">${j.companyName}</p>
                            <p class="card-meta">
                                💰 <span class="highlight">${j.salary}</span><br>
                                📍 ${j.location}
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!--application-->
        <div id="cvPopup" class="popup-overlay">
            <div class="popup-content">
                <h3 style="color: #f28c28;">GỬI CV</h3>
                <form action="${pageContext.request.contextPath}/apply-job" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="jobID" value="${job.jobID}" />

                    <!-- Tiêu đề thư -->
                    <label for="subject">Tiêu đề Thư :</label>
                    <input type="text" id="subject" name="subject" class="input-text" required>

                    <!-- Nội dung thư -->
                    <textarea name="message" class="message-area" rows="6" >
                    </textarea>

                    <!-- Kéo & thả hoặc chọn file -->
                    <div class="cv-select-section">
                        <label for="savedCV">Chọn CV từ hồ sơ của bạn:</label>
                        <select name="cvFileID" id="savedCV" required>
                            <option value="" disabled selected>-- Chọn một file CV --</option>
                            <c:forEach var="cv" items="${savedCVs}" varStatus="status">
                                <option value="${cv.resumeID}" data-image="${cv.base64Image}">CV ${status.index + 1}(ngày upload: ${cv.uploadDate})</option>
                            </c:forEach>
                        </select>
                        <div class="cv-preview">
                            <p>Xem trước CV:</p>
                            <img id="cvImagePreview" src="" alt="Xem trước CV" style="max-width: 100%; display: none; border: 1px solid #ccc; padding: 10px;" />
                        </div>
                        <script>
                            document.getElementById("savedCV").addEventListener("change", function () {
                                const selectedOption = this.options[this.selectedIndex];
                                const imageBase64 = selectedOption.getAttribute("data-image");

                                const img = document.getElementById("cvImagePreview");
                                if (imageBase64 && imageBase64.trim() !== "") {
                                    img.src = "data:image/jpeg;base64," + imageBase64;
                                    img.style.display = "block";
                                } else {
                                    img.src = "";
                                    img.style.display = "none";
                                }
                            });
                        </script>
                        <small>Bạn có thể cập nhật CV trong trang hồ sơ cá nhân.</small>
                    </div>

                    <!-- Nút -->
                    <div class="popup-buttons">
                        <button type="submit" class="btn-submit">Nộp</button>
                        <button type="button" class="btn-cancel" onclick="closePopup()">Thoát</button>
                    </div>
                </form>
            </div>
        </div>
        <script>
            function openPopup() {
                const loggedIn = ${sessionScope.accountID != null ? "true" : "false"};
                const isJobSeeker = ${sessionScope.userType == 2 ? "true" : "false"};

                if (loggedIn) {
                    if (isJobSeeker) {
                        document.getElementById('cvPopup').style.display = "flex";
                    } else {
                        alert("Tài khoản hiện tại của bạn là Employee.");
                    }
                } else {
                    alert("Vui lòng đăng nhập để nộp hồ sơ.");
                    window.location.href = "/Hi5Jobs/login"; // hoặc redirect đến trang login
                }
            }

            function closePopup() {
                document.getElementById('cvPopup').style.display = 'none';
            }
        </script>

    </body>
</html>
