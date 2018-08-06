package com.my.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.my.entity.Author;
import com.my.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
