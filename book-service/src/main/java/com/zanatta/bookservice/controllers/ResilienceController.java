package com.zanatta.bookservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resilience-service")
public class ResilienceController {

    @GetMapping("/foo-bar")
    public String fooBar() {
        return "Foo-Bar!!";
    }
}
