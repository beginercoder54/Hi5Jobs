
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" cellspacing="0" cellpadding="10" style="width: 100%; border-collapse: collapse; font-family: Arial;">
            <thead style="background-color: #fbb03b; color: white;">
                <tr>
                    <th>UserID</th>
                    <th>Họ tên</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th>Địa chỉ</th>
                    <th>Tên công ty</th>
                    <th>Mã số thuế</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${jobseekers}">
                    <tr style="background-color: ${status.index % 2 == 0 ? '#fffbe6' : '#ffffff'};">
                        <td>${user.userID}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.phoneNumber}</td>
                        <td>${user.address}</td>
                        <td>${user.companyName}</td>
                        <td>${user.taxcode}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
