package ru.itis.hateoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.itis.hateoas.models.Book;
import ru.itis.hateoas.repositories.BooksRepository;

@RepositoryRestController
public class CustomBooksController {

    @Autowired
    private BooksRepository booksRepository;

    @PutMapping("/books/{book-id}/sell")
    public ResponseEntity<?> sell(@PathVariable("book-id") Long bookId){
        Book book = booksRepository.getOne(bookId);
        book.sell();
        return ResponseEntity.ok().build();
    }
}
