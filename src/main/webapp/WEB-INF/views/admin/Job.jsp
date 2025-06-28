
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Quản lý công việc</h3>
        <!-- Thanh chứa nút "Thêm" và ô tìm kiếm -->
        <!-- Ô tìm kiếm -->
        <form action="${pageContext.request.contextPath}/admin/search-job" method="get">
            <input type="text" name="keyword" placeholder="Tìm kiếm theo ID,tên...."
                   style="padding: 8px; width: 300px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
            <button type="submit"
                    style="padding: 8px 12px; background-color: #fbb03b; color: white; border: none; border-radius: 4px; cursor: pointer;">
                Tìm kiếm
            </button>
        </form>
        <table border="1" cellspacing="0" cellpadding="10" style="width: 100%; border-collapse: collapse; font-family: Arial;">
            <thead style="background-color: #fbb03b; color: white;">
                <tr>
                    <th>JobID</th>
                    <th>Job title</th>
                    <th>Job location</th>
                    <th>Upload Date</th>
                    <th>Chỉnh sửa</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${jobseekers}">
                <tr style="background-color: ${status.index % 2 == 0 ? '#fffbe6' : '#ffffff'};">
                    <td>${user.jobID}</td>
                    <td>${user.title}</td>
                    <td>${user.location}</td>
                    <td>${user.uploadDate}</td>

                    <td>
                        <!-- Button view -->
                        <form action="${pageContext.request.contextPath}/info?jobID=${user.jobID}&UserID=${user.userID}" method="get" style="display:inline;">
                            <input type="hidden" name="jobID" value="${user.jobID}" />
                            <input type="hidden" name="UserID" value="${user.userID}" />
                            <button type="submit" style="padding: 4px 8px; margin-right: 5px; background-color: #007bff; color: white; border: none; border-radius: 3px; cursor: pointer;">
                                Xem chi tiet
                            </button>
                        </form>

                        <!-- Button Xóa -->
                        <form action="${pageContext.request.contextPath}/admin/delete-job?jobID=${user.jobID}" method="post" style="display:inline;" 
                              onsubmit="return confirm('Bạn có chắc muốn xóa công việc này không?');">
                            <input type="hidden" name="jobID" value="${user.jobID}" />
                            <button type="submit" style="padding: 4px 8px; background-color: #dc3545; color: white; border: none; border-radius: 3px; cursor: pointer;">
                                Xóa
                            </button>
                        </form>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
