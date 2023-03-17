package com.example.ss11_mvc_bai_tap_2.repository.impl;

import com.example.ss11_mvc_bai_tap_2.model.Book;
import com.example.ss11_mvc_bai_tap_2.repository.IBooksRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksRepository implements IBooksRepository {
//    private static List<Book> bookList = new ArrayList<>();

//    static {
//        bookList.add(new Book(1, "dsygy", 365, "sdhbshd", "dsyfasfa"));
//        bookList.add(new Book(33, "tghf", 431, "fhifj", "fgshvz"));
//        bookList.add(new Book(6, "HDHD", 5674, "tam", "2twesdg"));
//        bookList.add(new Book(24, "dh", 33, "euvHHd", "1216sa"));
//    }

    @Override
    public void save(Book book) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("insert into books (title, page_size, author, category_id) values (?, ?, ?, ?);");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getPageSize());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setInt(4, book.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Book book) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("update books set title = ?, page_size = ?, author = ?, category_id = ? where id = ?;");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getPageSize());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setInt(4, book.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Book book) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("delete from books where id = ?;");
            preparedStatement.setInt(1, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book findByID(int id) {
        CallableStatement callableStatement = null;
        try {
            callableStatement = BaseRepository.getConnection().
                    prepareCall("call find_by_id_books(?);");
            callableStatement.setInt(1, id);
            Book book;
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPageSize(resultSet.getInt("page_size"));
                book.setAuthor(resultSet.getString("author"));
                book.setCategory(resultSet.getInt("category_id"));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> search(String title) {
        List<Book> bookList = new ArrayList<>();
        CallableStatement callableStatement = null;
        try {
            callableStatement = BaseRepository.getConnection().
                    prepareCall("call books_search(?);");
            ResultSet resultSet = callableStatement.executeQuery();
            Book book;
            while (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPageSize(resultSet.getInt("page_size"));
                book.setAuthor(resultSet.getString("author"));
                book.setCategory(resultSet.getInt("category_id"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = BaseRepository.getConnection().
                    prepareStatement("select * from books;");
            ResultSet resultSet = preparedStatement.executeQuery();
            Book book;
            while (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPageSize(resultSet.getInt("page_size"));
                book.setAuthor(resultSet.getString("author"));
                book.setCategory(resultSet.getInt("category_id"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
