package com.example.ss09_jsp_servlet_bai_tap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String passwork = request.getParameter("passwork");
        String name = "";
        if (username.equals("admin") && passwork.equals("123abc")) {
            name = "Admin đăng nhập thành công";
            request.setAttribute("name", name);
            request.setAttribute("date", new Date());
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            name = "Tên đăng nhập hoặc mật khẩu không đúng";
            request.setAttribute("name", name);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
