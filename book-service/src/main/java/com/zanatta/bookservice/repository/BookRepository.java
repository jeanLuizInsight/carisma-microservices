package com.zanatta.bookservice.repository;

import com.zanatta.bookservice.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
