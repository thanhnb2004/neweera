package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DAO.CustomerDAO;
import org.example.model.Customer;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final CustomerDAO customerDao = new CustomerDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/RegistrationPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        // Lấy dữ liệu từ form
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");


        String cccdStr = req.getParameter("cccd") != null ? req.getParameter("cccd").trim() : "";
        // BỎ: String codeCustomerStr = req.getParameter("codeCustomer");


        int codeCustomer = 0;
        // --------------------------------------------------


        long cccd = 0;


        try {
            if (cccdStr.isEmpty()) {
                req.setAttribute("error", "Vui lòng nhập CCCD!");
                req.getRequestDispatcher("/RegistrationPage.jsp").forward(req, resp);
                return;
            }
            cccd = Long.parseLong(cccdStr);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "CCCD phải là chữ số!");
            req.getRequestDispatcher("/RegistrationPage.jsp").forward(req, resp);
            return;
        }

        // Tạo đối tượng Customer (id = 0 vì auto-increment)
        Customer customer = new Customer(
                username,
                password,
                fullName,
                email,
                phone,
                0,
                cccd,
                codeCustomer
        ) {

        };

        // Kiểm tra email tồn tại
        if (customerDao.emailExists(email)) {
            req.setAttribute("error", "Email đã tồn tại!");
            req.getRequestDispatcher("/RegistrationPage.jsp").forward(req, resp);
            return;
        }

        // Lưu vào database
        String result = customerDao.save(customer);
        if (result.contains("thành công")) {
            req.getSession().setAttribute("success", result);
            resp.sendRedirect("LoginPage.jsp");
        } else {
            req.setAttribute("error", result);
            req.getRequestDispatcher("/RegistrationPage.jsp").forward(req, resp);
        }
    }
}