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
public class Reader {
    @Id
    @GeneratedValue
    private Long id;

    private String lastName;
    private String firstName;
    private String middleName;
    private String email;
    private String address;
    private Long phone;

    @OneToMany(mappedBy = "reader")
    private List<Issuance> issuances;
}
