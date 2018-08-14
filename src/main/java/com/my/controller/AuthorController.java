package com.my.controller;

import graphql.ExecutionInput;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private GraphQL graphQL;

    @PostMapping(value = "author")
    public String getAuthor(@RequestBody String query) {
        return graphQL.execute(ExecutionInput.newExecutionInput().query(query).build())
                      .getData()
                      .toString();
    }
}
