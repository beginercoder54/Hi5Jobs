<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/css/settings.css'/>" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="form-section">
            <div  style="
                  display: flex;
                  flex-direction: column;
                  align-items: center;
                  justify-content: center;
                  text-align: center;
                  padding: 20px;
                  ">
                <c:choose>
                    <c:when test="${not empty jobseekers.base64Image}">
                        <img src="data:image/jpeg;base64,${jobseekers.base64Image}" 
                             alt="Avatar"
                             style="width: 120px; height: 120px; border-radius: 50%; object-fit: cover; margin-bottom: 15px; border: 2px solid #ccc;"/>
                    </c:when>
                    <c:otherwise>
                        <img src="${pageContext.request.contextPath}/image/user.png" 
                             alt="Default Avatar"
                             style="width: 120px; height: 120px; border-radius: 50%; object-fit: cover; margin-bottom: 15px; border: 2px solid #ccc;" />
                    </c:otherwise>
                </c:choose>
                <h2>${jobseekers.name}</h2>
                <h4>User ID: ${jobseekers.userID}</h4>
            </div>
            <h3>Thông tin người dùng</h3>
            <p><strong>Name</strong> : <span>${jobseekers.name}</span></p>
            <p><strong>Email</strong> : <span>${jobseekers.email}</span></p>
            <p><strong>Phone</strong> : <span>${jobseekers.phoneNumber}</span></p>
            <p><strong>Address</strong> : <span>${jobseekers.address}</span></p>
            <p><strong>Company Name</strong> : <span>${jobseekers.companyName}</span></p>
            <p><strong>Company Name</strong> : <span>${jobseekers.taxcode}</span></p>
            <p><strong>Company Image</strong> :</p>
            <c:choose>
                <c:when test="${not empty re.base64Image}">
                    <img src="data:image/jpeg;base64,${re.base64Image}" 
                         alt="Avatar"
                         style="width: 120px; height: 120px;  object-fit: cover; margin-bottom: 15px; border: 2px solid #ccc;"/>
                </c:when>
                <c:otherwise>
                    <img src="${pageContext.request.contextPath}/image/logo-hi5jobs.png" 
                         alt="Default Avatar"
                         style="width: 120px; height: 120px;; object-fit: cover; margin-bottom: 15px; border: 2px solid #ccc;" />
                </c:otherwise>
            </c:choose>

        </div>
    </body>
</html>
