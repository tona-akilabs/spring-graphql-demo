package com.example.spring_graphql_demo.controller;

import com.example.spring_graphql_demo.entity.Book;
import com.example.spring_graphql_demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public List<Book> all() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
