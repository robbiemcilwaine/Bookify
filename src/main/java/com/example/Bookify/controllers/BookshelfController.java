package com.example.Bookify.controllers;

import com.example.Bookify.models.Book;
import com.example.Bookify.models.Bookshelf;
import com.example.Bookify.services.BookService;
import com.example.Bookify.services.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookshelves")
public class BookshelfController {

    @Autowired
    BookshelfService bookshelfService;

    @Autowired
    BookService bookService;

//    Retrieve all bookshelves for a user

    @GetMapping(value = ("/user/{id}"))
    public ResponseEntity<List<Bookshelf>> getBookshelvesByUserId(@PathVariable long id){
    List<Bookshelf> bookshelves = bookshelfService.getBookshelvesByUserId(id);
    return new ResponseEntity<>(bookshelves, HttpStatus.OK);
    }


//    Retrieve a specific bookshelf
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Bookshelf>> getBookShelfById(@PathVariable long id){
        Optional<Bookshelf> bookshelf = bookshelfService.getBookshelfByID(id);
        if (bookshelf.isPresent()){
            return new ResponseEntity<>(bookshelf, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Create a new bookshelf
    @PostMapping
    public ResponseEntity<Bookshelf> createBookshelf(@RequestBody Bookshelf bookshelf){
        Bookshelf savedBookshelf = bookshelfService.createBookshelf(bookshelf);
        return new ResponseEntity<>(savedBookshelf, HttpStatus.CREATED);
    }

//   Add book to existing bookshelf
    @PostMapping(value = "/{id}")
    public ResponseEntity<Optional<Bookshelf>> addBookToBookshelf(@PathVariable long id, @RequestBody Book book){
        Optional<Bookshelf> updatedBookshelf = bookshelfService.addBookToBookshelf(id, book);
        if (updatedBookshelf.isPresent()){
            return new ResponseEntity<>(updatedBookshelf, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Update the name of a specific bookshelf
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Optional<Bookshelf>> updateBookshelfName(@PathVariable long id, @RequestParam String name){
        Optional<Bookshelf> updatedBookshelfName = bookshelfService.updateBookshelfName(id, name);
        if(updatedBookshelfName.isPresent()){
            return new ResponseEntity<>(updatedBookshelfName, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Delete bookshelf by bookshelf_id (this will be mapped by the value = “bookshelves_id”)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Optional<Void>> deleteBookshelfById(@PathVariable long id){
        Optional<Bookshelf> deletedBookshelf = bookshelfService.getBookshelfByID(id);
        if(deletedBookshelf.isPresent()){
            bookshelfService.deleteBookshelf(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

//    Delete specific book by id from bookshelf
    @PatchMapping(value = "/{id}/books/{id}")
    public ResponseEntity<Optional<Bookshelf>> removeBookFromBookshelf(@PathVariable long bookshelfId, @PathVariable long bookId){
        Optional<Bookshelf> updatedBookshelf = bookshelfService.getBookshelfByID(bookshelfId);
        Optional<Book> removedBook = bookService.getBookById(bookId);
        if(updatedBookshelf.isPresent() && removedBook.isPresent()){
            Optional<Bookshelf> bookshelf = bookshelfService.removeBookFromBookshelf(bookshelfId, bookId);
        }
    }



}
