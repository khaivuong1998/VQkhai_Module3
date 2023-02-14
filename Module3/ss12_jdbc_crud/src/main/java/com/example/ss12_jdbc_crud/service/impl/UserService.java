package com.example.ss12_jdbc_crud.service.impl;

import com.example.ss12_jdbc_crud.model.User;
import com.example.ss12_jdbc_crud.repository.IUserRepository;
import com.example.ss12_jdbc_crud.repository.impl.UserRepository;
import com.example.ss12_jdbc_crud.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository iUserRepository = new UserRepository();

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}