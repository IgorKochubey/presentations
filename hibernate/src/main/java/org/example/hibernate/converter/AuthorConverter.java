package org.example.hibernate.converter;

import lombok.AllArgsConstructor;
import org.example.hibernate.dto.AuthorDto;
import org.example.hibernate.entity.Author;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorConverter {
//    private final BookConverter bookConverter;

    public Author convertToEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setEmail(authorDto.getEmail());
        return author;
    }

//    public AuthorDto convertToDto(Author author) {
//        AuthorDto authorDto = new AuthorDto();
//        authorDto.setName(author.getName());
//        authorDto.setEmail(author.getEmail());
//
//        List<BookDto> bookDtos = convertBooks(author.getBooks());
//        authorDto.setBooks(bookDtos);
//        return authorDto;
//    }
//
//    private List<BookDto> convertBooks(List<Book> books) {
//        List<BookDto> bookDtos = new ArrayList<>();
//        for (Book book : books) {
//            BookDto bookDto = bookConverter.convertToDto(book);
//            bookDtos.add(bookDto);
//        }
//        return bookDtos;
//    }
}
