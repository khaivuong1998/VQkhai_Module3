package com.example.ss11_mvc.controller;

import com.example.ss11_mvc.model.Customer;
import com.example.ss11_mvc.service.ICustomerService;
import com.example.ss11_mvc.service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("customerList", iCustomerService.findAll());
                request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                Customer customer = new Customer(name, email, address);
                iCustomerService.save(customer);
                response.sendRedirect("/customer");
                break;
        }
    }
}
