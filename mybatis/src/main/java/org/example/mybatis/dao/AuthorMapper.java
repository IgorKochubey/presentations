package org.example.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.mybatis.entity.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuthorMapper {
    List<Author> findAll();

    Author findById(@Param("authorId") Long authorId);

    void deleteById(@Param("authorId")Long authorId);

    Long create(Author author);

    void update(Author author);

    void addBookToAuthor(@Param("authorId") Long authorId, @Param("bookId") Long bookId);
}