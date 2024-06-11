package com.example.Bookify.repositories;

import com.example.Bookify.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
