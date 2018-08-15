package com.my.service;

import com.my.entity.Book;

import java.util.List;

public interface BookService {

    void saveAll(List<Book> books);
}
