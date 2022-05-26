package com.zanatta.bookservice.proxy;

import java.math.BigDecimal;

import com.zanatta.bookservice.dtos.CambioDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Proxy realizando chamada RESt com Feign (substituindo RestTemplate)
 */
@FeignClient(name = "cambio-service", url = "localhost:8000")
public interface CambioProxy {
    
    @GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
    public CambioDTO getCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to);
}
