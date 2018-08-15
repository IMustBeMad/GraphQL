package com.my.service.graph;

import com.my.entity.Book;
import com.my.repository.BookRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class BookGraph {

    @Autowired
    private BookRepository bookRepository;

    @GraphQLQuery(name = "findAllBooks")
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @GraphQLQuery(name = "countBooks")
    public Long countBooks() {
        return bookRepository.count();
    }
}
