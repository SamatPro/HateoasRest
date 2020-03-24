package ru.itis.hateoas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.hateoas.models.Book;
import ru.itis.hateoas.repositories.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService{

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public Book hide(Long bookId) {
        Book book = booksRepository.findById(bookId).orElseThrow(IllegalArgumentException::new);
        book.hide();
        booksRepository.save(book);
        return book;
    }

    @Override
    public Book open(Long bookId) {
        Book book = booksRepository.findById(bookId).orElseThrow(IllegalArgumentException::new);
        book.open();
        booksRepository.save(book);
        return book;
    }
}