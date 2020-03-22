package ru.itis.hateoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoas.models.Issuance;

public interface IssuancesRepository extends JpaRepository<Issuance, Long> {
}
