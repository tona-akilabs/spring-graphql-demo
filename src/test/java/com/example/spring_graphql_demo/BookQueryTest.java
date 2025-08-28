package com.example.spring_graphql_demo;

import com.example.spring_graphql_demo.entity.Book;
import com.example.spring_graphql_demo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

// @GraphQlTest
@SpringBootTest
@AutoConfigureGraphQlTester
public class BookQueryTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldGetBookById() {
        String document = """
            query {
              bookById(id: "1") {
                id
                title
                author
              }
            }
        """;

        graphQlTester.document(document)
                .execute()
                .path("bookById.title")
                .entity(String.class)
                .isEqualTo("Effective Java");
    }

}
