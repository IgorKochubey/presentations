package org.example.mybatis.service;

import lombok.AllArgsConstructor;
import org.example.mybatis.dao.AuthorMapper;
import org.example.mybatis.dao.BookMapper;
import org.example.mybatis.entity.Author;
import org.example.mybatis.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AuthorService {
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;

    @Transactional(readOnly = true)
    public Optional<Author> getAuthorById(Long authorId) {
        return Optional.ofNullable(authorMapper.findById(authorId));
    }

    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        return authorMapper.findAll();
    }

    public Author createOrUpdateAuthor(Author author) {
        long authorId;
        if (author.getIdAuthor() != null) {
            authorMapper.update(author);
            authorId = author.getIdAuthor();
        } else {
            authorId = authorMapper.create(author);
        }
        return authorMapper.findById(authorId);
    }

    public void deleteAuthorById(Long authorId) {
        authorMapper.deleteById(authorId);
    }

    public Optional<Author> addBookToAuthor(Long authorId, Long bookId) {
        Author author = authorMapper.findById(authorId);
        Book book = bookMapper.findById(bookId);
        if (author != null && book != null) {
            authorMapper.addBookToAuthor(authorId, bookId);
            return getAuthorById(authorId);
        }
        return Optional.empty();
    }
}
