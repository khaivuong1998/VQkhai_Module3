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

    @Override
    public Student findById(int id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public List<Student> search(String name) {
        return iStudentRepository.search(name);
    }

    @Override
    public void edit(Student student1) {
        iStudentRepository.edit(student1);
    }
}
