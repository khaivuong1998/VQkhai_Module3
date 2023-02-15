package com.example.ss10_demo.repository;

import com.example.ss10_demo.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Student findById(int id);

    List<Student> search(String name);

    void edit(Student student1);
}
