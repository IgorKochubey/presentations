//package org.example.mybatis.service;
//
//import lombok.AllArgsConstructor;
//import org.example.hibernate.dao.BookRepository;
//import org.example.hibernate.entity.Book;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//@AllArgsConstructor
//public class BookService {
//    private final BookRepository bookRepository;
//
//    @Transactional(readOnly = true)
//    public Optional<Book> getBookById(Long bookId) {
//        return bookRepository.findById(bookId);
//    }
//
//    @Transactional(readOnly = true)
//    public List<Book> getAllBooks() {
//        return bookRepository.findAll();
//    }
//
//    public Book createOrUpdateBook(Book book) {
//        return bookRepository.save(book);
//    }
//
//    public void deleteBookById(Long bookId) {
//        bookRepository.deleteById(bookId);
//    }
//}
