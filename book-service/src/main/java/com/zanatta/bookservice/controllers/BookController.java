package com.zanatta.bookservice.controllers;

import java.util.Optional;

import com.zanatta.bookservice.models.Book;
import com.zanatta.bookservice.proxy.CambioProxy;
import com.zanatta.bookservice.repository.BookRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired private Environment env;
    @Autowired private BookRepository bookRepository;
    @Autowired private CambioProxy cambioProxy;

    @Operation(summary = "Busca uma especificação de book pelo ID.")
    @GetMapping(value = "/{id}/{currency}")
    public Book getBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
        Optional<Book> opt = this.bookRepository.findById(id);
        if (opt.isEmpty()) {
            throw new RuntimeException("Book not found.");
        }
        Book book = opt.get();
        var cambioDto = this.cambioProxy.getCambio(book.getPrice(), "USD", currency);
        book.setPrice(cambioDto.getConvertedValue());
        book.setEnvironment("Book port: " + env.getProperty("local.server.port") + ", Cambio port: " + cambioDto.getEnvironment());
        return book;
    }
    
}
