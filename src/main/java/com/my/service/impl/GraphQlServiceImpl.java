package com.my.service.impl;

import com.my.service.GraphQlService;
import graphql.ExecutionInput;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class GraphQlServiceImpl implements GraphQlService {

    @Autowired
    private GraphQL graphQL;

    @Override
    @Transactional
    public Map<String, Object> processQuery(String query) {
        return graphQL.execute(ExecutionInput.newExecutionInput().query(query).build())
                      .toSpecification();
    }
}
