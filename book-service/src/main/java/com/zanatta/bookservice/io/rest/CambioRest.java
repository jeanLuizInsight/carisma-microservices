package com.zanatta.bookservice.io.rest;

import java.util.HashMap;

import com.zanatta.bookservice.dtos.CambioDTO;
import com.zanatta.bookservice.models.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CambioRest {
    
    @Autowired private RestTemplate restTemplate;

    public CambioDTO getCambio(Book book, String currency) {
        HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);
        var response = restTemplate.getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}", CambioDTO.class, params);
        return response.getBody();
    }
}
