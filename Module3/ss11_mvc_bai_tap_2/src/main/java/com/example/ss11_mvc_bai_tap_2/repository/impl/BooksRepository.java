package com.example.ss11_mvc_bai_tap_2.repository.impl;

import com.example.ss11_mvc_bai_tap_2.model.Book;
import com.example.ss11_mvc_bai_tap_2.repository.IBooksRepository;

import java.util.ArrayList;
import java.util.List;

public class BooksRepository implements IBooksRepository {
    private static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1, "dsygy", 365, "sdhbshd", "dsyfasfa"));
        bookList.add(new Book(33, "tghf", 431, "fhifj", "fgshvz"));
        bookList.add(new Book(6, "HDHD", 5674, "tam", "2twesdg"));
        bookList.add(new Book(24, "dh", 33, "euvHHd", "1216sa"));
    }

    @Override
    public void save(Book book) {
        book.setId(bookList.size() + 1);
        bookList.add(book);
    }

    @Override
    public void edit(Book book) {
        for (int i = 0; i < bookList.size(); i++) {
            if (book.getId() == bookList.get(i).getId()) {
                bookList.set(i, bookList.get(i));
            }
        }
    }

    @Override
    public void delete(Book book) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == book.getId()) ;
        }
    }

    @Override
    public Book findByID(int id) {
        for (Book book : bookList) {
            if (id == book.getId()) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> search(String title) {
        List<Book> bookList1 = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().contains(title)) {
                bookList1.add(bookList.get(i));
            }
        }
        return bookList1;
    }

    @Override
    public List<Book> findAll() {
        return bookList;
    }
}
