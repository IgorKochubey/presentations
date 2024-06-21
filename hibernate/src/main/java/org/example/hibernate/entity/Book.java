package org.example.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_book", unique = true, nullable = false)
    private Long idBook;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_author", referencedColumnName = "id_author"))
    @LazyCollection(LazyCollectionOption.EXTRA)
    @JsonBackReference
    private List<Author> authors;
}

