package com.example.Bookify.repositories;

import com.example.Bookify.models.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {

    List<Bookshelf> findByUserId(long userId);
}

