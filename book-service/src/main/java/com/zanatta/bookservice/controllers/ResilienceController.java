package com.zanatta.bookservice.controllers;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("resilience-service")
public class ResilienceController {

    private Logger logger = LoggerFactory.getLogger(ResilienceController.class);

    @GetMapping("/foo-bar")
    @Retry(name = "foo-bar", fallbackMethod = "retornoFallback")
    public String fooBar() {
        logger.info("request foo-bar is received!!!");
        var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        return response.getBody();
    }

    public String retornoFallback(Exception ex) {
        return "fallbackMethod foo-bar: " + ex.getMessage();
    }
}
