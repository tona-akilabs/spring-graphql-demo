package com.example.spring_graphql_demo;

import com.example.spring_graphql_demo.entity.Book;
import com.example.spring_graphql_demo.entity.Project;
import com.example.spring_graphql_demo.repository.BookRepository;
import com.example.spring_graphql_demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringGraphqlDemoApplication implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlDemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // Initialize some data
        bookRepository.save(new Book(null, "Effective Java", "Joshua Bloch"));
        bookRepository.save(new Book(null, "Clean Code", "Robert C. Martin"));

        projectRepository.save(new Project(null, "GraphQL API", LocalDate.now()));
        projectRepository.save(new Project(null, "Spring Boot App", LocalDate.now()));
    }
}
