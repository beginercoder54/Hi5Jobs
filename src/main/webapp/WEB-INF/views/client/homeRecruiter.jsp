<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Hi5Jobs</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homeRE.css">
    </head>
    <body>
        <div style="width: 50%; height: 10px; background-color: gray; border-radius: 5px; margin: auto;"></div>

        <div class="section-header">
            <h2>Chúng tôi không chỉ giúp bạn tuyển người <br>Chúng tôi giúp bạn tuyển đúng người</h2>
        </div>

        <div class="grid-container">
            <div class="info-item-horizontal">
                <div class="number-circle">1</div>
                <div class="info-content">
                    <p><strong>Nguồn ứng viên chất lượng, luôn sẵn sàng</strong></p>
                    <p>
                        Tiếp cận kho ứng viên khổng lồ với hàng triệu hồ sơ đa ngành nghề<br>
                        Hơn 50 triệu lượt truy cập mỗi năm – bạn luôn có cơ hội kết nối với người<br>
                        phù hợp nhất, đúng thời điểm
                    </p>
                </div>
            </div>

            <div class="info-item-horizontal">
                <div class="number-circle">2</div>
                <div class="info-content">
                    <p><strong>Tài khoản nhà tuyển dụng thông minh - Quản lý dễ dàng</strong></p>
                    <p>
                        Hệ thống tích hợp các công cụ hiện đại:<br>
                        Quản lý nhanh gọn<br>
                        Theo dõi lượt xem,lượng ứng tuyển theo thời gian thực<br><!-- comment -->
                        Lưu trữ và xử lý hồ sơ khoa học,tiện lợi
                    </p>
                </div>
            </div>
            <div class="info-item-horizontal">
                <div class="number-circle">3</div>
                <div class="info-content">
                    <p><strong>CSKH chuyên nghiệp - Luôn đồng hành cùng bạn</strong></p>
                    <p>
                        Đội ngũ hỗ trợ giàu kinh nghiệm, sẵn sàng giải đáp 24/7<br>
                        Tư vấn tận tình từng bước để giúp bạn tuyển được đúng người,đúng vị trí<br>
                        Hỗ trợ kĩ thuật nhanh chóng - bạn chỉ cần tập trung vào tuyển dụng 
                    </p>
                </div>
            </div>

            <div class="info-item-horizontal">
                <div class="number-circle">4</div>
                <div class="info-content">
                    <p><strong>Đăng tin trong vài phút - Nhận hồ sơ ngay trong ngày</strong></p>
                    <p>
                        Giao diện đăng tin trực quan,thao tác cực nhanh<br>
                        Tuyển dụng hiển thị nổi bật,dễ thu hút ứng viên phù hợp <br>
                        Theo dõi trạng thái tin đăng và lượng nộp đơn theo thời gian thực
                    </p>
                </div>
            </div>
        </div>
        <div class="cta-button">
            <a class="btn-primary" onclick="checkLoginAndRedirect()">Đăng tin ngay</a>
        </div>

        <div class="consultant-support">
            <h3>Hỗ trợ tư vấn tuyển dụng</h3>
            <div class="consultants">
                <div class="consultant"><img src="${pageContext.request.contextPath}/image/member.png" alt="Member"><p>Trương Hoàng Phúc</p></div>
                <div class="consultant"><img src="${pageContext.request.contextPath}/image/member.png" alt="Member"><p>Xầu Gia Hưng</p></div>
                <div class="consultant"><img src="${pageContext.request.contextPath}/image/member.png" alt="Member"><p>Nguyễn Đức Lương</p></div>
            </div>

        </div>
        <div class="btn-secondary" onclick="alert('Coming soon')">Tư vấn tuyển dụng</div>
        <div class="about-container">
            <h2>ABOUT US</h2>
            <div class="about-content">
                <div class="about-text">
                    <h3>Về Chúng Tôi</h3>
                    <p>Chúng tôi là một nền tảng tuyển dụng hiện đại, với sứ mệnh kết nối nhà tuyển dụng và người tìm việc một cách nhanh chóng, thông minh và hiệu quả.<br>
                        Ra đời nhằm giải quyết những khó khăn trong quá trình tuyển dụng và tìm việc, website của chúng tôi giúp đơn giản hóa quy trình, giúp nhà tuyển dụng tìm đúng người và ứng viên tìm đúng cơ hội để phát triển sự nghiệp.</p>
                    <h3>Đổi mới phát triển – Nhờ những đam mê</h3>
                    <p>
                        Chúng tôi gồm 5 thành viên trẻ, có kinh nghiệm trong lĩnh vực tuyển dụng, thiết kế trải nghiệm người dùng và phát triển hệ thống:
                        Mỗi người có một thế mạnh riêng, nhưng chung một mục tiêu: tạo ra nền tảng hữu ích, dễ dùng và thực sự mang lại giá trị.
                        Giao diện thân thiện, tính năng thông minh, gợi ý dựa trên AI – tất cả đều được xây dựng với tâm huyết và trách nhiệm.
                    </p>
                    <h3>Tâm nhìn & Giá trị cốt lõi</h3>
                    <p>
                        Đơn giản & Hiệu quả – Giúp tiết kiệm thời gian trong quá trình tuyển dụng và tìm việc.
                        Minh bạch & Tin cậy – Tạo môi trường uy tín cho cả doanh nghiệp và ứng viên.
                        Liên tục cải tiến – Lắng nghe phản hồi để nâng cao trải nghiệm người dùng.
                    </p>
                    <p>Chúng tôi luôn đồng hành cùng bạn – dù bạn là doanh nghiệp đang mở rộng đội ngũ, hay ứng viên tìm kiếm cơ hội mới. Hãy bắt đầu hành trình tại đây – nơi kết nối nghề nghiệp khởi đầu</p>
                </div>
                <div class="about-image">
                    <img src="${pageContext.request.contextPath}/image/logo-hi5jobs.png" alt="Hi5Jobs">
                </div>
            </div>

            <div class="about-buttons">
                <button class="btn-consult" onclick="alert('Coming soon')">Tư vấn tuyển dụng</button>
                <button class="btn-post" onclick="checkLoginAndRedirect()">Đăng tin ngay</button>
            </div>
        </div>
                <%
    Integer accountID = (Integer) session.getAttribute("accountID");
%>

<script>
    function checkLoginAndRedirect() {
        const accountID = <%= accountID != null ? accountID : "null" %>;
        if (accountID !== null) {
            window.location.href = "<c:url value='/post'/>";
        } else {
            alert("Bạn cần đăng nhập để đăng tin tuyển dụng!");
        }
    }
</script>
    </body>
</html>