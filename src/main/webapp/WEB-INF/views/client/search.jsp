<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value='/css/search.css'/>" />
    </head>
    <body>
        <div class="job-container" style="margin-top:20px; margin-bottom:20px;">
            <c:choose>
                <c:when test="${empty jobs}">
                    <div class="no-results" style="text-align: center; font-size: 20px; margin-top: 40px;">
                        Không tìm thấy kết quả nào phù hợp.
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach var="job" items="${jobs}">
                        <div class="job-card" >
                            <!-- Avatar bên trái -->
                            <div class="job-logo">
                                <img class="avatar"
                                     src="${job.base64Image != null ? 'data:image/jpeg;base64,'.concat(job.base64Image) : pageContext.request.contextPath.concat('/image/logo-hi5jobs.png')}"
                                     alt="Avatar"/>
                            </div>

                            <!-- Nội dung bên phải -->
                            <div class="job-info">
                                <div class="title-row">
                                    <h4 onclick="window.location.href='<c:url value='/info?jobID=${job.jobID}&UserID=${job.userID}'/>'">${job.title}</h4><br>
                                    <a href="${pageContext.request.contextPath}/addFavorite?jobID=${job.jobID}"><span class="favorite" >♡</span></a>
                                </div>
                                <div class="company">${job.companyName}</div>
                                <div class="meta">
                                    <span class="salary">💰 ${job.salary}</span>
                                    <span class="location">📍 ${job.location}</span>
                                </div>
                            </div>

                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>