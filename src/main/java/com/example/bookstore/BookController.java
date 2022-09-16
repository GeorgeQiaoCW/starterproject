package com.example.bookstore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookStoreController {

    @GetMapping("/book")
    public Book Book(@RequestParam(value = "name", defaultValue = "World") String name) {

    }
}
