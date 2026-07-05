package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @GetMapping("/")
    public String index() {
        return "Welcome to Spring Boot";
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi!";
    }
}
