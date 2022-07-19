package com.zanatta.bookservice.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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
    @Retry(name = "fooBar", fallbackMethod = "retornoFallback")
    public String fooBar() {
        logger.info("request foo-bar is received!!!");
        var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        return response.getBody();
    }

    @GetMapping("/foo-bar-cb")
    @CircuitBreaker(name = "fooBarCb", fallbackMethod = "retornoFallback")
    public String fooBarCb() {
        logger.info("request foo-bar-cb is received!!!");
        var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        return response.getBody();
    }
    @GetMapping("/foo-bar-rt")
    @RateLimiter(name = "fooBarRt", fallbackMethod = "retornoFallback")
    public String fooBarRt() {
        logger.info("request foo-bar-cb is received!!!");
        var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        return response.getBody();
    }


    public String retornoFallback(Exception ex) {
        return "fallbackMethod foo-bar: " + ex.getMessage();
    }
}
