package com.example.spring_graphql_demo.controller;

import com.example.spring_graphql_demo.entity.Project;
import com.example.spring_graphql_demo.helper.Pagination;
import com.example.spring_graphql_demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProjectController {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @QueryMapping
    public Pagination<Project> projects(@Argument int page, @Argument int size) {
        Page<Project> recordsPage = projectRepository.findAll(PageRequest.of(page, size));
        return new Pagination<Project>(recordsPage.getNumber(), recordsPage.getSize(), recordsPage.getTotalElements(), recordsPage.getTotalPages(), recordsPage.getContent());
    }

    @QueryMapping
    public Project projectById(@Argument String id) {
        return projectRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
