package com.my.service.graph;

import com.my.entity.Author;
import com.my.repository.AuthorRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class AuthorGraph {

    @Autowired
    private AuthorRepository authorRepository;

    @GraphQLQuery(name = "findAllAuthors")
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @GraphQLQuery(name = "countAuthors")
    public Long countAuthors() {
        return authorRepository.count();
    }
}
