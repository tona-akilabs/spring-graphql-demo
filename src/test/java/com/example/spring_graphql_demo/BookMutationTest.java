package com.example.spring_graphql_demo;

import com.example.spring_graphql_demo.entity.Book;
import com.example.spring_graphql_demo.repository.BookRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.mockito.Mockito.*;

//@GraphQlTest
@SpringBootTest
@AutoConfigureGraphQlTester
public class BookMutationTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private BookRepository bookRepository; // Mock instead of real DB

    @Test
    void shouldAddBook() {
        // Mock repo save behavior
        Book saved = new Book();
        saved.setId(1L);
        saved.setTitle("Clean Code");
        saved.setAuthor("Robert C. Martin");

        when(bookRepository.save(any(Book.class))).thenReturn(saved);

        String mutation = """
            mutation {
              addBook(book: {title: "Clean Code", author: "Robert C. Martin"}) {
                id
                title
                author
              }
            }
        """;

        graphQlTester.document(mutation)
                .execute()
                .path("addBook.title")
                .entity(String.class)
                .isEqualTo("Clean Code");
    }
}
