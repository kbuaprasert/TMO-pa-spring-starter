package com.galvanize.tmo.paspringstarter.repository;

import com.galvanize.tmo.paspringstarter.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Book, Long> {
}