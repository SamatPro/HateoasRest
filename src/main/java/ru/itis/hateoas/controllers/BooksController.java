package ru.itis.hateoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.hateoas.models.Book;
import ru.itis.hateoas.services.BooksService;

@RepositoryRestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @RequestMapping(value = "/books/{book-id}/hide", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> hide(@PathVariable("book-id") Long bookId){
        return ResponseEntity.ok(
                new EntityModel<>(
                        booksService.hide(bookId)));
    }
}
