# To Do List (Bookshelf) - Backend Project

## Summary
The to-do list will have three models, User, Book and Bookshelf. A user can create personalised bookshelves (lists) tailored to a specific theme. For example,  “Holiday Reads”, “Textbook’s for next year”, “Sorting my life together” which could be a collection of self-help books. Within these bookshelves are book objects (to-do) that the user can add, update, remove and provide details. Such as title, author, genre…

This system allows the user access to their bookshelves and associated books. It would include fields or attributes to indicate the status of each book (e.g., whether it's been read, is currently being read, or is intended for future reading) and potentially a priority level. Users could then categorise their books accordingly, helping them track their reading progress and prioritise their reading list effectively.

## Tech Stack

- **Java**
- **Spring Boot**
- **PostgreSQL**

### How to run this API locally

1. **Install PostgreSQL**
   - Via Homebrew:
     ```sh
     brew install postgresql
     ```
   - Or via [Postgres.app](https://postgresapp.com)
  
2. **Create a database**
   ```sh
   createdb bookify_db

3. **Fork repository**
   To your computer and run main() in BookifyApplication

4. **Postico**
   You may wish to visualise the database in Postico once the database is created.

5. **Postman**
   Create models/ services / repositories.
   You may wish to visualise the endpoints in Postman using the JSON segments.


## API Designs

## ERDs
![image](https://github.com/ornerykiwi/Bookify/assets/111086837/f6afba0d-52b6-4d69-a14d-8fa227ff3706)



## UML
![image](https://github.com/ornerykiwi/Bookify/assets/111086837/cd0486f8-c0fb-4c59-8efc-7a3b82102477)

  
## MVP Key Functionality

### Models:
- Book: Represents a book with properties such as title, author, ISBN, publication year, genre, and rating.
- Bookshelf: Represents a user's bookshelf, which contains a list of books.
- User: Represents a user who owns the bookshelf and can add many books to their bookshelf, as a list. Users can have multiple bookshelves.
- UsersBooks: Represents the relationship between users and books, allowing for additional information such as reading status to be stored.

### UsersBooks Class Explanation

The `UsersBooks` class serves several important purposes in our application:

1. Many-to-Many Relationship: It represents the relationship between users and books. This is a many-to-many relationship, as one user can have many books and one book can belong to many users.

2. Additional Information: It allows us to store additional information about the relationship between a user and a book, such as the reading status.

3. Reading Status: The class includes an `Enumerated` field `readingStatus`, which allows us to track the reading status of each book for each user (e.g., UNASSIGNED, TO_READ, CURRENTLY_READING, READ).

4. Flexibility: By using this intermediate class, we can easily add more attributes to the relationship in the future without modifying the User or Book classes.

5. Querying: It allows for more efficient querying of user-book relationships. For example, we can easily find all books with a certain status for a specific user.

6. Separation of Concerns: It keeps the User and Book entities clean by moving the relationship-specific data to a separate entity.




### Bookshelf

| Endpoints        | URLs           | Description  |
| :-------------: |:-------------:| :-----:|
| GET      | localhost:8080/users/{id}| Retrieve all of a user’s associated bookshelves |
| SHOW   | localhost:8080/bookshelves/{id} |  Retrieve a specific bookshelf |
| CREATE/POST | localhost:8080/bookshelves| Create a new bookshelf |
|PATCH | localhost:8080/bookshelves/{id} | Add a book to an existing bookshelf|
| UPDATE/PATCH | localhost:8080/bookshelves/{id} | Update the name of a specific bookshelf |
|DELETE |localhost:8080/bookshelves/{id}|Delete a specific bookshelf|
|DELETE |localhost:8080/bookshelves/{id}/books/{id}|Delete a specific book from a bookshelf|


#### Clarification for "Add book to bookshelf" method

The PATCH endpoint `localhost:8080/bookshelves/{id}` for adding a book to an existing bookshelf has the following characteristics:

* This method allows you to add a book's name, genre, and reading status to a bookshelf.
* The book details are handled in the request body (in POSTMAN).
* You are essentially "creating" a book by adding its details manually in the request body in POSTMAN.
* If the book doesn't exist in the database, it will be created and then added to the bookshelf.
* If the book already exists, it will be added to the bookshelf without creating a duplicate.





### Book

| Endpoints        | URLs           | Description  |
| :-------------: |:-------------:| :-----:|
| SHOW | localhost:8080/books/{id} | Retrieve a specific book by its ID |
| INDEX | localhost:8080/books | Retrieve all books |
| ~~UPDATE/PUT~~ | ~~localhost:8080/books/{id}~~ | ~~Update the details of a specific book~~ |
|DELETE|localhost:8080/books/{id}| Delete a specific book |


### User

| Endpoints        | URLs           | Description  |
| :-------------: |:-------------:| :-----:|
| GET | localhost:8080/users | Retrieve all users|
| GET| localhost:8080/users/{id}| Get a specific user |
|PUT | localhost:8080/users/{id} | Update the details of a specific user|
|POST|localhost:8080/users | Create a new user |
|DELETE|localhost:8080/users/{id}| Delete a specific user |

### UsersBooks
| Endpoints        | URLs           | Description  |
| :-------------: |:-------------:| :-----:|
| GET | localhost:8080/users-books | Retrieve all usersbooks|
| GET| localhost:8080/users-books/{id}| Get a specific usersbooks |
| GET| localhost:8080/users-books/{id}| Get a specific users usersbooks |
| UPDATE/PATCH | localhost:8080/books/{id} | Update reading status |
