package com.example.ss10_demo.controller;

import com.example.ss10_demo.model.Student;
import com.example.ss10_demo.service.IStudentService;
import com.example.ss10_demo.service.impl.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "com.example.ss10_demo.controller.StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private IStudentService iStudentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                request.getRequestDispatcher("/view/student/create.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("studentList", iStudentService.findAll());
                request.getRequestDispatcher("/view/student/list.jsp").forward(request, response);
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
                double score = Double.parseDouble(request.getParameter("score"));
                Student student = new Student(name, score);
                iStudentService.save(student);
                response.sendRedirect("/student");
                break;
        }
    }
}
