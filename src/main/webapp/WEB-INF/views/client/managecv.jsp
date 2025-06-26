<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value='/css/managecv.css'/>" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>QUẢN LÝ TUYỂN DỤNG</h3>

        <form method="get" action="${pageContext.request.contextPath}/manage-applications">
            <label for="jobID">Chọn công việc:</label>
            <select name="jobID" id="jobID" onchange="this.form.submit()" style="margin-bottom:10px;">
                <option value="">-- Tất cả công việc --</option>
                <c:forEach var="job" items="${jobs}">
                    <option value="${job.jobID}" ${job.jobID == selectedJobID ? 'selected' : ''}>
                        ${job.title}
                    </option>
                </c:forEach>
            </select>
        </form>

        <table class="application-table">
            <thead>
                <tr>
                    <th>ID Application</th>
                    <th>Ngày nộp</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="app" items="${applications}" varStatus="status">
                    <tr class="${status.index % 2 == 0 ? 'even' : 'odd'}">
                        <td>${app.applicationID}</td>
                        <td>${app.appDate}</td>
                        <td class="action-icons">
                            <a href="view/${app.applicationID}" class="icon view" title="Tải CV">
                                <img src="${pageContext.request.contextPath}/image/view.png" alt="Xem" style="width:20px; height:20px;"  onclick="openPopup()" style="cursor:pointer;">
                            </a>
                            <a href="download/${app.applicationID}" class="icon download" title="Tải CV">
                                <img src="${pageContext.request.contextPath}/image/download.png" alt="Tải CV" style="width:20px; height:20px;" style="cursor:pointer;">
                            </a>
                            <a href="approve/${app.applicationID}" class="icon approve" title="Phê duyệt">
                                <img src="${pageContext.request.contextPath}/image/check.png" alt="Phê duyệt" style="width:20px; height:20px;" style="cursor:pointer;">
                            </a>
                        </td>
                    </tr>
                <div id="cvPopup" class="popup-overlay">
                    <div class="popup-content">
                        <h3 style="color: #f28c28;">GỬI CV</h3>
                        <form action="${pageContext.request.contextPath}/apply-job" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="jobID" value="${job.jobID}" />

                            <!-- Tiêu đề thư -->
                            <label for="subject">Tiêu đề Thư :</label>
                            <input type="text" id="subject" name="subject" class="input-text" required disabled placeholder="${app.coverletter}" >

                            <!-- Nội dung thư -->
                            <textarea name="message" class="message-area" rows="6" disabled>${app.notes}</textarea>

                            <!-- Kéo & thả hoặc chọn file -->
                            <div class="cv-select-section">
                                <label for="savedCV">Resume:</label>
                                <div class="cv-preview">
                                    <img id="cvImagePreview" src="" alt="Xem trước CV" style="max-width: 100%; display: none; border: 1px solid #ccc; padding: 10px;" />
                                </div>

                            </div>

                            <!-- Nút -->
                            <div class="popup-buttons">
                                <button type="button" class="btn-cancel" onclick="closePopup()">Thoát</button>
                            </div>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </tbody>
    </table>

    <script>
        function openPopup() {
            document.getElementById('cvPopup').style.display = "flex";

        }

        function closePopup() {
            document.getElementById('cvPopup').style.display = 'none';
        }
    </script>

</body>
</html>
