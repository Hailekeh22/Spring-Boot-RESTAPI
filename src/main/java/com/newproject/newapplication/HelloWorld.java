package com.newproject.newapplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloWorld {
    
    @GetMapping("/hello") 
    public String hello() {
        return "Hello World";
    }
}
