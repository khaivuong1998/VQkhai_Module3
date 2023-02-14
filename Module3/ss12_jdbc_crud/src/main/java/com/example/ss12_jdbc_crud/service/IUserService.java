package com.example.ss12_jdbc_crud.service;

import com.example.ss12_jdbc_crud.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
    
}
