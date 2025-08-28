package com.example.spring_graphql_demo.config;

import com.example.spring_graphql_demo.scalar.DateScalar;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import graphql.schema.GraphQLScalarType;
import graphql.schema.Coercing;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class GraphQLConfig {
    @Bean
    public GraphQLScalarType dateScalar() {
        return DateScalar.DATE;
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .scalar(GraphQLScalarType.newScalar()
                        .name("Date")
                        .description("Java LocalDate as a scalar.")
                        .coercing(new Coercing<LocalDate, String>() {
                            private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

                            @Override
                            public String serialize(Object dataFetcherResult) {
                                if (dataFetcherResult instanceof LocalDate) {
                                    return ((LocalDate) dataFetcherResult).format(formatter);
                                }
                                throw new IllegalArgumentException("Invalid type for Date scalar");
                            }

                            @Override
                            public LocalDate parseValue(Object input) {
                                return LocalDate.parse(input.toString(), formatter);
                            }

                            @Override
                            public LocalDate parseLiteral(Object input) {
                                return LocalDate.parse(input.toString(), formatter);
                            }
                        })
                        .build()
                );
    }
}
