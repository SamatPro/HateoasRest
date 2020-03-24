package ru.itis.hateoas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.itis.hateoas.models.Book;
import ru.itis.hateoas.models.Genre;
import ru.itis.hateoas.services.BooksService;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class BooksTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BooksService booksService;

    @BeforeEach
    public void setUp() {
        when(booksService.hide(4L)).thenReturn(hiddenBook());
    }

    @Test
    public void bookHideTest() throws Exception {
        mockMvc.perform(put("/books/4/hide")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(hiddenBook().getTitle()))
                .andExpect(jsonPath("$.year").value(hiddenBook().getYear()))
                .andExpect(jsonPath("$.description").value(hiddenBook().getDescription()))
                .andExpect(jsonPath("$.genre", hiddenBook().getGenre()).exists())
                .andExpect(jsonPath("$.isHidden").value(hiddenBook().getIsHidden()))
                .andDo(document("hide_book", responseFields(
                        fieldWithPath("title").description("Название книги"),
                        fieldWithPath("year").description("Год выпуска"),
                        fieldWithPath("description").description("Описание книги"),
                        fieldWithPath("genre").description("Жанр книги"),
                        fieldWithPath("isHidden").description("Разрешение на выдачу"),
                        subsectionWithPath("_links").ignored()
                )));
    }

    private Book hiddenBook(){
        return Book.builder()
                .id(4L)
                .title("Python for Beginners")
                .year(Long.parseLong("2018"))
                .description("Learning Python")
                .genre(asList(Genre.ROMANCE, Genre.SCIENCE))
                .isHidden(true)
                .build();
    }

}
