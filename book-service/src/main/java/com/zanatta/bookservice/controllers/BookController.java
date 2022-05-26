package com.zanatta.bookservice.controllers;

import java.util.Optional;

import com.zanatta.bookservice.io.rest.CambioRest;
import com.zanatta.bookservice.models.Book;
import com.zanatta.bookservice.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired private Environment env;
    @Autowired private BookRepository bookRepository;
    @Autowired private CambioRest cambioRest;

    @GetMapping(value = "/{id}/{currency}")
    public Book getBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
        Optional<Book> opt = this.bookRepository.findById(id);
        if (opt.isEmpty()) {
            throw new RuntimeException("Book not found.");
        }
        Book book = opt.get();
        book.setEnvironment(env.getProperty("local.server.port"));

        var cambioDto = this.cambioRest.getCambio(book, currency);
        book.setPrice(cambioDto.getConvertedValue());
        return book;
    }
    
}
