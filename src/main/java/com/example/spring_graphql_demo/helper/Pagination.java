package com.example.spring_graphql_demo.helper;

import java.util.List;

public class Pagination<T> {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private List<T> content;

    public Pagination() {}

    public Pagination(int page, int size, long totalElements, int totalPages, List<T> content) {
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public java.util.List<T> getContent() {
        return content;
    }

    public void setContent(java.util.List<T> content) {
        this.content = content;
    }
}
