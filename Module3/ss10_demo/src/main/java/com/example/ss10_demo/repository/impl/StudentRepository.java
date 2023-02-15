package com.example.ss10_demo.repository.impl;

import com.example.ss10_demo.model.Student;
import com.example.ss10_demo.repository.IStudentRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        List<Student> studentList1 = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("select * from student;");
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setScore(resultSet.getDouble("score"));
                studentList1.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList1;
    }

    @Override
    public void save(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("insert into student (`name`, score) values (?, ?);");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDouble(2, student.getScore());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student findById(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("select * from student where id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student;
            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setScore(resultSet.getDouble("score"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("delete from student where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(Student student) {
        try {
            CallableStatement callableStatement = BaseRepository.getConnection()
                    .prepareCall("call update_student(?,?,?);");
            callableStatement.setString(1, student.getName());
            callableStatement.setDouble(2, student.getScore());
            callableStatement.setInt(3, student.getId());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> search(String name) {
        List<Student> studentList1 = new ArrayList<>();
        try {
            CallableStatement callableStatement = BaseRepository.getConnection()
                    .prepareCall("call student_search(?);");
            callableStatement.setString(1, name);
            ResultSet resultSet = callableStatement.executeQuery();
            Student student;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setScore(resultSet.getDouble("score"));
                studentList1.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList1;
    }
}
