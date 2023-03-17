package com.example.ss11_mvc_bai_tap_2.controller;

import com.example.ss11_mvc_bai_tap_2.model.Book;
import com.example.ss11_mvc_bai_tap_2.service.IBooksService;
import com.example.ss11_mvc_bai_tap_2.service.impl.BooksService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BooksServlet", value = "/books")
public class BooksServlet extends HttpServlet {
    private IBooksService iBooksService = new BooksService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String actionBooks = request.getParameter("actionBooks");
        if (actionBooks == null) {
            actionBooks = "";
        }
        switch (actionBooks) {
            case "create":
                request.getRequestDispatcher("/view/create.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Book book = iBooksService.findByID(id);
                request.setAttribute("book", book);
                request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("bookList", iBooksService.findAll());
                request.getRequestDispatcher("/view/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String actionBooks = request.getParameter("actionBooks");
        if (actionBooks == null) {
            actionBooks = "";
        }
        switch (actionBooks) {
            case "create":
                String title = request.getParameter("title");
                int pageSize = Integer.parseInt(request.getParameter("pageSize"));
                String author = request.getParameter("author");
                int category = Integer.parseInt(request.getParameter("category"));
                Book book = new Book(title, pageSize, author, category);
                iBooksService.save(book);
                response.sendRedirect("/books");
                break;
            case "edit":
                int id1 =Integer.parseInt(request.getParameter("id"));
                String title1 = request.getParameter("title");
                int pageSize1 = Integer.parseInt(request.getParameter("pageSize"));
                String author1 = request.getParameter("author");
                int category1 = Integer.parseInt(request.getParameter("category"));
                Book book1 = iBooksService.findByID(id1);
                book1.setTitle(title1);
                book1.setPageSize(pageSize1);
                book1.setAuthor(author1);
                book1.setCategory(category1);
                iBooksService.edit(book1);
                response.sendRedirect("/books");
                break;
            case "search":
                String title2 = request.getParameter("title");
                request.setAttribute("title", title2);
                List<Book> bookList = iBooksService.search(title2);
                request.setAttribute("bookList", bookList);
                request.getRequestDispatcher("/view/list.jsp").forward(request, response);
                break;
        }
    }
}
