package com.my.controller;

import com.my.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GraphController {

    @Autowired
    private GraphService graphService;

    @PostMapping(value = "/graphQl")
    public Map<String, Object> processGraphQuery(@RequestBody String query) {
        return graphService.processQuery(query);
    }
}
