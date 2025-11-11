<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>CineMan - Trang Chủ</title></head>
<body>
<h1>Chào mừng đến CineMan!</h1>
<h2>Đăng Nhập</h2>
<% if (session.getAttribute("success") != null) { %>
<p style="color:green;"><%= session.getAttribute("success") %></p>
<% session.removeAttribute("success"); %>
<% } %>
<form action="#" method="post">
    <label>Tên đăng nhập: <input type="text" name="username" required></label><br><br>
    <label>Mật khẩu: <input type="password" name="password" required></label><br><br>
    <button type="submit">Đăng Nhập</button>
</form>
<%--<p><a href="${pageContext.request.contextPath}/register">Đăng ký thành viên</a></p>--%>
<p><a href="register">Đăng ký thành viên</a></p>
</body>
</html>