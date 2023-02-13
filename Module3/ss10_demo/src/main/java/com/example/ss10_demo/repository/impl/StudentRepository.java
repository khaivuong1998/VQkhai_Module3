package com.example.ss10_demo.repository.impl;

import com.example.ss10_demo.model.Student;
import com.example.ss10_demo.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "Thắng", 5.9));
        studentList.add(new Student(2, "Kỳ", 7.8));
        studentList.add(new Student(3, "Duy", 4.6));
        studentList.add(new Student(4, "Huy", 8.8));
        studentList.add(new Student(5, "Huỳnh", 3.0));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        student.setId(studentList.size() + 1);
        studentList.add(student);
    }
}
