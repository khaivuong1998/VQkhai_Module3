package com.example.ss11_mvc_bai_tap.service.impl;

import com.example.ss11_mvc_bai_tap.model.Product;
import com.example.ss11_mvc_bai_tap.repository.IProductRepository;
import com.example.ss11_mvc_bai_tap.repository.impl.ProductRepository;
import com.example.ss11_mvc_bai_tap.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }
}
