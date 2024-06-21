package org.example.hibernate.service;

import lombok.AllArgsConstructor;
import org.example.hibernate.dao.AuthorRepository;
import org.example.hibernate.dao.BookRepository;
import org.example.hibernate.entity.Author;
import org.example.hibernate.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public Optional<Author> getAuthorById(Long authorId) {
        return authorRepository.findById(authorId);
    }

    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author createOrUpdateAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    public Optional<Author> addBookToAuthor(Long authorId, Long bookId) {
        Optional<Author> authorOpt = authorRepository.findById(authorId);
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if(authorOpt.isPresent() && bookOpt.isPresent()) {
            Author author = authorOpt.get();
            Book book = bookOpt.get();
            author.getBooks().add(book);
            return authorOpt;
        }
        return Optional.empty();
    }
}
