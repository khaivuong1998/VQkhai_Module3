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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                request.getRequestDispatcher("/view/student/create.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Student student = iStudentService.findById(id);
                request.setAttribute("student", student);
                request.getRequestDispatcher("/view/student/edit.jsp").forward(request, response);
                break;
//            case "search":
//                String name = request.getParameter("name");
//                request.setAttribute("name", name);
//                request.setAttribute("studentList", iStudentService.search(name));
//                request.getRequestDispatcher("/view/student/list.jsp").forward(request, response);
//                break;
            default:
                request.setAttribute("studentList", iStudentService.findAll());
                request.getRequestDispatcher("/view/student/list.jsp").forward(request, response);
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
                double score = Double.parseDouble(request.getParameter("score"));
                Student student = new Student(name, score);
                iStudentService.save(student);
                response.sendRedirect("/student");
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                String name1 = request.getParameter("name");
                double score1 = Double.parseDouble(request.getParameter("score"));
                Student student1 = iStudentService.findById(id);
                student1.setName(name1);
                student1.setScore(score1);
                iStudentService.edit(student1);
                response.sendRedirect("/student");
                break;
            case "search":
                String name2 = request.getParameter("name");
                request.setAttribute("name", name2);
                request.setAttribute("studentList", iStudentService.search(name2));
                request.getRequestDispatcher("/view/student/list.jsp").forward(request, response);
                break;
        }
    }
}
