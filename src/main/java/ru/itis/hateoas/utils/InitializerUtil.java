package ru.itis.hateoas.utils;

import org.springframework.context.ApplicationContext;
import ru.itis.hateoas.models.Author;
import ru.itis.hateoas.models.Book;
import ru.itis.hateoas.models.Genre;
import ru.itis.hateoas.models.PublishingHouse;
import ru.itis.hateoas.repositories.AuthorsRepository;
import ru.itis.hateoas.repositories.BooksRepository;
import ru.itis.hateoas.repositories.PublishingHousesRepository;

import java.util.HashSet;

import static java.util.Arrays.asList;

public class InitializerUtil {
    public static void init(ApplicationContext context){

        BooksRepository booksRepository = context.getBean(BooksRepository.class);
        AuthorsRepository authorsRepository = context.getBean(AuthorsRepository.class);
        PublishingHousesRepository publishingHousesRepository = context.getBean(PublishingHousesRepository.class);

        Book javaForBeginners = Book.builder()
                .title("Java for Beginners")
                .year(Long.parseLong("2015"))
                .description("The book was published to make easy and enjoy learning process")
                .genre(new HashSet<>(asList(Genre.ROMANCE, Genre.SCIENCE)))
                .isForSale(true)
                .build();

        Book pythonForBeginners = Book.builder()
                .title("Python for Beginners")
                .year(Long.parseLong("2018"))
                .description("Learning Python")
                .genre(new HashSet<>(asList(Genre.ROMANCE, Genre.SCIENCE)))
                .isForSale(false)
                .build();

        Book warAndPeace = Book.builder()
                .title("War and Peace")
                .year(Long.parseLong("1826"))
                .description("Voyna i mir")
                .genre(new HashSet<>(asList(Genre.CYBERPRUNK, Genre.DISTOPIA)))
                .isForSale(true)
                .build();

        Book evgeniyOnegin = Book.builder()
                .title("Evgeniy Onegin")
                .year(Long.parseLong("1824"))
                .description("Stikhi about Evgenia Onegina of A.S.Pushkin")
                .isForSale(false)
                .genre(new HashSet<>(asList(Genre.FANTASY, Genre.CRIME)))
                .build();


        booksRepository.saveAll(asList(
                javaForBeginners,
                pythonForBeginners,
                warAndPeace,
                evgeniyOnegin
        ));

        Author gshildt = Author.builder()
                .firstName("Gilbert")
                .lastName("Shildt")
                .email("gshildt@gmail.com")
                .books(asList(javaForBeginners, pythonForBeginners))
                .build();

        Author luchano = Author.builder()
                .firstName("Ramalio")
                .lastName("Luchano")
                .email("luchano@outlook.com")
                .books(asList(pythonForBeginners))
                .build();

        Author ltolstoy = Author.builder()
                .email("tolstoy@mail.ru")
                .firstName("Lev")
                .lastName("Tolstoy")
                .books(asList(warAndPeace))
                .build();

        Author pushkin = Author.builder()
                .firstName("ALexander")
                .lastName("Pushkin")
                .middleName("Sergeevish")
                .email("pushkin@mail.ru")
                .books(asList(evgeniyOnegin, warAndPeace))
                .build();

        authorsRepository.saveAll(asList(gshildt, luchano, ltolstoy, pushkin));

        PublishingHouse prosvechenie = PublishingHouse.builder()
                .address("Москва")
                .title("Просвещение")
                .books(asList(warAndPeace, evgeniyOnegin))
                .build();
        PublishingHouse orelly = PublishingHouse.builder()
                .address("Cambridge")
                .email("kambridge@gmail.com")
                .title("O'relly")
                .books(asList(pythonForBeginners, javaForBeginners))
                .build();

        publishingHousesRepository.saveAll(asList(prosvechenie, orelly));


    }
}
