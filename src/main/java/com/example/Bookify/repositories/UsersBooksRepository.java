package com.example.Bookify.repositories;

import com.example.Bookify.models.ReadingStatus;
import com.example.Bookify.models.UsersBooks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersBooksRepository extends JpaRepository <UsersBooks, Long> {
    List<UsersBooks> findByReadingStatus(ReadingStatus readingStatus);

    Optional<UsersBooks> findByUserIdAndBookId(Long userId, Long bookId);

}
