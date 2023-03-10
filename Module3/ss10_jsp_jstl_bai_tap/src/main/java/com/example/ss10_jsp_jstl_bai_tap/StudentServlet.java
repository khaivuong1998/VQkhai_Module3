package com.example.ss10_jsp_jstl_bai_tap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(5, "Hoa", 0, 57.5, "https://kenh14cdn.com/thumb_w/660/2019/8/15/img7247-15658681471561736158581.jpeg"));
        studentList.add(new Student(7, "Hoàng", 1, 69.3, "https://image.vtc.vn/upload/2020/12/27/nam-sinh-dai-hoc-luat-1-23322611.png"));
        studentList.add(new Student(33, "Vinh", 1, 77.9, "https://img.lovepik.com/photo/50128/2675_lovepik-male-university-graduate-photo-image_wh860.jpg"));
        studentList.add(new Student(2, "Tín", 1, 92.0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKuDeVrpMxN7oQB9P20t7K5t5vJxVANvG0lQ&usqp=CAU"));
        studentList.add(new Student(18, "Ngọc Châu", 0, 36.8, "https://anh.eva.vn/upload/1-2017/images/2017-03-24/can-canh-nhan-sac-nu-sinh-dai-hoc-xay-dung-gay-sot-mang-xa-hoi-2-1490345709-width500height889.jpg"));
        studentList.add(new Student(26, "Phan Thanh", 3, 60.5, "https://we25.vn/media2018/Img_News/2020/02/27/dai-hoc-thuong-mai-thong-bao-cho-sinh-vien-nghi-them-1-tuan-den-het-ngay-8-3-1_20200227163340.png"));
        studentList.add(new Student(44, "Đình Trọng", 7, "https://danviet.mediacdn.vn/upload/3-2014/images/2014-08-29/1434395469-nhfcn1_woug.jpg"));
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
