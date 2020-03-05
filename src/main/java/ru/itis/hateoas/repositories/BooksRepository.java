package ru.itis.hateoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoas.models.Book;

public interface BooksRepository extends JpaRepository<Book, Long> {
}
