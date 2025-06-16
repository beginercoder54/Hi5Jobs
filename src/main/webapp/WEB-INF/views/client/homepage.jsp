<%-- 
    Document   : homepage
    Created on : May 18, 2025, 10:54:39 PM
    Author     : hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/job-card.css">

<div class="job-container">
  <c:forEach var="job" items="${jobs}">
    <div class="job-card">
     
      <div class="content">
        <h4>${job.title}</h4>
        <div class="meta">
          <span class="salary">💰 ${job.salary}</span>
          <span class="location">📍 ${job.location}</span>
        </div>
      </div>
      <div class="favorite">♡</div>
    </div>
  </c:forEach>
</div>
