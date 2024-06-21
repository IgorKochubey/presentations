package org.example.hibernate.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {
    private Long idAuthor;
    private String name;
    private String email;
    private List<BookDto> books;
}
