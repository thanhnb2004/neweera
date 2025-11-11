/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DAO;

import org.example.model.Customer;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class CustomerDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/CinemaRegistration?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "126363abc";

    // Kết nối database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    // Kiểm tra email đã tồn tại chưa
    public boolean emailExists(String email) {
        String sql = "SELECT COUNT(*) FROM Customers WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lưu Customer mới
    public String save(Customer customer) {
        String sql = "INSERT INTO Customers (username, password, full_name, email, phone, cccd, code_customer) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getUsername());
            pstmt.setString(2, customer.getPassword());
            pstmt.setString(3, customer.getFullName());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getPhone());
            pstmt.setInt(6, customer.getCccd());
            pstmt.setInt(7, customer.getCodeCustomer());

            int rows = pstmt.executeUpdate();
            return rows > 0 ? "Đăng ký khách hàng thành công!" : "Lỗi khi lưu dữ liệu.";

        } catch (SQLException e) {
            // 23000 là lỗi trùng khóa (duplicate key)
            if ("23000".equals(e.getSQLState())) {
                return "Tên đăng nhập hoặc email đã tồn tại!";
            }
            e.printStackTrace();
            return "Lỗi hệ thống: " + e.getMessage();
        }
    }
}
