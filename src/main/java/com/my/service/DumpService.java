package com.my.service;

import com.my.entity.Author;
import com.my.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Service
public class DumpService {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    private List<Author> authors = List.of(
            new Author("Dan", "Brown"),
            new Author("Lisa", "Gardner"),
            new Author("Scott", "Green"),
            new Author("Ernest", "Hebert"),
            new Author("Paul ", "Fleischman")
    );

    private List<Book> books = List.of(
            new Book(new BigDecimal("100.00"), "Angels and Demons", new Author(1L)),
            new Book(new BigDecimal("110.00"), "Origin", new Author(1L)),
            new Book(new BigDecimal("99.999"), "Inferno", new Author(1L)),

            new Book(new BigDecimal("50.00"), "The Perfect Husband", new Author(2L)),
            new Book(new BigDecimal("51.00"), "The Third Victim", new Author(2L)),
            new Book(new BigDecimal("63.99"), "Live to Tell", new Author(2L)),

            new Book(new BigDecimal("42.42"), "Private Worlds", new Author(3L)),
            new Book(new BigDecimal("45.00"), "Pulp: Poems in the Pulp Tradition", new Author(3L)),
            new Book(new BigDecimal("63.99"), "Baby Sale at the 7-Eleven", new Author(3L)),

            new Book(new BigDecimal("75.00"), "Never Back Down", new Author(4L)),
            new Book(new BigDecimal("74.99"), "New Hampshire Patterns", new Author(4L)),
            new Book(new BigDecimal("83.50"), "Howard Elmans Farewell", new Author(4L)),

            new Book(new BigDecimal("80.00"), "Swat Radio", new Author(5L)),
            new Book(new BigDecimal("99.99"), "Logomaniacs", new Author(5L)),
            new Book(new BigDecimal("150.00"), "The Birthday Tree", new Author(5L))
    );

    @PostConstruct
    public void dump() {
        authorService.saveAll(authors);
        bookService.saveAll(books);
    }
}
