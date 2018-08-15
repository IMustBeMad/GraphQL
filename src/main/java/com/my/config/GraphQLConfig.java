package com.my.config;

import com.my.service.graph.AuthorGraph;
import com.my.service.graph.BookGraph;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

    @Autowired
    private BookGraph bookGraph;

    @Autowired
    private AuthorGraph authorGraph;

    @Bean
    public GraphQL graphQL(GraphQLSchema schema) {
        return GraphQL.newGraphQL(schema)
                      .build();
    }

    @Bean
    public GraphQLSchema schema() {
        return new GraphQLSchemaGenerator().withOperationsFromSingleton(bookGraph)
                                           .withOperationsFromSingleton(authorGraph)
                                           .generate();
    }
}
