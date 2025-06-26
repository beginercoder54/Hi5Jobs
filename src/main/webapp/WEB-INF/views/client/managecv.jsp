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
                <a href="view/${app.applicationID}" class="icon view" title="Xem"><img src="${pageContext.request.contextPath}/image/" class="fas fa-eye"></i></a>
                <a href="download/${app.applicationID}" class="icon download" title="Tải CV"><i class="fas fa-download"></i></a>
                <a href="approve/${app.applicationID}" class="icon approve" title="Phê duyệt"><i class="fas fa-check-circle"></i></a>
            </td>
        </tr>
    </c:forEach>
</tbody>
</table>


</body>
</html>
