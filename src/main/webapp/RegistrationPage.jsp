<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Đăng Ký Thành Viên</title></head>
<body>
    <h2>Đăng Ký Thành Viên</h2>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="register" method="post">
        <label>Họ tên: <input type="text" name="fullName" required></label><br><br>
        <label>Email: <input type="email" name="email" required></label><br><br>
        <label>Tên đăng nhập: <input type="text" name="username" required></label><br><br>
        <label>Mật khẩu: <input type="password" name="password" required></label><br><br>
        <label>Số điện thoại: <input type="text" name="phone"></label><br><br>
        <label>CCCD: <input type="text" name="cccd"></label><br><br>

        <button type="submit">Đăng Ký</button>
    </form>
    <br><a href="HomePage.jsp">Quay lại trang chủ</a>
</body>
</html>