package com.zanatta.greetingservice.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.zanatta.greetingservice.configuration.GreetingConfiguration;
import com.zanatta.greetingservice.models.Greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    
    private static final String TEMPLATE = "%s, s%";
    private final AtomicLong counter = new AtomicLong();

    @Autowired GreetingConfiguration greetingConfiguraration;

    @GetMapping(value = "/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        if (name.isEmpty()) {
            name = greetingConfiguraration.getDefaultValue();
        }
        return new Greeting(counter.getAndIncrement(), String.format(GreetingController.TEMPLATE, greetingConfiguraration.getGreeting(), name));
    }
}
