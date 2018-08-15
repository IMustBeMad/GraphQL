package com.my.service.impl;

import com.my.entity.Book;
import com.my.repository.AuthorRepository;
import com.my.repository.BookRepository;
import com.my.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional
    public Book addBook(String title, BigDecimal price, Long authorId) {
        Book book = new Book();
        book.setTitle(title);
        book.setPrice(price);
        book.setAuthor(authorRepository.findById(authorId).get());

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Long getCount() {
        return bookRepository.count();
    }

    @Override
    @Transactional
    public void saveAll(List<Book> books) {
        bookRepository.saveAll(books);
    }
}
