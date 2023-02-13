package com.example.ss11_mvc.service.impl;

import com.example.ss11_mvc.model.Customer;
import com.example.ss11_mvc.repository.ICustomerRepository;
import com.example.ss11_mvc.repository.impl.CustomerRepository;
import com.example.ss11_mvc.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.update(customer);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.remove(id);
    }
}
