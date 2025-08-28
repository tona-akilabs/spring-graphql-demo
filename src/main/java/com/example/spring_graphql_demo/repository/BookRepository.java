package com.example.spring_graphql_demo.repository;

import com.example.spring_graphql_demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
