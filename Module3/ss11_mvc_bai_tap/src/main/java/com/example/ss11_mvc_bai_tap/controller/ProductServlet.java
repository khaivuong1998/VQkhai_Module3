package com.example.ss11_mvc_bai_tap.controller;

import com.example.ss11_mvc_bai_tap.model.Product;
import com.example.ss11_mvc_bai_tap.service.IProductService;
import com.example.ss11_mvc_bai_tap.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService iProductService = new ProductService();

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
            case "search":
                request.getRequestDispatcher("/view/search.jsp").forward(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = iProductService.findById(id);
                request.setAttribute("product", product);
                request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("productList", iProductService.findAll());
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
                double price = Double.parseDouble(request.getParameter("price"));
                String description = request.getParameter("description");
                String producer = request.getParameter("producer");
                Product product = new Product(name, price, description, producer);
                iProductService.save(product);
                response.sendRedirect("/product");
                break;
            case "search":
                String name2 = request.getParameter("name");
                List<Product> productList = iProductService.search(name2);
                if (productList == null) {
                    try {
                        request.getRequestDispatcher("/view/error404.jsp").forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        request.setAttribute("productList", productList);
                        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                String name1 = request.getParameter("name1");
                double price1 = Double.parseDouble(request.getParameter("price1"));
                String description1 = request.getParameter("description1");
                String producer1 = request.getParameter("producer1");
                Product product1 = iProductService.findById(id);
                product1.setName(name1);
                product1.setPrice(price1);
                product1.setProducer(producer1);
                product1.setDescription(description1);
                iProductService.edit(product1);
                response.sendRedirect("/product");
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);

        request.setAttribute("product", product);
        try {
            request.getRequestDispatcher("/view/delete.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);

        if (product == null) {
            try {
                request.getRequestDispatcher("/view/error404.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            iProductService.delete(product);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
