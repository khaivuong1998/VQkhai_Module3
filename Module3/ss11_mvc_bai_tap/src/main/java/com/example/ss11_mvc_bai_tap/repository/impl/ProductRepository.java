package com.example.ss11_mvc_bai_tap.repository.impl;

import com.example.ss11_mvc_bai_tap.model.Product;
import com.example.ss11_mvc_bai_tap.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Grande", 52000000, "pro", "Yamaha"));
        productList.add(new Product(2, "Exciter135", 43000000, "medium", "Yamaha"));
        productList.add(new Product(3, "Winner", 62000000, "pro", "Honda"));
        productList.add(new Product(4, "SH", 125000000, "vip", "Yamaha"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        product.setId(productList.size() + 1);
        productList.add(product);
    }
}
