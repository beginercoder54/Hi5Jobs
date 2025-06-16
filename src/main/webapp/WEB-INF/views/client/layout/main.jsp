<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${not empty sessionScope.accountID}">
        <jsp:include page="headerLogin.jsp" />
    </c:when>
    <c:otherwise>
       <jsp:include page="header.jsp" />
    </c:otherwise>
</c:choose>
<jsp:include page="${body}"/>
<jsp:include page="footer.jsp"/>
