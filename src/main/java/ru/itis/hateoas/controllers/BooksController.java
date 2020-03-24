package ru.itis.hateoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/books/{book-id}/open", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> open(@PathVariable("book-id") Long bookId){
        return ResponseEntity.ok(
                new EntityModel<>(
                        booksService.open(bookId)));
    }



}
