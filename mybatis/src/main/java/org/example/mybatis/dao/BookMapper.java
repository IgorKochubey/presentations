package org.example.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.mybatis.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {
    List<Book> findAll();

    Book findById(@Param("bookId") Long bookId);

    void deleteById(@Param("bookId")Long bookId);

    Long create(Book book);

    void update(Book book);
}