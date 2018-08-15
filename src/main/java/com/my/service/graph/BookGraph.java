package com.my.service.graph;

import com.my.entity.Book;
import com.my.service.BookService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@GraphQLApi
public class BookGraph {

    @Autowired
    private BookService bookService;

    @GraphQLQuery(name = "findAllBooks")
    public List<Book> findAllBooks() {
        return bookService.getAll();
    }

    @GraphQLQuery(name = "countBooks")
    public Long countBooks() {
        return bookService.getCount();
    }

    @GraphQLMutation(name = "addBook")
    public Book addBook(@GraphQLArgument(name = "title") String title,
                        @GraphQLArgument(name = "price") BigDecimal price,
                        @GraphQLArgument(name = "authorId") Long authorId) {
        return bookService.addBook(title, price, authorId);
    }
}
