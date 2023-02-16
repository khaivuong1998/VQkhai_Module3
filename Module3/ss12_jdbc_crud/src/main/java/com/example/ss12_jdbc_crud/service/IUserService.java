package com.example.ss12_jdbc_crud.service;

import com.example.ss12_jdbc_crud.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
    User findById(int id);
    void delete(int id);
    void update(User user);

    List<User> search(String name2);
}
