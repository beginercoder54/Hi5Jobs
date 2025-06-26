<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main-wrapper">
    <c:choose>
        <c:when test="${not empty sessionScope.accountID}">
            <jsp:include page="headerLogin.jsp" />
        </c:when>
        <c:otherwise>
            <jsp:include page="header.jsp" />
        </c:otherwise>
    </c:choose>

    <div class="content">
        <jsp:include page="${body}"/>
    </div>
    <jsp:include page="footer.jsp"/>
</div>
<style>
    html, body {
        height: 100%;
        margin: 0;
        padding: 0;
    }

    .main-wrapper {
        min-height: 100vh;
        display: flex;
        flex-direction: column;
    }

    .content {
        flex: 1; /* chiếm toàn bộ chiều cao còn lại để đẩy footer xuống */
    }

    .footer {
        background: #ed8846;
        text-align: center;
        padding: 10px;
    }

</style>