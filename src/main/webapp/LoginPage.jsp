<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Đăng Nhập</title></head>
<body>
<h2>Đăng Nhập</h2>
<% if (session.getAttribute("success") != null) { %>
<p style="color:green;"><%= session.getAttribute("success") %></p>
<% session.removeAttribute("success"); %>
<% } %>
<form action="login" method="post">
    <label>Tên đăng nhập: <input type="text" name="username" required></label><br><br>
    <label>Mật khẩu: <input type="password" name="password" required></label><br><br>
    <button type="submit">Đăng Nhập</button>
</form>
</body>
</html>