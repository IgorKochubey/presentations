package org.example.hibernate.controller;

import lombok.AllArgsConstructor;
import org.example.hibernate.converter.BookConverter;
import org.example.hibernate.dto.BookDto;
import org.example.hibernate.entity.Book;
import org.example.hibernate.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookConverter bookConverter;

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = bookService.getAllBooks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        Optional<Book> bookOpt = bookService.getBookById(bookId);
        return bookOpt.map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Book> createOrUpdateBook(@RequestBody BookDto bookDto) {
        Book book = bookConverter.convertToEntity(bookDto);
        Book updated = bookService.createOrUpdateBook(book);
        return new ResponseEntity<>(updated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookId}")
    public HttpStatus deleteBookById(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
        return HttpStatus.NO_CONTENT;
    }
}
