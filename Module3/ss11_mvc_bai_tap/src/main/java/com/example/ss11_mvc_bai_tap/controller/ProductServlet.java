package com.example.ss11_mvc_bai_tap.controller;

import com.example.ss11_mvc_bai_tap.model.Product;
import com.example.ss11_mvc_bai_tap.service.IProductService;
import com.example.ss11_mvc_bai_tap.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService iProductService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                request.getRequestDispatcher("/view/create.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("productList", iProductService.findAll());
                request.getRequestDispatcher("/view/list.jsp").forward(request, response);
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
                double price = Double.parseDouble(request.getParameter("price"));
                String description = request.getParameter("description");
                String producer = request.getParameter("producer");
                Product product = new Product(name, price, description, producer);
                iProductService.save(product);
                response.sendRedirect("/product");
                break;
        }
    }
}
