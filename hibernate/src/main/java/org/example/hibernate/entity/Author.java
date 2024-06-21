package org.example.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_author", unique = true, nullable = false)
    private Long idAuthor;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "id_author", referencedColumnName = "id_author"),
            inverseJoinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id_book"))
    @LazyCollection(LazyCollectionOption.EXTRA)
    @JsonManagedReference
    private List<Book> books;
}
