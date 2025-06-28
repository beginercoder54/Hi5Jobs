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
            <p><strong>Education</strong> : <span>${jobseekers.education}</span></p>
            <p><strong>Experience</strong> : <span>${jobseekers.experience}</span></p>
            <h3>Resume</h3>
            <c:choose>
                <c:when test="${not empty resume}">
                    <div class="cv-grid" >
                        <c:forEach var="res" items="${resume}">
                            <div class="cv-item">
                                <img src="data:image/jpeg;base64,${res.base64Image}" alt="CV" />

                                <a href="data:image/jpeg;base64,${res.base64Image}" 
                                   download="cv_${res.resumeID}.jpg"
                                   class="download-btn">
                                    Tải xuống
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </c:when>
                <c:otherwise>
                    <p>Người dung chưa có CV</p>
                </c:otherwise>
            </c:choose>
            <style>
                .cv-item img,
                .cvPreview {
                    max-width: 300px;   /* Hoặc bất kỳ kích thước nào bạn muốn */
                    max-height: 400px;
                    width: auto;
                    height: auto;
                    border-radius: 10px;
                    object-fit: contain;
                    border: 1px solid #ccc;
                }

                .cv-grid {
                    display: flex;
                    flex-wrap: wrap;
                    gap: 16px;
                }

                .cv-item {
                    width: calc(33.333% - 16px);
                    box-sizing: border-box;
                    border: 1px solid #ccc;
                    padding: 8px;
                    border-radius: 10px;
                    background-color: #f9f9f9;
                    text-align: center;
                }

                .cv-item img {
                    width: 100%;
                    height: auto;
                    border-radius: 6px;
                }

                .download-btn {
                    display: inline-block;
                    margin-top: 8px;
                    padding: 6px 12px;
                    background-color: #4CAF50;
                    color: white;
                    text-decoration: none;
                    border-radius: 6px;
                    font-size: 14px;
                    transition: background-color 0.3s ease;
                }

                .download-btn:hover {
                    background-color: #45a049;
                }

                @media (max-width: 768px) {
                    .cv-item {
                        width: calc(50% - 16px);
                    }
                }

                @media (max-width: 480px) {
                    .cv-item {
                        width: 100%;
                    }
                }
            </style> 
        </div>
    </body>
</html>
