package com.example.Bookify.components;

import com.example.Bookify.models.*;
import com.example.Bookify.repositories.BookRepository;
import com.example.Bookify.repositories.UserRepository;
import com.example.Bookify.repositories.UsersBooksRepository;
import com.example.Bookify.services.BookService;
import com.example.Bookify.services.BookshelfService;
import com.example.Bookify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    BookshelfService bookshelfService;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UsersBooksRepository usersBooksRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Create users and add them to the database through service method createUser
        User robbie = new User("Zinizanzo");
        userService.createUser(robbie);
        User charisma = new User("CHRIMPY");
        userService.createUser(charisma);
        User sabah = new User("Flakeymeerkat");
        userService.createUser(sabah);

//        Create new bookshelf for first two users, .... saving them to the database through service method createBookshelf
        Bookshelf robbiesBookshelf = new Bookshelf(robbie,"Robbie's Bookshelf");
        bookshelfService.createBookshelf(robbiesBookshelf);
        Bookshelf charismasBookshelf = new Bookshelf(charisma, "Charisma's bookshelf");
        bookshelfService.createBookshelf(charismasBookshelf);

//        Create books, save them to the database and add them to bookshelves
//        Robbie's books
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", LocalDate.of(1960, 7, 11), 4.28, Genre.FICTION);
        bookRepository.save(book1);
        Book book2 = new Book("1984", "George Orwell", "978-0-452-28423-4", LocalDate.of(1949, 6, 8), 4.17, Genre.SCIENCE_FICTION);
        bookshelfService.addBookToBookshelf(1,book1);
        bookRepository.save(book2);
        bookshelfService.addBookToBookshelf(1,book2);
        Book book3 = new Book("Moby Dick", "Herman Melville", "978-0-14-243724-7", LocalDate.of(1851, 11, 14), 3.5, Genre.FICTION);
        bookRepository.save(book3);
        bookshelfService.addBookToBookshelf(1,book3);
        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5", LocalDate.of(1925, 4, 10), 3.92, Genre.FICTION);
        bookRepository.save(book4);
        bookshelfService.addBookToBookshelf(1,book4);
        Book book5 = new Book("Pride and Prejudice", "Jane Austen", "978-0-19-280238-5", LocalDate.of(1813, 1, 28), 4.26, Genre.ROMANCE);
        bookRepository.save(book5);
        bookshelfService.addBookToBookshelf(1,book5);

//        Charisma's book
        Book book6 = new Book("A Day of Fallen Night", "Samantha Shannon", "978-1-5266-1981-5", LocalDate.of(2023, 2, 28), 4.4, Genre.FANTASY);
        bookRepository.save(book6);
        bookshelfService.addBookToBookshelf(2, book6);

        Book book7 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0-618-00221-3", LocalDate.of(1937, 9, 21), 4.27, Genre.FANTASY);
        bookRepository.save(book7);

//        Sabah's book
        Book book8 = new Book("Crime and Punishment", "Fyodor Dostoevsky", "978-0-14-305814-4", LocalDate.of(1866, 1, 1), 4.21, Genre.FICTION);
        bookRepository.save(book8);

//        Create UserBooks objects and assign them a User and a Book
//        Robbie's UserBooks
        UsersBooks newUsersBook1 = new UsersBooks(robbie, book1);
        usersBooksRepository.save(newUsersBook1);
        UsersBooks newUsersBook2 = new UsersBooks(robbie, book2);
        usersBooksRepository.save(newUsersBook2);
        UsersBooks newUsersBook3 = new UsersBooks(robbie, book3);
        usersBooksRepository.save(newUsersBook3);

//        Charisma's UserBooks
        UsersBooks newUsersBook4 = new UsersBooks(charisma, book6);
        usersBooksRepository.save(newUsersBook4);

//        Sabah's UsersBooks
        UsersBooks newUsersBook = new UsersBooks(sabah, book8);
        usersBooksRepository.save(newUsersBook);

    }

}
