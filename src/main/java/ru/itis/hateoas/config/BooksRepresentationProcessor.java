package ru.itis.hateoas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.hateoas.controllers.BooksController;
import ru.itis.hateoas.models.Book;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BooksRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Book>> {

    @Autowired
    private RepositoryEntityLinks links;

    @Override
    public EntityModel<Book> process(EntityModel<Book> model) {
        Book book = model.getContent();
        if (book != null && !book.getIsHidden()){
            model.add(linkTo(methodOn(BooksController.class).hide(book.getId())).withRel("hide"));
        }
        return model;
    }
}
