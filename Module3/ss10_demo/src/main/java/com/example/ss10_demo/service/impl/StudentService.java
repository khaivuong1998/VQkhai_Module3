package com.example.ss10_demo.service.impl;

import com.example.ss10_demo.model.Student;
import com.example.ss10_demo.repository.IStudentRepository;
import com.example.ss10_demo.repository.impl.StudentRepository;
import com.example.ss10_demo.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        // Validate, xử lý nghiệp vụ,...
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }
}
