package com.my.service.graph;

import com.my.entity.Author;
import com.my.service.AuthorService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class AuthorGraph {

    @Autowired
    private AuthorService authorService;

    @GraphQLQuery(name = "findAllAuthors")
    public List<Author> findAllAuthors() {
        return authorService.getAll();
    }

    @GraphQLQuery(name = "countAuthors")
    public Long countAuthors() {
        return authorService.getCount();
    }

    @GraphQLQuery(name = "findAllAuthorsPaginated")
    public List<Author> findAllAuthorsPaginated(@GraphQLArgument(name = "pageIndex") Integer pageIndex) {
        return authorService.getAllPaginated(pageIndex);
    }

    @GraphQLMutation(name = "addAuthor")
    public Author addAuthor(@GraphQLArgument(name = "firstName") String firstName,
                            @GraphQLArgument(name = "lastName") String lastName) {
        return authorService.addAuthor(firstName, lastName);
    }
}
