package com.my.controller;

import com.my.service.GraphQlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthorController {

    @Autowired
    private GraphQlService graphQlService;

    @PostMapping(value = "graphQl")
    public Map<String, Object> getAuthor(@RequestBody String query) {
        return graphQlService.processQuery(query);
    }
}
