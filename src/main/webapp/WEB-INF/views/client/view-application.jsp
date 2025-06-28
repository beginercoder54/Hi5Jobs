<%-- 
    Document   : view-application
    Created on : Jun 28, 2025, 4:42:31 PM
    Author     : hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Tên người gửi:</h3><span>${app.name}</span>
        <h3>Tiêu để thư:</h3><span>${app.coverletter}</span><br>
        <h3>Nội dung thư:</h3>
        <p>${app.notes}</p>

        <h3>Resume</h3>
    <c:choose>
        <c:when test="${not empty app.base64Image}">
            <img src="data:image/jpeg;base64,${app.base64Image}" 
                 alt="Avatar"
                 style="width: 500px; height: 500px;  object-fit: cover; margin-bottom: 15px; border: 2px solid #ccc;"/><br>
            <a href="data:image/jpeg;base64,${re.base64Image}" 
               download="cv_${app.resumeID}.jpg"
               class="download-btn"
               style="
               display: inline-block;
               margin-top: 8px;
               padding: 6px 12px;
               background-color: #4CAF50;
               color: white;
               text-decoration: none;
               border-radius: 6px;
               font-size: 14px;
               transition: background-color 0.3s ease;
               ">
                Tải xuống
            </a>
        </c:when>
    </c:choose>
</body>
</html>
