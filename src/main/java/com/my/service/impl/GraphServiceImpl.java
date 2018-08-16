package com.my.service.impl;

import com.my.service.GraphService;
import graphql.ExecutionInput;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class GraphServiceImpl implements GraphService {

    @Autowired
    private GraphQL graphQL;

    @Override
    @Transactional
    public Map<String, Object> processQuery(Map<String, Object> request) {
        return graphQL.execute(getInput(request))
                      .toSpecification();
    }

    private ExecutionInput getInput(Map<String, Object> query) {
        return ExecutionInput.newExecutionInput()
                             .query((String) query.get("query"))
                             .operationName((String) query.get("operationName"))
                             .build();
    }
}
