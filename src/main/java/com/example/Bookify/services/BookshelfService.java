package com.example.Bookify.services;

import com.example.Bookify.models.Book;
import com.example.Bookify.models.Bookshelf;
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
    public Optional<Bookshelf> updateBookshelf(long id, Bookshelf updatedBookshelf, Book bookToAdd) {
    // find the bookshelf by its ID
        Optional<Bookshelf> optionalBookshelf = bookshelfRepository.findById(id);

    // check if the bookshelf exists
        if (optionalBookshelf.isPresent()) {
            // get the bookshelf object from the optional
            Bookshelf bookshelf = optionalBookshelf.get();

            // update the bookshelf name
            bookshelf.setName(updatedBookshelf.getName());

            // get the current list of books associated with that bookshelf
            List<Book> books = bookshelf.getBooks();
            if (books == null) {
                books = new ArrayList<>();
            }


                // add a book to that bookshelf
                books.add(bookToAdd);

                // set the updated list of books back to the bookshelf
                bookshelf.setBooks((books));

                // save the updated bookshelf using the BookshelfRepository
                Bookshelf updatedbookshelf = bookshelfRepository.save(bookshelf);

                // return an Optional containing the updated bookshelf
                return Optional.of(updatedBookshelf);

            }

            // if the bookshelf isn't found, return an empty Optional
             return Optional.empty();

        }
    }

    public void deleteBookshelf(Long id) {
        bookshelfRepository.deleteById(id);
    }












}
