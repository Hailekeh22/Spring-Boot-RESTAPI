package com.newproject.newapplication.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloWorld {
    
    @GetMapping("/hello") 
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/home")
    public String home() {
        return "<h1>Welcome to HOme Section</h1>";
    }
}
