package com.example.Bookify.repositories;

import com.example.Bookify.models.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {
}

