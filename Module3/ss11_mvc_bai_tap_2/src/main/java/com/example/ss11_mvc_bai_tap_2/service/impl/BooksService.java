package com.example.ss11_mvc_bai_tap_2.service.impl;

import com.example.ss11_mvc_bai_tap_2.model.Book;
import com.example.ss11_mvc_bai_tap_2.repository.IBooksRepository;
import com.example.ss11_mvc_bai_tap_2.repository.impl.BooksRepository;
import com.example.ss11_mvc_bai_tap_2.service.IBooksService;

import java.util.List;

public class BooksService implements IBooksService {
    private IBooksRepository iBooksRepository = new BooksRepository();
    @Override
    public void save(Book book) {
        iBooksRepository.save(book);
    }

    @Override
    public void edit(Book book) {
        iBooksRepository.edit(book);
    }

    @Override
    public void delete(Book book) {
        iBooksRepository.delete(book);
    }

    @Override
    public Book findByID(int id) {
        return iBooksRepository.findByID(id);
    }

    @Override
    public List<Book> search(String title) {
        return iBooksRepository.search(title);
    }

    @Override
    public List<Book> findAll() {
        return iBooksRepository.findAll();
    }
}
