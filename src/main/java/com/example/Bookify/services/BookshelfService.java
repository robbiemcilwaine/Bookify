package com.example.Bookify.services;

import com.example.Bookify.models.Book;
import com.example.Bookify.models.Bookshelf;
import com.example.Bookify.repositories.BookRepository;
import com.example.Bookify.repositories.BookshelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookshelfService {

    @Autowired
    BookshelfRepository bookshelfRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

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
    public Optional<Bookshelf> updateBookshelfName(long id, String name) {
        Optional<Bookshelf> optionalBookshelf = bookshelfRepository.findById(id);
        if (optionalBookshelf.isPresent()) {
            Bookshelf bookshelf = optionalBookshelf.get();
            bookshelf.setName(name);
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
            List<Book> books = bookshelf.getBooks();
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                if (book.getId() == bookId) {
                    books.remove(i);
                    break;
                }
            }
            return Optional.of(bookshelfRepository.save(bookshelf));
        }
        return Optional.empty();
    }

// Delete a specific bookshelf and its associated books (due to the many-to-many relationship)
    public void deleteBookshelf(long id) {
        Bookshelf bookshelf = getBookshelfByID(id).get();
        for (Book book : bookshelf.getBooks()) {
            bookService.deleteBook(book.getId());

        }

        bookshelfRepository.deleteById(id);
    }


}










