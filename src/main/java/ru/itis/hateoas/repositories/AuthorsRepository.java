package ru.itis.hateoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoas.models.Author;

public interface AuthorsRepository extends JpaRepository<Author, Long> {
}
