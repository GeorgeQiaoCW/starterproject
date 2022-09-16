package com.example.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStore extends JpaRepository<Book, Long> {
    Book findBookById(int id);
}
