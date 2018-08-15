package com.my.service.impl;

import com.my.entity.Book;
import com.my.repository.BookRepository;
import com.my.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void saveAll(List<Book> books) {
        bookRepository.saveAll(books);
    }
}
