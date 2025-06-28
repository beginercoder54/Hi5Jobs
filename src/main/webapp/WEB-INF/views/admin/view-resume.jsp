<%-- 
    Document   : view-resume
    Created on : Jun 28, 2025, 3:00:54 PM
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
    <c:choose>
        <c:when test="${not empty re.base64Image}">
            <img src="data:image/jpeg;base64,${re.base64Image}" 
                 alt="Avatar"
                 style="width: 500px; height: 500px;  object-fit: cover; margin-bottom: 15px; border: 2px solid #ccc;"/><br>
            <a href="data:image/jpeg;base64,${re.base64Image}" 
               download="cv_${re.resumeID}.jpg"
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
