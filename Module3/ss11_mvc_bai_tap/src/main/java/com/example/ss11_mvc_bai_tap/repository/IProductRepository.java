package com.example.ss11_mvc_bai_tap.repository;

import com.example.ss11_mvc_bai_tap.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
}
