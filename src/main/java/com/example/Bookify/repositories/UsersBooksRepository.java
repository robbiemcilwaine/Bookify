package com.example.Bookify.repositories;

import com.example.Bookify.models.UsersBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersBooksRepository extends JpaRepository <UsersBooks, Long> {
}
