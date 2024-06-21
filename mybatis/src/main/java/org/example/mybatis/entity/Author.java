package org.example.mybatis.entity;

import lombok.Data;

import java.util.List;

@Data
public class Author {
    private Long idAuthor;
    private String name;
    private String email;
    private List<Book> books;
}
