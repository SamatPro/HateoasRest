package ru.itis.hateoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoas.models.Reader;

public interface ReadersRepository extends JpaRepository<Reader, Long> {
}
