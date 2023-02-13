package com.example.ss11_mvc.repository;

import com.example.ss11_mvc.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void update(Customer customer);
    void remove(int id);
}
