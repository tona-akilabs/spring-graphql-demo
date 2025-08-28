package com.example.spring_graphql_demo.scalar;

import graphql.schema.*;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;

import java.time.LocalDate;

public class DateScalar {
    public static final GraphQLScalarType DATE = GraphQLScalarType.newScalar()
            .name("Date")
            .description("Java LocalDate as scalar.")
            .coercing(new Coercing<LocalDate, String>() {
                @Override
                public String serialize(Object dataFetcherResult) {
                    return ((LocalDate) dataFetcherResult).toString();
                }

                @Override
                public LocalDate parseValue(Object input) {
                    return LocalDate.parse(input.toString());
                }

                @Override
                public LocalDate parseLiteral(Object input) {
                    return LocalDate.parse(input.toString());
                }
            })
            .build();
}
