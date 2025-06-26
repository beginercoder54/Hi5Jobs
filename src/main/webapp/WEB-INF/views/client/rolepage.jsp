
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Hi5Jobs - Register</title>
        <link rel="stylesheet" href="<c:url value='/css/rolepage.css?v=5' />" />
    </head>
    <body>
        <div class="container">
            <div class="left-panel">
                <p class="slogan">Your Job. Your Team. Your Future</p>
                <img src="${pageContext.request.contextPath}/image/logo-hi5jobs.png" class="illustration" alt="Hi5Jobs">
            </div>

            <div class="role-selection">
                <h2>You are...</h2>
                <div class="role-buttons">
                    <form action="${pageContext.request.contextPath}/register-role" method="post">
                        <input type="hidden" name="accountID" value="${param.accountID}">
                        <button type="submit" name="role" value="2" class="role-button">
                            <img src="${pageContext.request.contextPath}/image/seeker-icon.png" alt="Người tìm việc">
                            <span>Jobseeker</span>
                        </button>
                    </form>


                    <form action="${pageContext.request.contextPath}/register-role" method="post">
                        <input type="hidden" name="accountID" value="${param.accountID}">
                        <button type="submit" name="role" value="3" class="role-button">
                            <img src="${pageContext.request.contextPath}/image/recruiter-icon.png" alt="Nhà tuyển dụng">
                            <span>Recruiter</span>
                        </button>
                    </form>
                </div>
            </div>

        </div>
    </body>
</html>
<!--<script>
    let url = window.location.search;
    alert(url);
    const a = document.getElementById('role_Jobseeker'); //or grab it by tagname etc
    a.href = "${pageContext.request.contextPath}/register/update" + url + "&role=Jobseeker";
</script>
<a id="role_Jobseeker"  href="/" name="role" value="2" class="role-button">
    <img src="${pageContext.request.contextPath}/image/seeker-icon.png" alt="Người tìm việc">
    <span>Jobseeker</span>
</a>-->