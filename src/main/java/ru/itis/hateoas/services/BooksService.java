package ru.itis.hateoas.services;

import ru.itis.hateoas.models.Book;

public interface BooksService {
    Book hide(Long bookId);
}
