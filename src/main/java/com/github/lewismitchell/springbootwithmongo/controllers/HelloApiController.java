package com.github.lewismitchell.springbootwithmongo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController {

    @GetMapping("/api")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}