package com.example.spring_graphql_demo.repository;

import com.example.spring_graphql_demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
