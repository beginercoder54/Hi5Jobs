<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value='/css/headerLayoutPost1.css'/>" />
<!-- layout.jsp -->
<jsp:include page="header1.jsp" />
<div class="app-container">
  <aside class="sidebar">
    <!-- Sidebar menu: Tài khoản, Tuyển dụng -->
    <%@ include file="header.jsp" %>
  </aside>

  <main class="main-content">
    <!-- Đây là chỗ sẽ hiện nội dung từng trang như postForm.jsp -->
    <jsp:include page="${body}" />
  </main>
</div>
