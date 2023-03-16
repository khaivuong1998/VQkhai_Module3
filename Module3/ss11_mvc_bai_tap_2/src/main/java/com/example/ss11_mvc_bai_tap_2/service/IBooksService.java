package com.example.ss11_mvc_bai_tap_2.service;

import com.example.ss11_mvc_bai_tap_2.model.Book;

import java.util.List;

public interface IBooksService {
    void save(Book book);
    void edit(Book book);
    void delete(Book book);
    Book findByID(int id);
    List<Book> search(String title);
    List<Book> findAll();
}
