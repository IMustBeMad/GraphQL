package com.my.config;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

    @Autowired
    private GraphQLSchema graphQLSchema;

    @Bean
    public GraphQL graphQL() {
        return GraphQL.newGraphQL(graphQLSchema).build();
    }
}
