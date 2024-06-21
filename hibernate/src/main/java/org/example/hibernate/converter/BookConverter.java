package org.example.hibernate.converter;

import org.example.hibernate.dto.BookDto;
import org.example.hibernate.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookConverter {
    public Book convertToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setDescription(bookDto.getDescription());
        book.setTitle(bookDto.getTitle());
        return book;
    }

//    public BookDto convertToDto(Book book) {
//        BookDto bookDto = new BookDto();
//        bookDto.setDescription(book.getDescription());
//        bookDto.setTitle(book.getTitle());
//        return bookDto;
//    }

}
