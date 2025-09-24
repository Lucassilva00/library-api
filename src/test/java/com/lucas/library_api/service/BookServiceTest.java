package com.lucas.library_api.service;

import com.lucas.library_api.model.entity.Book;
import com.lucas.library_api.model.repository.BookRepository;
import com.lucas.library_api.service.impl.BookServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class BookServiceTest {

    BookService service;

    @MockitoBean
    BookRepository repository;

    @BeforeEach
    public void setUp(){
        this.service = new BookServiceImp(repository);
    }

    @Test
    @DisplayName("Deve salvar um livro")
    public void saveBookTest(){
        //cenario
        Book book = Book.builder().isbn("123").title("As aventuras").author("Fulano").build();
        Mockito.when(repository.save(book))
                .thenReturn(Book.builder()
                        .id(1l).isbn("123")
                        .title("As aventuras")
                        .author("Fulano")
                        .build());

        //execucao
        Book savedBook = service.save(book);

        //verificacao
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("As aventuras");
        assertThat(savedBook.getIsbn()).isEqualTo("123");
        assertThat(savedBook.getAuthor()).isEqualTo("Fulano");

    }
}
