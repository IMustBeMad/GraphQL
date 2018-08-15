package com.my.service;

import com.my.entity.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    Book addBook(String title, BigDecimal price, Long authorId);

    List<Book> getAll();

    Long getCount();

    void saveAll(List<Book> books);
}
