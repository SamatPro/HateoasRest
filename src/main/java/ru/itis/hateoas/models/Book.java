package ru.itis.hateoas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private Long year;
    private String description;

    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "genre_id"))
    @Column(name = "book_id")
    private Set<Genre> genre;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToOne
    private PublishingHouse publishingHouse;

    private Boolean isForSale;

    @OneToMany(mappedBy = "book")
    private List<Issuance> issuances;

    public void sell(){
        if (!this.isForSale){
            throw new IllegalStateException();
        }
    }
}
