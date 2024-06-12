package com.example.Bookify.services;

import com.example.Bookify.models.Book;
import com.example.Bookify.models.Bookshelf;
import com.example.Bookify.repositories.BookRepository;
import com.example.Bookify.repositories.BookshelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookshelfService {

    @Autowired
    BookshelfRepository bookshelfRepository;

    @Autowired
    BookRepository bookRepository;

    //    Retrieve all bookshelves for a given user ID
    public List<Bookshelf> getBookshelvesByUserId(long userId) {
        return bookshelfRepository.findByUserId(userId);
    }

    //        Get a specific bookshelf by its ID
    public Optional<Bookshelf> getBookshelfByID(long id) {
        return bookshelfRepository.findById(id);
    }

    //    Create a new bookshelf
    public Bookshelf createBookshelf(Bookshelf bookshelf) {
        return bookshelfRepository.save(bookshelf);
    }

    //    Update an existing bookshelf
    public Optional<Bookshelf> updateBookshelf(long id, Bookshelf updatedBookshelf) {
        Optional<Bookshelf> optionalBookshelf = bookshelfRepository.findById(id);
        if (optionalBookshelf.isPresent()) {
            Bookshelf bookshelf = optionalBookshelf.get();
            bookshelf.setName(updatedBookshelf.getName());
            return Optional.of(bookshelfRepository.save(bookshelf));
        }
        return Optional.empty();
    }

    // Add a book to a bookshelf
    public Optional<Bookshelf> addBookToBookshelf(long bookshelfId, Book book) {
        Optional<Bookshelf> optionalBookshelf = bookshelfRepository.findById(bookshelfId);
        if (optionalBookshelf.isPresent()) {
            Bookshelf bookshelf = optionalBookshelf.get();
            bookshelf.getBooks().add(book);
            bookRepository.save(book);
            return Optional.of(bookshelfRepository.save(bookshelf));
        }
        return Optional.empty();
    }

    // Remove a book from a bookshelf
    public Optional<Bookshelf> removeBookFromBookshelf(long bookshelfId, long bookId) {
        Optional<Bookshelf> optionalBookshelf = bookshelfRepository.findById(bookshelfId);
        if (optionalBookshelf.isPresent()) {
            Bookshelf bookshelf = optionalBookshelf.get();
            bookshelf.getBooks().removeIf(book -> book.getId() == bookId);
            return Optional.of(bookshelfRepository.save(bookshelf));
        }
        return Optional.empty();
    }

    // explain the arrow (KhanZu) in this method

    public void deleteBookshelf(long id) {
        bookshelfRepository.deleteById(id);
    }


}










