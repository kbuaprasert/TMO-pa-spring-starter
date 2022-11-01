package com.galvanize.tmo.paspringstarter.service;

import com.galvanize.tmo.paspringstarter.model.Book;
import com.galvanize.tmo.paspringstarter.repository.LibraryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class LibraryServiceImplTest {

    @Mock
    LibraryRepository libraryRepository;
    @InjectMocks
    private LibraryServiceImpl libraryServiceImpl;


    @Test
    void savedBook() {
        Book book = new Book();
        book.setId(1L);
        book.setAuthor("Douglas Adams");
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setYearPublished(1979);

        Mockito.when(libraryRepository.save(any())).thenReturn(book);

        Book savedBook = libraryServiceImpl.addNewBook(book);
        Assertions.assertThat(savedBook.getId()).isNotNull();
    }

    @Test
    public void fetchBooksList() {
        Book book = new Book();
        book.setId(1L);
        book.setAuthor("Douglas Adams");
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setYearPublished(1979);
        List<Book> reTurnBookList = new ArrayList<>();
        reTurnBookList.add(book);

        book = new Book();
        book.setId(2L);
        book.setAuthor("Philip K. Dick");
        book.setTitle("Do Androids Dream of Electric Sheep?");
        book.setYearPublished(1968);
        reTurnBookList.add(book);

        book = new Book();
        book.setId(3L);
        book.setAuthor("William Gibson");
        book.setTitle("Neuromancer");
        book.setYearPublished(1984);
        reTurnBookList.add(book);

        List<Book> bookList = libraryServiceImpl.fetchBookList();
        Assertions.assertThat(libraryRepository.findAll()).isNotNull();

    }

    @Test
    public void deleteAllBookTest() {
        libraryServiceImpl.deleteAllBook();
        Assertions.assertThat(libraryRepository.findAll()).isEmpty();
    }
}
