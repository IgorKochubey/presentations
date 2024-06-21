package org.example.mybatis.controller;

import lombok.AllArgsConstructor;
import org.example.mybatis.entity.Author;
import org.example.mybatis.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/authors")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> list = authorService.getAllAuthors();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId) {
        Optional<Author> authorOpt = authorService.getAuthorById(authorId);
        return authorOpt.map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Author> createOrUpdateAuthor(@RequestBody Author author) {
        Author updated = authorService.createOrUpdateAuthor(author);
        return new ResponseEntity<>(updated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{authorId}")
    public HttpStatus deleteAuthorById(@PathVariable Long authorId) {
        authorService.deleteAuthorById(authorId);
        return HttpStatus.NOT_FOUND;
    }

    @PostMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<Author> addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        Optional<Author> authorOpt = authorService.addBookToAuthor(authorId, bookId);
        return authorOpt.map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
