package ru.itis.hateoas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublishingHouse {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String address;
    private Long phone;
    private String email;
    private String site;

    @OneToMany(mappedBy = "publishingHouse")
    private List<Book> books;
}
