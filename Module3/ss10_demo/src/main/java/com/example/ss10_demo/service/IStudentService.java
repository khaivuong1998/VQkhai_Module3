package com.example.ss10_demo.service;

import com.example.ss10_demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);
}
