package com.galvanize.tmo.paspringstarter.service;

import com.galvanize.tmo.paspringstarter.repository.LibraryRepository;
import com.galvanize.tmo.paspringstarter.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    @Transactional
    public Book addNewBook(Book book) {
        return libraryRepository.save(book);
    }

    @Override
    public List<Book> fetchBookList() {
        return (List<Book>) libraryRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }

    // delete operation
    @Override
    public void deleteAllBook() {
        libraryRepository.deleteAll();
    }
}
