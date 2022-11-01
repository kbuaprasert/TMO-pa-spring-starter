package com.galvanize.tmo.paspringstarter;

import com.galvanize.tmo.paspringstarter.model.Book;
import com.galvanize.tmo.paspringstarter.model.Library;
import com.galvanize.tmo.paspringstarter.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/health")
    public void health() {
    }

    // Save operation
    @PostMapping("/api/books")
    public ResponseEntity<Book> addNewBook(
            @Validated
            @RequestBody
            Book book
    ) {
        return new ResponseEntity<Book>(libraryService.addNewBook(book), HttpStatus.CREATED);
    }

    // Read operation
    @GetMapping("/api/books")
    public ResponseEntity fetchBookList() {
        Library library = new Library();
        library.setBooks(libraryService.fetchBookList());
        return new ResponseEntity<>(library, HttpStatus.OK);
    }

    // Delete operation
    @DeleteMapping("/api/books")
    public ResponseEntity deleteAllBook() {
        libraryService.deleteAllBook();
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
