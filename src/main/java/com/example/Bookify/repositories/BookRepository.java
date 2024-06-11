package com.example.Bookify.repositories;

import com.example.Bookify.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
