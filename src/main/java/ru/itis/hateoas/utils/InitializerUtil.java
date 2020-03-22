package ru.itis.hateoas.utils;

import org.springframework.context.ApplicationContext;
import ru.itis.hateoas.models.*;
import ru.itis.hateoas.repositories.*;

import java.time.LocalDateTime;
import java.util.HashSet;

import static java.util.Arrays.asList;

public class InitializerUtil {
    public static void init(ApplicationContext context){

        BooksRepository booksRepository = context.getBean(BooksRepository.class);
        AuthorsRepository authorsRepository = context.getBean(AuthorsRepository.class);
        PublishingHousesRepository publishingHousesRepository = context.getBean(PublishingHousesRepository.class);
        IssuancesRepository issuancesRepository = context.getBean(IssuancesRepository.class);
        ReadersRepository readersRepository = context.getBean(ReadersRepository.class);


        Reader ilona = Reader.builder()
                .firstName("Ilona")
                .lastName("Green")
                .address("New Zealand, ostrov Kiwi, Kazansburg, st. Kofeynaya, 32")
                .phone(Long.parseLong("885545665555"))
                .build();

        Reader bob = Reader.builder()
                .firstName("Bob")
                .lastName("White")
                .address("Kyoto, st. Imperatorskaya, 494")
                .phone(Long.parseLong("155445666888"))
                .build();

        readersRepository.saveAll(asList(ilona, bob));

        Book javaForBeginners = Book.builder()
                .title("Java for Beginners")
                .year(Long.parseLong("2015"))
                .description("The book was published to make easy and enjoy learning process")
                .genre(asList(Genre.ROMANCE, Genre.SCIENCE))
                .isHidden(false)
                .build();

        Book pythonForBeginners = Book.builder()
                .title("Python for Beginners")
                .year(Long.parseLong("2018"))
                .description("Learning Python")
                .genre(asList(Genre.ROMANCE, Genre.SCIENCE))
                .isHidden(false)
                .build();

        Book warAndPeace = Book.builder()
                .title("War and Peace")
                .year(Long.parseLong("1826"))
                .description("Voyna i mir")
                .genre(asList(Genre.CYBERPRUNK, Genre.DISTOPIA))
                .isHidden(false)
                .build();

        Book evgeniyOnegin = Book.builder()
                .title("Evgeniy Onegin")
                .year(Long.parseLong("1824"))
                .description("Stikhi about Evgenia Onegina of A.S.Pushkin")
                .isHidden(false)
                .genre(asList(Genre.FANTASY, Genre.CRIME))
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

        Issuance issuance1 = Issuance.builder()
                .book(javaForBeginners)
                .dateOfIssue(LocalDateTime.of(2019, 11, 27, 15, 17, 56))
                .isPassed(false)
                .reader(ilona)
                .build();

        Issuance issuance2 = Issuance.builder()
                .book(pythonForBeginners)
                .dateOfIssue(LocalDateTime.of(2019, 11, 27, 15, 18, 29))
                .returnDate(LocalDateTime.of(2019, 12, 15, 13, 25, 35))
                .isPassed(true)
                .reader(ilona)
                .build();

        Issuance issuance3 = Issuance.builder()
                .book(warAndPeace)
                .dateOfIssue(LocalDateTime.of(2019, 12, 27, 15, 18, 29))
                .returnDate(LocalDateTime.of(2020, 1, 19, 13, 25, 35))
                .isPassed(true)
                .reader(bob)
                .build();

        Issuance issuance4 = Issuance.builder()
                .book(evgeniyOnegin)
                .dateOfIssue(LocalDateTime.of(2019, 12, 27, 15, 18, 55))
                .returnDate(LocalDateTime.of(2020, 1, 19, 13, 25, 49))
                .isPassed(true)
                .reader(bob)
                .build();

        issuancesRepository.saveAll(asList(issuance1, issuance2, issuance3, issuance4));



    }
}
