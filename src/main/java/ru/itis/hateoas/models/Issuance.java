package ru.itis.hateoas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Issuance {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime dateOfIssue;

    private LocalDateTime returnDate;

    private Boolean isPassed;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Reader reader;
}
