package com.example.ss11_mvc_bai_tap.service;

import com.example.ss11_mvc_bai_tap.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);

    List<Product> search(String name);

    void delete(Product product);
    Product findById(int id);

    void edit(Product product);
}
