package com.example.ss11_mvc.service;

import com.example.ss11_mvc.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void update(Customer customer);
    void remove(int id);
}
