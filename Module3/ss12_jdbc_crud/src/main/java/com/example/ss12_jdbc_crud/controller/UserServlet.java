package com.example.ss12_jdbc_crud.controller;

import com.example.ss12_jdbc_crud.model.User;
import com.example.ss12_jdbc_crud.service.IUserService;
import com.example.ss12_jdbc_crud.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserService iUserService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                request.getRequestDispatcher("/view/create.jsp").forward(request, response);
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                iUserService.delete(id);
                try {
                    response.sendRedirect("/user");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                int id1 = Integer.parseInt(request.getParameter("id1"));
                User user = iUserService.findById(id1);
                request.setAttribute("user", user);
                request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("userList", iUserService.findAll());
                request.getRequestDispatcher("/view/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String country = request.getParameter("country");
                User user = new User(name, email, country);
                iUserService.save(user);
                response.sendRedirect("/user");
                break;
            case "edit":
                int id1 = Integer.parseInt(request.getParameter("id1"));
                String name1 = request.getParameter("name1");
                String email1 = request.getParameter("email1");
                String country1 = request.getParameter("country1");
                User user1 = iUserService.findById(id1);
                user1.setName(name1);
                user1.setEmail(email1);
                user1.setCountry(country1);
                iUserService.update(user1);
                response.sendRedirect("/user");
                break;
        }
    }
}
