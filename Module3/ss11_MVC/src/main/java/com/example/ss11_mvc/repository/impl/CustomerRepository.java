package com.example.ss11_mvc.repository.impl;

import com.example.ss11_mvc.model.Customer;
import com.example.ss11_mvc.repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customerList.add(new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customerList.add(new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customerList.add(new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customerList.add(new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customerList.add(new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customer.setId(customerList.size() + 1);
        customerList.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void update(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }
}
