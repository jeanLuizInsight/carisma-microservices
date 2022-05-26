package com.zanatta.cambioservice.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.zanatta.cambioservice.dtos.CambioDTO;
import com.zanatta.cambioservice.repository.CambioRepository;

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

    @Autowired private Environment env;
    @Autowired private CambioRepository cambioRepository;
    
    @GetMapping(value = "/{amount}/{from}/{to}")
    @ResponseStatus(value = HttpStatus.OK)
    public CambioDTO getCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to) {
        var cambio = this.cambioRepository.findByFromAndTo(from, to);
        if (cambio == null) {
            throw new RuntimeException("Currency Unsuported.");
        }
        cambio.setEnvironment(env.getProperty("local.server.port"));
        cambio.setConvertedValue(cambio.getConversionFactor().multiply(amount).setScale(2, RoundingMode.CEILING));
        return CambioDTO.builder(cambio);
    }
}
