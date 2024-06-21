package org.example.hibernate.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookDto {
    private Long idBook;
    private String title;
    private String description;
    private List<AuthorDto> authors;
}

