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

    @Override
    public List<Product> search(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)) {
                productList1.add(productList.get(i));
            }
        }
        return productList1;
    }

    @Override
    public void delete(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.remove(i);
            }
        }
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }
}
