package com.galvanize.tmo.paspringstarter.service;

import com.galvanize.tmo.paspringstarter.model.Book;

import java.util.List;

public interface LibraryService {

    public Book addNewBook(Book book);

    public List<Book> fetchBookList();

    public void deleteAllBook();
}
