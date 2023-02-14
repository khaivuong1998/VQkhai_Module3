package com.example.ss12_jdbc_crud.repository;

import com.example.ss12_jdbc_crud.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    void save(User user);
}
