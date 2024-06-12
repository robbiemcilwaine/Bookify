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
    @PatchMapping(value = "/{id}/books/{bookId}")
    public ResponseEntity<Bookshelf> removeBookFromBookshelf(@PathVariable long id, @PathVariable long bookId) { // id of bookshelf and id of book to remove
        // call the bookshelfService to remove the book from the bookshelf
        // the service method returns an Optional<Bookshelf> representing the updated bookshelf
        Optional<Bookshelf> optionalUpdatedBookshelf = bookshelfService.removeBookFromBookshelf(id, bookId);
        if (optionalUpdatedBookshelf.isPresent()) {
            // if the Optional contains a value e.g. the book was successfully removed
            // return a ResponseEntity with the updated bookshelf and a HTTPStatus code of OK (200)
            return new ResponseEntity<>(optionalUpdatedBookshelf.get(), HttpStatus.OK);
        } else {
            // if the Optional is empty e.g. the bookshelf or the book was not found
            // return a ResponseEntity with an HTTP status of NOT_FOUND (404)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

