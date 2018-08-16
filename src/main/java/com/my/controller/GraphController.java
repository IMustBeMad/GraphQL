package com.my.controller;

import com.my.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GraphController {

    @Autowired
    private GraphService graphService;

    @PostMapping(path = "/graph-parser", consumes = "application/json")
    public Map<String, Object> processGraphQuery(@RequestBody Map<String, Object> request) {
        return graphService.processQuery(request);
    }
}
