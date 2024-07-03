package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {
    @RequestMapping("/world")
    public String helloWorld() {
        System.out.println("fffff6666");
        return "Hello World!9999";
    }

    @RequestMapping("/world3")
    public String helloWorld3() {
        System.out.println("fffff6666");
        return "Hello World!9999";
    }

    @RequestMapping("/world4")
    public String helloWorld4() {
        System.out.println("fffff");
        return "Hello World!9999";
    }
}
