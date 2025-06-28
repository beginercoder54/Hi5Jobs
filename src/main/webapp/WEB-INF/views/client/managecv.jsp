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
                            <a href="${pageContext.request.contextPath}/view-application?resumeID=${app.resumeID}&UserID=${app.userID}" class="icon view" title="Xem CV">
                                <img src="${pageContext.request.contextPath}/image/view.png" alt="Xem" style="width:20px; height:20px;"  onclick="openPopup()" style="cursor:pointer;">
                            </a>
                            <a href="data:image/jpeg;base64,${app.base64Image}" 
                               download="cv_${app.resumeID}.jpg"
                               class="download-btn" title="Tải CV">
                                <img src="${pageContext.request.contextPath}/image/download.png" alt="Tải CV" style="width:20px; height:20px;" style="cursor:pointer;">
                            </a>
                            <c:choose>
                                <c:when test="${app.status == 0}">
                                    <a href="${pageContext.request.contextPath}/approve?ApplicationID=${app.applicationID}&UserID=${app.userID}" class="icon approve" title="Phê duyệt">
                                        <img src="${pageContext.request.contextPath}/image/check.png" alt="Phê duyệt" style="width:20px; height:20px; cursor:pointer;">
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#" class="icon approved" title="Đã phê duyệt">
                                        <img src="${pageContext.request.contextPath}/image/stamp.png" alt="Đã phê duyệt" style="width:20px; height:20px; cursor:default;">
                                    </a>
                                </c:otherwise>
                            </c:choose>

                        </td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>



    </body>
</html>
