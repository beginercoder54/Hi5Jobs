<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Thống kê tổng quan</title>
        <link rel="stylesheet" href="<c:url value='/css/report.css'/>" />
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            .card-container {
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
                justify-content: space-between;
                margin-top: 20px;
            }
            .card {
                display: flex;
                align-items: center;
                background-color: #fbb03b;
                border-radius: 20px;
                padding: 20px;
                width: calc(33.33% - 14px);
                box-sizing: border-box;
                color: white;
            }
            .card-icon {
                background-color: #fdecb3;
                border-radius: 50%;
                width: 50px;
                height: 50px;
                display: flex;
                align-items: center;
                justify-content: center;
                margin-right: 12px;
            }
            .card-icon img {
                width: 24px;
                height: 24px;
            }
            .card-title {
                font-size: 14px;
                margin-bottom: 4px;
            }
            .card-number {
                font-size: 24px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <h3>Tổng quan</h3>

        <div class="card-container">

            <div class="card">
                <div class="card-icon">
                    <img src="<c:url value='/image/jobuser.png'/>" alt="icon" />
                </div>
                <div class="card-content">
                    <div class="card-title">Tổng ứng viên</div>
                    <div class="card-number">${stats.totalJ}</div>
                </div>
            </div>

            <div class="card">
                <div class="card-icon">
                    <img src="<c:url value='/image/resume.png'/>" alt="icon" />
                </div>
                <div class="card-content">
                    <div class="card-title">Nhà tuyển dụng</div>
                    <div class="card-number">${stats.totalE}</div>
                </div>
            </div>

            <div class="card">
                <div class="card-icon">
                    <img src="<c:url value='/image/briefcase.png'/>" alt="icon" />
                </div>
                <div class="card-content">
                    <div class="card-title">Tổng công việc</div>
                    <div class="card-number">${stats.totalJob}</div>
                </div>
            </div>

            <div class="card">
                <div class="card-icon">
                    <img src="<c:url value='/image/jobuser.png'/>" alt="icon" />
                </div>
                <div class="card-content">
                    <div class="card-title">Ứng tuyển (theo ngày)</div>
                    <div class="card-number">${stats.application}</div>
                </div>
            </div>

            <div class="card">
                <div class="card-icon">
                    <img src="<c:url value='/image/briefcase.png'/>" alt="icon" />
                </div>
                <div class="card-content">
                    <div class="card-title">Tin đăng (theo ngày)</div>
                    <div class="card-number">${stats.job}</div>
                </div>
            </div>

            <div class="card">
                <div class="card-icon">
                    <img src="<c:url value='/image/resume.png'/>" alt="icon" />
                </div>
                <div class="card-content">
                    <div class="card-title">CV được tải lên</div>
                    <div class="card-number">${stats.resume}</div>
                </div>
            </div>

        </div>
        <h3 style="margin-bottom: 10px;">Chọn khoảng thời gian</h3>
        <form action="${pageContext.request.contextPath}/admin/report" method="get" style="margin-bottom: 30px;">
            <label for="from">Từ ngày:</label>
            <input type="date" id="from" name="from" value="${param.from}" required />

            <label for="to" style="margin-left: 20px;">Đến ngày:</label>
            <input type="date" id="to" name="to" value="${param.to}" required />

            <button type="submit" style="margin-left: 20px; padding: 6px 12px; background-color: #fbb03b; color: white; border: none; border-radius: 5px; cursor: pointer;">
                Lọc
            </button>
        </form>

    </body>
</html>
