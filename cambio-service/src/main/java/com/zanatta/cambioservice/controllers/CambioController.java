package com.zanatta.cambioservice.controllers;

import java.math.BigDecimal;

import com.zanatta.cambioservice.models.Cambio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private Environment env;
    
    @GetMapping(value = "/{amount}/{from}/{to}")
    @ResponseStatus(value = HttpStatus.OK)
    public Cambio getCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to) {

        return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, env.getProperty("local.server.port"));
    }
}
